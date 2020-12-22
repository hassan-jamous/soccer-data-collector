package models;

public class StatisticsMostGoalsInGame {
	public String playerGoalsNumber;
	public String playerName;
	public String matchDate;
	public String homeClub;
	public String guestClub;
	public String matchResult;

	public StatisticsMostGoalsInGame() {}
	
	public StatisticsMostGoalsInGame(String playerName , String matchDate , String homeClub , String matchResult ,String guestClub , String goalsNumber) {
		this.playerName = playerName;
		this.matchDate = matchDate;
		this.homeClub =homeClub;
		this.guestClub = guestClub;
		this.matchResult = matchResult;
		this.playerGoalsNumber = goalsNumber;
	}
	
	public String toString() {
		String result ="";
		result = "(" + playerGoalsNumber + ")" + playerName + "(" + matchDate + ")" + "  " + homeClub + "  vs  " + guestClub + "(" + matchResult + ")";
		return result;
	}
}
