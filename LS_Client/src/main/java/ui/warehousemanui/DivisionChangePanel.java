/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.warehousemanui;
import javax.swing.*;

import VO.StockDivisionVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.stockblservice.StockBLService;
import blservice.stockblservice.StockDivisionBLService;
import ui.mainFrame.MainFrame;
import util.FromIntToCity;
import util.enumData.City;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author G
 */
public class DivisionChangePanel extends JFrame {

    /**
     * Creates new form DivisionChange
     */
    public DivisionChangePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	
    	
    	/**
    	 * 设置窗体大小
    	 */
    	this.setSize(400, 330);
    	/**
    	 * 设置窗体大小为不可变
    	 */
    	this.setResizable(false);
    	/**
    	 * 设置窗体在中部出现
    	 */
    	Toolkit tk = Toolkit.getDefaultToolkit();
    	Dimension screensize = tk.getScreenSize();
    	int screenh = screensize.height;
    	int screenw = screensize.width;
    	this.setLocation(screenw/2-this.getWidth()/2, screenh/2-this.getHeight()/2);
    	/**
    	 * 关闭窗口
    	 */
    	setDefaultCloseOperation(EXIT_ON_CLOSE);

        jLabel9 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        oldBlocks = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        oldPlaces = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        newPlaces = new javax.swing.JComboBox();
        confirm = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        oldDivisions = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        newDivisions = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        newBlocks = new javax.swing.JComboBox();

        jLabel9.setText("当前账户：大玉儿");

        exit.setText("退出");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel1.setText("原区域：");

        jLabel2.setText("区号：");

        oldBlocks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "oldblock", "Item 2", "Item 3", "Item 4" }));
        oldBlocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					oldBlocksActionPerformed(evt);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (NotBoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        jLabel3.setText("位号：");

        oldPlaces.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "oldplace", "Item 2", "Item 3", "Item 4" }));
        oldPlaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPlacesActionPerformed(evt);
            }
        });

        jLabel4.setText("新区域：");

        jLabel5.setText("调整至------------------------------------->");

        jLabel7.setText("位号：");

        newPlaces.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "newplace", "Item 2", "Item 3", "Item 4" }));
        newPlaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlacesActionPerformed(evt);
            }
        });

        confirm.setText("确定");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        back.setText("返回");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel10.setText("所在地：南京 01");

        jLabel8.setText("块号：");

        oldDivisions.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08" }));
        oldDivisions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					oldDivisionsActionPerformed(evt);
				} catch (NotBoundException | IOException e) {
					e.printStackTrace();
				}
            }
        });

        jLabel11.setText("区号：");

        newDivisions.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08" }));
        newDivisions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					newDivisionsActionPerformed(evt);
				} catch (NotBoundException | IOException e) {
					e.printStackTrace();
				}
            }
        });

        jLabel12.setText("块号：");

        newBlocks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "newblock", "Item 2", "Item 3", "Item 4" }));
        newBlocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					newBlocksActionPerformed(evt);
				} catch (NotBoundException | IOException e) {
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(285, 285, 285)
                                .addComponent(back)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirm))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oldDivisions, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oldBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oldPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(newDivisions, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(newBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(newPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(exit)
                    .addComponent(jLabel10))
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(oldBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(oldPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(oldDivisions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(newPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(newDivisions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(newBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(confirm))
                .addGap(41, 41, 41))
        );
    }// </editor-fold>                        

    /**
     * 退出
     * @param evt
     */
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	MainFrame mf = new MainFrame();
    	mf.setVisible(true);
    	this.dispose();
    }                                        

    private void oldBlocksActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, RemoteException, NotBoundException, IOException {                                           
    	//得到本仓库选中的区的所有VO
    	int division = oldDivisions.getSelectedIndex()+1;	
    	City desCity = FromIntToCity.toCity(division);
    	ArrayList<StockDivisionVO> list = s.getBlock(desCity);
    	//得到本区所选小块的存在的所有位号
    	int block = oldBlocks.getSelectedIndex()+1;    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (StockDivisionVO vo : list) {
    		if (vo.place<=(100*block)&&vo.place>=((block-1)*100+1)) {
				result.add(vo.place);
			}
    		
       	}
    	//TODO 要在oldplaces中显示这些位号
    }                                          

    private void oldPlacesActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO 似乎没什么要写的
    }                                          

    private void newPlacesActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO 似乎没什么要写的
    }                                          

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO 得到所有的复选框中的值，然后判断
    }                                        

    private void backActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	WarehousePanel w = new WarehousePanel();
		w.setVisible(true);
		this.dispose();
    }                                        

    StockDivisionBLService s = ControllerFactoryImpl.getInstance().getStockDivisionController();
    
    private void oldDivisionsActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, RemoteException, NotBoundException, IOException {                                           
    	//得到本仓库选中的区的所有VO
    	int division = oldDivisions.getSelectedIndex()+1;	
    	City desCity = FromIntToCity.toCity(division);
    	ArrayList<StockDivisionVO> list = s.getBlock(desCity);
    	//得到中间参数小块号，布尔值为true的需要显示
    	boolean[] smallBlocks = new boolean[10];
    	
    	for (StockDivisionVO vo : list) {
    		int i = vo.place/100 ;
    		smallBlocks[i] = true;
    		//判断是不是所有的小块都满了，如果全满，则停止遍历
    		boolean full = true;
    		for(int m = 0; m < 10; m++) {
    			if (smallBlocks[m] == false) {
					full = false;
					break;
				}
    		}
    		if (full) {
				break;
			}
    	}
    	
    	
    	//TODO   要在oldblocks下拉框中显示出这些小块
    	
    }                                          

    private void newDivisionsActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, RemoteException, NotBoundException, IOException {                                           
    	//得到本仓库选中的区的所有VO
    	int division = newDivisions.getSelectedIndex()+1;	
    	City desCity = FromIntToCity.toCity(division);
    	ArrayList<StockDivisionVO> list = s.getBlock(desCity);
    	//得到空闲的中间参数小块号
    	boolean[] smallBlocks = new boolean[10];
    	//得到每个块中的库存数量
    	int[] blocks = new int[10];
    	for (StockDivisionVO vo : list) {
    		int i = vo.place/100 ;
    		blocks[i]+=blocks[i];
    	
    	}
    	for (int i = 0; i < blocks.length; i++) {
			if (blocks[i] < 1000) {
				smallBlocks[i] = true;
			}
		}
    	
    	
    	//TODO   要在newblocks下拉框中显示出这些小块
    }                                          

    private void newBlocksActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, RemoteException, NotBoundException, IOException {                                           
    	//得到本仓库选中的区的所有VO
    	int division = oldDivisions.getSelectedIndex()+1;	
    	City desCity = FromIntToCity.toCity(division);
    	ArrayList<StockDivisionVO> list = s.getBlock(desCity);
    	//初始places均为0，然后使得选中的小块中的位号全为1，然后再
    	//把vo list中所有的位号全置为0，这样得到最后的所有位号为1的即为需要显示的位号
    	//TODO 注意，其中places的下标与真实显示的位号相差1
    	
    	int[] places = new int[1000];
    	int block = oldBlocks.getSelectedIndex()+1;    	
    	
    	for (int i = (block-1)*100; i < block*100; i++) {
			places[i] = 1;
		}
    	for (StockDivisionVO vo : list) {
			places[vo.place-1] = 0;
		}
    	
    	//TODO 在newplaces里面显示位号
    	
    }                                          


    // Variables declaration - do not modify                     
    private javax.swing.JButton exit;
    private javax.swing.JButton confirm;
    private javax.swing.JButton back;
    private javax.swing.JComboBox oldBlocks;
    private javax.swing.JComboBox oldPlaces;
    private javax.swing.JComboBox newPlaces;
    private javax.swing.JComboBox oldDivisions;
    private javax.swing.JComboBox newDivisions;
    private javax.swing.JComboBox newBlocks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration                   
}