package sofaScore;

import com.google.gson.Gson;

import sofaScoreModels.GameStatistic;
import util.HttpUtil;

public class GameCollector {
	
	private final String API_SOFA_SCORE_GAME_URL ="https://api.sofascore.com/api/v1/event/%s/statistics"; 
	private final HttpUtil httpUtil = new HttpUtil();

	public GameStatistic getGamegetStatistics(String gameID) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_URL, gameID));
		Gson gson = new Gson();
		GameStatistic gamesInfo = gson.fromJson(gsonString, GameStatistic.class);
		return gamesInfo;
		
	}

}
