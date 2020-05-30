package com.student.Configuration.TestCases;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.BaseClass.BaseClass;
import com.student.Terms.DeletePayload;
import com.student.Terms.DeleteTermsCampusGroup;
import com.student.Terms.DeleteTermsCampusList;
import com.student.Terms.DeleteTermsPayload;
import com.student.Terms.GetTerms;
import com.student.Terms.GetTermsPayload;
import com.student.Terms.NewEditTerms;
import com.student.Terms.NewEditTermsPayload;
import com.student.TestData.UtilClass;

public class TC009_TermsCRUDTestCases extends BaseClass {

	ObjectMapper objMapper = new ObjectMapper();
	public static List<String> id_responsepayload_data = new ArrayList<String>();
	public static List<String> name_responsepayload_data = new ArrayList<String>();
	public static String name_responsepayload_editdata;
	public static String campusGroupId_responsepayload_data;
	public static String rowVersion_responsepayload_data;
	public static Object[][] data_excelNew;
	public static int Count_Edit;
	public static int Count_Delete;
	public static String file_Patch = "C:\\GopalBackUp\\WorkSpace\\APIRestAssuredToolsQA\\src\\main\\java\\TestDataFromExcel\\FreeCRMtestData.xlsx";

	@BeforeMethod
	public void SetUp() {

		String service_URL = prop.getProperty("ConfigurationAcademicRecordsTermSERVICESURL");

		request = initialization(service_URL);

	}

	@Test(dataProvider = "setNewTermsExcelData", priority = 1)
	public void CreateTerms(String code, String name, String startDate, String endDate, String faAcademicCalendar,
			String isStandardTerm, String standardTermType, String termUsage, String summerHeaderOrTrailer,
			String isChildTermDatesRuleEnforced, String revenueUnits, String isOnlineUsageAllowed, String isActive,
			String isAttendanceRecorded, String isExcludedCrmIntegration, String isGlobalExtractTerm,
			String isPrePullRequiredForGlobal, String isSapTerm, String isTermOpen,
			String isTermSuspendLiftedCampusLinkAmbassador, String lastModifiedDateTime, String lastModifiedUserId,
			String numberOfDaysAfterTermStartDate, String numberOfDaysPriorToTermStartDate,
			String sapCalcDaysAfterTermEnd, String scheduleChangesType, String sendCourseSectionDataInitialDoneToLms,
			String sendCourseSectionDataToLms, String sendInstructorAssignmentsInitialDoneToLms,
			String sendInstructorAssignmentsToLms, String sendStudentRegistrationDataInitialDoneToLms,
			String sendStudentRegistrationDataToLms, String shiftId, String createdDateTime)
			throws JsonProcessingException {

		List<Integer> CampusId = new ArrayList<Integer>();
		CampusId.add(5);

		NewEditTerms newEditTerms = new NewEditTerms();
		newEditTerms.id = -1;
		newEditTerms.campusGroupId = null;
		newEditTerms.addDropDate = null;
		newEditTerms.auditDesignationDeadline = null;
		newEditTerms.code = code;
		newEditTerms.courseRefundPolicyId = 0;
		newEditTerms.createdDateTime = createdDateTime;
		newEditTerms.startDate = startDate;
		newEditTerms.endDate = endDate;
		newEditTerms.isChildTermDatesRuleEnforced = Boolean.parseBoolean(isChildTermDatesRuleEnforced);
		newEditTerms.revenueUnits = (int) Math.round(Double.parseDouble(revenueUnits));
		newEditTerms.isOnlineUsageAllowed = Boolean.parseBoolean(isOnlineUsageAllowed);
		newEditTerms.faAcademicCalendar = faAcademicCalendar;
		newEditTerms.internalRegistrationBeginDateTime = null;
		newEditTerms.internalRegistrationEndDateTime = null;
		newEditTerms.isActive = Boolean.parseBoolean(isActive);
		newEditTerms.isAttendanceRecorded = Boolean.parseBoolean(isAttendanceRecorded);
		newEditTerms.isExcludedCrmIntegration = Boolean.parseBoolean(isExcludedCrmIntegration);
		newEditTerms.isGlobalExtractTerm = Boolean.parseBoolean(isGlobalExtractTerm);
		newEditTerms.isLdaRetainedUnregisteredCourses = null;
		newEditTerms.isPrePullRequiredForGlobal = Boolean.parseBoolean(isPrePullRequiredForGlobal);
		newEditTerms.isSapTerm = Boolean.parseBoolean(isSapTerm);
		newEditTerms.isStandardTerm = (int) Math.round(Double.parseDouble(isStandardTerm));
		newEditTerms.isTermOpen = Boolean.parseBoolean(isTermOpen);
		newEditTerms.isTermSuspendLiftedCampusLinkAmbassador = Boolean
				.parseBoolean(isTermSuspendLiftedCampusLinkAmbassador);
		newEditTerms.lastModifiedDateTime = lastModifiedDateTime;
		newEditTerms.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		newEditTerms.name = name;
		newEditTerms.numberOfDaysAfterTermStartDate = (int) Math
				.round(Double.parseDouble(numberOfDaysAfterTermStartDate));
		newEditTerms.numberOfDaysPriorToTermStartDate = (int) Math
				.round(Double.parseDouble(numberOfDaysPriorToTermStartDate));
		newEditTerms.numberOfDaysToRecalcNotification = "";
		newEditTerms.openRegistrationBeginDateTime = null;
		newEditTerms.openRegistrationEndDateTime = null;
		newEditTerms.rowVersion = null;
		newEditTerms.sapCalcDaysAfterTermEnd = (int) Math.round(Double.parseDouble(sapCalcDaysAfterTermEnd));
		newEditTerms.scheduleChangesType = "0";
		newEditTerms.sendCourseSectionDataInitialDoneToLms = Boolean
				.parseBoolean(sendCourseSectionDataInitialDoneToLms);
		newEditTerms.sendCourseSectionDataToLms = Boolean.parseBoolean(sendCourseSectionDataToLms);
		newEditTerms.sendInstructorAssignmentsInitialDoneToLms = Boolean
				.parseBoolean(sendInstructorAssignmentsInitialDoneToLms);
		newEditTerms.sendInstructorAssignmentsToLms = Boolean.parseBoolean(sendInstructorAssignmentsToLms);
		newEditTerms.sendStudentRegistrationDataInitialDoneToLms = Boolean
				.parseBoolean(sendStudentRegistrationDataInitialDoneToLms);
		newEditTerms.sendStudentRegistrationDataToLms = Boolean.parseBoolean(sendStudentRegistrationDataToLms);
		newEditTerms.shiftId = (int) Math.round(Double.parseDouble(shiftId));
		newEditTerms.standardTermType = standardTermType;
		newEditTerms.studentRegisterEndDate = null;
		newEditTerms.studentRegisterStartDate = null;
		newEditTerms.termGroupId = null;
		newEditTerms.termUsage = (int) Math.round(Double.parseDouble(termUsage));
		newEditTerms.summerHeaderOrTrailer = (int) Math.round(Double.parseDouble(summerHeaderOrTrailer));
		newEditTerms.entityState = UtilClass.new_entityState;
		newEditTerms.campusIdList = CampusId;

		NewEditTermsPayload newEditTermsPayload = new NewEditTermsPayload();
		newEditTermsPayload.payload = newEditTerms;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newEditTermsPayload);

		System.out.println(data);

		request.body(newEditTermsPayload);

		response = request.post("/SaveNew");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		String name_responsepayload = jsonPathEvaluator.getString("payload.data.name");

		id_responsepayload_data.add(jsonPathEvaluator.getString("payload.data.id"));

		name_responsepayload_data.add(jsonPathEvaluator.getString("payload.data.name"));

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(name_responsepayload, name);

	}

	@Test(dataProvider = "setEditTermsExcelData", priority = 2)
	public void EditTerms(String code, String name, String startDate, String endDate, String faAcademicCalendar,
			String isStandardTerm, String standardTermType, String summerHeaderOrTrailer,
			String isChildTermDatesRuleEnforced, String revenueUnits, String isOnlineUsageAllowed, String isActive,
			String isAttendanceRecorded, String isExcludedCrmIntegration, String isGlobalExtractTerm,
			String isPrePullRequiredForGlobal, String isSapTerm, String isTermOpen,
			String isTermSuspendLiftedCampusLinkAmbassador, String lastModifiedDateTime, String lastModifiedUserId,
			String numberOfDaysAfterTermStartDate, String numberOfDaysPriorToTermStartDate,
			String sapCalcDaysAfterTermEnd, String scheduleChangesType, String sendCourseSectionDataInitialDoneToLms,
			String sendCourseSectionDataToLms, String sendInstructorAssignmentsInitialDoneToLms,
			String sendInstructorAssignmentsToLms, String sendStudentRegistrationDataInitialDoneToLms,
			String sendStudentRegistrationDataToLms, String shiftId, String termUsage, String createdDateTime)
			throws JsonProcessingException {

		GetTerms getTerms = new GetTerms();
		getTerms.id = (int) Math.round(Double.parseDouble(id_responsepayload_data.get(Count_Edit)));

		GetTermsPayload getTermsPayload = new GetTermsPayload();
		getTermsPayload.payload = getTerms;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getTermsPayload);

		System.out.println(data);

		request.body(getTermsPayload);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");

		campusGroupId_responsepayload_data = jsonPathEvaluator.getString("payload.data.campusGroup.id");

		Assert.assertEquals(response.getStatusCode(), 200);

		// Edit payload building and Editing.

		List<Integer> CampusId = new ArrayList<Integer>();
		CampusId.add(5);

		NewEditTerms newEditTerms = new NewEditTerms();
		newEditTerms.id = (int) Math.round(Double.parseDouble(id_responsepayload_data.get(Count_Edit)));
		newEditTerms.campusGroupId = (int) Math.round(Double.parseDouble(campusGroupId_responsepayload_data));
		newEditTerms.addDropDate = null;
		newEditTerms.auditDesignationDeadline = null;
		newEditTerms.code = code;// 35
		newEditTerms.courseRefundPolicyId = 0;
		newEditTerms.createdDateTime = createdDateTime;// 34
		newEditTerms.startDate = startDate;// 33
		newEditTerms.endDate = endDate;// 32
		newEditTerms.isChildTermDatesRuleEnforced = Boolean.parseBoolean(isChildTermDatesRuleEnforced);// 31
		newEditTerms.revenueUnits = (int) Math.round(Double.parseDouble(revenueUnits));// 30
		newEditTerms.isOnlineUsageAllowed = Boolean.parseBoolean(isOnlineUsageAllowed);// 29
		newEditTerms.faAcademicCalendar = faAcademicCalendar;// 28
		newEditTerms.internalRegistrationBeginDateTime = null;
		newEditTerms.internalRegistrationEndDateTime = null;
		newEditTerms.isActive = Boolean.parseBoolean(isActive);// 27
		newEditTerms.isAttendanceRecorded = Boolean.parseBoolean(isAttendanceRecorded);// 26
		newEditTerms.isExcludedCrmIntegration = Boolean.parseBoolean(isExcludedCrmIntegration);// 25
		newEditTerms.isGlobalExtractTerm = Boolean.parseBoolean(isGlobalExtractTerm);// 24
		newEditTerms.isLdaRetainedUnregisteredCourses = null;
		newEditTerms.isPrePullRequiredForGlobal = Boolean.parseBoolean(isPrePullRequiredForGlobal);// 23
		newEditTerms.isSapTerm = Boolean.parseBoolean(isSapTerm);// 22
		newEditTerms.isStandardTerm = (int) Math.round(Double.parseDouble(isStandardTerm));// 21
		newEditTerms.isTermOpen = Boolean.parseBoolean(isTermOpen);// 20
		newEditTerms.isTermSuspendLiftedCampusLinkAmbassador = Boolean
				.parseBoolean(isTermSuspendLiftedCampusLinkAmbassador);// 19
		newEditTerms.lastModifiedDateTime = lastModifiedDateTime;// 18
		newEditTerms.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));// 17
		newEditTerms.name = name;// 16
		newEditTerms.numberOfDaysAfterTermStartDate = (int) Math
				.round(Double.parseDouble(numberOfDaysAfterTermStartDate));// 15
		newEditTerms.numberOfDaysPriorToTermStartDate = (int) Math
				.round(Double.parseDouble(numberOfDaysPriorToTermStartDate));// 14
		newEditTerms.numberOfDaysToRecalcNotification = "";// 13
		newEditTerms.openRegistrationBeginDateTime = null;
		newEditTerms.openRegistrationEndDateTime = null;
		newEditTerms.rowVersion = rowVersion_responsepayload_data;
		newEditTerms.sapCalcDaysAfterTermEnd = (int) Math.round(Double.parseDouble(sapCalcDaysAfterTermEnd));// 12
		newEditTerms.scheduleChangesType = "0";// 11
		newEditTerms.sendCourseSectionDataInitialDoneToLms = Boolean
				.parseBoolean(sendCourseSectionDataInitialDoneToLms);// 10
		newEditTerms.sendCourseSectionDataToLms = Boolean.parseBoolean(sendCourseSectionDataToLms);// 9
		newEditTerms.sendInstructorAssignmentsInitialDoneToLms = Boolean
				.parseBoolean(sendInstructorAssignmentsInitialDoneToLms);// 8
		newEditTerms.sendInstructorAssignmentsToLms = Boolean.parseBoolean(sendInstructorAssignmentsToLms);// 7
		newEditTerms.sendStudentRegistrationDataInitialDoneToLms = Boolean
				.parseBoolean(sendStudentRegistrationDataInitialDoneToLms);// 6
		newEditTerms.sendStudentRegistrationDataToLms = Boolean.parseBoolean(sendStudentRegistrationDataToLms);// 5
		newEditTerms.shiftId = (int) Math.round(Double.parseDouble(shiftId));// 4
		newEditTerms.standardTermType = standardTermType;// 3
		newEditTerms.studentRegisterEndDate = null;
		newEditTerms.studentRegisterStartDate = null;
		newEditTerms.termGroupId = null;
		newEditTerms.termUsage = (int) Math.round(Double.parseDouble(termUsage));// 2
		newEditTerms.summerHeaderOrTrailer = (int) Math.round(Double.parseDouble(summerHeaderOrTrailer));// 1
		newEditTerms.entityState = UtilClass.edit_entityState;
		newEditTerms.campusIdList = CampusId;

		NewEditTermsPayload newEditTermsPayload = new NewEditTermsPayload();
		newEditTermsPayload.payload = newEditTerms;

		String editPayLoadData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newEditTermsPayload);

		System.out.println(editPayLoadData);

		request.body(newEditTermsPayload);

		response = request.post("/Save");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		name_responsepayload_editdata = (jsonPathEvaluator.getString("payload.data.name"));

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(name_responsepayload_editdata, name);

		Count_Edit = Count_Edit + 1;
	}

	@Test(dataProvider = "setDeleteTerms", priority = 3)
	public void DeleteTerms(String Code, String startDate, String faAcademicCalendar, String endDate)
			throws JsonProcessingException {

		for (int i = 0; i < id_responsepayload_data.size(); i++) {

			GetTerms getTerms = new GetTerms();
			getTerms.id = (int) Math.round(Double.parseDouble(id_responsepayload_data.get(i)));

			GetTermsPayload getTermsPayload = new GetTermsPayload();
			getTermsPayload.payload = getTerms;

			String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getTermsPayload);

			System.out.println(data);

			request.body(getTermsPayload);

			response = request.post("/Get");

			body = response.getBody();

			jsonPathEvaluator = body.jsonPath();

			String terms_name = jsonPathEvaluator.getString("payload.data.name");

			rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");

			campusGroupId_responsepayload_data = jsonPathEvaluator.getString("payload.data.campusGroup.id");

			String code_CampusGroup = jsonPathEvaluator.getString("payload.data.campusGroup.code");

			String name_CampusGroup = jsonPathEvaluator.getString("payload.data.campusGroup.name");

			String rowVersion_CampusGroup = jsonPathEvaluator.getString("payload.data.campusGroup.rowVersion");

			int id_CampusList = (Integer) jsonPathEvaluator.getList("payload.data.campusGroup.campusList.id").get(0);

			String rowVersion_CampusList = (String) jsonPathEvaluator
					.getList("payload.data.campusGroup.campusList.rowVersion").get(0);

			Assert.assertEquals(response.getStatusCode(), 200);

			DeleteTermsCampusList deleteTermsCampusList = new DeleteTermsCampusList();
			deleteTermsCampusList.id = id_CampusList;
			deleteTermsCampusList.campusGroupId = (int) Math
					.round(Double.parseDouble(campusGroupId_responsepayload_data));
			deleteTermsCampusList.campusId = 5;
			deleteTermsCampusList.createdDateTime = "2020/05/29 01:18:26";
			deleteTermsCampusList.isCampusActive = true;
			deleteTermsCampusList.isSystemCode = false;
			deleteTermsCampusList.lastModifiedDateTime = "2020/05/29 01:18:26";
			deleteTermsCampusList.lastModifiedUserId = 34719;
			deleteTermsCampusList.rowVersion = rowVersion_CampusList;
			deleteTermsCampusList.originalState = "";
			deleteTermsCampusList.secureState = "";
			deleteTermsCampusList.entityState = 0;

			List<DeleteTermsCampusList> CampusList = new ArrayList<DeleteTermsCampusList>();
			CampusList.add(deleteTermsCampusList);

			DeleteTermsCampusGroup deleteTermsCampusGroup = new DeleteTermsCampusGroup();
			deleteTermsCampusGroup.id = (int) Math.round(Double.parseDouble(campusGroupId_responsepayload_data));
			deleteTermsCampusGroup.code = code_CampusGroup;
			deleteTermsCampusGroup.createdDateTime = "2020/05/29 01:18:26";
			deleteTermsCampusGroup.financialCampusGroup = false;
			deleteTermsCampusGroup.isActive = true;
			deleteTermsCampusGroup.isSystemCode = true;
			deleteTermsCampusGroup.lastModifiedDateTime = "2020/05/29 01:18:26";
			deleteTermsCampusGroup.lastModifiedUserId = 34719;
			deleteTermsCampusGroup.name = name_CampusGroup;
			deleteTermsCampusGroup.rowVersion = rowVersion_CampusGroup;
			deleteTermsCampusGroup.saStmtComments = null;
			deleteTermsCampusGroup.saStmtLastCloseDate = null;
			deleteTermsCampusGroup.type = "T";
			deleteTermsCampusGroup.originalState = "";
			deleteTermsCampusGroup.secureState = "";
			deleteTermsCampusGroup.entityState = 0;
			deleteTermsCampusGroup.campusList = CampusList;

			DeleteTermsPayload deleteTermsPayload = new DeleteTermsPayload();
			deleteTermsPayload.campusIdList = null;
			deleteTermsPayload.isExcludedCrmIntegration = false;
			deleteTermsPayload.id = (int) Math.round(Double.parseDouble(id_responsepayload_data.get(i)));
			deleteTermsPayload.addDropDate = null;
			deleteTermsPayload.auditDesignationDeadline = null;
			deleteTermsPayload.campusGroupId = (int) Math.round(Double.parseDouble(campusGroupId_responsepayload_data));
			deleteTermsPayload.code = Code;
			deleteTermsPayload.courseRefundPolicyId = 0;
			deleteTermsPayload.createdDateTime = "2020/05/29 01:18:26";
			deleteTermsPayload.endDate = endDate;
			deleteTermsPayload.faAcademicCalendar = (int) Math.round(Double.parseDouble(faAcademicCalendar));
			deleteTermsPayload.internalRegistrationBeginDateTime = null;
			deleteTermsPayload.internalRegistrationEndDateTime = null;
			deleteTermsPayload.isActive = true;
			deleteTermsPayload.isAttendanceRecorded = false;
			deleteTermsPayload.isChildTermDatesRuleEnforced = true;
			deleteTermsPayload.isGlobalExtractTerm = false;
			deleteTermsPayload.isLdaRetainedUnregisteredCourses = null;
			deleteTermsPayload.isOnlineUsageAllowed = false;
			deleteTermsPayload.isPrePullRequiredForGlobal = true;
			deleteTermsPayload.isSapTerm = true;
			deleteTermsPayload.isStandardTerm = 1;
			deleteTermsPayload.isTermOpen = true;
			deleteTermsPayload.isTermSuspendLiftedCampusLinkAmbassador = false;
			deleteTermsPayload.lastModifiedDateTime = "2020/05/29 01:18:26";
			deleteTermsPayload.lastModifiedUserId = 34719;
			deleteTermsPayload.name = terms_name;
			deleteTermsPayload.numberOfDaysAfterTermStartDate = 0;
			deleteTermsPayload.numberOfDaysPriorToTermStartDate = 0;
			deleteTermsPayload.numberOfDaysToRecalcNotification = null;
			deleteTermsPayload.openRegistrationBeginDateTime = null;
			deleteTermsPayload.openRegistrationEndDateTime = null;
			deleteTermsPayload.revenueUnits = 0;
			deleteTermsPayload.rowVersion = rowVersion_responsepayload_data;
			deleteTermsPayload.sapCalcDaysAfterTermEnd = 0;
			deleteTermsPayload.scheduleChangesType = "0";
			deleteTermsPayload.sendCourseSectionDataInitialDoneToLms = false;
			deleteTermsPayload.sendCourseSectionDataToLms = false;
			deleteTermsPayload.sendInstructorAssignmentsInitialDoneToLms = false;
			deleteTermsPayload.sendInstructorAssignmentsToLms = false;
			deleteTermsPayload.sendStudentRegistrationDataInitialDoneToLms = false;
			deleteTermsPayload.sendStudentRegistrationDataToLms = false;
			deleteTermsPayload.shiftId = 0;
			deleteTermsPayload.standardTermType = "U";
			deleteTermsPayload.startDate = startDate;
			deleteTermsPayload.studentRegisterEndDate = null;
			deleteTermsPayload.studentRegisterStartDate = null;
			deleteTermsPayload.summerHeaderOrTrailer = 1;
			deleteTermsPayload.termGroupId = null;
			deleteTermsPayload.termUsage = 7;
			deleteTermsPayload.originalState = "";
			deleteTermsPayload.secureState = "";
			deleteTermsPayload.entityState = UtilClass.delete_entityState;
			deleteTermsPayload.campusGroup = deleteTermsCampusGroup;

			DeletePayload deletePayload = new DeletePayload();
			deletePayload.payload = deleteTermsPayload;

			String dataDelete = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(deletePayload);

			System.out.println(dataDelete);

			request.body(deletePayload);

			response = request.post("/Delete");

			body = response.getBody();

			jsonPathEvaluator = body.jsonPath();

			Assert.assertEquals(jsonPathEvaluator.getString("payload.deleted"), "true");

		}

	}

	@DataProvider
	public Object[][] setDeleteTerms() {

		Object[][] setDeleteTerms = { { "QAAC419-20", "2019/09/01 00:00:00", "2", "2045/09/01 00:00:00" } };

		return setDeleteTerms;
	}

	@DataProvider
	public Object[][] setNewTerms() {

		Object[][] data_NewTerms = { { "!!!CODE", "2020/05/22 23:44:32", "2019/09/01 00:00:00", "2027/09/01 00:00:00",
				"true", "0", "false", "2", "true", "false", "false", "false", "false", "true", "1", "true", "false",
				"2020/05/22 23:44:32", "2", "!!!!Tracks1899", "0", "0", "0", "0", "false", "false", "false", "false",
				"false", "false", "0", "U", "7", "1" } };

		return data_NewTerms;
	}

	@DataProvider
	public Object[][] setEditTerms() {

		Object[][] setEditTerms = { { "!!!CODEUp", "2020/05/22 23:44:32", "2019/09/01 00:00:00", "2036/09/01 00:00:00",
				"true", "0", "false", "2", "true", "false", "false", "false", "false", "true", "1", "true", "false",
				"2020/05/22 23:44:32", "2", "!!!!Tracks1899Update", "0", "0", "0", "false", "false", "false", "false",
				"false", "false", "0", "U", "7", "1" } };

		return setEditTerms;
	}

	@DataProvider(name = "setNewTermsExcelData")
	public Object[][] setNewTermsexceldata() {

		data_excelNew = UtilClass.setData("1", file_Patch);

		return data_excelNew;
	}

	@DataProvider(name = "setEditTermsExcelData")
	public Object[][] setEditTermsExcelData() {

		Object[][] data_excelEdit = UtilClass.setData("2", file_Patch);

		return data_excelEdit;
	}
}
