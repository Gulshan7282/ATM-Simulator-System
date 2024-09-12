package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JLabel image, text;
    JButton back;
    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,690,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,690);
        add(image);

        back = new JButton("BACK");
        back.setBounds(170,395,340,23);
        back.setFont(new Font("System",Font.BOLD,14));
        back.addActionListener(this);
        image.add(back);


        Conn conn = new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }catch (Exception e) {
            System.out.println(e);
        }

        text =  new JLabel("Your current Account Balance is RS "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(200,300,400,30);
        image.add(text);

        setSize(900,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
