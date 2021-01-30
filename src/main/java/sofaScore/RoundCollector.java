package sofaScore;

import java.util.ArrayList;
import com.google.gson.Gson;
import csvFile.CSVDealer;
import csvFile.CSVDealerForGetInforamtion;
import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameStatistics.GameStatistics;
import sofaScore.models.utilities.HashMapLeaguesID;
import sofaScore.models.utilities.HashMapSeasonsID;
import sofaScore.models.utilities.SeasonIDObject;
import util.HttpUtil;


public class RoundCollector {

	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID(); 
	private final HttpUtil httpUtil = new HttpUtil();
	GameCollector gameCollector = new GameCollector();
	CSVDealerForGetInforamtion csvGetterString = new CSVDealerForGetInforamtion();
	CSVDealer csvDealer = new CSVDealer();
	private final String API_SOFA_SCORE_ROUND_URL ="https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/events/round/%s";
	private final String API_SOFA_SCORE_ROUND_URL222 ="https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/events/round/%s%s";

	/***
	 * @param competitionName for example ( Premier League , La Liga  , Bundesliga , .....)
	 * @param competitionYears  for example (2020/2021 , 2009/2021 , ....)
	 * @param round for example 1 , 4 , 10 , 20 , .......
	 * from this url  https://api.sofascore.com/api/v1/unique-tournament/Competition's ID/season/Season's ID/events/round/ Round Number
	 * we extract games' ids for the round
	 * competition's id = 17 English Premier League
	 * season's id = 23776 for season 2019/2020
	 * round's number  =3 the third round in league
	 * 
	 * @return arraylist of game' id
	 */
	
	public RoundGamesID getGamesIdInRound(String competitionName, String competitionYears , String round) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_ROUND_URL,leagueId.getLeagueID(competitionName), seasonId.getSeasonID(competitionName , competitionYears),round));
		if(gsonString.contains("Not Found")) {return null;}
		Gson gson = new Gson();
		RoundGamesID gamesId = gson.fromJson(gsonString, RoundGamesID.class);
		return gamesId;
	}
	
	/**
	 * @param competitionName for example ( Premier League , La Liga  , Bundesliga , .....)
	 * @param competitionYears  for example (2020/2021 , 2009/2021 , ....)
	 * @param round for example 1 , 4 , 10 , 20 , .......
	 * write round's games (game basic information and game statistics) into file
	 */
	public void writeRound(String competitionName, String competitionYears , String round) {
	
		RoundGamesID gamesIdInRound = getGamesIdInRound(competitionName , competitionYears , round);
		if((gamesIdInRound == null) ||(gamesIdInRound.events == null) ||(gamesIdInRound.events.isEmpty())) {
			csvDealer.write("SofaScore", competitionName, "no information about season "+competitionYears +"in round "+round, true, "NOStatistic");
		}
		else {
			for(int i =0 ; i < gamesIdInRound.events.size(); i++) {
				GameStatistics gameStatistic = gameCollector.getGameStatistics(gamesIdInRound.events.get(i).id);
				GameBasicInformation gameBasicInfromation = gameCollector.getGameBasicInformation(gamesIdInRound.events.get(i).id);
				//the game was played 
				//but in la liga 2013-2014 round 37 (description == removed , type == finished) we must know all values
				if(  (gameBasicInfromation.event.status.description.equals("Ended")||gameBasicInfromation.event.status.description.equals("Removed")) 
						&&  gameBasicInfromation.event.status.type.equals("finished") ) {
					if((i==0)&&(Integer.valueOf(round)==1)) {//first game to write the header
							csvDealer.write("SofaScore", competitionName, csvGetterString.getHeaderStringForCSV(gameBasicInfromation) + csvGetterString.getHeaderStringForCSV(gameStatistic), true, "Statistic");
					}
						csvDealer.write("SofaScore", competitionName, csvGetterString.getValuesStringForCSV(gameBasicInfromation)+ csvGetterString.getValuesStringForCSV(gameStatistic), false, "Statistic");
				}
				else if(gameBasicInfromation.event.status.description.equals("Not started") && gameBasicInfromation.event.status.type.equals("notstarted")) {//not played yet
					if((i==0)&&(Integer.valueOf(round)==1)) {//first game to write the header
						csvDealer.write("SofaScore", competitionName, csvGetterString.getHeaderStringForCSV(gameBasicInfromation) + csvGetterString.getHeaderStringForCSV(gameStatistic), true, "Statistic");
					}
					csvDealer.write("SofaScore", competitionName, csvGetterString.getValuesStringForCSV(gameBasicInfromation) + "  the game "+i+"  with id "+ gamesIdInRound.events.get(i).id+" at round "+ round +"  is not started", false, "Statistic");// header must be values now just for test
				}
				else{// if the match has been canceled
					if((i==0)&&(Integer.valueOf(round)==1)) {//first game to write the header
						csvDealer.write("SofaScore", competitionName, csvGetterString.getHeaderStringForCSV(gameBasicInfromation) + csvGetterString.getHeaderStringForCSV(gameStatistic), true, "Statistic");
					}
					csvDealer.write("SofaScore", competitionName, csvGetterString.getValuesStringForCSV(gameBasicInfromation) + "  the game "+i+"  with id "+ gamesIdInRound.events.get(i).id+" at round "+ round +"  is cancelled", false, "Statistic");// header must be values now just for test
				}
			}
		}
	}
	
	/***
	 * @param competitionName for example ( Premier League , La Liga  , Bundesliga , .....)
	 * @param competitionYears  for example (2020/2021 , 2009/2021 , ....)
	 * @param round for example 1 , 4 , 10 , 20 , .......
	 * from this url  https://api.sofascore.com/api/v1/unique-tournament/Competition's ID/season/Season's ID/events/round/ Round Number
	 * we extract games' ids for the round
	 * competition's id = 17 English Premier League
	 * season's id = 23776 for season 2019/2020
	 * round's number  =3 the third round in league
	 * 
	 * @return arraylist of game' id
	 */
	
	public RoundGamesID getGamesIdInRound222(String competitionName, String competitionYears , String round , String roundKind) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_ROUND_URL222,leagueId.getLeagueID(competitionName), seasonId.getSeasonID(competitionName , competitionYears),round,roundKind));
		System.out.println(competitionName + "   " + competitionYears + "  round " + round);
		System.out.println(String.format(API_SOFA_SCORE_ROUND_URL222,leagueId.getLeagueID(competitionName), seasonId.getSeasonID(competitionName , competitionYears),round,roundKind));

		if(gsonString.contains("Not Found")) {return null;}
		Gson gson = new Gson();
		RoundGamesID gamesId = gson.fromJson(gsonString, RoundGamesID.class);
		return gamesId;
	}
	
	/**
	 * @param competitionName for example ( Premier League , La Liga  , Bundesliga , .....)
	 * @param competitionYears  for example (2020/2021 , 2009/2021 , ....)
	 * @param round for example 1 , 4 , 10 , 20 , .......
	 * write round's games (game basic information and game statistics) into file
	 */
	public void writeRound222(String competitionName, String competitionYears , String round , String roundKind) {
	
		RoundGamesID gamesIdInRound = getGamesIdInRound222(competitionName , competitionYears , round, roundKind);
		if((gamesIdInRound == null) ||(gamesIdInRound.events == null) ||(gamesIdInRound.events.isEmpty())) {
			csvDealer.write("SofaScore", competitionName, "no information about season "+competitionYears +"in round "+round, true, "NOStatistic");
		}
		else {
			for(int i =0 ; i < gamesIdInRound.events.size(); i++) {
				GameStatistics gameStatistic = gameCollector.getGameStatistics(gamesIdInRound.events.get(i).id);
				GameBasicInformation gameBasicInfromation = gameCollector.getGameBasicInformation(gamesIdInRound.events.get(i).id);
				//the game was played 
				//but in la liga 2013-2014 round 37 (description == removed , type == finished) we must know all values
				if(  (gameBasicInfromation.event.status.description.equals("Ended")||gameBasicInfromation.event.status.description.equals("Removed")
						||(gameBasicInfromation.event.status.description.equals("AP"))) 
						&&  gameBasicInfromation.event.status.type.equals("finished") ) {
					if((i==0)&&(Integer.valueOf(round)==1)) {//first game to write the header
							csvDealer.write("SofaScore", competitionName, csvGetterString.getHeaderStringForCSV(gameBasicInfromation) + csvGetterString.getHeaderStringForCSV(gameStatistic), true, "Statistic");
					}
						csvDealer.write("SofaScore", competitionName, csvGetterString.getValuesStringForCSV(gameBasicInfromation)+ csvGetterString.getValuesStringForCSV(gameStatistic), false, "Statistic");
				}
				else{// if the match has been canceled
					if((i==0)&&(Integer.valueOf(round)==1)) {//first game to write the header
						csvDealer.write("SofaScore", competitionName, csvGetterString.getHeaderStringForCSV(gameBasicInfromation) + csvGetterString.getHeaderStringForCSV(gameStatistic), true, "Statistic");
					}
					csvDealer.write("SofaScore", competitionName, csvGetterString.getValuesStringForCSV(gameBasicInfromation) + "  the game "+i+"  with id "+ gamesIdInRound.events.get(i).id+" at round "+ round +"  is cancelled", false, "Statistic");// header must be values now just for test
				}
			}
		}
	}


	/**
	 * 
	 * @param competitionName for example (Premier League  , La Liga , .....)
	 * @param competitionYears for example (2020/2021 , 2019/2020 , 2013/2014 , ....)
	 * @param round for example (1 , 3 , 15 , ...)
	 * @return played games' ids
	 * from this url https://api.sofascore.com/api/v1/unique-tournament/League's ID/season/season's ID/events/round/round's number
     * English primer league id is 17 , la liga id is 8
 	 * for season 2019/2020 id in english primer league is 23776 
	 */
	
	
	public RoundGamesID getPlayedGamesIdInRound(String competitionName, String competitionYears , String round) {
			
			String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_ROUND_URL,leagueId.getLeagueID(competitionName), seasonId.getSeasonID(competitionName ,competitionYears),round));
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

