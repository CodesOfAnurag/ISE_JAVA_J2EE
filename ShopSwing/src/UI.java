import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class UI {
	private static Component add;
	
	Customer cTemp;
	static HashMap<String, String> hm;
	static HashMap<Integer, Customer> hpno;
	static HashMap<Integer, Item> hitm;

	public static void main(String args[]){
	
		// login users
		hm =new HashMap<String, String>();
		hm.put("admin", "admin");
		hm.put("shop", "shop");
		
		int i=0;
		
		String login = JOptionPane.showInputDialog(null, "Enter LoginID");
		if (login==null)
			System.exit(0);
		for(i=0; !hm.keySet().contains(login) && i<2 ;i++) {
			login = JOptionPane.showInputDialog(null, "Enter correct LoginID", "", JOptionPane.WARNING_MESSAGE);
			if (login==null)
				System.exit(0);
		}
		if (i==3){
			JOptionPane.showMessageDialog(null, "Exceeded maximum attempts","Bye", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
			
		
		String pass = JOptionPane.showInputDialog(null, "Enter Password");
		if (pass==null)
			System.exit(0);
		for(i=0; !hm.get(login).equals(pass) && i<2;i++) {
			pass = JOptionPane.showInputDialog(null, "Enter correct Password", "", JOptionPane.WARNING_MESSAGE);
			if (pass==null)
				System.exit(0);
		}
			
		if (i==3){
			JOptionPane.showMessageDialog(null, "Exceeded maximum attempts","Bye", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		JOptionPane.showMessageDialog(null, "Successful Login", "Success", JOptionPane.INFORMATION_MESSAGE);
		
		hpno = new HashMap<Integer, Customer>();
		hpno.put(123456, new Customer(101, 123456, "Anurag"));
		hpno.put(987654, new Customer(102, 987654, "Anupam"));
		
		hitm = new HashMap<Integer, Item>();
		hitm.put(101, new Item(101, 100, "RedBull"));
		hitm.put(201, new Item(201, 50, "Pepsi"));
		hitm.put(301, new Item(301, 20, "Maaza"));
		hitm.put(401, new Item(401, 35, "Coke"));
		
		JFrame inputCustomer = new JFrame("Customer");
		JFrame items = new JFrame("items");
		
		JPanel cPane = new JPanel();
		cPane.setLayout(new GridLayout(2,2));
		
		JTextField phone;

		phone = new JTextField(15);
		
		cPane.add(new JLabel("Customer Phone"));
		cPane.add(phone);
		
		JPanel btnPane = new JPanel();

		
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
		
		JTextArea customerInfo = new JTextArea(150,150);
		customerInfo.setEnabled(false);
		inputCustomer.add(customerInfo);
		
		inputCustomer.setVisible(true);
		inputCustomer.setSize(320, 320);
		inputCustomer.setLayout(new GridLayout(4,1));
		
		JPanel iPane = new JPanel();
		iPane.setLayout(new GridLayout(2,2));
		
		
		JComboBox<Integer> itemID = new JComboBox<Integer>();
		for (int x : hitm.keySet())
			itemID.addItem(x);
		
		iPane.add(new JLabel("Item ID"));
		iPane.add(itemID);
		items.add(iPane);
		
		JPanel iPane2 = new JPanel();
		JTextField qty = new JTextField(20);
		iPane2.setLayout(new GridLayout(2,2));
		iPane2.add(new JLabel("Qauntity"));
		iPane2.add(qty);
		items.add(iPane2);
		
		JPanel btnPane2 = new JPanel();
		JButton calc = new JButton("Bill");
		btnPane2.add(calc);
		JButton disc = new JButton("Discount");
		btnPane2.add(disc);
		
		items.add(btnPane2);
		
		JTextArea itemInfo = new JTextArea(150,150);
		itemInfo.setEnabled(false);
		items.add(itemInfo);
		
		items.setVisible(false);
		items.setSize(350, 350);
		items.setLayout(new GridLayout(4,1));
		
		double[] discount = {1.00};
		
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
		
		itemB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inputCustomer.setVisible(false);
				items.setVisible(true);
			}
		});
		
		calc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Item iTemp = hitm.get(itemID.getSelectedItem());
				itemInfo.setText(iTemp+"\nQuantity: "+(qty.getText())+"\nTotal: "+(Integer.parseInt(qty.getText())*iTemp.cost*discount[0]));
			}
		});
		
		disc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] discounts = {"10%", "20%", "30%"};
				int d = JOptionPane.showOptionDialog(null, "Select Discount", "Discount", 0, JOptionPane.INFORMATION_MESSAGE, null, discounts, discounts[0]);
				switch(d) {
					case 0:
						discount[0] = 0.9;
						break;
					case 1:
						discount[0] = 0.8;
						break;
					case 2:
						discount[0] = 0.7;
						break;
				}
				System.out.println(discount[0]);
			}
		});
	}
}
