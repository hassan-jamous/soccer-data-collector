package sofaScore.models.RoundInformation;

import java.util.ArrayList;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
/**
 * 
 * contains array list of gameID witch we will use in GameCollector as gameID the parameter 
 * for his methods ( getGameStatistics(String gameID)  , getGameIncidents(String gameID)
 * and getGameBasicInformation(String gameID) ) * 
 *
 */
public class RoundGamesID {

	public ArrayList<GameID> events;
}
