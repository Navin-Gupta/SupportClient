
package com.define.client.home;
import javax.swing.*;

import com.define.client.resources.CommonResource;

import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.Socket;

import static com.define.client.resources.CommonResource.handleException;

public class IpAddress extends JFrame implements ActionListener{
	/*JButton btnConnect;
	JTextField txtIP;
    JLabel lblIP;*/
	
	JButton jbtn;
	JTextField jtxt;
    JLabel jlbl;
	
    public IpAddress() {
	
		this.setLayout(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		this.jbtn = new JButton("CONNECT");
		this.jlbl = new JLabel("Enter IP Address");
		this.jtxt = new JTextField();
		
                
                
                this.add(jbtn);
                this.add(jlbl);
                this.add(jtxt);
        
	
                    jlbl.setBounds(30,20,100,20);
                    jtxt.setBounds(30,60,150,20);
                    jbtn.setBounds(150,100,100,20);
                    
                    
                   // this.jbtn.addActionListener();
       this.jbtn.addActionListener(this);             
                
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(this.jtxt.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Server IP not provided!!!", "IP Address", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		try {
			InetAddress inet = InetAddress.getByName(this.jtxt.getText().trim());
			CommonResource.client = new Socket(inet, 2244);
			JOptionPane.showMessageDialog(this, "Connected to server..", "IP Address", JOptionPane.INFORMATION_MESSAGE);
			
			// show Login window
			LoginWindow login = new LoginWindow();
			this.dispose();
			
			
		}catch(Exception ex) {
			handleException(ex, "Problem while connecting to server!!!");
		}
	}
}
   

   


		
	

        
