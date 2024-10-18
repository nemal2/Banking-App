package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1,b2;
    String pinnumber;


    MiniStatement(String pinnumber) {

        this.pinnumber = pinnumber;

        setTitle("Bank Statement");
        setLayout(null);

        l1 = new JLabel();
        l1.setForeground(Color.BLACK);
        l1.setBounds(20, 140, 360, 200); // Adjusted to display more content
        add(l1);

        JLabel bank = new JLabel("EASY BANK SRI LANKA");
        bank.setForeground(Color.BLACK);
        bank.setFont(new Font("System", Font.BOLD, 15));
        bank.setBounds(100, 20, 300, 30);
        add(bank);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setForeground(Color.BLACK);
        l4.setBounds(20, 380, 300, 30);
        add(l4);

        try {
            Conn conn = new Conn();
            String query = "select * from login where pin = '" + pinnumber + "'"; // Use pinnumber
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                l3.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            int balance = 0;
            Conn c1 = new Conn();
            // Fetch only the last 5 transactions ordered by date descending (latest first)
            String query1 = "select * from bank where pin = '" + pinnumber + "' order by date asc limit 6";
            ResultSet rs = c1.s.executeQuery(query1);
            StringBuilder transactionHistory = new StringBuilder("<html><table>");

            // Define the headers
            transactionHistory.append("<tr><th>Date</th><th>Type</th><th>Amount</th></tr>");

            while (rs.next()) {
                // Append each transaction as a table row with three columns for date, type, and amount
                transactionHistory.append("<tr>")
                        .append("<td>").append(rs.getString("date")).append("</td>")
                        .append("<td>").append(rs.getString("type")).append("</td>")
                        .append("<td>").append(rs.getString("amount")).append("</td>")
                        .append("</tr>");

                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            transactionHistory.append("</table></html>"); // Close the table and HTML tag
            l1.setText(transactionHistory.toString()); // Set the constructed HTML to JLabel
            l4.setText("Your total Balance is Rs " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }


        b1 = new JButton("EXIT");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(20, 500, 100, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200, 500, 100, 30);
        b2.addActionListener(this);
        add(b2);

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            System.exit(0);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MiniStatement("1234"); // Example pin number
    }
}
