package com.jwebmp.plugins.angularfileupload;

import com.jwebmp.core.Page;
import org.junit.jupiter.api.Test;

public class AngularFileUploadTest
{

	@Test
	public void testPage()
	{
		Page<?> p = new Page();
		p.getOptions()
		 .setDynamicRender(false);
		System.out.println(p.toString(0));
	}

}
