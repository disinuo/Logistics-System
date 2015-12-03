/**
 * 
 */
package VO;

import PO.StockDivisionPO;

/**
 * @author G
 *
 */
public class StockDivisionVO {
	public String cityNum;
	public String destination;
	public int block;
	public int place;
	public boolean available;
	
	/**
	 * 
	 * @param cn    id of this warehouse
	 * @param des   destination of this place
	 * @param b	    block to which this place belongs
	 * @param p	    number of this place
	 * @param avai  state of this place
	 */
	public StockDivisionVO(String cn,String des,int b,int p,boolean avai){
		cityNum=cn;
		destination=des;
		block=b;
		place=p;
		available=avai;
	}
	
	public StockDivisionVO() {};
	
	public StockDivisionPO voToPo(StockDivisionVO vo) {
		
		StockDivisionPO po = new StockDivisionPO(null, null, 0, 0, true);
		po.setAvailable(vo.available);
		po.setBlock(vo.block);
		po.setCityNum(vo.cityNum);
		po.setDestination(vo.destination);
		po.setPlace(vo.place);
		
		return po;
	}
	
	public StockDivisionVO poToVo(StockDivisionPO po) {
		
		StockDivisionVO vo = new StockDivisionVO(null, null, 0, 0, true);
		vo.available = po.getAvailable();
		vo.block = po.getBlock();
		vo.cityNum = po.getCityNum();
		vo.destination = po.getDestination();
		vo.place = po.getPlace();
		
		return vo;
	}
}
