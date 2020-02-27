package getInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class GetDataAlternate extends JFrame{
	
	JButton calc, disp;
	JTextArea databaseEntry;
	ArrayList<JTextField> info = new ArrayList<JTextField>();
	ArrayList<JTextField> sgpa = new ArrayList<JTextField>();
	ArrayList<Student> details = new ArrayList<Student>();
	GetDataAlternate(){
		
		super("CGPA Calculator");
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy=0;
		String[] infoLabel = {"Name", "Age", "Gender", "USN", "Address"};
		for(int i=0; i<infoLabel.length; i++ ){
			info.add(new JTextField(20));
			c.gridx = 0;
			add(new JLabel(infoLabel[i]),c);
			c.gridx = 1;
			add(info.get(i),c);
			c.gridy++;
		}
		
		String label;
		for(int i=0; i<8; i++){
			label="SGPA Semester "+(i+1);
			c.gridx = 0;
			add(new JLabel(label),c);
			c.gridx = 1;
			sgpa.add(new JTextField(20));
			add(sgpa.get(i),c);
			c.gridy++;
		}
		
		calc = new JButton("Calculate CGPA");
		c.gridx=0;
		add(calc,c);
		
		disp = new JButton("Display");
		c.gridx=1;
		add(disp,c);
		
		c.gridy++;
		c.gridx=0;
		c.gridwidth = 2;
		c.ipady = 100;
		databaseEntry = new JTextArea();//200,400);
		add(databaseEntry,c);
		
		calc.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) {
					ArrayList<String> studentArg = new ArrayList<String>();
					try {
						for (JTextField x : info) {
							if (!x.getText().equals(""))
								studentArg.add(x.getText());
							else
								throw new NullPointerException();
						}
						Double cgpa = 0.0, count = 0.0;
						for (JTextField x : sgpa) {
							if (!x.getText().equals("")) {
								cgpa+=Double.parseDouble(x.getText());
								count++;
							}
						}
						cgpa/=count;
						studentArg.add(""+cgpa);
						Student std = new Student(studentArg.get(0), studentArg.get(1), studentArg.get(2), studentArg.get(3), studentArg.get(4), studentArg.get(5));
						details.add(std);
						databaseEntry.setText(databaseEntry.getText()+std);
						JOptionPane.showMessageDialog(null, "Added: "+std, "Added to database", JOptionPane.INFORMATION_MESSAGE);
					}
					catch (NullPointerException e){
						System.out.println(e);
						JOptionPane.showMessageDialog(null, "Please provide all Student information", "Error",JOptionPane.ERROR_MESSAGE);
					}
					catch (ArithmeticException e) {
						System.out.println(e);
						JOptionPane.showMessageDialog(null, "Can't Calculate CGPA, no SGPA provided", "Error",JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		);
		
		
		disp.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt){
					String s = "";
					for (Student x : details)
						s+=x;
					System.out.println(s);
					if (!s.equals(""))
						JOptionPane.showMessageDialog(null, s+"\nTotal Records: "+details.size(), "Records", JOptionPane.PLAIN_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "No Record Entered", "Records", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		);		
	}
	
	public static void main(String args[]){
		GetDataAlternate gd = new GetDataAlternate();
		gd.setVisible(true);
		gd.setSize(480,480);
	}
	
}
