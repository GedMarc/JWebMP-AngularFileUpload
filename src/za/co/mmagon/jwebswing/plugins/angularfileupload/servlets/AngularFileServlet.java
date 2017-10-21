package za.co.mmagon.jwebswing.plugins.angularfileupload.servlets;

import com.google.inject.Singleton;
import org.apache.commons.io.IOUtils;
import za.co.mmagon.jwebswing.base.ajax.exceptions.InvalidRequestException;
import za.co.mmagon.jwebswing.base.servlets.JWDefaultServlet;
import za.co.mmagon.jwebswing.base.servlets.options.AngularFileTransferData;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.logger.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The default file receiving servlet
 */
@Singleton
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
	 *
	 * @throws ServletException
	 * @throws IOException
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
	}
}
