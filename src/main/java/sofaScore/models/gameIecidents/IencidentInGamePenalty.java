package sofaScore.models.gameIecidents;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class IencidentInGamePenalty implements Iencident{

	public String time;
	public IencidentInGamePlayer player;
	public String description;
	public String id;
	public String incidentType;
	public String isHome;
	public String incidentClass;
	
}
