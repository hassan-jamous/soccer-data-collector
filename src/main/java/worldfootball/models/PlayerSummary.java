package worldfootball.models;

public class PlayerSummary {

	public String number;
	public Player playerBasicInfo;
	public String nation;
	public String birthDate;
	public String information;

	
	public PlayerSummary() {
		playerBasicInfo = new Player();
	}
	public PlayerSummary(String number , String name , String nation , String birthDate , String information) {
		this();
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
