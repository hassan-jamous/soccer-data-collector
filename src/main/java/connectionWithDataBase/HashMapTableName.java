package connectionWithDataBase;

import java.util.HashMap;

public class HashMapTableName {

	HashMap<String,String> tableNames;
	
	public HashMapTableName() {
		tableNames = new HashMap<>();
		tableNames.put("Premier League", "premierleaguestatistics");
	}
	
	public String getTableName(String key) {
		if(tableNames.containsKey(key)) {
			return tableNames.get(key);
		}
		throw new RuntimeException("do not found table "+key);
	}
}
