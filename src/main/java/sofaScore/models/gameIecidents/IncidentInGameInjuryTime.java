package sofaScore.models.gameIecidents;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@NoArgsConstructor
@SuperBuilder
@ToString
public class IncidentInGameInjuryTime extends IncidentInGame {
	public String length;
	public String time;
	public String addedTime;
	
	public IncidentInGameInjuryTime(String length,String time, String addedTime,String incidentType	) {
		
		this.length =length;
		this.time =time;
		this.addedTime =addedTime;
		this.incidentType =incidentType;
	}
	

}
