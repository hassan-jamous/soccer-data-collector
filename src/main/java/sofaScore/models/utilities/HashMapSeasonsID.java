package sofaScore.models.utilities;

import java.util.HashMap;

public class HashMapSeasonsID {

	public HashMap<String, String> seasonsID ;

	public HashMapSeasonsID() {
		this.seasonsID = new HashMap<>();

		seasonsID.put("Premier League 20/21","29415");
		seasonsID.put("Premier League 19/20","23776");
		seasonsID.put("Premier League 18/19","17359");
		seasonsID.put("Premier League 17/18","13380");
		seasonsID.put("Premier League 16/17","11733");
		seasonsID.put("Premier League 15/16","10356");
		seasonsID.put("Premier League 14/15","8186");
		seasonsID.put("Premier League 13/14","6311");
		seasonsID.put("Premier League 12/13","4710");
		seasonsID.put("Premier League 11/12","3391");
		seasonsID.put("Premier League 10/11","2746");
		seasonsID.put("Premier League 09/10","2139");
		seasonsID.put("Premier League 08/09","1544");
		seasonsID.put("Premier League 07/08","581");
		seasonsID.put("Premier League 06/07","4");
		seasonsID.put("Premier League 05/06","3");
		seasonsID.put("Premier League 04/05","2");
		seasonsID.put("Premier League 03/04","1");
		seasonsID.put("Premier League 02/03","46");
		seasonsID.put("Premier League 01/02","47");
		seasonsID.put("Premier League 00/01","48");
		seasonsID.put("Premier League 99/00","49");
		seasonsID.put("Premier League 98/99","50");
		seasonsID.put("Premier League 97/98","51");
		seasonsID.put("Premier League 96/97","25682");
		seasonsID.put("Premier League 95/96","25681");
		seasonsID.put("Premier League 94/95","29167");
		seasonsID.put("Premier League 93/94","25680");
		seasonsID.put("La Liga 20/21","32501");
		seasonsID.put("La Liga 19/20","24127");
		seasonsID.put("La Liga 18/19","18020");
		seasonsID.put("La Liga 17/18","13662");
		seasonsID.put("La Liga 16/17","11906");
		seasonsID.put("La Liga 15/16","10495");
		seasonsID.put("La Liga 14/15","8578");
		seasonsID.put("La Liga 13/14","6559");
		seasonsID.put("La Liga 12/13","4959");
		seasonsID.put("La Liga 11/12","3502");
		seasonsID.put("La Liga 10/11","2896");
		seasonsID.put("La Liga 09/10","2252");

	}
	
	public String get(String key) {
		if(! seasonsID.containsKey(key)) {throw new RuntimeException("season not found");}
		return seasonsID.get(key);
	}
}


