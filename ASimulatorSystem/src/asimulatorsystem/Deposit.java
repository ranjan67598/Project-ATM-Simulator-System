
package asimulatorsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JButton deposit, back;
    JTextField amount;
    String pinnumber;
    
    Deposit(String pinnumber)
    {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,680);
        add(image);
        
        JLabel text = new JLabel("Enter the Amount you want to deposit");
        text.setBounds(130,230,250,30);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(130,270,250,30);
        amount.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(300,365,100,22);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(300,392,100,22);
        back.addActionListener(this);
        image.add(back);
        
        setTitle("Deposit");
        setSize(700,680);
        setLocation(280,0);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==deposit)
        {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter a Valid amount");
            }
            else
            {
                try
                {
                    Conn conn = new Conn();
                    String query = "Insert into bank values('"+pinnumber+"','"+date+"', 'Deposit','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs"+number+" deposited Sucessfull");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Deposit("");
        
    }
}
