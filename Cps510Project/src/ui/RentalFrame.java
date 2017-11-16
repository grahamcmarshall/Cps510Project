package ui;

//Basic java imports
import javax.swing.*;

import java.awt.*;

//classes folder files 
import classes.Employee;

//UI package files
import ui.LogInPanel;
import ui.EmployeePanel;


public class RentalFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	private LogInPanel logPanel;
	private EmployeePanel empPanel;
	private ChoicePanel chPanel;
	
	
	public RentalFrame(){
		super();
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
		setLocationRelativeTo(this.getParent());
		setResizable(false);
	}
	
	public void run(){
		changeToLogin(this);
		this.setVisible(true);
	}
	
	public void changeToLogin(RentalFrame parent){
		removePanels(parent);
		logPanel = new LogInPanel(parent);
		setSize(350,330);
		add(logPanel);
		setLocationRelativeTo(null);
		repaint();
		revalidate();
	}
	
	public void changeToEmployee(Employee employee,RentalFrame parent){
		empPanel = new EmployeePanel(employee,parent);
		remove(logPanel);
		add(empPanel);
		setFrameToMaximizeSize();
		repaint();
		revalidate();
	}
	
	public void createPopUpChoice(String newText,JPanel location1,String listText,JPanel listLocation,RentalFrame parent){
		JFrame frame = new JFrame();
		frame.setSize(330,70);
		frame.setLocationRelativeTo(parent);
		chPanel = new ChoicePanel(newText,location1,listText,listLocation,frame);
		frame.add(chPanel);
		frame.setVisible(true);
	}
	
	private void setFrameToMaximizeSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width/2,screenSize.height/2);
		setExtendedState(Frame.MAXIMIZED_BOTH/2);
	}
	private void removePanels(RentalFrame parent){
		parent.getContentPane().removeAll();
	}
	
}
