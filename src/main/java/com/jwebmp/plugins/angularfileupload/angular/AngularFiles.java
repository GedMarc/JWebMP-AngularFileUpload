package com.jwebmp.plugins.angularfileupload.angular;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRawValue;

import java.util.List;

/**
 * Designates a JSON object from the items
 *
 * @param <J>
 */
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class AngularFiles<J extends AngularFiles<J>>
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

	public List<AngularFile<?>> getFiles()
	{
		return files;
	}

	public void setFiles(List<AngularFile<?>> files)
	{
		this.files = files;
	}
}
