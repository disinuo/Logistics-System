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
	
	@Override
	public int checkInStock(String startDate, String endDate) {
		
		return stock.checkInStock(startDate, endDate);
	}
	@Override
	public int checkOutStock(String startDate, String endDate) {
		
		return stock.checkOutStock(startDate, endDate);
	}
	@Override
	public int checkStockQuantity(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return stock.checkStockQuantity(startDate, endDate);
	}

	@Override
	public int checkPresentStockQuantity() {
		// TODO Auto-generated method stub
		return stock.checkPresentStockQuantity();
	}
	@Override
	public ArrayList<StockVO> show() {
		// TODO Auto-generated method stub
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

	
}
