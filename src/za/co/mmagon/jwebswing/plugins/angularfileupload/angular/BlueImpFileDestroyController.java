package za.co.mmagon.jwebswing.plugins.angularfileupload.angular;

import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.base.angular.controllers.AngularControllerBase;

public class BlueImpFileDestroyController extends AngularControllerBase {

	public static final String FILE_DESTROY_CONTROLLER_NAME = "BlueImpFileDestroyController";

	public BlueImpFileDestroyController() {
		super(FILE_DESTROY_CONTROLLER_NAME);
	}

	@Override
	public String renderFunction() {
		return FileTemplates.getFileTemplate(BlueImpFileDestroyController.class, "BlueImpFileDestroyController", "blueimpfiledestroycontroller")
			.toString();
	}
}
