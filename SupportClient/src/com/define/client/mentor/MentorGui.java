package com.define.client.mentor;

import java.awt.*;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

//import javafx.scene.text.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class MentorGui extends JFrame {

	private static final long serialVersionUID = 1L;
	TopPanel toppanel;
	BottomPanel bottompanel;
	
	
	
	//Storing the width and height 
	
	static int HEIGHT;
	static int WIDTH;
	
	// adding panels 
	JLabel MENTOR_RECIPT;
	
	
	
	
	public MentorGui(String title)
	{
		// this.setBackground(Color.WHITE);
		this.setTitle(title);
		this.addWindowSize();
		
		this.addPanels();
	}
	
	
	class TopPanel extends JPanel
	{
		
		private static final long serialVersionUID = 1L;

		
		JLabel LOGIN_ID,PASSWORD,PERSONAL,CONFIRM_PASS,NAME,AGE,DEPARTMENT;
		
		JTextField login,password,confirm_password,name,age,deprtment;
		TopPanel()
		{
			this.setBounds(0, 0, MentorGui.WIDTH, MentorGui.HEIGHT/2);
			this.setLayout(null);
			this.setBackground(Color.WHITE);
			
			this.addComp();
		}
		void addComp()
		{
			// adding compnents 
			LOGIN_ID=new JLabel("LOGIN-ID");
			
			PASSWORD=new JLabel("PASSWORD");
			PERSONAL=new JLabel("PERSONAL DETAILS");
			CONFIRM_PASS=new JLabel("CONFIRM_PASS");
			NAME =new JLabel("NAME");
			AGE=new JLabel("AGE");
			DEPARTMENT=new JLabel("DEPARTMENT");
			 login=new JTextField();
			 password=new JTextField();
			 confirm_password=new JTextField();
			 name=new JTextField();
			 age=new JTextField();
			 deprtment=new JTextField();
			
			
			this.configComp();
			
			//this.add(MENTOR_RECIPT);
			
		}
		void configComp()
		{
			// MentorReciept
			//MENTOR_RECIPT.setBounds(600, 60, 150, 20);
			MENTOR_RECIPT=new JLabel("NEW MENTOR RECIPT");
			MENTOR_RECIPT.setFont(new Font("Courier New", Font.BOLD, 40));
			MENTOR_RECIPT.setBounds(500, 0, 500, 40);
			//MENTOR_RECIPT.setAlignmentX(CENTER_ALIGNMENT);
			this.add(MENTOR_RECIPT);
			
			JPanel j1=new JPanel();
			JPanel j2=new JPanel();
			JPanel j3=new JPanel();
			JPanel j4=new JPanel();
			
			j1.setBounds(0, 0, MentorGui.WIDTH/4, MentorGui.HEIGHT/2);
			j1.setBackground(Color.WHITE);
			j1.setLayout(null);
			this.add(j1);
			
			j3.setBounds(MentorGui.WIDTH/4, 0, MentorGui.WIDTH/4, MentorGui.HEIGHT/2);
			j3.setBackground(Color.WHITE);
			j3.setLayout(null);
			this.add(j3);
			
			//
			j2.setBounds(MentorGui.WIDTH/4, 0, MentorGui.WIDTH/2, MentorGui.HEIGHT);
			j2.setBackground(Color.WHITE);
			j2.setLayout(null);
			this.add(j2);
			
			j4.setBounds(MentorGui.WIDTH*3/4, 0, MentorGui.WIDTH/2, MentorGui.HEIGHT/2);
			j4.setBackground(Color.WHITE);
			j4.setLayout(null);
			this.add(j4);
			
			this.addLbl1(j1);
			this.addLbl2(j3);
			this.addLbl3(j2);
			this.addLbl4(j4);
		}
		
		void addLbl1(JPanel j1)
		{
			LOGIN_ID.setBounds(280,140,70,20);
			j1.add(LOGIN_ID);
			PASSWORD.setBounds(280,190,70,20);
			j1.add(PASSWORD);
			CONFIRM_PASS.setBounds(280, 240, 100, 20);
			j1.add(CONFIRM_PASS);
		}
		
		void addLbl2(JPanel j3)
		{
			login.setBounds(130,140,80,20);
			j3.add(login);
			password.setBounds(130, 190, 80, 20);
			j3.add(password);
			confirm_password.setBounds(130, 240, 80, 20);
			j3.add(confirm_password);
		}
		void addLbl3(JPanel j2)
		{
			PERSONAL.setBounds(480,70,270,20);
			PERSONAL.setFont(new Font("Courier New", Font.BOLD, 20));
			j2.add(PERSONAL);
			NAME.setBounds(500,140,50,20);
			j2.add(NAME);
			AGE.setBounds(500, 190, 50, 20);
			j2.add(AGE);
			DEPARTMENT.setBounds(500, 240, 100, 20);
			j2.add(DEPARTMENT);
		}
		void addLbl4(JPanel j4)
		{
			name.setBounds(70,140,80,20);
			j4.add(name);
			age.setBounds(70,190,80,20);
			j4.add(age);
			deprtment.setBounds(70,240,80,20);
			j4.add(deprtment);
		}
	}
	
	
	//Bottom panel for table with read-only feature 
	class BottomPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		
		JButton btn1,btn2;
		void initPanel()
		{

			this.setBounds(MentorGui.WIDTH/2, MentorGui.HEIGHT/2, 200,300);
			
			this.setLayout(null);
			
			
		}
		
			
			
			 BottomPanel() {
				 this.setBackground(Color.LIGHT_GRAY);
				 JScrollPane jsp;
				 JTable table;
				this.setLayout(null);
				this.initPanel();
				
				
				table = new JTable();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
			
				jsp = new JScrollPane(table);
				
				this.add(jsp);
				jsp.setBounds(0, MentorGui.HEIGHT/2, MentorGui.WIDTH, (MentorGui.HEIGHT/2)-70);
				model.addColumn("Login-Id");
				model.addColumn("Password");
				model.addColumn("Name");
				
				
				model.fireTableStructureChanged();
				model.fireTableDataChanged();
				}
		}
		
	
	
	
	void addPanels()
	{
		
		this.toppanel=this.new TopPanel();
		this.bottompanel=this.new BottomPanel();
		
		this.add(toppanel);
		this.add(bottompanel);
	}
	
	
	void addWindowSize()
	{
		// set Visible on
				this.setVisible(true);
				
				// set bounds
				Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
				MentorGui.HEIGHT= screenSize.height;
				MentorGui.WIDTH=screenSize.width;
				this.setSize(screenSize.width, screenSize.height);
				this.setExtendedState(MAXIMIZED_BOTH);
				
	}

}
