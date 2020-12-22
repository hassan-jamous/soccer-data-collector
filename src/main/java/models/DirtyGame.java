package models;

public class DirtyGame {
	public Game gameNormalInfo;//i.e first team , second team , result , date , .......
	public String redCards;
	public String secondYellowCards;
	public String yellowCards;
	public String dirtyPoints;
	
	public DirtyGame() {
		gameNormalInfo = new Game();
	} 
	
	public DirtyGame(String date, String firstTeam ,String result,String secondTeam , String redCards , String secondYellowCards , String yellowCards , String dirtyPoints) {
		this.gameNormalInfo = new Game();
		this.gameNormalInfo.date = date;
		this.gameNormalInfo.firstTeam = firstTeam;
		this.gameNormalInfo.finalResult = result;
		this.gameNormalInfo.secondTeam = secondTeam;
		this.redCards = redCards;
		this.secondYellowCards = secondYellowCards;
		this.yellowCards = yellowCards;
		this.dirtyPoints = dirtyPoints;
	}
	
	public String toString() {
		String result = "";
		result = gameNormalInfo.toString() + "  Red Cards: " + redCards + " Second Yellow Cards: " + secondYellowCards +
				"  Yellow Cards: " + yellowCards; 
		return result;
	}
	

}
