package sofaScore;

import java.util.ArrayList;
import com.google.gson.Gson;
import sofaScore.models.Game;
import sofaScore.models.GameIecidents;
import sofaScore.models.GameIencidentsGSON;
import sofaScore.models.GameStatistic;
import sofaScore.models.IencidentInGameChangePlayers;
import sofaScore.models.IencidentInGameGoal;
import sofaScore.models.IencidentInGameHeader;
import sofaScore.models.IencidentInGameInjuryTime;
import sofaScore.models.IencidentInGameVarDecision;
import sofaScore.models.InncidentInGameCard;
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

	/**
	 * 
	 * @param gameID 
	 * in this example gameID is 8896899 for this game English Premier League 20_21 Crystal Palace vs Sheffield United 
	 * https://api.sofascore.com/api/v1/event/8896899/statistics 
	 * @return object GameStatistics contains array list of statistics
	 */
	public GameStatistic getGameStatistics(String gameID) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_URL, gameID , "statistics"));
		Gson gson = new Gson();
		GameStatistic gamesInfo = gson.fromJson(gsonString, GameStatistic.class);
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
			//if i do not recognize all types
			else {
				throw new RuntimeException("New Game Iecident Type i = " + i  +"   gameInfo's type is " + gameInfo.incidents.get(i).incidentType );
			}

		}
		if(result ==  null || result.iecidents.size() == 0) {return null;}
		return result;
	}
	
	public Game getGameBasicInformation(String gameId) {
		
		String gsonString = httpUtil.sendGetHttpRequest(API_SOFA_SCORE_GAME_URL_FOR_BASIC + gameId);
	    Gson gson = new Gson();
	    Game game = gson.fromJson(gsonString, Game.class) ;
		return game;
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
