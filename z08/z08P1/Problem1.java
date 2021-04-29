// MCK-Layouts/Layouts.java
package z08P1;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Problem1 extends JFrame {
    static final long serialVersionUID = 20160515L;

    static JTextArea area = null;

    public static void main (String[] args) {
        new Problem1();
    }

    private Problem1() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setting layout of the whole contentPane
        // of the frame window (it is border layout
        // by default anyway...)
        setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3,3,10,10));
        for (int i = 1; i < 10; ++i)
            southPanel.add(new JButton("B0" + i));
        add(southPanel,BorderLayout.SOUTH);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(3,1));
        northPanel.add(new JTextField("Filed 1",30));
        northPanel.add(new JTextField("Filed 1",30));
        northPanel.add(new JTextField("Filed 1",30));
        add(northPanel,BorderLayout.NORTH);

        area = new JTextArea(15,15);
        area.setBackground(Color.WHITE);
        area.setForeground(Color.BLACK);
        JScrollPane scroll = new JScrollPane(area,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll,BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
