package z08P1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class FirstMain extends JFrame{
    FirstMain(){ 
        
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);         
       setContentPane(new First()); 
       pack();       
       setLocationRelativeTo(null);         
       revalidate();
       repaint();   
       setResizable(false);
       setVisible(true);
     }
}

class First extends JPanel{
  First(){
       setLayout(new BorderLayout());
        JPanel top = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
                  
        JTextField[] text = new JTextField[3];
        
        for (int i = 0; i < text.length; i++) { 
        	text[i]=new JTextField(11);
        	text[i].setText("JTextField no "+(i+1));
            top.add(text[i]);
        } 
        
        TextArea texta = new TextArea("TextArea1", 9 , 22 , TextArea.SCROLLBARS_NONE);
        top.setLayout(new GridLayout(3,1));      
        right.setLayout(new GridLayout(3,3));
        
        int d = 1;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
            	right.add(new JButton ("B0"+d )); 
             d++;
            }
        }
        left.add(texta);
        add(top,BorderLayout.NORTH);
        add(left,BorderLayout.WEST);
        add(right,BorderLayout.EAST);
        
  }
}
