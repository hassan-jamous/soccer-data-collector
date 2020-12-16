package collector;


import models.Club;
import models.Game;
import models.GamesTableOfLeague;
import models.Goal;
import models.Player;
import models.RankingTable;
import models.Round;
import models.Team;

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
   @Test
   public void itShouldGetPlayersInTeam() {
       ScreenScraper screenScraperUnderTest = new ScreenScraper();
       ArrayList <Player> manchesterUnitedActualValueplayers2015 = screenScraperUnderTest.getTeamPlayers("manchester-united","2015");
       ArrayList <Player> manchesterUnitedExpectedplayers2015 = new ArrayList <>();
       Player player1 = new Player("40","Ben Amos","England","10/04/1990","Goalkeeper");
       Player player2 = new Player("1","De Gea","Spain","07/11/1990","Goalkeeper");
       Player player3 = new Player("13","Anders Lindegaard","Denmark","13/04/1984","Goalkeeper");
       Player player4 = new Player("32","Víctor Valdés","Spain","14/01/1982","Goalkeeper");
       
       Player player5 = new Player("42","Tyler Blackett","England","02/04/1994","Defender");
       Player player6 = new Player("6","Jonny Evans","Northern Ireland","03/01/1988","Defender");
       Player player7 = new Player("37","Saidy Janko","Switzerland","22/10/1995","Defender");
       Player player8 = new Player("4","Phil Jones","England","21/02/1992","Defender");
       Player player9 = new Player("","Andrew Kellett","England","10/11/1993","Defender");
       Player player10 = new Player("33","Paddy McNair","Northern Ireland","27/04/1995","Defender");
       Player player11 = new Player("2","Rafael","Brazil","09/07/1990","Defender");
       Player player12 = new Player("5","Marcos Rojo","Argentina","20/03/1990","Defender");
       Player player13 = new Player("3","Luke Shaw","England","12/07/1995","Defender");
       Player player14 = new Player("12","Chris Smalling","England","22/11/1989","Defender");
       Player player15 = new Player("39","Tom Thorpe","England","13/01/1993","Defender");
       
       Player player16 = new Player("21","Ander Herrera","Spain","14/08/1989","Midfielder");
       Player player17 = new Player("44","Andreas Pereira","Brazil","01/01/1996","Midfielder");
       Player player18 = new Player("17","Daley Blind","Netherlands","09/03/1990","Midfielder");
       Player player19 = new Player("16","Michael Carrick","England","28/07/1981","Midfielder");
       Player player20 = new Player("31","Marouane Fellaini","Belgium","22/11/1987","Midfielder");
       Player player21 = new Player("11","Adnan Januzaj","Belgium","05/02/1995","Midfielder");
       Player player22 = new Player("8","Mata","Spain","28/04/1988","Midfielder");
       Player player23 = new Player("25","Antonio Valencia","Ecuador","04/08/1985","Midfielder");
       Player player24 = new Player("18","Ashley Young","England","09/07/1985","Midfielder");
       
       Player player25 = new Player("7","Ángel Di María","Argentina","14/02/1988","Forward");
       Player player26 = new Player("9","Radamel Falcao","Colombia","10/02/1986","Forward");
       Player player27 = new Player("10","Wayne Rooney","England","24/10/1985","Forward");
       Player player28 = new Player("20","Robin van Persie","Netherlands","06/08/1983","Forward");
       Player player29 = new Player("49","James Wilson","England","01/12/1995","Forward");
       
       Player player30 = new Player("","Louis van Gaal","Netherlands","08/08/1951","Manager");
       
       Player player31 = new Player("","Marcel Bout","Netherlands","18/11/1962","Ass. Manager");
       Player player32 = new Player("","Ryan Giggs","Wales","29/11/1973","Ass. Manager");
       Player player33 = new Player("","Albert Stuivenberg","Netherlands","30/10/1970","Ass. Manager");
       
       Player player34 = new Player("","Frans Hoek","Netherlands","17/10/1956","Goalkeeper-Coach");
       
       manchesterUnitedExpectedplayers2015.add(player1);
       manchesterUnitedExpectedplayers2015.add(player2);
       manchesterUnitedExpectedplayers2015.add(player3);
       manchesterUnitedExpectedplayers2015.add(player4);
       manchesterUnitedExpectedplayers2015.add(player5);
       manchesterUnitedExpectedplayers2015.add(player6);
       manchesterUnitedExpectedplayers2015.add(player7);
       manchesterUnitedExpectedplayers2015.add(player8);
       manchesterUnitedExpectedplayers2015.add(player9);
       manchesterUnitedExpectedplayers2015.add(player10);
       manchesterUnitedExpectedplayers2015.add(player11);
       manchesterUnitedExpectedplayers2015.add(player12);
       manchesterUnitedExpectedplayers2015.add(player13);
       manchesterUnitedExpectedplayers2015.add(player14);
       manchesterUnitedExpectedplayers2015.add(player15);
       manchesterUnitedExpectedplayers2015.add(player16);
       manchesterUnitedExpectedplayers2015.add(player17);
       manchesterUnitedExpectedplayers2015.add(player18);
       manchesterUnitedExpectedplayers2015.add(player19);
       manchesterUnitedExpectedplayers2015.add(player20);
       manchesterUnitedExpectedplayers2015.add(player21);
       manchesterUnitedExpectedplayers2015.add(player22);
       manchesterUnitedExpectedplayers2015.add(player23);
       manchesterUnitedExpectedplayers2015.add(player24);
       manchesterUnitedExpectedplayers2015.add(player25);
       manchesterUnitedExpectedplayers2015.add(player26);
       manchesterUnitedExpectedplayers2015.add(player27);
       manchesterUnitedExpectedplayers2015.add(player28);
       manchesterUnitedExpectedplayers2015.add(player29);
       manchesterUnitedExpectedplayers2015.add(player30);
       manchesterUnitedExpectedplayers2015.add(player31);
       manchesterUnitedExpectedplayers2015.add(player32);
       manchesterUnitedExpectedplayers2015.add(player33);
       manchesterUnitedExpectedplayers2015.add(player34);
       
       Assert.assertEquals(manchesterUnitedExpectedplayers2015.toString(), manchesterUnitedActualValueplayers2015.toString());
       
       
       ArrayList <Player> manchesterUnitedActualValueplayers1950 = screenScraperUnderTest.getTeamPlayers("manchester-united","1950");
       ArrayList <Player> manchesterUnitedExpectedplayers1950 = new ArrayList <>();
       Player player40 = new Player("","Jack Crompton","England","18/12/1921","Goalkeeper");
       Player player41 = new Player("","Sonny Feehan","Ireland","17/09/1926","Goalkeeper");
       Player player42 = new Player("","Joe Lancaster","England","28/04/1926","Goalkeeper");
       Player player43 = new Player("","Ray Wood","England","11/06/1931","Goalkeeper");
       
       Player player44 = new Player("","John Aston","England","03/09/1921","Defender");
       Player player45 = new Player("","John Ball","England","13/03/1925","Defender");
       Player player46 = new Player("","Johnny Carey","Ireland","23/02/1919","Defender");
       Player player47 = new Player("","Sammy Lynn","England","25/12/1920","Defender");
       Player player48 = new Player("","Tommy McNulty","England","30/12/1929","Defender");
       Player player49 = new Player("","Billy Redman","England","29/01/1928","Defender");
       Player player50 = new Player("","John Warner","Wales","21/09/1911","Defender");
       
       Player player51 = new Player("","Allenby Chilton","England","16/09/1918","Midfielder");
       Player player52 = new Player("","Henry Cockburn","England","14/09/1923","Midfielder");
       Player player53 = new Player("","Don Gibson","England","12/05/1929","Midfielder");
       Player player54 = new Player("","Tommy Lowrie","Scotland","14/01/1928","Midfielder");
       Player player55 = new Player("","Billy McGlen","England","27/04/1921","Midfielder");
       Player player56 = new Player("","Jeff Whitefoot","England","31/12/1933","Midfielder");
       
       Player player57 = new Player("","Brian Birch","England","18/11/1931","Forward");
       Player player58 = new Player("","Tommy Bogan","Scotland","18/05/1920","Forward");
       Player player59 = new Player("","Laurie Cassidy","England","10/03/1923","Forward");
       Player player60 = new Player("","Frank Clempson","England","27/05/1930","Forward");
       Player player61 = new Player("","Jimmy Delaney","Scotland","03/09/1914","Forward");
       Player player62 = new Player("","Johnny Downie","Scotland","19/07/1925","Forward");
       Player player63 = new Player("","Charlie Mitten","England","17/01/1921","Forward");
       Player player64 = new Player("","Stan Pearson","England","11/01/1919","Forward");
       Player player65 = new Player("","Jack Rowley","England","07/10/1920","Forward");
       
       Player player66 = new Player("","Matt Busby","Scotland","26/05/1909","Manager");
       
       Player player67 = new Player("","Jimmy Murphy","Wales","27/10/1910","Ass. Manager");
       

       manchesterUnitedExpectedplayers1950.add(player40);
       manchesterUnitedExpectedplayers1950.add(player41);
       manchesterUnitedExpectedplayers1950.add(player42);
       manchesterUnitedExpectedplayers1950.add(player43);
       manchesterUnitedExpectedplayers1950.add(player44);
       manchesterUnitedExpectedplayers1950.add(player45);
       manchesterUnitedExpectedplayers1950.add(player46);
       manchesterUnitedExpectedplayers1950.add(player47);
       manchesterUnitedExpectedplayers1950.add(player48);
       manchesterUnitedExpectedplayers1950.add(player49);
       manchesterUnitedExpectedplayers1950.add(player50);
       manchesterUnitedExpectedplayers1950.add(player51);
       manchesterUnitedExpectedplayers1950.add(player52);
       manchesterUnitedExpectedplayers1950.add(player53);
       manchesterUnitedExpectedplayers1950.add(player54);
       manchesterUnitedExpectedplayers1950.add(player55);
       manchesterUnitedExpectedplayers1950.add(player56);
       manchesterUnitedExpectedplayers1950.add(player57);
       manchesterUnitedExpectedplayers1950.add(player58);
       manchesterUnitedExpectedplayers1950.add(player59);
       manchesterUnitedExpectedplayers1950.add(player60);
       manchesterUnitedExpectedplayers1950.add(player61);
       manchesterUnitedExpectedplayers1950.add(player62);
       manchesterUnitedExpectedplayers1950.add(player63);
       manchesterUnitedExpectedplayers1950.add(player64);
       manchesterUnitedExpectedplayers1950.add(player65);
       manchesterUnitedExpectedplayers1950.add(player66);
       manchesterUnitedExpectedplayers1950.add(player67);
              
       Assert.assertEquals(manchesterUnitedActualValueplayers1950.toString(), manchesterUnitedExpectedplayers1950.toString());
       
       
       ArrayList <Player> manchesterUnitedActualValueplayers1890 = screenScraperUnderTest.getTeamPlayers("manchester-united","1890");
       ArrayList <Player> manchesterUnitedExpectedplayers1890 = new ArrayList <>();
       
       Player player70 = new Player("","Tom Burke","Wales","1862","Midfielder");
       Player player71 = new Player("","Joe Davies","Wales","12/07/1864","Midfielder");
       Player player72 = new Player("","Roger Doughty","Wales","1868","Midfielder");
       
       Player player73 = new Player("","Thomas Craig","England","","Forward");
       Player player74 = new Player("","Jack Doughty","England","10/1865","Forward");
       
       manchesterUnitedExpectedplayers1890.add(player70);
       manchesterUnitedExpectedplayers1890.add(player71);
       manchesterUnitedExpectedplayers1890.add(player72);
       manchesterUnitedExpectedplayers1890.add(player73);
       manchesterUnitedExpectedplayers1890.add(player74);

       Assert.assertEquals(manchesterUnitedActualValueplayers1890.toString(), manchesterUnitedExpectedplayers1890.toString());
       
       
       
       ArrayList <Player> AccringtonActualValueplayers1890 = screenScraperUnderTest.getTeamPlayers("Accrington","1890");
       ArrayList <Player> AccringtonExpectedplayers1890 = new ArrayList <>();
       Assert.assertEquals(AccringtonActualValueplayers1890.toString(), AccringtonExpectedplayers1890.toString());
       // Accrington FC´s URL is https://www.worldfootball.net/teams/accrington-fc/"

   }
   
   @Test
   public void itShouldGetTeamsInLeague() {
       ScreenScraper screenScraperUnderTest = new ScreenScraper();
       
       ArrayList<Team> teamsAt2015_2016ActualValue = screenScraperUnderTest.getTeamsAtSeason("2015-2016");
       ArrayList<Team> teamsAt2015_2016Expected = new ArrayList<>();
       Team team1 = new Team("AFC Bournemouth");
       Team team2 = new Team("Arsenal FC");
       Team team3 = new Team("Aston Villa");
       Team team4 = new Team("Chelsea FC");
       Team team5 = new Team("Crystal Palace");
       Team team6 = new Team("Everton FC");
       Team team7 = new Team("Leicester City");
       Team team8 = new Team("Liverpool FC");
       Team team9 = new Team("Manchester City");
       Team team10 = new Team("Manchester United");
       Team team11 = new Team("Newcastle United");
       Team team12 = new Team("Norwich City");
       Team team13 = new Team("Southampton FC");
       Team team14 = new Team("Stoke City");
       Team team15 = new Team("Sunderland AFC");
       Team team16 = new Team("Swansea City");
       Team team17 = new Team("Tottenham Hotspur");
       Team team18 = new Team("Watford FC");
       Team team19 = new Team("West Bromwich Albion");
       Team team20 = new Team("West Ham United");
       teamsAt2015_2016Expected.add(team1);
       teamsAt2015_2016Expected.add(team2);
       teamsAt2015_2016Expected.add(team3);
       teamsAt2015_2016Expected.add(team4);
       teamsAt2015_2016Expected.add(team5);
       teamsAt2015_2016Expected.add(team6);
       teamsAt2015_2016Expected.add(team7);
       teamsAt2015_2016Expected.add(team8);
       teamsAt2015_2016Expected.add(team9);
       teamsAt2015_2016Expected.add(team10);
       teamsAt2015_2016Expected.add(team11);
       teamsAt2015_2016Expected.add(team12);
       teamsAt2015_2016Expected.add(team13);
       teamsAt2015_2016Expected.add(team14);
       teamsAt2015_2016Expected.add(team15);
       teamsAt2015_2016Expected.add(team16);
       teamsAt2015_2016Expected.add(team17);
       teamsAt2015_2016Expected.add(team18);
       teamsAt2015_2016Expected.add(team19);
       teamsAt2015_2016Expected.add(team20);
       Assert.assertEquals(teamsAt2015_2016Expected.toString(), teamsAt2015_2016ActualValue.toString());

       
       
       ArrayList<Team> teamsAt1967_1968ActualValue = screenScraperUnderTest.getTeamsAtSeason("1967-1968");
       ArrayList<Team> teamsAt1967_1968Expected = new ArrayList<>();
       Team team30 = new Team("Arsenal FC");
       Team team31 = new Team("Burnley FC");
       Team team32 = new Team("Chelsea FC");
       Team team33 = new Team("Coventry City");
       Team team34 = new Team("Everton FC");
       Team team35 = new Team("Fulham FC");
       Team team36 = new Team("Leeds United");
       Team team37 = new Team("Leicester City");
       Team team38 = new Team("Liverpool FC");
       Team team39 = new Team("Manchester City");
       Team team40 = new Team("Manchester United");
       Team team41 = new Team("Newcastle United");
       Team team42 = new Team("Nottingham Forest");
       Team team43 = new Team("Sheffield United");
       Team team44 = new Team("Sheffield Wednesday");
       Team team45 = new Team("Southampton FC");
       Team team46 = new Team("Stoke City");
       Team team47 = new Team("Sunderland AFC");
       Team team48 = new Team("Tottenham Hotspur");
       Team team49 = new Team("West Bromwich Albion");
       Team team50 = new Team("West Ham United");
       Team team51 = new Team("Wolverhampton Wanderers");
       teamsAt1967_1968Expected.add(team30);
       teamsAt1967_1968Expected.add(team31);
       teamsAt1967_1968Expected.add(team32);
       teamsAt1967_1968Expected.add(team33);
       teamsAt1967_1968Expected.add(team34);
       teamsAt1967_1968Expected.add(team35);
       teamsAt1967_1968Expected.add(team36);
       teamsAt1967_1968Expected.add(team37);
       teamsAt1967_1968Expected.add(team38);
       teamsAt1967_1968Expected.add(team39);
       teamsAt1967_1968Expected.add(team40);
       teamsAt1967_1968Expected.add(team41);
       teamsAt1967_1968Expected.add(team42);
       teamsAt1967_1968Expected.add(team43);
       teamsAt1967_1968Expected.add(team44);
       teamsAt1967_1968Expected.add(team45);
       teamsAt1967_1968Expected.add(team46);
       teamsAt1967_1968Expected.add(team47);
       teamsAt1967_1968Expected.add(team48);
       teamsAt1967_1968Expected.add(team49);
       teamsAt1967_1968Expected.add(team50);
       teamsAt1967_1968Expected.add(team51);
       
       Assert.assertEquals(teamsAt1967_1968Expected.toString(), teamsAt1967_1968ActualValue.toString());
       
       
       
       ArrayList<Team> teamsAt1889_1890ActualValue = screenScraperUnderTest.getTeamsAtSeason("1889-1890");
       ArrayList<Team> teamsAt1889_1890Expected = new ArrayList<>();
       Team team60 = new Team("Accrington FC");
       Team team61 = new Team("Aston Villa");
       Team team62 = new Team("Blackburn Rovers");
       Team team63 = new Team("Bolton Wanderers");
       Team team64 = new Team("Burnley FC");
       Team team65 = new Team("Derby County");
       Team team66 = new Team("Everton FC");
       Team team67 = new Team("Notts County");
       Team team68 = new Team("Preston North End");
       Team team69 = new Team("Stoke City");
       Team team70 = new Team("West Bromwich Albion");
       Team team71 = new Team("Wolverhampton Wanderers");
       teamsAt1889_1890Expected.add(team60);
       teamsAt1889_1890Expected.add(team61);
       teamsAt1889_1890Expected.add(team62);
       teamsAt1889_1890Expected.add(team63);
       teamsAt1889_1890Expected.add(team64);
       teamsAt1889_1890Expected.add(team65);
       teamsAt1889_1890Expected.add(team66);
       teamsAt1889_1890Expected.add(team67);
       teamsAt1889_1890Expected.add(team68);
       teamsAt1889_1890Expected.add(team69);
       teamsAt1889_1890Expected.add(team70);
       teamsAt1889_1890Expected.add(team71);
       
       
       Assert.assertEquals(teamsAt1889_1890Expected.toString(), teamsAt1889_1890ActualValue.toString());

   }

}