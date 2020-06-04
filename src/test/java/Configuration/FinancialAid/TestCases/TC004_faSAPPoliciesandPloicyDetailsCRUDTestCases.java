package Configuration.FinancialAid.TestCases;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.BaseClass.BaseClass;
import com.student.Groups.GetGroups;
import com.student.Groups.GetPayload;
import com.student.Groups.NewEditGroups;
import com.student.Groups.NewEditGroupsPayload;
import com.student.SAPStatus.FaSapStatusStudentGroupList;
import com.student.SAPStatus.Get_Payload_faSAPStatus;
import com.student.SAPStatus.Get_faSAPStatus;
import com.student.SAPStatus.Payload;
import com.student.SAPStatus.PayloadSap;
import com.student.TestData.UtilClass;
import SAPPoliciesAndPolicyDetails.GetSAPPolicies;
import SAPPoliciesAndPolicyDetails.GetSAPPoliciesPayload;
import SAPPoliciesAndPolicyDetails.NewEditSAPPolicies;
import SAPPoliciesAndPolicyDetails.NewEditSAPPoliciesPayload;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC004_faSAPPoliciesandPloicyDetailsCRUDTestCases extends BaseClass {

	ObjectMapper objMapper = new ObjectMapper();

	public static RequestSpecification request2;
	public static RequestSpecification request3;
	public static RequestSpecification request4;

	public static String SAPStatusid_responsepayload_data;
	public static String SAPStatusrowVersion_responsepayload_data;

	public static String Groupsid_responsepayload_data;
	public static String GroupsrowVersion_responsepayload_data;

	public static String id_responsepayload_data;
	public static String name_responsepayload_data;
	public static String rowVersion_responsepayload_data;

	@BeforeMethod
	public void SetUp() {

		String service_URL = "/api/commands/FinancialAid/FaSapTable";

		String service_FaSapStatus_URL = "/api/commands/FinancialAid/FaSapStatus";

		String service_StudentGroup_URL = "/api/commands/Common/StudentGroup";

		request4 = initialization(service_URL);

		request2 = initialization(service_FaSapStatus_URL);

		request3 = initialization(service_StudentGroup_URL);

	}

	// New SAPStatus TestCases and get newly created SAPStatusid.
	@Test(dataProvider = "setNewSAPStatusData", priority = 1)
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
		payload.entityState = UtilClass.new_entityState;
		payload.faSapStatusStudentGroupList = fasaplist;

		PayloadSap payloadsap = new PayloadSap();
		payloadsap.payload = payload;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payloadsap);

		System.out.println(data);

		request2.body(payloadsap);

		response = request2.post("/SaveNew");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		SAPStatusid_responsepayload_data = jsonPathEvaluator.getString("payload.data.id");

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	// New Groups TestCases and get newly created Groupsid.
	@Test(dataProvider = "setNewGroupsData", priority = 2)
	public void CreateNewGroups(String id, String campusGroupId, String code, String createdDateTime,
			String expirationDate, String groupType, String isActive, String isPortalGroup, String isPublic,
			String isSprocQuery, String isTransferMonitoringGroup, String isUsedForAutoAwardCoa,
			String isUsedForAutoAwardRules, String lastModifiedDateTime, String lastModifiedUserId,
			String lastRefreshDate, String name, String ownerStaffId, String preserveManualAddedStudentsOnRefresh)
			throws JsonProcessingException {

		NewEditGroups groups = new NewEditGroups();
		groups.id = (int) Math.round(Double.parseDouble(id));
		groups.campusGroupId = (int) Math.round(Double.parseDouble(campusGroupId));
		groups.code = code;
		groups.createdDateTime = createdDateTime;
		groups.dataQueryIdentifier = null;
		groups.expirationDate = expirationDate;
		groups.groupType = groupType;
		groups.isActive = Boolean.parseBoolean(isActive);
		groups.isPortalGroup = Boolean.parseBoolean(isPortalGroup);
		groups.isPublic = Boolean.parseBoolean(isPublic);
		groups.isSprocQuery = Boolean.parseBoolean(isSprocQuery);
		groups.isTransferMonitoringGroup = Boolean.parseBoolean(isTransferMonitoringGroup);
		groups.isUsedForAutoAwardCoa = Boolean.parseBoolean(isUsedForAutoAwardCoa);
		groups.isUsedForAutoAwardRules = Boolean.parseBoolean(isUsedForAutoAwardRules);
		groups.jobFrequency = "";
		groups.lastModifiedDateTime = lastModifiedDateTime;
		groups.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		groups.lastRefreshDate = lastRefreshDate;
		groups.name = name;
		groups.ownerStaffId = (int) Math.round(Double.parseDouble(ownerStaffId));
		groups.preserveManualAddedStudentsOnRefresh = Boolean.parseBoolean(preserveManualAddedStudentsOnRefresh);
		groups.rowVersion = null;
		groups.sqlQuery = "";
		groups.viewQuery = null;
		groups.originalState = "";
		groups.secureState = "";
		groups.entityState = UtilClass.new_entityState;

		NewEditGroupsPayload groupspayload = new NewEditGroupsPayload();
		groupspayload.payload = groups;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(groupspayload);

		System.out.println(data);

		request3.body(groupspayload);

		response = request3.post("/saveNew");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Groupsid_responsepayload_data = jsonPathEvaluator.getString("payload.data.id");

	}

	// New SAPPolicies TestCases.
	@Test(dataProvider = "setNewSAPPpoliciesData", priority = 3)
	public void CreateSAPPolicies(String id, String code, String attHoursBasis, String createdDateTime, String isActive,
			String isConcurrentEnrollmentsUsed, String isMaxHoursValidated, String isPartialSapTermValidated,
			String isSystemCode, String isTransferCreditsExcluded, String lastModifiedDateTime,
			String lastModifiedUserId, String maxTimeFrame, String minimumPaymentPeriodAvg,
			String minimumPaymentPeriodGpa, String minimumTermAvg, String minimumTermGpa, String name,
			String paymentPeriodAvgOverride, String paymentPeriodGpaOverride, String termAvgOverride,
			String termGpaOverride, String unitBasis) throws JsonProcessingException {

		NewEditSAPPolicies newEditSAPpolicies = new NewEditSAPPolicies();
		newEditSAPpolicies.id = (int) Math.round(Double.parseDouble(id));
		newEditSAPpolicies.attHoursBasis = attHoursBasis;
		newEditSAPpolicies.code = code;
		newEditSAPpolicies.createdDateTime = createdDateTime;
		newEditSAPpolicies.faSapStatusId = (int) Math.round(Double.parseDouble(SAPStatusid_responsepayload_data));
		newEditSAPpolicies.isActive = Boolean.parseBoolean(isActive);
		newEditSAPpolicies.isConcurrentEnrollmentsUsed = Boolean.parseBoolean(isConcurrentEnrollmentsUsed);
		newEditSAPpolicies.isMaxHoursValidated = Boolean.parseBoolean(isMaxHoursValidated);
		newEditSAPpolicies.isPartialSapTermValidated = Boolean.parseBoolean(isPartialSapTermValidated);
		newEditSAPpolicies.isSystemCode = Boolean.parseBoolean(isSystemCode);
		newEditSAPpolicies.isTransferCreditsExcluded = Boolean.parseBoolean(isTransferCreditsExcluded);
		newEditSAPpolicies.lastModifiedDateTime = lastModifiedDateTime;
		newEditSAPpolicies.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		newEditSAPpolicies.maxTimeFrame = (int) Math.round(Double.parseDouble(maxTimeFrame));
		newEditSAPpolicies.minimumPaymentPeriodAvg = (int) Math.round(Double.parseDouble(minimumPaymentPeriodAvg));
		newEditSAPpolicies.minimumPaymentPeriodGpa = (int) Math.round(Double.parseDouble(minimumPaymentPeriodGpa));
		newEditSAPpolicies.minimumTermAvg = (int) Math.round(Double.parseDouble(minimumTermAvg));
		newEditSAPpolicies.minimumTermGpa = (int) Math.round(Double.parseDouble(minimumTermGpa));
		newEditSAPpolicies.name = name;
		newEditSAPpolicies.paymentPeriodAvgOverride = (int) Math.round(Double.parseDouble(paymentPeriodAvgOverride));
		newEditSAPpolicies.paymentPeriodGpaOverride = (int) Math.round(Double.parseDouble(paymentPeriodGpaOverride));
		newEditSAPpolicies.rowVersion = null;
		newEditSAPpolicies.schoolStatusId = null;
		newEditSAPpolicies.studentGroupId = (int) Math.round(Double.parseDouble(Groupsid_responsepayload_data));
		newEditSAPpolicies.termAvgOverride = (int) Math.round(Double.parseDouble(termAvgOverride));
		newEditSAPpolicies.termGpaOverride = (int) Math.round(Double.parseDouble(termGpaOverride));
		newEditSAPpolicies.unitBasis = unitBasis;
		newEditSAPpolicies.originalState = "";
		newEditSAPpolicies.secureState = "";
		newEditSAPpolicies.entityState = UtilClass.new_entityState;

		NewEditSAPPoliciesPayload payload = new NewEditSAPPoliciesPayload();
		payload.payload = newEditSAPpolicies;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		System.out.println("SAPPloicies New Payload: " + data);

		request4.body(payload);

		response = request4.post("/SaveNew");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		id_responsepayload_data = jsonPathEvaluator.getString("payload.data.id");

		name_responsepayload_data = jsonPathEvaluator.getString("payload.data.name");

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(name_responsepayload_data, name);

	}

	// Get SAPPolicies TestCases and get newly created SAPPoliciesid and rowVersion.
	@Test(priority = 4)
	public void GetEditSAPPolicies() throws JsonProcessingException {

		GetSAPPolicies getSAPPolicies = new GetSAPPolicies();
		getSAPPolicies.id = (int) Math.round(Double.parseDouble(id_responsepayload_data));

		GetSAPPoliciesPayload GetSAPPoliciesPayload = new GetSAPPoliciesPayload();
		GetSAPPoliciesPayload.payload = getSAPPolicies;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(GetSAPPoliciesPayload);

		System.out.println("Get SAPPolicies payload: " + data);

		request4.body(GetSAPPoliciesPayload);

		response = request4.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	// Edit SAPPolicies TestCases.
	@Test(dataProvider = "setEditSAPPpoliciesData", priority = 5)
	public void EditSAPPolicies(String code, String attHoursBasis, String createdDateTime, String isActive,
			String isConcurrentEnrollmentsUsed, String isMaxHoursValidated, String isPartialSapTermValidated,
			String isSystemCode, String isTransferCreditsExcluded, String lastModifiedDateTime,
			String lastModifiedUserId, String maxTimeFrame, String minimumPaymentPeriodAvg,
			String minimumPaymentPeriodGpa, String minimumTermAvg, String minimumTermGpa, String name,
			String paymentPeriodAvgOverride, String paymentPeriodGpaOverride, String termAvgOverride,
			String termGpaOverride, String unitBasis) throws JsonProcessingException {

		NewEditSAPPolicies newEditSAPpolicies = new NewEditSAPPolicies();
		newEditSAPpolicies.id = (int) Math.round(Double.parseDouble(id_responsepayload_data));
		newEditSAPpolicies.attHoursBasis = attHoursBasis;
		newEditSAPpolicies.code = code;
		newEditSAPpolicies.createdDateTime = createdDateTime;
		newEditSAPpolicies.faSapStatusId = (int) Math.round(Double.parseDouble(SAPStatusid_responsepayload_data));
		newEditSAPpolicies.isActive = Boolean.parseBoolean(isActive);
		newEditSAPpolicies.isConcurrentEnrollmentsUsed = Boolean.parseBoolean(isConcurrentEnrollmentsUsed);
		newEditSAPpolicies.isMaxHoursValidated = Boolean.parseBoolean(isMaxHoursValidated);
		newEditSAPpolicies.isPartialSapTermValidated = Boolean.parseBoolean(isPartialSapTermValidated);
		newEditSAPpolicies.isSystemCode = Boolean.parseBoolean(isSystemCode);
		newEditSAPpolicies.isTransferCreditsExcluded = Boolean.parseBoolean(isTransferCreditsExcluded);
		newEditSAPpolicies.lastModifiedDateTime = lastModifiedDateTime;
		newEditSAPpolicies.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		newEditSAPpolicies.maxTimeFrame = (int) Math.round(Double.parseDouble(maxTimeFrame));
		newEditSAPpolicies.minimumPaymentPeriodAvg = (int) Math.round(Double.parseDouble(minimumPaymentPeriodAvg));
		newEditSAPpolicies.minimumPaymentPeriodGpa = (int) Math.round(Double.parseDouble(minimumPaymentPeriodGpa));
		newEditSAPpolicies.minimumTermAvg = (int) Math.round(Double.parseDouble(minimumTermAvg));
		newEditSAPpolicies.minimumTermGpa = (int) Math.round(Double.parseDouble(minimumTermGpa));
		newEditSAPpolicies.name = name;
		newEditSAPpolicies.paymentPeriodAvgOverride = (int) Math.round(Double.parseDouble(paymentPeriodAvgOverride));
		newEditSAPpolicies.paymentPeriodGpaOverride = (int) Math.round(Double.parseDouble(paymentPeriodGpaOverride));
		newEditSAPpolicies.rowVersion = rowVersion_responsepayload_data;
		newEditSAPpolicies.schoolStatusId = null;
		newEditSAPpolicies.studentGroupId = (int) Math.round(Double.parseDouble(Groupsid_responsepayload_data));
		newEditSAPpolicies.termAvgOverride = (int) Math.round(Double.parseDouble(termAvgOverride));
		newEditSAPpolicies.termGpaOverride = (int) Math.round(Double.parseDouble(termGpaOverride));
		newEditSAPpolicies.unitBasis = unitBasis;
		newEditSAPpolicies.originalState = "";
		newEditSAPpolicies.secureState = "";
		newEditSAPpolicies.entityState = UtilClass.edit_entityState;

		NewEditSAPPoliciesPayload payload = new NewEditSAPPoliciesPayload();
		payload.payload = newEditSAPpolicies;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		System.out.println("SAPPloicies Edit Payload: " + data);

		request4.body(payload);

		response = request4.post("/Save");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		name_responsepayload_data = jsonPathEvaluator.getString("payload.data.name");

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(name_responsepayload_data, name);

	}

	// Get SAPPolicies TestCases and get edited SAPPoliciesid and rowVersion for
	// Delete.
	@Test(priority = 6)
	public void GetDeleteSAPPolicies() throws JsonProcessingException {

		GetSAPPolicies getSAPPolicies = new GetSAPPolicies();
		getSAPPolicies.id = (int) Math.round(Double.parseDouble(id_responsepayload_data));

		GetSAPPoliciesPayload GetSAPPoliciesPayload = new GetSAPPoliciesPayload();
		GetSAPPoliciesPayload.payload = getSAPPolicies;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(GetSAPPoliciesPayload);

		System.out.println("Get SAPPolicies payload: " + data);

		request4.body(GetSAPPoliciesPayload);

		response = request4.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	// Delete SAPPolicies TestCases.
	@Test(dataProvider = "setEditSAPPpoliciesData", priority = 7)
	public void DeleteAPPolicies(String code, String attHoursBasis, String createdDateTime, String isActive,
			String isConcurrentEnrollmentsUsed, String isMaxHoursValidated, String isPartialSapTermValidated,
			String isSystemCode, String isTransferCreditsExcluded, String lastModifiedDateTime,
			String lastModifiedUserId, String maxTimeFrame, String minimumPaymentPeriodAvg,
			String minimumPaymentPeriodGpa, String minimumTermAvg, String minimumTermGpa, String name,
			String paymentPeriodAvgOverride, String paymentPeriodGpaOverride, String termAvgOverride,
			String termGpaOverride, String unitBasis) throws JsonProcessingException {

		NewEditSAPPolicies newEditSAPpolicies = new NewEditSAPPolicies();
		newEditSAPpolicies.id = (int) Math.round(Double.parseDouble(id_responsepayload_data));
		newEditSAPpolicies.attHoursBasis = attHoursBasis;
		newEditSAPpolicies.code = code;
		newEditSAPpolicies.createdDateTime = createdDateTime;
		newEditSAPpolicies.faSapStatusId = (int) Math.round(Double.parseDouble(SAPStatusid_responsepayload_data));
		newEditSAPpolicies.isActive = Boolean.parseBoolean(isActive);
		newEditSAPpolicies.isConcurrentEnrollmentsUsed = Boolean.parseBoolean(isConcurrentEnrollmentsUsed);
		newEditSAPpolicies.isMaxHoursValidated = Boolean.parseBoolean(isMaxHoursValidated);
		newEditSAPpolicies.isPartialSapTermValidated = Boolean.parseBoolean(isPartialSapTermValidated);
		newEditSAPpolicies.isSystemCode = Boolean.parseBoolean(isSystemCode);
		newEditSAPpolicies.isTransferCreditsExcluded = Boolean.parseBoolean(isTransferCreditsExcluded);
		newEditSAPpolicies.lastModifiedDateTime = lastModifiedDateTime;
		newEditSAPpolicies.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		newEditSAPpolicies.maxTimeFrame = (int) Math.round(Double.parseDouble(maxTimeFrame));
		newEditSAPpolicies.minimumPaymentPeriodAvg = (int) Math.round(Double.parseDouble(minimumPaymentPeriodAvg));
		newEditSAPpolicies.minimumPaymentPeriodGpa = (int) Math.round(Double.parseDouble(minimumPaymentPeriodGpa));
		newEditSAPpolicies.minimumTermAvg = (int) Math.round(Double.parseDouble(minimumTermAvg));
		newEditSAPpolicies.minimumTermGpa = (int) Math.round(Double.parseDouble(minimumTermGpa));
		newEditSAPpolicies.name = name;
		newEditSAPpolicies.paymentPeriodAvgOverride = (int) Math.round(Double.parseDouble(paymentPeriodAvgOverride));
		newEditSAPpolicies.paymentPeriodGpaOverride = (int) Math.round(Double.parseDouble(paymentPeriodGpaOverride));
		newEditSAPpolicies.rowVersion = rowVersion_responsepayload_data;
		newEditSAPpolicies.schoolStatusId = null;
		newEditSAPpolicies.studentGroupId = (int) Math.round(Double.parseDouble(Groupsid_responsepayload_data));
		newEditSAPpolicies.termAvgOverride = (int) Math.round(Double.parseDouble(termAvgOverride));
		newEditSAPpolicies.termGpaOverride = (int) Math.round(Double.parseDouble(termGpaOverride));
		newEditSAPpolicies.unitBasis = unitBasis;
		newEditSAPpolicies.originalState = "";
		newEditSAPpolicies.secureState = "";
		newEditSAPpolicies.entityState = UtilClass.edit_entityState;

		NewEditSAPPoliciesPayload payload = new NewEditSAPPoliciesPayload();
		payload.payload = newEditSAPpolicies;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		System.out.println("SAPPloicies Edit Payload: " + data);

		request4.body(payload);

		response = request4.post("/Delete");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		String delete_responsepayload_data = jsonPathEvaluator.getString("payload.deleted");

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(delete_responsepayload_data, "true");

	}

	// Get Groups TestCases and get edited Groups and rowVersion for Delete.
	@Test(priority = 8)
	public void GetDeleteGroups() throws JsonProcessingException {

		GetGroups getGroups = new GetGroups();
		getGroups.id = (int) Math.round(Double.parseDouble(Groupsid_responsepayload_data));

		GetPayload getpayload = new GetPayload();
		getpayload.payload = getGroups;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getpayload);

		System.out.println("Get for Delete :" + data);

		request3.body(getpayload);

		response = request3.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		GroupsrowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");

		System.out.println(jsonPathEvaluator.prettyPrint());

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// Delete Groups TestCases.
	@Test(dataProvider = "setDeleteGroupsData", priority = 9)
	public void DeleteGroupsandAddStudentMember(String campusGroupId, String code, String createdDateTime,
			String expirationDate, String groupType, String isActive, String isPortalGroup, String isPublic,
			String isSprocQuery, String isTransferMonitoringGroup, String isUsedForAutoAwardCoa,
			String isUsedForAutoAwardRules, String lastModifiedDateTime, String lastModifiedUserId,
			String lastRefreshDate, String name, String ownerStaffId, String preserveManualAddedStudentsOnRefresh)
			throws JsonProcessingException {

		List<Object> staffAccess = new ArrayList<Object>();

		NewEditGroups groups = new NewEditGroups();
		groups.id = (int) Math.round(Double.parseDouble(Groupsid_responsepayload_data));
		groups.campusGroupId = (int) Math.round(Double.parseDouble(campusGroupId));
		groups.code = code;
		groups.createdDateTime = createdDateTime;
		groups.dataQueryIdentifier = null;
		groups.expirationDate = expirationDate;
		groups.groupType = groupType;
		groups.isActive = Boolean.parseBoolean(isActive);
		groups.isPortalGroup = Boolean.parseBoolean(isPortalGroup);
		groups.isPublic = Boolean.parseBoolean(isPublic);
		groups.isSprocQuery = Boolean.parseBoolean(isSprocQuery);
		groups.isTransferMonitoringGroup = Boolean.parseBoolean(isTransferMonitoringGroup);
		groups.isUsedForAutoAwardCoa = Boolean.parseBoolean(isUsedForAutoAwardCoa);
		groups.isUsedForAutoAwardRules = Boolean.parseBoolean(isUsedForAutoAwardRules);
		groups.jobFrequency = "";
		groups.lastModifiedDateTime = lastModifiedDateTime;
		groups.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		groups.lastRefreshDate = lastRefreshDate;
		groups.name = name;
		groups.ownerStaffId = (int) Math.round(Double.parseDouble(ownerStaffId));
		groups.preserveManualAddedStudentsOnRefresh = Boolean.parseBoolean(preserveManualAddedStudentsOnRefresh);
		groups.rowVersion = GroupsrowVersion_responsepayload_data;
		groups.sqlQuery = "";
		groups.viewQuery = null;
		groups.originalState = "";
		groups.secureState = "";
		groups.entityState = UtilClass.delete_entityState;
		groups.staffAccess = staffAccess;

		NewEditGroupsPayload groupspayload = new NewEditGroupsPayload();
		groupspayload.payload = groups;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(groupspayload);

		System.out.println("Delete Payload: " + data);

		request3.body(groupspayload);

		response = request3.post("/delete");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Assert.assertEquals(jsonPathEvaluator.getString("payload.deleted"), "true");

	}

	// Get SAPStatus TestCases and get edited SAPStatus and rowVersion for Delete.
	@Test(priority = 10)
	public void GetDeletefaSAPStatus() throws JsonProcessingException {

		Get_faSAPStatus get_faSAPStatus = new Get_faSAPStatus();
		get_faSAPStatus.id = (int) Math.round(Double.parseDouble(SAPStatusid_responsepayload_data));

		Get_Payload_faSAPStatus get_Payload_faSAPStatus = new Get_Payload_faSAPStatus();
		get_Payload_faSAPStatus.payload = get_faSAPStatus;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(get_Payload_faSAPStatus);

		System.out.println("Get Payload for Edit mode: " + data);

		request2.body(get_Payload_faSAPStatus);

		response = request2.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Assert.assertEquals(response.getStatusCode(), 200);

		SAPStatusrowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");

	}

	// Delete SAPStatus TestCases.
	@Test(dataProvider = "setDeleteModeData", priority = 11)
	public void DeletefaSAPStatus(String code, String createdDateTime, String excludeFromCalc, String isActive,
			String isSapMet, String isSystemCode, String lastModifiedDateTime, String lastModifiedUserId, String name)
			throws JsonProcessingException {

		List<FaSapStatusStudentGroupList> fasaplist = new ArrayList<FaSapStatusStudentGroupList>();

		Payload payload = new Payload();
		payload.id = (int) Math.round(Double.parseDouble(SAPStatusid_responsepayload_data));
		payload.code = code;
		payload.createdDateTime = createdDateTime;
		payload.excludeFromCalc = Boolean.parseBoolean(excludeFromCalc);
		payload.isActive = Boolean.parseBoolean(isActive);
		payload.isSapMet = Boolean.parseBoolean(isSapMet);
		payload.isSystemCode = Boolean.parseBoolean(isSystemCode);
		payload.lastModifiedDateTime = lastModifiedDateTime;
		payload.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		payload.name = name;
		payload.rowVersion = SAPStatusrowVersion_responsepayload_data;
		payload.originalState = "";
		payload.secureState = "";
		payload.entityState = UtilClass.delete_entityState;
		payload.faSapStatusStudentGroupList = fasaplist;

		PayloadSap payloadsap = new PayloadSap();
		payloadsap.payload = payload;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payloadsap);

		System.out.println(data);

		request2.body(payloadsap);

		response = request2.post("/Delete");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		String delete_value = jsonPathEvaluator.getString("payload.deleted");

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(delete_value, "true");
	}

	// New SAPPolicies Data
	@DataProvider
	public Object[][] setNewSAPPpoliciesData() {

		Object[][] data_NewSAPPpolicies = { { "-1", "SAPPOL", "A", "2020/05/15 23:40:39", "true", "false", "true",
				"true", "false", "true", "2020/05/15 23:40:39", "2", "150", "7", "6", "5", "2", "!!!!!!SAPPloicies",
				"99", "9", "5", "6", "H" } };

		return data_NewSAPPpolicies;
	}

	// Edit SAPPolicies Data
	@DataProvider
	public Object[][] setEditSAPPpoliciesData() {

		Object[][] data_NewSAPPpolicies = { { "SAPUPA", "A", "2020/05/15 23:40:39", "true", "false", "true", "true",
				"false", "true", "2020/05/15 23:40:39", "3", "150", "9", "9", "9", "9", "!!!!!!SAPPloiciesUpdate", "54",
				"9", "5", "6", "H" } };

		return data_NewSAPPpolicies;
	}

	// New SAPStatus Data
	@DataProvider
	public Object[][] setNewSAPStatusData() {

		Object[][] data_NewMode = { { "-1", "!!SAP!!", "2020/05/13 18:30:59", "false", "true", "false", "false",
				"2020/05/13 18:30:59", "2", "!!SAPNAME!!!!" } };

		return data_NewMode;
	}

	// Delete SAPStatus Data
	@DataProvider
	public Object[][] setDeleteModeData() {

		Object[][] data_NewMode = { { "SAPUpda", "2020/05/13 18:30:59", "false", "true", "false", "false",
				"2020/05/13 18:30:59", "2", "!!SAPNAMEUPDATE!!!!" } };

		return data_NewMode;
	}

	// New Groups Data
	@DataProvider
	public Object[][] setNewGroupsData() {

		Object[][] data_NewGroups = { { "-1", "1", "Groups", "2020/05/14 18:35:51", "2063/05/14 18:35:51", "M", "true",
				"false", "true", "false", "false", "true", "true", "2020/05/14 18:35:51", "2", "2020/05/14 18:35:51",
				"!!!!!!!!!NewGroups", "2", "false" } };

		return data_NewGroups;
	}

	// Delete Groups Data
	@DataProvider
	public Object[][] setDeleteGroupsData() {

		Object[][] data_EditGroups = { { "1", "Groups", "2020/05/14 18:35:51", "2063/05/14 18:35:51", "M", "true",
				"true", "true", "false", "true", "true", "true", "2020/05/14 18:35:51", "2", "2020/05/14 18:35:51",
				"!!!!!!!!!NewGroupsUPdate", "2", "false" } };

		return data_EditGroups;
	}
}