
package asimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    
    JButton b1, b2, b3, b4, b5, b6, back;
    String pinnumber;
    
    FastCash(String pinnumber)
    {
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 680);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(170,230,200,30);
        text.setForeground(Color.white);
        image.add(text);
        
        b1 = new JButton("Rs 100");
        b1.setBounds(125,314,130,22);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Rs 500");
        b2.setBounds(265,314,130,22);
        b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Rs 1000");
        b3.setBounds(125,342,130,22);
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Rs 2000");
        b4.setBounds(265,342,130,22);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Rs 5000");
        b5.setBounds(125,369,130,22);
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Rs 10000");
        b6.setBounds(265,369,130,22);
        b6.addActionListener(this);
        image.add(b6);
        
        back = new JButton("Back");
        back.setBounds(265,394,130,22);
        back.addActionListener(this);
        image.add(back);
        
        setTitle("FastCash");
        setSize(700,680);
        setLocation(280,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else 
        {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try
            {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance=0;
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
                if(ae.getSource()!=back && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    
    public static void main(String args[]) {
        new FastCash("");
    }
}
