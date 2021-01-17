package sofaScore;

import csvFiles.DealerCSV;
import sofaScore.models.Game;
import sofaScore.models.GameIecidents;
import sofaScore.models.GameStatistic;
import sofaScore.models.RoundGamesID;
import sofaScore.models.Season;

public class SofaScoreCollector {

	RoundCollector roundCollerctor = new RoundCollector();
	GameCollector gameCollector = new GameCollector();
	DealerCSV csvDealer = new DealerCSV();
	
	/***
	 * 
	 * @param competitionName example Premier League
	 * @param competitionYears example 05/06
	 * @param round round number 1 or 2
	 */
	public RoundGamesID getGamesIdInRound (String competitionName, String competitionYears , String round) {
		return roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round);
	}
	
	/***
	 * 
	 * @param competitionName example Premier League
	 * @param competitionYears example 05/06
	 * @param round
	 */
	public GameStatistic getGameStatistics (String competitionName, String competitionYears , String round , int gameIndex) {
		return gameCollector.getGameStatistics(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round).events.get(gameIndex).id);
	}
	/***
	 * 
	 * @param competitionName example Premier League
	 * @param competitionYears example 05/06
	 * @param round
	 */
	public GameIecidents getGameIencidents(String competitionName, String competitionYears , String round , int gameIndex) {
		return gameCollector.getGameIncidents(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round).events.get(gameIndex).id);
	}
	
	/**
	 * 
	 * @param competitionName  example Premier League
	 * @param competitionYears example 05/06
	 * @param round
	 * @param gameIndex
	 * @return
	 */
	public Game getGameBasicInformation(String competitionName, String competitionYears , String round , int gameIndex) {
		return gameCollector.getGameBasicInformation(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round).events.get(gameIndex).id);
	}
	
	public Season getAllRoundsInformationInSeason(String competitionName , String competitionYears) {
		return roundCollerctor.getAllRoundsInformationInSeason(competitionName, competitionYears);
	}
	
	public int getNumberOfFinishedRoundAtSeason(String competitionName , String competitionYears) {
		return roundCollerctor.getNumberOfFinishedRoundInSeason(competitionName, competitionYears);
	}
	
	public void writePlayedGamesInRoundInCSVFiles(String competitionName, String competitionYears , int round) {
		RoundGamesID gamesID =  getPlayedGamesIdInRound(competitionName, competitionYears ,  String.valueOf(round));
		for(int i = 0 ; i < gamesID.events.size() ; i++ ) {
			Game game = gameCollector.getGameBasicInformation(gamesID.events.get(i).id);
			csvDealer.writeRound(competitionName, competitionYears, round, game.toString());
		}
	}
	
	public void writeSeasonInCSVFiles(String competitionName, String competitionYears) {
		int NumberOfRoundsAtSeason = getCurrentRoundNumber(competitionName, competitionYears);
		for(int i =1; i <=NumberOfRoundsAtSeason ; i++ ) {
			writePlayedGamesInRoundInCSVFiles(competitionName, competitionYears,i);
		}		
	}
	
	public int getCurrentRoundNumber(String competitionName, String competitionYears) {
		return roundCollerctor.getCurrentRound(competitionName, competitionYears);
	}
	
	public RoundGamesID getPlayedGamesIdInRound(String competitionName, String competitionYears , String round) {
		return 	roundCollerctor.getPlayedGamesIdInRound(competitionName,competitionYears , round) ;
	}
 
}
