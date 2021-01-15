package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StatisticsMostGoalsByPlayerPerGame {

	public Player playerInfo;
    public Game gameInfo;
    public String numberOfGoal;

}
