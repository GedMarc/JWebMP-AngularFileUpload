/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.plugins.angularfileupload.servlets;

import com.google.inject.Singleton;
import com.jwebmp.SessionHelper;
import com.jwebmp.annotations.SiteInterception;
import com.jwebmp.base.servlets.JWDefaultServlet;
import com.jwebmp.guiceinjection.GuiceContext;
import com.jwebmp.guiceinjection.Pair;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.angularfileupload.AngularFileUploadBinder;
import com.jwebmp.plugins.angularfileupload.intercepters.OnDeleteFileInterceptor;
import com.jwebmp.plugins.angularfileupload.intercepters.OnFileUploadInterceptor;
import com.jwebmp.plugins.angularfileupload.intercepters.OnGetFileInterceptor;
import com.jwebmp.plugins.angularfileupload.intercepters.OnThumbnailFileInterceptor;
import com.jwebmp.plugins.angularfileupload.parts.json.JsonFile;
import com.jwebmp.plugins.angularfileupload.parts.json.JsonFilesArray;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.tika.Tika;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

/**
 * The default file receiving servlet
 */
@Singleton
@MultipartConfig
public class AngularFileServlet
		extends JWDefaultServlet
{

	private static final long serialVersionUID = 1L;
	private static final Logger log = LogFactory.getInstance()
	                                            .getLogger("BlueImpAngularFileServlet");

	private static final String getFileMethod = "getfile";
	private static final String deleteFileMethod = "delfile";
	private static final String getThumbMethod = "getthumb";

	private static Map<String, File> stringFileMap = new HashMap<>();

	/**
	 * Constructs a new File Servlet
	 */
	public AngularFileServlet()
	{
		//Nothing Needed
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	{

		if (request.getParameter(getFileMethod) != null && !request.getParameter(getFileMethod)
		                                                           .isEmpty())
		{

			processGetFile(request, response);

		}
		else if (request.getParameter(deleteFileMethod) != null && !request.getParameter(deleteFileMethod)
		                                                                   .isEmpty())
		{
			processDeleteFile(request);
		}
		else if (request.getParameter(getThumbMethod) != null && !request.getParameter(getThumbMethod)
		                                                                 .isEmpty())
		{
			processGetThumb(request, response);
		}
	}

	private void processGetFile(HttpServletRequest request, HttpServletResponse response)
	{
		String filename = request.getParameter(getFileMethod);
		Set<Class<? extends OnGetFileInterceptor>> intercepters = GuiceContext.reflect()
		                                                                      .getSubTypesOf(OnGetFileInterceptor.class);
		if (intercepters == null || intercepters.isEmpty())
		{
			log.warning("There are no file getter interceptors to catch this file get. Create a class that implements " + "OnGetFileInterceptor to deliver this file.");
		}
		else
		{
			intercepters.forEach(a ->
			                     {
				                     OnGetFileInterceptor obj = GuiceContext.getInstance(a);
				                     Pair<String, InputStream> is = obj.onGetFile(filename);
				                     String mimeType = new Tika().detect(is.getKey());
				                     response.setContentType(mimeType);
				                     response.setHeader("Content-Disposition", "inline; filename=\"" + is.getKey() + "\"");
				                     try
				                     {
					                     IOUtils.copyLarge(is.getValue(), response.getOutputStream());
					                     is.getValue()
					                       .close();
				                     }
				                     catch (IOException e)
				                     {
					                     log.log(Level.SEVERE, "Unable to deliver file when input stream is transferred to output stream", e);
				                     }
			                     });
		}
	}

	private void processDeleteFile(HttpServletRequest request)
	{
		String filename = request.getParameter(deleteFileMethod);

		Set<Class<? extends OnDeleteFileInterceptor>> intercepters = GuiceContext.reflect()
		                                                                         .getSubTypesOf(OnDeleteFileInterceptor.class);
		if (intercepters == null || intercepters.isEmpty())
		{
			log.warning("There are no file delete interceptors to catch this file delete. Create a class that implements " + "OnDeleteFileInterceptor to delete this file.");
		}
		else
		{
			intercepters.forEach(a ->
			                     {
				                     OnDeleteFileInterceptor obj = GuiceContext.getInstance(a);
				                     obj.onDeleteFile(filename);
			                     });
		}
	}

	private void processGetThumb(HttpServletRequest request, HttpServletResponse response)
	{
		String filename = request.getParameter(getThumbMethod);

		Set<Class<? extends OnThumbnailFileInterceptor>> intercepters = GuiceContext.reflect()
		                                                                            .getSubTypesOf(OnThumbnailFileInterceptor.class);
		if (intercepters == null || intercepters.isEmpty())
		{
			log.warning(
					"There are no file get thumbnail interceptors to catch this file thumbnail. Create a class that implements " + "OnThumbnailFileInterceptor to deliver the thumbnail.");
		}
		else
		{
			intercepters.forEach(a ->
			                     {
				                     OnThumbnailFileInterceptor obj = GuiceContext.getInstance(a);
				                     Pair<String, InputStream> is = obj.onThumbnailGet(filename);
				                     String mimeType = new Tika().detect(is.getKey());
				                     response.setContentType(mimeType);
				                     response.setHeader("Content-Disposition", "inline; filename=\"" + is.getKey() + "\"");
				                     try
				                     {
					                     IOUtils.copyLarge(is.getValue(), response.getOutputStream());
					                     is.getValue()
					                       .close();
				                     }
				                     catch (IOException e)
				                     {
					                     log.log(Level.SEVERE, "Unable to deliver file when input stream is transferred to output stream", e);
				                     }
			                     });
		}
	}

	/**
	 * Validates and sends the post
	 *
	 * @param request
	 * @param response
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			processRequest(request);
		}
		catch (ServletException e)
		{
			log.log(Level.SEVERE, "Angular File Servlet Do Post", e);
		}
	}

	@SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request) throws ServletException
	{
		log.log(Level.INFO, "[SessionID]-[{0}];[Connection]-[Data Call Connection Established]", request.getSession()
		                                                                                                .getId());

		if (!ServletFileUpload.isMultipartContent(request))
		{
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
		if (remaining == 0)
		{
			completed = true;
		}

		ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
		JsonFilesArray filesArray = new JsonFilesArray();
		try
		{
			List<FileItem> items = uploadHandler.parseRequest(request);
			for (FileItem item : items)
			{
				if (!item.isFormField())
				{
					processUploadedFile(completed, totalS, item, filesArray);
				}
			}
		}
		catch (FileUploadException e)
		{
			log.log(Level.SEVERE, "File Upload Exception Occured : ", e);
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, "Generic Exception on File Upload Occured : ", e);
		}
		finally
		{
			writeOutput(new StringBuilder(filesArray.toString()), "application/json", Charset.defaultCharset());
		}
	}

	@SiteInterception
	protected void intercept()
	{
		/**
		 * Intercepted with the annotations
		 */
	}

	private void processUploadedFile(boolean completed, Long totalS, FileItem item, JsonFilesArray filesArray) throws IOException
	{
		String fileUploadIdentifier = item.getName() + "|" + totalS + "|" + item.getFieldName();

		if (!stringFileMap.containsKey(fileUploadIdentifier))
		{
			File tempFile = File.createTempFile("jwebswing_fileUpload_", "-ul");
			stringFileMap.put(fileUploadIdentifier, tempFile);
		}

		File tempFile = stringFileMap.get(fileUploadIdentifier);

		if (!completed)
		{
			FileUtils.writeByteArrayToFile(tempFile, item.get(), true);
		}
		else
		{
			JsonFile file = new JsonFile();
			file.setName(item.getName());
			file.setSize(tempFile.length());

			try (FileInputStream fis = new FileInputStream(tempFile))
			{
				file.setContent(fis);
				file.setType(new Tika().detect(item.getName()));

				file.setDownloadUrl(SessionHelper.getServerPath() + AngularFileUploadBinder.BLUEIMP_FILEUPLOAD_SERVLETURL + "?getfile=" + item.getName());
				file.setThumbnailUrl(SessionHelper.getServerPath() + AngularFileUploadBinder.BLUEIMP_FILEUPLOAD_SERVLETURL + "?getthumb=" + item.getName());
				file.setDeleteUrl(SessionHelper.getServerPath() + AngularFileUploadBinder.BLUEIMP_FILEUPLOAD_SERVLETURL + "?delfile=" + item.getName());

				filesArray.getAllFiles()
				          .add(file);

				Set<Class<? extends OnFileUploadInterceptor>> intercepters = GuiceContext.reflect()
				                                                                         .getSubTypesOf(OnFileUploadInterceptor.class);

				if (intercepters == null || intercepters.isEmpty())
				{
					log.warning("There are no file upload interceptors to catch this file upload. Create a class that implements " + "OnFileUploadInterceptor to use this file.");
				}
				else
				{
					intercepters.forEach(a ->
					                     {
						                     OnFileUploadInterceptor obj = GuiceContext.getInstance(a);
						                     obj.onUploadCompleted(file);
					                     });
				}
			}
			if (!tempFile.delete())
			{
				log.warning("Unable to delete temporary file : " + tempFile);
			}
			stringFileMap.remove(fileUploadIdentifier);
		}
	}
}
