package testUtilities;


import sofaScore.RoundCollector;
import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.models.gameStatistics.GameStatistics;

public class SofaScoreTestHelper {

	RoundCollector roundtest = new RoundCollector();
	
	public void getGamesIDs(String CompetitionName , String CompetitionYear, String round) {
		
		RoundGamesID s = roundtest.getGamesIdInRound(CompetitionName, CompetitionYear, round,"");
		for(int i =0 ; i < s.events.size(); i++) {
			System.out.println("i ="+i+"   id="+s.events.get(i));
		}
		
	}
 
	public void printStatistics(GameStatistics game) {
		for(int i =0 ; i <game.statistics.size(); i++) {
			System.out.println(
					game.statistics.get(i).period+"    "+
					game.statistics.get(i).groupName+"    "+
					game.statistics.get(i).name+"    "+
					game.statistics.get(i).home+"    "+
					game.statistics.get(i).away);
		}
	}
}
