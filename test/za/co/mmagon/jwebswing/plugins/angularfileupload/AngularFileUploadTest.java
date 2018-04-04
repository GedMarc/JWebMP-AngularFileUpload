package za.co.mmagon.jwebswing.plugins.angularfileupload;

import org.junit.jupiter.api.Test;

import za.co.mmagon.jwebswing.Page;

public class AngularFileUploadTest
{

	@Test
	public void testPage()
	{
		Page p = new Page();
		p.getOptions().setDynamicRender(false);
		System.out.println(p.toString(0));
	}


}
