package com.student.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	public static Properties prop;

	public static String configfile_Patch = "C:\\GopalBackUp\\WorkSpace\\APIRestAssuredToolsQA\\src\\main\\java\\com\\student\\config\\config.properties";

	public static RequestSpecification request;

	public static Response response;

	public static ResponseBody body;

	public static JsonPath jsonPathEvaluator;

	public BaseClass() {

		prop = new Properties();

		try {

			FileInputStream file = new FileInputStream(configfile_Patch);

			prop.load(file);

		} catch (Throwable e) {

			System.out.println(e.getMessage());

		}
	}

	public static RequestSpecification initialization(String service_URL) {

		String URI = prop.getProperty("endpoint_URL") + service_URL;

		RestAssured.baseURI = URI;

		request = RestAssured.given();

		request.header("Content-Type", "application/json");

		request.auth().preemptive().basic(prop.getProperty("UserName"), prop.getProperty("Password"));

		request.config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()));

		return request;

	}

}
