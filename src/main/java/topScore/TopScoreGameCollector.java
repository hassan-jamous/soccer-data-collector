package topScore;

import com.google.gson.Gson;

import topScoreModels.GameStatisticTopScore;

public class TopScoreGameCollector {
	private final String API_TOP_SCORE_PREMIER_LEAGUE_GAME_URL ="https://api.sofascore.com/api/v1/event/"; 
	private final HttpUtilScore httpUtil = new HttpUtilScore();

	public GameStatisticTopScore getTopScoreGamegetStatistics(String gameID) {
		
		String gsonString = httpUtil.sendGetHttpRequest(API_TOP_SCORE_PREMIER_LEAGUE_GAME_URL + gameID + "/statistics");
		Gson gson = new Gson();
		GameStatisticTopScore gamesInfo = new GameStatisticTopScore();		
		gamesInfo = gson.fromJson(gsonString, GameStatisticTopScore.class);
		return gamesInfo;
		
	}

}
