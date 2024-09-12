package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JLabel image,text;
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;
    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,690,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,690);
        add(image);

        text = new JLabel("Enter the Amount you want to Withdraw: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,250,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170,300,320,25);
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(amount);


        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("RaleWay",Font.BOLD,16));
        withdraw.setBounds(375,370,120,25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setFont(new Font("RaleWay",Font.BOLD,16));
        back.setBounds(170,370,120,25);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date  = new Date();
            if(number.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the amount tou want to Withdraw");
            }else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"', '"+date+"','Withdrawl','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }catch (Exception e) {
                    System.out.println(e);
                }
            }
        }else if(ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
