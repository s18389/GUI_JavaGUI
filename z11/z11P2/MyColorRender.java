package z11P2;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public abstract class MyColorRender extends JLabel implements TableCellRenderer{

	public MyColorRender() {
		setOpaque(true); //MUST do this for background to show up.
	}

    public Component getTableCellRendererComponent(
            JTable table, double value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
    	
    		if( value>25) setBackground(Color.RED);
    		else if(value<18) setBackground(Color.YELLOW);
    		else setBackground(Color.WHITE);
    	
        return this;
	}

}
