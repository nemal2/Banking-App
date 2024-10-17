package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    String pinnumber;
    JButton change, back;
    JPasswordField pin, pin1;
    public PinChange(String pinnumber) {

        this.pinnumber = pinnumber;

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = icon.getImage().getScaledInstance(850, 820, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(i2);
        JLabel label = new JLabel(icon1);
        label.setBounds(0, 0, 850, 820);
        add(label);

        JLabel l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setForeground(Color.black);
        l1.setBounds(285, 290, 700, 40);
        label.add(l1);

        JLabel pintext = new JLabel("New pin:");
        pintext.setFont(new Font("System", Font.BOLD, 14));
        pintext.setForeground(Color.black);
        pintext.setBounds(230, 333, 700, 40);
        label.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("System", Font.BOLD, 15));
        pin.setBounds(330, 340, 150, 30);
        label.add(pin);


        JLabel pintext1 = new JLabel("Re-enter:");
        pintext1.setFont(new Font("System", Font.BOLD, 14));
        pintext1.setForeground(Color.black);
        pintext1.setBounds(230, 370, 700, 40);
        label.add(pintext1);


        pin1 = new JPasswordField();
        pin1.setFont(new Font("System", Font.BOLD, 15));
        pin1.setBounds(330, 380, 150, 30);
        label.add(pin1);


        change = new JButton("CHANGE");
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.setBounds(360, 430, 120, 25);
        change.addActionListener(this);
        label.add(change);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(360, 460, 120, 25);
        back.addActionListener(this);
        label.add(back);



        setLayout(null);
        setSize(850, 820);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = pin1.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter pin");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter pin");
                    return;
                }

                if (npin.equals(rpin)) {
                    Conn c = new Conn();
                    String query = "update login set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                    String query1 = "update bank set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                    String query2 = "update signupthree set pin = '" + rpin + "' where pin = '" + pinnumber + "'";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new Transaction(npin).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {

        new PinChange("").setVisible(true);

    }
}
