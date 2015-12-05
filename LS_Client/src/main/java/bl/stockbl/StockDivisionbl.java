/**
 * 
 */
package bl.stockbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.stockdataservice.StockDataService;
import dataservice.stockdataservice.StockDivisionDataService;
import util.enumData.ResultMessage;
import PO.StockDivisionPO;
import PO.ReceiptPO.InStockRepPO;
import PO.ReceiptPO.OutStockRepPO;
import VO.StockDivisionVO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.OutStockRepVO;
import bl.receiptbl.InStockRepbl.InStockRepbl;
import blservice.stockblservice.StockDivisionBLService;

/**
 * @author G
 *
 */
public class StockDivisionbl implements StockDivisionBLService{

	
	
	
	private StockDivisionDataService getStockDivisionDataService() throws MalformedURLException, RemoteException, NotBoundException {
		StockDivisionDataService sd = (StockDivisionDataService) Naming.lookup("stockDivision");
		return sd;
	}
	
	
	public ResultMessage update(InStockRepVO vo) throws MalformedURLException, RemoteException, NotBoundException{
		InStockRepPO po = vo.toPO(vo);
		StockDivisionDataService sd = getStockDivisionDataService();
		return sd.update(po);
		
	}
	public ResultMessage update(OutStockRepVO vo) throws MalformedURLException, RemoteException, NotBoundException{
		OutStockRepPO po = vo.toPO(vo);
		StockDivisionDataService sd = getStockDivisionDataService();
		return sd.update(po);
	}
	
	public ResultMessage modifyDivision(int oldDivision, int oldBlock, int oldPlace,int newDivision, int newBlock, int newPlace) {
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
	 * @throws NotBoundException
	 * @throws IOException 
	 */
	public boolean isPlaceAvailable(int block, int place) throws NotBoundException, IOException {
		
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
		if(block<=8&&block>=1&&place>0&&place<=1000) {
			result = true;
		}
		
		return result;
	}
	
	
	/**
	 * 返回库存超过80的区号们，如果所有区号均未报警，则返回null
	 * @param vo
	 * @return
	 * @throws NotBoundException 
	 * @throws IOException 
	 */
	public ArrayList<Integer> getOverBlock(InStockRepVO vo) throws NotBoundException, IOException{
		ArrayList<Integer> result = new ArrayList<Integer>();
		/**
		 *数组中存放每个区中货物的个数
		 */
		int [] block = new int[8];
		StockDivisionDataService sd = getStockDivisionDataService();
		ArrayList<StockDivisionPO> list = sd.getStockDivision();
		for(StockDivisionPO po:list) {
			block[po.getBlock()-1]++;
		}
		
		//找出库存报警的区号，并加入结果数组
		for(int i = 0; i < block.length; ++i) {
			if(block[i]>800) {
				result.add(i);
			}
		}
		
		return result;
	}

}
