package sofaScore.models.gameIecidents;

import java.util.ArrayList;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@NoArgsConstructor
@ ToString
public class GameIncidents {

	public ArrayList<IncidentInGame> incidentInGames;
}
