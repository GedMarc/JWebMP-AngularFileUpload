package za.co.mmagon.jwebswing.plugins.angularfileupload.intercepters;

import java.io.InputStream;

/**
 * Specifies the get file interceptor
 */
@FunctionalInterface
public interface OnDeleteFileInterceptor {
	void onDeleteFile(String filename);
}
