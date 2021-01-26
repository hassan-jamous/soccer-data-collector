package sofaScore.models.gameBasicInformation;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString

/**
 * 
 * https://www.sofascore.com/brighton-and-hove-albion-manchester-city/rsF , for this game 
 * the basic information are in this page {https://api.sofascore.com/api/v1/event/7828251 }
 * gameID is 7828251
 * that page contains all information about the game contains event which contains season information 
 * , round information  , home team information , ...etc 
 * 
 */

public class GameBasicInformation {

	public GameEvent event;
	
}
