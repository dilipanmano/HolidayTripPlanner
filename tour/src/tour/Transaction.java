package tour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Transaction {
	Transaction(int amt,String un,String s1){
		JFrame tr=new JFrame("Transaction");
		JLabel no = new JLabel("Total Number of seats:"+tour.person.val+"");
		JLabel cost = new JLabel("Total Cost:"+amt+"");
		JLabel l3 = new JLabel("Transaction Password:");

		  JPasswordField tf1 = new JPasswordField();
		JButton btn=new JButton("Confirm");  
		
		  no.setBounds(100, 30, 400, 30);
		  cost.setBounds(100, 70, 200, 30);
		  l3.setBounds(100, 110, 200, 30);
		  tf1.setBounds(300, 110, 200, 30);
		  btn.setBounds(400, 160, 100, 30);
		  
		  tr.add(no);
		  tr.add(cost);
		  tr.add(l3);
		  tr.add(tf1);
		  tr.add(btn);

		  tr.setSize(800, 400);
		  tr.setLayout(null);
		  tr.setVisible(true);
		  btn.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){  
			             String un1=tf1.getText();
			             int stats=0;
				  Fillo filloc= new Fillo();
					Connection connection1;
					try {
						connection1 = filloc.getConnection("tour.xlsx");
						String str1Queryc ="SELECT * FROM Sheet6 WHERE EXISTS (SELECT BankId FROM Sheet1 WHERE TransactionId='"+tf1.getText()+"' and BankId='"+un+"')";
				
						
						Recordset rsc=connection1.executeQuery(str1Queryc);					
						if(un1.equals("")) {

			        		   JOptionPane.showMessageDialog(null,"Kindly Enter both your TransactionId ");
						}else {
	                    while(rsc.next()) {
	                    	if(rsc.getField("TransactionId").equals(un1)&&(Integer.parseInt(rsc.getField("Balance"))>amt)) {
	                    		int amt1=Integer.parseInt(rsc.getField("Balance"));
	                    		amt1=amt1-amt;
	                    		String upp= Integer.toString(amt1);
	                    		String strup="Update Sheet6 Set Balance='"+amt1+"' where BankId='"+un+"' ";
	                    		connection1.executeUpdate(strup);
	                    		JOptionPane.showMessageDialog(null,"Transaction Successful!!!");
	                    		tr.dispose();
	                    		new Finish();
	                    		stats+=1;
	                    	    //new Update(s1,dat1,Mov1,Tim1); 	
	                    		break;
	                    	}
	                    	
	                    }
	                    if(stats==0){
                    		JOptionPane.showMessageDialog(null,"Incorrect BankId or Password");
                    		
                    	}
						}
						
					} catch (FilloException e1) {	
						e1.printStackTrace();
					}


	          }  
}); 
}
}
