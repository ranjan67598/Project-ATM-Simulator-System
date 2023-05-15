
package asimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    
    String pinnumber;
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,680);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(310,390,80,25);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;
        try
        {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");            
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your Current account balance:   Rs "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(130,230,300,25);
        image.add(text);
        
        setSize(700,680);
        setTitle("Balance Enquiry");
        setLocation(280,0);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
