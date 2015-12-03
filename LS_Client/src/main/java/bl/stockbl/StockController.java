/**
 * 
 */
package bl.stockbl;

import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.InStockRepVO;
import VO.OutStockRepVO;
import VO.StockDivisionVO;
import VO.StockVO;
import blservice.stockblservice.StockBLService;
import blservice.stockblservice.StockDivisionBLService;
import blservice.stockblservice.StockNumBLService;

/**
 * @author G
 *
 */
public class StockController implements StockBLService,StockNumBLService,StockDivisionBLService{

	private Stock stock = new Stock();
	private StockNum ininum = new StockNum();
	private StockDivisionbl division =  new StockDivisionbl();
	
	

	
	public boolean isPlaceAvailable(int block, int place) {
		return division.isPlaceAvailable(block, place);
	}
	
	@Override
	public int checkPresentStockQuantity() {
		return stock.checkPresentStockQuantity();
	}
	@Override
	public ArrayList<StockVO> show() {
		return stock.show();
	}

	
	@Override
	public InStockRepVO toWriteInStockRep() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public OutStockRepVO toWriteOutStockRep() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ResultMessage initial(String input) {
		return ininum.initial(input);
		
	}
	
	public ResultMessage modifyDivision(int oldBlock, int oldPlace,
			int newBlock, int newPlace) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public ArrayList<StockDivisionVO> getBlock(String destination) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String checkStock(String startMonth, String startDay,
			String endMonth, String endDay) {
		return stock.checkStock(startMonth, startDay, endMonth, endDay);
	}
	
	
	
	
}
