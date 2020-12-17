package models;

import java.util.ArrayList;

public class PlayerPersonalInformation {

	public String name;
	public String fullName;
	public String birthDate;
	public String birthPlace;
	public String nationality;//or array
	public String height;
	public String weight;
	public String positions;//or array
	public String foot;
	
	public String toString() {
		String result ="";
		result = "Personal Information are \n"+
				name + "\n" +
				fullName +"\n" +
				birthDate + "\n" +
				birthPlace + "\n" +
				nationality + "\n" +
				height + "\n" +
				weight + "\n" +
				positions + "\n" +
				foot;
		return result;
	}
	
}
