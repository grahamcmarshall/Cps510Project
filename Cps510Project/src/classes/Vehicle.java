package classes;

public class Vehicle {
		public long id;
		public String model;
		public String make;
		public String year;
		public int price;
		public String plate;
		public String available;
		public String type;
		public int door;
		public int seat;
		public String fuel;
		public int bag;
		
		
		public void setId(long id){
			this.id = id;
		}
		public void setModel(String model){
			this.model = model;
		}
		public void setMake(String make){
			this.make = make;
		}
		public void setYear(String year){
			this.year = year;
		}
		public void setPrice(int price){
			this.price = price;
		}
		public void setPlate(String plate){
			this.plate = type;
		}
		public void setavailable(String available){
			this.available = type;
		}
		public void setType(String type){
			this.type = type;
		}
		public void setDoor(int door){
			this.door = door;
		}
		public void setSeat(int seat){
			this.seat = seat;
		}
		public void setFuel(String fuel){
			this.fuel = fuel;
		}
		public void setBag(int bag){
			this.bag = bag;
		}
		
		
		public long getId(){return id;}
		public String getModel(){return model;}
		public String getMake(){return make;}
		public String getYear(){return year;}
		public long getPriceId(){return price;}
		public String getPlate(){return plate;}
		public String getAvailable(){return available;}
		public String getType(){return type;}
		
}
