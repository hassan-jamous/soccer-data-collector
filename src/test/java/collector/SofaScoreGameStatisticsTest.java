package collector;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Test;

import sofaScore.SofaScoreCollector;
import sofaScoreModels.GameStatistic;
import sofaScoreModels.ItemStatisticsInGroup;

public class SofaScoreGameStatisticsTest {
	 @Test
	    public void itShouldGetGameStatisticSofaScore() {

	        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();

	        GameStatistic game1Atround3At19_20StatisticTopScoreActualValue = sofaScoreCollectorTest.getGameStatistic("Premier League", "19/20", "3", 1);

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

	        GameStatistic game5Atround8At20_21StatisticTopScoreActualValue = sofaScoreCollectorTest.getGameStatistic("Premier League", "20/21", "8", 5);

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
}
