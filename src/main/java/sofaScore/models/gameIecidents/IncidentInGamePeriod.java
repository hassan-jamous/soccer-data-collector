package sofaScore.models.gameIecidents;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@NoArgsConstructor
@SuperBuilder
@ToString
public class IncidentInGamePeriod extends IncidentInGame{
	public String text;
	public String homeScore;
	public String awayScore;
	public String isLive;
	public String time;
	public String addedTime;
	
	public IncidentInGamePeriod(String text , String homeScore, String awayScore, String isLive, String time, String addedTime, String incidentType) {

		this.text =text;
		this.homeScore =homeScore;
		this.awayScore = awayScore;
		this.isLive =isLive;
		this.time = time;
		this.addedTime =addedTime;
		this.incidentType =incidentType;

	}	
	public String getName() {
    	return "Period";
    }
}
