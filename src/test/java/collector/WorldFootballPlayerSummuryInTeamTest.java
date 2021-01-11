package collector;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import models.PlayerSummary;
import testValues.WorldFootballPlayerSummuryInTeamsValues;

public class WorldFootballPlayerSummuryInTeamTest {

    WorldFootballPlayerSummuryInTeamsValues playersInTeamsValues = new WorldFootballPlayerSummuryInTeamsValues();

	public void assertPlayersSummaryInTeam(ArrayList<PlayerSummary> playersClubActualValue, List<PlayerSummary> playersInClubExpectedValue, List<Integer> playersIds) {
        for (int i = 0; i < playersInClubExpectedValue.size(); i++) {
            assertThat(playersInClubExpectedValue.get(i)).usingRecursiveComparison().isEqualTo(playersClubActualValue.get(playersIds.get(i)));
        }
    }

    @Test
    public void itShouldGetPlayersSummuryInTeam() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<PlayerSummary> playersManchesterUnited2015ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "2015");
        List<PlayerSummary> playersManchesterUnited2015Expected = playersInTeamsValues.playersManchesterUnited2015Expected();
        List<Integer> playersIdManchesterUnited2015 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
                , 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34);
        assertPlayersSummaryInTeam(playersManchesterUnited2015ActualValue, playersManchesterUnited2015Expected, playersIdManchesterUnited2015);

        ArrayList<PlayerSummary> playersManchesterUnited2001ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "2001");
        List<Integer> playersIdManchesterUnited2001 = Arrays.asList(0, 3, 4, 8, 15, 32, 38, 39);
        List<PlayerSummary> playersManchesterUnited2001Expected = playersInTeamsValues.playersManchesterUnited2001Expected();
        assertPlayersSummaryInTeam(playersManchesterUnited2001ActualValue, playersManchesterUnited2001Expected, playersIdManchesterUnited2001);

        ArrayList<PlayerSummary> playersManchesterUnited1991ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1991");
        List<Integer> playersIdManchesterUnited1991 = Arrays.asList(0, 3, 4, 8, 15, 23, 29);
        List<PlayerSummary> playersManchesterUnited1991Expected = playersInTeamsValues.playersManchesterUnited1991Expected();
        assertPlayersSummaryInTeam(playersManchesterUnited1991ActualValue, playersManchesterUnited1991Expected, playersIdManchesterUnited1991);

        ArrayList<PlayerSummary> playersManchesterUnited1970ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1970");
        List<Integer> playersIdManchesterUnited1970 = Arrays.asList(0, 2, 11, 17, 18, 24, 26);
        List<PlayerSummary> playersManchesterUnited1970Expected = playersInTeamsValues.playersManchesterUnited1970Expected();
        assertPlayersSummaryInTeam(playersManchesterUnited1970ActualValue, playersManchesterUnited1970Expected, playersIdManchesterUnited1970);

        ArrayList<PlayerSummary> manchesterUnitedActualValueplayers1966 = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1966");
        List<Integer> playersIdManchesterUnited1966 = Arrays.asList(0, 4, 12);
        List<PlayerSummary> playersManchesterUnited1966Expected = playersInTeamsValues.playersManchesterUnited1966Expected();
        assertPlayersSummaryInTeam(manchesterUnitedActualValueplayers1966, playersManchesterUnited1966Expected, playersIdManchesterUnited1966);

        ArrayList<PlayerSummary> playersManchesterUnited1950ActualValue = screenScraperUnderTest.getAllPlayersSummaryInClub("manchester-united", "1950");
        List<Integer> playersIdManchesterUnited1950 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27);
        List<PlayerSummary> playersManchesterUnited1950Expected = playersInTeamsValues.playersManchesterUnited1950Expected();
        assertPlayersSummaryInTeam(playersManchesterUnited1950ActualValue, playersManchesterUnited1950Expected, playersIdManchesterUnited1950);

        ArrayList<PlayerSummary> playersManchesterUnited1890ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1890");
        List<Integer> playersIdManchesterUnited1890 = Arrays.asList(0, 1, 2, 3, 4);
        List<PlayerSummary> playersManchesterUnited1890Expected = playersInTeamsValues.playersManchesterUnited1890Expected();
        assertPlayersSummaryInTeam(playersManchesterUnited1890ActualValue, playersManchesterUnited1890Expected, playersIdManchesterUnited1890);

        ArrayList<PlayerSummary> playersAccrington1890ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("Accrington", "1890");
        Assert.assertEquals(null, playersAccrington1890ActualValue);

    }
}
