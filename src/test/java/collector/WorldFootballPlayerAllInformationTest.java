package collector;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import models.PlayerAllInformation;
import testUtilities.WorldFootBallAttributeFor_TEST;
import testValues.WorldFootballPlayerAllInformationValues;

public class WorldFootballPlayerAllInformationTest {
	
	WorldFootballPlayerAllInformationValues playersInformationWorldFootballValue= new WorldFootballPlayerAllInformationValues();

	public void assertPlayerInformationWithIndexes(PlayerAllInformation actualValue, List<WorldFootBallAttributeFor_TEST> attributeList, PlayerAllInformation expectedValue) {

        for (int i = 0; i < attributeList.size(); i++) {
            int limit;
            if (attributeList.get(i).attributeName.equals("personalInfo")) {
                assertThat(actualValue.personalInfo).usingRecursiveComparison().isEqualTo(expectedValue.personalInfo);
            } else if (attributeList.get(i).attributeName.equals("teamsManaged")) {
                if (expectedValue.teamsManaged == null) {
                    Assert.assertEquals(null, actualValue.teamsManaged);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.teamsManaged.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.teamsManaged.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.teamsManaged.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("clubsCareer")) {
                if (expectedValue.clubsCareer == null) {
                    Assert.assertEquals(null, actualValue.clubsCareer);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.clubsCareer.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.clubsCareer.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.clubsCareer.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("clubMatches")) {
                if (expectedValue.clubMatches == null) {
                    Assert.assertEquals(null, actualValue.clubMatches);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.clubMatches.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.clubMatches.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.clubMatches.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("internationalCopmetitionsInfo")) {
                if (expectedValue.internationalCopmetitionsInfo == null) {
                    Assert.assertEquals(null, actualValue.internationalCopmetitionsInfo);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.internationalCopmetitionsInfo.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.internationalCopmetitionsInfo.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.internationalCopmetitionsInfo.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("clubsMatchesOverall")) {
                if (expectedValue.clubsMatchesOverall == null) {
                    Assert.assertEquals(null, actualValue.clubsMatchesOverall);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.clubsMatchesOverall.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        //assertThat(playerInfoActualValue.clubsMatchesOverall).contains(playerInfoExpectedValue.clubsMatchesOverall.get(j));
                        assertThat(actualValue.clubsMatchesOverall.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.clubsMatchesOverall.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("internationalCopmetitionsOverall")) {
                if (expectedValue.internationalCopmetitionsOverall == null) {
                    Assert.assertEquals(null, actualValue.internationalCopmetitionsOverall);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.internationalCopmetitionsOverall.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.internationalCopmetitionsOverall.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.internationalCopmetitionsOverall.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("internationalCopmetitionsOverall")) {
                if (expectedValue.internationalCopmetitionsOverall == null) {
                    Assert.assertEquals(null, actualValue.internationalCopmetitionsOverall);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.internationalCopmetitionsOverall.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.internationalCopmetitionsOverall.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.internationalCopmetitionsOverall.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("internationalCopmetitionsOverall")) {
                if (expectedValue.internationalCopmetitionsOverall == null) {
                    Assert.assertEquals(null, actualValue.internationalCopmetitionsOverall);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.internationalCopmetitionsOverall.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.internationalCopmetitionsOverall.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.internationalCopmetitionsOverall.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("recordReferee")) {
                if (expectedValue.recordReferee == null) {
                    Assert.assertEquals(null, actualValue.recordReferee);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.recordReferee.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.recordReferee.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.recordReferee.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("recordOpponent")) {
                if (expectedValue.recordOpponent == null) {
                    Assert.assertEquals(null, actualValue.recordOpponent);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.recordOpponent.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.recordOpponent.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.recordOpponent.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("forEachCompetitionInformationOverallsClubs")) {
                if (expectedValue.forEachCompetitionInformationOverallsClubs == null) {
                    Assert.assertEquals(null, actualValue.forEachCompetitionInformationOverallsClubs);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.forEachCompetitionInformationOverallsClubs.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.forEachCompetitionInformationOverallsClubs.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.forEachCompetitionInformationOverallsClubs.get(j));
                        j++;
                    }
                }
            } else if (attributeList.get(i).attributeName.equals("forEachCompetitionInformationOverallsInternational")) {
                if (expectedValue.forEachCompetitionInformationOverallsInternational == null) {
                    Assert.assertEquals(null, actualValue.forEachCompetitionInformationOverallsInternational);
                } else {
                    limit = (attributeList.get(i).indexes.isEmpty()) ? actualValue.forEachCompetitionInformationOverallsInternational.size() : attributeList.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributeList.get(i).indexes.isEmpty()) ? j : attributeList.get(i).indexes.get(j);
                        assertThat(actualValue.forEachCompetitionInformationOverallsInternational.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.forEachCompetitionInformationOverallsInternational.get(j));
                        j++;
                    }
                }
            }
        }
    }

    @Test
    public void itShouldGetPlayerInformation() {

        ScreenScraper screenScraperTest = new ScreenScraper();

        //https://www.worldfootball.net/player_summary/eric-bailly/
        PlayerAllInformation player1ActualValueInfo = screenScraperTest.playerCollector.getAllInformationAboutPlayer("eric-bailly");
        PlayerAllInformation player1ExpectedValueInfo = playersInformationWorldFootballValue.getEricBaillyInformation();
        List<WorldFootBallAttributeFor_TEST> player1AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("teamsManaged"),
                new WorldFootBallAttributeFor_TEST("clubsCareer"),
                new WorldFootBallAttributeFor_TEST("clubMatches"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo"),
                new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsOverall"),
                new WorldFootBallAttributeFor_TEST("recordOpponent", new ArrayList<>(Arrays.asList(0, 7, 19, 20, 40, 60, 80, 100, 109))),
                new WorldFootBallAttributeFor_TEST("recordReferee", new ArrayList<>(Arrays.asList(0, 20, 41, 61, 81, 100, 106))),
                new WorldFootBallAttributeFor_TEST("forEachCompetitionInformationOverallsClubs", new ArrayList<>(Arrays.asList(2, 3)))));
        assertPlayerInformationWithIndexes(player1ActualValueInfo, player1AttributeList, player1ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/tony-adams/
        PlayerAllInformation player2ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("tony-adams");
        PlayerAllInformation player2ExpectedValueInfo = playersInformationWorldFootballValue.getTonyAdamsInformation();
        List<WorldFootBallAttributeFor_TEST> player2AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("teamsManaged"),
                new WorldFootBallAttributeFor_TEST("clubsCareer"),
                new WorldFootBallAttributeFor_TEST("clubMatches"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo"),
                new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsOverall"),
                new WorldFootBallAttributeFor_TEST("recordOpponent", new ArrayList<>(Arrays.asList(0, 20, 40, 60, 80, 100, 106))),
                new WorldFootBallAttributeFor_TEST("recordReferee", new ArrayList<>(Arrays.asList(0, 140, 148)))));
        assertPlayerInformationWithIndexes(player2ActualValueInfo, player2AttributeList, player2ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/walter-aitkenhead/
        PlayerAllInformation player3ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("walter-aitkenhead");
        PlayerAllInformation player3ExpectedValueInfo = playersInformationWorldFootballValue.getWwalterAitkenhead();
        List<WorldFootBallAttributeFor_TEST> player3AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("teamsManaged"),
                new WorldFootBallAttributeFor_TEST("clubsCareer"),
                new WorldFootBallAttributeFor_TEST("clubMatches"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo"),
                new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsOverall"),
                new WorldFootBallAttributeFor_TEST("recordOpponent"),
                new WorldFootBallAttributeFor_TEST("recordReferee")));
        assertPlayerInformationWithIndexes(player3ActualValueInfo, player3AttributeList, player3ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/sam-johnstone/
        PlayerAllInformation player4ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("sam-johnstone");
        PlayerAllInformation player4ExpectedValueInfo = playersInformationWorldFootballValue.getSamJohnstone();
        List<WorldFootBallAttributeFor_TEST> player4AttributesToTest = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("clubsCareer", new ArrayList<Integer>(Arrays.asList(1, 5))),
                new WorldFootBallAttributeFor_TEST("clubMatches", new ArrayList<Integer>(Arrays.asList(0, 3, 6)))));
        assertPlayerInformationWithIndexes(player4ActualValueInfo, player4AttributesToTest, player4ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/george-timmins/
        PlayerAllInformation player5ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("george-timmins");
        PlayerAllInformation player5ExpectedValueInfo = playersInformationWorldFootballValue.getGeorgeTimmins();
        List<WorldFootBallAttributeFor_TEST> player5AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("clubsCareer"),
                new WorldFootBallAttributeFor_TEST("clubMatches"),
                new WorldFootBallAttributeFor_TEST("clubsMatchesOverall"),
                new WorldFootBallAttributeFor_TEST("internationalCopmetitionsInfo")));
        assertPlayerInformationWithIndexes(player5ActualValueInfo, player5AttributeList, player5ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/che-adams/
        PlayerAllInformation player6ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("che-adams");
        PlayerAllInformation player6ExpectedValueInfo = playersInformationWorldFootballValue.getCheAdams();
        List<WorldFootBallAttributeFor_TEST> player6AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("teamManaged")));
        assertPlayerInformationWithIndexes(player6ActualValueInfo, player6AttributeList, player6ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/adam-carson/
        PlayerAllInformation player7ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("adam-carson");
        PlayerAllInformation player7ExpectedValueInfo = playersInformationWorldFootballValue.getAdamCarson();
        List<WorldFootBallAttributeFor_TEST> player7AttributeList = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("personalInfo"),
                new WorldFootBallAttributeFor_TEST("teamManaged")));
        assertPlayerInformationWithIndexes(player7ActualValueInfo, player7AttributeList, player7ExpectedValueInfo);

    }
}
