package collector;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;


import collector.testData.SofaScoreGameIencidentsValues;
import sofaScore.SofaScoreCollector;
import sofaScoreModels.GameIecidents;
import sofaScoreModels.Iencident;
import testUtilities.AssertUtilities;

public class ZSofaScoreGameIencidentsTest {
	
	SofaScoreGameIencidentsValues englishPreimerLeague = new SofaScoreGameIencidentsValues();
	AssertUtilities assertUtily = new AssertUtilities();
	@Test
    public void itShouldGetGameIencidentsSofaScore() {
        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
        GameIecidents game1AtRound3At19_20IencidentsActualValue = sofaScoreCollectorTest.getGameIencidents("Premier League", "20/21", "17", 3);
        List<Iencident>  game1AtRound3At19_20IencidentsExpectedValueValue = englishPreimerLeague.getGameEnglishPreimerLeague20_21Crystal_Palace_Sheffield_United_IecidentsExpexted();
        List <Integer> game1Indexes = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13);
        assertUtily.assertArrayToArraySpecificIndexes(game1AtRound3At19_20IencidentsActualValue.iecidents ,game1Indexes , game1AtRound3At19_20IencidentsExpectedValueValue);

        
    }
}
