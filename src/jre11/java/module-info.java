module com.jwebmp.plugins.angularfileupload {

	exports com.jwebmp.plugins.angularfileupload.angular;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.jwebmp.guicedservlets;
	requires java.logging;
	requires javax.servlet.api;
	requires com.google.guice;

	requires com.jwebmp.guicedinjection;

	requires java.validation;
	requires com.fasterxml.jackson.annotation;
	requires com.fasterxml.jackson.databind;
	requires java.activation;
	requires com.jwebmp.core.angularjs;

	provides com.jwebmp.core.base.angular.services.IAngularModule with com.jwebmp.plugins.angularfileupload.angular.AngularFileUploadModule, com.jwebmp.plugins.angularfileupload.angular.AngularFilesUploadModule;
	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.angularfileupload.angular.AngularFileUploadPageConfigurator;

	provides com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.angularfileupload.implementations.AngularFileUploadExclusionsModule;
	provides com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions with com.jwebmp.plugins.angularfileupload.implementations.AngularFileUploadExclusionsModule;

	opens com.jwebmp.plugins.angularfileupload.angular to com.fasterxml.jackson.databind, com.jwebmp.core;

}
