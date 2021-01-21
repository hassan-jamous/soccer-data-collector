package sofaScore.models.gameIecidents;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IencidentInGameInjuryTime implements Iencident {
	public String length;
	public String time;
	public String addedTime;
	public String incidentType;

}
