package za.co.mmagon.jwebswing.plugins.angularfileuploader;

import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.plugins.PluginInformation;

@PluginInformation(pluginName = "Angular File Upload",
		pluginUniqueName = "jwebswing-angular-file-upload",
		pluginDescription = "File Upload widget with multiple file selection, drag&drop support, progress bars, validation and preview images, audio and video for jQuery.\n" +
				"Supports cross-domain, chunked and resumable file uploads and client-side image resizing.\n" +
				"Works with any server-side platform (PHP, Python, Ruby on Rails, Java, Node.js, Go etc.) that supports standard HTML form file uploads.",
		pluginVersion = "2.4.7",
		pluginDependancyUniqueIDs = "jquery-ui,jquery,angular",
		pluginCategories = "File Upload, Widget, BlueImp",
		pluginSubtitle = "A File Uploader for JWebSwing",
		pluginGitUrl = "https://github.com/blueimp/jQuery-File-Upload",
		pluginSourceUrl = "https://github.com/blueimp/jQuery-File-Upload",
		pluginWikiUrl = "https://github.com/GedMarc/AngularFileUploadPageConfigurator/wiki",
		pluginOriginalHomepage = "https://github.com/blueimp/jQuery-File-Upload",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/AngularFileUploadPageConfigurator.jar/download",
		pluginIconUrl = "",
		pluginIconImageUrl = "",
		pluginLastUpdatedDate = "2017/09/18"
)
@Singleton
public class AngularFileUploadPageConfigurator extends PageConfigurator
{
	/**
	 * Configures the page for this component
	 */
	public AngularFileUploadPageConfigurator()
	{
		//Nothing Needed
	}
	
	@Override
	public Page configure(Page page)
	{
		if(!page.isConfigured())
		{
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.GalleryReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.GalleryReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.GalleryIndicatorReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.GalleryIndicatorReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.GalleryVideoReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.GalleryVideoReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.GalleryVimeoReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.GalleryVimeoReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.GalleryYoutubeReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.GalleryYoutubeReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.GalleryHelperReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.GalleryHelperReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.LoadImageJCropReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.LoadImageJCropReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.LoadImageExifReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.LoadImageExifReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.LoadImageExifMapReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.LoadImageExifMapReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.LoadImageMetaReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.LoadImageMetaReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.LoadImageReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.LoadImageReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.FileUploadReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.FileUploadReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.FileUploadAudioReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.FileUploadAudioReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.FileUploadImageReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.FileUploadImageReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.FileUploadProcessReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.FileUploadProcessReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.FileUploadValidateReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.FileUploadValidateReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.FileUploadIFrameTransportReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.FileUploadIFrameTransportReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.FileUploadVideoReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.FileUploadVideoReference.getCssReference());
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.FileUploadUIReference.getJavaScriptReference());
			page.getBody().addCssReference(AngularFileUploadReferencePool.FileUploadUIReference.getCssReference());
		}
		return page;
	}
}
