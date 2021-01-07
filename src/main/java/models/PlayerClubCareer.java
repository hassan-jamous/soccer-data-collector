package models;

public class PlayerClubCareer {
	public Club clubBasicInfo;
	public String clubNation;
	public String playerPosition;
	public String playerNumber ;//number if the player is in the club(has a number)  , or he was in the club so the number is #
	public String years;
	
	public PlayerClubCareer() {
		clubBasicInfo = new Club();
	}
	public PlayerClubCareer(String years ,String clubName , String clubNation , String playerPosition , String playerNumber  ) {
		this();
		this.clubBasicInfo.name = clubName;
		this.clubNation = clubNation;
		this.playerPosition = playerPosition;
		this.playerNumber = playerNumber;
		this.years = years;
	}
	public String toString() {
		String result ="";
		result = clubBasicInfo.name + "{ " + clubNation + " } " + playerPosition + "  number is " + playerNumber + " date is " + years; 
		return result;
	}
}
