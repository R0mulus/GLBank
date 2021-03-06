/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iban;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Joseph
 */
public class IbanGenerator extends javax.swing.JFrame {
    private int[] account = new int[10];
    private int[] prefix = new int[6];
    private int[] bank = new int[4];
    private int[] bban = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,8,2,0,0,0};
    private char[] iban = {'S','K',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int controlNum;
    
    /**
     * Creates new form IbanGenerator
     */
    public IbanGenerator() {
        initComponents();
        txtIban.setEditable(false);
        setLocationRelativeTo(null);
        setResizable(false);
        
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
        txtAccount = new javax.swing.JTextField();
        txtBank = new javax.swing.JTextField();
        btnIbanOK = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtIban = new javax.swing.JTextField();
        btnIbanCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPrefix = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Account: ");

        jLabel2.setText("Bank code: ");

        txtBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBankActionPerformed(evt);
            }
        });

        btnIbanOK.setText("OK");
        btnIbanOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIbanOKActionPerformed(evt);
            }
        });

        jLabel3.setText("IBAN (SK): ");

        btnIbanCancel.setText("Cancel");
        btnIbanCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIbanCancelActionPerformed(evt);
            }
        });

        jLabel4.setText("Prefix: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIbanOK, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnIbanCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIban, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(txtAccount)
                    .addComponent(txtBank)
                    .addComponent(txtPrefix))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIbanOK)
                    .addComponent(btnIbanCancel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBankActionPerformed

    private void btnIbanCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIbanCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnIbanCancelActionPerformed

    private void btnIbanOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIbanOKActionPerformed
        if(!testAccount()){
            JOptionPane.showMessageDialog(null, "Account must consist of digits and be from 2 to 10 digits long!");
        }else if(!testPrefix()){
            JOptionPane.showMessageDialog(null, "Leave prefix empty or maximum of 6 digits!");
        }else if(!testBank()){
            JOptionPane.showMessageDialog(null, "Bank must be exactly 4 digits long!");
        }else{
            controlNum = 0;
            String acc = prependZeroes(txtAccount.getText(),"account");
            String pref = prependZeroes(txtPrefix.getText(),"prefix");
            String bankk = txtBank.getText();
            convertStringToArray(acc,"account");
            convertStringToArray(pref,"prefix");
            convertStringToArray(bankk,"bank");
            bankToBBAN();
            prefixToBBAN();
            accountToBBAN();
            calculateControlNum();
            appendItemsToIBAN();
            System.out.println("");
            String fullIBAN = new String(iban);

            
            txtIban.setText(fullIBAN);
        }
    }//GEN-LAST:event_btnIbanOKActionPerformed

    public static void main(String[] args){
        IbanGenerator ibanGenerator = new IbanGenerator();
        ibanGenerator.setVisible(true);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIbanCancel;
    private javax.swing.JButton btnIbanOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtAccount;
    private javax.swing.JTextField txtBank;
    private javax.swing.JTextField txtIban;
    private javax.swing.JTextField txtPrefix;
    // End of variables declaration//GEN-END:variables

    private void appendItemsToIBAN(){
        String contr = "" + controlNum;
        for(int i = 2; i < 4; i++){
            iban[i] = contr.charAt(i-2);
        }
        for(int i = 4; i < 8; i++){
            iban[i] = Character.forDigit(bank[i-4], 10);
        }
        for(int i = 8; i < 14; i++){
            iban[i] = Character.forDigit(prefix[i-8], 10);
        }
        for(int i = 14; i < 24; i++){
            iban[i] = Character.forDigit(account[i-14], 10);
        }
    }
    
    private void calculateControlNum(){
        for(int i = 0; i < bban.length; i++){
            controlNum = ( (controlNum*10) + bban[i]) % 97;
	}
	controlNum = 98 - controlNum;
    }
    
    private void bankToBBAN(){
        System.arraycopy(bank, 0, bban, 0, 4);
    }
    
    private void prefixToBBAN(){
        System.arraycopy(prefix, 0, bban, 4, 6);
    }
    
    private void accountToBBAN(){
        System.arraycopy(account, 0, bban, 10, 10);
    }
    
    private boolean testAccount() {
        String account = txtAccount.getText();
        return (isLong(account) && (account.length() <= 10) && (account.length() >= 2));
    }

    private boolean testBank() {
        String bank = txtBank.getText();
        return (isLong(bank) && (bank.length() == 4));
    }
    
    private boolean testPrefix(){
        String prefix = txtPrefix.getText();
        return (prefix.equals("") || ( isLong(prefix) && (prefix.length() <= 6) ));
    }

    private boolean isLong(String text) {
        try {
            Long.parseLong(text);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
    
    private int[] convertStringToArray(String text, String type){
        int length = text.length() - 1;
        int pom;
        switch(type){
            case "account":
                for(int i = 9; i >= 0; i--){
                    pom = Character.getNumericValue(text.charAt(length));
                    account[i] = pom;
                    length--;
                }
                return account;
            case "prefix":
                for(int i = 5; i >= 0; i--){
                    pom = Character.getNumericValue(text.charAt(length));
                    prefix[i] = pom;
                    length--;
                }
                return prefix;
            case "bank":
                for(int i = 3; i >= 0; i--){
                    pom = Character.getNumericValue(text.charAt(length));
                    bank[i] = pom;
                    length--;
                }
                return bank;
        }
        
        return null;
    }
    
    private String prependZeroes(String text, String type){
        int length = text.length();
        switch(type){
            case "account":
                if(length < 10){
                    for(int i = 0; i < 10-length; i++){
                        text = "0" + text;
                    }
                }
                break;
            case "prefix":
                if(length < 6){
                    for(int i = 0; i < 6-length; i++){
                        text = "0" + text;
                    }
                }
                break;
        }
        
        return text;
    }
    
 

}
