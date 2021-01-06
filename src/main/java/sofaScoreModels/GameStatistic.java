package sofaScoreModels;

import java.util.ArrayList;

public class GameStatistic {

	public ArrayList<PeriodStatisticInGame> statistics;
	
	public GameStatistic() {
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
