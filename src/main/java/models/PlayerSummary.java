package models;



//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//to ask hassan , will we replace string player and assister (attributes of class goal) by this class (Player class)
public class PlayerSummary {

	String number;//is it better int or no?
	public Player playerBasicInfo;
	String nation;
	String birthDate;//or date instead of string
	String information;

	
	public PlayerSummary() {
		playerBasicInfo = new Player();
	}//may we will delete it later
	public PlayerSummary(String number , String name , String nation , String birthDate , String information) {
		this.playerBasicInfo = new Player();
		this.number = number;
		this.playerBasicInfo.name = name;
		this.nation = nation;
		this.birthDate = birthDate;
		this.information = information;
		
	}
	
	public String toString() {
		String player ="";
		player = "# " + number + "  " + playerBasicInfo.name + "  "+ information + "  " + nation + "  " + birthDate;
		return player;
	}
}
