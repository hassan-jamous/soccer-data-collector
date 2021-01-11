package testValues;

import java.util.ArrayList;
import java.util.Arrays;
import models.PlayerTopScoreForSeason;
import models.PlayerTopSoccer;

public class WorldFootballWorldFootballTopScoreAndTopScoreForCompetitionAllYearsValue {

		public ArrayList<PlayerTopScoreForSeason> getTopScoerForEnglishPreimerLeagueAllYears() {
			return new ArrayList<>(Arrays.asList(
	    			new PlayerTopScoreForSeason("2019/2020" , "England","Jamie Vardy",                "Leicester City","23"),
	    			new PlayerTopScoreForSeason("2018/2019" , "Senegal","Sadio Mané" ,                "Liverpool FC",  "22"),
	    			new PlayerTopScoreForSeason("2018/2019" , "Gabon",  "Pierre-Emerick Aubameyang",  "Arsenal FC",    "22"),
	    			new PlayerTopScoreForSeason("2018/2019" , "Egypt",  "Mohamed Salah", 	          "Liverpool FC",  "22"),
	    			new PlayerTopScoreForSeason("2017/2018" , "Egypt", 	"Mohamed Salah", 	 	      "Liverpool FC",  "32"),
	    			new PlayerTopScoreForSeason("2016/2017" , "England","Harry Kane", 	              "Tottenham Hotspur","29"),
	    			new PlayerTopScoreForSeason("2012/2013" , "Netherlands","Robin van Persie", 	"Manchester United","26")));
		}

		public ArrayList<PlayerTopSoccer> getTableTopScore2019_2020() {
			return new ArrayList<>(Arrays.asList(
	        		new PlayerTopSoccer("1.", "Jamie Vardy", "England", "Leicester City", "23", "4"),
	        		new PlayerTopSoccer("2.", "Pierre-Emerick Aubameyang", "Gabon", "Arsenal FC", "22", "2"),
	        		new PlayerTopSoccer("2.", "Danny Ings", "England", "Southampton FC", "22", "1"),
	        		new PlayerTopSoccer("4.", "Raheem Sterling", "England", "Manchester City", "20", "0"),
	        		new PlayerTopSoccer("5.", "Mohamed Salah", "Egypt", "Liverpool FC", "19", "3")));
		}
		public ArrayList<PlayerTopSoccer> getTopScoreEngishPriemerLeague1946_1947() {
			return new ArrayList<>(Arrays.asList(
	        		new PlayerTopSoccer("1.", "Dennis Westcott", "England", "Wolverhampton Wanderers", "38", "0"),
	        		new PlayerTopSoccer("2.", "Reg Lewis", "England", "Arsenal FC", "29", "3"),
	        		new PlayerTopSoccer("2.", "Stan Mortensen", "England", "Blackpool FC", "29", "1"),
	        		new PlayerTopSoccer("2.", "Duggie Reid", "Scotland", "Portsmouth FC", "29", "1"),
	        		new PlayerTopSoccer("2.", "Freddie Steele", "England", "Stoke City", "29", "0")));
		}

		public ArrayList<PlayerTopSoccer> getTopScoreEnglishPreimerLeague2009_2010() {
			return new ArrayList<>(Arrays.asList(
	        		new PlayerTopSoccer("5.", "Frank Lampard", "England", "Chelsea FC", "22", "10"),
	        		new PlayerTopSoccer("6.", "Jermain Defoe", "England", "Tottenham Hotspur", "18", "1"),
	        		new PlayerTopSoccer("6.", "Fernando Torres", "Spain", "Liverpool FC", "18", "0"),
	        		new PlayerTopSoccer("8.", "Cesc Fàbregas", "Spain", "Arsenal FC", "15", "3"),
	        		new PlayerTopSoccer("9.", "Emmanuel Adebayor", "Togo", "Manchester City", "14", "0")));
		}

	}


