package sofaScore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameIecidents.GameIecidents;
import sofaScore.models.gameIecidents.GameIencidentsGSON;
import sofaScore.models.gameIecidents.IencidentInGameChangePlayers;
import sofaScore.models.gameIecidents.IencidentInGameGoal;
import sofaScore.models.gameIecidents.IencidentInGameHeader;
import sofaScore.models.gameIecidents.IencidentInGameInjuryTime;
import sofaScore.models.gameIecidents.IencidentInGamePenalty;
import sofaScore.models.gameIecidents.IencidentInGameVarDecision;
import sofaScore.models.gameIecidents.InncidentInGameCard;
import sofaScore.models.gameStatistics.GameStatisticNew;
import sofaScore.models.gameStatistics.GameStatisticsForOneAttributeNew;
import util.HttpUtil;
/**
 * 
 * collect games information like( statistics and incidents)  
 *
 */
public class GameCollector {                                  
	private final String API_SOFA_SCORE_GAME_URL_FOR_BASIC = "https://api.sofascore.com/api/v1/event/";
	private final String API_SOFA_SCORE_GAME_URL ="https://api.sofascore.com/api/v1/event/%s/%s"; 
	private final HttpUtil httpUtil = new HttpUtil();

	public GameBasicInformation getGameBasicInformation(String gameId) {
		String gsonString = httpUtil.sendGetHttpRequest(API_SOFA_SCORE_GAME_URL_FOR_BASIC + gameId);
	    Gson gson = new Gson();
	    GameBasicInformation gameBasicInformation = gson.fromJson(gsonString, GameBasicInformation.class) ;
		return gameBasicInformation;
	}
	/***
	 * 
	 * @param gameID
	 * the same information in the last method but here store in new class 
	 * GameStatisticNew is array list of class contains five Strings(period , groupName , name ,home , away)
	 * 	for example (All , shots , shots on target , 10, 8)
	 * 	 * @return
	 */

	public GameStatisticNew getGameStatistics(String gameID) {

		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_URL, gameID , "statistics"));
		if(gsonString.contains("Not Found")) {return null;}
		JsonElement  jsonElement = JsonParser.parseString(gsonString);
		JsonArray statisticsArray = jsonElement.getAsJsonObject().get("statistics").getAsJsonArray();
		GameStatisticNew gamesInfo = new  GameStatisticNew();
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
					GameStatisticsForOneAttributeNew gameStatistic = new GameStatisticsForOneAttributeNew(peroid,groupName,name,home,away);
					if(gamesInfo.statistics == null) {gamesInfo.statistics = new ArrayList<>();}
					gamesInfo.statistics.add(gameStatistic);
				}
			}
		}
		if((  (gamesInfo == null)  ||(  gamesInfo.statistics == null) || (gamesInfo.statistics.isEmpty()) )) {return null;}
		Collections.sort((List<GameStatisticsForOneAttributeNew>)gamesInfo.statistics);
		return gamesInfo;
	}
    
	/**
	 * 
	 * @param gameID
	 * https://api.sofascore.com/api/v1/event/8896899/incidents 
	 * @return GameIecidents contains array list of Incident
	 */
	public GameIecidents getGameIncidents(String gameID) {
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_URL, gameID , "incidents"));
		Gson gson = new Gson();
		GameIencidentsGSON gameInfo = gson.fromJson(gsonString, GameIencidentsGSON.class);
		GameIecidents result = new GameIecidents();	
		if(result.iecidents == null) {result.iecidents = new ArrayList<>();}
		for(int i = 0 ; i< gameInfo.incidents.size(); i++) {
			if(gameInfo.incidents.get(i).incidentType.equals("period")) {
				IencidentInGameHeader header = getHeader(gameInfo, i);
				result.iecidents.add(header);
			}
			else if(gameInfo.incidents.get(i).incidentType.equals("injuryTime")) {
				result.iecidents.add(getInjuryTime(gameInfo, i));
			}
			else if(gameInfo.incidents.get(i).incidentType.equals("substitution")) {
				result.iecidents.add(getChangingEvent(gameInfo, i));
			}
			else if(gameInfo.incidents.get(i).incidentType.equals("goal")) {
				result.iecidents.add(getGoal(gameInfo, i));
			}
			else if(gameInfo.incidents.get(i).incidentType.equals("card")) {
				result.iecidents.add(getCard(gameInfo, i));
			}
			else if(gameInfo.incidents.get(i).incidentType.equals("varDecision")) {
				result.iecidents.add(getVarDecision(gameInfo, i));
			}
			else if(gameInfo.incidents.get(i).incidentType.equals("inGamePenalty")) {
				result.iecidents.add(getGamePenalty(gameInfo, i));
			}
			//if i do not recognize all types
			else {
				throw new RuntimeException("New GameBasicInformation Iecident Type i = " + i  +"   gameInfo's type is " + gameInfo.incidents.get(i).incidentType );
			}
		}
		if(result ==  null || result.iecidents.size() == 0) {return null;}
		return result;
	}
	
	private IencidentInGamePenalty getGamePenalty(GameIencidentsGSON gameInfo, int i) {
		IencidentInGamePenalty penalty = new IencidentInGamePenalty();
		penalty.time = gameInfo.incidents.get(i).time;
		penalty.player = gameInfo.incidents.get(i).player;
		penalty.description = gameInfo.incidents.get(i).description;
		penalty.id = gameInfo.incidents.get(i).id;
		penalty.isHome = gameInfo.incidents.get(i).isHome;
		penalty.incidentType = gameInfo.incidents.get(i).incidentType;
		penalty.incidentClass = gameInfo.incidents.get(i).incidentClass;		
		return penalty;
	}
	
	private IencidentInGameHeader getHeader(GameIencidentsGSON gameInfo, int i) {
		IencidentInGameHeader header =  new IencidentInGameHeader();
		header.incidentType = gameInfo.incidents.get(i).incidentType;
		header.addedTime = gameInfo.incidents.get(i).addedTime;
		header.awayScore = gameInfo.incidents.get(i).awayScore;
		header.homeScore = gameInfo.incidents.get(i).homeScore;
		header.isLive = gameInfo.incidents.get(i).isLive;
		header.text = gameInfo.incidents.get(i).text;
		header.time = gameInfo.incidents.get(i).time;
		return header;
	}

	private IencidentInGameInjuryTime getInjuryTime(GameIencidentsGSON gameInfo, int i) {
		IencidentInGameInjuryTime injuryTime = new IencidentInGameInjuryTime();
		injuryTime.addedTime = gameInfo.incidents.get(i).addedTime;
		injuryTime.incidentType = gameInfo.incidents.get(i).incidentType;
		injuryTime.length = gameInfo.incidents.get(i).length;
		injuryTime.time = gameInfo.incidents.get(i).time;
		return injuryTime;
	}

	private IencidentInGameChangePlayers getChangingEvent(GameIencidentsGSON gameInfo, int i) {
		IencidentInGameChangePlayers playerChanged = new IencidentInGameChangePlayers();		
		playerChanged.addedTime = gameInfo.incidents.get(i).addedTime;
		playerChanged.id = gameInfo.incidents.get(i).id;
		playerChanged.incidentClass = gameInfo.incidents.get(i).incidentClass;
		playerChanged.incidentType = gameInfo.incidents.get(i).incidentType;
		playerChanged.injury = gameInfo.incidents.get(i).injury;
		playerChanged.isHome = gameInfo.incidents.get(i).isHome;
		playerChanged.playerIn = gameInfo.incidents.get(i).playerIn;
		playerChanged.playerOut = gameInfo.incidents.get(i).playerOut;
		playerChanged.time = gameInfo.incidents.get(i).time;
		return playerChanged;
	}

	private IencidentInGameGoal getGoal(GameIencidentsGSON gameInfo, int i) {
		IencidentInGameGoal goal = new IencidentInGameGoal();
		goal.addedTime = gameInfo.incidents.get(i).addedTime;
		goal.assist1 = gameInfo.incidents.get(i).assist1;
		goal.awayScore = gameInfo.incidents.get(i).awayScore;
		goal.homeScore = gameInfo.incidents.get(i).homeScore;
		goal.id = gameInfo.incidents.get(i).id;
		goal.incidentClass = gameInfo.incidents.get(i).incidentClass;
		goal.incidentType = gameInfo.incidents.get(i).incidentType;
		goal.isHome = gameInfo.incidents.get(i).isHome;
		goal.player = gameInfo.incidents.get(i).player;
		goal.time = gameInfo.incidents.get(i).time;
		return goal;
	}

	private InncidentInGameCard getCard(GameIencidentsGSON gameInfo, int i) {
		InncidentInGameCard actionWithPlayer = new InncidentInGameCard();
		actionWithPlayer.addedTime = gameInfo.incidents.get(i).addedTime;
		actionWithPlayer.id = gameInfo.incidents.get(i).id;
		actionWithPlayer.incidentClass = gameInfo.incidents.get(i).incidentClass;
		actionWithPlayer.incidentType = gameInfo.incidents.get(i).incidentType;				
		actionWithPlayer.isHome = gameInfo.incidents.get(i).isHome;
		actionWithPlayer.player = gameInfo.incidents.get(i).player;
		actionWithPlayer.playerName = gameInfo.incidents.get(i).playerName;
		actionWithPlayer.reason = gameInfo.incidents.get(i).reason;
		actionWithPlayer.time = gameInfo.incidents.get(i).time;
		return actionWithPlayer;
	}

	private IencidentInGameVarDecision getVarDecision(GameIencidentsGSON gameInfo, int i) {
		IencidentInGameVarDecision varDecision= new IencidentInGameVarDecision();
		varDecision.confirmed = gameInfo.incidents.get(i).confirmed;
		varDecision.player = gameInfo.incidents.get(i).player;
		varDecision.isHome = gameInfo.incidents.get(i).isHome;
		varDecision.id = gameInfo.incidents.get(i).id;
		varDecision.time = gameInfo.incidents.get(i).time;
		varDecision.incidentClass = gameInfo.incidents.get(i).incidentClass;
		varDecision.incidentType = gameInfo.incidents.get(i).incidentType;
		return varDecision;
	}
}
