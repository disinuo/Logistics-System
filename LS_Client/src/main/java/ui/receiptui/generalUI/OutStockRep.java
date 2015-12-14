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

import Exception.ExceptionPrint;
import Exception.NumNotFoundException;
import VO.ReceiptVO.OutStockRepVO;
import VO.ReceiptVO.ShippingRepVO;
import VO.ReceiptVO.TransferRepVO;
import bl.receiptbl.InStockRepbl.InStockRepController;
import bl.receiptbl.OutStockRepbl.OutStockRepController;
import util.enumData.City;
import util.enumData.Rep;
import util.enumData.ShipForm;

/**
 *
 * @author apple
 */
public class OutStockRep extends javax.swing.JPanel {
	
	 // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton checkAllRepsButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel destinationLabel;
    private javax.swing.JTextField destinationText;
    private javax.swing.JButton confirmButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField shipFormText;
    private javax.swing.JLabel numLabel;
    private javax.swing.JTextField numText;
    private javax.swing.JLabel officeLabel;
    private javax.swing.JTextField officeText;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox<String> repTypeBox;
    private javax.swing.JLabel repTypeLabel;
    private javax.swing.JTextField repTypeText;
    private javax.swing.JTextField resultMsgText;
    private javax.swing.JLabel shipFormLabel;
    private OutStockRepController control;
   	private DefaultTableModel model;
   	private Vector<String> columnIdentifiers;
   	private Vector<Object> dataVector;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form OutStockRep
     */
    public OutStockRep() {
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
        repTypeLabel = new javax.swing.JLabel();
        repTypeText = new javax.swing.JTextField();
        destinationLabel = new javax.swing.JLabel();
        shipFormLabel = new javax.swing.JLabel();
        repTypeBox = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        destinationText = new javax.swing.JTextField();
        resultMsgText = new javax.swing.JTextField();
        checkAllRepsButton = new javax.swing.JButton();
        shipFormText = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        control = new OutStockRepController();
		model = new DefaultTableModel();
		columnIdentifiers = new Vector<String>();
		dataVector = new Vector<Object>();

        setBackground(new java.awt.Color(255, 255, 255));

        dateText.setEditable(false);
        dateText.setText(control.getDate());

        dateLabel.setText("日期:");

        officeText.setEditable(false);
        officeText.setText("025");

        officeLabel.setText("中转中心:");

        numLabel.setText("编号:");

        numText.setEditable(false);
        String num = officeText.getText() + "000";
		num += control.getDateInNum(dateText.getText());
		num += "4";
		try {
			num += control.createNum(dateText.getText(), officeText.getText());
			numText.setText(num);
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}

        repTypeLabel.setText("出库单据类型:");

        destinationLabel.setText("目的地:");

        shipFormLabel.setText("装运形式:");

        repTypeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "中转单", "中转中心装车单" }));

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

        cancelButton.setText("取消");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        destinationText.setEditable(false);

        resultMsgText.setEditable(false);

        checkAllRepsButton.setText("查看所有单据");
        checkAllRepsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAllRepsButtonActionPerformed(evt);
            }
        });

        shipFormText.setEditable(false);

        confirmButton.setText("确定");
        confirmButton.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		confirmButtonActionPerformed(evt);
        	}
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultMsgText)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(numLabel)
                                    .addComponent(repTypeLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(repTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(repTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(confirmButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(cancelButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(okButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(shipFormLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(shipFormText, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(destinationLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(destinationText, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(92, 92, 92)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkAllRepsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(officeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(repTypeLabel)
                            .addComponent(repTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(repTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmButton))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(destinationLabel)
                            .addComponent(destinationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(shipFormLabel)
                            .addComponent(shipFormText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton)
                            .addComponent(cancelButton))
                        .addGap(0, 158, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    

    private void checkAllRepsButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	String num = numText.getText();
    	String date = dateText.getText();
    	String destination = destinationText.getText();
    	Rep rep = Rep.getRep(repTypeBox.getSelectedItem().toString());
    	String shipNum = repTypeText.getText();
    	ShipForm form = ShipForm.getShipForm(shipFormText.getText());
    	ArrayList<String> goods = new ArrayList<String>();
    	for(int i = 0;i < dataVector.size();i++){
    		goods.add(dataVector.get(i).toString());
    	}
    	OutStockRepVO outStockRepVO = new OutStockRepVO(num, date, destination, form, rep, shipNum, goods);
    	try {
			control.submit(outStockRepVO);
		} catch (NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}
    }
    
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt){
    	if(repTypeBox.getSelectedItem().toString().equals("中转单")){
    		ShippingRepVO shippingRepVO = null;
    		try {
				shippingRepVO = control.getShippingRepVO(repTypeText.getText());
			} catch (ClassNotFoundException | NotBoundException | IOException | NumNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultMsgText.setText(ExceptionPrint.print(e));
			}
    		ArrayList<String> orders = shippingRepVO.goods;
    		dataVector.addAll(orders);
    		model.setDataVector(dataVector, columnIdentifiers);
    		destinationText.setText(shippingRepVO.destination);
    		shipFormText.setText("汽运");
    	}
    	else {
			TransferRepVO transferRepVO = null;
			try {
				transferRepVO = control.getTransferRepVO(repTypeText.getText());
			} catch (ClassNotFoundException | NotBoundException | IOException | NumNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultMsgText.setText(ExceptionPrint.print(e));
			}
			ArrayList<String> orders = transferRepVO.goods;
    		dataVector.addAll(orders);
    		model.setDataVector(dataVector, columnIdentifiers);
    		destinationText.setText(City.toString(transferRepVO.city));
    		shipFormText.setText(ShipForm.toFrendlyString(transferRepVO.form));
		}
    }
   
}
