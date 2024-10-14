package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    String pinnumber;

    JButton deposit, withdraw, miniStatement, pinChange, fastCash, balanceEnquiry, exit;

    FastCash(String pinnumber) {

        this.pinnumber = pinnumber;

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = icon.getImage().getScaledInstance(850, 820, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(i2);
        JLabel label = new JLabel(icon1);
        label.setBounds(0, 0, 850, 820);
        add(label);

        JLabel l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setForeground(Color.black);
        l1.setBounds(265, 290, 700, 40);
        label.add(l1);

        deposit = new JButton("Rs. 1000");
        deposit.setBounds(225, 350, 120, 20);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw = new JButton("Rs. 2000");
        withdraw.setBounds(360, 350, 120, 20);
        withdraw.addActionListener(this);
        label.add(withdraw);


        miniStatement = new JButton("Rs. 3000");
        miniStatement.setBounds(225, 390, 120, 20);
        miniStatement.addActionListener(this);
        label.add(miniStatement);

        pinChange = new JButton("Rs. 5000");
        pinChange.setBounds(360, 390, 120,  20);
        pinChange.addActionListener(this);
        label.add(pinChange);

        fastCash = new JButton("Rs. 10000");
        fastCash.setBounds(225, 430, 120, 20);
        fastCash.addActionListener(this);
        label.add(fastCash);

        balanceEnquiry = new JButton("Rs. 20000");
        balanceEnquiry.setBounds(360, 430, 120, 20);
        balanceEnquiry.addActionListener(this);
        label.add(balanceEnquiry);

        exit = new JButton("BACK");
        exit.setBounds(360, 465, 120, 20);
        exit.addActionListener(this);
        label.add(exit);


        setLayout(null);
        setSize(850, 820);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exit) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }

        else {

            String amount = ((JButton) ae.getSource()).getText().substring(4);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('" + pinnumber + "', '" + date + "', '" + "Withdrawl" + "', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }

}
