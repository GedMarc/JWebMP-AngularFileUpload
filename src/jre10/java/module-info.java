import com.jwebmp.guicedservlets.services.IGuiceSiteBinder;
import com.jwebmp.plugins.angularfileupload.AngularFileUploadBinderGuiceSiteBinder;

module com.jwebmp.plugins.angularfileupload {
	exports com.jwebmp.plugins.angularfileupload;
	exports com.jwebmp.plugins.angularfileupload.angular;
	exports com.jwebmp.plugins.angularfileupload.intercepters;
	exports com.jwebmp.plugins.angularfileupload.options;
	exports com.jwebmp.plugins.angularfileupload.parts;
	exports com.jwebmp.plugins.angularfileupload.parts.json;
	exports com.jwebmp.plugins.angularfileupload.servlets;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.jwebmp.guicedservlets;
	requires java.logging;
	requires javax.servlet.api;
	requires com.google.guice;
	requires commons.fileupload;
	requires com.jwebmp.guicedinjection;
	requires tika.core;
	requires commons.io;
	requires java.validation;
	requires com.fasterxml.jackson.annotation;
	requires com.fasterxml.jackson.databind;
	requires java.activation;

	provides IGuiceSiteBinder with AngularFileUploadBinderGuiceSiteBinder;
}
