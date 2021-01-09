package models;

public class PlayerTopScoreForSeason {
	public String competitionYears;
	public String playerNation;
	public Player playerInfo;
	public Club clubInfo;
	public String goals;
	
	public PlayerTopScoreForSeason() {
		playerInfo = new Player();
		clubInfo = new Club();
		}
	public PlayerTopScoreForSeason(String competitionYears, String playerNation 
			, String playerName, String clubName , String goals) {
		this();
		this.competitionYears = competitionYears;
		this.playerNation = playerNation;
		this.playerInfo.name = playerName;
		this.clubInfo.name = clubName;
		this.goals = goals;
	}
	public String toString() {
		String result ="";
		result = "(" + competitionYears + ")   (" + playerNation +")   " + playerInfo.name +  "in club(" + clubInfo.name +")    with goals="+goals;  
		return result;
	}

}
