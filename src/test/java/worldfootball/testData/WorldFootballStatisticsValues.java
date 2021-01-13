package worldfootball.testData;

import java.util.ArrayList;
import java.util.Arrays;
import worldfootball.models.DirtyGame;
import worldfootball.models.StatisticsBestPlayerInYear;
import worldfootball.models.StatisticsGoalsPerRound;
import worldfootball.models.StatisticsGoalsPerSeason;
import worldfootball.models.StatisticsMostGoalsByPlayerPerGame;
import worldfootball.models.StatisticsRecordWinsAndMostGoalInGame;
public class WorldFootballStatisticsValues {



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
	        		new StatisticsMostGoalsByPlayerPerGame( "Geoff Hurst", "19/10/1968", "West Ham United", "8:0", "Sunderland AFC", "6"),
	        		new StatisticsMostGoalsByPlayerPerGame( "Kun Agüero", "03/10/2015", "Manchester City", "6:1", "Newcastle United", "5"),
	        		new StatisticsMostGoalsByPlayerPerGame( "Heung-min Son", "20/09/2020", "Southampton FC", "2:5", "Tottenham Hotspur", "4")));
		}
		
		public ArrayList<StatisticsGoalsPerRound> getStatisticsGoalsPerRoundEnglishPreimerLeague() {
			return new ArrayList<>(Arrays.asList(
	        		new StatisticsGoalsPerRound("1", "1891/1892", "23. Round", "42", "6", "7.0000"),
	        		new StatisticsGoalsPerRound("2", "1888/1889", "8. Round", "42", "6", "7.0000"),
	        		new StatisticsGoalsPerRound("3", "1889/1890", "13. Round", "34", "5", "6.8000"),
	        		new StatisticsGoalsPerRound("4", "1888/1889", "4. Round", "40", "6", "6.6667"),
	        		new StatisticsGoalsPerRound("5", "1963/1964", "24. Round", "71", "11", "6.4545")));
		}
		public ArrayList<StatisticsBestPlayerInYear> getStatisticsEnglishPreimerLeagueBestPlayerInYear() {
			return new ArrayList<>(Arrays.asList(
	        		new StatisticsBestPlayerInYear("2020", "Jordan Henderson"),
	        		new StatisticsBestPlayerInYear("2019", "Raheem Sterling"),
	        		new StatisticsBestPlayerInYear("2018", "Mohamed Salah"),
	        		new StatisticsBestPlayerInYear("2017", "N'Golo Kanté"),
	        		new StatisticsBestPlayerInYear("2016", "Jamie Vardy"),
	        		new StatisticsBestPlayerInYear("2015", "Eden Hazard"),
	        		new StatisticsBestPlayerInYear("2014", "Luis Suárez"),
	        		new StatisticsBestPlayerInYear("2013", "Gareth Bale"),
	        		new StatisticsBestPlayerInYear("2012", "Robin van Persie"),
	        		new StatisticsBestPlayerInYear("2011", "Scott Parker")));
		}

		
		public ArrayList<DirtyGame> getStatisticsEnglishPreimerLeageDirtiesGame() {
			return new ArrayList<>(Arrays.asList(
	        		new DirtyGame("01/05/1999", "West Ham United", "1:5", "Leeds United", "2", "1", "7", "15"),
	        		new DirtyGame("23/10/2011", "Queens Park Rangers", "1:0", "Chelsea FC", "2", "0", "9", "15"),
	        		new DirtyGame("27/09/1999", "Liverpool FC", "0:1", "Everton FC", "3", "0", "5", "14"),
	        		new DirtyGame("18/09/2004", "West Bromwich Albion", "1:1", "Fulham FC", "2", "1", "6", "14"),
	        		new DirtyGame("25/03/2006", "Liverpool FC", "3:1", "Everton FC", "1", "1", "9", "14"),
	        		new DirtyGame("07/11/1999", "Tottenham Hotspur", "2:1", "Arsenal FC", "1", "1", "9", "14"),
	        		new DirtyGame("09/02/2010", "Portsmouth FC", "1:1", "Sunderland AFC", "3", "0", "4", "13"),
	        		new DirtyGame("17/02/1999", "Chelsea FC", "1:1", "Blackburn Rovers", "2", "0", "7", "13"),
	        		new DirtyGame("13/09/2003", "Everton FC", "2:2", "Newcastle United", "1", "0", "10", "13"),
	        		new DirtyGame("25/10/1998", "Leeds United", "0:0", "Chelsea FC", "0", "1", "11", "13")));
		}
		
		public ArrayList<StatisticsRecordWinsAndMostGoalInGame> getStatisticsEnglishPreimerLeagueMostGoalInGame() {
			return new ArrayList<>(Arrays.asList(
	        		new StatisticsRecordWinsAndMostGoalInGame("1958/1959", "12. Round", "11/10/1958", "Tottenham Hotspur", "10:4", "Everton FC"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1891/1892", "23. Round", "12/03/1892", "Aston Villa", "12:2", "Accrington FC"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1936/1937", "26. Round", "04/02/1937", "Stoke City", "10:3", "West Bromwich Albion"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1933/1934", "14. Round", "18/11/1933", "Middlesbrough FC", "10:3", "Sheffield United"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1925/1926", "24. Round", "01/01/1926", "Sheffield United", "11:2", "Cardiff City"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1890/1891", "1. Round", "06/09/1890", "Derby County", "8:5", "Blackburn Rovers"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1957/1958", "31. Round", "22/02/1958", "Leicester City", "8:4", "Manchester City"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1952/1953", "10. Round", "27/09/1952", "Blackpool FC", "8:4", "Charlton Athletic"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1934/1935", "18. Round", "08/12/1934", "Derby County", "9:3", "West Bromwich Albion"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1931/1932", "11. Round", "17/10/1931", "Everton FC", "9:3", "Sheffield Wednesday")));
		}

		public ArrayList<StatisticsRecordWinsAndMostGoalInGame> getStatisticsEnglishPreimerLeagueRecoedWin() {
			return new ArrayList<>(Arrays.asList(
	        		new StatisticsRecordWinsAndMostGoalInGame("1908/1909", "36. Round", "21/04/1909", "Nottingham Forest", "12:0", "Leicester Fosse"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1891/1892", "23. Round", "04/04/1892", "West Bromwich Albion", "12:0", "Darwen"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1891/1892", "23. Round", "12/03/1892", "Aston Villa", "12:2", "Accrington FC"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1928/1929", "26. Round", "19/01/1929", "Sheffield United", "10:0", "Burnley FC"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1928/1929", "11. Round", "20/10/1928", "Leicester City", "10:0", "Portsmouth FC"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1925/1926", "1. Round", "29/08/1925", "Aston Villa", "10:0", "Burnley FC"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1912/1913", "8. Round", "05/10/1912", "Aston Villa", "10:0", "The Wednesday FC"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1889/1890", "1. Round", "14/09/1889", "Preston North End", "10:0", "Stoke City"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1925/1926", "24. Round", "01/01/1926", "Sheffield United", "11:2", "Cardiff City"),
	        		new StatisticsRecordWinsAndMostGoalInGame("1963/1964", "24. Round", "26/12/1963", "Fulham FC", "10:1", "Ipswich Town")));
		}

	}


