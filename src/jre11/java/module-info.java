import com.jwebmp.plugins.angularfileupload.implementations.AngularFileUploadModuleInclusion;

module com.jwebmp.plugins.angularfileupload {

	exports com.jwebmp.plugins.angularfileupload.angular;

	requires com.jwebmp.core;
	requires com.guicedee.guicedservlets;
	requires java.servlet;

	requires jakarta.validation;
	requires com.jwebmp.core.angularjs;

	provides com.jwebmp.core.base.angular.services.IAngularModule with com.jwebmp.plugins.angularfileupload.angular.AngularFileUploadModule, com.jwebmp.plugins.angularfileupload.angular.AngularFilesUploadModule;
	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.angularfileupload.angular.AngularFileUploadPageConfigurator;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with AngularFileUploadModuleInclusion;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions with com.jwebmp.plugins.angularfileupload.implementations.AngularFileUploadExclusionsModule;

	opens com.jwebmp.plugins.angularfileupload.angular to com.fasterxml.jackson.databind, com.jwebmp.core;

}
