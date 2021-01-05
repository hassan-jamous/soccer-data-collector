package sofaScore;

import com.google.gson.Gson;

import sofaScoreModels.GameStatistic;
import util.HttpUtil;

public class SofaScoreGameCollector {
	private final String API_TOP_SCORE_PREMIER_LEAGUE_GAME_URL ="https://api.sofascore.com/api/v1/event/"; 
	private final HttpUtil httpUtil = new HttpUtil();

	//todo string formattor
	public GameStatistic getTopScoreGamegetStatistics(String gameID) {
		
		String gsonString = httpUtil.sendGetHttpRequest(API_TOP_SCORE_PREMIER_LEAGUE_GAME_URL + gameID + "/statistics");
		Gson gson = new Gson();
		GameStatistic gamesInfo = gson.fromJson(gsonString, GameStatistic.class);
		return gamesInfo;
		
	}

}
