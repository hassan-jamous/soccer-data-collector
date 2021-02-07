package sofaScore.models.gameBasicInformation;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
public class GameEvent {

	public TournamentInGame tournament;
	public SeasonInGame season;
	public RoundInGame roundInfo;
	public TeamInGame homeTeam;
	public TeamInGame awayTeam;
	public ScoreTeamInGame homeScore;
	public ScoreTeamInGame awayScore;
	public Stauts status;
	//public Date currentPeriodStartTimestamp;
	public Long startTimestamp;
	
	public Date getDate() {	
		return new Date(this.startTimestamp*1000L);
	}
	
	public String getDateToPrint() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy HH:mm");
		return  sdf.format(getDate());
	}	
}
