package collector;


import models.TableOfLeague;
import org.junit.Assert;
import org.junit.Test;

public class ScreenScraperTest {

    @Test
    public void itShouldGetTheRoundInformation() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        TableOfLeague tableOfLeagueActualValue = screenScraperUnderTest.getResultOfCompetition("1960-1961");
        TableOfLeague expectedValue = new TableOfLeague("1999-1975");

        Assert.assertEquals(expectedValue.getRound("Round1"), tableOfLeagueActualValue.getRound("Round1"));

    }

    @Test
    public void itShouldThrowExceptionIfFoundDoesNotExist() {

    }

}