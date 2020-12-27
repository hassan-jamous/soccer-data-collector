package convertByGson;

import java.util.ArrayList;

import com.google.gson.Gson;

import collector.ScreenScraper;
import models.GamesTableOfLeague;

public class GamesConvertor {

	ScreenScraper screenScraper = new ScreenScraper();//public or private????????????
	
	public ArrayList <String> convertAllRoundsFromObjectToGson(String leagueName , String SeasonYears) {
		GamesTableOfLeague rounds = screenScraper.getAllRounds(leagueName, SeasonYears);
		Gson gson = new Gson();
		String json = gson.toJson(rounds);
		System.out.println(json);
		ArrayList <String> result = new ArrayList<>();
		return result;
	}
	
	public ArrayList<String> convertAllRoundsFromGsonToObejct (String gsonString){
		Gson gson = new Gson();
		GamesTableOfLeague leagueTable = gson.fromJson(gsonString, GamesTableOfLeague.class);
		System.out.println(leagueTable);
		ArrayList <String> result = new ArrayList<>();
		
		
		return result;
	}
}
