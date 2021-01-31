package sofaScore.models.gameStatistics;

//import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class GameStatisticsForOneItem implements Comparable <GameStatisticsForOneItem> {
	
	public String period;
	public String groupName;
	public String name;
	public String home;
	public String away;

	@Override
	public int compareTo(GameStatisticsForOneItem objecttoCompare) {
		HashMapStatisticPeriod hashMapPeriod = new HashMapStatisticPeriod();
		HashMapStatisticGroupName hashMapGroupName = new HashMapStatisticGroupName();
		HashMapStatisticName hashMapName = new HashMapStatisticName();
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
	