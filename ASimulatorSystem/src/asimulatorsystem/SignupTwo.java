
package asimulatorsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{

    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton cyes, cno, eyes, eno;
    JComboBox religon, category, income, educational, occupation;
    String formno;
    
    SignupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
                
        JLabel additionalDatails = new JLabel("PAGE 2: Additional Details ");
        additionalDatails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDatails.setBounds(235, 60, 400, 30);
        add(additionalDatails);
        
        JLabel religonLabel = new JLabel("Religon: ");
        religonLabel.setFont(new Font("Raleway",Font.BOLD,20));
        religonLabel.setBounds(100, 110, 200, 30);
        add(religonLabel); 
        
        String valReligon[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religon = new JComboBox(valReligon);
        religon.setFont(new Font("Raleway",Font.BOLD,14));
        religon.setBackground(Color.WHITE);
        religon.setBounds(300, 110, 300, 30);
        add(religon);
        
        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setFont(new Font("Raleway",Font.BOLD,20));
        categoryLabel.setBounds(100, 150, 200, 30);
        add(categoryLabel);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setFont(new Font("Raleway",Font.BOLD,14));
        category.setBackground(Color.WHITE);
        category.setBounds(300, 150, 300, 30);
        add(category);
        
        JLabel incomeLabel = new JLabel("Income: ");
        incomeLabel.setFont(new Font("Raleway",Font.BOLD,20));
        incomeLabel.setBounds(100, 190, 200, 30);
        add(incomeLabel);
        
        String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setFont(new Font("Raleway",Font.BOLD,14));
        income.setBackground(Color.WHITE);
        income.setBounds(300, 195, 300, 30); 
        add(income);
        
        JLabel educationalLabel = new JLabel("Educational ");
        educationalLabel.setFont(new Font("Raleway",Font.BOLD,20));
        educationalLabel.setBounds(100, 230, 200, 30);
        add(educationalLabel);
        
        JLabel qualificationLabel = new JLabel("Qualification: ");
        qualificationLabel.setFont(new Font("Raleway",Font.BOLD,20));
        qualificationLabel.setBounds(100, 260, 200, 30);
        add(qualificationLabel);
        
        String valEducational[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Retired","Others"};
        educational = new JComboBox(valEducational);
        educational.setFont(new Font("Raleway",Font.BOLD,14));
        educational.setBackground(Color.WHITE);
        educational.setBounds(300, 250, 300, 30);
        add(educational);
        
        JLabel occupationLabel = new JLabel("Occupation: ");
        occupationLabel.setFont(new Font("Raleway",Font.BOLD,20));
        occupationLabel.setBounds(100, 300, 200, 30);
        add(occupationLabel);
        
        String valOccupation[] = {"Self-Employed","Salaried","Business Man","Student","Other"};
        occupation = new JComboBox(valOccupation);
        occupation.setFont(new Font("Raleway",Font.BOLD,14));
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300, 300, 300, 30);
        add(occupation);
        
        JLabel panLabel = new JLabel("PAN No.: ");
        panLabel.setFont(new Font("Raleway",Font.BOLD,20));
        panLabel.setBounds(100, 340, 200, 30);
        add(panLabel);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300, 340, 300, 30);
        add(panTextField);
        
        JLabel aadharLabel = new JLabel("Aadhar Number: ");
        aadharLabel.setFont(new Font("Raleway",Font.BOLD,20));
        aadharLabel.setBounds(100, 380, 200, 30);
        add(aadharLabel);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300, 380, 300, 30);
        add(aadharTextField);
        
        JLabel citizenLabel = new JLabel("Senior citizen: ");
        citizenLabel.setFont(new Font("Raleway",Font.BOLD,20));
        citizenLabel.setBounds(100, 420, 200, 30);
        add(citizenLabel);
        
        cyes = new JRadioButton("YES");
        cyes.setBackground(Color.WHITE);
        cyes.setBounds(300,420,80,30);
        add(cyes);
        
        cno = new JRadioButton("NO");
        cno.setBackground(Color.WHITE);
        cno.setBounds(390,420,100,30);
        add(cno);
        
        
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(cyes);
        citizengroup.add(cno);
        
        JLabel existingLabel = new JLabel("Existing Account: ");
        existingLabel.setFont(new Font("Raleway",Font.BOLD,20));
        existingLabel.setBounds(100, 460, 200, 30);
        add(existingLabel);
        
        eyes = new JRadioButton("YES");
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(300,460,80,30);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBackground(Color.WHITE);
        eno.setBounds(390,460,100,30);
        add(eno);       
        
        ButtonGroup existgroup = new ButtonGroup();
        existgroup.add(eyes);
        existgroup.add(eno);
        
        next = new JButton("NEXT");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(520, 520, 80, 30);
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
        String sreligon = (String) religon.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) educational.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        String seniorcitizen = null;
        if(cyes.isSelected())
        {
            seniorcitizen = "Yes";
        }
        else if(cno.isSelected())
        {
            seniorcitizen = "No"; 
        }
        String existing = null;
        if(eyes.isSelected())
        {
            existing = "Yes";
        }
        else if(eno.isSelected())
        {
            existing = "No";
        }
        
        try
        {
               Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligon+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existing+"')";
                c.s.executeUpdate(query); 
                
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e); 
        }
        
    }
    
    
    public static void main(String args[]) {
       new SignupTwo("");
    }
}
