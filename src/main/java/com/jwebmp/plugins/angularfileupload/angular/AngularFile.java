package com.jwebmp.plugins.angularfileupload.angular;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Designates a JSON object from the items
 *
 * @param <J>
 */
public class AngularFile<J extends AngularFile<J>>
		extends JavaScriptPart<J>
{
	/**
	 * The last modified in long for the file
	 */
	private Long lastModified;
	/**
	 * THe last modified date for the file
	 */
	private LocalDateTime lastModifiedDate;
	/**
	 * The name of the file
	 */
	private String name;
	/**
	 * The size of the file
	 */
	private Long size;
	/**
	 * THe mime type of the uploaded file text/plan etc
	 */
	private String type;
	/**
	 * A Base 64 representation of the uploaded file
	 */
	private String data;

	public AngularFile()
	{
		//No config required
	}

	/**
	 * Method getLastModified returns the lastModified of this AngularFile object.
	 * <p>
	 * The last modified in long for the file
	 *
	 * @return the lastModified (type Long) of this AngularFile object.
	 */
	public Long getLastModified()
	{
		return lastModified;
	}

	/**
	 * Method setLastModified sets the lastModified of this AngularFile object.
	 * <p>
	 * The last modified in long for the file
	 *
	 * @param lastModified
	 * 		the lastModified of this AngularFile object.
	 *
	 * @return J
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setLastModified(Long lastModified)
	{
		this.lastModified = lastModified;
		return (J) this;
	}

	/**
	 * Method getLastModifiedDate returns the lastModifiedDate of this AngularFile object.
	 * <p>
	 * THe last modified date for the file
	 *
	 * @return the lastModifiedDate (type LocalDateTime) of this AngularFile object.
	 */
	public LocalDateTime getLastModifiedDate()
	{
		return lastModifiedDate;
	}

	/**
	 * Method setLastModifiedDate sets the lastModifiedDate of this AngularFile object.
	 * <p>
	 * THe last modified date for the file
	 *
	 * @param lastModifiedDate
	 * 		the lastModifiedDate of this AngularFile object.
	 *
	 * @return J
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setLastModifiedDate(LocalDateTime lastModifiedDate)
	{
		this.lastModifiedDate = lastModifiedDate;
		return (J) this;
	}

	/**
	 * Method getName returns the name of this AngularFile object.
	 * <p>
	 * The name of the file
	 *
	 * @return the name (type String) of this AngularFile object.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Method setName sets the name of this AngularFile object.
	 * <p>
	 * The name of the file
	 *
	 * @param name
	 * 		the name of this AngularFile object.
	 *
	 * @return J
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setName(String name)
	{
		this.name = name;
		return (J) this;
	}

	/**
	 * Method getSize returns the size of this AngularFile object.
	 * <p>
	 * The size of the file
	 *
	 * @return the size (type Long) of this AngularFile object.
	 */
	public Long getSize()
	{
		return size;
	}

	/**
	 * Method setSize sets the size of this AngularFile object.
	 * <p>
	 * The size of the file
	 *
	 * @param size
	 * 		the size of this AngularFile object.
	 *
	 * @return J
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSize(Long size)
	{
		this.size = size;
		return (J) this;
	}

	/**
	 * Method getType returns the type of this AngularFile object.
	 * <p>
	 * THe mime type of the uploaded file text/plan etc
	 *
	 * @return the type (type String) of this AngularFile object.
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Method setType sets the type of this AngularFile object.
	 * <p>
	 * THe mime type of the uploaded file text/plan etc
	 *
	 * @param type
	 * 		the type of this AngularFile object.
	 *
	 * @return J
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setType(String type)
	{
		this.type = type;
		return (J) this;
	}

	/**
	 * Method getData returns the data of this AngularFile object.
	 * <p>
	 * A Base 64 representation of the uploaded file
	 *
	 * @return the data (type String) of this AngularFile object.
	 */
	public String getData()
	{
		return data;
	}

	/**
	 * Method setData sets the data of this AngularFile object.
	 * <p>
	 * A Base 64 representation of the uploaded file
	 *
	 * @param data
	 * 		the data of this AngularFile object.
	 *
	 * @return J
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setData(String data)
	{
		this.data = data;
		return (J) this;
	}
}
