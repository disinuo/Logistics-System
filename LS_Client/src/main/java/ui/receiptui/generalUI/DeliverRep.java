/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui.generalUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Exception.ExceptionPrint;
import Exception.GoodsNotFound;
import VO.ReceiptVO.DeliverRepVO;
import VO.ReceiptVO.DeliverVO;
import bl.receiptbl.DeliverRepbl.DeliverController;
import blservice.receiptblservice.DeliverRepblService;
import util.enumData.ResultMessage;

/**
 *
 * @author apple
 */
public class DeliverRep extends javax.swing.JPanel {
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel courierLabel;
    private javax.swing.JTextField courierText;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel numLabel;
    private javax.swing.JTextField numText;
    private javax.swing.JLabel officeLabel;
    private javax.swing.JTextField officeText;
    private javax.swing.JButton okButton;
    private javax.swing.JButton orderButton;
    private javax.swing.JLabel orderNumLabel;
    private javax.swing.JTextField orderNumText;
    private javax.swing.JTextField resultMsgText;
    private javax.swing.JButton checkAllRepsButton;
    private DeliverRepblService control;
    private DefaultTableModel model;
    private Vector<String> columnIdentifiers;
    private Vector<Object> dataVector;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form DeliverRep
     */
    public DeliverRep() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateText = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        officeText = new javax.swing.JTextField();
        officeLabel = new javax.swing.JLabel();
        numLabel = new javax.swing.JLabel();
        numText = new javax.swing.JTextField();
        courierLabel = new javax.swing.JLabel();
        courierText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        orderNumLabel = new javax.swing.JLabel();
        orderNumText = new javax.swing.JTextField();
        orderButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        resultMsgText = new javax.swing.JTextField();
        checkAllRepsButton = new javax.swing.JButton();
        control = new DeliverController();
        model = new DefaultTableModel();
        columnIdentifiers = new Vector<String>();
        dataVector = new Vector<Object>();

        setBackground(new java.awt.Color(255, 255, 255));

        resultMsgText.setEditable(false);

        dateLabel.setText("日期:");
        
        dateText.setEditable(false);
        dateText.setText(control.getDate());

        officeText.setEditable(false);
        officeText.setText("025001");

        officeLabel.setText(" 营业厅:");

        numLabel.setText("编号:");

        numText.setEditable(false);
		try {
			String num = officeText.getText();
			num += control.getDateInNum(dateText.getText());
			num += "2";
			num += control.createNum(dateText.getText());
			numText.setText(num);
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}

        courierLabel.setText("派件员编号:");

        columnIdentifiers.add("订单号");
        columnIdentifiers.add("收件人名字");
        columnIdentifiers.add("手机");
        columnIdentifiers.add("地点");
        columnIdentifiers.add("删除");

        model.setDataVector(dataVector, columnIdentifiers);
        jTable.setModel(model);
        jTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable);

        orderNumLabel.setText("订单号:");

        orderButton.setText("添加");
        orderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderMouseClicked(evt);
            }
        });

        okButton.setText("确认");
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okMouseClicked(evt);
            }
        });
        
        cancelButton.setText("取消");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        
        checkAllRepsButton.setText("查看所有单据");
        checkAllRepsButton.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent evt){
        		checkAllRepsButtonMouseClicked(evt);
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
				if(col==4){
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(checkAllRepsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(officeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(dateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(courierLabel)
                                    .addComponent(numLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courierText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(resultMsgText)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addGap(100, 100, 100)
                        .addComponent(okButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(orderNumLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orderNumText, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(orderButton)))
                .addGap(194, 194, 194))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numLabel)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courierLabel)
                    .addComponent(courierText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderNumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderNumLabel)
                    .addComponent(orderButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void setColumn(){
    	TableColumn column1 = jTable.getColumnModel().getColumn(0);
        column1.setPreferredWidth(103);
        TableColumn column2 = jTable.getColumnModel().getColumn(1);
        column2.setPreferredWidth(75);
        TableColumn column3 = jTable.getColumnModel().getColumn(2);
        column3.setPreferredWidth(110);
        TableColumn column4 = jTable.getColumnModel().getColumn(3);
        column4.setPreferredWidth(355);
        TableColumn column5 = jTable.getColumnModel().getColumn(4);
        column5.setPreferredWidth(30);
    }

    private void orderMouseClicked(java.awt.event.MouseEvent evt) {
    	String order = orderNumText.getText();
    	ResultMessage resultMessage = control.checkNum(order, 10);
    	String resultMsg = ResultMessage.toFriendlyString(resultMessage);
    	resultMsgText.setText(resultMsg);
    	if(resultMessage==ResultMessage.ADD_SUCCESS){
//    		String name = "bismuth";
//    		String phoneNum = "13934517986";
//    		String address = "南京大学";
    		String name = null;
    		String phoneNum = null;
    		String address = null;
			try {
				name = control.getNameByOrder(order);
				phoneNum = control.getPhoneByOrder(order);
	    		address = control.getAddressByOrder(order);
			} catch (GoodsNotFound e) {
				e.printStackTrace();
				resultMsgText.setText(ExceptionPrint.print(e));
			}
    		Vector<Object> arr = new Vector<Object>();
    		arr.add(order);
    		arr.add(name);
    		arr.add(phoneNum);
    		arr.add(address);
    		dataVector.add(arr);
        	model.setDataVector(dataVector, columnIdentifiers);
        	setColumn();
    	}
    }
    
    private void okMouseClicked(java.awt.event.MouseEvent evt) {
    	String courierNum = courierText.getText();
    	ResultMessage resultMessage = control.checkCourierNum(courierNum);
    	String resultMsg = ResultMessage.toFriendlyString(resultMessage);
    	resultMsgText.setText(resultMsg);
    	if(resultMessage==ResultMessage.ADD_SUCCESS){
    		String num = numText.getText();
    		String date = dateText.getText();
    		ArrayList<DeliverVO> deliverVOs = new ArrayList<DeliverVO>();
    		for(int i = 0;i<dataVector.size();i++){
    			DeliverVO vo = new DeliverVO((String)jTable.getValueAt(i, 0), (String)jTable.getValueAt(i, 1), (String)jTable.getValueAt(i, 2), (String)jTable.getValueAt(i, 3));
    			deliverVOs.add(vo);
    		}
    		DeliverRepVO deliverRepVO = new DeliverRepVO(num, date, courierText.getText(), deliverVOs);
    		try {
    			control.submit(deliverRepVO);
    		} catch (NotBoundException | IOException e) {
    			e.printStackTrace();
    			resultMsgText.setText(ExceptionPrint.print(e));
    		}
    		resultMsgText.setText(ResultMessage.toFriendlyString(ResultMessage.SUBMIT_SUCCESS));
    	}
    }
    
    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {

    }
    
    private void checkAllRepsButtonMouseClicked(MouseEvent evt){
    	
    }
    
    public static void main (String[] args){
    	JFrame myFrame = new JFrame();
    	myFrame.setSize(673, 503);
    	myFrame.add(new DeliverRep());
    	myFrame.setVisible(true);
    }
}
