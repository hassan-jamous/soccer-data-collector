package sofaScore.models.gameIecidents;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IencidentInGameInjuryTime implements Iencident {
	public String length;//or int
	public String time;//or int
	public String addedTime;
	public String incidentType;

}
