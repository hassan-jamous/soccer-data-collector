package collector;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import models.Staduim;
import testValues.WorldFootballSataduimValues;

public class WorldFootballClubsStaduimForCompetitionTest {

	WorldFootballSataduimValues staduimsWorldDootballValues = new WorldFootballSataduimValues();
	@Test
    public void itShouldGetAllClubStaduimsForCompetition() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<Staduim> actualValueEnglandPremierLeague2020_2021 = screenScraperUnderTest.getCompetitionStadiums("eng-premier-league", "2020-2021");
        ArrayList<Staduim> expectedValueEnglndPreimerLeague2020_2021Just0To5 = staduimsWorldDootballValues.getEnglishPreimerLeagueStaduim2020_2021();
        List<Integer> indexesEnglandPremierLeague2020_2021 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        assertStaduimsForCompetition(actualValueEnglandPremierLeague2020_2021, indexesEnglandPremierLeague2020_2021, expectedValueEnglndPreimerLeague2020_2021Just0To5);

        ArrayList<Staduim> actualValueEnglandChampionship1950_1951 = screenScraperUnderTest.getCompetitionStadiums("eng-championship", "1950-1951");
        ArrayList<Staduim> expectedValue1950_1951Just0To5 = null;
        assertStaduimsForCompetition(actualValueEnglandChampionship1950_1951, null, expectedValue1950_1951Just0To5);

    }
	
	public void assertStaduimsForCompetition(ArrayList<?> actualValue, List<Integer> indexes, ArrayList<?> expectedValue) {
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
