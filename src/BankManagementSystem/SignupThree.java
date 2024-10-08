package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JLabel l1, type, card, number, pin, pnumber, cardDetails, pinDetails,services;
    JRadioButton r1, r2, r3, r4;
    JButton submit, cancel;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formno;
    SignupThree(String formno) {
        this.formno = formno;

        setLayout(null);

        l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(290,50,400,30);
        add(l1);

        type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,90,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("RaleWay",Font.BOLD,16));
        r1.setBounds(100,140,250,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("RaleWay",Font.BOLD,16));
        r2.setBounds(350,140,250,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setBackground(Color.WHITE);
        r3.setFont(new Font("RaleWay",Font.BOLD,16));
        r3.setBounds(100,190,250,20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("RaleWay",Font.BOLD,16));
        r4.setBounds(350,190,250,20);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,240,200,30);
        add(card);

        number = new JLabel("XXXX-XXXX-XXXX-4048");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(300,240,300,30);
        add(number);

        cardDetails = new JLabel("Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100,270,300,20);
        add(cardDetails);

        pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,320,200,30);
        add(pin);

        pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(300,320,300,30);
        add(pnumber);

        pinDetails = new JLabel("Your 4 Digit PIN Number");
        pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetails.setBounds(100,350,300,20);
        add(pinDetails);

        services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,400,400,30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("RaleWay", Font.BOLD, 16));
        c1.setBounds(100, 450, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("RaleWay", Font.BOLD, 16));
        c2.setBounds(350, 450, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("RaleWay", Font.BOLD, 16));
        c3.setBounds(100, 500, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email and SMS Altere");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("RaleWay", Font.BOLD, 16));
        c4.setBounds(350, 500, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("RaleWay", Font.BOLD, 16));
        c5.setBounds(100, 550, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("RaleWay", Font.BOLD, 16));
        c6.setBounds(350, 550, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the my best of knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("RaleWay", Font.BOLD, 12));
        c7.setBounds(130, 600, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("RalaWay",Font.BOLD,14));
        submit.setBounds(250, 650,100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("RalaWay",Font.BOLD,14));
        cancel.setBounds(420, 650,100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);


        setSize(850,730);
        setLocation(350,5);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            String accountType = null;
            if(r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Reoccurring Deposit Account";
            }

            Random random = new Random();

            String cardnumber = "" + Math.abs((random.nextLong() % 900000000L) + 504093600000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(c1.isSelected()) {
                facility = facility + " ATM Card";
            } else if (c2.isSelected()){
                facility = facility + " Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + " Email and SMS Alter";
            } else if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }

            try {
                if(accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }
                if(facility.equals("")) {
                    JOptionPane.showMessageDialog(null, "Facility Type is Required");
                }
                if(c7.equals("")){
                    JOptionPane.showMessageDialog(null,"Please check the box");
                }
                else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupThree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: " + cardnumber + "\n Pin: " + pinnumber);

                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            }catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == cancel) {
                setVisible(false);
                new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
