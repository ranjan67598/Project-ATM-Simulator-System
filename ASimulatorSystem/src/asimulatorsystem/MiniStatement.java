package asimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber)
    {
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,120,300,200);
        add(mini);
        
        JLabel bank = new JLabel("BANK BANK");
        bank.setBounds(100,15,80,0);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,70,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number : "+rs.getString("cardnumber").substring(0,4)+"-XXXX-XXXX-"+rs.getString("cardnumber").substring(12));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        try
        {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText() + "<html>"+rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit"))
                {
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("You Current Account Balance is Rs " +bal);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        setTitle("Mini-Statement");
        setSize(330,600);
        setLocation(15,15);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }

    public static void main(String args[]) {
        new MiniStatement("");
    }
}
