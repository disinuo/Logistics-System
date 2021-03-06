/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui.generalUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Exception.ExceptionPrint;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.Receipt.PayRentVO;
import VO.Receipt.PayRepRentRepVO;
import VO.Receipt.PayRepVO;
import bl.receiptbl.PayRepbl.PayRepRentController;
import blservice.receiptblservice.PayRepRentblService;
import ui.util.MyFrame;
import util.enumData.ResultMessage;

/**
 *
 * @author apple
 */
public class PayRepRent extends javax.swing.JPanel {

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private MyFrame myFrame;
	private javax.swing.JButton addButton;
	private javax.swing.JLabel balanceLabel;
	private javax.swing.JTextField balanceText;
	private javax.swing.JComboBox<String> bankAccountBox;
	private javax.swing.JLabel bankAccountLabel;
	private javax.swing.JButton cancelButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable;
	private javax.swing.JLabel moneyLabel;
	private javax.swing.JTextField moneyText;
	private javax.swing.JButton okButton;
	private javax.swing.JLabel receiverNameLabel;
	private javax.swing.JTextField receiverNameText;
	private javax.swing.JLabel receiverPhoneLabel;
	private javax.swing.JTextField receiverPhoneText;
	private javax.swing.JTextField resultMsgText;
	private javax.swing.JLabel sumLabel;
	private javax.swing.JTextField sumText;
	private PayRepRentblService control;
	private DefaultTableModel model;
	private Vector<String> columnIdentifiers;
	private Vector<Object> dataVector;
	private PayRepVO payRepVO;
	private PayRep payRep;
	private String bankAccount;
	// End of variables declaration//GEN-END:variables

	/**
	 * Creates new form PayRep租金
	 */
	public PayRepRent(PayRep oriPayRep, PayRepVO oriPayRepVO, String bank) {
		payRep = oriPayRep;
		payRepVO = oriPayRepVO;
		bankAccount = bank;
		initComponents();
		myFrame = new MyFrame(512, 606, this);
		myFrame.setTitle("租金");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		receiverNameLabel = new javax.swing.JLabel();
		receiverNameText = new javax.swing.JTextField();
		receiverPhoneLabel = new javax.swing.JLabel();
		receiverPhoneText = new javax.swing.JTextField();
		moneyLabel = new javax.swing.JLabel();
		moneyText = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable = new javax.swing.JTable();
		sumText = new javax.swing.JTextField();
		balanceLabel = new javax.swing.JLabel();
		balanceText = new javax.swing.JTextField();
		bankAccountLabel = new javax.swing.JLabel();
		bankAccountBox = new javax.swing.JComboBox<String>();
		cancelButton = new javax.swing.JButton();
		okButton = new javax.swing.JButton();
		sumLabel = new javax.swing.JLabel();
		addButton = new javax.swing.JButton();
		resultMsgText = new javax.swing.JTextField();
		control = new PayRepRentController();
		columnIdentifiers = new Vector<String>();
		dataVector = new Vector<Object>();
		model = new DefaultTableModel(dataVector, columnIdentifiers){
			@Override
			public boolean isCellEditable(int row, int column){
				if(column==3)
					return true;
				else 
					return false;
			}
		};

		setBackground(new java.awt.Color(255, 255, 255));

		receiverNameLabel.setText("收租人名字:");

		receiverPhoneLabel.setText("收租人手机:");

		moneyLabel.setText("租金:");

		columnIdentifiers.add("收租人名字");
		columnIdentifiers.add("手机");
		columnIdentifiers.add("金额");
		columnIdentifiers.add("备注");
		columnIdentifiers.add("删除");
		dataVector = control.initRentTable(payRepVO);
		if(dataVector==null)
			dataVector = new Vector<Object>();
		model.setDataVector(dataVector, columnIdentifiers);
		jTable.setModel(model);
		jTable.setGridColor(new java.awt.Color(0, 0, 0));
		jScrollPane1.setViewportView(jTable);

		sumLabel.setText("总计:");
		
		sumText.setEditable(false);
        if(dataVector.size()!=0){
        	sumText.setText(calSum());
        }

		balanceLabel.setText("账户余额:");

		balanceText.setEditable(false);

		bankAccountLabel.setText("付款账户:");

		try {
			bankAccountBox = new JComboBox<String>(control.showBankAccount());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}
		if (bankAccount != null) {
			bankAccountBox.setEnabled(false);
			for (int i = 0; i < bankAccountBox.getItemCount(); i++) {
				if (bankAccountBox.getItemAt(i).equals(bankAccount)) {
					bankAccountBox.setSelectedIndex(i);
					double balance = 0;
					try {
						balance = control.showBankBalance(bankAccount);
					} catch (ClassNotFoundException | NameNotFoundException | IOException | NumNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						resultMsgText.setText(ExceptionPrint.print(e));
					}
					balanceText.setText(balance+"");
					break;
				}
			}
		}
		bankAccountBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				bankAccountBoxActionPerformed(evt);
			}
		});

		cancelButton.setText("取消");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

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

		resultMsgText.setEditable(false);

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
				if (col == 4) {
					model.removeRow(row);
					jTable.setModel(model);
					sumText.setText(calSum());
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(moneyLabel)
                                    .addComponent(receiverPhoneLabel)
                                    .addComponent(receiverNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(receiverPhoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(moneyText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(addButton))
                                    .addComponent(receiverNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bankAccountLabel)
                                    .addComponent(balanceLabel)
                                    .addComponent(sumLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bankAccountBox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(cancelButton))
                                            .addComponent(balanceText, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(68, 68, 68)
                                        .addComponent(okButton))
                                    .addComponent(sumText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resultMsgText)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receiverNameLabel)
                    .addComponent(receiverNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receiverPhoneLabel)
                    .addComponent(receiverPhoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moneyLabel)
                    .addComponent(moneyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sumLabel)
                    .addComponent(sumText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bankAccountLabel)
                    .addComponent(bankAccountBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceLabel)
                    .addComponent(balanceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addGap(18, 18, 18)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
	}// </editor-fold>//GEN-END:initComponents

	private void setColumn() {
		TableColumn column1 = jTable.getColumnModel().getColumn(0);
		column1.setPreferredWidth(75);
		TableColumn column2 = jTable.getColumnModel().getColumn(1);
		column2.setPreferredWidth(115);
		TableColumn column3 = jTable.getColumnModel().getColumn(2);
		column3.setPreferredWidth(60);
		TableColumn column4 = jTable.getColumnModel().getColumn(3);
		column4.setPreferredWidth(300);
		TableColumn column5 = jTable.getColumnModel().getColumn(4);
		column5.setPreferredWidth(50);
	}

	private String calSum() {
		double sum = 0;
		for (int i = 0; i < dataVector.size(); i++) {
    		sum += Double.parseDouble((String)jTable.getValueAt(i, 2));
		}
		return sum + "";
	}

	private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
		resultMsgText.setText("");
		if(receiverNameText.getText().equals("")){
			resultMsgText.setText("请填写收租人姓名");
			return;
		}
		if(receiverPhoneText.getText().equals("")){
			resultMsgText.setText("请填写收租人手机");
			return;
		}
		if(moneyText.getText().equals("")){
			resultMsgText.setText("请填写租金金额");
			return;
		}
		String name = receiverNameText.getText();
		String phone = receiverPhoneText.getText();
		double money = Double.parseDouble(moneyText.getText());
		String resultMsg = control.checkNum(phone, 11, "手机号");
		ResultMessage resultMessage = control.checkMoney(money);
		if (!resultMsg.equals("添加成功")) {
			resultMsgText.setText(resultMsg);
			return;
		}
		if (resultMessage != ResultMessage.ADD_SUCCESS) {
			resultMsgText.setText(ResultMessage.toFriendlyString(resultMessage));
			return;
		}
		resultMsgText.setText("添加成功");
		Vector<String> arr = new Vector<String>();
		arr.add(name);
		arr.add(phone);
		arr.add(money + "");
		dataVector.add(arr);
		model.setDataVector(dataVector, columnIdentifiers);
		setColumn();
		sumText.setText(calSum());
		receiverNameText.setText("");
		receiverPhoneText.setText("");
		moneyText.setText("");
	}

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		myFrame.dispose();
	}

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String balanceT = balanceText.getText();
		if(balanceT.equals("")){
			resultMsgText.setText("请选择付款账户");
			return;
		}
		double balance = Double.parseDouble(balanceT);
		double sum = Double.parseDouble(sumText.getText());
		if(sum>balance){
			resultMsgText.setText("付款金额超过账户余额，请更换账户");
			return;
		}
		String bankAccount = (String) bankAccountBox.getSelectedItem();
		try {
			control.minusMoneyInBankAccount(bankAccount, sum);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
			return;
		} catch (NumNotFoundException e) {
			// TODO Auto-generated catch block
			resultMsgText.setText(ExceptionPrint.print(e));
			return;
		}
		ArrayList<PayRentVO> payRentVOs = new ArrayList<PayRentVO>();
		for (int i = 0; i < dataVector.size(); i++) {
			PayRentVO payRentVO = new PayRentVO((String) jTable.getValueAt(i, 0), 
					(String) jTable.getValueAt(i, 1),
					Double.parseDouble((String) jTable.getValueAt(i, 2)), 
					(String) jTable.getValueAt(i, 3));
			payRentVOs.add(payRentVO);
		}
		PayRepRentRepVO payRepRentRepVO = new PayRepRentRepVO(payRentVOs, bankAccount, sum);
		control.submitRent(payRepVO, payRepRentRepVO);
		payRep.deleteRow("租金");
		Vector<String> arr = new Vector<String>();
		arr.add("租金");
		arr.add(sum + "");
		arr.add(bankAccount);
		payRep.createRow(arr);
		myFrame.dispose();
	}
	
	private void bankAccountBoxActionPerformed(java.awt.event.ActionEvent evt){
		resultMsgText.setText("");
		String bankAccount = (String)bankAccountBox.getSelectedItem();
		double balance = 0;
		try {
			balance = control.showBankBalance(bankAccount);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
			return;
		} catch (NameNotFoundException | NumNotFoundException e) {
			// TODO Auto-generated catch block
			resultMsgText.setText(ExceptionPrint.print(e));
			return;
		}
		balanceText.setText(balance+"");
	}

}
