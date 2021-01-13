package worldfootball;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import worldfootball.testData.WorldFootballGamesInEnglishPreimerLeagueLeagueValues;
import worldfootball.models.Game;
import worldfootball.models.GamesTableOfLeague;
import testUtilities.AssertUtilities;

public class RoundCollectorTest  {

	WorldFootballGamesInEnglishPreimerLeagueLeagueValues gamesInTableworldFootballValues = new WorldFootballGamesInEnglishPreimerLeagueLeagueValues();
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();

	@Test
    public void itShouldGetGamesTableOfLeague() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        GamesTableOfLeague gamesTableActualValue2015_2016 = screenScraperUnderTest.getAllRounds("eng-premier-league", "2015-2016");
        List<Game> gamesInRound4At2015_2016 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague2015_2016Round4();
        List<Integer> gamesIdsInRound4At2015_2016 = Arrays.asList(0, 1, 8);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound4At2015_2016, gamesIdsInRound4At2015_2016, 4);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(3).games.size());
        List<Game> gamesInRound9At2015_2016 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague2015_2016Round9();
        List<Integer> gamesIdsInRound9At2015_2016 = Arrays.asList(0, 3, 8, 9);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound9At2015_2016, gamesIdsInRound9At2015_2016, 9);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(8).games.size());
        List<Game> gamesInRound14At2015_2016 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague2015_2016Round14();
        List<Integer> gamesIdsInRound14At2015_2016 = Arrays.asList(1, 5, 7, 8);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound14At2015_2016, gamesIdsInRound14At2015_2016, 14);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(13).games.size());
        List<Game> gamesInRound21At2015_2016 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague2015_2016Round21();
        List<Integer> gamesIdsInRound21At2015_2016 = Arrays.asList(0, 2, 9);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound21At2015_2016, gamesIdsInRound21At2015_2016, 21);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(20).games.size());
        List<Game> gamesInRound27At2015_2016 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague2015_2016Round27();
        List<Integer> gamesIdsInRound27At2015_2016 = Arrays.asList(6, 7, 9);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound27At2015_2016, gamesIdsInRound27At2015_2016, 27);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(26).games.size());
        List<Game> gamesInRound35At2015_2016 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague2015_2016Round35();
        List<Integer> gamesIdsInRound35At2015_2016 = Arrays.asList(0, 4, 8);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound35At2015_2016, gamesIdsInRound35At2015_2016, 35);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(34).games.size());
        Assert.assertEquals(38, gamesTableActualValue2015_2016.rounds.size());

        GamesTableOfLeague gamesTableActualValue2005_2006 = screenScraperUnderTest.getAllRounds("eng-premier-league", "2005-2006");
        List<Game> gamesInRound2At2005_2006 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague2005_2006Round2();
        List<Integer> gamesIdsInRound2At2005_2006 = Arrays.asList(0, 1, 6, 8);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound2At2005_2006, gamesIdsInRound2At2005_2006, 2);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(1).games.size());
        List<Game> gamesInRound12At2005_2006 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague2005_2006Round12();
        List<Integer> gamesIdsInRound12At2005_2006 = Arrays.asList(2, 6, 8);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound12At2005_2006, gamesIdsInRound12At2005_2006, 12);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(11).games.size());
        List<Game> gamesInRound20At2005_2006 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague2005_2006Round20();
        List<Integer> gamesIdsInRound20At2005_2006 = Arrays.asList(0, 3, 9);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound20At2005_2006, gamesIdsInRound20At2005_2006, 20);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(19).games.size());
        List<Game> gamesInRound32At2005_2006 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague2005_2006Round32();
        List<Integer> gamesIdsInRound32At2005_2006 = Arrays.asList(0, 1, 7, 9);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound32At2005_2006, gamesIdsInRound32At2005_2006, 32);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(31).games.size());
        Assert.assertEquals(38, gamesTableActualValue2005_2006.rounds.size());

        GamesTableOfLeague gamesTableActualValue1960_1961 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1960-1961");
        List<Game> gamesInRound1At1960_1961 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1960_1961Round1();
        List<Integer> gamesIdsInRound1At1960_1961 = Arrays.asList(0, 5, 8, 10);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound1At1960_1961, gamesIdsInRound1At1960_1961, 1);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(0).games.size());
        List<Game> gamesInRound4At1960_1961 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1960_1961Round4();
        List<Integer> gamesIdsInRound4At1960_1961 = Arrays.asList(1, 2, 3, 9);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound4At1960_1961, gamesIdsInRound4At1960_1961, 4);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(3).games.size());
        List<Game> gamesInRound16At1960_1961 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1960_1961Round16();
        List<Integer> gamesIdsInRound16At1960_1961 = Arrays.asList(0, 1, 9, 10);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound16At1960_1961, gamesIdsInRound16At1960_1961, 16);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(15).games.size());
        List<Game> gamesInRound27At1960_1961 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1960_1961Round27();
        List<Integer> gamesIdsInRound27At1960_1961 = Arrays.asList(2, 5, 8, 10);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound27At1960_1961, gamesIdsInRound27At1960_1961, 27);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(26).games.size());
        List<Game> gamesInRound36At1960_1961 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1960_1961Round36();
        List<Integer> gamesIdsInRound36At1960_1961 = Arrays.asList(0, 1, 7, 9);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound36At1960_1961, gamesIdsInRound36At1960_1961, 36);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(35).games.size());
        Assert.assertEquals(42, gamesTableActualValue1960_1961.rounds.size());

        GamesTableOfLeague gamesTableActualValue1925_1926 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1925-1926");
        List<Game> gamesInRound3At1925_1926 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1925_1926Round3();
        List<Integer> gamesIdsInRound3At1925_1926 = Arrays.asList(1, 3, 10);
        assertGameInRound(gamesTableActualValue1925_1926, gamesInRound3At1925_1926, gamesIdsInRound3At1925_1926, 3);
        Assert.assertEquals(11, gamesTableActualValue1925_1926.rounds.get(2).games.size());
        List<Game> gamesInRound35At1925_1926 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1925_1926Round35();
        List<Integer> gamesIdsInRound35At1925_1926 = Arrays.asList(0, 1, 5);
        assertGameInRound(gamesTableActualValue1925_1926, gamesInRound35At1925_1926, gamesIdsInRound35At1925_1926, 35);
        Assert.assertEquals(8, gamesTableActualValue1925_1926.rounds.get(34).games.size());
        List<Game> gamesInRound36At1925_1926 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1925_1926Round36();
        List<Integer> gamesIdsInRound36At1925_1926 = Arrays.asList(0, 2, 7, 11);
        assertGameInRound(gamesTableActualValue1925_1926, gamesInRound36At1925_1926, gamesIdsInRound36At1925_1926, 36);
        Assert.assertEquals(13, gamesTableActualValue1925_1926.rounds.get(35).games.size());
        Assert.assertEquals(42, gamesTableActualValue1925_1926.rounds.size());
        GamesTableOfLeague gamesTableActualValue1891_1892 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1891-1892");
        List<Game> gamesInRound1At1891_1892 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1891_1892Round1();
        List<Integer> gamesIdsInRound36At1891_1892 = Arrays.asList(1, 4, 6);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound1At1891_1892, gamesIdsInRound36At1891_1892, 1);
        Assert.assertEquals(7, gamesTableActualValue1891_1892.rounds.get(0).games.size());
        List<Game> gamesInRound6At1891_1892 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1891_1892Round6();
        List<Integer> gamesIdsInRound6At1891_1892 = Arrays.asList(1, 2, 5, 7);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound6At1891_1892, gamesIdsInRound6At1891_1892, 6);
        Assert.assertEquals(8, gamesTableActualValue1891_1892.rounds.get(5).games.size());
        List<Game> gamesInRound14At1891_1892 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1891_1892Round14();
        List<Integer> gamesIdsInRound14At1891_1892 = Arrays.asList(0, 1, 4, 6);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound14At1891_1892, gamesIdsInRound14At1891_1892, 14);
        Assert.assertEquals(7, gamesTableActualValue1891_1892.rounds.get(13).games.size());
        List<Game> gamesInRound23At1891_1892 = gamesInTableworldFootballValues.getGamesEnglishPriemerLeague1891_1892Round23();
        List<Integer> gamesIdsInRound23At1891_1892 = Arrays.asList(3, 4, 5);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound23At1891_1892, gamesIdsInRound23At1891_1892, 23);
        Assert.assertEquals(6, gamesTableActualValue1891_1892.rounds.get(22).games.size());
        Assert.assertEquals(26, gamesTableActualValue1891_1892.rounds.size());

        //this season starts with round 0,
        GamesTableOfLeague gamesTableActualValue1888_1889 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1888-1889");
        List<Game> gamesInRound2At1888_1889 = gamesInTableworldFootballValues.getGamesEnglishPreimerLeague1888_1889Round2();
        List<Integer> gamesIdsInRound2At1888_1889 = Arrays.asList(0, 1, 2, 3, 4, 5);
        assertGameInRound(gamesTableActualValue1888_1889, gamesInRound2At1888_1889, gamesIdsInRound2At1888_1889, 2 + 1);//this season starts with round 0
        Assert.assertEquals(6, gamesTableActualValue1888_1889.rounds.get(2).games.size());//this season starts with round 0
        Assert.assertEquals(23, gamesTableActualValue1888_1889.rounds.size());

    }
	private void assertGameInRound(GamesTableOfLeague actualValue, List<Game> expectedValue, List<Integer> gamesIndexes, int roundNumber) {
		assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.rounds.get(roundNumber-1).games , gamesIndexes , expectedValue);
        
    }
}