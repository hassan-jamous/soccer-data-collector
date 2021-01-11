package collector;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import models.MatchDetails;
import testUtilities.ComparePlayerNames;
import testUtilities.WorldFootBallAttributeFor_TEST;
import testValues.WorldFootballMatchesDetailsValues;

public class WorldFootballMatchDetailsTest {
	
	WorldFootballMatchesDetailsValues matchesWorldFootballMatchDetailsValue = new WorldFootballMatchesDetailsValues();
    public void assertMatches(MatchDetails actualValue, List<WorldFootBallAttributeFor_TEST> attributes, MatchDetails expectedValue) {
        int limit;
        for (int i = 0; i < attributes.size(); i++) {
            if (attributes.get(i).attributeName.equals("staduim")) {
                assertThat(actualValue.staduim).isEqualTo(expectedValue.staduim);
            } else if (attributes.get(i).attributeName.equals("attendance")) {
                assertThat(actualValue.attendance).isEqualTo(expectedValue.attendance);
            } else if (attributes.get(i).attributeName.equals("matchSummary")) {
                assertThat(actualValue.matchSummary).usingRecursiveComparison().isEqualTo(expectedValue.matchSummary);
            } else if (attributes.get(i).attributeName.equals("goals")) {
                if (expectedValue.goals == null) {
                    Assert.assertEquals(null, actualValue.goals);
                } else {
                    limit = (attributes.get(i).indexes.isEmpty()) ? actualValue.goals.size() : attributes.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributes.get(i).indexes.isEmpty()) ? j : attributes.get(i).indexes.get(j);
                        assertThat(actualValue.goals.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.goals.get(j));
                        j++;
                    }
                }
            } else if (attributes.get(i).attributeName.equals("firstClub")) {
                Assert.assertEquals(expectedValue.firstClub.manager, actualValue.firstClub.manager);
                Assert.assertEquals(expectedValue.firstClub.clubBasicInfo.name, actualValue.firstClub.clubBasicInfo.name);
                limit = (attributes.get(i).indexes.isEmpty()) ? actualValue.firstClub.players.size() : attributes.get(i).indexes.size();
                int j = 0;
                while (j < limit) {
                    int index = (attributes.get(i).indexes.isEmpty()) ? j : attributes.get(i).indexes.get(j);
                    assertThat(actualValue.firstClub.players.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.firstClub.players.get(j));
                    //Assertions.assertThat(actualValue.firstClub.players).contains(expectedValue.firstClub.players.get(j),atIndex(index)) ;
                    j++;
                }
            } else if (attributes.get(i).attributeName.equals("secondClub")) {
                Assert.assertEquals(expectedValue.secondClub.manager, actualValue.secondClub.manager);
                Assert.assertEquals(expectedValue.secondClub.clubBasicInfo.name, actualValue.secondClub.clubBasicInfo.name);
                limit = (attributes.get(i).indexes.isEmpty()) ? actualValue.secondClub.players.size() : attributes.get(i).indexes.size();
                int j = 0;
                while (j < limit) {
                    int index = (attributes.get(i).indexes.isEmpty()) ? j : attributes.get(i).indexes.get(j);
                    assertThat(actualValue.secondClub.players.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.secondClub.players.get(j));
                    j++;
                }
            } else if (attributes.get(i).attributeName.equals("referees")) {
                if (expectedValue.referees == null) {
                    Assert.assertEquals(null, actualValue.referees);
                } else {
                    limit = (attributes.get(i).indexes.isEmpty()) ? actualValue.referees.size() : attributes.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (attributes.get(i).indexes.isEmpty()) ? j : attributes.get(i).indexes.get(j);
                        assertThat(actualValue.referees.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.referees.get(j));
                        j++;
                    }
                }
            }
        }
    }

    @Test
    public void itShouldMatchDetails() {
//ShouldContainAtIndex.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        //https://www.worldfootball.net/report/premier-league-2019-2020-brighton-hove-albion-everton-fc/
        MatchDetails match1ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2019-2020", "brighton-hove-albion", "everton-fc");
        MatchDetails match1ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2019_2020BrightonHoveAlbionEvertonFc();
        List<WorldFootBallAttributeFor_TEST> match1Attributes = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("firstClub"),
                new WorldFootBallAttributeFor_TEST("secondClub"),
                new WorldFootBallAttributeFor_TEST("staduim"),
                new WorldFootBallAttributeFor_TEST("attendance"),
                new WorldFootBallAttributeFor_TEST("goals"),
                new WorldFootBallAttributeFor_TEST("referees"),
                new WorldFootBallAttributeFor_TEST("matchSummary")));

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
        List<WorldFootBallAttributeFor_TEST> match2Attributes = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("firstClub"),
                new WorldFootBallAttributeFor_TEST("secondClub"),
                new WorldFootBallAttributeFor_TEST("staduim"),
                new WorldFootBallAttributeFor_TEST("attendance"),
                new WorldFootBallAttributeFor_TEST("goals"),
                new WorldFootBallAttributeFor_TEST("referees"),
                new WorldFootBallAttributeFor_TEST("matchSummary")));
        assertMatches(match2ActualValue, match2Attributes, match2ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-2020-2021-leeds-united-burnley-fc/
        MatchDetails match3ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "Leeds-United", "Burnley-FC");
        MatchDetails match3ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2020_2021LeedsUnitdBurnleyFc();
        List<WorldFootBallAttributeFor_TEST> match3Attributes = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("goals")));
        assertMatches(match3ActualValue, match3Attributes, match3ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-2020-2021-sheffield-united-everton-fc/
        MatchDetails match4ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "sheffield-united", "everton-fc");
        MatchDetails match4ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2020_2021SheffieldUnitdEvertonFc();
        List<WorldFootBallAttributeFor_TEST> match4Attributes = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("goals")));
        assertMatches(match4ActualValue, match4Attributes, match4ExpectedValue);

    }
}
