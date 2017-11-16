package classes;

public class Van extends Vehicle {
	
	public String vanType;
	public int height;
	
	public Van(){
	
	}
	/*public Van(long id,String model,String make,String year,int price,String plate,String available,String type,String vanType,int height){
		this.id = id;
		this.model = model;
		this.make = make;
		this.year = year;
		this.price = price;
		this.available = available;
		this.type = type;
		this.vanType = vanType;
		this.height = height;
	}*/
	
	public String getVanType(){return vanType;}
	public int getHeight(){return height;}
	
	public void setVanType(String vanType){
		this.vanType = vanType;
	}
	
	public String avaibleToString(){
		return id +" "+ vanType +" "+ model +" "+ make +" "+ year +" "+ price +"\n";
	}
	
}
