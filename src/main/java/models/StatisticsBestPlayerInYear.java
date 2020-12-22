package models;

public class StatisticsBestPlayerInYear {

	public String year;
	public String playerName;
	
	public StatisticsBestPlayerInYear() {}
	public StatisticsBestPlayerInYear(String year, String playerName) {
		this.year = year;
		this.playerName = playerName;
	}
	public String toString() {
		String result ="";
		result = "(" + year + ")  " + playerName; 
		return result;
	}
}
