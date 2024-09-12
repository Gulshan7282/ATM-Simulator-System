package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    JLabel additionalDetails,religion, category, income, educational, qualification,occupation, panNo, Aadhar, senior, exisiting;
    JButton next;
    JTextField pan, aadhar;
    JComboBox rel, cat, inc, educt, occup;
    JRadioButton syes,sno, eyes, eno;
    ButtonGroup sGroup, eGroup;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);


        religion = new JLabel("Religion: ");
        religion.setFont(new Font("RaleWay",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);

        String valueReligion[] = {"Hindu", "Muslim", "Sikh", "Chrisitan", "Other"};
        rel = new JComboBox(valueReligion);
        rel.setBounds(300,140, 400,30);
        rel.setBackground(Color.WHITE);
        add(rel);





        category = new JLabel("Category: ");
        category.setFont(new Font("RaleWay",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        String valueCategery[] = {"General", "OBC", "SC", "ST", "Other"};
        cat = new JComboBox(valueCategery);
        cat.setBounds(300,190, 400,30);
        cat.setBackground(Color.WHITE);
        add(cat);




        income = new JLabel("Income: ");
        income.setFont(new Font("RaleWay",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);

        String incomeCategery[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        inc = new JComboBox(incomeCategery);
        inc.setBounds(300,240, 400,30);
        inc.setBackground(Color.WHITE);
        add(inc);




        educational = new JLabel("Educational ");
        educational.setFont(new Font("RaleWay",Font.BOLD,20));
        educational.setBounds(100,290,200,30);
        add(educational);

        qualification = new JLabel("Qualifaction: ");
        qualification.setFont(new Font("RaleWay",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);

        String educatValue[] = {"Non Graduation", "Graduation", "Post Graduation", "Doctorate", "Other"};
        educt = new JComboBox(educatValue);
        educt.setBounds(300,315, 400,30);
        educt.setBackground(Color.WHITE);
        add(educt);




        occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("RaleWay",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);

        String occupationalValue[] = {"Salaried", "Self Employed", "Business", "Student", "Retired", "Other"};
        occup = new JComboBox(occupationalValue);
        occup.setBounds(300,390, 400,30);
        occup.setBackground(Color.WHITE);
        add(occup);



        panNo = new JLabel("PAN Number: ");
        panNo.setFont(new Font("RaleWay",Font.BOLD,20));
        panNo.setBounds(100,440,200,30);
        add(panNo);

        pan = new JTextField();
        pan.setFont(new Font("RalyWay",Font.BOLD,14));
        pan.setBounds(300,440,200,30);
        add(pan);




        Aadhar = new JLabel("Aadhar Number: ");
        Aadhar.setFont(new Font("RaleWay",Font.BOLD,20));
        Aadhar.setBounds(100,490,200,30);
        add(Aadhar);

        aadhar = new JTextField();
        aadhar.setFont(new Font("RalyWay",Font.BOLD,14));
        aadhar.setBounds(300,490,200,30);
        add(aadhar);



        senior = new JLabel("Senior Citizen: ");
        senior.setFont(new Font("RaleWay",Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        sGroup = new ButtonGroup();
        sGroup.add(syes);
        sGroup.add(sno);


        exisiting = new JLabel("Exisiting Account");
        exisiting.setFont(new Font("RaleWay",Font.BOLD,20));
        exisiting.setBounds(100,590,200,30);
        add(exisiting);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        eGroup = new ButtonGroup();
        eGroup.add(eyes);
        eGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("RaleWay",Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);


        setSize(850,730);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String religion = (String)rel.getSelectedItem();
        String category = (String)cat.getSelectedItem();
        String income = (String)inc.getSelectedItem();
        String eduction = (String)educt.getSelectedItem();
        String occupation = (String)occup.getSelectedItem();
        String seniercitizen = null;
        if(syes.isSelected()) {
            seniercitizen = "Yes";
        }else if (sno.isSelected()) {
            seniercitizen = "No";
        }

        String exiting = null;
        if(eyes.isSelected()) {
            exiting = "Yes";
        }else if (eno.isSelected()) {
            exiting = "No";
        }
        String panNo = pan.getText();
        String Aadhar = aadhar.getText();

        try {
            if(panNo.equals("")) {
                JOptionPane.showMessageDialog(null, "Pan Number is Required");
            }
            if(Aadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
            }else {
                Conn c = new Conn();
                String query = "insert into signupTwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+eduction+"', '"+occupation+"', '"+panNo+"', '"+Aadhar+"', '"+seniercitizen+"', '"+exiting+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
