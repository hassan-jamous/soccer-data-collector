package models;

public class PlayerTopSoccer {

	public String playerRanking;
	public Player playerBasicInfo;
	public String playerNation;
	public String playerClubName;
	public String goals;
	public String penalty;
	
	
	public PlayerTopSoccer() {
		playerBasicInfo = new Player();
	}
	
	public PlayerTopSoccer(String playerRanking,  String playerName, String playerNation,String playerClubName,
	                       String goals, String penalty) {
		this();
		this.playerRanking = playerRanking;
		this.playerBasicInfo.name =playerName;
		this.playerNation =playerNation;
		this.playerClubName=playerClubName;
		this.goals =goals;
		this.penalty =penalty;
		
	}
	public String toString() {
		String result="";
		result ="#" + playerRanking + "   " + playerBasicInfo.name + "  {" + playerNation +"} " + playerClubName + "  " + goals + "("+ penalty + ")";
		return result;
	}
}
