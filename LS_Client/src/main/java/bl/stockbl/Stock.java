/**
 * 
 */
package bl.stockbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.ValidationEvent;

import dataservice.stockdataservice.StockDataService;
import bl.receiptbl.InStockRepbl.InStockRepController;
import bl.receiptbl.InStockRepbl.InStockRepbl;
import bl.receiptbl.OutStockRepbl.OutStockRepbl;
import ui.warehousemanui.CheckUtil;
import util.enumData.ResultMessage;
import PO.StockPO;
import VO.InStockRepVO;
import VO.OutStockRepVO;
import VO.StockVO;

/**
 * @author G
 *
 */
public class Stock {
	
	
	StockNum sn = new StockNum();
	private ArrayList<StockVO> result;
	
	public InStockRepVO toWriteInStockRep() {
		//TODO
		return null;
	}
	
	public OutStockRepVO toWriteOutStockRep() {
		//TODO
		return null;
	}

	
	/**
	 * 根据输入的起始月日和终止月日得到这段时间内的入库数量，出库数量的总字符串，以空格隔开
	 * @param startMonth
	 * @param startDay
	 * @param endMonth
	 * @param endDay
	 * @return
	 */
	public String checkStock(String startMonth, String startDay,
			String endMonth, String endDay) {
		InStockRepbl instockrep = new InStockRepbl();
		OutStockRepbl outstockrep = new OutStockRepbl();
		
		ArrayList<InStockRepVO> instockreps = new ArrayList<InStockRepVO>();
		ArrayList<OutStockRepVO> outstockreps = new ArrayList<OutStockRepVO>();
		
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        
        try{
            Date dateOne = dateFormat.parse(startMonth+"-"+startDay);
            Date dateTwo = dateFormat.parse(endMonth+"-"+endDay);
             
            Calendar calendar = Calendar.getInstance();
             
            System.out.println(checkDateValid(dateOne,dateTwo));
            if(!checkDateValid(dateOne,dateTwo)){
    			return null;
    		}
            
            calendar.setTime(dateOne);
             
            while(calendar.getTime().compareTo(dateTwo)<=0){               
            	
                instockreps.addAll(instockrep.getRepBydate(dateFormat.format(calendar.getTime())));
                outstockreps.addAll(outstockrep.getRepBydate(dateFormat.format(calendar.getTime())));
                
                calendar.add(Calendar.DAY_OF_MONTH, 1);               
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        

         
        int instocknum = instockreps.size();
        int outstocknum = outstockreps.size();

		
		return instocknum+" "+outstocknum;
	}

	public static void main(String[] args) {
		Stock s =new Stock();
		s.checkStock(2+"", 20+"", 2+"", 20+"");
	}
	
	
	
	
	
	/**
	 * 得到当前库存数量，现有库存数量=初始库存数量+遍历库存的数量
	 * @return
	 */
	public int checkPresentStockQuantity() {
		
		int result = 0;
		int initialnum = sn.getInitialStockNum();
		ArrayList<StockVO> list = show();
		int presentnum = list.size();
		result = initialnum+presentnum;
		return result;
		
	
	}

	
	/**
	 * 得到当前所有有完整信息的库存
	 * @return
	 */
	public ArrayList<StockVO> show() {
		result = null;
		ArrayList<StockPO> list = null;
		try {
			StockDataService sd = (StockDataService) Naming.lookup("stock");
			list = sd.getStock();
			for(StockPO po:list) {
				result.add(new StockVO().poToVo(po));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	
	/**
	 * 检查起始日期是否在结束日期之前
	 * @param dateOne
	 * @param dateTwo
	 * @return
	 */
	private boolean checkDateValid(Date dateOne,Date dateTwo){
		Calendar calendar = Calendar.getInstance();
        
        calendar.setTime(dateOne);
         
        if(calendar.getTime().compareTo(dateTwo)<=0){
        	return true;
        }
        
        return false;
	}
}
