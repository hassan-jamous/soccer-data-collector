package worldfootball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import worldfootball.testData.WorldFootballMatchesDetailsEnglishPreimerLeagueValues;
import worldfootball.models.MatchDetails;
import testUtilities.AssertUtilities;
import testUtilities.ComparePlayerNames;
import testUtilities.ArrayAttributeWithIndexesFor_TEST;

public class MatchCollectorTest {

	WorldFootballMatchesDetailsEnglishPreimerLeagueValues matchesWorldFootballMatchDetailsValue = new WorldFootballMatchesDetailsEnglishPreimerLeagueValues();
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();

    @Test
    public void itShouldMatchDetails() {
    	
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        //https://www.worldfootball.net/report/premier-league-2019-2020-brighton-hove-albion-everton-fc/
        MatchDetails match1ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2019-2020", "brighton-hove-albion", "everton-fc");
        MatchDetails match1ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2019_2020BrightonHoveAlbionEvertonFc();
        List<ArrayAttributeWithIndexesFor_TEST> match1Attributes = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexesFor_TEST("firstClub"),
                new ArrayAttributeWithIndexesFor_TEST("secondClub"),
                new ArrayAttributeWithIndexesFor_TEST("staduim"),
                new ArrayAttributeWithIndexesFor_TEST("attendance"),
                new ArrayAttributeWithIndexesFor_TEST("goals"),
                new ArrayAttributeWithIndexesFor_TEST("referees"),
                new ArrayAttributeWithIndexesFor_TEST("matchSummary")));

        ComparePlayerNames playerComparator = new ComparePlayerNames();
        Collections.sort(match1ActualValue.firstClub.players, playerComparator);
        Collections.sort(match1ActualValue.secondClub.players, playerComparator);
        Collections.sort(match1ExpectedValue.firstClub.players, playerComparator);
        Collections.sort(match1ExpectedValue.secondClub.players, playerComparator);
        assertMatches(match1ActualValue, match1Attributes, match1ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-1946-1947-brentford-fc-middlesbrough-fc/
        MatchDetails match2ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "1946-1947", "brentford-fc", "middlesbrough-fc");
        MatchDetails match2ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame1946_1947BrentfordFcMiddlesbroughFc();
        Collections.sort(match2ActualValue.firstClub.players, playerComparator);
        Collections.sort(match2ActualValue.secondClub.players, playerComparator);
        Collections.sort(match2ExpectedValue.firstClub.players, playerComparator);
        Collections.sort(match2ExpectedValue.secondClub.players, playerComparator);
        List<ArrayAttributeWithIndexesFor_TEST> match2Attributes = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexesFor_TEST("firstClub"),
                new ArrayAttributeWithIndexesFor_TEST("secondClub"),
                new ArrayAttributeWithIndexesFor_TEST("staduim"),
                new ArrayAttributeWithIndexesFor_TEST("attendance"),
                new ArrayAttributeWithIndexesFor_TEST("goals"),
                new ArrayAttributeWithIndexesFor_TEST("referees"),
                new ArrayAttributeWithIndexesFor_TEST("matchSummary")));
        assertMatches(match2ActualValue, match2Attributes, match2ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-2020-2021-leeds-united-burnley-fc/
        MatchDetails match3ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "Leeds-United", "Burnley-FC");
        MatchDetails match3ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2020_2021LeedsUnitdBurnleyFc();
        List<ArrayAttributeWithIndexesFor_TEST> match3Attributes = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexesFor_TEST("goals")));
        assertMatches(match3ActualValue, match3Attributes, match3ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-2020-2021-sheffield-united-everton-fc/
        MatchDetails match4ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "sheffield-united", "everton-fc");
        MatchDetails match4ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2020_2021SheffieldUnitdEvertonFc();
        List<ArrayAttributeWithIndexesFor_TEST> match4Attributes = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexesFor_TEST("goals")));
        assertMatches(match4ActualValue, match4Attributes, match4ExpectedValue);

    }
	private void assertMatches(MatchDetails actualValue, List<ArrayAttributeWithIndexesFor_TEST> attributes, MatchDetails expectedValue) {

		for (int i = 0; i < attributes.size(); i++) {
            if (attributes.get(i).attributeName.equals("staduim")) {
                assertThat(actualValue.staduim).isEqualTo(expectedValue.staduim);
            } 
            else if (attributes.get(i).attributeName.equals("attendance")) {
                assertThat(actualValue.attendance).isEqualTo(expectedValue.attendance);
            } 
            else if (attributes.get(i).attributeName.equals("matchSummary")) {
                assertThat(actualValue.matchSummary).usingRecursiveComparison().isEqualTo(expectedValue.matchSummary);
            } 
            else if (attributes.get(i).attributeName.equals("goals")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.goals, attributes.get(i).indexes, expectedValue.goals);
            } 
            else if (attributes.get(i).attributeName.equals("firstClub")) {
                Assert.assertEquals(expectedValue.firstClub.manager, actualValue.firstClub.manager);
                Assert.assertEquals(expectedValue.firstClub.clubBasicInfo.name, actualValue.firstClub.clubBasicInfo.name);
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.firstClub.players, attributes.get(i).indexes, expectedValue.firstClub.players);

            }
            else if (attributes.get(i).attributeName.equals("secondClub")) {
                Assert.assertEquals(expectedValue.secondClub.manager, actualValue.secondClub.manager);
                Assert.assertEquals(expectedValue.secondClub.clubBasicInfo.name, actualValue.secondClub.clubBasicInfo.name);
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.secondClub.players, attributes.get(i).indexes, expectedValue.secondClub.players);

            }
            else if (attributes.get(i).attributeName.equals("referees")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.referees, attributes.get(i).indexes, expectedValue.referees);
            }
        }
    }
}