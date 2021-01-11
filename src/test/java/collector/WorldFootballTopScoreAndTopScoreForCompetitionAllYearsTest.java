package collector;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import models.PlayerTopScoreForSeason;
import models.PlayerTopSoccer;
import testValues.WorldFootballWorldFootballTopScoreAndTopScoreForCompetitionAllYearsValue;

public class WorldFootballTopScoreAndTopScoreForCompetitionAllYearsTest {
	
	WorldFootballWorldFootballTopScoreAndTopScoreForCompetitionAllYearsValue scoreWorldFootballValue = new WorldFootballWorldFootballTopScoreAndTopScoreForCompetitionAllYearsValue();
	 @Test
	    public void itShouldGetTopScoreForCompetitionAllYears() {
	        ScreenScraper screenScraperTest = new ScreenScraper();
	        ArrayList<PlayerTopScoreForSeason> engPreimerLeagueactualValue = screenScraperTest.getTopSoccerForCompetitionAllYears("eng-premier-league");
	        ArrayList<PlayerTopScoreForSeason> engPreimerLeagueexpectedValue = scoreWorldFootballValue.getTopScoerForEnglishPreimerLeagueAllYears();
	        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 9));
	        assertScore(engPreimerLeagueactualValue, indexes, engPreimerLeagueexpectedValue);
	    }
	 
	 @Test
	    public void itShouldGetTopSoccer() {
	        ScreenScraper screenScraperUnderTest = new ScreenScraper();

	        ArrayList<PlayerTopSoccer> table2019_2020ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "2019-2020");
	        ArrayList<PlayerTopSoccer> table2019_2020player0TO4ExpectedValue = scoreWorldFootballValue.getTableTopScore2019_2020();
	        List<Integer> indexes2019_2020From0To4 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
	        assertScore(table2019_2020ActualValue, indexes2019_2020From0To4, table2019_2020player0TO4ExpectedValue);

	        ArrayList<PlayerTopSoccer> table2009_2010ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "2009-2010");
	        ArrayList<PlayerTopSoccer> table2009_2010player4TO9ExpectedValue = scoreWorldFootballValue.getTopScoreEnglishPreimerLeague2009_2010();
	        List<Integer> indexes2019_2020From6To10 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));
	        assertScore(table2009_2010ActualValue, indexes2019_2020From6To10, table2009_2010player4TO9ExpectedValue);

	        ArrayList<PlayerTopSoccer> table1946_1947ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "1946-1947");
	        ArrayList<PlayerTopSoccer> table1946_1947player0TO4ExpectedValue = scoreWorldFootballValue.getTopScoreEngishPriemerLeague1946_1947();
	        List<Integer> indexes1946_1947From0To4 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
	        assertScore(table1946_1947ActualValue, indexes1946_1947From0To4, table1946_1947player0TO4ExpectedValue);

	    }
	 public void assertScore(ArrayList<?> actualValue, List<Integer> indexes, ArrayList<?> expectedValue) {
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

}
