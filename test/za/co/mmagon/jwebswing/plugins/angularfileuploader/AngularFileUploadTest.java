package za.co.mmagon.jwebswing.plugins.angularfileuploader;

import org.junit.jupiter.api.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;

class AngularFileUploadTest extends BaseTestClass
{
	@Test
	public void testPage()
	{
		Page p = getInstance();
		System.out.println(p.toString(0));
	}
}
