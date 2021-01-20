package sofaScore;

import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.Gson;
import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.models.gameBasicInformation.Game;
import sofaScore.models.gameStatistics.GameStatisticNew;
import sofaScore.models.utilities.HashMapLeaguesID;
import sofaScore.models.utilities.HashMapSeasonsID;
import util.HttpUtil;

public class RoundCollector {

	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID(); 
	private final HttpUtil httpUtil = new HttpUtil();
	GameCollector gameCollector = new GameCollector();
	private final String API_SOFA_SCORE_ROUND_URL ="https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/events/round/%s";
	/***
	 * 
	 * @param competitionName example Premier League
	 * @param competitionYears example 05/06
	 * @param rounndNumber example (1 or 17 )
	 */
	public RoundGamesID getGamesIdInRound(String competitionName, String competitionYears , String round) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_ROUND_URL,leagueId.getLeagueID(competitionName), seasonId.get(competitionName + " " + competitionYears),round));
		Gson gson = new Gson();
		RoundGamesID gamesId = gson.fromJson(gsonString, RoundGamesID.class);

		return gamesId;
	}
	/**
	 * 
	 * @param competitionName
	 * @param competitionYears
	 * @param round
	 * @return the statistic for all game in this round
	 * for example if one game has statistic for red cards with out statistic for offside
	 * and other game has statistic offside
	 * the result contains all (red cards and offside)
	 */
	
	public GameStatisticNew getGamesStatisticNewInRound(String competitionName, String competitionYears , String round){
		
		RoundGamesID gamesIdInRound = getGamesIdInRound(competitionName , competitionYears , round);
		if((gamesIdInRound == null) || (gamesIdInRound.events.isEmpty())) {
			//not error so i can not throw an exception just to check what happened or throw an exception
			System.out.println("no games id in this round " + round +"  at " + competitionYears );
			return null;
		}
		String firstgGameId = gamesIdInRound.events.get(0).id;
		GameStatisticNew resultGameStastiscs = gameCollector.getGameStatisticsNew(firstgGameId);
		if(gamesIdInRound.events.size()==1) {
			//not error so i can not throw an exception just to check what happened or throw an exception
			System.out.println("only one game in " + round +"  at " + competitionYears );
			return resultGameStastiscs;
		}
		for(int i =0; i < gamesIdInRound.events.size(); i++) {
			String gameId = gamesIdInRound.events.get(i).id;
			GameStatisticNew gameStastiscs = gameCollector.getGameStatisticsNew(gameId);
			if(gameStastiscs == null) {
				return resultGameStastiscs;
			}
			resultGameStastiscs.itHaveTheSameTo(gameStastiscs);
		}
		Collections.sort(resultGameStastiscs.statistics);

		return resultGameStastiscs; 
	} 
	
	
	public RoundGamesID getPlayedGamesIdInRound(String competitionName, String competitionYears , String round) {
			
			String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_ROUND_URL,leagueId.getLeagueID(competitionName), seasonId.get(competitionName + " " + competitionYears),round));
			Gson gson = new Gson();
			RoundGamesID gamesId = gson.fromJson(gsonString, RoundGamesID.class);
			RoundGamesID result = new RoundGamesID();
			for(int i =0 ; i < gamesId.events.size() ; i++) {
				Game game = gameCollector.getGameBasicInformation(String.valueOf(gamesId.events.get(i).id));
				if(game.event.status.description.equals("Not started")) {}//there are many descriptions 
				else if(game.event.status.description.equals("Ended")) {
					if(result.events == null) {result.events = new ArrayList<>();}
					result.events.add(gamesId.events.get(i));
				}			
			}
			return result;
		}
}

