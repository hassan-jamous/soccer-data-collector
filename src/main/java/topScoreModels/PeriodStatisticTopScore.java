package topScoreModels;

import java.util.ArrayList;

public class PeriodStatisticTopScore {

	public String period;
	public ArrayList<GameStatisticInformationTopScore> groups;
	
	public PeriodStatisticTopScore() {
		groups = new ArrayList<>();
	}
	
	public String toString() {
		String result ="";
		result = period + "\n";
		for(int i =0; i<groups.size(); i++) {
			result+= groups.get(i).toString();
		}
		return result;
	}
	
}
