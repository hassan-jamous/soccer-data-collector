package models;

import java.util.ArrayList;

public class MatchDetailsClub{
	public String clubName;//may we delete it? class match contains it
		
	public ArrayList <Goal> goals;//total goal is size of the array goals
	public ArrayList <PlayerAtMatch> players;
	public String manager;
	
	public MatchDetailsClub() {
		goals = new ArrayList<>();
		players = new ArrayList<>();
	}
	public MatchDetailsClub(String clubName , String manager  , ArrayList<Goal> goal, ArrayList <PlayerAtMatch> players) {
		this.clubName = clubName;
		this.manager = manager;
		this.goals = goal;
		this.players = players;
	}
	public String toString() {
		String result = "";
		result = clubName + "\n";
		
		if(goals.size() == 0) {
			result =result + "GOALS ARE ZERO" + "\n";
		}
		else {
			for(int i = 0; i < goals.size() ; i++) {
			result = result + goals.get(i).toString() + "\n";
			}
		}
	
		if(players.size() == 0) {
			result =result + "NO PLAYERS !!!" + "\n";
		}
		else {
			for(int i = 0; i < players.size() ; i++) {
			result = result + players.get(i).toString() + "\n";
			}
		}
		result = result + "THE MANAGER IS " + manager;
		return result;
	}
}
