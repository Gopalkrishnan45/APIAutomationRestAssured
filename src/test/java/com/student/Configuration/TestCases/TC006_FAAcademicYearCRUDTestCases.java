package com.student.Configuration.TestCases;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.AcademicYearDetails.GetAcademicYear;
import com.student.AcademicYearDetails.GetAcademicYearPayload;
import com.student.AcademicYearDetails.NewEditDisbursementsDatum;
import com.student.AcademicYearDetails.NewEditFAAcademicYearPayload;
import com.student.AcademicYearDetails.NewEditFaAcademicYearDetails;
import com.student.AcademicYearDetails.NewEditfaFundSourceDisbursementsGridDatum;
import com.student.BaseClass.BaseClass;
import com.student.TestData.UtilClass;

import junit.framework.Assert;

public class TC006_FAAcademicYearCRUDTestCases extends BaseClass {

	ObjectMapper objMapper = new ObjectMapper();
	public static String id_response_value;
	public static String name_response_value;
	public static String code_response_value;
	public static String rowVersion_response_value;

	@BeforeMethod
	public void SetUp() {

		String service_URL = "/api/commands/FinancialAid/AcademicYear";

		request = initialization(service_URL);

	}

	@Test(dataProvider = "setNewAcademicYear", priority = 1)
	public void CreateAcademicYear(String code, String createdDateTime, String defaultMonthsinAcademicYear,
			String defaultTermsInAcademicYear, String defaultWeeksInAcademicYear, String defaultWeeksNonEnrollment,
			String disbursement1PctGrant, String disbursement1PctLoan, String disbursement1PctOther,
			String disbursement1PctPell, String disbursement1PctPerkins, String disbursement2PctGrant,
			String disbursement2PctLoan, String disbursement2PctOther, String disbursement2PctPell,
			String disbursement2PctPerkins, String isActive, String lastModifiedDateTime, String lastModifiedUserId,
			String name, String numberGrantDisbursements, String numberLoanDisbursements,
			String numberOtherDisbursements, String numberPellDisbursements, String numberPerkinsDisbursements,
			String fundSourceId1, String fundSourceId2, String fundSourceId3, String fundSourceId4,
			String fundSourceId5, String disbursementNumber1, String disbursementNumber2, String percentage1,
			String percentage2, String fundSourceName1, String fundSourceName2, String fundSourceName3,
			String fundSourceName4, String fundSourceName5, String numberOfDisbursements)
			throws JsonProcessingException {

		// ===============================================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumLoans = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumLoans.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId1));
		newEditDisbursementsDatumLoans.disbursementNumber = (int) Math.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumLoans.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumLoans1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumLoans1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId1));
		newEditDisbursementsDatumLoans1.disbursementNumber = (int) Math.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumLoans1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumLoansList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumLoansList.add(newEditDisbursementsDatumLoans);
		newEditDisbursementsDatumLoansList.add(newEditDisbursementsDatumLoans1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumLoans = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumLoans.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId1));
		newEditfaFundSourceDisbursementsGridDatumLoans.fundSourceName = fundSourceName1;
		newEditfaFundSourceDisbursementsGridDatumLoans.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumLoans.disbursementsData = newEditDisbursementsDatumLoansList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherGrants = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherGrants.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId2));
		newEditDisbursementsDatumOtherGrants.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumOtherGrants.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherGrants1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherGrants1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId2));
		newEditDisbursementsDatumOtherGrants1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumOtherGrants1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumOtherGrantsList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumOtherGrantsList.add(newEditDisbursementsDatumOtherGrants);
		newEditDisbursementsDatumOtherGrantsList.add(newEditDisbursementsDatumOtherGrants1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumOtherGrants = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId2));
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.fundSourceName = fundSourceName2;
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.disbursementsData = newEditDisbursementsDatumOtherGrantsList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherLoans = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherLoans.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId3));
		newEditDisbursementsDatumOtherLoans.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumOtherLoans.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherLoans1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherLoans1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId3));
		newEditDisbursementsDatumOtherLoans1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumOtherLoans1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumOtherLoansList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumOtherLoansList.add(newEditDisbursementsDatumOtherLoans);
		newEditDisbursementsDatumOtherLoansList.add(newEditDisbursementsDatumOtherLoans1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumOtherLoans = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId3));
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.fundSourceName = fundSourceName3;
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.disbursementsData = newEditDisbursementsDatumOtherLoansList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumPellGrant = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPellGrant.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId4));
		newEditDisbursementsDatumPellGrant.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumPellGrant.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumPellGran1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPellGran1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId4));
		newEditDisbursementsDatumPellGran1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumPellGran1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumPellGrantList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumPellGrantList.add(newEditDisbursementsDatumPellGrant);
		newEditDisbursementsDatumPellGrantList.add(newEditDisbursementsDatumPellGran1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumPellGrant = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumPellGrant.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId4));
		newEditfaFundSourceDisbursementsGridDatumPellGrant.fundSourceName = fundSourceName4;
		newEditfaFundSourceDisbursementsGridDatumPellGrant.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumPellGrant.disbursementsData = newEditDisbursementsDatumPellGrantList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumPerkinsLoan = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPerkinsLoan.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId5));
		newEditDisbursementsDatumPerkinsLoan.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumPerkinsLoan.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumPerkinsLoan1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPerkinsLoan1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId1));
		newEditDisbursementsDatumPerkinsLoan1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumPerkinsLoan1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumPerkinsLoanList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumPerkinsLoanList.add(newEditDisbursementsDatumPerkinsLoan);
		newEditDisbursementsDatumPerkinsLoanList.add(newEditDisbursementsDatumPerkinsLoan1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumPerkinsLoan = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId5));
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.fundSourceName = fundSourceName5;
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.disbursementsData = newEditDisbursementsDatumPerkinsLoanList;

		// =============================================================================================

		List<NewEditfaFundSourceDisbursementsGridDatum> newEditfaFundSourceDisbursementsGridDatumList = new ArrayList<NewEditfaFundSourceDisbursementsGridDatum>();
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumLoans);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumOtherGrants);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumOtherLoans);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumPellGrant);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumPerkinsLoan);

		NewEditFaAcademicYearDetails newEditFaAcademicYearDetails = new NewEditFaAcademicYearDetails();
		newEditFaAcademicYearDetails.id = -1;
		newEditFaAcademicYearDetails.code = code;
		newEditFaAcademicYearDetails.createdDateTime = createdDateTime;
		newEditFaAcademicYearDetails.defaultMonthsinAcademicYear = (int) Math
				.round(Double.parseDouble(defaultMonthsinAcademicYear));
		newEditFaAcademicYearDetails.defaultTermsInAcademicYear = (int) Math
				.round(Double.parseDouble(defaultTermsInAcademicYear));
		newEditFaAcademicYearDetails.defaultWeeksInAcademicYear = (int) Math
				.round(Double.parseDouble(defaultWeeksInAcademicYear));
		newEditFaAcademicYearDetails.defaultWeeksNonEnrollment = (int) Math
				.round(Double.parseDouble(defaultWeeksNonEnrollment));
		newEditFaAcademicYearDetails.disbursement1PctGrant = (int) Math
				.round(Double.parseDouble(disbursement1PctGrant));
		newEditFaAcademicYearDetails.disbursement1PctLoan = (int) Math.round(Double.parseDouble(disbursement1PctLoan));
		newEditFaAcademicYearDetails.disbursement1PctOther = (int) Math
				.round(Double.parseDouble(disbursement1PctOther));
		newEditFaAcademicYearDetails.disbursement1PctPell = (int) Math.round(Double.parseDouble(disbursement1PctPell));
		newEditFaAcademicYearDetails.disbursement1PctPerkins = (int) Math
				.round(Double.parseDouble(disbursement1PctPerkins));
		newEditFaAcademicYearDetails.disbursement2PctGrant = (int) Math
				.round(Double.parseDouble(disbursement2PctGrant));
		newEditFaAcademicYearDetails.disbursement2PctLoan = (int) Math.round(Double.parseDouble(disbursement2PctLoan));
		newEditFaAcademicYearDetails.disbursement2PctOther = (int) Math
				.round(Double.parseDouble(disbursement2PctOther));
		newEditFaAcademicYearDetails.disbursement2PctPell = (int) Math.round(Double.parseDouble(disbursement2PctPell));
		newEditFaAcademicYearDetails.disbursement2PctPerkins = (int) Math
				.round(Double.parseDouble(disbursement2PctPerkins));
		newEditFaAcademicYearDetails.isActive = Boolean.parseBoolean(isActive);
		newEditFaAcademicYearDetails.lastModifiedDateTime = lastModifiedDateTime;
		newEditFaAcademicYearDetails.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		newEditFaAcademicYearDetails.name = name;
		newEditFaAcademicYearDetails.numberGrantDisbursements = (int) Math
				.round(Double.parseDouble(numberGrantDisbursements));
		newEditFaAcademicYearDetails.numberLoanDisbursements = (int) Math
				.round(Double.parseDouble(numberLoanDisbursements));
		newEditFaAcademicYearDetails.numberOtherDisbursements = (int) Math
				.round(Double.parseDouble(numberOtherDisbursements));
		newEditFaAcademicYearDetails.numberPellDisbursements = (int) Math
				.round(Double.parseDouble(numberPellDisbursements));
		newEditFaAcademicYearDetails.numberPerkinsDisbursements = (int) Math
				.round(Double.parseDouble(numberPerkinsDisbursements));
		newEditFaAcademicYearDetails.rowVersion = null;
		newEditFaAcademicYearDetails.entityState = UtilClass.new_entityState;
		newEditFaAcademicYearDetails.fundSourceDisbursementsGridData = newEditfaFundSourceDisbursementsGridDatumList;

		NewEditFAAcademicYearPayload newEditFAAcademicYearPayload = new NewEditFAAcademicYearPayload();
		newEditFAAcademicYearPayload.payload = newEditFaAcademicYearDetails;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newEditFAAcademicYearPayload);

		System.out.println(data);

		request.body(newEditFAAcademicYearPayload);

		response = request.post("/SaveNew");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		id_response_value = jsonPathEvaluator.getString("payload.data.id");

		name_response_value = jsonPathEvaluator.getString("payload.data.name");

		code_response_value = jsonPathEvaluator.getString("payload.data.code");

		Assert.assertEquals(name_response_value, name);

		Assert.assertEquals(code_response_value, code);

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2)
	public void getAcademicYear() throws JsonProcessingException {

		GetAcademicYear getAcademicYear = new GetAcademicYear();
		getAcademicYear.id = (int) Math.round(Double.parseDouble(id_response_value));

		GetAcademicYearPayload getAcademicYearPayload = new GetAcademicYearPayload();
		getAcademicYearPayload.payload = getAcademicYear;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getAcademicYearPayload);

		System.out.println(data);

		request.body(getAcademicYearPayload);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		id_response_value = jsonPathEvaluator.getString("payload.data.id");

		rowVersion_response_value = jsonPathEvaluator.getString("payload.data.rowVersion");

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(dataProvider = "setEditAcademicYear", priority = 3)
	public void EditAcademicYear(String code, String createdDateTime, String defaultMonthsinAcademicYear,
			String defaultTermsInAcademicYear, String defaultWeeksInAcademicYear, String defaultWeeksNonEnrollment,
			String disbursement1PctGrant, String disbursement1PctLoan, String disbursement1PctOther,
			String disbursement1PctPell, String disbursement1PctPerkins, String disbursement2PctGrant,
			String disbursement2PctLoan, String disbursement2PctOther, String disbursement2PctPell,
			String disbursement2PctPerkins, String isActive, String lastModifiedDateTime, String lastModifiedUserId,
			String name, String numberGrantDisbursements, String numberLoanDisbursements,
			String numberOtherDisbursements, String numberPellDisbursements, String numberPerkinsDisbursements,
			String fundSourceId1, String fundSourceId2, String fundSourceId3, String fundSourceId4,
			String fundSourceId5, String disbursementNumber1, String disbursementNumber2, String percentage1,
			String percentage2, String fundSourceName1, String fundSourceName2, String fundSourceName3,
			String fundSourceName4, String fundSourceName5, String numberOfDisbursements)
			throws JsonProcessingException {

		// ===============================================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumLoans = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumLoans.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId1));
		newEditDisbursementsDatumLoans.disbursementNumber = (int) Math.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumLoans.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumLoans1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumLoans1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId1));
		newEditDisbursementsDatumLoans1.disbursementNumber = (int) Math.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumLoans1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumLoansList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumLoansList.add(newEditDisbursementsDatumLoans);
		newEditDisbursementsDatumLoansList.add(newEditDisbursementsDatumLoans1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumLoans = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumLoans.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId1));
		newEditfaFundSourceDisbursementsGridDatumLoans.fundSourceName = fundSourceName1;
		newEditfaFundSourceDisbursementsGridDatumLoans.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumLoans.disbursementsData = newEditDisbursementsDatumLoansList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherGrants = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherGrants.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId2));
		newEditDisbursementsDatumOtherGrants.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumOtherGrants.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherGrants1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherGrants1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId2));
		newEditDisbursementsDatumOtherGrants1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumOtherGrants1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumOtherGrantsList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumOtherGrantsList.add(newEditDisbursementsDatumOtherGrants);
		newEditDisbursementsDatumOtherGrantsList.add(newEditDisbursementsDatumOtherGrants1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumOtherGrants = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId2));
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.fundSourceName = fundSourceName2;
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.disbursementsData = newEditDisbursementsDatumOtherGrantsList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherLoans = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherLoans.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId3));
		newEditDisbursementsDatumOtherLoans.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumOtherLoans.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherLoans1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherLoans1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId3));
		newEditDisbursementsDatumOtherLoans1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumOtherLoans1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumOtherLoansList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumOtherLoansList.add(newEditDisbursementsDatumOtherLoans);
		newEditDisbursementsDatumOtherLoansList.add(newEditDisbursementsDatumOtherLoans1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumOtherLoans = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId3));
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.fundSourceName = fundSourceName3;
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.disbursementsData = newEditDisbursementsDatumOtherLoansList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumPellGrant = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPellGrant.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId4));
		newEditDisbursementsDatumPellGrant.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumPellGrant.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumPellGran1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPellGran1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId4));
		newEditDisbursementsDatumPellGran1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumPellGran1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumPellGrantList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumPellGrantList.add(newEditDisbursementsDatumPellGrant);
		newEditDisbursementsDatumPellGrantList.add(newEditDisbursementsDatumPellGran1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumPellGrant = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumPellGrant.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId4));
		newEditfaFundSourceDisbursementsGridDatumPellGrant.fundSourceName = fundSourceName4;
		newEditfaFundSourceDisbursementsGridDatumPellGrant.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumPellGrant.disbursementsData = newEditDisbursementsDatumPellGrantList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumPerkinsLoan = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPerkinsLoan.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId5));
		newEditDisbursementsDatumPerkinsLoan.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumPerkinsLoan.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumPerkinsLoan1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPerkinsLoan1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId1));
		newEditDisbursementsDatumPerkinsLoan1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumPerkinsLoan1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumPerkinsLoanList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumPerkinsLoanList.add(newEditDisbursementsDatumPerkinsLoan);
		newEditDisbursementsDatumPerkinsLoanList.add(newEditDisbursementsDatumPerkinsLoan1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumPerkinsLoan = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId5));
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.fundSourceName = fundSourceName5;
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.disbursementsData = newEditDisbursementsDatumPerkinsLoanList;

		// =============================================================================================

		List<NewEditfaFundSourceDisbursementsGridDatum> newEditfaFundSourceDisbursementsGridDatumList = new ArrayList<NewEditfaFundSourceDisbursementsGridDatum>();
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumLoans);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumOtherGrants);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumOtherLoans);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumPellGrant);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumPerkinsLoan);

		NewEditFaAcademicYearDetails newEditFaAcademicYearDetails = new NewEditFaAcademicYearDetails();
		newEditFaAcademicYearDetails.id = (int) Math.round(Double.parseDouble(id_response_value));
		newEditFaAcademicYearDetails.code = code;
		newEditFaAcademicYearDetails.createdDateTime = createdDateTime;
		newEditFaAcademicYearDetails.defaultMonthsinAcademicYear = (int) Math
				.round(Double.parseDouble(defaultMonthsinAcademicYear));
		newEditFaAcademicYearDetails.defaultTermsInAcademicYear = (int) Math
				.round(Double.parseDouble(defaultTermsInAcademicYear));
		newEditFaAcademicYearDetails.defaultWeeksInAcademicYear = (int) Math
				.round(Double.parseDouble(defaultWeeksInAcademicYear));
		newEditFaAcademicYearDetails.defaultWeeksNonEnrollment = (int) Math
				.round(Double.parseDouble(defaultWeeksNonEnrollment));
		newEditFaAcademicYearDetails.disbursement1PctGrant = (int) Math
				.round(Double.parseDouble(disbursement1PctGrant));
		newEditFaAcademicYearDetails.disbursement1PctLoan = (int) Math.round(Double.parseDouble(disbursement1PctLoan));
		newEditFaAcademicYearDetails.disbursement1PctOther = (int) Math
				.round(Double.parseDouble(disbursement1PctOther));
		newEditFaAcademicYearDetails.disbursement1PctPell = (int) Math.round(Double.parseDouble(disbursement1PctPell));
		newEditFaAcademicYearDetails.disbursement1PctPerkins = (int) Math
				.round(Double.parseDouble(disbursement1PctPerkins));
		newEditFaAcademicYearDetails.disbursement2PctGrant = (int) Math
				.round(Double.parseDouble(disbursement2PctGrant));
		newEditFaAcademicYearDetails.disbursement2PctLoan = (int) Math.round(Double.parseDouble(disbursement2PctLoan));
		newEditFaAcademicYearDetails.disbursement2PctOther = (int) Math
				.round(Double.parseDouble(disbursement2PctOther));
		newEditFaAcademicYearDetails.disbursement2PctPell = (int) Math.round(Double.parseDouble(disbursement2PctPell));
		newEditFaAcademicYearDetails.disbursement2PctPerkins = (int) Math
				.round(Double.parseDouble(disbursement2PctPerkins));
		newEditFaAcademicYearDetails.isActive = Boolean.parseBoolean(isActive);
		newEditFaAcademicYearDetails.lastModifiedDateTime = lastModifiedDateTime;
		newEditFaAcademicYearDetails.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		newEditFaAcademicYearDetails.name = name;
		newEditFaAcademicYearDetails.numberGrantDisbursements = (int) Math
				.round(Double.parseDouble(numberGrantDisbursements));
		newEditFaAcademicYearDetails.numberLoanDisbursements = (int) Math
				.round(Double.parseDouble(numberLoanDisbursements));
		newEditFaAcademicYearDetails.numberOtherDisbursements = (int) Math
				.round(Double.parseDouble(numberOtherDisbursements));
		newEditFaAcademicYearDetails.numberPellDisbursements = (int) Math
				.round(Double.parseDouble(numberPellDisbursements));
		newEditFaAcademicYearDetails.numberPerkinsDisbursements = (int) Math
				.round(Double.parseDouble(numberPerkinsDisbursements));
		newEditFaAcademicYearDetails.rowVersion = rowVersion_response_value;
		newEditFaAcademicYearDetails.entityState = UtilClass.edit_entityState;
		newEditFaAcademicYearDetails.fundSourceDisbursementsGridData = newEditfaFundSourceDisbursementsGridDatumList;

		NewEditFAAcademicYearPayload newEditFAAcademicYearPayload = new NewEditFAAcademicYearPayload();
		newEditFAAcademicYearPayload.payload = newEditFaAcademicYearDetails;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newEditFAAcademicYearPayload);

		System.out.println(data);

		request.body(newEditFAAcademicYearPayload);

		response = request.post("/Save");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		name_response_value = jsonPathEvaluator.getString("payload.data.name");

		code_response_value = jsonPathEvaluator.getString("payload.data.code");

		Assert.assertEquals(name_response_value, name);

		Assert.assertEquals(code_response_value, code);

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 4)
	public void getDeleteAcademicYear() throws JsonProcessingException {

		GetAcademicYear getAcademicYear = new GetAcademicYear();
		getAcademicYear.id = (int) Math.round(Double.parseDouble(id_response_value));

		GetAcademicYearPayload getAcademicYearPayload = new GetAcademicYearPayload();
		getAcademicYearPayload.payload = getAcademicYear;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(getAcademicYearPayload);

		System.out.println(data);

		request.body(getAcademicYearPayload);

		response = request.post("/Get");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		id_response_value = jsonPathEvaluator.getString("payload.data.id");

		rowVersion_response_value = jsonPathEvaluator.getString("payload.data.rowVersion");

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(dataProvider = "setEditAcademicYear", priority = 5)
	public void DeleteAcademicYear(String code, String createdDateTime, String defaultMonthsinAcademicYear,
			String defaultTermsInAcademicYear, String defaultWeeksInAcademicYear, String defaultWeeksNonEnrollment,
			String disbursement1PctGrant, String disbursement1PctLoan, String disbursement1PctOther,
			String disbursement1PctPell, String disbursement1PctPerkins, String disbursement2PctGrant,
			String disbursement2PctLoan, String disbursement2PctOther, String disbursement2PctPell,
			String disbursement2PctPerkins, String isActive, String lastModifiedDateTime, String lastModifiedUserId,
			String name, String numberGrantDisbursements, String numberLoanDisbursements,
			String numberOtherDisbursements, String numberPellDisbursements, String numberPerkinsDisbursements,
			String fundSourceId1, String fundSourceId2, String fundSourceId3, String fundSourceId4,
			String fundSourceId5, String disbursementNumber1, String disbursementNumber2, String percentage1,
			String percentage2, String fundSourceName1, String fundSourceName2, String fundSourceName3,
			String fundSourceName4, String fundSourceName5, String numberOfDisbursements)
			throws JsonProcessingException {

		// ===============================================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumLoans = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumLoans.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId1));
		newEditDisbursementsDatumLoans.disbursementNumber = (int) Math.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumLoans.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumLoans1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumLoans1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId1));
		newEditDisbursementsDatumLoans1.disbursementNumber = (int) Math.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumLoans1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumLoansList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumLoansList.add(newEditDisbursementsDatumLoans);
		newEditDisbursementsDatumLoansList.add(newEditDisbursementsDatumLoans1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumLoans = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumLoans.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId1));
		newEditfaFundSourceDisbursementsGridDatumLoans.fundSourceName = fundSourceName1;
		newEditfaFundSourceDisbursementsGridDatumLoans.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumLoans.disbursementsData = newEditDisbursementsDatumLoansList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherGrants = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherGrants.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId2));
		newEditDisbursementsDatumOtherGrants.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumOtherGrants.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherGrants1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherGrants1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId2));
		newEditDisbursementsDatumOtherGrants1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumOtherGrants1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumOtherGrantsList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumOtherGrantsList.add(newEditDisbursementsDatumOtherGrants);
		newEditDisbursementsDatumOtherGrantsList.add(newEditDisbursementsDatumOtherGrants1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumOtherGrants = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId2));
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.fundSourceName = fundSourceName2;
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumOtherGrants.disbursementsData = newEditDisbursementsDatumOtherGrantsList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherLoans = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherLoans.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId3));
		newEditDisbursementsDatumOtherLoans.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumOtherLoans.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumOtherLoans1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumOtherLoans1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId3));
		newEditDisbursementsDatumOtherLoans1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumOtherLoans1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumOtherLoansList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumOtherLoansList.add(newEditDisbursementsDatumOtherLoans);
		newEditDisbursementsDatumOtherLoansList.add(newEditDisbursementsDatumOtherLoans1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumOtherLoans = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId3));
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.fundSourceName = fundSourceName3;
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumOtherLoans.disbursementsData = newEditDisbursementsDatumOtherLoansList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumPellGrant = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPellGrant.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId4));
		newEditDisbursementsDatumPellGrant.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumPellGrant.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumPellGran1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPellGran1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId4));
		newEditDisbursementsDatumPellGran1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumPellGran1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumPellGrantList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumPellGrantList.add(newEditDisbursementsDatumPellGrant);
		newEditDisbursementsDatumPellGrantList.add(newEditDisbursementsDatumPellGran1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumPellGrant = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumPellGrant.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId4));
		newEditfaFundSourceDisbursementsGridDatumPellGrant.fundSourceName = fundSourceName4;
		newEditfaFundSourceDisbursementsGridDatumPellGrant.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumPellGrant.disbursementsData = newEditDisbursementsDatumPellGrantList;

		// =============================================================================================

		NewEditDisbursementsDatum newEditDisbursementsDatumPerkinsLoan = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPerkinsLoan.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId5));
		newEditDisbursementsDatumPerkinsLoan.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber1));
		newEditDisbursementsDatumPerkinsLoan.percentage = (int) Math.round(Double.parseDouble(percentage1));

		NewEditDisbursementsDatum newEditDisbursementsDatumPerkinsLoan1 = new NewEditDisbursementsDatum();
		newEditDisbursementsDatumPerkinsLoan1.fundSourceId = (int) Math.round(Double.parseDouble(fundSourceId1));
		newEditDisbursementsDatumPerkinsLoan1.disbursementNumber = (int) Math
				.round(Double.parseDouble(disbursementNumber2));
		newEditDisbursementsDatumPerkinsLoan1.percentage = (int) Math.round(Double.parseDouble(percentage2));

		List<NewEditDisbursementsDatum> newEditDisbursementsDatumPerkinsLoanList = new ArrayList<NewEditDisbursementsDatum>();
		newEditDisbursementsDatumPerkinsLoanList.add(newEditDisbursementsDatumPerkinsLoan);
		newEditDisbursementsDatumPerkinsLoanList.add(newEditDisbursementsDatumPerkinsLoan1);

		NewEditfaFundSourceDisbursementsGridDatum newEditfaFundSourceDisbursementsGridDatumPerkinsLoan = new NewEditfaFundSourceDisbursementsGridDatum();
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.fundSourceId = (int) Math
				.round(Double.parseDouble(fundSourceId5));
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.fundSourceName = fundSourceName5;
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.numberOfDisbursements = (int) Math
				.round(Double.parseDouble(numberOfDisbursements));
		newEditfaFundSourceDisbursementsGridDatumPerkinsLoan.disbursementsData = newEditDisbursementsDatumPerkinsLoanList;

		// =============================================================================================

		List<NewEditfaFundSourceDisbursementsGridDatum> newEditfaFundSourceDisbursementsGridDatumList = new ArrayList<NewEditfaFundSourceDisbursementsGridDatum>();
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumLoans);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumOtherGrants);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumOtherLoans);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumPellGrant);
		newEditfaFundSourceDisbursementsGridDatumList.add(newEditfaFundSourceDisbursementsGridDatumPerkinsLoan);

		NewEditFaAcademicYearDetails newEditFaAcademicYearDetails = new NewEditFaAcademicYearDetails();
		newEditFaAcademicYearDetails.id = (int) Math.round(Double.parseDouble(id_response_value));
		newEditFaAcademicYearDetails.code = code;
		newEditFaAcademicYearDetails.createdDateTime = createdDateTime;
		newEditFaAcademicYearDetails.defaultMonthsinAcademicYear = (int) Math
				.round(Double.parseDouble(defaultMonthsinAcademicYear));
		newEditFaAcademicYearDetails.defaultTermsInAcademicYear = (int) Math
				.round(Double.parseDouble(defaultTermsInAcademicYear));
		newEditFaAcademicYearDetails.defaultWeeksInAcademicYear = (int) Math
				.round(Double.parseDouble(defaultWeeksInAcademicYear));
		newEditFaAcademicYearDetails.defaultWeeksNonEnrollment = (int) Math
				.round(Double.parseDouble(defaultWeeksNonEnrollment));
		newEditFaAcademicYearDetails.disbursement1PctGrant = (int) Math
				.round(Double.parseDouble(disbursement1PctGrant));
		newEditFaAcademicYearDetails.disbursement1PctLoan = (int) Math.round(Double.parseDouble(disbursement1PctLoan));
		newEditFaAcademicYearDetails.disbursement1PctOther = (int) Math
				.round(Double.parseDouble(disbursement1PctOther));
		newEditFaAcademicYearDetails.disbursement1PctPell = (int) Math.round(Double.parseDouble(disbursement1PctPell));
		newEditFaAcademicYearDetails.disbursement1PctPerkins = (int) Math
				.round(Double.parseDouble(disbursement1PctPerkins));
		newEditFaAcademicYearDetails.disbursement2PctGrant = (int) Math
				.round(Double.parseDouble(disbursement2PctGrant));
		newEditFaAcademicYearDetails.disbursement2PctLoan = (int) Math.round(Double.parseDouble(disbursement2PctLoan));
		newEditFaAcademicYearDetails.disbursement2PctOther = (int) Math
				.round(Double.parseDouble(disbursement2PctOther));
		newEditFaAcademicYearDetails.disbursement2PctPell = (int) Math.round(Double.parseDouble(disbursement2PctPell));
		newEditFaAcademicYearDetails.disbursement2PctPerkins = (int) Math
				.round(Double.parseDouble(disbursement2PctPerkins));
		newEditFaAcademicYearDetails.isActive = Boolean.parseBoolean(isActive);
		newEditFaAcademicYearDetails.lastModifiedDateTime = lastModifiedDateTime;
		newEditFaAcademicYearDetails.lastModifiedUserId = (int) Math.round(Double.parseDouble(lastModifiedUserId));
		newEditFaAcademicYearDetails.name = "!!!!!!!!TRacks18999";
		newEditFaAcademicYearDetails.numberGrantDisbursements = (int) Math
				.round(Double.parseDouble(numberGrantDisbursements));
		newEditFaAcademicYearDetails.numberLoanDisbursements = (int) Math
				.round(Double.parseDouble(numberLoanDisbursements));
		newEditFaAcademicYearDetails.numberOtherDisbursements = (int) Math
				.round(Double.parseDouble(numberOtherDisbursements));
		newEditFaAcademicYearDetails.numberPellDisbursements = (int) Math
				.round(Double.parseDouble(numberPellDisbursements));
		newEditFaAcademicYearDetails.numberPerkinsDisbursements = (int) Math
				.round(Double.parseDouble(numberPerkinsDisbursements));
		newEditFaAcademicYearDetails.rowVersion = rowVersion_response_value;
		newEditFaAcademicYearDetails.entityState = UtilClass.edit_entityState;
		newEditFaAcademicYearDetails.fundSourceDisbursementsGridData = newEditfaFundSourceDisbursementsGridDatumList;

		NewEditFAAcademicYearPayload newEditFAAcademicYearPayload = new NewEditFAAcademicYearPayload();
		newEditFAAcademicYearPayload.payload = newEditFaAcademicYearDetails;

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newEditFAAcademicYearPayload);

		System.out.println(data);

		request.body(newEditFAAcademicYearPayload);

		response = request.post("/Delete");

		body = response.getBody();

		jsonPathEvaluator = body.jsonPath();

		String delete_response_value = jsonPathEvaluator.getString("payload.deleted");

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(delete_response_value, "true");

	}

	@DataProvider
	public Object[][] setNewAcademicYear() {

		Object[][] data_NewAcademicYear = { { "!!Code", "2020/05/18 01:11:11", "3", "4", "2", "5", "50", "50", "50",
				"50", "50", "50", "50", "50", "50", "50", "true", "2020/05/18 01:11:11", "2", "!!!!!!!!TRacks18999",
				"2", "2", "2", "2", "2", "1", "2", "3", "4", "5", "1", "2", "50", "50", "Loans", "Other Loans",
				"Other Loans", "Pell Grant", "Perkins Loan", "2" } };

		return data_NewAcademicYear;

	}

	@DataProvider
	public Object[][] setEditAcademicYear() {

		Object[][] data_EditAcademicYear = { { "!!!Code", "2020/05/18 01:11:11", "36", "45", "27", "54", "50", "50",
				"50", "50", "50", "50", "50", "50", "50", "50", "true", "2020/05/18 01:11:11", "2",
				"!!!!!!!!TRacks18999Update", "2", "2", "2", "2", "2", "1", "2", "3", "4", "5", "1", "2", "50", "50",
				"Loans", "Other Loans", "Other Loans", "Pell Grant", "Perkins Loan", "2" } };

		return data_EditAcademicYear;

	}

}