
package atmsimulationsystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Pattern;

public class Login extends JFrame implements ActionListener{
	JLabel l1,l2,l3;
	JTextField tf1;
	JPasswordField pf2;
	JButton b1,b2,b3;

	Login(){


		//Move the text to the center

		setFont(new Font("System", Font.BOLD, 22));
		Font f = getFont();
		FontMetrics fm = getFontMetrics(f);
		int x = fm.stringWidth("AUTOMATED TELLER MACHINE");
		int y = fm.stringWidth(" ");
		int z = getWidth() - x;
		int w = z/y;
		String pad ="";
		//for (int i=0; i!=w; i++) pad +=" ";   
		pad = String.format("%"+w+"s", pad);
		setTitle(pad+"AUTOMATED TELLER MACHINE");






		l1 = new JLabel("WELCOME TO ATM");
		l1.setFont(new Font("Osward", Font.BOLD, 38));

		l2 = new JLabel("Card No:");
		l2.setFont(new Font("Raleway", Font.BOLD, 28));


		tf1 = new JTextField(15);
		pf2 = new JPasswordField(15);

		b1 = new JButton("SIGN IN");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2 = new JButton("CLEAR");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		b3 = new JButton("SIGN UP");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);

		setLayout(null);

		l1.setBounds(175,50,450,200);
		add(l1);

		l2.setBounds(125,150,375,200);
		add(l2);

		tf1.setFont(new Font("Arial", Font.BOLD, 14));
		tf1.setBounds(300,235,230,30);
		add(tf1);



		b1.setFont(new Font("Arial", Font.BOLD, 14));
		b1.setBounds(300,400,100,30);
		add(b1);

		b2.setFont(new Font("Arial", Font.BOLD, 14));
		b2.setBounds(430,400,100,30);
		add(b2);

		b3.setFont(new Font("Arial", Font.BOLD, 14));
		b3.setBounds(300,450,230,30);
		add(b3);


		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		getContentPane().setBackground(Color.CYAN);

		setSize(750,700);
		setLocation(300,5);
		setVisible(true);



	}
	public void actionPerformed(ActionEvent ae){

		try{        
			conn c1 = new conn();
			String a  = tf1.getText();
			//String b  = pf2.getText();

			if(ae.getSource()==b1){

				//Checking input using regex

				if(!Pattern.matches("\\d{16}",a )) {

					JOptionPane.showMessageDialog(null, "Please Enter your 16 digit card number."); // new change
					tf1.setText("");
					pf2.setText("");

				}else {
					String q  = "select * from signup3 where cardno = '"+a+"'";
					ResultSet rs = c1.s.executeQuery(q);
					if(rs.next()){
						new Transactions(a).setVisible(true);
						setVisible(false);

					}else{
						JOptionPane.showMessageDialog(null, "Card not recognised !");

					}
				}
			}else if(ae.getSource()==b2){
				tf1.setText("");
				pf2.setText("");
			}else if(ae.getSource()==b3){
				JOptionPane.showMessageDialog(null, "Please note your form number for reference. ");
				new Signup().setVisible(true);
				setVisible(false);

			}


		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error: "+e);
		}

	}


	public static void main(String[] args){
		new Login().setVisible(true);
	}


}
