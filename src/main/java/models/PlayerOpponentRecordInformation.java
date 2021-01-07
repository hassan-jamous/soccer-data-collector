package models;

public class PlayerOpponentRecordInformation {

	public Club opponentName;
	public String matchesNumber;
	public String goalsNumber;
	public String startingLineUp;
	public String substitueIn;
	public String substitueOut;
	public String yellowCards;
	public String secondYellowCards;
	public String redCards;
	
	public PlayerOpponentRecordInformation() {
		opponentName = new Club();
	}
	public PlayerOpponentRecordInformation(String opponentName  , String matchesNumber , String goalsNumber
			,String startingLineUp , String substitueIn ,String subtitueOut ,String yellowCard , String secondYellowCard ,String redCards) {
		this();
		this.opponentName.name = opponentName;
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
		return opponentName.name +"    " +"   playedGame " + matchesNumber + "  goals " + goalsNumber + "  startingLineUp  " + startingLineUp +
				"  subIN  " + substitueIn + "  subOUT  " + substitueOut + "  Yellow  " + yellowCards + "  Second Yellow  " +
				secondYellowCards + "  Red  " + redCards;
	}
	
}
