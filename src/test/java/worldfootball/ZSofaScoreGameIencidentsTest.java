package worldfootball;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;


import worldfootball.testData.SofaScoreGameIencidentsValues;
import sofaScore.SofaScoreCollector;
import sofaScore.models.GameIecidents;
import sofaScore.models.Iencident;
import testUtilities.AssertUtilities;

public class ZSofaScoreGameIencidentsTest {
	
	SofaScoreGameIencidentsValues sofaScoreIencidentsValues = new SofaScoreGameIencidentsValues();
	AssertUtilities assertUtily = new AssertUtilities();
	@Test
    public void itShouldGetGameIencidentsSofaScore() {
        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
        
        GameIecidents game3AtRound3At19_20IencidentsActualValue = sofaScoreCollectorTest.getGameIencidents("Premier League", "20/21", "17", 3);
        List<Iencident>  game3AtRound3At19_20IencidentsExpectedValueValue = sofaScoreIencidentsValues.getGameEnglishPreimerLeague20_21Crystal_Palace_Sheffield_United_IecidentsExpexted();
        List <Integer> game3Round3At19_20Indexes = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13);
        assertUtily.assertArrayToArraySpecificIndexes(game3AtRound3At19_20IencidentsActualValue.iecidents ,game3Round3At19_20Indexes , game3AtRound3At19_20IencidentsExpectedValueValue);

        GameIecidents game10AtRound1At19_20IencidentsActualValue = sofaScoreCollectorTest.getGameIencidents("Premier League", "20/21", "1", 10);
        List<Iencident>  game1AtRound1At19_20IencidentsExpectedValueValue = sofaScoreIencidentsValues.getGameEnglishPreimerLeague20_21Burnley_Manchester_United_IecidentsExpexted();
        List <Integer> game10Round1At19_20Indexes = Arrays.asList(0,1,2,3,4);
        assertUtily.assertArrayToArraySpecificIndexes(game10AtRound1At19_20IencidentsActualValue.iecidents ,game10Round1At19_20Indexes , game1AtRound1At19_20IencidentsExpectedValueValue);


        
    }
}
