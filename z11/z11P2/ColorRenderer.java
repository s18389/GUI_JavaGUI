package z11P2;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.util.Scanner;
 
 
public class ColorRenderer extends JLabel implements TableCellRenderer  {
 

	public ColorRenderer() {
        setOpaque(true); //MUST do this for background to show up.
    }
 
    public Component getTableCellRendererComponent(
                            JTable table, Object value,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
    	if(column == 3)
    	{
    		//	System.out.println(value.toString()); 
    			
    			String color_all = value.toString();
    			color_all = color_all.replaceAll("[^0-9]+", " ");
    			
    			Scanner s1 = new Scanner(color_all);
    			int red = s1.nextInt();
    			int green = s1.nextInt();
    			int blue = s1.nextInt();
    			System.out.println(red);
    			System.out.println(green);
    			System.out.println(blue);
    			System.out.println();
                setBackground(new Color(red, green, blue));
    	}
    	
    	if(column == 6)
    	{
    		System.out.println(value.toString()); 
    		String temp_s = value.toString();
    		String input = temp_s.substring(0, 6);
    		double temp_d = Double.parseDouble(temp_s);
    		if(temp_d>25) setBackground(Color.RED);
    		else if(temp_d<18) setBackground(Color.YELLOW);
    		else setBackground(Color.WHITE);
    		setText(input);
    	}
        return this;
    }
}