/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.define.client.admin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/*
 *
 * @author ASUS
 */
public class BroadCastWin extends JFrame {
    
    final static int WIDTH=660;
    final static int HEIGHT=560;
    private JLabel lbl_broadcast;
    private JTextField txt_b;
    private JButton btn_upld,btn_remove; 
    private JTable tbl_msg;
    private JScrollPane scrpane_tbl;

    public BroadCastWin(String title){
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
         this.setLayout(null);
        this.lbl_broadcast=new JLabel("BroadCast");
        this.txt_b=new JTextField();
        this.btn_upld=new JButton("Upload");
        this.btn_remove=new JButton("Remove");
        this.tbl_msg=new JTable();
        this.scrpane_tbl=new JScrollPane();
        this.lbl_broadcast.setFont(new Font("Times New Roman",20,20));
        this.tbl_msg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        this.tbl_msg.setColumnSelectionAllowed(true);
        this.tbl_msg.setShowHorizontalLines(false);
        this.tbl_msg.setShowVerticalLines(false);
        this.tbl_msg.getTableHeader().setReorderingAllowed(false);
        this.scrpane_tbl.setViewportView(this.tbl_msg);
        
        this.tbl_msg.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (this.tbl_msg.getColumnModel().getColumnCount() > 0) {
            this.tbl_msg.getColumnModel().getColumn(0).setResizable(false);
            this.tbl_msg.getColumnModel().getColumn(1).setResizable(false);
            
        }
      
        this.design();
        this.handleEvent();
        this.setIntialState(title);
    }

    private void handleEvent() {
         this.btn_upld.addActionListener(new ActionListener(){
            double num1,num2,res;
            @Override
            public void actionPerformed(ActionEvent e) {
               
               }
            }
         );
         this.btn_upld.addActionListener(new ActionListener(){
            double num1,num2,res;
            @Override
            public void actionPerformed(ActionEvent e) {
               
               }
            }
         );
    }

    private void setIntialState(String title) {
         Toolkit tool=Toolkit.getDefaultToolkit();
        Dimension size= tool.getScreenSize();
        this.setBounds(size.width/2-WIDTH/2,size.height/2-HEIGHT/2,WIDTH,HEIGHT);   
        this.setResizable(false);
        this.setTitle(title);
    
    }

    private void design() {
        this.setPos(this.lbl_broadcast,50,10,100,30);
        this.setPos(this.txt_b,50,50,400,30);
        this.setPos(this.btn_upld,450,100,80,30);
        this.setPos(this.scrpane_tbl,50,150,400,200);
        this.setPos(this.btn_remove,450,450,80,30);
        
    }
    private void setPos(Component component,int x,int y,int width,int height){
        
        this.add(component);
        component.setBounds(x, y, width, height);
    }

}
