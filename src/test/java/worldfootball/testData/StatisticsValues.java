package worldfootball.testData;

import java.util.ArrayList;
import java.util.Arrays;

import worldfootball.models.Club;
import worldfootball.models.DirtyGame;
import worldfootball.models.Game;
import worldfootball.models.Player;
import worldfootball.models.Round;
import worldfootball.models.StatisticsBestPlayerInYear;
import worldfootball.models.StatisticsGoalsPerRound;
import worldfootball.models.StatisticsGoalsPerSeason;
import worldfootball.models.StatisticsMostGoalsByPlayerPerGame;
import worldfootball.models.StatisticsRecordWinsAndMostGoalInGame;

public class StatisticsValues {

		public ArrayList<StatisticsGoalsPerSeason> getStatististicsGoslsPerSeasonEnglishPriemerLeague() {
			return new ArrayList<>(Arrays.asList(
	        		new StatisticsGoalsPerSeason("1", "1889/1890", "611", "132", "4.6288"),
	        		new StatisticsGoalsPerSeason("2", "1888/1889", "586", "132", "4.4394"),
	        		new StatisticsGoalsPerSeason("3", "1891/1892", "777", "182", "4.2692"),
	        		new StatisticsGoalsPerSeason("4", "1890/1891", "554", "132", "4.1970"),
	        		new StatisticsGoalsPerSeason("5", "1930/1931", "1823", "462", "3.9459"),
	        		new StatisticsGoalsPerSeason("6", "1893/1894", "939", "240", "3.9125"),
	        		new StatisticsGoalsPerSeason("7", "1892/1893", "936", "240", "3.9000"),
	        		new StatisticsGoalsPerSeason("8", "1894/1895", "917", "240", "3.8208"),
	        		new StatisticsGoalsPerSeason("9", "1927/1928", "1765", "462", "3.8203")));
		}
		public ArrayList<StatisticsMostGoalsByPlayerPerGame> getStatisticEnglishPreimerLeagueMostGoalPerPlayerInGame() {
			return new ArrayList<>(Arrays.asList(
	        		new StatisticsMostGoalsByPlayerPerGame(new Player( "Geoff Hurst"),new Game( "19/10/1968",null , new Club( "West Ham United"),new Club( "Sunderland AFC"), "8:0"), "6"),
	        		new StatisticsMostGoalsByPlayerPerGame(new Player( "Kun Agüero"), new Game("03/10/2015",null , new Club( "Manchester City"), new Club("Newcastle United"), "6:1"), "5"),
	        		new StatisticsMostGoalsByPlayerPerGame(new Player( "Heung-min Son"),new Game( "20/09/2020",null , new Club( "Southampton FC"),new Club( "Tottenham Hotspur"), "2:5"), "4")));
		}
		
		public ArrayList<StatisticsGoalsPerRound> getStatisticsGoalsPerRoundEnglishPreimerLeague() {
			return new ArrayList<>(Arrays.asList(
	        		new StatisticsGoalsPerRound("2", "1888/1889",new Round( "8. Round"), "42", "6", "7.0000"),
	        		new StatisticsGoalsPerRound("1", "1891/1892",new Round( "23. Round"), "42", "6", "7.0000"),
	        		new StatisticsGoalsPerRound("3", "1889/1890",new Round(  "13. Round"), "34", "5", "6.8000"),
	        		new StatisticsGoalsPerRound("4", "1888/1889",new Round(  "4. Round"), "40", "6", "6.6667"),
	        		new StatisticsGoalsPerRound("5", "1963/1964",new Round(  "24. Round"), "71", "11", "6.4545")));
		}
		public ArrayList<StatisticsBestPlayerInYear> getStatisticsEnglishPreimerLeagueBestPlayerInYear() {
			return new ArrayList<>(Arrays.asList(
	        		new StatisticsBestPlayerInYear("2020", new Player("Jordan Henderson")),
	        		new StatisticsBestPlayerInYear("2019", new Player("Raheem Sterling")),
	        		new StatisticsBestPlayerInYear("2018", new Player("Mohamed Salah")),
	        		new StatisticsBestPlayerInYear("2017", new Player("N'Golo Kanté")),
	        		new StatisticsBestPlayerInYear("2016", new Player("Jamie Vardy")),
	        		new StatisticsBestPlayerInYear("2015", new Player("Eden Hazard")),
	        		new StatisticsBestPlayerInYear("2014", new Player("Luis Suárez")),
	        		new StatisticsBestPlayerInYear("2013", new Player("Gareth Bale")),
	        		new StatisticsBestPlayerInYear("2012", new Player("Robin van Persie")),
	        		new StatisticsBestPlayerInYear("2011", new Player("Scott Parker"))));
		}
		
		public ArrayList<DirtyGame> getStatisticsEnglishPreimerLeageDirtiesGame() {
			return new ArrayList<>(Arrays.asList(
	        		new DirtyGame(new Game ("01/05/1999",null , new Club( "West Ham United"), new Club("Leeds United"), "1:5"), "2", "1", "7", "15"),
	        		new DirtyGame(new Game ("23/10/2011",null, new Club("Queens Park Rangers"), new Club("Chelsea FC"), "1:0"), "2", "0", "9", "15"),
	        		new DirtyGame(new Game ("27/09/1999",null, new Club("Liverpool FC"),  new Club("Everton FC"),"0:1"), "3", "0", "5", "14"),
	        		new DirtyGame(new Game ("18/09/2004",null, new Club("West Bromwich Albion"), new Club( "Fulham FC"),"1:1"), "2", "1", "6", "14"),
	        		new DirtyGame(new Game ("25/03/2006",null, new Club("Liverpool FC"), new Club("Everton FC"), "3:1"),"1", "1", "9", "14"),
	        		new DirtyGame(new Game ("07/11/1999",null, new Club("Tottenham Hotspur"), new Club("Arsenal FC"),"2:1"),  "1", "1", "9", "14"),
	        		new DirtyGame(new Game ("09/02/2010",null,new Club( "Portsmouth FC"), new Club( "Sunderland AFC"), "1:1"), "3", "0", "4", "13"),
	        		new DirtyGame(new Game ("17/02/1999",null, new Club("Chelsea FC"), new Club("Blackburn Rovers"),"1:1"), "2", "0", "7", "13"),
	        		new DirtyGame(new Game ("13/09/2003", null,new Club("Everton FC"),new Club( "Newcastle United"), "2:2" ),"1", "0", "10", "13"),
	        		new DirtyGame(new Game ("25/10/1998",null, new Club("Leeds United"),new Club( "Chelsea FC"), "0:0" ),"0", "1", "11", "13")));
		}
		
		public ArrayList<StatisticsRecordWinsAndMostGoalInGame> getStatisticsEnglishPreimerLeagueMostGoalInGame() {
			return new ArrayList<>(Arrays.asList(
	        		new StatisticsRecordWinsAndMostGoalInGame("1958/1959", new Round("12. Round"), new Game ("11/10/1958",null, new Club( "Tottenham Hotspur"), new Club( "Everton FC"), "10:4")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1891/1892", new Round("23. Round"), new Game ("12/03/1892",null, new Club("Aston Villa"), new Club( "Accrington FC"), "12:2")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1936/1937", new Round("26. Round"), new Game ("04/02/1937",null, new Club("Stoke City"), new Club("West Bromwich Albion"), "10:3")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1933/1934",new Round( "14. Round"), new Game ("18/11/1933",null,new Club( "Middlesbrough FC"), new Club("Sheffield United"), "10:3")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1925/1926", new Round("24. Round"), new Game ("01/01/1926",null, new Club("Sheffield United"), new Club("Cardiff City"), "11:2")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1890/1891", new Round("1. Round"),  new Game ("06/09/1890",null, new Club("Derby County"), new Club("Blackburn Rovers"), "8:5")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1957/1958", new Round("31. Round"),new Game ( "22/02/1958",null, new Club("Leicester City"), new Club("Manchester City"), "8:4")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1952/1953", new Round("10. Round"),new Game ( "27/09/1952",null, new Club("Blackpool FC"),new Club( "Charlton Athletic"), "8:4")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1934/1935", new Round("18. Round"), new Game ("08/12/1934",null, new Club("Derby County"), new Club("West Bromwich Albion"), "9:3")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1931/1932", new Round("11. Round"), new Game ("17/10/1931",null, new Club("Everton FC"), new Club("Sheffield Wednesday"), "9:3"))));
		}

		public ArrayList<StatisticsRecordWinsAndMostGoalInGame> getStatisticsEnglishPreimerLeagueRecoedWin() {
			return new ArrayList<>(Arrays.asList(
	        		new StatisticsRecordWinsAndMostGoalInGame("1908/1909", new Round("36. Round"), new Game ("21/04/1909",null, new Club("Nottingham Forest"),new Club( "Leicester Fosse"), "12:0")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1891/1892", new Round("23. Round"), new Game ("04/04/1892",null, new Club("West Bromwich Albion"), new Club("Darwen"), "12:0")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1891/1892", new Round("23. Round"), new Game ("12/03/1892",null, new Club("Aston Villa"), new Club("Accrington FC"), "12:2")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1928/1929", new Round("26. Round"), new Game ("19/01/1929",null, new Club("Sheffield United"), new Club("Burnley FC"), "10:0")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1928/1929", new Round("11. Round"), new Game ("20/10/1928", null,new Club("Leicester City"), new Club("Portsmouth FC"), "10:0")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1925/1926", new Round("1. Round"), new Game ("29/08/1925",null, new Club("Aston Villa"), new Club("Burnley FC"), "10:0")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1912/1913", new Round("8. Round"), new Game ("05/10/1912",null, new Club("Aston Villa"), new Club("The Wednesday FC"), "10:0")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1889/1890", new Round("1. Round"), new Game ("14/09/1889",null, new Club("Preston North End"), new Club("Stoke City"), "10:0")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1925/1926", new Round("24. Round"),new Game ( "01/01/1926",null,new Club( "Sheffield United"), new Club("Cardiff City"), "11:2")),
	        		new StatisticsRecordWinsAndMostGoalInGame("1963/1964", new Round("24. Round"), new Game ("26/12/1963",null, new Club("Fulham FC"), new Club("Ipswich Town"), "10:1"))));
		}

	}


