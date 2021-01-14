
package atmsimulationsystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;
import java.lang.*;

public class Signup3 extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l12;
	JRadioButton r1,r2,r3,r4;
	JButton b1,b2;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JTextField t2;
	long formNo;



	Signup3(long first){

		setFont(new Font("System", Font.BOLD, 22));
		Font f = getFont();
		FontMetrics fm = getFontMetrics(f);
		int x = fm.stringWidth("NEW ACCOUNT APPLICATION FORM - PAGE 3");
		int y = fm.stringWidth(" ");
		int z = getWidth()/2 - (x/2);
		int w = z/y;
		String pad ="";
		//for (int i=0; i!=w; i++) pad +=" ";   
		pad = String.format("%"+w+"s", pad);
		setTitle(pad+"NEW ACCOUNT APPLICATION FORM - PAGE 3");

		formNo = first ;


		l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));

		l2 = new JLabel("Account Type:");
		l2.setFont(new Font("Raleway", Font.BOLD, 18));

		l3 = new JLabel("Card Number:");
		l3.setFont(new Font("Raleway", Font.BOLD, 18));

		l4 = new JLabel("XXXX-XXXX-XXXX-4184");
		l4.setFont(new Font("Raleway", Font.BOLD, 18));

		l5 = new JLabel("(Your 16-digit Card number)");
		l5.setFont(new Font("Raleway", Font.BOLD, 12));

		l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
		l6.setFont(new Font("Raleway", Font.BOLD, 12));

		l7 = new JLabel("PIN:");
		l7.setFont(new Font("Raleway", Font.BOLD, 18));

		l8 = new JLabel("XXXX");
		l8.setFont(new Font("Raleway", Font.BOLD, 18));

		l9 = new JLabel("(4-digit password)");
		l9.setFont(new Font("Raleway", Font.BOLD, 12));

		l10 = new JLabel("Services Required:");
		l10.setFont(new Font("Raleway", Font.BOLD, 18));



		l12 = new JLabel("Mob.No: ");
		l12.setFont(new Font("Raleway", Font.BOLD,14));


		b1 = new JButton("Submit");
		b1.setFont(new Font("Raleway", Font.BOLD, 14));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2 = new JButton("Cancel");
		b2.setFont(new Font("Raleway", Font.BOLD, 14));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);


		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.BOLD, 16));

		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.BOLD, 16));

		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.BOLD, 16));

		c4 = new JCheckBox("EMAIL Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.BOLD, 16));

		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway", Font.BOLD, 16));

		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway", Font.BOLD, 16));

		c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway", Font.BOLD, 12));


		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font.BOLD, 16));
		r1.setBackground(Color.WHITE);

		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway", Font.BOLD, 16));
		r2.setBackground(Color.WHITE);

		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway", Font.BOLD, 16));
		r3.setBackground(Color.WHITE);

		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway", Font.BOLD, 16));
		r4.setBackground(Color.WHITE);

		ButtonGroup group = new ButtonGroup();
		group.add(r1);
		group.add(r2);
		group.add(r3);
		group.add(r4);

		t2 = new JTextField();
		t2.setFont(new Font("Raleway", Font.BOLD, 12));




		setLayout(null);


		l12.setBounds(650,50,70,30);
		add(l12);



		t2.setBounds(710,50,90,30);
		add(t2);

		l1.setBounds(280,30,400,40);
		add(l1); 

		l2.setBounds(100,100,200,30);
		add(l2);

		r1.setBounds(100,140,150,30);
		add(r1);

		r2.setBounds(350,140,300,30);
		add(r2);

		r3.setBounds(100,180,250,30);
		add(r3);

		r4.setBounds(350,180,250,30);
		add(r4);

		l3.setBounds(100,260,200,30);
		add(l3);

		l4.setBounds(330,260,250,30);
		add(l4);

		l5.setBounds(100,290,200,20);
		add(l5);

		l6.setBounds(330,290,500,20);
		add(l6);

		l7.setBounds(100,330,200,30);
		add(l7);

		l8.setBounds(330,330,200,30);
		add(l8);

		l9.setBounds(100,360,200,20);
		add(l9);

		l10.setBounds(100,410,200,30);
		add(l10);

		c1.setBounds(100,460,200,30);
		add(c1);

		c2.setBounds(350,460,200,30);
		add(c2);

		c3.setBounds(100,510,200,30);
		add(c3);

		c4.setBounds(350,510,200,30);
		add(c4);

		c5.setBounds(100,560,200,30);
		add(c5);

		c6.setBounds(350,560,200,30);
		add(c6);

		c7.setBounds(100,620,600,20);
		add(c7);

		b1.setBounds(300,640,100,30);
		add(b1);

		b2.setBounds(420,640,100,30);
		add(b2);


		getContentPane().setBackground(Color.WHITE);

		setSize(850,730);
		setLocation(300,9);
		setVisible(true);

		b1.addActionListener(this);
		b2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ae){


		String a = null;
		if(r1.isSelected()){ 
			a = "Saving Account";
		}
		else if(r2.isSelected()){ 
			a = "Fixed Deposit Account";
		}
		else if(r3.isSelected()){ 
			a = "Current Account";
		}else if(r4.isSelected()){ 
			a = "Recurring Deposit Account";
		}

		Random ran = new Random();
		long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
		long first8 = Math.abs(first7);

		long first3 = (ran.nextLong() % 9000L) + 1000L;
		long first4 = Math.abs(first3);
		String cno = String.valueOf(first8);

		String b = "";
		if(c1.isSelected()){ 
			b = b+" ATM Card";
		}
		if(c2.isSelected()){ 
			b = b+" Internet Banking";
		}
		if(c3.isSelected()){ 
			b = b+" Mobile Banking";
		}
		if(c4.isSelected()){ 
			b = b+" EMAIL Alerts";
		}
		if(c5.isSelected()){ 
			b = b+" Cheque Book";
		}
		if(c6.isSelected()){ 
			b = b+" E-Statement";
		}


		String d = t2.getText();


		try{

			if(ae.getSource()==b1){

				if(b.equals("")){

					JOptionPane.showMessageDialog(null, "Fill all the required fields");

				}else if(!c7.isSelected()){

					JOptionPane.showMessageDialog(null, "Agree to declaration!");

				}else if( t2.getText().equals("")){

					JOptionPane.showMessageDialog(null, "Enter contact number !!");

				}else if( !Pattern.matches("^\\d{10}$", d)){

					JOptionPane.showMessageDialog(null, "Enter 10 digit contact number !!");

				}else{


					conn c1 = new conn();
					String q1 = "insert into signup3 values('"+formNo+"','"+a+"','"+first8+"','"+first4+"','"+b+"','"+d+"')";  
					String q3 = "insert into bank values('"+first8+"','"+d+"','"+first4+"',null,null,0,null)";
					c1.s.executeUpdate(q1);
					c1.s.executeUpdate(q3);
					JOptionPane.showMessageDialog(null, "Card Number: " + first8 + "\n Pin:"+ first4);

					new Login().setVisible(true);
					setVisible(false);
				}

			}else if(ae.getSource()==b2){
				System.exit(0);
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

//	public static void main(String[] args){
//		new Signup3(123).setVisible(true);
//	}

}
