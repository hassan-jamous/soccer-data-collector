package sofaScore.models.gameBasicInformation;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class RoundInGame {
	public int round;
	
	public String write(String dataType) {
		return (dataType.equals("header"))? "Round , " : round +"," ;
	}

}
