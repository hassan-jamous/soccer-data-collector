package sofaScore.models.gameBasicInformation;

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
	
}
