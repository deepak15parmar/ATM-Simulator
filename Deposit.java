
package atmsimulationsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1;
    JButton b1,b2,b3;
    JLabel l1,l2;
    String cardno;
    
    Deposit(String a){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("DEPOSIT");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (5*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"DEPOSIT");
        
        
        cardno = a; 
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setFont(new Font("System", Font.BOLD, 35));
        
        l2 = new JLabel("TO DEPOSIT");
        l2.setFont(new Font("System", Font.BOLD, 35));
        
        
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        
        setLayout(null);
        
        
        l1.setBounds(150,150,800,60);
        add(l1);
        
        l2.setBounds(290,210,800,60);
        add(l2);
        
        t1.setBounds(250,300,300,50);
        add(t1);
        
        b1.setBounds(260,380,125,50);
        add(b1);
        
        b2.setBounds(415,380,125,50);
        add(b2);
        
        b3.setBounds(300,550,200,50);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.CYAN);
        
        setSize(800,750);
        setLocation(300,9);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String a = t1.getText();
            
            
            
            
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                
                }else if(Integer.parseInt(t1.getText())<100 ){
                    
                    JOptionPane.showMessageDialog(null, "Minimum amount is Rs.100 ");
                
                }else if(Integer.parseInt(t1.getText())%100 != 0 ){
                    
                    JOptionPane.showMessageDialog(null, "Cannot deposit that amount. Please deposit the amount in multiples of 100"); 
                
                }else{
                    
                	String pinn = JOptionPane.showInputDialog("Please enter your PIN : ");
                    conn c1 = new conn();                   
   
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+pinn+"' and accno = '"+cardno+"' order by id desc");
                    
                    double balance = 0;
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        
                        balance = rs.getDouble("balance");
                        
                        String mobile = rs.getString("mobile");
                        
                        double d = Double.parseDouble(a);
                        balance+=d;
                        String q1= "insert into bank values('"+cardno+"','"+mobile+"','"+pin+"','"+d+"',null,'"+balance+"',null)";
                    
                        c1.s.executeUpdate(q1);
                        JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited Successfully");
                        
                        new Transactions(cardno).setVisible(true);
                        setVisible(false);
                    }else {
                    	JOptionPane.showMessageDialog(null, "Incorrect Pin !");
                        
                       
                    }
   
                }
                
            }else if(ae.getSource()==b2){
                
                new Transactions(cardno).setVisible(true);
                setVisible(false);
                
            }else if(ae.getSource()==b3){
                
                System.exit(0);
                
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    
//    public static void main(String[] args){
//        new Deposit("5040936014162963").setVisible(true);
//    }    
}
