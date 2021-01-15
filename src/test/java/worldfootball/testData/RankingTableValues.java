package worldfootball.testData;

import java.util.Arrays;
import java.util.List;

import worldfootball.models.Club;
import worldfootball.models.ClubForRankingTable;

public class RankingTableValues {

	public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague1898_1898Round18NormalExpected() {
		return  Arrays.asList(
				new ClubForRankingTable("1", new Club("Aston Villa"), "17", "12", "3", "2", "40:14", "26", "27:7"),
				new ClubForRankingTable("6", new Club("Sheffield United"), "18", "5", "10", "3", "24:24", "0", "20:16"),
				new ClubForRankingTable("16", new Club("The Wednesday FC"), "16", "5", "4", "7", "18:27", "-9", "14:18"));
	}
	public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague1955_1956Round20NormalExpected() {
			return Arrays.asList(
				new ClubForRankingTable("1",new Club("Manchester United"),"20","10","6","4","38:28","10","26:14"),
				new ClubForRankingTable("4",new Club( "Charlton Athletic"),"20","10","4","6","46:38","8","24:16"),
				new ClubForRankingTable("11",new Club("Everton FC"),"20","8","5","7","28:27","1","21:19"));
	}
	public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague2000_2001Round11NormalExpected() {
		return Arrays.asList(
				new ClubForRankingTable("1", new Club("Manchester United"), "11", "7", "3", "1", "31:8", "23", "24"),
				new ClubForRankingTable("5",new Club( "Ipswich Town"), "11", "5", "3", "3", "16:12", "4", "18"),
				new ClubForRankingTable("14", new Club("Everton FC"), "11", "3", "3", "5", "14:19", "-5", "12"));
	}
	public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague2012_2013Round14NormalExpected() {
		return Arrays.asList(
				new ClubForRankingTable("1",new Club( "Manchester United"), "14", "11", "0", "3", "33:18", "15", "33"),
				new ClubForRankingTable("2",new Club( "Manchester City"), "14", "9", "5", "0", "27:10", "17", "32"),
				new ClubForRankingTable("3",new Club( "Chelsea FC"), "14", "7", "5", "2", "24:13", "11", "26"),
				new ClubForRankingTable("4", new Club("West Bromwich Albion"), "14", "8", "2", "4", "24:18", "6", "26"),
				new ClubForRankingTable("5",new Club( "Tottenham Hotspur"), "14", "7", "2", "5", "25:23", "2", "23"),
				new ClubForRankingTable("6",new Club( "Everton FC"), "14", "5", "7", "2", "24:18", "6", "22"),
				new ClubForRankingTable("7",new Club( "Arsenal FC"), "14", "5", "6", "3", "24:14", "10", "21"),
				new ClubForRankingTable("8",new Club( "Swansea City"), "14", "5", "5", "4", "21:17", "4", "20"),
				new ClubForRankingTable("9",new Club( "Stoke City"), "14", "4", "7", "3", "13:12", "1", "19"),
				new ClubForRankingTable("10",new Club( "West Ham United"), "14", "5", "4", "5", "16:16", "0", "19"),
				new ClubForRankingTable("11",new Club( "Fulham FC"), "14", "4", "5", "5", "25:23", "2", "17"),
				new ClubForRankingTable("12",new Club( "Liverpool FC"), "14", "3", "7", "4", "18:18", "0", "16"),
				new ClubForRankingTable("13",new Club( "Sunderland AFC"), "14", "3", "7", "4", "15:16", "-1", "16"),
				new ClubForRankingTable("14",new Club( "Norwich City"), "14", "3", "7", "4", "11:20", "-9", "16"),
				new ClubForRankingTable("15", new Club("Newcastle United"), "14", "3", "5", "6", "14:21", "-7", "14"),
				new ClubForRankingTable("16",new Club( "Wigan Athletic"), "14", "4", "2", "8", "15:25", "-10", "14"),
				new ClubForRankingTable("17",new Club( "Aston Villa"), "14", "3", "4", "7", "11:22", "-11", "13"),
				new ClubForRankingTable("18",new Club( "Southampton FC"), "14", "3", "3", "8", "21:31", "-10", "12"),
				new ClubForRankingTable("19",new Club( "Reading FC"), "14", "1", "6", "7", "16:26", "-10", "9"),
				new ClubForRankingTable("20",new Club( "Queens Park Rangers"), "14", "0", "5", "9", "10:26", "-16", "5"));
	}
	public void getRankingTableEnglishPreimerLeague1955_1956Round20AwayExpected() {
		Arrays.asList(
				new ClubForRankingTable("1", new Club("Manchester United"), "20", "10", "6", "4", "38:28", "10", "26:14"),
				new ClubForRankingTable("4", new Club("Charlton Athletic"), "20", "10", "4", "6", "46:38", "8", "24:16"),
				new ClubForRankingTable("14", new Club("Newcastle United"), "20", "9", "2", "9", "43:37", "6", "20:20"));
	}
	public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague1888_1889Round10AwayExpected() {
		return  Arrays.asList(
				new ClubForRankingTable("1",new Club( "Preston North End"), "6", "5", "1", "0", "22:2", "20", "11:1"),
				new ClubForRankingTable("5",new Club( "Blackburn Rovers"), "5", "1", "2", "2", "14:14", "0", "4:6"),
				new ClubForRankingTable("11",new Club( "Notts County"), "4", "0", "0", "4", "4:18", "-14", "0:8"));
	}
	public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague2000_2001Round11AwayExpected() {
		return Arrays.asList(
				new ClubForRankingTable("1",new Club( "Ipswich Town"), "5", "3", "0", "2", "9:6", "3", "9"),
				new ClubForRankingTable("4", new Club("Manchester United"), "5", "2", "2", "1", "9:5", "4", "8"),
				new ClubForRankingTable("14",new Club( "Aston Villa"), "5", "1", "2", "2", "4:6", "-2", "5"));
	}
	public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague2018_2019Round21AwayExpected() {
		return Arrays.asList(
				new ClubForRankingTable("1",new Club( "Tottenham Hotspur"), "12", "10", "0", "2", "28:12", "16", "30"),
				new ClubForRankingTable("2",new Club( "Liverpool FC"), "11", "8", "2", "1", "22:7", "15", "26"),
				new ClubForRankingTable("18",new Club( "Cardiff City"), "10", "1", "2", "7", "6:18", "-12", "5"));
	}


	public List<ClubForRankingTable> getLastRankingTableEnglishPreimerLeague2017_2018() {
			return Arrays.asList(
					new ClubForRankingTable("2",new Club( "Manchester United"), "38", "25", "6", "7", "68:28", "40", "81"),
					new ClubForRankingTable("6",new Club( "Arsenal FC"), "38", "19", "6", "13", "74:51", "23", "63"),
					new ClubForRankingTable("19",new Club( "Stoke City"), "38", "7", "12", "19", "35:68", "-33", "33"));
	}
	public List<ClubForRankingTable> getLastRankingTableEnglishPreimerLeague2007_2008() {
		return   Arrays.asList(
				new ClubForRankingTable("1",new Club( "Manchester United"), "38", "27", "6", "5", "80:22", "58", "87"),
				new ClubForRankingTable("4", new Club("Liverpool FC"), "38", "21", "13", "4", "67:28", "39", "76"),
				new ClubForRankingTable("12",new Club( "Newcastle United"), "38", "11", "10", "17", "45:65", "-20", "43"));
	}
	public List<ClubForRankingTable> getLastRankingTableEnglishPreimerLeague1959_1960() {
		return Arrays.asList(
				new ClubForRankingTable("2",new Club( "Wolverhampton Wanderers"), "42", "24", "6", "12", "106:67", "39", "54:30"),
				new ClubForRankingTable("7", new Club("Manchester United"), "42", "19", "7", "16", "102:80", "22", "45:39"),
				new ClubForRankingTable("21", new Club("Leeds United"), "42", "12", "10", "20", "65:92", "-27", "34:50"));
	}
	public List<ClubForRankingTable> getLastRankingTableEnglishPreimerLeague1906_1907() {
		return Arrays.asList(
				new ClubForRankingTable("1",new Club( "Newcastle United"), "38", "22", "7", "9", "74:46", "28", "51:25"),
				new ClubForRankingTable("2", new Club("Bristol City"), "38", "20", "8", "10", "66:47", "19", "48:28"),
				new ClubForRankingTable("3",new Club( "Everton FC"), "38", "20", "5", "13", "70:46", "24", "45:31"),
				new ClubForRankingTable("8",new Club( "Manchester United"), "38", "17", "8", "13", "53:56", "-3", "42:34"),
				new ClubForRankingTable("12",new Club( "Blackburn Rovers"), "38", "14", "7", "17", "56:59", "-3", "35:41"),
				new ClubForRankingTable("18", new Club("Notts County"), "38", "8", "15", "15", "46:50", "-4", "31:45"));
	}
	public List<ClubForRankingTable> getLastRankingTableEnglishPreimerLeague1889_1890() {
		return Arrays.asList(
				new ClubForRankingTable("1",new Club( "Preston North End"), "22", "15", "3", "4", "71:30", "41", "33:11"),
				new ClubForRankingTable("2", new Club("Everton FC"), "22", "14", "3", "5", "65:40", "25", "31:13"),
				new ClubForRankingTable("3",new Club( "Blackburn Rovers"), "22", "12", "3", "7", "78:41", "37", "27:17"),
				new ClubForRankingTable("4",new Club( "Wolverhampton Wanderers"), "22", "10", "5", "7", "51:38", "13", "25:19"),
				new ClubForRankingTable("5",new Club( "West Bromwich Albion"), "22", "11", "3", "8", "47:50", "-3", "25:19"),
				new ClubForRankingTable("6",new Club( "Accrington FC"), "22", "9", "6", "7", "53:56", "-3", "24:20"),
				new ClubForRankingTable("7",new Club( "Derby County"), "22", "9", "3", "10", "43:55", "-12", "21:23"),
				new ClubForRankingTable("8",new Club( "Aston Villa"), "22", "7", "5", "10", "43:51", "-8", "19:25"),
				new ClubForRankingTable("9",new Club( "Bolton Wanderers"), "22", "9", "1", "12", "54:65", "-11", "19:25"),
				new ClubForRankingTable("10",new Club( "Notts County"), "22", "6", "5", "11", "43:51", "-8", "17:27"),
				new ClubForRankingTable("11", new Club("Burnley FC"), "22", "4", "5", "13", "36:65", "-29", "13:31"),
				new ClubForRankingTable("12",new Club( "Stoke City"), "22", "3", "4", "15", "27:69", "-42", "10:34"));
	}
		public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague1977_1978Round37AwayExpected() {
			return Arrays.asList(
					new ClubForRankingTable("1",new Club( "Nottingham Forest"), "18", "9", "6", "3", "28:14", "14", "24:12"),
					new ClubForRankingTable("4",new Club( "Arsenal FC"), "18", "6", "5", "7", "19:20", "-1", "17:19"),
					new ClubForRankingTable("11",new Club( "Manchester United"), "18", "5", "4", "9", "30:37", "-7", "14:22"));
		}
		public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague1891_1892Round12HomeExpected() {
			return Arrays.asList(
					new ClubForRankingTable("1",new Club( "Sunderland AFC"), "9", "9", "0", "0", "39:7", "32", "18:0"),
					new ClubForRankingTable("4",new Club( "Wolverhampton Wanderers"), "11", "7", "2", "2", "30:13", "17", "16:6"),
					new ClubForRankingTable("14",new Club( "Stoke City"), "10", "4", "0", "6", "17:15", "2", "8:12"));
		}
		public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague1925_1926Round12HomeExpected() {
			return Arrays.asList(
					new ClubForRankingTable("1",new Club( "Sunderland AFC"), "6", "6", "0", "0", "26:7", "19", "12:0"),
					new ClubForRankingTable("4",new Club( "Manchester United"), "7", "4", "2", "1", "15:6", "9", "10:4"),
					new ClubForRankingTable("14",new Club( "Burnley FC"), "6", "2", "3", "1", "10:7", "3", "7:5"));
		}
		public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague1930_1931Round8HomeExpected() {
			return Arrays.asList(
					new ClubForRankingTable("1", new Club("Arsenal FC"), "5", "4", "1", "0", "18:7", "11", "9:1"),
					new ClubForRankingTable("22", new Club("Manchester United"), "4", "0", "0", "4", "3:15", "-12", "0:8"));
		}
		public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague1948_1949Round27HomeExpected() {
			return Arrays.asList(
					new ClubForRankingTable("1",new Club( "Portsmouth FC"), "27", "15", "8", "4", "48:23", "25", "38:16"),
					new ClubForRankingTable("4",new Club( "Manchester United"), "27", "12", "9", "6", "52:28", "24", "33:21"),
					new ClubForRankingTable("14",new Club( "Burnley FC"), "27", "9", "7", "11", "32:37", "-5", "25:29"));
		}
		public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague1985_1986Round26HomeExpected() {
			return Arrays.asList(
					new ClubForRankingTable("1",new Club( "Liverpool FC"), "14", "11", "3", "0", "38:9", "29", "36"),
					new ClubForRankingTable("2",new Club( "Manchester United"), "14", "9", "4", "1", "23:5", "18", "31"),
					new ClubForRankingTable("14",new Club( "Newcastle United"), "13", "6", "3", "4", "24:21", "3", "21"));
		}
		public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague2000_2001Round11HomeExpected() {
			return Arrays.asList(
					new ClubForRankingTable("1",new Club( "Arsenal FC"), "6", "6", "0", "0", "16:4", "12", "18"),
					new ClubForRankingTable("2",new Club( "Manchester United"), "6", "5", "1", "0", "22:3", "19", "16"),
					new ClubForRankingTable("14", new Club("West Ham United"), "6", "1", "3", "2", "6:7", "-1", "6"));
		}
		public List<ClubForRankingTable> getRankingTableEnglishPreimerLeague2013_2014Round21HomeExpected() {
			return Arrays.asList(
					new ClubForRankingTable("1", new Club("Chelsea FC"), "14", "12", "2", "0", "29:9", "20", "38"),
					new ClubForRankingTable("6",new Club( "Manchester United"), "13", "6", "3", "4", "18:12", "6", "21"));
		}
}
