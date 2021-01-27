package sofaScore.models.gameBasicInformation;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
/**
 * 
 * here we know the status of the game (played , postponed ...)
 *
 */
public class Stauts {

	public int code;
	public String description;
	public String type;

}
