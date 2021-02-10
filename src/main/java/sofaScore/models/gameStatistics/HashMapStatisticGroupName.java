package sofaScore.models.gameStatistics;

import java.util.HashMap;

public class HashMapStatisticGroupName {

public HashMap<String, Integer> groupsIDs ;
	
	public HashMapStatisticGroupName() {
		groupsIDs = new HashMap<>();
		groupsIDs.put("Possession", 0);
		groupsIDs.put("Shots", 1);
		groupsIDs.put("TVData", 2);
		groupsIDs.put("Shots_extra", 3);
		groupsIDs.put("Passes", 4);
		groupsIDs.put("Duels", 5);
		groupsIDs.put("Defending", 6);
	}
	
	public int getGroupNameId(String key) {
		if(! groupsIDs.containsKey(key)) {
			throw new RuntimeException("key not found  "  + key);
		}
		return groupsIDs.get(key);
	}
}


