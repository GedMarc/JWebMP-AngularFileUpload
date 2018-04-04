package za.co.mmagon.jwebswing.plugins.angularfileupload.pages;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.plugins.angularfileupload.AngularFileUpload;
import za.co.mmagon.jwebswing.plugins.angularfileupload.parts.BlueImpFileUploadTable;
import za.co.mmagon.jwebswing.plugins.angularfileupload.parts.BlueImpUploadButtonBar;

public class AngularFileUploadTestPage extends Page<AngularFileUploadTestPage> {

	public AngularFileUploadTestPage() {
		AngularFileUpload fileUpload = new AngularFileUpload();
		BlueImpUploadButtonBar bar = fileUpload.addButtonBar();
		BlueImpFileUploadTable table = fileUpload.addDisplayTable();

		bar.addAddButton("btn btn-success", "glyphicon glyphicon-plus", "Add Files...", true);
		bar.addStartButton("btn btn-primary", "glyphicon glyphicon-upload", "Start Upload");
		bar.addCancelButton("btn btn-warning", "glyphicon glyphicon-ban-circle", "Cancel Upload");
		bar.addGlobalFileProcessingState();
		
		add(fileUpload);
	}
}
