package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JLabel text, image;
    JButton deposit, withdrawl, fastcash, minstatement, pinchange,balanceenquiry, exit;
    String pinnumber;
    Transaction(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,690,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,690);
        add(image);

        text = new JLabel("Please select your Transaction");
        text.setBounds(215, 250, 700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,320,160,23);
        deposit.setFont(new Font("System",Font.BOLD,14));
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton(" Cash Withdrawal");
        withdrawl.setBounds(350,320,160,23);
        withdrawl.setFont(new Font("System",Font.BOLD,14));
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,345,160,23);
        fastcash.setFont(new Font("System",Font.BOLD,14));
        fastcash.addActionListener(this);
        image.add(fastcash);

        minstatement = new JButton("Min Statement");
        minstatement.setBounds(350,345,160,23);
        minstatement.setFont(new Font("System",Font.BOLD,14));
        minstatement.addActionListener(this);
        image.add(minstatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,370,160,23);
        pinchange.setFont(new Font("System",Font.BOLD,14));
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(350,370,160,23);
        balanceenquiry.setFont(new Font("System",Font.BOLD,14));
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
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
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == minstatement) {
            setVisible(true);
            new MiniStatement(pinnumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
