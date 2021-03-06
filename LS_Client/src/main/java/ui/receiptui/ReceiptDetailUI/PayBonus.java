/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui.ReceiptDetailUI;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import VO.Receipt.PayRepVO;
import bl.receiptbl.PayRepbl.PayRepBounsController;
import bl.receiptbl.PayRepbl.PayRepController;
import blservice.receiptblservice.PayRepBonusblService;
import ui.util.MyFrame;

/**
 *
 * @author apple
 */
public class PayBonus extends javax.swing.JPanel {
	
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
    private PayRepBonusblService control;
    private DefaultTableModel model;
    private Vector<String> columnIdentifiers;
    private Vector<Object> dataVector;
    private PayRepVO payRepVO;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form Bonus
     */
    public PayBonus(PayRepVO oriPayRepVO) {
    	payRepVO = oriPayRepVO;
        initComponents();
        myFrame = new MyFrame(553, 524, this);
        myFrame.setTitle("奖金详细信息查看");
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
        sumLabel = new javax.swing.JLabel();
        sumText = new javax.swing.JTextField();
        bankAccountLabel = new javax.swing.JLabel();
        bankAccountText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        okButton = new javax.swing.JButton();
        resultMsgText = new javax.swing.JTextField();
        control = new PayRepBounsController();
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

        sumLabel.setText("总计:");

        sumText.setEditable(false);

        bankAccountLabel.setText("付款账户:");

        bankAccountText.setEditable(false);

        okButton.setText("完成");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        resultMsgText.setEditable(false);
        
        columnIdentifiers.add("名字");
        columnIdentifiers.add("编号");
        columnIdentifiers.add("金额");
        columnIdentifiers.add("备注");
        dateText.setText(payRepVO.date);
        numText.setText(payRepVO.num);
        sumText.setText(payRepVO.bonus.sum+"");
        bankAccountText.setText(payRepVO.bonus.bankAccountNum);
        dataVector = control.initBonusTable(payRepVO);
        model.setDataVector(dataVector, columnIdentifiers);
        jTable.setModel(model);
        jTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable);

        setColumn();
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(bankAccountText, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(236, 236, 236))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultMsgText)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void setColumn(){
    	TableColumn column1 = jTable.getColumnModel().getColumn(0);
        column1.setPreferredWidth(75);
        TableColumn column2 = jTable.getColumnModel().getColumn(1);
        column2.setPreferredWidth(115);
        TableColumn column3 = jTable.getColumnModel().getColumn(2);
        column3.setPreferredWidth(60);
        TableColumn column4 = jTable.getColumnModel().getColumn(3);
        column4.setPreferredWidth(150);
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	myFrame.dispose();
    }

}
