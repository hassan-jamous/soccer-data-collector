package sofaScore.models.gameIecidents;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class IncidentInGameVarDecision extends IncidentInGame {

    public String confirmed;
    public IncidentInGamePlayer player;
    public String isHome;
    public String id;
    public String time;
    public String incidentClass;
    
    public IncidentInGameVarDecision(String confirmed , IncidentInGamePlayer player, String isHome, String id, String time, String incidentClass,
    		String incidentType) {
    	this.confirmed = confirmed;
    	this.player = player;
    	this.isHome = isHome;
    	this.id = id;
    	this.time = time;
    	this.incidentClass = incidentClass;
    	this.incidentType = incidentType;
    }

}
