package collector;

import collector.testData.*;
import models.Club;
import models.ClubForRankingTable;
import models.ClubTransferTable;
import models.DirtyGame;
import models.Game;
import models.GamesTableOfLeague;
import models.Goal;
import models.MatchDetails;
import models.PlayerAllInformation;
import models.PlayerSummary;
import models.PlayerTopScoreForSeason;
import models.PlayerTopSoccer;
import models.RankingTable;
import models.RankingTableRequest;
import models.Staduim;
import models.StatisticsBestPlayerInYear;
import models.StatisticsGoalsPerRound;
import models.StatisticsGoalsPerSeason;
import models.StatisticsMostGoalsByPlayerPerGame;
import models.StatisticsRecordWinsAndMostGoalInGame;
import models.StatisticsRequestKind;
import sofaScore.SofaScoreCollector;
import sofaScoreModels.GameID;
import sofaScoreModels.GameIencidents;
import sofaScoreModels.GameStatistic;
import sofaScoreModels.ItemStatisticsInGroup;
import sofaScoreModels.RoundGamesID;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class ScreenScraperTest {
    WorldFootballGamesInTableOfLeagueValues gamesInTableworldFootballValues = new WorldFootballGamesInTableOfLeagueValues();
    WorldFootballRankingTableValues rankingTablesWorldFootballValues = new WorldFootballRankingTableValues();
    WorldFootballGoalsValues goalsWorldFootBallValues = new WorldFootballGoalsValues();
    WorldFootballClubsValues clubsWorldFootballClubsValues = new WorldFootballClubsValues();
    WorldFootballPlayerSummuryInTeamsValues playersInTeamsValues = new WorldFootballPlayerSummuryInTeamsValues();
    WorldFootballPlayersValue playersInformationWorldFootballValue = new WorldFootballPlayersValue();
    WorldFootballMatchDetailsValue matchesWorldFootballMatchDetailsValue = new WorldFootballMatchDetailsValue();
    WorldFootballTransferTableValues tansferTableWorldFootballTransferTableValues = new WorldFootballTransferTableValues();
    WorldFootballTopScoreValue topScoreWorldFootballValue = new WorldFootballTopScoreValue();
    WorlFootballStatisticsValues statisticsValues = new WorlFootballStatisticsValues();
    WorldFootballStadimsValues staduimsWorldDootballValues = new WorldFootballStadimsValues();
    SofaScoreGamesIDInRoundValues gameIDInRoundSofaScoreValues = new SofaScoreGamesIDInRoundValues();

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
        List<Game> gamesInRound21At2015_2016 = gamesInTableworldFootballValues.getGamesInRoundInSeason("2015-2016", 21);
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
        List<Game> gamesInRound35At1925_1926 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1925-1926", 35);
        List<Integer> gamesIdsInRound35At1925_1926 = Arrays.asList(0, 1, 5);
        assertGameInRound(gamesTableActualValue1925_1926, gamesInRound35At1925_1926, gamesIdsInRound35At1925_1926, 35);
        Assert.assertEquals(8, gamesTableActualValue1925_1926.rounds.get(34).games.size());
        List<Game> gamesInRound36At1925_1926 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1925-1926", 36);
        List<Integer> gamesIdsInRound36At1925_1926 = Arrays.asList(0, 2, 7, 11);
        assertGameInRound(gamesTableActualValue1925_1926, gamesInRound36At1925_1926, gamesIdsInRound36At1925_1926, 36);
        Assert.assertEquals(13, gamesTableActualValue1925_1926.rounds.get(35).games.size());
        Assert.assertEquals(42, gamesTableActualValue1925_1926.rounds.size());
        GamesTableOfLeague gamesTableActualValue1891_1892 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1891-1892");
        List<Game> gamesInRound1At1891_1892 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1891-1892", 1);
        List<Integer> gamesIdsInRound36At1891_1892 = Arrays.asList(1, 4, 6);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound1At1891_1892, gamesIdsInRound36At1891_1892, 1);
        Assert.assertEquals(7, gamesTableActualValue1891_1892.rounds.get(0).games.size());
        List<Game> gamesInRound6At1891_1892 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1891-1892", 6);
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
        List<Game> gamesInRound2At1888_1889 = gamesInTableworldFootballValues.getGamesInRoundInSeason("1888-1889", 2);
        List<Integer> gamesIdsInRound2At1888_1889 = Arrays.asList(0, 1, 2, 3, 4, 5);
        assertGameInRound(gamesTableActualValue1888_1889, gamesInRound2At1888_1889, gamesIdsInRound2At1888_1889, 2 + 1);//this season starts with round 0
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
        List<Integer> clubsIdInRankingTable1889_1890 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        assertRankingTable(rankingTable1889_1890ActualValue, rankingTable1889_1890Expected, clubsIdInRankingTable1889_1890);
        RankingTable rankingTable1906_1907ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "1906-1907");
        List<Integer> clubsIdInRankingTable1906_1907 = Arrays.asList(0, 1, 2, 7, 11, 17);
        List<ClubForRankingTable> rankingTable1906_1907Expected = rankingTablesWorldFootballValues.getLastRankingTable("eng-premier-league", "1906-1907");
        assertRankingTable(rankingTable1906_1907ActualValue, rankingTable1906_1907Expected, clubsIdInRankingTable1906_1907);
        Assert.assertEquals(20, rankingTable1906_1907ActualValue.table.size());
        RankingTable rankingTable1959_1960ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "1959-1960");
        List<Integer> clubsIdInRankingTable1959_1960 = Arrays.asList(1, 6, 20);
        List<ClubForRankingTable> rankingTable1960_1970Expected = rankingTablesWorldFootballValues.getLastRankingTable("eng-premier-league", "1959-1960");
        assertRankingTable(rankingTable1959_1960ActualValue, rankingTable1960_1970Expected, clubsIdInRankingTable1959_1960);
        Assert.assertEquals(22, rankingTable1959_1960ActualValue.table.size());
        RankingTable rankingTable2007_2008ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "2007-2008");
        List<Integer> clubsIdInRankingTable2007_2008 = Arrays.asList(0, 3, 11);
        List<ClubForRankingTable> rankingTable2007_2008Expected = rankingTablesWorldFootballValues.getLastRankingTable("eng-premier-league", "2007-2008");
        assertRankingTable(rankingTable2007_2008ActualValue, rankingTable2007_2008Expected, clubsIdInRankingTable2007_2008);
        Assert.assertEquals(20, rankingTable2007_2008ActualValue.table.size());
        RankingTable rankingTable2017_2018ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "2017-2018");
        List<Integer> clubsIdInRankingTable2017_2018 = Arrays.asList(1, 5, 18);
        List<ClubForRankingTable> rankingTable2017_2018Expected = rankingTablesWorldFootballValues.getLastRankingTable("eng-premier-league", "2017-2018");
        assertRankingTable(rankingTable2017_2018ActualValue, rankingTable2017_2018Expected, clubsIdInRankingTable2017_2018);
        Assert.assertEquals(20, rankingTable2017_2018ActualValue.table.size());

    }

    @Test
    public void itShouldGetRankingTableByRound() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        RankingTable rankingTable2012_2013ByRound14NormalActualValue = screenScraperUnderTest.getTableByRound("eng-premier-league", "2012-2013", "14", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable2012_2013Round14Normal = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
        List<ClubForRankingTable> rankingTable2012_2013Expected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable2012_2013Expected");
        assertRankingTable(rankingTable2012_2013ByRound14NormalActualValue, rankingTable2012_2013Expected, clubsIdInRankingTable2012_2013Round14Normal);

        RankingTable rankingTable2018_2019Round21AwayActualValue = screenScraperUnderTest.getTableByRound("eng-premier-league", "2018-2019", "21", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable2018_2019Round21Away = Arrays.asList(0, 1, 17);
        List<ClubForRankingTable> rankingTable2018_2019Round21AwayExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable2018_2019Round21AwayExpected");
        assertRankingTable(rankingTable2018_2019Round21AwayActualValue, rankingTable2018_2019Round21AwayExpected, clubsIdInRankingTable2018_2019Round21Away);
        Assert.assertEquals(20, rankingTable2018_2019Round21AwayActualValue.table.size());

        RankingTable rankingTableActualValue2013_2014ByRound27Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "2013-2014", "27", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable2013_2014Round27Home = Arrays.asList(0, 5);
        List<ClubForRankingTable> rankingTable2013_2014Round21HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable2013_2014Round21HomeExpected");
        assertRankingTable(rankingTableActualValue2013_2014ByRound27Home, rankingTable2013_2014Round21HomeExpected, clubsIdInRankingTable2013_2014Round27Home);
        Assert.assertEquals(20, rankingTableActualValue2013_2014ByRound27Home.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable2000_2001Round11Normal = Arrays.asList(0, 4, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11NormalExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable2000_2001Round11NormalExpected");
        assertRankingTable(rankingTableActualValue2000_2001ByRound11Normal, rankingTable2000_2001Round11NormalExpected, clubsIdInRankingTable2000_2001Round11Normal);
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Normal.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable2000_2001Round11Away = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11AwayExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable2000_2001Round11AwayExpected");
        assertRankingTable(rankingTableActualValue2000_2001ByRound11Away, rankingTable2000_2001Round11AwayExpected, clubsIdInRankingTable2000_2001Round11Away);
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Away.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable2000_2001ByRound11Home = Arrays.asList(0, 1, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTableActualValue2000_2001ByRound11Home");
        assertRankingTable(rankingTableActualValue2000_2001ByRound11Home, rankingTable2000_2001Round11HomeExpected, clubsIdInRankingTable2000_2001ByRound11Home);
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Home.table.size());

        RankingTable rankingTableActualValue1955_1956ByRound20Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1955-1956", "20", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1955_1956ByRound20Normal = Arrays.asList(0, 3, 10);
        List<ClubForRankingTable> rankingTable1955_1956Round20NormalExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1955_1956Round20NormalExpected");
        assertRankingTable(rankingTableActualValue1955_1956ByRound20Normal, rankingTable1955_1956Round20NormalExpected, clubsIdInRankingTable1955_1956ByRound20Normal);
        Assert.assertEquals(22, rankingTableActualValue1955_1956ByRound20Normal.table.size());

        RankingTable rankingTableActualValue1977_1978ByRound37Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1977-1978", "37", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1977_1978ByRound37Away = Arrays.asList(0, 3, 10);
        List<ClubForRankingTable> rankingTable1977_1978Round37AwayExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTableActualValue1955_1956ByRound20Normal");
        assertRankingTable(rankingTableActualValue1977_1978ByRound37Away, rankingTable1977_1978Round37AwayExpected, clubsIdInRankingTable1977_1978ByRound37Away);
        Assert.assertEquals(22, rankingTableActualValue1977_1978ByRound37Away.table.size());

        RankingTable rankingTableActualValue1985_1986ByRound26Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1985-1986", "26", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1985_1986ByRound26Home = Arrays.asList(0, 1, 13);
        List<ClubForRankingTable> rankingTable1985_1986ByRound26HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1985_1986ByRound26HomeExpected");
        assertRankingTable(rankingTableActualValue1985_1986ByRound26Home, rankingTable1985_1986ByRound26HomeExpected, clubsIdInRankingTable1985_1986ByRound26Home);
        Assert.assertEquals(22, rankingTableActualValue1985_1986ByRound26Home.table.size());

        RankingTable rankingTableActualValue1948_1949ByRound27Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1948-1949", "27", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1948_1949ByRound27Normal = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1948_1949ByRound27HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1948_1949ByRound27HomeExpected");
        assertRankingTable(rankingTableActualValue1948_1949ByRound27Normal, rankingTable1948_1949ByRound27HomeExpected, clubsIdInRankingTable1948_1949ByRound27Normal);
        Assert.assertEquals(22, rankingTableActualValue1948_1949ByRound27Normal.table.size());

        RankingTable rankingTableActualValue1930_1931ByRound8Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1930-1931", "8", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1930_1931ByRound8Away = Arrays.asList(0, 21);
        List<ClubForRankingTable> rankingTable1930_1931ByRound8HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1930_1931ByRound8HomeExpected");
        assertRankingTable(rankingTableActualValue1930_1931ByRound8Away, rankingTable1930_1931ByRound8HomeExpected, clubsIdInRankingTable1930_1931ByRound8Away);
        Assert.assertEquals(22, rankingTableActualValue1930_1931ByRound8Away.table.size());

        RankingTable rankingTableActualValue1925_1926ByRound12Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1925-1926", "12", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1925_1926ByRound12Home = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1925_1926ByRound12HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1925_1926ByRound12HomeExpected");
        assertRankingTable(rankingTableActualValue1925_1926ByRound12Home, rankingTable1925_1926ByRound12HomeExpected, clubsIdInRankingTable1925_1926ByRound12Home);
        Assert.assertEquals(22, rankingTableActualValue1925_1926ByRound12Home.table.size());

        RankingTable rankingTableActualValue1898_1899ByRound18Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1898-1899", "18", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1898_1899ByRound18Normal = Arrays.asList(0, 5, 15);
        List<ClubForRankingTable> rankingTable1898_1899ByRound18NormalExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1898_1899ByRound18NormalExpected");
        assertRankingTable(rankingTableActualValue1898_1899ByRound18Normal, rankingTable1898_1899ByRound18NormalExpected, clubsIdInRankingTable1898_1899ByRound18Normal);
        Assert.assertEquals(18, rankingTableActualValue1898_1899ByRound18Normal.table.size());

        RankingTable rankingTableActualValue1888_1889ByRound10Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1888-1889", "10", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1888_1889ByRound10Away = Arrays.asList(0, 4, 10);
        List<ClubForRankingTable> rankingTable1888_1889ByRound10AwayExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1888_1889ByRound10AwayExpected");
        assertRankingTable(rankingTableActualValue1888_1889ByRound10Away, rankingTable1888_1889ByRound10AwayExpected, clubsIdInRankingTable1888_1889ByRound10Away);
        Assert.assertEquals(12, rankingTableActualValue1888_1889ByRound10Away.table.size());

        RankingTable rankingTableActualValue1891_1892ByRound18Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1891-1892", "18", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1891_1892ByRound18Home = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1891_1892ByRound12HomeExpected = rankingTablesWorldFootballValues.getRankingTableByRound("eng-premier-league", "rankingTable1891_1892ByRound12HomeExpected");
        assertRankingTable(rankingTableActualValue1891_1892ByRound18Home, rankingTable1891_1892ByRound12HomeExpected, clubsIdInRankingTable1891_1892ByRound18Home);
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
        List<Goal> goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue = goalsWorldFootBallValues.getGamesGoalsValue("goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue");
        assertGameGoal(goals2017_2018LiverpoolFcBrightonHoveAlbionActualValue, goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue);

        ArrayList<Goal> goals2015_2016ArsenalFcAstonVillaActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2015-2016", "arsenal-fc", "aston-villa");
        List<Goal> goals2015_2016ArsenalFcAstonVillaExpectedValue = goalsWorldFootBallValues.getGamesGoalsValue("goals2015_2016ArsenalFcAstonVillaExpectedValue");
        assertGameGoal(goals2015_2016ArsenalFcAstonVillaActualValue, goals2015_2016ArsenalFcAstonVillaExpectedValue);

        ArrayList<Goal> goals2015_2016SunderlandAfcChelseaFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2015-2016", "sunderland-afc", "chelsea-fc");
        List<Goal> goals2015_2016SunderlandAfcChelseaFcExpectedValue = goalsWorldFootBallValues.getGamesGoalsValue("goals2015_2016SunderlandAfcChelseaFcExpectedValue");
        assertGameGoal(goals2015_2016SunderlandAfcChelseaFcActualValue, goals2015_2016SunderlandAfcChelseaFcExpectedValue);

        ArrayList<Goal> goals2000_2001BradfordCityLeicesterCityActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2000-2001", "bradford-city", "leicester-city");
        Assert.assertEquals(null, goals2000_2001BradfordCityLeicesterCityActualValue);

        ArrayList<Goal> goals2000_2001LeedsUnitedEvertonFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2000-2001", "leeds-united", "everton-fc");
        List<Goal> goals2000_2001LeedsUnitedEvertonFcExpectedValue = goalsWorldFootBallValues.goals2000_2001LeedsUnitedEvertonFcExpectedValue();
        assertGameGoal(goals2000_2001LeedsUnitedEvertonFcActualValue, goals2000_2001LeedsUnitedEvertonFcExpectedValue);

        ArrayList<Goal> goals1998_1999ArsenalFcAstonVillaActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1998-1999", "arsenal-fc", "aston-villa");
        List<Goal> goals1998_1999ArsenalFcAstonVillaExpected = goalsWorldFootBallValues.getgoals1998_1999ArsenalFcAstonVillaExpected();
        assertGameGoal(goals1998_1999ArsenalFcAstonVillaActualValue, goals1998_1999ArsenalFcAstonVillaExpected);

        ArrayList<Goal> goals1996_1997ManchesterUnitedWestHamUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1996-1997", "manchester-united", "west-ham-united");
        List<Goal> goals1996_1997ManchesterUnitedWestHamUnitedExpected = goalsWorldFootBallValues.goals1996_1997ManchesterUnitedWestHamUnitedExpected();
        assertGameGoal(goals1996_1997ManchesterUnitedWestHamUnitedActualValue, goals1996_1997ManchesterUnitedWestHamUnitedExpected);

        ArrayList<Goal> goals1992_1993LiverpoolFcNottinghamForestActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1992-1993", "liverpool-fc", "nottingham-forest");
        Assert.assertEquals(null, goals1992_1993LiverpoolFcNottinghamForestActualValue);

        ArrayList<Goal> goals1992_1993ChelseaFcSheffieldUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1992-1993", "chelsea-fc", "sheffield-united");
        List<Goal> goals1992_1993ChelseaFcSheffieldUnitedExpected = goalsWorldFootBallValues.goals1992_1993ChelseaFcSheffieldUnitedExpected();
        assertGameGoal(goals1992_1993ChelseaFcSheffieldUnitedActualValue, goals1992_1993ChelseaFcSheffieldUnitedExpected);

        ArrayList<Goal> goals1983_1984TottenhamHotspurManchesterUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1983-1984", "tottenham-hotspur", "manchester-united");
        List<Goal> goals1983_1984TottenhamHotspurManchesterUnitedExpected = goalsWorldFootBallValues.goals1983_1984TottenhamHotspurManchesterUnitedExpected();
        assertGameGoal(goals1983_1984TottenhamHotspurManchesterUnitedActualValue, goals1983_1984TottenhamHotspurManchesterUnitedExpected);

        ArrayList<Goal> goals1976_1977LeedsUnitedCoventryCityActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1976-1977", "leeds-united", "coventry-city");
        List<Goal> goals1976_1977LeedsUnitedCoventryCityExpected = goalsWorldFootBallValues.goals1976_1977LeedsUnitedCoventryCityExpected();
        assertGameGoal(goals1976_1977LeedsUnitedCoventryCityActualValue, goals1976_1977LeedsUnitedCoventryCityExpected);

        ArrayList<Goal> goals1963_1964SheffieldUnitedBurnleyFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1963-1964", "sheffield-united", "burnley-fc");
        List<Goal> goals1963_1964SheffieldUnitedBurnleyFcExpected = goalsWorldFootBallValues.goals1963_1964SheffieldUnitedBurnleyFcExpected();
        assertGameGoal(goals1963_1964SheffieldUnitedBurnleyFcActualValue, goals1963_1964SheffieldUnitedBurnleyFcExpected);

        ArrayList<Goal> goals1956_1957SheffieldWednesdayChelseaFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "sheffield-wednesday", "chelsea-fc");
        List<Goal> goals1956_1957SheffieldWednesdayChelseaFcExpectedValue = goalsWorldFootBallValues.goals1956_1957SheffieldWednesdayChelseaFcExpectedValue();
        assertGameGoal(goals1956_1957SheffieldWednesdayChelseaFcActualValue, goals1956_1957SheffieldWednesdayChelseaFcExpectedValue);

        ArrayList<Goal> goals1956_1957TottenhamHotspurLeedsUnitedActualVlaue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "tottenham-hotspur", "leeds-united");
        List<Goal> goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue = goalsWorldFootBallValues.goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue();
        assertGameGoal(goals1956_1957TottenhamHotspurLeedsUnitedActualVlaue, goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue);

        ArrayList<Goal> goalsActualValueoldGoalZeroToZero = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "aston-villa", "west-bromwich-albion");
        Assert.assertEquals(null, goalsActualValueoldGoalZeroToZero);

        ArrayList<Goal> goals1946_1947LeedsUnitedSunderlandAfcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1946-1947", "leeds-united", "sunderland-afc");
        List<Goal> goals1946_1947LeedsUnitedSunderlandAfcExpected = goalsWorldFootBallValues.goals1946_1947LeedsUnitedSunderlandAfcExpected();
        assertGameGoal(goals1946_1947LeedsUnitedSunderlandAfcActualValue, goals1946_1947LeedsUnitedSunderlandAfcExpected);


    }

    public void assertPlayersSummaryInTeam(ArrayList<PlayerSummary> playersClubActualValue, List<PlayerSummary> playersInClubExpectedValue, List<Integer> playersIds) {
        for (int i = 0; i < playersInClubExpectedValue.size(); i++) {
            assertThat(playersInClubExpectedValue.get(i)).usingRecursiveComparison().isEqualTo(playersClubActualValue.get(playersIds.get(i)));
        }
    }

    @Test
    public void itShouldGetPlayersSummuryInTeam() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<PlayerSummary> playersManchesterUnited2015ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "2015");
        List<PlayerSummary> playersManchesterUnited2015Expected = playersInTeamsValues.playersManchesterUnited2015Expected();
        List<Integer> playersIdManchesterUnited2015 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
                , 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34);
        assertPlayersSummaryInTeam(playersManchesterUnited2015ActualValue, playersManchesterUnited2015Expected, playersIdManchesterUnited2015);

        ArrayList<PlayerSummary> playersManchesterUnited2001ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "2001");
        List<Integer> playersIdManchesterUnited2001 = Arrays.asList(0, 3, 4, 8, 15, 32, 38, 39);
        List<PlayerSummary> playersManchesterUnited2001Expected = playersInTeamsValues.playersManchesterUnited2001Expected();
        assertPlayersSummaryInTeam(playersManchesterUnited2001ActualValue, playersManchesterUnited2001Expected, playersIdManchesterUnited2001);

        ArrayList<PlayerSummary> playersManchesterUnited1991ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1991");
        List<Integer> playersIdManchesterUnited1991 = Arrays.asList(0, 3, 4, 8, 15, 23, 29);
        List<PlayerSummary> playersManchesterUnited1991Expected = playersInTeamsValues.playersManchesterUnited1991Expected();
        assertPlayersSummaryInTeam(playersManchesterUnited1991ActualValue, playersManchesterUnited1991Expected, playersIdManchesterUnited1991);

        ArrayList<PlayerSummary> playersManchesterUnited1970ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1970");
        List<Integer> playersIdManchesterUnited1970 = Arrays.asList(0, 2, 11, 17, 18, 24, 26);
        List<PlayerSummary> playersManchesterUnited1970Expected = playersInTeamsValues.playersManchesterUnited1970Expected();
        assertPlayersSummaryInTeam(playersManchesterUnited1970ActualValue, playersManchesterUnited1970Expected, playersIdManchesterUnited1970);

        ArrayList<PlayerSummary> manchesterUnitedActualValueplayers1966 = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1966");
        List<Integer> playersIdManchesterUnited1966 = Arrays.asList(0, 4, 12);
        List<PlayerSummary> playersManchesterUnited1966Expected = playersInTeamsValues.playersManchesterUnited1966Expected();
        assertPlayersSummaryInTeam(manchesterUnitedActualValueplayers1966, playersManchesterUnited1966Expected, playersIdManchesterUnited1966);

        ArrayList<PlayerSummary> playersManchesterUnited1950ActualValue = screenScraperUnderTest.getAllPlayersSummaryInClub("manchester-united", "1950");
        List<Integer> playersIdManchesterUnited1950 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27);
        List<PlayerSummary> playersManchesterUnited1950Expected = playersInTeamsValues.playersManchesterUnited1950Expected();
        assertPlayersSummaryInTeam(playersManchesterUnited1950ActualValue, playersManchesterUnited1950Expected, playersIdManchesterUnited1950);

        ArrayList<PlayerSummary> playersManchesterUnited1890ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1890");
        List<Integer> playersIdManchesterUnited1890 = Arrays.asList(0, 1, 2, 3, 4);
        List<PlayerSummary> playersManchesterUnited1890Expected = playersInTeamsValues.playersManchesterUnited1890Expected();
        assertPlayersSummaryInTeam(playersManchesterUnited1890ActualValue, playersManchesterUnited1890Expected, playersIdManchesterUnited1890);

        ArrayList<PlayerSummary> playersAccrington1890ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("Accrington", "1890");
        Assert.assertEquals(null, playersAccrington1890ActualValue);

    }


    public void assertClubsInSeason(ArrayList<Club> clubsInSeasonActualValue, List<Club> clubsInSeasonExpectedValue, List<Integer> clubsIdSeason) {
        for (int i = 0; i < clubsInSeasonExpectedValue.size(); i++) {
            assertThat(clubsInSeasonActualValue.get(i)).usingRecursiveComparison().isEqualTo(clubsInSeasonExpectedValue.get(clubsIdSeason.get(i)));
        }
    }

    @Test
    public void itShouldGetClubsInSeason() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<Club> clubsAt2015_2016ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("eng-premier-league", "2015-2016");
        List<Integer> clubsIdAtSeason2015_2016 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
        List<Club> clubsAt2015_2016Expected = clubsWorldFootballClubsValues.clubsAt2015_2016Expected();
        assertClubsInSeason(clubsAt2015_2016ActualValue, clubsAt2015_2016Expected, clubsIdAtSeason2015_2016);

        ArrayList<Club> clubsAt1967_1968ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("eng-premier-league", "1967-1968");
        List<Integer> clubsIdAtSeason1967_1968 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21);
        List<Club> clubsAt1967_1968Expected = clubsWorldFootballClubsValues.clubsAt1967_1968Expected();
        assertClubsInSeason(clubsAt1967_1968ActualValue, clubsAt1967_1968Expected, clubsIdAtSeason1967_1968);

        ArrayList<Club> clubsAt1889_1890ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("eng-premier-league", "1889-1890");
        List<Integer> clubsIdAtSeason1890_1891 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        List<Club> clubsAt1889_1890Expected = clubsWorldFootballClubsValues.clubsAt1889_1890Expected();
        assertClubsInSeason(clubsAt1889_1890ActualValue, clubsAt1889_1890Expected, clubsIdAtSeason1890_1891);

    }


    public void assertPlayerInformationWithIndexes(PlayerAllInformation actualValue, List<WorldFootBallAttributeFor_TEST> attributeList, PlayerAllInformation expectedValue) {

        for (int i = 0; i < attributeList.size(); i++) {
            int limit;
            if (attributeList.get(i).attributeName.equals("personalInfo")) {
                assertThat(actualValue.personalInfo).usingRecursiveComparison().isEqualTo(expectedValue.personalInfo);
            } else if (attributeList.get(i).attributeName.equals("teamsManaged")) {
                if (expectedValue.teamsManaged == null) {
                    Assert.assertEquals(null, actualValue.teamsManaged);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.teamsManaged.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.teamsManaged.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.teamsManaged.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("clubsCareer")) {
                if (expectedValue.clubsCareer == null) {
                    Assert.assertEquals(null, actualValue.clubsCareer);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.clubsCareer.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.clubsCareer.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.clubsCareer.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("clubMatches")) {
                if (expectedValue.clubMatches == null) {
                    Assert.assertEquals(null, actualValue.clubMatches);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.clubMatches.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.clubMatches.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.clubMatches.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("internationalCopmetitionsInfo")) {
                if (expectedValue.internationalCopmetitionsInfo == null) {
                    Assert.assertEquals(null, actualValue.internationalCopmetitionsInfo);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.internationalCopmetitionsInfo.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.internationalCopmetitionsInfo.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.internationalCopmetitionsInfo.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("clubsMatchesOverall")) {
                if (expectedValue.clubsMatchesOverall == null) {
                    Assert.assertEquals(null, actualValue.clubsMatchesOverall);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.clubsMatchesOverall.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        //assertThat(playerInfoActualValue.clubsMatchesOverall).contains(playerInfoExpectedValue.clubsMatchesOverall.get(j));
                        assertThat(actualValue.clubsMatchesOverall.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.clubsMatchesOverall.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("internationalCopmetitionsOverall")) {
                if (expectedValue.internationalCopmetitionsOverall == null) {
                    Assert.assertEquals(null, actualValue.internationalCopmetitionsOverall);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.internationalCopmetitionsOverall.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.internationalCopmetitionsOverall.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.internationalCopmetitionsOverall.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("internationalCopmetitionsOverall")) {
                if (expectedValue.internationalCopmetitionsOverall == null) {
                    Assert.assertEquals(null, actualValue.internationalCopmetitionsOverall);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.internationalCopmetitionsOverall.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.internationalCopmetitionsOverall.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.internationalCopmetitionsOverall.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("internationalCopmetitionsOverall")) {
                if (expectedValue.internationalCopmetitionsOverall == null) {
                    Assert.assertEquals(null, actualValue.internationalCopmetitionsOverall);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.internationalCopmetitionsOverall.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.internationalCopmetitionsOverall.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.internationalCopmetitionsOverall.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("recordReferee")) {
                if (expectedValue.recordReferee == null) {
                    Assert.assertEquals(null, actualValue.recordReferee);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.recordReferee.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.recordReferee.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.recordReferee.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("recordOpponent")) {
                if (expectedValue.recordOpponent == null) {
                    Assert.assertEquals(null, actualValue.recordOpponent);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.recordOpponent.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.recordOpponent.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.recordOpponent.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("forEachCompetitionInformationOverallsClubs")) {
                if (expectedValue.forEachCompetitionInformationOverallsClubs == null) {
                    Assert.assertEquals(null, actualValue.forEachCompetitionInformationOverallsClubs);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.forEachCompetitionInformationOverallsClubs.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.forEachCompetitionInformationOverallsClubs.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.forEachCompetitionInformationOverallsClubs.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("forEachCompetitionInformationOverallsInternational")) {
                if (expectedValue.forEachCompetitionInformationOverallsInternational == null) {
                    Assert.assertEquals(null, actualValue.forEachCompetitionInformationOverallsInternational);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.forEachCompetitionInformationOverallsInternational.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.forEachCompetitionInformationOverallsInternational.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.forEachCompetitionInformationOverallsInternational.get(j));
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
        PlayerAllInformation player1ExpectedValueInfo = playersInformationWorldFootballValue.getEricBaillyInformation();
        List<WorldFootBallAttributeFor_TEST> player1AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("teamsManaged"),
                new WorldFootBallAttributeFor_TEST("clubsCareer"),
                new WorldFootBallAttributeFor_TEST("clubMatches"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo"),
                new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsOverall"),
                new WorldFootBallAttributeFor_TEST("recordOpponent", new ArrayList<>(Arrays.asList(0, 7, 19, 20, 40, 60, 80, 100, 109))),
                new WorldFootBallAttributeFor_TEST("recordReferee", new ArrayList<>(Arrays.asList(0, 20, 41, 61, 81, 100, 106))),
                new WorldFootBallAttributeFor_TEST("forEachCompetitionInformationOverallsClubs", new ArrayList<>(Arrays.asList(2, 3)))));
        assertPlayerInformationWithIndexes(player1ActualValueInfo, player1AttributeList, player1ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/tony-adams/
        PlayerAllInformation player2ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("tony-adams");
        PlayerAllInformation player2ExpectedValueInfo = playersInformationWorldFootballValue.getTonyAdamsInformation();
        List<WorldFootBallAttributeFor_TEST> player2AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("teamsManaged"),
                new WorldFootBallAttributeFor_TEST("clubsCareer"),
                new WorldFootBallAttributeFor_TEST("clubMatches"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo"),
                new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsOverall"),
                new WorldFootBallAttributeFor_TEST("recordOpponent", new ArrayList<>(Arrays.asList(0, 20, 40, 60, 80, 100, 106))),
                new WorldFootBallAttributeFor_TEST("recordReferee", new ArrayList<>(Arrays.asList(0, 140, 148)))));
        assertPlayerInformationWithIndexes(player2ActualValueInfo, player2AttributeList, player2ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/walter-aitkenhead/
        PlayerAllInformation player3ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("walter-aitkenhead");
        PlayerAllInformation player3ExpectedValueInfo = playersInformationWorldFootballValue.getWwalterAitkenhead();
        List<WorldFootBallAttributeFor_TEST> player3AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("teamsManaged"),
                new WorldFootBallAttributeFor_TEST("clubsCareer"),
                new WorldFootBallAttributeFor_TEST("clubMatches"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo"),
                new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsOverall"),
                new WorldFootBallAttributeFor_TEST("recordOpponent"),
                new WorldFootBallAttributeFor_TEST("recordReferee")));
        assertPlayerInformationWithIndexes(player3ActualValueInfo, player3AttributeList, player3ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/sam-johnstone/
        PlayerAllInformation player4ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("sam-johnstone");
        PlayerAllInformation player4ExpectedValueInfo = playersInformationWorldFootballValue.getSamJohnstone();
        List<WorldFootBallAttributeFor_TEST> player4AttributesToTest = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("clubsCareer", new ArrayList<Integer>(Arrays.asList(1, 5))),
                new WorldFootBallAttributeFor_TEST("clubMatches", new ArrayList<Integer>(Arrays.asList(0, 3, 6)))));
        assertPlayerInformationWithIndexes(player4ActualValueInfo, player4AttributesToTest, player4ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/george-timmins/
        PlayerAllInformation player5ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("george-timmins");
        PlayerAllInformation player5ExpectedValueInfo = playersInformationWorldFootballValue.getGeorgeTimmins();
        List<WorldFootBallAttributeFor_TEST> player5AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("clubsCareer"),
                new WorldFootBallAttributeFor_TEST("clubMatches"),
                new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo")));
        assertPlayerInformationWithIndexes(player5ActualValueInfo, player5AttributeList, player5ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/che-adams/
        PlayerAllInformation player6ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("che-adams");
        PlayerAllInformation player6ExpectedValueInfo = playersInformationWorldFootballValue.getCheAdams();
        List<WorldFootBallAttributeFor_TEST> player6AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("teamManaged")));
        assertPlayerInformationWithIndexes(player6ActualValueInfo, player6AttributeList, player6ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/adam-carson/
        PlayerAllInformation player7ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("adam-carson");
        PlayerAllInformation player7ExpectedValueInfo = playersInformationWorldFootballValue.getAdamCarson();
        List<WorldFootBallAttributeFor_TEST> player7AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("teamManaged")));
        assertPlayerInformationWithIndexes(player7ActualValueInfo, player7AttributeList, player7ExpectedValueInfo);

    }

    public void assertMatches(MatchDetails actualValue, List<WorldFootBallAttributeFor_TEST> attributes, MatchDetails expectedValue) {
        int limit;
        for (int i = 0; i < attributes.size(); i++) {
            if (attributes.get(i).attributeName.equals("staduim")) {
                assertThat(actualValue.staduim).isEqualTo(expectedValue.staduim);
            } else if (attributes.get(i).attributeName.equals("attendance")) {
                assertThat(actualValue.attendance).isEqualTo(expectedValue.attendance);
            } else if (attributes.get(i).attributeName.equals("matchSummary")) {
                assertThat(actualValue.matchSummary).usingRecursiveComparison().isEqualTo(expectedValue.matchSummary);
            } else if (attributes.get(i).attributeName.equals("goals")) {
                if (expectedValue.goals == null) {
                    Assert.assertEquals(null, actualValue.goals);
                } else {
                    limit = (attributes.get(i).indexes.isEmpty()) ? actualValue.goals.size() : attributes.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributes.get(i).indexes.isEmpty()) ? j : attributes.get(i).indexes.get(j);
                        assertThat(actualValue.goals.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.goals.get(j));
                        j++;
                    }
                }
            } else if (attributes.get(i).attributeName.equals("firstClub")) {
                Assert.assertEquals(expectedValue.firstClub.manager, actualValue.firstClub.manager);
                Assert.assertEquals(expectedValue.firstClub.clubBasicInfo.name, actualValue.firstClub.clubBasicInfo.name);
                limit = (attributes.get(i).indexes.isEmpty()) ? actualValue.firstClub.players.size() : attributes.get(i).indexes.size();
                int j = 0;
                while (j < limit) {
                    int index = (attributes.get(i).indexes.isEmpty()) ? j : attributes.get(i).indexes.get(j);
                    assertThat(actualValue.firstClub.players.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.firstClub.players.get(j));
                    //Assertions.assertThat(actualValue.firstClub.players).contains(expectedValue.firstClub.players.get(j),atIndex(index)) ;
                    j++;
                }
            } else if (attributes.get(i).attributeName.equals("secondClub")) {
                Assert.assertEquals(expectedValue.secondClub.manager, actualValue.secondClub.manager);
                Assert.assertEquals(expectedValue.secondClub.clubBasicInfo.name, actualValue.secondClub.clubBasicInfo.name);
                limit = (attributes.get(i).indexes.isEmpty()) ? actualValue.secondClub.players.size() : attributes.get(i).indexes.size();
                int j = 0;
                while (j < limit) {
                    int index = (attributes.get(i).indexes.isEmpty()) ? j : attributes.get(i).indexes.get(j);
                    assertThat(actualValue.secondClub.players.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.secondClub.players.get(j));
                    j++;
                }
            } else if (attributes.get(i).attributeName.equals("referees")) {
                if (expectedValue.referees == null) {
                    Assert.assertEquals(null, actualValue.referees);
                } else {
                    limit = (attributes.get(i).indexes.isEmpty()) ? actualValue.referees.size() : attributes.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributes.get(i).indexes.isEmpty()) ? j : attributes.get(i).indexes.get(j);
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
        MatchDetails match1ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2019_2020BrightonHoveAlbionEvertonFc();
        List<WorldFootBallAttributeFor_TEST> match1Attributes = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("firstClub"),
                new WorldFootBallAttributeFor_TEST("secondClub"),
                new WorldFootBallAttributeFor_TEST("staduim"),
                new WorldFootBallAttributeFor_TEST("attendance"),
                new WorldFootBallAttributeFor_TEST("goals"),
                new WorldFootBallAttributeFor_TEST("referees"),
                new WorldFootBallAttributeFor_TEST("matchSummary")));

        ComparePlayerNames playerComparator = new ComparePlayerNames();
        Collections.sort(match1ActualValue.firstClub.players, playerComparator);
        Collections.sort(match1ActualValue.secondClub.players, playerComparator);
        Collections.sort(match1ExpectedValue.firstClub.players, playerComparator);
        Collections.sort(match1ExpectedValue.secondClub.players, playerComparator);
        assertMatches(match1ActualValue, match1Attributes, match1ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-1946-1947-brentford-fc-middlesbrough-fc/
        MatchDetails match2ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "1946-1947", "brentford-fc", "middlesbrough-fc");
        MatchDetails match2ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame1946_1947BrentfordFcMiddlesbroughFc();
        Collections.sort(match2ActualValue.firstClub.players, playerComparator);
        Collections.sort(match2ActualValue.secondClub.players, playerComparator);
        Collections.sort(match2ExpectedValue.firstClub.players, playerComparator);
        Collections.sort(match2ExpectedValue.secondClub.players, playerComparator);
        List<WorldFootBallAttributeFor_TEST> match2Attributes = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("firstClub"),
                new WorldFootBallAttributeFor_TEST("secondClub"),
                new WorldFootBallAttributeFor_TEST("staduim"),
                new WorldFootBallAttributeFor_TEST("attendance"),
                new WorldFootBallAttributeFor_TEST("goals"),
                new WorldFootBallAttributeFor_TEST("referees"),
                new WorldFootBallAttributeFor_TEST("matchSummary")));
        assertMatches(match2ActualValue, match2Attributes, match2ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-2020-2021-leeds-united-burnley-fc/
        MatchDetails match3ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "Leeds-United", "Burnley-FC");
        MatchDetails match3ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2020_2021LeedsUnitdBurnleyFc();
        List<WorldFootBallAttributeFor_TEST> match3Attributes = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("goals")));
        assertMatches(match3ActualValue, match3Attributes, match3ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-2020-2021-sheffield-united-everton-fc/
        MatchDetails match4ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "sheffield-united", "everton-fc");
        MatchDetails match4ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2020_2021SheffieldUnitdEvertonFc();
        List<WorldFootBallAttributeFor_TEST> match4Attributes = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("goals")));
        assertMatches(match4ActualValue, match4Attributes, match4ExpectedValue);

    }

    public void assertClubTransfer(ClubTransferTable actualValue, List<WorldFootBallAttributeFor_TEST> tables, ClubTransferTable expectedValue) {
        assertThat(actualValue.clubBasicInfo).usingRecursiveComparison().isEqualTo(expectedValue.clubBasicInfo);
        assertThat(actualValue.season).isEqualTo(expectedValue.season);
        for (int i = 0; i < tables.size(); i++) {
            int limit;
            if (tables.get(i).attributeName.equals("in")) {
                if (expectedValue.intable == null) {
                    Assert.assertEquals(null, actualValue.intable);
                } else {
                    limit = (tables.get(i).indexes.isEmpty()) ? Math.max(actualValue.intable.size(), expectedValue.intable.size()) : tables.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (tables.get(i).indexes.isEmpty()) ? index = j : tables.get(i).indexes.get(j);
                        assertThat(actualValue.intable.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.intable.get(j));
                        j++;
                    }
                }
            } else {
                if (expectedValue.outtable == null) {
                    Assert.assertEquals(null, actualValue.outtable);
                } else {
                    limit = (tables.get(i).indexes.isEmpty()) ? Math.max(actualValue.outtable.size(), expectedValue.outtable.size()) : tables.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (tables.get(i).indexes.isEmpty()) ? index = j : tables.get(i).indexes.get(j);
                        assertThat(actualValue.outtable.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.outtable.get(j));
                        j++;
                    }
                }
            }
        }
    }

    @Test
    public void itShouldGetTransferTable() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<ClubTransferTable> transferTableActualValue2015_2016 = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier-league", "2015-2016");
        ClubTransferTable astonVillaTransferTable2015_2016ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTableActualValue2015_2016, "Aston Villa");
        ClubTransferTable AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForAstonVilla2015_2016();
        List<WorldFootBallAttributeFor_TEST> astonVilla2015_2016AtrribuTests = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("in", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4))),
                new WorldFootBallAttributeFor_TEST("out", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4)))));
        assertClubTransfer(astonVillaTransferTable2015_2016ActualValue, astonVilla2015_2016AtrribuTests, AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue);

        ArrayList<ClubTransferTable> transferTable1889_1890ActualValue = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier-league", "1889-1890");
        ClubTransferTable astonVillaTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Aston Villa");
        ClubTransferTable astonVillatransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForAstonVilla1889_1890();
        List<WorldFootBallAttributeFor_TEST> astonVilla1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("in", new ArrayList<Integer>(Arrays.asList())),
                new WorldFootBallAttributeFor_TEST("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(astonVillaTransferTable1889_1890ActualValue, astonVilla1889_1890AtrribuTests, astonVillatransferTable1889_1890ExpectedValue);

        ClubTransferTable accringtonFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Accrington FC");
        ClubTransferTable accringtonFCtransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForAccringtonFC1889_1890();
        List<WorldFootBallAttributeFor_TEST> accrington1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("in", new ArrayList<Integer>(Arrays.asList())),
                new WorldFootBallAttributeFor_TEST("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(accringtonFCTransferTable1889_1890ActualValue, accrington1889_1890AtrribuTests, accringtonFCtransferTable1889_1890ExpectedValue);

        ClubTransferTable derbyCountyTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Derby County");
        ClubTransferTable derbyCountytransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForDerbyCounty1889_1890();
        List<WorldFootBallAttributeFor_TEST> derbyCounty1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("in", new ArrayList<Integer>(Arrays.asList())),
                new WorldFootBallAttributeFor_TEST("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(derbyCountyTransferTable1889_1890ActualValue, derbyCounty1889_1890AtrribuTests, derbyCountytransferTable1889_1890ExpectedValue);

        ClubTransferTable burnleyFCTransferTable1889_1890ActualValue = new ClubTransferTable();
        burnleyFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Burnley FC");
        ClubTransferTable burnleyFCtransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForburnleyFCTransferTable1889_1890();
        List<WorldFootBallAttributeFor_TEST> burnleyFC1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("in", new ArrayList<Integer>(Arrays.asList())),
                new WorldFootBallAttributeFor_TEST("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(burnleyFCTransferTable1889_1890ActualValue, burnleyFC1889_1890AtrribuTests, burnleyFCtransferTable1889_1890ExpectedValue);

    }

    @Test
    public void itShouldGetTopSoccer() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<PlayerTopSoccer> table2019_2020ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "2019-2020");
        ArrayList<PlayerTopSoccer> table2019_2020player0TO4ExpectedValue = topScoreWorldFootballValue.getTableTopScore2019_2020();
        List<Integer> indexes2019_2020From0To4 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        assertStatistics(table2019_2020ActualValue, indexes2019_2020From0To4, table2019_2020player0TO4ExpectedValue);

        ArrayList<PlayerTopSoccer> table2009_2010ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "2009-2010");
        ArrayList<PlayerTopSoccer> table2009_2010player4TO9ExpectedValue = topScoreWorldFootballValue.getTopScoreEnglishPreimerLeague2009_2010();
        List<Integer> indexes2019_2020From6To10 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));
        assertStatistics(table2009_2010ActualValue, indexes2019_2020From6To10, table2009_2010player4TO9ExpectedValue);

        ArrayList<PlayerTopSoccer> table1946_1947ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "1946-1947");
        ArrayList<PlayerTopSoccer> table1946_1947player0TO4ExpectedValue = topScoreWorldFootballValue.getTopScoreEngishPriemerLeague1946_1947();
        List<Integer> indexes1946_1947From0To4 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        assertStatistics(table1946_1947ActualValue, indexes1946_1947From0To4, table1946_1947player0TO4ExpectedValue);

    }

    public void assertStatistics(ArrayList<?> actualValue, List<Integer> indexes, ArrayList<?> expectedValue) {
        if (expectedValue == null) {
            Assert.assertEquals(null, actualValue);
        } else {
            int limit = ((indexes == null) || (indexes.isEmpty())) ? Math.max(actualValue.size(), expectedValue.size()) : indexes.size();
            int j = 0;
            while (j < limit) {
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
        ArrayList<StatisticsGoalsPerSeason> expectedValue0To9 = statisticsValues.getStatististicsGoslsPerSeasonEnglishPriemerLeague();
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        assertStatistics(actualValue, indexes, expectedValue0To9);

    }


    @Test
    public void itShouldGetStatisticsGoalsPerRound() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsGoalsPerRound> actualValue = screenScraperUnderTest.getStatisticsGoalsPerRound("eng-premier-league");
        ArrayList<StatisticsGoalsPerRound> expectedlValue0To4 = statisticsValues.getStatisticsGoalsPerRoundEnglishPreimerLeague();
        CompareStatisticsGoalsPerRound roundComparator = new CompareStatisticsGoalsPerRound();
        Collections.sort(actualValue, roundComparator);
        Collections.sort(expectedlValue0To4, roundComparator);
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        assertStatistics(actualValue, indexes, expectedlValue0To4);

    }

    @Test
    public void itShouldGetStatisticsRecordWins() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue = screenScraperUnderTest.getStatisticsRecordWinsOrMostGoalInGame("eng-premier-league", StatisticsRequestKind.RecordWins);
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> expectedValue0To9 = statisticsValues.getStatisticsEnglishPreimerLeagueRecoedWin();
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        assertStatistics(actualValue, indexes, expectedValue0To9);
    }

    @Test
    public void itShouldGetStatisticsMostGoalInGame() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue = new ArrayList<>();
        actualValue = screenScraperUnderTest.getStatisticsRecordWinsOrMostGoalInGame("eng-premier-league", StatisticsRequestKind.MostGoalInGame);
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> expectedValue0To9 = statisticsValues.getStatisticsEnglishPreimerLeagueMostGoalInGame();
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        assertStatistics(actualValue, indexes, expectedValue0To9);

    }

    @Test
    public void itShouldGetStatisticsDirtiesGamesForCompetition() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<DirtyGame> actualValue = screenScraperUnderTest.getStatisticsDirtiesGamesForCompetition("eng-premier-league");
        ArrayList<DirtyGame> expectedValue0To9 = statisticsValues.getStatisticsEnglishPreimerLeageDirtiesGame();
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertStatistics(actualValue, indexes, expectedValue0To9);

    }

    @Test
    public void itShouldGetStatisticsBestPlayerInYear() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsBestPlayerInYear> actualValue = screenScraperUnderTest.getStatisticsBestPlayerInYear("england");
        ArrayList<StatisticsBestPlayerInYear> expectedValue0To9 = statisticsValues.getStatisticsEnglishPreimerLeagueBestPlayerInYear();
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertStatistics(actualValue, indexes, expectedValue0To9);
    }

    @Test
    public void itShouldGetAllClubStaduimsForCompetition() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<Staduim> actualValueEnglandPremierLeague2020_2021 = screenScraperUnderTest.getCompetitionStadiums("eng-premier-league", "2020-2021");
        ArrayList<Staduim> expectedValueEnglndPreimerLeague2020_2021Just0To5 = staduimsWorldDootballValues.getEnglishPreimerLeagueStaduim2020_2021();
        List<Integer> indexesEnglandPremierLeague2020_2021 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        assertStatistics(actualValueEnglandPremierLeague2020_2021, indexesEnglandPremierLeague2020_2021, expectedValueEnglndPreimerLeague2020_2021Just0To5);

        ArrayList<Staduim> actualValueEnglandChampionship1950_1951 = screenScraperUnderTest.getCompetitionStadiums("eng-championship", "1950-1951");
        ArrayList<Staduim> expectedValue1950_1951Just0To5 = null;
        assertStatistics(actualValueEnglandChampionship1950_1951, null, expectedValue1950_1951Just0To5);

    }

    @Test
    public void itShouldGetMostGoalsByPlayerPerGame() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsMostGoalsByPlayerPerGame> engPremierLeagueActualValue = screenScraperUnderTest.getStatisticsMostGoalsByPlayerInGameInCompetition("eng-premier-league");
        ArrayList<StatisticsMostGoalsByPlayerPerGame> engPremierLeagueExpectedValue = statisticsValues.getStatisticEnglishPreimerLeagueMostGoalPerPlayerInGame();
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 22));
        assertStatistics(engPremierLeagueActualValue, indexes, engPremierLeagueExpectedValue);

    }

    @Test
    public void itShouldGetTopScoreForCompetitionAllYears() {
        ScreenScraper screenScraperTest = new ScreenScraper();
        ArrayList<PlayerTopScoreForSeason> engPreimerLeagueactualValue = screenScraperTest.getTopSoccerForCompetitionAllYears("eng-premier-league");
        ArrayList<PlayerTopScoreForSeason> engPreimerLeagueexpectedValue = topScoreWorldFootballValue.getTopScoerForEnglishPreimerLeagueAllYears();
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 9));
        assertStatistics(engPreimerLeagueactualValue, indexes, engPreimerLeagueexpectedValue);
    }

    void assertSofaScoreGamesIdInRound(RoundGamesID actualValue, List<Integer> indexes, ArrayList<GameID> expectedValue, int expectedGamesNumberInRound) {

        int limit = (indexes == null || indexes.size() == 0) ? expectedGamesNumberInRound : indexes.size();
        int i = 0;
        while (i < limit) {
            int index = (indexes == null || indexes.size() == 0) ? i : indexes.get(i);
            //System.out.println("Sofa Id " + i);
            assertThat(actualValue.events.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.get(i));
            i++;
        }
    }

    @Test
    public void itShouldgetGamesIDInRound() {
        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();

        RoundGamesID gamesIdActualValueEnglishPreimerLeague19_20Round3 = sofaScoreCollectorTest.getGamesIdInRound("Premier League", "19/20", "3");
        ArrayList<GameID> gamesIdExpectedValueEnglishPreimerLeague19_20Round3 = gameIDInRoundSofaScoreValues.getEnglishPreimerLeague19_20Round3();
        assertSofaScoreGamesIdInRound(gamesIdActualValueEnglishPreimerLeague19_20Round3, null, gamesIdExpectedValueEnglishPreimerLeague19_20Round3, 10);

        //wrong IDs in google document (preimer league)
        RoundGamesID gamesIdActualValueEnglishPreimerLeague18_19Round5 = sofaScoreCollectorTest.getGamesIdInRound("Premier League", "18/19", "5");
        ArrayList<GameID> gamesIdExpectedValueEnglishPreimerLeague18_19Round5 = gameIDInRoundSofaScoreValues.getEnglishPreimerLeague18_19Round5();
        assertSofaScoreGamesIdInRound(gamesIdActualValueEnglishPreimerLeague18_19Round5, null, gamesIdExpectedValueEnglishPreimerLeague18_19Round5, 10);

    }

    public void assertGameStatisticsSofaScore(GameStatistic actualValue) {
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

    @Test
    public void itShouldGetGameIencidentsSofaScore() {
        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
        ArrayList<GameIencidents> game1Atround3At19_20IencidentsActualValue = sofaScoreCollectorTest.getGameIencidents("Premier League", "19/20", "3", 0);

        System.out.println("##########################################################");
        System.out.println("##########################################################");
        System.out.println("\n  \n \n");
        for (int j = 0; j < game1Atround3At19_20IencidentsActualValue.size(); j++) {
            System.out.println(j + "    " + game1Atround3At19_20IencidentsActualValue.get(j));
        }
        System.out.println("size   " + game1Atround3At19_20IencidentsActualValue.size());
    }


}