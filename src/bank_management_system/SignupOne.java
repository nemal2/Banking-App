package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField formno, nameTF, fnameTF, addressTF,dobTF, stateTF, pincodeTF, cityTF, emailTF;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    SignupOne(){

        setLayout(null);
        setTitle("Create Account Form - Page 1");

        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;

        JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

    //Personal Info ======================================================================
        JLabel personalinfo = new JLabel("Page 1: Personal Information");
        personalinfo.setFont(new Font("Raleway", Font.BOLD, 22));
        personalinfo.setBounds(280, 80, 400, 30);
        add(personalinfo);

    //name label ==================================================
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 120, 30);
        add(name);

        nameTF = new JTextField();
        nameTF.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTF.setBounds(300, 140, 400, 30);
        add(nameTF);

    //Father's Name label ==================================================
        JLabel fname = new JLabel("Father's Name");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTF = new JTextField();
        fnameTF.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTF.setBounds(300, 190, 400, 30);
        add(fnameTF);


    //Date of Birth label ==================================================
        JLabel dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);


    //Gender label ==================================================
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);


        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);


    //Email label ==================================================
        JLabel email = new JLabel("Email Address");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTF = new JTextField();
        emailTF.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTF.setBounds(300, 340, 400, 30);
        add(emailTF);


    //Marital status label ==================================================
        JLabel marital = new JLabel("Marital Status");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);


        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);


        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(married);
        bg1.add(unmarried);
        bg1.add(other);


    //Address label ==================================================
        JLabel address = new JLabel("Address");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTF = new JTextField();
        addressTF.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTF.setBounds(300, 440, 400, 30);
        add(addressTF);


    //City label ==================================================
        JLabel city = new JLabel("City");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTF = new JTextField();
        cityTF.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTF.setBounds(300, 490, 400, 30);
        add(cityTF);




    //State label ==================================================
       JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTF = new JTextField();
        stateTF.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTF.setBounds(300, 540, 400, 30);
        add(stateTF);

    //Pin code label ==================================================
        JLabel pincode = new JLabel("Pin Code");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pincodeTF = new JTextField();
        pincodeTF.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTF.setBounds(300, 590, 400, 30);
        add(pincodeTF);


    //Next button ==================================================

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setVisible(true);
        setLocation(350,10);

    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; // string ("") + long = String
        String name = nameTF.getText();
        String fname = fnameTF.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTF.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "other";
        }
        String address = addressTF.getText();
        String city = cityTF.getText();
        String state = stateTF.getText();
        String pincode = pincodeTF.getText();


        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query); // execute query using statement
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }


        } catch (Exception e) {
            System.out.println(e);
        }

    }



    public static void main(String[] args) {
        new SignupOne();

    }
}
