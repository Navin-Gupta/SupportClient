package com.define.client.home;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import com.define.client.resources.CommonResource;
import com.define.client.resources.RequestCodes;
import com.define.client.resources.Student;

public class LoginWindow extends JFrame implements ActionListener{
	
	final static int WIDTH = 400;
	final static int HEIGHT = 200 ;
	
	JButton login,newreg;
	JLabel username,password;
	JRadioButton adminrb,mentorrb,studentrb;
	TextField user;
	JPasswordField pass;
	
	public LoginWindow(){
		
		
		//Buttons
		this.login = new JButton("Login");
		this.newreg = new JButton("New Registration");
		
		//Labels
		this.username = new JLabel("Enter Username");
		this.password = new JLabel("Enter Password ");
		
		//Radio Button
		this.adminrb = new JRadioButton("Admin");
		this.mentorrb = new JRadioButton("Mentor");
		this.studentrb = new JRadioButton("Student");
		
		//Text Field
		
		this.user = new TextField(20);
		this.pass= new JPasswordField();
		//String str1= this.user.getText();
		//String str2= this.pass.getText();
		this.pass.setEchoChar('*');
		
		
		// Default Operation of Window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(null);
		
		//designong the window
		this.design();
		
		// To Set Initial State of window
		this.setInitState();
		
		this.registerEvents();
	}
	private void setInitState(){
		this.setVisible(true);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension size = toolkit.getScreenSize();
		this.setBounds((size.width/2) - (WIDTH/2), (size.height/2) - (HEIGHT/2),WIDTH,HEIGHT);
		this.setResizable(false);
		
		this.setTitle("Login: Chat Master!!");
		
	}
	
	private void registerEvents() {
		this.login.addActionListener(this);
	}
	
	private void design(){
		this.commonActivity(this.login,240,130,70,20);
		this.commonActivity(this.newreg,50,130,150,20);
		this.commonActivity(this.username,30,60,100,20);
		this.commonActivity(this.password,30,100,100,20);
		this.commonActivity(this.adminrb,40,20,70,20);
		this.commonActivity(this.mentorrb,130,20,70,20);
		this.commonActivity(this.studentrb,220,20,70,20);
		this.commonActivity(this.user,140,60,160,20);
		this.commonActivity(this.pass,140,100,160,20);
		
	}

	private void commonActivity(Component comp, int x, int y, int width, int height) {
		// common task for layout
		
		// 1. Add component to container
		this.add(comp);
		
		// 2. set position and size
		comp.setBounds(x, y, width, height);
				
	}
	/*private void groupButton(){
		ButtonGroup bg = new ButtonGroup();
		bg.add(this.adminrb);
		bg.add(this.mentorrb);
		bg.add(this.studentrb);
		
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// validate the entry data
		String loginId = this.user.getText().trim();
		String password = new String(this.pass.getPassword()).trim();
		// fetch type of user
		// String type="";
		
		
		if(loginId.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(this, "Login Credentials not provided!!!", "Login", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(CommonResource.client.getOutputStream());
			out.writeObject(RequestCodes.LOGIN);
			out.writeObject(loginId);
			out.writeObject(password);
			// out.writeObject(type);
			
			// prepare to recv response
			ObjectInputStream in = new ObjectInputStream(CommonResource.client.getInputStream());
			String resp =  in.readObject().toString();
			if(resp.equals("Success")) {
				CommonResource.type = in.readObject().toString();
				if(CommonResource.type.equals("Student")) {
					CommonResource.student =  (Student)in.readObject();
					// student related activity 
				}
				
				// initiate a client side thread
				
			}else {
				
			}
			
		}catch(Exception ex) {
			CommonResource.handleException(ex, "Problem while login!!!");
		}
		
	}
	
}