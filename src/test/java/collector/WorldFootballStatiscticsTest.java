package collector;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import models.DirtyGame;
import models.StatisticsBestPlayerInYear;
import models.StatisticsGoalsPerRound;
import models.StatisticsGoalsPerSeason;
import models.StatisticsMostGoalsByPlayerPerGame;
import models.StatisticsRecordWinsAndMostGoalInGame;
import models.StatisticsRequestKind;
import testUtilities.CompareStatisticsGoalsPerRound;
import testValues.WorldFootballStatisticsValues;

public class WorldFootballStatiscticsTest {

	WorldFootballStatisticsValues statisticsValues = new WorldFootballStatisticsValues();
	
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
	 public void itShouldGetMostGoalsByPlayerPerGame() {

	        ScreenScraper screenScraperUnderTest = new ScreenScraper();
	        ArrayList<StatisticsMostGoalsByPlayerPerGame> engPremierLeagueActualValue = screenScraperUnderTest.getStatisticsMostGoalsByPlayerInGameInCompetition("eng-premier-league");
	        ArrayList<StatisticsMostGoalsByPlayerPerGame> engPremierLeagueExpectedValue = statisticsValues.getStatisticEnglishPreimerLeagueMostGoalPerPlayerInGame();
	        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 22));
	        assertStatistics(engPremierLeagueActualValue, indexes, engPremierLeagueExpectedValue);

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
    public void itShouldGetStatisticsGoalsPerSeason() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsGoalsPerSeason> actualValue = screenScraperUnderTest.getStatisticsGoalsPerSeason("eng-premier-league");
        ArrayList<StatisticsGoalsPerSeason> expectedValue0To9 = statisticsValues.getStatististicsGoslsPerSeasonEnglishPriemerLeague();
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        assertStatistics(actualValue, indexes, expectedValue0To9);

    }
}
