package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
//to save head to head between two clubs
public class HistoyGame implements Comparable <HistoyGame>{

	public String competitionName;
	public String year;
	public String roundInfo;
	public Game gameInfo;
	
	@Override
	public int compareTo(HistoyGame objecttoCompare) {
		
		int thisYear = Integer.valueOf(this.year.substring(0, 4));
		int objYear  = Integer.valueOf(objecttoCompare.year.substring(0, 4));
		return  objYear - thisYear;				
	}
}
