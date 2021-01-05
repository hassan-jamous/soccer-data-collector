package topScoreModels;

import java.util.ArrayList;

public class GameStatisticInformationTopScore {

	public String groupName;
	public ArrayList<StatisticsItemsGameTopScore> statisticsItems;
	
	public GameStatisticInformationTopScore() {
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
