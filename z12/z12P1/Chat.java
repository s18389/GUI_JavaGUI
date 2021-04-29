package z12P1;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import  javax.swing.*;

class ChatMain extends JFrame{
    
	ChatMain(){
      
     
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         setContentPane(new Chat()); 
         pack();
         setLocationRelativeTo(null);         
         setSize(600,550);        
         setVisible(true);
         revalidate();
         repaint();
          
    }
    
}

class Chat extends JPanel implements ActionListener{
 
	TextArea t_area;
	TextArea t_area2;
	TextField field1;
	TextField field2;
	JButton send;
	JButton send2;

	Chat(){
       setLayout(new BorderLayout());
       JPanel left = new JPanel();
       JPanel right = new JPanel();
       JPanel bottom = new JPanel();
       
     
       t_area = new TextArea("", 50 , 50 , TextArea.SCROLLBARS_VERTICAL_ONLY);       
       JScrollPane t_scroll = new JScrollPane(t_area);
//       t_scroll.setBounds(0, 0, 300, 300);
   //    t_area.setBackground(Color.RED);
       left.add(t_area);
       
       t_area2 = new TextArea("", 50 , 50 , TextArea.SCROLLBARS_VERTICAL_ONLY);  
       JScrollPane t_scroll2 = new JScrollPane(t_area2);
//       t_scroll2.setBounds(300, 0, 300, 300);
 //      t_area2.setBackground(Color.BLUE);
       right.add(t_area2);
       

      field1 = new TextField();
      bottom.add(field1);
      send = new JButton("Send");
      send.setSize(40, 20);
      bottom.add(send);
      send.addActionListener(this);
      field1.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
              if(e.getKeyCode() == KeyEvent.VK_ENTER){
            	  String text_content = "";
       			String message = "";
       		
  			 if (field1.getText().equals("") == false)
  	        	{
  				 	text_content = field1.getText();
  	        		message = "Juliet: " + text_content;
  	        		t_area.append(message + "\n");
  	        		t_area2.append(message + "\n");
  	        	     
  	            }
              }
          }
      });
      
      field2 = new TextField();
      bottom.add(field2);
      send2 = new JButton("Send");
      send2.addActionListener(this);
      send2.setSize(40, 20);
      bottom.add(send2);
      field2.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
              if(e.getKeyCode() == KeyEvent.VK_ENTER){
     			 String text_content = "";
      			String message = "";
      		
 			 if (field2.getText().equals("") == false)
 	        	{
 				 	text_content = field2.getText();
 	        		message = "Romeo: " + text_content;
 	        		t_area.append(message + "\n");
 	        		t_area2.append(message + "\n");
 	        	     
 	        
 	            }
              }
          }
      });
      
      left.setLayout(new GridLayout(1,1));
      right.setLayout(new GridLayout(1,1));
      bottom.setLayout(new GridLayout(1,4));

        
       add(left,BorderLayout.WEST);
       add(right,BorderLayout.EAST);
       add(bottom, BorderLayout.SOUTH);
 }

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Object source = actionEvent.getSource();
		
		 if(source == send) 
		 {
			 String text_content = "";
     			String message = "";
     		
			 if (field1.getText().equals("") == false)
	        	{
				 	text_content = field1.getText();
	        		message = "Juliet: " + text_content;
	        		t_area.append(message + "\n");
	        		t_area2.append(message + "\n");
	        	     
	            }
		 }
		 
		 if(source == send2) 
		 {
			 String text_content = "";
     			String message = "";
     		
			 if (field2.getText().equals("") == false)
	        	{
				 	text_content = field2.getText();
	        		message = "Romeo: " + text_content;
	        		t_area.append(message + "\n");
	        		t_area2.append(message + "\n");
	        	     
	        
	            }
		 }
		 
	       
	        	
	}
}
