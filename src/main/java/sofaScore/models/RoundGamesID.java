package sofaScore.models;

import java.util.ArrayList;

public class RoundGamesID {

	public ArrayList<GameID> events;
	public RoundGamesID() {
		events = new ArrayList<>();
	}
	public String toString() {
		String result = "";
		if(events == null) {result = "#######null#######";}
		else if (events.size() == 0) {result = "#######Zero#######";}
		else {
			for(int i = 0 ; i < events.size() ; i++) {
				result += events.get(i);
			}
		}
		return result;
	}

}
