package za.co.mmagon.jwebswing.plugins.angularfileupload;

import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.base.angular.configurations.AngularConfigurationBase;

public class AngularFileUploadDataBinderConfigurationBase extends AngularConfigurationBase
{
	public AngularFileUploadDataBinderConfigurationBase()
	{
		super("AngularFileUploadDataBinderConfigurationBase");
	}

	@Override
	public String renderFunction()
	{
		String output;

		StringBuilder sb = FileTemplates.getFileTemplate(AngularFileUploadDataBinderConfigurationBase.class, "FileUploadDefaultOptionsTemplate", "FileUploadDefaultOptionsTemplate");
		output = sb.toString().replace("FileUploadDefaultOptionsTemplateOptions", AngularFileUploadPageConfigurator.getDefaultOptions().toString());

		return output;
	}
}
