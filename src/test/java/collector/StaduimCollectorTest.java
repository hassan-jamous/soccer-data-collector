package collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import collector.testData.WorldFootballSataduimValues;
import models.Staduim;
import testUtilities.AssertUtilities;

public class StaduimCollectorTest {

	WorldFootballSataduimValues staduimsWorldDootballValues = new WorldFootballSataduimValues();
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();

	@Test
    public void itShouldGetAllClubStaduimsForCompetition() {
		
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<Staduim> actualValueEnglandPremierLeague2020_2021 = screenScraperUnderTest.getCompetitionStadiums("eng-premier-league", "2020-2021");
        ArrayList<Staduim> expectedValueEnglndPreimerLeague2020_2021Just0To5 = staduimsWorldDootballValues.getEnglishPreimerLeagueStaduim2020_2021();
        List<Integer> indexesEnglandPremierLeague2020_2021 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValueEnglandPremierLeague2020_2021, indexesEnglandPremierLeague2020_2021, expectedValueEnglndPreimerLeague2020_2021Just0To5);

        ArrayList<Staduim> actualValueEnglandChampionship1950_1951 = screenScraperUnderTest.getCompetitionStadiums("eng-championship", "1950-1951");
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValueEnglandChampionship1950_1951, null, null);

    }
	
	
}
