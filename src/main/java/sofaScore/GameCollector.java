package sofaScore;

import java.util.ArrayList;

import com.google.gson.Gson;

import sofaScoreModels.GameIencidents;
import sofaScoreModels.GameIencidentsGSON;
import sofaScoreModels.GameStatistic;
import sofaScoreModels.IencidentInGameChangePlayers;
import sofaScoreModels.IencidentInGameGoal;
import sofaScoreModels.IencidentInGameHeader;
import sofaScoreModels.IencidentInGameInjuryTime;
import sofaScoreModels.InncidentInGameActionWithPlayer;
import util.HttpUtil;

public class GameCollector {
	
	private final String API_SOFA_SCORE_GAME_URL ="https://api.sofascore.com/api/v1/event/%s/%s"; 
	private final HttpUtil httpUtil = new HttpUtil();

	public GameStatistic getGameStatistics(String gameID) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_URL, gameID , "statistics"));
		Gson gson = new Gson();
		GameStatistic gamesInfo = gson.fromJson(gsonString, GameStatistic.class);
		return gamesInfo;
		
	}
	public ArrayList<GameIencidents> getGameIncidents(String gameID) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_URL, gameID , "incidents"));
		Gson gson = new Gson();
		GameIencidentsGSON gamesInfo = gson.fromJson(gsonString, GameIencidentsGSON.class);
		if(gamesInfo == null) {System.out.println("Erorr no object " + gamesInfo);  return null;}
		if(gamesInfo.incidents.isEmpty()) {System.out.println("Empty" + gamesInfo);  return null;}
		ArrayList<GameIencidents> result = new ArrayList<>();
		for(int i = 0 ; i< gamesInfo.incidents.size(); i++) {
			if(gamesInfo.incidents.get(i).incidentType.equals("period")) {
				IencidentInGameHeader header =  new IencidentInGameHeader();
				header.addedTime = gamesInfo.incidents.get(i).addedTime;
				header.awayScore = gamesInfo.incidents.get(i).awayScore;
				header.homeScore = gamesInfo.incidents.get(i).homeScore;
				header.isLive = gamesInfo.incidents.get(i).isLive;
				header.text = gamesInfo.incidents.get(i).text;
				header.time = gamesInfo.incidents.get(i).time;	
				result.add(header);
			}
			else if(gamesInfo.incidents.get(i).incidentType.equals("injuryTime")) {
				IencidentInGameInjuryTime injuryTime = new IencidentInGameInjuryTime();
				injuryTime.addedTime = gamesInfo.incidents.get(i).addedTime;
				injuryTime.incidentType = gamesInfo.incidents.get(i).incidentType;
				injuryTime.length = gamesInfo.incidents.get(i).length;
				injuryTime.time = gamesInfo.incidents.get(i).time;
				result.add(injuryTime);
			}
			else if(gamesInfo.incidents.get(i).incidentType.equals("substitution")) {
				IencidentInGameChangePlayers playerChanged = new IencidentInGameChangePlayers();
				playerChanged.id = gamesInfo.incidents.get(i).id;
				playerChanged.incidentClass = gamesInfo.incidents.get(i).incidentClass;
				playerChanged.incidentType = gamesInfo.incidents.get(i).incidentType;
				playerChanged.injury = gamesInfo.incidents.get(i).injury;
				playerChanged.isHome = gamesInfo.incidents.get(i).isHome;
				playerChanged.playerIn = gamesInfo.incidents.get(i).playerIn;
				playerChanged.playerOut = gamesInfo.incidents.get(i).playerOut;
				playerChanged.time = gamesInfo.incidents.get(i).time;
				result.add(playerChanged);

			}
			else if(gamesInfo.incidents.get(i).incidentType.equals("goal")) {
				IencidentInGameGoal goal = new IencidentInGameGoal();
				goal.assist1 = gamesInfo.incidents.get(i).assist1;
				goal.awayScore = gamesInfo.incidents.get(i).awayScore;
				goal.homeScore = gamesInfo.incidents.get(i).homeScore;
				goal.id = gamesInfo.incidents.get(i).id;
				goal.incidentClass = gamesInfo.incidents.get(i).incidentClass;
				goal.incidentType = gamesInfo.incidents.get(i).incidentType;
				goal.isHome = gamesInfo.incidents.get(i).isHome;
				goal.player = gamesInfo.incidents.get(i).player;
				goal.time = gamesInfo.incidents.get(i).time;
				result.add(goal);
			}
			else if(gamesInfo.incidents.get(i).incidentType.equals("card")) {
				System.out.println("in card i ="+i);
				InncidentInGameActionWithPlayer actioWithPlayer = new InncidentInGameActionWithPlayer();
				actioWithPlayer.addedTime = gamesInfo.incidents.get(i).addedTime;
				actioWithPlayer.id = gamesInfo.incidents.get(i).id;
				actioWithPlayer.incidentClass = gamesInfo.incidents.get(i).incidentClass;
				actioWithPlayer.incidentType = gamesInfo.incidents.get(i).incidentType;				
				actioWithPlayer.isHome = gamesInfo.incidents.get(i).isHome;
				actioWithPlayer.player = gamesInfo.incidents.get(i).player;
				actioWithPlayer.reason = gamesInfo.incidents.get(i).reason;
				actioWithPlayer.time = gamesInfo.incidents.get(i).time;
				result.add(actioWithPlayer);
			}
			else {
				System.out.println("i="+i  + "     "+gamesInfo.incidents.get(i));
			}

		}

		if(result ==  null || result.size() == 0) {return null;}
		return result;
	}

}
