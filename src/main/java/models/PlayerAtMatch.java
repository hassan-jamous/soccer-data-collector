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
	public PlayerAtMatch(String playerNumberAsString ,String playerName  , PlayerTypeAtMatch playerPosition , ArrayList<PlayerEventAtMatch> events) {
		this.playerName = playerName;
		this.playerNumberAsString = playerNumberAsString;
		this.playerType = playerPosition;
		this.events = new ArrayList<>();
		this.events= events;
		
	}
	public String toString() {
		String result = "";
		result = "#" + playerNumberAsString + "  " + playerName + " (" + (playerType == PlayerTypeAtMatch.Essential ? "Essential" : "Substitute")+ " )  " ;
		if((events != null)&&!(events.isEmpty())) {
			for(int i = 0 ; i < events.size() ; i++) {
				result = result + events.get(i).toString() + "    ";
			}
		}
		return result;
	}
}
