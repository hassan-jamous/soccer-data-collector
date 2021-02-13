package sofaScore.models.gameIecidents;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor

@SuperBuilder
@ToString
public class IncidentInGamePenalty extends IncidentInGame{

	public String time;
	public IncidentInGamePlayer player;
	public String description;
	public String id;
	public String isHome;
	public String incidentClass;
	
	public IncidentInGamePenalty(String time , IncidentInGamePlayer player, String description, String id, String isHome,
	 String incidentClass, String incidentType ) {
		this.time =time;
		this.player = player;
		this.description =description;
		this.id = id;
		this.isHome = isHome;
		this.incidentClass = incidentClass;
		this.incidentType = incidentType;
		
	}
	public String getName() {
    	return "Penalty";
    }
}
