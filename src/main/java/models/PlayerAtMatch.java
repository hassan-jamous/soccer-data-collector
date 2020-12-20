package models;

import java.util.ArrayList;

public class PlayerAtMatch {

	public String playerName;
	public String playerNumberAsString;
	public PlayerTypeAtMatch playerType;
	public ArrayList <PlayerEventAtMatch> events;
	
	public PlayerAtMatch() {
		events = new ArrayList<>();
	}
	public PlayerAtMatch(String playerName , String playerNumberSsString , PlayerTypeAtMatch playerPosition , ArrayList<PlayerEventAtMatch> events) {
		this.playerName = playerName;
		this.playerNumberAsString = playerNumberSsString;
		this.playerType = playerPosition;
		this.events = events;
		
	}
	public String toString() {
		String result = "";
		result = "#" + playerNumberAsString + "  " + playerName + " (" + (playerType == PlayerTypeAtMatch.Essential ? "Essential" : "Substitute")+ " )  " ;
		for(int i = 0 ; i < events.size() ; i++) {
			result = result + events.get(i).toString() + "    ";
		}
		return result;
	}
}
