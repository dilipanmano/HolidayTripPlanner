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

public class update {
	update() {
		JFrame frame = new JFrame("Bank Confirmation");
		
		JLabel l1 = new JLabel("No. of Persons : " + person.val  );
		JLabel l2 = new JLabel("Total Cost : " + person.total);
		JButton ok2 =new JButton("Click to Confirm");
		JLabel l3 = new JLabel("Bank Username:");
		JLabel l4 = new JLabel("Transaction Password:");
		JTextField tf1 = new JTextField();
		JPasswordField p1 = new JPasswordField();
		
		l1.setBounds(80, 70, 200, 30);
		l2.setBounds(80, 110, 200, 30);
		ok2.setBounds(350, 200, 500, 40);
		l3.setBounds(80, 150, 200, 30);
		l4.setBounds(80, 190, 200, 30);
		tf1.setBounds(150, 150, 200, 30);
		p1.setBounds(150, 190, 200, 30);
		
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);
		frame.add(tf1);
		frame.add(p1);
		frame.add(ok2);
		
		frame.setSize(800, 400);
		frame.setLayout(null);
		frame.setVisible(true);
		

		ok2.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){ 
				String un1=p1.getText();
				int exi,stats=0,amt=person.total;
				  Fillo filloc= new Fillo();
					Connection connection1;
					try {
						connection1 = filloc.getConnection("tour.xlsx");
						String str1Queryc ="SELECT * FROM Sheet6 WHERE EXISTS (SELECT BankId FROM Sheet6 WHERE TransactionId='"+p1.getText()+"' and BankId='"+tf1+"')";
						Recordset rsc=connection1.executeQuery(str1Queryc);					
						if(un1.equals("")) {

			        		   JOptionPane.showMessageDialog(null,"Kindly Enter both your TransactionId ");
						}else {
	                    while(rsc.next()) {
	                    	if(rsc.getField("TransactionId").equals(un1)&&(Integer.parseInt(rsc.getField("Balance"))>amt)) {
	                    		int amt1=Integer.parseInt(rsc.getField("Balance"));
	                    		amt1=amt1-amt;
	                    		String upp= Integer.toString(amt1);
	                    		String strup="Update Sheet6 Set Balance='"+amt1+"' where BankId='"+tf1+"' ";
	                    		connection1.executeUpdate(strup);
	                    		JOptionPane.showMessageDialog(null,"Transaction Successful!!!");
	                    		frame.dispose();
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
