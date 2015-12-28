/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui.ReceiptDetailUI;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import VO.Receipt.PayRepRefundRepVO;
import VO.Receipt.PayRepVO;
import bl.receiptbl.PayRepbl.PayRepController;
import bl.receiptbl.PayRepbl.PayRepRefundController;
import blservice.receiptblservice.PayRepRefundblService;
import ui.util.MyFrame;

/**
 *
 * @author apple
 */
public class PayRefund extends javax.swing.JPanel {
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
	private MyFrame myFrame;
    private javax.swing.JLabel bankAccountLabel;
    private javax.swing.JTextField bankAccountText;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel numLabel;
    private javax.swing.JTextField numText;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField resultMsgText;
    private javax.swing.JLabel sumLabel;
    private javax.swing.JTextField sumText;
    private PayRepRefundblService control;
    private DefaultTableModel model;
    private Vector<String> columnIdentifiers;
    private Vector<Object> dataVector;
    private PayRepVO payRepVO;
    private String date;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form PayRepRefund
     */
    public PayRefund(String oriDate, PayRepVO oriPayRepVO) {
    	payRepVO = oriPayRepVO;
    	date = oriDate;
        initComponents();
        myFrame = new MyFrame(367, 526, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bankAccountLabel = new javax.swing.JLabel();
        sumText = new javax.swing.JTextField();
        sumLabel = new javax.swing.JLabel();
        numText = new javax.swing.JTextField();
        numLabel = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        resultMsgText = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        bankAccountText = new javax.swing.JTextField();
        control = new PayRepRefundController();
        columnIdentifiers = new Vector<String>();
        dataVector = new Vector<Object>();
		model = new DefaultTableModel(dataVector, columnIdentifiers) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

        setBackground(new java.awt.Color(255, 255, 255));

        bankAccountLabel.setText("付款账户:");

        sumText.setEditable(false);

        sumLabel.setText("总计:");

        numText.setEditable(false);

        numLabel.setText("编号:");

        dateText.setEditable(false);

        dateLabel.setText("日期:");

        resultMsgText.setEditable(false);

        okButton.setText("完成");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        bankAccountText.setEditable(false);
        
        columnIdentifiers.add("金额");
        columnIdentifiers.add("付款原因");
        PayRepRefundRepVO payRepRefundRepVO = control.getRefundByDate(payRepVO.refund, date);
        dateText.setText(payRepVO.date);
        numText.setText(payRepVO.num);
        sumText.setText(payRepRefundRepVO.sum+"");
        bankAccountText.setText(payRepRefundRepVO.bankAccountNum);
        dataVector = control.initRefundTable(payRepVO, date);
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
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bankAccountLabel)
                            .addComponent(sumLabel)
                            .addComponent(numLabel)
                            .addComponent(dateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sumText, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bankAccountText, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(okButton)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numLabel)
                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sumLabel)
                    .addComponent(sumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankAccountLabel)
                    .addComponent(bankAccountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void setColumn(){
    	TableColumn column1 = jTable.getColumnModel().getColumn(0);
        column1.setPreferredWidth(60);
        TableColumn column2 = jTable.getColumnModel().getColumn(1);
        column2.setPreferredWidth(300);
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	myFrame.dispose();
    }

}
