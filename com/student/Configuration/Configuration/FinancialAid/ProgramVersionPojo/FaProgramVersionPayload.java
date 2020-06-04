package Configuration.FinancialAid.ProgramVersionPojo;

import java.util.List;

import com.student.AdProgramVersions.NewEditAdProgramVersions;

public class FaProgramVersionPayload {

	public FAProgramVersionsDetails programVersionDetail;
	public List<FaProgramVersionAcademicYearList> programVersionAcademicYearList;
	public List<FaProgramVersionBudgetCostList> programVersionBudgetCostList;
	public List<Integer> programVersionPellCoaDetailList = null;
	public FaProgramVersionTermProgramAssociationSaveRequest termProgramAssociationSaveRequest;
	public List<Integer> programVersionIdsToCopy = null;
	public List<Integer> nonTermPaymentPeriodList = null;
	public Object paymentPeriodClockToCreditConversionRate;
	public Boolean isClockToCreditConfigured;

}
