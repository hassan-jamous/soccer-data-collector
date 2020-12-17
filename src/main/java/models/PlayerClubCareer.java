package models;

public class PlayerClubCareer {
	public String clubName;
	public String clubNation;
	public String playerPosition;
	public String playerNumber ="#";//number if the player is in the club(has a number)  , or he was in the club so the number is #
	public String years;
	
	public String toString() {
		String result ="";
		result = clubName + "{ " + clubNation + " } " + playerPosition + "# " + playerNumber + " date is " + years; 
		return result;
	}
}
