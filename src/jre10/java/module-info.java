import com.jwebmp.core.base.angular.services.IAngularModule;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.angularfileupload.angular.AngularFileUploadModule;
import com.jwebmp.plugins.angularfileupload.angular.AngularFileUploadPageConfigurator;
import com.jwebmp.plugins.angularfileupload.angular.AngularFilesUploadModule;

module com.jwebmp.plugins.angularfileupload {
	exports com.jwebmp.plugins.angularfileupload.angular;

	requires com.jwebmp.core;

	provides IAngularModule with AngularFileUploadModule, AngularFilesUploadModule;
	provides IPageConfigurator with AngularFileUploadPageConfigurator;

	opens com.jwebmp.plugins.angularfileupload.angular to com.fasterxml.jackson.databind, com.jwebmp.core;
}
