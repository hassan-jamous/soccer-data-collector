package sofaScore;

import java.util.Collections;

import com.google.gson.Gson;

import csvFile.CSVDealer;
import sofaScore.models.gameStatistics.GameStatistics;
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
	CSVDealer csvDealer = new CSVDealer();
	
	public Season getAllRoundsInformationInSeason(String competitionName , String competitionYears) {

		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_SEASON_ROUNDS_URL,leagueId.getLeagueID(competitionName), seasonId.get(competitionName + " " + competitionYears)));
		Gson gson = new Gson();
		Season season = gson.fromJson(gsonString, Season.class);
		if(season.rounds.get(season.rounds.size()-1).roundName.equals("Season")) {
			season.rounds.remove(season.rounds.size()-1);
		}
		return season;
	}
	
	public Integer getNumberOfFinishedRoundInSeason(String competitionName , String competitionYears) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_SEASON_ROUNDS_URL,leagueId.getLeagueID(competitionName), seasonId.get(competitionName + " " + competitionYears)));
		Gson gson = new Gson();
		Season season = gson.fromJson(gsonString, Season.class);
		if(season.rounds == null) {return null;}
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
	
	public GameStatistics getGamesStatisticNewInSeason(String competitionName, String competitionYears){
	
		int limit = getCurrentRound(competitionName, competitionYears);
		GameStatistics seasonStatistic = roundCollerctor.getRoundGamesStatistic(competitionName, competitionYears , String.valueOf(1));
		int j =2;
		while ((j <= limit) && (seasonStatistic == null)) {
			seasonStatistic = roundCollerctor.getRoundGamesStatistic(competitionName, competitionYears , String.valueOf(j));
			j++;			
		}
		if ((seasonStatistic == null) || (seasonStatistic.statistics == null)) {
			return null;
		}
		for(int i =j ; i <= limit ; i++) {
			
			GameStatistics roundStatistic = roundCollerctor.getRoundGamesStatistic(competitionName, competitionYears , String.valueOf(i));
			if((roundStatistic != null) && (roundStatistic.statistics != null)) {
				seasonStatistic.makeItHaveTheSameTo(roundStatistic);
			}
		}
		Collections.sort(seasonStatistic.statistics);
		return seasonStatistic; 
	}
	
	public void writeSeason(String competitionName, String competitionYears) {
		
		GameStatistics  seasonStatistic = getGamesStatisticNewInSeason(competitionName, competitionYears);
		//no statistics for this season so just print the basic information
		//must delete if and else they are the same
		if(seasonStatistic == null) {
			int limit = getCurrentRound(competitionName, competitionYears);
			for(int i =1 ; i <= limit ; i++) {
				roundCollerctor.writeRoundFromSeason(competitionName, competitionYears , String.valueOf(i), seasonStatistic);
			}
		}
		else {
			int limit = getCurrentRound(competitionName, competitionYears);
			for(int i =1 ; i <= limit ; i++) {
				roundCollerctor.writeRoundFromSeason(competitionName, competitionYears , String.valueOf(i), seasonStatistic);
			}
		}
	}
	
	
}
