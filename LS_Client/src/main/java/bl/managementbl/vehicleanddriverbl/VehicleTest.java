package bl.managementbl.vehicleanddriverbl;

import static org.junit.Assert.*;

import org.junit.Test;

import util.enumData.ResultMessage;



public class VehicleTest {

	@Test
	public void testCreateLog() {
		Vehiclebl vehicleBL = new Vehiclebl();
		assertEquals(ResultMessage.SUCCESS, vehicleBL.createLog("2015/11/14 营业厅业务员  车辆管理"));
	}
	

}




















































































































































































































































