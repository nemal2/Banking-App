package bank_management_system;
import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","PereraIsuri2@");
            // create connection
            s = c.createStatement();

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
