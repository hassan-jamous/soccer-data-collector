package sofaScore.models.gameBasicInformation;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class ScoreTeamInGame {
	
	public int current ;
	public int display;
	public int period1;
	public int period2;
	public int normaltime;
	
	public String write() {
		return current+", ";
	}

}
