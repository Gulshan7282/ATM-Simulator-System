package BankManagementSystem;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JLabel text, image;
    JButton deposit, withdrawl, fastcash, minstatement, pinchange,balanceenquiry, exit;
    String pinnumber;
    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,690,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,690);
        add(image);

        text = new JLabel("SELECTED WITHDRAWAL AMOUNT");
        text.setBounds(210, 230, 700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("RS 100");
        deposit.setBounds(170,320,160,23);
        deposit.setFont(new Font("System",Font.BOLD,14));
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("RS 500");
        withdrawl.setBounds(350,320,160,23);
        withdrawl.setFont(new Font("System",Font.BOLD,14));
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("RS 1000");
        fastcash.setBounds(170,345,160,23);
        fastcash.setFont(new Font("System",Font.BOLD,14));
        fastcash.addActionListener(this);
        image.add(fastcash);

        minstatement = new JButton("RS 2000");
        minstatement.setBounds(350,345,160,23);
        minstatement.setFont(new Font("System",Font.BOLD,14));
        minstatement.addActionListener(this);
        image.add(minstatement);

        pinchange = new JButton("RS 5000");
        pinchange.setBounds(170,370,160,23);
        pinchange.setFont(new Font("System",Font.BOLD,14));
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("10000");
        balanceenquiry.setBounds(350,370,160,23);
        balanceenquiry.setFont(new Font("System",Font.BOLD,14));
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("BACK");
        exit.setBounds(170,395,340,23);
        exit.setFont(new Font("System",Font.BOLD,14));
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS "+ amount + "Debited Successfully");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
