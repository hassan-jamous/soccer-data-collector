package sofaScore.models.gameIecidents;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InncidentInGameCard implements Iencident {
	
	public IencidentInGamePlayer player;
	public String playerName;
	public String reason;
	public String id;
	public String time;
	public String addedTime ;
	public String isHome ;
	public String incidentClass;
	public String incidentType;

}
