package z10P1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionListener;
import  javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Problem1 extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menuFile, menuTools, menuHelp, menuOption;
    JMenuItem mOpen, mSave, mExit, mTool1, mTool2, aboutProgramm, mOption1, mOption2, mpCopy, mpPaste, mpAttach;
    JCheckBoxMenuItem chOption3;
    JTextArea t_area;
    JTextField t_find;
    JButton b_find, b_color_choose,   b_select_file, b_exit;
    JPopupMenu popup;
    JComboBox color_combo;
    JLabel l_file;
	private String choosen_text;

    public Problem1(){
        setTitle("Menu moje nie twoje a moje");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
            mOpen = new JMenuItem("Open..", 'O');
            menuFile.add(mOpen);
            mOpen.addActionListener(this);
            mSave = new JMenuItem("Save");
            menuFile.add(mSave);
            mSave.addActionListener(this);
            mExit = new JMenuItem("Exit");
            menuFile.addSeparator();
            menuFile.add(mExit);
                mExit.addActionListener(this);
                mExit.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
        menuTools = new JMenu("Tools");
            mTool1 = new JMenuItem("Tool 1");
            menuTools.add(mTool1);
                mTool1.setEnabled(false);
            mTool2 = new JMenuItem("Cm to inch");
            menuTools.add(mTool2);
            mTool2.addActionListener(this);
            menuOption = new JMenu("Options");
                mOption1 = new JMenuItem("Option 1");
                menuOption.add(mOption1);
                mOption2 = new JMenuItem("Option 2");
                menuOption.add(mOption2);
                chOption3 = new JCheckBoxMenuItem("Option 3");
                menuOption.add(chOption3);
                    chOption3.addActionListener(this);
            menuTools.add(menuOption);
        menuHelp = new JMenu("Help");
            aboutProgramm = new JMenuItem("About program");
            menuHelp.add(aboutProgramm);
                aboutProgramm.addActionListener(this);

        setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuBar.add(menuTools);
        menuBar.add(menuHelp);
        
        t_area = new JTextArea();
        JScrollPane t_scroll = new JScrollPane(t_area);
        t_scroll.setBounds(20, 40, 700, 400);
        add(t_scroll);
        
        l_file = new JLabel();
        l_file.setBounds(300, 10, 200 , 20);
        add(l_file);
        
        t_find = new JTextField();
        t_find.setBounds(20, 460, 300, 20);
        add(t_find);
        
        b_find = new JButton("Find");
        b_find.setBounds(340, 460, 70, 20);
        add(b_find);
        b_find.addActionListener(this);
        
        b_select_file = new JButton("Select file");
        b_select_file.setBounds(340, 560, 100, 20);
        add(  b_select_file);
        b_select_file.addActionListener(this);
        
        b_exit = new JButton("Exit");
        b_exit.setBounds(445, 560, 65, 20);
        add(b_exit);
        b_exit.addActionListener(this);
        
        popup = new JPopupMenu();
        mpCopy = new JMenuItem("Copy");
        mpCopy.addActionListener(this);
        mpPaste = new JMenuItem("Paste");
        mpPaste.addActionListener(this);
        mpAttach = new JMenuItem("Attach");
        mpAttach.addActionListener(this);
        popup.add(mpCopy);
        popup.add(mpPaste);
        popup.add(mpAttach);
        t_area.setComponentPopupMenu(popup);
        
        color_combo = new JComboBox();
        color_combo.setBounds(20, 500, 300, 20);
        color_combo.addItem("Black");
        color_combo.addItem("Red");
        color_combo.addItem("Green");
        color_combo.addItem("Blue");
        add(color_combo);
        color_combo.addActionListener(this);
        
        b_color_choose = new JButton("Choose color");
        b_color_choose.setBounds(20, 540, 150, 20);
        add(b_color_choose);
        b_color_choose.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if(source == mExit || source == b_exit) 
        {	int answer = JOptionPane.showConfirmDialog(null, "Are you suru want to exit?", "Question", JOptionPane.YES_NO_OPTION);
        	if (answer == JOptionPane.YES_OPTION || answer == JOptionPane.CLOSED_OPTION) dispose();}
       
        if (source == chOption3)
        {	if (chOption3.isSelected()) mTool1.setEnabled(true);
            else if(chOption3.isSelected()==false) mTool1.setEnabled(false); }
       
        if(source == aboutProgramm)
        {	JOptionPane.showMessageDialog(this, "This program is fucking super \n and Stannis rules motherfuckers!", "Opis programu", JOptionPane.WARNING_MESSAGE);}
        
        if (source == mTool2) 
        {	String cm_s = JOptionPane.showInputDialog("Type lenght in cm");
        	double cm_d = Double.parseDouble(cm_s);
        	double inch_d = cm_d/2.54; 
        	String inch_s = String.format("%.2f", inch_d);
        	JOptionPane.showMessageDialog(null, cm_s + " cm = " + inch_s + " inches"); }
        
        if(source == mOpen || source == b_select_file)
        {	JFileChooser choose_file = new JFileChooser();
        	choose_file.setFileFilter(new FileNameExtensionFilter("txt file","txt"));
        	if ( choose_file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        		{File file = choose_file.getSelectedFile();
        		// JOptionPane.showMessageDialog(null, "I have choosen file : " + file.getName() + "\n" + "Path: " + file.getAbsolutePath());
        		
					Scanner sc;
					try {
						sc = new Scanner(file);
						while(sc.hasNext()) t_area.append(sc.nextLine() +"\n");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					l_file.setText(file.getName());
				//	System.out.println(file.getName());
			
        		}
        }
        
        if(source == mSave)
        {	JFileChooser choose_folder = new JFileChooser();
        	if ( choose_folder.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
        		{File file = choose_folder.getSelectedFile();
        		 JOptionPane.showMessageDialog(null, "I have save file : " + file.getName() + "\n" + "to: " + file.getAbsolutePath());
	        		 try {
						PrintWriter to_w = new PrintWriter(file);
						Scanner sc_w = new Scanner(t_area.getText());
						while ( sc_w.hasNext()) to_w.println(sc_w.nextLine() + "\n");
						to_w.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
        		}
        }
        
        if(source == b_find)
        {
        	String all_text = t_area.getText();
        	String find_text = t_find.getText();
        	String where_text = "";
        	int i = 0;
        	int index;
        	int startIndex = 0;
        	while((index = all_text.indexOf(find_text, startIndex)) != -1){
        		startIndex = index + find_text.length();
        		i++;
        		where_text = where_text + index + ", ";
        	}
        	String final_text = '"' + find_text + '"';
        	JOptionPane.showMessageDialog(null, final_text + " " + i + " times in index(es): " + where_text);
        }
        
        if(source == mpCopy ) choosen_text = t_area.getSelectedText();
        if(source == mpPaste) t_area.insert(choosen_text, t_area.getCaretPosition());
        if(source == mpAttach) t_area.append("\n" + choosen_text);
        
        if(source == color_combo)
        {
        	String color = color_combo.getSelectedItem().toString();
        	if(color.equals("Black")) t_area.setForeground(Color.BLACK);
        	if(color.equals("Red")) t_area.setForeground(Color.RED);
        	if(color.equals("Green")) t_area.setForeground(Color.GREEN);
        	if(color.equals("Blue")) t_area.setForeground(Color.BLUE);
        }
        
		if(source == b_color_choose) 
			{
			Color choosen_color = JColorChooser.showDialog(null, "Choose of color", Color.BLACK);
			t_area.setForeground(choosen_color);			
			}
    }

    public static void main(String[] args){
        Problem1 apkMenu = new Problem1();
        apkMenu.setVisible(true);
    }




}
