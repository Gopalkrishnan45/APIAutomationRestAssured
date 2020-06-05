package Configuration.AcademicRecords.TestCases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.AdProgramVersions.GetProgramVersions;
import com.student.AdProgramVersions.GetProgramVersionsPayload;
import com.student.AdProgramVersions.NewEditAdProgramVersionPayload;
import com.student.AdProgramVersions.NewEditAdProgramVersions;
import com.student.AdProgramVersions.NewEditAdProgramVersionsCampusList;
import com.student.BaseClass.BaseClass;
import com.student.TestData.UtilClass;

import junit.framework.Assert;

public class TC012_AdAdProgramVersionsCRUDTestCase extends BaseClass {

	public static ObjectMapper objMapper = new ObjectMapper();
	public static String ExcelSheet_FilePatch = "C:\\GopalBackUp\\WorkSpace\\APIRestAssuredToolsQA\\src\\main\\BaseClasses\\TestDataFromExcel\\AdProgramVersions.xlsx";
	public static String name_responsepayload_editdata;
	public static String code_responsepayload_editdata;
	public static String campusGroupId_responsepayload_editdata;
	public static List<String> Id_responsepayload_data = new ArrayList<String>();
	public static String rowVersion_responsepayload_data;
	public static Integer Count_Delete = 0;
	public static List<String> adProgramList = new ArrayList<String>();
	public static List<String> currectCIPCODEList = new ArrayList<String>();
	public static List<String> adGradeScaleList = new ArrayList<String>();
	public static List<String> adGradeLevelPromotionList = new ArrayList<String>();
	public static List<String> addegreeList = new ArrayList<String>();
	public static List<String> adSapTableList = new ArrayList<String>();
	public static List<String> programGroupList = new ArrayList<String>();

	@BeforeClass
	public void RunSQLQuary() throws SQLException {

		// =================AdProgram=====================

		String adProgramSQLQuary = "Select AdProgramID,* from AdProgram where AdProgramID=374";

		adProgramList = SelectQuaryfromDatabase(adProgramSQLQuary);

		// ================AdCIPCodeYear======================

		String currectCIPCODESQLQuary = "Select AdCIPCodeYearId,* from AdCIPCodeYear where CIPCode like '01.00'";

		currectCIPCODEList = SelectQuaryfromDatabase(currectCIPCODESQLQuary);

		// =================AdGradeScale=====================

		String adGradeScaleSQLQuary = "Select AdGradeScaleID,* from AdGradeScale";

		adGradeScaleList = SelectQuaryfromDatabase(adGradeScaleSQLQuary);

		// =================AdGradeLevelPromotion=====================

		String adGradeLevelPromotionSQLQuary = "Select AdGradeLevelPromotionID,* from AdGradeLevelPromotion";

		adGradeLevelPromotionList = SelectQuaryfromDatabase(adGradeLevelPromotionSQLQuary);

		// ==================addegree====================

		String addegreeSQLQuary = "Select AdDegreeID,* from addegree";

		addegreeList = SelectQuaryfromDatabase(addegreeSQLQuary);

		// ===================AdSapTable===================

		String adSapTableSQLQuary = "Select AdSapTableID,* from AdSapTable";

		adSapTableList = SelectQuaryfromDatabase(adSapTableSQLQuary);

		// ==============================AdProgramGroup====================================

		String programGroupSQLQuary = "Select AdProgramGroupid,* from AdProgramGroup";

		programGroupList = SelectQuaryfromDatabase(programGroupSQLQuary);

	}

	@BeforeMethod
	public void SetUp() {

		String service_URL = prop.getProperty("ConfigurationAcademicRecordsAdProgramVersionsSERVICESURL");

		request = initialization(service_URL);

	}

	@Test(dataProvider = "setNewProgramVersionData", priority = 1)
	public void CreateProgramVersion(String code, String name, String creditHoursRequired, String clockHoursRequired,
			String expectedCreditsPerTerm, String fullTimeMin, String halfTimeMin, String lessThanHalfTimeMin,
			String threeQuarterrTimeMin, String totalMonths, String totalWeeks, String transcriptDescription,
			String minimumGpa, String programLengthType, String programLengthValue, String programVersionUnitType,
			String isExcludedCrmIntegration, String isHoursPerYear, String activeUnits, String activeWhen,
			String campusLicenseUnit, String cipCode, String defaultSpecialProgramType, String isActive,
			String isBudgetAutoRecalculated, String isClockToCredit, String isClockToCreditPriorJuly2011,
			String isDegreeProgram, String isEnglishProficiencyRequired, String isExternStartDateRequired,
			String isGpaCalcWeighted, String isIncrementalBillEarn, String isNonSe9W,
			String isOutsideProgramRegistrationAllowed, String isRequiredToTakeAttendance,
			String isRevenueIncludedIn9010Report, String isSapBasedOnPaymentPeriod, String isScheduledHoursUsed,
			String isTitleIvEligible, String isUndeclared, String isWaitListingRestricted)
			throws JsonProcessingException, SQLException {

		NewEditAdProgramVersionsCampusList newEditAdProgramVersionsCampusList = new NewEditAdProgramVersionsCampusList();
		newEditAdProgramVersionsCampusList.campusName = "TRADITIONAL";
		newEditAdProgramVersionsCampusList.campusId = 5;
		newEditAdProgramVersionsCampusList.selected = 1;
		newEditAdProgramVersionsCampusList.isCampusActive = true;

		List<NewEditAdProgramVersionsCampusList> newEditAdProgramVersionsCampusListArrayList = new ArrayList<NewEditAdProgramVersionsCampusList>();
		newEditAdProgramVersionsCampusListArrayList.add(newEditAdProgramVersionsCampusList);

		List<Integer> programGroupIds = new ArrayList<Integer>();
		programGroupIds.add((int) Math.round(Double.parseDouble(programGroupList.get(0))));

		NewEditAdProgramVersions newEditAdProgramVersions = new NewEditAdProgramVersions();
		newEditAdProgramVersions.isExcludedCrmIntegration = Boolean.parseBoolean(isExcludedCrmIntegration);
		newEditAdProgramVersions.programName = null;
		newEditAdProgramVersions.isHoursPerYear = Boolean.parseBoolean(isExcludedCrmIntegration);
		newEditAdProgramVersions.programCode = null;
		newEditAdProgramVersions.transferCreditRestrictionList = null;
		newEditAdProgramVersions.id = -1;
		newEditAdProgramVersions.academicCalendar = null;
		newEditAdProgramVersions.academicYearType = null;
		newEditAdProgramVersions.activeUnits = (int) Math.round(Double.parseDouble(activeUnits));
		newEditAdProgramVersions.activeWhen = activeWhen;
		newEditAdProgramVersions.attendanceWithdrawalDateOption = null;
		newEditAdProgramVersions.billingMethodId = null;
		newEditAdProgramVersions.budgetId = null;
		newEditAdProgramVersions.campusGroupId = 1;
		newEditAdProgramVersions.campusLicenseUnit = campusLicenseUnit;
		newEditAdProgramVersions.censusPeriod = null;
		newEditAdProgramVersions.censusRecurrence = null;
		newEditAdProgramVersions.cipCode = cipCode;
		newEditAdProgramVersions.clockHoursRequired = (int) Math.round(Double.parseDouble(clockHoursRequired));
		newEditAdProgramVersions.clockToCreditRate = 0;
		newEditAdProgramVersions.clockToCreditRatePriorJuly2011 = 0;
		newEditAdProgramVersions.code = code;
		newEditAdProgramVersions.courseFulfillmentOrderDetailId = null;
		newEditAdProgramVersions.courseRefundPolicyId = null;
		newEditAdProgramVersions.createdDateTime = "2020/05/31 22:12:45";
		newEditAdProgramVersions.creditBalanceScheduleDateType = null;
		newEditAdProgramVersions.creditBalanceScheduleDateTypeOffsetDays = null;
		newEditAdProgramVersions.creditHoursRequired = (int) Math.round(Double.parseDouble(creditHoursRequired));
		newEditAdProgramVersions.creditsInFullAcademicYear = 0;
		newEditAdProgramVersions.creditsYear1 = 0;
		newEditAdProgramVersions.creditsYear2 = 0;
		newEditAdProgramVersions.creditsYear3 = 0;
		newEditAdProgramVersions.creditsYear4 = 0;
		newEditAdProgramVersions.currentYearCipCodeId = (int) Math.round(Double.parseDouble(currectCIPCODEList.get(0)));
		newEditAdProgramVersions.daysBetweenLessons = null;
		newEditAdProgramVersions.defaultSpecialProgramType = defaultSpecialProgramType;
		newEditAdProgramVersions.degreeId = (int) Math.round(Double.parseDouble(addegreeList.get(0)));
		newEditAdProgramVersions.doNotUsePaymentPeriods = null;
		newEditAdProgramVersions.englishProficiencyNotRequiredReason = null;
		newEditAdProgramVersions.expectedCreditsPerTerm = (int) Math.round(Double.parseDouble(expectedCreditsPerTerm));
		newEditAdProgramVersions.expectedHoursPerWeekExternship = 0;
		newEditAdProgramVersions.externshipClockHours = 0;
		newEditAdProgramVersions.externshipCreditHours = 0;
		newEditAdProgramVersions.financialAidCredits = 0;
		newEditAdProgramVersions.firstMonthPercentage = null;
		newEditAdProgramVersions.fullTimeMin = (int) Math.round(Double.parseDouble(fullTimeMin));
		newEditAdProgramVersions.gradeLevelPromotionRuleId = (int) Math
				.round(Double.parseDouble(adGradeLevelPromotionList.get(0)));
		newEditAdProgramVersions.gradeScaleId = (int) Math.round(Double.parseDouble(adGradeScaleList.get(0)));
		newEditAdProgramVersions.halfTimeMin = (int) Math.round(Double.parseDouble(halfTimeMin));
		newEditAdProgramVersions.hoursYear1 = 0;
		newEditAdProgramVersions.hoursYear2 = 0;
		newEditAdProgramVersions.hoursYear3 = 0;
		newEditAdProgramVersions.hoursYear4 = 0;
		newEditAdProgramVersions.isActive = Boolean.parseBoolean(isActive);
		newEditAdProgramVersions.isBudgetAutoRecalculated = Boolean.parseBoolean(isBudgetAutoRecalculated);
		newEditAdProgramVersions.isCensusDateTriggerEnabled = null;
		newEditAdProgramVersions.isClockToCredit = Boolean.parseBoolean(isClockToCredit);
		newEditAdProgramVersions.isClockToCreditPriorJuly2011 = Boolean.parseBoolean(isClockToCreditPriorJuly2011);
		newEditAdProgramVersions.isDegreeProgram = Boolean.parseBoolean(isDegreeProgram);
		newEditAdProgramVersions.isEnglishProficiencyRequired = Boolean.parseBoolean(isEnglishProficiencyRequired);
		newEditAdProgramVersions.isExternStartDateRequired = Boolean.parseBoolean(isExternStartDateRequired);
		newEditAdProgramVersions.isGpaCalcWeighted = Boolean.parseBoolean(isGpaCalcWeighted);
		newEditAdProgramVersions.isIncrementalBillEarn = Boolean.parseBoolean(isIncrementalBillEarn);
		newEditAdProgramVersions.isNonSe9W = Boolean.parseBoolean(isNonSe9W);
		newEditAdProgramVersions.isOutsideProgramRegistrationAllowed = Boolean
				.parseBoolean(isOutsideProgramRegistrationAllowed);
		newEditAdProgramVersions.isRequiredToTakeAttendance = Boolean.parseBoolean(isRequiredToTakeAttendance);
		newEditAdProgramVersions.isRevenueIncludedIn9010Report = Boolean.parseBoolean(isRevenueIncludedIn9010Report);
		newEditAdProgramVersions.isSapBasedOnPaymentPeriod = Boolean.parseBoolean(isSapBasedOnPaymentPeriod);
		newEditAdProgramVersions.isScheduledHoursUsed = Boolean.parseBoolean(isScheduledHoursUsed);
		newEditAdProgramVersions.isTitleIvEligible = Boolean.parseBoolean(isTitleIvEligible);
		newEditAdProgramVersions.isUndeclared = Boolean.parseBoolean(isUndeclared);
		newEditAdProgramVersions.isWaitListingRestricted = Boolean.parseBoolean(isWaitListingRestricted);
		newEditAdProgramVersions.lastModifiedDateTime = "2020/05/31 22:12:45";
		newEditAdProgramVersions.lastModifiedUserId = 34719;
		newEditAdProgramVersions.lessThanHalfTimeMin = (int) Math.round(Double.parseDouble(lessThanHalfTimeMin));
		newEditAdProgramVersions.maxOnlineRegistrationCredits = null;
		newEditAdProgramVersions.minimumGpa = (int) Math.round(Double.parseDouble(minimumGpa));
		newEditAdProgramVersions.minOnlineRegistrationCredits = null;
		newEditAdProgramVersions.monthsInTerm = 0;
		newEditAdProgramVersions.name = name;
		newEditAdProgramVersions.note = null;
		newEditAdProgramVersions.numberExtensions = null;
		newEditAdProgramVersions.numberPaymentPeriodsNonTitleIvAcademicYear = 0;
		newEditAdProgramVersions.numberPaymentPeriodsTitleIvAcademicYear = 0;
		newEditAdProgramVersions.outsideCourseWorkHours = 0;
		newEditAdProgramVersions.paymentMethodology = null;
		newEditAdProgramVersions.programGroupId = null;
		newEditAdProgramVersions.programId =(int)Math.round(Double.parseDouble(adProgramList.get(0)));
		newEditAdProgramVersions.programLengthType = programLengthType;
		newEditAdProgramVersions.programLengthValue = (int) Math.round(Double.parseDouble(programLengthValue));
		newEditAdProgramVersions.programVersionUnitType = programVersionUnitType;
		newEditAdProgramVersions.proRateCostFlag = 0;
		newEditAdProgramVersions.refundBasedOn = "";
		newEditAdProgramVersions.requiresAreaOfStudy = false;
		newEditAdProgramVersions.returnOfTitleIvEnrollmentPeriodType = null;
		newEditAdProgramVersions.returnOfTitleIvPeriod = null;
		newEditAdProgramVersions.returnOfTitleIvPeriodReenroll = null;
		newEditAdProgramVersions.revenueEarningMethodId = null;
		newEditAdProgramVersions.revenuePeriod = null;
		newEditAdProgramVersions.revenueUnits = null;
		newEditAdProgramVersions.rowVersion = null;
		newEditAdProgramVersions.sapTableId = (int) Math.round(Double.parseDouble(adSapTableList.get(0)));
		newEditAdProgramVersions.schoolDefinedField1 = null;
		newEditAdProgramVersions.schoolDefinedField2 = null;
		newEditAdProgramVersions.schoolDefinedField3 = null;
		newEditAdProgramVersions.schoolDefinedField4 = null;
		newEditAdProgramVersions.servicerProgramIdentifier = null;
		newEditAdProgramVersions.summerTermCredits = 0;
		newEditAdProgramVersions.summerTermHeaderOrTrailer = 0;
		newEditAdProgramVersions.summerTermPackaging = false;
		newEditAdProgramVersions.termsInAcademicYear = null;
		newEditAdProgramVersions.threeQuarterrTimeMin = (int) Math.round(Double.parseDouble(threeQuarterrTimeMin));
		newEditAdProgramVersions.totalApprovedTransferCredits = 0;
		newEditAdProgramVersions.totalBooksSuppliesCost = null;
		newEditAdProgramVersions.totalLessons = 0;
		newEditAdProgramVersions.totalMonths = (int) Math.round(Double.parseDouble(totalMonths));
		newEditAdProgramVersions.totalOtherCost = null;
		newEditAdProgramVersions.totalTuitionCost = null;
		newEditAdProgramVersions.totalWeeks = (int) Math.round(Double.parseDouble(totalWeeks));
		newEditAdProgramVersions.transcriptDescription = transcriptDescription;
		newEditAdProgramVersions.weeksInFullAcademicYear = 0;
		newEditAdProgramVersions.weeksInTerm = 0;
		newEditAdProgramVersions.campusList = newEditAdProgramVersionsCampusListArrayList;
		newEditAdProgramVersions.originalState = "";
		newEditAdProgramVersions.secureState = "";
		newEditAdProgramVersions.entityState = UtilClass.new_entityState;
		newEditAdProgramVersions.programGroupIdList = programGroupIds;

		NewEditAdProgramVersionPayload newEditAdProgramVersionPayload = new NewEditAdProgramVersionPayload();
		newEditAdProgramVersionPayload.payload = newEditAdProgramVersions;

		String data_newPayload = objMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(newEditAdProgramVersionPayload);

		System.out.println("Create AdProgramVersion PayLoad: " + data_newPayload);

		request.body(newEditAdProgramVersionPayload);

		response = request.post("/SaveNew");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Id_responsepayload_data.add(jsonPathEvaluator.getString("payload.data.id"));

		name_responsepayload_editdata = jsonPathEvaluator.getString("payload.data.name");

		code_responsepayload_editdata = jsonPathEvaluator.getString("payload.data.code");

		Assert.assertEquals(name_responsepayload_editdata, name);

		Assert.assertEquals(code_responsepayload_editdata, code);

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(dataProvider = "setEditProgramVersionData", priority = 2)
	public void EditandGetProgramVersion(String code, String name, String creditHoursRequired,
			String clockHoursRequired, String expectedCreditsPerTerm, String fullTimeMin, String halfTimeMin,
			String lessThanHalfTimeMin, String threeQuarterrTimeMin, String totalMonths, String totalWeeks,
			String transcriptDescription, String minimumGpa, String programLengthType, String programLengthValue,
			String programVersionUnitType, String isExcludedCrmIntegration, String isHoursPerYear, String activeUnits,
			String activeWhen, String campusLicenseUnit, String cipCode, String defaultSpecialProgramType,
			String isActive, String isBudgetAutoRecalculated, String isClockToCredit,
			String isClockToCreditPriorJuly2011, String isDegreeProgram, String isEnglishProficiencyRequired,
			String isExternStartDateRequired, String isGpaCalcWeighted, String isIncrementalBillEarn, String isNonSe9W,
			String isOutsideProgramRegistrationAllowed, String isRequiredToTakeAttendance,
			String isRevenueIncludedIn9010Report, String isSapBasedOnPaymentPeriod, String isScheduledHoursUsed,
			String isTitleIvEligible, String isUndeclared, String isWaitListingRestricted, String schoolDefinedField1,
			String schoolDefinedField2, String schoolDefinedField3, String schoolDefinedField4,
			String englishProficiencyNotRequiredReason, String note) throws JsonProcessingException, SQLException {

		GetProgramVersions getProgramVersions = new GetProgramVersions();
		getProgramVersions.id = (int) Math.round(Double.parseDouble(Id_responsepayload_data.get(Count_Delete)));

		GetProgramVersionsPayload getProgramVersionsPayload = new GetProgramVersionsPayload();
		getProgramVersionsPayload.payload = getProgramVersions;

		String data_getProgramVersions = objMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(getProgramVersionsPayload);

		System.out.println("Get Program Version Payload: " + data_getProgramVersions);

		request.body(data_getProgramVersions);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		campusGroupId_responsepayload_editdata = jsonPathEvaluator.getString("payload.data.campusGroupId");

		rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");

		Assert.assertEquals(response.getStatusCode(), 200);

		NewEditAdProgramVersionsCampusList newEditAdProgramVersionsCampusList = new NewEditAdProgramVersionsCampusList();
		newEditAdProgramVersionsCampusList.campusName = "TRADITIONAL";
		newEditAdProgramVersionsCampusList.campusId = 5;
		newEditAdProgramVersionsCampusList.selected = 1;
		newEditAdProgramVersionsCampusList.isCampusActive = true;

		List<NewEditAdProgramVersionsCampusList> newEditAdProgramVersionsCampusListArrayList = new ArrayList<NewEditAdProgramVersionsCampusList>();
		newEditAdProgramVersionsCampusListArrayList.add(newEditAdProgramVersionsCampusList);

		List<Integer> programGroupIds = new ArrayList<Integer>();
		programGroupIds.add((int) Math.round(Double.parseDouble(programGroupList.get(0))));

		NewEditAdProgramVersions newEditAdProgramVersions = new NewEditAdProgramVersions();
		newEditAdProgramVersions.isExcludedCrmIntegration = Boolean.parseBoolean(isExcludedCrmIntegration);
		newEditAdProgramVersions.programName = null;
		newEditAdProgramVersions.isHoursPerYear = Boolean.parseBoolean(isExcludedCrmIntegration);
		newEditAdProgramVersions.programCode = null;
		newEditAdProgramVersions.transferCreditRestrictionList = null;
		newEditAdProgramVersions.id = (int) Math.round(Double.parseDouble(Id_responsepayload_data.get(Count_Delete)));
		newEditAdProgramVersions.academicCalendar = null;
		newEditAdProgramVersions.academicYearType = null;
		newEditAdProgramVersions.activeUnits = (int) Math.round(Double.parseDouble(activeUnits));
		newEditAdProgramVersions.activeWhen = activeWhen;
		newEditAdProgramVersions.attendanceWithdrawalDateOption = null;
		newEditAdProgramVersions.billingMethodId = null;
		newEditAdProgramVersions.budgetId = null;
		newEditAdProgramVersions.campusGroupId = (int) Math
				.round(Double.parseDouble(campusGroupId_responsepayload_editdata));
		newEditAdProgramVersions.campusLicenseUnit = campusLicenseUnit;
		newEditAdProgramVersions.censusPeriod = null;
		newEditAdProgramVersions.censusRecurrence = null;
		newEditAdProgramVersions.cipCode = cipCode;
		newEditAdProgramVersions.clockHoursRequired = (int) Math.round(Double.parseDouble(clockHoursRequired));
		newEditAdProgramVersions.clockToCreditRate = 0;
		newEditAdProgramVersions.clockToCreditRatePriorJuly2011 = 0;
		newEditAdProgramVersions.code = code;
		newEditAdProgramVersions.courseFulfillmentOrderDetailId = null;
		newEditAdProgramVersions.courseRefundPolicyId = null;
		newEditAdProgramVersions.createdDateTime = "2020/05/31 22:12:45";
		newEditAdProgramVersions.creditBalanceScheduleDateType = null;
		newEditAdProgramVersions.creditBalanceScheduleDateTypeOffsetDays = null;
		newEditAdProgramVersions.creditHoursRequired = (int) Math.round(Double.parseDouble(creditHoursRequired));
		newEditAdProgramVersions.creditsInFullAcademicYear = 0;
		newEditAdProgramVersions.creditsYear1 = 0;
		newEditAdProgramVersions.creditsYear2 = 0;
		newEditAdProgramVersions.creditsYear3 = 0;
		newEditAdProgramVersions.creditsYear4 = 0;
		newEditAdProgramVersions.currentYearCipCodeId = (int) Math.round(Double.parseDouble(currectCIPCODEList.get(0)));
		newEditAdProgramVersions.daysBetweenLessons = null;
		newEditAdProgramVersions.defaultSpecialProgramType = defaultSpecialProgramType;
		newEditAdProgramVersions.degreeId = (int) Math.round(Double.parseDouble(addegreeList.get(0)));
		newEditAdProgramVersions.doNotUsePaymentPeriods = null;
		newEditAdProgramVersions.englishProficiencyNotRequiredReason = englishProficiencyNotRequiredReason;
		newEditAdProgramVersions.expectedCreditsPerTerm = (int) Math.round(Double.parseDouble(expectedCreditsPerTerm));
		newEditAdProgramVersions.expectedHoursPerWeekExternship = 0;
		newEditAdProgramVersions.externshipClockHours = 0;
		newEditAdProgramVersions.externshipCreditHours = 0;
		newEditAdProgramVersions.financialAidCredits = 0;
		newEditAdProgramVersions.firstMonthPercentage = null;
		newEditAdProgramVersions.fullTimeMin = (int) Math.round(Double.parseDouble(fullTimeMin));
		newEditAdProgramVersions.gradeLevelPromotionRuleId = (int) Math
				.round(Double.parseDouble(adGradeLevelPromotionList.get(0)));
		newEditAdProgramVersions.gradeScaleId = (int) Math.round(Double.parseDouble(adGradeScaleList.get(0)));
		newEditAdProgramVersions.halfTimeMin = (int) Math.round(Double.parseDouble(halfTimeMin));
		newEditAdProgramVersions.hoursYear1 = 0;
		newEditAdProgramVersions.hoursYear2 = 0;
		newEditAdProgramVersions.hoursYear3 = 0;
		newEditAdProgramVersions.hoursYear4 = 0;
		newEditAdProgramVersions.isActive = Boolean.parseBoolean(isActive);
		newEditAdProgramVersions.isBudgetAutoRecalculated = Boolean.parseBoolean(isBudgetAutoRecalculated);
		newEditAdProgramVersions.isCensusDateTriggerEnabled = null;
		newEditAdProgramVersions.isClockToCredit = Boolean.parseBoolean(isClockToCredit);
		newEditAdProgramVersions.isClockToCreditPriorJuly2011 = Boolean.parseBoolean(isClockToCreditPriorJuly2011);
		newEditAdProgramVersions.isDegreeProgram = Boolean.parseBoolean(isDegreeProgram);
		newEditAdProgramVersions.isEnglishProficiencyRequired = Boolean.parseBoolean(isEnglishProficiencyRequired);
		newEditAdProgramVersions.isExternStartDateRequired = Boolean.parseBoolean(isExternStartDateRequired);
		newEditAdProgramVersions.isGpaCalcWeighted = Boolean.parseBoolean(isGpaCalcWeighted);
		newEditAdProgramVersions.isIncrementalBillEarn = Boolean.parseBoolean(isIncrementalBillEarn);
		newEditAdProgramVersions.isNonSe9W = Boolean.parseBoolean(isNonSe9W);
		newEditAdProgramVersions.isOutsideProgramRegistrationAllowed = Boolean
				.parseBoolean(isOutsideProgramRegistrationAllowed);
		newEditAdProgramVersions.isRequiredToTakeAttendance = Boolean.parseBoolean(isRequiredToTakeAttendance);
		newEditAdProgramVersions.isRevenueIncludedIn9010Report = Boolean.parseBoolean(isRevenueIncludedIn9010Report);
		newEditAdProgramVersions.isSapBasedOnPaymentPeriod = Boolean.parseBoolean(isSapBasedOnPaymentPeriod);
		newEditAdProgramVersions.isScheduledHoursUsed = Boolean.parseBoolean(isScheduledHoursUsed);
		newEditAdProgramVersions.isTitleIvEligible = Boolean.parseBoolean(isTitleIvEligible);
		newEditAdProgramVersions.isUndeclared = Boolean.parseBoolean(isUndeclared);
		newEditAdProgramVersions.isWaitListingRestricted = Boolean.parseBoolean(isWaitListingRestricted);
		newEditAdProgramVersions.lastModifiedDateTime = "2020/05/31 22:12:45";
		newEditAdProgramVersions.lastModifiedUserId = 34719;
		newEditAdProgramVersions.lessThanHalfTimeMin = (int) Math.round(Double.parseDouble(lessThanHalfTimeMin));
		newEditAdProgramVersions.maxOnlineRegistrationCredits = null;
		newEditAdProgramVersions.minimumGpa = (int) Math.round(Double.parseDouble(minimumGpa));
		newEditAdProgramVersions.minOnlineRegistrationCredits = null;
		newEditAdProgramVersions.monthsInTerm = 0;
		newEditAdProgramVersions.name = name;
		newEditAdProgramVersions.note = note;
		newEditAdProgramVersions.numberExtensions = null;
		newEditAdProgramVersions.numberPaymentPeriodsNonTitleIvAcademicYear = 0;
		newEditAdProgramVersions.numberPaymentPeriodsTitleIvAcademicYear = 0;
		newEditAdProgramVersions.outsideCourseWorkHours = 0;
		newEditAdProgramVersions.paymentMethodology = null;
		newEditAdProgramVersions.programGroupId = null;
		newEditAdProgramVersions.programId = (int)Math.round(Double.parseDouble(adProgramList.get(0)));
		newEditAdProgramVersions.programLengthType = programLengthType;
		newEditAdProgramVersions.programLengthValue = (int) Math.round(Double.parseDouble(programLengthValue));
		newEditAdProgramVersions.programVersionUnitType = programVersionUnitType;
		newEditAdProgramVersions.proRateCostFlag = 0;
		newEditAdProgramVersions.refundBasedOn = "";
		newEditAdProgramVersions.requiresAreaOfStudy = false;
		newEditAdProgramVersions.returnOfTitleIvEnrollmentPeriodType = null;
		newEditAdProgramVersions.returnOfTitleIvPeriod = null;
		newEditAdProgramVersions.returnOfTitleIvPeriodReenroll = null;
		newEditAdProgramVersions.revenueEarningMethodId = null;
		newEditAdProgramVersions.revenuePeriod = null;
		newEditAdProgramVersions.revenueUnits = null;
		newEditAdProgramVersions.rowVersion = rowVersion_responsepayload_data;
		newEditAdProgramVersions.sapTableId = (int) Math.round(Double.parseDouble(adSapTableList.get(0)));
		newEditAdProgramVersions.schoolDefinedField1 = schoolDefinedField1;
		newEditAdProgramVersions.schoolDefinedField2 = schoolDefinedField2;
		newEditAdProgramVersions.schoolDefinedField3 = schoolDefinedField3;
		newEditAdProgramVersions.schoolDefinedField4 = schoolDefinedField4;
		newEditAdProgramVersions.servicerProgramIdentifier = null;
		newEditAdProgramVersions.summerTermCredits = 0;
		newEditAdProgramVersions.summerTermHeaderOrTrailer = 0;
		newEditAdProgramVersions.summerTermPackaging = false;
		newEditAdProgramVersions.termsInAcademicYear = null;
		newEditAdProgramVersions.threeQuarterrTimeMin = (int) Math.round(Double.parseDouble(threeQuarterrTimeMin));
		newEditAdProgramVersions.totalApprovedTransferCredits = 0;
		newEditAdProgramVersions.totalBooksSuppliesCost = null;
		newEditAdProgramVersions.totalLessons = 0;
		newEditAdProgramVersions.totalMonths = (int) Math.round(Double.parseDouble(totalMonths));
		newEditAdProgramVersions.totalOtherCost = null;
		newEditAdProgramVersions.totalTuitionCost = null;
		newEditAdProgramVersions.totalWeeks = (int) Math.round(Double.parseDouble(totalWeeks));
		newEditAdProgramVersions.transcriptDescription = transcriptDescription;
		newEditAdProgramVersions.weeksInFullAcademicYear = 0;
		newEditAdProgramVersions.weeksInTerm = 0;
		newEditAdProgramVersions.campusList = newEditAdProgramVersionsCampusListArrayList;
		newEditAdProgramVersions.originalState = "";
		newEditAdProgramVersions.secureState = "";
		newEditAdProgramVersions.entityState = UtilClass.edit_entityState;
		newEditAdProgramVersions.programGroupIdList = programGroupIds;

		NewEditAdProgramVersionPayload newEditAdProgramVersionPayload = new NewEditAdProgramVersionPayload();
		newEditAdProgramVersionPayload.payload = newEditAdProgramVersions;

		String data_newPayload = objMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(newEditAdProgramVersionPayload);

		System.out.println("Edit AdProgramVersion PayLoad: " + data_newPayload);

		request.body(newEditAdProgramVersionPayload);

		response = request.post("/Save");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		Id_responsepayload_data.add(jsonPathEvaluator.getString("payload.data.id"));

		name_responsepayload_editdata = jsonPathEvaluator.getString("payload.data.name");

		code_responsepayload_editdata = jsonPathEvaluator.getString("payload.data.code");

		Assert.assertEquals(name_responsepayload_editdata, name);

		Assert.assertEquals(code_responsepayload_editdata, code);

		Assert.assertEquals(response.getStatusCode(), 200);

		Count_Delete = Count_Delete + 1;

	}

	@Test(dataProvider = "setDeleteProgramVersionData", priority = 3)
	public void DeleteGetProgramVersion(String code, String name, String creditHoursRequired, String clockHoursRequired,
			String expectedCreditsPerTerm, String fullTimeMin, String halfTimeMin, String lessThanHalfTimeMin,
			String threeQuarterrTimeMin, String totalMonths, String totalWeeks, String transcriptDescription,
			String minimumGpa, String programLengthType, String programLengthValue, String programVersionUnitType,
			String isExcludedCrmIntegration, String isHoursPerYear, String activeUnits, String activeWhen,
			String campusLicenseUnit, String cipCode, String defaultSpecialProgramType, String isActive,
			String isBudgetAutoRecalculated, String isClockToCredit, String isClockToCreditPriorJuly2011,
			String isDegreeProgram, String isEnglishProficiencyRequired, String isExternStartDateRequired,
			String isGpaCalcWeighted, String isIncrementalBillEarn, String isNonSe9W,
			String isOutsideProgramRegistrationAllowed, String isRequiredToTakeAttendance,
			String isRevenueIncludedIn9010Report, String isSapBasedOnPaymentPeriod, String isScheduledHoursUsed,
			String isTitleIvEligible, String isUndeclared, String isWaitListingRestricted, String schoolDefinedField1,
			String schoolDefinedField2, String schoolDefinedField3, String schoolDefinedField4,
			String englishProficiencyNotRequiredReason, String note) throws JsonProcessingException, SQLException {

		GetProgramVersions getProgramVersions = new GetProgramVersions();
		getProgramVersions.id = (int) Math.round(Double.parseDouble(Id_responsepayload_data.get(Count_Delete)));

		GetProgramVersionsPayload getProgramVersionsPayload = new GetProgramVersionsPayload();
		getProgramVersionsPayload.payload = getProgramVersions;

		String data_getProgramVersions = objMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(getProgramVersionsPayload);

		System.out.println("Get Program Version Payload: " + data_getProgramVersions);

		request.body(data_getProgramVersions);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		campusGroupId_responsepayload_editdata = jsonPathEvaluator.getString("payload.data.campusGroupId");

		rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.rowVersion");

		Assert.assertEquals(response.getStatusCode(), 200);

		NewEditAdProgramVersionsCampusList newEditAdProgramVersionsCampusList = new NewEditAdProgramVersionsCampusList();
		newEditAdProgramVersionsCampusList.campusName = "TRADITIONAL";
		newEditAdProgramVersionsCampusList.campusId = 5;
		newEditAdProgramVersionsCampusList.selected = 1;
		newEditAdProgramVersionsCampusList.isCampusActive = true;

		List<NewEditAdProgramVersionsCampusList> newEditAdProgramVersionsCampusListArrayList = new ArrayList<NewEditAdProgramVersionsCampusList>();
		newEditAdProgramVersionsCampusListArrayList.add(newEditAdProgramVersionsCampusList);

		List<Integer> programGroupIds = new ArrayList<Integer>();
		programGroupIds.add((int) Math.round(Double.parseDouble(programGroupList.get(0))));

		NewEditAdProgramVersions newEditAdProgramVersions = new NewEditAdProgramVersions();
		newEditAdProgramVersions.isExcludedCrmIntegration = Boolean.parseBoolean(isExcludedCrmIntegration);
		newEditAdProgramVersions.programName = null;
		newEditAdProgramVersions.isHoursPerYear = Boolean.parseBoolean(isExcludedCrmIntegration);
		newEditAdProgramVersions.programCode = null;
		newEditAdProgramVersions.transferCreditRestrictionList = null;
		newEditAdProgramVersions.id = (int) Math.round(Double.parseDouble(Id_responsepayload_data.get(Count_Delete)));
		newEditAdProgramVersions.academicCalendar = null;
		newEditAdProgramVersions.academicYearType = null;
		newEditAdProgramVersions.activeUnits = (int) Math.round(Double.parseDouble(activeUnits));
		newEditAdProgramVersions.activeWhen = activeWhen;
		newEditAdProgramVersions.attendanceWithdrawalDateOption = null;
		newEditAdProgramVersions.billingMethodId = null;
		newEditAdProgramVersions.budgetId = null;
		newEditAdProgramVersions.campusGroupId = (int) Math
				.round(Double.parseDouble(campusGroupId_responsepayload_editdata));
		newEditAdProgramVersions.campusLicenseUnit = campusLicenseUnit;
		newEditAdProgramVersions.censusPeriod = null;
		newEditAdProgramVersions.censusRecurrence = null;
		newEditAdProgramVersions.cipCode = cipCode;
		newEditAdProgramVersions.clockHoursRequired = (int) Math.round(Double.parseDouble(clockHoursRequired));
		newEditAdProgramVersions.clockToCreditRate = 0;
		newEditAdProgramVersions.clockToCreditRatePriorJuly2011 = 0;
		newEditAdProgramVersions.code = code;
		newEditAdProgramVersions.courseFulfillmentOrderDetailId = null;
		newEditAdProgramVersions.courseRefundPolicyId = null;
		newEditAdProgramVersions.createdDateTime = "2020/05/31 22:12:45";
		newEditAdProgramVersions.creditBalanceScheduleDateType = null;
		newEditAdProgramVersions.creditBalanceScheduleDateTypeOffsetDays = null;
		newEditAdProgramVersions.creditHoursRequired = (int) Math.round(Double.parseDouble(creditHoursRequired));
		newEditAdProgramVersions.creditsInFullAcademicYear = 0;
		newEditAdProgramVersions.creditsYear1 = 0;
		newEditAdProgramVersions.creditsYear2 = 0;
		newEditAdProgramVersions.creditsYear3 = 0;
		newEditAdProgramVersions.creditsYear4 = 0;
		newEditAdProgramVersions.currentYearCipCodeId = (int) Math.round(Double.parseDouble(currectCIPCODEList.get(0)));
		newEditAdProgramVersions.daysBetweenLessons = null;
		newEditAdProgramVersions.defaultSpecialProgramType = defaultSpecialProgramType;
		newEditAdProgramVersions.degreeId = (int) Math.round(Double.parseDouble(addegreeList.get(0)));
		newEditAdProgramVersions.doNotUsePaymentPeriods = null;
		newEditAdProgramVersions.englishProficiencyNotRequiredReason = englishProficiencyNotRequiredReason;
		newEditAdProgramVersions.expectedCreditsPerTerm = (int) Math.round(Double.parseDouble(expectedCreditsPerTerm));
		newEditAdProgramVersions.expectedHoursPerWeekExternship = 0;
		newEditAdProgramVersions.externshipClockHours = 0;
		newEditAdProgramVersions.externshipCreditHours = 0;
		newEditAdProgramVersions.financialAidCredits = 0;
		newEditAdProgramVersions.firstMonthPercentage = null;
		newEditAdProgramVersions.fullTimeMin = (int) Math.round(Double.parseDouble(fullTimeMin));
		newEditAdProgramVersions.gradeLevelPromotionRuleId = (int) Math
				.round(Double.parseDouble(adGradeLevelPromotionList.get(0)));
		newEditAdProgramVersions.gradeScaleId = (int) Math.round(Double.parseDouble(adGradeScaleList.get(0)));
		newEditAdProgramVersions.halfTimeMin = (int) Math.round(Double.parseDouble(halfTimeMin));
		newEditAdProgramVersions.hoursYear1 = 0;
		newEditAdProgramVersions.hoursYear2 = 0;
		newEditAdProgramVersions.hoursYear3 = 0;
		newEditAdProgramVersions.hoursYear4 = 0;
		newEditAdProgramVersions.isActive = Boolean.parseBoolean(isActive);
		newEditAdProgramVersions.isBudgetAutoRecalculated = Boolean.parseBoolean(isBudgetAutoRecalculated);
		newEditAdProgramVersions.isCensusDateTriggerEnabled = null;
		newEditAdProgramVersions.isClockToCredit = Boolean.parseBoolean(isClockToCredit);
		newEditAdProgramVersions.isClockToCreditPriorJuly2011 = Boolean.parseBoolean(isClockToCreditPriorJuly2011);
		newEditAdProgramVersions.isDegreeProgram = Boolean.parseBoolean(isDegreeProgram);
		newEditAdProgramVersions.isEnglishProficiencyRequired = Boolean.parseBoolean(isEnglishProficiencyRequired);
		newEditAdProgramVersions.isExternStartDateRequired = Boolean.parseBoolean(isExternStartDateRequired);
		newEditAdProgramVersions.isGpaCalcWeighted = Boolean.parseBoolean(isGpaCalcWeighted);
		newEditAdProgramVersions.isIncrementalBillEarn = Boolean.parseBoolean(isIncrementalBillEarn);
		newEditAdProgramVersions.isNonSe9W = Boolean.parseBoolean(isNonSe9W);
		newEditAdProgramVersions.isOutsideProgramRegistrationAllowed = Boolean
				.parseBoolean(isOutsideProgramRegistrationAllowed);
		newEditAdProgramVersions.isRequiredToTakeAttendance = Boolean.parseBoolean(isRequiredToTakeAttendance);
		newEditAdProgramVersions.isRevenueIncludedIn9010Report = Boolean.parseBoolean(isRevenueIncludedIn9010Report);
		newEditAdProgramVersions.isSapBasedOnPaymentPeriod = Boolean.parseBoolean(isSapBasedOnPaymentPeriod);
		newEditAdProgramVersions.isScheduledHoursUsed = Boolean.parseBoolean(isScheduledHoursUsed);
		newEditAdProgramVersions.isTitleIvEligible = Boolean.parseBoolean(isTitleIvEligible);
		newEditAdProgramVersions.isUndeclared = Boolean.parseBoolean(isUndeclared);
		newEditAdProgramVersions.isWaitListingRestricted = Boolean.parseBoolean(isWaitListingRestricted);
		newEditAdProgramVersions.lastModifiedDateTime = "2020/05/31 22:12:45";
		newEditAdProgramVersions.lastModifiedUserId = 34719;
		newEditAdProgramVersions.lessThanHalfTimeMin = (int) Math.round(Double.parseDouble(lessThanHalfTimeMin));
		newEditAdProgramVersions.maxOnlineRegistrationCredits = null;
		newEditAdProgramVersions.minimumGpa = (int) Math.round(Double.parseDouble(minimumGpa));
		newEditAdProgramVersions.minOnlineRegistrationCredits = null;
		newEditAdProgramVersions.monthsInTerm = 0;
		newEditAdProgramVersions.name = name;
		newEditAdProgramVersions.note = note;
		newEditAdProgramVersions.numberExtensions = null;
		newEditAdProgramVersions.numberPaymentPeriodsNonTitleIvAcademicYear = 0;
		newEditAdProgramVersions.numberPaymentPeriodsTitleIvAcademicYear = 0;
		newEditAdProgramVersions.outsideCourseWorkHours = 0;
		newEditAdProgramVersions.paymentMethodology = null;
		newEditAdProgramVersions.programGroupId = null;
		newEditAdProgramVersions.programId = (int)Math.round(Double.parseDouble(adProgramList.get(0)));
		newEditAdProgramVersions.programLengthType = programLengthType;
		newEditAdProgramVersions.programLengthValue = (int) Math.round(Double.parseDouble(programLengthValue));
		newEditAdProgramVersions.programVersionUnitType = programVersionUnitType;
		newEditAdProgramVersions.proRateCostFlag = 0;
		newEditAdProgramVersions.refundBasedOn = "";
		newEditAdProgramVersions.requiresAreaOfStudy = false;
		newEditAdProgramVersions.returnOfTitleIvEnrollmentPeriodType = null;
		newEditAdProgramVersions.returnOfTitleIvPeriod = null;
		newEditAdProgramVersions.returnOfTitleIvPeriodReenroll = null;
		newEditAdProgramVersions.revenueEarningMethodId = null;
		newEditAdProgramVersions.revenuePeriod = null;
		newEditAdProgramVersions.revenueUnits = null;
		newEditAdProgramVersions.rowVersion = rowVersion_responsepayload_data;
		newEditAdProgramVersions.sapTableId = (int) Math.round(Double.parseDouble(adSapTableList.get(0)));
		newEditAdProgramVersions.schoolDefinedField1 = schoolDefinedField1;
		newEditAdProgramVersions.schoolDefinedField2 = schoolDefinedField2;
		newEditAdProgramVersions.schoolDefinedField3 = schoolDefinedField3;
		newEditAdProgramVersions.schoolDefinedField4 = schoolDefinedField4;
		newEditAdProgramVersions.servicerProgramIdentifier = null;
		newEditAdProgramVersions.summerTermCredits = 0;
		newEditAdProgramVersions.summerTermHeaderOrTrailer = 0;
		newEditAdProgramVersions.summerTermPackaging = false;
		newEditAdProgramVersions.termsInAcademicYear = null;
		newEditAdProgramVersions.threeQuarterrTimeMin = (int) Math.round(Double.parseDouble(threeQuarterrTimeMin));
		newEditAdProgramVersions.totalApprovedTransferCredits = 0;
		newEditAdProgramVersions.totalBooksSuppliesCost = null;
		newEditAdProgramVersions.totalLessons = 0;
		newEditAdProgramVersions.totalMonths = (int) Math.round(Double.parseDouble(totalMonths));
		newEditAdProgramVersions.totalOtherCost = null;
		newEditAdProgramVersions.totalTuitionCost = null;
		newEditAdProgramVersions.totalWeeks = (int) Math.round(Double.parseDouble(totalWeeks));
		newEditAdProgramVersions.transcriptDescription = transcriptDescription;
		newEditAdProgramVersions.weeksInFullAcademicYear = 0;
		newEditAdProgramVersions.weeksInTerm = 0;
		newEditAdProgramVersions.campusList = newEditAdProgramVersionsCampusListArrayList;
		newEditAdProgramVersions.originalState = "";
		newEditAdProgramVersions.secureState = "";
		newEditAdProgramVersions.entityState = UtilClass.delete_entityState;
		newEditAdProgramVersions.programGroupIdList = programGroupIds;

		NewEditAdProgramVersionPayload newEditAdProgramVersionPayload = new NewEditAdProgramVersionPayload();
		newEditAdProgramVersionPayload.payload = newEditAdProgramVersions;

		String data_newPayload = objMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(newEditAdProgramVersionPayload);

		System.out.println("Delete AdProgramVersion PayLoad: " + data_newPayload);

		request.body(newEditAdProgramVersionPayload);

		response = request.post("/Delete");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		String delete_responsepayload_data = jsonPathEvaluator.getString("payload.deleted");

		Assert.assertEquals(delete_responsepayload_data, "true");

		Assert.assertEquals(response.getStatusCode(), 200);

		Count_Delete = Count_Delete + 1;
	}

	@DataProvider
	public Object[][] setNewProgramVersionData() {

		Object[][] data_NewProgramVersion = UtilClass.setData("0", ExcelSheet_FilePatch);

		return data_NewProgramVersion;
	}

	@DataProvider
	public Object[][] setEditProgramVersionData() {

		Object[][] data_EditProgramVersion = UtilClass.setData("1", ExcelSheet_FilePatch);

		return data_EditProgramVersion;
	}

	@DataProvider
	public Object[][] setDeleteProgramVersionData() {

		Object[][] data_EditProgramVersion = UtilClass.setData("1", ExcelSheet_FilePatch);

		return data_EditProgramVersion;
	}

}
