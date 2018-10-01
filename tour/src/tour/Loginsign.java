package tour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;  
public class Loginsign {  
JFrame f;  
	 Loginsign() {
	  JFrame frame = new JFrame("Login Form");
	  JLabel l1 = new JLabel("Login Form");
	 
	  JLabel l2 = new JLabel("Username");
	  JLabel l3 = new JLabel("Password");
	  JTextField tf1 = new JTextField();
	  JPasswordField p1 = new JPasswordField();
	  JButton btn1 = new JButton("Login");
      JButton sign =new JButton("SignUp");	 
	  l1.setBounds(100, 30, 400, 30);
	  l2.setBounds(80, 70, 200, 30);
	  l3.setBounds(80, 110, 200, 30);
	  tf1.setBounds(300, 70, 200, 30);
	  p1.setBounds(300, 110, 200, 30);
	  btn1.setBounds(400, 160, 100, 30);
	  sign.setBounds(250, 160, 100, 30);
	  frame.add(l1);
	  frame.add(l2);
	  frame.add(tf1);
	  frame.add(l3);
	  frame.add(p1);
	  frame.add(btn1);
	  frame.add(sign);
	 
	  frame.setSize(800, 400);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  
	  btn1.addActionListener(new ActionListener(){  
		  public void actionPerformed(ActionEvent e){  
		             String un=tf1.getText();
		             String pwd=p1.getText();
		             int stats=0;
			  Fillo filloc= new Fillo();
				Connection connection1;
				try {
					connection1 = filloc.getConnection("tour.xlsx");
					String str1Queryc ="SELECT * FROM Sheet1 WHERE EXISTS (SELECT Username FROM Sheet1 WHERE Username='"+btn1.getText()+"')";
			
					
					Recordset rsc=connection1.executeQuery(str1Queryc);					
					if(un.equals("") ||pwd.equals("")) {

		        		   JOptionPane.showMessageDialog(null,"Kindly Enter both your Username and Password");
					}else {
                    while(rsc.next()) {
                    	if(rsc.getField("Password").equals(pwd)) {
                    		JOptionPane.showMessageDialog(null,"Login Successful!!!");
                    		 frame.dispose();
                    		new city();
                    		stats=stats+1;
                    		break;
                    	}
                    	
                    }
                    if(stats==0){
                		JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
                		
                	}
					}
					
				} catch (FilloException e1) {
					
					e1.printStackTrace();
				}


		          }  
		      }); 
	 
	  sign.addActionListener(new ActionListener(){  
		  public void actionPerformed(ActionEvent e){  
			  frame.dispose();
			  new signup();
		  }  
      }); 
	  
	 }  
public static void main(String[] args) {  
    new Loginsign();  
}} 
