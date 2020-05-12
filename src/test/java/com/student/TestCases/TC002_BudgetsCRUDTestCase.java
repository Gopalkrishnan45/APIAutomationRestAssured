package com.student.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.BaseClass.BaseClass;
import com.student.Budgets.Get_Budgets;
import com.student.Budgets.Get_Payload_Budgets;
import com.student.Budgets.NewEditBudgets;
import com.student.Budgets.NewEditPayloadBudgets;
import com.student.TestData.UtilClass;

import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_BudgetsCRUDTestCase extends BaseClass {

	public static RequestSpecification request;
	public static NewEditPayloadBudgets payload;
	public static ObjectMapper objMapper = new ObjectMapper();
	public static Get_Payload_Budgets getpayload;
	public static String id_response_value;
	public static String rowVersion_response_value;
	public static String name_response_value;
	public static String code_response_value;

	@BeforeMethod
	public void Setup() {

		String service_URL = "/api/commands/FinancialAid/Budget";

		request = initialization(service_URL);

	}

	@Test(dataProvider = "setNewData", priority = 1)
	public void CreateRecordBudgets(String id, String books, String campusGroupId, String code, String createdDateTime,
			String institutionChargesCalcMethod, String isActive, String isMonthlyBudget,
			String isOffCampusOtherCharge1Institutional, String isOffCampusOtherCharge2Institutional,
			String isOffCampusOtherCharge3Institutional, String isOffCampusOtherCharge4Institutional,
			String isOffCampusOtherCharge5Institutional, String isOffCampusOtherCharge6Institutional,
			String isOffCampusOtherCharge7Institutional, String isOffCampusOtherCharge8Institutional,
			String isOnCampusOtherCharge1Institutional, String isOnCampusOtherCharge2Institutional,
			String isOnCampusOtherCharge3Institutional, String isOnCampusOtherCharge4Institutional,
			String isOnCampusOtherCharge5Institutional, String isOnCampusOtherCharge6Institutional,
			String isOnCampusOtherCharge7Institutional, String isOnCampusOtherCharge8Institutional,
			String isOtherCharge1Institutional, String isOtherCharge2Institutional, String isOtherCharge3Institutional,
			String isOtherCharge4Institutional, String isOtherCharge5Institutional, String isOtherCharge6Institutional,
			String isOtherCharge7Institutional, String isOtherCharge8Institutional, String lastModifiedDateTime,
			String lastModifiedUserId, String name, String offCampusOtherAmount1, String offCampusOtherAmount2,
			String offCampusOtherAmount3, String offCampusOtherAmount4, String offCampusOtherAmount5,
			String offCampusOtherAmount6, String offCampusOtherAmount7, String offCampusOtherAmount8,
			String offCampusOtherDescription1, String offCampusOtherDescription2, String offCampusOtherDescription3,
			String offCampusOtherDescription4, String offCampusOtherDescription5, String offCampusOtherDescription6,
			String offCampusOtherDescription7, String offCampusOtherDescription8, String offCampusRoomBoard,
			String offCampusTravel, String onCampusOtherAmount1, String onCampusOtherAmount2,
			String onCampusOtherAmount3, String onCampusOtherAmount4, String onCampusOtherAmount5,
			String onCampusOtherAmount6, String onCampusOtherAmount7, String onCampusOtherAmount8,
			String onCampusOtherDescription1, String onCampusOtherDescription2, String onCampusOtherDescription3,
			String onCampusOtherDescription4, String onCampusOtherDescription5, String onCampusOtherDescription6,
			String onCampusOtherDescription7, String onCampusOtherDescription8, String onCampusRoomBoard,
			String onCampusTravel, String otherAmount1, String otherAmount2, String otherAmount3, String otherAmount4,
			String otherAmount5, String otherAmount6, String otherAmount7, String otherAmount8,
			String otherDescription1, String otherDescription2, String otherDescription3, String otherDescription4,
			String otherDescription5, String otherDescription6, String otherDescription7, String otherDescription8,
			String roomBoard, String travel, String tuition, String isModal) throws JsonProcessingException {

		NewEditBudgets Budgets = new NewEditBudgets();
		Budgets.id = (int) Math.round(Double.parseDouble(id));
		Budgets.books = (int) Math.round(Double.parseDouble(books));
		Budgets.campusGroupId = (int) Math.round(Double.parseDouble(campusGroupId));
		Budgets.code = code;
		Budgets.createdDateTime = createdDateTime;
		Budgets.institutionChargesCalcMethod = institutionChargesCalcMethod;
		Budgets.isActive = Boolean.parseBoolean(isActive);
		Budgets.isMonthlyBudget = Boolean.parseBoolean(isMonthlyBudget);
		Budgets.isOffCampusOtherCharge1Institutional = Boolean.parseBoolean(isOffCampusOtherCharge1Institutional);
		Budgets.isOffCampusOtherCharge2Institutional = Boolean.parseBoolean(isOffCampusOtherCharge2Institutional);
		Budgets.isOffCampusOtherCharge3Institutional = Boolean.parseBoolean(isOffCampusOtherCharge3Institutional);
		Budgets.isOffCampusOtherCharge4Institutional = Boolean.parseBoolean(isOffCampusOtherCharge4Institutional);
		Budgets.isOffCampusOtherCharge5Institutional = Boolean.parseBoolean(isOffCampusOtherCharge5Institutional);
		Budgets.isOffCampusOtherCharge6Institutional = Boolean.parseBoolean(isOffCampusOtherCharge6Institutional);
		Budgets.isOffCampusOtherCharge7Institutional = Boolean.parseBoolean(isOffCampusOtherCharge7Institutional);
		Budgets.isOffCampusOtherCharge8Institutional = Boolean.parseBoolean(isOffCampusOtherCharge8Institutional);
		Budgets.isOnCampusOtherCharge1Institutional = Boolean.parseBoolean(isOnCampusOtherCharge1Institutional);
		Budgets.isOnCampusOtherCharge2Institutional = Boolean.parseBoolean(isOnCampusOtherCharge2Institutional);
		Budgets.isOnCampusOtherCharge3Institutional = Boolean.parseBoolean(isOnCampusOtherCharge3Institutional);
		Budgets.isOnCampusOtherCharge4Institutional = Boolean.parseBoolean(isOnCampusOtherCharge4Institutional);
		Budgets.isOnCampusOtherCharge5Institutional = Boolean.parseBoolean(isOnCampusOtherCharge5Institutional);
		Budgets.isOnCampusOtherCharge6Institutional = Boolean.parseBoolean(isOnCampusOtherCharge6Institutional);
		Budgets.isOnCampusOtherCharge7Institutional = Boolean.parseBoolean(isOnCampusOtherCharge7Institutional);
		Budgets.isOnCampusOtherCharge8Institutional = Boolean.parseBoolean(isOnCampusOtherCharge8Institutional);
		Budgets.isOtherCharge1Institutional = Boolean.parseBoolean(isOtherCharge1Institutional);
		Budgets.isOtherCharge2Institutional = Boolean.parseBoolean(isOtherCharge2Institutional);
		Budgets.isOtherCharge3Institutional = Boolean.parseBoolean(isOtherCharge3Institutional);
		Budgets.isOtherCharge4Institutional = Boolean.parseBoolean(isOtherCharge4Institutional);
		Budgets.isOtherCharge5Institutional = Boolean.parseBoolean(isOtherCharge5Institutional);
		Budgets.isOtherCharge6Institutional = Boolean.parseBoolean(isOtherCharge6Institutional);
		Budgets.isOtherCharge7Institutional = Boolean.parseBoolean(isOtherCharge7Institutional);
		Budgets.isOtherCharge8Institutional = Boolean.parseBoolean(isOtherCharge8Institutional);
		Budgets.lastModifiedDateTime = lastModifiedDateTime;
		Budgets.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		Budgets.name = name;
		Budgets.offCampusOtherAmount1 = (int) Math.round(Double.parseDouble(offCampusOtherAmount1));
		Budgets.offCampusOtherAmount2 = (int) Math.round(Double.parseDouble(offCampusOtherAmount2));
		Budgets.offCampusOtherAmount3 = (int) Math.round(Double.parseDouble(offCampusOtherAmount3));
		Budgets.offCampusOtherAmount4 = (int) Math.round(Double.parseDouble(offCampusOtherAmount4));
		Budgets.offCampusOtherAmount5 = (int) Math.round(Double.parseDouble(offCampusOtherAmount5));
		Budgets.offCampusOtherAmount6 = (int) Math.round(Double.parseDouble(offCampusOtherAmount6));
		Budgets.offCampusOtherAmount7 = (int) Math.round(Double.parseDouble(offCampusOtherAmount7));
		Budgets.offCampusOtherAmount8 = (int) Math.round(Double.parseDouble(offCampusOtherAmount8));
		Budgets.offCampusOtherDescription1 = offCampusOtherDescription1;
		Budgets.offCampusOtherDescription2 = offCampusOtherDescription2;
		Budgets.offCampusOtherDescription3 = offCampusOtherDescription3;
		Budgets.offCampusOtherDescription4 = offCampusOtherDescription4;
		Budgets.offCampusOtherDescription5 = offCampusOtherDescription5;
		Budgets.offCampusOtherDescription6 = offCampusOtherDescription6;
		Budgets.offCampusOtherDescription7 = offCampusOtherDescription7;
		Budgets.offCampusOtherDescription8 = offCampusOtherDescription8;
		Budgets.offCampusRoomBoard = (int) Math.round(Double.parseDouble(offCampusRoomBoard));
		Budgets.offCampusTravel = (int) Math.round(Double.parseDouble(offCampusTravel));
		Budgets.onCampusOtherAmount1 = (int) Math.round(Double.parseDouble(onCampusOtherAmount1));
		Budgets.onCampusOtherAmount2 = (int) Math.round(Double.parseDouble(onCampusOtherAmount2));
		Budgets.onCampusOtherAmount3 = (int) Math.round(Double.parseDouble(onCampusOtherAmount3));
		Budgets.onCampusOtherAmount4 = (int) Math.round(Double.parseDouble(onCampusOtherAmount4));
		Budgets.onCampusOtherAmount5 = (int) Math.round(Double.parseDouble(onCampusOtherAmount5));
		Budgets.onCampusOtherAmount6 = (int) Math.round(Double.parseDouble(onCampusOtherAmount6));
		Budgets.onCampusOtherAmount7 = (int) Math.round(Double.parseDouble(onCampusOtherAmount7));
		Budgets.onCampusOtherAmount8 = (int) Math.round(Double.parseDouble(onCampusOtherAmount8));
		Budgets.onCampusOtherDescription1 = onCampusOtherDescription1;
		Budgets.onCampusOtherDescription2 = onCampusOtherDescription2;
		Budgets.onCampusOtherDescription3 = onCampusOtherDescription3;
		Budgets.onCampusOtherDescription4 = onCampusOtherDescription4;
		Budgets.onCampusOtherDescription5 = onCampusOtherDescription5;
		Budgets.onCampusOtherDescription6 = onCampusOtherDescription6;
		Budgets.onCampusOtherDescription7 = onCampusOtherDescription7;
		Budgets.onCampusOtherDescription8 = onCampusOtherDescription8;
		Budgets.onCampusRoomBoard = (int) Math.round(Double.parseDouble(onCampusRoomBoard));
		Budgets.onCampusTravel = (int) Math.round(Double.parseDouble(onCampusTravel));
		Budgets.otherAmount1 = (int) Math.round(Double.parseDouble(otherAmount1));
		Budgets.otherAmount2 = (int) Math.round(Double.parseDouble(otherAmount2));
		Budgets.otherAmount3 = (int) Math.round(Double.parseDouble(otherAmount3));
		Budgets.otherAmount4 = (int) Math.round(Double.parseDouble(otherAmount4));
		Budgets.otherAmount5 = (int) Math.round(Double.parseDouble(otherAmount5));
		Budgets.otherAmount6 = (int) Math.round(Double.parseDouble(otherAmount6));
		Budgets.otherAmount7 = (int) Math.round(Double.parseDouble(otherAmount7));
		Budgets.otherAmount8 = (int) Math.round(Double.parseDouble(otherAmount8));
		Budgets.otherDescription1 = otherDescription1;
		Budgets.otherDescription2 = otherDescription2;
		Budgets.otherDescription3 = otherDescription3;
		Budgets.otherDescription4 = otherDescription4;
		Budgets.otherDescription5 = otherDescription5;
		Budgets.otherDescription6 = otherDescription6;
		Budgets.otherDescription7 = otherDescription7;
		Budgets.otherDescription8 = otherDescription8;
		Budgets.roomBoard = (int) Math.round(Double.parseDouble(roomBoard));
		Budgets.rowVersion = null;
		Budgets.travel = (int) Math.round(Double.parseDouble(travel));
		Budgets.tuition = (int) Math.round(Double.parseDouble(tuition));
		Budgets.originalState = "";
		Budgets.secureState = "";
		Budgets.entityState = 0;
		Budgets.isModal = Boolean.parseBoolean(isModal);

		payload = new NewEditPayloadBudgets(Budgets);

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		System.out.println("Create Budgets payload: " + data);

		request.body(payload);

		response = request.post("/SaveNew");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		id_response_value = jsonPathEvaluator.getString("payload.data.id");

		name_response_value = jsonPathEvaluator.getString("payload.data.name");

		code_response_value = jsonPathEvaluator.getString("payload.data.code");

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(name_response_value, name);

		Assert.assertEquals(code_response_value, code);

	}

	@Test(priority = 2)
	public void GetEditBudgets() throws JsonProcessingException {

		Get_Budgets Budgets = new Get_Budgets();
		Budgets.id = (int) Math.round(Double.parseDouble(id_response_value));

		getpayload = new Get_Payload_Budgets(Budgets);

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getpayload);

		System.out.println("Get Edit Budgets payload: " + data);

		request.body(getpayload);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Assert.assertEquals(response.getStatusCode(), 200);

		rowVersion_response_value = jsonPathEvaluator.getString("payload.data.rowVersion");

	}

	@Test(dataProvider = "setEditData", priority = 3)
	public void EditRecordBudgets(String id, String books, String campusGroupId, String code, String createdDateTime,
			String institutionChargesCalcMethod, String isActive, String isMonthlyBudget,
			String isOffCampusOtherCharge1Institutional, String isOffCampusOtherCharge2Institutional,
			String isOffCampusOtherCharge3Institutional, String isOffCampusOtherCharge4Institutional,
			String isOffCampusOtherCharge5Institutional, String isOffCampusOtherCharge6Institutional,
			String isOffCampusOtherCharge7Institutional, String isOffCampusOtherCharge8Institutional,
			String isOnCampusOtherCharge1Institutional, String isOnCampusOtherCharge2Institutional,
			String isOnCampusOtherCharge3Institutional, String isOnCampusOtherCharge4Institutional,
			String isOnCampusOtherCharge5Institutional, String isOnCampusOtherCharge6Institutional,
			String isOnCampusOtherCharge7Institutional, String isOnCampusOtherCharge8Institutional,
			String isOtherCharge1Institutional, String isOtherCharge2Institutional, String isOtherCharge3Institutional,
			String isOtherCharge4Institutional, String isOtherCharge5Institutional, String isOtherCharge6Institutional,
			String isOtherCharge7Institutional, String isOtherCharge8Institutional, String lastModifiedDateTime,
			String lastModifiedUserId, String name, String offCampusOtherAmount1, String offCampusOtherAmount2,
			String offCampusOtherAmount3, String offCampusOtherAmount4, String offCampusOtherAmount5,
			String offCampusOtherAmount6, String offCampusOtherAmount7, String offCampusOtherAmount8,
			String offCampusOtherDescription1, String offCampusOtherDescription2, String offCampusOtherDescription3,
			String offCampusOtherDescription4, String offCampusOtherDescription5, String offCampusOtherDescription6,
			String offCampusOtherDescription7, String offCampusOtherDescription8, String offCampusRoomBoard,
			String offCampusTravel, String onCampusOtherAmount1, String onCampusOtherAmount2,
			String onCampusOtherAmount3, String onCampusOtherAmount4, String onCampusOtherAmount5,
			String onCampusOtherAmount6, String onCampusOtherAmount7, String onCampusOtherAmount8,
			String onCampusOtherDescription1, String onCampusOtherDescription2, String onCampusOtherDescription3,
			String onCampusOtherDescription4, String onCampusOtherDescription5, String onCampusOtherDescription6,
			String onCampusOtherDescription7, String onCampusOtherDescription8, String onCampusRoomBoard,
			String onCampusTravel, String otherAmount1, String otherAmount2, String otherAmount3, String otherAmount4,
			String otherAmount5, String otherAmount6, String otherAmount7, String otherAmount8,
			String otherDescription1, String otherDescription2, String otherDescription3, String otherDescription4,
			String otherDescription5, String otherDescription6, String otherDescription7, String otherDescription8,
			String roomBoard, String travel, String tuition, String isModal) throws JsonProcessingException {

		NewEditBudgets Budgets = new NewEditBudgets();
		Budgets.id = (int) Math.round(Double.parseDouble(id_response_value));
		Budgets.books = (int) Math.round(Double.parseDouble(books));
		Budgets.campusGroupId = (int) Math.round(Double.parseDouble(campusGroupId));
		Budgets.code = code;
		Budgets.createdDateTime = createdDateTime;
		Budgets.institutionChargesCalcMethod = institutionChargesCalcMethod;
		Budgets.isActive = Boolean.parseBoolean(isActive);
		Budgets.isMonthlyBudget = Boolean.parseBoolean(isMonthlyBudget);
		Budgets.isOffCampusOtherCharge1Institutional = Boolean.parseBoolean(isOffCampusOtherCharge1Institutional);
		Budgets.isOffCampusOtherCharge2Institutional = Boolean.parseBoolean(isOffCampusOtherCharge2Institutional);
		Budgets.isOffCampusOtherCharge3Institutional = Boolean.parseBoolean(isOffCampusOtherCharge3Institutional);
		Budgets.isOffCampusOtherCharge4Institutional = Boolean.parseBoolean(isOffCampusOtherCharge4Institutional);
		Budgets.isOffCampusOtherCharge5Institutional = Boolean.parseBoolean(isOffCampusOtherCharge5Institutional);
		Budgets.isOffCampusOtherCharge6Institutional = Boolean.parseBoolean(isOffCampusOtherCharge6Institutional);
		Budgets.isOffCampusOtherCharge7Institutional = Boolean.parseBoolean(isOffCampusOtherCharge7Institutional);
		Budgets.isOffCampusOtherCharge8Institutional = Boolean.parseBoolean(isOffCampusOtherCharge8Institutional);
		Budgets.isOnCampusOtherCharge1Institutional = Boolean.parseBoolean(isOnCampusOtherCharge1Institutional);
		Budgets.isOnCampusOtherCharge2Institutional = Boolean.parseBoolean(isOnCampusOtherCharge2Institutional);
		Budgets.isOnCampusOtherCharge3Institutional = Boolean.parseBoolean(isOnCampusOtherCharge3Institutional);
		Budgets.isOnCampusOtherCharge4Institutional = Boolean.parseBoolean(isOnCampusOtherCharge4Institutional);
		Budgets.isOnCampusOtherCharge5Institutional = Boolean.parseBoolean(isOnCampusOtherCharge5Institutional);
		Budgets.isOnCampusOtherCharge6Institutional = Boolean.parseBoolean(isOnCampusOtherCharge6Institutional);
		Budgets.isOnCampusOtherCharge7Institutional = Boolean.parseBoolean(isOnCampusOtherCharge7Institutional);
		Budgets.isOnCampusOtherCharge8Institutional = Boolean.parseBoolean(isOnCampusOtherCharge8Institutional);
		Budgets.isOtherCharge1Institutional = Boolean.parseBoolean(isOtherCharge1Institutional);
		Budgets.isOtherCharge2Institutional = Boolean.parseBoolean(isOtherCharge2Institutional);
		Budgets.isOtherCharge3Institutional = Boolean.parseBoolean(isOtherCharge3Institutional);
		Budgets.isOtherCharge4Institutional = Boolean.parseBoolean(isOtherCharge4Institutional);
		Budgets.isOtherCharge5Institutional = Boolean.parseBoolean(isOtherCharge5Institutional);
		Budgets.isOtherCharge6Institutional = Boolean.parseBoolean(isOtherCharge6Institutional);
		Budgets.isOtherCharge7Institutional = Boolean.parseBoolean(isOtherCharge7Institutional);
		Budgets.isOtherCharge8Institutional = Boolean.parseBoolean(isOtherCharge8Institutional);
		Budgets.lastModifiedDateTime = lastModifiedDateTime;
		Budgets.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		Budgets.name = name;
		Budgets.offCampusOtherAmount1 = (int) Math.round(Double.parseDouble(offCampusOtherAmount1));
		Budgets.offCampusOtherAmount2 = (int) Math.round(Double.parseDouble(offCampusOtherAmount2));
		Budgets.offCampusOtherAmount3 = (int) Math.round(Double.parseDouble(offCampusOtherAmount3));
		Budgets.offCampusOtherAmount4 = (int) Math.round(Double.parseDouble(offCampusOtherAmount4));
		Budgets.offCampusOtherAmount5 = (int) Math.round(Double.parseDouble(offCampusOtherAmount5));
		Budgets.offCampusOtherAmount6 = (int) Math.round(Double.parseDouble(offCampusOtherAmount6));
		Budgets.offCampusOtherAmount7 = (int) Math.round(Double.parseDouble(offCampusOtherAmount7));
		Budgets.offCampusOtherAmount8 = (int) Math.round(Double.parseDouble(offCampusOtherAmount8));
		Budgets.offCampusOtherDescription1 = offCampusOtherDescription1;
		Budgets.offCampusOtherDescription2 = offCampusOtherDescription2;
		Budgets.offCampusOtherDescription3 = offCampusOtherDescription3;
		Budgets.offCampusOtherDescription4 = offCampusOtherDescription4;
		Budgets.offCampusOtherDescription5 = offCampusOtherDescription5;
		Budgets.offCampusOtherDescription6 = offCampusOtherDescription6;
		Budgets.offCampusOtherDescription7 = offCampusOtherDescription7;
		Budgets.offCampusOtherDescription8 = offCampusOtherDescription8;
		Budgets.offCampusRoomBoard = (int) Math.round(Double.parseDouble(offCampusRoomBoard));
		Budgets.offCampusTravel = (int) Math.round(Double.parseDouble(offCampusTravel));
		Budgets.onCampusOtherAmount1 = (int) Math.round(Double.parseDouble(onCampusOtherAmount1));
		Budgets.onCampusOtherAmount2 = (int) Math.round(Double.parseDouble(onCampusOtherAmount2));
		Budgets.onCampusOtherAmount3 = (int) Math.round(Double.parseDouble(onCampusOtherAmount3));
		Budgets.onCampusOtherAmount4 = (int) Math.round(Double.parseDouble(onCampusOtherAmount4));
		Budgets.onCampusOtherAmount5 = (int) Math.round(Double.parseDouble(onCampusOtherAmount5));
		Budgets.onCampusOtherAmount6 = (int) Math.round(Double.parseDouble(onCampusOtherAmount6));
		Budgets.onCampusOtherAmount7 = (int) Math.round(Double.parseDouble(onCampusOtherAmount7));
		Budgets.onCampusOtherAmount8 = (int) Math.round(Double.parseDouble(onCampusOtherAmount8));
		Budgets.onCampusOtherDescription1 = onCampusOtherDescription1;
		Budgets.onCampusOtherDescription2 = onCampusOtherDescription2;
		Budgets.onCampusOtherDescription3 = onCampusOtherDescription3;
		Budgets.onCampusOtherDescription4 = onCampusOtherDescription4;
		Budgets.onCampusOtherDescription5 = onCampusOtherDescription5;
		Budgets.onCampusOtherDescription6 = onCampusOtherDescription6;
		Budgets.onCampusOtherDescription7 = onCampusOtherDescription7;
		Budgets.onCampusOtherDescription8 = onCampusOtherDescription8;
		Budgets.onCampusRoomBoard = (int) Math.round(Double.parseDouble(onCampusRoomBoard));
		Budgets.onCampusTravel = (int) Math.round(Double.parseDouble(onCampusTravel));
		Budgets.otherAmount1 = (int) Math.round(Double.parseDouble(otherAmount1));
		Budgets.otherAmount2 = (int) Math.round(Double.parseDouble(otherAmount2));
		Budgets.otherAmount3 = (int) Math.round(Double.parseDouble(otherAmount3));
		Budgets.otherAmount4 = (int) Math.round(Double.parseDouble(otherAmount4));
		Budgets.otherAmount5 = (int) Math.round(Double.parseDouble(otherAmount5));
		Budgets.otherAmount6 = (int) Math.round(Double.parseDouble(otherAmount6));
		Budgets.otherAmount7 = (int) Math.round(Double.parseDouble(otherAmount7));
		Budgets.otherAmount8 = (int) Math.round(Double.parseDouble(otherAmount8));
		Budgets.otherDescription1 = otherDescription1;
		Budgets.otherDescription2 = otherDescription2;
		Budgets.otherDescription3 = otherDescription3;
		Budgets.otherDescription4 = otherDescription4;
		Budgets.otherDescription5 = otherDescription5;
		Budgets.otherDescription6 = otherDescription6;
		Budgets.otherDescription7 = otherDescription7;
		Budgets.otherDescription8 = otherDescription8;
		Budgets.roomBoard = (int) Math.round(Double.parseDouble(roomBoard));
		Budgets.rowVersion = rowVersion_response_value;
		Budgets.travel = (int) Math.round(Double.parseDouble(travel));
		Budgets.tuition = (int) Math.round(Double.parseDouble(tuition));
		Budgets.originalState = "";
		Budgets.secureState = "";
		Budgets.entityState = UtilClass.edit_entityState;
		Budgets.isModal = Boolean.parseBoolean(isModal);

		payload = new NewEditPayloadBudgets(Budgets);

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		System.out.println("Edit Budgets payload: " + data);

		request.body(payload);

		response = request.post("/Save");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		name_response_value = jsonPathEvaluator.getString("payload.data.name");

		code_response_value = jsonPathEvaluator.getString("payload.data.code");

		Assert.assertEquals(name_response_value, name);

		Assert.assertEquals(code_response_value, code);
	}

	@Test(priority = 4)
	public void GetDeleteBudgets() throws JsonProcessingException {

		Get_Budgets Budgets = new Get_Budgets();
		Budgets.id = (int) Math.round(Double.parseDouble(id_response_value));

		getpayload = new Get_Payload_Budgets(Budgets);

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getpayload);

		System.out.println("Get Delete Budgets payload: " + data);

		request.body(getpayload);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		rowVersion_response_value = jsonPathEvaluator.getString("payload.data.rowVersion");

	}

	@Test(dataProvider = "setEditData", priority = 5)
	public void DeleteRecordBudgets(String id, String books, String campusGroupId, String code, String createdDateTime,
			String institutionChargesCalcMethod, String isActive, String isMonthlyBudget,
			String isOffCampusOtherCharge1Institutional, String isOffCampusOtherCharge2Institutional,
			String isOffCampusOtherCharge3Institutional, String isOffCampusOtherCharge4Institutional,
			String isOffCampusOtherCharge5Institutional, String isOffCampusOtherCharge6Institutional,
			String isOffCampusOtherCharge7Institutional, String isOffCampusOtherCharge8Institutional,
			String isOnCampusOtherCharge1Institutional, String isOnCampusOtherCharge2Institutional,
			String isOnCampusOtherCharge3Institutional, String isOnCampusOtherCharge4Institutional,
			String isOnCampusOtherCharge5Institutional, String isOnCampusOtherCharge6Institutional,
			String isOnCampusOtherCharge7Institutional, String isOnCampusOtherCharge8Institutional,
			String isOtherCharge1Institutional, String isOtherCharge2Institutional, String isOtherCharge3Institutional,
			String isOtherCharge4Institutional, String isOtherCharge5Institutional, String isOtherCharge6Institutional,
			String isOtherCharge7Institutional, String isOtherCharge8Institutional, String lastModifiedDateTime,
			String lastModifiedUserId, String name, String offCampusOtherAmount1, String offCampusOtherAmount2,
			String offCampusOtherAmount3, String offCampusOtherAmount4, String offCampusOtherAmount5,
			String offCampusOtherAmount6, String offCampusOtherAmount7, String offCampusOtherAmount8,
			String offCampusOtherDescription1, String offCampusOtherDescription2, String offCampusOtherDescription3,
			String offCampusOtherDescription4, String offCampusOtherDescription5, String offCampusOtherDescription6,
			String offCampusOtherDescription7, String offCampusOtherDescription8, String offCampusRoomBoard,
			String offCampusTravel, String onCampusOtherAmount1, String onCampusOtherAmount2,
			String onCampusOtherAmount3, String onCampusOtherAmount4, String onCampusOtherAmount5,
			String onCampusOtherAmount6, String onCampusOtherAmount7, String onCampusOtherAmount8,
			String onCampusOtherDescription1, String onCampusOtherDescription2, String onCampusOtherDescription3,
			String onCampusOtherDescription4, String onCampusOtherDescription5, String onCampusOtherDescription6,
			String onCampusOtherDescription7, String onCampusOtherDescription8, String onCampusRoomBoard,
			String onCampusTravel, String otherAmount1, String otherAmount2, String otherAmount3, String otherAmount4,
			String otherAmount5, String otherAmount6, String otherAmount7, String otherAmount8,
			String otherDescription1, String otherDescription2, String otherDescription3, String otherDescription4,
			String otherDescription5, String otherDescription6, String otherDescription7, String otherDescription8,
			String roomBoard, String travel, String tuition, String isModal) throws JsonProcessingException {

		NewEditBudgets Budgets = new NewEditBudgets();
		Budgets.id = (int) Math.round(Double.parseDouble(id_response_value));
		Budgets.books = (int) Math.round(Double.parseDouble(books));
		Budgets.campusGroupId = (int) Math.round(Double.parseDouble(campusGroupId));
		Budgets.code = code;
		Budgets.createdDateTime = createdDateTime;
		Budgets.institutionChargesCalcMethod = institutionChargesCalcMethod;
		Budgets.isActive = Boolean.parseBoolean(isActive);
		Budgets.isMonthlyBudget = Boolean.parseBoolean(isMonthlyBudget);
		Budgets.isOffCampusOtherCharge1Institutional = Boolean.parseBoolean(isOffCampusOtherCharge1Institutional);
		Budgets.isOffCampusOtherCharge2Institutional = Boolean.parseBoolean(isOffCampusOtherCharge2Institutional);
		Budgets.isOffCampusOtherCharge3Institutional = Boolean.parseBoolean(isOffCampusOtherCharge3Institutional);
		Budgets.isOffCampusOtherCharge4Institutional = Boolean.parseBoolean(isOffCampusOtherCharge4Institutional);
		Budgets.isOffCampusOtherCharge5Institutional = Boolean.parseBoolean(isOffCampusOtherCharge5Institutional);
		Budgets.isOffCampusOtherCharge6Institutional = Boolean.parseBoolean(isOffCampusOtherCharge6Institutional);
		Budgets.isOffCampusOtherCharge7Institutional = Boolean.parseBoolean(isOffCampusOtherCharge7Institutional);
		Budgets.isOffCampusOtherCharge8Institutional = Boolean.parseBoolean(isOffCampusOtherCharge8Institutional);
		Budgets.isOnCampusOtherCharge1Institutional = Boolean.parseBoolean(isOnCampusOtherCharge1Institutional);
		Budgets.isOnCampusOtherCharge2Institutional = Boolean.parseBoolean(isOnCampusOtherCharge2Institutional);
		Budgets.isOnCampusOtherCharge3Institutional = Boolean.parseBoolean(isOnCampusOtherCharge3Institutional);
		Budgets.isOnCampusOtherCharge4Institutional = Boolean.parseBoolean(isOnCampusOtherCharge4Institutional);
		Budgets.isOnCampusOtherCharge5Institutional = Boolean.parseBoolean(isOnCampusOtherCharge5Institutional);
		Budgets.isOnCampusOtherCharge6Institutional = Boolean.parseBoolean(isOnCampusOtherCharge6Institutional);
		Budgets.isOnCampusOtherCharge7Institutional = Boolean.parseBoolean(isOnCampusOtherCharge7Institutional);
		Budgets.isOnCampusOtherCharge8Institutional = Boolean.parseBoolean(isOnCampusOtherCharge8Institutional);
		Budgets.isOtherCharge1Institutional = Boolean.parseBoolean(isOtherCharge1Institutional);
		Budgets.isOtherCharge2Institutional = Boolean.parseBoolean(isOtherCharge2Institutional);
		Budgets.isOtherCharge3Institutional = Boolean.parseBoolean(isOtherCharge3Institutional);
		Budgets.isOtherCharge4Institutional = Boolean.parseBoolean(isOtherCharge4Institutional);
		Budgets.isOtherCharge5Institutional = Boolean.parseBoolean(isOtherCharge5Institutional);
		Budgets.isOtherCharge6Institutional = Boolean.parseBoolean(isOtherCharge6Institutional);
		Budgets.isOtherCharge7Institutional = Boolean.parseBoolean(isOtherCharge7Institutional);
		Budgets.isOtherCharge8Institutional = Boolean.parseBoolean(isOtherCharge8Institutional);
		Budgets.lastModifiedDateTime = lastModifiedDateTime;
		Budgets.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		Budgets.name = name;
		Budgets.offCampusOtherAmount1 = (int) Math.round(Double.parseDouble(offCampusOtherAmount1));
		Budgets.offCampusOtherAmount2 = (int) Math.round(Double.parseDouble(offCampusOtherAmount2));
		Budgets.offCampusOtherAmount3 = (int) Math.round(Double.parseDouble(offCampusOtherAmount3));
		Budgets.offCampusOtherAmount4 = (int) Math.round(Double.parseDouble(offCampusOtherAmount4));
		Budgets.offCampusOtherAmount5 = (int) Math.round(Double.parseDouble(offCampusOtherAmount5));
		Budgets.offCampusOtherAmount6 = (int) Math.round(Double.parseDouble(offCampusOtherAmount6));
		Budgets.offCampusOtherAmount7 = (int) Math.round(Double.parseDouble(offCampusOtherAmount7));
		Budgets.offCampusOtherAmount8 = (int) Math.round(Double.parseDouble(offCampusOtherAmount8));
		Budgets.offCampusOtherDescription1 = offCampusOtherDescription1;
		Budgets.offCampusOtherDescription2 = offCampusOtherDescription2;
		Budgets.offCampusOtherDescription3 = offCampusOtherDescription3;
		Budgets.offCampusOtherDescription4 = offCampusOtherDescription4;
		Budgets.offCampusOtherDescription5 = offCampusOtherDescription5;
		Budgets.offCampusOtherDescription6 = offCampusOtherDescription6;
		Budgets.offCampusOtherDescription7 = offCampusOtherDescription7;
		Budgets.offCampusOtherDescription8 = offCampusOtherDescription8;
		Budgets.offCampusRoomBoard = (int) Math.round(Double.parseDouble(offCampusRoomBoard));
		Budgets.offCampusTravel = (int) Math.round(Double.parseDouble(offCampusTravel));
		Budgets.onCampusOtherAmount1 = (int) Math.round(Double.parseDouble(onCampusOtherAmount1));
		Budgets.onCampusOtherAmount2 = (int) Math.round(Double.parseDouble(onCampusOtherAmount2));
		Budgets.onCampusOtherAmount3 = (int) Math.round(Double.parseDouble(onCampusOtherAmount3));
		Budgets.onCampusOtherAmount4 = (int) Math.round(Double.parseDouble(onCampusOtherAmount4));
		Budgets.onCampusOtherAmount5 = (int) Math.round(Double.parseDouble(onCampusOtherAmount5));
		Budgets.onCampusOtherAmount6 = (int) Math.round(Double.parseDouble(onCampusOtherAmount6));
		Budgets.onCampusOtherAmount7 = (int) Math.round(Double.parseDouble(onCampusOtherAmount7));
		Budgets.onCampusOtherAmount8 = (int) Math.round(Double.parseDouble(onCampusOtherAmount8));
		Budgets.onCampusOtherDescription1 = onCampusOtherDescription1;
		Budgets.onCampusOtherDescription2 = onCampusOtherDescription2;
		Budgets.onCampusOtherDescription3 = onCampusOtherDescription3;
		Budgets.onCampusOtherDescription4 = onCampusOtherDescription4;
		Budgets.onCampusOtherDescription5 = onCampusOtherDescription5;
		Budgets.onCampusOtherDescription6 = onCampusOtherDescription6;
		Budgets.onCampusOtherDescription7 = onCampusOtherDescription7;
		Budgets.onCampusOtherDescription8 = onCampusOtherDescription8;
		Budgets.onCampusRoomBoard = (int) Math.round(Double.parseDouble(onCampusRoomBoard));
		Budgets.onCampusTravel = (int) Math.round(Double.parseDouble(onCampusTravel));
		Budgets.otherAmount1 = (int) Math.round(Double.parseDouble(otherAmount1));
		Budgets.otherAmount2 = (int) Math.round(Double.parseDouble(otherAmount2));
		Budgets.otherAmount3 = (int) Math.round(Double.parseDouble(otherAmount3));
		Budgets.otherAmount4 = (int) Math.round(Double.parseDouble(otherAmount4));
		Budgets.otherAmount5 = (int) Math.round(Double.parseDouble(otherAmount5));
		Budgets.otherAmount6 = (int) Math.round(Double.parseDouble(otherAmount6));
		Budgets.otherAmount7 = (int) Math.round(Double.parseDouble(otherAmount7));
		Budgets.otherAmount8 = (int) Math.round(Double.parseDouble(otherAmount8));
		Budgets.otherDescription1 = otherDescription1;
		Budgets.otherDescription2 = otherDescription2;
		Budgets.otherDescription3 = otherDescription3;
		Budgets.otherDescription4 = otherDescription4;
		Budgets.otherDescription5 = otherDescription5;
		Budgets.otherDescription6 = otherDescription6;
		Budgets.otherDescription7 = otherDescription7;
		Budgets.otherDescription8 = otherDescription8;
		Budgets.roomBoard = (int) Math.round(Double.parseDouble(roomBoard));
		Budgets.rowVersion = rowVersion_response_value;
		Budgets.travel = (int) Math.round(Double.parseDouble(travel));
		Budgets.tuition = (int) Math.round(Double.parseDouble(tuition));
		Budgets.originalState = "";
		Budgets.secureState = "";
		Budgets.entityState = UtilClass.delete_entityState;
		Budgets.isModal = Boolean.parseBoolean(isModal);

		payload = new NewEditPayloadBudgets(Budgets);

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		System.out.println("Delete payload: " + data);

		request.body(payload);

		response = request.post("/Delete");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Assert.assertEquals(jsonPathEvaluator.getString("payload.deleted"), "true");

	}

	@DataProvider(name = "setNewData")
	public Object[][] setCreateData() {

		Object[][] data_New = { { "-1", "2", "516208", "Code", "2020/05/11 15:57:47", "B", "true", "false", "false",
				"false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false",
				"false", "false", "false", "false", "false", "false", "false", "false", "false", "false", "false",
				"false", "2020/05/11 15:57:47", "2", "NewBudgets189", "3", "4", "5", "4", "9", "9", "9", "9",
				"offCampusOtherDesc1", "offCampusOtherDesc2", "offCampusOtherDesc3", "offCampusOtherDesc4",
				"offCampusOtherDesc5", "offCampusOtherDesc6", "offCampusOtherDesc7", "offCampusOtherDesc8", "2", "3",
				"1", "2", "3", "4", "5", "6", "7", "8", "onCampusOtherDesc1", "onCampusOtherDesc2",
				"onCampusOtherDesc3", "onCampusOtherDesc4", "onCampusOtherDesc5", "onCampusOtherDesc6",
				"onCampusOtherDesc7", "onCampusOtherDesc8", "4", "5", "1", "2", "3", "4", "5", "6", "7", "8",
				"otherDesc1", "otherDesc2", "otherDesc3", "otherDesc4", "otherDesc5", "otherDesc6", "otherDesc7",
				"otherDesc8", "4", "5", "6", "false" } };

		return data_New;
	}

	@DataProvider(name = "setEditData")
	public Object[][] setEditData() {

		Object[][] data_New = { { "-1", "2", "516208", "CodeUpda", "2020/05/11 15:57:47", "B", "true", "true", "true",
				"true", "true", "true", "true", "true", "true", "true", "true", "true", "true", "true", "true", "true",
				"true", "true", "true", "true", "true", "true", "true", "true", "true", "true", "2020/05/11 15:57:47",
				"2", "NewBudgets189Update", "33", "45", "54", "45", "99", "99", "99", "99", "offCampusOtherDesc11",
				"offCampusOtherDesc22", "offCampusOtherDesc33", "offCampusOtherDesc45", "offCampusOtherDesc54",
				"offCampusOtherDesc66", "offCampusOtherDesc77", "offCampusOtherDesc88", "2", "3", "11", "22", "33",
				"45", "54", "66", "77", "88", "onCampusOtherDesc11", "onCampusOtherDesc22", "onCampusOtherDesc33",
				"onCampusOtherDesc45", "onCampusOtherDesc54", "onCampusOtherDesc66", "onCampusOtherDesc77",
				"onCampusOtherDesc88", "45", "54", "11", "22", "33", "45", "54", "66", "77", "88", "otherDesc11",
				"otherDesc22", "otherDesc33", "otherDesc45", "otherDesc54", "otherDesc66", "otherDesc77", "otherDesc88",
				"45", "54", "66", "false" } };

		return data_New;
	}

}
