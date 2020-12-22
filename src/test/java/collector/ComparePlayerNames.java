package collector;

import java.util.Comparator;

import models.PlayerAtMatch;

public class ComparePlayerNames implements Comparator<PlayerAtMatch>{
	@Override
	public int compare(PlayerAtMatch player1, PlayerAtMatch player2) {
		if(player1.playerName.compareTo(player2.playerName) >= 0) {return 1;}
		else {return -1;}
	}
	
	
}
