package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
public class SignupTwo extends JFrame implements ActionListener {


    String formno;
    JTextField  nameTF, fnameTF, pan,dobTF, stateTF, pincodeTF, idTF, emailTF;
    JButton next;
    JRadioButton male, female, married, unmarried, other, syes,eyes,eno, sno;
    JDateChooser dateChooser;

    JComboBox religion,category,income,qualification,occupation1;
    SignupTwo(String formno) {
        // to get primary id from prior form
        this.formno = formno;

        setLayout(null);
        setTitle("Account Application Page 2");


        //Personal Info ======================================================================
        JLabel additonalinfo = new JLabel("Page 2: Additional Information");
        additonalinfo.setFont(new Font("Raleway", Font.BOLD, 22));
        additonalinfo.setBounds(280, 80, 400, 30);
        add(additonalinfo);

        //religion label ==================================================
        JLabel name = new JLabel("Religion");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 120, 30);

        add(name);

        religion = new JComboBox();
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        religion.addItem("Catholic");
        religion.addItem("Hindu");
        religion.addItem("Muslim");
        religion.addItem("Christian");
        add(religion);


        //Category label ==================================================
        JLabel fname = new JLabel("Category");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        category = new JComboBox();
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        category.addItem("General");
        category.addItem("OBC");
        category.addItem("SC");
        category.addItem("ST");
        add(category);


        //Income label ==================================================
        JLabel dob = new JLabel("Income");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        income = new JComboBox();
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        income.addItem("Null");
        income.addItem("0L - 2L");
        income.addItem("2L - 5L");
        income.addItem("5L - 10L");
        income.addItem("10L+");
        add(income);


        //Education label ==================================================
        JLabel gender = new JLabel("Education");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);


        JLabel email = new JLabel("Qualifications");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);

        qualification = new JComboBox();
        qualification.setBackground(Color.WHITE);
        qualification.addItem("Class X");
        qualification.addItem("Class XII");
        qualification.addItem("Graduate");
        qualification.addItem("Post Graduate");
        qualification.setBounds(300, 315, 400, 30);
        add(qualification);



        //occupation label ==================================================
        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 370, 200, 30);
        add(occupation);

        occupation1 = new JComboBox();
        occupation1.setBackground(Color.WHITE);
        occupation1.addItem("Salaried");
        occupation1.addItem("Self-Employed");
        occupation1.addItem("Student");
        occupation1.setBounds(300, 370, 400, 30);
        add(occupation1);



        //pan label ==================================================
        JLabel address = new JLabel("PAN NO");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 430, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 430, 400, 30);
        add(pan);


        //id label ==================================================
        JLabel city = new JLabel("ID Number");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 480, 200, 30);
        add(city);

        idTF = new JTextField();
        idTF.setFont(new Font("Raleway", Font.BOLD, 14));
        idTF.setBounds(300, 480, 400, 30);
        add(idTF);




        //Senior label ==================================================
        JLabel state = new JLabel("Senior Citizen");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 530, 200, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 530, 60, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 530, 60, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup sgroup = new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);

        //Pin code label ==================================================
        JLabel pincode = new JLabel("Existing Account");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 580, 200, 30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 580, 60, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 580, 60, 30);
        eno.setBackground(Color.WHITE);
        add(eno);


        ButtonGroup egroup = new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);


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


        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) qualification.getSelectedItem();
        String soccupation = (String) occupation1.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if (eyes.isSelected()){
            existingaccount = "Yes";
        }
        else if (eno.isSelected()){
            existingaccount = "No";
        }

        String span = pan.getText();
        String sid = idTF.getText();

    // put in database

        try {

                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sid+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query); // execute query using statement
                setVisible(false);


                //signup3 object

        }

        catch (Exception e) {
            System.out.println(e);
        }

    }



    public static void main(String[] args) {
        // pass empty value for default constructor
        new SignupTwo("");

    }
}
