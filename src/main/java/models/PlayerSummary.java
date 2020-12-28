package models;

public class PlayerSummary {

	String number;//is it better int or no?
	public Player playerBasicInfo;
	String nation;
	String birthDate;//or date instead of string
	String information;

	
	public PlayerSummary() {
		playerBasicInfo = new Player();
	}
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
