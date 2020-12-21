package com.jwebmp.plugins.angularfileupload.angular;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPageConfigurator;

import jakarta.validation.constraints.NotNull;

@PluginInformation(pluginName = "File Upload",
		pluginDescription = "Angular File Model is a directive for angularjs to help you make a model for input file and you can send it to sever for next step.",
		pluginUniqueName = "angular",
		pluginVersion = "1.0.4",
		pluginDependancyUniqueIDs = "jquery",
		pluginCategories = "jquery, angular, data-binding, ng, google",
		pluginGitUrl = "https://github.com/GedMarc/JWebMP-AngularJS",
		pluginSourceUrl = "https://github.com/resultsystems/ng-files-model",
		pluginWikiUrl = "https://github.com/GedMarc/JWebMP-AngularJS/wiki",
		pluginOriginalHomepage = "https://github.com/resultsystems/ng-files-model",
		pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins.angular/jwebmp-angular-file-upload",
		pluginIconImageUrl = "https://angularjs.org/img/AngularJS-large.png",
		pluginIconUrl = "https://angularjs.org/img/AngularJS-large.png",
		pluginLastUpdatedDate = "2020/12/14",
		pluginStatus = PluginStatus.Released,
		pluginGroupId = "com.jwebmp.plugins.angular",
		pluginArtifactId = "jwebmp-angular-file-upload",
		pluginModuleName = "com.jwebmp.plugins.angularfileupload",
		pluginSubtitle = "Binds the input file type to an angular variable"
)
public class AngularFileUploadPageConfigurator
		implements IPageConfigurator<AngularFileUploadPageConfigurator>
{
	private static final JavascriptReference fileUploadReference = new JavascriptReference("AngularFileUploadReference", 1.04,
	                                                                                       "bower_components/ng-file-model/ng-file-model.min.js");
	private static final JavascriptReference fileUploadsReference = new JavascriptReference("AngularFileUploadsReference", 1.04,
	                                                                                        "bower_components/ng-files-model/ng-files-model.min.js");
	private static boolean enabled = true;

	public static boolean isEnabled()
	{
		return enabled;
	}

	public static void setEnabled(boolean enabled)
	{
		AngularFileUploadPageConfigurator.enabled = enabled;
	}

	@Override
	public @NotNull Page<?> configure(Page<?> page)
	{
		if (enabled())
		{
			page.addJavaScriptReference(getFileUploadReference());
			page.addJavaScriptReference(getFileUploadsReference());
		}
		return page;
	}

	@Override
	public boolean enabled()
	{
		return enabled;
	}

	public static JavascriptReference getFileUploadReference()
	{
		return fileUploadReference;
	}

	public static JavascriptReference getFileUploadsReference()
	{
		return fileUploadsReference;
	}
}
