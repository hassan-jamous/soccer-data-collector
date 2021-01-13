package sofaScore;

import com.google.gson.Gson;
import sofaScore.models.GameIecidents;
import sofaScore.models.GameIencidentsGSON;
import sofaScore.models.GameStatistic;
import sofaScore.models.IencidentInGame_ChangePlayers;
import sofaScore.models.IencidentInGame_Goal;
import sofaScore.models.IencidentInGame_Header;
import sofaScore.models.IencidentInGame_InjuryTime;
import sofaScore.models.IencidentInGame_VarDecision;
import sofaScore.models.InncidentInGame_Card;
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
	public GameIecidents getGameIncidents(String gameID) {
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_URL, gameID , "incidents"));
		Gson gson = new Gson();
		GameIencidentsGSON gameInfo = gson.fromJson(gsonString, GameIencidentsGSON.class);
		if(gameInfo == null) {System.out.println("Erorr no object " + gameInfo);  return null;}
		if(gameInfo.incidents.isEmpty()) {System.out.println("Empty" + gameInfo);  return null;}
		GameIecidents result = new GameIecidents();
		
		for(int i = 0 ; i< gameInfo.incidents.size(); i++) {
			if(gameInfo.incidents.get(i).incidentType.equals("period")) {
				IencidentInGame_Header header =  new IencidentInGame_Header();
				header.incidentType = gameInfo.incidents.get(i).incidentType;
				header.addedTime = gameInfo.incidents.get(i).addedTime;
				header.awayScore = gameInfo.incidents.get(i).awayScore;
				header.homeScore = gameInfo.incidents.get(i).homeScore;
				header.isLive = gameInfo.incidents.get(i).isLive;
				header.text = gameInfo.incidents.get(i).text;
				header.time = gameInfo.incidents.get(i).time;	
				result.iecidents.add(header);
			}
			else if(gameInfo.incidents.get(i).incidentType.equals("injuryTime")) {
				IencidentInGame_InjuryTime injuryTime = new IencidentInGame_InjuryTime();
				injuryTime.addedTime = gameInfo.incidents.get(i).addedTime;
				injuryTime.incidentType = gameInfo.incidents.get(i).incidentType;
				injuryTime.length = gameInfo.incidents.get(i).length;
				injuryTime.time = gameInfo.incidents.get(i).time;
				result.iecidents.add(injuryTime);
			}
			else if(gameInfo.incidents.get(i).incidentType.equals("substitution")) {
				IencidentInGame_ChangePlayers playerChanged = new IencidentInGame_ChangePlayers();
				
				playerChanged.addedTime = gameInfo.incidents.get(i).addedTime;
				playerChanged.id = gameInfo.incidents.get(i).id;
				playerChanged.incidentClass = gameInfo.incidents.get(i).incidentClass;
				playerChanged.incidentType = gameInfo.incidents.get(i).incidentType;
				playerChanged.injury = gameInfo.incidents.get(i).injury;
				playerChanged.isHome = gameInfo.incidents.get(i).isHome;
				playerChanged.playerIn = gameInfo.incidents.get(i).playerIn;
				playerChanged.playerOut = gameInfo.incidents.get(i).playerOut;
				playerChanged.time = gameInfo.incidents.get(i).time;
				result.iecidents.add(playerChanged);

			}
			else if(gameInfo.incidents.get(i).incidentType.equals("goal")) {
				IencidentInGame_Goal goal = new IencidentInGame_Goal();
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
				result.iecidents.add(goal);
			}
			else if(gameInfo.incidents.get(i).incidentType.equals("card")) {
				InncidentInGame_Card actionWithPlayer = new InncidentInGame_Card();
				actionWithPlayer.addedTime = gameInfo.incidents.get(i).addedTime;
				actionWithPlayer.id = gameInfo.incidents.get(i).id;
				actionWithPlayer.incidentClass = gameInfo.incidents.get(i).incidentClass;
				actionWithPlayer.incidentType = gameInfo.incidents.get(i).incidentType;				
				actionWithPlayer.isHome = gameInfo.incidents.get(i).isHome;
				actionWithPlayer.player = gameInfo.incidents.get(i).player;
				actionWithPlayer.playerName = gameInfo.incidents.get(i).playerName;
				actionWithPlayer.reason = gameInfo.incidents.get(i).reason;
				actionWithPlayer.time = gameInfo.incidents.get(i).time;
				result.iecidents.add(actionWithPlayer);
			}
			else if(gameInfo.incidents.get(i).incidentType.equals("varDecision")) {
				IencidentInGame_VarDecision varDecision= new IencidentInGame_VarDecision();
				varDecision.confirmed = gameInfo.incidents.get(i).confirmed;
				varDecision.player = gameInfo.incidents.get(i).player;
				varDecision.isHome = gameInfo.incidents.get(i).isHome;
				varDecision.id = gameInfo.incidents.get(i).id;
				varDecision.time = gameInfo.incidents.get(i).time;
				varDecision.incidentClass = gameInfo.incidents.get(i).incidentClass;
				varDecision.incidentType = gameInfo.incidents.get(i).incidentType;
				result.iecidents.add(varDecision);
			}
			//if i do not recognize all types
			else {
				throw new RuntimeException("New Game Iecident Type i = " + i  +"   gameInfo's type is " + gameInfo.incidents.get(i).incidentType );
			}

		}

		if(result ==  null || result.iecidents.size() == 0) {return null;}
		return result;
	}

}
