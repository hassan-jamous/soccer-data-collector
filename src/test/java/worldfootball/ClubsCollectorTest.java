package worldfootball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import worldfootball.testData.ClubsInSeasonValues;
import worldfootball.testData.ClubsSquadValues;
import worldfootball.models.Club;
import worldfootball.models.PlayerSummary;
import testUtilities.AssertUtilities;

public class ClubsCollectorTest {
	
	ClubsInSeasonValues clubsValues = new ClubsInSeasonValues();
    ClubsSquadValues playersInClubs_Squad_Values = new ClubsSquadValues();
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();

    @Test
    public void itShouldGetClubsInSeason() {
        ClubsCollector clubsCollector = new ClubsCollector();

        ArrayList<Club> clubsAt2015_2016ActualValue = clubsCollector.getAllClubsInSeason("eng-premier-league", "2015-2016");
        List<Integer> clubsIdAtSeason2015_2016 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
        List<Club> clubsAt2015_2016Expected = clubsValues.clubsAtEnglishPreimerLeague2015_2016Expected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(clubsAt2015_2016ActualValue,clubsIdAtSeason2015_2016, clubsAt2015_2016Expected );

        ArrayList<Club> clubsAt1967_1968ActualValue = clubsCollector.getAllClubsInSeason("eng-premier-league", "1967-1968");
        List<Integer> clubsIdAtSeason1967_1968 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21);
        List<Club> clubsAt1967_1968Expected = clubsValues.clubsAtEnglishPreimerLeague1967_1968Expected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(clubsAt1967_1968ActualValue, clubsIdAtSeason1967_1968,clubsAt1967_1968Expected );

        ArrayList<Club> clubsAt1889_1890ActualValue = clubsCollector.getAllClubsInSeason("eng-premier-league", "1889-1890");
        List<Integer> clubsIdAtSeason1890_1891 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        List<Club> clubsAt1889_1890Expected = clubsValues.clubsAtEnglishPreimerLeague1889_1890Expected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(clubsAt1889_1890ActualValue,clubsIdAtSeason1890_1891, clubsAt1889_1890Expected);

    }

    @Test
    public void itShouldGetPlayersSummuryInClub() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<PlayerSummary> playersManchesterUnited2015ActualValue = screenScraperUnderTest.clubsCollector.getClubSquad("manchester-united", "2015");
        List<PlayerSummary> playersManchesterUnited2015Expected = playersInClubs_Squad_Values.playersManchesterUnited2015Expected();
        List<Integer> playersIdManchesterUnited2015 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
                , 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33);
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(playersManchesterUnited2015ActualValue, playersIdManchesterUnited2015, playersManchesterUnited2015Expected );

        ArrayList<PlayerSummary> playersManchesterUnited2001ActualValue = screenScraperUnderTest.clubsCollector.getClubSquad("manchester-united", "2001");
        List<Integer> playersIdManchesterUnited2001 = Arrays.asList(0, 3, 4, 8, 15, 32, 38, 39);
        List<PlayerSummary> playersManchesterUnited2001Expected = playersInClubs_Squad_Values.playersManchesterUnited2001Expected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(playersManchesterUnited2001ActualValue,playersIdManchesterUnited2001, playersManchesterUnited2001Expected );

        ArrayList<PlayerSummary> playersManchesterUnited1991ActualValue = screenScraperUnderTest.clubsCollector.getClubSquad("manchester-united", "1991");
        List<Integer> playersIdManchesterUnited1991 = Arrays.asList(0, 3, 4, 8, 15, 23, 29);
        List<PlayerSummary> playersManchesterUnited1991Expected = playersInClubs_Squad_Values.playersManchesterUnited1991Expected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(playersManchesterUnited1991ActualValue,playersIdManchesterUnited1991, playersManchesterUnited1991Expected);

        ArrayList<PlayerSummary> playersManchesterUnited1970ActualValue = screenScraperUnderTest.clubsCollector.getClubSquad("manchester-united", "1970");
        List<Integer> playersIdManchesterUnited1970 = Arrays.asList(0, 2, 11, 17, 18, 24, 26);
        List<PlayerSummary> playersManchesterUnited1970Expected = playersInClubs_Squad_Values.playersManchesterUnited1970Expected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(playersManchesterUnited1970ActualValue, playersIdManchesterUnited1970, playersManchesterUnited1970Expected );

        ArrayList<PlayerSummary> manchesterUnitedActualValueplayers1966 = screenScraperUnderTest.clubsCollector.getClubSquad("manchester-united", "1966");
        List<Integer> playersIdManchesterUnited1966 = Arrays.asList(0, 4, 12);
        List<PlayerSummary> playersManchesterUnited1966Expected = playersInClubs_Squad_Values.playersManchesterUnited1966Expected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(manchesterUnitedActualValueplayers1966,playersIdManchesterUnited1966, playersManchesterUnited1966Expected );

        ArrayList<PlayerSummary> playersManchesterUnited1950ActualValue = screenScraperUnderTest.get_ClubSquad_AllPlayersSummaryInClub("manchester-united", "1950");
        List<Integer> playersIdManchesterUnited1950 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27);
        List<PlayerSummary> playersManchesterUnited1950Expected = playersInClubs_Squad_Values.playersManchesterUnited1950Expected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(playersManchesterUnited1950ActualValue,playersIdManchesterUnited1950, playersManchesterUnited1950Expected );

        ArrayList<PlayerSummary> playersManchesterUnited1890ActualValue = screenScraperUnderTest.clubsCollector.getClubSquad("manchester-united", "1890");
        List<Integer> playersIdManchesterUnited1890 = Arrays.asList(0, 1, 2, 3, 4);
        List<PlayerSummary> playersManchesterUnited1890Expected = playersInClubs_Squad_Values.playersManchesterUnited1890Expected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(playersManchesterUnited1890ActualValue,playersIdManchesterUnited1890, playersManchesterUnited1890Expected);

        ArrayList<PlayerSummary> playersAccrington1890ActualValue = screenScraperUnderTest.clubsCollector.getClubSquad("Accrington", "1890");
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(playersAccrington1890ActualValue,null ,null);

    }
 }


