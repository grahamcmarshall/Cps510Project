package classes;

public class Car extends Vehicle{
	
	public String carType;
	public Car(){}
	
	/*public Car(long id,String model,String make,String year,long price,String plate,String available,String type,String carType ){
		this.id = id;
		this.model = model;
		this.make = make;
		this.year = year;
		this.price = price;
		this.available = available;
		this.type = type;
		this.carType = carType;
	}*/
	
	public String getCarType(){return carType;}
	public void setCarType(String type){
		carType = type;
	}
	
	
	public String avaibleToString(){
		return id +" "+ carType +" "+ model +" "+ make +" "+ year +" "+ price +"\n";
	}
	
}
