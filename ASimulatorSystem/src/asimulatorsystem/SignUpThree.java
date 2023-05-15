package asimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton saving, fixed, current, recuring;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    SignUpThree(String formno)
    {
        this.formno = formno;
        setLayout(null);
        
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setBounds(230, 20, 400, 30);
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        add(accountDetails);
        
        JLabel accountType = new JLabel("Account Type");
        accountType.setBounds(60, 90, 300, 30);
        accountType.setFont(new Font("Raleway", Font.BOLD, 20));
        add(accountType);
        
        saving = new JRadioButton("Saving Account");
        saving.setBounds(60, 130, 200, 30);
        saving.setFont(new Font("Raleway", Font.BOLD, 16));
        saving.setBackground(Color.WHITE);
        add(saving);
        
        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(290, 130, 300, 30);
        fixed.setFont(new Font("Raleway", Font.BOLD, 16));
        fixed.setBackground(Color.WHITE);
        add(fixed);
        
        current = new JRadioButton("Current Account");
        current.setBounds(60, 170, 200, 30);
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBackground(Color.WHITE);
        add(current);
        
        recuring = new JRadioButton("Recurring Deposit Account");
        recuring.setBounds(290, 170, 300, 30);
        recuring.setFont(new Font("Raleway", Font.BOLD, 16));
        recuring.setBackground(Color.WHITE);
        add(recuring);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(saving);
        groupaccount.add(fixed);
        groupaccount.add(current);
        groupaccount.add(recuring);
        
        JLabel card = new JLabel("Card Number : ");
        card.setBounds(60,220,200,30);
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBackground(Color.WHITE);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setBounds(280,220,300,30);
        number.setFont(new Font("Raleway",Font.BOLD,20));
        number.setBackground(Color.WHITE);
        add(number);
        
        JLabel cardDetail = new JLabel("Your 16 Digit Card number");
        cardDetail.setBounds(60,250,200,20);
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetail.setBackground(Color.WHITE);
        add(cardDetail);
        
        JLabel pin = new JLabel("PIN : ");
        pin.setBounds(60,280,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBackground(Color.WHITE);
        add(pin);
        
        JLabel pNumber = new JLabel("XXXX");
        pNumber.setBounds(280,280,300,30);
        pNumber.setFont(new Font("Raleway",Font.BOLD,20));
        pNumber.setBackground(Color.WHITE);
        add(pNumber);
        
        JLabel pinDetail = new JLabel("Your 4 Digit Password.");
        pinDetail.setBounds(60,310,200,20);
        pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetail.setBackground(Color.WHITE);
        add(pinDetail);
        
        JLabel services = new JLabel("Services Required");
        services.setBounds(60,350,300,30);
        services.setFont(new Font("Raleway",Font.BOLD,20));
        services.setBackground(Color.WHITE);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBounds(60, 390, 200, 25);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(280, 390, 200, 25);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.WHITE);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(60, 425, 200, 25);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4 = new JCheckBox("Email and SMS Alert");
        c4.setBounds(280, 425, 200, 25);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.WHITE);
        add(c4);
        
        c5 = new JCheckBox("Check Book");
        c5.setBounds(60, 460, 200, 25);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBounds(280, 460, 200, 25);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that above entered details are correct to the best of my Knowledge.");
        c7.setBounds(60, 505, 600, 20);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(Color.WHITE);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBounds(200, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,18));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(360, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,18));
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        setTitle("Accounts Details");
        
        setSize(700,680); 
        setLocation(300,0);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==submit)
      {
          String accountType = null;
          if(saving.isSelected())
          {
              accountType = "Saving Account";
          }
          else if(fixed.isSelected())
          {
              accountType = "Fixed Deposit Account";
          }
          else if(current.isSelected())
          {
              accountType = "Current Account";
          }
          else if(recuring.isSelected())
          {
              accountType = "Recurring Account";
          }
          
          Random random = new Random();
          String cardNumber =""+ Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);
          String pinNumber =""+ Math.abs((random.nextLong() % 9000L)+1000L);
          
          String facility = "";
          if(c1.isSelected())
          {
              facility = facility + " ATM card";
          }
          if(c2.isSelected())
          {
              facility = facility + " Internet Banking";
          }
          if(c3.isSelected())
          {
              facility = facility + " Mobile Banking";
          }
          if(c4.isSelected())
          {
              facility = facility + " Email and SMS Alert";
          }
          if(c5.isSelected())
          {
              facility = facility + " Cheque Book";
          }
          if(c6.isSelected())
          {
              facility = facility + " E-Statement";
          }
          
          try
          {
              if(accountType.equals(""))
              {
                  JOptionPane.showMessageDialog(null, "Account type is Required");
              }else
              {
                  Conn conn = new Conn();
                  String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                  String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                  conn.s.executeUpdate(query1);
                  conn.s.executeUpdate(query2);
                  
                  JOptionPane.showMessageDialog(null, "Card Number:  " +  cardNumber + "\n PIN:  " + pinNumber);
                  setVisible(false);
                  new Login().setVisible(true);
              }
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
          
      }
      else if(ae.getSource()==cancel)
      {
          setVisible(false);
          new Login();
      }
    }

    
    public static void main(String args[]) {
        new SignUpThree("");
    }
}
