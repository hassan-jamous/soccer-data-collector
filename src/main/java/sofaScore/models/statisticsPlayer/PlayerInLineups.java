package sofaScore.models.statisticsPlayer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sofaScore.models.basicModels.Player;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerInLineups {

	public Player player;
	public Integer shirtNumber;
	public String position;
	public Boolean substitute;
	public PlayerStatistics statistics;
}
