/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.ConnectionProvider;
import glbank.Client;
import glbank.Employee;
import gui.panels.PanelAboutUser;
import gui.panels.PanelAccounts;
import java.awt.Dimension;
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
        //this.setExtendedState(MAXIMIZED_BOTH); //start window in fullscreen
        this.setMinimumSize(new Dimension(760,645));
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
        btnCreateNewClient = new javax.swing.JButton();
        tabPanel = new javax.swing.JTabbedPane();
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

        btnCreateNewClient.setText("Create new client");
        btnCreateNewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewClientActionPerformed(evt);
            }
        });

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
                    .addComponent(tabPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbListOfAllClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                        .addComponent(btnCreateNewClient)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateNewClient)
                    .addComponent(lblEmployeeName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbListOfAllClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
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
        if (index > 0) {
            Client selectedClient = list.get(index - 1);
            Client client = new ConnectionProvider().getClientByID(selectedClient.getIdc());
            PanelAboutUser panelAboutUser = new PanelAboutUser(client);
            tabPanel.add("About client", panelAboutUser);
            PanelAccounts panelAccounts = new PanelAccounts(client.getIdc());
            tabPanel.add("Accounts", panelAccounts);
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
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JMenuItem menuChangePass;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables
}
