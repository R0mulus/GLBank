/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.ConnectionProvider;
import glbank.Client;
import glbank.Employee;
import java.util.List;

/**
 *
 * @author Joseph
 */
public class MainForm extends javax.swing.JFrame {
    private int idemp;
    private ConnectionProvider conn;
    private List<Client> list;
    /**
     * Creates new form MainForm
     */
    public MainForm(int idemp) {
        initComponents();
        this.idemp = idemp;
        conn = new ConnectionProvider();
        initFormData();
        setLocationRelativeTo(null);
    }
    
    private void initFormData(){
        printEmployeeName();
        showListOfClients();
    }
    
    private void printEmployeeName(){
        Employee employee = conn.getEmployee(idemp);
        if(employee != null){
            String name = employee.getFirstname() + " " + employee.getLastname();
            lblEmployeeName.setText("Logged in user: " + name);
        }
    }
    
    private void showListOfClients(){
        list = new ConnectionProvider().getListOfAllClients();
        if(list != null && list.size() > 0){
            for(Client client : list){
                String item = client.getLastname() + " " + client.getFirstname() + 
                        " [" + client.getDob() + "]";
                cmbListOfAllClients.addItem(item);
            }
            
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEmployeeName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbListOfAllClients = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnCreateNewClient = new javax.swing.JButton();
        tabPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuChangePass = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEmployeeName.setText("Logged in user: Firstname Lastname");

        jLabel1.setText("Select client: ");

        cmbListOfAllClients.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose" }));
        cmbListOfAllClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListOfAllClientsActionPerformed(evt);
            }
        });

        btnCreateNewClient.setText("New Client");
        btnCreateNewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabPanelLayout = new javax.swing.GroupLayout(tabPanel);
        tabPanel.setLayout(tabPanelLayout);
        tabPanelLayout.setHorizontalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tabPanelLayout.setVerticalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );

        jMenu1.setText("Menu");

        menuChangePass.setText("Change password");
        menuChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuChangePassActionPerformed(evt);
            }
        });
        jMenu1.add(menuChangePass);

        menuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreateNewClient)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(cmbListOfAllClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 395, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblEmployeeName)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbListOfAllClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateNewClient)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuChangePassActionPerformed
        ChangePassForm changePassForm = new ChangePassForm(this, true, idemp);
        changePassForm.setVisible(true);
    }//GEN-LAST:event_menuChangePassActionPerformed

    private void cmbListOfAllClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListOfAllClientsActionPerformed
        int index = cmbListOfAllClients.getSelectedIndex();
        tabPanel.removeAll();
        if(index>0){
            int idc = list.get(index-1).getIdc();
        }
    }//GEN-LAST:event_cmbListOfAllClientsActionPerformed

    private void btnCreateNewClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewClientActionPerformed
        NewClientForm newClientForm = new NewClientForm(this, true);
        newClientForm.setVisible(true);
    }//GEN-LAST:event_btnCreateNewClientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateNewClient;
    private javax.swing.JComboBox<String> cmbListOfAllClients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JMenuItem menuChangePass;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JPanel tabPanel;
    // End of variables declaration//GEN-END:variables
}
