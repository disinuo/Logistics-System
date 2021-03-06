package bl.managementbl.managedata;

import util.CurrentTime;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import bl.logbl.Logbl;
import bl.loginbl.Loginbl;
import PO.AccountPO;
import PO.BankAccountPO;
import PO.ConstPO;
import PO.CourierPO;
import PO.DriverPO;
import PO.InstitutionPO;
import PO.SalaryPolicyPO;
import PO.VehiclePO;
import VO.LogVO;
import VO.ManagementVO.AccountVO;
import VO.ManagementVO.BankAccountVO;
import VO.ManagementVO.ConstVO;
import VO.ManagementVO.CourierVO;
import VO.ManagementVO.DriverVO;
import VO.ManagementVO.InstitutionVO;
import VO.ManagementVO.SalaryPolicyVO;
import VO.ManagementVO.VehicleVO;

public class ManageVOPO {
	private static ManageVOPO manageVOPO;
	private static Logbl logbl;

	private ManageVOPO() {
		logbl = new Logbl();
	}

	public static ManageVOPO getInstance() {
		if (manageVOPO == null) {
			manageVOPO = new ManageVOPO();
		}
		return manageVOPO;
	}

	/**
	 * add log
	 * 
	 * @param operation
	 * @return ResultMessage
	 */
	public ResultMessage addLog(LogType operation) {
		LogVO logVO = new LogVO(operation, Loginbl.getCurrentOptorId(),
				CurrentTime.getTime());
		try {
			assert (logbl != null) : ("Logbl is null!");
		} catch (AssertionError e) {
			System.out.println("Logbl is null!");
			System.out.println(e.getMessage());
		}
		logbl.add(logVO);
		return ResultMessage.SUCCESS;
	}

	public AccountPO voToPO(AccountVO vo) {
		return new AccountPO(vo.accountNum, vo.accountName, vo.password,
				vo.sex, vo.authority, vo.phoneNum, vo.institutionNum);
	}

	public CourierPO voToPO(CourierVO vo) {
		return new CourierPO(vo.courierNum, vo.courrentMonthMoney);
	}

	public BankAccountPO voToPO(BankAccountVO vo) {
		return new BankAccountPO(vo.bankAccountNum, vo.bankAccountName,
				vo.balance);
	}

	public ConstPO voToPO(ConstVO vo) {
		return new ConstPO(vo.city1,vo.city2, vo.priceConst, vo.distanceConst);
	}

	public InstitutionPO voToPO(InstitutionVO vo) {
		return new InstitutionPO(vo.institutionNum, vo.institutionName,
				vo.contactInfo, vo.address, vo.manning);
	}

	public SalaryPolicyPO voToPO(SalaryPolicyVO vo) {
		return new SalaryPolicyPO(vo.authority, vo.salaryPolicy, vo.value);
	}

	public DriverPO voToPO(DriverVO vo) {
		return new DriverPO(vo.driverNum, vo.name, vo.sex, vo.id, vo.phoneNum,
				vo.licensedTime, vo.number);
	}

	public VehiclePO voToPO(VehicleVO vo) {
		return new VehiclePO(vo.vehicleNum, vo.licenseNum, vo.startTime);
	}

	public AccountVO poToVO(AccountPO po) {
		return new AccountVO(po.getAccountNum(), po.getAccountName(),
				po.getPassword(), po.getSex(), po.getAuthority(),
				po.getPhoneNum(), po.getInstitutionNum());
	}

	public CourierVO poToVO(CourierPO po) {
		return new CourierVO(po.getCourierNum(), po.getCourrentMonthMoney());
	}

	public BankAccountVO poToVO(BankAccountPO po) {
		return new BankAccountVO(po.getBankAccountNum(),
				po.getBankAccountName(), po.getBalance());
	}

	public ConstVO poToVO(ConstPO po) {
		return new ConstVO(po.getCity1(),po.getCity2(), po.getPriceConst(),
				po.getDistanceConst());
	}

	public InstitutionVO poToVO(InstitutionPO po) {
		return new InstitutionVO(po.getInstitutionNum(),
				po.getInstitutionName(), po.getContactInfo(), po.getAddress(),
				po.getManning());
	}

	public SalaryPolicyVO poToVO(SalaryPolicyPO po) {
		return new SalaryPolicyVO(po.getAuthority(), po.getSalaryPolicy(),
				po.getValue());
	}

	public DriverVO poToVO(DriverPO po) {
		return new DriverVO(po.getDriverNum(), po.getName(), po.getSex(),
				po.getId(), po.getPhoneNum(), po.getLicensedTime(),
				po.getNumber());
	}

	public VehicleVO poToVO(VehiclePO po) {
		return new VehicleVO(po.getVehicleNum(), po.getLicenseNum(),
				po.getStartTime());
	}

}
