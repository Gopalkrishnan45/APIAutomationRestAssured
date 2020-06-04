package Configuration.FinancialAid.ProgramVersionPojo;

import java.util.List;

public class FaProgramVersionTermProgramAssociationSaveRequest {

	public Integer programVersionId;
	public Integer shiftSchoolStartDateId;
	public List<Integer> campusIdsList = null;
	public List<FaProgramVersionTermAssociationAcademicYear> termAssociationAcademicYears = null;
	public List<Integer> termsInAcademicYear = null;

}