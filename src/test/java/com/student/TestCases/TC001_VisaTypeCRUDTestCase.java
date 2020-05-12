package com.student.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.BaseClass.BaseClass;
import com.student.TestData.UtilClass;
import com.student.visatype.Get_Payload_visatype;
import com.student.visatype.Get_VisaType;
import com.student.visatype.NewEditPayloadvisatype;
import com.student.visatype.NewEditVisaType;

public class TC001_VisaTypeCRUDTestCase extends BaseClass {

	ObjectMapper objMapper = new ObjectMapper();
	static Get_Payload_visatype getpayload;
	static NewEditPayloadvisatype payload;
	static UtilClass utilclass;
	public static String id_response_value;
	public static String name_response_value;
	public static String code_response_value;
	public static String rowVersion_response_value;
	public static String Code_Valdation;

	@BeforeMethod
	public void setUpURL() {

		String service_URL = "/api/commands/Crm/VisaType";

		request = initialization(service_URL);

		utilclass = new UtilClass();

	}

	@Test(dataProvider = "setDataforNewVisaType", priority = 1)
	public void CreateVisaType(String id, String code, String createdDateTime, String isActive, String isSystemCode,
			String isUsedSevis, String lastModifiedDateTime, String lastModifiedUserId, String name)
			throws JsonProcessingException {

		NewEditVisaType visaType = new NewEditVisaType();
		visaType.id = (int) Math.round(Double.parseDouble(id));
		visaType.code = code;
		visaType.createdDateTime = createdDateTime;
		visaType.entityState = 0;
		visaType.isActive = Boolean.parseBoolean(isActive);
		visaType.isSystemCode = Boolean.parseBoolean(isSystemCode);
		visaType.isUsedSevis = Boolean.parseBoolean(isUsedSevis);
		visaType.lastModifiedDateTime = lastModifiedDateTime;
		visaType.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		visaType.name = name;
		visaType.originalState = "";
		visaType.rowVersion = null;
		visaType.secureState = "";

		payload = new NewEditPayloadvisatype(visaType);

		String datas = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		System.out.println("Create New Record payload: " + datas);

		request.body(payload);

		response = request.post("/SaveNew");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Assert.assertEquals(response.getStatusCode(), 200);

		name_response_value = jsonPathEvaluator.getString("payload.data.name");

		Assert.assertEquals(name_response_value, name, "Record not created");

		code_response_value = jsonPathEvaluator.getString("payload.data.code");

		Assert.assertEquals(code_response_value, code);

		id_response_value = jsonPathEvaluator.getString("payload.data.id");

	}

	@Test(dataProvider = "setDataforNewVisaType", priority = 2)
	public void CodeValidationinewNewMode(String id, String code, String createdDateTime, String isActive,
			String isSystemCode, String isUsedSevis, String lastModifiedDateTime, String lastModifiedUserId,
			String name) throws JsonProcessingException {

		NewEditVisaType visatype = new NewEditVisaType();
		visatype.id = (int) Math.round(Double.parseDouble(id));
		visatype.code = code;
		visatype.createdDateTime = createdDateTime;
		visatype.isActive = Boolean.parseBoolean(isActive);
		visatype.isSystemCode = Boolean.parseBoolean(isSystemCode);
		visatype.isUsedSevis = Boolean.parseBoolean(isUsedSevis);
		visatype.lastModifiedDateTime = lastModifiedDateTime;
		visatype.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		visatype.name = name;
		visatype.rowVersion = null;
		visatype.originalState = "";
		visatype.secureState = "";
		visatype.entityState = 0;

		payload = new NewEditPayloadvisatype(visatype);

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		System.out.println("Create New Record payload and verify code already existing validation message: " + data);

		request.body(payload);

		response = request.post("/SaveNew");

		body = response.body();

		jsonPathEvaluator = body.jsonPath();

		Code_Valdation = jsonPathEvaluator.getString("notifications.message");

		Assert.assertEquals(Code_Valdation, "[Code already exists.]");

	}

	@Test(priority = 3)
	public void GetforEditVisaType() throws JsonProcessingException {

		Get_VisaType get_visatype = new Get_VisaType();

		get_visatype.id = (int) Math.round(Double.parseDouble(id_response_value));

		getpayload = new Get_Payload_visatype(get_visatype);

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getpayload);

		System.out.println("Get Record payload:" + data);

		request.body(getpayload);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Assert.assertEquals(response.getStatusCode(), 200);

		rowVersion_response_value = jsonPathEvaluator.getString("payload.data.rowVersion");

	}

	@Test(dataProvider = "setDataforEditVisaType", priority = 4)
	public void EditVisaType(String code, String createdDateTime, String isActive, String isSystemCode,
			String isUsedSevis, String lastModifiedDateTime, String lastModifiedUserId, String name)
			throws JsonProcessingException {

		NewEditVisaType visaType = new NewEditVisaType();
		visaType.id = (int) Math.round(Double.parseDouble(id_response_value));
		visaType.code = code;
		visaType.createdDateTime = createdDateTime;
		visaType.isActive = Boolean.parseBoolean(isActive);
		visaType.isSystemCode = Boolean.parseBoolean(isSystemCode);
		visaType.isUsedSevis = Boolean.parseBoolean(isUsedSevis);
		visaType.lastModifiedDateTime = lastModifiedDateTime;
		visaType.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		visaType.name = name;
		visaType.rowVersion = rowVersion_response_value;
		visaType.originalState = "";
		visaType.secureState = "";
		visaType.entityState = utilclass.edit_entityState;

		payload = new NewEditPayloadvisatype(visaType);

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		System.out.println("Edit Record payload: " + data);

		request.body(payload);

		response = request.post("/Save");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		name_response_value = jsonPathEvaluator.getString("payload.data.name");

		Assert.assertEquals(name_response_value, name);

		code_response_value = jsonPathEvaluator.getString("payload.data.code");

		Assert.assertEquals(code_response_value, code);

	}

	@Test(priority = 5)
	public void GetforDeleteVisaType() throws JsonProcessingException {

		Get_VisaType get_visatype = new Get_VisaType();
		get_visatype.id = (int) Math.round(Double.parseDouble(id_response_value));

		getpayload = new Get_Payload_visatype(get_visatype);

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getpayload);

		System.out.println("Get for delete Record payload: " + data);

		request.body(getpayload);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Assert.assertEquals(response.getStatusCode(), 200);

		rowVersion_response_value = jsonPathEvaluator.getString("payload.data.rowVersion");

	}

	@Test(dataProvider = "setDataforEditVisaType", priority = 6)
	public void DeleteVisaType(String code, String createdDateTime, String isActive, String isSystemCode,
			String isUsedSevis, String lastModifiedDateTime, String lastModifiedUserId, String name)
			throws JsonProcessingException {

		NewEditVisaType visatype = new NewEditVisaType();
		visatype.id = (int) Math.round(Double.parseDouble(id_response_value));
		visatype.code = code;
		visatype.createdDateTime = createdDateTime;
		visatype.isActive = Boolean.parseBoolean(isActive);
		visatype.isSystemCode = Boolean.parseBoolean(isSystemCode);
		visatype.isUsedSevis = Boolean.parseBoolean(isUsedSevis);
		visatype.lastModifiedDateTime = lastModifiedDateTime;
		visatype.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		visatype.name = name;
		visatype.rowVersion = rowVersion_response_value;
		visatype.originalState = "";
		visatype.secureState = "";
		visatype.entityState = utilclass.delete_entityState;

		payload = new NewEditPayloadvisatype(visatype);

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		System.out.println("Delete Record payload: " + data);

		request.body(payload);

		response = request.post("/Delete");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		String deleteMessage = jsonPathEvaluator.getString("payload.deleted");

		Assert.assertEquals(deleteMessage, "true");

	}

	@DataProvider(name = "setDataforNewVisaType")
	public Object[][] getNewEditData() {
		Object[][] visaTypeData = { { "-1", "Code3", "2020/01/06 11:23:01", "TRUE", "FALSE", "FALSE",
				"2020/01/06 11:23:01", "2", "Name3" } };
		return visaTypeData;
	}

	@DataProvider(name = "setDataforEditVisaType")
	public Object[][] getNewData() {
		Object[][] visaTypeData = { { "CodeUpa", "2020/01/06 11:23:01", "TRUE", "FALSE", "FALSE", "2020/01/06 11:23:01",
				"2", "Name2Updated" } };
		return visaTypeData;
	}
}
