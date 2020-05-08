package swingStudent;

import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class jdbcSwing extends JFrame implements ActionListener{
	JTextField uname;
	JPasswordField pass;
	JLabel resp;
	Connection con;
	jdbcSwing() throws ClassNotFoundException, SQLException{
		super("Login");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root", "root");
		Class.forName("com.mysql.jdbc.Driver");
		add(new JLabel("Username"));
		uname = new JTextField(20);
		add(uname);
		
		add(new JLabel("Password"));
		pass = new JPasswordField(20);
		add(pass);
		
		JButton login = new JButton("Login");
		add(login);
		
		login.addActionListener(this);
		
		resp=new JLabel("");
		add(resp);
		
		setVisible(true);
		setSize(320,150);
		setLayout(new FlowLayout());
	}
	
	public void actionPerformed(ActionEvent e) {
		
		try {
			String user = uname.getText();
			String pkey = pass.getText();
			int flag=0;
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select * from logins;");
			while(res.next() && flag==0) {
				if (res.getString(1).equals(user) && res.getString(2).equals(pkey))
				{
					flag=1;
					resp.setText("Login Successful");
				}
			}
			if (flag==0)
				resp.setText("Login Unsuccessful");
		} catch (SQLException e1) {
			e1.printStackTrace();
			resp.setText("Can't Connect");
		}
	}
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		jdbcSwing UI = new jdbcSwing();
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.HOUR+":"+c.MINUTE+":"+c.SECOND+":"+c.MILLISECOND);
	}

}
