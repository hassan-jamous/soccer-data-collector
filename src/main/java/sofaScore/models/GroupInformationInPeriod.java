package sofaScore.models;

import java.util.ArrayList;

public class GroupInformationInPeriod {

	public String groupName;
	public ArrayList<ItemStatisticsInGroup> statisticsItems;
	
	public GroupInformationInPeriod() {
		statisticsItems = new ArrayList<>();
	}
	public String toString() {
		String result= "";
		result = groupName +"\n";
		for(int i =0 ; i<statisticsItems.size() ; i++ ) {
			result += statisticsItems.get(i).toString() + "\n";
		}
		return result;
	}
}
