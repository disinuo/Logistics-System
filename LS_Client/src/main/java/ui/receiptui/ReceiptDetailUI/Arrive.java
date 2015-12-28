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
import javax.swing.table.TableColumn;

import util.enumData.*;
import Exception.ExceptionPrint;
import Exception.NumNotFoundException;
import VO.Receipt.GetRepVO;
import VO.Receipt.ReceptionRepVO;
import bl.receiptbl.GetRepbl.GetRepController;
import bl.receiptbl.ReceptionRepbl.ReceptionRepController;
import blservice.receiptblservice.GetRepblService;
import blservice.receiptblservice.ReceptionRepblService;
import ui.receiptui.ReceiptCheckUI.ShippingCheck;
import ui.util.MyFrame;
import util.enumData.Rep;

/**
 *
 * @author apple
 */
public class Arrive extends javax.swing.JPanel {
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private MyFrame myFrame;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel departLabel;
    private javax.swing.JTextField departText;
    private javax.swing.JLabel getRepNumLabel;
    private javax.swing.JTextField getRepNumText;
    private javax.swing.JLabel getRepTypeLabel;
    private javax.swing.JTextField getRepTypeText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel numLabel;
    private javax.swing.JTextField numText;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField resultMsgText;
    private GetRepblService getControl;
    private ReceptionRepblService receptionControl;
    private DefaultTableModel model;
    private Vector<String> columnIdentifiers;
    private Vector<Object> dataVector;
    private Rep rep;
    private String num;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form GetCheck
     */
    public Arrive(Rep oriRep, String oriNum) {
    	rep = oriRep;
    	num = oriNum;
        initComponents();
        myFrame = new MyFrame(346, 558, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateLabel = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        numLabel = new javax.swing.JLabel();
        numText = new javax.swing.JTextField();
        getRepTypeLabel = new javax.swing.JLabel();
        getRepTypeText = new javax.swing.JTextField();
        getRepNumLabel = new javax.swing.JLabel();
        getRepNumText = new javax.swing.JTextField();
        departLabel = new javax.swing.JLabel();
        departText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        okButton = new javax.swing.JButton();
        resultMsgText = new javax.swing.JTextField();
        getControl = new GetRepController();
        receptionControl = new ReceptionRepController();
        columnIdentifiers = new Vector<String>();
        dataVector = new Vector<Object>();
		model = new DefaultTableModel(dataVector, columnIdentifiers) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

        setBackground(new java.awt.Color(255, 255, 255));

        dateLabel.setText("日期:");

        dateText.setEditable(false);

        numLabel.setText("编号:");

        numText.setEditable(false);

        getRepTypeLabel.setText("到达单据类型:");

        getRepTypeText.setEditable(false);

        getRepNumLabel.setText("到达单据编号:");

        getRepNumText.setEditable(false);

        departLabel.setText("出发地:");

        departText.setEditable(false);
        
        okButton.setText("完成");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        
        resultMsgText.setEditable(false);
        
		columnIdentifiers.add("订单号");
		columnIdentifiers.add("到达状态");
        if(rep==Rep.GetRep){
        	GetRepVO getRepVO = null;
			try {
				getRepVO = getControl.getRepByNum(num);
			} catch (ClassNotFoundException | NotBoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultMsgText.setText(ExceptionPrint.print(e));
			} catch (NumNotFoundException e) {
				// TODO Auto-generated catch block
				resultMsgText.setText(ExceptionPrint.print(e));
			}
        	dateText.setText(getRepVO.date);
        	numText.setText(num);
        	getRepTypeText.setText(getRepVO.rep.getChineseName());
        	getRepNumText.setText(getRepVO.shipNum);
        	departText.setText(getRepVO.depart);
        	try {
				dataVector = getControl.initShow(num);
			} catch (ClassNotFoundException | NotBoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultMsgText.setText(ExceptionPrint.print(e));
			} catch (NumNotFoundException e) {
				// TODO Auto-generated catch block
				resultMsgText.setText(ExceptionPrint.print(e));
			}
        }
        else {
			ReceptionRepVO receptionRepVO = null;
			try {
				receptionRepVO = receptionControl.getRepByNum(num);
			} catch (ClassNotFoundException | NotBoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultMsgText.setText(ExceptionPrint.print(e));
			} catch (NumNotFoundException e) {
				// TODO Auto-generated catch block
				resultMsgText.setText(ExceptionPrint.print(e));
			}
			dateText.setText(receptionRepVO.date);
			departText.setText(receptionRepVO.date);
			numText.setText(num);
			getRepTypeText.setText(receptionRepVO.rep.getChineseName());
			getRepNumText.setText(receptionRepVO.shipNum);
			departText.setText(City.toString(receptionRepVO.city));
			try {
				dataVector = receptionControl.initShow(num);
			} catch (ClassNotFoundException | NotBoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultMsgText.setText(ExceptionPrint.print(e));
			} catch (NumNotFoundException e) {
				// TODO Auto-generated catch block
				resultMsgText.setText(ExceptionPrint.print(e));
			}
		}
        model.setDataVector(dataVector, columnIdentifiers);
        jTable.setModel(model);
        jTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable);
        
		setColumn();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultMsgText)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(departLabel)
                                    .addComponent(getRepNumLabel)
                                    .addComponent(getRepTypeLabel)
                                    .addComponent(numLabel)
                                    .addComponent(dateLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numText)
                                        .addComponent(getRepTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(getRepNumText, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                                    .addComponent(departText, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(okButton)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numLabel)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getRepTypeLabel)
                    .addComponent(getRepTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getRepNumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getRepNumLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departLabel)
                    .addComponent(departText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
	private void setColumn() {
		TableColumn column1 = jTable.getColumnModel().getColumn(0);
		column1.setPreferredWidth(105);
		TableColumn column2 = jTable.getColumnModel().getColumn(1);
		column2.setPreferredWidth(50);
	}

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	myFrame.dispose();
    }

}
