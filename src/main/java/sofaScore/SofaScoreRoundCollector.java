package sofaScore;

import com.google.gson.Gson;
import sofaScoreModels.HashMapLeaguesID;
import sofaScoreModels.RoundTopScore;
import util.HttpUtil;

public class SofaScoreRoundCollector {

	private final HashMapLeaguesID leaguesId = new HashMapLeaguesID();
	private final HttpUtil httpUtil = new HttpUtil();
	private final String API_TOP_SCORE_PREMIER_LEAGUE_URL ="https://api.sofascore.com/api/v1/unique-tournament/17/season/";
	private final String API = "https://api.sofascore.com/api/v1/unique-tournament/17/season/";//for all competition?????

	//todo
	//use string formattor
	/***
	 * 
	 * @param competitionName example Premier League
	 * @param competitionYears example 05/06
	 * @param round
	 */
	public RoundTopScore getGamesIdInRound(String competitionName, String competitionYears , String round) {
		String key = competitionName + " " + competitionYears;
		String id = leaguesId.get(key);
		
		String gsonString = httpUtil.sendGetHttpRequest(API_TOP_SCORE_PREMIER_LEAGUE_URL + id + "/events/round/" + round);

		Gson gson = new Gson();
		RoundTopScore gamesId = gson.fromJson(gsonString, RoundTopScore.class);

		return gamesId;
	}
	public void getAllRounds() {}

}
