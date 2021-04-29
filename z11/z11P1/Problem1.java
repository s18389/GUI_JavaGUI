package z11P1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionListener;
import  javax.swing.*;


public class Problem1 extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menuFile, menuTools, menuHelp, menuOption;
    JMenuItem mOpen, mSave, mExit, mTool1, mTool2, aboutProgramm, mOption1, mOption2, mpCopy, mpPaste, mpAttach;
    JCheckBoxMenuItem chOption3;
    JTextArea t_area;
    JTextField t_text;
    JButton b_find, b_color_choose;
    JPopupMenu popup;
	private String text_content;

    public Problem1(){
        setTitle("Menu moje nie twoje a moje");
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        
        t_area = new JTextArea();
        JScrollPane t_scroll = new JScrollPane(t_area);
        t_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        t_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        t_scroll.setBounds(0, 0, 285, 280);
        add(t_scroll);
        t_area.setForeground(Color.RED);
        Font font = new Font("Courier", Font.BOLD,12);
        t_area.setFont(font); 
        
        t_text = new JTextField();
        t_text.setBounds(0, 280, 300, 30);
        add(t_text);
        t_text.addActionListener(this);
        t_text.setForeground(Color.BLUE);
        Font font2 = new Font("Courier", Font.ITALIC,12);
        t_text.setFont(font2); 
        
        
        b_find = new JButton("Find");
        b_find.setBounds(340, 460, 70, 20);
        //add(b_find);
        b_find.addActionListener(this);
        
        
       
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if(source == mExit) 
        {	int answer = JOptionPane.showConfirmDialog(null, "Are you suru want to exit?", "Question", JOptionPane.YES_NO_OPTION);
        	if (answer == JOptionPane.YES_OPTION || answer == JOptionPane.CLOSED_OPTION) dispose();}
       
        
        if(source == t_text)
        {
        	if (t_text.getText().equals("") == false)
        	{
        		text_content = t_text.getText();
        		String decidion = "";
        	     if(text_content.contains(" ")){
        	    	decidion = text_content.substring(0, text_content.indexOf(" ")); 
        	        if(decidion.equals("add")) 
        	        {
        	        	String name = text_content.substring(3);
        	        	int index;
        	        	int startIndex = 0;
        	        	if((index = t_area.getText().indexOf(name, startIndex)) != -1) {
        	        		text_content = "";
        	        		t_text.setText("add ");
        	        		JPanel panel = new JPanel();
        	        		JOptionPane.showMessageDialog(panel, "Entry \""+ name + "\" already exists", "WARNING",
        	        			        JOptionPane.WARNING_MESSAGE);
        	        	}
        	        	else 
        	        	{
        	        		t_text.setText("add ");
        	        		t_area.append(name +"\n");
        	        	}
        	        	
        	        }
        	        if(decidion.equals("del")) 
        	        {
        	        	String name = text_content.substring(3);
        	        	int index;
        	        	int startIndex = 0;
        	        	if((index = t_area.getText().indexOf(name, startIndex)) != -1) 
        	        	{
        	        		t_text.setText("del ");
        	        		t_area.setText( t_area.getText().replaceAll(name, "" ));
        	        	}
        	        	else 
        	        	{
        	        		JPanel panel = new JPanel();
        	        		JOptionPane.showMessageDialog(panel, "There is no such name","WARNING",
	        			        JOptionPane.WARNING_MESSAGE);
        	        		t_text.setText("del ");
        	        	}
        	        	
        	        }
        	     }
        	     if(text_content.equals("quit")) dispose();
            }
        }

        
        
//        if(source == b_find)
//        {
//        	String all_text = t_area.getText()
//        	String where_text = "";
//        	int i = 0;
//        	int index;
//        	int startIndex = 0;
//        	while((index = all_text.indexOf(find_text, startIndex)) != -1){
//        		startIndex = index + find_text.length();
//        		i++;
//        		where_text = where_text + index + ", ";
//        	}
//        	String final_text = '"' + find_text + '"';
//        	JOptionPane.showMessageDialog(null, final_text + " " + i + " times in index(es): " + where_text);
//        }
        
 //       if(source == mpAttach) t_area.append("\n" + choosen_text);
        
	
    }

    public static void main(String[] args){
        Problem1 apkMenu = new Problem1();
        apkMenu.setVisible(true);
    }




}
