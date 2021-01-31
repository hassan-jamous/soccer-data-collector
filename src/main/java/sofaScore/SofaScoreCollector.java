package sofaScore;

import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameIecidents.GameIncidents;
import sofaScore.models.gameStatistics.GameStatistics;

public class SofaScoreCollector {

	RoundCollector roundCollerctor = new RoundCollector();
	GameCollector gameCollector = new GameCollector();
	
	/***
	 * 
	 * @param competitionName example Premier League
	 * @param competitionYears example 05/06
	 * @param round
	 * @param gameIndex in round
	 */
	public GameIncidents getGameIencidents(String competitionName, String competitionYears , String round , int gameIndex) {
		return gameCollector.getGameIncidents(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round,"").events.get(gameIndex).id);
	}
	
	/**
	 * 
	 * @param competitionName  example Premier League
	 * @param competitionYears example 05/06
	 * @param round
	 * @param gameIndex in round
	 * @return
	 */
	public GameBasicInformation getGameBasicInformation(String competitionName, String competitionYears , String round , int gameIndex) {
		return gameCollector.getGameBasicInformation(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round,"").events.get(gameIndex).id);
	}
	/**
	 * 
	 * @param competitionName
	 * @param competitionYears
	 * @param round
	 * @param gameIndex in round
	 * @return
	 */

	public GameStatistics getGameStatistics(String competitionName, String competitionYears , String round , int gameIndex) {
		return gameCollector.getGameStatistics(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round,"").events.get(gameIndex).id);
	}

}
