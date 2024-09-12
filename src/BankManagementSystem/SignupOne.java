package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    JTextField nameTextFiled, fnameTextFiled , emailTextFiled, addressTextFiled, cityTextFiled,stateTextFiled,pinTextFiled;
    long random;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    SignupOne() {

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application Form No: "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextFiled = new JTextField();
        nameTextFiled.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextFiled.setBounds(300,140,400,30);
        add(nameTextFiled);




        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextFiled = new JTextField();
        fnameTextFiled.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextFiled.setBounds(300,190,400,30);
        add(fnameTextFiled);




        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setFont(new Font("RaleWay", Font.BOLD,14));
        add(dateChooser);




        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);




        JLabel email = new JLabel("Email Address : ");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextFiled = new JTextField();
        emailTextFiled.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextFiled.setBounds(300,340,400,30);
        add(emailTextFiled);




        JLabel matrial = new JLabel("Married status : ");
        matrial.setFont(new Font("Raleway", Font.BOLD,20));
        matrial.setBounds(100,390,200,30);
        add(matrial);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup matrialGroup = new ButtonGroup();
        matrialGroup.add(married);
        matrialGroup.add(unmarried);
        matrialGroup.add(other);

        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextFiled = new JTextField();
        addressTextFiled.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextFiled.setBounds(300,440,400,30);
        add(addressTextFiled);




        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextFiled = new JTextField();
        cityTextFiled.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextFiled.setBounds(300,490,400,30);
        add(cityTextFiled);




        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextFiled = new JTextField();
        stateTextFiled.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextFiled.setBounds(300,540,400,30);
        add(stateTextFiled);




        JLabel pincode = new JLabel("Pin Code : ");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pinTextFiled = new JTextField();
        pinTextFiled.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextFiled.setBounds(300,590,400,30);
        add(pinTextFiled);


        next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("RaleWay",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,730);
        setLocation(350,10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String formno = " "+ random;
        String name = nameTextFiled.getText();
        String fname = fnameTextFiled.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextFiled.getText();
        String martial =  null;
        if(married.isSelected()) {
            martial = "Married";
        } else if (unmarried.isSelected()) {
            martial = "Unmarried";
        } else if (other.isSelected()) {
            martial = "Other";
        }
        String address = addressTextFiled.getText();
        String city = cityTextFiled.getText();
        String state = stateTextFiled.getText();
        String pin = pinTextFiled.getText();

        try {
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter your Name");

            }

            if(fname.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter your Father Name");

            }
            if(dob.equals("")) {
                JOptionPane.showMessageDialog(null,"DOB is Require");

            }
//            if(gender.equals("")) {
//                JOptionPane.showMessageDialog(null,"Please select Gender");
//
//            }
            if(email.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the Email");

            }
//            if(martial.equals("")) {
//                JOptionPane.showMessageDialog(null,"Please select Married Status");
//
//            }
            if(address.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter Your Address");

            }
            if(city.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter Your City Name");

            }
            if(state.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter Your State Name");

            }
            if(pin.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter Your Pin Code");

            }
            else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+martial+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignupOne();
    }
}
