package worldfootball.models;

public class StatisticsMostGoalsByPlayerPerGame {

	public Game gameInfo;
	public Player playerInfo;
	public String  numberOfGoal;

	public StatisticsMostGoalsByPlayerPerGame() {
		this.gameInfo = new Game();
		this.playerInfo = new Player();
	}
	
	public StatisticsMostGoalsByPlayerPerGame(String playerName , String gameDate , String firstClub , String result , 
			String secondClub , String numberOfGoal) {
		this();
		playerInfo.name = playerName;
		gameInfo.date = gameDate;
		gameInfo.firstTeamBasicInfo.name = firstClub;
		gameInfo.finalResult  = result;
		gameInfo.secondTeamBasicInfo.name = secondClub;
		this.numberOfGoal = numberOfGoal;
		
	}
	public String toString() {
		String result ="";
		result = "(" + numberOfGoal + ")    "  +  playerInfo.name + "     " + gameInfo.date + "  " + 
				gameInfo.firstTeamBasicInfo.name + "   vs    " + gameInfo.secondTeamBasicInfo.name + "    "+
				"(" + gameInfo.finalResult + ")";
		return result;
	}
}
