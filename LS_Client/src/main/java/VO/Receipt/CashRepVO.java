package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.CashRepPO;
import PO.Receipt.ReceiptPO;

public class CashRepVO extends ReceiptVO {
	public double sum;
	public String bankAccount;
	public ArrayList<CashVO> cashVOs;

	public CashRepVO(String num, String date, double sum, String bankAccount, ArrayList<CashVO> cashVOs) {
		super(num, date);
		this.sum = sum;
		this.bankAccount = bankAccount;
		this.cashVOs = cashVOs;
	}

	public static CashRepPO toPO(CashRepVO vo) {
		if (vo == null)
			return null;
		return new CashRepPO(vo.num, vo.date, CashVO.toArrayPO(vo.cashVOs), vo.sum, vo.bankAccount);
	}

	public CashRepVO(CashRepPO po) {
		this.num = po.getNum();
		this.date = po.getDate();
		this.cashVOs = CashVO.toArrayVO(po.getCashPOs());
		this.sum = po.getSum();
		this.bankAccount = po.getBankAccount();
	}

	public static ArrayList<CashRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		if (receiptPOs == null)
			return null;
		ArrayList<CashRepVO> cashRepVOs = new ArrayList<CashRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			cashRepVOs.add(new CashRepVO((CashRepPO) receiptPO));
		return cashRepVOs;
	}

	public static ArrayList<CashRepVO> cashToArrayVO(ArrayList<CashRepPO> cashRepPOs) {
		if (cashRepPOs == null)
			return null;
		ArrayList<CashRepVO> cashRepVOs = new ArrayList<CashRepVO>();
		for (CashRepPO cashRepPO : cashRepPOs)
			cashRepVOs.add(new CashRepVO((CashRepPO) cashRepPO));
		return cashRepVOs;
	}

	public static ArrayList<CashRepPO> toArrayPO(ArrayList<CashRepVO> cashRepVOs) {
		if (cashRepVOs == null)
			return null;
		ArrayList<CashRepPO> cashRepPOs = new ArrayList<CashRepPO>();
		for (CashRepVO cashRepVO : cashRepVOs)
			cashRepPOs.add(toPO(cashRepVO));
		return cashRepPOs;
	}
}
