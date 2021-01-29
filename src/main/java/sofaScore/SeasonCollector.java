package sofaScore;

import com.google.gson.Gson;
import csvFile.CSVDealer;
import sofaScore.models.season.CurrentRoundSeasonInfo;
import sofaScore.models.utilities.HashMapLeaguesID;
import sofaScore.models.utilities.HashMapSeasonsID;
import util.HttpUtil;

public class SeasonCollector {
	
	private final HttpUtil httpUtil = new HttpUtil();
	private final String API_SOFA_SCORE_CURRENT_ROUND_URL = "https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/rounds";
	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID(); 
	RoundCollector roundCollerctor = new RoundCollector();
	GameCollector gameCollector = new GameCollector();
	CSVDealer csvDealer = new CSVDealer();

	public int getCurrentRound(String competitionName , String competitionYears) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_CURRENT_ROUND_URL,leagueId.getLeagueID(competitionName), seasonId.get(competitionName + " " + competitionYears)));
		Gson gson = new Gson();
		CurrentRoundSeasonInfo currentRoundInfo = gson.fromJson(gsonString, CurrentRoundSeasonInfo.class);
		return currentRoundInfo.currentRound.round;
	}

	public void writeSeason(String competitionName, String competitionYears) {
		int limit = getCurrentRound(competitionName, competitionYears);
		for(int i =1 ; i <= limit ; i++) {
			roundCollerctor.writeRound(competitionName, competitionYears , String.valueOf(i));
		}
	}
	
	public void writeCompetition(String competition) {
		
	}
	
}
