package sofaScore;

import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.Gson;
import csvFile.CSVDealer;
import csvFile.CSVDealerForGetInforamtion;
import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameStatistics.GameStatistics;
import sofaScore.models.utilities.HashMapLeaguesID;
import sofaScore.models.utilities.HashMapSeasonsID;
import util.HttpUtil;

/**
 * 
 * collect rounds information like games' ids in this round from this url [https://api.sofascore.com/api/v1/unique-tournamentInGame/competition's ID/season/season's ID/events/round/round's number]
 * for example from this url [ https://api.sofascore.com/api/v1/unique-tournamentInGame/17/season/29415/events/round/3  ]
 * competition's ID =17 English Premier League
 * season's ID = 29415 season 20/21
 * round's number = 3
 * 
 */
public class RoundCollector {

	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID(); 
	private final HttpUtil httpUtil = new HttpUtil();
	GameCollector gameCollector = new GameCollector();
	CSVDealerForGetInforamtion csvGetterString = new CSVDealerForGetInforamtion();
	CSVDealer csvDealer = new CSVDealer();
	private final String API_SOFA_SCORE_ROUND_URL ="https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/events/round/%s";
	
	/***
	 * 
	 * @param competitionName example Premier League
	 * @param competitionYears example 05/06
	 * @param rounndNumber example (1 or 17 )
	 * @return RoundGamesID (list of String as games' ids) to use them in class GameCollector as parameters for his methods as(gameID)
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
	
	public GameStatistics getRoundGamesStatistic(String competitionName, String competitionYears , String round){
		
		RoundGamesID gamesIdInRound = getGamesIdInRound(competitionName , competitionYears , round);
		if((gamesIdInRound == null) || (gamesIdInRound.events.isEmpty())) {
			//but we must return null
			//not error so i can not throw an exception just to check what happened or throw an exception
			throw new RuntimeException("no games id in this round " + round +"  at " + competitionYears );
		}
		GameStatistics resultGameStastiscs = new GameStatistics();
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
			GameStatistics gameStastiscs = gameCollector.getGameStatistics(gameId);
			if((gameStastiscs != null) && (gameStastiscs.statistics != null)) {			
				resultGameStastiscs.makeItHaveTheSameTo(gameStastiscs);
				Collections.sort(resultGameStastiscs.statistics);
			}
		}
		return resultGameStastiscs; 
	} 

	public void writeRoundFromSeason(String competitionName, String competitionYears , String round , GameStatistics  seasonStatistic) {
		
		RoundGamesID gamesIdInRound = getGamesIdInRound(competitionName , competitionYears , round);
		if( seasonStatistic!= null) {
			for(int i =0 ; i < gamesIdInRound.events.size(); i++) {
				GameStatistics gameStatistic = gameCollector.getGameStatistics(gamesIdInRound.events.get(i).id);
				GameBasicInformation gameBasicInfromation = gameCollector.getGameBasicInformation(gamesIdInRound.events.get(i).id);
				//the game was played 
				//but in la liga 2013-2014 round 37 (description == removed , type == finished)
				if(  (gameBasicInfromation.event.status.description.equals("Ended")||gameBasicInfromation.event.status.description.equals("Removed")) 
						&&  gameBasicInfromation.event.status.type.equals("finished") ) {
					if(gameStatistic == null) {gameStatistic = new GameStatistics();}
					//make all game have the same statistics
					gameStatistic.makeItHaveTheSameTo(seasonStatistic);
					//i think we want to discuss a better solution to determine which game is the first
					//i mean better than if(i==0)&&(round==1) ,the solution i suggest is to print seasonStatistic if the first match from the first round is canceled 
					//it depends on how we send the data if String so we want else , or object we do not want it
					if((i==0)&&(Integer.valueOf(round)==1)) {
							csvDealer.write("SofaScore", competitionName, competitionYears,csvGetterString.getHeaderStringForCSV(gameBasicInfromation) + csvGetterString.getHeaderStringForCSV(gameStatistic), true, "statistic");
							csvDealer.write("SofaScore", competitionName, competitionYears,csvGetterString.getValuesStringForCSV(gameBasicInfromation) +csvGetterString.getValuesStringForCSV(gameStatistic), false, "statistic");
					}
					else {
						//it must be write(values) but now for test , every game has the same statistics
						csvDealer.write("SofaScore", competitionName, competitionYears,csvGetterString.getValuesStringForCSV(gameBasicInfromation)+ csvGetterString.getValuesStringForCSV(gameStatistic), false, "statistic");// header must be values now just for test
					}
				}
				else{// if the match has been canceled
					if((i==0)&&(Integer.valueOf(round)==1)) {
						csvDealer.write("SofaScore", competitionName, competitionYears,csvGetterString.getHeaderStringForCSV(gameBasicInfromation) + csvGetterString.getHeaderStringForCSV(gameStatistic), true, "statistic");// header must be values now just for test
					}
					csvDealer.write("SofaScore", competitionName, competitionYears,csvGetterString.getValuesStringForCSV(gameBasicInfromation) + "  null statistic for game "+i +"  with id "+ gamesIdInRound.events.get(i).id+" at round "+ round, false, "statistic");// header must be values now just for test
				}
			}
		}
		else {//no statistics  for this season
			for(int i =0 ; i < gamesIdInRound.events.size(); i++) {
				GameBasicInformation gameBasicInfromation = gameCollector.getGameBasicInformation(gamesIdInRound.events.get(i).id);
				if(  (gameBasicInfromation.event.status.description.equals("Ended")||gameBasicInfromation.event.status.description.equals("Removed")) 
						&&  gameBasicInfromation.event.status.type.equals("finished") ) {					
					//it depends on how we send the data if String so we want else , or object we do not want it
					if((i==0)&&(Integer.valueOf(round)==1)) {
							csvDealer.write("SofaScore", competitionName, competitionYears,csvGetterString.getHeaderStringForCSV(gameBasicInfromation) +" (no statistics in this season)  header", true, "statistic");
							csvDealer.write("SofaScore", competitionName, competitionYears,csvGetterString.getValuesStringForCSV(gameBasicInfromation) +"(no statistics in this season)  here must be value", false, "statistic");
					}
					else {
						//it must be write(values) but now for test , every game has the same statistics
						csvDealer.write("SofaScore", competitionName, competitionYears, csvGetterString.getValuesStringForCSV(gameBasicInfromation)+" (no statistics in this season)  here must be value", false, "statistic");// header must be values now just for test
					}
				}
				else{// if the match has been canceled
					if((i==0)&&(Integer.valueOf(round)==1)) {
						csvDealer.write("SofaScore", competitionName, competitionYears,csvGetterString.getHeaderStringForCSV(gameBasicInfromation)+"(no statistics in this season)  header", true, "statistic");
					}
					csvDealer.write("SofaScore", competitionName, competitionYears,csvGetterString.getValuesStringForCSV(gameBasicInfromation)+ " the game is cancaled "+ i +"  with id "+ gamesIdInRound.events.get(i).id+" at round "+ round, false, "statistic");// header must be values now just for test
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

