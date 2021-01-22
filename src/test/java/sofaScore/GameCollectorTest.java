package sofaScore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameIecidents.GameIecidents;
import sofaScore.models.gameIecidents.Iencident;
import sofaScore.models.gameStatistics.GameStatisticNew;
import sofaScore.models.gameStatistics.GameStatisticsForOneAttributeNew;
import sofaScore.testData.GameIencidentsValues;
import testUtilities.AssertUtilities;

public class GameCollectorTest {
	
    SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
	GameIencidentsValues iencidentsValues = new GameIencidentsValues();
	AssertUtilities assertUtily = new AssertUtilities();
 
	 @Test
	    public void itShouldGetGameStatisticsNew() {

		    GameStatisticNew gameStatistics1Atround3At19_20ActualValue = sofaScoreCollectorTest.getGameNewStatisticsNew("Premier League", "19/20", "3", 1);
		    //gameId =8243423
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneAttributeNew("ALL","Possession","Ball possession","46%","54%")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneAttributeNew("ALL","Shots","Total shots","6","23")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneAttributeNew("1ST","Shots extra","Hit woodwork","0","0")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneAttributeNew("1ST","Duels","Dribbles","2/10 (20%)","9/11 (82%)")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneAttributeNew("2ND","Passes","Passes","210","255")));
		    
		    GameStatisticNew gameStatistics3Atround10At20_21ActualValue = sofaScoreCollectorTest.getGameNewStatisticsNew("Premier League", "20/21", "10", 3);
		    //gameId =8896979
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneAttributeNew("ALL","Possession","Ball possession","41%","59%")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneAttributeNew("ALL","Shots","Total shots","15","23")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneAttributeNew("2ND","TVData","Yellow cards","1","1")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneAttributeNew("2ND","Shots extra","Counter attacks","1","1")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneAttributeNew("2ND","Duels","Possession lost","66","70")));

	    }
	 @Test
	    public void itShouldGetGameIencidents() {
	        
	        GameIecidents game3AtRound3At19_20IencidentsActualValue = sofaScoreCollectorTest.getGameIencidents("Premier League", "20/21", "17", 3);
	        List<Iencident>  game3AtRound3At19_20IencidentsExpectedValueValue = iencidentsValues.getGameEnglishPreimerLeague20_21Crystal_Palace_Sheffield_United_IecidentsExpexted();
	        List <Integer> game3Round3At19_20Indexes = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13);
	        assertUtily.assertArrayToArraySpecificIndexes(game3AtRound3At19_20IencidentsActualValue.iecidents ,game3Round3At19_20Indexes , game3AtRound3At19_20IencidentsExpectedValueValue);

	        GameIecidents game10AtRound1At19_20IencidentsActualValue = sofaScoreCollectorTest.getGameIencidents("Premier League", "20/21", "1", 10);
	        List<Iencident>  game1AtRound1At19_20IencidentsExpectedValueValue = iencidentsValues.getGameEnglishPreimerLeague20_21Burnley_Manchester_United_IecidentsExpexted();
	        List <Integer> game10Round1At19_20Indexes = Arrays.asList(0,1,2,3,4);
	        assertUtily.assertArrayToArraySpecificIndexes(game10AtRound1At19_20IencidentsActualValue.iecidents ,game10Round1At19_20Indexes , game1AtRound1At19_20IencidentsExpectedValueValue);
        
	    }
	 
	 @Test
	 public void itShouldGetGameBasicInformation() {
	        
		 GameBasicInformation game1AtRound10At20_21ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "20/21", "10", 0);
	     //game id 8896999
		 assertThat(game1AtRound10At20_21ActualValue.event.homeTeam.name).isEqualTo("Crystal Palace");
	     assertThat(game1AtRound10At20_21ActualValue.event.awayTeam.name).isEqualTo("Newcastle United");
	     
		 GameBasicInformation game1AtRound1At20_21ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "20/21", "1", 0);
		 //game id 8896967
		 assertThat(game1AtRound1At20_21ActualValue.event.homeTeam.name).isEqualTo("Fulham");
		 assertThat(game1AtRound1At20_21ActualValue.event.awayTeam.name).isEqualTo("Arsenal");
		 assertThat(game1AtRound1At20_21ActualValue.event.homeScore.period1).isEqualTo(0);
		 
		 GameBasicInformation game1AtRound1At19_20ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "19/20", "15", 0);
		 assertThat(game1AtRound1At19_20ActualValue.event.homeTeam.name).isEqualTo("Crystal Palace");
		 assertThat(game1AtRound1At19_20ActualValue.event.roundInfo.round).isEqualTo(15);

	 }
}
