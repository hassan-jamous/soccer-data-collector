package sofaScore.models.gameIecidents;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor


@ToString
public class IncidentInGameGoal extends IncidentInGame{
	public String homeScore;
	public String awayScore;
	public IncidentInGamePlayer player;
	public IncidentInGamePlayer assist1;
	public String id;
	public String time;
	public String addedTime;
	public String isHome;
	public String incidentClass;
	
	public IncidentInGameGoal(String homeScore , String awayScore,  IncidentInGamePlayer player,  IncidentInGamePlayer assist1, String id,
	 String time, String addedTime, String isHome,String incidentClass, String incidentType) {
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.player = player;
		this.assist1 = assist1;
		this.id = id;
		this.time = time;
		this.addedTime =addedTime;
		this.isHome = isHome;
		this.incidentClass = incidentClass;
		this.incidentType = incidentType;
	}
}
