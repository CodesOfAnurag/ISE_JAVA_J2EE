import javax.swing.*;

import java.awt.*;
import java.util.*;
public class UI {
	private static Component add;

	public static void main(String args[]){
/*		
		// login users
		HashMap<String, String> hm =new HashMap<String, String>();
		hm.put("ADMIN", "admin");
		hm.put("SHOP", "shop");
		
		int i=0;
		
		String login = JOptionPane.showInputDialog(null, "Enter LoginID");
		for(i=0; !hm.keySet().contains(login) && i<2 ;i++)
			login = JOptionPane.showInputDialog(null, "Enter correct LoginID", "", JOptionPane.WARNING_MESSAGE);
		if (i==3){
			JOptionPane.showMessageDialog(null, "Exceeded maximum attempts","Bye", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
			
		
		String pass = JOptionPane.showInputDialog(null, "Enter Password");
		for(i=0; !hm.get(login).equals(pass) && i<2;i++)
			pass = JOptionPane.showInputDialog(null, "Enter correct Password", "", JOptionPane.WARNING_MESSAGE);
		if (i==3){
			JOptionPane.showMessageDialog(null, "Exceeded maximum attempts","Bye", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		JOptionPane.showMessageDialog(null, "Successful Login", "Success", JOptionPane.INFORMATION_MESSAGE);
*/
		JFrame inputCustomer = new JFrame("Customer");
		
		JPanel cPane = new JPanel();
		cPane.setLayout(new GridLayout(2,2));
		
		JTextField id, name, phone;
//		id = new JTextField();
//		name = new JTextField();
		phone = new JTextField();
		
//		cPane.add(new JLabel("Customer Id"));
//		cPane.add(id);
//		cPane.add(new JLabel("Customer Name"));
//		cPane.add(name);
		cPane.add(new JLabel("Customer Phone"));
		cPane.add(phone);
		
		JPanel btnPane = new JPanel();
		btnPane.setLayout(new GridLayout(3,1));
		
		JButton addB, findB, itemB;
		addB = new JButton("Add");
		findB = new JButton("Find");
		itemB = new JButton("Items");
		itemB.setEnabled(false);
		
		btnPane.add(addB);
		btnPane.add(findB);
		btnPane.add(itemB);
		
		inputCustomer.add(cPane);
		inputCustomer.add(btnPane);
		
		inputCustomer.setVisible(true);
		inputCustomer.setSize(320, 320);
		inputCustomer.setLayout(new GridLayout(4,1));
		ssss	
		
	}
}
