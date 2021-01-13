package worldfootball.models;

public class StatisticsGoalsPerRound {

    public String roundRankingNumber;
    public String seasonYears;
    public Round round;
    public String goals;
    public String matchesNumber;
    public String goalsPerMatch;

    public StatisticsGoalsPerRound() {
        round = new Round();
    }

    public StatisticsGoalsPerRound(String roundRankingNumber, String seasonYears, String round, String goals, String matchesNumber, String goalsPerMatch) {
        this();
        this.roundRankingNumber = roundRankingNumber;
        this.seasonYears = seasonYears;
        this.round.roundNumberAsString = round;
        this.goals = goals;
        this.matchesNumber = matchesNumber;
        this.goalsPerMatch = goalsPerMatch;
    }

    public String toString() {
        String result = "";
        result = "(" + roundRankingNumber + ")  " + seasonYears + "  | " + round.roundNumberAsString + "  goals: " + goals + "  matches: " + matchesNumber + "  goals per match " + goalsPerMatch;
        return result;
    }

}

