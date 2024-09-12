package BankManagementSystem;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
   public Conn() {

        try {
//            Class.forName(com.mysql.cj.jdbc.Driver); // 1 st step - Driver ko Register karna
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Gulsh@n123");   // 2nd step - Connerction Create karna hai
            s = c.createStatement(); // 3rd step - create statement
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
