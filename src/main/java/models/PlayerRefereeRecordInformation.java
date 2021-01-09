package models;

public class PlayerRefereeRecordInformation {

	public Referee refereeInfo;
	public String matchesNumber;
	public String goalsNumber;
	public String startingLineUp;
	public String substitueIn;
	public String substitueOut;
	public String yellowCards;
	public String secondYellowCards;
	public String redCards;
	
	public PlayerRefereeRecordInformation() {
		refereeInfo = new Referee();
	}
	public PlayerRefereeRecordInformation(String refereeName , String refereeNation , String matchesNumber , String goalsNumber
			,String startingLineUp , String substitueIn ,String subtitueOut ,String yellowCard , String secondYellowCard ,String redCards) {
		this();
		this.refereeInfo.name = refereeName;
		this.refereeInfo.nation = refereeNation;		
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
		return refereeInfo.name +" (" + refereeInfo.nation+")   playedGame " + matchesNumber + "  goals " + goalsNumber + "  startingLineUp  " + startingLineUp +
				"  subIN  " + substitueIn + "  subOUT  " + substitueOut + "  Yellow  " + yellowCards + "  Second Yellow  " +
				secondYellowCards + "  Red  " + redCards;
	}
	
}


