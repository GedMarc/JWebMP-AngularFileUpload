package za.co.mmagon.jwebswing.plugins.angularfileupload.angular;

import za.co.mmagon.FileTemplates;
import za.co.mmagon.jwebswing.base.angular.directives.AngularDirectiveBase;

/**
 * The Angular Auto Focus Directive that is applied
 *
 * @author Marc Magon
 * @since 30 May 2017
 */
public class AngularFileUploadDirective
		extends AngularDirectiveBase
{

	private static final long serialVersionUID = 1L;

	/*
	 * Constructs a new Angular File Upload Binding Directive
	 */
	public AngularFileUploadDirective()
	{
		super("AngularFileUploadDirective");
	}

	@Override
	public String renderFunction()
	{
		return FileTemplates.getFileTemplate(AngularFileUploadDirective.class, "AngularFileUploadDirective", "angularfileuploaddirective")
		                    .toString();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
