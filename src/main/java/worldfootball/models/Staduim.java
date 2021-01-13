package worldfootball.models;

public class Staduim {
	
	public String name;
	public String city;
	public String country;
	public String capacity;
	
	public Staduim() {}
	public Staduim(String name , String city , String country , String capacity) {
		this.name = name;
		this.city = city;
		this.country = country;
		this.capacity = capacity;
	}

	public String toString() {
		String result ="";
		result = name + " in city " + city + "  in  " + country  + "  with capacity  " + capacity; 
		return result;
	}

}
