package za.co.mmagon.jwebswing.plugins.angularfileupload.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Singleton;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.tika.Tika;
import za.co.mmagon.SessionHelper;
import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.guiceinjection.Pair;
import za.co.mmagon.jwebswing.annotations.DataCallInterception;
import za.co.mmagon.jwebswing.annotations.SiteInterception;
import za.co.mmagon.jwebswing.base.servlets.JWDefaultServlet;
import za.co.mmagon.jwebswing.exceptions.InvalidRequestException;
import za.co.mmagon.jwebswing.plugins.angularfileupload.AngularFileUploadBinder;
import za.co.mmagon.jwebswing.plugins.angularfileupload.intercepters.OnDeleteFileInterceptor;
import za.co.mmagon.jwebswing.plugins.angularfileupload.intercepters.OnFileUploadInterceptor;
import za.co.mmagon.jwebswing.plugins.angularfileupload.intercepters.OnGetFileInterceptor;
import za.co.mmagon.jwebswing.plugins.angularfileupload.intercepters.OnThumbnailFileInterceptor;
import za.co.mmagon.jwebswing.plugins.angularfileupload.parts.json.JsonFile;
import za.co.mmagon.jwebswing.plugins.angularfileupload.parts.json.JsonFilesArray;
import za.co.mmagon.logger.LogFactory;

/**
 * The default file receiving servlet
 */
@Singleton
@MultipartConfig
public class AngularFileServlet extends JWDefaultServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LogFactory.getInstance().getLogger("BlueImpAngularFileServlet");

	private static Map<String, File> stringFileMap = new HashMap<>();

	/**
	 * Constructs a new File Servlet
	 */
	public AngularFileServlet() {
		//Nothing Needed
	}

	/**
	 * Validates and sends the post
	 *
	 * @param request
	 * @param response
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			processRequest(request, response);
		}
		catch (IOException | InvalidRequestException | ServletException e) {
			log.log(Level.SEVERE, "Angular File Servlet Do Post", e);
		}
	}

	@SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws IOException, InvalidRequestException, ServletException {
		log.log(Level.INFO, "[SessionID]-[{0}];[Connection]-[Data Call Connection Established]", request.getSession().getId());

		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new ServletException("File Uploaded is not a multipart request");
		}

		intercept();

		String rangeString = request.getHeader("Content-Range");
		String rangeUpTo = rangeString.substring(rangeString.indexOf('-') + 1, rangeString.indexOf('/'));
		String totalSize = rangeString.substring(rangeString.indexOf('/') + 1);
		Long totalS = Long.parseLong(totalSize);
		Long rangeTotal = Long.parseLong(rangeUpTo);
		Long remaining = (totalS - 1) - rangeTotal;

		boolean completed = false;
		if (remaining == 0) {
			completed = true;
		}

		ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
		JsonFilesArray filesArray = new JsonFilesArray();
		try {
			List<FileItem> items = uploadHandler.parseRequest(request);
			for (FileItem item : items) {
				if (!item.isFormField()) {
					String fileUploadIdentifier = item.getName() + "|" + totalS + "|" + item.getFieldName();

					if (!stringFileMap.containsKey(fileUploadIdentifier)) {
						File tempFile = File.createTempFile("jwebswing_fileUpload_", "-ul");
						stringFileMap.put(fileUploadIdentifier, tempFile);
					}

					File tempFile = stringFileMap.get(fileUploadIdentifier);

					if (!completed) {
						FileUtils.writeByteArrayToFile(tempFile, item.get(), true);
					}
					else {
						JsonFile file = new JsonFile();
						file.setName(item.getName());
						file.setSize(tempFile.length());

						try (FileInputStream fis = new FileInputStream(tempFile)) {
							file.setContent(fis);
							file.setType(new Tika().detect(item.getName()));

							file.setDownloadUrl(SessionHelper.getServerPath() + AngularFileUploadBinder
								.BLUEIMP_FILEUPLOAD_SERVLETURL + "?getfile=" + item
								.getName());
							file.setThumbnailUrl(
								SessionHelper.getServerPath() + AngularFileUploadBinder.BLUEIMP_FILEUPLOAD_SERVLETURL + "?getthumb=" +
									item.getName());
							file.setDeleteUrl(
								SessionHelper.getServerPath() + AngularFileUploadBinder.BLUEIMP_FILEUPLOAD_SERVLETURL + "?delfile=" + item.getName
									());

							filesArray.getAllFiles().add(file);

							Set<Class<? extends OnFileUploadInterceptor>> intercepters =
								GuiceContext.reflect().getSubTypesOf(OnFileUploadInterceptor
									.class);

							if (intercepters == null || intercepters.isEmpty()) {
								log.warning("There are no file upload interceptors to catch this file upload. Create a class that implements " +
									"OnFileUploadInterceptor to use this file.");
							}
							else {
								intercepters.forEach(a -> {
									OnFileUploadInterceptor obj = GuiceContext.getInstance(a);
									obj.onUploadCompleted(file);
								});
							}
						}
						tempFile.delete();
						stringFileMap.remove(fileUploadIdentifier);
					}
				}
			}
		}
		catch (FileUploadException e) {
			throw new RuntimeException(e);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			writeOutput(new StringBuilder(filesArray.toString()), "application/json", Charset.defaultCharset());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		if (request.getParameter("getfile") != null && !request.getParameter("getfile").isEmpty()) {

			String filename = request.getParameter("getfile");
			Set<Class<? extends OnGetFileInterceptor>> intercepters =
				GuiceContext.reflect().getSubTypesOf(OnGetFileInterceptor
					.class);
			if (intercepters == null || intercepters.isEmpty()) {
				log.warning("There are no file getter interceptors to catch this file get. Create a class that implements " +
					"OnGetFileInterceptor to deliver this file.");
			}
			else {
				intercepters.forEach(a -> {
					OnGetFileInterceptor obj = GuiceContext.getInstance(a);
					Pair<String, InputStream> is = obj.onGetFile(filename);
					String mimeType = new Tika().detect(is.getKey());
					response.setContentType(mimeType);
					response.setHeader("Content-Disposition", "inline; filename=\"" + is.getKey() + "\"");
					try {
						IOUtils.copyLarge(is.getValue(), response.getOutputStream());
					}
					catch (IOException e) {
						log.log(Level.SEVERE, "Unable to deliver file when input stream is transferred to output stream", e);
					}
					try {
						is.getValue().close();
					}
					catch (IOException e) {
						log.finest("already closed stream no need - " + e.getMessage());
					}
				});
			}

		}
		else if (request.getParameter("delfile") != null && !request.getParameter("delfile").isEmpty()) {
			String filename = request.getParameter("delfile");

			Set<Class<? extends OnDeleteFileInterceptor>> intercepters =
				GuiceContext.reflect().getSubTypesOf(OnDeleteFileInterceptor
					.class);
			if (intercepters == null || intercepters.isEmpty()) {
				log.warning("There are no file delete interceptors to catch this file delete. Create a class that implements " +
					"OnDeleteFileInterceptor to delete this file.");
			}
			else {
				intercepters.forEach(a -> {
					OnDeleteFileInterceptor obj = GuiceContext.getInstance(a);
					obj.onDeleteFile(filename);
				});
			}
		}
		else if (request.getParameter("getthumb") != null && !request.getParameter("getthumb").isEmpty()) {
			String filename = request.getParameter("getthumb");

			Set<Class<? extends OnThumbnailFileInterceptor>> intercepters =
				GuiceContext.reflect().getSubTypesOf(OnThumbnailFileInterceptor
					.class);
			if (intercepters == null || intercepters.isEmpty()) {
				log.warning("There are no file get thumbnail interceptors to catch this file thumbnail. Create a class that implements " +
					"OnThumbnailFileInterceptor to deliver the thumbnail.");
			}
			else {
				intercepters.forEach(a -> {
					OnThumbnailFileInterceptor obj = GuiceContext.getInstance(a);
					Pair<String, InputStream> is = obj.onThumbnailGet(filename);
					String mimeType = new Tika().detect(is.getKey());
					response.setContentType(mimeType);
					response.setHeader("Content-Disposition", "inline; filename=\"" + is.getKey() + "\"");
					try {
						IOUtils.copyLarge(is.getValue(), response.getOutputStream());
					}
					catch (IOException e) {
						log.log(Level.SEVERE, "Unable to deliver file when input stream is transferred to output stream", e);
					}
					try {
						is.getValue().close();
					}
					catch (IOException e) {
						log.finest("already closed stream no need - " + e.getMessage());
					}
				});
			}
		}
	}

	@SiteInterception
	protected void intercept() {
		/**
		 * Intercepted with the annotations
		 */
	}
}
