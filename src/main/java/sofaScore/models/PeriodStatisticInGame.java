package sofaScore.models;

import java.util.ArrayList;

public class PeriodStatisticInGame {

	public String period;
	public ArrayList<GroupInformationInPeriod> groups;
	
	public PeriodStatisticInGame() {
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
