package sofaScore.models.gameStatistics;

import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class GameStatisticsForOneAttributeNew implements Comparable <GameStatisticsForOneAttributeNew> {
	HashMapStatisticPeriod hashMapPeriod = new HashMapStatisticPeriod();
	HashMapStatisticGroupName hashMapGroupName = new HashMapStatisticGroupName();
	HashMapStatisticName hashMapName = new HashMapStatisticName();
	@Expose
	public String period;
	@Expose
	public String groupName;
	@Expose
	public String name;
	
	public String home;
	public String away;
	
	public GameStatisticsForOneAttributeNew(String period , String groupName , String name , String home, String away) {
		this.period = period;
		this.groupName = groupName;
		this.name =name;
		this.home =home;
		this.away =away;
	}

	@Override
	public int compareTo(GameStatisticsForOneAttributeNew objecttoCompare) {
		if(this.period.equals(objecttoCompare.period)) {
			if(this.groupName.equals(objecttoCompare.groupName)) {
				return hashMapName.getNameId(name) - hashMapName.getNameId(objecttoCompare.name);
			}
			else {
				return hashMapGroupName.getGroupNameId(groupName) - hashMapGroupName.getGroupNameId(objecttoCompare.groupName);
			}
		}
		else{
			return hashMapPeriod.getPeriodID(period) - hashMapPeriod.getPeriodID(objecttoCompare.period) ;
		}		
	}
	
}
	