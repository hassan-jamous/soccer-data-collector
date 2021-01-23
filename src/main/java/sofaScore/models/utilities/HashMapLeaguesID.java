package sofaScore.models.utilities;

import java.util.HashMap;

public class HashMapLeaguesID {

	public HashMap<String, String> leaguesID ;
	
	public HashMapLeaguesID() {
		leaguesID = new HashMap<>();
		leaguesID.put("Premier League", "17");
		leaguesID.put("La Liga", "8");

	}
	
	public String getLeagueID(String key) {
		if(! leaguesID.containsKey(key)) {throw new RuntimeException("league not found");}
		return leaguesID.get(key);
	}
}
