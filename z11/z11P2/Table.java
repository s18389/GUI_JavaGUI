package z11P2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Table extends JPanel {
    private boolean DEBUG = false;

    public Table() {
        super(new GridLayout(1,0));

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Date of birth");
        model.addColumn("Favourite color");
        model.addColumn("Height[cm]");
        model.addColumn("Weight[kg]");
        model.addColumn("BMI");

        Scanner sc2 = null;
        String directory = System.getProperty("user.dir") + "\\InputFiles\\";
        try {
            sc2 = new Scanner(new File(directory + "table.txt"));
        } catch (FileNotFoundException var13) {
            var13.printStackTrace();
        }
        

        while(sc2.hasNextLine()) {

            Scanner s2 = new Scanner(sc2.nextLine());

            while(s2.hasNext()) {
                String first_name = s2.next();
                String last_name = s2.next();
                String date_of_birth = s2.next();
	                String[] birth_parts = date_of_birth.split("-");
	                int year= Integer.parseInt(birth_parts[0]);
	                int mounth = Integer.parseInt(birth_parts[1]);
	                int day = Integer.parseInt(birth_parts[2]);
                String color_all = s2.next();
                    String[] parts = color_all.split(",");
                    int red = Integer.parseInt(parts[0]);
                    int green = Integer.parseInt(parts[1]);
                    int blue = Integer.parseInt(parts[2]);
                    Color color = new Color(red, green, blue);
                int height = s2.nextInt();
                int weight = s2.nextInt();
                double bmi = Double.valueOf(weight)/((Double.valueOf(height)/100)*(Double.valueOf(height)/100));
               
                String dayNames[] = new DateFormatSymbols().getWeekdays();
                Calendar date2 = Calendar.getInstance();
                date2.set(year, mounth, day);
              //  System.out.println("Today is a " + dayNames[date2.get(Calendar.DAY_OF_WEEK)]);
                
                
                System.out.println(bmi);
                model.addRow(new Object[] { first_name, last_name, dayNames[date2.get(Calendar.DAY_OF_WEEK)], color, height, weight , bmi});
                table.getColumnModel().getColumn(3).setCellRenderer(new ColorRenderer());
                table.getColumnModel().getColumn(6).setCellRenderer(new ColorRenderer());
            }


        }

        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);


    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Table newContentPane = new Table();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
        
    }

}


