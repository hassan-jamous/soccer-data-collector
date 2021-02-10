package sofaScore.models.gameBasicInformation;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString

/**
 * 
 * https://www.sofascore.com/brighton-and-hove-albion-manchester-city/rsF , for  game 
 * the basic information are in  page {https://api.sofascore.com/api/v1/event/7828251 }
 * gameID is 7828251
 * that page contains all information about the game contains event which contains season information 
 * , round information  , home team information , ...etc 
 * 
 */

public class GameBasicInformation {

	public GameEvent event;
	
	public void initialize() {
		this.event = new GameEvent(); 
		this.event.tournament = new TournamentInGame();
		this.event.season= new SeasonInGame();
		this.event.roundInfo = new RoundInGame();
		this.event.tournament.uniqueTournament = new UniqueTournamentInGame();
		this.event.homeTeam= new TeamInGame();
		this.event.awayTeam= new TeamInGame();
		this.event.homeScore = new ScoreTeamInGame();
		this.event.awayScore= new ScoreTeamInGame();
		this.event.status = new Stauts();
	}  

	
}
