package sofaScore.models.gameStatistics;

import java.util.HashMap;

public class HashMapStatisticPeriod {

public HashMap<String, Integer> periodIDs ;
	
	public HashMapStatisticPeriod() {
		periodIDs = new HashMap<>();
		periodIDs.put("ALL", 0);
		periodIDs.put("FirstHalf", 1);
		periodIDs.put("SecondHalf", 2);
		periodIDs.put("ET1", 3);
		periodIDs.put("ET2", 4);

	}
	
	public int getPeriodID(String key) {
		if(! periodIDs.containsKey(key)) {
			throw new RuntimeException("key not found  "  + key);
		}
		return periodIDs.get(key);
	}
}
