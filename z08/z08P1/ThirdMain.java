package z08P1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ThirdMain extends JFrame{
    
    ThirdMain(){
      
     
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         setContentPane(new Third()); 
         pack();
         setLocationRelativeTo(null);         
         setSize(590,190);        
         setVisible(true);
         revalidate();
         repaint();
          
    }
    
}

class Third extends JPanel{
 
Third(){
       setLayout(new BorderLayout());
       JPanel top  = new JPanel();
       JPanel left = new JPanel();
       JPanel center = new JPanel();
       JPanel right = new JPanel();
    
       top.setLayout(new GridLayout(1,1));
       TextArea text = new TextArea("TextArea1", 3 , 10 , TextArea.SCROLLBARS_NONE);        
       
       top.add(text);
       
       left.setLayout(new GridLayout(2,2));
       right.setLayout(new GridLayout(2,2));
       JButton[] button = new JButton[8];
       for(int i = 0;i<button.length;i++)
       {
           button[i] = new JButton(String.format("B%02d",i+1));
           
           if(i< 4) left.add(button[i]);
           else right.add(button[i]);
       }
       TextField field1 = new TextField("TextField1");
       TextField field2 = new TextField("TextField2");
       TextField field3 = new TextField("TextField3");
       
       center.setLayout(new GridLayout(3,1));
       center.add(field1);
       center.add(field2);
       center.add(field3);
        
       add(top,BorderLayout.NORTH);
       add(left,BorderLayout.WEST);
       add(center,BorderLayout.CENTER);
       add(right,BorderLayout.EAST);
 }

}
