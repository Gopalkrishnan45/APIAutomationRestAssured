package com.student.TestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.SAPStatus.FaSapStatusStudentGroupList;
import com.student.SAPStatus.Payload;
import com.student.SAPStatus.PayloadSap;
import com.student.SAPStatus.StudentGroup;

public class TC001_SAPStatusCRUDTestCases {

	@Test
	public void Setup() throws JsonProcessingException {
		
		List<FaSapStatusStudentGroupList> fasaplist = new ArrayList<FaSapStatusStudentGroupList>();

		StudentGroup studentgroup = new StudentGroup();
		studentgroup.name = "StudentGroup1899";

		FaSapStatusStudentGroupList fasapstatusstudentgrouplist = new FaSapStatusStudentGroupList();
		fasapstatusstudentgrouplist.id = -1;
		fasapstatusstudentgrouplist.isActive = true;
		fasapstatusstudentgrouplist.faSapStatusId = 63;
		fasapstatusstudentgrouplist.studentGroupId = 12826;
		fasapstatusstudentgrouplist.entityState = 0;
		fasapstatusstudentgrouplist.isRemovedFromStudentGroupWhenSapMet = true;
		fasapstatusstudentgrouplist.studentGroup = studentgroup;

		fasaplist.add(fasapstatusstudentgrouplist);

		Payload payload = new Payload();
		payload.id = 63;
		payload.code = "!!SAP!!";
		payload.createdDateTime = "";
		payload.excludeFromCalc = false;
		payload.isActive = true;
		payload.isSapMet = false;
		payload.isSystemCode = false;
		payload.lastModifiedDateTime = "";
		payload.lastModifiedUserId = 2;
		payload.name = "!!SAP!!";
		payload.rowVersion = "";
		payload.originalState = "";
		payload.secureState = "";
		payload.entityState = 2;
		payload.faSapStatusStudentGroupList = fasaplist;

		PayloadSap payloadsap = new PayloadSap();
		payloadsap.payload = payload;

		ObjectMapper objMapper = new ObjectMapper();

		String data = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);

		System.out.println(data);

	}

}
