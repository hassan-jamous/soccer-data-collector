package models;

import java.util.ArrayList;

public class PlayerAtMatch {

	public Player playerBasicInfo;
	public String playerNumberAsString;
	public PlayerTypeAtMatch playerType;
	public ArrayList <PlayerEventAtMatch> events;
	
	public PlayerAtMatch() {
		playerBasicInfo = new Player();
		events = new ArrayList<>();
	}
	public PlayerAtMatch(String playerNumberAsString ,String playerName  , PlayerTypeAtMatch playerPosition , ArrayList<PlayerEventAtMatch> events) {
		this();
		this.playerBasicInfo.name = playerName;
		this.playerNumberAsString = playerNumberAsString;
		this.playerType = playerPosition;
		this.events= events;
		
	}
	public String toString() {
		String result = "";
		result = "#" + playerNumberAsString + "  " + playerBasicInfo.name  + " (" + (playerType == PlayerTypeAtMatch.Essential ? "Essential" : "Substitute")+ " )  " ;
		if((events != null)&&!(events.isEmpty())) {
			for(int i = 0 ; i < events.size() ; i++) {
				result = result + events.get(i).toString() + "    ";
			}
		}
		return result;
	}
	public int compare(PlayerAtMatch player1, PlayerAtMatch player2) {
		if(player1.playerBasicInfo.name .compareTo(player2.playerBasicInfo.name ) >= 0) {return 1;}
		else {return -1;}
	}
}
