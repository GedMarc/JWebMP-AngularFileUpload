package za.co.mmagon.jwebswing.plugins.angularfileupload;

import com.google.inject.Singleton;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.H3;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.List;
import za.co.mmagon.jwebswing.plugins.PluginInformation;
import za.co.mmagon.jwebswing.plugins.angularfileupload.angular.AngularBlueImpFileUploadModule;
import za.co.mmagon.jwebswing.plugins.angularfileupload.angular.BlueImpFileDestroyController;
import za.co.mmagon.jwebswing.plugins.angularfileupload.options.BlueImpFileUploadDefaultOptions;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;

import javax.validation.constraints.NotNull;

@PluginInformation(pluginName = "Angular File Upload",
		pluginUniqueName = "jwebswing-angular-file-upload",
		pluginDescription = "File Upload widget with multiple file selection, drag&drop support, progress bars, validation and preview " +
				                    "images, audio and video for jQuery.\n" + "Supports cross-domain, chunked and resumable file uploads "
				                    + "and client-side image resizing.\n" + "Works with any server-side platform (PHP, Python, Ruby on " +
				                    "Rails, Java, Node.js, Go etc.) that supports standard HTML form file uploads.",
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
		pluginLastUpdatedDate = "2017/09/18")
@Singleton
public class AngularFileUploadPageConfigurator
		extends PageConfigurator
{
	private static BlueImpFileUploadDefaultOptions defaultOptions;
	/**
	 * The div for the gallery
	 */
	private Div galleryDiv;
	
	private static boolean renderJqueryUI;

	/**
	 * Configures the page for this component
	 */
	public AngularFileUploadPageConfigurator()
	{
		//Nothing Needed
	}

	/**
	 * Returns the default options applied with this object
	 *
	 * @return
	 */
	@NotNull
	public static BlueImpFileUploadDefaultOptions getDefaultOptions()
	{
		if (defaultOptions == null)
		{
			defaultOptions = new BlueImpFileUploadDefaultOptions();
		}
		return defaultOptions;
	}

	/**
	 * Sets the default options applied
	 *
	 * @param defaultOptions
	 */
	public static void setDefaultOptions(BlueImpFileUploadDefaultOptions defaultOptions)
	{
		AngularFileUploadPageConfigurator.defaultOptions = defaultOptions;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Page configure(Page page)
	{
		if (!page.isConfigured())
		{
			registerModules(page);

			page.getBody()
			    .add(getGalleryDiv());

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.TemplatesReference.getJavaScriptReference().setSortOrder(200));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.LoadImageJCropReference.getJavaScriptReference().setSortOrder(201));
			page.getBody()
			    .addCssReference(AngularFileUploadReferencePool.LoadImageJCropReference.getCssReference().setSortOrder(202));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.LoadImageReference.getJavaScriptReference().setSortOrder(203));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.LoadImageMetaReference.getJavaScriptReference().setSortOrder(204));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.LoadImageExifReference.getJavaScriptReference().setSortOrder(205));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.LoadImageExifMapReference.getJavaScriptReference().setSortOrder(206));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.CanvasToBlobReference.getJavaScriptReference().setSortOrder(207));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryReference.getJavaScriptReference().setSortOrder(208));
			page.getBody()
			    .addCssReference(AngularFileUploadReferencePool.GalleryReference.getCssReference().setSortOrder(209));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryIndicatorReference.getJavaScriptReference().setSortOrder(210));
			page.getBody()
			    .addCssReference(AngularFileUploadReferencePool.GalleryIndicatorReference.getCssReference().setSortOrder(211));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryVideoReference.getJavaScriptReference().setSortOrder(212));
			page.getBody()
			    .addCssReference(AngularFileUploadReferencePool.GalleryVideoReference.getCssReference().setSortOrder(213));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryVimeoReference.getJavaScriptReference().setSortOrder(214));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryYoutubeReference.getJavaScriptReference().setSortOrder(215));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryHelperReference.getJavaScriptReference().setSortOrder(216));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadIFrameTransportReference.getJavaScriptReference().setSortOrder(217));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadReference.getJavaScriptReference().setSortOrder(218));
			page.getBody()
			    .addCssReference(AngularFileUploadReferencePool.FileUploadReference.getCssReference().setSortOrder(219));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadProcessReference.getJavaScriptReference().setSortOrder(220));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadAudioReference.getJavaScriptReference().setSortOrder(221));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadImageReference.getJavaScriptReference().setSortOrder(222));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadValidateReference.getJavaScriptReference().setSortOrder(223));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadVideoReference.getJavaScriptReference().setSortOrder(224));

			if(renderJqueryUI) {
				page.getBody()
					.addJavaScriptReference(AngularFileUploadReferencePool.FileUploadUIReference.getJavaScriptReference().setSortOrder(225));
				page.getBody()
					.addCssReference(AngularFileUploadReferencePool.FileUploadUIReference.getCssReference().setSortOrder(226));
			}
			
			page.getBody().addJavaScriptReference(AngularFileUploadReferencePool.FileUploadAngularReference.getJavaScriptReference().setSortOrder
				(227));
		}
		return page;
	}

	private void registerModules(Page page)
	{
		JQueryPageConfigurator.setRequired(true);
		AngularPageConfigurator.setRequired(true);

		page.getAngular()
		    .getAngularModules()
		    .add(new AngularBlueImpFileUploadModule());

		page.getAngular()
			.getAngularControllers()
			.add(new BlueImpFileDestroyController());
		
		page.getAngular()
		    .getAngularConfigurations()
		    .add(new AngularFileUploadDataBinderConfigurationBase());
	}

	/**
	 * The gallery div
	 *
	 * @return
	 */
	public Div getGalleryDiv()
	{
		if (galleryDiv == null)
		{
			setGalleryDiv(new Div());
		}
		return galleryDiv;
	}

	/**
	 * Sets the gallery div
	 *
	 * @param galleryDiv
	 */
	@SuppressWarnings("unchecked")
	public void setGalleryDiv(Div galleryDiv)
	{
		this.galleryDiv = galleryDiv;
		if (this.galleryDiv != null)
		{
			this.galleryDiv.setID("blueimp-gallery");
			this.galleryDiv.addClass("blueimp-gallery blueimp-gallery-controls");
			this.galleryDiv.addAttribute("data-filter", ":even");

			this.galleryDiv.add(new Div().addClass("slides"));
			this.galleryDiv.add(new H3().addClass("title"));
			this.galleryDiv.add(new Link().addClass("prev"));
			this.galleryDiv.add(new Link().addClass("next"));
			this.galleryDiv.add(new Link().addClass("close"));
			this.galleryDiv.add(new Link().addClass("play-pause"));
			this.galleryDiv.add(new List<>(true).addClass("indicator"));
		}
	}

	public static boolean isRenderJqueryUI() {
		return renderJqueryUI;
	}

	public static void setRenderJqueryUI(boolean renderJqueryUI) {
		AngularFileUploadPageConfigurator.renderJqueryUI = renderJqueryUI;
	}
}
