package models;

public class PlayerCompetitionInformationOverall {

	public String competitionNation;
	public String competitionName;
	public String season;
	public String team;
	public String matches;
	public String goals;
	public String startingLineUp ;
	public String substitueIn;
	public String substituOut;
	public String yellowCards;
	public String secondYellowCards;
	public String redCards;
	
	public PlayerCompetitionInformationOverall() {}
	
	public String toString() {
		return competitionNation + "  " +  competitionName +"    " +"   playedGame " + matches + "  goals " + goals + "  startingLineUp  " + startingLineUp +
				"  subIN  " + substitueIn + "  subOUT  " + substituOut + "  Yellow  " + yellowCards + "  Second Yellow  " +
				secondYellowCards + "  Red  " + redCards;
	}
}
