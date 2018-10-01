package tour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Finish {
		Finish(){
			JFrame frame=new JFrame("Success!");
			
			JLabel l3 = new JLabel("Your " + tour.person.val +" tickets have been succesfully booked ");
			JLabel l4 = new JLabel("and the amount of Rs."+ tour.person.total);
			JLabel l5 = new JLabel("has been successfully transfered  from your account");
			JButton btn=new JButton("Confirm");  
			
			l3.setBounds(50, 50, 500, 50);
			l4.setBounds(50, 80, 500, 50);
			l5.setBounds(50, 110, 500, 50);
			btn.setBounds(130, 180, 80, 30);
			
			frame.add(l3);
			frame.add(l4);
			frame.add(l5);
			frame.add(btn);
			
			frame.setSize(400, 350);
			frame.setLayout(null);
			frame.setVisible(true);
			
			btn.addActionListener(new ActionListener(){ 
				public void actionPerformed(ActionEvent e){ 
					frame.dispose();
				}
			});
		}
}
