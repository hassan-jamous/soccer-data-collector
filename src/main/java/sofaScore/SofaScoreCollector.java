package sofaScore;

import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameIecidents.GameIecidents;
import sofaScore.models.gameStatistics.GameStatisticNew;
import sofaScore.models.season.Season;

public class SofaScoreCollector {

	RoundCollector roundCollerctor = new RoundCollector();
	GameCollector gameCollector = new GameCollector();
	SeasonCollector seasonCollector = new SeasonCollector();
	
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
	public GameBasicInformation getGameBasicInformation(String competitionName, String competitionYears , String round , int gameIndex) {
		return gameCollector.getGameBasicInformation(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round).events.get(gameIndex).id);
	}
	
	public Season getAllRoundsInformationInSeason(String competitionName , String competitionYears) {
		return seasonCollector.getAllRoundsInformationInSeason(competitionName, competitionYears);
	}
	
	public int getNumberOfFinishedRoundAtSeason(String competitionName , String competitionYears) {
		return seasonCollector.getNumberOfFinishedRoundInSeason(competitionName, competitionYears);
	}
	
	public GameStatisticNew getGameNewStatisticsNew(String competitionName, String competitionYears , String round , int gameIndex) {
		return gameCollector.getGameStatistics(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round).events.get(gameIndex).id);
	}
	 
}
