package sofaScore.models.gameIecidents;

import java.util.ArrayList;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@NoArgsConstructor
@ ToString

/**
 * https://www.sofascore.com/fulham-manchester-united/KsT
 * https://api.sofascore.com/api/v1/event/8897060/incidents 
 * the last url contains game incidents like (goals , var decision , yellow cards , .....)
 *
 */
public class GameIncidents {

	public ArrayList<IncidentInGame> incidentInGames;
}
