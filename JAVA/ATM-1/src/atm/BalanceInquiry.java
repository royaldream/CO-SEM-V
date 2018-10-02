/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author shah jainam
 */
public class BalanceInquiry {

    private JFrame mainFrame;
    private JLabel statusLabel;
    private JLabel headerLabel;
    private JLabel Balance;

    Connection connection;
    String balance_number;

    public BalanceInquiry() {
    }

    BalanceInquiry(int card, int cvv, int pin) throws SQLException {
        Conection conn = new Conection();
        if (conn.isConnection()) {
            connection = conn.conreturn();
            Statement statement = connection.createStatement();
            String sql_bal = "SELECT * FROM `REGISTER` WHERE card_no=" + card + "";
            ResultSet resultSet = statement.executeQuery(sql_bal);
            if (resultSet.next()) {
                int balance = resultSet.getInt("balance");
                balance_number = String.valueOf(balance);
                System.out.println(balance + "\n" + balance_number);
                prepareLayout();
                retrieveBalance();
            }
        }

    }

    private void prepareLayout() {
        mainFrame = new JFrame("ATM Simulator System");      //Main Heading name
        mainFrame.setSize(600, 400);         //Set Size of window
        mainFrame.setLocation(383, 84);
        mainFrame.setLayout(null);
        headerLabel = new JLabel("");
        headerLabel.setText("Your Account Balance: ");
        headerLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        headerLabel.setBounds(100, 150, 200, 25);
        //kya ama nakhavanu che ?
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

    private void retrieveBalance() {
        Balance = new JLabel(balance_number);//aa kem nai work kartu
        Balance.setBounds(300, 150, 200, 25);
        Balance.setFont(new Font("Serif",Font.PLAIN,20));//barabar?
        //ha to ee page banav
        mainFrame.add(Balance);
        mainFrame.setVisible(true);
    }
}
