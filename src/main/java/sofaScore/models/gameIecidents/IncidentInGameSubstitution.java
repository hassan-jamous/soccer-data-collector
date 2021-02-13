package sofaScore.models.gameIecidents;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class IncidentInGameSubstitution extends IncidentInGame{
	public IncidentInGamePlayer playerIn;
	public IncidentInGamePlayer playerOut;
	public String injury;
	public String id; 
	public String time;
	public String addedTime;
	public String isHome;
	public String incidentClass;
	
	public IncidentInGameSubstitution(IncidentInGamePlayer playerIn, IncidentInGamePlayer playerOut, String injury, String id, String time,
	 String addedTime, String isHome, String incidentClass, String incidentType) {
		this.playerIn = playerIn;
		this.playerOut = playerOut;
		this.injury = injury;
		this.id =id;
		this.time =time;
		this.addedTime =addedTime;
		this.isHome =isHome;
		this.incidentClass = incidentClass;
		this.incidentType =incidentType;
	}
	public String getName() {
    	return "Substitution";
    }
}
