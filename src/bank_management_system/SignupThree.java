package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    JButton submit,cancel;
    String formno;
    SignupThree(String formno){

        this.formno = formno;

        setLayout(null);
        setTitle("Create Account Form - Page 3");
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,0,850,820);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setBounds(280, 80, 400, 30);
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(100, 150, 200, 30);
        add(type);


        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(150, 190, 200, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(400, 190, 200, 30);
        add(r2);


        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(150, 230, 200, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Fixed Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(400, 230, 200, 30);
        add(r4);


        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        group.add(r4);


        // card number
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100, 305, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4183");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(330, 305, 300, 30);
        add(number);

        JLabel carddetail = new JLabel("Your card details are safe with us");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100, 325, 300, 30);
        add(carddetail);

        // pin code
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 390, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pnumber.setBounds(330, 390, 300, 30);
        add(pnumber);


        JLabel pindetail = new JLabel("This your 4 digit password");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100, 410, 300, 30);
        add(pindetail);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100, 490, 200, 30);
        add(services);

        // checkboxes for services
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 530, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(320, 530, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(550, 530, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(100, 580, 200, 30);
        add(c4);


        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(320, 580, 200, 30);
        add(c5);


        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(550, 580, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are true");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 13));
        c7.setBounds(100, 650, 500, 30);
        add(c7);


        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);



    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Fixed Account";
            }

            Random random = new Random();
            String cardnumber ="" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pin = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + "ATM Card";
            }
            else if (c2.isSelected()) {
                facility = facility + "Internet Banking";
            }
            else if (c3.isSelected()) {
                facility = facility + "Mobile Banking";
            }
            else if (c4.isSelected()) {
                facility = facility + "Email Alerts";
            }
            else if (c5.isSelected()) {
                facility = facility + "Cheque Book";
            }
            else if (c6.isSelected()) {
                facility = facility + "E-Statement";
            }

            try {
                if (accountType.equals(null)) {
                    JOptionPane.showMessageDialog(null, "Select Account Type");
                }
                else if (cardnumber.equals(null)) {
                    JOptionPane.showMessageDialog(null, "Select Account Type");
                }
                else if (pin.equals(null)) {
                    JOptionPane.showMessageDialog(null, "Select Account Type");
                }
                else if (facility.equals(null)) {
                    JOptionPane.showMessageDialog(null, "Select Account Type");
                }

                else {
                    Conn c = new Conn();
                    String query = "insert into signupthree values('" + formno + "', '" + accountType + "', '" + cardnumber + "', '" + pin + "', '" + facility + "')";
                    String query1 = "insert into login values('" + formno + "','" + cardnumber + "', '" + pin + "')";
                    c.s.executeUpdate(query);

                    c.s.executeUpdate(query1);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin Number: " + pin);
                   setVisible(false);
                    new Deposit(pin).setVisible(false);
                }
            } catch (Exception e) {
                System.out.println(e);
            }



        } else if (ae.getSource() == cancel) {

            setVisible(false);
            new Login().setVisible(true);

        }
        }

        public static void main(String[] args) {
    new SignupThree("");

    }
}