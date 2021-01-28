package sofaScore.models.gameStatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import com.google.gson.annotations.Expose;
import lombok.NoArgsConstructor;

/**
 * 
 * the class GameStatistics contains the games' statistics in array list of GamestatisticsForOneItem  
 * GamestatisticsForOneItem contains information about one item ,in five Strings
 * period , groupName , name , away , home
 * ALL , Shots , Shots on target , 5 ,6
 */
@NoArgsConstructor
public class GameStatistics {

	//@Expose
	public ArrayList<GameStatisticsForOneItem> statistics;
	
	public boolean containsSatatistic(GameStatisticsForOneItem item) {
		if((this.statistics == null) || (this.statistics.isEmpty())) {
			return false;
		}
		for(int i =0; i<statistics.size();i++) {
			if((statistics.get(i).period.equals(item.period)) && (statistics.get(i).groupName.equals(item.groupName)) 
					&&(statistics.get(i).name.equals(item.name))) {
				return true;
			}
		}
		return false;
	}
	
	

	public void addStatistic(GameStatisticsForOneItem item) {
		if(this.statistics == null) {this.statistics= new ArrayList<>();}
		if(this.statistics.isEmpty()) {this.statistics.add(item);}
		else {
			GameStatisticsForOneItem  itemToAdd = new GameStatisticsForOneItem();
			itemToAdd.period = item.period;
			itemToAdd.groupName = item.groupName;
			itemToAdd.name = item.name;
			itemToAdd.home = itemToAdd.away = null;
			this.statistics.add(itemToAdd);
			Collections.sort((List<GameStatisticsForOneItem>)this.statistics);
		}
	}
	
	//use this method just for test in GameCollector --> itShouldGetGameStatisticsNew()
		public boolean containsSatatisticWithValues(GameStatisticsForOneItem item) {
			if((this.statistics == null) || (this.statistics.isEmpty())) {
				return false;
			}
			for(int i =0; i<statistics.size();i++) {
				if((statistics.get(i).period.equals(item.period)) && (statistics.get(i).groupName.equals(item.groupName)) 
						&&(statistics.get(i).name.equals(item.name)) &&
						((statistics.get(i).home == null && statistics.get(i).away == null && item.away == null && item.home==null)||
								((statistics.get(i).home.equals(item.home))&&(statistics.get(i).away.equals(item.away))) )) {
					return true;
				}
			}
			return false;
		}

}

