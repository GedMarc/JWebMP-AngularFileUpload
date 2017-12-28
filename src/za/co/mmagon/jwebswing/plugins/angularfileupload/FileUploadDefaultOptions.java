package za.co.mmagon.jwebswing.plugins.angularfileupload;

import com.fasterxml.jackson.annotation.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * The default options settings for the blue imp file uploader
 *
 * @param <J>
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileUploadDefaultOptions<J extends FileUploadDefaultOptions<J>> extends JavaScriptPart<FileUploadDefaultOptions<J>>
{
	/**
	 * The maximum file size to be uploaded
	 */
	private Integer maxFileSize = 999999999;
	/**
	 * The maximum chunk size to be uploaded
	 */
	private Integer maxChunkSize = 2048;

	/**
	 * Constructs a new instance of the default options
	 */
	public FileUploadDefaultOptions()
	{
		//No config needed
	}

	/**
	 * A Regex for when the image resizing must not happen
	 *
	 * @return
	 */
	@JsonProperty(value = "disableImageResize", required = true)
	@JsonRawValue
	@SuppressWarnings("unused")
	private String getDisableImageResize()
	{
		return new StringBuilder("/Android(?!.*Chrome)|Opera/" +
				                         ".test(window.navigator.userAgent)").toString();
	}

	/**
	 * The maximum file size to be uploaded
	 *
	 * @return
	 */
	public Integer getMaxFileSize()
	{
		return maxFileSize;
	}

	/**
	 * The maximum file size to be uploaded
	 *
	 * @param maxFileSize
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setMaxFileSize(Integer maxFileSize)
	{
		this.maxFileSize = maxFileSize;
		return (J) this;
	}

	/**
	 * The maximum chunk size to be uploaded
	 *
	 * @return
	 */
	public Integer getMaxChunkSize()
	{
		return maxChunkSize;
	}

	/**
	 * The maximum chunk size to be uploaded
	 *
	 * @param maxChunkSize
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setMaxChunkSize(Integer maxChunkSize)
	{
		this.maxChunkSize = maxChunkSize;
		return (J) this;
	}
}
