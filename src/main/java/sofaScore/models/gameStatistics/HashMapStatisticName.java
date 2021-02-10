package sofaScore.models.gameStatistics;

import java.util.HashMap;

public class HashMapStatisticName {

public HashMap<String, Integer> nameIDs ;
	
	public HashMapStatisticName() {
		
		nameIDs = new HashMap<>();
		//Possession
		nameIDs.put("Ball_possession", 0);
		//Shots
		nameIDs.put("Total_shots", 1);
		nameIDs.put("Shots_on_target", 2);
		nameIDs.put("Shots_off_target", 3);
		nameIDs.put("Blocked_shots", 4);
		//TVData
		nameIDs.put("Corner_kicks", 5);
		nameIDs.put("Offsides", 6);
		nameIDs.put("Fouls", 7);
		nameIDs.put("Yellow_cards", 8);
		nameIDs.put("Red_cards", 9);
		//Shots extra
		nameIDs.put("Big_chances", 10);
		nameIDs.put("Big_chances_missed", 11);
		nameIDs.put("Hit_woodwork", 12);
		nameIDs.put("Counter_attacks", 13);
		nameIDs.put("Counter_attack_shots", 14);
		nameIDs.put("Counter_attack_goals", 15);
		nameIDs.put("Shots_inside_box", 16);
		nameIDs.put("Shots_outside_box", 17);
		nameIDs.put("Goalkeeper_saves", 18);
		//Passes
		nameIDs.put("Passes", 19);
		nameIDs.put("Accurate_passes", 20);
		nameIDs.put("Long_balls", 21);
		nameIDs.put("Crosses", 22);
		//Duels
		nameIDs.put("Dribbles", 23);
		nameIDs.put("Possession_lost", 24);
		nameIDs.put("Duels_won", 25);
		nameIDs.put("Aerials_won", 26);
		//Defending
		nameIDs.put("Tackles", 27);
		nameIDs.put("Interceptions", 28);
		nameIDs.put("Clearances", 29);


	}
	
	public int getNameId(String key) {
		if(! nameIDs.containsKey(key)) {
			throw new RuntimeException("key not found  "  + key);
		}
		return nameIDs.get(key);
	}
}


