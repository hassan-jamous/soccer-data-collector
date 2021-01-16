package sofaScore;

import java.util.ArrayList;

import com.google.gson.Gson;

import sofaScore.models.CurrentRoundSeasonInfo;
import sofaScore.models.Game;
import sofaScore.models.HashMapLeaguesID;
import sofaScore.models.HashMapSeasonsID;
import sofaScore.models.RoundGamesID;
import sofaScore.models.Season;
import util.HttpUtil;

public class RoundCollector {

	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID(); 
	private final HttpUtil httpUtil = new HttpUtil();
	GameCollector gameCollector = new GameCollector();
	private final String API_SOFA_SCORE_CURRENT_ROUND_URL ="https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/rounds";
	private final String API_SOFA_SCORE_ROUND_URL ="https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/events/round/%s";
	private final String API_SOFA_SCORE_SEASON_ROUNDS_URL = "https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/team-of-the-week/rounds";
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
	
	public Season getAllRoundsInformationInSeason(String competitionName , String competitionYears) {

		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_SEASON_ROUNDS_URL,leagueId.getLeagueID(competitionName), seasonId.get(competitionName + " " + competitionYears)));
		Gson gson = new Gson();
		Season season = gson.fromJson(gsonString, Season.class);
		if(season.rounds.get(season.rounds.size()-1).roundName.equals("Season")) {
			season.rounds.remove(season.rounds.size()-1);
		}
		return season;
	}
	
	public int getNumberOfFinishedRoundInSeason(String competitionName , String competitionYears) {
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_SEASON_ROUNDS_URL,leagueId.getLeagueID(competitionName), seasonId.get(competitionName + " " + competitionYears)));
		Gson gson = new Gson();
		Season season = gson.fromJson(gsonString, Season.class);
		if(season.rounds.get(season.rounds.size()-1).roundName.equals("Season")) {//the final entry is season
			season.rounds.remove(season.rounds.size()-1);
		}
		return season.rounds.size();
	}
	
	public int getCurrentRound(String competitionName , String competitionYears) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_CURRENT_ROUND_URL,leagueId.getLeagueID(competitionName), seasonId.get(competitionName + " " + competitionYears)));
		Gson gson = new Gson();
		CurrentRoundSeasonInfo currentRoundInfo = gson.fromJson(gsonString, CurrentRoundSeasonInfo.class);
		return currentRoundInfo.currentRound.round;
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

