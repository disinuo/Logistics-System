package bl.receiptbl.ReceptionRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.GoodsNotFound;
import Exception.NumNotFoundException;
import PO.Receipt.ReceiptPO;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ReceptionRepVO;
import VO.Receipt.ShipmentRepVO;
import VO.Receipt.TransferRepVO;
import bl.goodsbl.Goodsbl;
import bl.loginbl.LoginblController;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.ShipmentRepbl.ShipmentRepbl;
import bl.receiptbl.TransferRepbl.TransferRepbl;
import util.CurrentTime;
import util.enumData.City;
import util.enumData.GoodsArrivalState;
import util.enumData.GoodsLogisticState;
import util.enumData.LogType;
import util.enumData.Rep;

public class ReceptionRepbl {

	Receiptbl receiptbl = new Receiptbl();
	Goodsbl goodsbl = new Goodsbl();
	private LoginblController login = new LoginblController();

	public ShipmentRepVO getShipmentRep(String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		ShipmentRepbl shipment = new ShipmentRepbl();
		return shipment.getRepByNum(num);
	}

	public TransferRepVO getTransferRep(String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		TransferRepbl transfer = new TransferRepbl();
		return transfer.getRepByNum(num);
	}

	public String createNum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.ReceptionRep, office);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(ReceptionRepVO.toPO((ReceptionRepVO) vo), Rep.ReceptionRep);
		String operatorID = login.getCurrentOptorId();
		receiptbl.addLog(LogType.TRANSFER_CTR_RECEPTION, operatorID, CurrentTime.getTime());
	}

	public Vector<Object> initTable(Rep rep, String num, ArrayList<String> existOrders)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<String> orders;
		if (rep == Rep.ShipmentRep) {
			orders = getShipmentRep(num).goods;
		} else {
			orders = getTransferRep(num).goods;
		}
		if (orders.size() > existOrders.size()) {
			for (int i = 0; i < orders.size(); i++) {
				String order = orders.get(i);
				if (!existOrders.contains(order)) {
					Vector<String> arr = new Vector<String>();
					arr.add(order);
					arr.add(GoodsArrivalState.LOST.getChineseName());
					data.add(arr);
					// transferOver(order, GoodsArrivalState.LOST);
				}
			}
		}
		return data;
	}

	public void transferOver(String num, GoodsArrivalState goodsArrivalState) {
		// TODO Auto-generated method stub
		goodsbl.end(num, goodsArrivalState);
		// goodsbl.setArrivalState(num, goodsArrivalState, receiptbl.getDate());
		// goodsbl.setLogisticState(num, GoodsLogisticState.BROKEN_OR_LOST,
		// receiptbl.getDate());
	}

	public void changeLogistic(String num, GoodsLogisticState goodsLogisticState) {
		goodsbl.setLogisticState(num, goodsLogisticState, receiptbl.getDate());
	}

	public ArrayList<ReceptionRepVO> getAllRep(String office)
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.ReceptionRep, office);
		return ReceptionRepVO.toArrayVO(receiptPOs);
	}
	
	public String getDepart(Rep rep, String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		if (rep == Rep.ShipmentRep) {
			String businessOfficeNum = getShipmentRep(num).depart;
			String depart = businessOfficeNum.substring(0,3);
			City departCity = City.getCityByNum(depart);
			return City.toString(departCity);
		} else {
			return City.toString(getTransferRep(num).depart);
		}
	}

	public boolean isTrueOrder(String order) {
		return receiptbl.isTrueOrder(order);
	}

	public String getDestination(String order) throws GoodsNotFound {
		return goodsbl.findByListNum(order).destinationCity;
	}

	public String getDepart(String order) throws GoodsNotFound {
		return goodsbl.findByListNum(order).startCity;
	}

}
