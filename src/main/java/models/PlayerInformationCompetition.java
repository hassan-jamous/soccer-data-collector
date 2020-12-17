package models;

public class PlayerInformationCompetition {

	public String competitionName;
	public String matches;
	public String goals;
	public String startingLineUp;
	public String substitueIn;
	public String substituOut;
	public String yellowCards;
	public String secondYellowCards;
	public String redCards;
	
	
	public String toString() {
		return competitionName + "   playedGame " + matches + "  goals " + goals + "  startingLineUp  " + startingLineUp +
				"  subIN  " + substitueIn + "  subOUT  " + substituOut + "  Yellow  " + yellowCards + "  Second Yellow  " +
				secondYellowCards + "  Red  " + redCards;
	}
	
}
