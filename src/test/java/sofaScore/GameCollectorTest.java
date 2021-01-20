package sofaScore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import sofaScore.models.gameBasicInformation.Game;
import sofaScore.models.gameIecidents.GameIecidents;
import sofaScore.models.gameIecidents.Iencident;
import sofaScore.models.gameStatistics.GameStatistic;
import sofaScore.models.gameStatistics.GameStatisticNew;
import sofaScore.models.gameStatistics.GameStatisticsForOneAttributeNew;
import sofaScore.models.gameStatistics.ItemStatisticsInGroup;
import sofaScore.testData.GameIencidentsValues;
import testUtilities.AssertUtilities;

public class GameCollectorTest {
    SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
    GameCollector gameCollector = new GameCollector();
	GameIencidentsValues iencidentsValues = new GameIencidentsValues();
	AssertUtilities assertUtily = new AssertUtilities();
	
	 @Test
	    public void itShouldGetGameStatistics() {
 
	        GameStatistic game1Atround3At19_20StatisticTopScoreActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "19/20", "3", 1);

	        assertThat("ALL").isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(0).period);
	        assertThat("1ST").isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(1).period);
	        assertThat("TVData").isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(2).groups.get(2).groupName);

	        ItemStatisticsInGroup game1Atround3At19_20_ALL_Possession_Info = new ItemStatisticsInGroup("Ball possession", "46%", "54%");
	        assertThat(game1Atround3At19_20_ALL_Possession_Info).usingRecursiveComparison().isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(0).groups.get(0).statisticsItems.get(0));

	        ItemStatisticsInGroup game1Atround3At19_20_ALL_Total_Shots_Info = new ItemStatisticsInGroup("Total shots", "6", "23");
	        assertThat(game1Atround3At19_20_ALL_Total_Shots_Info).usingRecursiveComparison().isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(0).groups.get(1).statisticsItems.get(0));

	        ItemStatisticsInGroup game1Atround3At19_20_1ST_Blocked_Shots_Info = new ItemStatisticsInGroup("Blocked shots", "0", "5");
	        assertThat(game1Atround3At19_20_1ST_Blocked_Shots_Info).usingRecursiveComparison().isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(1).groups.get(1).statisticsItems.get(3));

	        ItemStatisticsInGroup game1Atround3At19_20_1ST_Goalkeeper_Saves_Info = new ItemStatisticsInGroup("Goalkeeper saves", "2", "2");
	        assertThat(game1Atround3At19_20_1ST_Goalkeeper_Saves_Info).usingRecursiveComparison().isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(1).groups.get(3).statisticsItems.get(6));

	        ItemStatisticsInGroup game1Atround3At19_20_2ND_Long_Balls_Info = new ItemStatisticsInGroup("Long balls", "5/28 (18%)", "11/23 (48%)");
	        assertThat(game1Atround3At19_20_2ND_Long_Balls_Info).usingRecursiveComparison().isEqualTo(game1Atround3At19_20StatisticTopScoreActualValue.statistics.get(2).groups.get(4).statisticsItems.get(2));

	        GameStatistic game5Atround8At20_21StatisticTopScoreActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "20/21", "8", 5);
	        assertThat("2ND").isEqualTo(game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(2).period);
	        assertThat("Shots extra").isEqualTo(game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(1).groups.get(3).groupName);
	        assertThat("TVData").isEqualTo(game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(2).groups.get(2).groupName);

	        ItemStatisticsInGroup game5Atround8At20_21_ALL_Possession_Info = new ItemStatisticsInGroup("Ball possession", "53%", "47%");
	        assertThat(game5Atround8At20_21_ALL_Possession_Info).usingRecursiveComparison().isEqualTo(game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(0).groups.get(0).statisticsItems.get(0));

	        ItemStatisticsInGroup game5Atround8At20_21_ALL_Shots_Off_Target_Info = new ItemStatisticsInGroup("Shots off target", "8", "4");
	        assertThat(game5Atround8At20_21_ALL_Shots_Off_Target_Info).usingRecursiveComparison().isEqualTo(game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(0).groups.get(1).statisticsItems.get(2));

	        Assert.assertEquals(7, game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(2).groups.size());

	        Assert.assertEquals(4, game5Atround8At20_21StatisticTopScoreActualValue.statistics.get(2).groups.get(5).statisticsItems.size());

	    }
	 
	 @Test
	    public void itShouldGetGameStatisticsNew() {

		 GameStatisticNew game1Atround3At19_20StatisticTopScoreActualValue = sofaScoreCollectorTest.getGameNewStatistics("Premier League", "19/20", "3", 1);
	       // System.out.println(game1Atround3At19_20StatisticTopScoreActualValue.statistics);
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
	        
		 Game game1AtRound10At20_21ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "20/21", "10", 0);
	     //game id 8896999
		 assertThat(game1AtRound10At20_21ActualValue.event.homeTeam.name).isEqualTo("Crystal Palace");
	     assertThat(game1AtRound10At20_21ActualValue.event.awayTeam.name).isEqualTo("Newcastle United");
	     
		 Game game1AtRound1At20_21ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "20/21", "1", 0);
		 //game id 8896967
		 assertThat(game1AtRound1At20_21ActualValue.event.homeTeam.name).isEqualTo("Fulham");
		 assertThat(game1AtRound1At20_21ActualValue.event.awayTeam.name).isEqualTo("Arsenal");
		 assertThat(game1AtRound1At20_21ActualValue.event.homeScore.period1).isEqualTo(0);
		 
		 Game game1AtRound1At19_20ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "19/20", "15", 0);
		 assertThat(game1AtRound1At19_20ActualValue.event.homeTeam.name).isEqualTo("Crystal Palace");
		 assertThat(game1AtRound1At19_20ActualValue.event.roundInfo.round).isEqualTo(15);

	 }
}
