package models;

import java.util.ArrayList;

public class ClubInMatch{
	public Club clubBasicInfo;//may we delete it? class match contains it
		
	public ArrayList <Goal> goals;//total goal is size of the array goals
	public ArrayList <PlayerAtMatch> players;
	public String manager;
	
	public ClubInMatch() {
		clubBasicInfo = new Club();
		goals = new ArrayList<>();
		players = new ArrayList<>();
	}
	public ClubInMatch(String clubName , String manager  , ArrayList<Goal> goal, ArrayList <PlayerAtMatch> players) {
		this.clubBasicInfo = new Club();
		this.goals = new ArrayList<>();
		this.players = new ArrayList<>();
		this.clubBasicInfo.name = clubName;
		this.manager = manager;
		this.goals = goal;
		this.players = players;
	}
	public String toString() {
		String result = "";
		result = clubBasicInfo.name + "\n";
		
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
