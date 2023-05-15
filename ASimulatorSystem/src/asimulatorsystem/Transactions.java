
package asimulatorsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, fastCash, miniStatement, pinChange, balance, exit;
    String pinnumber;
    
    Transactions(String pinnumber)
    {
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 680);
        add(image);
        
        JLabel text = new JLabel("Please Select your Transaction");
        text.setBounds(170,230,200,30);
        text.setForeground(Color.white);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(125,314,130,22);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(265,314,130,22);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(125,342,130,22);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini-Statement");
        miniStatement.setBounds(265,342,130,22);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(125,369,130,22);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(265,369,130,22);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
        exit.setBounds(265,394,130,22);
        exit.addActionListener(this);
        image.add(exit);
        
        setTitle("Transactions");
        setSize(700,680);
        setLocation(280,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl)
        {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastCash)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinChange)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balance)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==miniStatement)
        {
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    
    public static void main(String args[]) {
        new Transactions("");
    }
}
