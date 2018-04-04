package za.co.mmagon.jwebswing.plugins.angularfileupload.angular;

import za.co.mmagon.jwebswing.base.angular.modules.AngularModuleBase;

/**
 * The module getting loaded into angular
 *
 * @author Marc Magon
 * @since 08 Jun 2017
 */
public class AngularBlueImpFileUploadModule extends AngularModuleBase
{

	private static final long serialVersionUID = 1L;

	/*
	 * Constructs a new AngularRouteModule
	 */
	public AngularBlueImpFileUploadModule()
	{
		super("blueimp.fileupload");
	}

	@Override
	public String renderFunction()
	{
		return null;
	}
}
