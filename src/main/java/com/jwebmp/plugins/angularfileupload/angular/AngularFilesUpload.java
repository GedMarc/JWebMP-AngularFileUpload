package com.jwebmp.plugins.angularfileupload.angular;

import com.jwebmp.core.base.html.attributes.InputFileTypeAttributes;
import com.jwebmp.core.base.html.inputs.InputFileType;

import jakarta.validation.constraints.NotNull;

import static com.guicedee.services.jsonrepresentation.json.StaticStrings.STRING_EMPTY;
import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * A file input component that allows the binding for base 64 into json objects
 *
 * @param <J>
 */
public class AngularFilesUpload<J extends AngularFilesUpload<J>>
		extends InputFileType<J>
{
	/**
	 * The angular file upload file type, can be used anyhow
	 */
	public AngularFilesUpload()
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
		addAttribute("ng-file-model", STRING_EMPTY);
		addAttribute("model", variableName);

		addAttribute(InputFileTypeAttributes.Multiple, "multiple");
		return (J) this;
	}
}
