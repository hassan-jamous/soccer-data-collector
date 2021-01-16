package sofaScore.models;

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
	
}
