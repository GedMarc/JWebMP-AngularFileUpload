package za.co.mmagon.jwebswing.plugins.angularfileupload.parts;

import za.co.mmagon.SessionHelper;
import za.co.mmagon.jwebswing.base.angular.AngularAttributes;
import za.co.mmagon.jwebswing.base.html.Form;
import za.co.mmagon.jwebswing.plugins.angularfileupload.options.BlueImpFileUploadOptions;

import static za.co.mmagon.jwebswing.plugins.angularfileupload.AngularFileUploadBinder.BLUEIMP_FILEUPLOAD_SERVLETURL;

/**
 * The file upload form used as target for the file upload widget
 *
 * @param <J>
 */
public class BlueImpUploadForm<J extends BlueImpUploadForm<J>> extends Form<J> {

	private static final long serialVersionUID = 1L;

	private BlueImpFileUploadOptions options;

	public BlueImpUploadForm() {
		addAttribute("action", SessionHelper.getServletUrl() + BLUEIMP_FILEUPLOAD_SERVLETURL);
		addAttribute("method", "POST");
		addAttribute("enc-type", "multipart/form-data");
		addAttribute("data-file-upload", "options");
		addAttribute("data-ng-class", "{'fileupload-processing': processing() || loadingFiles}");
	}

	public BlueImpUploadButtonBar addButtonBar() {
		BlueImpUploadButtonBar bar = new BlueImpUploadButtonBar();
		add(bar);
		return bar;
	}

	public BlueImpFileUploadTable addDisplayTable() {
		BlueImpFileUploadTable bar = new BlueImpFileUploadTable();
		add(bar);
		return bar;
	}

	@Override
	public void preConfigure() {
		if (!isConfigured()) {
			String options = getOptions().toString().replaceAll("\\s", "");
			if (!options.trim().isEmpty()) {
				addAttribute(AngularAttributes.ngInit, "options=" + getOptions().toString().replaceAll("\\s", ""));
			}
		}
		super.preConfigure();
	}

	public BlueImpFileUploadOptions getOptions() {
		if (options == null) {
			options = new BlueImpFileUploadOptions();
		}
		return options;
	}
}
