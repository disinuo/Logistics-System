/**
 * 
 */
package dataimpl.stockdata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.StockNumPO;
import PO.StockPO;
import dataservice.stockdataservice.StockInitialDataService;
import datautil.DataUtility;

/**
 * @author G
 *
 */
public class StockInitialData extends UnicastRemoteObject implements StockInitialDataService{

	
	String filename = "StockIniNum.txt";
	DataUtility du = new DataUtility();
	/**
	 * @throws RemoteException
	 */
	public StockInitialData() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 初始化库存数量
	 */
	@Override
	public ResultMessage initial(StockNumPO po) throws RemoteException {

		try {
			du.save(po, filename);	
			
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
		
		return ResultMessage.SUCCESS;
	}

	/**
	 * 得到库存初始化的值
	 */
	@Override
	public StockNumPO getInitialNum(String citynum) throws RemoteException {
		
		ArrayList<Object> list;
		try {
			list = du.getAll(filename);
			
			for(int i = 0;i < list.size();++i) {
				StockNumPO po = (StockNumPO)list.get(i);
				if(po.getCityNum().equals(citynum)){
					return po;
				}
			}
			
			du.SaveAll(list, filename);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}

}
