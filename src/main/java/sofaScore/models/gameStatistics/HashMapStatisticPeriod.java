package sofaScore.models.gameStatistics;

import java.util.HashMap;

public class HashMapStatisticPeriod {

public HashMap<String, Integer> periodID ;
	
	public HashMapStatisticPeriod() {
		periodID = new HashMap<>();
		periodID.put("ALL", 0);
		periodID.put("1ST", 1);
		periodID.put("2ND", 1);

	}
	
	public int getPeriodID(String key) {
		return periodID.get(key);
	}
}
