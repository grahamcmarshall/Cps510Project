package database;

import java.sql.*;
import java.util.*;

import classes.Employee;
import classes.Car;
import classes.Truck;
import classes.Van;
import classes.SUV;

//classes files 
//import classes.Employee;

public class DataParser {
	
	public DataParser(){
		
	}
	
	public ArrayList<Employee> getEmployees(ResultSet set){
		ArrayList<Employee> list = new ArrayList<Employee>();
		System.out.println("Set: " + set);
		try{
		while(set.next()){
			long id = set.getLong(1);
			String f = set.getString(2);
			String l = set.getString(3);
			String em = set.getString(4);
			long ph = set.getLong(5);
			String h = set.getString(6);
			String z = set.getString(7);
			String st = set.getString(8);
			String c = set.getString(9);
			String pr = set.getString(10);
			String po = set.getString(11);
			long sal = set.getLong(12);
			
			System.out.println(id + f + l + em + ph + h + z + st + c + pr + po + sal);
			
			Employee employee = new Employee(id,f,l,em,ph,z,st,c,pr,h,po,sal);
			list.add(employee);
		}
		}catch(SQLException e){
			System.out.println("ERROR: " + e);
		}
		return list;
	}

	public ArrayList<Car> getCars(ResultSet set){

		ArrayList<Car> list = new ArrayList<Car>();
		System.out.println("Car Set: " + set);
		try{
		while(set.next()){
			long id = set.getLong(1);
			String type  = set.getString(2);
			String model = set.getString(3);
			String make = set.getString(4);
			String year = set.getString(5);
			String fuel = set.getString(6);
			int price = set.getInt(7);
				
			System.out.println(id + type + model + make + year + fuel + price);
			
			Car car = new Car();
			car.setId(id);
			car.setCarType(type);
			car.setModel(model);
			car.setMake(make);
			car.setYear(year);
			car.setFuel(fuel);
			car.setPrice(price);
			list.add(car);
		}
		}catch(SQLException e){
			System.out.println("ERROR: " + e);
		}
		return list;
	}
	public ArrayList<Truck> getTrucks(ResultSet set){
		ArrayList<Truck> list = new ArrayList<Truck>();
		System.out.println("Truck Set: " + set);
		try{
		while(set.next()){
			long id = set.getLong(1);
			String type  = set.getString(2);
			String model = set.getString(3);
			String make = set.getString(4);
			String year = set.getString(5);
			String fuel = set.getString(6);
			int price = set.getInt(7);
				
			System.out.println(id + type + model + make + year + fuel + price);
			
			Truck truck = new Truck();
			truck.setId(id);
			truck.setTruckType(type);
			truck.setModel(model);
			truck.setMake(make);
			truck.setYear(year);
			truck.setFuel(fuel);
			truck.setPrice(price);
			list.add(truck);
		}
		}catch(SQLException e){
			System.out.println("ERROR: " + e);
		}
		return list;
	}
	public ArrayList<Van> getVans(ResultSet set){
		ArrayList<Van> list = new ArrayList<Van>();
		System.out.println("van Set: " + set);
		try{
		while(set.next()){
			long id = set.getLong(1);
			String type  = set.getString(2);
			String model = set.getString(3);
			String make = set.getString(4);
			String year = set.getString(5);
			String fuel = set.getString(6);
			int price = set.getInt(7);
				
			System.out.println(id + type + model + make + year + fuel + price);
			
			Van van = new Van();
			van.setId(id);
			van.setVanType(type);
			van.setModel(model);
			van.setMake(make);
			van.setYear(year);
			van.setFuel(fuel);
			van.setPrice(price);
			list.add(van);
		}
		}catch(SQLException e){
			System.out.println("ERROR: " + e);
		}
		return list;
	}
	public ArrayList<SUV> getSUVs(ResultSet set){
		ArrayList<SUV> list = new ArrayList<SUV>();
		System.out.println("SUV Set: " + set);
		try{
		while(set.next()){
			long id = set.getLong(1);
			String type  = set.getString(2);
			String model = set.getString(3);
			String make = set.getString(4);
			String year = set.getString(5);
			String fuel = set.getString(6);
			int price = set.getInt(7);
				
			System.out.println(id + type + model + make + year + fuel + price);
			
			SUV suv = new SUV();
			suv.setId(id);
			suv.setSUVType(type);
			suv.setModel(model);
			suv.setMake(make);
			suv.setYear(year);
			suv.setFuel(fuel);
			suv.setPrice(price);
			list.add(suv);
		}
		}catch(SQLException e){
			System.out.println("ERROR: " + e);
		}
		return list;
	}
}
