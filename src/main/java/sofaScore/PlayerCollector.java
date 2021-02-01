package sofaScore;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.models.statisticsPlayer.PlayerInLineups;
import sofaScore.models.statisticsPlayer.TeamKindInGame;
import sofaScore.models.utilities.HashMapLeaguesID;
import sofaScore.models.utilities.HashMapSeasonsID;
import util.HttpUtil;

public class PlayerCollector {

	private final HttpUtil httpUtil = new HttpUtil();
	private final String API_SOFA_SCORE_GAME_LINEUP_URL = "https://api.sofascore.com/api/v1/event/%s/lineups";

	// JUST_TEST///////////////////////////////////////////////////////
	private final String API_SOFA_SCORE_ROUND_URL = "https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/events/round/%s%s";
	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID();
	///////////////////////////////////////////////////////////////////

	public List<PlayerInLineups> getPlayerStatisticsInTeam(String gameID, TeamKindInGame teamKind) {

		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_GAME_LINEUP_URL, gameID));
		if (gsonString.contains("Not Found")) {
			return null;
		}
		JsonElement jsonElement = JsonParser.parseString(gsonString);
		JsonElement team = jsonElement.getAsJsonObject().get(teamKind.value());
		JsonArray players = team.getAsJsonObject().get("players").getAsJsonArray();
		Gson gson = new Gson();
		List<PlayerInLineups> result = new ArrayList<>(Arrays.asList());
		Type listOfMyClassObject = new TypeToken<ArrayList<PlayerInLineups>>() {}.getType();
		result = gson.fromJson(players, listOfMyClassObject);
		if (result.isEmpty()) {
			return null;
		}
		return result;
	}

	public String getPlayerStatisticsInTeamJUST_TEST(String competitionName, String competitionYears, String round,
			int gameIndex) {

		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_ROUND_URL, leagueId.getLeagueID(competitionName),
						seasonId.getSeasonID(competitionName, competitionYears), round, ""));
		if (gsonString.contains("Not Found")) {
			return null;
		}
		Gson gson = new Gson();
		RoundGamesID gamesId = gson.fromJson(gsonString, RoundGamesID.class);
		return gamesId.events.get(gameIndex).id;
	}

}
