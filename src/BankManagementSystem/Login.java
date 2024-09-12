package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    JButton login, singup, clear;
    JTextField cardTextFiled;
    JPasswordField pinTextFiled;
    Login() {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome To Gulshan ATM");
        text.setBounds(200,40,500,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        JLabel cardno = new JLabel("Card No: ");
        cardno.setBounds(120,150,250,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,26));
        add(cardno);

        cardTextFiled = new JTextField();
        cardTextFiled.setBounds(300,150,230,30);
        cardTextFiled.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextFiled);

        JLabel pin = new JLabel("PIN: ");
        pin.setBounds(120,220,250,30);
        pin.setFont(new Font("RaleWay",Font.BOLD,28));
        add(pin);

        pinTextFiled = new JPasswordField();
        pinTextFiled.setBounds(300,220,230,30);
        pinTextFiled.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextFiled);

        login = new JButton("SING IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        singup = new JButton("SING UP");
        singup.setBounds(300,350,230,30);
        singup.setBackground(Color.BLACK);
        singup.setForeground(Color.WHITE);
        singup.addActionListener(this);
        add(singup);

        getContentPane().setBackground(Color.WHITE);

        setTitle("Gulshan ATM");
        setSize(800, 480);
        setVisible(true);
        setLocation(300,150);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear) {
            cardTextFiled.setText("");
            pinTextFiled.setText("");
        }else if(ae.getSource() == singup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }else if(ae.getSource() == login) {
            Conn conn = new Conn();
            String cardNumber =  cardTextFiled.getText();
            String pinnumber = pinTextFiled.getText();
            String query = "select * from login where cardnumber = '"+cardNumber+"' and pinnumber = '"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card number and Pin");
                }
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
