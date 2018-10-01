package tour;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cost_display {
	void costDisplay(){
	JFrame frame = new JFrame("Confirmation");
	
	JLabel l1 = new JLabel("No. of Persons : " + person.val  );
	JLabel l2 = new JLabel("Total Cost : " + person.total);
	JButton ok2 =new JButton("Confirm");	
	
	l1.setBounds(80, 70, 200, 30);
	l2.setBounds(80, 110, 200, 30);
	ok2.setBounds(450, 200, 100, 30);
	
	frame.add(l1);
	frame.add(l2);
	frame.add(ok2);
	
	frame.setSize(800, 400);
	frame.setLayout(null);
	frame.setVisible(true);
	

	ok2.addActionListener(new ActionListener(){ 
		public void actionPerformed(ActionEvent e){ 
			new bank();
			frame.dispose();
		}
	});
	
	
}
}
