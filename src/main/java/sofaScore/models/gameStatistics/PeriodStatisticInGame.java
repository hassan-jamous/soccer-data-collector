package sofaScore.models.gameStatistics;

import java.util.ArrayList;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class PeriodStatisticInGame {

	public String period;
	public ArrayList<GroupInformationInPeriod> groups;

}
