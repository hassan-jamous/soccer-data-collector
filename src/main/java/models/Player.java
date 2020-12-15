package models;

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//to ask hassan , will we replace string player and assister (attributes of class goal) by this class (Player class)
public class Player {

	String number;//is it better int or no?
	String name;
	String nation;
	String birthDate;//or date instead of string
	String information;
	
	public Player() {}//may we will delete it later
	public Player(String number , String name , String nation , String birthDate , String information) {
		this.number = number;
		this.name = name;
		this.nation = nation;
		this.birthDate = birthDate;
		this.information = information;
		
	}
	
	public String toString() {
		String player ="";
		player = "# " + number + "  " + name + "  "+ information + "  " + nation + "  " + birthDate;
		return player;
	}
}
