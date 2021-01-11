package collector;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import models.Club;
import testValues.WorldFootballClubsInSeasonValues;

public class WorldFootballClubsInSeasonTest {
	
	WorldFootballClubsInSeasonValues clubsWorldFootballClubsValues = new WorldFootballClubsInSeasonValues();

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
}
