package com.jwebmp.plugins.angularfileupload.angular;

import com.jwebmp.core.base.html.inputs.InputFileType;

import jakarta.validation.constraints.NotNull;

/**
 * A file input component that allows the binding for base 64 into json objects
 *
 * @param <J>
 */
public class AngularFileUpload<J extends AngularFileUpload<J>>
		extends InputFileType<J>
{
	/**
	 * The angular file upload file type, can be used anyhow
	 */
	public AngularFileUpload()
	{
		//No config required
	}

	/**
	 * Push to model instead of bind
	 *
	 * @param variableName
	 * 		The variable to bind the file to
	 *
	 * @return J
	 *
	 * @see com.jwebmp.core.base.html.Input#bind(String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J bind(String variableName)
	{
		addAttribute("ng-file-model", variableName);
		return (J) this;
	}
}
