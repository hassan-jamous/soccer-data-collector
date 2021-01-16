package sofaScore.models;


import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString

//contains all information about the game {https://api.sofascore.com/api/v1/event/gameid }     
//for example gameid 7828251 
//https://www.sofascore.com/brighton-and-hove-albion-manchester-city/rsF 13 Jan 2021, 20:00
public class Game {

	public GameEvent event;
}
