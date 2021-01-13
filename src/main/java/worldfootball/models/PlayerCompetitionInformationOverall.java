package worldfootball.models;

public class PlayerCompetitionInformationOverall {

	public PlayerCompetitionInformation competitionInfo;
	public Club clubInfo;
	public String competitionYears;
	
	public PlayerCompetitionInformationOverall() {
		competitionInfo = new PlayerCompetitionInformation();
		clubInfo = new  Club ();
	}
	
	public PlayerCompetitionInformationOverall(String competitionNation ,String competitionName ,
			String competitionYears,  String club, String matchesNumber , String goalsNumber
			,String startingLineUp , String substitueIn ,String substitueOut ,String yellowCards ,
			String secondYellowCards ,String redCards ) {
		this();		
		this.competitionInfo.competitionNation = competitionNation;
		this.competitionInfo.competitionName = competitionName;
		this.competitionYears = competitionYears;
		this.clubInfo.name = club;
		this.competitionInfo.matchesNumber = matchesNumber;
		this.competitionInfo.goalsNumber = goalsNumber;
		this.competitionInfo.startingLineUp = startingLineUp;
		this.competitionInfo.substitueIn = substitueIn;
		this.competitionInfo.substitueOut = substitueOut;
		this.competitionInfo.yellowCards = yellowCards;
		this.competitionInfo.secondYellowCards = secondYellowCards;
		this.competitionInfo.redCards = redCards;
				
	}
	
	public String toString() {
		String result = "";
		result = clubInfo.name + "   " + competitionYears + "   " +  competitionInfo.toString(); 
		return result;
	}
}
