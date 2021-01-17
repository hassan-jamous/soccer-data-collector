package worldfootball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import worldfootball.models.PlayerAtMatch;
import worldfootball.testData.MatchesDetailsValues;
import worldfootball.models.MatchDetails;
import testUtilities.AssertUtilities;
import testUtilities.ArrayAttributeWithIndexes;

public class MatchCollectorTest {

	MatchesDetailsValues matchesWorldFootballMatchDetailsValue = new MatchesDetailsValues();
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();

    @Test
    public void itShouldMatchDetails() {
    	
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        //https://www.worldfootball.net/report/premier-league-2019-2020-brighton-hove-albion-everton-fc/
        MatchDetails match1ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2019-2020", "brighton-hove-albion", "everton-fc");
        MatchDetails match1ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2019_2020BrightonHoveAlbionEvertonFc();
        List<ArrayAttributeWithIndexes> match1Attributes = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("firstClub"),
                new ArrayAttributeWithIndexes("secondClub"),
                new ArrayAttributeWithIndexes("staduim"),
                new ArrayAttributeWithIndexes("attendance"),
                new ArrayAttributeWithIndexes("goals"),
                new ArrayAttributeWithIndexes("referees"),
                new ArrayAttributeWithIndexes("matchSummary")));

        Comparator<PlayerAtMatch> playerAtMatchComparator = Comparator.comparing(x -> x.playerBasicInfo.name);
        Collections.sort(match1ActualValue.firstClub.players, playerAtMatchComparator);
        Collections.sort(match1ActualValue.secondClub.players, playerAtMatchComparator);
        Collections.sort(match1ExpectedValue.firstClub.players, playerAtMatchComparator);
        Collections.sort(match1ExpectedValue.secondClub.players, playerAtMatchComparator);
        assertMatches(match1ActualValue, match1Attributes, match1ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-1946-1947-brentford-fc-middlesbrough-fc/
        MatchDetails match2ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "1946-1947", "brentford-fc", "middlesbrough-fc");
        MatchDetails match2ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame1946_1947BrentfordFcMiddlesbroughFc();
        Collections.sort(match2ActualValue.firstClub.players, playerAtMatchComparator);
        Collections.sort(match2ActualValue.secondClub.players, playerAtMatchComparator);
        Collections.sort(match2ExpectedValue.firstClub.players, playerAtMatchComparator);
        Collections.sort(match2ExpectedValue.secondClub.players, playerAtMatchComparator);
        List<ArrayAttributeWithIndexes> match2Attributes = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("firstClub"),
                new ArrayAttributeWithIndexes("secondClub"),
                new ArrayAttributeWithIndexes("staduim"),
                new ArrayAttributeWithIndexes("attendance"),
                new ArrayAttributeWithIndexes("goals"),
                new ArrayAttributeWithIndexes("referees"),
                new ArrayAttributeWithIndexes("matchSummary")));
        assertMatches(match2ActualValue, match2Attributes, match2ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-2020-2021-leeds-united-burnley-fc/
        MatchDetails match3ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "Leeds-United", "Burnley-FC");
        MatchDetails match3ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2020_2021LeedsUnitdBurnleyFc();
        List<ArrayAttributeWithIndexes> match3Attributes = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("goals")));
        assertMatches(match3ActualValue, match3Attributes, match3ExpectedValue);

        //https://www.worldfootball.net/report/premier-league-2020-2021-sheffield-united-everton-fc/
        MatchDetails match4ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "sheffield-united", "everton-fc");
        MatchDetails match4ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2020_2021SheffieldUnitdEvertonFc();
        List<ArrayAttributeWithIndexes> match4Attributes = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("goals")));
        assertMatches(match4ActualValue, match4Attributes, match4ExpectedValue);
        
		//https://www.worldfootball.net/report/premier-league-2020-2021-sheffield-united-newcastle-united/
        MatchDetails match5ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "sheffield-united", "newcastle-united");
        MatchDetails match5ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2020_2021SheffieldUnitedNewcastleUnited();
        List<ArrayAttributeWithIndexes> match5Attributes = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("firstClub" , new ArrayList<>(Arrays.asList(10,12))),
                new ArrayAttributeWithIndexes("secondClub" , new ArrayList<>(Arrays.asList(10)))));
        assertMatches(match5ActualValue, match5Attributes, match5ExpectedValue);
        
      //https://www.worldfootball.net/report/premier-league-2020-2021-wolverhampton-wanderers-manchester-united/
      //  MatchDetails match6ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "wolverhampton-wanderers", "manchester-united");
        //MatchDetails match6ExpectedValue = matchesWorldFootballMatchDetailsValue.getGame2020_2021WolverhamptonWanderersManchesterUnited();
        //assertMatches(match6ActualValue, null, match5ExpectedValue);

        
    }
	private void assertMatches(MatchDetails actualValue, List<ArrayAttributeWithIndexes> attributes, MatchDetails expectedValue) {
			
		int numberOfAttributes = (attributes == null)? 7 : attributes.size() ;
		for (int i = 0; i < numberOfAttributes; i++) {
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