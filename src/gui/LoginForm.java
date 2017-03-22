package gui;

import database.ConnectionProvider;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Joseph on 21.3.2017.
 */
public class LoginForm {
    private JTextField txtLogin;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblErrorMessage;

    public LoginForm() {
        lblErrorMessage.setVisible(false);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("dasdasd");
                String login = txtLogin.getText();
                char arrPassword[] = txtPassword.getPassword();
                String password = new String(arrPassword);

                System.out.println("login: " + login + ";pass: " + password);

                if( !(login.equals("")) && (password.length() > 3) ){
                    ConnectionProvider conn = new ConnectionProvider();
                    if(conn.isEmployeePasswordValid(login, password)){
                        System.out.println("Password OK.");
                        int id = conn.getEmployeeId(login);
                        conn.logEmployeeAccess(id);
                        lblErrorMessage.setVisible(false);
                    }else{
                        System.out.println("Incorrect password.");
                        lblErrorMessage.setVisible(true);
                    }
                }
            }
        });
    }
/*
    private void jButtonActionPerformed(){
        String login = txtLogin.getText();
        String password = Arrays.toString(txtPassword.getPassword());

        if( !(login.equals("")) && password.length() > 3){
            ConnectionProvider conn = new ConnectionProvider();
            if(conn.isEmployeePasswordValid(login, password)){
                System.out.println("Password OK.");
            }else{
                System.out.println("Incorrect password.");
            }
        }

    }
*/

}
