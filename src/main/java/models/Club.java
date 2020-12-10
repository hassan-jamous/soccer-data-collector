package models;

public class Club{
	String name;
	String goals;	
	String position;
	String playedGames;
	String winGames;
	String drawGames;
	String lostGames;
	String diffirentGoals;
	String points;
	
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
