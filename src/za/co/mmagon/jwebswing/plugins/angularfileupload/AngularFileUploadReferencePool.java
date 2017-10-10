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
package za.co.mmagon.jwebswing.plugins.angularfileupload;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.interfaces.ReferencePool;
import za.co.mmagon.jwebswing.plugins.angularfileupload.interfaces.ReferenceNames;

/**
 * Default reference pool structure
 *
 * @author GedMarc
 * @since 20 Apr 2016
 */
public enum AngularFileUploadReferencePool implements ReferencePool,ReferenceNames
{
	TemplatesReference(new JavascriptReference("TemplatesReference", 1.0, "jwebswing-angular-file-upload/tmpl.min.js"),
	                   null),
	/**
	 * Gallery Reference
	 */
	GalleryReference(new JavascriptReference("GalleryReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-gallery.js"),
	                 new CSSReference("GalleryReference", 1.0, "jwebswing-angular-file-upload/gallery/css/blueimp-gallery.min.css")),
	
	GalleryIndicatorReference(new JavascriptReference("GalleryIndicatorReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-gallery-indicator.js"),
	                          new CSSReference("GalleryIndicatorReference", 1.0, "jwebswing-angular-file-upload/gallery/css/blueimp-gallery-indicator.css")),
	
	GalleryVideoReference(new JavascriptReference("GalleryVideoReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-gallery-video.js"),
	                      new CSSReference("GalleryVideoReference", 1.0, "jwebswing-angular-file-upload/gallery/css/blueimp-gallery-video.css")),
	
	GalleryVimeoReference(new JavascriptReference("GalleryVimeoReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-gallery-vimeo.js"),
	                      null),
	
	GalleryYoutubeReference(new JavascriptReference("GalleryYoutubeReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-gallery-youtube.js"),
	                        null),
	
	GalleryHelperReference(new JavascriptReference("GalleryHelperReference", 1.0, "jwebswing-angular-file-upload/gallery/js/blueimp-helper.js"),
	                       null),
	
	/**
	 * Load Image
	 */
	
	LoadImageJCropReference(new JavascriptReference("LoadImageJCropReference", 1.0, "jwebswing-angular-file-upload/load-image/js/vendor/jquery.Jcrop.js"),
	                        new CSSReference("LoadImageJCropReference", 1.0, "jwebswing-angular-file-upload/load-image/css/vendor/jquery.Jcrop.css")),
	
	LoadImageExifReference(new JavascriptReference("LoadImageExifReference", 1.0, "jwebswing-angular-file-upload/load-image/js/load-image-exif.js"),
	                       null),
	LoadImageMetaReference(new JavascriptReference("LoadImageMetaReference", 1.0, "jwebswing-angular-file-upload/load-image/js/load-image-meta.js"),
	                       null),
	LoadImageExifMapReference(new JavascriptReference("LoadImageExifMapReference", 1.0, "jwebswing-angular-file-upload/load-image/js/load-image-exif-map.js"),
	                          null),
	LoadImageReference(new JavascriptReference("LoadImageReference", 1.0, "jwebswing-angular-file-upload/load-image/js/load-image.js"),
	                   null),
	
	
	CanvasToBlobReference(new JavascriptReference("CanvasToBlobReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/canvas-to-blob.min.js"),
	                      null),
	
	/**
	 * File Upload
	 */
	
	FileUploadReference(new JavascriptReference(ReferenceNames.FileUploadReference, 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload.js"),
	                    new CSSReference(ReferenceNames.FileUploadReference, 1.0, "jwebswing-angular-file-upload/file-upload/css/jquery.fileupload.css")),
	
	FileUploadAudioReference(new JavascriptReference("FileUploadAudioReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-audio.js"),
	                         null),
	
	FileUploadImageReference(new JavascriptReference("FileUploadImageReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-image.js"),
	                         null),
	FileUploadProcessReference(new JavascriptReference("FileUploadProcessReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-process.js"),
	                           null),
	FileUploadValidateReference(new JavascriptReference("FileUploadValidateReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-validate.js"),
	                            null),
	FileUploadIFrameTransportReference(new JavascriptReference("FileUploadIFrameTransportReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.iframe-transport.js"),
	                                   null),
	FileUploadVideoReference(new JavascriptReference("FileUploadVideoReference", 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-video.js"),
	                         null),
	
	
	FileUploadUIReference(new JavascriptReference(ReferenceNames.FileUploadReference, 1.0, "jwebswing-angular-file-upload/file-upload/js/jquery.fileupload-ui.js"),
	                      new CSSReference("angularFileUploadReference", 1.0, "jwebswing-angular-file-upload/file-upload/css/jquery.fileupload-ui.css")),;
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
	private AngularFileUploadReferencePool()
	{
	}
	
	/**
	 * Constructs a new reference pool
	 *
	 * @param javaScriptReference
	 * @param cssReference
	 */
	private AngularFileUploadReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference)
	{
		this.javaScriptReference = javaScriptReference;
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
}
