package sofaScore;

import java.util.ArrayList;

import sofaScoreModels.GameIencidents;
import sofaScoreModels.GameIencidentsGSON;
import sofaScoreModels.GameStatistic;
import sofaScoreModels.RoundGamesID;

public class SofaScoreCollector {

	RoundCollector roundCollerctor = new RoundCollector();
	GameCollector gameCollector = new GameCollector();
	
	/***
	 * 
	 * @param competitionName example Premier League
	 * @param competitionYears example 05/06
	 * @param round
	 */
	public RoundGamesID getGamesIdInRound (String competitionName, String competitionYears , String round) {
		return roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round);
	}
	
	public GameStatistic getGameStatistic (String competitionName, String competitionYears , String round , int gameIndex) {
		return gameCollector.getGameStatistics(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round).events.get(gameIndex).id);
	}
	public ArrayList<GameIencidents> getGameIencidents(String competitionName, String competitionYears , String round , int gameIndex) {
		return gameCollector.getGameIncidents(roundCollerctor.getGamesIdInRound(competitionName, competitionYears, round).events.get(gameIndex).id);
	}
}
