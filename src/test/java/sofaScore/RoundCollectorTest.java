package sofaScore;

import java.util.List;
import org.junit.Test;
import sofaScore.models.RoundInformation.GameID;
import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.testData.GamesIdInRoundValues;
import testUtilities.AssertUtilities;

public class RoundCollectorTest {
    SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();
	GamesIdInRoundValues gameIDInRoundSofaScoreValues = new sofaScore.testData.GamesIdInRoundValues();
	
	@Test
    public void itShouldgetGamesIDInRound() {

        RoundGamesID gamesIdActualValueEnglishPreimerLeague19_20Round3 = sofaScoreCollectorTest.getGamesIdInRound("Premier League", "19/20", "3");
        List<GameID> gamesIdExpectedValueEnglishPreimerLeague19_20Round3 = gameIDInRoundSofaScoreValues.getEnglishPreimerLeague19_20Round3();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(gamesIdActualValueEnglishPreimerLeague19_20Round3.events, null, gamesIdExpectedValueEnglishPreimerLeague19_20Round3);
       
        RoundGamesID gamesIdActualValueEnglishPreimerLeague18_19Round5 = sofaScoreCollectorTest.getGamesIdInRound("Premier League", "18/19", "5");
        List<GameID> gamesIdExpectedValueEnglishPreimerLeague18_19Round5 = gameIDInRoundSofaScoreValues.getEnglishPreimerLeague18_19Round5();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(gamesIdActualValueEnglishPreimerLeague18_19Round5.events, null, gamesIdExpectedValueEnglishPreimerLeague18_19Round5);

    }
		
	@Test 
	public void itShouldWriteRoundStatistic() {
		//roundContloler.writeRound("Premier League", "19/20", "1");
	}
	
}
