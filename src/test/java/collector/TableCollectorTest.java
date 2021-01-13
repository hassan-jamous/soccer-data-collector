package collector;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import collector.testData.WorldFootballRankingTableValues;
import models.ClubForRankingTable;
import models.RankingTable;
import models.RankingTableRequest;
import testUtilities.AssertUtilities;

public class TableCollectorTest {
	
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();    
    WorldFootballRankingTableValues rankingTablesWorldFootballValues = new WorldFootballRankingTableValues();
    
    
    @Test
    public void itShouldGetLastRankingTableOfLeague() {
        
    	ScreenScraper screenScraperUnderTest = new ScreenScraper();
        
        RankingTable rankingTable1889_1890ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "1889-1890");
        List<ClubForRankingTable> rankingTable1889_1890Expected = rankingTablesWorldFootballValues.getLastRankingTableEnglishPreimerLeague1889_1890();
        List<Integer> clubsIdInRankingTable1889_1890 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTable1889_1890ActualValue.table, clubsIdInRankingTable1889_1890, rankingTable1889_1890Expected);
        
        RankingTable rankingTable1906_1907ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "1906-1907");
        List<Integer> clubsIdInRankingTable1906_1907 = Arrays.asList(0, 1, 2, 7, 11, 17);
        List<ClubForRankingTable> rankingTable1906_1907Expected = rankingTablesWorldFootballValues.getLastRankingTableEnglishPreimerLeague1906_1907();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTable1906_1907ActualValue.table, clubsIdInRankingTable1906_1907, rankingTable1906_1907Expected );
        Assert.assertEquals(20, rankingTable1906_1907ActualValue.table.size());
        
        RankingTable rankingTable1959_1960ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "1959-1960");
        List<Integer> clubsIdInRankingTable1959_1960 = Arrays.asList(1, 6, 20);
        List<ClubForRankingTable> rankingTable1960_1970Expected = rankingTablesWorldFootballValues.getLastRankingTableEnglishPreimerLeague1959_1960();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTable1959_1960ActualValue.table, clubsIdInRankingTable1959_1960 , rankingTable1960_1970Expected );
        Assert.assertEquals(22, rankingTable1959_1960ActualValue.table.size());
        
        RankingTable rankingTable2007_2008ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "2007-2008");
        List<Integer> clubsIdInRankingTable2007_2008 = Arrays.asList(0, 3, 11);
        List<ClubForRankingTable> rankingTable2007_2008Expected = rankingTablesWorldFootballValues.getLastRankingTableEnglishPreimerLeague2007_2008();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTable2007_2008ActualValue.table, clubsIdInRankingTable2007_2008, rankingTable2007_2008Expected);
        Assert.assertEquals(20, rankingTable2007_2008ActualValue.table.size());
        
        RankingTable rankingTable2017_2018ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "2017-2018");
        List<Integer> clubsIdInRankingTable2017_2018 = Arrays.asList(1, 5, 18);
        List<ClubForRankingTable> rankingTable2017_2018Expected = rankingTablesWorldFootballValues.getLastRankingTableEnglishPreimerLeague2017_2018();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTable2017_2018ActualValue.table,clubsIdInRankingTable2017_2018, rankingTable2017_2018Expected );
        Assert.assertEquals(20, rankingTable2017_2018ActualValue.table.size());

    }

    @Test
    public void itShouldGetRankingTableByRound() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        RankingTable rankingTable2012_2013ByRound14NormalActualValue = screenScraperUnderTest.getTableByRound("eng-premier-league", "2012-2013", "14", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable2012_2013Round14Normal = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
        List<ClubForRankingTable> rankingTable2012_2013NormalExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague2012_2013Round14NormalExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTable2012_2013ByRound14NormalActualValue.table, clubsIdInRankingTable2012_2013Round14Normal , rankingTable2012_2013NormalExpected );

        RankingTable rankingTable2018_2019Round21AwayActualValue = screenScraperUnderTest.getTableByRound("eng-premier-league", "2018-2019", "21", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable2018_2019Round21Away = Arrays.asList(0, 1, 17);
        List<ClubForRankingTable> rankingTable2018_2019Round21AwayExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague2018_2019Round21AwayExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTable2018_2019Round21AwayActualValue.table, clubsIdInRankingTable2018_2019Round21Away , rankingTable2018_2019Round21AwayExpected );
        Assert.assertEquals(20, rankingTable2018_2019Round21AwayActualValue.table.size());

        RankingTable rankingTableActualValue2013_2014ByRound27Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "2013-2014", "27", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable2013_2014Round27Home = Arrays.asList(0, 5);
        List<ClubForRankingTable> rankingTable2013_2014Round21HomeExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague2013_2014Round21HomeExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue2013_2014ByRound27Home.table,clubsIdInRankingTable2013_2014Round27Home, rankingTable2013_2014Round21HomeExpected);
        Assert.assertEquals(20, rankingTableActualValue2013_2014ByRound27Home.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable2000_2001Round11Normal = Arrays.asList(0, 4, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11NormalExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague2000_2001Round11NormalExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue2000_2001ByRound11Normal.table, clubsIdInRankingTable2000_2001Round11Normal , rankingTable2000_2001Round11NormalExpected);
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Normal.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable2000_2001Round11Away = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11AwayExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague2000_2001Round11AwayExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue2000_2001ByRound11Away.table, clubsIdInRankingTable2000_2001Round11Away, rankingTable2000_2001Round11AwayExpected);
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Away.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable2000_2001ByRound11Home = Arrays.asList(0, 1, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11HomeExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague2000_2001Round11HomeExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue2000_2001ByRound11Home.table, clubsIdInRankingTable2000_2001ByRound11Home , rankingTable2000_2001Round11HomeExpected);
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Home.table.size());

        RankingTable rankingTableActualValue1955_1956ByRound20Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1955-1956", "20", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1955_1956ByRound20Normal = Arrays.asList(0, 3, 10);
        List<ClubForRankingTable> rankingTable1955_1956Round20NormalExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague1955_1956Round20NormalExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue1955_1956ByRound20Normal.table,clubsIdInRankingTable1955_1956ByRound20Normal, rankingTable1955_1956Round20NormalExpected);
        Assert.assertEquals(22, rankingTableActualValue1955_1956ByRound20Normal.table.size());

        RankingTable rankingTableActualValue1977_1978ByRound37Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1977-1978", "37", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1977_1978ByRound37Away = Arrays.asList(0, 3, 10);
        List<ClubForRankingTable> rankingTable1977_1978Round37AwayExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague1977_1978Round37AwayExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue1977_1978ByRound37Away.table, clubsIdInRankingTable1977_1978ByRound37Away , rankingTable1977_1978Round37AwayExpected);
        Assert.assertEquals(22, rankingTableActualValue1977_1978ByRound37Away.table.size());

        RankingTable rankingTableActualValue1985_1986ByRound26Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1985-1986", "26", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1985_1986ByRound26Home = Arrays.asList(0, 1, 13);
        List<ClubForRankingTable> rankingTable1985_1986ByRound26HomeExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague1985_1986Round26HomeExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue1985_1986ByRound26Home.table,clubsIdInRankingTable1985_1986ByRound26Home , rankingTable1985_1986ByRound26HomeExpected);
        Assert.assertEquals(22, rankingTableActualValue1985_1986ByRound26Home.table.size());

        RankingTable rankingTableActualValue1948_1949ByRound27Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1948-1949", "27", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1948_1949ByRound27Normal = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1948_1949ByRound27HomeExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague1948_1949Round27HomeExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue1948_1949ByRound27Normal.table, clubsIdInRankingTable1948_1949ByRound27Normal , rankingTable1948_1949ByRound27HomeExpected);
        Assert.assertEquals(22, rankingTableActualValue1948_1949ByRound27Normal.table.size());

        RankingTable rankingTableActualValue1930_1931ByRound8Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1930-1931", "8", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1930_1931ByRound8Away = Arrays.asList(0, 21);
        List<ClubForRankingTable> rankingTable1930_1931ByRound8HomeExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague1930_1931Round8HomeExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue1930_1931ByRound8Away.table, clubsIdInRankingTable1930_1931ByRound8Away , rankingTable1930_1931ByRound8HomeExpected);
        Assert.assertEquals(22, rankingTableActualValue1930_1931ByRound8Away.table.size());

        RankingTable rankingTableActualValue1925_1926ByRound12Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1925-1926", "12", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1925_1926ByRound12Home = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1925_1926ByRound12HomeExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague1925_1926Round12HomeExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue1925_1926ByRound12Home.table, clubsIdInRankingTable1925_1926ByRound12Home , rankingTable1925_1926ByRound12HomeExpected);
        Assert.assertEquals(22, rankingTableActualValue1925_1926ByRound12Home.table.size());

        RankingTable rankingTableActualValue1898_1899ByRound18Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1898-1899", "18", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1898_1899ByRound18Normal = Arrays.asList(0, 5, 15);
        List<ClubForRankingTable> rankingTable1898_1899ByRound18NormalExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague1898_1898Round18NormalExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue1898_1899ByRound18Normal.table, clubsIdInRankingTable1898_1899ByRound18Normal ,rankingTable1898_1899ByRound18NormalExpected);
        Assert.assertEquals(18, rankingTableActualValue1898_1899ByRound18Normal.table.size());

        RankingTable rankingTableActualValue1888_1889ByRound10Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1888-1889", "10", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1888_1889ByRound10Away = Arrays.asList(0, 4, 10);
        List<ClubForRankingTable> rankingTable1888_1889ByRound10AwayExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague1888_1889Round10AwayExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue1888_1889ByRound10Away.table, clubsIdInRankingTable1888_1889ByRound10Away , rankingTable1888_1889ByRound10AwayExpected);
        Assert.assertEquals(12, rankingTableActualValue1888_1889ByRound10Away.table.size());

        RankingTable rankingTableActualValue1891_1892ByRound18Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1891-1892", "18", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1891_1892ByRound18Home = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1891_1892ByRound12HomeExpected = rankingTablesWorldFootballValues.getRankingTableEnglishPreimerLeague1891_1892Round12HomeExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(rankingTableActualValue1891_1892ByRound18Home.table, clubsIdInRankingTable1891_1892ByRound18Home , rankingTable1891_1892ByRound12HomeExpected);
        Assert.assertEquals(14, rankingTableActualValue1891_1892ByRound18Home.table.size());

    }

}