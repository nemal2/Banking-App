package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinnumber;
    JButton back;
    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = icon.getImage().getScaledInstance(850, 820, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(i2);
        JLabel label = new JLabel(icon1);
        label.setBounds(0, 0, 850, 820);
        add(label);

        JLabel l1 = new JLabel("BALANCE ENQUIRY");
        l1.setFont(new Font("System", Font.BOLD, 14));
        l1.setForeground(Color.black);
        l1.setBounds(285, 290, 700, 40);
        label.add(l1);

        JLabel l2 = new JLabel("BALANCE :");
        l2.setFont(new Font("System", Font.BOLD, 14));
        l2.setForeground(Color.black);
        l2.setBounds(230, 333, 700, 40);
        label.add(l2);

        JLabel l3 = new JLabel();
        l3.setFont(new Font("System", Font.BOLD, 14));
        l3.setForeground(Color.black);
        l3.setBounds(330, 333, 700, 40);
        label.add(l3);

        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 450, 120, 25);
        back.addActionListener(this);
        label.add(back);

        Conn c = new Conn();
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l3.setText("Rs. "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }

        setLayout(null);
        setSize(850, 820);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);



    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }

}
