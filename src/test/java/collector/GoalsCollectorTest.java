package collector;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import collector.testData.WorldFootballEnglishPreimerLeagueGoalsValues;


import models.Goal;
import testUtilities.AssertUtilities;

public class GoalsCollectorTest {
	
	WorldFootballEnglishPreimerLeagueGoalsValues goalsWorldFootBallValues = new WorldFootballEnglishPreimerLeagueGoalsValues();
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();

	@Test
    public void itShouldGetGameGoals() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<Goal> goals2020_2021BrightonHoveAlbionVsBurnleyFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2020-2021", "brighton-hove-albion", "burnley-fc");
        Assert.assertEquals(null, goals2020_2021BrightonHoveAlbionVsBurnleyFcActualValue);

        ArrayList<Goal> goals2017_2018LiverpoolFcBrightonHoveAlbionActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2017-2018", "liverpool-fc", "brighton-hove-albion");
        List<Goal> goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue = goalsWorldFootBallValues.getgoals2017_2018LiverpoolFcBrightonHoveAlbionExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals2017_2018LiverpoolFcBrightonHoveAlbionActualValue, null,goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue);

        ArrayList<Goal> goals2015_2016ArsenalFcAstonVillaActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2015-2016", "arsenal-fc", "aston-villa");
        List<Goal> goals2015_2016ArsenalFcAstonVillaExpectedValue = goalsWorldFootBallValues.goals2015_2016ArsenalFcAstonVillaExpectedValue();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals2015_2016ArsenalFcAstonVillaActualValue, null, goals2015_2016ArsenalFcAstonVillaExpectedValue);

        ArrayList<Goal> goals2015_2016SunderlandAfcChelseaFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2015-2016", "sunderland-afc", "chelsea-fc");
        List<Goal> goals2015_2016SunderlandAfcChelseaFcExpectedValue = goalsWorldFootBallValues.goals2015_2016SunderlandAfcChelseaFcExpectedValue();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals2015_2016SunderlandAfcChelseaFcActualValue,null, goals2015_2016SunderlandAfcChelseaFcExpectedValue);

        ArrayList<Goal> goals2000_2001BradfordCityLeicesterCityActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2000-2001", "bradford-city", "leicester-city");
        Assert.assertEquals(null, goals2000_2001BradfordCityLeicesterCityActualValue);

        ArrayList<Goal> goals2000_2001LeedsUnitedEvertonFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2000-2001", "leeds-united", "everton-fc");
        List<Goal> goals2000_2001LeedsUnitedEvertonFcExpectedValue = goalsWorldFootBallValues.goals2000_2001LeedsUnitedEvertonFcExpectedValue();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals2000_2001LeedsUnitedEvertonFcActualValue,null, goals2000_2001LeedsUnitedEvertonFcExpectedValue);

        ArrayList<Goal> goals1998_1999ArsenalFcAstonVillaActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1998-1999", "arsenal-fc", "aston-villa");
        List<Goal> goals1998_1999ArsenalFcAstonVillaExpected = goalsWorldFootBallValues.getgoals1998_1999ArsenalFcAstonVillaExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals1998_1999ArsenalFcAstonVillaActualValue, null, goals1998_1999ArsenalFcAstonVillaExpected);

        ArrayList<Goal> goals1996_1997ManchesterUnitedWestHamUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1996-1997", "manchester-united", "west-ham-united");
        List<Goal> goals1996_1997ManchesterUnitedWestHamUnitedExpected = goalsWorldFootBallValues.goals1996_1997ManchesterUnitedWestHamUnitedExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals1996_1997ManchesterUnitedWestHamUnitedActualValue, null, goals1996_1997ManchesterUnitedWestHamUnitedExpected);

        ArrayList<Goal> goals1992_1993LiverpoolFcNottinghamForestActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1992-1993", "liverpool-fc", "nottingham-forest");
        Assert.assertEquals(null, goals1992_1993LiverpoolFcNottinghamForestActualValue);

        ArrayList<Goal> goals1992_1993ChelseaFcSheffieldUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1992-1993", "chelsea-fc", "sheffield-united");
        List<Goal> goals1992_1993ChelseaFcSheffieldUnitedExpected = goalsWorldFootBallValues.goals1992_1993ChelseaFcSheffieldUnitedExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals1992_1993ChelseaFcSheffieldUnitedActualValue, null, goals1992_1993ChelseaFcSheffieldUnitedExpected);

        ArrayList<Goal> goals1983_1984TottenhamHotspurManchesterUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1983-1984", "tottenham-hotspur", "manchester-united");
        List<Goal> goals1983_1984TottenhamHotspurManchesterUnitedExpected = goalsWorldFootBallValues.goals1983_1984TottenhamHotspurManchesterUnitedExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals1983_1984TottenhamHotspurManchesterUnitedActualValue,null, goals1983_1984TottenhamHotspurManchesterUnitedExpected);

        ArrayList<Goal> goals1976_1977LeedsUnitedCoventryCityActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1976-1977", "leeds-united", "coventry-city");
        List<Goal> goals1976_1977LeedsUnitedCoventryCityExpected = goalsWorldFootBallValues.goals1976_1977LeedsUnitedCoventryCityExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals1976_1977LeedsUnitedCoventryCityActualValue, null, goals1976_1977LeedsUnitedCoventryCityExpected);

        ArrayList<Goal> goals1963_1964SheffieldUnitedBurnleyFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1963-1964", "sheffield-united", "burnley-fc");
        List<Goal> goals1963_1964SheffieldUnitedBurnleyFcExpected = goalsWorldFootBallValues.goals1963_1964SheffieldUnitedBurnleyFcExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals1963_1964SheffieldUnitedBurnleyFcActualValue,null, goals1963_1964SheffieldUnitedBurnleyFcExpected);

        ArrayList<Goal> goals1956_1957SheffieldWednesdayChelseaFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "sheffield-wednesday", "chelsea-fc");
        List<Goal> goals1956_1957SheffieldWednesdayChelseaFcExpectedValue = goalsWorldFootBallValues.goals1956_1957SheffieldWednesdayChelseaFcExpectedValue();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals1956_1957SheffieldWednesdayChelseaFcActualValue,null, goals1956_1957SheffieldWednesdayChelseaFcExpectedValue);

        ArrayList<Goal> goals1956_1957TottenhamHotspurLeedsUnitedActualVlaue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "tottenham-hotspur", "leeds-united");
        List<Goal> goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue = goalsWorldFootBallValues.goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals1956_1957TottenhamHotspurLeedsUnitedActualVlaue,null, goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue);

        ArrayList<Goal> goalsActualValueoldGoalZeroToZero = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "aston-villa", "west-bromwich-albion");
        Assert.assertEquals(null, goalsActualValueoldGoalZeroToZero);

        ArrayList<Goal> goals1946_1947LeedsUnitedSunderlandAfcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1946-1947", "leeds-united", "sunderland-afc");
        List<Goal> goals1946_1947LeedsUnitedSunderlandAfcExpected = goalsWorldFootBallValues.goals1946_1947LeedsUnitedSunderlandAfcExpected();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(goals1946_1947LeedsUnitedSunderlandAfcActualValue,null, goals1946_1947LeedsUnitedSunderlandAfcExpected);


    }

}

