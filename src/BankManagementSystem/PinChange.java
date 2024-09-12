package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    String pinnumber;
    ImageIcon i1,i3;
    Image i2;
    JLabel image, text, pintext, repintext;
    JPasswordField pin, repin;
    JButton change, back;
    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,690,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,690);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,220,400,35);
        image.add(text);

        pintext = new JLabel("Enter Your New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(170,260,200,25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("RaleWay",Font.BOLD,16));
        pin.setBounds(355,260,150,25);
        image.add(pin);

        repintext = new JLabel("Enter Your New PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(170,300,200,25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("RaleWay",Font.BOLD,16));
        repin.setBounds(355,300,150,25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,360,150,25);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,390,150,25);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change) {
            try {
                String newpin = pin.getText();
                String newrepin = repin.getText();
                if(!newpin.equals(newrepin)) {
                    JOptionPane.showMessageDialog(null,"Entered Pin does not Match");
                    return;
                }
                if(newpin.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please Enter New Pin");
                    return;
                }
                if(newrepin.equals("")) {
                    JOptionPane.showMessageDialog(null,"Please ReEnter New Pin");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pinnumber = '"+newrepin+"' where pinnumber = '"+pinnumber+"'";
                String query2 = "update login set pinnumber = '"+newrepin+"' where pinnumber = '"+pinnumber+"'";
                String query3 = "update signupthree set pinnumber = '"+newrepin+"' where pinnumber = '"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
                setVisible(true);
                new Transaction(newrepin).setVisible(true);
            }catch (Exception e) {
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
