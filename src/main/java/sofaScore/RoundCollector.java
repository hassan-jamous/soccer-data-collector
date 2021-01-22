package sofaScore;

import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.Gson;
import csvFile.CSVDealer;
import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameStatistics.GameStatisticNew;
import sofaScore.models.utilities.HashMapLeaguesID;
import sofaScore.models.utilities.HashMapSeasonsID;
import util.HttpUtil;

public class RoundCollector {

	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID(); 
	private final HttpUtil httpUtil = new HttpUtil();
	GameCollector gameCollector = new GameCollector();
	CSVDealer csvDealer = new CSVDealer();
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
	
	public GameStatisticNew getRoundGamesStatistic(String competitionName, String competitionYears , String round){
		
		RoundGamesID gamesIdInRound = getGamesIdInRound(competitionName , competitionYears , round);
		if((gamesIdInRound == null) || (gamesIdInRound.events.isEmpty())) {
			//not error so i can not throw an exception just to check what happened or throw an exception
			System.out.println("no games id in this round " + round +"  at " + competitionYears );
			return null;
		}
		GameStatisticNew resultGameStastiscs = new GameStatisticNew();
		int j = 0; 
		while ((j < gamesIdInRound.events.size())&& (resultGameStastiscs == null)) {
			String gameId = gamesIdInRound.events.get(j).id;
			resultGameStastiscs = gameCollector.getGameStatistics(gameId);
			j++;
		}
		if((j ==gamesIdInRound.events.size() && 
				(((resultGameStastiscs == null)) ||(resultGameStastiscs.statistics == null)))) {
			return null;
		}
		for(int i =j; i < gamesIdInRound.events.size(); i++) {
			String gameId = gamesIdInRound.events.get(i).id;
			GameStatisticNew gameStastiscs = gameCollector.getGameStatistics(gameId);
			if((gameStastiscs != null) && (gameStastiscs.statistics != null)) {			
				resultGameStastiscs.makeItHaveTheSameTo(gameStastiscs);
				Collections.sort(resultGameStastiscs.statistics);
			}
		}
		return resultGameStastiscs; 
	} 

	public void writeRoundFromSeason(String competitionName, String competitionYears , String round , GameStatisticNew  seasonStatistic) {
		
		RoundGamesID gamesIdInRound = getGamesIdInRound(competitionName , competitionYears , round);
		if( seasonStatistic!= null) {
			for(int i =0 ; i < gamesIdInRound.events.size(); i++) {
				GameStatisticNew gameStatistic = gameCollector.getGameStatistics(gamesIdInRound.events.get(i).id);
				GameBasicInformation gameBasicInfromation = gameCollector.getGameBasicInformation(gamesIdInRound.events.get(i).id);
				//the game was played
				if((gameBasicInfromation.event.status.description.equals("Ended") && (gameBasicInfromation.event.status.type.equals("finished")))) {
					if(gameStatistic == null) {gameStatistic = new GameStatisticNew();}
					//make all game have the same statistics
					gameStatistic.makeItHaveTheSameTo(seasonStatistic);
					//i think we want to discuss a better solution to determine which game is the first
					//i mean better than if(i==0)&&(round==1)
					//it depends on how we send the data if String so we want else , or object we do not want it
					if((i==0)&&(Integer.valueOf(round)==1)) {
							csvDealer.write("SofaScore", competitionName, competitionYears,gameBasicInfromation.write("header")+ gameStatistic.write("header"), true, "statistic");
							csvDealer.write("SofaScore", competitionName, competitionYears,gameBasicInfromation.write("header")+ gameStatistic.write("header")+"  here must be value", false, "statistic");
					}
					else {
						//it must be write(values) but now for test , every game has the same statistics
						csvDealer.write("SofaScore", competitionName, competitionYears, gameBasicInfromation.write("header")+ gameStatistic.write("header")+"  here must be value", false, "statistic");// header must be values now just for test
					}
				}
				else{// if the match has been canceled
						csvDealer.write("SofaScore", competitionName, competitionYears,gameBasicInfromation.write("header")+ "  null statistic for game "+i +"  with id "+ gamesIdInRound.events.get(i).id+" at round "+ round, false, "statistic");// header must be values now just for test
				}
			}
		}
		else {//no statistics  for this season
			for(int i =0 ; i < gamesIdInRound.events.size(); i++) {
				GameBasicInformation gameBasicInfromation = gameCollector.getGameBasicInformation(gamesIdInRound.events.get(i).id);
				if((gameBasicInfromation.event.status.description.equals("Ended") && (gameBasicInfromation.event.status.type.equals("finished")))) {
					//it depends on how we send the data if String so we want else , or object we do not want it
					//
					if((i==0)&&(Integer.valueOf(round)==1)) {
							csvDealer.write("SofaScore", competitionName, competitionYears,gameBasicInfromation.write("header")+"(no statistics in this season)  header", true, "statistic");
							csvDealer.write("SofaScore", competitionName, competitionYears,gameBasicInfromation.write("header")+"(no statistics in this season)  here must be value", false, "statistic");
					}
					else {
						//it must be write(values) but now for test , every game has the same statistics
						csvDealer.write("SofaScore", competitionName, competitionYears, gameBasicInfromation.write("header")+" (no statistics in this season)  here must be value", false, "statistic");// header must be values now just for test
					}
				}
				else{// if the match has been canceled
					if((i==0)&&(Integer.valueOf(round)==1)) {
						csvDealer.write("SofaScore", competitionName, competitionYears,gameBasicInfromation.write("header")+"(no statistics in this season)  header", true, "statistic");
					}
					csvDealer.write("SofaScore", competitionName, competitionYears,gameBasicInfromation.write("header")+ " the game is cancaled "+ i +"  with id "+ gamesIdInRound.events.get(i).id+" at round "+ round, false, "statistic");// header must be values now just for test
				}				
			}
		}		
	}
	
	public RoundGamesID getPlayedGamesIdInRound(String competitionName, String competitionYears , String round) {
			
			String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_ROUND_URL,leagueId.getLeagueID(competitionName), seasonId.get(competitionName + " " + competitionYears),round));
			Gson gson = new Gson();
			RoundGamesID gamesId = gson.fromJson(gsonString, RoundGamesID.class);
			RoundGamesID result = new RoundGamesID();
			for(int i =0 ; i < gamesId.events.size() ; i++) {
				GameBasicInformation gameBasicInformation = gameCollector.getGameBasicInformation(String.valueOf(gamesId.events.get(i).id));
				if(gameBasicInformation.event.status.description.equals("Not started")) {}//there are many descriptions 
				else if(gameBasicInformation.event.status.description.equals("Ended")) {
					if(result.events == null) {result.events = new ArrayList<>();}
					result.events.add(gamesId.events.get(i));
				}			
			}
			return result;
		}
}

