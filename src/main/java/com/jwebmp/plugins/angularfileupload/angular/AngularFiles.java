package com.jwebmp.plugins.angularfileupload.angular;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Designates a JSON object from the items
 *
 * @param <J>
 */
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class AngularFiles<J extends AngularFiles<J>>
		extends JavaScriptPart<J>
{
	/**
	 * A list of files returned from the JSON object
	 */
	@JsonRawValue
	private List<AngularFile<?>> files;

	/**
	 * An angular file upload that binds to variables
	 */
	public AngularFiles()
	{
		//No config required
	}

	/**
	 * Method getFiles returns the files of this AngularFiles object.
	 * <p>
	 * A list of files returned from the JSON object
	 *
	 * @return the files (type List<AngularFile<?>>) of this AngularFiles object.
	 */
	@NotNull
	@JsonValue
	public List<AngularFile<?>> getFiles()
	{
		if (files == null)
		{
			files = new ArrayList<>();
		}
		return files;
	}

	/**
	 * Method setFiles sets the files of this AngularFiles object.
	 * <p>
	 * A list of files returned from the JSON object
	 *
	 * @param files
	 * 		the files of this AngularFiles object.
	 *
	 * @return J
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setFiles(List<AngularFile<?>> files)
	{
		this.files = files;
		return (J) this;
	}
}
