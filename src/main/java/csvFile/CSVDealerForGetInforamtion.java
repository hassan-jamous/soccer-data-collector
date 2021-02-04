package csvFile;

import lombok.NoArgsConstructor;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameStatistics.GameStatistics;
import worldfootball.models.Game;
import worldfootball.models.HistoyGame;
/**
 * 
 * to get the information as string to be written in the file
 *
 */
@NoArgsConstructor
public class CSVDealerForGetInforamtion {

	public String getValuesStringForCSV(GameStatistics obj) {
		String result =String.valueOf(obj.hasFivePeriods)+" ,";
		for(int i = 0 ; i < obj.statistics.size() ; i++) {
			result +=obj.statistics.get(i).home+" ,"+obj.statistics.get(i).away+" ,";
		}
		return result;
	}
	
	public String getValueStringForCSV(HistoyGame game) {
	
		String result ="";
		result = game.competitionName+" ,"+game.year+" ,"+game.roundInfo+" ,"+getValueStringForCSV(game.gameInfo);
		return result;
	}
	
	public String getValueStringForCSV(Game game) {
		
		String result ="";
		result = game.date+" ,"+game.time+" ,"+game.firstTeamBasicInfo.name+" ,"+game.secondTeamBasicInfo.name+" ,"+
		game.finalResult+((game.resultOfFirstHalf==null)?" ,":("("+game.resultOfFirstHalf+") ,"));
		return result;
	}
	
	public String getHeaderStringForCSV(GameStatistics obj) {
		String result ="Has Extra Time ,";
		for(int i = 0 ; i < obj.statistics.size() ; i++) {
			result += obj.statistics.get(i).period+" "+obj.statistics.get(i).groupName+" "+
					obj.statistics.get(i).name+" Home ,"+
					obj.statistics.get(i).period+" "+obj.statistics.get(i).groupName+" "+
					obj.statistics.get(i).name+" Away ,";
		}
		return result;
	}
	
	//ask hassan what we want to print
	//the different
	//https://api.sofascore.com/api/v1/event/7821318
	//https://api.sofascore.com/api/v1/event/7805352
	public String getValuesStringForCSV(GameBasicInformation obj) {
		String result ="";
		result = obj.event.tournament.uniqueTournament.name+" ,"+obj.event.season.year+" ,"+ obj.event.tournament.name+" ,"+obj.event.roundInfo.round+" ,"
		+obj.event.homeTeam.shortName+" ,"+obj.event.awayTeam.shortName +" ,"+obj.event.homeScore.current+" ,"+
				obj.event.awayScore.current+" ,";
		return result;
	}
	
	public String getHeaderStringForCSV(GameBasicInformation obj) {
		String result ="League , Years ,Type Of League ,Round , Home Team , Away Team ,  HomeScore , Away Score ,";
		return result;
	}
}
