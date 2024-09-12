package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinnumber;
    JLabel mini, bank, card, balance;
    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Min Statement");
        setLayout(null);

        mini = new JLabel();
        add(mini);

        bank = new JLabel("State Bank of India");
        bank.setBounds(150,20,200,20);
        add(bank);

        card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        balance = new JLabel();
        balance.setBounds(100,450,400,20);
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs =  conn.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
            while(rs.next()) {
                card.setText("Card number: "+ rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));

            }
        }catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            int bal = 0;
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                }else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Balance is RS " + bal);
        }catch (Exception e) {
            System.out.println(e);
        }

        mini.setBounds(50,140,500,200);

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
