/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui.ReceiptDetailUI;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import Exception.ExceptionPrint;
import Exception.NumNotFoundException;
import VO.Receipt.TransferRepVO;
import bl.receiptbl.TransferRepbl.TransferRepController;
import blservice.receiptblservice.TransferRepblService;
import ui.util.MyFrame;
import util.enumData.City;
import util.enumData.ShipForm;

/**
 *
 * @author apple
 */
public class Transfer extends javax.swing.JPanel {
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MyFrame myFrame;
    private javax.swing.JLabel carNumLabel;
    private javax.swing.JTextField carNumText;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel destinationLabel;
    private javax.swing.JTextField destinationText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel numLabel;
    private javax.swing.JTextField numText;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField resultMsgText;
    private javax.swing.JLabel shipFormLabel;
    private javax.swing.JTextField shipFormText;
    private TransferRepblService control;
    private DefaultTableModel model;
    private Vector<String> columnIdentifiers;
    private Vector<Object> dataVector;
    private String num;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form TransferRep
     */
    public Transfer(String oriNum) {
    	num = oriNum;
        initComponents();
        myFrame = new MyFrame(470, 338, this);
        myFrame.setTitle("中转单详细信息查看");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        numText = new javax.swing.JTextField();
        destinationLabel = new javax.swing.JLabel();
        destinationText = new javax.swing.JTextField();
        shipFormLabel = new javax.swing.JLabel();
        shipFormText = new javax.swing.JTextField();
        carNumLabel = new javax.swing.JLabel();
        carNumText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        okButton = new javax.swing.JButton();
        resultMsgText = new javax.swing.JTextField();
        control = new TransferRepController();
        columnIdentifiers = new Vector<String>();
        dataVector = new Vector<Object>();
		model = new DefaultTableModel(dataVector, columnIdentifiers) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

        setBackground(new java.awt.Color(255, 255, 255));

        numLabel.setText("编号:");

        dateLabel.setText("日期:");

        dateText.setEditable(false);

        numText.setEditable(false);

        destinationLabel.setText("目的地:");

        destinationText.setEditable(false);

        shipFormLabel.setText("装运形式:");

        shipFormText.setEditable(false);

        carNumLabel.setText("车次:");

        carNumText.setEditable(false);

        okButton.setText("完成");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        resultMsgText.setEditable(false);
        
        TransferRepVO transferRepVO = null;
        try {
			transferRepVO = control.getRepByNum(num);
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			resultMsgText.setText(ExceptionPrint.print(e));
		}
        dateText.setText(transferRepVO.date);
        numText.setText(num);
        shipFormText.setText(ShipForm.toFrendlyString(transferRepVO.form));
        carNumText.setText(transferRepVO.carNum);
        destinationText.setText(City.toString(transferRepVO.destination));
        try {
			dataVector = control.initShow(num);
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			resultMsgText.setText(ExceptionPrint.print(e));
		}
        columnIdentifiers.add("订单号");
        model.setDataVector(dataVector, columnIdentifiers);
        jTable.setModel(model);
        jTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultMsgText)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(destinationLabel)
                    .addComponent(numLabel)
                    .addComponent(dateLabel)
                    .addComponent(shipFormLabel)
                    .addComponent(carNumLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(destinationText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(carNumText, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(shipFormText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(okButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateLabel)
                            .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numLabel)
                            .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(shipFormLabel)
                            .addComponent(shipFormText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carNumLabel)
                            .addComponent(carNumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(destinationLabel)
                            .addComponent(destinationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(okButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	myFrame.dispose();
    }

}
