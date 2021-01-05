package sofaScoreModels;

import java.util.ArrayList;

public class PeriodStatistic {

	public String period;
	public ArrayList<GameStatisticInformation> groups;
	
	public PeriodStatistic() {
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
