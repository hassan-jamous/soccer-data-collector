package worldfootball.models;

public class StatisticsGoalsPerSeason {
	public String seasonRankingNumber;
	public String seasonYears;
	public String goals;
	public String matchesNumber;
	public String goalsPerMatch;
	
	public StatisticsGoalsPerSeason() {}
	public StatisticsGoalsPerSeason(String seasonRankingNumber , String seasonYears ,  String goals , String matchesNumber, String goalsPerMatch) {
		this.seasonRankingNumber = seasonRankingNumber;
		this.seasonYears = seasonYears;
		this.goals = goals;
		this.matchesNumber = matchesNumber ;
		this.goalsPerMatch = goalsPerMatch;
	}
	public String toString() {
		String result="";
		result =  "(" + seasonRankingNumber + ")  " + seasonYears + "  goals: " + goals + "  matches: " + matchesNumber + "  goals per match " + goalsPerMatch;
		return result;
	}

}
