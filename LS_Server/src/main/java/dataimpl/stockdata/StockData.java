 /**
 * 
 */
package dataimpl.stockdata;



import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.FromIntToCity;
import util.enumData.City;
import util.enumData.ResultMessage;
import PO.StockDivisionPO;
import PO.StockPO;
import PO.Receipt.InStockPO;
import PO.Receipt.InStockRepPO;
import PO.Receipt.OutStockRepPO;
import dataservice.stockdataservice.StockDataService;
import datautil.DataUtility;

/**
 * @author G
 *
 */
public class StockData extends UnicastRemoteObject implements StockDataService{

	String filename = "Stock.txt";
	DataUtility du = new DataUtility();
	/**
	 * @throws RemoteException
	 */
	public StockData() throws RemoteException {
		super();
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 在文件末尾增添序列化库存po
	 */
	@Override
	public ResultMessage add(StockPO po) throws RemoteException {
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			list = du.getAll(filename);
			if (list != null){
				for(Object o:list){
					StockPO p = (StockPO)o;
					if(p.getCityNum().equals(po.getCityNum())&&p.getListNum().equals(po.getListNum())){
						return ResultMessage.EXIST;
					}else if(p.getCityNum()==po.getCityNum()&&p.getBlock()==po.getBlock()&&p.getPlace()==po.getPlace()){
						return ResultMessage.NOT_AVAILABLE;
					}
				}
			}
			return du.save(po, filename);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return ResultMessage.FAILED;
	}


	@Override
	public ResultMessage delete(String listnum) throws RemoteException {
		boolean isFound = false;
		ArrayList<Object> list;
		try {
			list = du.getAll(filename);
			if (list != null) {
				for(int i = 0;i < list.size();++i) {
					StockPO po = (StockPO)list.get(i);

					if(po.getListNum().equals(listnum)){
						isFound = true;
						list.remove(i);
					}
				}
			} else {
				return ResultMessage.NOT_FOUND;
			}
			du.SaveAll(list, filename);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
		if(!isFound){
			return ResultMessage.NOT_FOUND;
		}else{
			return ResultMessage.SUCCESS;
		}
		
	}

	public static void main(String[] args) throws IOException{
		StockData stockData = new StockData();
		stockData.getStock(City.SHANGHAI);
	}
	
	@Override
	public ArrayList<StockPO> getStock(City cityNum) throws IOException {
		
		ArrayList<StockPO> list = new ArrayList<StockPO>();
		ArrayList<Object> listo = new ArrayList<Object>();
		try {
			
			
			listo = du.getAll(filename);
			if (listo != null) {
				for(Object o:listo) {
					StockPO po = (StockPO) o;
					if (po.getCityNum().equals(cityNum)){
						list.add(po);
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}


	/* (non-Javadoc)
	 * @see dataservice.stockdataservice.StockDataService#update(PO.ReceiptPO.InStockRepPO)
	 */
	@Override
	public ResultMessage update(InStockRepPO po, City cityNum) throws RemoteException {
		ResultMessage rm = ResultMessage.SUCCESS;
		String inrepnum = po.getNum();
		String date = po.getDate();
			
		
		System.out.println("stock  "+cityNum.toString());
		ArrayList<InStockPO> list = po.getInStockPOs();
		for(InStockPO inpo : list) {
			int block = Integer.parseInt(inpo.getArea());
			int place = Integer.parseInt(inpo.getLoc());
			City desCity = FromIntToCity.toCity(block);
			rm = add(new StockPO(cityNum, inpo.getOrder(), inrepnum, date, desCity, block, place));

		}
		return rm;
	}


	/* (non-Javadoc)
	 * @see dataservice.stockdataservice.StockDataService#update(PO.ReceiptPO.OutStockRepPO)
	 */
	@Override
	public ResultMessage update(OutStockRepPO po) throws RemoteException {
		ResultMessage rm = ResultMessage.SUCCESS;
		ArrayList<String> list = po.getGoods();
		for(String goods : list) {
			 rm = delete(goods);
			
		}
		
		return rm;
	}
	
	

	/* (non-Javadoc)
	 * @see dataservice.stockdataservice.StockDataService#find(int, int)
	 */
	@Override
	public StockPO find(int block, int place) throws ClassNotFoundException, IOException {
		ArrayList<Object> listo = du.getAll(filename);
		
		for(Object o:listo) {
			StockPO po = (StockPO) o;
			
			if (po.getBlock() == block && po.getPlace() == place) {
				return po;
			}
		}
		
		return null;
	}
	
	
	
	
}
