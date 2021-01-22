package sofaScore.models.gameBasicInformation;

import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
public class GameEvent {
	//public Tournament tournament; do we want this information
	public SeasonInGame season;
	public RoundInGame roundInfo;
	public TeamInGame homeTeam;
	public TeamInGame awayTeam;
	public ScoreTeamInGame homeScore;
	public ScoreTeamInGame awayScore;
	public Stauts status;
	
	
	//dataType header or values
	public String write(String dataType) {
		return season.write(dataType) + roundInfo.write(dataType)+ status.write(dataType) + 
				((dataType.equals("header")?"Home Team, " : homeTeam.write())) + 
				((dataType.equals("header")?"Away Team, " :awayTeam.write())) + 
				((dataType.equals("header")?"Away Score, " :homeScore.write())) + 
				((dataType.equals("header")?"Away Score, " :awayScore.write())) ;
	}
	
	
}
