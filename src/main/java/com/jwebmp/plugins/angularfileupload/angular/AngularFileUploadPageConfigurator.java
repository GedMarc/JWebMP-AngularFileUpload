package com.jwebmp.plugins.angularfileupload.angular;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.services.IPageConfigurator;

import javax.validation.constraints.NotNull;

public class AngularFileUploadPageConfigurator
		implements IPageConfigurator
{
	private static final JavascriptReference fileUploadReference = new JavascriptReference("AngularFileUploadReference", 1.0,
	                                                                                       "bower_components/ng-file-model/ng-file-model.min.js");
	private static final JavascriptReference fileUploadsReference = new JavascriptReference("AngularFileUploadsReference", 1.0,
	                                                                                        "bower_components/ng-files-model/ng-files-model.min.js");
	private static boolean enabled;

	public static boolean isEnabled()
	{
		return enabled;
	}

	public static void setEnabled(boolean enabled)
	{
		AngularFileUploadPageConfigurator.enabled = enabled;
	}

	public static JavascriptReference getFileUploadReference()
	{
		return fileUploadReference;
	}

	public static JavascriptReference getFileUploadsReference()
	{
		return fileUploadsReference;
	}

	@Override
	public @NotNull Page<?> configure(Page<?> page)
	{
		page.addJavaScriptReference(fileUploadReference);
		page.addJavaScriptReference(fileUploadsReference);
		return page;
	}

	@Override
	public boolean enabled()
	{
		return enabled;
	}
}
