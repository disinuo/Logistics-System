package bl.managementbl.institutionbl;

import static org.junit.Assert.*;

import org.junit.Test;

import util.enumData.ResultMessage;



public class InstitutionTest {

	@Test
	public void testCreateLog() {
		Institutionbl institutionBL = new Institutionbl();
		assertEquals(ResultMessage.SUCCESS, institutionBL.createLog("2015/11/14 总经理 机构管理"));
	}

}




















































































































































































































































