package swingStudent;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI extends JPanel implements ActionListener{

	ArrayList<Student> StudentInfo = new ArrayList<Student>();
	ArrayList<JTextField> inputs = new ArrayList<JTextField>();
	ArrayList<JTextField> sgpa = new ArrayList<JTextField>();
	JTextArea info;
	JButton calc, disp;
	
	UI(JTextArea info) {
		this.info=info;
		String[] labels= {"Name", "USN", "Sex", "Age"};

		JTextField temp;
		for(String x: labels) {
			temp = new JTextField(20);
			add(new JLabel(x));
			add(temp);
			inputs.add(temp);
		}
		
		for(int i=1; i<=8; i++) {
			temp = new JTextField(20);
			add(new JLabel("SGPA Semester "+i));
			add(temp);
			sgpa.add(temp);
		}
		
		calc = new JButton("Calculate");
		disp = new JButton("Display");
		
		add(calc);
		add(disp);
		setLayout(new GridLayout(13,2));
		
		calc.addActionListener((ActionListener) this);
		disp.addActionListener((ActionListener) this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==calc)
		{
			try {
				ArrayList<String> text = new ArrayList<String>();
				for (JTextField jf : inputs) {
					String x = jf.getText();
					if (!x.isEmpty() || x != null)
						text.add(x);
				}
				Double cgpa = 0.0;
				int sem = 0;
				for (JTextField jf : sgpa) {
					String x = jf.getText();
					if (!x.equals("") && Double.parseDouble(x)<=10.0 && Double.parseDouble(x)>=0.0) {
						cgpa+=Double.parseDouble(x);
						sem+=1;
					}
					else 
						continue;
				}			
				if (sem!=0) {
					cgpa/=sem;
					Student S1= new Student(text.get(0), text.get(1), text.get(2), Integer.parseInt(text.get(3)), cgpa);
					StudentInfo.add(S1);
					info.setText("ADDED STUDENT\n"+S1);
				}
			}
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Invalid Data", "Error", JOptionPane.ERROR_MESSAGE);
			}
				
		}
		else {
			String s="";
			for(Student x : StudentInfo) {
				s+=x;
			}
			if (!s.equals(""))
				info.setText(s);
			else
				JOptionPane.showMessageDialog(null, "No Student in Database", "Error", JOptionPane.ERROR_MESSAGE);
		}
	
	}
}

