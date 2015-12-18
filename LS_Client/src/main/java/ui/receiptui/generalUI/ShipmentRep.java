/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui.generalUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Exception.ExceptionPrint;
import VO.ReceiptVO.ShipmentRepVO;
import bl.receiptbl.ShipmentRepbl.ShipmentRepController;
import ui.receiptui.ReceiptCheckUI.ShipmentCheck;
import ui.util.MyFrame;
import util.enumData.ResultMessage;

/**
 *
 * @author apple
 */
public class ShipmentRep extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
	private MyFrame myFrame;
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton checkAllRepsButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel driverLabel;
    private javax.swing.JTextField driverText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel numLabel;
    private javax.swing.JTextField numText;
    private javax.swing.JLabel officeLabel;
    private javax.swing.JTextField officeText;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel orderLabel;
    private javax.swing.JTextField orderText;
    private javax.swing.JLabel plateLabel;
    private javax.swing.JTextField plateText;
    private javax.swing.JTextField resultMsgText;
    private ShipmentRepController control;
    private DefaultTableModel model;
    private Vector<String> columnIdentifiers;
    private Vector<Object> dataVector;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form ShippingRep
     */
    public ShipmentRep() {
        initComponents();
        myFrame = new MyFrame(426, 461, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numLabel = new javax.swing.JLabel();
        plateText = new javax.swing.JTextField();
        plateLabel = new javax.swing.JLabel();
        numText = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        driverLabel = new javax.swing.JLabel();
        driverText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        okButton = new javax.swing.JButton();
        officeText = new javax.swing.JTextField();
        officeLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        orderText = new javax.swing.JTextField();
        orderLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        resultMsgText = new javax.swing.JTextField();
        checkAllRepsButton = new javax.swing.JButton();
        control = new ShipmentRepController();
        model = new DefaultTableModel();
        columnIdentifiers = new Vector<String>();
        dataVector = new Vector<Object>();

        setBackground(new java.awt.Color(255, 255, 255));
        
        dateLabel.setText("日期:");
        dateText.setText(control.getDate());

        dateText.setEditable(false);
        
        officeText.setEditable(false);
        officeText.setText("025001");

        officeLabel.setText("营业厅:");
        
        numLabel.setText("编号:");
        
        numText.setEditable(false);
        String num = officeText.getText();
        num += control.getDateInNum(dateText.getText());
        num += "2";
        try {
			num += control.createNum(dateText.getText(), officeText.getText());
			numText.setText(num);
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}
        
        plateLabel.setText("车牌号:");

        driverLabel.setText("司机编号:");

        columnIdentifiers.add("订单号");
        model.setDataVector(dataVector, columnIdentifiers);
        jTable.setModel(model);
        jTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable);

        okButton.setText("确认");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        addButton.setText("添加");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        orderLabel.setText("订单号:");

        cancelButton.setText("取消");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        resultMsgText.setEditable(false);

        checkAllRepsButton.setText("查看所有单据");
        checkAllRepsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAllRepsButtonActionPerformed(evt);
            }
        });
        
        setColumn();
        
        jTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = jTable.getSelectedRow();
				int col = jTable.getSelectedColumn();
				if(col==1){
					model.removeRow(row);
					jTable.setModel(model);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numLabel)
                            .addComponent(plateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 184, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(driverLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(driverText, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(officeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkAllRepsButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(addButton)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(orderLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(orderText, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cancelButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(okButton)))))
                        .addGap(0, 38, Short.MAX_VALUE))))
            .addComponent(resultMsgText)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel)
                    .addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(officeLabel)
                    .addComponent(checkAllRepsButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numLabel)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plateLabel)
                    .addComponent(plateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driverLabel)
                    .addComponent(driverText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(orderLabel)
                            .addComponent(orderText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(addButton)
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton)
                            .addComponent(cancelButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void setColumn(){
    	TableColumn column1 = jTable.getColumnModel().getColumn(0);
        column1.setPreferredWidth(105);
        TableColumn column2 = jTable.getColumnModel().getColumn(1);
        column2.setPreferredWidth(10);
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	String driverNum = driverText.getText();
    	ResultMessage resultMessage = control.checkDriverNum(driverNum);
    	String resultMsg = ResultMessage.toFriendlyString(resultMessage);
    	resultMsgText.setText(resultMsg);
    	if(resultMessage==ResultMessage.ADD_SUCCESS){
    		if(control.isTrueAccount(driverNum)){
    			String num = numText.getText();
        		String date = dateText.getText();
        		ArrayList<String> orders = new ArrayList<String>();
        		for(int i = 0;i < dataVector.size();i++){
        			orders.add((String)jTable.getValueAt(i, 0));
        		}
        		ShipmentRepVO shipmentRepVO = new ShipmentRepVO(num, date, officeText.getText(), 
        				plateText.getText(), driverNum, orders);
        		try {
    				control.submit(shipmentRepVO);
    			} catch (NotBoundException | IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    				resultMsgText.setText(ExceptionPrint.print(e));
    			}
        		myFrame.dispose();
    		}
    		else {
				resultMsgText.setText("未找到该司机");
			}
    	}
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	myFrame.dispose();
    }

    private void checkAllRepsButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	new ShipmentCheck(officeText.getText());
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	String order = orderText.getText();
    	ResultMessage resultMessage = control.checkNum(order, 10);
    	String resultMsg = ResultMessage.toFriendlyString(resultMessage);
    	resultMsgText.setText(resultMsg);
    	if(resultMessage==ResultMessage.ADD_SUCCESS){
    		dataVector.add(order);
    		model.setDataVector(dataVector, columnIdentifiers);
        	setColumn();
    	}
    }

}
