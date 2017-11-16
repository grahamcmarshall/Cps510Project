package classes;

public class SUV extends Vehicle {

	public String SUVType;
	public long towing;
	
	
	public SUV(){}

	public String getSUVType(){return SUVType;}
	public long getTowing(){return towing;}
	
	public void setSUVType(String SUVType){
		this.SUVType = SUVType;
	}
	
	public String avaibleToString(){
		return id +" "+ SUVType +" "+ model +" "+ make +" "+ year +" "+ price +"\n";
	}
}
