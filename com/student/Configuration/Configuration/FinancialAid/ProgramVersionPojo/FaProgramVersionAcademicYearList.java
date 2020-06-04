package Configuration.FinancialAid.ProgramVersionPojo;

public class FaProgramVersionAcademicYearList {
	
	public Integer id;
	public Integer entityState;
	public Integer termsInAcademicYear;
	public Boolean isTermsInAcademicYearDirty;
	public Integer sequence;
	public Integer enrollmentStatusId;
	public FaProgramVersionsAcademicYearEnrollmentStatus enrollmentStatus;
	public String enrollmentStatusName;
	public String budgetName;
	public String academicYearName;
	public Integer budgetId;
	public FaProgramVersionsAcademicYearBudget budget;
	public Integer academicYearId;
	public FaProgramVersionsAcademicYearAcademicYear academicYear;
	public Integer defaultWeeksInAcademicYear;
	public Integer creditHoursInAcademicYear;
	public Boolean isCreditHoursInAcademicYearDirty;
	public Integer programVersionId;
	public Boolean isActive;
	public Integer clockToCreditRateFlag;

}
