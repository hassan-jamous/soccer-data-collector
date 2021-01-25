package sofaScore.models.gameStatistics;

import java.util.HashMap;

public class HashMapStatisticPeriod {

public HashMap<String, Integer> periodIDs ;
	
	public HashMapStatisticPeriod() {
		periodIDs = new HashMap<>();
		periodIDs.put("ALL", 0);
		periodIDs.put("1ST", 1);
		periodIDs.put("2ND", 2);

	}
	
	public int getPeriodID(String key) {
		if(! periodIDs.containsKey(key)) {
			throw new RuntimeException("key not found  "  + key);
		}
		return periodIDs.get(key);
	}
}
