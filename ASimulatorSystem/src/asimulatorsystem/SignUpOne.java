
package asimulatorsystem;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignUpOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JDateChooser datechooser;
    JButton next;
    JRadioButton male, female, others, married, unmarried;
    
    SignUpOne()
    {
        setLayout(null);
        
        setTitle("New Account Application Form - PAGE -1");
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(160, 10, 500, 40);
        add(formno);
        
        JLabel personalDatails = new JLabel("PAGE 1: Personal Details ");
        personalDatails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDatails.setBounds(235, 60, 400, 30);
        add(personalDatails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 110, 200, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 110, 300, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 150, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300, 150, 300, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 190, 200, 30);
        add(dob);
        
        datechooser = new JDateChooser();
        datechooser.setBounds(300,190,300,30);
        datechooser.setForeground(Color.black);
        add(datechooser); 
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 230, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(300,230,60,30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(400,230,80,30);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 270, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300, 270, 300, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100, 310, 200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBackground(Color.WHITE);
        married.setBounds(300,310,80,30);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(390,310,100,30);
        add(unmarried);
        
        others = new JRadioButton("Others");
        others.setBackground(Color.WHITE);
        others.setBounds(500,310,80,30);
        add(others);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 350, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300, 350, 300, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 390, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300, 390, 300, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100, 430, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300, 430, 300, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("PinCode: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100, 470, 200, 30);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300, 470, 300, 30);
        add(pinTextField);
        
        next = new JButton("NEXT");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(520, 530, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750,680);
        setLocation(250,0);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
        {
            gender = "Male";
        }
        else if(female.isSelected())
        {
            gender = "Female"; 
        }
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected())
        {
            marital = "Married";
        }
        else if(unmarried.isSelected())
        {
            marital = "Unmarried";
        }
        else if(others.isSelected())
        {
            marital = "Others";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else
            {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e)
        {
            System.out.println(e); 
        }
        
    }
    
    
    public static void main(String args[]) {
       new SignUpOne();
    }
}
