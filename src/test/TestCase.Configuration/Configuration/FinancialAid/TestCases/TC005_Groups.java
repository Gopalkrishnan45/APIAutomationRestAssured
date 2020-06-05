package Configuration.FinancialAid.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
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
import com.student.TestData.UtilClass;

public class TC005_Groups extends BaseClass {

	ObjectMapper objMapper = new ObjectMapper();

	public static String id_responsepayload_data;
	public static String name_responsepayload_data;
	public static String rowVersion_responsepayload_data;

	@BeforeMethod
	public void SetUp() {

		String service_URL = "/api/commands/Common/StudentGroup";

		request = initialization(service_URL);

	}

	@Test(dataProvider = "setNewData", priority = 1)
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
		groups.entityState = 0;

		NewEditGroupsPayload groupspayload = new NewEditGroupsPayload();
		groupspayload.payload = groups;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(groupspayload);

		System.out.println("Create Groups Payload: " + data);

		request.body(groupspayload);

		response = request.post("/saveNew");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		id_responsepayload_data = jsonPathEvaluator.getString("payload.data.id");

		name_responsepayload_data = jsonPathEvaluator.getString("payload.data.name");

		Assert.assertEquals(name_responsepayload_data, name);

	}

	@Test(priority = 2)
	public void GetEditGroups() throws JsonProcessingException {

		GetGroups getGroups = new GetGroups();
		getGroups.id = (int) Math.round(Double.parseDouble(id_responsepayload_data));

		GetPayload getpayload = new GetPayload();
		getpayload.payload = getGroups;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getpayload);

		System.out.println("Get Groups Payload: " + data);

		request.body(getpayload);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(dataProvider = "setEditData", priority = 3)
	public void EditGroupsandAddStudentMember(String campusGroupId, String code, String createdDateTime,
			String expirationDate, String groupType, String isActive, String isPortalGroup, String isPublic,
			String isSprocQuery, String isTransferMonitoringGroup, String isUsedForAutoAwardCoa,
			String isUsedForAutoAwardRules, String lastModifiedDateTime, String lastModifiedUserId,
			String lastRefreshDate, String name, String ownerStaffId, String preserveManualAddedStudentsOnRefresh)
			throws JsonProcessingException {

		NewEditGroups groups = new NewEditGroups();
		groups.id = (int) Math.round(Double.parseDouble(id_responsepayload_data));
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
		groups.rowVersion = rowVersion_responsepayload_data;
		groups.sqlQuery = "";
		groups.viewQuery = null;
		groups.originalState = "";
		groups.secureState = "";
		groups.entityState = UtilClass.edit_entityState;

		NewEditGroupsPayload groupspayload = new NewEditGroupsPayload();
		groupspayload.payload = groups;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(groupspayload);

		System.out.println("Edit Groups Payload: " + data);

		request.body(groupspayload);

		response = request.post("/save");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		id_responsepayload_data = jsonPathEvaluator.getString("payload.data.id");

		name_responsepayload_data = jsonPathEvaluator.getString("payload.data.name");

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(name_responsepayload_data, name);

	}

	@Test(priority = 4)
	public void GetDeleteGroups() throws JsonProcessingException {

		GetGroups getGroups = new GetGroups();
		getGroups.id = (int) Math.round(Double.parseDouble(id_responsepayload_data));

		GetPayload getpayload = new GetPayload();
		getpayload.payload = getGroups;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getpayload);

		System.out.println("Get Groups for Delete :" + data);

		request.body(getpayload);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");

		System.out.println(jsonPathEvaluator.prettyPrint());

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(dataProvider = "setEditData", priority = 5)
	public void DeleteGroupsandAddStudentMember(String campusGroupId, String code, String createdDateTime,
			String expirationDate, String groupType, String isActive, String isPortalGroup, String isPublic,
			String isSprocQuery, String isTransferMonitoringGroup, String isUsedForAutoAwardCoa,
			String isUsedForAutoAwardRules, String lastModifiedDateTime, String lastModifiedUserId,
			String lastRefreshDate, String name, String ownerStaffId, String preserveManualAddedStudentsOnRefresh)
			throws JsonProcessingException {

		List<Object> staffAccess = new ArrayList<Object>();

		NewEditGroups groups = new NewEditGroups();
		groups.id = (int) Math.round(Double.parseDouble(id_responsepayload_data));
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
		groups.rowVersion = rowVersion_responsepayload_data;
		groups.sqlQuery = "";
		groups.viewQuery = null;
		groups.originalState = "";
		groups.secureState = "";
		groups.entityState = UtilClass.delete_entityState;
		groups.staffAccess = staffAccess;

		NewEditGroupsPayload groupspayload = new NewEditGroupsPayload();
		groupspayload.payload = groups;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(groupspayload);

		System.out.println("Delete Payload for Groups: " + data);

		request.body(groupspayload);

		response = request.post("/delete");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Assert.assertEquals(jsonPathEvaluator.getString("payload.deleted"), "true");

	}

	@DataProvider
	public Object[][] setNewData() {

		Object[][] data_NewGroups = { { "-1", "1", "Groups", "2020/05/14 18:35:51", "2063/05/14 18:35:51", "M", "true",
				"false", "true", "false", "false", "true", "true", "2020/05/14 18:35:51", "2", "2020/05/14 18:35:51",
				"!!!!!!!!!NewGroups", "2", "false" } };

		return data_NewGroups;
	}

	@DataProvider
	public Object[][] setEditData() {

		Object[][] data_EditGroups = { { "1", "Groups", "2020/05/14 18:35:51", "2063/05/14 18:35:51", "M", "true",
				"true", "true", "false", "true", "true", "true", "2020/05/14 18:35:51", "2", "2020/05/14 18:35:51",
				"!!!!!!!!!NewGroupsUPdate", "2", "false" } };

		return data_EditGroups;
	}
}
