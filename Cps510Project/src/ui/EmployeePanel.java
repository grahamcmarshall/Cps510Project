package ui;

//basic java imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import classes.Employee;
import classes.Car;
import classes.Truck;
import classes.Van;
import classes.SUV;
import database.DataControl;


//import java.awt.*;
//Event handlers
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

//Connection with over files
//import database.DataControl;

//Oracle stuff
import java.sql.SQLException; 

public class EmployeePanel extends JPanel {
	
	private static final long serialVersionUID = 1L; 
	private final int textAreaSize = 40;
	private DataControl data;
	private ArrayList<Car> avCars;
	private ArrayList<Truck> avTrucks;
	private ArrayList<Van> avVans;
	private ArrayList<SUV> avSUVs;
	

	public EmployeePanel(Employee theEmp, final RentalFrame parent) {
		super();
		parent.setTitle("Vehicle Rental Manager - Employee: " + theEmp.getFirstName() + " " + theEmp.getLastName());
		data = DataControl.getInstance();
		try{
			avCars = data.queryAviableCars();
			avTrucks = data.queryAviableTrucks();
			avVans = data.queryAviableVans();
			avSUVs = data.queryAviableSUVs();
			
		}catch(SQLException e){
			System.out.println(e);
		}
		setLayout(new BorderLayout());
        
                
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JPanel topLeftPanel = new JPanel();
        JPanel topRightPanel = new JPanel();
        
        JLabel empPhone = new JLabel(Long.toString(theEmp.getPhone()));
        JLabel empAddress = new JLabel(theEmp.getEmail());
        JLabel empEmail = new JLabel(theEmp.getAddress());
        
        JButton out = new JButton("Log Out");
        out.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		parent.changeToLogin(parent);
        	}
        });
        
        JButton tran = new JButton("Transactions");
        tran.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		JPanel panel = new JPanel();
        		JPanel list = new ListPanel("Transactions","Query");
        		parent.createPopUpChoice("New Transaction",panel,"List Of Transactions",list,parent);
        	}
        });
        
        
        JButton cus = new JButton("Customer");
        cus.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		JPanel panel = new JPanel();
        		JPanel list = new JPanel();
        		parent.createPopUpChoice("New Customer",panel,"List Of Customer",list,parent);
        	}
        });
        JButton emp = new JButton("Employee");
        emp.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		JPanel panel = new JPanel();
        		JPanel list = new JPanel();
        		parent.createPopUpChoice("New Employee",panel,"List Of Employee",list,parent);
        	}
        });
        JButton dist = new JButton("Order");
        JButton veh = new JButton("Vehicles");
        veh.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		JPanel panel = new JPanel();
        		JPanel list = new JPanel();
        		parent.createPopUpChoice("New Vehicles",panel,"List Of Vehicles",list,parent);
        	}
        });        
        
        topRightPanel.add(emp);
        topRightPanel.add(veh);
        topRightPanel.add(dist);
        topRightPanel.add(cus);
        topRightPanel.add(tran);
        topRightPanel.add(out);
        
        topLeftPanel.add(empPhone);
        topLeftPanel.add(empAddress);
        topLeftPanel.add(empEmail);
        
        topPanel.setLayout(new BorderLayout());
        topPanel.add(topLeftPanel, BorderLayout.WEST);
        topPanel.add(topRightPanel, BorderLayout.EAST);
        
        
        //Button half of employee panel
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        bottomPanel.setLayout(new BorderLayout());
        
        
        JPanel bottomLeftLarge = new JPanel();
        bottomLeftLarge.setBorder(new EmptyBorder(10,10,10,10));
        bottomLeftLarge.setLayout(new BorderLayout());
       // bottomLeftLarge.setBorder(BorderFactory.createLineBorder(Color.RED));
        
        JPanel bottomLeftLargeTop = new JPanel();
        bottomLeftLargeTop.setLayout(new BorderLayout());
        
        JLabel pending = new JLabel("Pending Transactions");
        JTextArea pendingArea = new JTextArea(5,textAreaSize);
        JScrollPane pendingScroll = new JScrollPane(pendingArea);
        pendingArea.setEditable(false);
        bottomLeftLargeTop.add(pending,BorderLayout.NORTH);
        bottomLeftLargeTop.add(pendingScroll,BorderLayout.CENTER);
        
        JPanel bottomLeftLargeBottom = new JPanel();
        bottomLeftLargeBottom.setLayout(new BorderLayout());
        
        JLabel avTruck = new JLabel("Available Trucks");
        JTextArea truckArea = new JTextArea(5,textAreaSize);
        for(Truck truck: avTrucks){
        	truckArea.append(truck.avaibleToString());
        }
        JScrollPane truckScroll = new JScrollPane(truckArea);
        truckArea.setEditable(false);
        
        bottomLeftLargeBottom.add(avTruck,BorderLayout.NORTH);
        bottomLeftLargeBottom.add(truckScroll,BorderLayout.CENTER);
        
        
        bottomLeftLarge.add(bottomLeftLargeTop, BorderLayout.NORTH);
        bottomLeftLarge.add(bottomLeftLargeBottom,BorderLayout.CENTER);
        
        JPanel bottomRightLarge = new JPanel();
        bottomRightLarge.setBorder(new EmptyBorder(10,10,10,10));
        bottomRightLarge.setLayout(new BorderLayout());
        
        JPanel bottomRightLargeTop = new JPanel();
        JPanel bottomRightLargeMiddle = new JPanel();
        JPanel bottomRightLargeBottom = new JPanel();
        
        bottomRightLargeTop.setLayout(new BorderLayout());
        bottomRightLargeMiddle.setLayout(new BorderLayout());
        bottomRightLargeBottom.setLayout(new BorderLayout());
        
        JLabel avCar = new JLabel("Available Cars");
        JTextArea avCarArea = new JTextArea(5,textAreaSize);
        for(Car car: avCars){
        	avCarArea.append(car.avaibleToString());
        }
        JScrollPane avCarScroll = new JScrollPane(avCarArea);
        avCarArea.setEditable(false);
        bottomRightLargeTop.add(avCar,BorderLayout.NORTH);
        bottomRightLargeTop.add(avCarScroll,BorderLayout.CENTER);
        
        JLabel avVan = new JLabel("Available Vans");
        JTextArea avVanArea = new JTextArea(5,textAreaSize);
        for(Van van: avVans){
        	avVanArea.append(van.avaibleToString());
        }
        JScrollPane avVaScroll = new JScrollPane(avVanArea);
        avVanArea.setEditable(false);
        bottomRightLargeMiddle.add(avVan,BorderLayout.NORTH);
        bottomRightLargeMiddle.add(avVaScroll,BorderLayout.CENTER);
        
        JLabel avSUV = new JLabel("Available SUVs");
        JTextArea avSUVArea = new JTextArea(5,textAreaSize);
        for(SUV suv: avSUVs){
        	avSUVArea.append(suv.avaibleToString());
        }
        JScrollPane avSUVScroll = new JScrollPane(avSUVArea);
        avSUVArea.setEditable(false);
        bottomRightLargeBottom.add(avSUV,BorderLayout.NORTH);
        bottomRightLargeBottom.add(avSUVScroll,BorderLayout.CENTER);
        
        
        bottomRightLarge.add(bottomRightLargeTop,BorderLayout.NORTH);
        bottomRightLarge.add(bottomRightLargeMiddle,BorderLayout.CENTER);
        bottomRightLarge.add(bottomRightLargeBottom,BorderLayout.SOUTH);
               
        
        
       
        
        bottomPanel.add(bottomRightLarge,BorderLayout.EAST);
        bottomPanel.add(bottomLeftLarge,BorderLayout.WEST);
        
        add(topPanel,BorderLayout.PAGE_START);
        add(bottomPanel,BorderLayout.CENTER);
       
    }	
}
