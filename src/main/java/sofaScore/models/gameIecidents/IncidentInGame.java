package sofaScore.models.gameIecidents;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class IncidentInGame {

    public String incidentType;
    public String getName() {
    	return "IncidentInGame";
    }
}
