package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.GetRepPO;
import PO.Receipt.ReceiptPO;
import util.enumData.Rep;

public class GetRepVO extends ArriveRepVO {
	public String depart;

	public GetRepVO(String num, String date, Rep rep, String shipNum, ArrayList<ArriveVO> arriveVOs, String depart) {
		super(num, date, rep, shipNum, arriveVOs);
		this.depart = depart;
	}

	public GetRepVO(GetRepPO po) {
		this.num = po.getNum();
		this.date = po.getDate();
		this.rep = po.getRep();
		this.shipNum = po.getShipNum();
		this.arriveVOs = ArriveVO.toArrayVO(po.getArrivePOs());
		this.depart = po.getDepart();
	}

	public static GetRepPO toPO(GetRepVO vo) {
		if (vo == null)
			return null;
		return new GetRepPO(vo.num, vo.date, vo.rep, vo.shipNum, ArriveVO.toArrayPO(vo.arriveVOs), vo.depart);
	}

	public static ArrayList<GetRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		if (receiptPOs == null)
			return null;
		ArrayList<GetRepVO> getRepVOs = new ArrayList<GetRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			getRepVOs.add(new GetRepVO((GetRepPO) receiptPO));
		return getRepVOs;
	}

	public static ArrayList<GetRepPO> toArrayPO(ArrayList<GetRepVO> getRepVOs) {
		if (getRepVOs == null)
			return null;
		ArrayList<GetRepPO> getRepPOs = new ArrayList<GetRepPO>();
		for (GetRepVO getRepVO : getRepVOs)
			getRepPOs.add(toPO(getRepVO));
		return getRepPOs;
	}
}
