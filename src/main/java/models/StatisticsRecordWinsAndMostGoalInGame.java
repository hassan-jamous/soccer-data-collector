package models;

public class StatisticsRecordWinsAndMostGoalInGame {

	public String seasonYears;
	public String round;
	public String matchDate;
	public String homeClub;
	public String matchResult;
	public String guestClub;
	
	public StatisticsRecordWinsAndMostGoalInGame() {}
	public StatisticsRecordWinsAndMostGoalInGame(String seasonYear, String round, String matchDate ,String homeClub , String result, String guestClub) {
		this.seasonYears = seasonYear;
		this.round = round;
		this.matchDate = matchDate;
		this.homeClub  = homeClub;
		this.matchResult = result;
		this.guestClub = guestClub;
	}
	
	public String toString() {
		String result="";
		result = seasonYears + "   " + round + " AT " + matchDate + "  " + homeClub + "  vs  " + guestClub + " (" + matchResult + ")";
		return result;
	}
}
