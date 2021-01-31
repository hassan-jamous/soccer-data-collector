package sofaScore;

import java.util.List;
import org.junit.Test;
import sofaScore.models.RoundInformation.GameID;
import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.testData.GamesIdInRoundValues;
import testUtilities.AssertUtilities;

public class RoundCollectorTest {
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();
    RoundCollector roundCollector = new RoundCollector();
	GamesIdInRoundValues gameIDInRoundSofaScoreValues = new sofaScore.testData.GamesIdInRoundValues();
	
	@Test
    public void itShouldgetGamesIDInRound() {

        RoundGamesID gamesIdActualValueEnglishPreimerLeague19_20Round3 = roundCollector.getGamesIdInRound("Premier League", "2019/2020", "3" ,"");
        List<GameID> gamesIdExpectedValueEnglishPreimerLeague19_20Round3 = gameIDInRoundSofaScoreValues.getEnglishPreimerLeague19_20Round3();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(gamesIdActualValueEnglishPreimerLeague19_20Round3.events, null, gamesIdExpectedValueEnglishPreimerLeague19_20Round3);
       
        RoundGamesID gamesIdActualValueEnglishPreimerLeague18_19Round5 = roundCollector.getGamesIdInRound("Premier League", "2018/2019", "5" ,"");
        List<GameID> gamesIdExpectedValueEnglishPreimerLeague18_19Round5 = gameIDInRoundSofaScoreValues.getEnglishPreimerLeague18_19Round5();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(gamesIdActualValueEnglishPreimerLeague18_19Round5.events, null, gamesIdExpectedValueEnglishPreimerLeague18_19Round5);

    }

}
