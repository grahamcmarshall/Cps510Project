package ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListPanel extends JPanel {
		
	public ListPanel(String titleText,String query){
		setLayout(new BorderLayout());
		JLabel title = new JLabel(titleText);
		JTextArea displayArea = new JTextArea(5,40);
        JScrollPane displayScroll = new JScrollPane(displayArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(title,BorderLayout.NORTH);
        add(displayScroll,BorderLayout.CENTER);
	}

}
