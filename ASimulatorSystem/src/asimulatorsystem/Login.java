package asimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login()
    {
        setTitle("Automated Teller Machine");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(75, 80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(100, 10, 75, 80);
        add(label);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(190,40,520,40);
        add(text);
        
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,120,150,30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 120, 220, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,200,150,30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 200, 220, 30);
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 270, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(415, 270, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 320, 215, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        setSize(800,450);
        setVisible(true);
        setLocation(250,120);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login)
        {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber='"+cardnumber+"' and pin = '"+pinnumber+"'";
            try
            {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()) 
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect CardNumber or Pin");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignUpOne().setVisible(true);            
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
