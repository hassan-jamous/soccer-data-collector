package collector;

import models.Club;
import models.ClubForRankingTable;
import models.ClubTransferTable;
import models.DirtyGame;
import models.Game;
import models.GamesTableOfLeague;
import models.Goal;
import models.GoalInMatchDetails;
import models.KindOfReferee;
import models.MatchDetails;
import models.MatchSummary;
import models.ClubInMatchDetails;
import models.PlayerAllInformation;
import models.PlayerAtMatch;
import models.PlayerClubCareer;
import models.PlayerCompetitionInformationOverall;
import models.PlayerCompetitionInformation;
import models.PlayerEventAtMatch;
import models.PlayerOpponentRecordInformation;
import models.PlayerPersonalInformation;
import models.PlayerRefereeRecordInformation;
import models.PlayerSummary;
import models.PlayerTeamManaged;
import models.PlayerTopScoreForSeason;
import models.PlayerTopSoccer;
import models.PlayerTypeAtMatch;
import models.RankingTable;
import models.RankingTableRequest;
import models.Referee;
import models.Staduim;
import models.StatisticsBestPlayerInYear;
import models.StatisticsGoalsPerRound;
import models.StatisticsGoalsPerSeason;
import models.StatisticsMostGoalsByPlayerPerGame;
import models.StatisticsRecordWinsAndMostGoalInGame;
import models.StatisticsRequestKind;
import models.TransferPlayerInformation;
import sofaScore.SofaScoreCollector;
import sofaScoreModels.GameStatistic;
import sofaScoreModels.ItemStatisticsInGroup;

import java.util.*;

/*import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;
import org.assertj.core.error.ShouldContainAtIndex;*/
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ScreenScraperTest {
	WorldFootballGamesInTableOfLeagueValues gamesInTableworldFootballValues = new WorldFootballGamesInTableOfLeagueValues();
	WorldFootballRankingTableValues rankingTablesWorldFootballValues = new WorldFootballRankingTableValues();
	WorldFootballGoalsValues goalsWorldFootBallValues = new WorldFootballGoalsValues();
	public void assertGameInRound(GamesTableOfLeague gamesTableActualValue, List<Game> gamesExpectedValue, List<Integer> gamesIds, int roundNumber) {
        for (int i = 0; i < gamesExpectedValue.size(); i++) {
            assertThat(gamesExpectedValue.get(i)).usingRecursiveComparison().isEqualTo(gamesTableActualValue.rounds.get(roundNumber - 1).games.get(gamesIds.get(i)));
        }
    }

    @Test
    public void itShouldGetGamesTableOfLeague() {
    	
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        GamesTableOfLeague gamesTableActualValue2015_2016 = screenScraperUnderTest.getAllRounds("eng-premier-league", "2015-2016");

        List<Game> gamesInRound4At2015_2016 = gamesInTableworldFootballValues.getGamesInRoundInSeason("2015-2016", 4);
        List<Integer> gamesIdsInRound4At2015_2016 = Arrays.asList(0, 1, 8);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound4At2015_2016, gamesIdsInRound4At2015_2016, 4);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(3).games.size());

        List<Game> gamesInRound9At2015_2016 = gamesInTableworldFootballValues.getGamesInRoundInSeason("2015-2016", 9);
        List<Integer> gamesIdsInRound9At2015_2016 = Arrays.asList(0, 3, 8, 9);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound9At2015_2016, gamesIdsInRound9At2015_2016, 9);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(8).games.size());

        List<Game> gamesInRound14At2015_2016 = gamesInTableworldFootballValues.getGamesInRoundInSeason("2015-2016", 14);
        List<Integer> gamesIdsInRound14At2015_2016 = Arrays.asList(1, 5, 7, 8);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound14At2015_2016, gamesIdsInRound14At2015_2016, 14);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(13).games.size());

        List<Game> gamesInRound21At2015_2016 = gamesInTableworldFootballValues.getGamesInRoundInSeason("2015-2016",21);
        List<Integer> gamesIdsInRound21At2015_2016 = Arrays.asList(0, 2, 9);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound21At2015_2016, gamesIdsInRound21At2015_2016, 21);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(20).games.size());

        List<Game> gamesInRound27At2015_2016 = gamesInTableworldFootballValues.getGamesInRoundInSeason("2015-2016", 27);
        List<Integer> gamesIdsInRound27At2015_2016 = Arrays.asList(6, 7, 9);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound27At2015_2016, gamesIdsInRound27At2015_2016, 27);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(26).games.size());

        List<Game> gamesInRound35At2015_2016 = gamesInTableworldFootballValues.getGamesInRoundInSeason("2015-2016", 35);       		
        List<Integer> gamesIdsInRound35At2015_2016 = Arrays.asList(0, 4, 8);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound35At2015_2016, gamesIdsInRound35At2015_2016, 35);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(34).games.size());
        
        Assert.assertEquals(38, gamesTableActualValue2015_2016.rounds.size());


        GamesTableOfLeague gamesTableActualValue2005_2006 = screenScraperUnderTest.getAllRounds("eng-premier-league", "2005-2006");

        List<Game> gamesInRound2At2005_2006 = gamesInTableworldFootballValues.getGamesInRoundInSeason("2005-2006", 2);
        List<Integer> gamesIdsInRound2At2005_2006 = Arrays.asList(0, 1, 6, 8);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound2At2005_2006, gamesIdsInRound2At2005_2006, 2);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(1).games.size());

        List<Game> gamesInRound12At2005_2006 = gamesInTableworldFootballValues.getGamesInRoundInSeason("2005-2006", 12);
        List<Integer> gamesIdsInRound12At2005_2006 = Arrays.asList(2, 6, 8);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound12At2005_2006, gamesIdsInRound12At2005_2006, 12);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(11).games.size());

        List<Game> gamesInRound20At2005_2006 = gamesInTableworldFootballValues.getGamesInRoundInSeason("2005-2006", 20);
        List<Integer> gamesIdsInRound20At2005_2006 = Arrays.asList(0, 3, 9);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound20At2005_2006, gamesIdsInRound20At2005_2006, 20);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(19).games.size());

        List<Game> gamesInRound32At2005_2006 = gamesInTableworldFootballValues.getGamesInRoundInSeason("2005-2006", 32);
        List<Integer> gamesIdsInRound32At2005_2006 = Arrays.asList(0, 1, 7, 9);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound32At2005_2006, gamesIdsInRound32At2005_2006, 32);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(31).games.size());

        Assert.assertEquals(38, gamesTableActualValue2005_2006.rounds.size());

        
        GamesTableOfLeague gamesTableActualValue1960_1961 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1960-1961");
       
        List<Game> gamesInRound1At1960_1961 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1960-1961", 1);
        List<Integer> gamesIdsInRound1At1960_1961 = Arrays.asList(0, 5, 8, 10);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound1At1960_1961, gamesIdsInRound1At1960_1961, 1);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(0).games.size());

        List<Game> gamesInRound4At1960_1961 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1960-1961", 4);
        List<Integer> gamesIdsInRound4At1960_1961 = Arrays.asList(1, 2, 3, 9);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound4At1960_1961, gamesIdsInRound4At1960_1961, 4);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(3).games.size());

        List<Game> gamesInRound16At1960_1961 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1960-1961", 16);
        List<Integer> gamesIdsInRound16At1960_1961 = Arrays.asList(0, 1, 9, 10);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound16At1960_1961, gamesIdsInRound16At1960_1961, 16);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(15).games.size());

        List<Game> gamesInRound27At1960_1961 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1960-1961", 27);
        List<Integer> gamesIdsInRound27At1960_1961 = Arrays.asList(2, 5, 8, 10);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound27At1960_1961, gamesIdsInRound27At1960_1961, 27);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(26).games.size());

        List<Game> gamesInRound36At1960_1961 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1960-1961", 36);
        List<Integer> gamesIdsInRound36At1960_1961 = Arrays.asList(0, 1, 7, 9);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound36At1960_1961, gamesIdsInRound36At1960_1961, 36);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(35).games.size());

        Assert.assertEquals(42, gamesTableActualValue1960_1961.rounds.size());

        GamesTableOfLeague gamesTableActualValue1925_1926 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1925-1926");

        List<Game> gamesInRound3At1925_1926 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1925-1926", 3);
        List<Integer> gamesIdsInRound3At1925_1926 = Arrays.asList(1, 3, 10);
        assertGameInRound(gamesTableActualValue1925_1926, gamesInRound3At1925_1926, gamesIdsInRound3At1925_1926, 3);
        Assert.assertEquals(11, gamesTableActualValue1925_1926.rounds.get(2).games.size());

        List<Game> gamesInRound35At1925_1926 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1925-1926",35);
        List<Integer> gamesIdsInRound35At1925_1926 = Arrays.asList(0, 1, 5);
        assertGameInRound(gamesTableActualValue1925_1926, gamesInRound35At1925_1926, gamesIdsInRound35At1925_1926, 35);
        Assert.assertEquals(8, gamesTableActualValue1925_1926.rounds.get(34).games.size());

        List<Game> gamesInRound36At1925_1926 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1925-1926", 36);
        List<Integer> gamesIdsInRound36At1925_1926 = Arrays.asList(0, 2, 7, 11);
        assertGameInRound(gamesTableActualValue1925_1926, gamesInRound36At1925_1926, gamesIdsInRound36At1925_1926, 36);
        Assert.assertEquals(13, gamesTableActualValue1925_1926.rounds.get(35).games.size());

        Assert.assertEquals(42, gamesTableActualValue1925_1926.rounds.size());

        GamesTableOfLeague gamesTableActualValue1891_1892 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1891-1892");
        List<Game> gamesInRound1At1891_1892 =gamesInTableworldFootballValues.getGamesInRoundInSeason("1891-1892", 1);
        List<Integer> gamesIdsInRound36At1891_1892 = Arrays.asList(1, 4, 6);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound1At1891_1892, gamesIdsInRound36At1891_1892, 1);
        Assert.assertEquals(7, gamesTableActualValue1891_1892.rounds.get(0).games.size());

        List<Game> gamesInRound6At1891_1892 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1891-1892",6);
        List<Integer> gamesIdsInRound6At1891_1892 = Arrays.asList(1, 2, 5, 7);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound6At1891_1892, gamesIdsInRound6At1891_1892, 6);
        Assert.assertEquals(8, gamesTableActualValue1891_1892.rounds.get(5).games.size());

        List<Game> gamesInRound14At1891_1892 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1891-1892", 14);
        List<Integer> gamesIdsInRound14At1891_1892 = Arrays.asList(0, 1, 4, 6);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound14At1891_1892, gamesIdsInRound14At1891_1892, 14);
        Assert.assertEquals(7, gamesTableActualValue1891_1892.rounds.get(13).games.size());

        List<Game> gamesInRound23At1891_1892 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1891-1892", 23);
        List<Integer> gamesIdsInRound23At1891_1892 = Arrays.asList(3, 4, 5);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound23At1891_1892, gamesIdsInRound23At1891_1892, 23);
        Assert.assertEquals(6, gamesTableActualValue1891_1892.rounds.get(22).games.size());

        Assert.assertEquals(26, gamesTableActualValue1891_1892.rounds.size());

        //this season starts with round 0, 
        GamesTableOfLeague gamesTableActualValue1888_1889 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1888-1889");
        
        List<Game> gamesInRound2At1888_1889 =gamesInTableworldFootballValues.getGamesInRoundInSeason("1888-1889", 2);
        List<Integer> gamesIdsInRound2At1888_1889 = Arrays.asList(0 ,1 ,2 ,3 , 4, 5);
        assertGameInRound(gamesTableActualValue1888_1889, gamesInRound2At1888_1889, gamesIdsInRound2At1888_1889, 2+1);//this season starts with round 0
        Assert.assertEquals(6, gamesTableActualValue1888_1889.rounds.get(2).games.size());//this season starts with round 0

        Assert.assertEquals(23, gamesTableActualValue1888_1889.rounds.size());


    }
    public void assertRankingTable(RankingTable rankingTableActualValue, List<ClubForRankingTable> clubsExpectedValue, List<Integer> clubsIds) {
        for (int i = 0; i < clubsExpectedValue.size(); i++) {
            assertThat(clubsExpectedValue.get(i)).usingRecursiveComparison().isEqualTo(rankingTableActualValue.table.get(clubsIds.get(i)));
        }
    }

    @Test
    public void itShouldGetLastRankingTableOfLeague() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        
        RankingTable rankingTable1889_1890ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "1889-1890");
        List<ClubForRankingTable> rankingTable1889_1890Expected = rankingTablesWorldFootballValues.getLastRankingTable("eng-premier-league", "1889-1890"); 
        List<Integer> clubsIdInRankingTable1889_1890 = Arrays.asList(0 ,1 ,2 ,3 , 4, 5, 6, 7, 8, 9, 10, 11);
        assertRankingTable(rankingTable1889_1890ActualValue ,rankingTable1889_1890Expected , clubsIdInRankingTable1889_1890);

        RankingTable rankingTable1906_1907ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "1906-1907");
        List<Integer> clubsIdInRankingTable1906_1907 = Arrays.asList(0 ,1 ,2 , 7, 11, 17);
        List<ClubForRankingTable> rankingTable1906_1907Expected = rankingTablesWorldFootballValues.getLastRankingTable("eng-premier-league", "1906-1907");
        assertRankingTable(rankingTable1906_1907ActualValue ,rankingTable1906_1907Expected ,  clubsIdInRankingTable1906_1907);
        Assert.assertEquals(20, rankingTable1906_1907ActualValue.table.size());

        RankingTable rankingTable1959_1960ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "1959-1960");
        List<Integer> clubsIdInRankingTable1959_1960 = Arrays.asList(1 , 6, 20);
        List<ClubForRankingTable> rankingTable1960_1970Expected = rankingTablesWorldFootballValues.getLastRankingTable("eng-premier-league", "1959-1960");
        assertRankingTable(rankingTable1959_1960ActualValue ,rankingTable1960_1970Expected ,  clubsIdInRankingTable1959_1960);
        Assert.assertEquals(22, rankingTable1959_1960ActualValue.table.size());

        RankingTable rankingTable2007_2008ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "2007-2008");
        List<Integer> clubsIdInRankingTable2007_2008 = Arrays.asList(0 , 3, 11);
        List<ClubForRankingTable> rankingTable2007_2008Expected = rankingTablesWorldFootballValues.getLastRankingTable("eng-premier-league", "2007-2008");
        assertRankingTable(rankingTable2007_2008ActualValue  ,  rankingTable2007_2008Expected , clubsIdInRankingTable2007_2008);
        Assert.assertEquals(20, rankingTable2007_2008ActualValue.table.size());

        RankingTable rankingTable2017_2018ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "2017-2018");
        List<Integer> clubsIdInRankingTable2017_2018 = Arrays.asList(1 , 5, 18);
        List<ClubForRankingTable> rankingTable2017_2018Expected = rankingTablesWorldFootballValues.getLastRankingTable("eng-premier-league", "2017-2018");
        assertRankingTable(rankingTable2017_2018ActualValue  ,  rankingTable2017_2018Expected , clubsIdInRankingTable2017_2018);
        Assert.assertEquals(20, rankingTable2017_2018ActualValue.table.size());


    }

    @Test
    public void itShouldGetRankingTableByRound() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        RankingTable rankingTable2012_2013ByRound14NormalActualValue = screenScraperUnderTest.getTableByRound("eng-premier-league", "2012-2013", "14", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable2012_2013Round14Normal = Arrays.asList(0, 1 , 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
        List<ClubForRankingTable> rankingTable2012_2013Expected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable2012_2013Expected");
        assertRankingTable(rankingTable2012_2013ByRound14NormalActualValue , rankingTable2012_2013Expected ,  clubsIdInRankingTable2012_2013Round14Normal  );

        RankingTable rankingTable2018_2019Round21AwayActualValue = screenScraperUnderTest.getTableByRound("eng-premier-league", "2018-2019", "21", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable2018_2019Round21Away = Arrays.asList(0, 1 , 17);
        List<ClubForRankingTable> rankingTable2018_2019Round21AwayExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable2018_2019Round21AwayExpected");
        assertRankingTable(rankingTable2018_2019Round21AwayActualValue , rankingTable2018_2019Round21AwayExpected ,  clubsIdInRankingTable2018_2019Round21Away  );
        Assert.assertEquals(20, rankingTable2018_2019Round21AwayActualValue.table.size());

        RankingTable rankingTableActualValue2013_2014ByRound27Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "2013-2014", "27", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable2013_2014Round27Home = Arrays.asList(0, 5);
        List<ClubForRankingTable> rankingTable2013_2014Round21HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable2013_2014Round21HomeExpected");
        assertRankingTable(rankingTableActualValue2013_2014ByRound27Home , rankingTable2013_2014Round21HomeExpected ,  clubsIdInRankingTable2013_2014Round27Home  );
        Assert.assertEquals(20, rankingTableActualValue2013_2014ByRound27Home.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable2000_2001Round11Normal = Arrays.asList(0, 4, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11NormalExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable2000_2001Round11NormalExpected");
        assertRankingTable(rankingTableActualValue2000_2001ByRound11Normal , rankingTable2000_2001Round11NormalExpected ,  clubsIdInRankingTable2000_2001Round11Normal  );
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Normal.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable2000_2001Round11Away = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11AwayExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable2000_2001Round11AwayExpected");
        assertRankingTable(rankingTableActualValue2000_2001ByRound11Away , rankingTable2000_2001Round11AwayExpected ,  clubsIdInRankingTable2000_2001Round11Away  );
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Away.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable2000_2001ByRound11Home = Arrays.asList(0, 1, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTableActualValue2000_2001ByRound11Home");
        assertRankingTable(rankingTableActualValue2000_2001ByRound11Home , rankingTable2000_2001Round11HomeExpected ,  clubsIdInRankingTable2000_2001ByRound11Home  );
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Home.table.size());

        RankingTable rankingTableActualValue1955_1956ByRound20Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1955-1956", "20", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1955_1956ByRound20Normal = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1955_1956Round20AwayExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Manchester United", "20", "10", "6", "4", "38:28", "10", "26:14"),
        		new ClubForRankingTable("4", "Charlton Athletic", "20", "10", "4", "6", "46:38", "8", "24:16"),
        		new ClubForRankingTable("14", "Newcastle United", "20", "9", "2", "9", "43:37", "6", "20:20"));
        assertRankingTable(rankingTableActualValue1955_1956ByRound20Normal , rankingTable1955_1956Round20AwayExpected ,  clubsIdInRankingTable1955_1956ByRound20Normal  );
        Assert.assertEquals(22, rankingTableActualValue1955_1956ByRound20Normal.table.size());

        RankingTable rankingTableActualValue1977_1978ByRound37Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1977-1978", "37", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1977_1978ByRound37Away = Arrays.asList(0, 3, 10);
        List<ClubForRankingTable> rankingTable1977_1978Round37AwayExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTableActualValue1955_1956ByRound20Normal");
        assertRankingTable(rankingTableActualValue1977_1978ByRound37Away , rankingTable1977_1978Round37AwayExpected ,  clubsIdInRankingTable1977_1978ByRound37Away  );
        Assert.assertEquals(22, rankingTableActualValue1977_1978ByRound37Away.table.size());

        RankingTable rankingTableActualValue1985_1986ByRound26Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1985-1986", "26", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1985_1986ByRound26Home = Arrays.asList(0, 1, 13);
        List<ClubForRankingTable> rankingTable1985_1986ByRound26HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1985_1986ByRound26HomeExpected");
        assertRankingTable(rankingTableActualValue1985_1986ByRound26Home , rankingTable1985_1986ByRound26HomeExpected ,  clubsIdInRankingTable1985_1986ByRound26Home  );
        Assert.assertEquals(22, rankingTableActualValue1985_1986ByRound26Home.table.size());

        RankingTable rankingTableActualValue1948_1949ByRound27Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1948-1949", "27", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1948_1949ByRound27Normal = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1948_1949ByRound27HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1948_1949ByRound27HomeExpected");
        assertRankingTable(rankingTableActualValue1948_1949ByRound27Normal , rankingTable1948_1949ByRound27HomeExpected ,  clubsIdInRankingTable1948_1949ByRound27Normal  );
        Assert.assertEquals(22, rankingTableActualValue1948_1949ByRound27Normal.table.size());

        RankingTable rankingTableActualValue1930_1931ByRound8Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1930-1931", "8", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1930_1931ByRound8Away = Arrays.asList(0, 21);
        List<ClubForRankingTable> rankingTable1930_1931ByRound8HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1930_1931ByRound8HomeExpected");
        assertRankingTable(rankingTableActualValue1930_1931ByRound8Away , rankingTable1930_1931ByRound8HomeExpected ,  clubsIdInRankingTable1930_1931ByRound8Away  );
        Assert.assertEquals(22, rankingTableActualValue1930_1931ByRound8Away.table.size());

        RankingTable rankingTableActualValue1925_1926ByRound12Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1925-1926", "12", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1925_1926ByRound12Home = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1925_1926ByRound12HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1925_1926ByRound12HomeExpected");
        assertRankingTable(rankingTableActualValue1925_1926ByRound12Home , rankingTable1925_1926ByRound12HomeExpected ,  clubsIdInRankingTable1925_1926ByRound12Home  );
        Assert.assertEquals(22, rankingTableActualValue1925_1926ByRound12Home.table.size());

        RankingTable rankingTableActualValue1898_1899ByRound18Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1898-1899", "18", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1898_1899ByRound18Normal = Arrays.asList(0, 5, 15);
        List<ClubForRankingTable> rankingTable1898_1899ByRound18NormalExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1898_1899ByRound18NormalExpected");
        assertRankingTable(rankingTableActualValue1898_1899ByRound18Normal , rankingTable1898_1899ByRound18NormalExpected ,  clubsIdInRankingTable1898_1899ByRound18Normal  );
        Assert.assertEquals(18, rankingTableActualValue1898_1899ByRound18Normal.table.size());

        RankingTable rankingTableActualValue1888_1889ByRound10Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1888-1889", "10", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1888_1889ByRound10Away = Arrays.asList(0, 4, 10);
        List<ClubForRankingTable> rankingTable1888_1889ByRound10AwayExpected =rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1888_1889ByRound10AwayExpected");
        assertRankingTable(rankingTableActualValue1888_1889ByRound10Away , rankingTable1888_1889ByRound10AwayExpected ,  clubsIdInRankingTable1888_1889ByRound10Away  );
        Assert.assertEquals(12, rankingTableActualValue1888_1889ByRound10Away.table.size());

        RankingTable rankingTableActualValue1891_1892ByRound18Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1891-1892", "18", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1891_1892ByRound18Home = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1891_1892ByRound12HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1891_1892ByRound12HomeExpected");
        assertRankingTable(rankingTableActualValue1891_1892ByRound18Home , rankingTable1891_1892ByRound12HomeExpected ,  clubsIdInRankingTable1891_1892ByRound18Home  );
        Assert.assertEquals(14, rankingTableActualValue1891_1892ByRound18Home.table.size());

    }
    
    public void assertGameGoal(ArrayList<Goal> goalsActualValue, List<Goal> goalsExpectedValue) {
        for (int i = 0; i < goalsExpectedValue.size(); i++) {
            assertThat(goalsExpectedValue.get(i)).usingRecursiveComparison().isEqualTo(goalsActualValue.get(i));
        }
    }

    @Test
    public void itShouldGetGameGoals() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<Goal> goals2020_2021BrightonHoveAlbionVsBurnleyFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2020-2021", "brighton-hove-albion", "burnley-fc");
        Assert.assertEquals(null, goals2020_2021BrightonHoveAlbionVsBurnleyFcActualValue);

        ArrayList<Goal> goals2017_2018LiverpoolFcBrightonHoveAlbionActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2017-2018", "liverpool-fc", "brighton-hove-albion");
        List<Goal> goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue = goalsWorldFootBallValues.getGamesGoalsValue("premier-league", "goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue");      
        assertGameGoal(goals2017_2018LiverpoolFcBrightonHoveAlbionActualValue,goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue);
       
        ArrayList<Goal> goals2015_2016ArsenalFcAstonVillaActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2015-2016", "arsenal-fc", "aston-villa");
        List<Goal> goals2015_2016ArsenalFcAstonVillaExpectedValue = Arrays.asList(
        		new Goal("1 : 0", "5", "Olivier Giroud", "header", "Nacho Monreal"),
        		new Goal("2 : 0", "78", "Olivier Giroud", "left-footed shot", "Mesut Özil"),
        		new Goal("3 : 0", "80", "Olivier Giroud", "left-footed shot", "Héctor Bellerín"),
        		new Goal("4 : 0", "90", "Mark Bunn", "own goal"));
        assertGameGoal(goals2015_2016ArsenalFcAstonVillaActualValue,goals2015_2016ArsenalFcAstonVillaExpectedValue);

        ArrayList<Goal> goals2015_2016SunderlandAfcChelseaFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2015-2016", "sunderland-afc", "chelsea-fc");
        List<Goal> goals2015_2016SunderlandAfcChelseaFcExpectedValue = Arrays.asList(
        		new Goal("0 : 1", "14", "Diego Costa", "right-footed shot"),
        		new Goal("1 : 1", "41", "Wahbi Khazri", "right-footed shot"),
        		new Goal("1 : 2", "45", "Nemanja Matić", "left-footed shot", "Azpilicueta"),
        		new Goal("2 : 2", "67", "Fabio Borini", "right-footed shot", "Patrick van Aanholt"),
        		new Goal("3 : 2", "70", "Jermain Defoe", "right-footed shot"));
        assertGameGoal(goals2015_2016SunderlandAfcChelseaFcActualValue,goals2015_2016SunderlandAfcChelseaFcExpectedValue);
 
        ArrayList<Goal> goals2000_2001BradfordCityLeicesterCityActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2000-2001", "bradford-city", "leicester-city");
        Assert.assertEquals(null, goals2000_2001BradfordCityLeicesterCityActualValue);

        ArrayList<Goal> goals2000_2001LeedsUnitedEvertonFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2000-2001", "leeds-united", "everton-fc");
        List<Goal> goals2000_2001LeedsUnitedEvertonFcExpectedValue = Arrays.asList(
        		new Goal("1 : 0", "16", "Alan Smith"),
        		new Goal("2 : 0", "37", "Alan Smith"));
        assertGameGoal(goals2000_2001LeedsUnitedEvertonFcActualValue, goals2000_2001LeedsUnitedEvertonFcExpectedValue);
 
        ArrayList<Goal> goals1998_1999ArsenalFcAstonVillaActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1998-1999", "arsenal-fc", "aston-villa");
        List<Goal> goals1998_1999ArsenalFcAstonVillaExpected = Arrays.asList(
        		new Goal("1 : 0", "66", "Nwankwo Kanu"));
        assertGameGoal(goals1998_1999ArsenalFcAstonVillaActualValue ,goals1998_1999ArsenalFcAstonVillaExpected);

        ArrayList<Goal> goals1996_1997ManchesterUnitedWestHamUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1996-1997", "manchester-united", "west-ham-united");
        List<Goal> goals1996_1997ManchesterUnitedWestHamUnitedExpected = Arrays.asList(
        		new Goal("1 : 0", "11", "Ole Gunnar Solskjær"),
        		new Goal("2 : 0", "84", "Jordi Cruyff"));
        assertGameGoal(goals1996_1997ManchesterUnitedWestHamUnitedActualValue , goals1996_1997ManchesterUnitedWestHamUnitedExpected );

        ArrayList<Goal> goals1992_1993LiverpoolFcNottinghamForestActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1992-1993", "liverpool-fc", "nottingham-forest");
        Assert.assertEquals(null, goals1992_1993LiverpoolFcNottinghamForestActualValue);

        ArrayList<Goal> goals1992_1993ChelseaFcSheffieldUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1992-1993", "chelsea-fc", "sheffield-united");
        List<Goal> goals1992_1993ChelseaFcSheffieldUnitedExpected = Arrays.asList(
        		new Goal("0 : 1", "40", "Adrian Littlejohn"),
        		new Goal("1 : 1", "41", "Andy Townsend"),
        		new Goal("1 : 2", "57", "Brian Deane"));
        assertGameGoal(goals1992_1993ChelseaFcSheffieldUnitedActualValue , goals1992_1993ChelseaFcSheffieldUnitedExpected );

        ArrayList<Goal> goals1983_1984TottenhamHotspurManchesterUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1983-1984", "tottenham-hotspur", "manchester-united");
        List<Goal> goals1983_1984TottenhamHotspurManchesterUnitedExpected = Arrays.asList(
        		new Goal("1 : 0", "90", "Steve Archibald"),
        		new Goal("1 : 1", "90", "Norman Whiteside"));
        assertGameGoal(goals1983_1984TottenhamHotspurManchesterUnitedActualValue , goals1983_1984TottenhamHotspurManchesterUnitedExpected );

        ArrayList<Goal> goals1976_1977LeedsUnitedCoventryCityActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1976-1977", "leeds-united", "coventry-city");
        List<Goal> goals1976_1977LeedsUnitedCoventryCityExpected = Arrays.asList(
        		new Goal("0 : 1", "45", "Alan Green"),
        		new Goal("1 : 1", "45", "Joe Jordan"),
        		new Goal("1 : 2", "90", "Donal Murphy"));
        assertGameGoal(goals1976_1977LeedsUnitedCoventryCityActualValue , goals1976_1977LeedsUnitedCoventryCityExpected );

        ArrayList<Goal> goals1963_1964SheffieldUnitedBurnleyFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1963-1964", "sheffield-united", "burnley-fc");
        List<Goal> goals1963_1964SheffieldUnitedBurnleyFcExpected = Arrays.asList(
        		new Goal("1 : 0", "90", "Tony Wagstaff"),
        		new Goal("2 : 0", "90", "Mick Jones"));
        assertGameGoal(goals1963_1964SheffieldUnitedBurnleyFcActualValue , goals1963_1964SheffieldUnitedBurnleyFcExpected );

        ArrayList<Goal> goals1956_1957SheffieldWednesdayChelseaFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "sheffield-wednesday", "chelsea-fc");
        List<Goal> goals1956_1957SheffieldWednesdayChelseaFcExpectedValue = Arrays.asList(
        		new Goal("1 : 0", "0","Roy Shiner" ),
        		new Goal("2 : 0", "0","Roy Shiner"),
        		new Goal("3 : 0", "0","Albert Quixall"),
        		new Goal("4 : 0", "0","Albert Quixall"));
        assertGameGoal(goals1956_1957SheffieldWednesdayChelseaFcActualValue , goals1956_1957SheffieldWednesdayChelseaFcExpectedValue );

        ArrayList<Goal> goals1956_1957TottenhamHotspurLeedsUnitedActualVlaue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "tottenham-hotspur", "leeds-united");
        List<Goal> goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue = Arrays.asList(
        		new Goal("1 : 0", "0","Bobby Smith"),
        		new Goal("2 : 0", "0","George Robb"),
        		new Goal("3 : 0", "0","Terry Medwin"),
        		new Goal("4 : 0", "0","John Brooks"),
        		new Goal("5 : 0", "0","Danny Blanchflower"),
        		new Goal("5 : 1", "0","Keith Ripley"));
        assertGameGoal(goals1956_1957TottenhamHotspurLeedsUnitedActualVlaue , goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue );

        ArrayList<Goal> goalsActualValueoldGoalZeroToZero = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "aston-villa", "west-bromwich-albion");
        Assert.assertEquals(null, goalsActualValueoldGoalZeroToZero);

        ArrayList<Goal> goals1946_1947LeedsUnitedSunderlandAfcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1946-1947", "leeds-united", "sunderland-afc");
        List<Goal> goals1946_1947LeedsUnitedSunderlandAfcExpected = Arrays.asList(
        		new Goal("1 : 0", "90", "Davy Cochrane"),
        		new Goal("1 : 1", "90", "Jackie Robinson"));
        assertGameGoal(goals1946_1947LeedsUnitedSunderlandAfcActualValue , goals1946_1947LeedsUnitedSunderlandAfcExpected );


    }
    
    public void assertPlayersSummaryInTeam(ArrayList<PlayerSummary> playersClubActualValue, List<PlayerSummary> playersInClubExpectedValue , List<Integer> playersIds) {
        for (int i = 0; i < playersInClubExpectedValue.size(); i++) {
            assertThat(playersInClubExpectedValue.get(i)).usingRecursiveComparison().isEqualTo(playersClubActualValue.get(playersIds.get(i)));
        }
    }

    @Test
    public void itShouldGetPlayersSummuryInTeam() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        
        ArrayList<PlayerSummary> playersManchesterUnited2015ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "2015");
        List<PlayerSummary> playersManchesterUnited2015Expected = Arrays.asList(
        		new PlayerSummary("40", "Ben Amos", "England", "10/04/1990", "Goalkeeper"),
        		new PlayerSummary("1", "De Gea", "Spain", "07/11/1990", "Goalkeeper"),
        		new PlayerSummary("13", "Anders Lindegaard", "Denmark", "13/04/1984", "Goalkeeper"),
        		new PlayerSummary("32", "Víctor Valdés", "Spain", "14/01/1982", "Goalkeeper"),
        		new PlayerSummary("42", "Tyler Blackett", "England", "02/04/1994", "Defender"),
        		new PlayerSummary("6", "Jonny Evans", "Northern Ireland", "03/01/1988", "Defender"),
        		new PlayerSummary("37", "Saidy Janko", "Switzerland", "22/10/1995", "Defender"),
        		new PlayerSummary("4", "Phil Jones", "England", "21/02/1992", "Defender"),
        		new PlayerSummary(null, "Andrew Kellett", "England", "10/11/1993", "Defender"),
        		new PlayerSummary("33", "Paddy McNair", "Northern Ireland", "27/04/1995", "Defender"),
        		new PlayerSummary("2", "Rafael", "Brazil", "09/07/1990", "Defender"),
        		new PlayerSummary("5", "Marcos Rojo", "Argentina", "20/03/1990", "Defender"),
        		new PlayerSummary("3", "Luke Shaw", "England", "12/07/1995", "Defender"),
        		new PlayerSummary("12", "Chris Smalling", "England", "22/11/1989", "Defender"),
        		new PlayerSummary("39", "Tom Thorpe", "England", "13/01/1993", "Defender"),
        		new PlayerSummary("21", "Ander Herrera", "Spain", "14/08/1989", "Midfielder"),
        		new PlayerSummary("44", "Andreas Pereira", "Brazil", "01/01/1996", "Midfielder"),
        		new PlayerSummary("17", "Daley Blind", "Netherlands", "09/03/1990", "Midfielder"),
        		new PlayerSummary("16", "Michael Carrick", "England", "28/07/1981", "Midfielder"),
        		new PlayerSummary("31", "Marouane Fellaini", "Belgium", "22/11/1987", "Midfielder"),
        		new PlayerSummary("11", "Adnan Januzaj", "Belgium", "05/02/1995", "Midfielder"),
        		new PlayerSummary("8", "Mata", "Spain", "28/04/1988", "Midfielder"),
        		new PlayerSummary("25", "Antonio Valencia", "Ecuador", "04/08/1985", "Midfielder"),
        		new PlayerSummary("18", "Ashley Young", "England", "09/07/1985", "Midfielder"),
        		new PlayerSummary("7", "Ángel Di María", "Argentina", "14/02/1988", "Forward"),
        		new PlayerSummary("9", "Radamel Falcao", "Colombia", "10/02/1986", "Forward"),
        		new PlayerSummary("10", "Wayne Rooney", "England", "24/10/1985", "Forward"),
        		new PlayerSummary("20", "Robin van Persie", "Netherlands", "06/08/1983", "Forward"),
        		new PlayerSummary("49", "James Wilson", "England", "01/12/1995", "Forward"),
        		new PlayerSummary(null, "Louis van Gaal", "Netherlands", "08/08/1951", "Manager"),
        		new PlayerSummary(null, "Marcel Bout", "Netherlands", "18/11/1962", "Ass. Manager"),
        		new PlayerSummary(null, "Ryan Giggs", "Wales", "29/11/1973", "Ass. Manager"),
        		new PlayerSummary(null, "Albert Stuivenberg", "Netherlands", "30/10/1970", "Ass. Manager"),
        		new PlayerSummary(null, "Frans Hoek", "Netherlands", "17/10/1956", "Goalkeeper-Coach"));
        List<Integer> playersIdManchesterUnited2015 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
        		,21,22,23,24,25,26,27,28,29,30,31,32,33,34);    
        
        assertPlayersSummaryInTeam(playersManchesterUnited2015ActualValue,playersManchesterUnited2015Expected,playersIdManchesterUnited2015);

        ArrayList<PlayerSummary> playersManchesterUnited2001ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "2001");
        List<Integer> playersIdManchesterUnited2001 = Arrays.asList(0,3,4,8,15,32,38,39); 
        List<PlayerSummary> playersManchesterUnited2001Expected = Arrays.asList(
        		new PlayerSummary("1", "Fabien Barthez", "France", "28/06/1971", "Goalkeeper"),
        		new PlayerSummary("17", "Raimond van der Gouw", "Netherlands", "24/03/1963", "Goalkeeper"),
        		new PlayerSummary("24", "Wes Brown", "England", "13/10/1979", "Defender"),
        		new PlayerSummary(null, "Mark Lynch", "England", "02/09/1981", "Defender"),
        		new PlayerSummary("7", "David Beckham", "England", "02/05/1975", "Midfielder"),
        		new PlayerSummary("9", "Andy Cole", "England", "15/10/1971", "Forward"),
        		new PlayerSummary(null, "Alex Ferguson", "Scotland", "31/12/1941", "Manager"),
        		new PlayerSummary(null, "Steve McClaren", "England", "03/05/1961", "Ass. Manager"));
        assertPlayersSummaryInTeam(playersManchesterUnited2001ActualValue,playersManchesterUnited2001Expected,playersIdManchesterUnited2001);

        ArrayList<PlayerSummary> playersManchesterUnited1991ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1991");
        List<Integer> playersIdManchesterUnited1991 = Arrays.asList(0,3,4,8,15,23,29); 
        List<PlayerSummary> playersManchesterUnited1991Expected = Arrays.asList(
        		new PlayerSummary(null, "Mark Bosnich", "Australia", "13/01/1972", "Goalkeeper"),
        		new PlayerSummary("25", "Gary Walsh", "England", "21/03/1968", "Goalkeeper"),
        		new PlayerSummary("15", "Clayton Blackmore", "Wales", "23/09/1964", "Defender"),
        		new PlayerSummary(null, "Lee Martin", "England", "05/02/1968", "Defender"),
        		new PlayerSummary(null, "Andrey Kanchelskis", "Russia", "23/01/1969", "Midfielder"),
        		new PlayerSummary(null, "Jeff Baicher", "USA", "16/11/1968", "Forward"),
        		new PlayerSummary(null, "Alex Ferguson", "Scotland", "31/12/1941", "Manager"));
        assertPlayersSummaryInTeam(playersManchesterUnited1991ActualValue,playersManchesterUnited1991Expected,playersIdManchesterUnited1991);

        ArrayList<PlayerSummary> playersManchesterUnited1970ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1970");
        List<Integer> playersIdManchesterUnited1970 = Arrays.asList(0,2,11,17,18,24,26);
        List<PlayerSummary> playersManchesterUnited1970Expected = Arrays.asList(
        		new PlayerSummary(null, "Jimmy Rimmer", "England", "10/02/1948", "Goalkeeper"),
        		new PlayerSummary(null, "Shay Brennan", "Ireland", "06/05/1937", "Defender"),
        		new PlayerSummary(null, "Bobby Charlton", "England", "11/10/1937", "Midfielder"),
        		new PlayerSummary(null, "John Aston", "England", "28/07/1947", "Forward"),
        		new PlayerSummary("7", "George Best", "Northern Ireland", "22/05/1946", "Forward"),
        		new PlayerSummary(null, "Wilf McGuinness", "England", "25/10/1937", "Manager"),
        		new PlayerSummary(null, "Jimmy Murphy", "Wales", "27/10/1910", "Ass. Manager"));
        assertPlayersSummaryInTeam(playersManchesterUnited1970ActualValue,playersManchesterUnited1970Expected,playersIdManchesterUnited1970);
        
        ArrayList<PlayerSummary> manchesterUnitedActualValueplayers1966 = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1966");
        List<Integer> playersIdManchesterUnited1966 = Arrays.asList(0,4,12);
        List<PlayerSummary> playersManchesterUnited1966Expected = Arrays.asList(
        		new PlayerSummary(null, "Pat Dunne", "Ireland", "09/02/1943", "Goalkeeper"),
        		new PlayerSummary(null, "Shay Brennan", "Ireland", "06/05/1937", "Defender"),
        		new PlayerSummary(null, "Bobby Charlton", "England", "11/10/1937", "Midfielder"));
        assertPlayersSummaryInTeam(manchesterUnitedActualValueplayers1966,playersManchesterUnited1966Expected,playersIdManchesterUnited1966);

        ArrayList<PlayerSummary> playersManchesterUnited1950ActualValue = screenScraperUnderTest.getAllPlayersSummaryInClub("manchester-united", "1950");
        List<Integer> playersIdManchesterUnited1950 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27);
        List<PlayerSummary> playersManchesterUnited1950Expected = Arrays.asList(
        		new PlayerSummary(null, "Jack Crompton", "England", "18/12/1921", "Goalkeeper"),
        		new PlayerSummary(null, "Sonny Feehan", "Ireland", "17/09/1926", "Goalkeeper"),
        		new PlayerSummary(null, "Joe Lancaster", "England", "28/04/1926", "Goalkeeper"),
        		new PlayerSummary(null, "Ray Wood", "England", "11/06/1931", "Goalkeeper"),        		
        		new PlayerSummary(null, "John Aston", "England", "03/09/1921", "Defender"),
        		new PlayerSummary(null, "John Ball", "England", "13/03/1925", "Defender"),
        		new PlayerSummary(null, "Johnny Carey", "Ireland", "23/02/1919", "Defender"),
        		new PlayerSummary(null, "Sammy Lynn", "England", "25/12/1920", "Defender"),
        		new PlayerSummary(null, "Tommy McNulty", "England", "30/12/1929", "Defender"),
        		new PlayerSummary(null, "Billy Redman", "England", "29/01/1928", "Defender"),
        		new PlayerSummary(null, "Jack Warner", "Wales", "21/09/1911", "Defender"),        		
        		new PlayerSummary(null, "Allenby Chilton", "England", "16/09/1918", "Midfielder"),
        		new PlayerSummary(null, "Henry Cockburn", "England", "14/09/1923", "Midfielder"),
        		new PlayerSummary(null, "Don Gibson", "England", "12/05/1929", "Midfielder"),
        		new PlayerSummary(null, "Tommy Lowrie", "Scotland", "14/01/1928", "Midfielder"),
        		new PlayerSummary(null, "Billy McGlen", "England", "27/04/1921", "Midfielder"),
        		new PlayerSummary(null, "Jeff Whitefoot", "England", "31/12/1933", "Midfielder"),        		
        		new PlayerSummary(null, "Brian Birch", "England", "18/11/1931", "Forward"),
        		new PlayerSummary(null, "Tommy Bogan", "Scotland", "18/05/1920", "Forward"),
        		new PlayerSummary(null, "Laurie Cassidy", "England", "10/03/1923", "Forward"),
        		new PlayerSummary(null, "Frank Clempson", "England", "27/05/1930", "Forward"),
        		new PlayerSummary(null, "Jimmy Delaney", "Scotland", "03/09/1914", "Forward"),
        		new PlayerSummary(null, "Johnny Downie", "Scotland", "19/07/1925", "Forward"),
        		new PlayerSummary(null, "Charlie Mitten", "England", "17/01/1921", "Forward"),
        		new PlayerSummary(null, "Stan Pearson", "England", "11/01/1919", "Forward"),
        		new PlayerSummary(null, "Jack Rowley", "England", "07/10/1920", "Forward"),
        		new PlayerSummary(null, "Matt Busby", "Scotland", "26/05/1909", "Manager"),
        		new PlayerSummary(null, "Jimmy Murphy", "Wales", "27/10/1910", "Ass. Manager"));
        assertPlayersSummaryInTeam(playersManchesterUnited1950ActualValue,playersManchesterUnited1950Expected,playersIdManchesterUnited1950);

        ArrayList<PlayerSummary> playersManchesterUnited1890ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1890");
        List<Integer> playersIdManchesterUnited1890 = Arrays.asList(0,1,2,3,4);
        List<PlayerSummary> playersManchesterUnited1890Expected = Arrays.asList(
        		new PlayerSummary(null, "Tom Burke", "Wales", "1862", "Midfielder"),
        		new PlayerSummary(null, "Joe Davies", "Wales", "12/07/1864", "Midfielder"),
        		new PlayerSummary(null, "Roger Doughty", "Wales", "1868", "Midfielder"),
        		new PlayerSummary(null, "Thomas Craig", "England", "", "Forward"),
        		new PlayerSummary(null, "Jack Doughty", "England", "10/1865", "Forward"));
        assertPlayersSummaryInTeam(playersManchesterUnited1890ActualValue,playersManchesterUnited1890Expected,playersIdManchesterUnited1890);

        ArrayList<PlayerSummary> playersAccrington1890ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("Accrington", "1890");
        Assert.assertEquals(null,playersAccrington1890ActualValue);

    }
    
    public void assertClubsInSeason(ArrayList<Club> clubsInSeasonActualValue, List<Club> clubsInSeasonExpectedValue, List<Integer> clubsIdSeason ) {
    	for (int i = 0; i < clubsInSeasonExpectedValue.size(); i++) {
    		assertThat(clubsInSeasonActualValue.get(i)).usingRecursiveComparison().isEqualTo(clubsInSeasonExpectedValue.get(clubsIdSeason.get(i)));
    	}
    }

    @Test
    public void itShouldGetClubsInSeason() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<Club> clubsAt2015_2016ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("eng-premier-league", "2015-2016");
        List<Integer> clubsIdAtSeason2015_2016 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19); 
        List<Club> clubsAt2015_2016Expected = Arrays.asList(
        		new Club("AFC Bournemouth"),
        		new Club("Arsenal FC"),
        		new Club("Aston Villa"),
        		new Club("Chelsea FC"),
        		new Club("Crystal Palace"),
        		new Club("Everton FC"),
        		new Club("Leicester City"),
        		new Club("Liverpool FC"),
        		new Club("Manchester City"),
        		new Club("Manchester United"),
        		new Club("Newcastle United"),
        		new Club("Norwich City"),
        		new Club("Southampton FC"),
        		new Club("Stoke City"),
        		new Club("Sunderland AFC"),
        		new Club("Swansea City"),
        		new Club("Tottenham Hotspur"),
        		new Club("Watford FC"),
        		new Club("West Bromwich Albion"),
        		new Club("West Ham United"));      
        assertClubsInSeason(clubsAt2015_2016ActualValue,clubsAt2015_2016Expected,clubsIdAtSeason2015_2016);

        ArrayList<Club> clubsAt1967_1968ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("eng-premier-league", "1967-1968");
        List<Integer> clubsIdAtSeason1967_1968 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21); 
        List<Club> clubsAt1967_1968Expected = Arrays.asList(
        		new Club("Arsenal FC"),
        		new Club("Burnley FC"),
        		new Club("Chelsea FC"),
        		new Club("Coventry City"),
        		new Club("Everton FC"),
        		new Club("Fulham FC"),
        		new Club("Leeds United"),
        		new Club("Leicester City"),
        		new Club("Liverpool FC"),
        		new Club("Manchester City"),
        		new Club("Manchester United"),
        		new Club("Newcastle United"),
        		new Club("Nottingham Forest"),
        		new Club("Sheffield United"),
        		new Club("Sheffield Wednesday"),
        		new Club("Southampton FC"),
        		new Club("Stoke City"),
        		new Club("Sunderland AFC"),
        		new Club("Tottenham Hotspur"),
        		new Club("West Bromwich Albion"),
        		new Club("West Ham United"),
        		new Club("Wolverhampton Wanderers"));
        assertClubsInSeason(clubsAt1967_1968ActualValue,clubsAt1967_1968Expected,clubsIdAtSeason1967_1968);

        ArrayList<Club> clubsAt1889_1890ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("eng-premier-league", "1889-1890");
        List<Integer> clubsIdAtSeason1890_1891 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11); 
        List<Club> clubsAt1889_1890Expected = Arrays.asList(
        		new Club("Accrington FC"),
        		new Club("Aston Villa"),
        		new Club("Blackburn Rovers"),
        		new Club("Bolton Wanderers"),
        		new Club("Burnley FC"),
        		new Club("Derby County"),
        		new Club("Everton FC"),
        		new Club("Notts County"),
        		new Club("Preston North End"),
        		new Club("Stoke City"),
        		new Club("West Bromwich Albion"),
        		new Club("Wolverhampton Wanderers"));
        assertClubsInSeason(clubsAt1889_1890ActualValue,clubsAt1889_1890Expected,clubsIdAtSeason1890_1891);

    }

      
    public void assertPlayerInformationWithIndexes(PlayerAllInformation playerInfoActualValue, List<WorldFootBallAttributeFor_TEST> attributeList , PlayerAllInformation playerInfoExpectedValue) {
     	
    	for(int i =0 ; i<attributeList.size() ; i++) {
    		
    		int limit ;
    		if(attributeList.get(i).attributeName.equals("personalInfo")) {
	    		assertThat(playerInfoActualValue.personalInfo).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.personalInfo);
    		}
    		else if(attributeList.get(i).attributeName.equals("teamsManaged")) {
    			if(playerInfoExpectedValue.teamsManaged == null) {
    		        Assert.assertEquals(null, playerInfoActualValue.teamsManaged);
    			}
    			else{
	    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.teamsManaged.size() : attributeList.get(i).indexes.size(); 
	     			int j =0;
	    			while(j<limit) {
	    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
	    				assertThat(playerInfoActualValue.teamsManaged.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.teamsManaged.get(j)); 
	    				j++;
	    			}
    			}
    		}
    		else if(attributeList.get(i).attributeName.equals("clubsCareer")) {
    			if(playerInfoExpectedValue.clubsCareer == null) {
    		        Assert.assertEquals(null, playerInfoActualValue.clubsCareer);
    			}
    			else{
	    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.clubsCareer.size() : attributeList.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
	    				assertThat(playerInfoActualValue.clubsCareer.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.clubsCareer.get(j)); 
	    				j++;
	    			}
    			}
    		}    			
    		else if(attributeList.get(i).attributeName.equals("clubMatches")) {
    			if(playerInfoExpectedValue.clubMatches == null) {
    		        Assert.assertEquals(null, playerInfoActualValue.clubMatches);
    			}
    			else{
	    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.clubMatches.size() : attributeList.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
	    				assertThat(playerInfoActualValue.clubMatches.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.clubMatches.get(j)); 
	    				j++;
	    			}
    			}
    		}
            else if(attributeList.get(i).attributeName.equals("internationalCopmetitionsInfo")) {
            	if(playerInfoExpectedValue.internationalCopmetitionsInfo == null) {
    		        Assert.assertEquals(null, playerInfoActualValue.internationalCopmetitionsInfo);
    			}
    			else{            
	    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.internationalCopmetitionsInfo.size() : attributeList.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
	    				assertThat(playerInfoActualValue.internationalCopmetitionsInfo.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.internationalCopmetitionsInfo.get(j)); 
	    				j++;
	    			}
    			} 
            }
    		else if(attributeList.get(i).attributeName.equals("clubsMatchesOverall")) {    			
    			if(playerInfoExpectedValue.clubsMatchesOverall == null) {
    		        Assert.assertEquals(null, playerInfoActualValue.clubsMatchesOverall);
    			}
    			else{
	    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.clubsMatchesOverall.size() : attributeList.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
	    				assertThat(playerInfoActualValue.clubsMatchesOverall.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.clubsMatchesOverall.get(j)); 
	    				j++;
	    			}
    			}
        	}                    			
    		else if(attributeList.get(i).attributeName.equals("internationalCopmetitionsOverall")) {
    			if(playerInfoExpectedValue.internationalCopmetitionsOverall == null) {
    		        Assert.assertEquals(null, playerInfoActualValue.internationalCopmetitionsOverall);
    			}
    			else{    		
	    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.internationalCopmetitionsOverall.size() : attributeList.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
	    				assertThat(playerInfoActualValue.internationalCopmetitionsOverall.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.internationalCopmetitionsOverall.get(j)); 
	    				j++;
	    			}
    			}
        	}
    		else if(attributeList.get(i).attributeName.equals("internationalCopmetitionsOverall")) {
    			if(playerInfoExpectedValue.internationalCopmetitionsOverall == null) {
    		        Assert.assertEquals(null, playerInfoActualValue.internationalCopmetitionsOverall);
    			}
    			else{    		
	    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.internationalCopmetitionsOverall.size() : attributeList.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
	    				assertThat(playerInfoActualValue.internationalCopmetitionsOverall.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.internationalCopmetitionsOverall.get(j)); 
	    				j++;
	    			}
    			}
        	}
    		else if(attributeList.get(i).attributeName.equals("internationalCopmetitionsOverall")) {
    			if(playerInfoExpectedValue.internationalCopmetitionsOverall == null) {
    		        Assert.assertEquals(null, playerInfoActualValue.internationalCopmetitionsOverall);
    			}
    			else{    		
	    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.internationalCopmetitionsOverall.size() : attributeList.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
	    				assertThat(playerInfoActualValue.internationalCopmetitionsOverall.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.internationalCopmetitionsOverall.get(j)); 
	    				j++;
	    			}
    			}
        	}
        	else if(attributeList.get(i).attributeName.equals("recordReferee")) {
        		if(playerInfoExpectedValue.recordReferee == null) {
    		        Assert.assertEquals(null, playerInfoActualValue.recordReferee);
    			}
    			else{        	
	    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.recordReferee.size() : attributeList.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
	    				assertThat(playerInfoActualValue.recordReferee.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.recordReferee.get(j)); 
	    				j++;
	    			}
    			}
        	}
    		else if(attributeList.get(i).attributeName.equals("recordOpponent")) {
    			if(playerInfoExpectedValue.recordOpponent == null) {
    		        Assert.assertEquals(null, playerInfoActualValue.recordOpponent);
    			}
    			else{    		
	    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.recordOpponent.size() : attributeList.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
	    				assertThat(playerInfoActualValue.recordOpponent.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.recordOpponent.get(j)); 
	    				j++;
	    			}
    			}
   		}
 		else if(attributeList.get(i).attributeName.equals("forEachCompetitionInformationOverallsClubs")) {
			if(playerInfoExpectedValue.forEachCompetitionInformationOverallsClubs == null) {
		        Assert.assertEquals(null, playerInfoActualValue.forEachCompetitionInformationOverallsClubs);
			}
			else{    		
    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.forEachCompetitionInformationOverallsClubs.size() : attributeList.get(i).indexes.size(); 
    			int j =0;
    			while(j<limit) {
    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
    				assertThat(playerInfoActualValue.forEachCompetitionInformationOverallsClubs.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.forEachCompetitionInformationOverallsClubs.get(j)); 
    				j++;
    			}
			}
    	}
 		else if(attributeList.get(i).attributeName.equals("forEachCompetitionInformationOverallsInternational")) {
			if(playerInfoExpectedValue.forEachCompetitionInformationOverallsInternational == null) {
		        Assert.assertEquals(null, playerInfoActualValue.forEachCompetitionInformationOverallsInternational);
			}
			else{    		
    			limit = (attributeList.get(i).indexes.isEmpty())? playerInfoActualValue.forEachCompetitionInformationOverallsInternational.size() : attributeList.get(i).indexes.size(); 
    			int j =0;
    			while(j<limit) {
    				int index = (attributeList.get(i).indexes.isEmpty())?j :attributeList.get(i).indexes.get(j);
    				assertThat(playerInfoActualValue.forEachCompetitionInformationOverallsInternational.get(index)).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.forEachCompetitionInformationOverallsInternational.get(j)); 
    				j++;
    			}
			}
    	}
    		
		}
    }
       
    @Test
    public void itShouldGetPlayerInformation() {

        ScreenScraper screenScraperTest = new ScreenScraper();        
        
        //https://www.worldfootball.net/player_summary/eric-bailly/
        PlayerAllInformation player1ActualValueInfo = screenScraperTest.playerCollector.getAllInformationAboutPlayer("eric-bailly");        
        PlayerAllInformation player1ExpectedValueInfo = new PlayerAllInformation();
        player1ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Eric Bailly","Eric Bertrand Bailly",
                "12.04.1994", "Bingerville, Ivory Coast", new  ArrayList<String>(Arrays.asList("Ivory Coast")), "187 cm",
                "77 kg",new  ArrayList<String>(Arrays.asList( "Centre Back")), "right");
        player1ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("07/2016 - 06/2022", "Manchester United", "England", "Defender", "#3"),
        		new PlayerClubCareer("01/2020 - 01/2020", "Manchester United U23", "England", "Defender", null),
        		new PlayerClubCareer("01/2017 - 01/2017", "Manchester United U23", "England", "Defender", null),
        		new PlayerClubCareer("01/2015 - 06/2016", "Villarreal CF", "Spain", "Defender", null),
        		new PlayerClubCareer("09/2014 - 01/2015", "Espanyol Barcelona", "Spain", "Defender", null),
        		new PlayerClubCareer("03/2013 - 01/2015", "Espanyol Barcelona B", "Spain", "Defender", null),
        		new PlayerClubCareer("07/2012 - 06/2013", "Espanyol Barcelona [Youth]", "Spain", "Defender", null)));
        player1ExpectedValueInfo.clubMatches = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("Champions League", "UEFA", "7", "0", "7", "0", "1", "2", "0", "0"),
        		new PlayerCompetitionInformation("Europa League", "UEFA", "24", "1", "24", "0", "2", "4", "2", "1"),
        		new PlayerCompetitionInformation("Premier League", "England", "59", "1", "48", "11", "5", "8", "0", "1"),
        		new PlayerCompetitionInformation("FA Cup", "England", "6", "0", "5", "1", "2", "1", "0", "0"),
        		new PlayerCompetitionInformation("League Cup", "England", "5", "0", "5", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformation("FA Community Shield", "England", "1", "0", "1", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformation("U23 Premier League Div. 1", "England", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformation("U23 Premier League Div. 2", "England", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformation("Primera División", "Spanien", "40", "0", "39", "1", "10", "15", "1", "0"),
        		new PlayerCompetitionInformation("Copa del Rey", "Spanien", "3", "0", "3", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformation("Segunda B Grupo 3", "Spanien", "22", "0", "19", "3", "2", "6", "1", "0"),
        		new PlayerCompetitionInformation("∑", null, "169", "2", "153", "16", "24", "39", "4", "2")));
        player1ExpectedValueInfo.clubsMatchesOverall = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2020/2021", "Manchester United", "5", "0", "4", "1", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "2020/2021", "Manchester United", "3", "0", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "2019/2020", "Manchester United", "4", "0", "4", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "2019/2020", "Manchester United", "3", "0", "3", "0", "2", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2019/2020", "Manchester United", "4", "0", "1", "3", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "U23 PL Div.2", "2019/2020", "Manchester United U23", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2018/2019", "Manchester United", "12", "0", "8", "4", "2", "0", "0", "1"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "2018/2019", "Manchester United", "4", "0", "4", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "2018/2019", "Manchester United", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "2018/2019", "Manchester United", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2017/2018", "Manchester United", "13", "1", "11", "2", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "2017/2018", "Manchester United", "2", "0", "1", "1", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "2017/2018", "Manchester United", "3", "0", "3", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2016/2017", "Manchester United", "25", "0", "24", "1", "3", "4", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "2016/2017", "Manchester United", "11", "0", "11", "0", "0", "2", "1", "1"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "2016/2017", "Manchester United", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "U23 PL Div.1", "2016/2017", "Manchester United U23", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Com. Shield", "2016", "Manchester United", "1", "0", "1", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "Pr. División", "2015/2016", "Villarreal CF", "25", "0", "25", "0", "6", "9", "1", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "2015/2016", "Villarreal CF", "7", "1", "7", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "Copa del Rey", "2015/2016", "Villarreal CF", "3", "0", "3", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "Pr. División", "2014/2015", "Villarreal CF", "10", "0", "10", "0", "3", "5", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "2014/2015", "Villarreal CF", "2", "0", "2", "0", "0", "0", "1", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "Pr. División", "2014/2015", "Espanyol Barcelona", "5", "0", "4", "1", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "2ª B G3", "2014/2015", "Espanyol Barcelona B", "1", "0", "1", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "2ª B G3", "2013/2014", "Espanyol Barcelona B", "21", "0", "18", "3", "2", "5", "1", "0")));
        player1ExpectedValueInfo.internationalCopmetitionsOverall = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2020", "Ivory Coast", "2", "0", "2", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2018", "Ivory Coast", "2", "0", "2", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("CAF", "Afr. Cup QF", "2017-2019", "Ivory Coast", "5", "2", "5", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("CAF", "Africa Cup", "2017 Gabun", "Ivory Coast", "3", "0", "3", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2017", "Ivory Coast", "4", "0", "3", "1", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2016", "Ivory Coast", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("CAF", "Afr. Cup QF", "2015/2016", "Ivory Coast", "4", "0", "4", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "WCQ Africa", "2015-2017", "Ivory Coast", "4", "0", "4", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("CAF", "Africa Cup", "2015 Equatorial Guinea", "Ivory Coast", "6", "0", "6", "0", "1", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2015", "Ivory Coast", "5", "0", "5", "0", "1", "0", "0", "0")));
        player1ExpectedValueInfo.internationalCopmetitionsInfo = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("WC Qualifiers Africa", "FIFA", "4", "0", "4", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformation("Friendlies", "FIFA", "14", "0", "13", "1", "2", "1", "0", "0"),
        		new PlayerCompetitionInformation("Africa Cup", "CAF", "9", "0", "9", "0", "1", "3", "0", "0"),
        		new PlayerCompetitionInformation("Africa Cup Qual.", "CAF", "9", "2", "9", "0", "2", "1", "0", "0"),
        		new PlayerCompetitionInformation("∑", null, "36", "2", "35", "1", "5", "7", "0", "0")));       
        
        player1ExpectedValueInfo.recordOpponent = new ArrayList<>(Arrays.asList(
        		new PlayerOpponentRecordInformation("Chelsea FC","7","3","1","3","0","1","0","0"),
        		new PlayerOpponentRecordInformation("Liverpool FC","4","2","1","1","0","1","0","0"),
        		new PlayerOpponentRecordInformation("Real Madrid","3","1","1","1","0","2","0","0"),
        		new PlayerOpponentRecordInformation("SD Eibar","3","2","1","0","0","0","0","0"),
        		new PlayerOpponentRecordInformation("Middlesbrough FC","2","2","0","0","0","0","0","0"),
        		new PlayerOpponentRecordInformation("Belgium","1","0","1","0","0","0","0","0"),
        		new PlayerOpponentRecordInformation("Japan","1","0","0","1","0","0","0","0"),
        		new PlayerOpponentRecordInformation("Sporting Gijón","1","0","0","1","0","0","0","0"),
        		new PlayerOpponentRecordInformation("Wolverhampton Wanderers","1","1","0","0","0","0","0","0")));
        
        player1ExpectedValueInfo.recordReferee = new ArrayList<>(Arrays.asList(
        		new PlayerRefereeRecordInformation("Jonathan Moss","England","10","7","2","1","1","1","0","0"),
        		new PlayerRefereeRecordInformation("Carlos Velasco Carballo","Spain","3","1","0","2","0","2","0","0"),
        		new PlayerRefereeRecordInformation("Alex Muhabi",           "Uganda","1","1","0","0","1","0","0","0"),
        		new PlayerRefereeRecordInformation("Jorge Díaz Escudero","Spain","1","1","0","0","0","0","0","0"),
        		new PlayerRefereeRecordInformation("Pavel Královec","Czech Republic","1","1","0","0","0","0","0","0"),
        		new PlayerRefereeRecordInformation("José Teixeira Vitienes","Spain","1","0","1","0","0","1","0","0"),
        		new PlayerRefereeRecordInformation("Slavko Vinčić","Slovenia","1","0","1","0","0","0","0","0")));
        player1ExpectedValueInfo.teamsManaged = null;
        
        player1ExpectedValueInfo.forEachCompetitionInformationOverallsClubs  = new ArrayList<PlayerCompetitionInformationOverall>(Arrays.asList(
				new PlayerCompetitionInformationOverall("UEFA","EL","2019/2020","Manchester United","4","0","4","0","1","1","0","0"),
				new PlayerCompetitionInformationOverall("UEFA","EL","2016/2017","Manchester United","11","0","11","0","0","2","1","1")

		));
        List<WorldFootBallAttributeFor_TEST> player1AttributeList = new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("personalInfo"),
        		new WorldFootBallAttributeFor_TEST("teamsManaged") ,
        		new WorldFootBallAttributeFor_TEST("clubsCareer"),
        		new WorldFootBallAttributeFor_TEST("clubMatches"),
        		new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo"),
        		new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
        		new WorldFootBallAttributeFor_TEST("internationalCopmetitionsOverall"),
				new WorldFootBallAttributeFor_TEST("recordOpponent", new ArrayList<>(Arrays.asList(0,6,19,20,40,60,80,100,109))),
				new WorldFootBallAttributeFor_TEST("recordReferee", new ArrayList<>(Arrays.asList(0,20,40,60,80,100,106))),
				new WorldFootBallAttributeFor_TEST("forEachCompetitionInformationOverallsClubs", new ArrayList<>(Arrays.asList(2,3)))));

       /* assertThat(player1ActualValueInfo.forEachCompetitionInformationOverallsClubs).contains(
				new PlayerCompetitionInformationOverall("UEFA","EL","2019/2020","Manchester United","4","0","4","0","1","1","0","0"),
				atIndex(2));*/
        
        
        assertPlayerInformationWithIndexes(player1ActualValueInfo,player1AttributeList,player1ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/tony-adams/
        PlayerAllInformation player2ActualValueInfo  = screenScraperTest.getAllInformationAboutPlayer("tony-adams");
        PlayerAllInformation player2ExpectedValueInfo = new PlayerAllInformation();

        player2ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Tony Adams", "Anthony Alexander Adams",
                "10.10.1966", "Romford, England",new  ArrayList<String>(Arrays.asList( "England")), "191 cm", "87 kg", 
                new  ArrayList<String>(Arrays.asList("Centre Back")), "right");
        player2ExpectedValueInfo.teamsManaged = new ArrayList<>(Arrays.asList(
        		new PlayerTeamManaged("04/2017 - 06/2017", "Granada CF", "Spain", "Manager"),
        		new PlayerTeamManaged("07/2010 - 06/2012", "Gabala FK", "Azerbaijan", "Manager"),
        		new PlayerTeamManaged("10/2008 - 02/2009", "Portsmouth FC", "England", "Manager")));
        player2ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("07/1983 - 06/2002", "Arsenal FC", "England", "Defender", null),
        		new PlayerClubCareer("07/1982 - 06/1983", "Arsenal FC [U18]", "England", "Defender", null)));
        player2ExpectedValueInfo.clubMatches = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("Champions League", "UEFA", "21", "1", "21", "0", "1", "3", "0", "0"),
        		new PlayerCompetitionInformation("Europa League", "UEFA", "9", "0", "9", "0", "2", "2", "0", "0"),
        		new PlayerCompetitionInformation("UEFA Super Cup", "UEFA", "2", "0", "2", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformation("Cup Winners Cup", "UEFA", "16", "2", "16", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformation("Premier League", "England", "504", "32", "500", "4", "19", "37", "1", "4"),
        		new PlayerCompetitionInformation("FA Cup", "England", "33", "7", "32", "1", "0", "2", "0", "0"),
        		new PlayerCompetitionInformation("League Cup", "England", "17", "3", "17", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformation("FA Community Shield", "England", "4", "0", "4", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformation("∑", null, "606", "45", "601", "5", "23", "47", "1", "4")));
        player2ExpectedValueInfo.internationalCopmetitionsInfo = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("World Cup", "FIFA", "4", "0", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformation("WC Qualifiers Europe", "FIFA", "14", "0", "14", "0", "2", "2", "0", "0"),
        		new PlayerCompetitionInformation("Friendlies", "FIFA", "29", "3", "29", "0", "4", "0", "0", "0"),
        		new PlayerCompetitionInformation("EURO", "UEFA", "9", "1", "9", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformation("EURO Qualifiers", "UEFA", "10", "1", "10", "0", "2", "1", "0", "0"),
        		new PlayerCompetitionInformation("∑", null, "66", "5", "66", "0", "9", "4", "0", "0"),
        		new PlayerCompetitionInformation("EURO [U21]", "UEFA", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformation("∑ U21", null, "1", "0", "1", "0", "0", "0", "0", "0")));
        player2ExpectedValueInfo.clubsMatchesOverall = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "2001/2002", "Arsenal FC", "3", "1", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2001/2002", "Arsenal FC", "10", "0", "10", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2000/2001", "Arsenal FC", "26", "1", "26", "0", "0", "7", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "2000/2001", "Arsenal FC", "4", "1", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "2000/2001", "Arsenal FC", "8", "0", "8", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "1999/2000", "Arsenal FC", "6", "0", "6", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1999/2000", "Arsenal FC", "21", "0", "21", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1999/2000", "Arsenal FC", "1", "1", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "1999/2000", "Arsenal FC", "5", "0", "5", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1998/1999", "Arsenal FC", "26", "1", "26", "0", "0", "4", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1998/1999", "Arsenal FC", "5", "0", "5", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "1998/1999", "Arsenal FC", "4", "1", "4", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Com. Shield", "1998", "Arsenal FC", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1997/1998", "Arsenal FC", "6", "0", "6", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1997/1998", "Arsenal FC", "26", "3", "26", "0", "0", "6", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1997/1998", "Arsenal FC", "2", "0", "2", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "1997/1998", "Arsenal FC", "2", "0", "2", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1996/1997", "Arsenal FC", "28", "3", "27", "1", "2", "5", "1", "1"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1996/1997", "Arsenal FC", "3", "0", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1996/1997", "Arsenal FC", "3", "0", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "1996/1997", "Arsenal FC", "1", "0", "1", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1995/1996", "Arsenal FC", "2", "0", "2", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1995/1996", "Arsenal FC", "21", "1", "21", "0", "0", "2", "0", "1"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1995/1996", "Arsenal FC", "5", "2", "5", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1994/1995", "Arsenal FC", "27", "3", "27", "0", "3", "4", "0", "1"),
        		new PlayerCompetitionInformationOverall("UEFA", "CWC", "1994/1995", "Arsenal FC", "8", "0", "8", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1994/1995", "Arsenal FC", "1", "0", "0", "1", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1994/1995", "Arsenal FC", "4", "1", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "UEFA Sup.Cup", "1994", "Arsenal FC", "2", "0", "2", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1993/1994", "Arsenal FC", "35", "0", "35", "0", "3", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "CWC", "1993/1994", "Arsenal FC", "8", "2", "8", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1993/1994", "Arsenal FC", "3", "2", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1993/1994", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Com. Shield", "1993", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1992/1993", "Arsenal FC", "4", "2", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1992/1993", "Arsenal FC", "35", "0", "33", "2", "2", "4", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1992/1993", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1991/1992", "Arsenal FC", "35", "2", "35", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "1991/1992", "Arsenal FC", "4", "0", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Com. Shield", "1991", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1990/1991", "Arsenal FC", "30", "1", "30", "0", "2", "1", "0", "1"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1990/1991", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1989/1990", "Arsenal FC", "38", "5", "38", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Com. Shield", "1989", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1988/1989", "Arsenal FC", "36", "4", "36", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1987/1988", "Arsenal FC", "39", "2", "39", "0", "3", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1986/1987", "Arsenal FC", "42", "6", "42", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1986/1987", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1985/1986", "Arsenal FC", "10", "0", "10", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1984/1985", "Arsenal FC", "16", "0", "15", "1", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1983/1984", "Arsenal FC", "3", "0", "3", "0", "1", "0", "0", "0")));
        player2ExpectedValueInfo.internationalCopmetitionsOverall = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformationOverall("FIFA", "WCQ Europe", "2000/2001", "England", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO", "2000 Holland/Belgium", "England", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2000", "England", "2", "1", "2", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1999", "England", "2", "0", "2", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO Qualif.", "1998/1999", "England", "5", "0", "5", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "World Cup", "1998 France", "England", "4", "0", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1998", "England", "3", "0", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "WCQ Europe", "1996/1997", "England", "3", "0", "3", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO", "1996 England", "England", "5", "0", "5", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1996", "England", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1995", "England", "6", "0", "6", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1994", "England", "5", "0", "5", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "WCQ Europe", "1992/1993", "England", "9", "0", "9", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO Qualif.", "1990/1991", "England", "2", "0", "2", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "WCQ Europe", "1988/1989", "England", "1", "0", "1", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO", "1988 Germany", "England", "3", "1", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1988", "England", "7", "2", "7", "0", "2", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1987", "England", "3", "0", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO Qualif.", "1986/1987", "England", "3", "1", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO [U21]", "1986", "England", "1", "0", "1", "0", "0", "0", "0", "0")));
        player2ExpectedValueInfo.recordOpponent = new ArrayList<>(Arrays.asList(
        		new PlayerOpponentRecordInformation("Manchester United","31","11","9","11","2","4","0","0"),
        		new PlayerOpponentRecordInformation("Luton Town","13","7","4","2","1","0","0","1"),
        		new PlayerOpponentRecordInformation("Germany","3","0","0","3","0","0","0","0"),
        		new PlayerOpponentRecordInformation("France", "2","0","1","1","0","0","0","0"),
        		new PlayerOpponentRecordInformation("Ukraine","1","1","0","0","1","0","0","0"),
        		new PlayerOpponentRecordInformation("Parma Calcio 1913","1","1","0","0","0","0","0","0"),
        		new PlayerOpponentRecordInformation("USA","1","1","0","0","0","0","0","0")));
        
        player2ExpectedValueInfo.recordReferee = new ArrayList<>(Arrays.asList(
        		new PlayerRefereeRecordInformation("Paul Durkin","England","20","14","3","3","0","2","0","1"),
        		new PlayerRefereeRecordInformation("Albert Thomas","Netherlands","1","1","0","0","0","0","0","0"),
        		new PlayerRefereeRecordInformation("Vadim Zhuk","Belarus","1","1","0","0","0","0","0","0")));
        
        List<WorldFootBallAttributeFor_TEST> player2AttributeList = new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("personalInfo"),
        		new WorldFootBallAttributeFor_TEST("teamsManaged") ,
        		new WorldFootBallAttributeFor_TEST("clubsCareer"),
        		new WorldFootBallAttributeFor_TEST("clubMatches"),
        		new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo"),
        		new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
        		new WorldFootBallAttributeFor_TEST("internationalCopmetitionsOverall"),
				new WorldFootBallAttributeFor_TEST("recordOpponent", new ArrayList<>(Arrays.asList(0,20,40,60,80,100,106))),
				new WorldFootBallAttributeFor_TEST("recordReferee", new ArrayList<>(Arrays.asList(0,140,148)))));

        assertPlayerInformationWithIndexes(player2ActualValueInfo,player2AttributeList,player2ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/walter-aitkenhead/
        PlayerAllInformation player3ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("walter-aitkenhead");
        PlayerAllInformation player3ExpectedValueInfo = new PlayerAllInformation();
        player3ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Walter Aitkenhead", "Walter Campbell Allison Aitkenhead",
                "21.05.1887 † 19.07.1966", "Glasgow, Scotland", new  ArrayList<String>(Arrays.asList("Scotland")), null, null, null, null);
        player3ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("01/1906 - 12/1918", "Blackburn Rovers", "England", "Forward", null),
        		new PlayerClubCareer("01/1905 - 12/1905", "Partick Thistle", "Scotland", "Forward", null)));
        player3ExpectedValueInfo.internationalCopmetitionsInfo = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("Friendlies", "FIFA", "1", "2", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformation("∑", null, "1", "2", "1", "0", "0", "0", "0", "0")));
        player3ExpectedValueInfo.internationalCopmetitionsOverall = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1912", "Scotland", "1", "2", "1", "0", "0", "0", "0", "0")));
        player3ExpectedValueInfo.recordOpponent = new ArrayList<>(Arrays.asList(
        		new PlayerOpponentRecordInformation("All Ireland","1","1","0","0","2","0","0","0")));
        player3ExpectedValueInfo.recordReferee = new ArrayList<>(Arrays.asList(
        		new PlayerRefereeRecordInformation("Herbert Bamlett","England","1","1","0","0","2","0","0","0")));
        List<WorldFootBallAttributeFor_TEST> player3AttributeList = new ArrayList<>( Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("personalInfo"),
        		new WorldFootBallAttributeFor_TEST("teamsManaged" ),
        		new WorldFootBallAttributeFor_TEST("clubsCareer"),
        		new WorldFootBallAttributeFor_TEST("clubMatches"),
        		new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo"),
        		new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
        		new WorldFootBallAttributeFor_TEST("internationalCopmetitionsOverall"),
        		new WorldFootBallAttributeFor_TEST("recordOpponent"),
        		new WorldFootBallAttributeFor_TEST("recordReferee")));
        player3ExpectedValueInfo.teamsManaged = null;
        player3ExpectedValueInfo.clubMatches = null;
        player3ExpectedValueInfo.clubsMatchesOverall = null;
        assertPlayerInformationWithIndexes(player3ActualValueInfo,player3AttributeList,player3ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/sam-johnstone/
        PlayerAllInformation player4ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("sam-johnstone");
        PlayerAllInformation player4ExpectedValueInfo = new PlayerAllInformation();
        player4ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("07/2018 - 07/2018", "Manchester United U23", "England", "Goalkeeper", null),
         		new PlayerClubCareer("01/2016 - 01/2016", "Preston North End", "England", "Goalkeeper", null)));

        player4ExpectedValueInfo.clubMatches = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("Premier League","England","17","0","17","0","0","0","0","0"),
        		new PlayerCompetitionInformation("League One","England","51","0","51","0","0","4","0","0"),
        		new PlayerCompetitionInformation("∑",null,"273","0","273","0","0","14","0","0")));
        
        List<WorldFootBallAttributeFor_TEST> player4AttributesToTest = new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("clubsCareer",  new ArrayList<Integer> (Arrays.asList(1,5))),
				new WorldFootBallAttributeFor_TEST("clubMatches",  new ArrayList<Integer> (Arrays.asList(0,3,6)))
				));      
        
        assertPlayerInformationWithIndexes(player4ActualValueInfo,player4AttributesToTest,player4ExpectedValueInfo);

      //https://www.worldfootball.net/player_summary/george-timmins/
        PlayerAllInformation player5ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("george-timmins");
        PlayerAllInformation player5ExpectedValueInfo = new PlayerAllInformation();
        player5ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("George Timmins",null,"1858 †","West Bromwich, England",new  ArrayList<String>(Arrays.asList("England")),null,null,null,null);
        player5ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("07/1880 - 06/1891","West Bromwich Albion","England","Midfielder", null)));
        List<WorldFootBallAttributeFor_TEST> player5AttributeList = new ArrayList<>( Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("personalInfo"),
        		new WorldFootBallAttributeFor_TEST("clubsCareer"),
        		new WorldFootBallAttributeFor_TEST("clubMatches"),
        		new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
        		new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo")));
        player5ExpectedValueInfo.clubMatches = null;
        player5ExpectedValueInfo.clubsMatchesOverall=null;
        player5ExpectedValueInfo.internationalCopmetitionsInfo =null;
        assertPlayerInformationWithIndexes(player5ActualValueInfo,player5AttributeList,player5ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/che-adams/
        PlayerAllInformation player6ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("che-adams");
        PlayerAllInformation player6ExpectedValueInfo = new PlayerAllInformation();
        player6ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Che Adams","Che Zach Everton Fred Adams","13.07.1996",
        		"Leicester, England",new  ArrayList<String>(Arrays.asList("England","Antigua & Barbuda")),"179 cm","70 kg",new  ArrayList<String>(Arrays.asList("Centre Forward","Left Winger")),"right");
        List<WorldFootBallAttributeFor_TEST> player6AttributeList = new ArrayList<>( Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("personalInfo"),
        		new WorldFootBallAttributeFor_TEST("teamManaged")
        		));
        player6ExpectedValueInfo.teamsManaged = null;
        assertPlayerInformationWithIndexes(player6ActualValueInfo,player6AttributeList,player6ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/adam-carson/
        PlayerAllInformation player7ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("adam-carson");
        PlayerAllInformation player7ExpectedValueInfo = new PlayerAllInformation();
        player7ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Adam Carson",null,"†",
        		"Scotland",new  ArrayList<String>(Arrays.asList("Scotland")),null,null,null,null);
        List<WorldFootBallAttributeFor_TEST> player7AttributeList = new ArrayList<>( Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("personalInfo"),
        		new WorldFootBallAttributeFor_TEST("teamManaged")
        		));
        player7ExpectedValueInfo.teamsManaged = null;
        assertPlayerInformationWithIndexes(player7ActualValueInfo,player7AttributeList,player7ExpectedValueInfo);
   
    }
    public void assertMatches(MatchDetails actualValue , List<WorldFootBallAttributeFor_TEST> attributes , MatchDetails expectedValue) {
    	int limit;
    	for(int i =0 ; i < attributes.size() ; i++) {
    		if(attributes.get(i).attributeName.equals("staduim")) {
    			assertThat(actualValue.staduim).isEqualTo( expectedValue.staduim);
    		}
    		else if(attributes.get(i).attributeName.equals("attendance")) {
    			assertThat(actualValue.attendance).isEqualTo( expectedValue.attendance);
    		}
    		else if(attributes.get(i).attributeName.equals("matchSummary")) {
    			assertThat(actualValue.matchSummary).usingRecursiveComparison().isEqualTo(expectedValue.matchSummary);
    		}
    		else if(attributes.get(i).attributeName.equals("goals")) {
    			if(expectedValue.goals == null) {
    		        Assert.assertEquals(null, actualValue.goals);
    			}
    			else{    		
	    			limit = (attributes.get(i).indexes.isEmpty())? actualValue.goals.size() : attributes.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributes.get(i).indexes.isEmpty())? j :attributes.get(i).indexes.get(j);
	    				assertThat(actualValue.goals.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.goals.get(j)); 
	    				j++;
	    			}
    			}
    		}
    		else if(attributes.get(i).attributeName.equals("firstClub")) {
    			Assert.assertEquals(expectedValue.firstClub.manager, actualValue.firstClub.manager);
 		        Assert.assertEquals(expectedValue.firstClub.clubBasicInfo.name, actualValue.firstClub.clubBasicInfo.name);
 		        limit = (attributes.get(i).indexes.isEmpty())? actualValue.firstClub.players.size() : attributes.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributes.get(i).indexes.isEmpty())? j :attributes.get(i).indexes.get(j);
	    				assertThat(actualValue.firstClub.players.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.firstClub.players.get(j)); 
	    				//Assertions.assertThat(actualValue.firstClub.players).contains(expectedValue.firstClub.players.get(j),atIndex(index)) ;
	    				j++;
	    			}
    		}
    		else if(attributes.get(i).attributeName.equals("secondClub")) {
    		        Assert.assertEquals(expectedValue.secondClub.manager, actualValue.secondClub.manager);
    		        Assert.assertEquals(expectedValue.secondClub.clubBasicInfo.name, actualValue.secondClub.clubBasicInfo.name);
    		        limit = (attributes.get(i).indexes.isEmpty())? actualValue.secondClub.players.size() : attributes.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributes.get(i).indexes.isEmpty())? j :attributes.get(i).indexes.get(j);
	    				assertThat(actualValue.secondClub.players.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.secondClub.players.get(j)); 
	    				j++;
	    			}
    			
    		}
    		else if(attributes.get(i).attributeName.equals("referees")) {
    			if(expectedValue.referees == null) {
    		        Assert.assertEquals(null, actualValue.referees);
    			}
    			else{    		
	    			limit = (attributes.get(i).indexes.isEmpty())? actualValue.referees.size() : attributes.get(i).indexes.size(); 
	    			int j =0;
	    			while(j<limit) {
	    				int index = (attributes.get(i).indexes.isEmpty())? j :attributes.get(i).indexes.get(j);
	    				assertThat(actualValue.referees.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.referees.get(j)); 
	    				j++;
	    			}
    			}
    			
    		}
    		
    	}
    }

    @Test
    public void itShouldMatchDetails() {
//ShouldContainAtIndex.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        //https://www.worldfootball.net/report/premier-league-2019-2020-brighton-hove-albion-everton-fc/
        MatchDetails match1ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2019-2020", "brighton-hove-albion", "everton-fc");
        MatchDetails match1ExpectedValue = new MatchDetails();

        match1ExpectedValue.staduim ="Amex Stadium (Brighton / England)";
        match1ExpectedValue.attendance ="30.529";
        match1ExpectedValue.goals = new ArrayList<>(Arrays.asList(
        		new GoalInMatchDetails("Brighton & Hove Albion", new Goal("1 : 0", "15", "Pascal Groß", "free kick")),
        		new GoalInMatchDetails("Everton FC", new Goal("1 : 1", "20", "Adam Webster", "own goal")),
        		new GoalInMatchDetails("Everton FC", new Goal("1 : 2", "74", "Dominic Calvert-Lewin", "left-footed shot", "Mason Holgate")),
        		new GoalInMatchDetails("Brighton & Hove Albion", new Goal("2 : 2", "80", "Neal Maupay", "penalty")),
        		new GoalInMatchDetails("Brighton & Hove Albion", new Goal("3 : 2", "90", "Lucas Digne", "own goal"))));

        match1ExpectedValue.referees = new ArrayList<>(Arrays.asList(
        		new Referee("Andy Madley", "England", KindOfReferee.Referee),
        		new Referee("Edward Smart", "England", KindOfReferee.AssistantReferee),
        		new Referee("Derek Eaton", "England", KindOfReferee.AssistantReferee)));
        
        match1ExpectedValue.matchSummary = new MatchSummary("Brighton & Hove Albion", "Everton FC", "3:2", "Saturday, 26. October 2019", "15:00 Clock");
        
        match1ExpectedValue.firstClub = new ClubInMatchDetails(
        		"Brighton & Hove Albion", 
        		"Graham Potter",
        		new ArrayList<PlayerAtMatch>(Arrays.asList(
        				new PlayerAtMatch("1", "Mathew Ryan", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch("5", "Lewis Dunk", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch("15", "Adam Webster", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch("22", "Martín Montoya", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("66", "out")))),
        				new PlayerAtMatch("33", "Dan Burn", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch("6", "Dale Stephens", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("33", "Yellow card")))),
        				new PlayerAtMatch("13", "Pascal Groß", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("65", "out")))),
        				new PlayerAtMatch("24", "Davy Pröpper", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("90", "Yellow card")))),
        				new PlayerAtMatch("46", "Steven Alzate", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch("7", "Neal Maupay", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch("44", "Aaron Connolly", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("80", "out")))),
        				new PlayerAtMatch("21", "Ezequiel Schelotto", PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("66", "in")))),
           				new PlayerAtMatch("11", "Leandro Trossard", PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("65", "in")))),
        				new PlayerAtMatch("17", "Glenn Murray", PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("80", "in")))),
        				new PlayerAtMatch("27", "David Button", PlayerTypeAtMatch.Substitute, null),
        				new PlayerAtMatch("14", "Leon Balogun", PlayerTypeAtMatch.Substitute, null),
        				new PlayerAtMatch("8", "Yves Bissouma", PlayerTypeAtMatch.Substitute, null),
        				new PlayerAtMatch("20", "Solly March", PlayerTypeAtMatch.Substitute, null))));

        match1ExpectedValue.secondClub = new ClubInMatchDetails(
        									"Everton FC",
        									"Marco Silva",
        									new ArrayList<PlayerAtMatch>(Arrays.asList(
        											new PlayerAtMatch("1", "Jordan Pickford", PlayerTypeAtMatch.Essential, null),
        											new PlayerAtMatch("2", "Mason Holgate", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("86", "Yellow card")))),
        											new PlayerAtMatch("5", "Michael Keane", PlayerTypeAtMatch.Essential, null),
        											new PlayerAtMatch("12", "Lucas Digne", PlayerTypeAtMatch.Essential, null),
        											new PlayerAtMatch("19", "Djibril Sidibé", PlayerTypeAtMatch.Essential, null),
        											new PlayerAtMatch("21", "André Gomes", PlayerTypeAtMatch.Essential, null),
        											new PlayerAtMatch("26", "Tom Davies", PlayerTypeAtMatch.Essential, null),
        											new PlayerAtMatch("7", "Richarlison", PlayerTypeAtMatch.Essential, null),
        											new PlayerAtMatch("11", "Theo Walcott", PlayerTypeAtMatch.Essential,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "out")))),
        											new PlayerAtMatch("17", "Alex Iwobi", PlayerTypeAtMatch.Essential,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "out")))),
        											new PlayerAtMatch("20", "Bernard", PlayerTypeAtMatch.Essential,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("30", "out")))),
        											new PlayerAtMatch("8", "Fabian Delph", PlayerTypeAtMatch.Substitute,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "in")))),
        											new PlayerAtMatch("10", "Gylfi Sigurðsson", PlayerTypeAtMatch.Substitute,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("30", "in")))),
        											new PlayerAtMatch("9", "Dominic Calvert-Lewin", PlayerTypeAtMatch.Substitute,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "in")))),
        											new PlayerAtMatch("49", "Jonas Lössl", PlayerTypeAtMatch.Substitute, null),
        											new PlayerAtMatch("23", "Séamus Coleman", PlayerTypeAtMatch.Substitute, null),
        											new PlayerAtMatch("18", "Morgan Schneiderlin", PlayerTypeAtMatch.Substitute, null),
        											new PlayerAtMatch("27", "Moise Kean", PlayerTypeAtMatch.Substitute, null))));

        List <WorldFootBallAttributeFor_TEST> match1Attributes = new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("firstClub"),
        		new WorldFootBallAttributeFor_TEST("secondClub"),
        		new WorldFootBallAttributeFor_TEST("staduim"),
        		new WorldFootBallAttributeFor_TEST("attendance"),
        		new WorldFootBallAttributeFor_TEST("goals"),
        		new WorldFootBallAttributeFor_TEST("referees"),
        		new WorldFootBallAttributeFor_TEST("matchSummary")
        		));

        ComparePlayerNames playerComparator = new ComparePlayerNames();
        Collections.sort(match1ActualValue.firstClub.players, playerComparator);
        Collections.sort(match1ActualValue.secondClub.players, playerComparator);
        Collections.sort(match1ExpectedValue.firstClub.players, playerComparator);
        Collections.sort(match1ExpectedValue.secondClub.players, playerComparator);
        assertMatches(match1ActualValue, match1Attributes, match1ExpectedValue);
        
        //https://www.worldfootball.net/report/premier-league-1946-1947-brentford-fc-middlesbrough-fc/
        MatchDetails match2ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "1946-1947", "brentford-fc", "middlesbrough-fc");
        MatchDetails match2ExpectedValue = new MatchDetails();
        match2ExpectedValue.staduim ="Griffin Park (London / England)";
        match2ExpectedValue.attendance = "19.020";
        match2ExpectedValue.referees = null;
        match2ExpectedValue.goals = null;
        match2ExpectedValue.matchSummary = new MatchSummary("Brentford FC","Middlesbrough FC", "0:0", "Saturday, 26. April 1947", null);

        match2ExpectedValue.firstClub = new ClubInMatchDetails(
        		"Brentford FC", 
        		"Jimmy Hogan",
				new ArrayList<PlayerAtMatch>(Arrays.asList(
						new PlayerAtMatch(null, "Joe Crozier", PlayerTypeAtMatch.Essential, null),
						new PlayerAtMatch(null, "Harry Oliver", PlayerTypeAtMatch.Essential, null),
						new PlayerAtMatch(null, "Roddie Munro", PlayerTypeAtMatch.Essential, null),
						new PlayerAtMatch(null, "George Smith", PlayerTypeAtMatch.Essential, null),
						new PlayerAtMatch(null, "Cyril Toulouse", PlayerTypeAtMatch.Essential, null),
						new PlayerAtMatch(null, "Dai Hopkins", PlayerTypeAtMatch.Essential, null),
						new PlayerAtMatch(null, "George Paterson", PlayerTypeAtMatch.Essential, null),
						new PlayerAtMatch(null, "Len Townsend", PlayerTypeAtMatch.Essential, null),
						new PlayerAtMatch(null, "George Stewart", PlayerTypeAtMatch.Essential, null),
						new PlayerAtMatch(null, "Dickie Girling", PlayerTypeAtMatch.Essential, null),
						new PlayerAtMatch(null, "Malky MacDonald", PlayerTypeAtMatch.Essential, null))));

        match2ExpectedValue.secondClub = new ClubInMatchDetails(
        		"Middlesbrough FC", 
        		"David Jack",
        		new ArrayList<PlayerAtMatch>(Arrays.asList(
        				new PlayerAtMatch(null, "Paddy Nash", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch(null, "Bobby Stuart", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch(null, "Dicky Robinson", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch(null, "George Hardwick", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch(null, "Harry Bell", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch(null, "Geoff Walker", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch(null, "Johnny Spuhler", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch(null, "Jimmy Gordon", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch(null, "Alec Linwood", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch(null, "Micky Fenton", PlayerTypeAtMatch.Essential, null),
        				new PlayerAtMatch(null, "Wilf Mannion", PlayerTypeAtMatch.Essential, null))));

        Collections.sort(match2ActualValue.firstClub.players, playerComparator);
        Collections.sort(match2ActualValue.secondClub.players, playerComparator);
        Collections.sort(match2ExpectedValue.firstClub.players, playerComparator);
        Collections.sort(match2ExpectedValue.secondClub.players, playerComparator);
        List <WorldFootBallAttributeFor_TEST> match2Attributes = new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("firstClub"),
        		new WorldFootBallAttributeFor_TEST("secondClub"),
        		new WorldFootBallAttributeFor_TEST("staduim"),
        		new WorldFootBallAttributeFor_TEST("attendance"),
        		new WorldFootBallAttributeFor_TEST("goals"),
        		new WorldFootBallAttributeFor_TEST("referees"),
        		new WorldFootBallAttributeFor_TEST("matchSummary")
        		));
        assertMatches(match2ActualValue, match2Attributes, match2ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-2020-2021-leeds-united-burnley-fc/
        MatchDetails match3ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "Leeds-United", "Burnley-FC");
        MatchDetails match3ExpectedValue =new  MatchDetails();
        match3ExpectedValue.goals= new ArrayList<>(Arrays.asList(
        		new GoalInMatchDetails("Leeds United", new Goal("1 : 0", "5", "Patrick Bamford", "penalty"))));
        List <WorldFootBallAttributeFor_TEST> match3Attributes = new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("goals")	));
        assertMatches(match3ActualValue, match3Attributes, match3ExpectedValue);
        
        //https://www.worldfootball.net/report/premier-league-2020-2021-sheffield-united-everton-fc/
        MatchDetails match4ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "sheffield-united", "everton-fc");
        MatchDetails match4ExpectedValue =new  MatchDetails();
        match4ExpectedValue.goals= new ArrayList<>(Arrays.asList(
        		new GoalInMatchDetails("Everton FC", new Goal("0 : 1", "80", "Gylfi Sigurðsson", "right-footed shot", "Abdoulaye Doucouré"))));
        List <WorldFootBallAttributeFor_TEST> match4Attributes = new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("goals")	));
        assertMatches(match4ActualValue, match4Attributes, match4ExpectedValue);

    }
    public void assertClubTransfer(ClubTransferTable actualValue ,List<WorldFootBallAttributeFor_TEST> tables, ClubTransferTable expectedValue) {
		assertThat(actualValue.clubBasicInfo).usingRecursiveComparison().isEqualTo(expectedValue.clubBasicInfo); 
		assertThat(actualValue.season).isEqualTo(expectedValue.season); 
    	for(int i =0 ; i <tables.size() ; i++) {
    		int limit;
    		if(tables.get(i).attributeName.equals("in")) {
    			limit = (tables.get(i).indexes.isEmpty())?Math.max(actualValue.intable.size(), expectedValue.intable.size()) :tables.get(i).indexes.size();
    			int j =0;
    			while(j < limit) {
    				int index = (tables.get(i).indexes.isEmpty())? index =j : tables.get(i).indexes.get(j);
    				assertThat(actualValue.intable.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.intable.get(j)); 
    				j++;
    			}    			
    		}
    		else {
    			limit = (tables.get(i).indexes.isEmpty())?Math.max(actualValue.outtable.size(), expectedValue.outtable.size()) :tables.get(i).indexes.size();
    			int j =0;
    			while(j < limit) {
    				int index = (tables.get(i).indexes.isEmpty())? index =j : tables.get(i).indexes.get(j);
    				assertThat(actualValue.outtable.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.outtable.get(j)); 
    				j++;
    			}
    		}
    	}
    }

    @Test
    public void itShouldGetTransferTable() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<ClubTransferTable> transferTableActualValue2015_2016  = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier-league", "2015-2016");
        ClubTransferTable astonVillaTransferTable2015_2016ActualValue  = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTableActualValue2015_2016, "Aston Villa");
        //Aston Villa 2015-2016
        ClubTransferTable AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue = new ClubTransferTable();
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.clubBasicInfo.name = "Aston Villa";
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.season = "2015-2016";
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable = new ArrayList<>(Arrays.asList(
        		new TransferPlayerInformation("05/16", "Lewis Kinsella", "England", "DF", "Kidderminster Harriers", "Aston Villa"),
        		new TransferPlayerInformation("01/16", "Joe Cole", "England", "MF", "Coventry City", "Aston Villa"),
        		new TransferPlayerInformation("01/16", "Aly Cissokho", "France", "DF", "FC Porto", "Aston Villa"),
        		new TransferPlayerInformation("01/16", "Callum Robinson", "Ireland", "MF", "Bristol City", "Aston Villa"),
        		new TransferPlayerInformation("11/15", "Bradley Watkins", "England", "GK", "Wolverhampton Wanderers U21", "Aston Villa")));
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable = new ArrayList<>(Arrays.asList(
        		new TransferPlayerInformation("03/16", "Jerell Sellars", "England", "MF", "Aston Villa", "Wycombe Wanderers"),
        		new TransferPlayerInformation("02/16", "Lewis Kinsella", "England", "DF", "Aston Villa", "Kidderminster Harriers"),
        		new TransferPlayerInformation("01/16", "Philippe Senderos", "Switzerland", "DF", "Aston Villa", "Grasshopper Club Zürich"),
        		new TransferPlayerInformation("01/16", "Ángel Crespo", "Spain", "DF", "Aston Villa", "Rayo Vallecano"),
        		new TransferPlayerInformation("01/16", "Gary Gardner", "England", "MF", "Aston Villa", "Nottingham Forest")));
        List<WorldFootBallAttributeFor_TEST> astonVilla2015_2016AtrribuTests =new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("in",new ArrayList<Integer>(Arrays.asList(0,1,2,3,4))),
        		new WorldFootBallAttributeFor_TEST("out",new ArrayList<Integer>(Arrays.asList(0,1,2,3,4)))));
        assertClubTransfer(astonVillaTransferTable2015_2016ActualValue,astonVilla2015_2016AtrribuTests,AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue);

        ArrayList<ClubTransferTable> transferTable1889_1890ActualValue  = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier-league", "1889-1890");
        ClubTransferTable astonVillaTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Aston Villa");
        ClubTransferTable astonVillatransferTable1889_1890ExpectedValue = new ClubTransferTable();
        astonVillatransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Aston Villa";
        astonVillatransferTable1889_1890ExpectedValue.season = "1889-1890";
        astonVillatransferTable1889_1890ExpectedValue.intable = new ArrayList<>(Arrays.asList(
        		new TransferPlayerInformation("07/89", "Albert Aldridge", "England", "DF", "Swifts FC", "Aston Villa"),
            	new TransferPlayerInformation("07/89", "William Dickson", "Scotland", "FW", "Sunderland AFC", "Aston Villa")));
        astonVillatransferTable1889_1890ExpectedValue.outtable = new ArrayList<>(Arrays.asList(
        		new TransferPlayerInformation("06/89", "Archie Goodall", "Northern Ireland", "MF", "Aston Villa", "Derby County")));
       
        List<WorldFootBallAttributeFor_TEST> astonVilla1889_1890AtrribuTests =new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("in",new ArrayList<Integer>(Arrays.asList())),
        		new WorldFootBallAttributeFor_TEST("out",new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(astonVillaTransferTable1889_1890ActualValue,astonVilla1889_1890AtrribuTests,astonVillatransferTable1889_1890ExpectedValue);

        ClubTransferTable accringtonFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Accrington FC");
        ClubTransferTable accringtonFCtransferTable1889_1890ExpectedValue = new ClubTransferTable();
        accringtonFCtransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Accrington FC";
        accringtonFCtransferTable1889_1890ExpectedValue.season = "1889-1890";
        accringtonFCtransferTable1889_1890ExpectedValue.outtable = new ArrayList<>(Arrays.asList(
        		new TransferPlayerInformation("06/89", "Joe Lofthouse", "England", "FW", "Accrington FC", "Blackburn Rovers")));
        List<WorldFootBallAttributeFor_TEST> accrington1889_1890AtrribuTests =new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("out",new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(accringtonFCTransferTable1889_1890ActualValue,accrington1889_1890AtrribuTests,accringtonFCtransferTable1889_1890ExpectedValue);

        ClubTransferTable derbyCountyTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Derby County");
        ClubTransferTable derbyCountytransferTable1889_1890ExpectedValue = new ClubTransferTable();
        derbyCountytransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Derby County";
        derbyCountytransferTable1889_1890ExpectedValue.season = "1889-1890";
        derbyCountytransferTable1889_1890ExpectedValue.intable= new ArrayList<>(Arrays.asList(
        		new TransferPlayerInformation("07/89", "Charlie Bunyan", "England", "GK", "Hyde FC", "Derby County"),
        		new TransferPlayerInformation("07/89", "Archie Goodall", "Northern Ireland", "MF", "Aston Villa", "Derby County"),
        		new TransferPlayerInformation("07/89", "John Goodall", "England", "FW", "Preston North End", "Derby County")));
        List<WorldFootBallAttributeFor_TEST> derbyCounty1889_1890AtrribuTests =new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("out",new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(derbyCountyTransferTable1889_1890ActualValue,derbyCounty1889_1890AtrribuTests,derbyCountytransferTable1889_1890ExpectedValue);

        ClubTransferTable burnleyFCTransferTable1889_1890ActualValue = new ClubTransferTable();
        burnleyFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Burnley FC");
        ClubTransferTable burnleyFCtransferTable1889_1890ExpectedValue = new ClubTransferTable();
        burnleyFCtransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Burnley FC";
        burnleyFCtransferTable1889_1890ExpectedValue.season = "1889-1890";
        List<WorldFootBallAttributeFor_TEST> burnleyFC1889_1890AtrribuTests =new ArrayList<>(Arrays.asList(
        		new WorldFootBallAttributeFor_TEST("in",new ArrayList<Integer>(Arrays.asList())),
        		new WorldFootBallAttributeFor_TEST("out",new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(burnleyFCTransferTable1889_1890ActualValue,burnleyFC1889_1890AtrribuTests,burnleyFCtransferTable1889_1890ExpectedValue);

    }

    /*public void assertTopScore(ArrayList<PlayerTopSoccer> actualValue ,List<Integer> indexes, ArrayList<PlayerTopSoccer> expectedValue) {
    	int limit = (indexes.isEmpty())?Math.max(actualValue.size(), expectedValue.size()) : indexes.size();
		int j =0;
    	while(j < limit) {
    		int index = (indexes.isEmpty())? index =j : indexes.get(j);
    		assertThat(actualValue.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.get(j)); 
    		j++;
    	} 
    }*/
    @Test
    public void itShouldGetTopSoccer() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<PlayerTopSoccer> table2019_2020ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "2019-2020");
        ArrayList<PlayerTopSoccer> table2019_2020player0TO4ExpectedValue = new ArrayList<>(Arrays.asList(
        		new PlayerTopSoccer("1.", "Jamie Vardy", "England", "Leicester City", "23", "4"),
        		new PlayerTopSoccer("2.", "Pierre-Emerick Aubameyang", "Gabon", "Arsenal FC", "22", "2"),
        		new PlayerTopSoccer("2.", "Danny Ings", "England", "Southampton FC", "22", "1"),
        		new PlayerTopSoccer("4.", "Raheem Sterling", "England", "Manchester City", "20", "0"),
        		new PlayerTopSoccer("5.", "Mohamed Salah", "Egypt", "Liverpool FC", "19", "3")));
        List<Integer> indexes2019_2020From0To4 = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        assertStatistics(table2019_2020ActualValue, indexes2019_2020From0To4, table2019_2020player0TO4ExpectedValue);

        ArrayList<PlayerTopSoccer> table2009_2010ActualValue  = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "2009-2010");
        ArrayList<PlayerTopSoccer> table2009_2010player4TO9ExpectedValue = new ArrayList<>(Arrays.asList(
        		new PlayerTopSoccer("5.", "Frank Lampard", "England", "Chelsea FC", "22", "10"),
        		new PlayerTopSoccer("6.", "Jermain Defoe", "England", "Tottenham Hotspur", "18", "1"),
        		new PlayerTopSoccer("6.", "Fernando Torres", "Spain", "Liverpool FC", "18", "0"),
        		new PlayerTopSoccer("8.", "Cesc Fàbregas", "Spain", "Arsenal FC", "15", "3"),
        		new PlayerTopSoccer("9.", "Emmanuel Adebayor", "Togo", "Manchester City", "14", "0")));
        List<Integer> indexes2019_2020From6To10 = new ArrayList<>(Arrays.asList(4,5,6,7,8));
        assertStatistics(table2009_2010ActualValue, indexes2019_2020From6To10, table2009_2010player4TO9ExpectedValue);
        
        ArrayList<PlayerTopSoccer> table1946_1947ActualValue =screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "1946-1947");
        ArrayList<PlayerTopSoccer> table1946_1947player0TO4ExpectedValue = new ArrayList<>(Arrays.asList(
        		new PlayerTopSoccer("1.", "Dennis Westcott", "England", "Wolverhampton Wanderers", "38", "0"),
        		new PlayerTopSoccer("2.", "Reg Lewis", "England", "Arsenal FC", "29", "3"),
        		new PlayerTopSoccer("2.", "Stan Mortensen", "England", "Blackpool FC", "29", "1"),
        		new PlayerTopSoccer("2.", "Duggie Reid", "Scotland", "Portsmouth FC", "29", "1"),
        		new PlayerTopSoccer("2.", "Freddie Steele", "England", "Stoke City", "29", "0")));
        List<Integer> indexes1946_1947From0To4 = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        assertStatistics(table1946_1947ActualValue, indexes1946_1947From0To4, table1946_1947player0TO4ExpectedValue);
 
    }
    public void assertStatistics(ArrayList<?> actualValue,List<Integer>  indexes ,ArrayList<?> expectedValue) {
    	if(expectedValue == null) {
    		Assert.assertEquals(null,actualValue);
    	}
	    	else {
	    	int limit = ((indexes == null) || (indexes.isEmpty())) ? Math.max(actualValue.size(), expectedValue.size()) : indexes.size();
	    	int j = 0;
	    	while(j < limit) {
	    		int index = ((indexes == null) || (indexes.isEmpty())) ? j : indexes.get(j);
	    		assertThat(actualValue.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.get(j));
	    		j++;
	    	}
    	}
    }

    @Test
    public void itShouldGetStatisticsGoalsPerSeason() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsGoalsPerSeason> actualValue = screenScraperUnderTest.getStatisticsGoalsPerSeason("eng-premier-league");
        ArrayList<StatisticsGoalsPerSeason> actualValue0To9 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            actualValue0To9.add(actualValue.get(i));
        }
        ArrayList<StatisticsGoalsPerSeason> expectedValue0To9 = new ArrayList<>(Arrays.asList(
        		new StatisticsGoalsPerSeason("1", "1889/1890", "611", "132", "4.6288"),
        		new StatisticsGoalsPerSeason("2", "1888/1889", "586", "132", "4.4394"),
        		new StatisticsGoalsPerSeason("3", "1891/1892", "777", "182", "4.2692"),
        		new StatisticsGoalsPerSeason("4", "1890/1891", "554", "132", "4.1970"),
        		new StatisticsGoalsPerSeason("5", "1930/1931", "1823", "462", "3.9459"),
        		new StatisticsGoalsPerSeason("6", "1893/1894", "939", "240", "3.9125"),
        		new StatisticsGoalsPerSeason("7", "1892/1893", "936", "240", "3.9000"),
        		new StatisticsGoalsPerSeason("8", "1894/1895", "917", "240", "3.8208"),
        		new StatisticsGoalsPerSeason("9", "1927/1928", "1765", "462", "3.8203")));
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8));
        assertStatistics(actualValue, indexes,expectedValue0To9);

    }

    @Test
    public void itShouldGetStatisticsGoalsPerRound() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsGoalsPerRound> actualValue = screenScraperUnderTest.getStatisticsGoalsPerRound("eng-premier-league");

        ArrayList<StatisticsGoalsPerRound> expectedlValue0To4 = new ArrayList<>(Arrays.asList(
        		new StatisticsGoalsPerRound("1", "1891/1892", "23. Round", "42", "6", "7.0000"),
        		new StatisticsGoalsPerRound("2", "1888/1889", "8. Round", "42", "6", "7.0000"),
        		new StatisticsGoalsPerRound("3", "1889/1890", "13. Round", "34", "5", "6.8000"),
        		new StatisticsGoalsPerRound("4", "1888/1889", "4. Round", "40", "6", "6.6667"),
        		new StatisticsGoalsPerRound("5", "1963/1964", "24. Round", "71", "11", "6.4545")));

        /*CompareStatisticsGoalsPerRound roundComparator = new CompareStatisticsGoalsPerRound();
        Collections.sort(actualValue0To9, roundComparator);
        Collections.sort(expectedlValue0To9, roundComparator);*/
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        assertStatistics(actualValue, indexes, expectedlValue0To4);

    }

    @Test
    public void itShouldGetStatisticsRecordWins() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue = screenScraperUnderTest.getStatisticsRecordWinsOrMostGoalInGame("eng-premier-league", StatisticsRequestKind.RecordWins);

        ArrayList<StatisticsRecordWinsAndMostGoalInGame> expectedValue0To9 = new ArrayList<>(Arrays.asList(
        		new StatisticsRecordWinsAndMostGoalInGame("1908/1909", "36. Round", "21/04/1909", "Nottingham Forest", "12:0", "Leicester Fosse"),
        		new StatisticsRecordWinsAndMostGoalInGame("1891/1892", "23. Round", "04/04/1892", "West Bromwich Albion", "12:0", "Darwen"),
        		new StatisticsRecordWinsAndMostGoalInGame("1891/1892", "23. Round", "12/03/1892", "Aston Villa", "12:2", "Accrington FC"),
        		new StatisticsRecordWinsAndMostGoalInGame("1928/1929", "26. Round", "19/01/1929", "Sheffield United", "10:0", "Burnley FC"),
        		new StatisticsRecordWinsAndMostGoalInGame("1928/1929", "11. Round", "20/10/1928", "Leicester City", "10:0", "Portsmouth FC"),
        		new StatisticsRecordWinsAndMostGoalInGame("1925/1926", "1. Round", "29/08/1925", "Aston Villa", "10:0", "Burnley FC"),
        		new StatisticsRecordWinsAndMostGoalInGame("1912/1913", "8. Round", "05/10/1912", "Aston Villa", "10:0", "The Wednesday FC"),
        		new StatisticsRecordWinsAndMostGoalInGame("1889/1890", "1. Round", "14/09/1889", "Preston North End", "10:0", "Stoke City"),
        		new StatisticsRecordWinsAndMostGoalInGame("1925/1926", "24. Round", "01/01/1926", "Sheffield United", "11:2", "Cardiff City"),
        		new StatisticsRecordWinsAndMostGoalInGame("1963/1964", "24. Round", "26/12/1963", "Fulham FC", "10:1", "Ipswich Town")));

        List<Integer> indexes = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8));
        assertStatistics(actualValue, indexes, expectedValue0To9);
    }

    @Test
    public void itShouldGetStatisticsMostGoalInGame() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue = new ArrayList<>();
        actualValue = screenScraperUnderTest.getStatisticsRecordWinsOrMostGoalInGame("eng-premier-league", StatisticsRequestKind.MostGoalInGame);
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> expectedValue0To9 = new ArrayList<>(Arrays.asList(
        		new StatisticsRecordWinsAndMostGoalInGame("1958/1959", "12. Round", "11/10/1958", "Tottenham Hotspur", "10:4", "Everton FC"),
        		new StatisticsRecordWinsAndMostGoalInGame("1891/1892", "23. Round", "12/03/1892", "Aston Villa", "12:2", "Accrington FC"),
        		new StatisticsRecordWinsAndMostGoalInGame("1936/1937", "26. Round", "04/02/1937", "Stoke City", "10:3", "West Bromwich Albion"),
        		new StatisticsRecordWinsAndMostGoalInGame("1933/1934", "14. Round", "18/11/1933", "Middlesbrough FC", "10:3", "Sheffield United"),
        		new StatisticsRecordWinsAndMostGoalInGame("1925/1926", "24. Round", "01/01/1926", "Sheffield United", "11:2", "Cardiff City"),
        		new StatisticsRecordWinsAndMostGoalInGame("1890/1891", "1. Round", "06/09/1890", "Derby County", "8:5", "Blackburn Rovers"),
        		new StatisticsRecordWinsAndMostGoalInGame("1957/1958", "31. Round", "22/02/1958", "Leicester City", "8:4", "Manchester City"),
        		new StatisticsRecordWinsAndMostGoalInGame("1952/1953", "10. Round", "27/09/1952", "Blackpool FC", "8:4", "Charlton Athletic"),
        		new StatisticsRecordWinsAndMostGoalInGame("1934/1935", "18. Round", "08/12/1934", "Derby County", "9:3", "West Bromwich Albion"),
        		new StatisticsRecordWinsAndMostGoalInGame("1931/1932", "11. Round", "17/10/1931", "Everton FC", "9:3", "Sheffield Wednesday")));
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8));
        assertStatistics(actualValue, indexes, expectedValue0To9);

    }

    @Test
    public void itShouldGetStatisticsDirtiesGamesForCompetition() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<DirtyGame> actualValue  = screenScraperUnderTest.getStatisticsDirtiesGamesForCompetition("eng-premier-league");
        ArrayList<DirtyGame> expectedValue0To9 = new ArrayList<>(Arrays.asList(
        		new DirtyGame("01/05/1999", "West Ham United", "1:5", "Leeds United", "2", "1", "7", "15"),
        		new DirtyGame("23/10/2011", "Queens Park Rangers", "1:0", "Chelsea FC", "2", "0", "9", "15"),
        		new DirtyGame("27/09/1999", "Liverpool FC", "0:1", "Everton FC", "3", "0", "5", "14"),
        		new DirtyGame("18/09/2004", "West Bromwich Albion", "1:1", "Fulham FC", "2", "1", "6", "14"),
        		new DirtyGame("25/03/2006", "Liverpool FC", "3:1", "Everton FC", "1", "1", "9", "14"),
        		new DirtyGame("07/11/1999", "Tottenham Hotspur", "2:1", "Arsenal FC", "1", "1", "9", "14"),
        		new DirtyGame("09/02/2010", "Portsmouth FC", "1:1", "Sunderland AFC", "3", "0", "4", "13"),
        		new DirtyGame("17/02/1999", "Chelsea FC", "1:1", "Blackburn Rovers", "2", "0", "7", "13"),
        		new DirtyGame("13/09/2003", "Everton FC", "2:2", "Newcastle United", "1", "0", "10", "13"),
        		new DirtyGame("25/10/1998", "Leeds United", "0:0", "Chelsea FC", "0", "1", "11", "13")));
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        assertStatistics(actualValue, indexes, expectedValue0To9);

    }

    @Test
    public void itShouldGetStatisticsBestPlayerInYear() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsBestPlayerInYear> actualValue = screenScraperUnderTest.getStatisticsBestPlayerInYear("england");
        ArrayList<StatisticsBestPlayerInYear> expectedValue0To9 = new ArrayList<>(Arrays.asList(
        		new StatisticsBestPlayerInYear("2020", "Jordan Henderson"),
        		new StatisticsBestPlayerInYear("2019", "Raheem Sterling"),
        		new StatisticsBestPlayerInYear("2018", "Mohamed Salah"),
        		new StatisticsBestPlayerInYear("2017", "N'Golo Kanté"),
        		new StatisticsBestPlayerInYear("2016", "Jamie Vardy"),
        		new StatisticsBestPlayerInYear("2015", "Eden Hazard"),
        		new StatisticsBestPlayerInYear("2014", "Luis Suárez"),
        		new StatisticsBestPlayerInYear("2013", "Gareth Bale"),
        		new StatisticsBestPlayerInYear("2012", "Robin van Persie"),
        		new StatisticsBestPlayerInYear("2011", "Scott Parker")));
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        assertStatistics(actualValue, indexes, expectedValue0To9);
    }

    @Test
    public void itShouldGetAllClubStaduimsForCompetition() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<Staduim> actualValueEnglandPremierLeague2020_2021 = screenScraperUnderTest.getCompetitionStadiums("eng-premier-league", "2020-2021");
        ArrayList<Staduim> expectedValueEnglndPreimerLeague2020_2021Just0To5 = new ArrayList<>(Arrays.asList(
        		new Staduim("Amex Stadium", "Brighton", "England", "30.750"),
        		new Staduim("Anfield", "Liverpool", "England", "54.074"),
        		new Staduim("Bramall Lane", "Sheffield", "England", "33.000"),
        		new Staduim("Craven Cottage", "London", "England", "25.700"),
        		new Staduim("Elland Road", "Leeds", "England", "37.890")));
        List<Integer> indexesEnglandPremierLeague2020_2021 = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        assertStatistics(actualValueEnglandPremierLeague2020_2021, indexesEnglandPremierLeague2020_2021, expectedValueEnglndPreimerLeague2020_2021Just0To5);

        ArrayList<Staduim> actualValueEnglandChampionship1950_1951 =  screenScraperUnderTest.getCompetitionStadiums("eng-championship", "1950-1951");
        ArrayList<Staduim> expectedValue1950_1951Just0To5 = null;
        assertStatistics(actualValueEnglandChampionship1950_1951, null, expectedValue1950_1951Just0To5);

    }

    @Test
    public void itShouldGetMostGoalsByPlayerPerGame() {
    	
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsMostGoalsByPlayerPerGame> engPremierLeagueActualValue= screenScraperUnderTest.getStatisticsMostGoalsByPlayerInGameInCompetition("eng-premier-league");
        ArrayList<StatisticsMostGoalsByPlayerPerGame> engPremierLeagueExpectedValue = new ArrayList<>(Arrays.asList(
        		new StatisticsMostGoalsByPlayerPerGame( "Geoff Hurst", "19/10/1968", "West Ham United", "8:0", "Sunderland AFC", "6"),
        		new StatisticsMostGoalsByPlayerPerGame( "Kun Agüero", "03/10/2015", "Manchester City", "6:1", "Newcastle United", "5"),
        		new StatisticsMostGoalsByPlayerPerGame( "Heung-min Son", "20/09/2020", "Southampton FC", "2:5", "Tottenham Hotspur", "4")));
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0,1,22));
        assertStatistics(engPremierLeagueActualValue, indexes, engPremierLeagueExpectedValue);

    }
    @Test 
    public void itShouldGetTopScoreForCompetitionAllYears(){
    	ScreenScraper screenScraperTest = new ScreenScraper();
    	ArrayList<PlayerTopScoreForSeason> engPreimerLeagueactualValue = screenScraperTest.getTopSoccerForCompetitionAllYears("eng-premier-league");
    	ArrayList<PlayerTopScoreForSeason> engPreimerLeagueexpectedValue = new ArrayList<>(Arrays.asList(
    			new PlayerTopScoreForSeason("2019/2020" , "England","Jamie Vardy",                "Leicester City","23"),
    			new PlayerTopScoreForSeason("2018/2019" , "Senegal","Sadio Mané" ,                "Liverpool FC",  "22"),
    			new PlayerTopScoreForSeason("2018/2019" , "Gabon",  "Pierre-Emerick Aubameyang",  "Arsenal FC",    "22"),
    			new PlayerTopScoreForSeason("2018/2019" , "Egypt",  "Mohamed Salah", 	          "Liverpool FC",  "22"),
    			new PlayerTopScoreForSeason("2017/2018" , "Egypt", 	"Mohamed Salah", 	 	      "Liverpool FC",  "32"),
    			new PlayerTopScoreForSeason("2016/2017" , "England","Harry Kane", 	              "Tottenham Hotspur","29"),
    			new PlayerTopScoreForSeason("2012/2013" , "Netherlands","Robin van Persie", 	"Manchester United","26")));
    	List<Integer> indexes = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,9));
    	assertStatistics(engPreimerLeagueactualValue, indexes, engPreimerLeagueexpectedValue);
    }
    //to do
    @Test
    public void itShouldGetRoundInfoSofaScore() {
        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
        sofaScoreCollectorTest.getGamesIdInRound("Premier League", "20/21", "3");
    }
    public void assertItemStatisticsInGroup() {
    	//        assertThat(actualVlaue).usingRecursiveComparison().isEqualTo(expectedValue);
    }



    @Test
    public void itShouldGetGameStatisticSofaScore() {

        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();

        GameStatistic game1Atround3At19_20StatisticTopScoreActualValue = sofaScoreCollectorTest.getGameStatistic("Premier League", "19/20", "3", 1);

        assertThat("ALL").isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(0).period);
        assertThat("1ST").isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(1).period);
        assertThat("TVData").isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(2).groups.get(2).groupName);

        ItemStatisticsInGroup game1Atround3At19_20_ALL_Possession_Info = new ItemStatisticsInGroup("Ball possession", "46%", "54%");
        assertThat(game1Atround3At19_20_ALL_Possession_Info).usingRecursiveComparison().isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(0).groups.get(0).statisticsItems.get(0));

        ItemStatisticsInGroup game1Atround3At19_20_ALL_Total_Shots_Info = new ItemStatisticsInGroup("Total shots", "6", "23");
        assertThat(game1Atround3At19_20_ALL_Total_Shots_Info).usingRecursiveComparison().isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(0).groups.get(1).statisticsItems.get(0));

        ItemStatisticsInGroup game1Atround3At19_20_1ST_Blocked_Shots_Info = new ItemStatisticsInGroup("Blocked shots", "0", "5");
        assertThat(game1Atround3At19_20_1ST_Blocked_Shots_Info).usingRecursiveComparison().isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(1).groups.get(1).statisticsItems.get(3));

        ItemStatisticsInGroup game1Atround3At19_20_1ST_Goalkeeper_Saves_Info = new ItemStatisticsInGroup("Goalkeeper saves", "2", "2");
        assertThat(game1Atround3At19_20_1ST_Goalkeeper_Saves_Info).usingRecursiveComparison().isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(1).groups.get(3).statisticsItems.get(6));

        ItemStatisticsInGroup game1Atround3At19_20_2ND_Long_Balls_Info = new ItemStatisticsInGroup("Long balls", "5/28 (18%)", "11/23 (48%)");
        assertThat(game1Atround3At19_20_2ND_Long_Balls_Info).usingRecursiveComparison().isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(2).groups.get(4).statisticsItems.get(2));

        GameStatistic game5Atround8At20_21StatisticTopScoreActualValue = sofaScoreCollectorTest.getGameStatistic("Premier League", "20/21", "8", 5);

        assertThat("2ND").isEqualTo(game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(2).period);
        assertThat("Shots extra").isEqualTo(game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(1).groups.get(3).groupName);
        assertThat("TVData").isEqualTo(game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(2).groups.get(2).groupName);

        ItemStatisticsInGroup game5Atround8At20_21_ALL_Possession_Info = new ItemStatisticsInGroup("Ball possession", "53%", "47%");
        assertThat(game5Atround8At20_21_ALL_Possession_Info).usingRecursiveComparison().isEqualTo(game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(0).groups.get(0).statisticsItems.get(0));

        ItemStatisticsInGroup game5Atround8At20_21_ALL_Shots_Off_Target_Info = new ItemStatisticsInGroup("Shots off target", "8", "4");
        assertThat(game5Atround8At20_21_ALL_Shots_Off_Target_Info).usingRecursiveComparison().isEqualTo(game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(0).groups.get(1).statisticsItems.get(2));

        Assert.assertEquals(7, game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(2).groups.size());

        Assert.assertEquals(4, game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(2).groups.get(5).statisticsItems.size());

    }
   
 
}