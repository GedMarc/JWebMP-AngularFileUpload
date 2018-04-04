package za.co.mmagon.jwebswing.plugins.angularfileupload.parts.json;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Denotes a Json Files Array
 */
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonFilesArray extends JavaScriptPart<JsonFilesArray> {

	@JsonIgnore
	private List<JsonFile> allFiles;

	@NotNull
	@JsonProperty("files")
	public List<JsonFile> getAllFiles() {
		if (allFiles == null) {
			allFiles = new ArrayList<>();
		}
		return allFiles;
	}

}
