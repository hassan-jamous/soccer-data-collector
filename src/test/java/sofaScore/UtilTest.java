package sofaScore;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(leaguePremierLeague19_20.table.get(0)).usingRecursiveComparison().isEqualTo(new ClubRanking(1,"Liverpool",38,32,3,3,85,33,99));
        assertThat(leaguePremierLeague19_20.table.get(2)).usingRecursiveComparison().isEqualTo(new ClubRanking(3,"Man Utd",38,18,12,8,66,36,66));
       
        RankingTable leaguePremierLeague20_21 =	util.getRankingTableForComptitionUntil("Premier League", "20/21", "2021-02-10 00:00:00");
        assertThat(leaguePremierLeague20_21.table.get(0)).usingRecursiveComparison().isEqualTo(new ClubRanking(1,"Man City",22,15,5,2,43,14,50));
        assertThat(leaguePremierLeague20_21.table.get(1)).usingRecursiveComparison().isEqualTo(new ClubRanking(2,"Man Utd",23,13,6,4,49,30,45));
        assertThat(leaguePremierLeague20_21.table.get(7)).usingRecursiveComparison().isEqualTo(new ClubRanking(8,"Tottenham",22,10,6,6,36,22,36));
        assertThat(leaguePremierLeague20_21.table.get(10)).usingRecursiveComparison().isEqualTo(new ClubRanking(11,"Arsenal",23,9,4,10,27,23,31));
      
	}
	
	@Test
	public void itShouldGetClubRankingAt() {
	
		ClubRanking LiverpoolPremierLeague19_20Until2020_09_01 =	util.getClubRankingAt("Premier League", "19/20", "2020-09-01 00:00:00","Liverpool");
        assertThat(LiverpoolPremierLeague19_20Until2020_09_01).usingRecursiveComparison().isEqualTo(new ClubRanking(1,"Liverpool",38,32,3,3,85,33,99));
	}
	
	@Test
	public void itShouldGetHeadToHeadSinceUntil() {
		
		List<GameBasicInformation> ManUtd_Liverpool2019_8_1TO2019_11_29 = util.getHeadToHeadFromDataBaseSinceUntil("Premier League","Man Utd", "Liverpool", "2019-08-01 00:00:00","2019-11-29 00:00:00");
        assertThat(ManUtd_Liverpool2019_8_1TO2019_11_29.get(0).event.awayScore.current).isEqualTo(1);
        assertThat(ManUtd_Liverpool2019_8_1TO2019_11_29.get(0).event.homeScore.current).isEqualTo(1);
        assertThat(ManUtd_Liverpool2019_8_1TO2019_11_29.get(0).event.roundInfo.round).isEqualTo(9);
        assertThat(ManUtd_Liverpool2019_8_1TO2019_11_29.get(0).event.homeTeam.name).isEqualTo("Man Utd");
        assertThat(ManUtd_Liverpool2019_8_1TO2019_11_29.size()).isEqualTo(1);
        
        List<GameBasicInformation> ManUtd_Liverpool2019_8_1TO2021_2_1 = util.getHeadToHeadFromDataBaseSinceUntil("Premier League","Man Utd", "Liverpool", "2019-08-01 00:00:00","2021-02-10 00:00:00");
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(0).event.awayScore.current).isEqualTo(1);
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(0).event.homeScore.current).isEqualTo(1);
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(0).event.roundInfo.round).isEqualTo(9);
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(0).event.homeTeam.name).isEqualTo("Man Utd");
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(1).event.awayScore.current).isEqualTo(0);
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(1).event.homeScore.current).isEqualTo(2);
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(1).event.roundInfo.round).isEqualTo(23);
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(1).event.homeTeam.name).isEqualTo("Liverpool");
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(2).event.awayScore.current).isEqualTo(0);
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(2).event.homeScore.current).isEqualTo(0);
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(2).event.roundInfo.round).isEqualTo(19);
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.get(2).event.homeTeam.name).isEqualTo("Liverpool");
        assertThat(ManUtd_Liverpool2019_8_1TO2021_2_1.size()).isEqualTo(3);

	}

}
