package sofaScore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import csvFile.CSVDealerForGetInforamtion;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameIecidents.GameIncidents;
import sofaScore.models.gameIecidents.IncidentInGame;
import sofaScore.models.gameStatistics.GameStatistics;
import sofaScore.models.gameStatistics.GameStatisticsForOneItem;
import sofaScore.testData.GameIencidentsValues;
import testUtilities.AssertUtilities;
import testUtilities.SofaScoreTestHelper;

public class GameCollectorTest {
	
	SofaScoreTestHelper  heleper = new SofaScoreTestHelper(); 
    SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
	GameIencidentsValues iencidentsValues = new GameIencidentsValues();
	AssertUtilities assertUtily = new AssertUtilities();
	CSVDealerForGetInforamtion get = new CSVDealerForGetInforamtion();
	 @Test
	    public void itShouldGetGameStatistics() {

		    //https://www.sofascore.com/southampton-chelsea/NV
		    //https://api.sofascore.com/api/v1/event/8896911/statistics
		    GameStatistics gameStatistics1Atround5At20_21ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2020/2021", "5", 1);
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Blocked_shots","3","2")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots_extra","Big_chances","2","2")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots_extra","Goalkeeper_saves","1","2")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Red_cards",null,null)));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots_extra","Shots_outside_box","0","3")));
		    assertTrue(gameStatistics1Atround5At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots_extra","Counter_attack_goals",null,null)));
		    
		    // https://www.sofascore.com/everton-leeds-united/JsY
		    //https://api.sofascore.com/api/v1/event/8896979/statistics
		    GameStatistics gameStatistics3Atround10At20_21ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2020/2021", "10", 3);
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball_possession","41%","59%")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total_shots","15","23")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Yellow_cards","1","1")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots_extra","Counter_attacks","1","1")));
		    assertTrue(gameStatistics3Atround10At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession_lost","66","70")));

		    //https://api.sofascore.com/api/v1/event/8243423/statistics
		    //https://www.sofascore.com/chelsea-norwich-city/Nnf
		    GameStatistics gameStatistics1Atround3At19_20ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2019/2020", "3", 1);
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball_possession","46%","54%")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total_shots","6","23")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots_extra","Hit_woodwork","0","0")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Duels","Dribbles","2/10 (20%)","9/11 (82%)")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Passes","Passes","210","255")));
		    assertTrue(gameStatistics1Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Offsides",null,null)));

		    //https://www.sofascore.com/newcastle-united-tottenham/IO
		    //https://api.sofascore.com/api/v1/event/8243433/statistics
		    GameStatistics gameStatistics8Atround3At19_20ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2019/2020", "3", 8);
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots_extra","Big_chances_missed","1","0")));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots_extra","Hit_woodwork",null,null)));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Defending","Clearances","2","22")));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red_cards",null,null)));
		    assertTrue(gameStatistics8Atround3At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession_lost",null,null)));

		    //https://www.sofascore.com/west-ham-united-wolverhampton/dsM
		    //https://api.sofascore.com/api/v1/event/8243543/statistics
		    GameStatistics gameStatistics6Atround15At19_20ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2019/2020", "15", 6);
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Passes","Passes","479","496")));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Duels","Dribbles","16/28 (57%)","17/21 (81%)")));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots_extra","Counter_attack_shots",null,null)));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red_cards",null,null)));
		    assertTrue(gameStatistics6Atround15At19_20ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession_lost","71","71")));
		 
		    //https://www.sofascore.com/manchester-united-tottenham/IsK
		    //https://api.sofascore.com/api/v1/event/7437748/statistics
		    GameStatistics gameStatistics0Atround10At17_18ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2017/2018", "10", 0);
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total_shots","11","13")));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Corner_kicks","6","3")));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Fouls","12","14")));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Defending","Clearances",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots_extra","Big_chances",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Fouls",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Duels","Possession_lost",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Defending","Tackles",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red_cards",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession_lost",null,null)));
		    assertTrue(gameStatistics0Atround10At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Defending","Tackles",null,null)));
		    
		    //https://www.sofascore.com/manchester-united-leicester-city/GK
		    //https://api.sofascore.com/api/v1/event/7437911/statistics
		    GameStatistics gameStatistics9Atround19At17_18ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2017/2018", "19", 9);
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Shots_off_target","3","9")));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots_extra","Big_chances",null,null)));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots_extra","Counter_attack_shots",null,null)));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Red_cards","0","0")));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red_cards","1","0")));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession_lost",null,null)));
		    assertTrue(gameStatistics9Atround19At17_18ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Defending","Tackles",null,null)));

		    GameStatistics gameStatistics6Atround18At15_16ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2015/2016", "18", 6);
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball_possession","55%","45%")));
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total_shots","7","9")));
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Shots_off_target","3","3")));
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Corner_kicks","0","7")));
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots_extra","Big_chances",null,null)));
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots_extra","Counter_attack_shots",null,null)));
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Yellow_cards","0","1")));
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Red_cards",null,null)));
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red_cards",null,null)));
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession_lost",null,null)));
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Defending","Tackles",null,null)));
		    assertTrue(gameStatistics6Atround18At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Duels_won","29","22")));
		    
		    //https://www.sofascore.com/swansea-city-manchester-united/JdCg
		    //https://api.sofascore.com/api/v1/event/6768341/statistics
		    GameStatistics gameStatistics3Atround20At15_16ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2015/2016", "20", 3);
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball_possession","54%","46%")));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total_shots","19","9")));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Shots_off_target","5","3")));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Corner_kicks","4","2")));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots_extra","Big_chances",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots_extra","Counter_attack_shots",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Yellow_cards","1","0")));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Red_cards",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red_cards",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession_lost",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Defending","Tackles",null,null)));
		    assertTrue(gameStatistics3Atround20At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Duels_won","30","25")));
		    
		    //https://www.sofascore.com/manchester-united-tottenham/IsK
		    //https://api.sofascore.com/api/v1/event/7437748/statistics
		    GameStatistics gameStatistics11Atround30At15_16ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2015/2016", "30", 11);
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball_possession","66%","34%")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total_shots","16","5")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Corner_kicks","10","2")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Fouls","0","0")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Defending","Clearances",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots_extra","Shots_inside_box","5","2")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Passes","Passes","293","175")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Duels","Duels_won","34","30")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Defending","Tackles",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots_extra","Big_chances",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","TVData","Fouls",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Duels","Possession_lost",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Defending","Tackles",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Red_cards",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Possession_lost",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Defending","Tackles",null,null)));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","TVData","Offsides","1","0")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots","Shots_on_target","4","0")));
		    assertTrue(gameStatistics11Atround30At15_16ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Aerials_won","5","6")));

		    //https://www.sofascore.com/liverpool-aston-villa/PU
		    //https://api.sofascore.com/api/v1/event/5582852/statistics
		    GameStatistics gameStatistics0Atround22At14_15ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2014/2015", "22", 0);
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball_possession","46%","54%")));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Possession","Ball_possession",null,null)));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Possession","Ball_possession",null,null)));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots","Total_shots",null,null)));
		    assertTrue(gameStatistics0Atround22At14_15ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Possession","Ball_possession",null,null)));

		    //https://www.sofascore.com/manchester-united-manchester-city/rK
		    //https://api.sofascore.com/api/v1/event/3965147/statistics
		    GameStatistics gameStatistics9Atround5At13_14ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2013/2014", "5", 9);
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball_possession","45%","55%")));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total_shots",null,null)));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Corner_kicks","8","4")));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Fouls","8","12")));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Defending","Clearances",null,null)));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Red_cards","0","0")));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Possession","Ball_possession",null,null)));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots","Total_shots",null,null)));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Possession","Ball_possession",null,null)));
		    assertTrue(gameStatistics9Atround5At13_14ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Possession","Ball_possession",null,null)));

		    //https://www.sofascore.com/birmingham-city-bolton-wanderers/fsj
		    //https://api.sofascore.com/api/v1/event/1062836/statistics
		    GameStatistics gameStatistics2Atround38At09_10ActualValue = sofaScoreCollectorTest.getGameStatistics("Premier League", "2009/2010", "38", 2);
		    assertTrue(gameStatistics2Atround38At09_10ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball_possession",null,null)));
		    assertTrue(gameStatistics2Atround38At09_10ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots_extra","Counter_attacks",null,null)));

		    //https://www.sofascore.com/cadiz-huesca/NObspKj
		    //https://api.sofascore.com/api/v1/event/8966517/statistics
		    GameStatistics laLiagaGameStatistics6Atround2At20_21ActualValue = sofaScoreCollectorTest.getGameStatistics("LaLiga", "2020/2021", "2", 6);
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball_possession","70%","30%")));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Blocked_shots","1","0")));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots_extra","Big_chances","0","2")));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Red_cards",null,null)));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots_extra","Goalkeeper_saves","0","0")));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots_extra","Shots_outside_box","2","3")));
		    assertTrue(laLiagaGameStatistics6Atround2At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Shots_extra","Counter_attack_goals",null,null)));
		    
		    //https://www.sofascore.com/getafe-sevilla/Igbsjhb
		    //https://api.sofascore.com/api/v1/event/8966455/statistics
		    GameStatistics laLiagaGameStatistics4Atround22At20_21ActualValue = sofaScoreCollectorTest.getGameStatistics("LaLiga", "2020/2021", "22", 4);
		    assertTrue(laLiagaGameStatistics4Atround22At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Possession","Ball_possession","76%","24%")));
		    assertTrue(laLiagaGameStatistics4Atround22At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots","Total_shots","18","4")));
		    assertTrue(laLiagaGameStatistics4Atround22At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Corner_kicks","3","1")));
		    assertTrue(laLiagaGameStatistics4Atround22At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Fouls","10","11")));
		    assertTrue(laLiagaGameStatistics4Atround22At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Defending","Clearances","7","13")));
		    assertTrue(laLiagaGameStatistics4Atround22At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","TVData","Red_cards","0","1")));
		    assertTrue(laLiagaGameStatistics4Atround22At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("ALL","Shots_extra","Counter_attack_goals",null,null)));
		    assertTrue(laLiagaGameStatistics4Atround22At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Possession","Ball_possession","67%","33%")));
		    assertTrue(laLiagaGameStatistics4Atround22At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("FirstHalf","Shots","Total_shots","7","4")));
		    assertTrue(laLiagaGameStatistics4Atround22At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Possession","Ball_possession","83%","17%")));
		    assertTrue(laLiagaGameStatistics4Atround22At20_21ActualValue.containsSatatisticWithValues(new GameStatisticsForOneItem("SecondHalf","Duels","Dribbles","12/14 (86%)","1/1 (100%)")));

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
	 public void itShouldGetGameBasicInformation() throws ParseException {
	      
		 //https://www.sofascore.com/crystal-palace-newcastle-united/hO
		 //https://api.sofascore.com/api/v1/event/8896999
		 GameBasicInformation game0AtRound10At20_21ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "2020/2021", "10", 0);
		 assertThat(game0AtRound10At20_21ActualValue.event.homeTeam.name).isEqualTo("Crystal Palace");
		 assertThat(game0AtRound10At20_21ActualValue.event.awayTeam.name).isEqualTo("Newcastle United");
		 assertThat(game0AtRound10At20_21ActualValue.event.getDateToPrint()).isEqualTo("2020/Nov/27 22:00:00");

	     //https://www.sofascore.com/fulham-arsenal/RsT
	     //https://mobile.sofascore.com/api/v1/event/8896967
		 GameBasicInformation game0AtRound1At20_21ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "2020/2021", "1", 0);
		 assertThat(game0AtRound1At20_21ActualValue.event.homeTeam.name).isEqualTo("Fulham");
		 assertThat(game0AtRound1At20_21ActualValue.event.awayTeam.name).isEqualTo("Arsenal");
		 assertThat(game0AtRound1At20_21ActualValue.event.homeScore.period1).isEqualTo(0);
		 assertThat(game0AtRound1At20_21ActualValue.event.getDateToPrint()).isEqualTo("2020/Sep/12 13:30:00");
		    
		 //https://www.sofascore.com/crystal-palace-bournemouth/hkb
		 //https://api.sofascore.com/api/v1/event/8243556
		 GameBasicInformation game0AtRound15At19_20ActualValue = sofaScoreCollectorTest.getGameBasicInformation("Premier League", "2019/2020", "15", 0);
		 assertThat(game0AtRound15At19_20ActualValue.event.homeTeam.name).isEqualTo("Crystal Palace");
		 assertThat(game0AtRound15At19_20ActualValue.event.roundInfo.round).isEqualTo(15);
		 assertThat(game0AtRound15At19_20ActualValue.event.getDateToPrint()).isEqualTo("2019/Dec/03 21:30:00");

	 }
}
