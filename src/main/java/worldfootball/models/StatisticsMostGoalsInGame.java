package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatisticsMostGoalsInGame {
    public String playerGoalsNumber;
    public Player playerBasicInfo;
    public Game gameInfo;
  
}
