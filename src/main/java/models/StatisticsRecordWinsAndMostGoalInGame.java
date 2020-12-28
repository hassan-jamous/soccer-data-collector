package models;

public class StatisticsRecordWinsAndMostGoalInGame {

	public String seasonYears;
	public Round round;
	public String matchDate;

	public Club homeClubBasicInfo;
	public String matchResult;
	public Club guestClubBasicInfo;
	
	public StatisticsRecordWinsAndMostGoalInGame() {
		round = new Round();
		homeClubBasicInfo = new Club();
		guestClubBasicInfo = new Club();
	}
	public StatisticsRecordWinsAndMostGoalInGame(String seasonYear, String round, String matchDate ,String homeClub , String result, String guestClub) {
		this.round = new Round();
		this.homeClubBasicInfo = new Club();
		this.guestClubBasicInfo = new Club();
		this.seasonYears = seasonYear;
		this.round.roundNumberAsString = round;
		this.matchDate = matchDate;
		this.homeClubBasicInfo.name  = homeClub;
		this.matchResult = result;
		this.guestClubBasicInfo.name = guestClub;
	}
	
	public String toString() {
		String result="";

		result = seasonYears + "   " + round.roundNumberAsString + " AT " + matchDate + "  " + homeClubBasicInfo.name + "  vs  " + guestClubBasicInfo.name + " (" + matchResult + ")";

		return result;
	}
}
