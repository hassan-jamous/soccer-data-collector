package models;


public class ClubForRankingTable{
	public String position;
	public Club clubBasicInfo;
	public String playedGames;
	public String winGames;
	public String drawGames;
	public String lostGames;
	public String goals;
	public String diffirentGoals;
	public String points;
	

	public ClubForRankingTable() {
		clubBasicInfo = new Club();
	}
	public ClubForRankingTable(String clubPosition , String clubName , String playedGames , String winGames,
			String drawGames, String lostGames , String goals , String diffirentGoals ,
			String points) {
		this.clubBasicInfo = new Club();
		this.position = clubPosition;
		this.clubBasicInfo.name =  clubName;
		this.playedGames =playedGames;
		this.winGames = winGames;
		this.drawGames = drawGames;
		this.lostGames = lostGames;
		this.goals = goals;
		this.diffirentGoals = diffirentGoals;
		this.points = points;
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
		String result ="";
		 result = "# " + position + "   " + clubBasicInfo.name +"   played games " + playedGames + " win  " + winGames + " Draw " 
		+ drawGames + " lose " + lostGames + " goals " + goals + "  dif  " + diffirentGoals + " points "
        + points + "\n";
		 return result;
	}
}
	
