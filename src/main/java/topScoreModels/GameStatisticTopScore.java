package topScoreModels;

import java.util.ArrayList;

public class GameStatisticTopScore {

	public ArrayList<PeriodStatisticTopScore> statistics;
	
	public GameStatisticTopScore() {
		statistics = new ArrayList<>();
	}
	public String toString() {
		String result="";
		for(int i =0; i<statistics.size() ; i++) {
			result += statistics.get(i).toString();
		}
		return result;
	}
}
