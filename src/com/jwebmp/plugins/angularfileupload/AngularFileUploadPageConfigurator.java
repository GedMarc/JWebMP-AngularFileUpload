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

package com.jwebmp.plugins.angularfileupload;

import com.google.inject.Singleton;
import com.jwebmp.Page;
import com.jwebmp.PageConfigurator;
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.base.html.Div;
import com.jwebmp.base.html.H3;
import com.jwebmp.base.html.Link;
import com.jwebmp.base.html.List;
import com.jwebmp.plugins.PluginInformation;
import com.jwebmp.plugins.angularfileupload.angular.AngularBlueImpFileUploadModule;
import com.jwebmp.plugins.angularfileupload.angular.BlueImpFileDestroyController;
import com.jwebmp.plugins.angularfileupload.options.BlueImpFileUploadDefaultOptions;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;

import javax.validation.constraints.NotNull;

@PluginInformation(pluginName = "Angular File Upload",
		pluginUniqueName = "jwebswing-angular-file-upload",
		pluginDescription = "File Upload widget with multiple file selection, drag&drop support, progress bars, validation and preview " + "images, audio and video for jQuery.\n" + "Supports cross-domain, chunked and resumable file uploads " + "and client-side image resizing.\n" + "Works with any server-side platform (PHP, Python, Ruby on " + "Rails, Java, Node.js, Go etc.) that supports standard HTML form file uploads.",
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
	private static boolean renderJqueryUI;
	/**
	 * The div for the gallery
	 */
	private Div galleryDiv;

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

	public static boolean isRenderJqueryUI()
	{
		return renderJqueryUI;
	}

	public static void setRenderJqueryUI(boolean renderJqueryUI)
	{
		AngularFileUploadPageConfigurator.renderJqueryUI = renderJqueryUI;
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
			    .addJavaScriptReference(AngularFileUploadReferencePool.TemplatesReference.getJavaScriptReference()
			                                                                             .setSortOrder(200));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.LoadImageJCropReference.getJavaScriptReference()
			                                                                                  .setSortOrder(201));
			page.getBody()
			    .addCssReference(AngularFileUploadReferencePool.LoadImageJCropReference.getCssReference()
			                                                                           .setSortOrder(202));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.LoadImageReference.getJavaScriptReference()
			                                                                             .setSortOrder(203));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.LoadImageMetaReference.getJavaScriptReference()
			                                                                                 .setSortOrder(204));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.LoadImageExifReference.getJavaScriptReference()
			                                                                                 .setSortOrder(205));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.LoadImageExifMapReference.getJavaScriptReference()
			                                                                                    .setSortOrder(206));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.CanvasToBlobReference.getJavaScriptReference()
			                                                                                .setSortOrder(207));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryReference.getJavaScriptReference()
			                                                                           .setSortOrder(208));
			page.getBody()
			    .addCssReference(AngularFileUploadReferencePool.GalleryReference.getCssReference()
			                                                                    .setSortOrder(209));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryIndicatorReference.getJavaScriptReference()
			                                                                                    .setSortOrder(210));
			page.getBody()
			    .addCssReference(AngularFileUploadReferencePool.GalleryIndicatorReference.getCssReference()
			                                                                             .setSortOrder(211));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryVideoReference.getJavaScriptReference()
			                                                                                .setSortOrder(212));
			page.getBody()
			    .addCssReference(AngularFileUploadReferencePool.GalleryVideoReference.getCssReference()
			                                                                         .setSortOrder(213));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryVimeoReference.getJavaScriptReference()
			                                                                                .setSortOrder(214));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryYoutubeReference.getJavaScriptReference()
			                                                                                  .setSortOrder(215));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.GalleryHelperReference.getJavaScriptReference()
			                                                                                 .setSortOrder(216));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadIFrameTransportReference.getJavaScriptReference()
			                                                                                             .setSortOrder(217));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadReference.getJavaScriptReference()
			                                                                              .setSortOrder(218));
			page.getBody()
			    .addCssReference(AngularFileUploadReferencePool.FileUploadReference.getCssReference()
			                                                                       .setSortOrder(219));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadProcessReference.getJavaScriptReference()
			                                                                                     .setSortOrder(220));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadAudioReference.getJavaScriptReference()
			                                                                                   .setSortOrder(221));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadImageReference.getJavaScriptReference()
			                                                                                   .setSortOrder(222));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadValidateReference.getJavaScriptReference()
			                                                                                      .setSortOrder(223));

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadVideoReference.getJavaScriptReference()
			                                                                                   .setSortOrder(224));

			if (renderJqueryUI)
			{
				page.getBody()
				    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadUIReference.getJavaScriptReference()
				                                                                                .setSortOrder(225));
				page.getBody()
				    .addCssReference(AngularFileUploadReferencePool.FileUploadUIReference.getCssReference()
				                                                                         .setSortOrder(226));
			}

			page.getBody()
			    .addJavaScriptReference(AngularFileUploadReferencePool.FileUploadAngularReference.getJavaScriptReference()
			                                                                                     .setSortOrder(227));
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
}