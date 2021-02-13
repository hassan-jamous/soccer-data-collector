package sofaScore.models.gameIecidents;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@NoArgsConstructor

@ToString
public class IncidentInGameCard extends IncidentInGame {
	
	public IncidentInGamePlayer player;
	public String playerName;
	public String reason;
	public String id;
	public String time;
	public String addedTime ;
	public String isHome ;
	public String incidentClass;

	public IncidentInGameCard( IncidentInGamePlayer player, String playerName, String reason, String id, String time, 
			String addedTime ,String isHome ,String incidentClass , String incidentType){
	
		this.player = player;
		this.playerName = playerName;
		this.reason =reason;
		this.id = id;
		this.time = time;
		this.addedTime = addedTime;
		this.isHome =isHome;
		this.incidentClass = incidentClass;
		this.incidentType = incidentType;
	}
	
	public String getName() {
    	return "Card";
    }
	
	public void initialize() {
		player = new IncidentInGamePlayer();
	}
}