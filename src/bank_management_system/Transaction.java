package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    String pinnumber;

    JButton deposit, withdraw, miniStatement, pinChange, fastCash, balanceEnquiry, exit;

    Transaction(String pinnumber) {

        this.pinnumber = pinnumber;

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = icon.getImage().getScaledInstance(850, 820, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(i2);
        JLabel label = new JLabel(icon1);
        label.setBounds(0, 0, 850, 820);
        add(label);

        JLabel l1 = new JLabel("Select your Transaction");
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setForeground(Color.black);
        l1.setBounds(265, 290, 700, 40);
        label.add(l1);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(225, 350, 120, 20);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(360, 350, 120, 20);
        withdraw.addActionListener(this);
        label.add(withdraw);


        miniStatement = new JButton("STATEMENT");
        miniStatement.setBounds(225, 390, 120, 20);
        miniStatement.addActionListener(this);
        label.add(miniStatement);

        pinChange = new JButton("PIN CHANGE");
        pinChange.setBounds(360, 390, 120,  20);
        pinChange.addActionListener(this);
        label.add(pinChange);

        fastCash = new JButton("FAST CASH");
        fastCash.setBounds(225, 430, 120, 20);
        fastCash.addActionListener(this);
        label.add(fastCash);

        balanceEnquiry = new JButton("BALANCE");
        balanceEnquiry.setBounds(360, 430, 120, 20);
        balanceEnquiry.addActionListener(this);
        label.add(balanceEnquiry);



        exit = new JButton("EXIT");
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
            System.exit(0);
        }

        else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }

        else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }

        else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }

        else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }

        else if (ae.getSource() == miniStatement) {
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }


    }

    public static void main(String[] args) {
        new Transaction("");
    }

}
