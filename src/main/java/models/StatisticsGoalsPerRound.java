package models;

public class StatisticsGoalsPerRound {

		public String roundRankingNumber;
		public String seasonYears;
		public String round;
		public String goals;
		public String matchesNumber;
		public String goalsPerMatch;
		
		public StatisticsGoalsPerRound() {}
		public StatisticsGoalsPerRound(String roundRankingNumber , String seasonYears , String round ,  String goals , String matchesNumber, String goalsPerMatch) {
			this.roundRankingNumber = roundRankingNumber;
			this.seasonYears = seasonYears;
			this.round = round;
			this.goals = goals;
			this.matchesNumber = matchesNumber ;
			this.goalsPerMatch = goalsPerMatch;
		}
		public String toString() {
			String result="";
			result =  "(" + roundRankingNumber + ")  " + seasonYears + "  | " + round +  "  goals: " + goals + "  matches: " + matchesNumber + "  goals per match " + goalsPerMatch;
			return result;
		}

	}

