package sofaScore.models.gameBasicInformation;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString

//contains all information about the game {https://api.sofascore.com/api/v1/event/gameid }     
//for example gameid 7828251 
//https://www.sofascore.com/brighton-and-hove-albion-manchester-city/rsF 13 Jan 2021, 20:00

//it contains event which contains season information , round information  , home team information , ...etc 
//to ask hassan is this data structure good?
//i mean we can delete class event , so class game will have the information
public class GameBasicInformation {

	public GameEvent event;
	
}
