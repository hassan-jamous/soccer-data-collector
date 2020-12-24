package models;

public class StatisticsRecordWinsAndMostGoalInGame {

	public String seasonYears;
	public String round;
	public String matchDate;
	public Club homeClubBasicInfo;
	public String matchResult;
	public Club guestClubBasicInfo;
	
	public StatisticsRecordWinsAndMostGoalInGame() {
		homeClubBasicInfo = new Club();
		guestClubBasicInfo = new Club();
	}
	public StatisticsRecordWinsAndMostGoalInGame(String seasonYear, String round, String matchDate ,String homeClub , String result, String guestClub) {
		homeClubBasicInfo = new Club();
		guestClubBasicInfo = new Club();
		this.seasonYears = seasonYear;
		this.round = round;
		this.matchDate = matchDate;
		this.homeClubBasicInfo.name  = homeClub;
		this.matchResult = result;
		this.guestClubBasicInfo.name = guestClub;
	}
	
	public String toString() {
		String result="";
		result = seasonYears + "   " + round + " AT " + matchDate + "  " + homeClubBasicInfo.name + "  vs  " + guestClubBasicInfo.name + " (" + matchResult + ")";
		return result;
	}
}
