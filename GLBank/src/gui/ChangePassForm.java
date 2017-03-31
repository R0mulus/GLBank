/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.ConnectionProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Joseph
 */
public class ChangePassForm extends javax.swing.JDialog {
    private int idemp;
    private ConnectionProvider conn;
    /**
     * Creates new form ChangePassForm
     */
    public ChangePassForm(java.awt.Frame parent, boolean modal, int idemp) {
        super(parent, modal);
        this.idemp = idemp;
        conn = new ConnectionProvider();
        initComponents();
        setLocationRelativeTo(null);
        lblErrorOldPassword.setVisible(false);
        lblPasswordsDontMatchError.setVisible(false);
        lblInvalidPassword.setVisible(false);
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
        jLabel3 = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JPasswordField();
        txtNewPassword = new javax.swing.JPasswordField();
        txtNewPasswordRepeat = new javax.swing.JPasswordField();
        btnChangePassOK = new javax.swing.JButton();
        btnChangePassCancel = new javax.swing.JButton();
        lblPasswordsDontMatchError = new javax.swing.JLabel();
        lblErrorOldPassword = new javax.swing.JLabel();
        lblInvalidPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Old password: ");

        jLabel2.setText("New password: ");

        jLabel3.setText("Repeat new password: ");

        btnChangePassOK.setText("OK");
        btnChangePassOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassOKActionPerformed(evt);
            }
        });

        btnChangePassCancel.setText("Cancel");
        btnChangePassCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassCancelActionPerformed(evt);
            }
        });

        lblPasswordsDontMatchError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPasswordsDontMatchError.setForeground(new java.awt.Color(255, 0, 0));
        lblPasswordsDontMatchError.setText("Passwords don't match!");

        lblErrorOldPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblErrorOldPassword.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorOldPassword.setText("Incorrect password!");

        lblInvalidPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInvalidPassword.setForeground(new java.awt.Color(255, 0, 0));
        lblInvalidPassword.setText("Invalid password!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnChangePassCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChangePassOK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPasswordsDontMatchError))
                .addGap(0, 91, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNewPasswordRepeat, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(70, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25)
                                .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblInvalidPassword)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblErrorOldPassword)
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(lblErrorOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInvalidPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNewPasswordRepeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(lblPasswordsDontMatchError)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangePassOK)
                    .addComponent(btnChangePassCancel))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangePassCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnChangePassCancelActionPerformed

    private void btnChangePassOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassOKActionPerformed
        String oldPassword = new String(txtOldPassword.getPassword());
        String newPassword = new String(txtNewPassword.getPassword());
        String newPasswordRepeat = new String(txtNewPasswordRepeat.getPassword());
        
        lblInvalidPassword.setVisible(false);
        lblPasswordsDontMatchError.setVisible(false);
        lblErrorOldPassword.setVisible(false);
        
        boolean correctOldPassword = conn.isEmployeePasswordValid(idemp, oldPassword);
        boolean samePasswords = newPassword.equals(newPasswordRepeat);
        
        if(!correctOldPassword){
            lblErrorOldPassword.setVisible(true);
            //lblErrorOldPassword.setText("Incorrect Password!");
        }
        if(!isPasswordValid(newPassword)){
            lblInvalidPassword.setVisible(true);
        }
        if(!samePasswords){
            lblPasswordsDontMatchError.setVisible(true); 
        }
        
        if(correctOldPassword && samePasswords && isPasswordValid(newPassword)){
            conn.changePassword(idemp, newPassword);
            this.dispose();
        }

    }//GEN-LAST:event_btnChangePassOKActionPerformed

    
    private boolean isPasswordValid(String password){
        password = password.trim();
        if(password.length() < 6){
            return false;
        }
        boolean lowerLetters = false;
        boolean upperLetter = false;
        boolean digit = false;
        boolean nonAlphaNumeric = false;
        for(int i = 0; i<password.length(); i++){
            if(Character.isLowerCase(password.charAt(i))){
                lowerLetters = true;
            }
            if(Character.isUpperCase(password.charAt(i))){
                upperLetter = true;
            }
            if(Character.isDigit(password.charAt(i))){
                digit = true;
            }
            if( !(Character.isLetter(password.charAt(i))) && !(Character.isDigit(password.charAt(i))) ){
                nonAlphaNumeric = true;
            }
        }
        
        return lowerLetters && upperLetter && digit && nonAlphaNumeric;
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassCancel;
    private javax.swing.JButton btnChangePassOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblErrorOldPassword;
    private javax.swing.JLabel lblInvalidPassword;
    private javax.swing.JLabel lblPasswordsDontMatchError;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtNewPasswordRepeat;
    private javax.swing.JPasswordField txtOldPassword;
    // End of variables declaration//GEN-END:variables
}