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
		
		RoundGamesID s = roundtes.getGamesIdInRound("LaLiga", "2020/2021", "2","");
		for(int i =0 ; i < s.events.size(); i++) {
			//System.out.println("i ="+i+"   id="+s.events.get(i));
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
	    public void itShouldGetGameStatistics() {

		    //https://www.sofascore.com/southampton-chelsea/NV
		    //https://api.sofascore.com/api/v1/event/8896911/statistics
		    GameStatistics gameStatistics1Atround5At20_21ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2020/2021", "5", 1);
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Blocked shots","3","2")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots extra","Big chances","2","2")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Goalkeeper saves","1","2")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Red cards",null,null)));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots extra","Shots outside box","0","3")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots extra","Counter attack goals",null,null)));
		    
		    // https://www.sofascore.com/everton-leeds-united/JsY
		    //https://api.sofascore.com/api/v1/event/8896979/statistics
		    GameStatistics gameStatistics3Atround10At20_21ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2020/2021", "10", 3);
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession","41%","59%")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total shots","15","23")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Yellow cards","1","1")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots extra","Counter attacks","1","1")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession lost","66","70")));

		    //https://api.sofascore.com/api/v1/event/8243423/statistics
		    //https://www.sofascore.com/chelsea-norwich-city/Nnf
		    GameStatistics gameStatistics1Atround3At19_20ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2019/2020", "3", 1);
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession","46%","54%")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total shots","6","23")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Hit woodwork","0","0")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Duels","Dribbles","2/10 (20%)","9/11 (82%)")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Passes","Passes","210","255")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Offsides",null,null)));

		    //https://www.sofascore.com/newcastle-united-tottenham/IO
		    //https://api.sofascore.com/api/v1/event/8243433/statistics
		    GameStatistics gameStatistics8Atround3At19_20ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2019/2020", "3", 8);
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots extra","Big chances missed","1","0")));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots extra","Hit woodwork",null,null)));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Defending","Clearances","2","22")));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red cards",null,null)));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession lost",null,null)));

		    //https://www.sofascore.com/west-ham-united-wolverhampton/dsM
		    //https://api.sofascore.com/api/v1/event/8243543/statistics
		    GameStatistics gameStatistics6Atround15At19_20ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2019/2020", "15", 6);
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Passes","Passes","479","496")));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Duels","Dribbles","16/28 (57%)","17/21 (81%)")));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Counter attack shots",null,null)));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red cards",null,null)));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession lost","71","71")));
		 
		    //https://www.sofascore.com/manchester-united-tottenham/IsK
		    //https://api.sofascore.com/api/v1/event/7437748/statistics
		    GameStatistics gameStatistics0Atround10At17_18ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2017/2018", "10", 0);
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total shots","11","13")));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Corner kicks","6","3")));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Fouls","12","14")));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Defending","Clearances",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Big chances",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Fouls",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Duels","Possession lost",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Defending","Tackles",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red cards",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession lost",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Defending","Tackles",null,null)));

		    
		    //https://www.sofascore.com/manchester-united-leicester-city/GK
		    //https://api.sofascore.com/api/v1/event/7437911/statistics
		    GameStatistics gameStatistics9Atround19At17_18ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2017/2018", "19", 9);
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Shots off target","3","9")));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots extra","Big chances",null,null)));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Counter attack shots",null,null)));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Red cards","0","0")));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red cards","1","0")));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession lost",null,null)));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Defending","Tackles",null,null)));

		    //https://www.sofascore.com/swansea-city-manchester-united/JdCg
		    //https://api.sofascore.com/api/v1/event/6768341/statistics
		    GameStatistics gameStatistics3Atround20At15_16ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2015/2016", "20", 3);
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession","54%","46%")));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total shots","19","9")));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Shots off target","5","3")));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Corner kicks","4","2")));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots extra","Big chances",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Counter attack shots",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Yellow cards","1","0")));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Red cards",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red cards",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession lost",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Defending","Tackles",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Duels won","30","25")));
		    
		    //https://www.sofascore.com/manchester-united-tottenham/IsK
		    //https://api.sofascore.com/api/v1/event/7437748/statistics
		    GameStatistics gameStatistics11Atround30At15_16ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2015/2016", "30", 11);
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession","66%","34%")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total shots","16","5")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Corner kicks","10","2")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Fouls","0","0")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Defending","Clearances",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Shots inside box","5","2")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Passes","Passes","293","175")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Duels","Duels won","34","30")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Defending","Tackles",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Big chances",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Fouls",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Duels","Possession lost",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Defending","Tackles",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red cards",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession lost",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Defending","Tackles",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Offsides","1","0")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots","Shots on target","4","0")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Aerials won","5","6")));

		    //https://www.sofascore.com/liverpool-aston-villa/PU
		    //https://api.sofascore.com/api/v1/event/5582852/statistics
		    GameStatistics gameStatistics0Atround22At14_15ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2014/2015", "22", 0);
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession","46%","54%")));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Possession","Ball possession",null,null)));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Possession","Ball possession",null,null)));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots","Total shots",null,null)));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Possession","Ball possession",null,null)));

		    //https://www.sofascore.com/manchester-united-manchester-city/rK
		    //https://api.sofascore.com/api/v1/event/3965147/statistics
		    GameStatistics gameStatistics9Atround5At13_14ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2013/2014", "5", 9);
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession","45%","55%")));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total shots",null,null)));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Corner kicks","8","4")));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Fouls","8","12")));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Defending","Clearances",null,null)));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Red cards","0","0")));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Possession","Ball possession",null,null)));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots","Total shots",null,null)));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Possession","Ball possession",null,null)));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Possession","Ball possession",null,null)));

		    //https://www.sofascore.com/birmingham-city-bolton-wanderers/fsj
		    //https://api.sofascore.com/api/v1/event/1062836/statistics
		    GameStatistics gameStatistics2Atround38At09_10ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2009/2010", "38", 2);
		    assertTrue(gameStatistics2Atround38At09_10ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession",null,null)));
		    assertTrue(gameStatistics2Atround38At09_10ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots extra","Counter attacks",null,null)));

		    //https://www.sofascore.com/cadiz-huesca/NObspKj
		    //https://api.sofascore.com/api/v1/event/8966517/statistics
		    GameStatistics laLiagaGameStatistics6Atround2At20_21ActualValue = sofaScoreCollectorTest.getGameStatistics("LaLiga", "2020/2021", "2", 6);
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball possession","70%","30")));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Blocked shots","3","2")));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots extra","Big chances","2","2")));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Red cards",null,null)));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots extra","Goalkeeper saves","1","2")));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots extra","Shots outside box","0","3")));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots extra","Counter attack goals",null,null)));
		    
	    }

	
	 @Test
	    public void itShouldGetGameIencidents() {
		 
		 	//https://www.sofascore.com/crystal-palace-sheffield-united/hsp
	        //https://api.sofascore.com/api/v1/event/8896899/incidents
	        GameIncidents game3AtRound3At19_20IencidentsActualValue = sofaScoreCollectorTest.getGameIencidents("Premier League", "2020/2021", "17", 3);
	        List<IncidentInGame>  game3AtRound3At19_20IencidentsExpectedValueValue = iencidentsValues.getGameEnglishPreimerLeague20_21Crystal_Palace_Sheffield_United_IecidentsExpexted();
	        List <Integer> game3Round3At19_20Indexes = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13);
	        assertUtily.assertArrayToArraySpecificIndexes(game3AtRound3At19_20IencidentsActualValue.incidentInGames ,game3Round3At19_20Indexes , game3AtRound3At19_20IencidentsExpectedValueValue);

	        //https://www.sofascore.com/burnley-manchester-united/gK
	        //https://api.sofascore.com/api/v1/event/9258868/incidents
	        GameIncidents game10AtRound1At19_20IencidentsActualValue = sofaScoreCollectorTest.getGameIencidents("Premier League", "2020/2021", "1", 10);
	        List<IncidentInGame>  game1AtRound1At19_20IencidentsExpectedValueValue = iencidentsValues.getGameEnglishPreimerLeague20_21Burnley_Manchester_United_IecidentsExpexted();
	        List <Integer> game10Round1At19_20Indexes = Arrays.asList(0,1,2,3,4);
	        assertUtily.assertArrayToArraySpecificIndexes(game10AtRound1At19_20IencidentsActualValue.incidentInGames ,game10Round1At19_20Indexes , game1AtRound1At19_20IencidentsExpectedValueValue);
        
	    }
	 
	 @Test
	 public void itShouldGetGameBasicInformation() {
	      
		 //https://www.sofascore.com/crystal-palace-newcastle-united/hO
		 //https://api.sofascore.com/api/v1/event/8896999
		 GameBasicInformation game1AtRound10At20_21ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "2020/2021", "10", 0);
		 assertThat(game1AtRound10At20_21ActualValue.event.homeTeam.name).isEqualTo("Crystal Palace");
	     assertThat(game1AtRound10At20_21ActualValue.event.awayTeam.name).isEqualTo("Newcastle United");
	     
	     //https://www.sofascore.com/fulham-arsenal/RsT
	     //https://mobile.sofascore.com/api/v1/event/8896967
		 GameBasicInformation game1AtRound1At20_21ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "2020/2021", "1", 0);
		 assertThat(game1AtRound1At20_21ActualValue.event.homeTeam.name).isEqualTo("Fulham");
		 assertThat(game1AtRound1At20_21ActualValue.event.awayTeam.name).isEqualTo("Arsenal");
		 assertThat(game1AtRound1At20_21ActualValue.event.homeScore.period1).isEqualTo(0);

		 //https://www.sofascore.com/crystal-palace-bournemouth/hkb
		 //https://api.sofascore.com/api/v1/event/8243556
		 GameBasicInformation game1AtRound1At19_20ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "2019/2020", "15", 0);
		 assertThat(game1AtRound1At19_20ActualValue.event.homeTeam.name).isEqualTo("Crystal Palace");
		 assertThat(game1AtRound1At19_20ActualValue.event.roundInfo.round).isEqualTo(15);

	 }
}
