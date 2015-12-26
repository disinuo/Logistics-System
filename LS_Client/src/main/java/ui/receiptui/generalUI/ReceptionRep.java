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
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Exception.ExceptionPrint;
import Exception.GoodsNotFound;
import Exception.NumNotFoundException;
import VO.Receipt.ArriveVO;
import VO.Receipt.ReceptionRepVO;
import bl.controllerfactorybl.ControllerFactoryImpl;
import blservice.receiptblservice.ReceptionRepblService;
import ui.receiptui.ReceiptCheckUI.ArriveCheck;
import ui.util.MyFrame;
import util.CurrentCity;
import util.enumData.City;
import util.enumData.GoodsArrivalState;
import util.enumData.GoodsLogisticState;
import util.enumData.Rep;

/**
 *
 * @author apple
 */
public class ReceptionRep extends javax.swing.JPanel {

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private MyFrame myFrame;
	private javax.swing.JButton addButton;
	private javax.swing.JComboBox<String> arriveStateBox;
	private javax.swing.JLabel arriveStateLabel;
	private javax.swing.JButton cancelButton;
	private javax.swing.JButton checkAllRepsButton;
	private javax.swing.JLabel dateLabel;
	private javax.swing.JTextField dateText;
	private javax.swing.JLabel departLabel;
	private javax.swing.JTextField departText;
	private javax.swing.JComboBox<String> getTypeBox;
	private javax.swing.JLabel getTypeLabel;
	private javax.swing.JTextField getTypeText;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable;
	private javax.swing.JLabel numLabel;
	private javax.swing.JTextField numText;
	private javax.swing.JLabel officeLabel;
	private javax.swing.JTextField officeText;
	private javax.swing.JButton okButton;
	private javax.swing.JLabel orderLabel;
	private javax.swing.JTextField orderText;
	private javax.swing.JTextField resultMsgText;
	private javax.swing.JButton completeButton;
	private javax.swing.JButton confirmButton;
	private ReceptionRepblService control;
	private DefaultTableModel model;
	private Vector<String> columnIdentifiers;
	private Vector<Object> dataVector;
	private String officeID;
	// End of variables declaration//GEN-END:variables

	/**
	 * Creates new form ReceptionRep
	 */
	public ReceptionRep() {
		initComponents();
		myFrame = new MyFrame(556, 476, this);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		departText = new javax.swing.JTextField();
		dateText = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable = new javax.swing.JTable();
		dateLabel = new javax.swing.JLabel();
		officeText = new javax.swing.JTextField();
		orderLabel = new javax.swing.JLabel();
		officeLabel = new javax.swing.JLabel();
		orderText = new javax.swing.JTextField();
		numLabel = new javax.swing.JLabel();
		arriveStateLabel = new javax.swing.JLabel();
		numText = new javax.swing.JTextField();
		getTypeBox = new javax.swing.JComboBox<String>();
		getTypeLabel = new javax.swing.JLabel();
		addButton = new javax.swing.JButton();
		arriveStateBox = new javax.swing.JComboBox<String>();
		cancelButton = new javax.swing.JButton();
		getTypeText = new javax.swing.JTextField();
		okButton = new javax.swing.JButton();
		departLabel = new javax.swing.JLabel();
		resultMsgText = new javax.swing.JTextField();
		checkAllRepsButton = new javax.swing.JButton();
		confirmButton = new javax.swing.JButton();
		completeButton = new javax.swing.JButton();
        control = ControllerFactoryImpl.getInstance().getReceptionRepblService();
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
		dateText.setText(control.getDate());

		officeText.setEditable(false);
		try {
			officeText.setText(City.toString(CurrentCity.getCurrentCity()));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}
		officeID = CurrentCity.getCurrentOptorID(officeText.getText());

		orderLabel.setText("订单号:");

		officeLabel.setText("营业厅:");

		numLabel.setText("编号:");

		numText.setEditable(false);
		String num = officeID;
		num += "000";
		num += control.getDateInNum(dateText.getText());
		num += "1";
		try {
			num += control.createNum(dateText.getText(), officeID);
			numText.setText(num);
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}

		arriveStateLabel.setText("到达状态:");

		columnIdentifiers.add("订单号");
		columnIdentifiers.add("到达状态");
		columnIdentifiers.add("删除");

		model.setDataVector(dataVector, columnIdentifiers);
		jTable.setModel(model);
		jTable.setGridColor(new java.awt.Color(0, 0, 0));
		jScrollPane1.setViewportView(jTable);

		getTypeBox.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "营业厅装车单", "中转单" }));

		getTypeLabel.setText("到达单据类型:");

		addButton.setText("添加");
		addButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addButtonActionPerformed(evt);
			}
		});

		arriveStateBox.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "正常", "损毁", "丢失" }));

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

		departLabel.setText("出发地:");

		resultMsgText.setEditable(false);

		checkAllRepsButton.setText("查看所有单据");
		checkAllRepsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				checkAllRepsButtonActionPerformed(evt);
			}
		});

		confirmButton.setText("确定");
		confirmButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				confirmButtonActionPerformed(evt);
			}
		});

		completeButton.setText("完成");
		completeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				completeButtonActionPerformed(evt);
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
				if (col == 2) {
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
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(resultMsgText)
				.addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(checkAllRepsButton)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(officeLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(dateLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(15, 15, 15))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(getTypeLabel).addComponent(departLabel))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(departText, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createSequentialGroup()
														.addComponent(getTypeBox,
																javax.swing.GroupLayout.PREFERRED_SIZE, 147,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(getTypeText,
																javax.swing.GroupLayout.PREFERRED_SIZE, 193,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(confirmButton))))
								.addGroup(layout.createSequentialGroup().addGap(52, 52, 52).addComponent(numLabel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 179,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(10, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(81, 81, 81)
												.addComponent(addButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(completeButton))
										.addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addComponent(orderLabel)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(orderText, javax.swing.GroupLayout.PREFERRED_SIZE,
																106, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup().addComponent(arriveStateLabel)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(arriveStateBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addGroup(layout.createSequentialGroup().addComponent(cancelButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(okButton)))
								.addGap(20, 20, 20)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(12, 12, 12)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(dateLabel)
						.addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(officeLabel).addComponent(checkAllRepsButton))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(numLabel)
						.addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(getTypeLabel)
						.addComponent(getTypeText, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(getTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmButton))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(departLabel).addComponent(departText, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(
						layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254,
												Short.MAX_VALUE)
										.addGap(24, 24, 24))
						.addGroup(layout.createSequentialGroup().addGap(46, 46, 46)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(orderLabel).addComponent(orderText,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(arriveStateLabel).addComponent(arriveStateBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(addButton).addComponent(completeButton))
								.addGap(38, 38, 38)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(cancelButton).addComponent(okButton))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69,
										Short.MAX_VALUE)))
				.addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
	}// </editor-fold>//GEN-END:initComponents

	private void setColumn() {
		TableColumn column1 = jTable.getColumnModel().getColumn(0);
		column1.setPreferredWidth(100);
		TableColumn column2 = jTable.getColumnModel().getColumn(1);
		column2.setPreferredWidth(80);
		TableColumn column3 = jTable.getColumnModel().getColumn(2);
		column3.setPreferredWidth(50);
	}

	private void checkAllRepsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		new ArriveCheck(Rep.ReceptionRep, officeID);
	}

	private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String order = orderText.getText();
		if(order.equals("")){
			resultMsgText.setText("请填写订单号");
			return;
		}
    	if(checkRepeat(order)){
    		resultMsgText.setText("该订单号已填写");
    		return;
    	}
		String resultMessage = control.checkNum(order, 10, "编号");
		resultMsgText.setText(resultMessage);
		if (!resultMessage.equals("添加成功")) {
			return;
		}
		if (!control.isTrueOrder(order)) {
			resultMsgText.setText("未找到该订单");
			return;
		}
		Vector<String> arr = new Vector<String>();
		arr.add(order);
		arr.add(arriveStateBox.getSelectedItem().toString());
		dataVector.add(arr);
		model.setDataVector(dataVector, columnIdentifiers);
		setColumn();
		orderText.setText("");
	}

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		myFrame.dispose();
	}

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String num = numText.getText();
		String date = dateText.getText();
		String repString = getTypeBox.getSelectedItem().toString();
		Rep rep = Rep.getRep(repString);
		String shipNum = getTypeText.getText();
		City city = City.getCity(departText.getText());
		ArrayList<ArriveVO> arriveVOs = new ArrayList<ArriveVO>();
		for (int i = 0; i < dataVector.size(); i++) {
			ArriveVO vo = new ArriveVO((String) jTable.getValueAt(i, 0),
					GoodsArrivalState.getGoodsArrivalState((String) jTable.getValueAt(i, 1)));
			arriveVOs.add(vo);
		}
		ReceptionRepVO receptionRepVO = new ReceptionRepVO(num, date, rep, shipNum, arriveVOs, city);
		try {
			control.submit(receptionRepVO);
		} catch (NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
			return;
		}
		changeArrivalState();
		myFrame.dispose();
	}

	private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if(getTypeText.getText().equals("")){
			resultMsgText.setText("请填写到达单据编号");
			return;
		}
		String repString = getTypeBox.getSelectedItem().toString();
		Rep rep = Rep.getRep(repString);
		String shipNum = getTypeText.getText();
		try {
			departText.setText(control.getDepart(rep, shipNum));
		} catch (ClassNotFoundException | NotBoundException | IOException | NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
			return;
		}
	}

	private void completeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String repString = getTypeBox.getSelectedItem().toString();
		Rep rep = Rep.getRep(repString);
		ArrayList<String> existOrders = new ArrayList<String>();
		for (int i = 0; i < dataVector.size(); i++) {
			existOrders.add((String) jTable.getValueAt(i, 0));
		}
		Vector<Object> arrs = null;
		try {
			arrs = control.initTable(rep, getTypeText.getText(), existOrders);
		} catch (ClassNotFoundException | NotBoundException | IOException | NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
			return;
		}
		dataVector.addAll(arrs);
		model.setDataVector(dataVector, columnIdentifiers);
		setColumn();
	}

	private void changeArrivalState() {
		for (int i = 0; i < dataVector.size(); i++) {
			String order = (String) jTable.getValueAt(i, 0);
			GoodsArrivalState goodsArrivalState = GoodsArrivalState
					.getGoodsArrivalState((String) jTable.getValueAt(i, 1));
			if (goodsArrivalState != GoodsArrivalState.INTACT) {
				control.transferOver(order, goodsArrivalState);
			} else {
				String destination = null;
				String depart = null;
				try {
					depart = control.getDepart(order);
					destination = control.getDestination(order);
				} catch (GoodsNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					resultMsgText.setText(ExceptionPrint.print(e));
					return;
				}
				if (officeID.equals(destination)) {
					control.changeLogistic(order, GoodsLogisticState.RECEIVER_TRANSCENTER_ARRIVED);
				} else if (officeID.equals(depart)) {
					control.changeLogistic(order, GoodsLogisticState.SENDER_TRANSCENTER_ARRIVED);
				}
			}
		}
	}
	
    private boolean checkRepeat(String num){
    	for(int i = 0;i < dataVector.size();i++){
    		if(((String)jTable.getValueAt(i, 0)).equals(num)){
    			return true;
    		}
    	}
    	return false;
    }
}
