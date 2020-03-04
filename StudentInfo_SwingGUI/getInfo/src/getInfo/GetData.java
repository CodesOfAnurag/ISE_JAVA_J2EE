import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class UI {
	private static Component add;
	
	Customer cTemp;

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
		
		HashMap<Integer, Customer> hpno = new HashMap<Integer, Customer>();
		hpno.put(123456, new Customer(101, 123456, "Anurag"));
		hpno.put(987654, new Customer(102, 987654, "Anupam"));
		
		JFrame inputCustomer = new JFrame("Customer");
		
		JPanel cPane = new JPanel();
		cPane.setLayout(new GridLayout(2,2));
		
		JTextField phone;

		phone = new JTextField(15);
		
		cPane.add(new JLabel("Customer Phone"));
		cPane.add(phone);
		
		JPanel btnPane = new JPanel();
		//btnPane.setLayout(new GridLayout(3,1));
		
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
		
		JTextArea customerInfo = new JTextArea(150,150);
		customerInfo.setEnabled(false);
		inputCustomer.add(customerInfo);
		
		
		addB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (hpno.keySet().contains(Integer.parseInt(phone.getText())))
					JOptionPane.showMessageDialog(null, "Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID", "Customer ID", JOptionPane.INFORMATION_MESSAGE));
					String name = JOptionPane.showInputDialog(null, "Enter Name", "Customer Name", JOptionPane.INFORMATION_MESSAGE);
					Customer cTemp = new Customer(id, Integer.parseInt(phone.getText()), name);
					hpno.put(cTemp.phone, cTemp);
					System.out.println(cTemp);
					phone.setEnabled(false);
					addB.setEnabled(false);
					findB.setEnabled(false);
					itemB.setEnabled(true);
					customerInfo.setText("Customer Selected\n"+cTemp);
				}
			}
		});
		
		findB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (hpno.keySet().contains(Integer.parseInt(phone.getText()))) {
					JOptionPane.showMessageDialog(null, "Customer Found", "Detail Exists", JOptionPane.INFORMATION_MESSAGE);
					Customer cTemp = hpno.get(Integer.parseInt(phone.getText()));
					phone.setEnabled(false);
					addB.setEnabled(false);
					findB.setEnabled(false);
					itemB.setEnabled(true);
					customerInfo.setText("Customer Selected\n"+cTemp);
				}
				else {
					JOptionPane.showMessageDialog(null, "Customer Doesn't Exists", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
}
