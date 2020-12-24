package models;

public class StatisticsBestPlayerInYear {

	public String year;
	public Player playerBasicInfo;
	
	public StatisticsBestPlayerInYear() {
		playerBasicInfo = new Player();
	}
	public StatisticsBestPlayerInYear(String year, String playerName) {
		
		this.playerBasicInfo = new Player();
		this.year = year;
		this.playerBasicInfo.name = playerName;
	}
	public String toString() {
		String result ="";
		result = "(" + year + ")  " + playerBasicInfo.name; 

		return result;

	}
}
