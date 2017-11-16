package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChoicePanel extends JPanel {

		public ChoicePanel(String newText,JPanel location1,String listText,final JPanel listLocation,final JFrame parent){
			
			JButton newButton = new JButton(newText);
			newButton.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		        		
	        	}
	        });
			
			JButton listButton = new JButton(listText);
			listButton.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        		    changeToGivenPanel(listLocation,parent); 		
	        	}
	        });
			add(newButton);
			add(listButton);
			
		}
		
		public static void changeToGivenPanel(JPanel panel,JFrame parent){
			
			parent.getContentPane().removeAll();
			parent.setSize(400,400);
			parent.add(panel);
		}
}
