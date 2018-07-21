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

import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.interfaces.ReferencePool;

/**
 * Default reference pool structure
 *
 * @author GedMarc
 * @since 20 Apr 2016
 */
public enum AngularFileUploadReferencePool
		implements ReferencePool
{
	/**
	 * Display Template
	 */
	TemplatesReference(new JavascriptReference("TemplatesReference", 1.0, "jwebswing-angular-file-upload/tmpl.min.js"),
	                   null),
	/**
	 * Gallery Reference
	 */
	GalleryReference(new JavascriptReference("GalleryReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-gallery.min.js"),
	                 new CSSReference("GalleryReference", 1.0, "jwebswing-angular-file-upload/gallery/css/blueimp-gallery.min.css")),

	GalleryIndicatorReference(new JavascriptReference("GalleryIndicatorReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-gallery-indicator.min.js"),
	                          new CSSReference("GalleryIndicatorReference", 1.0, "jwebswing-angular-file-upload/gallery/css/blueimp-gallery-indicator.min.css")),

	GalleryVideoReference(new JavascriptReference("GalleryVideoReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-gallery-video.min.js"),
	                      new CSSReference("GalleryVideoReference", 1.0, "jwebswing-angular-file-upload/gallery/css/blueimp-gallery-video.min.css")),

	GalleryVimeoReference(new JavascriptReference("GalleryVimeoReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-gallery-vimeo.min.js"),
	                      null),

	GalleryYoutubeReference(new JavascriptReference("GalleryYoutubeReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-gallery-youtube.min.js"),
	                        null),

	GalleryHelperReference(new JavascriptReference("GalleryHelperReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-helper.min.js"),
	                       null),

	/**
	 * Load Image
	 */

	LoadImageJCropReference(new JavascriptReference("LoadImageJCropReference", 1.0, "jwebswing-angular-file-upload/load-image/js/vendor/jquery.Jcrop.min.js"),
	                        new CSSReference("LoadImageJCropReference", 1.0, "jwebswing-angular-file-upload/load-image/css/vendor/jquery.Jcrop.min.css")),

	LoadImageExifReference(new JavascriptReference("LoadImageExifReference", 1.0, "jwebswing-angular-file-upload/load-image/js/load-image-exif.min.js"),
	                       null),
	LoadImageMetaReference(new JavascriptReference("LoadImageMetaReference", 1.0, "jwebswing-angular-file-upload/load-image/js/load-image-meta.min.js"),
	                       null),
	LoadImageExifMapReference(new JavascriptReference("LoadImageExifMapReference", 1.0, "jwebswing-angular-file-upload/load-image/js/load-image-exif-map.min.js"),
	                          null),
	LoadImageReference(new JavascriptReference("LoadImageReference", 1.0, "jwebswing-angular-file-upload/load-image/js/load-image.min.js"),
	                   null),

	CanvasToBlobReference(new JavascriptReference("CanvasToBlobReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/canvas-to-blob.min.js"),
	                      null),

	/**
	 * File Upload
	 */

	FileUploadReference(new JavascriptReference("FileUploadReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload.min.js"),
	                    new CSSReference("FileUploadReferenceCSS", 1.0, "jwebswing-angular-file-upload/file-upload/css/jquery.fileupload.min.css")),

	FileUploadAudioReference(new JavascriptReference("FileUploadAudioReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-audio.min.js"),
	                         null),

	FileUploadImageReference(new JavascriptReference("FileUploadImageReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-image.min.js"),
	                         null),
	FileUploadProcessReference(new JavascriptReference("FileUploadProcessReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-process.min.js"),
	                           null),
	FileUploadValidateReference(new JavascriptReference("FileUploadValidateReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-validate.min.js"),
	                            null),
	FileUploadIFrameTransportReference(
			new JavascriptReference("FileUploadIFrameTransportReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.iframe-transport.min.js"),
			null),
	FileUploadVideoReference(new JavascriptReference("FileUploadVideoReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-video.min.js"),
	                         null),

	FileUploadUIReference(new JavascriptReference("FileUploadUIReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-ui.min.js"),
	                      new CSSReference("angularFileUploadReference", 1.0, "jwebswing-angular-file-upload/file-upload/css/jquery.fileupload-ui.min.css")),

	FileUploadAngularReference(new JavascriptReference("FileUploadAngularReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery" +
	                                                                                      ".fileupload-angular" +
	                                                                                      ".min.js"), null);
	/**
	 * The actual javascript
	 */
	private JavascriptReference javaScriptReference;
	/**
	 * The actual css reference
	 */
	private CSSReference cssReference;

	/**
	 * Constructs a reference pool
	 */
	AngularFileUploadReferencePool()
	{
	}

	/**
	 * Constructs a new reference pool
	 *
	 * @param javaScriptReference
	 * @param cssReference
	 */
	AngularFileUploadReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference)
	{
		this.javaScriptReference = javaScriptReference;
		this.cssReference = cssReference;
	}

	/**
	 * Gets the cSS reference
	 *
	 * @return
	 */
	@Override
	public CSSReference getCssReference()
	{
		return cssReference;
	}

	/**
	 * Sets the CSS Reference
	 *
	 * @param cssReference
	 */
	@Override
	public void setCssReference(CSSReference cssReference)
	{
		this.cssReference = cssReference;
	}

	/**
	 * Returns the javascript reference
	 *
	 * @return
	 */
	@Override
	public JavascriptReference getJavaScriptReference()
	{
		return javaScriptReference;
	}

	/**
	 * Sets the javascript reference
	 *
	 * @param javaScriptReference
	 */
	@Override
	public void setJavaScriptReference(JavascriptReference javaScriptReference)
	{
		this.javaScriptReference = javaScriptReference;
	}
}
