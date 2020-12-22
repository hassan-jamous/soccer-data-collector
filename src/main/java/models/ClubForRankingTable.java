package models;

public class ClubForRankingTable{
	String position;
	String name;
	String playedGames;
	String winGames;
	String drawGames;
	String lostGames;
	String goals;
	String diffirentGoals;
	String points;
	
	public ClubForRankingTable() {}
	public ClubForRankingTable(String position , String name , String playedGames , String winGames,
			String drawGames, String lostGames , String goals , String diffirentGoals ,
			String points) {
		this.position = position;
		this.name =  name;
		this.playedGames =playedGames;
		this.winGames = winGames;
		this.drawGames = drawGames;
		this.lostGames = lostGames;
		this.goals = goals;
		this.diffirentGoals = diffirentGoals;
		this.points = points;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPlayedGames(String games) {
		this.playedGames = games;
	}
	public void setWinGames(String games) {
		this.winGames = games;
	}
	public void setDrawGames(String games) {
		this.drawGames = games;
	}
	public void setLostGames(String games) {
		this.lostGames = games;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public void setDifGoals(String goals) {
		this.diffirentGoals = goals;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}

	public void setPoints(String points) {
		this.points =points;
	}
	public String toString() {
		String club ="";
		 club = "# " + position + "   " + name +"   played games " + playedGames + " win  " + winGames + " Draw " 
		+ drawGames + " lose " + lostGames + " goals " + goals + "  dif  " + diffirentGoals + " points "
        + points + "\n";
		 return club;
	}
	
}
