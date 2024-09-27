package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login  extends JFrame implements ActionListener {

    // globally defined to access even out of constructor
    JButton login, clear, signup;
    JTextField card;
    JPasswordField pincode;
    public Login() {
        setLayout(null);
        setTitle("Easy Bank Pvt Ltd");

        //Icon Image ===============================================================================
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = icon.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(i2);
        JLabel label = new JLabel(icon1);
        label.setBounds(70, 10, 100, 100);
        add(label);

        // Title ===================================================================================
        JLabel l1 = new JLabel("Welcome to Easy Bank");
        l1.setFont(new Font("system", Font.BOLD, 35));
        l1.setForeground(Color.black);
        l1.setBounds(200, 40, 500, 40);
        add(l1);

        // Text Fields card no and pin code =========================================================
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("system", Font.BOLD, 20));
        cardno.setForeground(Color.black);
        cardno.setBounds(120, 150, 100, 30);
        add(cardno);

        card = new JTextField();
        card.setFont(new Font("system", Font.BOLD, 14));
        card.setBounds(250, 150, 350, 30);
        add(card);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("system", Font.BOLD, 20));
        pin.setForeground(Color.black);
        pin.setBounds(120, 220, 100, 30);
        add(pin);

        pincode = new JPasswordField();
        pincode.setFont(new Font("Arial", Font.BOLD, 14));
        pincode.setBounds(250, 220, 350, 30);
        add(pincode);

        // Buttons login, clear, signup ==========================================================
        login = new JButton("SIGN IN");
        login.setBounds(250, 280, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        add(login);

        login.addActionListener(this);

        clear = new JButton("CLEAR");
        clear.setBounds(450, 280, 150, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        add(clear);

        clear.addActionListener(this);

        signup = new JButton("SIGN UP");
        signup.setBounds(250, 330, 150, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        add(signup);

        // Login Screen ============================================================================

        // Frame ====================================================================================
        setSize(700, 450);
        setVisible(true);
        setLocation(350, 200);
        //setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == clear) {
            card.setText("");
            pincode.setText("");
        }

        else if (ae.getSource() == login) {}

        else if (ae.getSource() == signup) {}

    }

    public static void main(String[] args) {
        new Login();
    }
}
