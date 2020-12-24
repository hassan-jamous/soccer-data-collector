package collector;


import models.Club;
import models.ClubForRankingTable;

import models.ClubForRankingTable;



import models.ClubTransferTable;
import models.DirtyGame;
import models.Game;
import models.GamesTableOfLeague;
import models.Goal;
import models.KindOfReferee;
import models.MatchDetails;
import models.ClubInMatch;
import models.PlayerAllInformation;
import models.PlayerAtMatch;
import models.PlayerClubCareer;
import models.PlayerCompetitionsInformation;
import models.PlayerEventAtMatch;
import models.PlayerPersonalInformation;
import models.PlayerSummary;
import models.PlayerTeamManaged;
import models.PlayerTopSoccer;
import models.PlayerTypeAtMatch;
import models.RankingTable;
import models.Referee;
import models.Round;
import models.Staduim;
import models.StatisticsBestPlayerInYear;
import models.StatisticsGoalsPerRound;
import models.StatisticsGoalsPerSeason;
import models.StatisticsRecordWinsAndMostGoalInGame;

import models.TransferPlayerInformation;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

public class ScreenScraperTest {

   @Test
   public void itShouldGetGamesTableOfLeague()  {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        
        GamesTableOfLeague gamesTableActualValue1960_1961 = screenScraperUnderTest.getAllRounds("eng-premier-league","1960-1961");
           
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
        
        GamesTableOfLeague gamesTableActualValue1888_1889 = screenScraperUnderTest.getAllRounds("eng-premier-league","1888-1889");        
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
       
        GamesTableOfLeague gamesTableActualValue2015_2016 = screenScraperUnderTest.getAllRounds("eng-premier-league","2015-2016");
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
	   RankingTable rankingTableActualValue1889_1890 = screenScraperUnderTest.getLastTable("eng-premier-league","1889-1890");
       RankingTable rankingTableExpectedValue1889_1890 = new RankingTable();       
       ClubForRankingTable club1 = new ClubForRankingTable("1","Preston North End","22","15","3","4","71:30","41","33:11");
       rankingTableExpectedValue1889_1890.addClub(club1);
       ClubForRankingTable club2 = new ClubForRankingTable("2","Everton FC","22","14","3","5","65:40","25","31:13");
       rankingTableExpectedValue1889_1890.addClub(club2);
       ClubForRankingTable club3 = new ClubForRankingTable("3","Blackburn Rovers","22","12","3","7","78:41","37","27:17");
       rankingTableExpectedValue1889_1890.addClub(club3);
       ClubForRankingTable club4 = new ClubForRankingTable("4","Wolverhampton Wanderers","22","10","5","7","51:38","13","25:19");
       rankingTableExpectedValue1889_1890.addClub(club4);
       ClubForRankingTable club5 = new ClubForRankingTable("5","West Bromwich Albion","22","11","3","8","47:50","-3","25:19");
       rankingTableExpectedValue1889_1890.addClub(club5);
       ClubForRankingTable club6 = new ClubForRankingTable("6","Accrington FC","22","9","6","7","53:56","-3","24:20");
       rankingTableExpectedValue1889_1890.addClub(club6);
       ClubForRankingTable club7 = new ClubForRankingTable("7","Derby County","22","9","3","10","43:55","-12","21:23");
       rankingTableExpectedValue1889_1890.addClub(club7);
       ClubForRankingTable club8 = new ClubForRankingTable("8","Aston Villa","22","7","5","10","43:51","-8","19:25");
       rankingTableExpectedValue1889_1890.addClub(club8);
       ClubForRankingTable club9 = new ClubForRankingTable("9","Bolton Wanderers","22","9","1","12","54:65","-11","19:25");
       rankingTableExpectedValue1889_1890.addClub(club9);
       ClubForRankingTable club10 = new ClubForRankingTable("10","Notts County","22","6","5","11","43:51","-8","17:27");
       rankingTableExpectedValue1889_1890.addClub(club10);
       ClubForRankingTable club11 = new ClubForRankingTable("11","Burnley FC","22","4","5","13","36:65","-29","13:31");
       rankingTableExpectedValue1889_1890.addClub(club11);
       ClubForRankingTable club12 = new ClubForRankingTable("12","Stoke City","22","3","4","15","27:69","-42","10:34");
       rankingTableExpectedValue1889_1890.addClub(club12);       
       Assert.assertEquals(rankingTableExpectedValue1889_1890.toString(), rankingTableActualValue1889_1890.toString());      
       
       RankingTable rankingTableActualValue2012_2013ByRound14 = screenScraperUnderTest.getTableByRound("eng-premier-league","2012-2013","14");
       RankingTable rankingTableExpectedValue2012_2013ByRound14 = new RankingTable();       
       ClubForRankingTable club20 = new ClubForRankingTable("1","Manchester United","14","11","0","3","33:18","15","33");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club20);
       ClubForRankingTable club21 = new ClubForRankingTable("2","Manchester City","14","9","5","0","27:10","17","32");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club21);
       ClubForRankingTable club22 = new ClubForRankingTable("3","Chelsea FC","14","7","5","2","24:13","11","26");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club22);
       ClubForRankingTable club23 = new ClubForRankingTable("4","West Bromwich Albion","14","8","2","4","24:18","6","26");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club23);
       ClubForRankingTable club24 = new ClubForRankingTable("5","Tottenham Hotspur","14","7","2","5","25:23","2","23");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club24);
       ClubForRankingTable club25 = new ClubForRankingTable("6","Everton FC","14","5","7","2","24:18","6","22");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club25);
       ClubForRankingTable club26 = new ClubForRankingTable("7","Arsenal FC","14","5","6","3","24:14","10","21");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club26);
       ClubForRankingTable club27 = new ClubForRankingTable("8","Swansea City","14","5","5","4","21:17","4","20");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club27);
       ClubForRankingTable club28 = new ClubForRankingTable("9","Stoke City","14","4","7","3","13:12","1","19");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club28);
       ClubForRankingTable club29 = new ClubForRankingTable("10","West Ham United","14","5","4","5","16:16","0","19");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club29);
       ClubForRankingTable club30 = new ClubForRankingTable("11","Fulham FC","14","4","5","5","25:23","2","17");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club30);
       ClubForRankingTable club31 = new ClubForRankingTable("12","Liverpool FC","14","3","7","4","18:18","0","16");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club31);
       ClubForRankingTable club32 = new ClubForRankingTable("13","Sunderland AFC","14","3","7","4","15:16","-1","16");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club32);
       ClubForRankingTable club33 = new ClubForRankingTable("14","Norwich City","14","3","7","4","11:20","-9","16");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club33);
       ClubForRankingTable club34 = new ClubForRankingTable("15","Newcastle United","14","3","5","6","14:21","-7","14");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club34);
       ClubForRankingTable club35 = new ClubForRankingTable("16","Wigan Athletic","14","4","2","8","15:25","-10","14");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club35);
       ClubForRankingTable club36 = new ClubForRankingTable("17","Aston Villa","14","3","4","7","11:22","-11","13");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club36);
       ClubForRankingTable club37 = new ClubForRankingTable("18","Southampton FC","14","3","3","8","21:31","-10","12");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club37);
       ClubForRankingTable club38 = new ClubForRankingTable("19","Reading FC","14","1","6","7","16:26","-10","9");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club38);
       ClubForRankingTable club39 = new ClubForRankingTable("20","Queens Park Rangers","14","0","5","9","10:26","-16","5");
       rankingTableExpectedValue2012_2013ByRound14.addClub(club39);       
       Assert.assertEquals(rankingTableExpectedValue2012_2013ByRound14.toString(), rankingTableActualValue2012_2013ByRound14.toString());
       
   }
   @Test
   public void itShouldGetGameGoals() {
	   
	   ScreenScraper screenScraperUnderTest = new ScreenScraper();	      
       ArrayList <Goal> goalsOwnGoalActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league","2015-2016","arsenal-fc","aston-villa");              
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

       ArrayList <Goal> goalsActualValueIndividuallyGoal = screenScraperUnderTest.getGoalsOfGame("premier-league","2015-2016","sunderland-afc","chelsea-fc");       
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
       
       ArrayList <Goal> goalsActualValueoldGoal1 = screenScraperUnderTest.getGoalsOfGame("premier-league","1956-1957","sheffield-wednesday","chelsea-fc");
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
       
       ArrayList <Goal> goalsActualValueoldGoal2 = screenScraperUnderTest.getGoalsOfGame("premier-league","1956-1957","tottenham-hotspur","leeds-united");
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
       
       ArrayList <Goal> goalsActualValueoldGoalZeroToZero = screenScraperUnderTest.getGoalsOfGame("premier-league","1956-1957","aston-villa","west-bromwich-albion");
       ArrayList <Goal> goalsExpectedOldGoalZerotoZero = new ArrayList <>();
       Assert.assertEquals(goalsExpectedOldGoalZerotoZero.toString(), goalsActualValueoldGoalZeroToZero.toString());
       
       ArrayList <Goal> goalsActualValuenewGoalZeroToZero = screenScraperUnderTest.getGoalsOfGame("premier-league","2020-2021","brighton-hove-albion","burnley-fc");
       ArrayList <Goal> goalsExpectedNewGoalZerotoZero = new ArrayList <>();
       Assert.assertEquals(goalsExpectedNewGoalZerotoZero.toString(), goalsActualValuenewGoalZeroToZero.toString());
        
   }
   @Test
   public void itShouldGetPlayersSummuryInTeam() {
       ScreenScraper screenScraperUnderTest = new ScreenScraper();
       ArrayList <PlayerSummary> manchesterUnitedActualValueplayers2015 = screenScraperUnderTest.clubsCollector.getAllPlayersSummuryInClub("manchester-united","2015");
       ArrayList <PlayerSummary> manchesterUnitedExpectedplayers2015 = new ArrayList <>();
       PlayerSummary player1 = new PlayerSummary("40","Ben Amos","England","10/04/1990","Goalkeeper");
       PlayerSummary player2 = new PlayerSummary("1","De Gea","Spain","07/11/1990","Goalkeeper");
       PlayerSummary player3 = new PlayerSummary("13","Anders Lindegaard","Denmark","13/04/1984","Goalkeeper");
       PlayerSummary player4 = new PlayerSummary("32","Víctor Valdés","Spain","14/01/1982","Goalkeeper");
       PlayerSummary player5 = new PlayerSummary("42","Tyler Blackett","England","02/04/1994","Defender");
       PlayerSummary player6 = new PlayerSummary("6","Jonny Evans","Northern Ireland","03/01/1988","Defender");
       PlayerSummary player7 = new PlayerSummary("37","Saidy Janko","Switzerland","22/10/1995","Defender");
       PlayerSummary player8 = new PlayerSummary("4","Phil Jones","England","21/02/1992","Defender");
       PlayerSummary player9 = new PlayerSummary("","Andrew Kellett","England","10/11/1993","Defender");
       PlayerSummary player10 = new PlayerSummary("33","Paddy McNair","Northern Ireland","27/04/1995","Defender");
       PlayerSummary player11 = new PlayerSummary("2","Rafael","Brazil","09/07/1990","Defender");
       PlayerSummary player12 = new PlayerSummary("5","Marcos Rojo","Argentina","20/03/1990","Defender");
       PlayerSummary player13 = new PlayerSummary("3","Luke Shaw","England","12/07/1995","Defender");
       PlayerSummary player14 = new PlayerSummary("12","Chris Smalling","England","22/11/1989","Defender");
       PlayerSummary player15 = new PlayerSummary("39","Tom Thorpe","England","13/01/1993","Defender");
       PlayerSummary player16 = new PlayerSummary("21","Ander Herrera","Spain","14/08/1989","Midfielder");
       PlayerSummary player17 = new PlayerSummary("44","Andreas Pereira","Brazil","01/01/1996","Midfielder");
       PlayerSummary player18 = new PlayerSummary("17","Daley Blind","Netherlands","09/03/1990","Midfielder");
       PlayerSummary player19 = new PlayerSummary("16","Michael Carrick","England","28/07/1981","Midfielder");
       PlayerSummary player20 = new PlayerSummary("31","Marouane Fellaini","Belgium","22/11/1987","Midfielder");
       PlayerSummary player21 = new PlayerSummary("11","Adnan Januzaj","Belgium","05/02/1995","Midfielder");
       PlayerSummary player22 = new PlayerSummary("8","Mata","Spain","28/04/1988","Midfielder");
       PlayerSummary player23 = new PlayerSummary("25","Antonio Valencia","Ecuador","04/08/1985","Midfielder");
       PlayerSummary player24 = new PlayerSummary("18","Ashley Young","England","09/07/1985","Midfielder");
       PlayerSummary player25 = new PlayerSummary("7","Ángel Di María","Argentina","14/02/1988","Forward");
       PlayerSummary player26 = new PlayerSummary("9","Radamel Falcao","Colombia","10/02/1986","Forward");
       PlayerSummary player27 = new PlayerSummary("10","Wayne Rooney","England","24/10/1985","Forward");
       PlayerSummary player28 = new PlayerSummary("20","Robin van Persie","Netherlands","06/08/1983","Forward");
       PlayerSummary player29 = new PlayerSummary("49","James Wilson","England","01/12/1995","Forward");
       PlayerSummary player30 = new PlayerSummary("","Louis van Gaal","Netherlands","08/08/1951","Manager");
       PlayerSummary player31 = new PlayerSummary("","Marcel Bout","Netherlands","18/11/1962","Ass. Manager");
       PlayerSummary player32 = new PlayerSummary("","Ryan Giggs","Wales","29/11/1973","Ass. Manager");
       PlayerSummary player33 = new PlayerSummary("","Albert Stuivenberg","Netherlands","30/10/1970","Ass. Manager");
       PlayerSummary player34 = new PlayerSummary("","Frans Hoek","Netherlands","17/10/1956","Goalkeeper-Coach");
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
       

       ArrayList <PlayerSummary> manchesterUnitedActualValueplayers1950 = screenScraperUnderTest.getAllPlayersSummuryInClub("manchester-united","1950");
       ArrayList <PlayerSummary> manchesterUnitedExpectedplayers1950 = new ArrayList <>();
       PlayerSummary player40 = new PlayerSummary("","Jack Crompton","England","18/12/1921","Goalkeeper");
       PlayerSummary player41 = new PlayerSummary("","Sonny Feehan","Ireland","17/09/1926","Goalkeeper");
       PlayerSummary player42 = new PlayerSummary("","Joe Lancaster","England","28/04/1926","Goalkeeper");
       PlayerSummary player43 = new PlayerSummary("","Ray Wood","England","11/06/1931","Goalkeeper");
       PlayerSummary player44 = new PlayerSummary("","John Aston","England","03/09/1921","Defender");
       PlayerSummary player45 = new PlayerSummary("","John Ball","England","13/03/1925","Defender");
       PlayerSummary player46 = new PlayerSummary("","Johnny Carey","Ireland","23/02/1919","Defender");
       PlayerSummary player47 = new PlayerSummary("","Sammy Lynn","England","25/12/1920","Defender");
       PlayerSummary player48 = new PlayerSummary("","Tommy McNulty","England","30/12/1929","Defender");
       PlayerSummary player49 = new PlayerSummary("","Billy Redman","England","29/01/1928","Defender");
       PlayerSummary player50 = new PlayerSummary("","Jack Warner","Wales","21/09/1911","Defender");
       PlayerSummary player51 = new PlayerSummary("","Allenby Chilton","England","16/09/1918","Midfielder");
       PlayerSummary player52 = new PlayerSummary("","Henry Cockburn","England","14/09/1923","Midfielder");
       PlayerSummary player53 = new PlayerSummary("","Don Gibson","England","12/05/1929","Midfielder");
       PlayerSummary player54 = new PlayerSummary("","Tommy Lowrie","Scotland","14/01/1928","Midfielder");
       PlayerSummary player55 = new PlayerSummary("","Billy McGlen","England","27/04/1921","Midfielder");
       PlayerSummary player56 = new PlayerSummary("","Jeff Whitefoot","England","31/12/1933","Midfielder");
       PlayerSummary player57 = new PlayerSummary("","Brian Birch","England","18/11/1931","Forward");
       PlayerSummary player58 = new PlayerSummary("","Tommy Bogan","Scotland","18/05/1920","Forward");
       PlayerSummary player59 = new PlayerSummary("","Laurie Cassidy","England","10/03/1923","Forward");
       PlayerSummary player60 = new PlayerSummary("","Frank Clempson","England","27/05/1930","Forward");
       PlayerSummary player61 = new PlayerSummary("","Jimmy Delaney","Scotland","03/09/1914","Forward");
       PlayerSummary player62 = new PlayerSummary("","Johnny Downie","Scotland","19/07/1925","Forward");
       PlayerSummary player63 = new PlayerSummary("","Charlie Mitten","England","17/01/1921","Forward");
       PlayerSummary player64 = new PlayerSummary("","Stan Pearson","England","11/01/1919","Forward");
       PlayerSummary player65 = new PlayerSummary("","Jack Rowley","England","07/10/1920","Forward");
       PlayerSummary player66 = new PlayerSummary("","Matt Busby","Scotland","26/05/1909","Manager");
       PlayerSummary player67 = new PlayerSummary("","Jimmy Murphy","Wales","27/10/1910","Ass. Manager");

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
              
       ArrayList <PlayerSummary> manchesterUnitedActualValueplayers1890 = screenScraperUnderTest.clubsCollector.getAllPlayersSummuryInClub("manchester-united","1890");
       ArrayList <PlayerSummary> manchesterUnitedExpectedplayers1890 = new ArrayList <>();
       PlayerSummary player70 = new PlayerSummary("","Tom Burke","Wales","1862","Midfielder");
       PlayerSummary player71 = new PlayerSummary("","Joe Davies","Wales","12/07/1864","Midfielder");
       PlayerSummary player72 = new PlayerSummary("","Roger Doughty","Wales","1868","Midfielder");
       PlayerSummary player73 = new PlayerSummary("","Thomas Craig","England","","Forward");
       PlayerSummary player74 = new PlayerSummary("","Jack Doughty","England","10/1865","Forward");
       manchesterUnitedExpectedplayers1890.add(player70);
       manchesterUnitedExpectedplayers1890.add(player71);
       manchesterUnitedExpectedplayers1890.add(player72);
       manchesterUnitedExpectedplayers1890.add(player73);
       manchesterUnitedExpectedplayers1890.add(player74);
       Assert.assertEquals(manchesterUnitedActualValueplayers1890.toString(), manchesterUnitedExpectedplayers1890.toString());
       
       ArrayList <PlayerSummary> AccringtonActualValueplayers1890 = screenScraperUnderTest.clubsCollector.getAllPlayersSummuryInClub("Accrington","1890");
       ArrayList <PlayerSummary> AccringtonExpectedplayers1890 = new ArrayList <>();
       Assert.assertEquals(AccringtonActualValueplayers1890.toString(), AccringtonExpectedplayers1890.toString());

   }
   
   @Test
   public void itShouldGetClubsInLeague() {
       ScreenScraper screenScraperUnderTest = new ScreenScraper();
      
       ArrayList<Club> teamsAt2015_2016ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("2015-2016");
       ArrayList<Club> teamsAt2015_2016Expected = new ArrayList<>();
       Club team1 = new Club("AFC Bournemouth");
       Club team2 = new Club("Arsenal FC");
       Club team3 = new Club("Aston Villa");
       Club team4 = new Club("Chelsea FC");
       Club team5 = new Club("Crystal Palace");
       Club team6 = new Club("Everton FC");
       Club team7 = new Club("Leicester City");
       Club team8 = new Club("Liverpool FC");
       Club team9 = new Club("Manchester City");
       Club team10 = new Club("Manchester United");
       Club team11 = new Club("Newcastle United");
       Club team12 = new Club("Norwich City");
       Club team13 = new Club("Southampton FC");
       Club team14 = new Club("Stoke City");
       Club team15 = new Club("Sunderland AFC");
       Club team16 = new Club("Swansea City");
       Club team17 = new Club("Tottenham Hotspur");
       Club team18 = new Club("Watford FC");
       Club team19 = new Club("West Bromwich Albion");
       Club team20 = new Club("West Ham United");
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
       
       ArrayList<Club> teamsAt1967_1968ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("1967-1968");
       ArrayList<Club> teamsAt1967_1968Expected = new ArrayList<>();
       Club team30 = new Club("Arsenal FC");
       Club team31 = new Club("Burnley FC");
       Club team32 = new Club("Chelsea FC");
       Club team33 = new Club("Coventry City");
       Club team34 = new Club("Everton FC");
       Club team35 = new Club("Fulham FC");
       Club team36 = new Club("Leeds United");
       Club team37 = new Club("Leicester City");
       Club team38 = new Club("Liverpool FC");
       Club team39 = new Club("Manchester City");
       Club team40 = new Club("Manchester United");
       Club team41 = new Club("Newcastle United");
       Club team42 = new Club("Nottingham Forest");
       Club team43 = new Club("Sheffield United");
       Club team44 = new Club("Sheffield Wednesday");
       Club team45 = new Club("Southampton FC");
       Club team46 = new Club("Stoke City");
       Club team47 = new Club("Sunderland AFC");
       Club team48 = new Club("Tottenham Hotspur");
       Club team49 = new Club("West Bromwich Albion");
       Club team50 = new Club("West Ham United");
       Club team51 = new Club("Wolverhampton Wanderers");
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
       
       ArrayList<Club> teamsAt1889_1890ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("1889-1890");
       ArrayList<Club> teamsAt1889_1890Expected = new ArrayList<>();
       Club team60 = new Club("Accrington FC");
       Club team61 = new Club("Aston Villa");
       Club team62 = new Club("Blackburn Rovers");
       Club team63 = new Club("Bolton Wanderers");
       Club team64 = new Club("Burnley FC");
       Club team65 = new Club("Derby County");
       Club team66 = new Club("Everton FC");
       Club team67 = new Club("Notts County");
       Club team68 = new Club("Preston North End");
       Club team69 = new Club("Stoke City");
       Club team70 = new Club("West Bromwich Albion");
       Club team71 = new Club("Wolverhampton Wanderers");
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
   
   @Test
   public void itShouldGetPlayerInformation() {
	  
	   ScreenScraper screenScraperTest = new ScreenScraper();
	   
	   PlayerAllInformation player1ActualValueInfo = new PlayerAllInformation();
	   PlayerAllInformation player1ExpectedValueInfo = new PlayerAllInformation();
	   player1ActualValueInfo = screenScraperTest.playerCollector.getAllInformationAboutPlayer("eric-bailly");
	   PlayerPersonalInformation player1ExpectedValuePersonalInfo = new PlayerPersonalInformation("Eric Bailly","Eric Bertrand Bailly",
			   "12.04.1994","Bingerville, Ivory Coast","Ivory Coast","187 cm","77 kg","Centre Back","right");
	   player1ExpectedValueInfo.personalInfo = player1ExpectedValuePersonalInfo;
	   ArrayList <PlayerClubCareer> palyer1ExpectedValueClubCareer = new ArrayList <>();
	   PlayerClubCareer player1ClubCareer1 = new PlayerClubCareer("07/2016 - 06/2022", "Manchester United"          ,"England" ,"Defender" ,"#3" );
	   PlayerClubCareer player1ClubCareer2 = new PlayerClubCareer("01/2020 - 01/2020" ,"Manchester United U23"      ,"England" ,"Defender" ,null   );
	   PlayerClubCareer player1ClubCareer3 = new PlayerClubCareer("01/2017 - 01/2017" ,"Manchester United U23"      ,"England" ,"Defender" ,null   );
	   PlayerClubCareer player1ClubCareer4 = new PlayerClubCareer("01/2015 - 06/2016" ,"Villarreal CF"              ,"Spain"   ,"Defender" ,null   );
	   PlayerClubCareer player1ClubCareer5 = new PlayerClubCareer("09/2014 - 01/2015" ,"Espanyol Barcelona"         ,"Spain"   ,"Defender" ,null   );
	   PlayerClubCareer player1ClubCareer6 = new PlayerClubCareer("03/2013 - 01/2015" , "Espanyol Barcelona B"       ,"Spain"   ,"Defender" ,null  );
	   PlayerClubCareer player1ClubCareer7 = new PlayerClubCareer("07/2012 - 06/2013" ,"Espanyol Barcelona [Youth]" ,"Spain"   ,"Defender" ,null   );
	   palyer1ExpectedValueClubCareer.add(player1ClubCareer1);
	   palyer1ExpectedValueClubCareer.add(player1ClubCareer2);
	   palyer1ExpectedValueClubCareer.add(player1ClubCareer3);
	   palyer1ExpectedValueClubCareer.add(player1ClubCareer4);
	   palyer1ExpectedValueClubCareer.add(player1ClubCareer5);
	   palyer1ExpectedValueClubCareer.add(player1ClubCareer6);
	   palyer1ExpectedValueClubCareer.add(player1ClubCareer7);
	   player1ExpectedValueInfo.clubsCareer = palyer1ExpectedValueClubCareer;
	   ArrayList <PlayerCompetitionsInformation> player1ExpectedValueClubMatchesInfo = new ArrayList<>();
	   PlayerCompetitionsInformation player1ClubMatches1 = new PlayerCompetitionsInformation("Champions League",         "UEFA"   ,"7","0","7","0","1","2","0","0");
	   PlayerCompetitionsInformation player1ClubMatches2 = new PlayerCompetitionsInformation("Europa League"   ,         "UEFA"   ,"24","1","24","0","2","4","2","1");
	   PlayerCompetitionsInformation player1ClubMatches3 = new PlayerCompetitionsInformation("Premier League",           "England","56","1","45","11","5","7","0","1");
	   PlayerCompetitionsInformation player1ClubMatches4 = new PlayerCompetitionsInformation("FA Cup"      , 	         "England","6","0","5","1","2","1","0","0");
	   PlayerCompetitionsInformation player1ClubMatches5 = new PlayerCompetitionsInformation("League Cup", 	             "England","5","0","5","0","0","0","0","0");
	   PlayerCompetitionsInformation player1ClubMatches6 = new PlayerCompetitionsInformation("FA Community Shield",      "England","1","0","1","0","0","1","0","0");
	   PlayerCompetitionsInformation player1ClubMatches7 = new PlayerCompetitionsInformation("U23 Premier League Div. 1","England","1","0","1","0","1","0","0","0");
	   PlayerCompetitionsInformation player1ClubMatches8 = new PlayerCompetitionsInformation("U23 Premier League Div. 2","England","1","0","1","0","1","0","0","0");
	   PlayerCompetitionsInformation player1ClubMatches9 = new PlayerCompetitionsInformation("Primera División"	    ,"Spanien","40","0","39","1","10","15","1","0");
	   PlayerCompetitionsInformation player1ClubMatches10 = new PlayerCompetitionsInformation("Copa del Rey"         	,"Spanien","3","0","3","0","0","2","0","0");
	   PlayerCompetitionsInformation player1ClubMatches11 = new PlayerCompetitionsInformation("Segunda B Grupo 3",     	 "Spanien","22","0","19","3","2","6","1","0");
	   PlayerCompetitionsInformation player1ClubMatches12 = new PlayerCompetitionsInformation("∑",null,"166","2","150","16","24","38","4","2");
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches1);
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches2);
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches3);
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches4);
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches5);
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches6);
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches7);
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches8);
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches9);
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches10);
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches11);
	   player1ExpectedValueClubMatchesInfo.add(player1ClubMatches12);
	   player1ExpectedValueInfo.clubMatches = player1ExpectedValueClubMatchesInfo;
	   ArrayList <PlayerCompetitionsInformation> player1ExpectedValueInternationalInfo = new ArrayList<>();
	   PlayerCompetitionsInformation player1International1 = new PlayerCompetitionsInformation("WC Qualifiers Africa","FIFA","4","0","4","0","0","2","0","0");
	   PlayerCompetitionsInformation player1International2 = new PlayerCompetitionsInformation("Friendlies", 	"FIFA","14","0","13","1","2","1","0","0");
	   PlayerCompetitionsInformation player1International3 = new PlayerCompetitionsInformation("Africa Cup", 	"CAF","9","0","9","0","1","3","0","0");
	   PlayerCompetitionsInformation player1International4 = new PlayerCompetitionsInformation("Africa Cup Qual.","CAF","9","2","9","0","2","1","0","0");
	   PlayerCompetitionsInformation player1International5 = new PlayerCompetitionsInformation("∑",null,"36","2","35","1","5","7","0","0");
	   player1ExpectedValueInternationalInfo.add(player1International1);
	   player1ExpectedValueInternationalInfo.add(player1International2);
	   player1ExpectedValueInternationalInfo.add(player1International3);
	   player1ExpectedValueInternationalInfo.add(player1International4);
	   player1ExpectedValueInternationalInfo.add(player1International5);
	   player1ExpectedValueInfo.internationalCopmetitionsInfo = player1ExpectedValueInternationalInfo;
	   Assert.assertEquals(player1ExpectedValueInfo.toString(), player1ActualValueInfo.toString());
	   
	   PlayerAllInformation player2ActualValueInfo = new PlayerAllInformation();
	   PlayerAllInformation player2ExpectedValueInfo = new PlayerAllInformation();
	   player2ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("tony-adams");
	   PlayerPersonalInformation player2ExpectedValuePersonalInfo = new PlayerPersonalInformation("Tony Adams","Anthony Alexander Adams",
			   "10.10.1966","Romford, England","England","191 cm","87 kg","Centre Back","right");
	   player2ExpectedValueInfo.personalInfo = player2ExpectedValuePersonalInfo;
	   ArrayList <PlayerTeamManaged> player2ExpectedValueTeamManaged = new ArrayList <>();
	   PlayerTeamManaged palyer2TeamManged1 = new PlayerTeamManaged("04/2017 - 06/2017","Granada CF","Spain","Manager");
	   PlayerTeamManaged palyer2TeamManged2 = new PlayerTeamManaged("07/2010 - 06/2012","Gabala FK","Azerbaijan","Manager");
	   PlayerTeamManaged palyer2TeamManged3 = new PlayerTeamManaged("10/2008 - 02/2009","Portsmouth FC","England","Manager");
	   player2ExpectedValueTeamManaged.add(palyer2TeamManged1);
	   player2ExpectedValueTeamManaged.add(palyer2TeamManged2);
	   player2ExpectedValueTeamManaged.add(palyer2TeamManged3);
	   player2ExpectedValueInfo.teamsManaged = player2ExpectedValueTeamManaged;
	   ArrayList <PlayerClubCareer> palyer2ExpectedValueClubCareer = new ArrayList <>();
	   PlayerClubCareer player2ClubCareer1 = new PlayerClubCareer("07/1983 - 06/2002","Arsenal FC","England","Defender",null);
	   PlayerClubCareer player2ClubCareer2 = new PlayerClubCareer("07/1982 - 06/1983","Arsenal FC [U18]","England","Defender",null);
	   palyer2ExpectedValueClubCareer.add(player2ClubCareer1);
	   palyer2ExpectedValueClubCareer.add(player2ClubCareer2);
	   player2ExpectedValueInfo.clubsCareer = palyer2ExpectedValueClubCareer;
	   ArrayList <PlayerCompetitionsInformation> player2ExpectedValueClubMatchesInfo = new ArrayList<>();
	   PlayerCompetitionsInformation player2ClubMatches1 = new PlayerCompetitionsInformation("Champions League","UEFA","21","1","21","0","1","3","0","0");
	   PlayerCompetitionsInformation player2ClubMatches2 = new PlayerCompetitionsInformation("Europa League","UEFA","9","0","9","0","2","2","0","0");
	   PlayerCompetitionsInformation player2ClubMatches3 = new PlayerCompetitionsInformation("UEFA Super Cup", 	"UEFA","2","0","2","0","0","0","0","0");
	   PlayerCompetitionsInformation player2ClubMatches4 = new PlayerCompetitionsInformation("Cup Winners Cup","UEFA","16","2","16","0","0","2","0","0");
	   PlayerCompetitionsInformation player2ClubMatches5 = new PlayerCompetitionsInformation("Premier League", 	"England", "504","32","500","4","19","37","1","4");
	   PlayerCompetitionsInformation player2ClubMatches6 = new PlayerCompetitionsInformation("FA Cup", 	"England" 	,"33", 	"7", 	"32", 	"1", 	"0", 	"2" ,	"0", 	"0");
	   PlayerCompetitionsInformation player2ClubMatches7 = new PlayerCompetitionsInformation("League Cup", 	"England", 	"17","3","17","0","0","1","0","0");
	   PlayerCompetitionsInformation player2ClubMatches8 = new PlayerCompetitionsInformation("FA Community Shield" 	,"England","4","0","4","0","1","0","0","0");
	   PlayerCompetitionsInformation player2ClubMatches9 = new PlayerCompetitionsInformation("∑",null, 	"606" 	,"45","601","5","23","47","1","4");
	   player2ExpectedValueClubMatchesInfo.add(player2ClubMatches1);
	   player2ExpectedValueClubMatchesInfo.add(player2ClubMatches2);
	   player2ExpectedValueClubMatchesInfo.add(player2ClubMatches3);
	   player2ExpectedValueClubMatchesInfo.add(player2ClubMatches4);
	   player2ExpectedValueClubMatchesInfo.add(player2ClubMatches5);
	   player2ExpectedValueClubMatchesInfo.add(player2ClubMatches6);
	   player2ExpectedValueClubMatchesInfo.add(player2ClubMatches7);
	   player2ExpectedValueClubMatchesInfo.add(player2ClubMatches8);
	   player2ExpectedValueClubMatchesInfo.add(player2ClubMatches9);
	   player2ExpectedValueInfo.clubMatches = player2ExpectedValueClubMatchesInfo;
	   ArrayList <PlayerCompetitionsInformation> player2ExpectedValueInternationalInfo = new ArrayList<>();
	   PlayerCompetitionsInformation player2International1 = new PlayerCompetitionsInformation("World Cup","FIFA","4","0","4","0","0","0","0","0");
	   PlayerCompetitionsInformation player2International2 = new PlayerCompetitionsInformation("WC Qualifiers Europe", 	"FIFA","14","0","14","0","2","2","0","0");
	   PlayerCompetitionsInformation player2International3 = new PlayerCompetitionsInformation("Friendlies", 	"FIFA","29","3","29","0","4","0","0","0");
	   PlayerCompetitionsInformation player2International4 = new PlayerCompetitionsInformation("EURO","UEFA","9","1","9","0","1","1","0","0");
	   PlayerCompetitionsInformation player2International5 = new PlayerCompetitionsInformation("EURO Qualifiers", "UEFA","10","1","10","0","2","1","0","0");
	   PlayerCompetitionsInformation player2International6 = new PlayerCompetitionsInformation("∑",null,"66","5","66","0","9","4","0","0");
	   PlayerCompetitionsInformation player2International7 = new PlayerCompetitionsInformation("EURO [U21]","UEFA","1","0","1","0","0","0","0","0");
	   PlayerCompetitionsInformation player2International8 = new PlayerCompetitionsInformation("∑ U21",null,"1","0","1","0","0","0","0","0");
	   player2ExpectedValueInternationalInfo.add(player2International1);
	   player2ExpectedValueInternationalInfo.add(player2International2);
	   player2ExpectedValueInternationalInfo.add(player2International3);
	   player2ExpectedValueInternationalInfo.add(player2International4);
	   player2ExpectedValueInternationalInfo.add(player2International5);
	   player2ExpectedValueInternationalInfo.add(player2International6);
	   player2ExpectedValueInternationalInfo.add(player2International7);
	   player2ExpectedValueInternationalInfo.add(player2International8);
	   player2ExpectedValueInfo.internationalCopmetitionsInfo = player2ExpectedValueInternationalInfo;
	   Assert.assertEquals(player2ExpectedValueInfo.toString(), player2ActualValueInfo.toString());

	   PlayerAllInformation player3ActualValueInfo = new PlayerAllInformation();
	   PlayerAllInformation player3ExpectedValueInfo = new PlayerAllInformation();
	   player3ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("walter-aitkenhead");
	   PlayerPersonalInformation player3ExpectedValuePersonalInfo = new PlayerPersonalInformation("Walter Aitkenhead","Walter Campbell Allison Aitkenhead",
			   "21.05.1887 † 19.07.1966","Glasgow, Scotland","Scotland",null,null,null,null);	  
	   player3ExpectedValueInfo.personalInfo = player3ExpectedValuePersonalInfo;
	   ArrayList <PlayerClubCareer> palyer3ExpectedValueClubCareer = new ArrayList <>();
	   PlayerClubCareer player3ClubCareer1 = new PlayerClubCareer("01/1906 - 12/1918","Blackburn Rovers","England","Forward",null);
	   PlayerClubCareer player3ClubCareer2 = new PlayerClubCareer("01/1905 - 12/1905","Partick Thistle","Scotland","Forward",null);
	   palyer3ExpectedValueClubCareer.add(player3ClubCareer1);
	   palyer3ExpectedValueClubCareer.add(player3ClubCareer2);
	   player3ExpectedValueInfo.clubsCareer = palyer3ExpectedValueClubCareer;
	   ArrayList <PlayerCompetitionsInformation> player3ExpectedValueInternationalInfo = new ArrayList<>();
	   PlayerCompetitionsInformation player3International1 = new PlayerCompetitionsInformation("Friendlies","FIFA","1","2","1","0","0","0","0","0");
	   PlayerCompetitionsInformation player3International2 = new PlayerCompetitionsInformation("∑", 	null,"1","2","1","0","0","0","0","0");
	   player3ExpectedValueInternationalInfo.add(player3International1);
	   player3ExpectedValueInternationalInfo.add(player3International2);
	   player3ExpectedValueInfo.internationalCopmetitionsInfo = player3ExpectedValueInternationalInfo;
   	   Assert.assertEquals(player3ExpectedValueInfo.toString(), player3ActualValueInfo.toString());
  
   }
   @Test 
   public void itShouldMatchDetails(){
	   
	   ScreenScraper screenScraperUnderTest = new ScreenScraper();
	
	   MatchDetails match1ActualValue = screenScraperUnderTest.getMatchDetails("premier-league","2019-2020","brighton-hove-albion","everton-fc");
	   ArrayList <Goal> match1Club1Goals = new ArrayList<>();
	   Goal match1Club1Goal1 = new Goal("1 : 0", "15",	"Pascal Groß","free kick" );
	   Goal match1Club1Goal2 = new Goal("2 : 2", "80",  "Neal Maupay","penalty"  );
	   Goal match1Club1Goal3 = new Goal("3 : 2", "90",  "Lucas Digne","own goal"  );
	   match1Club1Goals.add(match1Club1Goal1);
	   match1Club1Goals.add(match1Club1Goal2);
	   match1Club1Goals.add(match1Club1Goal3);
	   ArrayList <PlayerAtMatch> match1Club1Players = new ArrayList<>();
	   PlayerAtMatch match1Club1Player1 = new PlayerAtMatch("1","Mathew Ryan",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match1Club1Player2 = new PlayerAtMatch("5","Lewis Dunk" ,PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match1Club1Player3 = new PlayerAtMatch("15","Adam Webster",PlayerTypeAtMatch.Essential,null);
	   PlayerEventAtMatch match1Club1Player4Event1 = new PlayerEventAtMatch("66","out"); 
	   ArrayList <PlayerEventAtMatch> match1Club1Player4Events = new ArrayList<>();
	   match1Club1Player4Events.add(match1Club1Player4Event1);
	   PlayerAtMatch match1Club1Player4 = new PlayerAtMatch("22","Martín Montoya",PlayerTypeAtMatch.Essential,match1Club1Player4Events);
	   PlayerAtMatch match1Club1Player5 = new PlayerAtMatch("33","Dan Burn",PlayerTypeAtMatch.Essential,null);
	   PlayerEventAtMatch match1Club1Player6Event1 = new PlayerEventAtMatch("33","Yellow card"); 
	   ArrayList <PlayerEventAtMatch> match1Club1Player6Events = new ArrayList<>();
	   match1Club1Player6Events.add(match1Club1Player6Event1);
	   PlayerAtMatch match1Club1Player6 = new PlayerAtMatch("6","Dale Stephens",PlayerTypeAtMatch.Essential,match1Club1Player6Events);
	   PlayerEventAtMatch match1Club1Player7Event1 = new PlayerEventAtMatch("65","out"); 
	   ArrayList <PlayerEventAtMatch> match1Club1Player7Events = new ArrayList<>();
	   match1Club1Player7Events.add(match1Club1Player7Event1);
	   PlayerAtMatch match1Club1Player7 = new PlayerAtMatch("13", 	"Pascal Groß",PlayerTypeAtMatch.Essential,match1Club1Player7Events);
	   PlayerEventAtMatch match1Club1Player8Event1 = new PlayerEventAtMatch("90","Yellow card"); 
	   ArrayList <PlayerEventAtMatch> match1Club1Player8Events = new ArrayList<>();
	   match1Club1Player8Events.add(match1Club1Player8Event1);
	   PlayerAtMatch match1Club1Player8 = new PlayerAtMatch("24", 	"Davy Pröpper",PlayerTypeAtMatch.Essential,match1Club1Player8Events);
	   PlayerAtMatch match1Club1Player9 = new PlayerAtMatch("46", 	"Steven Alzate",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match1Club1Player10 = new PlayerAtMatch("7", 	"Neal Maupay",PlayerTypeAtMatch.Essential,null);
	   PlayerEventAtMatch match1Club1Player11Event1 = new PlayerEventAtMatch("80","out"); 
	   ArrayList <PlayerEventAtMatch> match1Club1Player11Events = new ArrayList<>();
	   match1Club1Player11Events.add(match1Club1Player11Event1);
	   PlayerAtMatch match1Club1Player11= new PlayerAtMatch("44", 	"Aaron Connolly",PlayerTypeAtMatch.Essential,match1Club1Player11Events);
	   PlayerEventAtMatch match1Club1Player12Event1 = new PlayerEventAtMatch("66","in"); 
	   ArrayList <PlayerEventAtMatch> match1Club1Player12Events = new ArrayList<>();
	   match1Club1Player12Events.add(match1Club1Player12Event1);
	   PlayerAtMatch match1Club1Player12= new PlayerAtMatch("21", 	"Ezequiel Schelotto",PlayerTypeAtMatch.Substitute,match1Club1Player12Events);
	   PlayerEventAtMatch match1Club1Player13Event1 = new PlayerEventAtMatch("65","in"); 
	   ArrayList <PlayerEventAtMatch> match1Club1Player13Events = new ArrayList<>();
	   match1Club1Player13Events.add(match1Club1Player13Event1);
	   PlayerAtMatch match1Club1Player13= new PlayerAtMatch("11", 	"Leandro Trossard" ,PlayerTypeAtMatch.Substitute,match1Club1Player13Events);
	   PlayerEventAtMatch match1Club1Player14Event1 = new PlayerEventAtMatch("80","in"); 
	   ArrayList <PlayerEventAtMatch> match1Club1Player14Events = new ArrayList<>();
	   match1Club1Player14Events.add(match1Club1Player14Event1);
	   PlayerAtMatch match1Club1Player14= new PlayerAtMatch("17", 	"Glenn Murray",PlayerTypeAtMatch.Substitute,match1Club1Player14Events );
	   PlayerAtMatch match1Club1Player15= new PlayerAtMatch("27", 	"David Button",PlayerTypeAtMatch.Substitute,null);
	   PlayerAtMatch match1Club1Player16= new PlayerAtMatch("14", 	"Leon Balogun",PlayerTypeAtMatch.Substitute,null);
	   PlayerAtMatch match1Club1Player17= new PlayerAtMatch("8", 	"Yves Bissouma",PlayerTypeAtMatch.Substitute,null);
	   PlayerAtMatch match1Club1Player18= new PlayerAtMatch("20", 	"Solly March",PlayerTypeAtMatch.Substitute,null);
	   match1Club1Players.add(match1Club1Player1);
	   match1Club1Players.add(match1Club1Player2);
	   match1Club1Players.add(match1Club1Player3);
	   match1Club1Players.add(match1Club1Player4);
	   match1Club1Players.add(match1Club1Player5);
	   match1Club1Players.add(match1Club1Player6);
	   match1Club1Players.add(match1Club1Player7);
	   match1Club1Players.add(match1Club1Player8);
	   match1Club1Players.add(match1Club1Player9);
	   match1Club1Players.add(match1Club1Player10);
	   match1Club1Players.add(match1Club1Player11);
	   match1Club1Players.add(match1Club1Player12);
	   match1Club1Players.add(match1Club1Player13);
	   match1Club1Players.add(match1Club1Player14);
	   match1Club1Players.add(match1Club1Player15);
	   match1Club1Players.add(match1Club1Player16);
	   match1Club1Players.add(match1Club1Player17);
	   match1Club1Players.add(match1Club1Player18);
	   ClubInMatch match1Club1 = new ClubInMatch("Brighton & Hove Albion","Graham Potter" ,match1Club1Goals,match1Club1Players);
	   
	   ArrayList <Goal> match1Club2Goals = new ArrayList<>();
	   Goal match1Club2Goal1 = new Goal("1 : 1","20", 	"Adam Webster","own goal"  );
	   Goal match1Club2Goal2 = new Goal("1 : 2","74", 	"Dominic Calvert-Lewin","left-footed shot",  "Mason Holgate"  );
	   match1Club2Goals.add(match1Club2Goal1);
	   match1Club2Goals.add(match1Club2Goal2);
	   ArrayList <PlayerAtMatch> match1Club2Players = new ArrayList<>();
	   PlayerAtMatch match1Club2Player1 = new PlayerAtMatch("1", 	"Jordan Pickford",PlayerTypeAtMatch.Essential,null);
	   PlayerEventAtMatch match1Club2Player2Event1 = new PlayerEventAtMatch("86","Yellow card"); 
	   ArrayList <PlayerEventAtMatch> match1Club2Player2Events = new ArrayList<>();
	   match1Club2Player2Events.add(match1Club2Player2Event1);
	   PlayerAtMatch match1Club2Player2 = new PlayerAtMatch("2", 	"Mason Holgate" ,PlayerTypeAtMatch.Essential ,match1Club2Player2Events);
	   PlayerAtMatch match1Club2Player3 = new PlayerAtMatch("5", 	"Michael Keane",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match1Club2Player4 = new PlayerAtMatch("12", 	"Lucas Digne",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match1Club2Player5 = new PlayerAtMatch("19", 	"Djibril Sidibé",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match1Club2Player6 = new PlayerAtMatch("21", 	"André Gomes",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match1Club2Player7 = new PlayerAtMatch("26", 	"Tom Davies",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match1Club2Player8 = new PlayerAtMatch("7", 	"Richarlison",PlayerTypeAtMatch.Essential,null);
	   ArrayList <PlayerEventAtMatch> match1Club2Player9Events = new ArrayList<>();
	   PlayerEventAtMatch match1Club2Player9Event1 = new PlayerEventAtMatch("72","out");
	   match1Club2Player9Events.add(match1Club2Player9Event1);	   
	   PlayerAtMatch match1Club2Player9 = new PlayerAtMatch("11", 	"Theo Walcott",PlayerTypeAtMatch.Essential,match1Club2Player9Events);
	   ArrayList <PlayerEventAtMatch> match1Club2Player10Events = new ArrayList<>();
	   PlayerEventAtMatch match1Club2Player10Event1 = new PlayerEventAtMatch("72","out");
	   match1Club2Player10Events.add(match1Club2Player10Event1);
	   PlayerAtMatch match1Club2Player10 = new PlayerAtMatch("17" 	,"Alex Iwobi",PlayerTypeAtMatch.Essential,match1Club2Player10Events);
	   PlayerEventAtMatch match1Club2Player11Event1 = new PlayerEventAtMatch("30","out"); 
	   ArrayList <PlayerEventAtMatch> match1Club2Player11Events = new ArrayList<>();
	   match1Club2Player11Events.add(match1Club2Player11Event1);
	   PlayerAtMatch match1Club2Player11 = new PlayerAtMatch("20", 	"Bernard",PlayerTypeAtMatch.Essential,match1Club2Player11Events);
	   PlayerEventAtMatch match1Club2Player12Event1 = new PlayerEventAtMatch("72","in"); 
	   ArrayList <PlayerEventAtMatch> match1Club2Player12Events = new ArrayList<>();
	   match1Club2Player12Events.add(match1Club2Player12Event1);
	   PlayerAtMatch match1Club2Player12= new PlayerAtMatch("8", 	"Fabian Delph",PlayerTypeAtMatch.Substitute,match1Club2Player12Events);
	   PlayerEventAtMatch match1Club2Player13Event1 = new PlayerEventAtMatch("30","in"); 
	   ArrayList <PlayerEventAtMatch> match1Club2Player13Events = new ArrayList<>();
	   match1Club2Player13Events.add(match1Club2Player13Event1);
	   PlayerAtMatch match1Club2Player13= new PlayerAtMatch("10", 	"Gylfi Sigurðsson" ,PlayerTypeAtMatch.Substitute,match1Club2Player13Events);
	   PlayerEventAtMatch match1Club2Player14Event1 = new PlayerEventAtMatch("72","in"); 
	   ArrayList <PlayerEventAtMatch> match1Club2Player14Events = new ArrayList<>();
	   match1Club2Player14Events.add(match1Club2Player14Event1);
	   PlayerAtMatch match1Club2Player14= new PlayerAtMatch("9", 	"Dominic Calvert-Lewin",PlayerTypeAtMatch.Substitute,match1Club2Player14Events );
	   PlayerAtMatch match1Club2Player15= new PlayerAtMatch("49", 	"Jonas Lössl",PlayerTypeAtMatch.Substitute,null);
	   PlayerAtMatch match1Club2Player16= new PlayerAtMatch("23", 	"Séamus Coleman",PlayerTypeAtMatch.Substitute,null);
	   PlayerAtMatch match1Club2Player17= new PlayerAtMatch("18", 	"Morgan Schneiderlin",PlayerTypeAtMatch.Substitute,null);
	   PlayerAtMatch match1Club2Player18= new PlayerAtMatch("27", 	"Moise Kean",PlayerTypeAtMatch.Substitute,null);
	   match1Club2Players.add(match1Club2Player1);
	   match1Club2Players.add(match1Club2Player2);
	   match1Club2Players.add(match1Club2Player3);
	   match1Club2Players.add(match1Club2Player4);
	   match1Club2Players.add(match1Club2Player5);
	   match1Club2Players.add(match1Club2Player6);
	   match1Club2Players.add(match1Club2Player7);
	   match1Club2Players.add(match1Club2Player8);
	   match1Club2Players.add(match1Club2Player9);
	   match1Club2Players.add(match1Club2Player10);
	   match1Club2Players.add(match1Club2Player11);
	   match1Club2Players.add(match1Club2Player12);
	   match1Club2Players.add(match1Club2Player13);
	   match1Club2Players.add(match1Club2Player14);
	   match1Club2Players.add(match1Club2Player15);
	   match1Club2Players.add(match1Club2Player16);
	   match1Club2Players.add(match1Club2Player17);
	   match1Club2Players.add(match1Club2Player18);
	   ClubInMatch match1Club2 = new ClubInMatch("Everton FC","Marco Silva" ,match1Club2Goals,match1Club2Players);
	   ArrayList <Referee> match1Referees = new ArrayList<>();
	   Referee match1Referee1 = new Referee("Andy Madley","England",KindOfReferee.Referee);
	   Referee match1Referee2 = new Referee("Edward Smart", "England",KindOfReferee.AssistantReferee);
	   Referee match1Referee3 = new Referee("Derek Eaton", "England",KindOfReferee.AssistantReferee);
	   match1Referees.add(match1Referee1);
	   match1Referees.add(match1Referee2);
	   match1Referees.add(match1Referee3);
	   MatchDetails match1ExpectedValue = new MatchDetails(match1Club1,match1Club2,"3:2","Saturday, 26. October 2019","15:00 Clock"
			   							,"Amex Stadium (Brighton / England)","30.529",match1Referees);
	   Assert.assertEquals(match1ExpectedValue.toString(), match1ActualValue.toString());
	  	   
	   MatchDetails match2ActualValue = screenScraperUnderTest.getMatchDetails("premier-league","1946-1947","brentford-fc","middlesbrough-fc");
	   ArrayList <Goal> match2Club1Goals = new ArrayList<>();
	   ArrayList <PlayerAtMatch> match2Club1Players = new ArrayList<>();
	   PlayerAtMatch match2Club1Player1 = new PlayerAtMatch("","Joe Crozier",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club1Player2 = new PlayerAtMatch("","Harry Oliver" ,PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club1Player3 = new PlayerAtMatch("","Roddie Munro",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club1Player4 = new PlayerAtMatch("","George Smith",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club1Player5 = new PlayerAtMatch("","Cyril Toulouse",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club1Player6 = new PlayerAtMatch("","Dai Hopkins",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club1Player7 = new PlayerAtMatch("", 	"George Paterson",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club1Player8 = new PlayerAtMatch("", 	"Len Townsend",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club1Player9 = new PlayerAtMatch("", 	"George Stewart",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club1Player10 = new PlayerAtMatch("", 	"Dickie Girling",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club1Player11= new PlayerAtMatch("", 	"Malky MacDonald",PlayerTypeAtMatch.Essential,null);
	   match2Club1Players.add(match2Club1Player1);
	   match2Club1Players.add(match2Club1Player2);
	   match2Club1Players.add(match2Club1Player3);
	   match2Club1Players.add(match2Club1Player4);
	   match2Club1Players.add(match2Club1Player5);
	   match2Club1Players.add(match2Club1Player6);
	   match2Club1Players.add(match2Club1Player7);
	   match2Club1Players.add(match2Club1Player8);
	   match2Club1Players.add(match2Club1Player9);
	   match2Club1Players.add(match2Club1Player10);
	   match2Club1Players.add(match2Club1Player11);
	   ClubInMatch match2Club1 = new ClubInMatch("Brentford FC","Jimmy Hogan" ,match2Club1Goals,match2Club1Players);
	   ArrayList <Goal> match2Club2Goals = new ArrayList<>();
	   ArrayList <PlayerAtMatch> match2Club2Players = new ArrayList<>();
	   PlayerAtMatch match2Club2Player1 = new PlayerAtMatch("", 	"Paddy Nash",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club2Player2 = new PlayerAtMatch("", 	"Bobby Stuart" ,PlayerTypeAtMatch.Essential ,null);
	   PlayerAtMatch match2Club2Player3 = new PlayerAtMatch("", 	"Dicky Robinson",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club2Player4 = new PlayerAtMatch("", 	"George Hardwick",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club2Player5 = new PlayerAtMatch("", 	"Harry Bell",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club2Player6 = new PlayerAtMatch("", 	"Geoff Walker",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club2Player7 = new PlayerAtMatch("", 	"Johnny Spuhler",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club2Player8 = new PlayerAtMatch("", 	"Jimmy Gordon",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club2Player9 = new PlayerAtMatch("", 	"Alec Linwood",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club2Player10 = new PlayerAtMatch("" 	,"Micky Fenton",PlayerTypeAtMatch.Essential,null);
	   PlayerAtMatch match2Club2Player11 = new PlayerAtMatch("", 	"Wilf Mannion",PlayerTypeAtMatch.Essential,null);
       match2Club2Players.add(match2Club2Player1);
	   match2Club2Players.add(match2Club2Player2);
	   match2Club2Players.add(match2Club2Player3);
	   match2Club2Players.add(match2Club2Player4);
	   match2Club2Players.add(match2Club2Player5);
	   match2Club2Players.add(match2Club2Player6);
	   match2Club2Players.add(match2Club2Player7);
	   match2Club2Players.add(match2Club2Player8);
	   match2Club2Players.add(match2Club2Player9);
	   match2Club2Players.add(match2Club2Player10);
	   match2Club2Players.add(match2Club2Player11);
	   ClubInMatch match2Club2 = new ClubInMatch("Middlesbrough FC","David Jack" ,match2Club2Goals,match2Club2Players);
	   ArrayList <Referee> match2Referees = new ArrayList<>();
	   MatchDetails match2ExpectedValue = new MatchDetails(match2Club1,match2Club2,"0:0","Saturday, 26. April 1947",null
			   							,"Griffin Park (London / England)","19.020",match2Referees);
	   //sorting the players
	   ComparePlayerNames playerComparator = new ComparePlayerNames();
	   Collections.sort(match2ActualValue.firstClub.players , playerComparator );
	   Collections.sort(match2ActualValue.secondClub.players , playerComparator );
	   Collections.sort(match2ExpectedValue.firstClub.players , playerComparator );
	   Collections.sort(match2ExpectedValue.secondClub.players , playerComparator );
  
	   Assert.assertEquals(match2ExpectedValue.toString(), match2ActualValue.toString());
  
   }
   
  @Test
   public void itShouldGetTransferTable() {

	   ScreenScraper screenScraperUnderTest = new ScreenScraper();

	   ArrayList <ClubTransferTable> clubTransferTable2015_2016 = new ArrayList<>();
	   clubTransferTable2015_2016 = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier","2015-2016");
	   ClubTransferTable astonVillaTransferTable2015_2016ActualValue = new ClubTransferTable();//
	   astonVillaTransferTable2015_2016ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(clubTransferTable2015_2016 ,"Aston Villa");
	   ClubTransferTable AstonVillatransferTable2015_2016_5IN5Out_ActualValue = new ClubTransferTable();
	   AstonVillatransferTable2015_2016_5IN5Out_ActualValue.clubBasicInfo.name = astonVillaTransferTable2015_2016ActualValue.clubBasicInfo.name;
	   AstonVillatransferTable2015_2016_5IN5Out_ActualValue.season=astonVillaTransferTable2015_2016ActualValue.season;
	   for(int i=0 ; i < 5 ; i++) {
		   AstonVillatransferTable2015_2016_5IN5Out_ActualValue.intable.add(astonVillaTransferTable2015_2016ActualValue.intable.get(i));
		   AstonVillatransferTable2015_2016_5IN5Out_ActualValue.outtable.add(astonVillaTransferTable2015_2016ActualValue.outtable.get(i));
	   }
	   //Aston Villa 2015-2016
	   ClubTransferTable AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue = new ClubTransferTable();
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.clubBasicInfo.name ="Aston Villa";
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.season ="2015-2016";
	   // first 5 in
	   TransferPlayerInformation playerIn1 = new TransferPlayerInformation("05/16","Lewis Kinsella", 	"England", 	"DF" 	,"Kidderminster Harriers","Aston Villa");
	   TransferPlayerInformation playerIn2 = new TransferPlayerInformation("01/16", 	"Joe Cole","England","MF", "Coventry City","Aston Villa");
	   TransferPlayerInformation playerIn3 = new TransferPlayerInformation("01/16","Aly Cissokho", 	"France","DF","FC Porto","Aston Villa");
	   TransferPlayerInformation playerIn4 = new TransferPlayerInformation("01/16", 	"Callum Robinson", 	"Ireland", 	"MF", 	"Bristol City", 	"Aston Villa");
	   TransferPlayerInformation playerIn5 = new TransferPlayerInformation("11/15", 	"Bradley Watkins", 	"England", 	"GK", 	"Wolverhampton Wanderers U21" 	,"Aston Villa");
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable.add(playerIn1);
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable.add(playerIn2);
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable.add(playerIn3);
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable.add(playerIn4);
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable.add(playerIn5);
	   //first 5 out
	   TransferPlayerInformation playerOut1 = new TransferPlayerInformation("03/16", "Jerell Sellars", 	 "England",	   "MF","Aston Villa","Wycombe Wanderers");
	   TransferPlayerInformation playerOut2 = new TransferPlayerInformation("02/16", "Lewis Kinsella", 	 "England",    "DF","Aston Villa","Kidderminster Harriers");
	   TransferPlayerInformation playerOut3 = new TransferPlayerInformation("01/16", "Philippe Senderos","Switzerland","DF","Aston Villa","Grasshopper Club Zürich");
	   TransferPlayerInformation playerOut4 = new TransferPlayerInformation("01/16", "Ángel Crespo", 	 "Spain", 	   "DF","Aston Villa","Rayo Vallecano");
	   TransferPlayerInformation playerOut5 = new TransferPlayerInformation("01/16", "Gary Gardner",     "England",    "MF","Aston Villa","Nottingham Forest");
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable.add(playerOut1);
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable.add(playerOut2);
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable.add(playerOut3);
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable.add(playerOut4);
	   AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable.add(playerOut5);
	   Assert.assertEquals(AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.toString(), AstonVillatransferTable2015_2016_5IN5Out_ActualValue.toString());
	   
	   ArrayList <ClubTransferTable> clubTransferTable1889_1890 = new ArrayList<>();
	   clubTransferTable1889_1890 = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier","1889-1890");
	   ClubTransferTable AstonVillaTransferTable1889_1890ActualValue = new ClubTransferTable();
	   AstonVillaTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(clubTransferTable1889_1890 ,"Aston Villa");
	   //Aston Villa 1889-1890
	   ClubTransferTable AstonVillatransferTable1889_1890ExpectedValue = new ClubTransferTable();
	   AstonVillatransferTable1889_1890ExpectedValue.clubBasicInfo.name ="Aston Villa";
	   AstonVillatransferTable1889_1890ExpectedValue.season ="1889-1890";
	   //  in
	   TransferPlayerInformation playerIn10 = new TransferPlayerInformation("07/89","Albert Aldridge","England","DF","Swifts FC","Aston Villa");
	   TransferPlayerInformation playerIn11 = new TransferPlayerInformation("07/89","William Dickson","Scotland","FW","Sunderland AFC","Aston Villa");
	   AstonVillatransferTable1889_1890ExpectedValue.intable.add(playerIn10);
	   AstonVillatransferTable1889_1890ExpectedValue.intable.add(playerIn11);
	   //out
	   TransferPlayerInformation playerOut10 = new TransferPlayerInformation("06/89", "Archie Goodall", 	 "Northern Ireland", 	"MF",	"Aston Villa","Derby County");
	   AstonVillatransferTable1889_1890ExpectedValue.outtable.add(playerOut10);
	   Assert.assertEquals(AstonVillatransferTable1889_1890ExpectedValue.toString(), AstonVillaTransferTable1889_1890ActualValue.toString());

	   ClubTransferTable AccringtonFCTransferTable1889_1890ActualValue = new ClubTransferTable();
	   AccringtonFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(clubTransferTable1889_1890 ,"Accrington FC");
	   //Accrington FC 1889-1890
	   ClubTransferTable AccringtonFCtransferTable1889_1890ExpectedValue = new ClubTransferTable();
	   AccringtonFCtransferTable1889_1890ExpectedValue.clubBasicInfo.name ="Accrington FC";
	   AccringtonFCtransferTable1889_1890ExpectedValue.season ="1889-1890";
	   //out
	   TransferPlayerInformation playerOut20 = new TransferPlayerInformation("06/89", 	"Joe Lofthouse", 	"England" 	,"FW","Accrington FC", 	"Blackburn Rovers");
	   AccringtonFCtransferTable1889_1890ExpectedValue.outtable.add(playerOut20);
	   Assert.assertEquals(AccringtonFCtransferTable1889_1890ExpectedValue.toString(), AccringtonFCTransferTable1889_1890ActualValue.toString());

	   //Derby County 1889-1890
	   ClubTransferTable DerbyCountyTransferTable1889_1890ActualValue = new ClubTransferTable();
	   DerbyCountyTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(clubTransferTable1889_1890 ,"Derby County");
	   ClubTransferTable DerbyCountytransferTable1889_1890ExpectedValue = new ClubTransferTable();
	   DerbyCountytransferTable1889_1890ExpectedValue.clubBasicInfo.name ="Derby County";
	   DerbyCountytransferTable1889_1890ExpectedValue.season ="1889-1890";
	   //  in
	   TransferPlayerInformation playerIn30 = new TransferPlayerInformation("07/89","Charlie Bunyan","England","GK","Hyde FC","Derby County");
	   TransferPlayerInformation playerIn31 = new TransferPlayerInformation("07/89","Archie Goodall","Northern Ireland","MF","Aston Villa","Derby County");
	   TransferPlayerInformation playerIn32 = new TransferPlayerInformation("07/89","John Goodall","England","FW","Preston North End","Derby County");
	   DerbyCountytransferTable1889_1890ExpectedValue.intable.add(playerIn30);
	   DerbyCountytransferTable1889_1890ExpectedValue.intable.add(playerIn31);
	   DerbyCountytransferTable1889_1890ExpectedValue.intable.add(playerIn32);
	   Assert.assertEquals(DerbyCountytransferTable1889_1890ExpectedValue.toString(), DerbyCountyTransferTable1889_1890ActualValue.toString());

	   //Burnley FC 1889-1890
	   ClubTransferTable BurnleyFCTransferTable1889_1890ActualValue = new ClubTransferTable();
	   BurnleyFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(clubTransferTable1889_1890 ,"Burnley FC");
	   ClubTransferTable BurnleyFCtransferTable1889_1890ExpectedValue = new ClubTransferTable();
	   BurnleyFCtransferTable1889_1890ExpectedValue.clubBasicInfo.name ="Burnley FC";
	   BurnleyFCtransferTable1889_1890ExpectedValue.season ="1889-1890";
	   Assert.assertEquals(BurnleyFCtransferTable1889_1890ExpectedValue.toString(), BurnleyFCTransferTable1889_1890ActualValue.toString());

   }

   @Test
   public void itShouldGetTopSoccer() {
       ScreenScraper screenScraperUnderTest = new ScreenScraper();

       ArrayList <PlayerTopSoccer> table2019_2020ActualValue = new ArrayList<>();
       table2019_2020ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("2019-2020");
       ArrayList <PlayerTopSoccer> table2019_2020player0TO4ActualValue = new ArrayList<>();
       for(int i =0 ; i<5 ;i++) {
    	   table2019_2020player0TO4ActualValue.add(table2019_2020ActualValue.get(i));
       }
       ArrayList <PlayerTopSoccer> table2019_2020player0TO4ExpectedValue = new ArrayList<>();
       PlayerTopSoccer player1 = new PlayerTopSoccer("1.", 	"Jamie Vardy", 	            "England", 	"Leicester City","23","4");
       PlayerTopSoccer player2 = new PlayerTopSoccer("2.", 	"Pierre-Emerick Aubameyang","Gabon", 	"Arsenal FC", "22", "2");
       PlayerTopSoccer player3 = new PlayerTopSoccer("2.",	"Danny Ings",	            "England", 	"Southampton FC", "22","1");
       PlayerTopSoccer player4 = new PlayerTopSoccer("4.", 	"Raheem Sterling",	        "England", 	"Manchester City","20", "0");
       PlayerTopSoccer player5 = new PlayerTopSoccer("5.", 	"Mohamed Salah", 	 	    "Egypt", 	"Liverpool FC","19", "3");
       table2019_2020player0TO4ExpectedValue.add(player1);
       table2019_2020player0TO4ExpectedValue.add(player2);
       table2019_2020player0TO4ExpectedValue.add(player3);
       table2019_2020player0TO4ExpectedValue.add(player4);
       table2019_2020player0TO4ExpectedValue.add(player5);
	   Assert.assertEquals(table2019_2020player0TO4ExpectedValue.toString(), table2019_2020player0TO4ActualValue.toString());

	   ArrayList <PlayerTopSoccer> table2009_2010ActualValue = new ArrayList<>();
	   table2009_2010ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("2009-2010");
       ArrayList <PlayerTopSoccer> table2009_2010player4TO9ActualValue = new ArrayList<>();
       for(int i =4 ; i<9 ;i++) {
    	   table2009_2010player4TO9ActualValue.add(table2009_2010ActualValue.get(i));
       }
       ArrayList <PlayerTopSoccer> table2009_2010player4TO9ExpectedValue = new ArrayList<>();
       PlayerTopSoccer player11 = new PlayerTopSoccer("5.",	"Frank Lampard",    "England",	"Chelsea FC",        "22","10");
       PlayerTopSoccer player12 = new PlayerTopSoccer("6.", "Jermain Defoe",    "England", 	"Tottenham Hotspur", "18","1");
       PlayerTopSoccer player13 = new PlayerTopSoccer("6.",	"Fernando Torres",  "Spain", 	"Liverpool FC", 	 "18","0");
       PlayerTopSoccer player14 = new PlayerTopSoccer("8.", "Cesc Fàbregas",    "Spain", 	"Arsenal FC",   	 "15","3");
       PlayerTopSoccer player15 = new PlayerTopSoccer("9.", "Emmanuel Adebayor", "Togo", 	"Manchester City", 	 "14","0");
       table2009_2010player4TO9ExpectedValue.add(player11);
       table2009_2010player4TO9ExpectedValue.add(player12);
       table2009_2010player4TO9ExpectedValue.add(player13);
       table2009_2010player4TO9ExpectedValue.add(player14);
       table2009_2010player4TO9ExpectedValue.add(player15);
	   Assert.assertEquals(table2009_2010player4TO9ExpectedValue.toString(), table2009_2010player4TO9ActualValue.toString());
       
	   ArrayList <PlayerTopSoccer> table1946_1947ActualValue = new ArrayList<>();
	   table1946_1947ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("1946-1947");
       ArrayList <PlayerTopSoccer> table1946_1947player0TO4ActualValue = new ArrayList<>();
       for(int i =0 ; i<5 ;i++) {
    	   table1946_1947player0TO4ActualValue.add(table1946_1947ActualValue.get(i));
       }
       ArrayList <PlayerTopSoccer> table1946_1947player0TO4ExpectedValue = new ArrayList<>();
       PlayerTopSoccer player20 = new PlayerTopSoccer("1.", "Dennis Westcott", 	"England",	"Wolverhampton Wanderers","38", "0");
       PlayerTopSoccer player21 = new PlayerTopSoccer("2.", "Reg Lewis",        "England", 	"Arsenal FC", "29", "3");
       PlayerTopSoccer player22 = new PlayerTopSoccer("2.",	"Stan Mortensen",	"England", 	"Blackpool FC",  "29","1");
       PlayerTopSoccer player23 = new PlayerTopSoccer("2.", "Duggie Reid", 	 	"Scotland", "Portsmouth FC", "29","1");
       PlayerTopSoccer player24 = new PlayerTopSoccer("2.", "Freddie Steele",	"England", 	"Stoke City",	 "29","0");
       table1946_1947player0TO4ExpectedValue.add(player20);
       table1946_1947player0TO4ExpectedValue.add(player21);
       table1946_1947player0TO4ExpectedValue.add(player22);
       table1946_1947player0TO4ExpectedValue.add(player23);
       table1946_1947player0TO4ExpectedValue.add(player24);
	   Assert.assertEquals(table1946_1947player0TO4ExpectedValue.toString(), table1946_1947player0TO4ActualValue.toString());
     
   }
   @Test
   public void itShouldGetStatisticsGoalsPerSeason() {
       ScreenScraper screenScraperUnderTest = new ScreenScraper();
       ArrayList <StatisticsGoalsPerSeason> actualValue = new ArrayList<>();
       actualValue = screenScraperUnderTest.getStatisticsGoalsPerSeason("eng-championship");
       ArrayList <StatisticsGoalsPerSeason> actualValue0To9 = new ArrayList<>();
       for(int i = 0 ; i < 9 ; i++ ) {
    	   actualValue0To9.add(actualValue.get(i));
       }
       ArrayList <StatisticsGoalsPerSeason> expectedValue0To9 = new ArrayList<>();
       StatisticsGoalsPerSeason season0 = new StatisticsGoalsPerSeason("1","1892/1893","591","132","4.4773");
       StatisticsGoalsPerSeason season1 = new StatisticsGoalsPerSeason("2","1894/1895","1019","239","4.2636");
       StatisticsGoalsPerSeason season2 = new StatisticsGoalsPerSeason("3","1893/1894","894","210","4.2571");
       StatisticsGoalsPerSeason season3 = new StatisticsGoalsPerSeason("4","1895/1896","943","240","3.9292");
       StatisticsGoalsPerSeason season4 = new StatisticsGoalsPerSeason("5","1896/1897","907","240","3.7792");
       StatisticsGoalsPerSeason season5 = new StatisticsGoalsPerSeason("6","1926/1927","1668","462","3.6104");
       StatisticsGoalsPerSeason season6 = new StatisticsGoalsPerSeason("7","1898/1899","1103","306","3.6046");
       StatisticsGoalsPerSeason season7 = new StatisticsGoalsPerSeason("8","1897/1898","860","240","3.5833");
       StatisticsGoalsPerSeason season8 = new StatisticsGoalsPerSeason("9","1956/1957","1644","462","3.5584");
       expectedValue0To9.add(season0);
       expectedValue0To9.add(season1);
       expectedValue0To9.add(season2);
       expectedValue0To9.add(season3);
       expectedValue0To9.add(season4);
       expectedValue0To9.add(season5);
       expectedValue0To9.add(season6);
       expectedValue0To9.add(season7);
       expectedValue0To9.add(season8);
	   Assert.assertEquals(expectedValue0To9.toString(), actualValue0To9.toString());    
       
   }
   @Test
   public void itShouldGetStatisticsGoalsPerRound() {
       ScreenScraper screenScraperUnderTest = new ScreenScraper();
       ArrayList <StatisticsGoalsPerRound> actualValue = new ArrayList<>();
       actualValue  = screenScraperUnderTest.getStatisticsGoalsPerRound("eng-championship");
       ArrayList <StatisticsGoalsPerRound> actualValue0To9 = new ArrayList<>();
       for(int i = 0 ; i < 9 ; i++ ) {
    	   actualValue0To9.add(actualValue.get(i));
       }
       ArrayList <StatisticsGoalsPerRound> expectedlValue0To9 = new ArrayList<>();
       StatisticsGoalsPerRound round0 =  new StatisticsGoalsPerRound("1","1892/1893","11. Round","39","6","6.5000");
       StatisticsGoalsPerRound round1 =  new StatisticsGoalsPerRound("2","1892/1893","20. Round","38","6","6.3333");
       StatisticsGoalsPerRound round2 =  new StatisticsGoalsPerRound("3","1892/1893","7. Round", "36","6","6.0000");                                                                    
       StatisticsGoalsPerRound round3 =  new StatisticsGoalsPerRound("4","1893/1894","10. Round","40","7","5.7143");
       StatisticsGoalsPerRound round4 =  new StatisticsGoalsPerRound("5","1893/1894","21. Round","40","7","5.7143");
       StatisticsGoalsPerRound round5 =  new StatisticsGoalsPerRound("6","1892/1893","8. Round", "34","6","5.6667");
       StatisticsGoalsPerRound round6 =  new StatisticsGoalsPerRound("7","1892/1893","17. Round","33","6","5.5000");
       StatisticsGoalsPerRound round7 =  new StatisticsGoalsPerRound("8","1892/1893","1. Round", "33","6","5.5000");
       StatisticsGoalsPerRound round8 =  new StatisticsGoalsPerRound("9","1893/1894","15. Round","38","7","5.4286");
       expectedlValue0To9.add(round0);
       expectedlValue0To9.add(round1);
       expectedlValue0To9.add(round2);
       expectedlValue0To9.add(round3);
       expectedlValue0To9.add(round4);
       expectedlValue0To9.add(round5);
       expectedlValue0To9.add(round6);
       expectedlValue0To9.add(round7);
       expectedlValue0To9.add(round8);
      
	   Assert.assertEquals(expectedlValue0To9.toString(), actualValue0To9.toString());    

   }
   @Test
   public void itShouldGetStatisticsRecordWins() {
   ScreenScraper screenScraperUnderTest = new ScreenScraper();
   ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue = new ArrayList<>();
   actualValue = screenScraperUnderTest.getStatisticsRecordWinsOrMostGoalInGame("eng-championship", 3);
   ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue0To9 = new ArrayList<>();
   for(int i =0 ; i < 10 ; i++) {
	   actualValue0To9.add(actualValue.get(i));
   }
   ArrayList<StatisticsRecordWinsAndMostGoalInGame> expectedValue0To9 = new ArrayList<>();
   StatisticsRecordWinsAndMostGoalInGame game1 = new StatisticsRecordWinsAndMostGoalInGame ("1946/1947","3. Round","05/10/1946","Newcastle United",       "13:0",  "Newport County");
   StatisticsRecordWinsAndMostGoalInGame game2 = new StatisticsRecordWinsAndMostGoalInGame ("1902/1903","8. Round","11/04/1903","Small Heath Birmingham", "12:0",  "Doncaster Rovers");
   StatisticsRecordWinsAndMostGoalInGame game3 = new StatisticsRecordWinsAndMostGoalInGame ("1899/1900","7. Round","12/03/1900","Woolwich Arsenal",       "12:0",  "Loughborough United");
   StatisticsRecordWinsAndMostGoalInGame game4 = new StatisticsRecordWinsAndMostGoalInGame ("1896/1897","4. Round","26/12/1896","Darwen",                 "12:0",  "Walsall FC");
   StatisticsRecordWinsAndMostGoalInGame game5 = new StatisticsRecordWinsAndMostGoalInGame ("1892/1893","7. Round","17/12/1892","Small Heath Birmingham", "12:0", 	"Walsall Town Swifts");
   StatisticsRecordWinsAndMostGoalInGame game6 = new StatisticsRecordWinsAndMostGoalInGame ("1959/1960","4. Round","14/11/1959","Aston Villa", 	 	      "11:1", 	"Charlton Athletic" 	);
   StatisticsRecordWinsAndMostGoalInGame game7 = new StatisticsRecordWinsAndMostGoalInGame ("1914/1915","5. Round","23/01/1915","Birmingham FC", 	 	  "11:1", 	"Glossop North End");
   StatisticsRecordWinsAndMostGoalInGame game8 = new StatisticsRecordWinsAndMostGoalInGame ("1902/1903","5. Round","17/01/1903","Chesterfield FC", 	      "10:0", 	"Glossop North End");
   StatisticsRecordWinsAndMostGoalInGame game9 = new StatisticsRecordWinsAndMostGoalInGame ("1898/1899","8. Round","01/04/1899","Loughborough United", 	  "10:0", 	"Darwen");
   StatisticsRecordWinsAndMostGoalInGame game10 = new StatisticsRecordWinsAndMostGoalInGame("1898/1899","7. Round","04/03/1899","Walsall FC", 	          "10:0", 	"Darwen");
   expectedValue0To9.add(game1);
   expectedValue0To9.add(game2);
   expectedValue0To9.add(game3);
   expectedValue0To9.add(game4);
   expectedValue0To9.add(game5);
   expectedValue0To9.add(game6);
   expectedValue0To9.add(game7);
   expectedValue0To9.add(game8);
   expectedValue0To9.add(game9);
   expectedValue0To9.add(game10);
   Assert.assertEquals(expectedValue0To9.toString(), actualValue0To9.toString());    


   }
   @Test
   public void itShouldGetStatisticsMostGoalInGame() {
       ScreenScraper screenScraperUnderTest = new ScreenScraper();
       ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue = new ArrayList<>();
       actualValue = screenScraperUnderTest.getStatisticsRecordWinsOrMostGoalInGame("eng-championship", 4);
       ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue0To9 = new ArrayList<>();
       for(int i =0 ; i < 10 ; i++) {
    	   actualValue0To9.add(actualValue.get(i));
       }
       ArrayList<StatisticsRecordWinsAndMostGoalInGame> expectedValue0To9 = new ArrayList<>();
       StatisticsRecordWinsAndMostGoalInGame game1 = new StatisticsRecordWinsAndMostGoalInGame ("1894/1895", "7. Round",   "23/03/1895", 	"Manchester City",	 "11:3","Lincoln City");
       StatisticsRecordWinsAndMostGoalInGame game2 = new StatisticsRecordWinsAndMostGoalInGame ("1957/1958", "5. Round",   "21/12/1957", 	"Charlton Athletic",  "7:6","Huddersfield Town");
       StatisticsRecordWinsAndMostGoalInGame game3 = new StatisticsRecordWinsAndMostGoalInGame ("1946/1947", "3. Round",   "05/10/1946", 	"Newcastle United",   "13:0","Newport County");
       StatisticsRecordWinsAndMostGoalInGame game4 = new StatisticsRecordWinsAndMostGoalInGame ("1919/1920", "4. Round",   "27/12/1919", 	"Hull City" ,		  "10:3",  	"Wolverhampton Wanderers");
       StatisticsRecordWinsAndMostGoalInGame game5 = new StatisticsRecordWinsAndMostGoalInGame ("1893/1894", "27. Round",  "24/02/1894", 	"Burton Swifts", 	  "8:5","Walsall Town Swifts");
       StatisticsRecordWinsAndMostGoalInGame game6 = new StatisticsRecordWinsAndMostGoalInGame ("1965/1966", "2. Round",   "18/09/1965", 	"Southampton FC" ,	  "9:3",  	"Wolverhampton Wanderers");
       StatisticsRecordWinsAndMostGoalInGame game7 = new StatisticsRecordWinsAndMostGoalInGame ("1960/1961", "3. Round",   "22/10/1960", 	"Charlton Athletic",  "6:6", 	"Middlesbrough FC");
       StatisticsRecordWinsAndMostGoalInGame game8 = new StatisticsRecordWinsAndMostGoalInGame ("1959/1960", "4. Round",   "14/11/1959", 	"Aston Villa", 	      "11:1", 	"Charlton Athletic");
       StatisticsRecordWinsAndMostGoalInGame game9 = new StatisticsRecordWinsAndMostGoalInGame ("1953/1954", "7. Round",   "27/02/1954", 	"Everton FC", 	      "8:4","Plymouth Argyle");
       StatisticsRecordWinsAndMostGoalInGame game10 = new StatisticsRecordWinsAndMostGoalInGame("1938/1939", "5. Round",   "26/12/1938", 	"Tranmere Rovers", 	  "3:9","Manchester City");
       expectedValue0To9.add(game1);
       expectedValue0To9.add(game2);
       expectedValue0To9.add(game3);
       expectedValue0To9.add(game4);
       expectedValue0To9.add(game5);
       expectedValue0To9.add(game6);
       expectedValue0To9.add(game7);
       expectedValue0To9.add(game8);
       expectedValue0To9.add(game9);
       expectedValue0To9.add(game10);
       Assert.assertEquals(expectedValue0To9.toString(), actualValue0To9.toString());    


   }
   
   @Test
   public void itShouldGetStatisticsDirtiesGamesForCompetition() {
	   ScreenScraper screenScraperUnderTest = new ScreenScraper();
       ArrayList<DirtyGame> actualValue = new ArrayList<>();
       actualValue = screenScraperUnderTest.getStatisticsDirtiesGamesForCompetition("eng-championship");
       ArrayList<DirtyGame> actualValue0To9 = new ArrayList<>();
       for(int i =0 ; i < 10 ; i++) {
    	   actualValue0To9.add(actualValue.get(i));
       }
       ArrayList<DirtyGame> expectedValue0To9 = new ArrayList<>();
       DirtyGame game1 = new DirtyGame ("14/04/2007", 	"Ipswich Town", 	 	   "2:1", "Derby County", 	     "2","0","10","16");
       DirtyGame game2 = new DirtyGame ("14/04/2015", 	"Millwall FC", 	 	       "2:0", "Wigan Athletic",      "3","0","6","15");
       DirtyGame game3 = new DirtyGame ("17/10/1997", 	"Wolverhampton Wanderers", "3:1", "Swindon Town", 	     "3","0","4","13");
       DirtyGame game4 = new DirtyGame ("04/03/2008", 	"Hull City", 	 	       "2:0", "Burnley FC", 	     "2","2","3","13");
       DirtyGame game5 = new DirtyGame ("01/11/2005", 	"Burnley FC", 		       "2:1", "Millwall FC","2", 	"1", 	"5", 	"13");
       DirtyGame game6 = new DirtyGame ("10/04/2001", 	"Crewe Alexandra", 		   "2:2", "Queens Park Rangers","2", 	"1", 	"5", 	"13");
       DirtyGame game7 = new DirtyGame ("21/11/2015", 	"Leeds United", 	       "0:1", "Rotherham United", 	 	"2", 	"0", 	"7", 	"13");
       DirtyGame game8 = new DirtyGame ("21/12/2002", 	"Gillingham FC", 	       "4:2", "Burnley FC", 		"2","0","7","13");
       DirtyGame game9 = new DirtyGame ("04/11/2000", 	"Nottingham Forest", 	   "3:1", "Preston North End", 	"2","0","7","13");
       DirtyGame game10 = new DirtyGame ("19/12/1997", 	"Reading FC", 	           "0:0", "Wolverhampton Wanderers", 	"2","0","7","13");
       expectedValue0To9.add(game1);
       expectedValue0To9.add(game2);
       expectedValue0To9.add(game3);
       expectedValue0To9.add(game4);
       expectedValue0To9.add(game5);
       expectedValue0To9.add(game6);
       expectedValue0To9.add(game7);
       expectedValue0To9.add(game8);
       expectedValue0To9.add(game9);
       expectedValue0To9.add(game10);
       
       Assert.assertEquals(expectedValue0To9.toString(), actualValue0To9.toString());    

   }
   @Test
   public void itShouldGetStatisticsBestPlayerInYear() {
       ScreenScraper screenScraperUnderTest = new ScreenScraper();
       ArrayList<StatisticsBestPlayerInYear> actualValue = new ArrayList<>();
       actualValue = screenScraperUnderTest.getStatisticsBestPlayerInYear("england");
       ArrayList<StatisticsBestPlayerInYear> actualValue0To9 = new ArrayList<>();
       for(int i =0 ; i < 10 ; i++) {
    	   actualValue0To9.add(actualValue.get(i));
       }
       ArrayList<StatisticsBestPlayerInYear> expectedValue0To9 = new ArrayList<>();
       StatisticsBestPlayerInYear game1  = new StatisticsBestPlayerInYear ("2020", 	"Jordan Henderson");
       StatisticsBestPlayerInYear game2  = new StatisticsBestPlayerInYear ("2019", 	"Raheem Sterling");
       StatisticsBestPlayerInYear game3  = new StatisticsBestPlayerInYear ("2018", 	"Mohamed Salah");
       StatisticsBestPlayerInYear game4  = new StatisticsBestPlayerInYear ("2017", 	"N'Golo Kanté");
       StatisticsBestPlayerInYear game5  = new StatisticsBestPlayerInYear ("2016", 	"Jamie Vardy");
       StatisticsBestPlayerInYear game6  = new StatisticsBestPlayerInYear ("2015", 	"Eden Hazard");
       StatisticsBestPlayerInYear game7  = new StatisticsBestPlayerInYear ("2014", 	"Luis Suárez");
       StatisticsBestPlayerInYear game8  = new StatisticsBestPlayerInYear ("2013", 	"Gareth Bale");
       StatisticsBestPlayerInYear game9  = new StatisticsBestPlayerInYear ("2012", 	"Robin van Persie");
       StatisticsBestPlayerInYear game10 = new StatisticsBestPlayerInYear ("2011", 	"Scott Parker");
       expectedValue0To9.add(game1);
       expectedValue0To9.add(game2);
       expectedValue0To9.add(game3);
       expectedValue0To9.add(game4);
       expectedValue0To9.add(game5);
       expectedValue0To9.add(game6);
       expectedValue0To9.add(game7);
       expectedValue0To9.add(game8);
       expectedValue0To9.add(game9);
       expectedValue0To9.add(game10);
       
       Assert.assertEquals(expectedValue0To9.toString(), actualValue0To9.toString());   

   }
   @Test 
   public void itShouldGetStaduim() {
	   ScreenScraper screenScraperUnderTest = new ScreenScraper();
       ArrayList<Staduim> actualValue2020_2021 = new ArrayList<>();
       actualValue2020_2021 = screenScraperUnderTest.getCompetitionSatuims("eng-championship","2020-2021");
       ArrayList<Staduim> actualValue2020_2021Just0To5 = new ArrayList<>();
       for(int i =0 ; i < 5 ; i++) {
    	   actualValue2020_2021Just0To5.add(actualValue2020_2021.get(i));
       }
       ArrayList<Staduim> expectedValue2020_2021Just0To5 = new ArrayList<>();
       Staduim staduim1 = new Staduim ("Adams Park", 	              "Wycombe", 	   "England",  "10.000");
       Staduim staduim2 = new Staduim ("Ashton Gate", 	              "Bristol", 	   "England",  "27.000");
       Staduim staduim3 = new Staduim ("bet365 Stadium", 	          "Stoke-on-Trent","England",  "30.089");
       Staduim staduim4 = new Staduim ("Brentford Community Stadium", "Brentford", 	   "England",  "17.250");
       Staduim staduim5 = new Staduim ("Cardiff City Stadium",        "Cardiff", 	   "Wales",    "33.000");
       expectedValue2020_2021Just0To5.add(staduim1);
       expectedValue2020_2021Just0To5.add(staduim2);
       expectedValue2020_2021Just0To5.add(staduim3);
       expectedValue2020_2021Just0To5.add(staduim4);
       expectedValue2020_2021Just0To5.add(staduim5);
       

       Assert.assertEquals(expectedValue2020_2021Just0To5.toString(), actualValue2020_2021Just0To5.toString());   
       
       ArrayList<Staduim> actualValue1950_1951 = new ArrayList<>();
       actualValue1950_1951 = screenScraperUnderTest.getCompetitionSatuims("eng-championship","1950-1951");
       ArrayList<Staduim> actualValue1950_1951Just0To5 = actualValue1950_1951;       
       ArrayList<Staduim> expectedValue1950_1951Just0To5 = new ArrayList<>();       
       Assert.assertEquals(expectedValue1950_1951Just0To5.toString(), actualValue1950_1951Just0To5.toString());   


   }
}