package sofaScore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameIecidents.GameIncidents;
import sofaScore.models.gameIecidents.IncidentInGame;
import sofaScore.models.gameIecidents.IncidentInGameCard;
import sofaScore.models.gameIecidents.IncidentInGameSubstitution;
import sofaScore.models.gameIecidents.IncidentInGameGoal;
import sofaScore.models.gameIecidents.IncidentInGamePeriod;
import sofaScore.models.gameIecidents.IncidentInGameInjuryTime;
import sofaScore.models.gameIecidents.IncidentInGamePenalty;
import sofaScore.models.gameIecidents.IncidentInGameVarDecision;
import sofaScore.models.gameIecidents.IncidentsGameDeserializer;
import sofaScore.models.gameStatistics.GameStatistics;
import sofaScore.models.gameStatistics.GameStatisticsForOneItem;
import util.HttpUtil;

/**
 * collect games information like( statistics , incidentInGames  and basic information)
 * for example arsenal vs new castle united in round 19 at season 2020-2021 (game id is 8897048) 
 *  
 * from this url [  https://api.sofascore.com/api/v1/event/8897048/statistics  ] we extract the statistics
 * for example statistics likes [ (Ball possession: home =66% , away=34%),(Shots off target: home=6 away=1)] 
 * this statistics for all periods (ALL= the game , 1ST = first half , 2ND = second half) if the site provides these information
 * old leagues do not contains any information
 * 
 * from this url [  https://api.sofascore.com/api/v1/event/8897048/incidentInGames  ] we extract the incidentInGames
 * incidentInGames likes( goal , substitution , red card....)
 * 
 * from this url [  https://api.sofascore.com/api/v1/event/8897048  ] we extract basic information
 * basic information likes ( home team arsenal , away team new castle united , in round 19 
 * season .. , home score .. , away score .. , status the game is played or postponed) 
 */
public class GameCollector {

	private final String API_SOFA_SCORE_GAME_URL_FOR_BASIC = "https://api.sofascore.com/api/v1/event/%s";
	private final String API_SOFA_SCORE_GAME_URL_FOR_STATISTICS ="https://api.sofascore.com/api/v1/event/%s/statistics";
	private final String API_SOFA_SCORE_GAME_URL_FOR_INCIDENTS ="https://api.sofascore.com/api/v1/event/%s/incidents";
	private final HttpUtil httpUtil = new HttpUtil();
    private Gson gson = new Gson();
 
   //i prefer my solution for these Reasons
   //1 - we want the statistics are ranked in groups like the site
   //2 - when add item to statistics(as HashTree not only HashSet -ranking in groups-) the item is added at the end , that breaks "group"
   //		for example we will see yellow cards' statistics at the middle and red cards' statistics at the end !!!
  
  //  public TreeSet<String> getGameStatisticsASString(String gameID) {
    //	String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_URL_FOR_STATISTICS, gameID ));
	//	if(gsonString.contains("Not Found")) {return null;}
	//	JsonElement  jsonElement = JsonParser.parseString(gsonString);
	//	JsonArray statisticsArray = jsonElement.getAsJsonObject().get("statistics").getAsJsonArray();
//		TreeSet<String> result = new TreeSet<String>();
	//	for(int i =0 ; i < statisticsArray.size() ; i++) {
		//	String peroid = statisticsArray.get(i).getAsJsonObject().get("period").getAsString();
		//	if(peroid.equals("1ST")) {peroid = "FirstHalf";}
			//if(peroid.equals("2ND")) {peroid = "SecondHalf";}
			//JsonArray groupsInPeriod = statisticsArray.get(i).getAsJsonObject().getAsJsonArray("groups");
		//	for(int i1 = 0 ; i1 < groupsInPeriod.size(); i1++) {
			//	String groupName = groupsInPeriod.get(i1).getAsJsonObject().get("groupName").getAsString();
		//		JsonArray statisticsItems = groupsInPeriod.get(i1).getAsJsonObject().getAsJsonArray("statisticsItems");
			//	for(int i2 =0 ; i2 < statisticsItems.size() ; i2++) {
				//	JsonElement item = statisticsItems.get(i2);
					//String name =item.getAsJsonObject().get("name").getAsString();
	//				String away =item.getAsJsonObject().get("away").getAsString();
		//			String home =item.getAsJsonObject().get("home").getAsString();
			//		String statisticAsStringHome = peroid+groupName+name;
				//	statisticAsStringHome = statisticAsStringHome.replaceAll("\\s+", "");
					//result.add(statisticAsStringHome);
//				}
	//		}
		//}
//		if((  (result == null)   || (result.isEmpty()) )) {return null;}
	//	return result;
   // }
    
    public GameStatistics getGameStatistics(String gameID) {

		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_URL_FOR_STATISTICS, gameID ));
		if(gsonString.contains("Not Found")) {return null;}
		JsonElement  jsonElement = JsonParser.parseString(gsonString);
		JsonArray statisticsArray = jsonElement.getAsJsonObject().get("statistics").getAsJsonArray();
		GameStatistics gamesInfo = new  GameStatistics();
		for(int i =0 ; i < statisticsArray.size() ; i++) {
			String peroid = statisticsArray.get(i).getAsJsonObject().get("period").getAsString();
			JsonArray groupsInPeriod = statisticsArray.get(i).getAsJsonObject().getAsJsonArray("groups");
			for(int i1 = 0 ; i1 < groupsInPeriod.size(); i1++) {
				String groupName = groupsInPeriod.get(i1).getAsJsonObject().get("groupName").getAsString();
				JsonArray statisticsItems = groupsInPeriod.get(i1).getAsJsonObject().getAsJsonArray("statisticsItems");
				for(int i2 =0 ; i2 < statisticsItems.size() ; i2++) {
					JsonElement item = statisticsItems.get(i2);
					String name =item.getAsJsonObject().get("name").getAsString();
					String away =item.getAsJsonObject().get("away").getAsString();
					String home =item.getAsJsonObject().get("home").getAsString();
					GameStatisticsForOneItem gameStatistic = new GameStatisticsForOneItem(peroid,groupName,name,home,away);
					if(gamesInfo.statistics == null) {gamesInfo.statistics = new ArrayList<>();}
					gamesInfo.statistics.add(gameStatistic);
				}
			}
		}
		if((  (gamesInfo == null)  ||(  gamesInfo.statistics == null) || (gamesInfo.statistics.isEmpty()) )) {return null;}
		Collections.sort((List<GameStatisticsForOneItem>)gamesInfo.statistics);
		return gamesInfo;
	}
    
 	public GameIncidents getGameIncidents(String gameID) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_URL_FOR_INCIDENTS, gameID ));		
		IncidentsGameDeserializer deserializer = new IncidentsGameDeserializer("incidentType");
		deserializer.registerIncidentType("card", IncidentInGameCard.class);
		deserializer.registerIncidentType("goal", IncidentInGameGoal.class);
		deserializer.registerIncidentType("injuryTime", IncidentInGameInjuryTime.class);
		deserializer.registerIncidentType("inGamePenalty", IncidentInGamePenalty.class);
		deserializer.registerIncidentType("period", IncidentInGamePeriod.class);
		deserializer.registerIncidentType("substitution", IncidentInGameSubstitution.class);
		deserializer.registerIncidentType("varDecision", IncidentInGameVarDecision.class);
		JsonElement  jsonElement = JsonParser.parseString(gsonString);
		JsonArray incidents = jsonElement.getAsJsonObject().getAsJsonArray("incidents");
		Gson gson = new GsonBuilder().registerTypeAdapter(IncidentInGame.class, deserializer).create();
		GameIncidents  result = new GameIncidents();
		if(result.incidentInGames == null) {result.incidentInGames = new ArrayList<>();}
		result.incidentInGames = gson.fromJson(incidents, new TypeToken<List<IncidentInGame>>(){}.getType());
		if((result == null)||(result.incidentInGames.isEmpty())) {return null;}
		return result;

	}

    public GameBasicInformation getGameBasicInformation(String gameID) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_URL_FOR_BASIC , gameID));
	    GameBasicInformation gameBasicInformation = gson.fromJson(gsonString, GameBasicInformation.class) ;
		return gameBasicInformation;
	}

}
