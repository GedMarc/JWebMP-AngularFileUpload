package za.co.mmagon.jwebswing.plugins.angularfileupload.servlets;

import com.google.inject.Singleton;
import org.apache.commons.io.IOUtils;
import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.servlets.JWDefaultServlet;
import za.co.mmagon.jwebswing.base.servlets.SessionStorageProperties;
import za.co.mmagon.jwebswing.base.servlets.options.AngularFileTransferData;
import za.co.mmagon.jwebswing.exceptions.InvalidRequestException;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.utilities.StaticStrings;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The default file receiving servlet
 */
@Singleton
@MultipartConfig
public class AngularFileServlet extends JWDefaultServlet
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = LogFactory.getInstance().getLogger("AngularFileServlet");

	/**
	 * Constructs a new File Servlet
	 */
	public AngularFileServlet()
	{
		//Nothing Needed
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
		catch (IOException | InvalidRequestException e)
		{
			log.log(Level.SEVERE, "Angular File Servlet Do Post", e);
		}
	}


	protected void processRequest(HttpServletRequest request)
			throws IOException, InvalidRequestException
	{
		log.log(Level.FINER, "[SessionID]-[{0}];[Connection]-[Data Call Connection Established]", request.getSession().getId());
		StringBuilder jb = new StringBuilder(IOUtils.toString(request.getInputStream(), "UTF-8"));

		AngularFileTransferData initData = new JavaScriptPart<>().From(jb.toString(), AngularFileTransferData.class);
		if (initData == null)
		{
			throw new InvalidRequestException("Could not extract the initial data from the information sent in");
		}
		if (jb.length() > 0)
		{
			initData = new JavaScriptPart<>().From(jb.toString(), AngularFileTransferData.class);
			initData.setReferenceId("Test");
		}

		SessionStorageProperties properties = GuiceContext.getInstance(SessionStorageProperties.class);
		Part file = null;
		try
		{
			file = request.getPart("file");
			String filename = getFilename(file);
			InputStream filecontent = file.getInputStream();
			byte[] contents = IOUtils.toByteArray(filecontent);
			properties.getUploadedFiles().put(filename, contents);
		}
		catch (ServletException e)
		{
			log.log(Level.SEVERE, "Unable to read part of message", e);
		}
		AjaxResponse response = GuiceContext.getInstance(AjaxResponse.class);
		writeOutput(new StringBuilder(response.toString()), "application/json", Charset.defaultCharset());
	}

	/**
	 * Gets a file name from a given upload part
	 *
	 * @param part
	 *
	 * @return
	 */
	public static String getFilename(Part part)
	{
		for (String cd : part.getHeader("content-disposition").split(StaticStrings.STRING_SEMICOLON))
		{
			if (cd.trim().startsWith("filename"))
			{
				String filename = cd.substring(cd.indexOf(StaticStrings.CHAR_EQUALS) + 1).trim().replace(StaticStrings.STRING_DOUBLE_QUOTES, StaticStrings.STRING_EMPTY);
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
			}
		}
		return null;
	}
}
