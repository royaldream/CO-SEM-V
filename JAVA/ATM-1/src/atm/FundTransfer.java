/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author shah jainam
 */
public class FundTransfer implements ActionListener {

    private JFrame mainFrame;
    private JLabel statusLabel;
    private JLabel headerLabel;
    
    private JLabel card1,card2,amount;
    private JTextField cardno1,cardno2,amountval;
    private JButton Transfer;
    
    public FundTransfer(int card){
        prepareLayout();
        transferFund();
    }
    
    private void prepareLayout(){
        mainFrame = new JFrame("ATM Simulator System");      //Main Heading name
        mainFrame.setSize(600, 400);         //Set Size of window
        mainFrame.setLocation(383, 84);
        mainFrame.setLayout(null);

        headerLabel = new JLabel("Transfer Fund");
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
    
    private void transferFund(){
        card1=new JLabel("Enter Account No: ");
        card1.setBounds(100, 100, 200, 25);
        
        card2=new JLabel("Enter Beneficiary Account No: ");
        card2.setBounds(100, 150, 200, 25);
        
        amount=new JLabel("Enter amount: ");
        amount.setBounds(100, 200, 200, 25);
        
        cardno1=new JTextField("");
        cardno1.setBounds(300, 100, 200, 25);
        
        cardno2=new JTextField("");
        cardno2.setBounds(300, 150, 200, 25);
        
        amountval=new JTextField("");
        amountval.setBounds(300, 200, 200, 25);
        
        Transfer=new JButton("Transfer");
        Transfer.setBounds(250, 250, 100, 50);
        Transfer.setActionCommand("Transfer");
        Transfer.addActionListener(this);
        
        mainFrame.add(card1);
        mainFrame.add(cardno1);
        mainFrame.add(card2);
        mainFrame.add(cardno2);
        mainFrame.add(amount);
        mainFrame.add(amountval);
        mainFrame.add(Transfer);
        mainFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command=ae.getActionCommand();
        if(command.equals("Transfer")){
            
        }
    }
}
