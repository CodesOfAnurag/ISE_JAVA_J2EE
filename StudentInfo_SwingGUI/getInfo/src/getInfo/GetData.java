package getInfo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class GetData extends JFrame{
	
	JButton calc, disp;
	JTextArea databaseEntry;
	ArrayList<JTextField> info = new ArrayList<JTextField>();
	ArrayList<JTextField> sgpa = new ArrayList<JTextField>();
	ArrayList<Student> details = new ArrayList<Student>();
	GetData(){
		
		super("CGPA Calculator");
		
		String[] infoLabel = {"Name", "Age", "Gender", "USN", "Address"};
		for(int i=0; i<infoLabel.length; i++ ){
			info.add(new JTextField());
			add(new JLabel(infoLabel[i]));
			add(info.get(i));
		}
		
		String label;
		for(int i=0; i<8; i++){
			label="SGPA Semester "+(i+1);
			add(new JLabel(label));
			sgpa.add(new JTextField());
			add(sgpa.get(i));
		}
		
		calc = new JButton("Calculate CGPA");
		add(calc);
		
		disp = new JButton("Display");
		add(disp);
		
		databaseEntry = new JTextArea();
		add(databaseEntry);
		
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
						databaseEntry.setText("Student Added: "+std+"CGPA: "+std.cgpa);
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
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid Data", "Error",JOptionPane.ERROR_MESSAGE);
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
					databaseEntry.setText(s+"Total Records: "+details.size());
					if (!s.equals(""))
						JOptionPane.showMessageDialog(null, s+"\nTotal Records: "+details.size(), "Records", JOptionPane.PLAIN_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "No Record Entered", "Records", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		);		
	}
	
	public static void main(String args[]){
		GetData gd = new GetData();
		gd.setVisible(true);
		gd.setSize(480,480);
		gd.setLayout(new GridLayout(16,2));
	}
	
}
