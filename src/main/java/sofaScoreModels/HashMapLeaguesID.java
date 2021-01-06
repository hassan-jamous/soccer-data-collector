package sofaScoreModels;

import java.util.HashMap;

public class HashMapLeaguesID {

	public HashMap<String, String> leaguesID ;
	
	public HashMapLeaguesID() {
		leaguesID = new HashMap<>();
		leaguesID.put("Premier League", "17");
	}
	
	public String getLeagueID(String key) {
		return leaguesID.get(key);
	}
}
