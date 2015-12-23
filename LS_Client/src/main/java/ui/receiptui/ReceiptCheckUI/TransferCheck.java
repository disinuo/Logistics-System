/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.receiptui.ReceiptCheckUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Exception.ExceptionPrint;
import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import bl.receiptbl.TransferRepbl.TransferRepController;
import blservice.receiptblservice.TransferRepblService;
import ui.receiptui.ReceiptDetailUI.Transfer;
import ui.util.MyFrame;

/**
 *
 * @author apple
 */
public class TransferCheck extends javax.swing.JPanel {

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private MyFrame myFrame;
	private javax.swing.JLabel dateLabel;
	private javax.swing.JTextField dateText;
	private javax.swing.JButton findButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable;
	private javax.swing.JButton okButton;
	private javax.swing.JTextField resultMsgText;
	private TransferRepblService control;
	private DefaultTableModel model;
	private Vector<String> columnIdentifiers;
	private Vector<Object> dataVector;
	private String office;
	// End of variables declaration//GEN-END:variables

	/**
	 * Creates new form TransferCheck
	 */
	public TransferCheck(String oriOffice) {
    	office = oriOffice;
		initComponents();
		myFrame = new MyFrame(521, 398, this);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		findButton = new javax.swing.JButton();
		dateLabel = new javax.swing.JLabel();
		dateText = new javax.swing.JTextField();
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

		findButton.setText("查找");
		findButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				findButtonActionPerformed(evt);
			}
		});

		dateLabel.setText("时间:");

		columnIdentifiers.add("日期");
		columnIdentifiers.add("编号");
		columnIdentifiers.add("装运形式");
		columnIdentifiers.add("车次");
		columnIdentifiers.add("目的地");
		columnIdentifiers.add("查看详细信息");
		try {
			dataVector = control.initCheck(office);
		} catch (ClassNotFoundException | NotBoundException | IOException | NameNotFoundException | NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}
        model.setDataVector(dataVector, columnIdentifiers);
        jTable.setModel(model);
		jTable.setGridColor(new java.awt.Color(0, 0, 0));
		jScrollPane1.setViewportView(jTable);

		okButton.setText("完成");
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonActionPerformed(evt);
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
				if(col==5){
					new Transfer((String)jTable.getValueAt(row, 1));
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
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486,
														javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup().addComponent(dateLabel)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(findButton))))
						.addGroup(layout.createSequentialGroup().addGap(224, 224, 224).addComponent(okButton)))
						.addContainerGap(15, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(dateLabel)
						.addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(findButton))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(okButton)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
	}// </editor-fold>//GEN-END:initComponents
	
	private void setColumn() {
		TableColumn column1 = jTable.getColumnModel().getColumn(0);
		column1.setPreferredWidth(110);
		TableColumn column2 = jTable.getColumnModel().getColumn(1);
		column2.setPreferredWidth(180);
		TableColumn column3 = jTable.getColumnModel().getColumn(2);
		column3.setPreferredWidth(50);
		TableColumn column4 = jTable.getColumnModel().getColumn(3);
		column4.setPreferredWidth(80);
		TableColumn column5 = jTable.getColumnModel().getColumn(4);
		column5.setPreferredWidth(75);
		TableColumn column6 = jTable.getColumnModel().getColumn(5);
		column6.setPreferredWidth(50);
	}

	private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {
		int row = jTable.getSelectedRow();
		if(row==-1)
			row = 0;
		for (int i = row; i < dataVector.size(); i++) {
			if (((String) jTable.getValueAt(i, 0)).equals(dateText.getText()))
				jTable.setRowSelectionInterval(i, i);
		}
	}

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
		myFrame.dispose();
	}

}
