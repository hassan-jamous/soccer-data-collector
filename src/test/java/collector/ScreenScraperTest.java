package collector;


import models.Club;
import models.Game;
import models.GamesTableOfLeague;
import models.Goal;
import models.RankingTable;
import models.Round;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class ScreenScraperTest {

    @Test
    public void itShouldGetGamesTableOfLeague()  {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        
        GamesTableOfLeague gamesTableActualValue1960_1961 = screenScraperUnderTest.getAllRounds("1960-1961");
           
        Round round4At1960_1961 = new Round();
        round4At1960_1961.setRoundNumber("4. Round");
        Game game1 = new Game ("29/08/1960","","Aston Villa","West Ham United","2:1 (0:0)");
        
        Game game2 = new Game ("30/08/1960","","Burnley FC","Manchester City","1:3 (0:0)");
        Game game3 = new Game ("30/08/1960","","Preston North End","Arsenal FC","2:0 (0:0)");
        
        Game game4 = new Game ("31/08/1960","","Manchester United","Everton FC","4:0 (2:0)");
        Game game5 = new Game ("31/08/1960","","Wolverhampton Wanderers","Bolton Wanderers","3:1 (0:0)");
        Game game6 = new Game ("31/08/1960","","Tottenham Hotspur","Blackpool FC","3:1 (0:0)");
        Game game7 = new Game ("31/08/1960","","Sheffield Wednesday","Cardiff City","2:0 (0:0)");
        Game game8 = new Game ("31/08/1960","","Nottingham Forest","Blackburn Rovers","1:1 (0:0)");
        Game game9 = new Game ("31/08/1960","","Leicester City","Chelsea FC","1:3 (0:0)");
        Game game10 = new Game("31/08/1960","","Fulham FC","Newcastle United","4:3 (0:0)");
        Game game11 = new Game("31/08/1960","","Birmingham City","West Bromwich Albion","3:1 (0:0)");
       
        round4At1960_1961.games.add(game1);
        round4At1960_1961.games.add(game2);
        round4At1960_1961.games.add(game3);
        round4At1960_1961.games.add(game4);
        round4At1960_1961.games.add(game5);
        round4At1960_1961.games.add(game6);
        round4At1960_1961.games.add(game7);
        round4At1960_1961.games.add(game8);
        round4At1960_1961.games.add(game9);
        round4At1960_1961.games.add(game10);
        round4At1960_1961.games.add(game11);
                
        Assert.assertEquals(round4At1960_1961.toString(), gamesTableActualValue1960_1961.getRoundObject(4).toString());
        
        
        GamesTableOfLeague gamesTableActualValue1888_1889 = screenScraperUnderTest.getAllRounds("1888-1889");
        
        Round round2At1888_1889 = new Round();
        round2At1888_1889.setRoundNumber("2. Round");
        Game game12 = new Game("15/09/1888" ,"","Aston Villa","Stoke City","5:1");
        Game game13 = new Game("15/09/1888" ,"","Bolton Wanderers","Burnley FC","3:4");
        Game game14 = new Game("15/09/1888" ,"","Derby County","West Bromwich Albion","1:2");
        Game game15 = new Game("15/09/1888" ,"","Everton FC","Notts County","2:1");
        Game game16 = new Game("15/09/1888" ,"","Wolverhampton Wanderers","Preston North End","0:4");
        Game game17 = new Game("15/09/1888" ,"","Blackburn Rovers","Accrington FC","5:5");
        round2At1888_1889.games.add(game12);
        round2At1888_1889.games.add(game13);
        round2At1888_1889.games.add(game14);
        round2At1888_1889.games.add(game15);
        round2At1888_1889.games.add(game16);
        round2At1888_1889.games.add(game17);
        
        Assert.assertEquals(round2At1888_1889.toString(), gamesTableActualValue1888_1889.getRoundObject(2).toString());
       
        GamesTableOfLeague gamesTableActualValue2015_2016 = screenScraperUnderTest.getAllRounds("2015-2016");

        Round round9At2015_2016 = new Round();
        round9At2015_2016.setRoundNumber("9. Round");
              
        Game game18 = new Game("17/10/2015","12:45","Tottenham Hotspur","Liverpool FC","0:0 (0:0)");
        Game game19 = new Game("17/10/2015","15:00","Chelsea FC","Aston Villa","2:0 (1:0)");
        Game game20 = new Game("17/10/2015","15:00","Crystal Palace","West Ham United","1:3 (1:1)");
        Game game21 = new Game("17/10/2015","15:00","Everton FC","Manchester United","0:3 (0:2)");
        Game game22 = new Game("17/10/2015","15:00","Manchester City","AFC Bournemouth","5:1 (4:1)");
        Game game23 = new Game("17/10/2015","15:00","Southampton FC","Leicester City","2:2 (2:0)");
        Game game24 = new Game("17/10/2015","15:00","West Bromwich Albion","Sunderland AFC","1:0 (0:0)");
        Game game25 = new Game("17/10/2015","17:30","Watford FC","Arsenal FC","0:3 (0:0)");
              
        Game game26 = new Game("18/10/2015","16:00","Newcastle United","Norwich City","6:2 (3:2)");
              
        Game game27 = new Game("19/10/2015","20:00","Swansea City","Stoke City","0:1 (0:1)");
             
        round9At2015_2016.games.add(game18);
        round9At2015_2016.games.add(game19);
        round9At2015_2016.games.add(game20);
        round9At2015_2016.games.add(game21);
        round9At2015_2016.games.add(game22);
        round9At2015_2016.games.add(game23);
        round9At2015_2016.games.add(game24);
        round9At2015_2016.games.add(game25);
        round9At2015_2016.games.add(game26);
        round9At2015_2016.games.add(game27);
        
        Assert.assertEquals(round9At2015_2016.toString(), gamesTableActualValue2015_2016.getRoundObject(9).toString());
          

    }
   @Test 
   public void itShouldGetLastRankingTableOfLeague() {
	   ScreenScraper screenScraperUnderTest = new ScreenScraper();
	   RankingTable rankingTableActualValue1889_1890 = screenScraperUnderTest.getLastTable("1889-1890");
       RankingTable rankingTableExpectedValue1889_1890 = new RankingTable();
       
       Club club1 = new Club("1","Preston North End","22","15","3","4","71:30","41","33:11");
       rankingTableExpectedValue1889_1890.addClub(club1);
       Club club2 = new Club("2","Everton FC","22","14","3","5","65:40","25","31:13");
       rankingTableExpectedValue1889_1890.addClub(club2);
       Club club3 = new Club("3","Blackburn Rovers","22","12","3","7","78:41","37","27:17");
       rankingTableExpectedValue1889_1890.addClub(club3);
       Club club4 = new Club("4","Wolverhampton Wanderers","22","10","5","7","51:38","13","25:19");
       rankingTableExpectedValue1889_1890.addClub(club4);
       Club club5 = new Club("5","West Bromwich Albion","22","11","3","8","47:50","-3","25:19");
       rankingTableExpectedValue1889_1890.addClub(club5);
       Club club6 = new Club("6","Accrington FC","22","9","6","7","53:56","-3","24:20");
       rankingTableExpectedValue1889_1890.addClub(club6);
       Club club7 = new Club("7","Derby County","22","9","3","10","43:55","-12","21:23");
       rankingTableExpectedValue1889_1890.addClub(club7);
       Club club8 = new Club("8","Aston Villa","22","7","5","10","43:51","-8","19:25");
       rankingTableExpectedValue1889_1890.addClub(club8);
       Club club9 = new Club("9","Bolton Wanderers","22","9","1","12","54:65","-11","19:25");
       rankingTableExpectedValue1889_1890.addClub(club9);
       Club club10 = new Club("10","Notts County","22","6","5","11","43:51","-8","17:27");
       rankingTableExpectedValue1889_1890.addClub(club10);
       Club club11 = new Club("11","Burnley FC","22","4","5","13","36:65","-29","13:31");
       rankingTableExpectedValue1889_1890.addClub(club11);
       Club club12 = new Club("12","Stoke City","22","3","4","15","27:69","-42","10:34");
       rankingTableExpectedValue1889_1890.addClub(club12);
       
       
       Assert.assertEquals(rankingTableExpectedValue1889_1890.toString(), rankingTableActualValue1889_1890.toString());
      
       
       RankingTable rankingTableActualValue2012_2013ByRound14 = screenScraperUnderTest.getTableByRound("2012-2013","14");
       RankingTable rankingTableExpectedValue2012_2013ByRound14 = new RankingTable();
       
       Club club20 = new Club("1","Manchester United","14","11","0","3","33:18","15","33");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club20);
       Club club21 = new Club("2","Manchester City","14","9","5","0","27:10","17","32");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club21);
       Club club22 = new Club("3","Chelsea FC","14","7","5","2","24:13","11","26");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club22);
       Club club23 = new Club("4","West Bromwich Albion","14","8","2","4","24:18","6","26");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club23);
       Club club24 = new Club("5","Tottenham Hotspur","14","7","2","5","25:23","2","23");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club24);
       Club club25 = new Club("6","Everton FC","14","5","7","2","24:18","6","22");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club25);
       Club club26 = new Club("7","Arsenal FC","14","5","6","3","24:14","10","21");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club26);
       Club club27 = new Club("8","Swansea City","14","5","5","4","21:17","4","20");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club27);
       Club club28 = new Club("9","Stoke City","14","4","7","3","13:12","1","19");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club28);
       Club club29 = new Club("10","West Ham United","14","5","4","5","16:16","0","19");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club29);
       Club club30 = new Club("11","Fulham FC","14","4","5","5","25:23","2","17");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club30);
       Club club31 = new Club("12","Liverpool FC","14","3","7","4","18:18","0","16");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club31);
       Club club32 = new Club("13","Sunderland AFC","14","3","7","4","15:16","-1","16");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club32);
       Club club33 = new Club("14","Norwich City","14","3","7","4","11:20","-9","16");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club33);
       Club club34 = new Club("15","Newcastle United","14","3","5","6","14:21","-7","14");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club34);
       Club club35 = new Club("16","Wigan Athletic","14","4","2","8","15:25","-10","14");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club35);
       Club club36 = new Club("17","Aston Villa","14","3","4","7","11:22","-11","13");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club36);
       Club club37 = new Club("18","Southampton FC","14","3","3","8","21:31","-10","12");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club37);
       Club club38 = new Club("19","Reading FC","14","1","6","7","16:26","-10","9");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club38);
       Club club39 = new Club("20","Queens Park Rangers","14","0","5","9","10:26","-16","5");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club39);
       
       
       Assert.assertEquals(rankingTableExpectedValue2012_2013ByRound14.toString(), rankingTableActualValue2012_2013ByRound14.toString());
       
   }
   @Test
   public void itShouldGetGameGoals() {
	   
	   ScreenScraper screenScraperUnderTest = new ScreenScraper();
	   	   	   
	   String ownGoal = "https://www.worldfootball.net/report/premier-league-2015-2016-arsenal-fc-aston-villa/";   
       ArrayList <Goal> goalsOwnGoalActualValue = screenScraperUnderTest.getEventsOfGame(ownGoal);
              
       Goal goal1 = new Goal("1 : 0","5","Olivier Giroud","header","Nacho Monreal" );
       Goal goal2 = new Goal("2 : 0","78","Olivier Giroud","left-footed shot","Mesut Özil" );
       Goal goal3 = new Goal("3 : 0","80","Olivier Giroud","left-footed shot","Héctor Bellerín" );
       Goal goal4 = new Goal("4 : 0","90","Mark Bunn","own goal" );
       ArrayList <Goal> goalsOwnGoalExpected = new ArrayList <>();
       goalsOwnGoalExpected.add(goal1);
       goalsOwnGoalExpected.add(goal2);
       goalsOwnGoalExpected.add(goal3);
       goalsOwnGoalExpected.add(goal4);
             
       Assert.assertEquals(goalsOwnGoalExpected.toString(), goalsOwnGoalActualValue.toString());

       String individuallyGoal ="https://www.worldfootball.net/report/premier-league-2015-2016-sunderland-afc-chelsea-fc/";
       ArrayList <Goal> goalsActualValueIndividuallyGoal = screenScraperUnderTest.getEventsOfGame(individuallyGoal);
       
       Goal goal10 = new Goal("0 : 1","14","Diego Costa","right-footed shot");
       Goal goal11 = new Goal("1 : 1","41","Wahbi Khazri","right-footed shot" );
       Goal goal12 = new Goal("1 : 2","45","Nemanja Matić","left-footed shot","Azpilicueta");
       Goal goal13 = new Goal("2 : 2","67","Fabio Borini","right-footed shot","Patrick van Aanholt" );
       Goal goal14 = new Goal("3 : 2","70","Jermain Defoe","right-footed shot" );
       ArrayList <Goal> goalsExpectedIndividuallyGoal = new ArrayList <>();
       goalsExpectedIndividuallyGoal.add(goal10);
       goalsExpectedIndividuallyGoal.add(goal11);
       goalsExpectedIndividuallyGoal.add(goal12);
       goalsExpectedIndividuallyGoal.add(goal13);
       goalsExpectedIndividuallyGoal.add(goal14);
              
       Assert.assertEquals(goalsExpectedIndividuallyGoal.toString(), goalsActualValueIndividuallyGoal.toString());
       
       String oldGame1 = "https://www.worldfootball.net/report/premier-league-1956-1957-sheffield-wednesday-chelsea-fc/";
       ArrayList <Goal> goalsActualValueoldGoal1 = screenScraperUnderTest.getEventsOfGame(oldGame1);
       
       ArrayList <Goal> goalsExpectedOldGoal1 = new ArrayList <>();
       Goal goal20 = new Goal("1 : 0","Roy Shiner", "0.");
       Goal goal21 = new Goal("2 : 0","Roy Shiner", "0.");
       Goal goal22 = new Goal("3 : 0","Albert Quixall","0.");
       Goal goal23 = new Goal("4 : 0","Albert Quixall","0.");       
       goalsExpectedOldGoal1.add(goal20);
       goalsExpectedOldGoal1.add(goal21);
       goalsExpectedOldGoal1.add(goal22);
       goalsExpectedOldGoal1.add(goal23);
       
       Assert.assertEquals(goalsExpectedOldGoal1.toString(), goalsActualValueoldGoal1.toString());
       
       
       String oldGame2 = "https://www.worldfootball.net/report/premier-league-1956-1957-tottenham-hotspur-leeds-united/";
       ArrayList <Goal> goalsActualValueoldGoal2 = screenScraperUnderTest.getEventsOfGame(oldGame2);
       
       ArrayList <Goal> goalsExpectedOldGoal2 = new ArrayList <>();
       Goal goal30 = new Goal("1 : 0","Bobby Smith", "0." );
       Goal goal31 = new Goal("2 : 0","George Robb", "0.");
       Goal goal32 = new Goal("3 : 0","Terry Medwin", "0." );
       Goal goal33 = new Goal("4 : 0", 	"John Brooks", "0.");
       Goal goal34 = new Goal("5 : 0", 	"Danny Blanchflower", "0." );
       Goal goal35 = new Goal("5 : 1", 	"Keith Ripley" , "0." );
       goalsExpectedOldGoal2.add(goal30);
       goalsExpectedOldGoal2.add(goal31);
       goalsExpectedOldGoal2.add(goal32);
       goalsExpectedOldGoal2.add(goal33);
       goalsExpectedOldGoal2.add(goal34);
       goalsExpectedOldGoal2.add(goal35);
       
       Assert.assertEquals(goalsExpectedOldGoal2.toString(), goalsActualValueoldGoal2.toString());
       

       String oldGameZeroToZero = "https://www.worldfootball.net/report/premier-league-1956-1957-aston-villa-west-bromwich-albion/";
       ArrayList <Goal> goalsActualValueoldGoalZeroToZero = screenScraperUnderTest.getEventsOfGame(oldGameZeroToZero);
       
       ArrayList <Goal> goalsExpectedOldGoalZerotoZero = new ArrayList <>();
      
       Assert.assertEquals(goalsExpectedOldGoalZerotoZero.toString(), goalsActualValueoldGoalZeroToZero.toString());
       
       
       
       String newGameZeroToZero = "https://www.worldfootball.net/report/premier-league-2020-2021-brighton-hove-albion-burnley-fc/";
       ArrayList <Goal> goalsActualValuenewGoalZeroToZero = screenScraperUnderTest.getEventsOfGame(newGameZeroToZero);
       
       ArrayList <Goal> goalsExpectedNewGoalZerotoZero = new ArrayList <>();
      
       Assert.assertEquals(goalsExpectedNewGoalZerotoZero.toString(), goalsActualValuenewGoalZeroToZero.toString());
       
    
   }

}