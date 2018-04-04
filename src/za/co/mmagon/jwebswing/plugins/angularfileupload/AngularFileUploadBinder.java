package za.co.mmagon.jwebswing.plugins.angularfileupload;

import za.co.mmagon.guiceinjection.abstractions.GuiceSiteInjectorModule;
import za.co.mmagon.guiceinjection.interfaces.GuiceSiteBinder;
import za.co.mmagon.jwebswing.plugins.angularfileupload.servlets.AngularFileServlet;
import za.co.mmagon.logger.LogFactory;

import java.util.logging.Level;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.QUERY_PARAMETERS_REGEX;

public class AngularFileUploadBinder extends GuiceSiteBinder
{
	private static final java.util.logging.Logger log = LogFactory.getLog("AngularFileUpload");

	public static final String BLUEIMP_FILEUPLOAD_SERVLETURL = "blueimpangularfileupload";
	
	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		module.serveRegex$("(" + "/" + BLUEIMP_FILEUPLOAD_SERVLETURL + ")" + QUERY_PARAMETERS_REGEX).with(AngularFileServlet.class);


		log.log(Level.INFO, "Serving File Uploads at {0}", "/" + BLUEIMP_FILEUPLOAD_SERVLETURL);
	}
}
