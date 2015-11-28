/**
 * 
 */
package bl.stockbl;

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
		//TODO
		return 0;
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
			
				
				return ResultMessage.EXIST;
			}
		}else {
			return ResultMessage.INPUT_SHOULD_BE_POSITIVE_INTEGER;
		}
	}
	
	

}
