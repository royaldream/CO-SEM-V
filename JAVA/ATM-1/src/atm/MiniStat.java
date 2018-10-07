/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import static atm.ATM.mainFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 *
 * @author shah jainam
 */
public class MiniStat implements ActionListener {

    private JFrame mainFrame;
    private JLabel statusLabel;
    private JLabel headerLabel;
    private Connection connection;
    private final int card;
    private Statement statement;
    private JLabel stat[] = new JLabel[10];

    public MiniStat(int card) throws SQLException, IOException {
        this.card = card;
        Conection conn = new Conection();
        if (conn.isConnection()) {
            connection = conn.conreturn();
        }
        prepareLayout();
        makeStat();
    }

    private void prepareLayout() {
        mainFrame = new JFrame("ATM Simulator System");      //Main Heading name
        mainFrame.setSize(600, 800);         //Set Size of window
        mainFrame.setLocation(383, 84);
        mainFrame.setLayout(null);

        headerLabel = new JLabel("Mini Statement");
        headerLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        headerLabel.setBounds(210, 20, 200, 25);

        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        statusLabel = new JLabel("");
        statusLabel.setText(date.toString());
        statusLabel.setBounds(10, 725, 250, 25);
        statusLabel.setFont(new Font("Serif", Font.PLAIN, 17));

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        mainFrame.add(headerLabel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }//
//bhatia

    private void makeStat() throws SQLException, FileNotFoundException, IOException {
        statement = connection.createStatement();
        FileOutputStream fout;
        fout = new FileOutputStream("statement.txt");
        int i = 0, x = 50, y = 50, w = 500, h = 30;

        String sql_que = "SELECT * FROM `transaction` WHERE sCardno=" + card + " OR rCardno=" + card + " ORDER BY `id` DESC LIMIT 10";
        ResultSet rs = statement.executeQuery(sql_que);
        byte b[];
        b = ("Cardno\tRCardno\tChange\tBalance\tType\r\n").getBytes();
        fout.write(b);
        while (rs.next()) {//ufbhoreek min
            String card = rs.getString("sCardno");
            String rcard = rs.getString("rCardno");
            String ch_balance = rs.getString("change_balance");
            String acc_balance = rs.getString("acc_balance");
            String type = rs.getString("type");//oii have hu file ma nathi nakhto direct print karavi de ee selu thase kem ke string mali gai che ?ok
            if (rcard != null) {
                
                String abc = "" + card + "  " + rcard + "\t" + ch_balance + "\t" + acc_balance + "\t" + type;
                stat[i] = new JLabel(abc + "");
                stat[i].setBounds(x, y, w, h);
                y += 50;
                i++;
                b = (card + "\t" + rcard + "\t" + ch_balance + "\t" + acc_balance + "\t" + type + "\r\n").getBytes();
                fout.write(b);//ek min
            } else {
                stat[i] = new JLabel(card + "\t\t" + ch_balance + "\t" + acc_balance + "\t" + type);
                stat[i].setBounds(x, y, w, h);
                y += 50;
                i++;
                b = (card + "\t\t" + ch_balance + "\t" + acc_balance + "\t" + type + "\r\n").getBytes();
                fout.write(b);
            }
            System.out.println(rs.getString("sCardno"));
        }
        fout.close();
        for (int j = 0; j < i; j++) {
            mainFrame.add(stat[j]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
