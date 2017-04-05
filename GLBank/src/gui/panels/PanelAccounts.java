/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import database.ConnectionProvider;
import glbank.Account;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Joseph
 */
public class PanelAccounts extends javax.swing.JPanel {
    private int idc;
    private List<Account> listAcc = new ArrayList<>();
    ConnectionProvider conn = new ConnectionProvider();
    /**
     * Creates new form PanelAccounts
     */
    public PanelAccounts(int idc) {
        initComponents();
        this.idc = idc;
        initAccountList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        btnAddFunds = new javax.swing.JButton();
        btnSubFunds = new javax.swing.JButton();
        cmbBoxAccountList = new javax.swing.JComboBox<>();
        btnCreateNewAccount = new javax.swing.JButton();
        txtAddFunds = new javax.swing.JTextField();
        txtSubFunds = new javax.swing.JTextField();
        tabAboutAccount = new javax.swing.JTabbedPane();

        jLabel1.setText("Account: ");

        jLabel2.setText("Balance: ");

        lblBalance.setText("0.00");

        btnAddFunds.setText("Add funds");
        btnAddFunds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFundsActionPerformed(evt);
            }
        });

        btnSubFunds.setText("Remove Funds");
        btnSubFunds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubFundsActionPerformed(evt);
            }
        });

        cmbBoxAccountList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));
        cmbBoxAccountList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxAccountListActionPerformed(evt);
            }
        });

        btnCreateNewAccount.setText("Create new account");
        btnCreateNewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreateNewAccount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAddFunds)
                            .addComponent(btnAddFunds, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addComponent(btnSubFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtSubFunds, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbBoxAccountList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tabAboutAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbBoxAccountList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabAboutAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddFunds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubFunds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubFunds)
                    .addComponent(btnAddFunds)
                    .addComponent(btnCreateNewAccount))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void cmbBoxAccountListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxAccountListActionPerformed
        refreshBalance();
    }//GEN-LAST:event_cmbBoxAccountListActionPerformed

    private void btnCreateNewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewAccountActionPerformed
        conn.createRandomAccount(idc);
        JOptionPane.showMessageDialog(btnAddFunds.getRootPane(), conn.getRandomBankAccount());
        initAccountList();
    }//GEN-LAST:event_btnCreateNewAccountActionPerformed

    private void btnAddFundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFundsActionPerformed
        if(isFloat(txtAddFunds.getText())){
            
            float funds = parseStringToFloat(txtAddFunds.getText());
            if(funds >= 0.1){
                controlFunds(funds, '+');
                JOptionPane.showMessageDialog(btnAddFunds.getRootPane(), "Transaction complete");
            }   
        }
    }//GEN-LAST:event_btnAddFundsActionPerformed

    private void btnSubFundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubFundsActionPerformed
        if(isFloat(txtSubFunds.getText())){
            
            float funds = parseStringToFloat(txtSubFunds.getText());
            if(funds >= 0.1){
                controlFunds(funds, '-');
                JOptionPane.showMessageDialog(btnSubFunds.getRootPane(), "Transaction complete");
            }          
        }
    }//GEN-LAST:event_btnSubFundsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFunds;
    private javax.swing.JButton btnCreateNewAccount;
    private javax.swing.JButton btnSubFunds;
    private javax.swing.JComboBox<String> cmbBoxAccountList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JTabbedPane tabAboutAccount;
    private javax.swing.JTextField txtAddFunds;
    private javax.swing.JTextField txtSubFunds;
    // End of variables declaration//GEN-END:variables

    private void initAccountList() {
        cmbBoxAccountList.removeAllItems();
        cmbBoxAccountList.addItem("Choose");
        listAcc = null;
        listAcc = conn.getListOfAccounts(idc);
        
        if(listAcc != null && listAcc.size() > 0){
            for(Account account : listAcc){
                cmbBoxAccountList.addItem("" + account.getIdacc() + "/2701");
            }
        }
        
        lblBalance.setVisible(false);
        txtAddFunds.setVisible(false);
        txtSubFunds.setVisible(false);
        btnAddFunds.setVisible(false);
        btnSubFunds.setVisible(false);
    }
    
    private void initCardList(){
        
    }
    
    private void refreshBalance(){
        int index = cmbBoxAccountList.getSelectedIndex();
        listAcc = conn.getListOfAccounts(idc);
        
        if(!listAcc.isEmpty() && index > 0){
            Account selectedAccount = listAcc.get(index - 1);
            lblBalance.setVisible(true);
            lblBalance.setText(String.valueOf(selectedAccount.getBalance()));
            txtAddFunds.setVisible(true);
            txtSubFunds.setVisible(true);
            btnAddFunds.setVisible(true);
            btnSubFunds.setVisible(true);
        }else {
            lblBalance.setVisible(false);
            txtAddFunds.setVisible(false);
            txtSubFunds.setVisible(false);
            btnAddFunds.setVisible(false);
            btnSubFunds.setVisible(false);
        }
       
    }
    
    private void controlFunds(float funds, char type){
        int index = cmbBoxAccountList.getSelectedIndex();
        long selectedAccount = listAcc.get(index - 1).getIdacc();
        try {
            conn.controlFundsToSelectedAccount(selectedAccount, funds, type);
            refreshBalance();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        txtAddFunds.setText("");
        txtSubFunds.setText("");
    }
    
    private boolean isFloat(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(btnSubFunds.getRootPane(), "Can not add string or negative numbers!");
            return false;
        }
    }
    
    private float parseStringToFloat(String value){
        float finalValue = Float.parseFloat(value);
        finalValue = (float)Math.round(finalValue * 100) / 100;
        return finalValue;
    }
}
