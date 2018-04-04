package za.co.mmagon.jwebswing.plugins.angularfileupload.intercepters;

import za.co.mmagon.jwebswing.plugins.angularfileupload.parts.json.JsonFile;

/**
 * Interceptor for when a file is uploaded.
 * <p>
 * Occurs after placed into the session storage (remember to clear session storage properties
 */
@FunctionalInterface
public interface OnFileUploadInterceptor {

	/**
	 * Occurs when a file has been successfully uploaded
	 *
	 * @param file
	 */
	void onUploadCompleted(JsonFile file);
}
