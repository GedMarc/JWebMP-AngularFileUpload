package com.jwebmp.plugins.angularfileupload.angular;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwebmp.core.base.html.inputs.InputTextType;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;

class AngularFileUploadModuleTest
{
	@Test
	void testMe() throws IOException
	{
		InputTextType<?> textInput = new InputTextType<>().bind("variable.binding");
		AngularFileUpload<?> upload = new AngularFileUpload<>();
		upload.bind("variable.angularFile");

		String jsonTest = "{\n" +
		                  "    \"lastModified\": 1438583972000,\n" +
		                  "    \"lastModifiedDate\": \"2015-08-03T06:39:32.000Z\",\n" +
		                  "    \"name\": \"gitignore_global.txt\",\n" +
		                  "    \"size\": 236,\n" +
		                  "    \"type\": \"text/plain\",\n" +
		                  "    \"data\": \"data:text/plain;base64,DQojaWdub3JlIHRodW1ibmFpbHMgY3JlYXRlZCBieSB3aW5kb3dz…xoDQoqLmJhaw0KKi5jYWNoZQ0KKi5pbGsNCioubG9nDQoqLmRsbA0KKi5saWINCiouc2JyDQo=\"\n" +
		                  "}";

		AngularFile file = new AngularFile<>().From(jsonTest, AngularFile.class);
		System.out.println(file);

		jsonTest = "[{\n" +
		           "    \"lastModified\": 1438583972000,\n" +
		           "    \"lastModifiedDate\": \"2015-08-03T06:39:32.000Z\",\n" +
		           "    \"name\": \"gitignore_global.txt\",\n" +
		           "    \"size\": 236,\n" +
		           "    \"type\": \"text/plain\",\n" +
		           "    \"data\": \"data:text/plain;base64,DQojaWdub3JlIHRodW1ibmFpbHMgY3JlYXRlZCBieSB3aW5kb3dz…xoDQoqLmJhaw0KKi5jYWNoZQ0KKi5pbGsNCioubG9nDQoqLmRsbA0KKi5saWINCiouc2JyDQo=\"\n" +
		           "}]";
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		mapper.readValue(new StringReader(jsonTest), AngularFiles.class);

		AngularFiles files = new AngularFiles<>().From(jsonTest, AngularFiles.class);

		System.out.println(files);

	}

	class DataTransfer
			extends JavaScriptPart<DataTransfer>
	{
		private String binding;
		private AngularFile<?> angularFile;
	}
}
