package com.jwebmp.plugins.angularfileupload;

import com.jwebmp.guicedservlets.GuiceSiteBinder;
import com.jwebmp.guicedservlets.GuiceSiteInjectorModule;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.angularfileupload.servlets.AngularFileServlet;

import java.util.logging.Level;

import static com.jwebmp.utilities.StaticStrings.*;

public class AngularFileUploadBinder
		extends GuiceSiteBinder
{
	public static final String BLUEIMP_FILEUPLOAD_SERVLETURL = "blueimpangularfileupload";
	private static final java.util.logging.Logger log = LogFactory.getLog("AngularFileUpload");

	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		module.serveRegex$("(" + "/" + BLUEIMP_FILEUPLOAD_SERVLETURL + ")" + QUERY_PARAMETERS_REGEX)
		      .with(AngularFileServlet.class);

		log.log(Level.INFO, "Serving File Uploads at {0}", "/" + BLUEIMP_FILEUPLOAD_SERVLETURL);
	}
}
