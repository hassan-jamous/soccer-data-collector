package csvFile;

import lombok.NoArgsConstructor;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameStatistics.GameStatistics;
/**
 * 
 * to get the information as string to be written in the file
 *
 */
@NoArgsConstructor
public class CSVDealerForGetInforamtion {

	public String getValuesStringForCSV(GameStatistics obj) {
		String result ="";
		for(int i = 0 ; i < obj.statistics.size() ; i++) {
			result +=obj.statistics.get(i).home+" ,"+obj.statistics.get(i).away+" ,";
		}
		return result;
	}
	
	public String getHeaderStringForCSV(GameStatistics obj) {
		String result ="";
		for(int i = 0 ; i < obj.statistics.size() ; i++) {
			result += obj.statistics.get(i).period+" "+obj.statistics.get(i).groupName+" "+
					obj.statistics.get(i).name+" Home ,"+
					obj.statistics.get(i).period+" "+obj.statistics.get(i).groupName+" "+
					obj.statistics.get(i).name+" Away ,";
		}
		return result;
	}
	
	public String getValuesStringForCSV(GameBasicInformation obj) {
		String result ="";
		result = obj.event.tournament.name+" ,"+obj.event.season.year+" ,"+obj.event.roundInfo.round+" ,"
		+obj.event.homeTeam.name+" ,"+obj.event.awayTeam.name +" ,"+obj.event.homeScore.current+" ,"+
				obj.event.awayScore.current+" ,";
		return result;
	}
	
	public String getHeaderStringForCSV(GameBasicInformation obj) {
		String result ="League , Years ,Round , Home Team , Away Team , HomeScore , Away Score ,";
		
		return result;
	}
}
