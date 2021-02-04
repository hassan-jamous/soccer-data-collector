package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class HistoryGameWithRanking implements Comparable <HistoryGameWithRanking> {

	public int firstTeamRanking;
	public int secondTeamRanking;
	public String competition;
	public HistoryGame game;
	
	@Override
	public int compareTo(HistoryGameWithRanking objecttoCompare) {
		
		if(objecttoCompare == null) {return 1;}
		String[] thisStrings = this.game.gameInfo.date.split("/");
		String[] otherStrings = objecttoCompare.game.gameInfo.date.split("/");				
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
