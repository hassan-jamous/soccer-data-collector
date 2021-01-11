package collector;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import models.ClubForRankingTable;
import models.RankingTable;
import models.RankingTableRequest;
import testValues.WorldFootballRankingTableValues;

public class WorldFootballRankingTableTest {

    WorldFootballRankingTableValues rankingTablesWorldFootballValues = new WorldFootballRankingTableValues();
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
}
