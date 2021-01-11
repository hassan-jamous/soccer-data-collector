package sofaScoreModels;

import java.util.ArrayList;

public class GameIencidentsGSON {

	public ArrayList<IencidentInGameGson> incidents;
	public GameIencidentsGSON() {
		incidents = new ArrayList<>();
	}
	
	public String toString () {
		String result = "";
		if(incidents == null ) {
			return "NULLLLL";
		}
		else if (incidents.isEmpty()) {
			return "ZEROOOOOO";
		}
		else {
			for(int i =0 ; i<incidents.size() ; i++) {
				result += incidents.get(i);
			}
			return result;
		}
	}
	
}
