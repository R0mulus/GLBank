/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.panels.accountPanels;

import database.ConnectionProvider;
import glbank.Card;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author Joseph
 */
public class PanelCards extends javax.swing.JPanel {
    private long idacc;
    private ConnectionProvider conn = new ConnectionProvider();
    private List<Card> listOfCards = new ArrayList<>();
    
    /** Creates new form PanelCards */
    public PanelCards(long idacc) {
        this.idacc = idacc;
        initComponents();
        initCardList(); 
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbBoxPanelCardSelectCard = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPanelCardCardID = new javax.swing.JLabel();
        lblPanelCardCardPIN = new javax.swing.JLabel();
        lblPanelCardCardBlocked = new javax.swing.JLabel();
        btnPanelCardsChangePin = new javax.swing.JButton();
        btnPanelCardsBlockCard = new javax.swing.JButton();
        btnPanelCardsUnblockCard = new javax.swing.JButton();
        btnPanelCardsCreateNewCard = new javax.swing.JButton();

        jLabel1.setText("Select Card: ");

        cmbBoxPanelCardSelectCard.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));
        cmbBoxPanelCardSelectCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxPanelCardSelectCardActionPerformed(evt);
            }
        });

        jLabel2.setText("Card ID: ");

        jLabel3.setText("PIN: ");

        jLabel4.setText("Blocked: ");

        lblPanelCardCardID.setText(" ");

        lblPanelCardCardPIN.setText(" ");

        lblPanelCardCardBlocked.setText(" ");

        btnPanelCardsChangePin.setText("Change pin number");
        btnPanelCardsChangePin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelCardsChangePinActionPerformed(evt);
            }
        });

        btnPanelCardsBlockCard.setText("Block card");
        btnPanelCardsBlockCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelCardsBlockCardActionPerformed(evt);
            }
        });

        btnPanelCardsUnblockCard.setText("Unblock card");
        btnPanelCardsUnblockCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelCardsUnblockCardActionPerformed(evt);
            }
        });

        btnPanelCardsCreateNewCard.setText("Create new card");
        btnPanelCardsCreateNewCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelCardsCreateNewCardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPanelCardCardBlocked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbBoxPanelCardSelectCard, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPanelCardCardPIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPanelCardCardID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPanelCardsBlockCard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPanelCardsUnblockCard))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnPanelCardsCreateNewCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPanelCardsChangePin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbBoxPanelCardSelectCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPanelCardsCreateNewCard))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblPanelCardCardID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblPanelCardCardPIN)
                    .addComponent(btnPanelCardsChangePin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblPanelCardCardBlocked)
                    .addComponent(btnPanelCardsBlockCard)
                    .addComponent(btnPanelCardsUnblockCard))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbBoxPanelCardSelectCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxPanelCardSelectCardActionPerformed
        refreshCardInfo();
    }//GEN-LAST:event_cmbBoxPanelCardSelectCardActionPerformed

    private void btnPanelCardsChangePinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelCardsChangePinActionPerformed
        int index = cmbBoxPanelCardSelectCard.getSelectedIndex();
        Card selectedCard = listOfCards.get(index - 1);
        if(!selectedCard.isBlocked()){
            ChangePINForm changePinForm = new ChangePINForm(getCardID());
            changePinForm.setVisible(true);
            changePinForm.addWindowListener(new WindowAdapter(){
                public void windowClosed(WindowEvent e)
                {
                    refreshCardInfo();            
                }
            });
        }else{
            JOptionPane.showMessageDialog(null, "Can not alter PIN of blocked card!");
        }
        
        
    }//GEN-LAST:event_btnPanelCardsChangePinActionPerformed

    private void btnPanelCardsBlockCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelCardsBlockCardActionPerformed
        conn.toggleCard(getCardID(), 'T');
        refreshCardInfo();
    }//GEN-LAST:event_btnPanelCardsBlockCardActionPerformed

    private void btnPanelCardsUnblockCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelCardsUnblockCardActionPerformed
        conn.toggleCard(getCardID(), 'F');
        refreshCardInfo();
    }//GEN-LAST:event_btnPanelCardsUnblockCardActionPerformed

    private void btnPanelCardsCreateNewCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelCardsCreateNewCardActionPerformed
        conn.insertRandomCard(idacc, getRandomPIN());
        initCardList();
        JOptionPane.showMessageDialog(null, "New card number: " + conn.getRandomCardNumber());
    }//GEN-LAST:event_btnPanelCardsCreateNewCardActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPanelCardsBlockCard;
    private javax.swing.JButton btnPanelCardsChangePin;
    private javax.swing.JButton btnPanelCardsCreateNewCard;
    private javax.swing.JButton btnPanelCardsUnblockCard;
    private javax.swing.JComboBox<String> cmbBoxPanelCardSelectCard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblPanelCardCardBlocked;
    private javax.swing.JLabel lblPanelCardCardID;
    private javax.swing.JLabel lblPanelCardCardPIN;
    // End of variables declaration//GEN-END:variables

    public int getCardID(){
        int index = cmbBoxPanelCardSelectCard.getSelectedIndex();
        if(index > 0 && !listOfCards.isEmpty()){
            Card selectedCard = listOfCards.get(index - 1);
            int idCard = selectedCard.getIdCard();
            return idCard;
        }
        return -1;
    }
    
    private int getRandomPIN(){
        int randomPIN = ThreadLocalRandom.current().nextInt(1,9999);
        return randomPIN;
    }
   
    private void initCardList(){
        cmbBoxPanelCardSelectCard.removeAllItems();
        cmbBoxPanelCardSelectCard.addItem("Choose");
        fillListOfCards();
        if(listOfCards != null && listOfCards.size() > 0){
            for(Card card : listOfCards){
                cmbBoxPanelCardSelectCard.addItem("" + card.getCardNumber());
            }
        }
    }
    
    private void fillListOfCards(){
        listOfCards = null;
        listOfCards = conn.getListOfCards(idacc);
    }

    public void refreshCardInfo(){
        lblPanelCardCardID.setText("");
        lblPanelCardCardPIN.setText("");
        lblPanelCardCardBlocked.setText("");
        
        fillListOfCards();
        
        int index = cmbBoxPanelCardSelectCard.getSelectedIndex();
        if(!listOfCards.isEmpty() && index > 0){
            Card selectedCard = listOfCards.get(index - 1);
            lblPanelCardCardID.setText("" + selectedCard.getIdCard());
            lblPanelCardCardPIN.setText("" + selectedCard.getPin());
            if(!selectedCard.isBlocked()){
                lblPanelCardCardBlocked.setText("No");
            }else{
                lblPanelCardCardBlocked.setText("Yes");
            }
        }
    }
    
}
