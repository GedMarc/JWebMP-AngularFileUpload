package com.jwebmp.plugins.angularfileupload.implementations;
import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;


public class AngularFileUploadModuleInclusion  implements IGuiceScanModuleInclusions<AngularFileUploadModuleInclusion>
{
	@Override
	public @NotNull Set<String> includeModules()
	{
		Set<String> set = new HashSet<>();
		set.add("com.jwebmp.plugins.angularfileupload");
		return set;
	}
}
