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

import Exception.ExceptionPrint;
import Exception.NumNotFoundException;
import VO.ReceiptVO.CashRepVO;
import bl.receiptbl.CashRepbl.CashRepController;
import ui.util.MyFrame;

/**
 *
 * @author apple
 */
public class Cash extends javax.swing.JPanel {
	
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
    private CashRepController control;
    private DefaultTableModel model;
    private Vector<String> columnIdentifiers;
    private Vector<Object> dataVector;
    private String num;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form Cash
     */
    public Cash(String oriNum) {
    	num = oriNum;
        initComponents();
        myFrame = new MyFrame(551, 518, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateLabel = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        numLabel = new javax.swing.JLabel();
        numText = new javax.swing.JTextField();
        sumLabel = new javax.swing.JLabel();
        sumText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        bankAccountLabel = new javax.swing.JLabel();
        bankAccountText = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        resultMsgText = new javax.swing.JTextField();
        control = new CashRepController();
        model = new DefaultTableModel();
        columnIdentifiers = new Vector<String>();
        dataVector = new Vector<Object>();

        setBackground(new java.awt.Color(255, 255, 255));

        dateLabel.setText("日期:");

        dateText.setEditable(false);

        numLabel.setText("编号:");

        numText.setEditable(false);

        sumLabel.setText("金额:");

        sumText.setEditable(false);

        bankAccountLabel.setText("收款账号:");

        bankAccountText.setEditable(false);

        okButton.setText("完成");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        resultMsgText.setEditable(false);
        
        columnIdentifiers.add("快递员名字");
        columnIdentifiers.add("快递员编号");
        columnIdentifiers.add("金额");
        columnIdentifiers.add("备注");
        CashRepVO cashRepVO = null;
        try {
        	cashRepVO = control.getRepByNum(num);
		} catch (ClassNotFoundException | NotBoundException | IOException | NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}
        dateText.setText(cashRepVO.date);
        numText.setText(num);
        sumText.setText(cashRepVO.sum+"");
        bankAccountText.setText(cashRepVO.bankAccount);
        try {
			dataVector = control.initShow(num);
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
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
                        .addGap(219, 219, 219)
                        .addComponent(okButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sumLabel)
                                    .addComponent(numLabel)
                                    .addComponent(dateLabel)
                                    .addComponent(bankAccountLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sumText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bankAccountText, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
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
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankAccountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bankAccountLabel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void setColumn(){
    	TableColumn column1 = jTable.getColumnModel().getColumn(0);
        column1.setPreferredWidth(60);
        TableColumn column2 = jTable.getColumnModel().getColumn(1);
        column2.setPreferredWidth(80);
        TableColumn column3 = jTable.getColumnModel().getColumn(2);
        column3.setPreferredWidth(30);
        TableColumn column4 = jTable.getColumnModel().getColumn(3);
        column4.setPreferredWidth(60);
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	myFrame.dispose();
    }

}
