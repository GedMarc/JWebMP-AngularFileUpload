import com.jwebmp.core.base.angular.services.IAngularModule;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
import com.jwebmp.plugins.angularfileupload.angular.AngularFileUploadModule;
import com.jwebmp.plugins.angularfileupload.angular.AngularFileUploadPageConfigurator;
import com.jwebmp.plugins.angularfileupload.angular.AngularFilesUploadModule;
import com.jwebmp.plugins.angularfileupload.implementations.AngularFileUploadExclusionsModule;

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
	requires jakarta.activation;

	provides IAngularModule with AngularFileUploadModule, AngularFilesUploadModule;
	provides IPageConfigurator with AngularFileUploadPageConfigurator;

	provides IGuiceScanModuleExclusions with AngularFileUploadExclusionsModule;
	provides IGuiceScanJarExclusions with AngularFileUploadExclusionsModule;

	opens com.jwebmp.plugins.angularfileupload.angular to com.fasterxml.jackson.databind, com.jwebmp.core;

}
