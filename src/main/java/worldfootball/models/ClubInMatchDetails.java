package worldfootball.models;

import java.util.ArrayList;


public class ClubInMatchDetails{
	public Club clubBasicInfo;		
	public ArrayList <PlayerAtMatch> players;
	public String manager;//is it better to convert (class)String to (class)Player some (old) players are managers now (tony adams arsenal2002)
	
	public ClubInMatchDetails() {
		clubBasicInfo = new Club();
		players = new ArrayList<>();
	}
	public ClubInMatchDetails(String clubName , String manager  , ArrayList <PlayerAtMatch> players) {
		this();
		this.clubBasicInfo.name = clubName;
		this.manager = manager;
		this.players = players;
	}
	public String toString() {
		String result = "";
		result = clubBasicInfo.name + "\n";
		
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
