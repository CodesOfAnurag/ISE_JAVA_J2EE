package swingStudent;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class app {
	public static void main(String args[]) {
		JFrame frm = new JFrame("Student DataBase");
		JTextArea info = new JTextArea();
		UI entryPane =new UI(info);
		
		info.setEnabled(false);
		
		frm.add(entryPane);
		frm.add(info);
				
		frm.setVisible(true);
		frm.setLayout(new GridLayout(1,2));
		frm.setSize(640,480);
	}
}
