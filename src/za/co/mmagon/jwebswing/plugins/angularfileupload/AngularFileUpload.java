package za.co.mmagon.jwebswing.plugins.angularfileupload;

import za.co.mmagon.jwebswing.base.html.DivSimple;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;
import za.co.mmagon.jwebswing.plugins.angularfileupload.parts.BlueImpUploadForm;

@ComponentInformation(name = "Angular File Upload"
		, description = "File Upload widget with multiple file selection, drag&drop support, progress bar, validation and preview images, audio and video for jQuery. Supports cross-domain, chunked and resumable file uploads. Works with any server-side platform (Google App Engine, PHP, Python, Ruby on Rails, Java, etc.) that supports standard HTML form file uploads. "
		, url = "https://github.com/GedMarc/JWebSwing-AngularFileUpload")
public class AngularFileUpload<J extends AngularFileUpload<J>> extends BlueImpUploadForm<J>
{
	/**
	 * Configures the page for this component
	 */
	public AngularFileUpload()
	{
		//Nothing Needed
	}
	
}
