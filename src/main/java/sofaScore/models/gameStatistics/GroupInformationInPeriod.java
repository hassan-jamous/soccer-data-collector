package sofaScore.models.gameStatistics;

import java.util.ArrayList;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class GroupInformationInPeriod {

	public String groupName;
	public ArrayList<ItemStatisticsInGroup> statisticsItems;
	
}
