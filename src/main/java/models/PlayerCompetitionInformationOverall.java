package models;

public class PlayerCompetitionInformationOverall {

	public PlayerCompetitionsInformation competitionInfo;
	public Club clubInfo;
	public String competitionYears;
	
	public PlayerCompetitionInformationOverall() {
		competitionInfo = new PlayerCompetitionsInformation();
		clubInfo = new  Club ();
	}
	public PlayerCompetitionInformationOverall(PlayerCompetitionsInformation competitionInfo , String club, String competitionYears) {
		this.competitionInfo = new PlayerCompetitionsInformation();
		this.clubInfo = new  Club ();
		this.competitionInfo = competitionInfo;
		this.clubInfo.name = club;
		this.competitionYears = competitionYears;		
	}
	
	public String toString() {
		String result = "";
		result = clubInfo.name + "   " + competitionYears + "   " +  competitionInfo.toString(); 
		return result;
	}
}
