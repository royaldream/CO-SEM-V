/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author shah jainam
 */
public class ATM {

    static JFrame mainFrame;
    private JLabel statusLabel;
    private JLabel headerLabel;
    

    public ATM() {
        prepareLayout();
    }

    public static void main(String[] args){

        ATM main = new ATM();
        main.makeAtm();
    }

    private void prepareLayout() {
        mainFrame = new JFrame("ATM Simulator System");      //Main Heading name
        mainFrame.setSize(600, 400);         //Set Size of window
        mainFrame.setLocation(383, 84);
        mainFrame.setLayout(null);

        headerLabel = new JLabel("WELCOME TO ATM");
        headerLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        headerLabel.setBounds(210, 20, 200, 25);

        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        statusLabel = new JLabel("");
        statusLabel.setText(date.toString());
        statusLabel.setBounds(10, 325, 250, 25);
        statusLabel.setFont(new Font("Serif", Font.PLAIN, 17));

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        mainFrame.add(headerLabel);
        mainFrame.add(statusLabel);
    }

    private void makeAtm() {
        JButton login = new JButton("Login");
        JButton register = new JButton("Register");
        login.setBounds(250, 150, 100, 30);
        register.setBounds(250, 200, 100, 30);
        login.setBackground(Color.yellow);
        register.setBackground(Color.yellow);

        login.setActionCommand("Login");
        register.setActionCommand("Register");

        login.addActionListener(new ButtonClickListener());
        register.addActionListener(new ButtonClickListener());

        mainFrame.add(login);
        mainFrame.add(register);
        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Login")) {
                try {
                    Login lg = new Login();
                                    mainFrame.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if (command.equals("Register")) {
                try {
                    Register reg = new Register();
                                    mainFrame.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
