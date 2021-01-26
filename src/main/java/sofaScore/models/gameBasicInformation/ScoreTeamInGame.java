package sofaScore.models.gameBasicInformation;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
//i recommend to change all primitives to objects (int to Integer) to accept null
public class ScoreTeamInGame {
	
	public Integer current ;
	public int display;
	public int period1;
	public int period2;
	public int normaltime;

}
