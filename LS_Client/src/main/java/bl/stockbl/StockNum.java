/**
 * 
 */
package bl.stockbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.stockdataservice.StockInitialDataService;
import ui.warehousemanui.CheckUtil;
import util.enumData.ResultMessage;
import PO.StockNumPO;
import VO.StockNumVO;
import blservice.stockblservice.StockNumBLService;

/**
 * @author G
 *
 */
public class StockNum {
	
	
	
	/**
	 * 由当前城市，得到初始库存数量
	 * @return
	 */
	public int getInitialStockNum() {
		//TODO 得到当前城市
		int i = 0;
		try {
			StockInitialDataService si = (StockInitialDataService) Naming.lookup("stockini");
			i = si.getInitialNum("Nanjing").getInitialNum();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return i;
	}


	
	/**
	 * 初始化当前城市库存数量
	 * @param initialNum
	 * @return
	 */
	public ResultMessage initial(String initialNum) {
		//TODO 本地城市
		if(CheckUtil.isSucceNumber(initialNum)){
			if(initialNum.length()>=10){
				
				return ResultMessage.NUMBER_OVER;
				
			}else{

				int n = Integer.parseInt(initialNum);
				StockNumVO vo = new StockNumVO("Nanjing", n);
				StockNumPO po = vo.voToPo(vo);
				
				try {
					StockInitialDataService si = (StockInitialDataService) Naming.lookup("stockini");
					si.initial(po);
				} catch (Exception e) {					
					e.printStackTrace();
					return ResultMessage.FAILED;
				}
				return ResultMessage.SUCCESS;
			}
		}else {
			return ResultMessage.INPUT_SHOULD_BE_POSITIVE_INTEGER;
		}
	}
	
	

}
