package tour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class person {
	public static int val, total;
	 int y ;
	void perso(){
JFrame frame = new JFrame("Total Persons");
		
		JLabel l1 = new JLabel("Enter No. of Persons");
		JTextField t1 = new JTextField();
		JButton sign =new JButton("Ok");
		
		l1.setBounds(40, 70, 200, 30);
		t1.setBounds(200, 70, 150, 30);
		sign.setBounds(90, 150, 100, 30);
		
		frame.add(l1);
		frame.add(t1);
		frame.add(sign);
		
		frame.setSize(400, 350);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		ActionListener al = new ActionListener() {
			@Override
			 public void actionPerformed(ActionEvent e) {
				String i = t1.getText();
				 val = Integer.parseInt(i);
				 frame.dispose();
				 y = tour.person.val ;
				 for (int x = tour.person.val; x > 0; x--) 
				 {
					 person_swing(x);	
				 }
				
		}
	};
	sign.addActionListener(al);
	
	
}
	void person_swing(int x) {
		 
			 JFrame frame = new JFrame("Details");
			 JLabel l1 = new JLabel("Person "+(x));
			 JLabel l2 = new JLabel("Name");
			 JLabel l3 = new JLabel("Age");
			 JLabel l4 = new JLabel("Gender");
			 JTextField t1 = new JTextField();
			 JTextField t2 = new JTextField();
			 JTextField t3 = new JTextField();
			 JButton ok =new JButton("ok");	
			 
			 
			 l1.setBounds(100, 30, 400, 30);
			 l2.setBounds(80, 70, 200, 30);
			 l3.setBounds(80, 110, 200, 30);
			 l4.setBounds(80,150,200,30);
			 t1.setBounds(300, 70, 200, 30);
			 t2.setBounds(300, 110, 200, 30);
			 t3.setBounds(300,150,200,30);
			 ok.setBounds(450, 200, 100, 30);
			 
			 frame.add(l1);
			 frame.add(l2);
			 frame.add(l3);
			 frame.add(l4);
			 frame.add(t1);
			 frame.add(t2);
			 frame.add(t3);
			 frame.add(ok);
			 
			 frame.setSize(800, 400);
			 frame.setLayout(null);
			 frame.setVisible(true);
			 
			 
			 
			cost_display obj3 = new cost_display();
			
			 if(city.s == "Goa")
			 {	 
			 ok.addActionListener(new ActionListener(){
				 public void actionPerformed(ActionEvent e){  
					 Fillo filloc= new Fillo();
					 Connection connection1;
					 try {
							connection1 = filloc.getConnection("tour.xlsx");
							String str1Queryc ="INSERT INTO Sheet2(Name,Age,Gender)VALUES('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"')";
							connection1.executeUpdate(str1Queryc);		
							connection1.close();
							
							
							y = y - 1; 
						} catch (FilloException e1) {
							
							e1.printStackTrace();
						}
					    frame.dispose();
					    total = val * goa.goa_price  ;
					    if(y==0)
					    {
					    	obj3.costDisplay();
					    }
				 }
			 });
			 
			 }
			 
			 else if(city.s=="Cochin")
			 {
				 ok.addActionListener(new ActionListener(){
					 public void actionPerformed(ActionEvent e){  
						 Fillo filloc= new Fillo();
						 Connection connection1;
						 try {
								connection1 = filloc.getConnection("tour.xlsx");
								String str1Queryc ="INSERT INTO Sheet3(Name,Age,Gender)VALUES('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"')";
								connection1.executeUpdate(str1Queryc);		
								connection1.close();
								y = y - 1;
							} catch (FilloException e1) {
								
								e1.printStackTrace();
							}
						    frame.dispose();
						    total = val * cochin.cochin_price;
						    if(y==0)
						    {
						    	obj3.costDisplay();
						    }
					 }
				 }); 
			 }
			 
			 else if(city.s=="Delhi")
			 {
				 ok.addActionListener(new ActionListener(){
					 public void actionPerformed(ActionEvent e){  
						 Fillo filloc= new Fillo();
						 Connection connection1;
						 try {
								connection1 = filloc.getConnection("tour.xlsx");
								String str1Queryc ="INSERT INTO Sheet4(Name,Age,Gender)VALUES('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"')";
								connection1.executeUpdate(str1Queryc);		
								connection1.close();
								y = y - 1;
							} catch (FilloException e1) {
								
								e1.printStackTrace();
							}
						    frame.dispose();
						    total = val * delhi.delhi_price;
						    if(y==0)
						    {
						    	obj3.costDisplay();
						    }
					 }
				 }); 
			 }
	         
			 else if(city.s == "Kashmir")
			 {
				 ok.addActionListener(new ActionListener(){
					 public void actionPerformed(ActionEvent e){  
						 Fillo filloc= new Fillo();
						 Connection connection1;
						 try {
								connection1 = filloc.getConnection("tour.xlsx");
								String str1Queryc ="INSERT INTO Sheet5(Name,Age,Gender)VALUES('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"')";
								connection1.executeUpdate(str1Queryc);		
								connection1.close();
							 	y = y - 1; 
							} catch (FilloException e1) {
								
								e1.printStackTrace();
							}
						    frame.dispose();
						    total = val * kashmir.kashmir_price;
						    if(y==0)
						    {
						    	obj3.costDisplay();
						    }
					 }
				 }); 
			 }
	     
	 }
	
}

