package com.student.TestCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.BaseClass.BaseClass;
import com.student.SAPStatus.FaSapStatusStudentGroupList;
import com.student.SAPStatus.Get_Payload_faSAPStatus;
import com.student.SAPStatus.Get_faSAPStatus;
import com.student.SAPStatus.Payload;
import com.student.SAPStatus.PayloadSap;
import com.student.SAPStatus.StudentGroup;
import com.student.TestData.UtilClass;

import junit.framework.Assert;

public class TC001_SAPStatusCRUDTestCases extends BaseClass {

	ObjectMapper objMapper = new ObjectMapper();
	public static String id_responsepayload_data;
	public static String name_responsepayload_data;
	public static String rowVersion_responsepayload_data;

	@Test
	public void SetUpBaseURL() {

		String service_URL = "/api/commands/FinancialAid/FaSapStatus";

		request = initialization(service_URL);
	}

	@Test(dataProvider = "setNewModeData", priority = 1)
	public void CreatefaSAPStatus(String id, String code, String createdDateTime, String excludeFromCalc,
			String isActive, String isSapMet, String isSystemCode, String lastModifiedDateTime,
			String lastModifiedUserId, String name) throws JsonProcessingException {

		List<FaSapStatusStudentGroupList> fasaplist = new ArrayList<FaSapStatusStudentGroupList>();

		Payload payload = new Payload();
		payload.id = (int) Math.round(Double.parseDouble(id));
		payload.code = code;
		payload.createdDateTime = createdDateTime;
		payload.excludeFromCalc = Boolean.parseBoolean(excludeFromCalc);
		payload.isActive = Boolean.parseBoolean(isActive);
		payload.isSapMet = Boolean.parseBoolean(isSapMet);
		payload.isSystemCode = Boolean.parseBoolean(isSystemCode);
		payload.lastModifiedDateTime = lastModifiedDateTime;
		payload.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		payload.name = name;
		payload.rowVersion = null;
		payload.originalState = "";
		payload.secureState = "";
		payload.entityState = 0;
		payload.faSapStatusStudentGroupList = fasaplist;

		PayloadSap payloadsap = new PayloadSap();
		payloadsap.payload = payload;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payloadsap);

		System.out.println(data);

		request.body(payloadsap);

		response = request.post("/SaveNew");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		id_responsepayload_data = jsonPathEvaluator.getString("payload.data.id");

		name_responsepayload_data = jsonPathEvaluator.getString("payload.data.name");

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(name_responsepayload_data, name);

	}

	@Test(dataProvider = "setNewModeData", priority = 2)
	public void CreateCodeAlreadyExistsValidationfaSAPStatus(String id, String code, String createdDateTime,
			String excludeFromCalc, String isActive, String isSapMet, String isSystemCode, String lastModifiedDateTime,
			String lastModifiedUserId, String name) throws JsonProcessingException {

		List<FaSapStatusStudentGroupList> fasaplist = new ArrayList<FaSapStatusStudentGroupList>();

		Payload payload = new Payload();
		payload.id = (int) Math.round(Double.parseDouble(id));
		payload.code = code;
		payload.createdDateTime = createdDateTime;
		payload.excludeFromCalc = Boolean.parseBoolean(excludeFromCalc);
		payload.isActive = Boolean.parseBoolean(isActive);
		payload.isSapMet = Boolean.parseBoolean(isSapMet);
		payload.isSystemCode = Boolean.parseBoolean(isSystemCode);
		payload.lastModifiedDateTime = lastModifiedDateTime;
		payload.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		payload.name = name;
		payload.rowVersion = null;
		payload.originalState = "";
		payload.secureState = "";
		payload.entityState = 0;
		payload.faSapStatusStudentGroupList = fasaplist;

		PayloadSap payloadsap = new PayloadSap();
		payloadsap.payload = payload;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payloadsap);

		System.out.println(data);

		request.body(payloadsap);

		response = request.post("/SaveNew");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		String code_validation_message = jsonPathEvaluator.getString("notifications.message");

		Assert.assertEquals(code_validation_message,
				"[The SAP Status was not saved because the code is specified for an existing SAP Status.]");

	}

	@Test(priority = 3)
	public void GetEditModefaSAPStatus() throws JsonProcessingException {

		Get_faSAPStatus get_faSAPStatus = new Get_faSAPStatus();
		get_faSAPStatus.id = (int) Math.round(Double.parseDouble(id_responsepayload_data));

		Get_Payload_faSAPStatus get_Payload_faSAPStatus = new Get_Payload_faSAPStatus();
		get_Payload_faSAPStatus.payload = get_faSAPStatus;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(get_Payload_faSAPStatus);

		System.out.println("Get Payload for Edit mode: " + data);

		request.body(get_Payload_faSAPStatus);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Assert.assertEquals(response.getStatusCode(), 200);

		rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");
	}

	@Test(dataProvider = "setEditModeData", priority = 4)
	public void EditfaSAPStatus(String code, String createdDateTime, String excludeFromCalc, String isActive,
			String isSapMet, String isSystemCode, String lastModifiedDateTime, String lastModifiedUserId, String name,
			String studentGroupName, String faSapStatusStudentGroupListid, String IsActive,
			String IsRemovedFromStudentGroupWhenSapMet, String StudentGroupId) throws JsonProcessingException {

		StudentGroup studentgroup = new StudentGroup();
		studentgroup.name = studentGroupName;

		List<FaSapStatusStudentGroupList> faSAPStatusStudGrupList = new ArrayList<FaSapStatusStudentGroupList>();

		FaSapStatusStudentGroupList faSapStatusStudentGroupList = new FaSapStatusStudentGroupList();
		faSapStatusStudentGroupList.id = (int) Math.round(Double.parseDouble(faSapStatusStudentGroupListid));
		faSapStatusStudentGroupList.faSapStatusId = (int) Math.round(Double.parseDouble(id_responsepayload_data));
		faSapStatusStudentGroupList.studentGroupId = (int) Math.round(Double.parseDouble(StudentGroupId));
		faSapStatusStudentGroupList.isActive = Boolean.parseBoolean(IsActive);
		faSapStatusStudentGroupList.entityState = 0;
		faSapStatusStudentGroupList.isRemovedFromStudentGroupWhenSapMet = Boolean
				.parseBoolean(IsRemovedFromStudentGroupWhenSapMet);
		faSapStatusStudentGroupList.studentGroup = studentgroup;

		faSAPStatusStudGrupList.add(faSapStatusStudentGroupList);

		Payload payload = new Payload();
		payload.id = (int) Math.round(Double.parseDouble(id_responsepayload_data));
		payload.code = code;
		payload.createdDateTime = createdDateTime;
		payload.excludeFromCalc = Boolean.parseBoolean(excludeFromCalc);
		payload.isActive = Boolean.parseBoolean(isActive);
		payload.isSapMet = Boolean.parseBoolean(isSapMet);
		payload.isSystemCode = Boolean.parseBoolean(isSystemCode);
		payload.lastModifiedDateTime = lastModifiedDateTime;
		payload.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		payload.name = name;
		payload.rowVersion = rowVersion_responsepayload_data;
		payload.originalState = "";
		payload.secureState = "";
		payload.entityState = UtilClass.edit_entityState;
		payload.faSapStatusStudentGroupList = faSAPStatusStudGrupList;

		PayloadSap payloadsap = new PayloadSap();
		payloadsap.payload = payload;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payloadsap);

		System.out.println("Edit faSAPStatus payload" + data);

		request.body(payloadsap);

		response = request.post("/Save");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(jsonPathEvaluator.getString("payload.data.name"), name);

	}

	@DataProvider
	public Object[][] setNewModeData() {

		Object[][] data_NewMode = { { "-1", "!!SAP!!", "2020/05/13 18:30:59", "false", "true", "false", "false",
				"2020/05/13 18:30:59", "2", "!!SAPNAME!!!!" } };

		return data_NewMode;
	}

	@DataProvider
	public Object[][] setEditModeData() {

		Object[][] data_EditMode = { { "SAPUpda", "2020/05/13 18:30:59", "false", "true", "false", "false",
				"2020/05/13 18:30:59", "2", "!!SAPNAMEUPDATE!!!!", "!!Gourab", "-1", "true", "false", "12990" } };

		return data_EditMode;
	}
}
