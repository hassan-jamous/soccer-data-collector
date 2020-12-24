package models;

public class StatisticsMostGoalsInGame {
	public String playerGoalsNumber;
	public Player playerBasicInfo;
	public String matchDate;
	public Club homeClubBasicInfo;
	public Club guestClubBasicInfo;
	public String matchResult;

	public StatisticsMostGoalsInGame() {
		playerBasicInfo = new Player();
		guestClubBasicInfo = new Club();
		homeClubBasicInfo = new Club();
	}
	
	public StatisticsMostGoalsInGame(String playerName , String matchDate , String homeClub , String matchResult ,String guestClub , String goalsNumber) {
		this.playerBasicInfo = new Player();
		this.guestClubBasicInfo = new Club();
		this.homeClubBasicInfo = new Club();
		this.playerBasicInfo.name = playerName;
		this.matchDate = matchDate;
		this.homeClubBasicInfo.name =homeClub;
		this.guestClubBasicInfo.name = guestClub;
		this.matchResult = matchResult;
		this.playerGoalsNumber = goalsNumber;
	}
	
	public String toString() {
		String result ="";
		result = "(" + playerGoalsNumber + ")" + playerBasicInfo.name + "(" + matchDate + ")" + "  " + homeClubBasicInfo.name + "  vs  " + guestClubBasicInfo.name + "(" + matchResult + ")";
		return result;
	}
}
