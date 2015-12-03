/**
 * 
 */
package bl.stockbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.stockdataservice.StockDataService;
import dataservice.stockdataservice.StockDivisionDataService;
import util.enumData.ResultMessage;
import PO.StockDivisionPO;
import VO.InStockRepVO;
import VO.StockDivisionVO;
import bl.receiptbl.InStockRepbl.InStockRepbl;
import blservice.stockblservice.StockDivisionBLService;

/**
 * @author G
 *
 */
public class StockDivisionbl implements StockDivisionBLService{

	
	
	private StockDivisionDataService getStockDivisionDataService() throws MalformedURLException, RemoteException, NotBoundException {
		StockDivisionDataService sd = (StockDivisionDataService) Naming.lookup("stock");
		return sd;
	}
	
	public ResultMessage modifyDivision(int oldBlock, int oldPlace, int newBlock, int newPlace) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	 
	public ArrayList<StockDivisionVO> getBlock(String destination) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	/**
	 * 判断此区位号是否已存在货物
	 * @param block
	 * @param place
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public boolean isPlaceAvailable(int block, int place) throws MalformedURLException, RemoteException, NotBoundException {
		
		boolean available = true;
		StockDivisionDataService sd = getStockDivisionDataService();
		ArrayList<StockDivisionPO> list = sd.getStockDivision();

		
		for(StockDivisionPO po:list) {
			if(po.getBlock()==block&&po.getPlace()==place) {
				available = false;
			}
		}
		
		return available;
	}
	
	/**
	 * 判断这个区位号是否在仓库中存在
	 * @param block
	 * @param place
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public boolean isExist(int block, int place) throws MalformedURLException, RemoteException, NotBoundException {
		boolean result = false;
		if(block<=8&&block>=1&&place>=0&&place<=10000) {
			result = true;
		}
		
		return result;
	}
	
	
	/**
	 * 返回库存超过80的区号，如果所有区号均未报警，则返回-1
	 * @param vo
	 * @return
	 */
	public int getOverBlock(InStockRepVO vo){
		int result = -1;
		int [] block = new int[8];
		//TODO 得到现有所有区的数量
		
		return result;
	}

}
