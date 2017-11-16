package classes;

public class Employee {
	
	public long empId;
	public String firstName;
	public String lastName;
	public String email;
	public long phone;
	public String zip;
	public String street;
	public String city;
	public String prov;
	public String hiring;
	public String position;
	public long salary;
	
	//Temp constructor
	public Employee(){
		
	}
	
	public Employee(long id,String f, String l,String email, long phone, String zip,String street,String city, String pov, String hiring,String pos, long salary){
		empId = id;
		firstName = f;
		lastName = l;
		this.email = email;
		this.phone = phone;
		this.zip = zip;
		this.street = street;
		this.city = city;
		this.prov = pov;
		String[] temp = hiring.split(" ");
		this.hiring = temp[0];
		position = pos;
		this.salary = salary;
	}
	
	public long getEmpId(){return empId;}
	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
	public String getEmail(){return email;}
	public long getPhone(){return phone;}
	public String getZip(){return zip;}
	public String getStreet(){return street;}
	public String getCity(){return city;}
	public String getProv(){return prov;}
	public String getHiring(){return hiring;}
	public String getPosition(){return position;}
	public long getSalary(){return salary;}
	
	public String getAddress(){
		return street+" "+city+ " " + prov +" "+ zip;
	}
	
}
