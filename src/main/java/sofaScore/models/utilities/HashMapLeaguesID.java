package sofaScore.models.utilities;

import java.util.HashMap;

public class HashMapLeaguesID {

	public HashMap<String, String> leaguesID ;
	
	public HashMapLeaguesID() {
		leaguesID = new HashMap<>();
		leaguesID.put("Premier League", "17");
		leaguesID.put("LaLiga", "8");
		leaguesID.put("Bundesliga", "35");
		leaguesID.put("Serie A", "23");
		leaguesID.put("Ligue 1", "34");//France
		leaguesID.put("Division 1", "34");//France


	}
	
	public String getLeagueID(String key) {
		if(! leaguesID.containsKey(key)) {throw new RuntimeException("league not found");}
		return leaguesID.get(key);
	}
}
