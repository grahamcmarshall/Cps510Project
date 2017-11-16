package ui;

//basic java imports
import javax.swing.*;
import java.awt.*;

//Event handlers
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Connection with over files
import database.DataControl;

//Oracle stuff
import java.sql.SQLException; 

//Classes folder 
import classes.Employee;


public class LogInPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private static final int HORIZONTAL_PADDING = 10;
	private static final int VERTICAL_PADDING = 4;

	DataControl data;
	
	public LogInPanel(final RentalFrame parent) {
		super();
        parent.setTitle("Vehicle Rental Manager - Login");
		data = DataControl.getInstance();
		data.getConnection();
		
		// set layout
		JPanel loginInfo = new JPanel();
		loginInfo.setLayout(new BoxLayout(loginInfo, BoxLayout.PAGE_AXIS));
		
		// create employee password text field
		JLabel empIDLabel = new JLabel("Employee ID:  ");
		final JPasswordField empPWField = new JPasswordField("",6);
		// create panel for password
		JPanel password = new JPanel();
		password.setLayout(new BoxLayout(password, BoxLayout.LINE_AXIS));
		// add components to the panel
		password.add(empIDLabel);
		password.add(Box.createRigidArea(new Dimension(HORIZONTAL_PADDING, 0)));
		password.add(empPWField);

		// create login button
		JButton logInButton = new JButton("Log In");
		logInButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		logInButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				String id = empPWField.getText();
				
				if (id.equals("")) JOptionPane.showMessageDialog(null,"Please give your employee id","Error", JOptionPane.INFORMATION_MESSAGE);
				else{
					try{
					Employee employee = data.queryEmployeeById(Long.parseLong(id));
					if(employee != null)parent.changeToEmployee(employee, parent);
					else JOptionPane.showMessageDialog(null,"Id not found","Error", JOptionPane.INFORMATION_MESSAGE);
					}catch(SQLException error){
						System.out.println(error);
					}
				}
			}
        });
		
		// add components to loginInfo panel
		// add top spacer
		loginInfo.add(Box.createRigidArea(new Dimension(0, VERTICAL_PADDING+32)));
		// add spacer
		loginInfo.add(Box.createRigidArea(new Dimension(0, VERTICAL_PADDING+32)));
		// add password panel
		loginInfo.add(password);
		loginInfo.add(Box.createRigidArea(new Dimension(0, 16)));
		loginInfo.add(logInButton);

		// add loginInfo panel
		add(loginInfo);
		
		JRootPane rootPane = parent.getRootPane();
		rootPane.setDefaultButton(logInButton);
	}
}
