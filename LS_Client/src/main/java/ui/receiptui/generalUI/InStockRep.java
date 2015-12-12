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
import javax.swing.table.TableColumn;

import Exception.ExceptionPrint;
import bl.controllerfactorybl.ControllerFactoryImpl;
import bl.receiptbl.InStockRepbl.InStockRepController;
import blservice.receiptblservice.InStockRepblService;
import util.enumData.ResultMessage;

/**
 *
 * @author apple
 */
public class InStockRep extends javax.swing.JPanel {
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JTextField areaText;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton checkAllRepsButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel locLabel;
    private javax.swing.JTextField locText;
    private javax.swing.JLabel numLabel;
    private javax.swing.JTextField numText;
    private javax.swing.JLabel officeLabel;
    private javax.swing.JTextField officeText;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel orderLabel;
    private javax.swing.JTextField orderText;
    private javax.swing.JTextField resultMsgText;
    private InStockRepController control;
	private DefaultTableModel model;
	private Vector<String> columnIdentifiers;
	private Vector<Object> dataVector;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates new form InStockRep
     */
    public InStockRep() {
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
        areaLabel = new javax.swing.JLabel();
        areaText = new javax.swing.JTextField();
        locLabel = new javax.swing.JLabel();
        locText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        orderLabel = new javax.swing.JLabel();
        orderText = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        resultMsgText = new javax.swing.JTextField();
        checkAllRepsButton = new javax.swing.JButton();
        control = new InStockRepController();
		model = new DefaultTableModel();
		columnIdentifiers = new Vector<String>();
		dataVector = new Vector<Object>();

        setBackground(new java.awt.Color(255, 255, 255));

        dateText.setEditable(false);

        dateLabel.setText("日期:");

        officeText.setEditable(false);
        officeText.setText("025");

        officeLabel.setText("中转中心:");

        numLabel.setText("编号:");

        numText.setEditable(false);
        String num = officeText.getText() + "000";
		num += control.getDateInNum(dateText.getText());
		num += "2";
		try {
			num += control.createNum(dateText.getText(), officeText.getText());
			numText.setText(num);
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMsgText.setText(ExceptionPrint.print(e));
		}
		
        areaLabel.setText("区号:");

        areaText.setEditable(false);

        locLabel.setText("位号:");

        locText.setEditable(false);

        columnIdentifiers.add("订单号");
        columnIdentifiers.add("区号");
        columnIdentifiers.add("位号");
        model.setDataVector(dataVector, columnIdentifiers);
		jTable.setModel(model);
        jTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable);

        orderLabel.setText("订单号:");

        addButton.setText("添加");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
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

        resultMsgText.setEditable(false);

        checkAllRepsButton.setText("查看所有单据");
        checkAllRepsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAllRepsButtonActionPerformed(evt);
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
				if (col == 3) {
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
            .addComponent(resultMsgText, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(checkAllRepsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(officeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(numLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(orderLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(orderText, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cancelButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(okButton))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(areaLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(areaText, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(locLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(locText, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(26, 26, 26)
                                        .addComponent(addButton)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateLabel)
                            .addComponent(officeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(officeLabel)
                            .addComponent(checkAllRepsButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numLabel)
                            .addComponent(numText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderLabel)
                    .addComponent(orderText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaLabel)
                    .addComponent(areaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locLabel)
                    .addComponent(locText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(resultMsgText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void setColumn() {
		TableColumn column1 = jTable.getColumnModel().getColumn(0);
		column1.setPreferredWidth(105);
		TableColumn column2 = jTable.getColumnModel().getColumn(1);
		column2.setPreferredWidth(30);
		TableColumn column3 = jTable.getColumnModel().getColumn(2);
		column3.setPreferredWidth(30);
		TableColumn column4 = jTable.getColumnModel().getColumn(3);
		column4.setPreferredWidth(10);
	}

    private void checkAllRepsButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	String order = orderText.getText();
		ResultMessage resultMessage = control.checkNum(order, 10);
		String resultMsg = ResultMessage.toFriendlyString(resultMessage);
		resultMsgText.setText(resultMsg);
		if (resultMessage == ResultMessage.ADD_SUCCESS) {
			String destination = 
			ArrayList<StockDivisionVO> stockDivisionVOs = control.getBlock(destination);
		}
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {

    }

}
