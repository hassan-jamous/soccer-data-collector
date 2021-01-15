package sofaScore.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IencidentInGameHeader implements Iencident{
	public String text;
	public String homeScore;
	public String awayScore;
	public String isLive;//or boolean
	public String time;
	public String addedTime;
	public String incidentType;

}
