package worldfootball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import worldfootball.testData.PlayerAllInformationValues;
import worldfootball.models.PlayerAllInformation;
import testUtilities.ArrayAttributeWithIndexes;
import testUtilities.AssertUtilities;

public class PlayerCollectorTest  {

	PlayerAllInformationValues playersInformationWorldFootballValue= new PlayerAllInformationValues();
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();

	public void assertPlayerInformationWithIndexes(PlayerAllInformation actualValue, List<ArrayAttributeWithIndexes> attributeList, PlayerAllInformation expectedValue) {

        for (int i = 0; i < attributeList.size(); i++) {
            if (attributeList.get(i).attributeName.equals("personalInfo")) {
            	assertThat(actualValue.personalInfo).usingRecursiveComparison().isEqualTo(expectedValue.personalInfo);
            } 
            else if (attributeList.get(i).attributeName.equals("teamsManaged")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.teamsManaged, attributeList.get(i).indexes, expectedValue.teamsManaged);
            }
            else if (attributeList.get(i).attributeName.equals("clubsCareer")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.clubsCareer, attributeList.get(i).indexes, expectedValue.clubsCareer);
            }
            else if (attributeList.get(i).attributeName.equals("clubMatches")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.clubMatches, attributeList.get(i).indexes, expectedValue.clubMatches);
            } 
            else if (attributeList.get(i).attributeName.equals("internationalCopmetitionsInfo")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.internationalCopmetitionsInfo, attributeList.get(i).indexes, expectedValue.internationalCopmetitionsInfo);
            } 
            else if (attributeList.get(i).attributeName.equals("clubsMatchesOverall")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.clubsMatchesOverall, attributeList.get(i).indexes, expectedValue.clubsMatchesOverall);
            } 
            else if (attributeList.get(i).attributeName.equals("internationalCopmetitionsOverall")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.internationalCopmetitionsOverall, attributeList.get(i).indexes, expectedValue.internationalCopmetitionsOverall);
            }
            else if (attributeList.get(i).attributeName.equals("recordReferee")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.recordReferee, attributeList.get(i).indexes, expectedValue.recordReferee);
            } 
            else if (attributeList.get(i).attributeName.equals("recordOpponent")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.recordOpponent, attributeList.get(i).indexes, expectedValue.recordOpponent);
            } 
            else if (attributeList.get(i).attributeName.equals("forEachCompetitionInformationOverallsClubs")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.forEachCompetitionInformationOverallsClubs, attributeList.get(i).indexes, expectedValue.forEachCompetitionInformationOverallsClubs);
            } 
            else if (attributeList.get(i).attributeName.equals("forEachCompetitionInformationOverallsInternational")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.forEachCompetitionInformationOverallsInternational, attributeList.get(i).indexes, expectedValue.forEachCompetitionInformationOverallsInternational);
            }
        }
    }

    @Test
    public void itShouldGetPlayerInformation() {

        ScreenScraper screenScraperTest = new ScreenScraper();

        //https://www.worldfootball.net/player_summary/eric-bailly/
        PlayerAllInformation player1ActualValueInfo = screenScraperTest.playerCollector.getAllInformationAboutPlayer("eric-bailly");
        PlayerAllInformation player1ExpectedValueInfo = playersInformationWorldFootballValue.getEricBaillyInformation();
        List<ArrayAttributeWithIndexes> player1AttributeList = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("personalInfo"),
                new ArrayAttributeWithIndexes("teamsManaged"),
                new ArrayAttributeWithIndexes("clubsCareer"),
                new ArrayAttributeWithIndexes("clubMatches"),
                new ArrayAttributeWithIndexes("internationalCopmetitionsInfo"),
                new ArrayAttributeWithIndexes("clubsMatchesOverall"),
                new ArrayAttributeWithIndexes("internationalCopmetitionsOverall"),
                new ArrayAttributeWithIndexes("recordOpponent", new ArrayList<>(Arrays.asList(0, 7, 20, 21, 41, 61, 80, 100, 109))),
                new ArrayAttributeWithIndexes("recordReferee", new ArrayList<>(Arrays.asList(1, 21, 41, 61, 81, 100, 106))),
                new ArrayAttributeWithIndexes("forEachCompetitionInformationOverallsClubs", new ArrayList<>(Arrays.asList(2, 3)))));
        assertPlayerInformationWithIndexes(player1ActualValueInfo, player1AttributeList, player1ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/tony-adams/
        PlayerAllInformation player2ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("tony-adams");
        PlayerAllInformation player2ExpectedValueInfo = playersInformationWorldFootballValue.getTonyAdamsInformation();
        List<ArrayAttributeWithIndexes> player2AttributeList = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("personalInfo"),
                new ArrayAttributeWithIndexes("teamsManaged"),
                new ArrayAttributeWithIndexes("clubsCareer"),
                new ArrayAttributeWithIndexes("clubMatches"),
                new ArrayAttributeWithIndexes("internationalCopmetitionsInfo"),
                new ArrayAttributeWithIndexes("clubsMatchesOverall"),
                new ArrayAttributeWithIndexes("internationalCopmetitionsOverall"),
                new ArrayAttributeWithIndexes("recordOpponent", new ArrayList<>(Arrays.asList(0, 20, 40, 60, 80, 100, 106))),
                new ArrayAttributeWithIndexes("recordReferee", new ArrayList<>(Arrays.asList(0, 140, 148)))));
        assertPlayerInformationWithIndexes(player2ActualValueInfo, player2AttributeList, player2ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/walter-aitkenhead/
        PlayerAllInformation player3ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("walter-aitkenhead");
        PlayerAllInformation player3ExpectedValueInfo = playersInformationWorldFootballValue.getWwalterAitkenhead();
        List<ArrayAttributeWithIndexes> player3AttributeList = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("personalInfo"),
                new ArrayAttributeWithIndexes("teamsManaged"),
                new ArrayAttributeWithIndexes("clubsCareer"),
                new ArrayAttributeWithIndexes("clubMatches"),
                new ArrayAttributeWithIndexes("internationalCopmetitionsInfo"),
                new ArrayAttributeWithIndexes("clubsMatchesOverall"),
                new ArrayAttributeWithIndexes("internationalCopmetitionsOverall"),
                new ArrayAttributeWithIndexes("recordOpponent"),
                new ArrayAttributeWithIndexes("recordReferee")));
        assertPlayerInformationWithIndexes(player3ActualValueInfo, player3AttributeList, player3ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/sam-johnstone/
        PlayerAllInformation player4ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("sam-johnstone");
        PlayerAllInformation player4ExpectedValueInfo = playersInformationWorldFootballValue.getSamJohnstone();
        List<ArrayAttributeWithIndexes> player4AttributesToTest = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("clubsCareer", new ArrayList<Integer>(Arrays.asList(1, 5))),
                new ArrayAttributeWithIndexes("clubMatches", new ArrayList<Integer>(Arrays.asList(0, 3, 6)))));
        assertPlayerInformationWithIndexes(player4ActualValueInfo, player4AttributesToTest, player4ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/george-timmins/
        PlayerAllInformation player5ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("george-timmins");
        PlayerAllInformation player5ExpectedValueInfo = playersInformationWorldFootballValue.getGeorgeTimmins();
        List<ArrayAttributeWithIndexes> player5AttributeList = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("personalInfo"),
                new ArrayAttributeWithIndexes("clubsCareer"),
                new ArrayAttributeWithIndexes("clubMatches"),
                new ArrayAttributeWithIndexes("clubsMatchesOverall"),
                new ArrayAttributeWithIndexes("internationalCopmetitionsInfo")));
        assertPlayerInformationWithIndexes(player5ActualValueInfo, player5AttributeList, player5ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/che-adams/
        PlayerAllInformation player6ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("che-adams");
        PlayerAllInformation player6ExpectedValueInfo = playersInformationWorldFootballValue.getCheAdams();
        List<ArrayAttributeWithIndexes> player6AttributeList = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("personalInfo"),
                new ArrayAttributeWithIndexes("teamManaged")));
        assertPlayerInformationWithIndexes(player6ActualValueInfo, player6AttributeList, player6ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/adam-carson/
        PlayerAllInformation player7ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("adam-carson");
        PlayerAllInformation player7ExpectedValueInfo = playersInformationWorldFootballValue.getAdamCarson();
        List<ArrayAttributeWithIndexes> player7AttributeList = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("personalInfo"),
                new ArrayAttributeWithIndexes("teamManaged")));
        assertPlayerInformationWithIndexes(player7ActualValueInfo, player7AttributeList, player7ExpectedValueInfo);

    }
}