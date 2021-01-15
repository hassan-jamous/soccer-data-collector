package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatisticsGoalsPerSeason {
    public String seasonRankingNumber;
    public String seasonYears;
    public String goals;
    public String matchesNumber;
    public String goalsPerMatch;

}
