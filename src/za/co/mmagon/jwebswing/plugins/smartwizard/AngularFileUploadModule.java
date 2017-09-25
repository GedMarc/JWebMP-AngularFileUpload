package za.co.mmagon.jwebswing.plugins.smartwizard;

import com.armineasy.injection.abstractions.GuiceSiteInjectorModule;
import com.armineasy.injection.interfaces.GuiceSiteBinder;
import za.co.mmagon.jwebswing.plugins.smartwizard.servlets.AngularFileUploadServlet;
import za.co.mmagon.logger.LogFactory;

import java.util.logging.Logger;


public class AngularFileUploadModule extends GuiceSiteBinder
{
	private static final Logger log = LogFactory.getLog("File Uploader");
	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		log.info("Binding file upload to /jwfileupload");
		module.serveRegex$("/jwfileupload" + QueryParametersRegex).with(AngularFileUploadServlet.class);
	}
}
