package Configuration.AcademicRecords.TestCases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.AdPrograms.DeleteProgramsPayload;
import com.student.AdPrograms.GetPrograms;
import com.student.AdPrograms.GetProgramsPayload;
import com.student.AdPrograms.NewPrograms;
import com.student.AdPrograms.NewProgramsList;
import com.student.AdPrograms.NewProgramsPayload;
import com.student.BaseClass.BaseClass;
import com.student.TestData.UtilClass;

public class TC011_AdPrograms extends BaseClass {

	public static ObjectMapper objMapper = new ObjectMapper();
	public static String file_Path = "C:\\GopalBackUp\\WorkSpace\\APIRestAssuredToolsQA\\src\\main\\java\\TestDataFromExcel\\ProrgamsData.xlsx";
	public static String name_responsepayload_editdata;
	public static String code_responsepayload_editdata;
	public static List<String> Id_responsepayload_data = new ArrayList<String>();
	public static String rowVersion_responsepayload_data;
	public static Integer Count_Delete = 0;

	@BeforeMethod
	public void SetUp() {

		String service_URL = prop.getProperty("ConfigurationAcademicRecordsProgramsSERVICESURL");

		request = initialization(service_URL);

	}

	@Test(dataProvider = "setNewProgramsData", priority = 1)
	public void CreateAdPrograms(String cipCode, String name, String code, String isActive,
			String allowOnlineApplication, String isProgramGroupChanges, String isCIPCodeUpdateToProgramVersion,
			String isProgramVersionRecordFound, String isOverrideProgramGroupChanges)
			throws JsonProcessingException, SQLException {

		String programGroupSQLQuary = "Select AdProgramGroupid,* from AdProgramGroup";

		List<String> programGroupList = new ArrayList<String>();
		programGroupList = SelectQuaryfromDatabase(programGroupSQLQuary);

		List<Integer> programGroupIds = new ArrayList<Integer>();
		programGroupIds.add((int) Math.round(Double.parseDouble(programGroupList.get(0))));

		// ======================================

		String currectCIPCODESQLQuary = "Select AdCIPCodeYearId,* from AdCIPCodeYear where CIPCode like '01.00'";
		List<String> currectCIPCODEList = new ArrayList<String>();
		currectCIPCODEList = SelectQuaryfromDatabase(currectCIPCODESQLQuary);

		// ======================================

		NewProgramsList newProgramsList = new NewProgramsList();
		newProgramsList.isExcludedCrmIntegration = false;
		newProgramsList.programGroupIds = programGroupIds;
		newProgramsList.documentTypeIds = null;
		newProgramsList.requirementRuleIds = null;
		newProgramsList.id = -1;
		newProgramsList.allowOnlineApplications = Boolean.parseBoolean(allowOnlineApplication);
		newProgramsList.cipCode = cipCode;
		newProgramsList.code = code;
		newProgramsList.createdDateTime = "2020/05/30 21:35:36";
		newProgramsList.currentYearCipCodeId = (int) Math.round(Double.parseDouble(currectCIPCODEList.get(0)));
		newProgramsList.isActive = Boolean.parseBoolean(isActive);
		newProgramsList.lastModifiedDateTime = "2020/05/30 21:35:36";
		newProgramsList.lastModifiedUserId = 34719;
		newProgramsList.name = name;
		newProgramsList.rowVersion = null;
		newProgramsList.originalState = "";
		newProgramsList.secureState = "";
		newProgramsList.entityState = UtilClass.new_entityState;

		List<NewProgramsList> newProgramsArrayList = new ArrayList<NewProgramsList>();
		newProgramsArrayList.add(newProgramsList);

		NewPrograms newPrograms = new NewPrograms();
		newPrograms.programId = -1;
		newPrograms.cipCode = cipCode;
		newPrograms.currentYearCipCodeId = (int) Math.round(Double.parseDouble(currectCIPCODEList.get(0)));
		newPrograms.name = name;
		newPrograms.code = code;
		newPrograms.isActive = Boolean.parseBoolean(isActive);
		newPrograms.allowOnlineApplication = Boolean.parseBoolean(allowOnlineApplication);
		newPrograms.isProgramGroupChanges = Boolean.parseBoolean(isProgramGroupChanges);
		newPrograms.isCIPCodeUpdateToProgramVersion = Boolean.parseBoolean(isCIPCodeUpdateToProgramVersion);
		newPrograms.isProgramVersionRecordFound = Boolean.parseBoolean(isProgramVersionRecordFound);
		newPrograms.isOverrideProgramGroupChanges = Boolean.parseBoolean(isOverrideProgramGroupChanges);
		newPrograms.entityState = UtilClass.new_entityState;
		newPrograms.documentTypeIds = null;
		newPrograms.programGroupIds = programGroupIds;
		newPrograms.requirementRuleIds = null;
		newPrograms.programs = newProgramsArrayList;

		NewProgramsPayload newProgramsPayload = new NewProgramsPayload();
		newProgramsPayload.payload = newPrograms;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newProgramsPayload);

		System.out.println("Create Payload for Programs:" +data);

		request.body(newProgramsPayload);

		response = request.post("/SaveProgram");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Id_responsepayload_data.add(jsonPathEvaluator.getString("payload.data.program.id"));

		name_responsepayload_editdata = jsonPathEvaluator.getString("payload.data.program.name");

		code_responsepayload_editdata = jsonPathEvaluator.getString("payload.data.program.code");

		Assert.assertEquals(name_responsepayload_editdata, name);

		Assert.assertEquals(code_responsepayload_editdata, code);

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(dataProvider = "setNewProgramsData", priority = 2)
	public void CodeAlreadyExistsValidationAdPrograms(String cipCode, String name, String code, String isActive,
			String allowOnlineApplication, String isProgramGroupChanges, String isCIPCodeUpdateToProgramVersion,
			String isProgramVersionRecordFound, String isOverrideProgramGroupChanges)
			throws JsonProcessingException, SQLException {

		String programGroupSQLQuary = "Select AdProgramGroupid,* from AdProgramGroup";

		List<String> programGroupList = new ArrayList<String>();
		programGroupList = SelectQuaryfromDatabase(programGroupSQLQuary);

		List<Integer> programGroupIds = new ArrayList<Integer>();
		programGroupIds.add((int) Math.round(Double.parseDouble(programGroupList.get(0))));

		// ======================================

		String currectCIPCODESQLQuary = "Select AdCIPCodeYearId,* from AdCIPCodeYear where CIPCode like '01.00'";
		List<String> currectCIPCODEList = new ArrayList<String>();
		currectCIPCODEList = SelectQuaryfromDatabase(currectCIPCODESQLQuary);

		// ======================================

		NewProgramsList newProgramsList = new NewProgramsList();
		newProgramsList.isExcludedCrmIntegration = false;
		newProgramsList.programGroupIds = programGroupIds;
		newProgramsList.documentTypeIds = null;
		newProgramsList.requirementRuleIds = null;
		newProgramsList.id = -1;
		newProgramsList.allowOnlineApplications = Boolean.parseBoolean(allowOnlineApplication);
		newProgramsList.cipCode = cipCode;
		newProgramsList.code = code;
		newProgramsList.createdDateTime = "2020/05/30 21:35:36";
		newProgramsList.currentYearCipCodeId = (int) Math.round(Double.parseDouble(currectCIPCODEList.get(0)));
		newProgramsList.isActive = Boolean.parseBoolean(isActive);
		newProgramsList.lastModifiedDateTime = "2020/05/30 21:35:36";
		newProgramsList.lastModifiedUserId = 34719;
		newProgramsList.name = name;
		newProgramsList.rowVersion = null;
		newProgramsList.originalState = "";
		newProgramsList.secureState = "";
		newProgramsList.entityState = UtilClass.new_entityState;

		List<NewProgramsList> newProgramsArrayList = new ArrayList<NewProgramsList>();
		newProgramsArrayList.add(newProgramsList);

		NewPrograms newPrograms = new NewPrograms();
		newPrograms.programId = -1;
		newPrograms.cipCode = cipCode;
		newPrograms.currentYearCipCodeId = (int) Math.round(Double.parseDouble(currectCIPCODEList.get(0)));
		newPrograms.name = name;
		newPrograms.code = code;
		newPrograms.isActive = Boolean.parseBoolean(isActive);
		newPrograms.allowOnlineApplication = Boolean.parseBoolean(allowOnlineApplication);
		newPrograms.isProgramGroupChanges = Boolean.parseBoolean(isProgramGroupChanges);
		newPrograms.isCIPCodeUpdateToProgramVersion = Boolean.parseBoolean(isCIPCodeUpdateToProgramVersion);
		newPrograms.isProgramVersionRecordFound = Boolean.parseBoolean(isProgramVersionRecordFound);
		newPrograms.isOverrideProgramGroupChanges = Boolean.parseBoolean(isOverrideProgramGroupChanges);
		newPrograms.entityState = UtilClass.new_entityState;
		newPrograms.documentTypeIds = null;
		newPrograms.programGroupIds = programGroupIds;
		newPrograms.requirementRuleIds = null;
		newPrograms.programs = newProgramsArrayList;

		NewProgramsPayload newProgramsPayload = new NewProgramsPayload();
		newProgramsPayload.payload = newPrograms;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newProgramsPayload);

		System.out.println("Create Payload for Programs Code Validation:" + data);

		request.body(newProgramsPayload);

		response = request.post("/SaveProgram");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		String Code_alreadyexists_message = (String) jsonPathEvaluator.getList("notifications.message").get(0);

		String actaul_Code_alreadyexists_message = "The " + code + " Program code is already in use.";

		Assert.assertEquals(Code_alreadyexists_message, actaul_Code_alreadyexists_message);

	}

	@Test(dataProvider = "setDeleteProgramData", priority = 3)
	public void GetandDeleteAdPrograms(String cipCode, String name, String code, String isActive,
			String allowOnlineApplication) throws JsonProcessingException, SQLException {

		String currectCIPCODESQLQuary = "Select AdCIPCodeYearId,* from AdCIPCodeYear where CIPCode like '01.00'";
		List<String> currectCIPCODEList = new ArrayList<String>();
		currectCIPCODEList = SelectQuaryfromDatabase(currectCIPCODESQLQuary);

		// ======================================

		GetPrograms getPrograms = new GetPrograms();
		getPrograms.id = (int) Math.round(Double.parseDouble(Id_responsepayload_data.get(Count_Delete)));

		GetProgramsPayload getProgramsPayload = new GetProgramsPayload();
		getProgramsPayload.payload = getPrograms;

		String data_get = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getProgramsPayload);

		System.out.println("Get Payload for Delete:" +data_get);

		request.body(getProgramsPayload);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");

		NewProgramsList newProgramsList = new NewProgramsList();
		newProgramsList.isExcludedCrmIntegration = false;
		newProgramsList.programGroupIds = null;
		newProgramsList.documentTypeIds = null;
		newProgramsList.requirementRuleIds = null;
		newProgramsList.id = (int) Math.round(Double.parseDouble(Id_responsepayload_data.get(Count_Delete)));
		newProgramsList.allowOnlineApplications = Boolean.parseBoolean(allowOnlineApplication);
		newProgramsList.cipCode = cipCode;
		newProgramsList.code = code;
		newProgramsList.createdDateTime = "2020/05/30 21:35:36";
		newProgramsList.currentYearCipCodeId = (int) Math.round(Double.parseDouble(currectCIPCODEList.get(0)));
		newProgramsList.isActive = Boolean.parseBoolean(isActive);
		newProgramsList.lastModifiedDateTime = "2020/05/30 21:35:36";
		newProgramsList.lastModifiedUserId = 34719;
		newProgramsList.name = name;
		newProgramsList.rowVersion = rowVersion_responsepayload_data;
		newProgramsList.originalState = "";
		newProgramsList.secureState = "";
		newProgramsList.entityState = UtilClass.delete_entityState;

		DeleteProgramsPayload deleteProgramsPayload = new DeleteProgramsPayload();
		deleteProgramsPayload.payload = newProgramsList;

		String payload_delete = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(deleteProgramsPayload);

		System.out.println(payload_delete);

		request.body(deleteProgramsPayload);

		response = request.post("/Delete");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		String delete_message = jsonPathEvaluator.getString("payload.deleted");

		Assert.assertEquals(delete_message, "true");

		Assert.assertEquals(response.getStatusCode(), 200);

		Count_Delete = Count_Delete + 1;

	}

	@DataProvider
	public Object[][] setNewProgramsData() {

		Object[][] data_NewPrograms = UtilClass.setData("0", file_Path);

		return data_NewPrograms;
	}

	@DataProvider
	public Object[][] setDeleteProgramData() {

		Object[][] data_DeletePrograms = UtilClass.setData("1", file_Path);

		return data_DeletePrograms;
	}
}
