
package asimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
    
    JButton change, back;
    JPasswordField pin, rePin;
    String pinnumber;
    
    PinChange(String pinnumber)
    {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,680);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setBounds(190,210,200,30);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel pinText = new JLabel("New PIN: ");
        pinText.setForeground(Color.WHITE);
        pinText.setBounds(125,250,150,25);
        pinText.setFont(new Font("System",Font.BOLD,12));
        image.add(pinText);
        
        pin = new JPasswordField();
        pin.setBounds(240,250,150,25);
        pin.setFont(new Font("System",Font.BOLD,12));
        image.add(pin);
        
        JLabel rePinText = new JLabel("Confirm new PIN: ");
        rePinText.setForeground(Color.WHITE);
        rePinText.setBounds(125,285,150,25);
        rePinText.setFont(new Font("System",Font.BOLD,12));
        image.add(rePinText);
        
        rePin = new JPasswordField();
        rePin.setBounds(240,285,150,25);
        rePin.setFont(new Font("System",Font.BOLD,12));
        image.add(rePin);
        
        change = new JButton("Change");
        change.setBounds(265,320,80,25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(175,320,80,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700,680);
        setLocation(280,0);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==change)
        {
            try
            {
                String npin = pin.getText();
                String rpin = rePin.getText();               
                
                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter new Pin");
                    return;
                }
                
                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please re-Enter new Pin");
                    return;
                }
                
                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null, "Pin Mismatch");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
                
                setVisible(false);
                new Transactions(npin).setVisible(true);
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }

    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}