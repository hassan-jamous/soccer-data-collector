package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
//to save head to head between two clubs
public class HistoryGame implements Comparable <HistoryGame>{

	public String competitionName;
	public String year;
	public String roundInfo;
	public Game gameInfo;
	
	@Override
	public int compareTo(HistoryGame objecttoCompare) {
		
		if(objecttoCompare == null) {return 1;}
		String[] thisStrings = this.gameInfo.date.split("/");
		String[] otherStrings = objecttoCompare.gameInfo.date.split("/");				
		int thisYear = Integer.valueOf(thisStrings[2]);
		int otherYear = Integer.valueOf(otherStrings[2]);
		if(thisYear == otherYear) {
			int thisMonth = Integer.valueOf(thisStrings[1]);
			int otherMonth = Integer.valueOf(otherStrings[1]);
			if(thisMonth == otherMonth) {
				int thisDay = Integer.valueOf(thisStrings[0]);
				int otherDay = Integer.valueOf(otherStrings[0]);
				return otherDay-thisDay;
			}else {
				return otherMonth-thisMonth;
			}
		}else {
			return  otherYear-thisYear;
		}
	}
}
