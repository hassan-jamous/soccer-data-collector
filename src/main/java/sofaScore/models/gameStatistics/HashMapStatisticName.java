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
		nameIDs.put("Shots inside box", 14);
		nameIDs.put("Shots outside box", 15);
		nameIDs.put("Goalkeeper saves", 16);
		nameIDs.put("Passes", 17);
		nameIDs.put("Accurate passes", 18);
		nameIDs.put("Long balls", 19);
		nameIDs.put("Crosses", 20);
		nameIDs.put("Dribbles", 21);
		nameIDs.put("Possession lost", 22);
		nameIDs.put("Duels won", 23);
		nameIDs.put("Aerials won", 24);
		nameIDs.put("Tackles", 25);
		nameIDs.put("Interceptions", 26);
		nameIDs.put("Clearances", 27);


	}
	
	public int getNameId(String key) {
		return nameIDs.get(key);
	}
}


