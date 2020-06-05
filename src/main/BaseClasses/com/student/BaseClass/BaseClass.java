package com.student.BaseClass;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	private static final Connection DriverManagar = null;
	public static Properties prop;
	public static String configfile_Patch = "C:\\GopalBackUp\\WorkSpace\\APIRestAssuredToolsQA\\src\\main\\BaseClasses\\com\\student\\config\\config.properties";
	public static RequestSpecification request;
	public static Response response;
	public static ResponseBody body;
	public static JsonPath jsonPathEvaluator;
	public static Connection connection = null;
	public static Statement statement = null;
	public static ResultSet resultset = null;
	public static int delete_Quary;
	public static ArrayList<String> airport = null;
	public static String id_NewCampus;

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

	public static ArrayList<String> SelectQuaryfromDatabase(String SQLQuary) throws SQLException {

		String connectionurl = "jdbc:sqlserver://INBDEVSQL2:1433;"
				+ "databaseName=QA_GCU_AD_2120;integratedSecurity=true;";

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			connection = DriverManager.getConnection(connectionurl);

			System.out.println("Connection Successfully!!!! ");

			statement = connection.createStatement();

			resultset = statement.executeQuery(SQLQuary);

			ResultSetMetaData rsmetadata = resultset.getMetaData();

			int columns = rsmetadata.getColumnCount();

			airport = new ArrayList<String>();

			while (resultset.next()) {

				for (int j = 1; j < columns; j++) {

					airport.add(resultset.getString(j));

				}

			}

		} catch (Throwable e) {

			System.out.println(e.getMessage());

		} finally {

			connection.close();

			statement.close();

			resultset.close();

		}

		return airport;

	}

	public void DeleteQuaryfromDatabase(String SQLQuary) throws SQLException {

		String connectionurl = "jdbc:sqlserver://INBDEVSQL2:1433;"
				+ "databaseName=QA_GCU_AD_2120;integratedSecurity=true;";

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			connection = DriverManager.getConnection(connectionurl);

			System.out.println("Connection Successfully!!!! ");

			statement = connection.createStatement();

			delete_Quary = statement.executeUpdate(SQLQuary);

		} catch (Throwable e) {

			System.out.println(e.getMessage());

		}

	}

}
