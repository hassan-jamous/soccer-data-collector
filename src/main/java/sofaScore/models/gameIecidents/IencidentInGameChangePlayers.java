package sofaScore.models.gameIecidents;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IencidentInGameChangePlayers implements Iencident{
	public IencidentInGamePlayer playerIn;
	public IencidentInGamePlayer playerOut;
	public String injury;
	public String id; 
	public String time;
	public String addedTime;
	public String isHome;
	public String incidentClass;
	public String incidentType;
	
}
