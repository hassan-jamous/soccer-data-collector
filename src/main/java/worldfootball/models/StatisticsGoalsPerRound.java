package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StatisticsGoalsPerRound {

    public String roundRankingNumber;
    public String seasonYears;
    public Round round;
    public String goals;
    public String matchesNumber;
    public String goalsPerMatch;

}

