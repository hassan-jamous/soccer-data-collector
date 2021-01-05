package sofaScore;

import sofaScoreModels.GameStatistic;
import sofaScoreModels.RoundTopScore;

public class SofaScoreCollector {

	SofaScoreRoundCollector roundCollerctor = new SofaScoreRoundCollector();
	SofaScoreGameCollector gameCollector = new SofaScoreGameCollector();
	
	/***
	 * 
	 * @param competitionName example Premier League
	 * @param competitionYears example 05/06
	 * @param round
	 */
	public RoundTopScore getGamesIdInRound (String competitionName, String competitionYears , String round) {
		return roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round);
	}
	
	public GameStatistic getGameStatistic (String competitionName, String competitionYears , String round , int gameIndex) {
		return gameCollector.getTopScoreGamegetStatistics(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round).events.get(gameIndex).id);
	}
}
