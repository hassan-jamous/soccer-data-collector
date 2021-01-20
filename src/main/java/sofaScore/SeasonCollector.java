package sofaScore;

import java.util.Collections;

import com.google.gson.Gson;

import sofaScore.models.gameStatistics.GameStatisticNew;
import sofaScore.models.season.CurrentRoundSeasonInfo;
import sofaScore.models.season.Season;
import sofaScore.models.utilities.HashMapLeaguesID;
import sofaScore.models.utilities.HashMapSeasonsID;
import util.HttpUtil;

public class SeasonCollector {
	
	private final HttpUtil httpUtil = new HttpUtil();
	private final String API_SOFA_SCORE_SEASON_ROUNDS_URL = "https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/team-of-the-week/rounds";
	private final String API_SOFA_SCORE_CURRENT_ROUND_URL ="https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/rounds";
	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID(); 
	RoundCollector roundCollerctor = new RoundCollector();
	GameCollector gameCollector = new GameCollector();
	
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
	
	public GameStatisticNew getGamesStatisticNewInSeason(String competitionName, String competitionYears){
	
		int limit = getNumberOfFinishedRoundInSeason(competitionName, competitionYears);
		GameStatisticNew seasonStatistic = roundCollerctor.getGamesStatisticNewInRound(competitionName, competitionYears , String.valueOf(1));
		for(int i =1 ; i <= limit ; i++) {
			GameStatisticNew roundStatistic = roundCollerctor.getGamesStatisticNewInRound(competitionName, competitionYears , String.valueOf(i));
			seasonStatistic.itHaveTheSameTo(roundStatistic);
		}
		Collections.sort(seasonStatistic.statistics);
		return seasonStatistic; 

	}
	

	
	
}
