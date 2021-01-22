package sofaScore.models.gameStatistics;

import java.util.HashMap;

public class HashMapStatisticName {

public HashMap<String, Integer> nameIDs ;
	
	public HashMapStatisticName() {
		
		nameIDs = new HashMap<>();
		nameIDs.put("Ball possession", 0);
		nameIDs.put("Total shots", 1);
		nameIDs.put("Shots on target", 2);
		nameIDs.put("Shots off target", 3);
		nameIDs.put("Blocked shots", 4);
		nameIDs.put("Corner kicks", 5);
		nameIDs.put("Offsides", 6);
		nameIDs.put("Fouls", 7);
		nameIDs.put("Yellow cards", 8);
		nameIDs.put("Red cards", 9);
		nameIDs.put("Big chances", 10);
		nameIDs.put("Big chances missed", 11);
		nameIDs.put("Hit woodwork", 12);
		nameIDs.put("Counter attacks", 13);
		nameIDs.put("Counter attack shots", 14);
		nameIDs.put("Counter attack goals", 15);
		nameIDs.put("Shots inside box", 16);
		nameIDs.put("Shots outside box", 17);
		nameIDs.put("Goalkeeper saves", 18);
		nameIDs.put("Passes", 19);
		nameIDs.put("Accurate passes", 20);
		nameIDs.put("Long balls", 21);
		nameIDs.put("Crosses", 22);
		nameIDs.put("Dribbles", 23);
		nameIDs.put("Possession lost", 24);
		nameIDs.put("Duels won", 25);
		nameIDs.put("Aerials won", 26);
		nameIDs.put("Tackles", 27);
		nameIDs.put("Interceptions", 28);
		nameIDs.put("Clearances", 29);


	}
	
	public int getNameId(String key) {
		if(! nameIDs.containsKey(key)) {
			//new name
			throw new RuntimeException("key not found  "  + key);
		}
		return nameIDs.get(key);
	}
}


