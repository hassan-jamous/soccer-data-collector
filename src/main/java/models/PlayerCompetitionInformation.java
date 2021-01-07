package models;

public class PlayerCompetitionInformation {

	public String competitionName;
	public String competitionNation;
	public String matchesNumber;
	public String goalsNumber;
	public String startingLineUp;
	public String substitueIn;
	public String substitueOut;
	public String yellowCards;
	public String secondYellowCards;
	public String redCards;
	
	public PlayerCompetitionInformation() {}
	public PlayerCompetitionInformation(String competitionName , String competitionNation , String matchesNumber , String goalsNumber
			,String startingLineUp , String substitueIn ,String subtitueOut ,String yellowCard , String secondYellowCard ,String redCards) {
		if(competitionName.contains("∑")) {
			this.competitionName = competitionName.replace("∑", "Total");
			this.competitionNation = null;

		}
		else{
			this.competitionName = competitionName;
			this.competitionNation = competitionNation;
		}
		this.matchesNumber = matchesNumber;
		this.goalsNumber = goalsNumber;
		this.startingLineUp = startingLineUp;
		this.substitueIn = substitueIn;
		this.substitueOut = subtitueOut;
		this.yellowCards = yellowCard;
		this.secondYellowCards = secondYellowCard;
		this.redCards = redCards;
		
	}
	
	public String toString() {
		return competitionName +"    " + competitionNation+"   playedGame " + matchesNumber + "  goals " + goalsNumber + "  startingLineUp  " + startingLineUp +
				"  subIN  " + substitueIn + "  subOUT  " + substitueOut + "  Yellow  " + yellowCards + "  Second Yellow  " +
				secondYellowCards + "  Red  " + redCards;
	}
	
}
