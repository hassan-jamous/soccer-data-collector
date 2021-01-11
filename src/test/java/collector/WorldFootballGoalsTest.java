package collector;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import models.Goal;
import testValues.WorldFootballGoalsValues;

public class WorldFootballGoalsTest {
	
	WorldFootballGoalsValues goalsWorldFootBallValues = new WorldFootballGoalsValues();
	
	public void assertGameGoal(ArrayList<Goal> goalsActualValue, List<Goal> goalsExpectedValue) {
        for (int i = 0; i < goalsExpectedValue.size(); i++) {
            assertThat(goalsExpectedValue.get(i)).usingRecursiveComparison().isEqualTo(goalsActualValue.get(i));
        }
    }

    @Test
    public void itShouldGetGameGoals() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<Goal> goals2020_2021BrightonHoveAlbionVsBurnleyFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2020-2021", "brighton-hove-albion", "burnley-fc");
        Assert.assertEquals(null, goals2020_2021BrightonHoveAlbionVsBurnleyFcActualValue);

        ArrayList<Goal> goals2017_2018LiverpoolFcBrightonHoveAlbionActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2017-2018", "liverpool-fc", "brighton-hove-albion");
        List<Goal> goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue = goalsWorldFootBallValues.getGamesGoalsValue("goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue");
        assertGameGoal(goals2017_2018LiverpoolFcBrightonHoveAlbionActualValue, goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue);

        ArrayList<Goal> goals2015_2016ArsenalFcAstonVillaActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2015-2016", "arsenal-fc", "aston-villa");
        List<Goal> goals2015_2016ArsenalFcAstonVillaExpectedValue = goalsWorldFootBallValues.getGamesGoalsValue("goals2015_2016ArsenalFcAstonVillaExpectedValue");
        assertGameGoal(goals2015_2016ArsenalFcAstonVillaActualValue, goals2015_2016ArsenalFcAstonVillaExpectedValue);

        ArrayList<Goal> goals2015_2016SunderlandAfcChelseaFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2015-2016", "sunderland-afc", "chelsea-fc");
        List<Goal> goals2015_2016SunderlandAfcChelseaFcExpectedValue = goalsWorldFootBallValues.getGamesGoalsValue("goals2015_2016SunderlandAfcChelseaFcExpectedValue");
        assertGameGoal(goals2015_2016SunderlandAfcChelseaFcActualValue, goals2015_2016SunderlandAfcChelseaFcExpectedValue);

        ArrayList<Goal> goals2000_2001BradfordCityLeicesterCityActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2000-2001", "bradford-city", "leicester-city");
        Assert.assertEquals(null, goals2000_2001BradfordCityLeicesterCityActualValue);

        ArrayList<Goal> goals2000_2001LeedsUnitedEvertonFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2000-2001", "leeds-united", "everton-fc");
        List<Goal> goals2000_2001LeedsUnitedEvertonFcExpectedValue = goalsWorldFootBallValues.goals2000_2001LeedsUnitedEvertonFcExpectedValue();
        assertGameGoal(goals2000_2001LeedsUnitedEvertonFcActualValue, goals2000_2001LeedsUnitedEvertonFcExpectedValue);

        ArrayList<Goal> goals1998_1999ArsenalFcAstonVillaActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1998-1999", "arsenal-fc", "aston-villa");
        List<Goal> goals1998_1999ArsenalFcAstonVillaExpected = goalsWorldFootBallValues.getgoals1998_1999ArsenalFcAstonVillaExpected();
        assertGameGoal(goals1998_1999ArsenalFcAstonVillaActualValue, goals1998_1999ArsenalFcAstonVillaExpected);

        ArrayList<Goal> goals1996_1997ManchesterUnitedWestHamUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1996-1997", "manchester-united", "west-ham-united");
        List<Goal> goals1996_1997ManchesterUnitedWestHamUnitedExpected = goalsWorldFootBallValues.goals1996_1997ManchesterUnitedWestHamUnitedExpected();
        assertGameGoal(goals1996_1997ManchesterUnitedWestHamUnitedActualValue, goals1996_1997ManchesterUnitedWestHamUnitedExpected);

        ArrayList<Goal> goals1992_1993LiverpoolFcNottinghamForestActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1992-1993", "liverpool-fc", "nottingham-forest");
        Assert.assertEquals(null, goals1992_1993LiverpoolFcNottinghamForestActualValue);

        ArrayList<Goal> goals1992_1993ChelseaFcSheffieldUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1992-1993", "chelsea-fc", "sheffield-united");
        List<Goal> goals1992_1993ChelseaFcSheffieldUnitedExpected = goalsWorldFootBallValues.goals1992_1993ChelseaFcSheffieldUnitedExpected();
        assertGameGoal(goals1992_1993ChelseaFcSheffieldUnitedActualValue, goals1992_1993ChelseaFcSheffieldUnitedExpected);

        ArrayList<Goal> goals1983_1984TottenhamHotspurManchesterUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1983-1984", "tottenham-hotspur", "manchester-united");
        List<Goal> goals1983_1984TottenhamHotspurManchesterUnitedExpected = goalsWorldFootBallValues.goals1983_1984TottenhamHotspurManchesterUnitedExpected();
        assertGameGoal(goals1983_1984TottenhamHotspurManchesterUnitedActualValue, goals1983_1984TottenhamHotspurManchesterUnitedExpected);

        ArrayList<Goal> goals1976_1977LeedsUnitedCoventryCityActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1976-1977", "leeds-united", "coventry-city");
        List<Goal> goals1976_1977LeedsUnitedCoventryCityExpected = goalsWorldFootBallValues.goals1976_1977LeedsUnitedCoventryCityExpected();
        assertGameGoal(goals1976_1977LeedsUnitedCoventryCityActualValue, goals1976_1977LeedsUnitedCoventryCityExpected);

        ArrayList<Goal> goals1963_1964SheffieldUnitedBurnleyFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1963-1964", "sheffield-united", "burnley-fc");
        List<Goal> goals1963_1964SheffieldUnitedBurnleyFcExpected = goalsWorldFootBallValues.goals1963_1964SheffieldUnitedBurnleyFcExpected();
        assertGameGoal(goals1963_1964SheffieldUnitedBurnleyFcActualValue, goals1963_1964SheffieldUnitedBurnleyFcExpected);

        ArrayList<Goal> goals1956_1957SheffieldWednesdayChelseaFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "sheffield-wednesday", "chelsea-fc");
        List<Goal> goals1956_1957SheffieldWednesdayChelseaFcExpectedValue = goalsWorldFootBallValues.goals1956_1957SheffieldWednesdayChelseaFcExpectedValue();
        assertGameGoal(goals1956_1957SheffieldWednesdayChelseaFcActualValue, goals1956_1957SheffieldWednesdayChelseaFcExpectedValue);

        ArrayList<Goal> goals1956_1957TottenhamHotspurLeedsUnitedActualVlaue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "tottenham-hotspur", "leeds-united");
        List<Goal> goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue = goalsWorldFootBallValues.goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue();
        assertGameGoal(goals1956_1957TottenhamHotspurLeedsUnitedActualVlaue, goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue);

        ArrayList<Goal> goalsActualValueoldGoalZeroToZero = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "aston-villa", "west-bromwich-albion");
        Assert.assertEquals(null, goalsActualValueoldGoalZeroToZero);

        ArrayList<Goal> goals1946_1947LeedsUnitedSunderlandAfcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1946-1947", "leeds-united", "sunderland-afc");
        List<Goal> goals1946_1947LeedsUnitedSunderlandAfcExpected = goalsWorldFootBallValues.goals1946_1947LeedsUnitedSunderlandAfcExpected();
        assertGameGoal(goals1946_1947LeedsUnitedSunderlandAfcActualValue, goals1946_1947LeedsUnitedSunderlandAfcExpected);


    }

}
