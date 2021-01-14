
package atmsimulationsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField t1;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String cardno;
    
    Withdrawl(String a){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("WITHDRAWAL");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (3*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"WITHDRAWAL");
        
        cardno = a;
        
        l1 = new JLabel("MAXIMUM DAILY WITHDRAWAL");
        l1.setFont(new Font("System", Font.BOLD, 40));
        
        l2 = new JLabel("IS RS.10,000");
        l2.setFont(new Font("System", Font.BOLD, 40));
        
        l3 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l3.setFont(new Font("System", Font.BOLD, 35));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        
        b1 = new JButton("WITHDRAW");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.DARK_GRAY);
        b3.setForeground(Color.WHITE);
        
        
        setLayout(null);
        
        l1.setBounds(90,100,800,60);
        add(l1);
        
        l2.setBounds(270,160,800,60);
        add(l2);
        
        l3.setBounds(120,260,800,60);
        add(l3);
        
        t1.setBounds(210,340,360,50);
        add(t1);
        
        b1.setBounds(220,400,160,50);
        add(b1);
        
        b2.setBounds(400,400,160,50);
        add(b2);
        
        b3.setBounds(300,550,200,50);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        
        getContentPane().setBackground(Color.CYAN);
        
        setSize(800,750);
        setLocation(300,90);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String a = t1.getText();

            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                
                }else if(Integer.parseInt(t1.getText())<100 ){
                    
                    JOptionPane.showMessageDialog(null, "Minimum amout that can be withdrawn is Rs.100. ");
                
                }else if(Integer.parseInt(t1.getText())%100 != 0 ){
                    
                    JOptionPane.showMessageDialog(null, "Denomination not available. ");
                
                }else{
                    String pinn = JOptionPane.showInputDialog("Enter your PIN : ");
                    conn c1 = new conn();
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+pinn+"' AND accno = '"+cardno+"' order by id desc");
                    
                    double balance = 0;
                    if(rs.next()){
                        String mobile = rs.getString("mobile");
                        String pin = rs.getString("pin");
                        
                        balance = rs.getDouble("balance");
                        //System.out.println(balance);
                        
                        double d = Double.parseDouble(a);
                        if((balance-d<=0)){
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        
                        }else{
                        balance-=d;
                        String q1= "insert into bank values('"+cardno+"','"+mobile+"','"+pin+"',null,'"+d+"','"+balance+"',null)";
                    
                        c1.s.executeUpdate(q1);
                    
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+a+" Debited Successfully");
                    
                    new Transactions(cardno).setVisible(true);
                    setVisible(false);
                        }
                    
                    }else {
                    	JOptionPane.showMessageDialog(null, "Incorrect PIN !");
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
//        new Withdrawl("5040936014162963").setVisible(true);
//    }
}
