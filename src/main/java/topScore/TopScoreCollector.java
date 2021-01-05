package topScore;

import topScoreModels.GameStatisticTopScore;
import topScoreModels.RoundTopScore;

public class TopScoreCollector{

	TopScoreRoundCollector roundCollerctor = new TopScoreRoundCollector();
	TopScoreGameCollector gameCollector = new TopScoreGameCollector();
	
	/***
	 * 
	 * @param competitionName example Premier League
	 * @param competitionYears example 05/06
	 * @param round
	 */
	public RoundTopScore getGamesIdInRound (String competitionName, String competitionYears , String round) {
		return roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round);
	}
	
	public GameStatisticTopScore getGameStatistic (String competitionName, String competitionYears , String round ,int gameIndex) {
		return gameCollector.getTopScoreGamegetStatistics(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round).events.get(gameIndex).id);
	}
}
