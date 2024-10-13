package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JButton back,deposit;
    String pinnumber;
    JTextField amount;
    Deposit(String pinnumber){

        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = icon.getImage().getScaledInstance(850, 820, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(i2);
        JLabel label = new JLabel(icon1);
        label.setBounds(0, 0, 850, 820);
        add(label);

        JLabel l1 = new JLabel("Enter Amount you want to deposit");
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setForeground(Color.black);
        l1.setBounds(238, 315, 700, 40);
        label.add(l1);

        amount = new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 18));
        amount.setBounds(238, 360, 230, 30);
        label.add(amount);


        deposit = new JButton("DEPOSIT");
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.setBounds(353, 430, 110, 23);
        deposit.addActionListener(this);
        label.add(deposit);


        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(353, 460, 110, 23);
        back.addActionListener(this);
        label.add(back);



        setTitle("Deposit");
        setLocation(300,0);
        setSize(850, 820);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == back) {
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } else if (ae.getSource() == deposit) {

                String amount1 = amount.getText();
                Date date = new Date();
                if (amount1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount to be deposited");
                } else {
                    try {
                        Conn conn = new Conn();
                        String query = "insert into bank values('" + pinnumber + "', '" + date + "', '" + "Deposit" + "', '" + amount1 + "')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs. " + amount1 + " Deposited Successfully");
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

        }
    public static void main(String[] args) {

        new Deposit("");
    }
}
