package tour;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class city {
	public static String s;
	city(){
		String[] city = new String[] {"--select--" ,"Goa", "Cochin","Delhi", "Kashmir"};
		JFrame frame = new JFrame("City");
		JLabel l1 = new JLabel("Select city");
		JComboBox<String> citylist = new JComboBox<>(city);
		JButton sign =new JButton("Select");
		
		l1.setBounds(40, 70, 200, 30);
		citylist.setBounds(130, 70, 150, 30);
		sign.setBounds(90, 150, 100, 30);
		
		frame.add(l1);
		frame.add(citylist);
		frame.add(sign);
		
		frame.setSize(350, 350);
		frame.setLayout(null);
		frame.setVisible(true);
		
		ActionListener al = new ActionListener() {
			
		@Override
			 public void actionPerformed(ActionEvent e) {
			
			  s = (String) citylist.getSelectedItem() ;
			
			switch (s) {//check for a match
            case "Goa":
            	new goa();
            	frame.dispose();
                break;
            case "Cochin":
            	new cochin();
            	frame.dispose();
                break;
            case "Delhi":
            	new delhi();
            	frame.dispose();
                break;
            case "Kashmir":
            	new kashmir();
            	frame.dispose();
            	break;
            case "--select--":
            	JOptionPane.showMessageDialog(null,"Select an option");
                break;
        }
		}
		};
		
		
		sign.addActionListener(al);
	}
	
}
