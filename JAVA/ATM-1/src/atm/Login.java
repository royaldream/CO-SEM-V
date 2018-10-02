/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

//import com.mysql.jdbc.Statement;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author shah jainam
 */
public class Login implements ActionListener {

    private JFrame mainFrame;
    private JLabel statusLabel;
    private JLabel headerLabel;

    //connection statment
    //Connection connection;
//    private Statement statement;
    private int pin, cvv;
    private int card;
    private JLabel Card;
    private JTextField Cardno;
    private JLabel Cvv;
    private JTextField Cvvno;
    private JLabel Pin;
    private JPasswordField Pinno;
    //private JLabel ExpiryDt;
    //private JFormattedTextField ExpiryDate;
    private JButton login;
    Connection connection;

    public Login() throws SQLException {
        Conection conn = new Conection();
        if (conn.isConnection()) {
            connection = conn.conreturn();
        }
        prepare();
        loginInfo();
    }

    private void prepare() {
        mainFrame = new JFrame("ATM Simulator System");      //Main Heading name
        mainFrame.setSize(800, 600);         //Set Size of window
        mainFrame.setLocation(300, 84);
        mainFrame.setLayout(null);

        headerLabel = new JLabel("Login Window");
        headerLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        headerLabel.setBounds(300, 20, 200, 25);

        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        statusLabel = new JLabel("");
        statusLabel.setText(date.toString());
        statusLabel.setBounds(10, 530, 250, 25);
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

    private void loginInfo() {
        Card = new JLabel("Enter Card No: ");
        Card.setBounds(200, 200, 200, 20);
        Cvv = new JLabel("Enter CVV No: ");
        Cvv.setBounds(200, 250, 200, 20);
        Pin = new JLabel("Enter Pin No: ");
        Pin.setBounds(200, 300, 200, 20);

        Cardno = new JTextField("");
        Cardno.setBounds(400, 200, 200, 20);
        Cvvno = new JTextField("");
        Cvvno.setBounds(400, 250, 200, 20);
        Pinno = new JPasswordField("");
        Pinno.setBounds(400, 300, 200, 20);

        login = new JButton("Login");
        login.setBounds(250, 350, 100, 50);
        login.setActionCommand("Login");
        login.addActionListener(this);

//btn banav ani click par check karsheok
        mainFrame.add(Card);
        mainFrame.add(Cardno);
        mainFrame.add(Cvv);
        mainFrame.add(Cvvno);
        mainFrame.add(Pin);
        mainFrame.add(Pinno);
        mainFrame.add(login);//thayu
        mainFrame.setVisible(true);
        //text kai rite avshe ee mane aap
//        Menu menu = new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String command = ae.getActionCommand();
        if (command.equals("Login")) {
            //click nathi thai//kari apu hu
//            System.out.println("Btn Click");
            card = Integer.parseInt(Cardno.getText());
            pin = Integer.parseInt(Pinno.getText());
            cvv = Integer.parseInt(Cvvno.getText());

            try {
                Statement statement = connection.createStatement();
                String sql_select_user = "SELECT * FROM `USER` WHERE user_id=" + Integer.parseInt(Cardno.getText()) + " AND password=" + pin + " AND cvv=" + cvv + "";
                ResultSet set = statement.executeQuery(sql_select_user);
//                System.out.println(set.next() + "\n" + sql_select_user + "\n");
                if (set.next()) {
//                    System.out.println("Login Sucess");
//                       JOptionPane.showMessageDialog(mainFrame, "Login Successful"); 
                       mainFrame.setVisible(false);
                       Menu menu=new Menu(card,cvv,pin);
                } else {
//                    System.out.println("Failed!!!!!!!!");
                       JOptionPane.showMessageDialog(mainFrame, "Login Unsuccessful");
                       
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
