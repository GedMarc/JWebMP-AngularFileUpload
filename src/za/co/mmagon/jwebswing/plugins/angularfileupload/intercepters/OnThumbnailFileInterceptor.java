package za.co.mmagon.jwebswing.plugins.angularfileupload.intercepters;

import java.io.InputStream;

import za.co.mmagon.guiceinjection.Pair;

/**
 * Specifies the get thumbnail interceptor
 */
@FunctionalInterface
public interface OnThumbnailFileInterceptor {

	/**
	 * Returns the thumbnail in line with the given output filename
	 *
	 * @param filename
	 * @return
	 */
	Pair<String, InputStream> onThumbnailGet(String filename);
}
