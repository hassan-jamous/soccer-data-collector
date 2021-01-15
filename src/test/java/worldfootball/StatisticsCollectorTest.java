package worldfootball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import worldfootball.testData.StatisticsValues;
import worldfootball.models.DirtyGame;
import worldfootball.models.StatisticsBestPlayerInYear;
import worldfootball.models.StatisticsGoalsPerRound;
import worldfootball.models.StatisticsGoalsPerSeason;
import worldfootball.models.StatisticsMostGoalsByPlayerPerGame;
import worldfootball.models.StatisticsRecordWinsAndMostGoalInGame;
import worldfootball.models.StatisticsRequestKind;
import testUtilities.AssertUtilities;
import testUtilities.CompareStatisticsGoalsPerRound;

public class StatisticsCollectorTest {

	StatisticsValues statisticsValues = new StatisticsValues();
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();

	@Test
    public void itShouldGetStatisticsGoalsPerRound() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsGoalsPerRound> actualValue = screenScraperUnderTest.getStatisticsGoalsPerRound("eng-premier-league");
        ArrayList<StatisticsGoalsPerRound> expectedlValue0To4 = statisticsValues.getStatisticsGoalsPerRoundEnglishPreimerLeague();
        CompareStatisticsGoalsPerRound roundComparator = new CompareStatisticsGoalsPerRound();
        Collections.sort(actualValue, roundComparator);
        Collections.sort(expectedlValue0To4, roundComparator);
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue, indexes, expectedlValue0To4);

    }
	 @Test
	 public void itShouldGetMostGoalsByPlayerPerGame() {

	        ScreenScraper screenScraperUnderTest = new ScreenScraper();
	        ArrayList<StatisticsMostGoalsByPlayerPerGame> engPremierLeagueActualValue = screenScraperUnderTest.getStatisticsMostGoalsByPlayerInGameInCompetition("eng-premier-league");
	        ArrayList<StatisticsMostGoalsByPlayerPerGame> engPremierLeagueExpectedValue = statisticsValues.getStatisticEnglishPreimerLeagueMostGoalPerPlayerInGame();
	        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 22));
	        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(engPremierLeagueActualValue, indexes, engPremierLeagueExpectedValue);

	  }
	
	 @Test
	    public void itShouldGetStatisticsDirtiesGamesForCompetition() {
	        ScreenScraper screenScraperUnderTest = new ScreenScraper();
	        ArrayList<DirtyGame> actualValue = screenScraperUnderTest.getStatisticsDirtiesGamesForCompetition("eng-premier-league");
	        ArrayList<DirtyGame> expectedValue0To9 = statisticsValues.getStatisticsEnglishPreimerLeageDirtiesGame();
	        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
	        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue, indexes, expectedValue0To9);

	    }

	    @Test
	    public void itShouldGetStatisticsBestPlayerInYear() {
	        ScreenScraper screenScraperUnderTest = new ScreenScraper();
	        ArrayList<StatisticsBestPlayerInYear> actualValue = screenScraperUnderTest.getStatisticsBestPlayerInYear("england");
	        ArrayList<StatisticsBestPlayerInYear> expectedValue0To9 = statisticsValues.getStatisticsEnglishPreimerLeagueBestPlayerInYear();
	        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
	        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue, indexes, expectedValue0To9);
	    }

    @Test
    public void itShouldGetStatisticsRecordWins() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue = screenScraperUnderTest.getStatisticsRecordWinsOrMostGoalInGame("eng-premier-league", StatisticsRequestKind.RecordWins);
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> expectedValue0To9 = statisticsValues.getStatisticsEnglishPreimerLeagueRecoedWin();
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue, indexes, expectedValue0To9);
    }

    @Test
    public void itShouldGetStatisticsMostGoalInGame() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue = new ArrayList<>();
        actualValue = screenScraperUnderTest.getStatisticsRecordWinsOrMostGoalInGame("eng-premier-league", StatisticsRequestKind.MostGoalInGame);
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> expectedValue0To9 = statisticsValues.getStatisticsEnglishPreimerLeagueMostGoalInGame();
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue, indexes, expectedValue0To9);

    }

    @Test
    public void itShouldGetStatisticsGoalsPerSeason() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsGoalsPerSeason> actualValue = screenScraperUnderTest.getStatisticsGoalsPerSeason("eng-premier-league");
        ArrayList<StatisticsGoalsPerSeason> expectedValue0To9 = statisticsValues.getStatististicsGoslsPerSeasonEnglishPriemerLeague();
        List<Integer> indexes = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue, indexes, expectedValue0To9);

    }
}