package Setting.FinancialAid.TestCases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.AdProgramVersions.NewEditAdProgramVersionPayload;
import com.student.AdProgramVersions.NewEditAdProgramVersions;
import com.student.AdProgramVersions.NewEditAdProgramVersionsCampusList;
import com.student.BaseClass.BaseClass;
import com.student.TestData.UtilClass;
import Configuration.FinancialAid.ProgramVersionPojo.FAProgramVersionsDetails;
import Configuration.FinancialAid.ProgramVersionPojo.FaProgramVersionAcademicYearList;
import Configuration.FinancialAid.ProgramVersionPojo.FaProgramVersionBudgetCostList;
import Configuration.FinancialAid.ProgramVersionPojo.FaProgramVersionPayload;
import Configuration.FinancialAid.ProgramVersionPojo.FaProgramVersionTermAssociationAcademicYear;
import Configuration.FinancialAid.ProgramVersionPojo.FaProgramVersionTermProgramAssociationSaveRequest;
import Configuration.FinancialAid.ProgramVersionPojo.FaProgramVersionsAcademicYearAcademicYear;
import Configuration.FinancialAid.ProgramVersionPojo.FaProgramVersionsAcademicYearBudget;
import Configuration.FinancialAid.ProgramVersionPojo.FaProgramVersionsAcademicYearEnrollmentStatus;
import Configuration.FinancialAid.ProgramVersionPojo.GetFAProgramVersions;
import Configuration.FinancialAid.ProgramVersionPojo.GetFaProgramVersionsPayload;
import Configuration.FinancialAid.ProgramVersionPojo.NewEditFaPayLoad;
import junit.framework.Assert;

public class TC001_FAProgramVersionsCRUDTestCases extends BaseClass {

	public static ObjectMapper objMapper = new ObjectMapper();
	public static String ExcelSheet_FilePatchFAProgramVersion = "C:\\GopalBackUp\\WorkSpace\\APIRestAssuredToolsQA\\src\\main\\java\\TestDataFromExcel\\FAProgramVersions.xlsx";
	public static String ExcelSheet_FilePatchADProgramVersion = "C:\\GopalBackUp\\WorkSpace\\APIRestAssuredToolsQA\\src\\main\\java\\TestDataFromExcel\\AdProgramVersions.xlsx";
	public static String name_responsepayload_editdata;
	public static String code_responsepayload_editdata;
	public static List<String> campusGroupId_responsepayload_editdata = new ArrayList<String>();
	public static List<String> Id_programVersion_responsepayload_data = new ArrayList<String>();
	public static String rowVersion_responsepayload_data;
	public static Integer Count = 0;
	public static Integer Count_Edit = 0;
	public static List<String> adProgramList = new ArrayList<String>();
	public static List<String> currectCIPCODEList = new ArrayList<String>();
	public static List<String> adGradeScaleList = new ArrayList<String>();
	public static List<String> adGradeLevelPromotionList = new ArrayList<String>();
	public static List<String> addegreeList = new ArrayList<String>();
	public static List<String> adSapTableList = new ArrayList<String>();
	public static List<String> programGroupList = new ArrayList<String>();
	public static List<String> faAcademicYearList = new ArrayList<String>();
	public static List<String> faBudgetList = new ArrayList<String>();
	public static List<String> AdTermList = new ArrayList<String>();

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

		// ==============================faAcademicYear====================================

		String faAcademicYearSQLQuary = "Select FaAcademicYearID,Code,Descrip,* from faAcademicYear";

		faAcademicYearList = SelectQuaryfromDatabase(faAcademicYearSQLQuary);

		// ==============================faAcademicYear====================================

		String faBudgetSQLQuary = "Select FABudgetID,Descrip,Code,* from fabudget";

		faBudgetList = SelectQuaryfromDatabase(faBudgetSQLQuary);

		// ==============================faAcademicYear====================================

		String AdTermSQLQuary = "Select AdTermid,*from AdTerm ";

		AdTermList = SelectQuaryfromDatabase(AdTermSQLQuary);

	}

	@BeforeMethod
	public void SetUp() {

		String service_URL = prop.getProperty("ConfigurationFinancialAidFAProgramVersionsSERVICESURL");

		request = initialization(service_URL);
	}

	@Test(dataProvider = "setNewADProgramVersionData", priority = 1)
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

		String service_URL = prop.getProperty("ConfigurationAcademicRecordsAdProgramVersionsSERVICESURL");

		request = initialization(service_URL);

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
		newEditAdProgramVersions.programId = (int) Math.round(Double.parseDouble(adProgramList.get(0)));
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

		Id_programVersion_responsepayload_data.add(jsonPathEvaluator.getString("payload.data.id"));

		campusGroupId_responsepayload_editdata.add(jsonPathEvaluator.getString("payload.data.campusGroupId"));

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(dataProvider = "setNewFAProgramVersionData", priority = 2)
	public void CreateFAProgramVersionsWithTermaAsscoationValidatione(String code, String name,
			String creditHoursRequired, String clockHoursRequired, String expectedCreditsPerTerm, String fullTimeMin,
			String halfTimeMin, String lessThanHalfTimeMin, String threeQuarterrTimeMin, String totalMonths,
			String totalWeeks, String transcriptDescription, String minimumGpa, String programLengthType,
			String programLengthValue, String programVersionUnitType, String academicCalendar, String academicYearType,
			String creditsInFullAcademicYear, String isExcludedCrmIntegration, String isHoursPerYear,
			String activeUnits, String activeWhen, String campusLicenseUnit, String cipCode,
			String defaultSpecialProgramType, String isActive, String isBudgetAutoRecalculated, String isClockToCredit,
			String isClockToCreditPriorJuly2011, String isDegreeProgram, String isEnglishProficiencyRequired,
			String isExternStartDateRequired, String isGpaCalcWeighted, String isIncrementalBillEarn, String isNonSe9W,
			String isOutsideProgramRegistrationAllowed, String isRequiredToTakeAttendance,
			String isRevenueIncludedIn9010Report, String isSapBasedOnPaymentPeriod, String isScheduledHoursUsed,
			String isTitleIvEligible, String isUndeclared, String isWaitListingRestricted, String sequence,
			String tuitionCost, String booksSuppliesCost, String otherCost, String total, String academicYearSequence1,
			String academicYearSequence2, String academicYearSequence3, String defaultWeeksInAcademicYear,
			String isDirty, String isBudgetDirty, String AcademicYearEnrollmentStatusname, String enrollmentStatusName,
			String defaultWeeksInAcademicYear1, String isCreditHoursInAcademicYearDirty, String clockToCreditRateFlag,
			String attendanceWithdrawalDateOption, String englishProficiencyNotRequiredReason,
			String externshipClockHours, String externshipCreditHours, String note, String paymentMethodology,
			String requiresAreaOfStudy, String schoolDefinedField1, String schoolDefinedField2,
			String schoolDefinedField3, String schoolDefinedField4, String servicerProgramIdentifier,
			String summerTermCredits, String summerTermHeaderOrTrailer, String summerTermPackaging,
			String termsInAcademicYear9, String weeksInFullAcademicYear) throws JsonProcessingException {

		GetFAProgramVersions getfaProgramVersions = new GetFAProgramVersions();
		getfaProgramVersions.programVersionId = (int) Math
				.round(Double.parseDouble(Id_programVersion_responsepayload_data.get(Count_Edit)));

		GetFaProgramVersionsPayload getFaProgramVersionsPayload = new GetFaProgramVersionsPayload();
		getFaProgramVersionsPayload.payload = getfaProgramVersions;

		String data_getProgramVersions = objMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(getFaProgramVersionsPayload);

		System.out.println("Get Program Version Payload: " + data_getProgramVersions);

		request.body(data_getProgramVersions);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.programVersionDetail.rowVersion");

		Assert.assertEquals(response.getStatusCode(), 200);

		FaProgramVersionBudgetCostList faProgramVersionBudgetCostList = new FaProgramVersionBudgetCostList();
		faProgramVersionBudgetCostList.id = -1;
		faProgramVersionBudgetCostList.entityState = 0;
		faProgramVersionBudgetCostList.sequence = (int) Math.round(Double.parseDouble(sequence));
		faProgramVersionBudgetCostList.effectiveDate = "2020/06/01 17:01:33";
		faProgramVersionBudgetCostList.programVersionId = (int) Math
				.round(Double.parseDouble(Id_programVersion_responsepayload_data.get(Count_Edit)));
		faProgramVersionBudgetCostList.tuitionCost = (int) Math.round(Double.parseDouble(tuitionCost));
		;
		faProgramVersionBudgetCostList.booksSuppliesCost = (int) Math.round(Double.parseDouble(booksSuppliesCost));
		faProgramVersionBudgetCostList.otherCost = (int) Math.round(Double.parseDouble(otherCost));
		faProgramVersionBudgetCostList.total = (int) Math.round(Double.parseDouble(total));

		List<FaProgramVersionBudgetCostList> faProgramVersionBudgetCostListArrayList = new ArrayList<FaProgramVersionBudgetCostList>();
		faProgramVersionBudgetCostListArrayList.add(faProgramVersionBudgetCostList);

		List<Integer> termIdsList1 = new ArrayList<Integer>();
		termIdsList1.add((int) Math.round(Double.parseDouble(AdTermList.get(0))));
		termIdsList1.add((int) Math.round(Double.parseDouble(AdTermList.get(50))));
		termIdsList1.add((int) Math.round(Double.parseDouble(AdTermList.get(100))));
		termIdsList1.add((int) Math.round(Double.parseDouble(AdTermList.get(150))));

		List<Integer> termIdsList2 = new ArrayList<Integer>();
		termIdsList2.add((int) Math.round(Double.parseDouble(AdTermList.get(200))));
		termIdsList2.add((int) Math.round(Double.parseDouble(AdTermList.get(250))));
		termIdsList2.add((int) Math.round(Double.parseDouble(AdTermList.get(300))));
		termIdsList2.add((int) Math.round(Double.parseDouble(AdTermList.get(350))));

		List<Integer> termIdsList3 = new ArrayList<Integer>();
		termIdsList3.add((int) Math.round(Double.parseDouble(AdTermList.get(400))));
		termIdsList3.add((int) Math.round(Double.parseDouble(AdTermList.get(450))));
		termIdsList3.add((int) Math.round(Double.parseDouble(AdTermList.get(500))));
		termIdsList3.add((int) Math.round(Double.parseDouble(AdTermList.get(550))));

		FaProgramVersionTermAssociationAcademicYear faProgramVersionTermAssociationAcademicYear1 = new FaProgramVersionTermAssociationAcademicYear();
		faProgramVersionTermAssociationAcademicYear1.academicYearSequence = (int) Math
				.round(Double.parseDouble(academicYearSequence1));
		faProgramVersionTermAssociationAcademicYear1.termIdsList = termIdsList1;

		FaProgramVersionTermAssociationAcademicYear faProgramVersionTermAssociationAcademicYear2 = new FaProgramVersionTermAssociationAcademicYear();
		faProgramVersionTermAssociationAcademicYear2.academicYearSequence = (int) Math
				.round(Double.parseDouble(academicYearSequence2));
		faProgramVersionTermAssociationAcademicYear2.termIdsList = termIdsList2;

		FaProgramVersionTermAssociationAcademicYear faProgramVersionTermAssociationAcademicYear3 = new FaProgramVersionTermAssociationAcademicYear();
		faProgramVersionTermAssociationAcademicYear3.academicYearSequence = (int) Math
				.round(Double.parseDouble(academicYearSequence3));
		faProgramVersionTermAssociationAcademicYear3.termIdsList = termIdsList3;

		List<FaProgramVersionTermAssociationAcademicYear> faProgramVersionTermAssociationAcademicYearList = new ArrayList<FaProgramVersionTermAssociationAcademicYear>();
		faProgramVersionTermAssociationAcademicYearList.add(faProgramVersionTermAssociationAcademicYear1);
		faProgramVersionTermAssociationAcademicYearList.add(faProgramVersionTermAssociationAcademicYear2);
		faProgramVersionTermAssociationAcademicYearList.add(faProgramVersionTermAssociationAcademicYear3);

		List<Integer> campusIdsList = new ArrayList<Integer>();
		campusIdsList.add(5);

		List<Integer> termsInAcademicYear = new ArrayList<Integer>();

		FaProgramVersionTermProgramAssociationSaveRequest faProgramVersionTermProgramAssociationSaveRequest = new FaProgramVersionTermProgramAssociationSaveRequest();
		faProgramVersionTermProgramAssociationSaveRequest.programVersionId = (int) Math
				.round(Double.parseDouble(Id_programVersion_responsepayload_data.get(Count_Edit)));
		faProgramVersionTermProgramAssociationSaveRequest.shiftSchoolStartDateId = 1357;
		faProgramVersionTermProgramAssociationSaveRequest.campusIdsList = campusIdsList;
		faProgramVersionTermProgramAssociationSaveRequest.termAssociationAcademicYears = faProgramVersionTermAssociationAcademicYearList;
		faProgramVersionTermProgramAssociationSaveRequest.termsInAcademicYear = termsInAcademicYear;

		FaProgramVersionsAcademicYearAcademicYear faProgramVersionsAcademicYearAcademicYear = new FaProgramVersionsAcademicYearAcademicYear();
		faProgramVersionsAcademicYearAcademicYear.id = 0;
		faProgramVersionsAcademicYearAcademicYear.code = faAcademicYearList.get(1);
		faProgramVersionsAcademicYearAcademicYear.name = faAcademicYearList.get(2);
		faProgramVersionsAcademicYearAcademicYear.defaultWeeksInAcademicYear = (int) Math
				.round(Double.parseDouble(defaultWeeksInAcademicYear1));
		faProgramVersionsAcademicYearAcademicYear.isDirty = Boolean.parseBoolean(isDirty);

		FaProgramVersionsAcademicYearBudget faProgramVersionsAcademicYearBudget = new FaProgramVersionsAcademicYearBudget();
		faProgramVersionsAcademicYearBudget.id = (int) Math.round(Double.parseDouble(faBudgetList.get(0)));
		faProgramVersionsAcademicYearBudget.name = faBudgetList.get(1);
		faProgramVersionsAcademicYearBudget.code = faBudgetList.get(2);
		faProgramVersionsAcademicYearBudget.isDirty = Boolean.parseBoolean(isBudgetDirty);

		FaProgramVersionsAcademicYearEnrollmentStatus faProgramVersionsAcademicYearEnrollmentStatus = new FaProgramVersionsAcademicYearEnrollmentStatus();
		faProgramVersionsAcademicYearEnrollmentStatus.id = 0;
		faProgramVersionsAcademicYearEnrollmentStatus.name = AcademicYearEnrollmentStatusname;
		faProgramVersionsAcademicYearEnrollmentStatus.code = "";

		FaProgramVersionAcademicYearList faProgramVersionAcademicYearList = new FaProgramVersionAcademicYearList();
		faProgramVersionAcademicYearList.id = -1;
		faProgramVersionAcademicYearList.entityState = 0;
		faProgramVersionAcademicYearList.termsInAcademicYear = 45;
		faProgramVersionAcademicYearList.isTermsInAcademicYearDirty = false;
		faProgramVersionAcademicYearList.sequence = (int) Math.round(Double.parseDouble(sequence));
		faProgramVersionAcademicYearList.enrollmentStatusId = 0;
		faProgramVersionAcademicYearList.enrollmentStatus = faProgramVersionsAcademicYearEnrollmentStatus;
		faProgramVersionAcademicYearList.enrollmentStatusName = enrollmentStatusName;
		faProgramVersionAcademicYearList.budgetName = faBudgetList.get(1);
		faProgramVersionAcademicYearList.academicYearName = faAcademicYearList.get(2);
		faProgramVersionAcademicYearList.budgetId = (int) Math.round(Double.parseDouble(faBudgetList.get(0)));
		faProgramVersionAcademicYearList.budget = faProgramVersionsAcademicYearBudget;
		faProgramVersionAcademicYearList.academicYearId = (int) Math
				.round(Double.parseDouble(faAcademicYearList.get(0)));
		faProgramVersionAcademicYearList.academicYear = faProgramVersionsAcademicYearAcademicYear;
		faProgramVersionAcademicYearList.defaultWeeksInAcademicYear = (int) Math
				.round(Double.parseDouble(defaultWeeksInAcademicYear1));
		faProgramVersionAcademicYearList.creditHoursInAcademicYear = 0;
		faProgramVersionAcademicYearList.isCreditHoursInAcademicYearDirty = Boolean
				.parseBoolean(isCreditHoursInAcademicYearDirty);
		faProgramVersionAcademicYearList.programVersionId = (int) Math
				.round(Double.parseDouble(Id_programVersion_responsepayload_data.get(Count_Edit)));
		faProgramVersionAcademicYearList.isActive = Boolean.parseBoolean(isActive);
		faProgramVersionAcademicYearList.clockToCreditRateFlag = (int) Math
				.round(Double.parseDouble(clockToCreditRateFlag));

		List<FaProgramVersionAcademicYearList> faProgramVersionAcademicYearListArrayList = new ArrayList<FaProgramVersionAcademicYearList>();
		faProgramVersionAcademicYearListArrayList.add(faProgramVersionAcademicYearList);

		List<Integer> programVersionIdsToCopy = new ArrayList<Integer>();

		List<Integer> nonTermPaymentPeriodList = new ArrayList<Integer>();

		List<Integer> programVersionPellCoaDetailList = new ArrayList<Integer>();

		FAProgramVersionsDetails faProgramVersionsDetails = new FAProgramVersionsDetails();
		faProgramVersionsDetails.isExcludedCrmIntegration = Boolean.parseBoolean(isExcludedCrmIntegration);
		faProgramVersionsDetails.programName = null;
		faProgramVersionsDetails.isHoursPerYear = Boolean.parseBoolean(isExcludedCrmIntegration);
		faProgramVersionsDetails.programCode = null;
		faProgramVersionsDetails.transferCreditRestrictionList = null;
		faProgramVersionsDetails.id = (int) Math
				.round(Double.parseDouble(Id_programVersion_responsepayload_data.get(Count_Edit)));
		faProgramVersionsDetails.academicCalendar = academicCalendar;
		faProgramVersionsDetails.academicYearType = academicYearType;
		faProgramVersionsDetails.activeUnits = (int) Math.round(Double.parseDouble(activeUnits));
		faProgramVersionsDetails.activeWhen = activeWhen;
		faProgramVersionsDetails.attendanceWithdrawalDateOption = attendanceWithdrawalDateOption;
		faProgramVersionsDetails.billingMethodId = null;
		faProgramVersionsDetails.budgetId = (int) Math.round(Double.parseDouble(faBudgetList.get(0)));
		faProgramVersionsDetails.campusGroupId = (int) Math
				.round(Double.parseDouble(campusGroupId_responsepayload_editdata.get(Count_Edit)));
		faProgramVersionsDetails.campusLicenseUnit = campusLicenseUnit;
		faProgramVersionsDetails.censusPeriod = null;
		faProgramVersionsDetails.censusRecurrence = null;
		faProgramVersionsDetails.cipCode = cipCode;
		faProgramVersionsDetails.clockHoursRequired = (int) Math.round(Double.parseDouble(clockHoursRequired));
		faProgramVersionsDetails.clockToCreditRate = 0;
		faProgramVersionsDetails.clockToCreditRatePriorJuly2011 = 0;
		faProgramVersionsDetails.code = code;
		faProgramVersionsDetails.courseFulfillmentOrderDetailId = null;
		faProgramVersionsDetails.courseRefundPolicyId = null;
		faProgramVersionsDetails.createdDateTime = "2020/05/31 22:12:45";
		faProgramVersionsDetails.creditBalanceScheduleDateType = null;
		faProgramVersionsDetails.creditBalanceScheduleDateTypeOffsetDays = null;
		faProgramVersionsDetails.creditHoursRequired = (int) Math.round(Double.parseDouble(creditHoursRequired));
		faProgramVersionsDetails.creditsInFullAcademicYear = (int) Math
				.round(Double.parseDouble(creditsInFullAcademicYear));
		faProgramVersionsDetails.creditsYear1 = 0;
		faProgramVersionsDetails.creditsYear2 = 0;
		faProgramVersionsDetails.creditsYear3 = 0;
		faProgramVersionsDetails.creditsYear4 = 0;
		faProgramVersionsDetails.currentYearCipCodeId = (int) Math.round(Double.parseDouble(currectCIPCODEList.get(0)));
		faProgramVersionsDetails.daysBetweenLessons = null;
		faProgramVersionsDetails.defaultSpecialProgramType = defaultSpecialProgramType;
		faProgramVersionsDetails.degreeId = (int) Math.round(Double.parseDouble(addegreeList.get(0)));
		faProgramVersionsDetails.doNotUsePaymentPeriods = null;
		faProgramVersionsDetails.englishProficiencyNotRequiredReason = englishProficiencyNotRequiredReason;
		faProgramVersionsDetails.expectedCreditsPerTerm = (int) Math.round(Double.parseDouble(expectedCreditsPerTerm));
		faProgramVersionsDetails.expectedHoursPerWeekExternship = 0;
		faProgramVersionsDetails.externshipClockHours = (int) Math.round(Double.parseDouble(externshipClockHours));
		faProgramVersionsDetails.externshipCreditHours = (int) Math.round(Double.parseDouble(externshipCreditHours));
		faProgramVersionsDetails.financialAidCredits = 0;
		faProgramVersionsDetails.firstMonthPercentage = null;
		faProgramVersionsDetails.fullTimeMin = (int) Math.round(Double.parseDouble(fullTimeMin));
		faProgramVersionsDetails.gradeLevelPromotionRuleId = (int) Math
				.round(Double.parseDouble(adGradeLevelPromotionList.get(0)));
		faProgramVersionsDetails.gradeScaleId = (int) Math.round(Double.parseDouble(adGradeScaleList.get(0)));
		faProgramVersionsDetails.halfTimeMin = (int) Math.round(Double.parseDouble(halfTimeMin));
		faProgramVersionsDetails.hoursYear1 = 0;
		faProgramVersionsDetails.hoursYear2 = 0;
		faProgramVersionsDetails.hoursYear3 = 0;
		faProgramVersionsDetails.hoursYear4 = 0;
		faProgramVersionsDetails.isActive = Boolean.parseBoolean(isActive);
		faProgramVersionsDetails.isBudgetAutoRecalculated = Boolean.parseBoolean(isBudgetAutoRecalculated);
		faProgramVersionsDetails.isCensusDateTriggerEnabled = null;
		faProgramVersionsDetails.isClockToCredit = Boolean.parseBoolean(isClockToCredit);
		faProgramVersionsDetails.isClockToCreditPriorJuly2011 = Boolean.parseBoolean(isClockToCreditPriorJuly2011);
		faProgramVersionsDetails.isDegreeProgram = Boolean.parseBoolean(isDegreeProgram);
		faProgramVersionsDetails.isEnglishProficiencyRequired = Boolean.parseBoolean(isEnglishProficiencyRequired);
		faProgramVersionsDetails.isExternStartDateRequired = Boolean.parseBoolean(isExternStartDateRequired);
		faProgramVersionsDetails.isGpaCalcWeighted = Boolean.parseBoolean(isGpaCalcWeighted);
		faProgramVersionsDetails.isIncrementalBillEarn = Boolean.parseBoolean(isIncrementalBillEarn);
		faProgramVersionsDetails.isNonSe9W = Boolean.parseBoolean(isNonSe9W);
		faProgramVersionsDetails.isOutsideProgramRegistrationAllowed = Boolean
				.parseBoolean(isOutsideProgramRegistrationAllowed);
		faProgramVersionsDetails.isRequiredToTakeAttendance = Boolean.parseBoolean(isRequiredToTakeAttendance);
		faProgramVersionsDetails.isRevenueIncludedIn9010Report = Boolean.parseBoolean(isRevenueIncludedIn9010Report);
		faProgramVersionsDetails.isSapBasedOnPaymentPeriod = Boolean.parseBoolean(isSapBasedOnPaymentPeriod);
		faProgramVersionsDetails.isScheduledHoursUsed = Boolean.parseBoolean(isScheduledHoursUsed);
		faProgramVersionsDetails.isTitleIvEligible = Boolean.parseBoolean(isTitleIvEligible);
		faProgramVersionsDetails.isUndeclared = Boolean.parseBoolean(isUndeclared);
		faProgramVersionsDetails.isWaitListingRestricted = Boolean.parseBoolean(isWaitListingRestricted);
		faProgramVersionsDetails.lastModifiedDateTime = "2020/05/31 22:12:45";
		faProgramVersionsDetails.lastModifiedUserId = 34719;
		faProgramVersionsDetails.lessThanHalfTimeMin = (int) Math.round(Double.parseDouble(lessThanHalfTimeMin));
		faProgramVersionsDetails.maxOnlineRegistrationCredits = null;
		faProgramVersionsDetails.minimumGpa = (int) Math.round(Double.parseDouble(minimumGpa));
		faProgramVersionsDetails.minOnlineRegistrationCredits = null;
		faProgramVersionsDetails.monthsInTerm = 0;
		faProgramVersionsDetails.name = name;
		faProgramVersionsDetails.note = note;
		faProgramVersionsDetails.numberExtensions = null;
		faProgramVersionsDetails.numberPaymentPeriodsNonTitleIvAcademicYear = 0;
		faProgramVersionsDetails.numberPaymentPeriodsTitleIvAcademicYear = 0;
		faProgramVersionsDetails.outsideCourseWorkHours = 0;
		faProgramVersionsDetails.paymentMethodology = paymentMethodology;
		faProgramVersionsDetails.programGroupId = null;
		faProgramVersionsDetails.programId = adProgramList.get(0);
		faProgramVersionsDetails.programLengthType = programLengthType;
		faProgramVersionsDetails.programLengthValue = programLengthValue;
		faProgramVersionsDetails.programVersionUnitType = programVersionUnitType;
		faProgramVersionsDetails.proRateCostFlag = 0;
		faProgramVersionsDetails.refundBasedOn = "";
		faProgramVersionsDetails.requiresAreaOfStudy = Boolean.parseBoolean(requiresAreaOfStudy);
		faProgramVersionsDetails.returnOfTitleIvEnrollmentPeriodType = null;
		faProgramVersionsDetails.returnOfTitleIvPeriod = null;
		faProgramVersionsDetails.returnOfTitleIvPeriodReenroll = null;
		faProgramVersionsDetails.revenueEarningMethodId = null;
		faProgramVersionsDetails.revenuePeriod = null;
		faProgramVersionsDetails.revenueUnits = null;
		faProgramVersionsDetails.rowVersion = rowVersion_responsepayload_data;
		faProgramVersionsDetails.sapTableId = (int) Math.round(Double.parseDouble(adSapTableList.get(0)));
		faProgramVersionsDetails.schoolDefinedField1 = schoolDefinedField1;
		faProgramVersionsDetails.schoolDefinedField1 = schoolDefinedField2;
		faProgramVersionsDetails.schoolDefinedField1 = schoolDefinedField3;
		faProgramVersionsDetails.schoolDefinedField1 = schoolDefinedField4;
		faProgramVersionsDetails.servicerProgramIdentifier = servicerProgramIdentifier;
		faProgramVersionsDetails.summerTermCredits = (int) Math.round(Double.parseDouble(summerTermCredits));
		faProgramVersionsDetails.summerTermHeaderOrTrailer = (int) Math
				.round(Double.parseDouble(summerTermHeaderOrTrailer));
		faProgramVersionsDetails.summerTermPackaging = Boolean.parseBoolean(summerTermPackaging);
		faProgramVersionsDetails.termsInAcademicYear = (int) Math.round(Double.parseDouble(termsInAcademicYear9));
		faProgramVersionsDetails.threeQuarterrTimeMin = (int) Math.round(Double.parseDouble(threeQuarterrTimeMin));
		faProgramVersionsDetails.totalApprovedTransferCredits = 0;
		faProgramVersionsDetails.totalBooksSuppliesCost = null;
		faProgramVersionsDetails.totalLessons = 0;
		faProgramVersionsDetails.totalMonths = (int) Math.round(Double.parseDouble(totalMonths));
		faProgramVersionsDetails.totalOtherCost = null;
		faProgramVersionsDetails.totalTuitionCost = null;
		faProgramVersionsDetails.totalWeeks = (int) Math.round(Double.parseDouble(totalWeeks));
		faProgramVersionsDetails.transcriptDescription = transcriptDescription;
		faProgramVersionsDetails.weeksInFullAcademicYear = (int) Math
				.round(Double.parseDouble(weeksInFullAcademicYear));
		faProgramVersionsDetails.weeksInTerm = 0;
		faProgramVersionsDetails.campusList = null;
		faProgramVersionsDetails.originalState = "";
		faProgramVersionsDetails.secureState = "";
		faProgramVersionsDetails.entityState = UtilClass.new_entityState;
		faProgramVersionsDetails.programGroupIdList = null;

		FaProgramVersionPayload faProgramVersionPayload = new FaProgramVersionPayload();
		faProgramVersionPayload.programVersionDetail = faProgramVersionsDetails;
		faProgramVersionPayload.programVersionAcademicYearList = faProgramVersionAcademicYearListArrayList;
		faProgramVersionPayload.programVersionBudgetCostList = faProgramVersionBudgetCostListArrayList;
		faProgramVersionPayload.programVersionPellCoaDetailList = programVersionPellCoaDetailList;
		faProgramVersionPayload.termProgramAssociationSaveRequest = faProgramVersionTermProgramAssociationSaveRequest;
		faProgramVersionPayload.programVersionIdsToCopy = programVersionIdsToCopy;
		faProgramVersionPayload.nonTermPaymentPeriodList = nonTermPaymentPeriodList;
		faProgramVersionPayload.paymentPeriodClockToCreditConversionRate = null;
		faProgramVersionPayload.isClockToCreditConfigured = false;

		NewEditFaPayLoad newEditFaPayLoad = new NewEditFaPayLoad();
		newEditFaPayLoad.payload = faProgramVersionPayload;

		String data_ProgramVersion = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newEditFaPayLoad);

		System.out.println("FAProgram Version Edit Payload: " + data_ProgramVersion);

		request.body(newEditFaPayLoad);

		response = request.post("/Save");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		String terms_Assocation_Validationsmessage_responsepayload_editdata = (String) jsonPathEvaluator
				.getList("notifications.message").get(0);

		Assert.assertEquals(terms_Assocation_Validationsmessage_responsepayload_editdata,
				"You must select the number of terms for a full academic year based on the academic calendar. The following academic year sequences are missing terms: 1,2,3.");

		Count_Edit = Count_Edit + 1;

		Assert.assertEquals(response.getStatusCode(), 400);

	}

	@Test(dataProvider = "setNewFAProgramVersionData", priority = 3)
	public void CreateFAProgramVersions(String code, String name, String creditHoursRequired, String clockHoursRequired,
			String expectedCreditsPerTerm, String fullTimeMin, String halfTimeMin, String lessThanHalfTimeMin,
			String threeQuarterrTimeMin, String totalMonths, String totalWeeks, String transcriptDescription,
			String minimumGpa, String programLengthType, String programLengthValue, String programVersionUnitType,
			String academicCalendar, String academicYearType, String creditsInFullAcademicYear,
			String isExcludedCrmIntegration, String isHoursPerYear, String activeUnits, String activeWhen,
			String campusLicenseUnit, String cipCode, String defaultSpecialProgramType, String isActive,
			String isBudgetAutoRecalculated, String isClockToCredit, String isClockToCreditPriorJuly2011,
			String isDegreeProgram, String isEnglishProficiencyRequired, String isExternStartDateRequired,
			String isGpaCalcWeighted, String isIncrementalBillEarn, String isNonSe9W,
			String isOutsideProgramRegistrationAllowed, String isRequiredToTakeAttendance,
			String isRevenueIncludedIn9010Report, String isSapBasedOnPaymentPeriod, String isScheduledHoursUsed,
			String isTitleIvEligible, String isUndeclared, String isWaitListingRestricted, String sequence,
			String tuitionCost, String booksSuppliesCost, String otherCost, String total, String academicYearSequence1,
			String academicYearSequence2, String academicYearSequence3, String defaultWeeksInAcademicYear,
			String isDirty, String isBudgetDirty, String AcademicYearEnrollmentStatusname, String enrollmentStatusName,
			String defaultWeeksInAcademicYear1, String isCreditHoursInAcademicYearDirty, String clockToCreditRateFlag,
			String attendanceWithdrawalDateOption, String englishProficiencyNotRequiredReason,
			String externshipClockHours, String externshipCreditHours, String note, String paymentMethodology,
			String requiresAreaOfStudy, String schoolDefinedField1, String schoolDefinedField2,
			String schoolDefinedField3, String schoolDefinedField4, String servicerProgramIdentifier,
			String summerTermCredits, String summerTermHeaderOrTrailer, String summerTermPackaging,
			String termsInAcademicYear9, String weeksInFullAcademicYear) throws JsonProcessingException {

		GetFAProgramVersions getfaProgramVersions = new GetFAProgramVersions();
		getfaProgramVersions.programVersionId = (int) Math
				.round(Double.parseDouble(Id_programVersion_responsepayload_data.get(Count)));

		GetFaProgramVersionsPayload getFaProgramVersionsPayload = new GetFaProgramVersionsPayload();
		getFaProgramVersionsPayload.payload = getfaProgramVersions;

		String data_getProgramVersions = objMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(getFaProgramVersionsPayload);

		System.out.println("Get Program Version Payload: " + data_getProgramVersions);

		request.body(data_getProgramVersions);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		rowVersion_responsepayload_data = jsonPathEvaluator.getString("payload.data.programVersionDetail.rowVersion");

		Assert.assertEquals(response.getStatusCode(), 200);

		FaProgramVersionBudgetCostList faProgramVersionBudgetCostList = new FaProgramVersionBudgetCostList();
		faProgramVersionBudgetCostList.id = -1;
		faProgramVersionBudgetCostList.entityState = 0;
		faProgramVersionBudgetCostList.sequence = (int) Math.round(Double.parseDouble(sequence));
		faProgramVersionBudgetCostList.effectiveDate = "2020/06/01 17:01:33";
		faProgramVersionBudgetCostList.programVersionId = (int) Math
				.round(Double.parseDouble(Id_programVersion_responsepayload_data.get(Count)));
		faProgramVersionBudgetCostList.tuitionCost = (int) Math.round(Double.parseDouble(tuitionCost));
		;
		faProgramVersionBudgetCostList.booksSuppliesCost = (int) Math.round(Double.parseDouble(booksSuppliesCost));
		faProgramVersionBudgetCostList.otherCost = (int) Math.round(Double.parseDouble(otherCost));
		faProgramVersionBudgetCostList.total = (int) Math.round(Double.parseDouble(total));

		List<FaProgramVersionBudgetCostList> faProgramVersionBudgetCostListArrayList = new ArrayList<FaProgramVersionBudgetCostList>();
		faProgramVersionBudgetCostListArrayList.add(faProgramVersionBudgetCostList);

		List<Integer> termIdsList1 = new ArrayList<Integer>();
		termIdsList1.add(15422);
		termIdsList1.add(15423);
		termIdsList1.add(15424);
		termIdsList1.add(15425);

		List<Integer> termIdsList2 = new ArrayList<Integer>();
		termIdsList2.add(15426);
		termIdsList2.add(15427);
		termIdsList2.add(15428);
		termIdsList2.add(15429);

		List<Integer> termIdsList3 = new ArrayList<Integer>();
		termIdsList3.add(15430);
		termIdsList3.add(15431);
		termIdsList3.add(15432);
		termIdsList3.add(15433);

		FaProgramVersionTermAssociationAcademicYear faProgramVersionTermAssociationAcademicYear1 = new FaProgramVersionTermAssociationAcademicYear();
		faProgramVersionTermAssociationAcademicYear1.academicYearSequence = (int) Math
				.round(Double.parseDouble(academicYearSequence1));
		faProgramVersionTermAssociationAcademicYear1.termIdsList = termIdsList1;

		FaProgramVersionTermAssociationAcademicYear faProgramVersionTermAssociationAcademicYear2 = new FaProgramVersionTermAssociationAcademicYear();
		faProgramVersionTermAssociationAcademicYear2.academicYearSequence = (int) Math
				.round(Double.parseDouble(academicYearSequence2));
		faProgramVersionTermAssociationAcademicYear2.termIdsList = termIdsList2;

		FaProgramVersionTermAssociationAcademicYear faProgramVersionTermAssociationAcademicYear3 = new FaProgramVersionTermAssociationAcademicYear();
		faProgramVersionTermAssociationAcademicYear3.academicYearSequence = (int) Math
				.round(Double.parseDouble(academicYearSequence3));
		faProgramVersionTermAssociationAcademicYear3.termIdsList = termIdsList3;

		List<FaProgramVersionTermAssociationAcademicYear> faProgramVersionTermAssociationAcademicYearList = new ArrayList<FaProgramVersionTermAssociationAcademicYear>();
		faProgramVersionTermAssociationAcademicYearList.add(faProgramVersionTermAssociationAcademicYear1);
		faProgramVersionTermAssociationAcademicYearList.add(faProgramVersionTermAssociationAcademicYear2);
		faProgramVersionTermAssociationAcademicYearList.add(faProgramVersionTermAssociationAcademicYear3);

		List<Integer> campusIdsList = new ArrayList<Integer>();
		campusIdsList.add(5);

		List<Integer> termsInAcademicYear = new ArrayList<Integer>();

		FaProgramVersionTermProgramAssociationSaveRequest faProgramVersionTermProgramAssociationSaveRequest = new FaProgramVersionTermProgramAssociationSaveRequest();
		faProgramVersionTermProgramAssociationSaveRequest.programVersionId = (int) Math
				.round(Double.parseDouble(Id_programVersion_responsepayload_data.get(Count)));
		faProgramVersionTermProgramAssociationSaveRequest.shiftSchoolStartDateId = 1357;
		faProgramVersionTermProgramAssociationSaveRequest.campusIdsList = campusIdsList;
		faProgramVersionTermProgramAssociationSaveRequest.termAssociationAcademicYears = faProgramVersionTermAssociationAcademicYearList;
		faProgramVersionTermProgramAssociationSaveRequest.termsInAcademicYear = termsInAcademicYear;

		FaProgramVersionsAcademicYearAcademicYear faProgramVersionsAcademicYearAcademicYear = new FaProgramVersionsAcademicYearAcademicYear();
		faProgramVersionsAcademicYearAcademicYear.id = 0;
		faProgramVersionsAcademicYearAcademicYear.code = faAcademicYearList.get(1);
		faProgramVersionsAcademicYearAcademicYear.name = faAcademicYearList.get(2);
		faProgramVersionsAcademicYearAcademicYear.defaultWeeksInAcademicYear = (int) Math
				.round(Double.parseDouble(defaultWeeksInAcademicYear1));
		faProgramVersionsAcademicYearAcademicYear.isDirty = Boolean.parseBoolean(isDirty);

		FaProgramVersionsAcademicYearBudget faProgramVersionsAcademicYearBudget = new FaProgramVersionsAcademicYearBudget();
		faProgramVersionsAcademicYearBudget.id = (int) Math.round(Double.parseDouble(faBudgetList.get(0)));
		faProgramVersionsAcademicYearBudget.name = faBudgetList.get(1);
		faProgramVersionsAcademicYearBudget.code = faBudgetList.get(2);
		faProgramVersionsAcademicYearBudget.isDirty = Boolean.parseBoolean(isBudgetDirty);

		FaProgramVersionsAcademicYearEnrollmentStatus faProgramVersionsAcademicYearEnrollmentStatus = new FaProgramVersionsAcademicYearEnrollmentStatus();
		faProgramVersionsAcademicYearEnrollmentStatus.id = 0;
		faProgramVersionsAcademicYearEnrollmentStatus.name = AcademicYearEnrollmentStatusname;
		faProgramVersionsAcademicYearEnrollmentStatus.code = "";

		FaProgramVersionAcademicYearList faProgramVersionAcademicYearList = new FaProgramVersionAcademicYearList();
		faProgramVersionAcademicYearList.id = -1;
		faProgramVersionAcademicYearList.entityState = 0;
		faProgramVersionAcademicYearList.termsInAcademicYear = 45;
		faProgramVersionAcademicYearList.isTermsInAcademicYearDirty = false;
		faProgramVersionAcademicYearList.sequence = (int) Math.round(Double.parseDouble(sequence));
		faProgramVersionAcademicYearList.enrollmentStatusId = 0;
		faProgramVersionAcademicYearList.enrollmentStatus = faProgramVersionsAcademicYearEnrollmentStatus;
		faProgramVersionAcademicYearList.enrollmentStatusName = enrollmentStatusName;
		faProgramVersionAcademicYearList.budgetName = faBudgetList.get(1);
		faProgramVersionAcademicYearList.academicYearName = faAcademicYearList.get(2);
		faProgramVersionAcademicYearList.budgetId = (int) Math.round(Double.parseDouble(faBudgetList.get(0)));
		faProgramVersionAcademicYearList.budget = faProgramVersionsAcademicYearBudget;
		faProgramVersionAcademicYearList.academicYearId = (int) Math
				.round(Double.parseDouble(faAcademicYearList.get(0)));
		faProgramVersionAcademicYearList.academicYear = faProgramVersionsAcademicYearAcademicYear;
		faProgramVersionAcademicYearList.defaultWeeksInAcademicYear = (int) Math
				.round(Double.parseDouble(defaultWeeksInAcademicYear1));
		faProgramVersionAcademicYearList.creditHoursInAcademicYear = 0;
		faProgramVersionAcademicYearList.isCreditHoursInAcademicYearDirty = Boolean
				.parseBoolean(isCreditHoursInAcademicYearDirty);
		faProgramVersionAcademicYearList.programVersionId = (int) Math
				.round(Double.parseDouble(Id_programVersion_responsepayload_data.get(Count)));
		faProgramVersionAcademicYearList.isActive = Boolean.parseBoolean(isActive);
		faProgramVersionAcademicYearList.clockToCreditRateFlag = (int) Math
				.round(Double.parseDouble(clockToCreditRateFlag));

		List<FaProgramVersionAcademicYearList> faProgramVersionAcademicYearListArrayList = new ArrayList<FaProgramVersionAcademicYearList>();
		faProgramVersionAcademicYearListArrayList.add(faProgramVersionAcademicYearList);

		List<Integer> programVersionIdsToCopy = new ArrayList<Integer>();

		List<Integer> nonTermPaymentPeriodList = new ArrayList<Integer>();

		List<Integer> programVersionPellCoaDetailList = new ArrayList<Integer>();

		FAProgramVersionsDetails faProgramVersionsDetails = new FAProgramVersionsDetails();
		faProgramVersionsDetails.isExcludedCrmIntegration = Boolean.parseBoolean(isExcludedCrmIntegration);
		faProgramVersionsDetails.programName = null;
		faProgramVersionsDetails.isHoursPerYear = Boolean.parseBoolean(isExcludedCrmIntegration);
		faProgramVersionsDetails.programCode = null;
		faProgramVersionsDetails.transferCreditRestrictionList = null;
		faProgramVersionsDetails.id = (int) Math
				.round(Double.parseDouble(Id_programVersion_responsepayload_data.get(Count)));
		faProgramVersionsDetails.academicCalendar = academicCalendar;
		faProgramVersionsDetails.academicYearType = academicYearType;
		faProgramVersionsDetails.activeUnits = (int) Math.round(Double.parseDouble(activeUnits));
		faProgramVersionsDetails.activeWhen = activeWhen;
		faProgramVersionsDetails.attendanceWithdrawalDateOption = attendanceWithdrawalDateOption;
		faProgramVersionsDetails.billingMethodId = null;
		faProgramVersionsDetails.budgetId = (int) Math.round(Double.parseDouble(faBudgetList.get(0)));
		faProgramVersionsDetails.campusGroupId = (int) Math
				.round(Double.parseDouble(campusGroupId_responsepayload_editdata.get(Count)));
		faProgramVersionsDetails.campusLicenseUnit = campusLicenseUnit;
		faProgramVersionsDetails.censusPeriod = null;
		faProgramVersionsDetails.censusRecurrence = null;
		faProgramVersionsDetails.cipCode = cipCode;
		faProgramVersionsDetails.clockHoursRequired = (int) Math.round(Double.parseDouble(clockHoursRequired));
		faProgramVersionsDetails.clockToCreditRate = 0;
		faProgramVersionsDetails.clockToCreditRatePriorJuly2011 = 0;
		faProgramVersionsDetails.code = code;
		faProgramVersionsDetails.courseFulfillmentOrderDetailId = null;
		faProgramVersionsDetails.courseRefundPolicyId = null;
		faProgramVersionsDetails.createdDateTime = "2020/05/31 22:12:45";
		faProgramVersionsDetails.creditBalanceScheduleDateType = null;
		faProgramVersionsDetails.creditBalanceScheduleDateTypeOffsetDays = null;
		faProgramVersionsDetails.creditHoursRequired = (int) Math.round(Double.parseDouble(creditHoursRequired));
		faProgramVersionsDetails.creditsInFullAcademicYear = (int) Math
				.round(Double.parseDouble(creditsInFullAcademicYear));
		faProgramVersionsDetails.creditsYear1 = 0;
		faProgramVersionsDetails.creditsYear2 = 0;
		faProgramVersionsDetails.creditsYear3 = 0;
		faProgramVersionsDetails.creditsYear4 = 0;
		faProgramVersionsDetails.currentYearCipCodeId = (int) Math.round(Double.parseDouble(currectCIPCODEList.get(0)));
		faProgramVersionsDetails.daysBetweenLessons = null;
		faProgramVersionsDetails.defaultSpecialProgramType = defaultSpecialProgramType;
		faProgramVersionsDetails.degreeId = (int) Math.round(Double.parseDouble(addegreeList.get(0)));
		faProgramVersionsDetails.doNotUsePaymentPeriods = null;
		faProgramVersionsDetails.englishProficiencyNotRequiredReason = englishProficiencyNotRequiredReason;
		faProgramVersionsDetails.expectedCreditsPerTerm = (int) Math.round(Double.parseDouble(expectedCreditsPerTerm));
		faProgramVersionsDetails.expectedHoursPerWeekExternship = 0;
		faProgramVersionsDetails.externshipClockHours = (int) Math.round(Double.parseDouble(externshipClockHours));
		faProgramVersionsDetails.externshipCreditHours = (int) Math.round(Double.parseDouble(externshipCreditHours));
		faProgramVersionsDetails.financialAidCredits = 0;
		faProgramVersionsDetails.firstMonthPercentage = null;
		faProgramVersionsDetails.fullTimeMin = (int) Math.round(Double.parseDouble(fullTimeMin));
		faProgramVersionsDetails.gradeLevelPromotionRuleId = (int) Math
				.round(Double.parseDouble(adGradeLevelPromotionList.get(0)));
		faProgramVersionsDetails.gradeScaleId = (int) Math.round(Double.parseDouble(adGradeScaleList.get(0)));
		faProgramVersionsDetails.halfTimeMin = (int) Math.round(Double.parseDouble(halfTimeMin));
		faProgramVersionsDetails.hoursYear1 = 0;
		faProgramVersionsDetails.hoursYear2 = 0;
		faProgramVersionsDetails.hoursYear3 = 0;
		faProgramVersionsDetails.hoursYear4 = 0;
		faProgramVersionsDetails.isActive = Boolean.parseBoolean(isActive);
		faProgramVersionsDetails.isBudgetAutoRecalculated = Boolean.parseBoolean(isBudgetAutoRecalculated);
		faProgramVersionsDetails.isCensusDateTriggerEnabled = null;
		faProgramVersionsDetails.isClockToCredit = Boolean.parseBoolean(isClockToCredit);
		faProgramVersionsDetails.isClockToCreditPriorJuly2011 = Boolean.parseBoolean(isClockToCreditPriorJuly2011);
		faProgramVersionsDetails.isDegreeProgram = Boolean.parseBoolean(isDegreeProgram);
		faProgramVersionsDetails.isEnglishProficiencyRequired = Boolean.parseBoolean(isEnglishProficiencyRequired);
		faProgramVersionsDetails.isExternStartDateRequired = Boolean.parseBoolean(isExternStartDateRequired);
		faProgramVersionsDetails.isGpaCalcWeighted = Boolean.parseBoolean(isGpaCalcWeighted);
		faProgramVersionsDetails.isIncrementalBillEarn = Boolean.parseBoolean(isIncrementalBillEarn);
		faProgramVersionsDetails.isNonSe9W = Boolean.parseBoolean(isNonSe9W);
		faProgramVersionsDetails.isOutsideProgramRegistrationAllowed = Boolean
				.parseBoolean(isOutsideProgramRegistrationAllowed);
		faProgramVersionsDetails.isRequiredToTakeAttendance = Boolean.parseBoolean(isRequiredToTakeAttendance);
		faProgramVersionsDetails.isRevenueIncludedIn9010Report = Boolean.parseBoolean(isRevenueIncludedIn9010Report);
		faProgramVersionsDetails.isSapBasedOnPaymentPeriod = Boolean.parseBoolean(isSapBasedOnPaymentPeriod);
		faProgramVersionsDetails.isScheduledHoursUsed = Boolean.parseBoolean(isScheduledHoursUsed);
		faProgramVersionsDetails.isTitleIvEligible = Boolean.parseBoolean(isTitleIvEligible);
		faProgramVersionsDetails.isUndeclared = Boolean.parseBoolean(isUndeclared);
		faProgramVersionsDetails.isWaitListingRestricted = Boolean.parseBoolean(isWaitListingRestricted);
		faProgramVersionsDetails.lastModifiedDateTime = "2020/05/31 22:12:45";
		faProgramVersionsDetails.lastModifiedUserId = 34719;
		faProgramVersionsDetails.lessThanHalfTimeMin = (int) Math.round(Double.parseDouble(lessThanHalfTimeMin));
		faProgramVersionsDetails.maxOnlineRegistrationCredits = null;
		faProgramVersionsDetails.minimumGpa = (int) Math.round(Double.parseDouble(minimumGpa));
		faProgramVersionsDetails.minOnlineRegistrationCredits = null;
		faProgramVersionsDetails.monthsInTerm = 0;
		faProgramVersionsDetails.name = name;
		faProgramVersionsDetails.note = note;
		faProgramVersionsDetails.numberExtensions = null;
		faProgramVersionsDetails.numberPaymentPeriodsNonTitleIvAcademicYear = 0;
		faProgramVersionsDetails.numberPaymentPeriodsTitleIvAcademicYear = 0;
		faProgramVersionsDetails.outsideCourseWorkHours = 0;
		faProgramVersionsDetails.paymentMethodology = paymentMethodology;
		faProgramVersionsDetails.programGroupId = null;
		faProgramVersionsDetails.programId = adProgramList.get(0);
		faProgramVersionsDetails.programLengthType = programLengthType;
		faProgramVersionsDetails.programLengthValue = programLengthValue;
		faProgramVersionsDetails.programVersionUnitType = programVersionUnitType;
		faProgramVersionsDetails.proRateCostFlag = 0;
		faProgramVersionsDetails.refundBasedOn = "";
		faProgramVersionsDetails.requiresAreaOfStudy = Boolean.parseBoolean(requiresAreaOfStudy);
		faProgramVersionsDetails.returnOfTitleIvEnrollmentPeriodType = null;
		faProgramVersionsDetails.returnOfTitleIvPeriod = null;
		faProgramVersionsDetails.returnOfTitleIvPeriodReenroll = null;
		faProgramVersionsDetails.revenueEarningMethodId = null;
		faProgramVersionsDetails.revenuePeriod = null;
		faProgramVersionsDetails.revenueUnits = null;
		faProgramVersionsDetails.rowVersion = rowVersion_responsepayload_data;
		faProgramVersionsDetails.sapTableId = (int) Math.round(Double.parseDouble(adSapTableList.get(0)));
		faProgramVersionsDetails.schoolDefinedField1 = schoolDefinedField1;
		faProgramVersionsDetails.schoolDefinedField1 = schoolDefinedField2;
		faProgramVersionsDetails.schoolDefinedField1 = schoolDefinedField3;
		faProgramVersionsDetails.schoolDefinedField1 = schoolDefinedField4;
		faProgramVersionsDetails.servicerProgramIdentifier = servicerProgramIdentifier;
		faProgramVersionsDetails.summerTermCredits = (int) Math.round(Double.parseDouble(summerTermCredits));
		faProgramVersionsDetails.summerTermHeaderOrTrailer = (int) Math
				.round(Double.parseDouble(summerTermHeaderOrTrailer));
		faProgramVersionsDetails.summerTermPackaging = Boolean.parseBoolean(summerTermPackaging);
		faProgramVersionsDetails.termsInAcademicYear = (int) Math.round(Double.parseDouble(termsInAcademicYear9));
		faProgramVersionsDetails.threeQuarterrTimeMin = (int) Math.round(Double.parseDouble(threeQuarterrTimeMin));
		faProgramVersionsDetails.totalApprovedTransferCredits = 0;
		faProgramVersionsDetails.totalBooksSuppliesCost = null;
		faProgramVersionsDetails.totalLessons = 0;
		faProgramVersionsDetails.totalMonths = (int) Math.round(Double.parseDouble(totalMonths));
		faProgramVersionsDetails.totalOtherCost = null;
		faProgramVersionsDetails.totalTuitionCost = null;
		faProgramVersionsDetails.totalWeeks = (int) Math.round(Double.parseDouble(totalWeeks));
		faProgramVersionsDetails.transcriptDescription = transcriptDescription;
		faProgramVersionsDetails.weeksInFullAcademicYear = (int) Math
				.round(Double.parseDouble(weeksInFullAcademicYear));
		faProgramVersionsDetails.weeksInTerm = 0;
		faProgramVersionsDetails.campusList = null;
		faProgramVersionsDetails.originalState = "";
		faProgramVersionsDetails.secureState = "";
		faProgramVersionsDetails.entityState = UtilClass.new_entityState;
		faProgramVersionsDetails.programGroupIdList = null;

		FaProgramVersionPayload faProgramVersionPayload = new FaProgramVersionPayload();
		faProgramVersionPayload.programVersionDetail = faProgramVersionsDetails;
		faProgramVersionPayload.programVersionAcademicYearList = faProgramVersionAcademicYearListArrayList;
		faProgramVersionPayload.programVersionBudgetCostList = faProgramVersionBudgetCostListArrayList;
		faProgramVersionPayload.programVersionPellCoaDetailList = programVersionPellCoaDetailList;
		faProgramVersionPayload.termProgramAssociationSaveRequest = faProgramVersionTermProgramAssociationSaveRequest;
		faProgramVersionPayload.programVersionIdsToCopy = programVersionIdsToCopy;
		faProgramVersionPayload.nonTermPaymentPeriodList = nonTermPaymentPeriodList;
		faProgramVersionPayload.paymentPeriodClockToCreditConversionRate = null;
		faProgramVersionPayload.isClockToCreditConfigured = false;

		NewEditFaPayLoad newEditFaPayLoad = new NewEditFaPayLoad();
		newEditFaPayLoad.payload = faProgramVersionPayload;

		String data_ProgramVersion = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newEditFaPayLoad);

		System.out.println("FAProgram Version Edit Payload: " + data_ProgramVersion);

		request.body(newEditFaPayLoad);

		response = request.post("/Save");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		name_responsepayload_editdata = jsonPathEvaluator.getString("payload.data.programVersionDetail.name");

		code_responsepayload_editdata = jsonPathEvaluator.getString("payload.data.programVersionDetail.code");

		Assert.assertEquals(name_responsepayload_editdata, name);

		Assert.assertEquals(code_responsepayload_editdata, code);

		Count = Count + 1;

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 3)
	public void DeleteFAProgramVesrions() throws SQLException {

		// =======================================FaProgramAYSeq=============================================

		String FaProgramAYSeq = "delete from FaProgramAYSeq where AdProgramVersionID in("
				+ Id_programVersion_responsepayload_data.get(0) + "," + Id_programVersion_responsepayload_data.get(1)
				+ ")";

		DeleteQuaryfromDatabase(FaProgramAYSeq);

		// =======================================faprogrambudgetcost=============================================

		String faprogrambudgetcost = "delete from faprogrambudgetcost where AdProgramVersionID in("
				+ Id_programVersion_responsepayload_data.get(0) + "," + Id_programVersion_responsepayload_data.get(1)
				+ ")";

		DeleteQuaryfromDatabase(faprogrambudgetcost);

		// =======================================AdTermProgramAssociation=============================================

		String AdTermProgramAssociation = "delete from AdTermProgramAssociation where AdProgramVersionID in("
				+ Id_programVersion_responsepayload_data.get(0) + "," + Id_programVersion_responsepayload_data.get(1)
				+ ")";

		DeleteQuaryfromDatabase(AdTermProgramAssociation);

		// =======================================AdProgramVersionProgramGroup=============================================

		String AdProgramVersionProgramGroup = "delete from AdProgramVersionProgramGroup where AdProgramVersionID in("
				+ Id_programVersion_responsepayload_data.get(0) + "," + Id_programVersion_responsepayload_data.get(1)
				+ ")";

		DeleteQuaryfromDatabase(AdProgramVersionProgramGroup);

		// =======================================AdCipCodeReporting=============================================

		String AdCipCodeReporting = "delete from AdCipCodeReporting where AdProgramVersionID in("
				+ Id_programVersion_responsepayload_data.get(0) + "," + Id_programVersion_responsepayload_data.get(1)
				+ ")";

		DeleteQuaryfromDatabase(AdCipCodeReporting);

		// =======================================AdProgramVersion=============================================

		String AdProgramVersion = "delete from AdProgramVersion where AdProgramVersionID in("
				+ Id_programVersion_responsepayload_data.get(0) + "," + Id_programVersion_responsepayload_data.get(1)
				+ ")";

		DeleteQuaryfromDatabase(AdProgramVersion);

	}

	@DataProvider
	public Object[][] setNewADProgramVersionData() {

		Object[][] data_NewProgramVersion = UtilClass.setData("0", ExcelSheet_FilePatchADProgramVersion);

		return data_NewProgramVersion;
	}

	@DataProvider
	public Object[][] setNewFAProgramVersionData() {

		Object[][] data_NewProgramVersion = UtilClass.setData("0", ExcelSheet_FilePatchFAProgramVersion);

		return data_NewProgramVersion;
	}
}
