package sofaScore.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IencidentInGameGoal implements Iencident{
	public String homeScore;
	public String awayScore;
	public IencidentInGamePlayer player;
	public IencidentInGamePlayer assist1;
	public String id;
	public String time;
	public String addedTime;
	public String isHome;//boolean is better????????
	public String incidentClass;
	public String incidentType;
	
}