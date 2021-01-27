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
import util.HttpUtil;


public class RoundCollector {

	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID(); 
	private final HttpUtil httpUtil = new HttpUtil();
	GameCollector gameCollector = new GameCollector();
	CSVDealerForGetInforamtion csvGetterString = new CSVDealerForGetInforamtion();
	CSVDealer csvDealer = new CSVDealer();
	private final String API_SOFA_SCORE_ROUND_URL ="https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/events/round/%s";
	
	/***
	 * from this url  https://api.sofascore.com/api/v1/unique-tournament/Competition's ID/season/Season's ID/events/round/ Round Number
	 * we extract games' ids for the round
	 * @param competition's id = 17 English Premier League
	 * @param season's id = 23776 for season 2019/2020
	 * @param round's number  =3 the third round in league
	 * 
	 * @return arraylist of game' id
	 */
	
	public RoundGamesID getGamesIdInRound(String competitionName, String competitionYears , String round) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_ROUND_URL,leagueId.getLeagueID(competitionName), seasonId.get(competitionName + " " + competitionYears),round));
		Gson gson = new Gson();
		RoundGamesID gamesId = gson.fromJson(gsonString, RoundGamesID.class);
		return gamesId;
	}
	
 void writeRound(String competitionName, String competitionYears , String round) {
	
		RoundGamesID gamesIdInRound = getGamesIdInRound(competitionName , competitionYears , round);
		for(int i =0 ; i < gamesIdInRound.events.size(); i++) {
			GameStatistics gameStatistic = gameCollector.getGameStatistics(gamesIdInRound.events.get(i).id);
			GameBasicInformation gameBasicInfromation = gameCollector.getGameBasicInformation(gamesIdInRound.events.get(i).id);
			//the game was played 
			//but in la liga 2013-2014 round 37 (description == removed , type == finished) we must know all values
			if(  (gameBasicInfromation.event.status.description.equals("Ended")||gameBasicInfromation.event.status.description.equals("Removed")) 
					&&  gameBasicInfromation.event.status.type.equals("finished") ) {
				if((i==0)&&(Integer.valueOf(round)==1)) {//first game to write the header
						csvDealer.write2("SofaScore", competitionName, csvGetterString.getHeaderStringForCSV(gameBasicInfromation) + csvGetterString.getHeaderStringForCSV(gameStatistic), true, "statistic");
				}
					csvDealer.write2("SofaScore", competitionName, csvGetterString.getValuesStringForCSV(gameBasicInfromation)+ csvGetterString.getValuesStringForCSV(gameStatistic), false, "statistic");
			}
			else{// if the match has been canceled
				if((i==0)&&(Integer.valueOf(round)==1)) {//first game to write the header
					csvDealer.write2("SofaScore", competitionName, csvGetterString.getHeaderStringForCSV(gameBasicInfromation) + csvGetterString.getHeaderStringForCSV(gameStatistic), true, "statistic");
				}
				csvDealer.write2("SofaScore", competitionName, csvGetterString.getValuesStringForCSV(gameBasicInfromation) + "  null statistic for game "+i +"  with id "+ gamesIdInRound.events.get(i).id+" at round "+ round, false, "statistic");// header must be values now just for test
			}
		}
	}

	/**
	 * 
	 * @param competitionName for example (Premier League  , La Liga , .....)
	 * @param competitionYears for example (20/21 , 19/20 , 13/14 , ....)
	 * @param round for example (1 , 3 , 15 , ...)
	 * @return played games' ids
	 * from this url https://api.sofascore.com/api/v1/unique-tournament/League's ID/season/season's ID/events/round/round's number
     * English primer league id is 17 , la liga id is 8
 	 * for season 2019/2020 id in english primer league is 23776 
	 */
	
	
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

