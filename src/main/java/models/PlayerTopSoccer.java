package models;

public class PlayerTopSoccer {

	public String playerRanking;
	public String playerName;
	public String playerNation;
	public String playerClubName;
	public String goals;
	public String penalty;
	
	public PlayerTopSoccer() {}
	
	public PlayerTopSoccer(String playerRanking,  String playerName, String playerNation,String playerClubName,
	                       String goals, String penalty) {
		this.playerRanking = playerRanking;
		this.playerName =playerName;
		this.playerNation =playerNation;
		this.playerClubName=playerClubName;
		this.goals =goals;
		this.penalty =penalty;
		
	}
	public String toString() {
		String result="";
		result ="#" + playerRanking + "   " + playerName + "  {" + playerNation +"} " + playerClubName + "  " + goals + "("+ penalty + ")";
		return result;
	}
}
