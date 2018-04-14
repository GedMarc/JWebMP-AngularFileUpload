package com.jwebmp.plugins.angularfileupload.parts;

import com.jwebmp.SessionHelper;
import com.jwebmp.base.angular.AngularAttributes;
import com.jwebmp.base.html.Form;
import com.jwebmp.plugins.angularfileupload.AngularFileUploadBinder;
import com.jwebmp.plugins.angularfileupload.options.BlueImpFileUploadOptions;

/**
 * The file upload form used as target for the file upload widget
 *
 * @param <J>
 */
public class BlueImpUploadForm<J extends BlueImpUploadForm<J>>
		extends Form<J>
{

	private static final long serialVersionUID = 1L;

	private BlueImpFileUploadOptions options;

	public BlueImpUploadForm()
	{
		addAttribute("action", SessionHelper.getServletUrl() + AngularFileUploadBinder.BLUEIMP_FILEUPLOAD_SERVLETURL);
		addAttribute("method", "POST");
		addAttribute("enc-type", "multipart/form-data");
		addAttribute("data-file-upload", "options");
		addAttribute("data-ng-class", "{'fileupload-processing': processing() || loadingFiles}");
	}

	public BlueImpUploadButtonBar addButtonBar()
	{
		BlueImpUploadButtonBar bar = new BlueImpUploadButtonBar();
		add(bar);
		return bar;
	}

	public BlueImpFileUploadTable addDisplayTable()
	{
		BlueImpFileUploadTable bar = new BlueImpFileUploadTable();
		add(bar);
		return bar;
	}

	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			String optionsString = getOptions().toString()
			                                   .replaceAll("\\s", "");
			if (!optionsString.trim()
			                  .isEmpty())
			{
				addAttribute(AngularAttributes.ngInit, "options=" + getOptions().toString()
				                                                                .replaceAll("\\s", ""));
			}
		}
		super.preConfigure();
	}

	@Override
	public BlueImpFileUploadOptions getOptions()
	{
		if (options == null)
		{
			options = new BlueImpFileUploadOptions();
		}
		return options;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
}
