package sofaScore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameIecidents.GameIncidents;
import sofaScore.models.gameIecidents.IncidentInGame;
import sofaScore.models.gameStatistics.GameStatistics;
import sofaScore.models.gameStatistics.GameStatisticsForOneItem;
import sofaScore.testData.GameIencidentsValues;
import testUtilities.AssertUtilities;

public class GameCollectorTest {
	
    SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
	GameIencidentsValues iencidentsValues = new GameIencidentsValues();
	AssertUtilities assertUtily = new AssertUtilities();
	
	//delet it after test
	RoundCollector roundtes = new RoundCollector();
	@Test
	public void getGameID() {
		
		RoundGamesID s = roundtes.getGamesIdInRound("Premier League", "2019/2020", "15","");
		for(int i =0 ; i < s.events.size(); i++) {
			System.out.println("i ="+i+"   id="+s.events.get(i));
		}
		
	}
 
	private void printStatistics(GameStatistics game) {
		for(int i =0 ; i <game.statistics.size(); i++) {
			System.out.println(
					game.statistics.get(i).period+"    "+
					game.statistics.get(i).groupName+"    "+
					game.statistics.get(i).name+"    "+
					game.statistics.get(i).home+"    "+
					game.statistics.get(i).away);
		}
	}
	 @Test
	    public void itShouldGetGameStatisticsNew() {

		    //https://api.sofascore.com/api/v1/event/8243423/statistics
		    //https://www.sofascore.com/chelsea-norwich-city/Nnf
		    GameStatistics gameStatistics1Atround3At19_20ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "19/20", "3", 1);
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession","46%","54%")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total shots","6","23")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Hit woodwork","0","0")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Duels","Dribbles","2/10 (20%)","9/11 (82%)")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Passes","Passes","210","255")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Offsides",null,null)));

		    //https://www.sofascore.com/southampton-chelsea/NV
		    //https://api.sofascore.com/api/v1/event/8896911/statistics
		    GameStatistics gameStatistics1Atround5At20_21ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "20/21", "5", 1);
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Blocked shots","3","2")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots extra","Big chances","2","2")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Goalkeeper saves","1","2")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Red cards",null,null)));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots extra","Shots outside box","0","3")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots extra","Counter attack goals",null,null)));

		    
		    // https://www.sofascore.com/everton-leeds-united/JsY
		    //https://api.sofascore.com/api/v1/event/8896979/statistics
		    GameStatistics gameStatistics3Atround10At20_21ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "20/21", "10", 3);
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession","41%","59%")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total shots","15","23")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Yellow cards","1","1")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots extra","Counter attacks","1","1")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession lost","66","70")));

		    //https://www.sofascore.com/newcastle-united-tottenham/IO
		    //https://api.sofascore.com/api/v1/event/8243433/statistics
		    GameStatistics gameStatistics8Atround3At19_20ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "19/20", "3", 8);
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots extra","Big chances missed","1","0")));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots extra","Hit woodwork",null,null)));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Defending","Clearances","2","22")));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red cards",null,null)));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession lost",null,null)));

		    //https://www.sofascore.com/west-ham-united-wolverhampton/dsM
		    //https://api.sofascore.com/api/v1/event/8243543/statistics
		    GameStatistics gameStatistics6Atround15At19_20ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "19/20", "15", 6);
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Passes","Passes","479","496")));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Duels","Dribbles","16/28 (57%)","17/21 (81%)")));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Counter attack shots",null,null)));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red cards",null,null)));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession lost","71","71")));

		 
		    //https://www.sofascore.com/liverpool-aston-villa/PU
		    //https://api.sofascore.com/api/v1/event/5582852/statistics
		    GameStatistics gameStatistics0Atround22At14_15ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "14/15", "22", 0);
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession","46%","54%")));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Possession","Ball possession",null,null)));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Possession","Ball possession",null,null)));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots","Total shots",null,null)));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Possession","Ball possession",null,null)));

		    
		    //https://www.sofascore.com/birmingham-city-bolton-wanderers/fsj
		    //https://api.sofascore.com/api/v1/event/1062836/statistics
		    GameStatistics gameStatistics2Atround38At09_10ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "09/10", "38", 2);
		    assertTrue(gameStatistics2Atround38At09_10ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession",null,null)));
		    assertTrue(gameStatistics2Atround38At09_10ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots extra","Counter attacks",null,null)));

		    
		    

		    
	    }

	
	 @Test
	    public void itShouldGetGameIencidents() {
		 
		 	//https://www.sofascore.com/crystal-palace-sheffield-united/hsp
	        //https://api.sofascore.com/api/v1/event/8896899/incidents
	        GameIncidents game3AtRound3At19_20IencidentsActualValue = sofaScoreCollectorTest.getGameIencidents("Premier League", "20/21", "17", 3);
	        List<IncidentInGame>  game3AtRound3At19_20IencidentsExpectedValueValue = iencidentsValues.getGameEnglishPreimerLeague20_21Crystal_Palace_Sheffield_United_IecidentsExpexted();
	        List <Integer> game3Round3At19_20Indexes = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13);
	        assertUtily.assertArrayToArraySpecificIndexes(game3AtRound3At19_20IencidentsActualValue.incidentInGames ,game3Round3At19_20Indexes , game3AtRound3At19_20IencidentsExpectedValueValue);

	        //https://www.sofascore.com/burnley-manchester-united/gK
	        //https://api.sofascore.com/api/v1/event/9258868/incidents
	        GameIncidents game10AtRound1At19_20IencidentsActualValue = sofaScoreCollectorTest.getGameIencidents("Premier League", "20/21", "1", 10);
	        List<IncidentInGame>  game1AtRound1At19_20IencidentsExpectedValueValue = iencidentsValues.getGameEnglishPreimerLeague20_21Burnley_Manchester_United_IecidentsExpexted();
	        List <Integer> game10Round1At19_20Indexes = Arrays.asList(0,1,2,3,4);
	        assertUtily.assertArrayToArraySpecificIndexes(game10AtRound1At19_20IencidentsActualValue.incidentInGames ,game10Round1At19_20Indexes , game1AtRound1At19_20IencidentsExpectedValueValue);
        
	    }
	 
	 @Test
	 public void itShouldGetGameBasicInformation() {
	      
		 //https://www.sofascore.com/crystal-palace-newcastle-united/hO
		 //https://api.sofascore.com/api/v1/event/8896999
		 GameBasicInformation game1AtRound10At20_21ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "20/21", "10", 0);
		 assertThat(game1AtRound10At20_21ActualValue.event.homeTeam.name).isEqualTo("Crystal Palace");
	     assertThat(game1AtRound10At20_21ActualValue.event.awayTeam.name).isEqualTo("Newcastle United");
	     
	     //https://www.sofascore.com/fulham-arsenal/RsT
	     //https://mobile.sofascore.com/api/v1/event/8896967
		 GameBasicInformation game1AtRound1At20_21ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "20/21", "1", 0);
		 assertThat(game1AtRound1At20_21ActualValue.event.homeTeam.name).isEqualTo("Fulham");
		 assertThat(game1AtRound1At20_21ActualValue.event.awayTeam.name).isEqualTo("Arsenal");
		 assertThat(game1AtRound1At20_21ActualValue.event.homeScore.period1).isEqualTo(0);

		 //https://www.sofascore.com/crystal-palace-bournemouth/hkb
		 //https://api.sofascore.com/api/v1/event/8243556
		 GameBasicInformation game1AtRound1At19_20ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "19/20", "15", 0);
		 assertThat(game1AtRound1At19_20ActualValue.event.homeTeam.name).isEqualTo("Crystal Palace");
		 assertThat(game1AtRound1At19_20ActualValue.event.roundInfo.round).isEqualTo(15);

	 }
}
