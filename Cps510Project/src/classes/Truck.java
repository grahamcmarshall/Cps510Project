package classes;

public class Truck extends Vehicle {
	
	public String truckType;
	public long maxLoad;
	public long towing;
	public int bedSize;
	
	public Truck(){}
	/*public Truck(long id,String model,String make,String year,int price,String plate,String available,String type,String truckType,long maxLoad,long towing,int bedSize){
		this.id = id;
		this.model = model;
		this.make = make;
		this.year = year;
		this.price = price;
		this.available = available;
		this.type = type;
		this.truckType = truckType;
		this.maxLoad = maxLoad;
		this.towing = towing;
		this.bedSize = bedSize;
	}*/
	
	public String getTruckType(){return truckType;}
	public long getMaxLoad(){return maxLoad;}
	public long getTowing(){return towing;}
	public int getBedSize(){return bedSize;}
	
	public void setTruckType(String truckType){
		this.truckType = truckType;
	}
	
	public String avaibleToString(){
		return id +" "+ truckType +" "+ model +" "+ make +" "+ year +" "+ price +"\n";
	}

}
