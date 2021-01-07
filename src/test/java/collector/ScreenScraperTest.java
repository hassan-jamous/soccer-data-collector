package collector;

import models.Club;
import models.ClubForRankingTable;
import models.ClubTransferTable;
import models.DirtyGame;
import models.Game;
import models.GamesTableOfLeague;
import models.Goal;
import models.GoalInMatchDetails;
import models.KindOfReferee;
import models.MatchDetails;
import models.MatchSummary;
import models.ClubInMatchDetails;
import models.PlayerAllInformation;
import models.PlayerAtMatch;
import models.PlayerClubCareer;
import models.PlayerCompetitionInformationOverall;
import models.PlayerCompetitionInformation;
import models.PlayerEventAtMatch;
import models.PlayerPersonalInformation;
import models.PlayerSummary;
import models.PlayerTeamManaged;
import models.PlayerTopSoccer;
import models.PlayerTypeAtMatch;
import models.RankingTable;
import models.RankingTableRequest;
import models.Referee;
import models.Staduim;
import models.StatisticsBestPlayerInYear;
import models.StatisticsGoalsPerRound;
import models.StatisticsGoalsPerSeason;
import models.StatisticsMostGoalsByPlayerPerGame;
import models.StatisticsRecordWinsAndMostGoalInGame;
import models.StatisticsRequestKind;
import models.TransferPlayerInformation;
import sofaScore.SofaScoreCollector;
import sofaScoreModels.GameStatistic;
import sofaScoreModels.ItemStatisticsInGroup;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ScreenScraperTest {

    public void assertGameInRound(GamesTableOfLeague gamesTableActualValue, List<Game> gamesExpectedValue, List<Integer> gamesIds, int roundNumber) {
        for (int i = 0; i < gamesExpectedValue.size(); i++) {
            assertThat(gamesExpectedValue.get(i)).usingRecursiveComparison().isEqualTo(gamesTableActualValue.rounds.get(roundNumber - 1).games.get(gamesIds.get(i)));
        }
    }

    @Test
    public void itShouldGetGamesTableOfLeague() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        GamesTableOfLeague gamesTableActualValue2015_2016 = screenScraperUnderTest.getAllRounds("eng-premier-league", "2015-2016");

        List<Game> gamesInRound4At2015_2016 = Arrays.asList(new Game("29/08/2015", "12:45", "Newcastle United", "Arsenal FC", "0:1 (0:0)"),
                new Game("29/08/2015", "15:00", "AFC Bournemouth", "Leicester City", "1:1 (1:0)"),
                new Game("30/08/2015", "13:30", "Southampton FC", "Norwich City", "3:0 (1:0)"));
        List<Integer> gamesIdsInRound4At2015_2016 = Arrays.asList(0, 1, 8);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound4At2015_2016, gamesIdsInRound4At2015_2016, 4);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(3).games.size());

        List<Game> gamesInRound9At2015_2016 = Arrays.asList(new Game("17/10/2015", "12:45", "Tottenham Hotspur", "Liverpool FC", "0:0 (0:0)"),
        		new Game("17/10/2015", "15:00", "Everton FC", "Manchester United", "0:3 (0:2)"),
        		new Game("18/10/2015", "16:00", "Newcastle United", "Norwich City", "6:2 (3:2)"),
        		new Game("19/10/2015", "20:00", "Swansea City", "Stoke City", "0:1 (0:1)"));
        List<Integer> gamesIdsInRound9At2015_2016 = Arrays.asList(0, 3, 8, 9);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound9At2015_2016, gamesIdsInRound9At2015_2016, 9);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(8).games.size());

        List<Game> gamesInRound14At2015_2016 = Arrays.asList(new Game("28/11/2015", "15:00", "Aston Villa", "Watford FC", "2:3 (1:1)"),
        		new Game("28/11/2015", "17:30", "Leicester City", "Manchester United", "1:1 (1:1)"),
        		new Game("29/11/2015", "14:05", "West Ham United", "West Bromwich Albion", "1:1 (1:0)"),
        		 new Game("29/11/2015", "16:15", "Liverpool FC", "Swansea City", "1:0 (0:0)"));
        List<Integer> gamesIdsInRound14At2015_2016 = Arrays.asList(1, 5, 7, 8);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound14At2015_2016, gamesIdsInRound14At2015_2016, 14);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(13).games.size());

        List<Game> gamesInRound21At2015_2016 = Arrays.asList(new Game("12/01/2016", "19:45", "AFC Bournemouth", "West Ham United", "1:3 (1:0)"),
        		new Game("12/01/2016", "19:45", "Newcastle United", "Manchester United", "3:3 (1:2)"),
        		new Game("13/01/2016", "20:00", "Tottenham Hotspur", "Leicester City", "0:1 (0:0)"));
        List<Integer> gamesIdsInRound21At2015_2016 = Arrays.asList(0, 2, 9);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound21At2015_2016, gamesIdsInRound21At2015_2016, 21);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(20).games.size());

        List<Game> gamesInRound27At2015_2016 = Arrays.asList(
        		new Game("28/02/2016", "14:05", "Manchester United", "Arsenal FC", "3:2 (2:1)"),
        		new Game("28/02/2016", "14:05", "Tottenham Hotspur", "Swansea City", "2:1 (0:1)"),
        		new Game("20/04/2016", "20:00", "Liverpool FC", "Everton FC", "4:0 (2:0)"));
        List<Integer> gamesIdsInRound27At2015_2016 = Arrays.asList(6, 7, 9);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound27At2015_2016, gamesIdsInRound27At2015_2016, 27);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(26).games.size());

        List<Game> gamesInRound35At2015_2016 = Arrays.asList(
        		new Game("13/04/2016", "20:00", "Crystal Palace", "Everton FC", "0:0 (0:0)"),
        		new Game("23/04/2016", "15:00", "Liverpool FC", "Newcastle United", "2:2 (2:0)"),
        		new Game("10/05/2016", "20:30", "West Ham United", "Manchester United", "3:2 (1:0)"));        		
        List<Integer> gamesIdsInRound35At2015_2016 = Arrays.asList(0, 4, 8);
        assertGameInRound(gamesTableActualValue2015_2016, gamesInRound35At2015_2016, gamesIdsInRound35At2015_2016, 35);
        Assert.assertEquals(10, gamesTableActualValue2015_2016.rounds.get(34).games.size());
        
        Assert.assertEquals(38, gamesTableActualValue2015_2016.rounds.size());


        GamesTableOfLeague gamesTableActualValue2005_2006 = screenScraperUnderTest.getAllRounds("eng-premier-league", "2005-2006");

        List<Game> gamesInRound2At2005_2006 = Arrays.asList(
        		new Game("20/08/2005", "12:45", "Manchester United", "Aston Villa", "1:0 (0:0)"),
        		new Game("20/08/2005", "15:00", "Blackburn Rovers", "Fulham FC", "2:1 (1:0)"),
        		new Game("20/08/2005", "15:15", "Liverpool FC", "Sunderland AFC", "1:0 (1:0)"),
        		new Game("21/08/2005", "13:30", "Bolton Wanderers", "Everton FC", "0:1 (0:0)"));
        List<Integer> gamesIdsInRound2At2005_2006 = Arrays.asList(0, 1, 6, 8);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound2At2005_2006, gamesIdsInRound2At2005_2006, 2);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(1).games.size());

        List<Game> gamesInRound12At2005_2006 = Arrays.asList(
        		new Game("05/11/2005", "15:00", "Blackburn Rovers", "Charlton Athletic", "4:1 (2:1)"),
        		new Game("05/11/2005", "17:15", "Portsmouth FC", "Wigan Athletic", "0:2 (0:0)"),
        		new Game("06/11/2005", "16:00", "Manchester United", "Chelsea FC", "1:0 (1:0)"));
        List<Integer> gamesIdsInRound12At2005_2006 = Arrays.asList(2, 6, 8);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound12At2005_2006, gamesIdsInRound12At2005_2006, 12);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(11).games.size());

        List<Game> gamesInRound20At2005_2006 = Arrays.asList(
        		new Game("31/12/2005", "12:45", "Aston Villa", "Arsenal FC", "0:0 (0:0)"),
        		new Game("31/12/2005", "13:00", "Tottenham Hotspur", "Newcastle United", "2:0 (1:0)"),
        		new Game("31/12/2005", "15:00", "Wigan Athletic", "Blackburn Rovers", "0:3 (0:1)"));
        List<Integer> gamesIdsInRound20At2005_2006 = Arrays.asList(0, 3, 9);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound20At2005_2006, gamesIdsInRound20At2005_2006, 20);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(19).games.size());

        List<Game> gamesInRound32At2005_2006 = Arrays.asList(
        		new Game("01/04/2006", "12:45", "Birmingham City", "Chelsea FC", "0:0 (0:0)"),
        		new Game("01/04/2006", "15:00", "Arsenal FC", "Aston Villa", "5:0 (2:0)"),
        		new Game("02/04/2006", "15:00", "Manchester City", "Middlesbrough FC", "0:1 (0:1)"),
        		new Game("03/04/2006", "20:00", "Blackburn Rovers", "Wigan Athletic", "1:1 (0:0)"));
        List<Integer> gamesIdsInRound32At2005_2006 = Arrays.asList(0, 1, 7, 9);
        assertGameInRound(gamesTableActualValue2005_2006, gamesInRound32At2005_2006, gamesIdsInRound32At2005_2006, 32);
        Assert.assertEquals(10, gamesTableActualValue2005_2006.rounds.get(31).games.size());

        Assert.assertEquals(38, gamesTableActualValue2005_2006.rounds.size());

        
        GamesTableOfLeague gamesTableActualValue1960_1961 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1960-1961");
       
        List<Game> gamesInRound1At1960_1961 = Arrays.asList(
        		new Game("20/08/1960", null, "Aston Villa", "Chelsea FC", "3:2 (0:0)"),
                new Game("20/08/1960", null, "Manchester United", "Blackburn Rovers", "1:3 (0:1)"),
                new Game("20/08/1960", null, "Burnley FC", "Arsenal FC", "3:2 (1:1)"),
                new Game("20/08/1960", null, "Wolverhampton Wanderers", "West Ham United", "4:2 (0:0)"));
        List<Integer> gamesIdsInRound1At1960_1961 = Arrays.asList(0, 5, 8, 10);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound1At1960_1961, gamesIdsInRound1At1960_1961, 1);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(0).games.size());

        List<Game> gamesInRound4At1960_1961 = Arrays.asList(
	        new Game("30/08/1960", null, "Burnley FC", "Manchester City", "1:3 (0:0)"),
	        new Game("30/08/1960", null, "Preston North End", "Arsenal FC", "2:0 (0:0)"),
	        new Game("31/08/1960", null, "Manchester United", "Everton FC", "4:0 (2:0)"),
	        new Game("31/08/1960", null, "Fulham FC", "Newcastle United", "4:3 (0:0)"));
        List<Integer> gamesIdsInRound4At1960_1961 = Arrays.asList(1, 2, 3, 9);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound4At1960_1961, gamesIdsInRound4At1960_1961, 4);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(3).games.size());

        List<Game> gamesInRound16At1960_1961 = Arrays.asList(
			new Game("04/11/1960", null, "Leicester City", "Preston North End", "5:2 (0:0)"),
			new Game("05/11/1960", null, "Chelsea FC", "Newcastle United", "4:2 (0:0)"),
			new Game("05/11/1960", null, "Blackburn Rovers", "Birmingham City", "2:0 (0:0)"),
			new Game("05/11/1960", null, "Aston Villa", "Burnley FC", "2:0 (0:0)"));
        List<Integer> gamesIdsInRound16At1960_1961 = Arrays.asList(0, 1, 9, 10);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound16At1960_1961, gamesIdsInRound16At1960_1961, 16);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(15).games.size());

        List<Game> gamesInRound27At1960_1961 = Arrays.asList(
	        new Game("21/01/1961", null, "West Ham United", "Chelsea FC", "3:1 (0:0)"),
	        new Game("21/01/1961", null, "Bolton Wanderers", "Blackpool FC", "3:1 (0:0)"),
	        new Game("21/01/1961", null, "Leicester City", "Manchester United", "6:0 (2:0)"),
	        new Game("21/01/1961", null, "Tottenham Hotspur", "Arsenal FC", "4:2 (3:1)"));
        List<Integer> gamesIdsInRound27At1960_1961 = Arrays.asList(2, 5, 8, 10);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound27At1960_1961, gamesIdsInRound27At1960_1961, 27);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(26).games.size());

        List<Game> gamesInRound36At1960_1961 = Arrays.asList(
        		new Game("28/01/1961", null, "Wolverhampton Wanderers", "West Bromwich Albion", "4:2 (0:0)"),
        		new Game("31/03/1961", null, "Burnley FC", "Nottingham Forest", "4:1 (0:0)"),
        		new Game("31/03/1961", null, "Blackpool FC", "Manchester United", "2:0 (1:0)"),
        		new Game("31/03/1961", null, "Fulham FC", "Arsenal FC", "2:2 (0:1)"));
        List<Integer> gamesIdsInRound36At1960_1961 = Arrays.asList(0, 1, 7, 9);
        assertGameInRound(gamesTableActualValue1960_1961, gamesInRound36At1960_1961, gamesIdsInRound36At1960_1961, 36);
        Assert.assertEquals(11, gamesTableActualValue1960_1961.rounds.get(35).games.size());

        Assert.assertEquals(42, gamesTableActualValue1960_1961.rounds.size());


        GamesTableOfLeague gamesTableActualValue1925_1926 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1925-1926");

        List<Game> gamesInRound3At1925_1926 = Arrays.asList(
        		new Game("05/09/1925", null, "West Bromwich Albion", "Sunderland AFC", "2:5"),
        		new Game("05/09/1925", null, "Newcastle United", "Notts County", "6:3"),
        		new Game("08/09/1925", null, "Huddersfield Town", "Bury FC", "2:1"));
        List<Integer> gamesIdsInRound3At1925_1926 = Arrays.asList(1, 3, 10);
        assertGameInRound(gamesTableActualValue1925_1926, gamesInRound3At1925_1926, gamesIdsInRound3At1925_1926, 3);
        Assert.assertEquals(11, gamesTableActualValue1925_1926.rounds.get(2).games.size());

        List<Game> gamesInRound35At1925_1926 = Arrays.asList(
        		new Game("13/03/1926", null, "Birmingham FC", "Newcastle United", "1:1"),
        		new Game("13/03/1926", null, "Tottenham Hotspur", "Leicester City", "1:3"),
        		new Game("02/04/1926", null, "Aston Villa", "Arsenal FC", "3:0"));
        List<Integer> gamesIdsInRound35At1925_1926 = Arrays.asList(0, 1, 5);
        assertGameInRound(gamesTableActualValue1925_1926, gamesInRound35At1925_1926, gamesIdsInRound35At1925_1926, 35);
        Assert.assertEquals(8, gamesTableActualValue1925_1926.rounds.get(34).games.size());

        List<Game> gamesInRound36At1925_1926 = Arrays.asList(
        		new Game("20/03/1926", null, "Leeds United", "Blackburn Rovers", "2:1"),
        		new Game("20/03/1926", null, "Manchester United", "Everton FC", "0:0"),
        		new Game("03/04/1926", null, "Arsenal FC", "Blackburn Rovers", "4:2"),
        		new Game("03/04/1926", null, "Newcastle United", "Cardiff City", "0:1"));
        List<Integer> gamesIdsInRound36At1925_1926 = Arrays.asList(0, 2, 7, 11);
        assertGameInRound(gamesTableActualValue1925_1926, gamesInRound36At1925_1926, gamesIdsInRound36At1925_1926, 36);
        Assert.assertEquals(13, gamesTableActualValue1925_1926.rounds.get(35).games.size());

        Assert.assertEquals(42, gamesTableActualValue1925_1926.rounds.size());


        GamesTableOfLeague gamesTableActualValue1891_1892 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1891-1892");
        List<Game> gamesInRound1At1891_1892 = Arrays.asList(
        		new Game("05/09/1891", null, "Aston Villa", "Blackburn Rovers", "5:1"),
        		new Game("05/09/1891", null, "Stoke City", "Derby County", "2:1"),
        		new Game("05/09/1891", null, "West Bromwich Albion", "Everton FC", "4:0"));
        List<Integer> gamesIdsInRound36At1891_1892 = Arrays.asList(1, 4, 6);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound1At1891_1892, gamesIdsInRound36At1891_1892, 1);
        Assert.assertEquals(7, gamesTableActualValue1891_1892.rounds.get(0).games.size());

        List<Game> gamesInRound6At1891_1892 = Arrays.asList(
        		new Game("03/10/1891", null, "Darwen", "Stoke City", "9:3"),
        		new Game("10/10/1891", null, "Aston Villa", "Bolton Wanderers", "1:2"),
        		new Game("10/10/1891", null, "Notts County", "West Bromwich Albion", "4:0"),
        		new Game("17/10/1891", null, "West Bromwich Albion", "Sunderland AFC", "2:5"));
        List<Integer> gamesIdsInRound6At1891_1892 = Arrays.asList(1, 2, 5, 7);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound6At1891_1892, gamesIdsInRound6At1891_1892, 6);
        Assert.assertEquals(8, gamesTableActualValue1891_1892.rounds.get(5).games.size());

        List<Game> gamesInRound14At1891_1892 = Arrays.asList(
        		new Game("28/11/1891", null, "Wolverhampton Wanderers", "Blackburn Rovers", "6:1"),
        		new Game("05/12/1891", null, "Aston Villa", "Burnley FC", "6:1"),
        		new Game("05/12/1891", null, "Sunderland AFC", "Notts County", "4:0"),
        		new Game("12/12/1891", null, "Burnley FC", "Blackburn Rovers", "3:0"));
        List<Integer> gamesIdsInRound14At1891_1892 = Arrays.asList(0, 1, 4, 6);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound14At1891_1892, gamesIdsInRound14At1891_1892, 14);
        Assert.assertEquals(7, gamesTableActualValue1891_1892.rounds.get(13).games.size());

        List<Game> gamesInRound23At1891_1892 = Arrays.asList(
        		new Game("26/03/1892", null, "Sunderland AFC", "Aston Villa", "2:1"),
        		new Game("02/04/1892", null, "Wolverhampton Wanderers", "Preston North End", "3:0"),
        		new Game("04/04/1892", null, "West Bromwich Albion", "Darwen", "12:0"));
        List<Integer> gamesIdsInRound23At1891_1892 = Arrays.asList(3, 4, 5);
        assertGameInRound(gamesTableActualValue1891_1892, gamesInRound23At1891_1892, gamesIdsInRound23At1891_1892, 23);
        Assert.assertEquals(6, gamesTableActualValue1891_1892.rounds.get(22).games.size());

        Assert.assertEquals(26, gamesTableActualValue1891_1892.rounds.size());

        //this season starts with round 0, 
        GamesTableOfLeague gamesTableActualValue1888_1889 = screenScraperUnderTest.getAllRounds("eng-premier-league", "1888-1889");
        
        List<Game> gamesInRound2At1888_1889 = Arrays.asList(
        		new Game("15/09/1888", null, "Aston Villa", "Stoke City", "5:1"),
        		new Game("15/09/1888", null, "Bolton Wanderers", "Burnley FC", "3:4"),
        		new Game("15/09/1888", null, "Derby County", "West Bromwich Albion", "1:2"),
        		new Game("15/09/1888", null, "Everton FC", "Notts County", "2:1"),
        		new Game("15/09/1888", null, "Wolverhampton Wanderers", "Preston North End", "0:4"),
        		new Game("15/09/1888", null, "Blackburn Rovers", "Accrington FC", "5:5"));
        List<Integer> gamesIdsInRound2At1888_1889 = Arrays.asList(0 ,1 ,2 ,3 , 4, 5);
        assertGameInRound(gamesTableActualValue1888_1889, gamesInRound2At1888_1889, gamesIdsInRound2At1888_1889, 2+1);//this season starts with round 0
        Assert.assertEquals(6, gamesTableActualValue1888_1889.rounds.get(2).games.size());//this season starts with round 0

        Assert.assertEquals(23, gamesTableActualValue1888_1889.rounds.size());


    }
    public void assertRankingTable(RankingTable rankingTableActualValue, List<ClubForRankingTable> clubsExpectedValue, List<Integer> clubsIds) {
        for (int i = 0; i < clubsExpectedValue.size(); i++) {
            assertThat(clubsExpectedValue.get(i)).usingRecursiveComparison().isEqualTo(rankingTableActualValue.table.get(clubsIds.get(i)));
        }
    }

    @Test
    public void itShouldGetLastRankingTableOfLeague() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        
        RankingTable rankingTable1889_1890ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "1889-1890");
        List<ClubForRankingTable> rankingTable1889_1890Expected = Arrays.asList(
        		new ClubForRankingTable("1", "Preston North End", "22", "15", "3", "4", "71:30", "41", "33:11"),
        		new ClubForRankingTable("2", "Everton FC", "22", "14", "3", "5", "65:40", "25", "31:13"),
        		new ClubForRankingTable("3", "Blackburn Rovers", "22", "12", "3", "7", "78:41", "37", "27:17"),
        		new ClubForRankingTable("4", "Wolverhampton Wanderers", "22", "10", "5", "7", "51:38", "13", "25:19"),
        		new ClubForRankingTable("5", "West Bromwich Albion", "22", "11", "3", "8", "47:50", "-3", "25:19"),
        		new ClubForRankingTable("6", "Accrington FC", "22", "9", "6", "7", "53:56", "-3", "24:20"),
        		new ClubForRankingTable("7", "Derby County", "22", "9", "3", "10", "43:55", "-12", "21:23"),
        		new ClubForRankingTable("8", "Aston Villa", "22", "7", "5", "10", "43:51", "-8", "19:25"),
        		new ClubForRankingTable("9", "Bolton Wanderers", "22", "9", "1", "12", "54:65", "-11", "19:25"),
        		new ClubForRankingTable("10", "Notts County", "22", "6", "5", "11", "43:51", "-8", "17:27"),
        		new ClubForRankingTable("11", "Burnley FC", "22", "4", "5", "13", "36:65", "-29", "13:31"),
        		new ClubForRankingTable("12", "Stoke City", "22", "3", "4", "15", "27:69", "-42", "10:34"));
        List<Integer> clubsIdInRankingTable1889_1890 = Arrays.asList(0 ,1 ,2 ,3 , 4, 5, 6, 7, 8, 9, 10, 11);
        assertRankingTable(rankingTable1889_1890ActualValue ,rankingTable1889_1890Expected , clubsIdInRankingTable1889_1890);

        RankingTable rankingTable1906_1907ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "1906-1907");
        List<Integer> clubsIdInRankingTable1906_1907 = Arrays.asList(0 ,1 ,2 , 7, 11, 17);
        List<ClubForRankingTable> rankingTable1906_1907Expected = Arrays.asList(
        		new ClubForRankingTable("1", "Newcastle United", "38", "22", "7", "9", "74:46", "28", "51:25"),
        		new ClubForRankingTable("2", "Bristol City", "38", "20", "8", "10", "66:47", "19", "48:28"),
        		new ClubForRankingTable("3", "Everton FC", "38", "20", "5", "13", "70:46", "24", "45:31"),
        		new ClubForRankingTable("8", "Manchester United", "38", "17", "8", "13", "53:56", "-3", "42:34"),
        		new ClubForRankingTable("12", "Blackburn Rovers", "38", "14", "7", "17", "56:59", "-3", "35:41"),
        		new ClubForRankingTable("18", "Notts County", "38", "8", "15", "15", "46:50", "-4", "31:45"));
        assertRankingTable(rankingTable1906_1907ActualValue ,rankingTable1906_1907Expected ,  clubsIdInRankingTable1906_1907);
        Assert.assertEquals(20, rankingTable1906_1907ActualValue.table.size());

        RankingTable rankingTable1959_1960ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "1959-1960");
        List<Integer> clubsIdInRankingTable1959_1960 = Arrays.asList(1 , 6, 20);
        List<ClubForRankingTable> rankingTable1960_1970Expected = Arrays.asList(
        		new ClubForRankingTable("2", "Wolverhampton Wanderers", "42", "24", "6", "12", "106:67", "39", "54:30"),
        		new ClubForRankingTable("7", "Manchester United", "42", "19", "7", "16", "102:80", "22", "45:39"),
        		new ClubForRankingTable("21", "Leeds United", "42", "12", "10", "20", "65:92", "-27", "34:50"));
        assertRankingTable(rankingTable1959_1960ActualValue ,rankingTable1960_1970Expected ,  clubsIdInRankingTable1959_1960);
        Assert.assertEquals(22, rankingTable1959_1960ActualValue.table.size());

        RankingTable rankingTable2007_2008ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "2007-2008");
        List<Integer> clubsIdInRankingTable2007_2008 = Arrays.asList(0 , 3, 11);
        List<ClubForRankingTable> rankingTable2007_2008Expected = Arrays.asList(
        		new ClubForRankingTable("1", "Manchester United", "38", "27", "6", "5", "80:22", "58", "87"),
        		new ClubForRankingTable("4", "Liverpool FC", "38", "21", "13", "4", "67:28", "39", "76"),
        		new ClubForRankingTable("12", "Newcastle United", "38", "11", "10", "17", "45:65", "-20", "43"));
        assertRankingTable(rankingTable2007_2008ActualValue  ,  rankingTable2007_2008Expected , clubsIdInRankingTable2007_2008);
        Assert.assertEquals(20, rankingTable2007_2008ActualValue.table.size());

        RankingTable rankingTable2017_2018ActualValue = screenScraperUnderTest.getLastTable("eng-premier-league", "2017-2018");
        List<Integer> clubsIdInRankingTable2017_2018 = Arrays.asList(1 , 5, 18);
        List<ClubForRankingTable> rankingTable2017_2018Expected = Arrays.asList(
        		new ClubForRankingTable("2", "Manchester United", "38", "25", "6", "7", "68:28", "40", "81"),
        		new ClubForRankingTable("6", "Arsenal FC", "38", "19", "6", "13", "74:51", "23", "63"),
        		new ClubForRankingTable("19", "Stoke City", "38", "7", "12", "19", "35:68", "-33", "33"));
        assertRankingTable(rankingTable2017_2018ActualValue  ,  rankingTable2017_2018Expected , clubsIdInRankingTable2017_2018);
        Assert.assertEquals(20, rankingTable2017_2018ActualValue.table.size());


    }

    @Test
    public void itShouldGetRankingTableByRound() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        RankingTable rankingTable2012_2013ByRound14NormalActualValue = screenScraperUnderTest.getTableByRound("eng-premier-league", "2012-2013", "14", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable2012_2013Round14Normal = Arrays.asList(0, 1 , 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
        List<ClubForRankingTable> rankingTable2012_2013Expected = Arrays.asList(
        		new ClubForRankingTable("1", "Manchester United", "14", "11", "0", "3", "33:18", "15", "33"),
        		new ClubForRankingTable("2", "Manchester City", "14", "9", "5", "0", "27:10", "17", "32"),
        		new ClubForRankingTable("3", "Chelsea FC", "14", "7", "5", "2", "24:13", "11", "26"),
        		new ClubForRankingTable("4", "West Bromwich Albion", "14", "8", "2", "4", "24:18", "6", "26"),
        		new ClubForRankingTable("5", "Tottenham Hotspur", "14", "7", "2", "5", "25:23", "2", "23"),
        		new ClubForRankingTable("6", "Everton FC", "14", "5", "7", "2", "24:18", "6", "22"),
        		new ClubForRankingTable("7", "Arsenal FC", "14", "5", "6", "3", "24:14", "10", "21"),
        		new ClubForRankingTable("8", "Swansea City", "14", "5", "5", "4", "21:17", "4", "20"),
        		new ClubForRankingTable("9", "Stoke City", "14", "4", "7", "3", "13:12", "1", "19"),
        		new ClubForRankingTable("10", "West Ham United", "14", "5", "4", "5", "16:16", "0", "19"),
        		new ClubForRankingTable("11", "Fulham FC", "14", "4", "5", "5", "25:23", "2", "17"),
        		new ClubForRankingTable("12", "Liverpool FC", "14", "3", "7", "4", "18:18", "0", "16"),
        		new ClubForRankingTable("13", "Sunderland AFC", "14", "3", "7", "4", "15:16", "-1", "16"),
        		new ClubForRankingTable("14", "Norwich City", "14", "3", "7", "4", "11:20", "-9", "16"),
        		new ClubForRankingTable("15", "Newcastle United", "14", "3", "5", "6", "14:21", "-7", "14"),
        		new ClubForRankingTable("16", "Wigan Athletic", "14", "4", "2", "8", "15:25", "-10", "14"),
        		new ClubForRankingTable("17", "Aston Villa", "14", "3", "4", "7", "11:22", "-11", "13"),
        		new ClubForRankingTable("18", "Southampton FC", "14", "3", "3", "8", "21:31", "-10", "12"),
        		new ClubForRankingTable("19", "Reading FC", "14", "1", "6", "7", "16:26", "-10", "9"),
        		new ClubForRankingTable("20", "Queens Park Rangers", "14", "0", "5", "9", "10:26", "-16", "5"));
        assertRankingTable(rankingTable2012_2013ByRound14NormalActualValue , rankingTable2012_2013Expected ,  clubsIdInRankingTable2012_2013Round14Normal  );


        RankingTable rankingTable2018_2019Round21AwayActualValue = screenScraperUnderTest.getTableByRound("eng-premier-league", "2018-2019", "21", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable2018_2019Round21Away = Arrays.asList(0, 1 , 17);
        List<ClubForRankingTable> rankingTable2018_2019Round21AwayExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Tottenham Hotspur", "12", "10", "0", "2", "28:12", "16", "30"),
        		new ClubForRankingTable("2", "Liverpool FC", "11", "8", "2", "1", "22:7", "15", "26"),
        		new ClubForRankingTable("18", "Cardiff City", "10", "1", "2", "7", "6:18", "-12", "5"));
        assertRankingTable(rankingTable2018_2019Round21AwayActualValue , rankingTable2018_2019Round21AwayExpected ,  clubsIdInRankingTable2018_2019Round21Away  );
        Assert.assertEquals(20, rankingTable2018_2019Round21AwayActualValue.table.size());

        RankingTable rankingTableActualValue2013_2014ByRound27Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "2013-2014", "27", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable2013_2014Round27Home = Arrays.asList(0, 5);
        List<ClubForRankingTable> rankingTable2013_2014Round21HomeExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Chelsea FC", "14", "12", "2", "0", "29:9", "20", "38"),
        		new ClubForRankingTable("6", "Manchester United", "13", "6", "3", "4", "18:12", "6", "21"));
        assertRankingTable(rankingTableActualValue2013_2014ByRound27Home , rankingTable2013_2014Round21HomeExpected ,  clubsIdInRankingTable2013_2014Round27Home  );
        Assert.assertEquals(20, rankingTableActualValue2013_2014ByRound27Home.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable2000_2001Round11Normal = Arrays.asList(0, 4, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11NormalExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Manchester United", "11", "7", "3", "1", "31:8", "23", "24"),
        		new ClubForRankingTable("5", "Ipswich Town", "11", "5", "3", "3", "16:12", "4", "18"),
        		new ClubForRankingTable("14", "Everton FC", "11", "3", "3", "5", "14:19", "-5", "12"));
        assertRankingTable(rankingTableActualValue2000_2001ByRound11Normal , rankingTable2000_2001Round11NormalExpected ,  clubsIdInRankingTable2000_2001Round11Normal  );
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Normal.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable2000_2001Round11Away = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11AwayExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Ipswich Town", "5", "3", "0", "2", "9:6", "3", "9"),
        		new ClubForRankingTable("4", "Manchester United", "5", "2", "2", "1", "9:5", "4", "8"),
        		new ClubForRankingTable("14", "Aston Villa", "5", "1", "2", "2", "4:6", "-2", "5"));
        assertRankingTable(rankingTableActualValue2000_2001ByRound11Away , rankingTable2000_2001Round11AwayExpected ,  clubsIdInRankingTable2000_2001Round11Away  );
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Away.table.size());

        RankingTable rankingTableActualValue2000_2001ByRound11Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "2000-2001", "11", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable2000_2001ByRound11Home = Arrays.asList(0, 1, 13);
        List<ClubForRankingTable> rankingTable2000_2001Round11HomeExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Arsenal FC", "6", "6", "0", "0", "16:4", "12", "18"),
        		new ClubForRankingTable("2", "Manchester United", "6", "5", "1", "0", "22:3", "19", "16"),
        		new ClubForRankingTable("14", "West Ham United", "6", "1", "3", "2", "6:7", "-1", "6"));
        assertRankingTable(rankingTableActualValue2000_2001ByRound11Home , rankingTable2000_2001Round11HomeExpected ,  clubsIdInRankingTable2000_2001ByRound11Home  );
        Assert.assertEquals(20, rankingTableActualValue2000_2001ByRound11Home.table.size());

        RankingTable rankingTableActualValue1955_1956ByRound20Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1955-1956", "20", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1955_1956ByRound20Normal = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1955_1956Round20AwayExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Manchester United", "20", "10", "6", "4", "38:28", "10", "26:14"),
        		new ClubForRankingTable("4", "Charlton Athletic", "20", "10", "4", "6", "46:38", "8", "24:16"),
        		new ClubForRankingTable("14", "Newcastle United", "20", "9", "2", "9", "43:37", "6", "20:20"));
        assertRankingTable(rankingTableActualValue1955_1956ByRound20Normal , rankingTable1955_1956Round20AwayExpected ,  clubsIdInRankingTable1955_1956ByRound20Normal  );
        Assert.assertEquals(22, rankingTableActualValue1955_1956ByRound20Normal.table.size());

        RankingTable rankingTableActualValue1977_1978ByRound37Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1977-1978", "37", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1977_1978ByRound37Away = Arrays.asList(0, 3, 10);
        List<ClubForRankingTable> rankingTable1977_1978Round37AwayExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Nottingham Forest", "18", "9", "6", "3", "28:14", "14", "24:12"),
        		new ClubForRankingTable("4", "Arsenal FC", "18", "6", "5", "7", "19:20", "-1", "17:19"),
        		new ClubForRankingTable("11", "Manchester United", "18", "5", "4", "9", "30:37", "-7", "14:22"));
        assertRankingTable(rankingTableActualValue1977_1978ByRound37Away , rankingTable1977_1978Round37AwayExpected ,  clubsIdInRankingTable1977_1978ByRound37Away  );
        Assert.assertEquals(22, rankingTableActualValue1977_1978ByRound37Away.table.size());

        RankingTable rankingTableActualValue1985_1986ByRound26Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1985-1986", "26", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1985_1986ByRound26Home = Arrays.asList(0, 1, 13);
        List<ClubForRankingTable> rankingTable1985_1986ByRound26HomeExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Liverpool FC", "14", "11", "3", "0", "38:9", "29", "36"),
        		new ClubForRankingTable("2", "Manchester United", "14", "9", "4", "1", "23:5", "18", "31"),
        		new ClubForRankingTable("14", "Newcastle United", "13", "6", "3", "4", "24:21", "3", "21"));
        assertRankingTable(rankingTableActualValue1985_1986ByRound26Home , rankingTable1985_1986ByRound26HomeExpected ,  clubsIdInRankingTable1985_1986ByRound26Home  );
        Assert.assertEquals(22, rankingTableActualValue1985_1986ByRound26Home.table.size());

        RankingTable rankingTableActualValue1948_1949ByRound27Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1948-1949", "27", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1948_1949ByRound27Normal = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1948_1949ByRound27HomeExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Portsmouth FC", "27", "15", "8", "4", "48:23", "25", "38:16"),
        		new ClubForRankingTable("4", "Manchester United", "27", "12", "9", "6", "52:28", "24", "33:21"),
        		new ClubForRankingTable("14", "Burnley FC", "27", "9", "7", "11", "32:37", "-5", "25:29"));
        assertRankingTable(rankingTableActualValue1948_1949ByRound27Normal , rankingTable1948_1949ByRound27HomeExpected ,  clubsIdInRankingTable1948_1949ByRound27Normal  );
        Assert.assertEquals(22, rankingTableActualValue1948_1949ByRound27Normal.table.size());

        RankingTable rankingTableActualValue1930_1931ByRound8Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1930-1931", "8", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1930_1931ByRound8Away = Arrays.asList(0, 21);
        List<ClubForRankingTable> rankingTable1930_1931ByRound8HomeExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Arsenal FC", "5", "4", "1", "0", "18:7", "11", "9:1"),
        		new ClubForRankingTable("22", "Manchester United", "4", "0", "0", "4", "3:15", "-12", "0:8"));
        assertRankingTable(rankingTableActualValue1930_1931ByRound8Away , rankingTable1930_1931ByRound8HomeExpected ,  clubsIdInRankingTable1930_1931ByRound8Away  );
        Assert.assertEquals(22, rankingTableActualValue1930_1931ByRound8Away.table.size());

        RankingTable rankingTableActualValue1925_1926ByRound12Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1925-1926", "12", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1925_1926ByRound12Home = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1925_1926ByRound12HomeExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Sunderland AFC", "6", "6", "0", "0", "26:7", "19", "12:0"),
        		new ClubForRankingTable("4", "Manchester United", "7", "4", "2", "1", "15:6", "9", "10:4"),
        		new ClubForRankingTable("14", "Burnley FC", "6", "2", "3", "1", "10:7", "3", "7:5"));
        assertRankingTable(rankingTableActualValue1925_1926ByRound12Home , rankingTable1925_1926ByRound12HomeExpected ,  clubsIdInRankingTable1925_1926ByRound12Home  );
        Assert.assertEquals(22, rankingTableActualValue1925_1926ByRound12Home.table.size());

        RankingTable rankingTableActualValue1898_1899ByRound18Normal = screenScraperUnderTest.getTableByRound("eng-premier-league", "1898-1899", "18", RankingTableRequest.Normal);
        List<Integer> clubsIdInRankingTable1898_1899ByRound18Normal = Arrays.asList(0, 5, 15);
        List<ClubForRankingTable> rankingTable1898_1899ByRound18NormalExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Aston Villa", "17", "12", "3", "2", "40:14", "26", "27:7"),
        		new ClubForRankingTable("6", "Sheffield United", "18", "5", "10", "3", "24:24", "0", "20:16"),
        		new ClubForRankingTable("16", "The Wednesday FC", "16", "5", "4", "7", "18:27", "-9", "14:18"));
        assertRankingTable(rankingTableActualValue1898_1899ByRound18Normal , rankingTable1898_1899ByRound18NormalExpected ,  clubsIdInRankingTable1898_1899ByRound18Normal  );
        Assert.assertEquals(18, rankingTableActualValue1898_1899ByRound18Normal.table.size());

        RankingTable rankingTableActualValue1888_1889ByRound10Away = screenScraperUnderTest.getTableByRound("eng-premier-league", "1888-1889", "10", RankingTableRequest.Away);
        List<Integer> clubsIdInRankingTable1888_1889ByRound10Away = Arrays.asList(0, 4, 10);
        List<ClubForRankingTable> rankingTable1888_1889ByRound10AwayExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Preston North End", "6", "5", "1", "0", "22:2", "20", "11:1"),
        		new ClubForRankingTable("5", "Blackburn Rovers", "5", "1", "2", "2", "14:14", "0", "4:6"),
        		new ClubForRankingTable("11", "Notts County", "4", "0", "0", "4", "4:18", "-14", "0:8"));
        assertRankingTable(rankingTableActualValue1888_1889ByRound10Away , rankingTable1888_1889ByRound10AwayExpected ,  clubsIdInRankingTable1888_1889ByRound10Away  );
        Assert.assertEquals(12, rankingTableActualValue1888_1889ByRound10Away.table.size());

        RankingTable rankingTableActualValue1891_1892ByRound18Home = screenScraperUnderTest.getTableByRound("eng-premier-league", "1891-1892", "18", RankingTableRequest.Home);
        List<Integer> clubsIdInRankingTable1891_1892ByRound18Home = Arrays.asList(0, 3, 13);
        List<ClubForRankingTable> rankingTable1891_1892ByRound12HomeExpected = Arrays.asList(
        		new ClubForRankingTable("1", "Sunderland AFC", "9", "9", "0", "0", "39:7", "32", "18:0"),
        		new ClubForRankingTable("4", "Wolverhampton Wanderers", "11", "7", "2", "2", "30:13", "17", "16:6"),
        		new ClubForRankingTable("14", "Stoke City", "10", "4", "0", "6", "17:15", "2", "8:12"));
        assertRankingTable(rankingTableActualValue1891_1892ByRound18Home , rankingTable1891_1892ByRound12HomeExpected ,  clubsIdInRankingTable1891_1892ByRound18Home  );
        Assert.assertEquals(14, rankingTableActualValue1891_1892ByRound18Home.table.size());

    }
    
    public void assertGameGoal(ArrayList<Goal> goalsActualValue, List<Goal> goalsExpectedValue) {
        for (int i = 0; i < goalsExpectedValue.size(); i++) {
            assertThat(goalsExpectedValue.get(i)).usingRecursiveComparison().isEqualTo(goalsActualValue.get(i));
        }
    }

    @Test
    public void itShouldGetGameGoals() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<Goal> goals2020_2021BrightonHoveAlbionVsBurnleyFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2020-2021", "brighton-hove-albion", "burnley-fc");
        Assert.assertEquals(null, goals2020_2021BrightonHoveAlbionVsBurnleyFcActualValue);

        ArrayList<Goal> goals2017_2018LiverpoolFcBrightonHoveAlbionActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2017-2018", "liverpool-fc", "brighton-hove-albion");
        List<Goal> goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue = Arrays.asList(
        		new Goal("1 : 0", "26", "Mohamed Salah", "left-footed shot"),
        		new Goal("2 : 0", "40", "Dejan Lovren", "header", "Andrew Robertson"),
        		new Goal("3 : 0", "53", "Dominic Solanke", "right-footed shot", "Mohamed Salah"),
        		new Goal("4 : 0", "85", "Andrew Robertson", "left-footed shot"));       
        assertGameGoal(goals2017_2018LiverpoolFcBrightonHoveAlbionActualValue,goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue);
       
        ArrayList<Goal> goals2015_2016ArsenalFcAstonVillaActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2015-2016", "arsenal-fc", "aston-villa");
        List<Goal> goals2015_2016ArsenalFcAstonVillaExpectedValue = Arrays.asList(
        		new Goal("1 : 0", "5", "Olivier Giroud", "header", "Nacho Monreal"),
        		new Goal("2 : 0", "78", "Olivier Giroud", "left-footed shot", "Mesut Özil"),
        		new Goal("3 : 0", "80", "Olivier Giroud", "left-footed shot", "Héctor Bellerín"),
        		new Goal("4 : 0", "90", "Mark Bunn", "own goal"));
        assertGameGoal(goals2015_2016ArsenalFcAstonVillaActualValue,goals2015_2016ArsenalFcAstonVillaExpectedValue);

        ArrayList<Goal> goals2015_2016SunderlandAfcChelseaFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2015-2016", "sunderland-afc", "chelsea-fc");
        List<Goal> goals2015_2016SunderlandAfcChelseaFcExpectedValue = Arrays.asList(
        		new Goal("0 : 1", "14", "Diego Costa", "right-footed shot"),
        		new Goal("1 : 1", "41", "Wahbi Khazri", "right-footed shot"),
        		new Goal("1 : 2", "45", "Nemanja Matić", "left-footed shot", "Azpilicueta"),
        		new Goal("2 : 2", "67", "Fabio Borini", "right-footed shot", "Patrick van Aanholt"),
        		new Goal("3 : 2", "70", "Jermain Defoe", "right-footed shot"));
        assertGameGoal(goals2015_2016SunderlandAfcChelseaFcActualValue,goals2015_2016SunderlandAfcChelseaFcExpectedValue);
 
        ArrayList<Goal> goals2000_2001BradfordCityLeicesterCityActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2000-2001", "bradford-city", "leicester-city");
        Assert.assertEquals(null, goals2000_2001BradfordCityLeicesterCityActualValue);

        ArrayList<Goal> goals2000_2001LeedsUnitedEvertonFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "2000-2001", "leeds-united", "everton-fc");
        List<Goal> goals2000_2001LeedsUnitedEvertonFcExpectedValue = Arrays.asList(
        		new Goal("1 : 0", "16", "Alan Smith"),
        		new Goal("2 : 0", "37", "Alan Smith"));
        assertGameGoal(goals2000_2001LeedsUnitedEvertonFcActualValue, goals2000_2001LeedsUnitedEvertonFcExpectedValue);
 
        ArrayList<Goal> goals1998_1999ArsenalFcAstonVillaActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1998-1999", "arsenal-fc", "aston-villa");
        List<Goal> goals1998_1999ArsenalFcAstonVillaExpected = Arrays.asList(
        		new Goal("1 : 0", "66", "Nwankwo Kanu"));
        assertGameGoal(goals1998_1999ArsenalFcAstonVillaActualValue ,goals1998_1999ArsenalFcAstonVillaExpected);

        ArrayList<Goal> goals1996_1997ManchesterUnitedWestHamUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1996-1997", "manchester-united", "west-ham-united");
        List<Goal> goals1996_1997ManchesterUnitedWestHamUnitedExpected = Arrays.asList(
        		new Goal("1 : 0", "11", "Ole Gunnar Solskjær"),
        		new Goal("2 : 0", "84", "Jordi Cruyff"));
        assertGameGoal(goals1996_1997ManchesterUnitedWestHamUnitedActualValue , goals1996_1997ManchesterUnitedWestHamUnitedExpected );

        ArrayList<Goal> goals1992_1993LiverpoolFcNottinghamForestActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1992-1993", "liverpool-fc", "nottingham-forest");
        Assert.assertEquals(null, goals1992_1993LiverpoolFcNottinghamForestActualValue);

        ArrayList<Goal> goals1992_1993ChelseaFcSheffieldUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1992-1993", "chelsea-fc", "sheffield-united");
        List<Goal> goals1992_1993ChelseaFcSheffieldUnitedExpected = Arrays.asList(
        		new Goal("0 : 1", "40", "Adrian Littlejohn"),
        		new Goal("1 : 1", "41", "Andy Townsend"),
        		new Goal("1 : 2", "57", "Brian Deane"));
        assertGameGoal(goals1992_1993ChelseaFcSheffieldUnitedActualValue , goals1992_1993ChelseaFcSheffieldUnitedExpected );

        ArrayList<Goal> goals1983_1984TottenhamHotspurManchesterUnitedActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1983-1984", "tottenham-hotspur", "manchester-united");
        List<Goal> goals1983_1984TottenhamHotspurManchesterUnitedExpected = Arrays.asList(
        		new Goal("1 : 0", "90", "Steve Archibald"),
        		new Goal("1 : 1", "90", "Norman Whiteside"));
        assertGameGoal(goals1983_1984TottenhamHotspurManchesterUnitedActualValue , goals1983_1984TottenhamHotspurManchesterUnitedExpected );

        ArrayList<Goal> goals1976_1977LeedsUnitedCoventryCityActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1976-1977", "leeds-united", "coventry-city");
        List<Goal> goals1976_1977LeedsUnitedCoventryCityExpected = Arrays.asList(
        		new Goal("0 : 1", "45", "Alan Green"),
        		new Goal("1 : 1", "45", "Joe Jordan"),
        		new Goal("1 : 2", "90", "Donal Murphy"));
        assertGameGoal(goals1976_1977LeedsUnitedCoventryCityActualValue , goals1976_1977LeedsUnitedCoventryCityExpected );

        ArrayList<Goal> goals1963_1964SheffieldUnitedBurnleyFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1963-1964", "sheffield-united", "burnley-fc");
        List<Goal> goals1963_1964SheffieldUnitedBurnleyFcExpected = Arrays.asList(
        		new Goal("1 : 0", "90", "Tony Wagstaff"),
        		new Goal("2 : 0", "90", "Mick Jones"));
        assertGameGoal(goals1963_1964SheffieldUnitedBurnleyFcActualValue , goals1963_1964SheffieldUnitedBurnleyFcExpected );

        ArrayList<Goal> goals1956_1957SheffieldWednesdayChelseaFcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "sheffield-wednesday", "chelsea-fc");
        List<Goal> goals1956_1957SheffieldWednesdayChelseaFcExpectedValue = Arrays.asList(
        		new Goal("1 : 0", "0","Roy Shiner" ),
        		new Goal("2 : 0", "0","Roy Shiner"),
        		new Goal("3 : 0", "0","Albert Quixall"),
        		new Goal("4 : 0", "0","Albert Quixall"));
        assertGameGoal(goals1956_1957SheffieldWednesdayChelseaFcActualValue , goals1956_1957SheffieldWednesdayChelseaFcExpectedValue );

        ArrayList<Goal> goals1956_1957TottenhamHotspurLeedsUnitedActualVlaue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "tottenham-hotspur", "leeds-united");
        List<Goal> goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue = Arrays.asList(
        		new Goal("1 : 0", "0","Bobby Smith"),
        		new Goal("2 : 0", "0","George Robb"),
        		new Goal("3 : 0", "0","Terry Medwin"),
        		new Goal("4 : 0", "0","John Brooks"),
        		new Goal("5 : 0", "0","Danny Blanchflower"),
        		new Goal("5 : 1", "0","Keith Ripley"));
        assertGameGoal(goals1956_1957TottenhamHotspurLeedsUnitedActualVlaue , goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue );

        ArrayList<Goal> goalsActualValueoldGoalZeroToZero = screenScraperUnderTest.getGoalsOfGame("premier-league", "1956-1957", "aston-villa", "west-bromwich-albion");
        Assert.assertEquals(null, goalsActualValueoldGoalZeroToZero);

        ArrayList<Goal> goals1946_1947LeedsUnitedSunderlandAfcActualValue = screenScraperUnderTest.getGoalsOfGame("premier-league", "1946-1947", "leeds-united", "sunderland-afc");
        List<Goal> goals1946_1947LeedsUnitedSunderlandAfcExpected = Arrays.asList(
        		new Goal("1 : 0", "90", "Davy Cochrane"),
        		new Goal("1 : 1", "90", "Jackie Robinson"));
        assertGameGoal(goals1946_1947LeedsUnitedSunderlandAfcActualValue , goals1946_1947LeedsUnitedSunderlandAfcExpected );


    }
    
    public void assertPlayersSummaryInTeam(ArrayList<PlayerSummary> playersClubActualValue, List<PlayerSummary> playersInClubExpectedValue , List<Integer> playersIds) {
        for (int i = 0; i < playersInClubExpectedValue.size(); i++) {
            assertThat(playersInClubExpectedValue.get(i)).usingRecursiveComparison().isEqualTo(playersClubActualValue.get(playersIds.get(i)));
        }
    }

    @Test
    public void itShouldGetPlayersSummuryInTeam() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        
        ArrayList<PlayerSummary> playersManchesterUnited2015ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "2015");
        List<PlayerSummary> playersManchesterUnited2015Expected = Arrays.asList(
        		new PlayerSummary("40", "Ben Amos", "England", "10/04/1990", "Goalkeeper"),
        		new PlayerSummary("1", "De Gea", "Spain", "07/11/1990", "Goalkeeper"),
        		new PlayerSummary("13", "Anders Lindegaard", "Denmark", "13/04/1984", "Goalkeeper"),
        		new PlayerSummary("32", "Víctor Valdés", "Spain", "14/01/1982", "Goalkeeper"),
        		new PlayerSummary("42", "Tyler Blackett", "England", "02/04/1994", "Defender"),
        		new PlayerSummary("6", "Jonny Evans", "Northern Ireland", "03/01/1988", "Defender"),
        		new PlayerSummary("37", "Saidy Janko", "Switzerland", "22/10/1995", "Defender"),
        		new PlayerSummary("4", "Phil Jones", "England", "21/02/1992", "Defender"),
        		new PlayerSummary(null, "Andrew Kellett", "England", "10/11/1993", "Defender"),
        		new PlayerSummary("33", "Paddy McNair", "Northern Ireland", "27/04/1995", "Defender"),
        		new PlayerSummary("2", "Rafael", "Brazil", "09/07/1990", "Defender"),
        		new PlayerSummary("5", "Marcos Rojo", "Argentina", "20/03/1990", "Defender"),
        		new PlayerSummary("3", "Luke Shaw", "England", "12/07/1995", "Defender"),
        		new PlayerSummary("12", "Chris Smalling", "England", "22/11/1989", "Defender"),
        		new PlayerSummary("39", "Tom Thorpe", "England", "13/01/1993", "Defender"),
        		new PlayerSummary("21", "Ander Herrera", "Spain", "14/08/1989", "Midfielder"),
        		new PlayerSummary("44", "Andreas Pereira", "Brazil", "01/01/1996", "Midfielder"),
        		new PlayerSummary("17", "Daley Blind", "Netherlands", "09/03/1990", "Midfielder"),
        		new PlayerSummary("16", "Michael Carrick", "England", "28/07/1981", "Midfielder"),
        		new PlayerSummary("31", "Marouane Fellaini", "Belgium", "22/11/1987", "Midfielder"),
        		new PlayerSummary("11", "Adnan Januzaj", "Belgium", "05/02/1995", "Midfielder"),
        		new PlayerSummary("8", "Mata", "Spain", "28/04/1988", "Midfielder"),
        		new PlayerSummary("25", "Antonio Valencia", "Ecuador", "04/08/1985", "Midfielder"),
        		new PlayerSummary("18", "Ashley Young", "England", "09/07/1985", "Midfielder"),
        		new PlayerSummary("7", "Ángel Di María", "Argentina", "14/02/1988", "Forward"),
        		new PlayerSummary("9", "Radamel Falcao", "Colombia", "10/02/1986", "Forward"),
        		new PlayerSummary("10", "Wayne Rooney", "England", "24/10/1985", "Forward"),
        		new PlayerSummary("20", "Robin van Persie", "Netherlands", "06/08/1983", "Forward"),
        		new PlayerSummary("49", "James Wilson", "England", "01/12/1995", "Forward"),
        		new PlayerSummary(null, "Louis van Gaal", "Netherlands", "08/08/1951", "Manager"),
        		new PlayerSummary(null, "Marcel Bout", "Netherlands", "18/11/1962", "Ass. Manager"),
        		new PlayerSummary(null, "Ryan Giggs", "Wales", "29/11/1973", "Ass. Manager"),
        		new PlayerSummary(null, "Albert Stuivenberg", "Netherlands", "30/10/1970", "Ass. Manager"),
        		new PlayerSummary(null, "Frans Hoek", "Netherlands", "17/10/1956", "Goalkeeper-Coach"));
        List<Integer> playersIdManchesterUnited2015 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
        		,21,22,23,24,25,26,27,28,29,30,31,32,33,34);    
        
        assertPlayersSummaryInTeam(playersManchesterUnited2015ActualValue,playersManchesterUnited2015Expected,playersIdManchesterUnited2015);

        ArrayList<PlayerSummary> playersManchesterUnited2001ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "2001");
        List<Integer> playersIdManchesterUnited2001 = Arrays.asList(0,3,4,8,15,32,38,39); 
        List<PlayerSummary> playersManchesterUnited2001Expected = Arrays.asList(
        		new PlayerSummary("1", "Fabien Barthez", "France", "28/06/1971", "Goalkeeper"),
        		new PlayerSummary("17", "Raimond van der Gouw", "Netherlands", "24/03/1963", "Goalkeeper"),
        		new PlayerSummary("24", "Wes Brown", "England", "13/10/1979", "Defender"),
        		new PlayerSummary(null, "Mark Lynch", "England", "02/09/1981", "Defender"),
        		new PlayerSummary("7", "David Beckham", "England", "02/05/1975", "Midfielder"),
        		new PlayerSummary("9", "Andy Cole", "England", "15/10/1971", "Forward"),
        		new PlayerSummary(null, "Alex Ferguson", "Scotland", "31/12/1941", "Manager"),
        		new PlayerSummary(null, "Steve McClaren", "England", "03/05/1961", "Ass. Manager"));
        assertPlayersSummaryInTeam(playersManchesterUnited2001ActualValue,playersManchesterUnited2001Expected,playersIdManchesterUnited2001);

        ArrayList<PlayerSummary> playersManchesterUnited1991ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1991");
        List<Integer> playersIdManchesterUnited1991 = Arrays.asList(0,3,4,8,15,23,29); 
        List<PlayerSummary> playersManchesterUnited1991Expected = Arrays.asList(
        		new PlayerSummary(null, "Mark Bosnich", "Australia", "13/01/1972", "Goalkeeper"),
        		new PlayerSummary("25", "Gary Walsh", "England", "21/03/1968", "Goalkeeper"),
        		new PlayerSummary("15", "Clayton Blackmore", "Wales", "23/09/1964", "Defender"),
        		new PlayerSummary(null, "Lee Martin", "England", "05/02/1968", "Defender"),
        		new PlayerSummary(null, "Andrey Kanchelskis", "Russia", "23/01/1969", "Midfielder"),
        		new PlayerSummary(null, "Jeff Baicher", "USA", "16/11/1968", "Forward"),
        		new PlayerSummary(null, "Alex Ferguson", "Scotland", "31/12/1941", "Manager"));
        assertPlayersSummaryInTeam(playersManchesterUnited1991ActualValue,playersManchesterUnited1991Expected,playersIdManchesterUnited1991);

        ArrayList<PlayerSummary> playersManchesterUnited1970ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1970");
        List<Integer> playersIdManchesterUnited1970 = Arrays.asList(0,2,11,17,18,24,26);
        List<PlayerSummary> playersManchesterUnited1970Expected = Arrays.asList(
        		new PlayerSummary(null, "Jimmy Rimmer", "England", "10/02/1948", "Goalkeeper"),
        		new PlayerSummary(null, "Shay Brennan", "Ireland", "06/05/1937", "Defender"),
        		new PlayerSummary(null, "Bobby Charlton", "England", "11/10/1937", "Midfielder"),
        		new PlayerSummary(null, "John Aston", "England", "28/07/1947", "Forward"),
        		new PlayerSummary("7", "George Best", "Northern Ireland", "22/05/1946", "Forward"),
        		new PlayerSummary(null, "Wilf McGuinness", "England", "25/10/1937", "Manager"),
        		new PlayerSummary(null, "Jimmy Murphy", "Wales", "27/10/1910", "Ass. Manager"));
        assertPlayersSummaryInTeam(playersManchesterUnited1970ActualValue,playersManchesterUnited1970Expected,playersIdManchesterUnited1970);

        
        ArrayList<PlayerSummary> manchesterUnitedActualValueplayers1966 = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1966");
        List<Integer> playersIdManchesterUnited1966 = Arrays.asList(0,4,12);
        List<PlayerSummary> playersManchesterUnited1966Expected = Arrays.asList(
        		new PlayerSummary(null, "Pat Dunne", "Ireland", "09/02/1943", "Goalkeeper"),
        		new PlayerSummary(null, "Shay Brennan", "Ireland", "06/05/1937", "Defender"),
        		new PlayerSummary(null, "Bobby Charlton", "England", "11/10/1937", "Midfielder"));
        assertPlayersSummaryInTeam(manchesterUnitedActualValueplayers1966,playersManchesterUnited1966Expected,playersIdManchesterUnited1966);

        ArrayList<PlayerSummary> playersManchesterUnited1950ActualValue = screenScraperUnderTest.getAllPlayersSummaryInClub("manchester-united", "1950");
        List<Integer> playersIdManchesterUnited1950 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27);
        List<PlayerSummary> playersManchesterUnited1950Expected = Arrays.asList(
        		new PlayerSummary(null, "Jack Crompton", "England", "18/12/1921", "Goalkeeper"),
        		new PlayerSummary(null, "Sonny Feehan", "Ireland", "17/09/1926", "Goalkeeper"),
        		new PlayerSummary(null, "Joe Lancaster", "England", "28/04/1926", "Goalkeeper"),
        		new PlayerSummary(null, "Ray Wood", "England", "11/06/1931", "Goalkeeper"),        		
        		new PlayerSummary(null, "John Aston", "England", "03/09/1921", "Defender"),
        		new PlayerSummary(null, "John Ball", "England", "13/03/1925", "Defender"),
        		new PlayerSummary(null, "Johnny Carey", "Ireland", "23/02/1919", "Defender"),
        		new PlayerSummary(null, "Sammy Lynn", "England", "25/12/1920", "Defender"),
        		new PlayerSummary(null, "Tommy McNulty", "England", "30/12/1929", "Defender"),
        		new PlayerSummary(null, "Billy Redman", "England", "29/01/1928", "Defender"),
        		new PlayerSummary(null, "Jack Warner", "Wales", "21/09/1911", "Defender"),        		
        		new PlayerSummary(null, "Allenby Chilton", "England", "16/09/1918", "Midfielder"),
        		new PlayerSummary(null, "Henry Cockburn", "England", "14/09/1923", "Midfielder"),
        		new PlayerSummary(null, "Don Gibson", "England", "12/05/1929", "Midfielder"),
        		new PlayerSummary(null, "Tommy Lowrie", "Scotland", "14/01/1928", "Midfielder"),
        		new PlayerSummary(null, "Billy McGlen", "England", "27/04/1921", "Midfielder"),
        		new PlayerSummary(null, "Jeff Whitefoot", "England", "31/12/1933", "Midfielder"),        		
        		new PlayerSummary(null, "Brian Birch", "England", "18/11/1931", "Forward"),
        		new PlayerSummary(null, "Tommy Bogan", "Scotland", "18/05/1920", "Forward"),
        		new PlayerSummary(null, "Laurie Cassidy", "England", "10/03/1923", "Forward"),
        		new PlayerSummary(null, "Frank Clempson", "England", "27/05/1930", "Forward"),
        		new PlayerSummary(null, "Jimmy Delaney", "Scotland", "03/09/1914", "Forward"),
        		new PlayerSummary(null, "Johnny Downie", "Scotland", "19/07/1925", "Forward"),
        		new PlayerSummary(null, "Charlie Mitten", "England", "17/01/1921", "Forward"),
        		new PlayerSummary(null, "Stan Pearson", "England", "11/01/1919", "Forward"),
        		new PlayerSummary(null, "Jack Rowley", "England", "07/10/1920", "Forward"),
        		new PlayerSummary(null, "Matt Busby", "Scotland", "26/05/1909", "Manager"),
        		new PlayerSummary(null, "Jimmy Murphy", "Wales", "27/10/1910", "Ass. Manager"));
        assertPlayersSummaryInTeam(playersManchesterUnited1950ActualValue,playersManchesterUnited1950Expected,playersIdManchesterUnited1950);

        ArrayList<PlayerSummary> playersManchesterUnited1890ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("manchester-united", "1890");
        List<Integer> playersIdManchesterUnited1890 = Arrays.asList(0,1,2,3,4);
        List<PlayerSummary> playersManchesterUnited1890Expected = Arrays.asList(
        		new PlayerSummary(null, "Tom Burke", "Wales", "1862", "Midfielder"),
        		new PlayerSummary(null, "Joe Davies", "Wales", "12/07/1864", "Midfielder"),
        		new PlayerSummary(null, "Roger Doughty", "Wales", "1868", "Midfielder"),
        		new PlayerSummary(null, "Thomas Craig", "England", "", "Forward"),
        		new PlayerSummary(null, "Jack Doughty", "England", "10/1865", "Forward"));
        assertPlayersSummaryInTeam(playersManchesterUnited1890ActualValue,playersManchesterUnited1890Expected,playersIdManchesterUnited1890);

        ArrayList<PlayerSummary> playersAccrington1890ActualValue = screenScraperUnderTest.clubsCollector.getAllPlayersSummaryInClub("Accrington", "1890");
        Assert.assertEquals(null,playersAccrington1890ActualValue);

    }
    
    public void assertClubsInSeason(ArrayList<Club> clubsInSeasonActualValue, List<Club> clubsInSeasonExpectedValue, List<Integer> clubsIdSeason ) {
    	for (int i = 0; i < clubsInSeasonExpectedValue.size(); i++) {
    		assertThat(clubsInSeasonActualValue.get(i)).usingRecursiveComparison().isEqualTo(clubsInSeasonExpectedValue.get(clubsIdSeason.get(i)));
    	}
    }

    @Test
    public void itShouldGetClubsInSeason() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<Club> clubsAt2015_2016ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("eng-premier-league", "2015-2016");
        List<Integer> clubsIdAtSeason2015_2016 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19); 
        List<Club> clubsAt2015_2016Expected = Arrays.asList(
        		new Club("AFC Bournemouth"),
        		new Club("Arsenal FC"),
        		new Club("Aston Villa"),
        		new Club("Chelsea FC"),
        		new Club("Crystal Palace"),
        		new Club("Everton FC"),
        		new Club("Leicester City"),
        		new Club("Liverpool FC"),
        		new Club("Manchester City"),
        		new Club("Manchester United"),
        		new Club("Newcastle United"),
        		new Club("Norwich City"),
        		new Club("Southampton FC"),
        		new Club("Stoke City"),
        		new Club("Sunderland AFC"),
        		new Club("Swansea City"),
        		new Club("Tottenham Hotspur"),
        		new Club("Watford FC"),
        		new Club("West Bromwich Albion"),
        		new Club("West Ham United"));      
        assertClubsInSeason(clubsAt2015_2016ActualValue,clubsAt2015_2016Expected,clubsIdAtSeason2015_2016);

        ArrayList<Club> clubsAt1967_1968ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("eng-premier-league", "1967-1968");
        List<Integer> clubsIdAtSeason1967_1968 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21); 
        List<Club> clubsAt1967_1968Expected = Arrays.asList(
        		new Club("Arsenal FC"),
        		new Club("Burnley FC"),
        		new Club("Chelsea FC"),
        		new Club("Coventry City"),
        		new Club("Everton FC"),
        		new Club("Fulham FC"),
        		new Club("Leeds United"),
        		new Club("Leicester City"),
        		new Club("Liverpool FC"),
        		new Club("Manchester City"),
        		new Club("Manchester United"),
        		new Club("Newcastle United"),
        		new Club("Nottingham Forest"),
        		new Club("Sheffield United"),
        		new Club("Sheffield Wednesday"),
        		new Club("Southampton FC"),
        		new Club("Stoke City"),
        		new Club("Sunderland AFC"),
        		new Club("Tottenham Hotspur"),
        		new Club("West Bromwich Albion"),
        		new Club("West Ham United"),
        		new Club("Wolverhampton Wanderers"));
        assertClubsInSeason(clubsAt1967_1968ActualValue,clubsAt1967_1968Expected,clubsIdAtSeason1967_1968);

        ArrayList<Club> clubsAt1889_1890ActualValue = screenScraperUnderTest.clubsCollector.getAllClubsInSeason("eng-premier-league", "1889-1890");
        List<Integer> clubsIdAtSeason1890_1891 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11); 
        List<Club> clubsAt1889_1890Expected = Arrays.asList(
        		new Club("Accrington FC"),
        		new Club("Aston Villa"),
        		new Club("Blackburn Rovers"),
        		new Club("Bolton Wanderers"),
        		new Club("Burnley FC"),
        		new Club("Derby County"),
        		new Club("Everton FC"),
        		new Club("Notts County"),
        		new Club("Preston North End"),
        		new Club("Stoke City"),
        		new Club("West Bromwich Albion"),
        		new Club("Wolverhampton Wanderers"));
        assertClubsInSeason(clubsAt1889_1890ActualValue,clubsAt1889_1890Expected,clubsIdAtSeason1890_1891);

    }
   
    public void assertPlayerInformation(PlayerAllInformation playerInfoActualValue, List<String> attributeList , PlayerAllInformation playerInformationExpectedValue) {
    	try {
    		for(int i =0 ; i<attributeList.size() ; i++) {
    			 assertThat(playerInfoActualValue.getClass().getDeclaredField(attributeList.get(i)).get(playerInfoActualValue)).
    			usingRecursiveComparison().isEqualTo(
    			   playerInformationExpectedValue.getClass().getDeclaredField(attributeList.get(i)).get(playerInformationExpectedValue));
    		}
		} catch (Exception e) {
			System.out.println("No Attribute Found");
			e.printStackTrace();
		}
    }
    
    public void assertPlayerInformationWithIndexes(PlayerAllInformation playerInfoActualValue, List<PlayerAttributeToForComparison_TEST> attributeList , PlayerAllInformation playerInfoExpectedValue) {
    	for(int i =0 ; i<attributeList.size() ; i++) {
    	try {    			
    			if(playerInfoActualValue.getClass().getDeclaredField(attributeList.get(i).attributeName).toString().contains("personalInfo")) {
	    			assertThat(playerInfoActualValue.personalInfo).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.personalInfo);
    			}
    			else if(playerInfoActualValue.getClass().getDeclaredField(attributeList.get(i).attributeName).toString().contains("teamsManaged")) {
    				for(int j =0 ; j<attributeList.get(i).indexes.size(); j++) {
    					assertThat(playerInfoActualValue.teamsManaged.get(attributeList.get(i).indexes.get(j))).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.teamsManaged.get(j)); 
    				}
    			}
    			else if(playerInfoActualValue.getClass().getDeclaredField(attributeList.get(i).attributeName).toString().contains("clubsCareer")) {
    				for(int j =0 ; j<attributeList.get(i).indexes.size(); j++) {
    					assertThat(playerInfoActualValue.clubsCareer.get(attributeList.get(i).indexes.get(j))).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.clubsCareer.get(j)); 
    				}
    			}    			
        		else if(playerInfoActualValue.getClass().getDeclaredField(attributeList.get(i).attributeName).toString().contains("clubMatches")) {
        			for(int j =0 ; j<attributeList.get(i).indexes.size(); j++) {
    					assertThat(playerInfoActualValue.clubMatches.get(attributeList.get(i).indexes.get(j))).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.clubMatches.get(j)); 
    				}
        		}
            			
        		else if(playerInfoActualValue.getClass().getDeclaredField(attributeList.get(i).attributeName).toString().contains("internationalCopmetitionsInfo")) {
        			for(int j =0 ; j<attributeList.get(i).indexes.size(); j++) {
    					assertThat(playerInfoActualValue.internationalCopmetitionsInfo.get(attributeList.get(i).indexes.get(j))).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.internationalCopmetitionsInfo.get(j)); 
    				}
        		}                			
        		else if(playerInfoActualValue.getClass().getDeclaredField(attributeList.get(i).attributeName).toString().contains("clubsMatchesOverall")) {
        			for(int j =0 ; j<attributeList.get(i).indexes.size(); j++) {
    					assertThat(playerInfoActualValue.clubsMatchesOverall.get(attributeList.get(i).indexes.get(j))).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.clubsMatchesOverall.get(j)); 
    				}
        		}                    			
        		else if(playerInfoActualValue.getClass().getDeclaredField(attributeList.get(i).attributeName).toString().contains("internationalCopmetitionsOverall")) {
        			for(int j =0 ; j<attributeList.get(i).indexes.size(); j++) {
    					assertThat(playerInfoActualValue.internationalCopmetitionsOverall.get(attributeList.get(i).indexes.get(j))).usingRecursiveComparison().isEqualTo(playerInfoExpectedValue.internationalCopmetitionsOverall.get(j)); 
    				}
        		}
    		}
    	
		 catch (Exception e) {
			System.out.println("No Attribute Found  " + attributeList.get(i).attributeName);
			e.printStackTrace();
		}
    }
    }

    @Test
    public void itShouldGetPlayerInformation() {

        ScreenScraper screenScraperTest = new ScreenScraper();        
        
        //https://www.worldfootball.net/player_summary/eric-bailly/
        PlayerAllInformation player1ActualValueInfo = screenScraperTest.playerCollector.getAllInformationAboutPlayer("eric-bailly");        
        PlayerAllInformation player1ExpectedValueInfo = new PlayerAllInformation();
        player1ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Eric Bailly", "Eric Bertrand Bailly",
                "12.04.1994", "Bingerville, Ivory Coast", "Ivory Coast", "187 cm", "77 kg", "Centre Back", "right");
        player1ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("07/2016 - 06/2022", "Manchester United", "England", "Defender", "#3"),
        		new PlayerClubCareer("01/2020 - 01/2020", "Manchester United U23", "England", "Defender", null),
        		new PlayerClubCareer("01/2017 - 01/2017", "Manchester United U23", "England", "Defender", null),
        		new PlayerClubCareer("01/2015 - 06/2016", "Villarreal CF", "Spain", "Defender", null),
        		new PlayerClubCareer("09/2014 - 01/2015", "Espanyol Barcelona", "Spain", "Defender", null),
        		new PlayerClubCareer("03/2013 - 01/2015", "Espanyol Barcelona B", "Spain", "Defender", null),
        		new PlayerClubCareer("07/2012 - 06/2013", "Espanyol Barcelona [Youth]", "Spain", "Defender", null)));
        player1ExpectedValueInfo.clubMatches = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("Champions League", "UEFA", "7", "0", "7", "0", "1", "2", "0", "0"),
        		new PlayerCompetitionInformation("Europa League", "UEFA", "24", "1", "24", "0", "2", "4", "2", "1"),
        		new PlayerCompetitionInformation("Premier League", "England", "59", "1", "48", "11", "5", "8", "0", "1"),
        		new PlayerCompetitionInformation("FA Cup", "England", "6", "0", "5", "1", "2", "1", "0", "0"),
        		new PlayerCompetitionInformation("League Cup", "England", "5", "0", "5", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformation("FA Community Shield", "England", "1", "0", "1", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformation("U23 Premier League Div. 1", "England", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformation("U23 Premier League Div. 2", "England", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformation("Primera División", "Spanien", "40", "0", "39", "1", "10", "15", "1", "0"),
        		new PlayerCompetitionInformation("Copa del Rey", "Spanien", "3", "0", "3", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformation("Segunda B Grupo 3", "Spanien", "22", "0", "19", "3", "2", "6", "1", "0"),
        		new PlayerCompetitionInformation("∑", null, "169", "2", "153", "16", "24", "39", "4", "2")));
        player1ExpectedValueInfo.clubsMatchesOverall = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2020/2021", "Manchester United", "5", "0", "4", "1", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "2020/2021", "Manchester United", "3", "0", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "2019/2020", "Manchester United", "4", "0", "4", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "2019/2020", "Manchester United", "3", "0", "3", "0", "2", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2019/2020", "Manchester United", "4", "0", "1", "3", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "U23 PL Div.2", "2019/2020", "Manchester United U23", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2018/2019", "Manchester United", "12", "0", "8", "4", "2", "0", "0", "1"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "2018/2019", "Manchester United", "4", "0", "4", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "2018/2019", "Manchester United", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "2018/2019", "Manchester United", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2017/2018", "Manchester United", "13", "1", "11", "2", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "2017/2018", "Manchester United", "2", "0", "1", "1", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "2017/2018", "Manchester United", "3", "0", "3", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2016/2017", "Manchester United", "25", "0", "24", "1", "3", "4", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "2016/2017", "Manchester United", "11", "0", "11", "0", "0", "2", "1", "1"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "2016/2017", "Manchester United", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "U23 PL Div.1", "2016/2017", "Manchester United U23", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Com. Shield", "2016", "Manchester United", "1", "0", "1", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "Pr. División", "2015/2016", "Villarreal CF", "25", "0", "25", "0", "6", "9", "1", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "2015/2016", "Villarreal CF", "7", "1", "7", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "Copa del Rey", "2015/2016", "Villarreal CF", "3", "0", "3", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "Pr. División", "2014/2015", "Villarreal CF", "10", "0", "10", "0", "3", "5", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "2014/2015", "Villarreal CF", "2", "0", "2", "0", "0", "0", "1", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "Pr. División", "2014/2015", "Espanyol Barcelona", "5", "0", "4", "1", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "2ª B G3", "2014/2015", "Espanyol Barcelona B", "1", "0", "1", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("Spanien", "2ª B G3", "2013/2014", "Espanyol Barcelona B", "21", "0", "18", "3", "2", "5", "1", "0")));
        player1ExpectedValueInfo.internationalCopmetitionsOverall = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2020", "Ivory Coast", "2", "0", "2", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2018", "Ivory Coast", "2", "0", "2", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("CAF", "Afr. Cup QF", "2017-2019", "Ivory Coast", "5", "2", "5", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("CAF", "Africa Cup", "2017 Gabun", "Ivory Coast", "3", "0", "3", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2017", "Ivory Coast", "4", "0", "3", "1", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2016", "Ivory Coast", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("CAF", "Afr. Cup QF", "2015/2016", "Ivory Coast", "4", "0", "4", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "WCQ Africa", "2015-2017", "Ivory Coast", "4", "0", "4", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("CAF", "Africa Cup", "2015 Equatorial Guinea", "Ivory Coast", "6", "0", "6", "0", "1", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2015", "Ivory Coast", "5", "0", "5", "0", "1", "0", "0", "0")));
        player1ExpectedValueInfo.internationalCopmetitionsInfo = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("WC Qualifiers Africa", "FIFA", "4", "0", "4", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformation("Friendlies", "FIFA", "14", "0", "13", "1", "2", "1", "0", "0"),
        		new PlayerCompetitionInformation("Africa Cup", "CAF", "9", "0", "9", "0", "1", "3", "0", "0"),
        		new PlayerCompetitionInformation("Africa Cup Qual.", "CAF", "9", "2", "9", "0", "2", "1", "0", "0"),
        		new PlayerCompetitionInformation("∑", null, "36", "2", "35", "1", "5", "7", "0", "0")));
        List<String> player1AttributeList = Arrays.asList("personalInfo","teamsManaged" , "clubsCareer","clubMatches",
        		"internationalCopmetitionsInfo","clubsMatchesOverall","internationalCopmetitionsOverall");
        assertPlayerInformation(player1ActualValueInfo,player1AttributeList, player1ExpectedValueInfo);
        //https://www.worldfootball.net/player_summary/tony-adams/
        PlayerAllInformation player2ActualValueInfo  = screenScraperTest.getAllInformationAboutPlayer("tony-adams");
        PlayerAllInformation player2ExpectedValueInfo = new PlayerAllInformation();

        player2ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Tony Adams", "Anthony Alexander Adams",
                "10.10.1966", "Romford, England", "England", "191 cm", "87 kg", "Centre Back", "right");
        player2ExpectedValueInfo.teamsManaged = new ArrayList<>(Arrays.asList(
        		new PlayerTeamManaged("04/2017 - 06/2017", "Granada CF", "Spain", "Manager"),
        		new PlayerTeamManaged("07/2010 - 06/2012", "Gabala FK", "Azerbaijan", "Manager"),
        		new PlayerTeamManaged("10/2008 - 02/2009", "Portsmouth FC", "England", "Manager")));
        player2ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("07/1983 - 06/2002", "Arsenal FC", "England", "Defender", null),
        		new PlayerClubCareer("07/1982 - 06/1983", "Arsenal FC [U18]", "England", "Defender", null)));
        player2ExpectedValueInfo.clubMatches = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("Champions League", "UEFA", "21", "1", "21", "0", "1", "3", "0", "0"),
        		new PlayerCompetitionInformation("Europa League", "UEFA", "9", "0", "9", "0", "2", "2", "0", "0"),
        		new PlayerCompetitionInformation("UEFA Super Cup", "UEFA", "2", "0", "2", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformation("Cup Winners Cup", "UEFA", "16", "2", "16", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformation("Premier League", "England", "504", "32", "500", "4", "19", "37", "1", "4"),
        		new PlayerCompetitionInformation("FA Cup", "England", "33", "7", "32", "1", "0", "2", "0", "0"),
        		new PlayerCompetitionInformation("League Cup", "England", "17", "3", "17", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformation("FA Community Shield", "England", "4", "0", "4", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformation("∑", null, "606", "45", "601", "5", "23", "47", "1", "4")));
        player2ExpectedValueInfo.internationalCopmetitionsInfo = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("World Cup", "FIFA", "4", "0", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformation("WC Qualifiers Europe", "FIFA", "14", "0", "14", "0", "2", "2", "0", "0"),
        		new PlayerCompetitionInformation("Friendlies", "FIFA", "29", "3", "29", "0", "4", "0", "0", "0"),
        		new PlayerCompetitionInformation("EURO", "UEFA", "9", "1", "9", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformation("EURO Qualifiers", "UEFA", "10", "1", "10", "0", "2", "1", "0", "0"),
        		new PlayerCompetitionInformation("∑", null, "66", "5", "66", "0", "9", "4", "0", "0"),
        		new PlayerCompetitionInformation("EURO [U21]", "UEFA", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformation("∑ U21", null, "1", "0", "1", "0", "0", "0", "0", "0")));
        player2ExpectedValueInfo.clubsMatchesOverall = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "2001/2002", "Arsenal FC", "3", "1", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2001/2002", "Arsenal FC", "10", "0", "10", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "2000/2001", "Arsenal FC", "26", "1", "26", "0", "0", "7", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "2000/2001", "Arsenal FC", "4", "1", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "2000/2001", "Arsenal FC", "8", "0", "8", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "1999/2000", "Arsenal FC", "6", "0", "6", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1999/2000", "Arsenal FC", "21", "0", "21", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1999/2000", "Arsenal FC", "1", "1", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "1999/2000", "Arsenal FC", "5", "0", "5", "0", "0", "2", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1998/1999", "Arsenal FC", "26", "1", "26", "0", "0", "4", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1998/1999", "Arsenal FC", "5", "0", "5", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "1998/1999", "Arsenal FC", "4", "1", "4", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Com. Shield", "1998", "Arsenal FC", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1997/1998", "Arsenal FC", "6", "0", "6", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1997/1998", "Arsenal FC", "26", "3", "26", "0", "0", "6", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1997/1998", "Arsenal FC", "2", "0", "2", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "1997/1998", "Arsenal FC", "2", "0", "2", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1996/1997", "Arsenal FC", "28", "3", "27", "1", "2", "5", "1", "1"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1996/1997", "Arsenal FC", "3", "0", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1996/1997", "Arsenal FC", "3", "0", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EL", "1996/1997", "Arsenal FC", "1", "0", "1", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1995/1996", "Arsenal FC", "2", "0", "2", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1995/1996", "Arsenal FC", "21", "1", "21", "0", "0", "2", "0", "1"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1995/1996", "Arsenal FC", "5", "2", "5", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1994/1995", "Arsenal FC", "27", "3", "27", "0", "3", "4", "0", "1"),
        		new PlayerCompetitionInformationOverall("UEFA", "CWC", "1994/1995", "Arsenal FC", "8", "0", "8", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1994/1995", "Arsenal FC", "1", "0", "0", "1", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1994/1995", "Arsenal FC", "4", "1", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "UEFA Sup.Cup", "1994", "Arsenal FC", "2", "0", "2", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1993/1994", "Arsenal FC", "35", "0", "35", "0", "3", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "CWC", "1993/1994", "Arsenal FC", "8", "2", "8", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1993/1994", "Arsenal FC", "3", "2", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1993/1994", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Com. Shield", "1993", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1992/1993", "Arsenal FC", "4", "2", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1992/1993", "Arsenal FC", "35", "0", "33", "2", "2", "4", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1992/1993", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1991/1992", "Arsenal FC", "35", "2", "35", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "Ch. League", "1991/1992", "Arsenal FC", "4", "0", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Com. Shield", "1991", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1990/1991", "Arsenal FC", "30", "1", "30", "0", "2", "1", "0", "1"),
        		new PlayerCompetitionInformationOverall("England", "FA Cup", "1990/1991", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1989/1990", "Arsenal FC", "38", "5", "38", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Com. Shield", "1989", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1988/1989", "Arsenal FC", "36", "4", "36", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1987/1988", "Arsenal FC", "39", "2", "39", "0", "3", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1986/1987", "Arsenal FC", "42", "6", "42", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "League Cup", "1986/1987", "Arsenal FC", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1985/1986", "Arsenal FC", "10", "0", "10", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1984/1985", "Arsenal FC", "16", "0", "15", "1", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("England", "Pr. League", "1983/1984", "Arsenal FC", "3", "0", "3", "0", "1", "0", "0", "0")));
        player2ExpectedValueInfo.internationalCopmetitionsOverall = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformationOverall("FIFA", "WCQ Europe", "2000/2001", "England", "1", "0", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO", "2000 Holland/Belgium", "England", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "2000", "England", "2", "1", "2", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1999", "England", "2", "0", "2", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO Qualif.", "1998/1999", "England", "5", "0", "5", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "World Cup", "1998 France", "England", "4", "0", "4", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1998", "England", "3", "0", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "WCQ Europe", "1996/1997", "England", "3", "0", "3", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO", "1996 England", "England", "5", "0", "5", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1996", "England", "1", "0", "1", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1995", "England", "6", "0", "6", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1994", "England", "5", "0", "5", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "WCQ Europe", "1992/1993", "England", "9", "0", "9", "0", "0", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO Qualif.", "1990/1991", "England", "2", "0", "2", "0", "1", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "WCQ Europe", "1988/1989", "England", "1", "0", "1", "0", "1", "1", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO", "1988 Germany", "England", "3", "1", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1988", "England", "7", "2", "7", "0", "2", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1987", "England", "3", "0", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO Qualif.", "1986/1987", "England", "3", "1", "3", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformationOverall("UEFA", "EURO [U21]", "1986", "England", "1", "0", "1", "0", "0", "0", "0", "0")));
        List<String> player2AttributeList = Arrays.asList("personalInfo","teamsManaged" , "clubsCareer","clubMatches",
        		"internationalCopmetitionsInfo","clubsMatchesOverall","internationalCopmetitionsOverall");
        assertPlayerInformation(player2ActualValueInfo,player2AttributeList, player2ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/walter-aitkenhead/
        PlayerAllInformation player3ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("walter-aitkenhead");
        PlayerAllInformation player3ExpectedValueInfo = new PlayerAllInformation();
        player3ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Walter Aitkenhead", "Walter Campbell Allison Aitkenhead",
                "21.05.1887 † 19.07.1966", "Glasgow, Scotland", "Scotland", null, null, null, null);
        player3ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("01/1906 - 12/1918", "Blackburn Rovers", "England", "Forward", null),
        		new PlayerClubCareer("01/1905 - 12/1905", "Partick Thistle", "Scotland", "Forward", null)));
        player3ExpectedValueInfo.internationalCopmetitionsInfo = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("Friendlies", "FIFA", "1", "2", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformation("∑", null, "1", "2", "1", "0", "0", "0", "0", "0")));
        player3ExpectedValueInfo.internationalCopmetitionsOverall = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1912", "Scotland", "1", "2", "1", "0", "0", "0", "0", "0")));
        List<String> player3AttributeList = Arrays.asList("personalInfo","teamsManaged" , "clubsCareer","clubMatches",
        		"internationalCopmetitionsInfo","clubsMatchesOverall","internationalCopmetitionsOverall");
        assertPlayerInformation(player3ActualValueInfo,player3AttributeList, player3ExpectedValueInfo);

        //https://www.worldfootball.net/player_summary/sam-johnstone/
        PlayerAllInformation player4ActualValueInfo = screenScraperTest.getAllInformationAboutPlayer("sam-johnstone");
        PlayerAllInformation player4ExpectedValueInfo = new PlayerAllInformation();
        player4ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("07/2018 - 07/2018", "Manchester United U23", "England", "Goalkeeper", null),
         		new PlayerClubCareer("01/2016 - 01/2016", "Preston North End", "England", "Goalkeeper", null)));

        player4ExpectedValueInfo.clubMatches = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("Premier League","England","17","0","17","0","0","0","0","0"),
        		new PlayerCompetitionInformation("League One","England","51","0","51","0","0","4","0","0"),
        		new PlayerCompetitionInformation("∑",null,"273","0","273","0","0","14","0","0")));
        
        List<PlayerAttributeToForComparison_TEST> player4AttributesToTest = new ArrayList<>(Arrays.asList(
        		new PlayerAttributeToForComparison_TEST("clubsCareer",  new ArrayList<Integer> (Arrays.asList(1,5))),
				new PlayerAttributeToForComparison_TEST("clubMatches",  new ArrayList<Integer> (Arrays.asList(0,3,6)))
				));
        
        assertPlayerInformationWithIndexes(player4ActualValueInfo,player4AttributesToTest,player4ExpectedValueInfo);


    }

    @Test
    public void itShouldMatchDetails() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        MatchDetails match1ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2019-2020", "brighton-hove-albion", "everton-fc");

        ArrayList<GoalInMatchDetails> match1Goals = new ArrayList<>();
        GoalInMatchDetails match1Goal1 = new GoalInMatchDetails("Brighton & Hove Albion", new Goal("1 : 0", "15", "Pascal Groß", "free kick"));
        GoalInMatchDetails match1Goal2 = new GoalInMatchDetails("Everton FC", new Goal("1 : 1", "20", "Adam Webster", "own goal"));
        GoalInMatchDetails match1Goal3 = new GoalInMatchDetails("Everton FC", new Goal("1 : 2", "74", "Dominic Calvert-Lewin", "left-footed shot", "Mason Holgate"));
        GoalInMatchDetails match1Goal4 = new GoalInMatchDetails("Brighton & Hove Albion", new Goal("2 : 2", "80", "Neal Maupay", "penalty"));
        GoalInMatchDetails match1Goal5 = new GoalInMatchDetails("Brighton & Hove Albion", new Goal("3 : 2", "90", "Lucas Digne", "own goal"));
        match1Goals.add(match1Goal1);
        match1Goals.add(match1Goal2);
        match1Goals.add(match1Goal3);
        match1Goals.add(match1Goal4);
        match1Goals.add(match1Goal5);
        ArrayList<PlayerAtMatch> match1Club1Players = new ArrayList<>();
        PlayerAtMatch match1Club1Player1 = new PlayerAtMatch("1", "Mathew Ryan", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match1Club1Player2 = new PlayerAtMatch("5", "Lewis Dunk", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match1Club1Player3 = new PlayerAtMatch("15", "Adam Webster", PlayerTypeAtMatch.Essential, null);
        PlayerEventAtMatch match1Club1Player4Event1 = new PlayerEventAtMatch("66", "out");
        ArrayList<PlayerEventAtMatch> match1Club1Player4Events = new ArrayList<>();
        match1Club1Player4Events.add(match1Club1Player4Event1);
        PlayerAtMatch match1Club1Player4 = new PlayerAtMatch("22", "Martín Montoya", PlayerTypeAtMatch.Essential, match1Club1Player4Events);
        PlayerAtMatch match1Club1Player5 = new PlayerAtMatch("33", "Dan Burn", PlayerTypeAtMatch.Essential, null);
        PlayerEventAtMatch match1Club1Player6Event1 = new PlayerEventAtMatch("33", "Yellow card");
        ArrayList<PlayerEventAtMatch> match1Club1Player6Events = new ArrayList<>();
        match1Club1Player6Events.add(match1Club1Player6Event1);
        PlayerAtMatch match1Club1Player6 = new PlayerAtMatch("6", "Dale Stephens", PlayerTypeAtMatch.Essential, match1Club1Player6Events);
        PlayerEventAtMatch match1Club1Player7Event1 = new PlayerEventAtMatch("65", "out");
        ArrayList<PlayerEventAtMatch> match1Club1Player7Events = new ArrayList<>();
        match1Club1Player7Events.add(match1Club1Player7Event1);
        PlayerAtMatch match1Club1Player7 = new PlayerAtMatch("13", "Pascal Groß", PlayerTypeAtMatch.Essential, match1Club1Player7Events);
        PlayerEventAtMatch match1Club1Player8Event1 = new PlayerEventAtMatch("90", "Yellow card");
        ArrayList<PlayerEventAtMatch> match1Club1Player8Events = new ArrayList<>();
        match1Club1Player8Events.add(match1Club1Player8Event1);
        PlayerAtMatch match1Club1Player8 = new PlayerAtMatch("24", "Davy Pröpper", PlayerTypeAtMatch.Essential, match1Club1Player8Events);
        PlayerAtMatch match1Club1Player9 = new PlayerAtMatch("46", "Steven Alzate", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match1Club1Player10 = new PlayerAtMatch("7", "Neal Maupay", PlayerTypeAtMatch.Essential, null);
        PlayerEventAtMatch match1Club1Player11Event1 = new PlayerEventAtMatch("80", "out");
        ArrayList<PlayerEventAtMatch> match1Club1Player11Events = new ArrayList<>();
        match1Club1Player11Events.add(match1Club1Player11Event1);
        PlayerAtMatch match1Club1Player11 = new PlayerAtMatch("44", "Aaron Connolly", PlayerTypeAtMatch.Essential, match1Club1Player11Events);
        PlayerEventAtMatch match1Club1Player12Event1 = new PlayerEventAtMatch("66", "in");
        ArrayList<PlayerEventAtMatch> match1Club1Player12Events = new ArrayList<>();
        match1Club1Player12Events.add(match1Club1Player12Event1);
        PlayerAtMatch match1Club1Player12 = new PlayerAtMatch("21", "Ezequiel Schelotto", PlayerTypeAtMatch.Substitute, match1Club1Player12Events);
        PlayerEventAtMatch match1Club1Player13Event1 = new PlayerEventAtMatch("65", "in");
        ArrayList<PlayerEventAtMatch> match1Club1Player13Events = new ArrayList<>();
        match1Club1Player13Events.add(match1Club1Player13Event1);
        PlayerAtMatch match1Club1Player13 = new PlayerAtMatch("11", "Leandro Trossard", PlayerTypeAtMatch.Substitute, match1Club1Player13Events);
        PlayerEventAtMatch match1Club1Player14Event1 = new PlayerEventAtMatch("80", "in");
        ArrayList<PlayerEventAtMatch> match1Club1Player14Events = new ArrayList<>();
        match1Club1Player14Events.add(match1Club1Player14Event1);
        PlayerAtMatch match1Club1Player14 = new PlayerAtMatch("17", "Glenn Murray", PlayerTypeAtMatch.Substitute, match1Club1Player14Events);
        PlayerAtMatch match1Club1Player15 = new PlayerAtMatch("27", "David Button", PlayerTypeAtMatch.Substitute, null);
        PlayerAtMatch match1Club1Player16 = new PlayerAtMatch("14", "Leon Balogun", PlayerTypeAtMatch.Substitute, null);
        PlayerAtMatch match1Club1Player17 = new PlayerAtMatch("8", "Yves Bissouma", PlayerTypeAtMatch.Substitute, null);
        PlayerAtMatch match1Club1Player18 = new PlayerAtMatch("20", "Solly March", PlayerTypeAtMatch.Substitute, null);
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
        ClubInMatchDetails match1Club1 = new ClubInMatchDetails("Brighton & Hove Albion", "Graham Potter", match1Club1Players);


        ArrayList<PlayerAtMatch> match1Club2Players = new ArrayList<>();
        PlayerAtMatch match1Club2Player1 = new PlayerAtMatch("1", "Jordan Pickford", PlayerTypeAtMatch.Essential, null);
        PlayerEventAtMatch match1Club2Player2Event1 = new PlayerEventAtMatch("86", "Yellow card");
        ArrayList<PlayerEventAtMatch> match1Club2Player2Events = new ArrayList<>();
        match1Club2Player2Events.add(match1Club2Player2Event1);
        PlayerAtMatch match1Club2Player2 = new PlayerAtMatch("2", "Mason Holgate", PlayerTypeAtMatch.Essential, match1Club2Player2Events);
        PlayerAtMatch match1Club2Player3 = new PlayerAtMatch("5", "Michael Keane", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match1Club2Player4 = new PlayerAtMatch("12", "Lucas Digne", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match1Club2Player5 = new PlayerAtMatch("19", "Djibril Sidibé", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match1Club2Player6 = new PlayerAtMatch("21", "André Gomes", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match1Club2Player7 = new PlayerAtMatch("26", "Tom Davies", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match1Club2Player8 = new PlayerAtMatch("7", "Richarlison", PlayerTypeAtMatch.Essential, null);
        ArrayList<PlayerEventAtMatch> match1Club2Player9Events = new ArrayList<>();
        PlayerEventAtMatch match1Club2Player9Event1 = new PlayerEventAtMatch("72", "out");
        match1Club2Player9Events.add(match1Club2Player9Event1);
        PlayerAtMatch match1Club2Player9 = new PlayerAtMatch("11", "Theo Walcott", PlayerTypeAtMatch.Essential, match1Club2Player9Events);
        ArrayList<PlayerEventAtMatch> match1Club2Player10Events = new ArrayList<>();
        PlayerEventAtMatch match1Club2Player10Event1 = new PlayerEventAtMatch("72", "out");
        match1Club2Player10Events.add(match1Club2Player10Event1);
        PlayerAtMatch match1Club2Player10 = new PlayerAtMatch("17", "Alex Iwobi", PlayerTypeAtMatch.Essential, match1Club2Player10Events);
        PlayerEventAtMatch match1Club2Player11Event1 = new PlayerEventAtMatch("30", "out");
        ArrayList<PlayerEventAtMatch> match1Club2Player11Events = new ArrayList<>();
        match1Club2Player11Events.add(match1Club2Player11Event1);
        PlayerAtMatch match1Club2Player11 = new PlayerAtMatch("20", "Bernard", PlayerTypeAtMatch.Essential, match1Club2Player11Events);
        PlayerEventAtMatch match1Club2Player12Event1 = new PlayerEventAtMatch("72", "in");
        ArrayList<PlayerEventAtMatch> match1Club2Player12Events = new ArrayList<>();
        match1Club2Player12Events.add(match1Club2Player12Event1);
        PlayerAtMatch match1Club2Player12 = new PlayerAtMatch("8", "Fabian Delph", PlayerTypeAtMatch.Substitute, match1Club2Player12Events);
        PlayerEventAtMatch match1Club2Player13Event1 = new PlayerEventAtMatch("30", "in");
        ArrayList<PlayerEventAtMatch> match1Club2Player13Events = new ArrayList<>();
        match1Club2Player13Events.add(match1Club2Player13Event1);
        PlayerAtMatch match1Club2Player13 = new PlayerAtMatch("10", "Gylfi Sigurðsson", PlayerTypeAtMatch.Substitute, match1Club2Player13Events);
        PlayerEventAtMatch match1Club2Player14Event1 = new PlayerEventAtMatch("72", "in");
        ArrayList<PlayerEventAtMatch> match1Club2Player14Events = new ArrayList<>();
        match1Club2Player14Events.add(match1Club2Player14Event1);
        PlayerAtMatch match1Club2Player14 = new PlayerAtMatch("9", "Dominic Calvert-Lewin", PlayerTypeAtMatch.Substitute, match1Club2Player14Events);
        PlayerAtMatch match1Club2Player15 = new PlayerAtMatch("49", "Jonas Lössl", PlayerTypeAtMatch.Substitute, null);
        PlayerAtMatch match1Club2Player16 = new PlayerAtMatch("23", "Séamus Coleman", PlayerTypeAtMatch.Substitute, null);
        PlayerAtMatch match1Club2Player17 = new PlayerAtMatch("18", "Morgan Schneiderlin", PlayerTypeAtMatch.Substitute, null);
        PlayerAtMatch match1Club2Player18 = new PlayerAtMatch("27", "Moise Kean", PlayerTypeAtMatch.Substitute, null);
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
        ClubInMatchDetails match1Club2 = new ClubInMatchDetails("Everton FC", "Marco Silva", match1Club2Players);
        ArrayList<Referee> match1Referees = new ArrayList<>();
        Referee match1Referee1 = new Referee("Andy Madley", "England", KindOfReferee.Referee);
        Referee match1Referee2 = new Referee("Edward Smart", "England", KindOfReferee.AssistantReferee);
        Referee match1Referee3 = new Referee("Derek Eaton", "England", KindOfReferee.AssistantReferee);
        match1Referees.add(match1Referee1);
        match1Referees.add(match1Referee2);
        match1Referees.add(match1Referee3);
        MatchSummary match1ExpectedSummary = new MatchSummary(match1Club1.clubBasicInfo.name, match1Club2.clubBasicInfo.name, "3:2", "Saturday, 26. October 2019", "15:00 Clock");

        MatchDetails match1ExpectedValue = new MatchDetails(match1Club1, match1Club2, match1ExpectedSummary, "Amex Stadium (Brighton / England)", "30.529", match1Referees, match1Goals);

         Assert.assertEquals(match1ExpectedValue.toString(), match1ActualValue.toString());

        MatchDetails match2ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "1946-1947", "brentford-fc", "middlesbrough-fc");
        ArrayList<PlayerAtMatch> match2Club1Players = new ArrayList<>();
        PlayerAtMatch match2Club1Player1 = new PlayerAtMatch("", "Joe Crozier", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club1Player2 = new PlayerAtMatch("", "Harry Oliver", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club1Player3 = new PlayerAtMatch("", "Roddie Munro", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club1Player4 = new PlayerAtMatch("", "George Smith", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club1Player5 = new PlayerAtMatch("", "Cyril Toulouse", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club1Player6 = new PlayerAtMatch("", "Dai Hopkins", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club1Player7 = new PlayerAtMatch("", "George Paterson", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club1Player8 = new PlayerAtMatch("", "Len Townsend", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club1Player9 = new PlayerAtMatch("", "George Stewart", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club1Player10 = new PlayerAtMatch("", "Dickie Girling", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club1Player11 = new PlayerAtMatch("", "Malky MacDonald", PlayerTypeAtMatch.Essential, null);
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
        ClubInMatchDetails match2Club1 = new ClubInMatchDetails("Brentford FC", "Jimmy Hogan", match2Club1Players);
        ArrayList<PlayerAtMatch> match2Club2Players = new ArrayList<>();
        PlayerAtMatch match2Club2Player1 = new PlayerAtMatch("", "Paddy Nash", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club2Player2 = new PlayerAtMatch("", "Bobby Stuart", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club2Player3 = new PlayerAtMatch("", "Dicky Robinson", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club2Player4 = new PlayerAtMatch("", "George Hardwick", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club2Player5 = new PlayerAtMatch("", "Harry Bell", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club2Player6 = new PlayerAtMatch("", "Geoff Walker", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club2Player7 = new PlayerAtMatch("", "Johnny Spuhler", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club2Player8 = new PlayerAtMatch("", "Jimmy Gordon", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club2Player9 = new PlayerAtMatch("", "Alec Linwood", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club2Player10 = new PlayerAtMatch("", "Micky Fenton", PlayerTypeAtMatch.Essential, null);
        PlayerAtMatch match2Club2Player11 = new PlayerAtMatch("", "Wilf Mannion", PlayerTypeAtMatch.Essential, null);
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
        ClubInMatchDetails match2Club2 = new ClubInMatchDetails("Middlesbrough FC", "David Jack", match2Club2Players);
        ArrayList<Referee> match2Referees = new ArrayList<>();
        MatchSummary match2ExpectedSummary = new MatchSummary(match2Club1.clubBasicInfo.name, match2Club2.clubBasicInfo.name, "0:0", "Saturday, 26. April 1947", null);

        MatchDetails match2ExpectedValue = new MatchDetails(match2Club1, match2Club2, match2ExpectedSummary
                , "Griffin Park (London / England)", "19.020", match2Referees, null);
        //sorting the players
        ComparePlayerNames playerComparator = new ComparePlayerNames();
        Collections.sort(match2ActualValue.firstClub.players, playerComparator);
        Collections.sort(match2ActualValue.secondClub.players, playerComparator);
        Collections.sort(match2ExpectedValue.firstClub.players, playerComparator);
        Collections.sort(match2ExpectedValue.secondClub.players, playerComparator);
        Assert.assertEquals(match2ExpectedValue.toString(), match2ActualValue.toString());


        //just to test goals with result (1:0)
        MatchDetails match3ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "Leeds-United", "Burnley-FC");

        ArrayList<GoalInMatchDetails> match3Goals = new ArrayList<>();
        GoalInMatchDetails match3Goal1 = new GoalInMatchDetails("Leeds United", new Goal("1 : 0", "5", "Patrick Bamford", "penalty"));

        match3Goals.add(match3Goal1);
        Assert.assertEquals(match3Goals.toString(), match3ActualValue.goals.toString());

        //just to test goals with result (0:1)
        MatchDetails match4ActualValue = screenScraperUnderTest.getMatchDetails("premier-league", "2020-2021", "sheffield-united", "everton-fc");

        ArrayList<GoalInMatchDetails> match4Goals = new ArrayList<>();
        GoalInMatchDetails match4Goal1 = new GoalInMatchDetails("Everton FC", new Goal("0 : 1", "80", "Gylfi Sigurðsson", "right-footed shot", "Abdoulaye Doucouré"));

        match4Goals.add(match4Goal1);
        Assert.assertEquals(match4Goals.toString(), match4ActualValue.goals.toString());


    }

    @Test
    public void itShouldGetTransferTable() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<ClubTransferTable> clubTransferTable2015_2016 = new ArrayList<>();
        
        clubTransferTable2015_2016 = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier-league", "2015-2016");
        ClubTransferTable astonVillaTransferTable2015_2016ActualValue = new ClubTransferTable();//
        astonVillaTransferTable2015_2016ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(clubTransferTable2015_2016, "Aston Villa");
        ClubTransferTable AstonVillatransferTable2015_2016_5IN5Out_ActualValue = new ClubTransferTable();
        AstonVillatransferTable2015_2016_5IN5Out_ActualValue.clubBasicInfo.name = astonVillaTransferTable2015_2016ActualValue.clubBasicInfo.name;
        AstonVillatransferTable2015_2016_5IN5Out_ActualValue.season = astonVillaTransferTable2015_2016ActualValue.season;
        for (int i = 0; i < 5; i++) {
            AstonVillatransferTable2015_2016_5IN5Out_ActualValue.intable.add(astonVillaTransferTable2015_2016ActualValue.intable.get(i));
            AstonVillatransferTable2015_2016_5IN5Out_ActualValue.outtable.add(astonVillaTransferTable2015_2016ActualValue.outtable.get(i));
        }
        //Aston Villa 2015-2016
        ClubTransferTable AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue = new ClubTransferTable();
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.clubBasicInfo.name = "Aston Villa";
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.season = "2015-2016";
        // first 5 in
        TransferPlayerInformation playerIn1 = new TransferPlayerInformation("05/16", "Lewis Kinsella", "England", "DF", "Kidderminster Harriers", "Aston Villa");
        TransferPlayerInformation playerIn2 = new TransferPlayerInformation("01/16", "Joe Cole", "England", "MF", "Coventry City", "Aston Villa");
        TransferPlayerInformation playerIn3 = new TransferPlayerInformation("01/16", "Aly Cissokho", "France", "DF", "FC Porto", "Aston Villa");
        TransferPlayerInformation playerIn4 = new TransferPlayerInformation("01/16", "Callum Robinson", "Ireland", "MF", "Bristol City", "Aston Villa");
        TransferPlayerInformation playerIn5 = new TransferPlayerInformation("11/15", "Bradley Watkins", "England", "GK", "Wolverhampton Wanderers U21", "Aston Villa");
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable.add(playerIn1);
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable.add(playerIn2);
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable.add(playerIn3);
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable.add(playerIn4);
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable.add(playerIn5);
        //first 5 out
        TransferPlayerInformation playerOut1 = new TransferPlayerInformation("03/16", "Jerell Sellars", "England", "MF", "Aston Villa", "Wycombe Wanderers");
        TransferPlayerInformation playerOut2 = new TransferPlayerInformation("02/16", "Lewis Kinsella", "England", "DF", "Aston Villa", "Kidderminster Harriers");
        TransferPlayerInformation playerOut3 = new TransferPlayerInformation("01/16", "Philippe Senderos", "Switzerland", "DF", "Aston Villa", "Grasshopper Club Zürich");
        TransferPlayerInformation playerOut4 = new TransferPlayerInformation("01/16", "Ángel Crespo", "Spain", "DF", "Aston Villa", "Rayo Vallecano");
        TransferPlayerInformation playerOut5 = new TransferPlayerInformation("01/16", "Gary Gardner", "England", "MF", "Aston Villa", "Nottingham Forest");
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable.add(playerOut1);
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable.add(playerOut2);
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable.add(playerOut3);
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable.add(playerOut4);
        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable.add(playerOut5);
        Assert.assertEquals(AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.toString(), AstonVillatransferTable2015_2016_5IN5Out_ActualValue.toString());

        ArrayList<ClubTransferTable> clubTransferTable1889_1890 = new ArrayList<>();
        clubTransferTable1889_1890 = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier-league", "1889-1890");
        ClubTransferTable AstonVillaTransferTable1889_1890ActualValue = new ClubTransferTable();
        AstonVillaTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(clubTransferTable1889_1890, "Aston Villa");
        //Aston Villa 1889-1890
        ClubTransferTable AstonVillatransferTable1889_1890ExpectedValue = new ClubTransferTable();
        AstonVillatransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Aston Villa";
        AstonVillatransferTable1889_1890ExpectedValue.season = "1889-1890";
        //  in
        TransferPlayerInformation playerIn10 = new TransferPlayerInformation("07/89", "Albert Aldridge", "England", "DF", "Swifts FC", "Aston Villa");
        TransferPlayerInformation playerIn11 = new TransferPlayerInformation("07/89", "William Dickson", "Scotland", "FW", "Sunderland AFC", "Aston Villa");
        AstonVillatransferTable1889_1890ExpectedValue.intable.add(playerIn10);
        AstonVillatransferTable1889_1890ExpectedValue.intable.add(playerIn11);
        //out
        TransferPlayerInformation playerOut10 = new TransferPlayerInformation("06/89", "Archie Goodall", "Northern Ireland", "MF", "Aston Villa", "Derby County");
        AstonVillatransferTable1889_1890ExpectedValue.outtable.add(playerOut10);
        Assert.assertEquals(AstonVillatransferTable1889_1890ExpectedValue.toString(), AstonVillaTransferTable1889_1890ActualValue.toString());

        ClubTransferTable AccringtonFCTransferTable1889_1890ActualValue = new ClubTransferTable();
        AccringtonFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(clubTransferTable1889_1890, "Accrington FC");
        //Accrington FC 1889-1890
        ClubTransferTable AccringtonFCtransferTable1889_1890ExpectedValue = new ClubTransferTable();
        AccringtonFCtransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Accrington FC";
        AccringtonFCtransferTable1889_1890ExpectedValue.season = "1889-1890";
        //out
        TransferPlayerInformation playerOut20 = new TransferPlayerInformation("06/89", "Joe Lofthouse", "England", "FW", "Accrington FC", "Blackburn Rovers");
        AccringtonFCtransferTable1889_1890ExpectedValue.outtable.add(playerOut20);
        Assert.assertEquals(AccringtonFCtransferTable1889_1890ExpectedValue.toString(), AccringtonFCTransferTable1889_1890ActualValue.toString());

        //Derby County 1889-1890
        ClubTransferTable DerbyCountyTransferTable1889_1890ActualValue = new ClubTransferTable();
        DerbyCountyTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(clubTransferTable1889_1890, "Derby County");
        ClubTransferTable DerbyCountytransferTable1889_1890ExpectedValue = new ClubTransferTable();
        DerbyCountytransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Derby County";
        DerbyCountytransferTable1889_1890ExpectedValue.season = "1889-1890";
        //  in
        TransferPlayerInformation playerIn30 = new TransferPlayerInformation("07/89", "Charlie Bunyan", "England", "GK", "Hyde FC", "Derby County");
        TransferPlayerInformation playerIn31 = new TransferPlayerInformation("07/89", "Archie Goodall", "Northern Ireland", "MF", "Aston Villa", "Derby County");
        TransferPlayerInformation playerIn32 = new TransferPlayerInformation("07/89", "John Goodall", "England", "FW", "Preston North End", "Derby County");
        DerbyCountytransferTable1889_1890ExpectedValue.intable.add(playerIn30);
        DerbyCountytransferTable1889_1890ExpectedValue.intable.add(playerIn31);
        DerbyCountytransferTable1889_1890ExpectedValue.intable.add(playerIn32);
        Assert.assertEquals(DerbyCountytransferTable1889_1890ExpectedValue.toString(), DerbyCountyTransferTable1889_1890ActualValue.toString());

        //Burnley FC 1889-1890
        ClubTransferTable BurnleyFCTransferTable1889_1890ActualValue = new ClubTransferTable();
        BurnleyFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(clubTransferTable1889_1890, "Burnley FC");
        ClubTransferTable BurnleyFCtransferTable1889_1890ExpectedValue = new ClubTransferTable();
        BurnleyFCtransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Burnley FC";
        BurnleyFCtransferTable1889_1890ExpectedValue.season = "1889-1890";
        Assert.assertEquals(BurnleyFCtransferTable1889_1890ExpectedValue.toString(), BurnleyFCTransferTable1889_1890ActualValue.toString());

    }

    @Test
    public void itShouldGetTopSoccer() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<PlayerTopSoccer> table2019_2020ActualValue = new ArrayList<>();
        table2019_2020ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "2019-2020");
        ArrayList<PlayerTopSoccer> table2019_2020player0TO4ActualValue = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            table2019_2020player0TO4ActualValue.add(table2019_2020ActualValue.get(i));
        }
        ArrayList<PlayerTopSoccer> table2019_2020player0TO4ExpectedValue = new ArrayList<>();
        PlayerTopSoccer player1 = new PlayerTopSoccer("1.", "Jamie Vardy", "England", "Leicester City", "23", "4");
        PlayerTopSoccer player2 = new PlayerTopSoccer("2.", "Pierre-Emerick Aubameyang", "Gabon", "Arsenal FC", "22", "2");
        PlayerTopSoccer player3 = new PlayerTopSoccer("2.", "Danny Ings", "England", "Southampton FC", "22", "1");
        PlayerTopSoccer player4 = new PlayerTopSoccer("4.", "Raheem Sterling", "England", "Manchester City", "20", "0");
        PlayerTopSoccer player5 = new PlayerTopSoccer("5.", "Mohamed Salah", "Egypt", "Liverpool FC", "19", "3");
        table2019_2020player0TO4ExpectedValue.add(player1);
        table2019_2020player0TO4ExpectedValue.add(player2);
        table2019_2020player0TO4ExpectedValue.add(player3);
        table2019_2020player0TO4ExpectedValue.add(player4);
        table2019_2020player0TO4ExpectedValue.add(player5);
        Assert.assertEquals(table2019_2020player0TO4ExpectedValue.toString(), table2019_2020player0TO4ActualValue.toString());

        ArrayList<PlayerTopSoccer> table2009_2010ActualValue = new ArrayList<>();
        table2009_2010ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "2009-2010");
        ArrayList<PlayerTopSoccer> table2009_2010player4TO9ActualValue = new ArrayList<>();
        for (int i = 4; i < 9; i++) {
            table2009_2010player4TO9ActualValue.add(table2009_2010ActualValue.get(i));
        }
        ArrayList<PlayerTopSoccer> table2009_2010player4TO9ExpectedValue = new ArrayList<>();
        PlayerTopSoccer player11 = new PlayerTopSoccer("5.", "Frank Lampard", "England", "Chelsea FC", "22", "10");
        PlayerTopSoccer player12 = new PlayerTopSoccer("6.", "Jermain Defoe", "England", "Tottenham Hotspur", "18", "1");
        PlayerTopSoccer player13 = new PlayerTopSoccer("6.", "Fernando Torres", "Spain", "Liverpool FC", "18", "0");
        PlayerTopSoccer player14 = new PlayerTopSoccer("8.", "Cesc Fàbregas", "Spain", "Arsenal FC", "15", "3");
        PlayerTopSoccer player15 = new PlayerTopSoccer("9.", "Emmanuel Adebayor", "Togo", "Manchester City", "14", "0");
        table2009_2010player4TO9ExpectedValue.add(player11);
        table2009_2010player4TO9ExpectedValue.add(player12);
        table2009_2010player4TO9ExpectedValue.add(player13);
        table2009_2010player4TO9ExpectedValue.add(player14);
        table2009_2010player4TO9ExpectedValue.add(player15);
        Assert.assertEquals(table2009_2010player4TO9ExpectedValue.toString(), table2009_2010player4TO9ActualValue.toString());

        ArrayList<PlayerTopSoccer> table1946_1947ActualValue = new ArrayList<>();
        table1946_1947ActualValue = screenScraperUnderTest.getTopSoccerAtSeason("eng-premier-league", "1946-1947");
        ArrayList<PlayerTopSoccer> table1946_1947player0TO4ActualValue = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            table1946_1947player0TO4ActualValue.add(table1946_1947ActualValue.get(i));
        }
        ArrayList<PlayerTopSoccer> table1946_1947player0TO4ExpectedValue = new ArrayList<>();
        PlayerTopSoccer player20 = new PlayerTopSoccer("1.", "Dennis Westcott", "England", "Wolverhampton Wanderers", "38", "0");
        PlayerTopSoccer player21 = new PlayerTopSoccer("2.", "Reg Lewis", "England", "Arsenal FC", "29", "3");
        PlayerTopSoccer player22 = new PlayerTopSoccer("2.", "Stan Mortensen", "England", "Blackpool FC", "29", "1");
        PlayerTopSoccer player23 = new PlayerTopSoccer("2.", "Duggie Reid", "Scotland", "Portsmouth FC", "29", "1");
        PlayerTopSoccer player24 = new PlayerTopSoccer("2.", "Freddie Steele", "England", "Stoke City", "29", "0");
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
        ArrayList<StatisticsGoalsPerSeason> actualValue = new ArrayList<>();
        actualValue = screenScraperUnderTest.getStatisticsGoalsPerSeason("eng-premier-league");
        ArrayList<StatisticsGoalsPerSeason> actualValue0To9 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            actualValue0To9.add(actualValue.get(i));
        }
        ArrayList<StatisticsGoalsPerSeason> expectedValue0To9 = new ArrayList<>();
        StatisticsGoalsPerSeason season0 = new StatisticsGoalsPerSeason("1", "1889/1890", "611", "132", "4.6288");
        StatisticsGoalsPerSeason season1 = new StatisticsGoalsPerSeason("2", "1888/1889", "586", "132", "4.4394");
        StatisticsGoalsPerSeason season2 = new StatisticsGoalsPerSeason("3", "1891/1892", "777", "182", "4.2692");
        StatisticsGoalsPerSeason season3 = new StatisticsGoalsPerSeason("4", "1890/1891", "554", "132", "4.1970");
        StatisticsGoalsPerSeason season4 = new StatisticsGoalsPerSeason("5", "1930/1931", "1823", "462", "3.9459");
        StatisticsGoalsPerSeason season5 = new StatisticsGoalsPerSeason("6", "1893/1894", "939", "240", "3.9125");
        StatisticsGoalsPerSeason season6 = new StatisticsGoalsPerSeason("7", "1892/1893", "936", "240", "3.9000");
        StatisticsGoalsPerSeason season7 = new StatisticsGoalsPerSeason("8", "1894/1895", "917", "240", "3.8208");
        StatisticsGoalsPerSeason season8 = new StatisticsGoalsPerSeason("9", "1927/1928", "1765", "462", "3.8203");
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
        ArrayList<StatisticsGoalsPerRound> actualValue = new ArrayList<>();
        actualValue = screenScraperUnderTest.getStatisticsGoalsPerRound("eng-premier-league");

        ArrayList<StatisticsGoalsPerRound> expectedlValue0To9 = new ArrayList<>();
        StatisticsGoalsPerRound round0 = new StatisticsGoalsPerRound("1", "1891/1892", "23. Round", "42", "6", "7.0000");
        StatisticsGoalsPerRound round1 = new StatisticsGoalsPerRound("2", "1888/1889", "8. Round", "42", "6", "7.0000");
        StatisticsGoalsPerRound round2 = new StatisticsGoalsPerRound("3", "1889/1890", "13. Round", "34", "5", "6.8000");
        StatisticsGoalsPerRound round3 = new StatisticsGoalsPerRound("4", "1888/1889", "4. Round", "40", "6", "6.6667");
        StatisticsGoalsPerRound round4 = new StatisticsGoalsPerRound("5", "1963/1964", "24. Round", "71", "11", "6.4545");

        expectedlValue0To9.add(round0);
        expectedlValue0To9.add(round1);
        expectedlValue0To9.add(round2);
        expectedlValue0To9.add(round3);
        expectedlValue0To9.add(round4);

        ArrayList<StatisticsGoalsPerRound> actualValue0To9 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            actualValue0To9.add(actualValue.get(i));
        }

        CompareStatisticsGoalsPerRound roundComparator = new CompareStatisticsGoalsPerRound();
        Collections.sort(actualValue0To9, roundComparator);
        Collections.sort(expectedlValue0To9, roundComparator);

        Assert.assertEquals(expectedlValue0To9.toString(), actualValue0To9.toString());


    }

    @Test
    public void itShouldGetStatisticsRecordWins() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue = new ArrayList<>();
        actualValue = screenScraperUnderTest.getStatisticsRecordWinsOrMostGoalInGame("eng-premier-league", StatisticsRequestKind.RecordWins);
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue0To9 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            actualValue0To9.add(actualValue.get(i));
        }
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> expectedValue0To9 = new ArrayList<>();
        StatisticsRecordWinsAndMostGoalInGame game1 = new StatisticsRecordWinsAndMostGoalInGame("1908/1909", "36. Round", "21/04/1909", "Nottingham Forest", "12:0", "Leicester Fosse");
        StatisticsRecordWinsAndMostGoalInGame game2 = new StatisticsRecordWinsAndMostGoalInGame("1891/1892", "23. Round", "04/04/1892", "West Bromwich Albion", "12:0", "Darwen");
        StatisticsRecordWinsAndMostGoalInGame game3 = new StatisticsRecordWinsAndMostGoalInGame("1891/1892", "23. Round", "12/03/1892", "Aston Villa", "12:2", "Accrington FC");
        StatisticsRecordWinsAndMostGoalInGame game4 = new StatisticsRecordWinsAndMostGoalInGame("1928/1929", "26. Round", "19/01/1929", "Sheffield United", "10:0", "Burnley FC");
        StatisticsRecordWinsAndMostGoalInGame game5 = new StatisticsRecordWinsAndMostGoalInGame("1928/1929", "11. Round", "20/10/1928", "Leicester City", "10:0", "Portsmouth FC");
        StatisticsRecordWinsAndMostGoalInGame game6 = new StatisticsRecordWinsAndMostGoalInGame("1925/1926", "1. Round", "29/08/1925", "Aston Villa", "10:0", "Burnley FC");
        StatisticsRecordWinsAndMostGoalInGame game7 = new StatisticsRecordWinsAndMostGoalInGame("1912/1913", "8. Round", "05/10/1912", "Aston Villa", "10:0", "The Wednesday FC");
        StatisticsRecordWinsAndMostGoalInGame game8 = new StatisticsRecordWinsAndMostGoalInGame("1889/1890", "1. Round", "14/09/1889", "Preston North End", "10:0", "Stoke City");
        StatisticsRecordWinsAndMostGoalInGame game9 = new StatisticsRecordWinsAndMostGoalInGame("1925/1926", "24. Round", "01/01/1926", "Sheffield United", "11:2", "Cardiff City");
        StatisticsRecordWinsAndMostGoalInGame game10 = new StatisticsRecordWinsAndMostGoalInGame("1963/1964", "24. Round", "26/12/1963", "Fulham FC", "10:1", "Ipswich Town");
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
        actualValue = screenScraperUnderTest.getStatisticsRecordWinsOrMostGoalInGame("eng-premier-league", StatisticsRequestKind.MostGoalInGame);
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> actualValue0To9 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            actualValue0To9.add(actualValue.get(i));
        }
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> expectedValue0To9 = new ArrayList<>();
        StatisticsRecordWinsAndMostGoalInGame game1 = new StatisticsRecordWinsAndMostGoalInGame("1958/1959", "12. Round", "11/10/1958", "Tottenham Hotspur", "10:4", "Everton FC");
        StatisticsRecordWinsAndMostGoalInGame game2 = new StatisticsRecordWinsAndMostGoalInGame("1891/1892", "23. Round", "12/03/1892", "Aston Villa", "12:2", "Accrington FC");
        StatisticsRecordWinsAndMostGoalInGame game3 = new StatisticsRecordWinsAndMostGoalInGame("1936/1937", "26. Round", "04/02/1937", "Stoke City", "10:3", "West Bromwich Albion");
        StatisticsRecordWinsAndMostGoalInGame game4 = new StatisticsRecordWinsAndMostGoalInGame("1933/1934", "14. Round", "18/11/1933", "Middlesbrough FC", "10:3", "Sheffield United");
        StatisticsRecordWinsAndMostGoalInGame game5 = new StatisticsRecordWinsAndMostGoalInGame("1925/1926", "24. Round", "01/01/1926", "Sheffield United", "11:2", "Cardiff City");
        StatisticsRecordWinsAndMostGoalInGame game6 = new StatisticsRecordWinsAndMostGoalInGame("1890/1891", "1. Round", "06/09/1890", "Derby County", "8:5", "Blackburn Rovers");
        StatisticsRecordWinsAndMostGoalInGame game7 = new StatisticsRecordWinsAndMostGoalInGame("1957/1958", "31. Round", "22/02/1958", "Leicester City", "8:4", "Manchester City");
        StatisticsRecordWinsAndMostGoalInGame game8 = new StatisticsRecordWinsAndMostGoalInGame("1952/1953", "10. Round", "27/09/1952", "Blackpool FC", "8:4", "Charlton Athletic");
        StatisticsRecordWinsAndMostGoalInGame game9 = new StatisticsRecordWinsAndMostGoalInGame("1934/1935", "18. Round", "08/12/1934", "Derby County", "9:3", "West Bromwich Albion");
        StatisticsRecordWinsAndMostGoalInGame game10 = new StatisticsRecordWinsAndMostGoalInGame("1931/1932", "11. Round", "17/10/1931", "Everton FC", "9:3", "Sheffield Wednesday");
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
        actualValue = screenScraperUnderTest.getStatisticsDirtiesGamesForCompetition("eng-premier-league");
        ArrayList<DirtyGame> actualValue0To9 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            actualValue0To9.add(actualValue.get(i));
        }
        ArrayList<DirtyGame> expectedValue0To9 = new ArrayList<>();
        DirtyGame game1 = new DirtyGame("01/05/1999", "West Ham United", "1:5", "Leeds United", "2", "1", "7", "15");
        DirtyGame game2 = new DirtyGame("23/10/2011", "Queens Park Rangers", "1:0", "Chelsea FC", "2", "0", "9", "15");
        DirtyGame game3 = new DirtyGame("27/09/1999", "Liverpool FC", "0:1", "Everton FC", "3", "0", "5", "14");
        DirtyGame game4 = new DirtyGame("18/09/2004", "West Bromwich Albion", "1:1", "Fulham FC", "2", "1", "6", "14");
        DirtyGame game5 = new DirtyGame("25/03/2006", "Liverpool FC", "3:1", "Everton FC", "1", "1", "9", "14");
        DirtyGame game6 = new DirtyGame("07/11/1999", "Tottenham Hotspur", "2:1", "Arsenal FC", "1", "1", "9", "14");
        DirtyGame game7 = new DirtyGame("09/02/2010", "Portsmouth FC", "1:1", "Sunderland AFC", "3", "0", "4", "13");
        DirtyGame game8 = new DirtyGame("17/02/1999", "Chelsea FC", "1:1", "Blackburn Rovers", "2", "0", "7", "13");
        DirtyGame game9 = new DirtyGame("13/09/2003", "Everton FC", "2:2", "Newcastle United", "1", "0", "10", "13");
        DirtyGame game10 = new DirtyGame("25/10/1998", "Leeds United", "0:0", "Chelsea FC", "0", "1", "11", "13");
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
        for (int i = 0; i < 10; i++) {
            actualValue0To9.add(actualValue.get(i));
        }
        ArrayList<StatisticsBestPlayerInYear> expectedValue0To9 = new ArrayList<>();
        StatisticsBestPlayerInYear game1 = new StatisticsBestPlayerInYear("2020", "Jordan Henderson");
        StatisticsBestPlayerInYear game2 = new StatisticsBestPlayerInYear("2019", "Raheem Sterling");
        StatisticsBestPlayerInYear game3 = new StatisticsBestPlayerInYear("2018", "Mohamed Salah");
        StatisticsBestPlayerInYear game4 = new StatisticsBestPlayerInYear("2017", "N'Golo Kanté");
        StatisticsBestPlayerInYear game5 = new StatisticsBestPlayerInYear("2016", "Jamie Vardy");
        StatisticsBestPlayerInYear game6 = new StatisticsBestPlayerInYear("2015", "Eden Hazard");
        StatisticsBestPlayerInYear game7 = new StatisticsBestPlayerInYear("2014", "Luis Suárez");
        StatisticsBestPlayerInYear game8 = new StatisticsBestPlayerInYear("2013", "Gareth Bale");
        StatisticsBestPlayerInYear game9 = new StatisticsBestPlayerInYear("2012", "Robin van Persie");
        StatisticsBestPlayerInYear game10 = new StatisticsBestPlayerInYear("2011", "Scott Parker");
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
    public void itShouldGetAllClubStaduimsForCompetition() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<Staduim> actualValue2020_2021 = new ArrayList<>();
        actualValue2020_2021 = screenScraperUnderTest.getCompetitionStadiums("eng-premier-league", "2020-2021");
        ArrayList<Staduim> actualValue2020_2021Just0To5 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            actualValue2020_2021Just0To5.add(actualValue2020_2021.get(i));
        }
        ArrayList<Staduim> expectedValue2020_2021Just0To5 = new ArrayList<>();
        Staduim staduim1 = new Staduim("Amex Stadium", "Brighton", "England", "30.750");
        Staduim staduim2 = new Staduim("Anfield", "Liverpool", "England", "54.074");
        Staduim staduim3 = new Staduim("Bramall Lane", "Sheffield", "England", "33.000");
        Staduim staduim4 = new Staduim("Craven Cottage", "London", "England", "25.700");
        Staduim staduim5 = new Staduim("Elland Road", "Leeds", "England", "37.890");
        expectedValue2020_2021Just0To5.add(staduim1);
        expectedValue2020_2021Just0To5.add(staduim2);
        expectedValue2020_2021Just0To5.add(staduim3);
        expectedValue2020_2021Just0To5.add(staduim4);
        expectedValue2020_2021Just0To5.add(staduim5);


        Assert.assertEquals(expectedValue2020_2021Just0To5.toString(), actualValue2020_2021Just0To5.toString());

        ArrayList<Staduim> actualValue1950_1951 = new ArrayList<>();
        actualValue1950_1951 = screenScraperUnderTest.getCompetitionStadiums("eng-championship", "1950-1951");
        ArrayList<Staduim> actualValue1950_1951Just0To5 = actualValue1950_1951;
        ArrayList<Staduim> expectedValue1950_1951Just0To5 = new ArrayList<>();
        Assert.assertEquals(expectedValue1950_1951Just0To5.toString(), actualValue1950_1951Just0To5.toString());


    }

    @Test
    public void itShouldGetMostGoalsByPlayerPerGame() {
        ScreenScraper screenScraperUnderTest = new ScreenScraper();
        ArrayList<StatisticsMostGoalsByPlayerPerGame> mostGoalsByPlayerPerGameEngPremierLeagueActualValue = new ArrayList<>();
        mostGoalsByPlayerPerGameEngPremierLeagueActualValue = screenScraperUnderTest.getStatisticsMostGoalsByPlayerInGameInCompetition("eng-premier-league");

        StatisticsMostGoalsByPlayerPerGame mostGoalsByPlayer1PerGameEngPremierLeagueExpectedValue = new StatisticsMostGoalsByPlayerPerGame(
                "Geoff Hurst", "19/10/1968", "West Ham United", "8:0", "Sunderland AFC", "6");
        Assert.assertEquals(mostGoalsByPlayer1PerGameEngPremierLeagueExpectedValue.toString(), mostGoalsByPlayerPerGameEngPremierLeagueActualValue.get(0).toString());

        StatisticsMostGoalsByPlayerPerGame mostGoalsByPlayer2PerGameEngPremierLeagueExpectedValue = new StatisticsMostGoalsByPlayerPerGame(
                "Kun Agüero", "03/10/2015", "Manchester City", "6:1", "Newcastle United", "5");
        Assert.assertEquals(mostGoalsByPlayer2PerGameEngPremierLeagueExpectedValue.toString(), mostGoalsByPlayerPerGameEngPremierLeagueActualValue.get(1).toString());

        StatisticsMostGoalsByPlayerPerGame mostGoalsByPlayer3PerGameEngPremierLeagueExpectedValue = new StatisticsMostGoalsByPlayerPerGame(
                "Heung-min Son", "20/09/2020", "Southampton FC", "2:5", "Tottenham Hotspur", "4");
        Assert.assertEquals(mostGoalsByPlayer3PerGameEngPremierLeagueExpectedValue.toString(), mostGoalsByPlayerPerGameEngPremierLeagueActualValue.get(22).toString());

    }
    //to do
    @Test
    public void itShouldGetRoundInfoSofaScore() {
        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
        sofaScoreCollectorTest.getGamesIdInRound("Premier League", "20/21", "3");
    }


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