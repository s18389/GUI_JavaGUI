package z08P1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SecondMain extends JFrame{
    
    SecondMain(){
      
     
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         setContentPane(new Second()); 
         pack();
         setLocationRelativeTo(null);         
         setSize(600,200);        
         setVisible(true);
         revalidate();
         repaint();
         setResizable(false);
    }
    
}

class Second extends JPanel{
 
Second(){
      setLayout(new BorderLayout());
       JPanel top_left = new JPanel();
       JPanel center = new JPanel();
       JPanel top_right = new JPanel();
       JPanel bottom = new JPanel();
         
       TextArea text1 = new TextArea("TextArea1", 9 , 22 , TextArea.SCROLLBARS_NONE);         
       TextArea text2 = new TextArea("TextArea2", 9 , 22 , TextArea.SCROLLBARS_NONE);
       TextField field = new TextField("TextField4");
       top_left.add(text1);
       top_right.add(text2);
       
       center.setLayout(new GridLayout(4,3));
       
       int d = 1;
       for(int i = 0; i<3; i++){
           for(int k = 0; k<4; k++){
               center.add(new JButton ("B"+d )); 
            d++;
           }
           
       }
       bottom.setLayout(new GridLayout(1,1));
       bottom.add(field);
       
       add(top_left,BorderLayout.WEST);
       add(center,BorderLayout.CENTER);
       add(top_right,BorderLayout.EAST);
       add(bottom,BorderLayout.SOUTH);
 }

}
