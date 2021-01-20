package sofaScore.models.gameBasicInformation;

import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
public class GameEvent {
	public SeasonInGame season;
	public RoundInGame roundInfo;
	public TeamInGame homeTeam;
	public TeamInGame awayTeam;
	public ScoreTeamInGame homeScore;
	public ScoreTeamInGame awayScore;
	public Stauts status;
	
	public String headerToCSV() {		 
		 return "Season,Round,Status,homeTeam,awayTeam,homeScore,awayScore,";
	}
	public String valuesToCSV() {
	 return  season.valuesToCSV() + roundInfo.valuesToCSV()+ status.valuesToCSV() + homeTeam.valuesToCSV() + awayTeam.valuesToCSV() +homeScore.valuesToCSV()  + awayScore.valuesToCSV();
	}
}
