package z09P1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Problem1 extends JFrame implements ChangeListener{
	
	private JSlider size;
	private int side;
	JTextArea square;
	
	 public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public Problem1(){
	        setTitle("Square slider");
	        setSize(500, 440);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(null);
	        
	        
	        size = new JSlider (0, 100, 0);
	        size.setBounds(20, 340, 440, 60);
	        size.setMajorTickSpacing(20);
	        size.setMinorTickSpacing(5);
	        size.setPaintLabels(true);
	        size.setPaintTicks(true);
	        size.setBorder(BorderFactory.createTitledBorder("Size of the square"));
	        add(size);
	        size.setValue(50);
	        size.addChangeListener(this);
	        
	        square = new JTextArea ();
	        square.setBackground(Color.BLUE);
	        square.setBounds(90, 20, size.getValue() * 3, size.getValue()* 3);
	        add(square);
	        
	 }
	
    public static void main(String[] args){
        Problem1 apkMenu = new Problem1();
        apkMenu.setVisible(true);
    }

	@Override
	public void stateChanged(ChangeEvent e) {
		
		setSide(size.getValue()*3);
		System.out.println("Slider: " + size.getValue() + "    side: " + getSide());
		square.setBounds(90, 20, getSide(), getSide());
	}



}
