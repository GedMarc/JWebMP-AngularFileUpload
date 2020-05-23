module com.jwebmp.plugins.angularfileupload {

	exports com.jwebmp.plugins.angularfileupload.angular;

	requires com.jwebmp.core;
	requires com.guicedee.logmaster;
	requires com.guicedee.guicedservlets;
	requires java.logging;
	requires java.servlet;
	requires com.google.guice;

	requires com.guicedee.guicedinjection;

	requires java.validation;
	requires com.fasterxml.jackson.annotation;
	requires com.fasterxml.jackson.databind;
	requires jakarta.activation;
	requires com.jwebmp.core.angularjs;

	provides com.jwebmp.core.base.angular.services.IAngularModule with com.jwebmp.plugins.angularfileupload.angular.AngularFileUploadModule, com.jwebmp.plugins.angularfileupload.angular.AngularFilesUploadModule;
	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.angularfileupload.angular.AngularFileUploadPageConfigurator;

	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.angularfileupload.implementations.AngularFileUploadExclusionsModule;

	opens com.jwebmp.plugins.angularfileupload.angular to com.fasterxml.jackson.databind, com.jwebmp.core;

}
