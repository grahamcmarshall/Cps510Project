package database;
/*
Class that controls the data

Connects to database 
Queries database 
Inserts into database
*/

//

//Basic java stuff 

// Oracle Stuff
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

//Class file connection
import classes.Employee;
import classes.Car;
import classes.Truck;
import classes.Van;
import classes.SUV;


public class DataControl{
	private static DataControl instance;
    private Connection connection = null;
    private DataParser parser;
	
	//Error messages
	final String ERROR_ALREADY = "Error: Already Connected To Rental Database";
    final String ERROR_DRIVER_UNFOUND = "Error: Where is you Oracle JDBC Driver?";
	final String ERROR_RUN_QUERY = "Error: Unable to run query";
    
	//Success messages
	final String SUCCESS_CONNECT = "Successfully Connected to database";
	
	
    public DataControl(){
    }
    
    public static DataControl getInstance(){
        if(instance == null){
            instance = new DataControl();
        }
        return instance;
    }
    
    public void getConnection()
    {	
		if(connection == null)
		{
			String hostName = "jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl";
			String uName = "M4IRWIN";
			String uPass = "YUIOP1234";
						
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch(ClassNotFoundException e){
				System.out.println(ERROR_DRIVER_UNFOUND);
			}
			try{
			connection = DriverManager.getConnection(hostName,uName,uPass);
			System.out.println(SUCCESS_CONNECT);
			parser = new DataParser();
			}catch(SQLException e){
				System.out.println(e);
			}
		}
		else
			System.out.println(ERROR_ALREADY);
    }
    
    public ResultSet runQuery(String query) throws SQLException {
		System.out.println("Running query: " + query);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
	}
    
// Employee Queries
    public Employee queryEmployeeById(long id) throws SQLException {
        String query = "SELECT emp.empid#, emp.firstname, emp.lastname, emp.email, emp.phone#, emp.hiringdate, zp.zip, zp.street, zp.city, zp.prov, ep.empposition, ep.salary "+
        			"FROM EMPLOYEE emp, ZIP zp, EMPLOYEEPOSITION ep WHERE emp.empid# = "+ id + " AND emp.zip = zp.zip AND emp.EMPID# = ep.EMPID#";
        ResultSet resultSet = runQuery(query);
        ArrayList<Employee> employee = parser.getEmployees(resultSet);
        if (employee.size() == 0) return null;
        return employee.get(0);
    }
    
    public ArrayList<Car> queryAviableCars() throws SQLException{
    	String query = "Select * FROM AVAILABLE_CAR";
    	ResultSet resultSet = runQuery(query);
    	ArrayList<Car> cars = parser.getCars(resultSet);
    	return cars;
    }
    public ArrayList<Truck> queryAviableTrucks() throws SQLException{
    	String query = "Select * FROM AVAILABLE_TRUCK";
    	ResultSet resultSet = runQuery(query);
    	ArrayList<Truck> trucks = parser.getTrucks(resultSet);
    	return trucks;
    }
    public ArrayList<Van> queryAviableVans() throws SQLException{
    	String query = "Select * FROM AVAILABLE_VAN";
    	ResultSet resultSet = runQuery(query);
    	ArrayList<Van> vans = parser.getVans(resultSet);
    	return vans;
    }
    public ArrayList<SUV> queryAviableSUVs() throws SQLException{
    	String query = "Select * FROM AVAILABLE_SUV";
    	ResultSet resultSet = runQuery(query);
    	ArrayList<SUV> suvs = parser.getSUVs(resultSet);
    	return suvs;
    }
    
    
    
    
	
}