package sofaScore;

import java.util.List;

import org.junit.Test;

import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.ranking.ClubRanking;
import sofaScore.models.ranking.RankingTable;

public class UtilTest {

	Util util = new Util();
	
	@Test
	public void itShouldGetLeagueRankingTable() {
	
		RankingTable leaguePremierLeague19_20 =	util.getRankingTableForComptitionUntil("Premier League", "19/20", "2020-09-01 00:00:00");
		for(int i =0 ; i < leaguePremierLeague19_20.table.size(); i++) {
			System.out.println(leaguePremierLeague19_20.table.get(i).position+"   "+leaguePremierLeague19_20.table.get(i).clubName+ "  "+leaguePremierLeague19_20.table.get(i).points+" "+
					(leaguePremierLeague19_20.table.get(i).hisGoals-leaguePremierLeague19_20.table.get(i).againstGoals));
		}
	}
	
	@Test
	public void itShouldGetClubRankingAt() {
	
		ClubRanking LiverpoolPremierLeague19_20Until2020_09_01 =	util.getClubRankingAt("Premier League", "19/20", "2020-09-01 00:00:00","Liverpool");
		System.out.println(LiverpoolPremierLeague19_20Until2020_09_01.position+"   "+LiverpoolPremierLeague19_20Until2020_09_01.clubName+ "  "+LiverpoolPremierLeague19_20Until2020_09_01.points+" "+
					(LiverpoolPremierLeague19_20Until2020_09_01.hisGoals-LiverpoolPremierLeague19_20Until2020_09_01.againstGoals));
		
	
		ClubRanking LiverpoolPremierLeague19_20Until2019_08_26 =	util.getClubRankingAt("Premier League", "19/20", "2019-08-26 00:00:00","Liverpool");
		System.out.println(LiverpoolPremierLeague19_20Until2019_08_26.position+"   "+LiverpoolPremierLeague19_20Until2019_08_26.clubName+ "  "+LiverpoolPremierLeague19_20Until2019_08_26.points+" "+
				(LiverpoolPremierLeague19_20Until2019_08_26.hisGoals-LiverpoolPremierLeague19_20Until2019_08_26.againstGoals));
		
		ClubRanking ManUtdPremierLeague19_20Until2019_08_26 =	util.getClubRankingAt("Premier League", "19/20", "2019-08-26 00:00:00","Man Utd");
		System.out.println(ManUtdPremierLeague19_20Until2019_08_26.position+"   "+ManUtdPremierLeague19_20Until2019_08_26.clubName+ "  "+ManUtdPremierLeague19_20Until2019_08_26.points+" "+
				(ManUtdPremierLeague19_20Until2019_08_26.hisGoals-ManUtdPremierLeague19_20Until2019_08_26.againstGoals));
	}
	
	@Test
	public void itShouldGetHeadToHeadSinceUntil() {
		List<GameBasicInformation> ManUtd_Liverpool = util.getHeadToHeadFromDataBaseSinceUntil("Premier League","Man Utd", "Liverpool", "2019-08-01 00:00:00","2019-11-29 00:00:00");
		for(int i = 0 ; i < ManUtd_Liverpool.size(); i++) {
			System.out.println(ManUtd_Liverpool.get(i).event.roundInfo.round+"  "+ManUtd_Liverpool.get(i).event.getDateToPrint());
		}
		System.out.println(ManUtd_Liverpool.size());
	}

}
