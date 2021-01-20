package sofaScore.models.gameStatistics;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GameStatisticNew {

	@Expose
	public ArrayList<GameStatisticsForOneAttributeNew> statistics;
	
	public boolean containsSatatistic(GameStatisticsForOneAttributeNew item) {
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
	
	public void addStatistic(GameStatisticsForOneAttributeNew item) {
		if(this.statistics == null) {this.statistics= new ArrayList<>();}
		if(this.statistics.isEmpty()) {this.statistics.add(item);}
		else {
			GameStatisticsForOneAttributeNew  itemToAdd = new GameStatisticsForOneAttributeNew();
			itemToAdd.period = item.period;
			itemToAdd.groupName = item.groupName;
			itemToAdd.name = item.name;
			itemToAdd.home = itemToAdd.away = null;
			this.statistics.add(itemToAdd);			
		}
	}
	public void itHaveTheSameTo(GameStatisticNew newGameStatistic) {
		Gson gson = new Gson().newBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String resultGameGsonString = gson.toJson(this);
		
		String newGameGsonString = gson.toJson(newGameStatistic);			
		if(resultGameGsonString.equals(newGameGsonString)) {}
		else {
			for(int i = 0 ; i <newGameStatistic.statistics.size(); i++) {
					if(! this.containsSatatistic(newGameStatistic.statistics.get(i))) {
						this.addStatistic(newGameStatistic.statistics.get(i));
					}
			}
		}		
	}
	
}

