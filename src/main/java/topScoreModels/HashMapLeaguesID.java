package topScoreModels;

import java.util.HashMap;

public class HashMapLeaguesID {

	public HashMap<String, String> LeaguesID ;

	public HashMapLeaguesID() {	
		LeaguesID = new HashMap<String, String>();
		LeaguesID.put("Premier League 20/21","29415");
		LeaguesID.put("Premier League 19/20","23776");
		LeaguesID.put("Premier League 18/19","17359");
		LeaguesID.put("Premier League 17/18","13380");
		LeaguesID.put("Premier League 16/17","11733");
		LeaguesID.put("Premier League 15/16","10356");
		LeaguesID.put("Premier League 14/15","8186");
		LeaguesID.put("Premier League 13/14","6311");
		LeaguesID.put("Premier League 12/13","4710");
		LeaguesID.put("Premier League 11/12","3391");
		LeaguesID.put("Premier League 10/11","2746");
		LeaguesID.put("Premier League 09/10","2139");
		LeaguesID.put("Premier League 08/09","1544");
		LeaguesID.put("Premier League 07/08","581");
		LeaguesID.put("Premier League 06/07","4");
		LeaguesID.put("Premier League 05/06","3");
		LeaguesID.put("Premier League 04/05","2");
		LeaguesID.put("Premier League 03/04","1");
		LeaguesID.put("Premier League 02/03","46");
		LeaguesID.put("Premier League 01/02","47");
		LeaguesID.put("Premier League 00/01","48");
		LeaguesID.put("Premier League 99/00","49");
		LeaguesID.put("Premier League 98/99","50");
		LeaguesID.put("Premier League 97/98","51");
		LeaguesID.put("Premier League 96/97","25682");
		LeaguesID.put("Premier League 95/96","25681");
		LeaguesID.put("Premier League 94/95","29167");
		LeaguesID.put("Premier League 93/94","25680");

	}
	
	public String get(String key) {
		return LeaguesID.get(key);
	}
}


