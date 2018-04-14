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

package com.jwebmp.plugins.angularfileupload;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.encoding.EncodingHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.websockets.jsr.WebSocketDeploymentInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import za.co.mmagon.guiceinjection.GuiceContext;
import za.co.mmagon.logger.LogFactory;
import za.co.mmagon.logger.handlers.ConsoleSTDOutputHandler;

import javax.servlet.ServletException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AngularFileUploadIT
{

	@BeforeAll
	public static void beforeEverythingStartServer() throws ServletException
	{
		Handler[] handles = Logger.getLogger("")
		                          .getHandlers();
		for (Handler handle : handles)
		{
			handle.setLevel(Level.FINE);
		}
		LogFactory.setDefaultLevel(Level.FINE);
		Logger.getLogger("")
		      .addHandler(new ConsoleSTDOutputHandler(true));

		DeploymentInfo servletBuilder = Servlets.deployment()
		                                        .setClassLoader(AngularFileUploadIT.class.getClassLoader())
		                                        .setContextPath("/")
		                                        .setDeploymentName("IntegrationTest.ear");
		System.out.println("Loading websocket deployment infor");
		final WebSocketDeploymentInfo webSocketDeploymentInfo = new WebSocketDeploymentInfo();
		servletBuilder.addServletContextAttribute(WebSocketDeploymentInfo.ATTRIBUTE_NAME, webSocketDeploymentInfo);
		System.out.println("Done loading websocket deployment infor");

		DeploymentManager manager = Servlets.defaultContainer()
		                                    .addDeployment(servletBuilder);

		manager.deploy();
		HttpHandler handler;
		HttpHandler jwebSwingHandler = manager.start();

		handler = jwebSwingHandler;
		HttpHandler encodingHandler = new EncodingHandler.Builder().build(null)
		                                                           .wrap(jwebSwingHandler);
		GuiceContext.inject();
		handler = encodingHandler;

		Undertow server = Undertow.builder()
		                          .addHttpListener(6002, "0.0.0.0")
		                          .setHandler(handler)
		                          .build();

		server.start();
	}

	@Test
	public void testUI()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.navigate()
		      .to("http://localhost:6002/");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.manage()
		      .timeouts()
		      .implicitlyWait(9999999, TimeUnit.DAYS);
		while (1 == 1)
		{
			//infite;
			Logger.getLogger("keepOPen")
			      .finest("Just keeping the site running");
		}
	}
}
