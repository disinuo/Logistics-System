/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.administratorui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import main.MainFrame;
import ui.receiptui.generalUI.OutStockRep;
import ui.util.MyFrame;

/**
 *
 * @author G
 */
public class AdministratorPanel extends javax.swing.JFrame {

    /**
     * Creates new form Management
     */
    public AdministratorPanel() {
        initComponents();
        this.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {


    	/**
    	 * 设置窗体大小为不可变
    	 */
    	this.setResizable(false);
    	/**
    	 * 设置窗体在中部出现
    	 */
    	Toolkit tk = Toolkit.getDefaultToolkit();
    	Dimension screensize = tk.getScreenSize();
    	int screenh = screensize.height;
    	int screenw = screensize.width;
    	this.setSize(500, 300);
    	this.setLocation(screenw/2-this.getWidth()/2, screenh/2-this.getHeight()/2);
    	/**
    	 * 关闭窗口
    	 */
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	

    	
        jLabel9 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        authority = new javax.swing.JButton();
        userAccount = new javax.swing.JButton();

        jLabel9.setText("当前账户：大玉儿");

        exit.setText("退出");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        authority.setText("权限");
        authority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorityActionPerformed(evt);
            }
        });

        userAccount.setText("用户账户");
        userAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(authority, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(userAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(exit))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authority, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    	MainFrame mf = new MainFrame();
    	mf.setVisible(true);
    	this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void authorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    	JFrame frame = new JFrame();
   	
    	frame.setResizable(false);
    	Toolkit tk = Toolkit.getDefaultToolkit();
    	Dimension screensize = tk.getScreenSize();
    	int screenh = screensize.height;
    	int screenw = screensize.width;
    	frame.setSize(820, 340);
    	frame.setLocation(screenw/2-this.getWidth()/2, screenh/2-this.getHeight()/2);	
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
		AuthorityManagementPanel amp = new AuthorityManagementPanel(frame);
    	frame.setContentPane(amp);
    	frame.setVisible(true);
    	this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void userAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    	UserAccountPanel userAccount = new UserAccountPanel();
    	userAccount.setVisible(true);
    	this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JButton authority;
    private javax.swing.JButton userAccount;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
