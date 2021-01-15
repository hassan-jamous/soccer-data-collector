package worldfootball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import worldfootball.testData.TopScoreAndTopScoreForCompetition;
import worldfootball.testData.TopScoreForCompetitionEveryYearValues;
import worldfootball.models.PlayerTopScoreForSeason;
import worldfootball.models.PlayerTopSoccerAtSeason;
import testUtilities.AssertUtilities;

public class TopScoreCollectorTest {

    AssertUtilities assertObjectArrayToArray = new AssertUtilities();
	TopScoreAndTopScoreForCompetition 	 topScoreForCompetitionAllYears = new TopScoreAndTopScoreForCompetition();
	TopScoreForCompetitionEveryYearValues topScoreEnglishPreimerLeagueEveryYear = new TopScoreForCompetitionEveryYearValues();
	
		@Test
	    public void itShouldGetTopScoreForCompetitionAllYears() {
	        ScreenScraper screenScraperTest = new ScreenScraper();
	        ArrayList<PlayerTopScoreForSeason> engPreimerLeagueactualValue = screenScraperTest.getTopSoccerForCompetitionAllYears("eng-premier-league");
	        ArrayList<PlayerTopScoreForSeason> engPreimerLeagueexpectedValue = topScoreForCompetitionAllYears.getTopScoerForEnglishPreimerLeagueAllYears();
	        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 9));
	        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(engPreimerLeagueactualValue, indexes, engPreimerLeagueexpectedValue);
	    }
	 
		@Test
	    public void itShouldGetTopSoccerForCompetitionAtOneSeason() {
	        ScreenScraper screenScraperUnderTest = new ScreenScraper();
	
	        ArrayList<PlayerTopSoccerAtSeason> table2019_2020ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "2019-2020");
	        ArrayList<PlayerTopSoccerAtSeason> table2019_2020player0TO4ExpectedValue = topScoreEnglishPreimerLeagueEveryYear.getTableTopScoreEnglishPriemerLeague2019_2020();
	        List<Integer> indexes2019_2020From0To4 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
	        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(table2019_2020ActualValue, indexes2019_2020From0To4, table2019_2020player0TO4ExpectedValue);
	
	        ArrayList<PlayerTopSoccerAtSeason> table2009_2010ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "2009-2010");
	        ArrayList<PlayerTopSoccerAtSeason> table2009_2010player4TO9ExpectedValue = topScoreEnglishPreimerLeagueEveryYear.getTopScoreEnglishPreimerLeague2009_2010();
	        List<Integer> indexes2019_2020From6To10 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));
	        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(table2009_2010ActualValue, indexes2019_2020From6To10, table2009_2010player4TO9ExpectedValue);
	
	        ArrayList<PlayerTopSoccerAtSeason> table1946_1947ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "1946-1947");
	        ArrayList<PlayerTopSoccerAtSeason> table1946_1947player0TO4ExpectedValue = topScoreEnglishPreimerLeagueEveryYear.getTopScoreEngishPriemerLeague1946_1947();
	        List<Integer> indexes1946_1947From0To4 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
	        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(table1946_1947ActualValue, indexes1946_1947From0To4, table1946_1947player0TO4ExpectedValue);
	
	    }
	
}