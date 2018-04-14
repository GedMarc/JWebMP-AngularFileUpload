/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jwebmp.plugins.angularfileupload.angular;

import com.jwebmp.FileTemplates;
import com.jwebmp.base.angular.controllers.AngularControllerBase;

public class BlueImpFileDestroyController
		extends AngularControllerBase
{

	public static final String FILE_DESTROY_CONTROLLER_NAME = "BlueImpFileDestroyController";

	public BlueImpFileDestroyController()
	{
		super(FILE_DESTROY_CONTROLLER_NAME);
	}

	@Override
	public String renderFunction()
	{
		return FileTemplates.getFileTemplate(BlueImpFileDestroyController.class, "BlueImpFileDestroyController", "blueimpfiledestroycontroller")
		                    .toString();
	}
}
