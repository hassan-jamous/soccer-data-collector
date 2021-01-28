package worldfootball.testData;

import java.util.ArrayList;
import java.util.Arrays;
import worldfootball.models.Club;
import worldfootball.models.Player;
import worldfootball.models.PlayerAllInformation;
import worldfootball.models.PlayerClubCareer;
import worldfootball.models.PlayerCompetitionInformation;
import worldfootball.models.PlayerCompetitionInformationOverall;
import worldfootball.models.PlayerOpponentRecordInformation;
import worldfootball.models.PlayerPersonalInformation;
import worldfootball.models.PlayerRefereeRecordInformation;
import worldfootball.models.PlayerTeamManaged;
import worldfootball.models.Referee;

public class PlayerAllInformationValues {

		public PlayerAllInformation getEricBaillyInformation() {
			PlayerAllInformation player1ExpectedValueInfo = new PlayerAllInformation();
		    player1ExpectedValueInfo.personalInfo = new PlayerPersonalInformation(new Player("Eric Bailly"),"Eric Bertrand Bailly",
		            "12.04.1994", "Bingerville, Ivory Coast", new  ArrayList<String>(Arrays.asList("Ivory Coast")), "187 cm",
		            "77 kg",new  ArrayList<String>(Arrays.asList( "Centre Back")), "right");
		    player1ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
		    		new PlayerClubCareer("07/2016 - 06/2022", new Club("Manchester United"), "England", "Defender", "#3"),
		    		new PlayerClubCareer("01/2020 - 01/2020", new Club("Manchester United U23"), "England", "Defender", null),
		    		new PlayerClubCareer("01/2017 - 01/2017", new Club("Manchester United U23"), "England", "Defender", null),
		    		new PlayerClubCareer("01/2015 - 06/2016", new Club("Villarreal CF"), "Spain", "Defender", null),
		    		new PlayerClubCareer("09/2014 - 01/2015", new Club("Espanyol Barcelona"), "Spain", "Defender", null),
		    		new PlayerClubCareer("03/2013 - 01/2015", new Club("Espanyol Barcelona B"), "Spain", "Defender", null),
		    		new PlayerClubCareer("07/2012 - 06/2013", new Club("Espanyol Barcelona [Youth]"), "Spain", "Defender", null)));
		    player1ExpectedValueInfo.clubMatches = new ArrayList<>(Arrays.asList(
		    		new PlayerCompetitionInformation( "UEFA","Champions League", "7", "0", "7", "0", "1", "2", "0", "0"),
		    		new PlayerCompetitionInformation( "UEFA","Europa League", "24", "1", "24", "0", "2", "4", "2", "1"),
		    		new PlayerCompetitionInformation("England","Premier League", "61", "1", "50", "11", "5", "8", "0", "1"),
		    		new PlayerCompetitionInformation( "England","FA Cup", "7", "0", "6", "1", "3", "1", "0", "0"),
		    		new PlayerCompetitionInformation( "England", "League Cup","5", "0", "5", "0", "0", "0", "0", "0"),
		    		new PlayerCompetitionInformation( "England","FA Community Shield", "1", "0", "1", "0", "0", "1", "0", "0"),
		    		new PlayerCompetitionInformation( "England", "U23 Premier League Div. 1","1", "0", "1", "0", "1", "0", "0", "0"),
		    		new PlayerCompetitionInformation( "England","U23 Premier League Div. 2", "1", "0", "1", "0", "1", "0", "0", "0"),
		    		new PlayerCompetitionInformation( "Spanien","Primera División", "40", "0", "39", "1", "10", "15", "1", "0"),
		    		new PlayerCompetitionInformation("Spanien","Copa del Rey",  "3", "0", "3", "0", "0", "2", "0", "0"),
		    		new PlayerCompetitionInformation( "Spanien","Segunda B Grupo 3", "22", "0", "19", "3", "2", "6",  "1", "0"),
		    		new PlayerCompetitionInformation(null,            "∑"  ,    "172", "2","156", "16","25","39", "4", "2")));
		    player1ExpectedValueInfo.clubsMatchesOverall = new ArrayList<>(Arrays.asList(
		    		new PlayerCompetitionInformationOverall( "2020/2021", new Club("Manchester United"), new PlayerCompetitionInformation("England", "Pr. League", "7", "0", "6", "1", "0", "2", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2020/2021", new Club("Manchester United"),new PlayerCompetitionInformation("England", "FA Cup", "1", "0", "1", "0", "1", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2020/2021", new Club("Manchester United"),new PlayerCompetitionInformation("England", "League Cup", "3", "0", "3", "0", "0", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2019/2020",new Club( "Manchester United"), new PlayerCompetitionInformation("UEFA", "EL","4", "0", "4", "0", "1", "1", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2019/2020",new Club( "Manchester United"), new PlayerCompetitionInformation("England", "FA Cup","3", "0", "3", "0", "2", "1", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2019/2020", new Club("Manchester United"), new PlayerCompetitionInformation("England", "Pr. League","4", "0", "1", "3", "0", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2019/2020",new Club( "Manchester United U23"),new PlayerCompetitionInformation("England", "U23 PL Div.2", "1", "0", "1", "0", "1", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall("2018/2019", new Club("Manchester United"),new PlayerCompetitionInformation("England", "Pr. League",  "12", "0", "8", "4", "2", "0", "0", "1")),
		    		new PlayerCompetitionInformationOverall( "2018/2019", new Club("Manchester United"),new PlayerCompetitionInformation( "UEFA", "Ch. League","4", "0", "4", "0", "1", "1", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2018/2019", new Club("Manchester United"),new PlayerCompetitionInformation( "England", "FA Cup","1", "0", "1", "0", "0", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2018/2019", new Club("Manchester United"),new PlayerCompetitionInformation("England", "League Cup", "1", "0", "1", "0", "0", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2017/2018", new Club("Manchester United"),new PlayerCompetitionInformation("England", "Pr. League", "13", "1", "11", "2", "0", "2", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2017/2018",new Club( "Manchester United"),new PlayerCompetitionInformation( "England", "FA Cup","2", "0", "1", "1", "0", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2017/2018",new Club( "Manchester United"),new PlayerCompetitionInformation( "UEFA", "Ch. League","3", "0", "3", "0", "0", "1", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2016/2017",new Club( "Manchester United"),new PlayerCompetitionInformation( "England", "Pr. League","25", "0", "24", "1", "3", "4", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2016/2017",new Club( "Manchester United"),new PlayerCompetitionInformation("UEFA", "EL", "11", "0", "11", "0", "0", "2", "1", "1")),
		    		new PlayerCompetitionInformationOverall( "2016/2017", new Club("Manchester United"),new PlayerCompetitionInformation( "England", "League Cup","1", "0", "1", "0", "0", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2016/2017",new Club( "Manchester United U23"),new PlayerCompetitionInformation("England", "U23 PL Div.1", "1", "0", "1", "0", "1", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall("2016",new Club( "Manchester United"),new PlayerCompetitionInformation( "England", "Com. Shield", "1", "0", "1", "0", "0", "1", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2015/2016", new Club("Villarreal CF"), new PlayerCompetitionInformation("Spanien", "Pr. División","25", "0", "25", "0", "6", "9", "1", "0")),
		    		new PlayerCompetitionInformationOverall( "2015/2016", new Club("Villarreal CF"),new PlayerCompetitionInformation("UEFA", "EL", "7", "1", "7", "0", "1", "1", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2015/2016", new Club("Villarreal CF"), new PlayerCompetitionInformation("Spanien", "Copa del Rey","3", "0", "3", "0", "0", "2", "0", "0")),
		    		new PlayerCompetitionInformationOverall("2014/2015",new Club( "Villarreal CF"), new PlayerCompetitionInformation("Spanien", "Pr. División", "10", "0", "10", "0", "3", "5", "0", "0")),
		    		new PlayerCompetitionInformationOverall("2014/2015",new Club( "Villarreal CF"),new PlayerCompetitionInformation("UEFA", "EL",  "2", "0", "2", "0", "0", "0", "1", "0")),
		    		new PlayerCompetitionInformationOverall( "2014/2015",new Club( "Espanyol Barcelona"),new PlayerCompetitionInformation("Spanien", "Pr. División", "5", "0", "4", "1", "1", "1", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2014/2015",new Club( "Espanyol Barcelona B"),new PlayerCompetitionInformation("Spanien", "2ª B G3", "1", "0", "1", "0", "0", "1", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2013/2014",new Club( "Espanyol Barcelona B"),new PlayerCompetitionInformation("Spanien", "2ª B G3", "21", "0", "18", "3", "2", "5", "1", "0"))));
		    player1ExpectedValueInfo.internationalCopmetitionsOverall = new ArrayList<>(Arrays.asList(
		    		new PlayerCompetitionInformationOverall( "2020", new Club("Ivory Coast"), new PlayerCompetitionInformation("FIFA", "Friendlies","2", "0", "2", "0", "1", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2018", new Club("Ivory Coast"), new PlayerCompetitionInformation("FIFA", "Friendlies","2", "0", "2", "0", "0", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2017-2019",new Club( "Ivory Coast"),new PlayerCompetitionInformation( "CAF", "Afr. Cup QF","5", "2", "5", "0", "1", "1", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2017 Gabun",new Club( "Ivory Coast"),new PlayerCompetitionInformation( "CAF", "Africa Cup","3", "0", "3", "0", "0", "1", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2017", new Club("Ivory Coast"),new PlayerCompetitionInformation("FIFA", "Friendlies", "4", "0", "3", "1", "0", "1", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2016", new Club("Ivory Coast"),new PlayerCompetitionInformation("FIFA", "Friendlies", "1", "0", "1", "0", "0", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2015/2016", new Club("Ivory Coast"),new PlayerCompetitionInformation("CAF", "Afr. Cup QF", "4", "0", "4", "0", "1", "0", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2015-2017", new Club("Ivory Coast"),new PlayerCompetitionInformation("FIFA", "WCQ Africa", "4", "0", "4", "0", "0", "2", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2015 Equatorial Guinea", new Club("Ivory Coast"),new PlayerCompetitionInformation("CAF", "Africa Cup", "6", "0", "6", "0", "1", "2", "0", "0")),
		    		new PlayerCompetitionInformationOverall( "2015",new Club( "Ivory Coast"), new PlayerCompetitionInformation("FIFA", "Friendlies","5", "0", "5", "0", "1", "0", "0", "0"))));
		    player1ExpectedValueInfo.internationalCopmetitionsInfo = new ArrayList<>(Arrays.asList(
		    		new PlayerCompetitionInformation( "FIFA","WC Qualifiers Africa", "4", "0", "4", "0", "0", "2", "0", "0"),
		    		new PlayerCompetitionInformation( "FIFA", "Friendlies","14", "0", "13", "1", "2", "1", "0", "0"),
		    		new PlayerCompetitionInformation( "CAF","Africa Cup", "9", "0", "9", "0", "1", "3", "0", "0"),
		    		new PlayerCompetitionInformation( "CAF","Africa Cup Qual.", "9", "2", "9", "0", "2", "1", "0", "0"),
		    		new PlayerCompetitionInformation(null, "∑", "36", "2", "35", "1", "5", "7", "0", "0")));       
		    
		    player1ExpectedValueInfo.recordOpponent = new ArrayList<>(Arrays.asList(
		    		new PlayerOpponentRecordInformation(new Club("Chelsea FC"),"7","3","1","3","0","1","0","0"),
		    		new PlayerOpponentRecordInformation(new Club("Liverpool FC"),"4","2","1","1","0","1","0","0"),
		    		new PlayerOpponentRecordInformation(new Club("Real Madrid"),"3","1","1","1","0","2","0","0"),
		    		new PlayerOpponentRecordInformation(new Club("SD Eibar"),"3","2","1","0","0","0","0","0"),
		    		new PlayerOpponentRecordInformation(new Club("Middlesbrough FC"),"2","2","0","0","0","0","0","0"),
		    		new PlayerOpponentRecordInformation(new Club("Belgium"),"1","0","1","0","0","0","0","0"),
		    		new PlayerOpponentRecordInformation(new Club("Japan"),"1","0","0","1","0","0","0","0"),
		    		new PlayerOpponentRecordInformation(new Club("Sporting Gijón"),"1","0","0","1","0","0","0","0"),
		    		new PlayerOpponentRecordInformation(new Club("Wolverhampton Wanderers"),"1","1","0","0","0","0","0","0")));
		    
		    player1ExpectedValueInfo.recordReferee = new ArrayList<>(Arrays.asList(
		    		new PlayerRefereeRecordInformation(new Referee("Jonathan Moss","England"),"10","7","2","1","1","1","0","0"),
		    		new PlayerRefereeRecordInformation(new Referee("Carlos Velasco Carballo","Spain"),"3","1","0","2","0","2","0","0"),
		    		new PlayerRefereeRecordInformation(new Referee("Alex Muhabi",           "Uganda"),"1","1","0","0","1","0","0","0"),
		    		new PlayerRefereeRecordInformation(new Referee("Jorge Díaz Escudero","Spain"),"1","1","0","0","0","0","0","0"),
		    		new PlayerRefereeRecordInformation(new Referee("Pavel Královec","Czech Republic"),"1","1","0","0","0","0","0","0"),
		    		new PlayerRefereeRecordInformation(new Referee("José Teixeira Vitienes","Spain"),"1","0","1","0","0","1","0","0"),
		    		new PlayerRefereeRecordInformation(new Referee("Slavko Vinčić","Slovenia"),"1","0","1","0","0","0","0","0")));
		    player1ExpectedValueInfo.teamsManaged = null;
		    
		    player1ExpectedValueInfo.forEachCompetitionInformationOverallsClubs  = new ArrayList<PlayerCompetitionInformationOverall>(Arrays.asList(
					new PlayerCompetitionInformationOverall("2019/2020",new Club("Manchester United"),new PlayerCompetitionInformation("UEFA","EL","4","0","4","0","1","1","0","0")),
					new PlayerCompetitionInformationOverall("2016/2017",new Club("Manchester United"),new PlayerCompetitionInformation("UEFA","EL","11","0","11","0","0","2","1","1"))));

		    return player1ExpectedValueInfo;
		}

	    
		public PlayerAllInformation getTonyAdamsInformation() {

	    //https://www.worldfootball.net/player_summary/tony-adams/
	    PlayerAllInformation player2ExpectedValueInfo = new PlayerAllInformation();

	    player2ExpectedValueInfo.personalInfo = new PlayerPersonalInformation(new Player("Tony Adams"), "Anthony Alexander Adams",
	            "10.10.1966", "Romford, England",new  ArrayList<String>(Arrays.asList( "England")), "191 cm", "87 kg", 
	            new  ArrayList<String>(Arrays.asList("Centre Back")), "right");
	    player2ExpectedValueInfo.teamsManaged = new ArrayList<>(Arrays.asList(
	    		new PlayerTeamManaged("04/2017 - 06/2017",new Club( "Granada CF"), "Spain", "Manager"),
	    		new PlayerTeamManaged("07/2010 - 06/2012",new Club( "Gabala FK"), "Azerbaijan", "Manager"),
	    		new PlayerTeamManaged("10/2008 - 02/2009", new Club("Portsmouth FC"), "England", "Manager")));
	    player2ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
	    		new PlayerClubCareer("07/1983 - 06/2002",new Club( "Arsenal FC"), "England", "Defender", null),
	    		new PlayerClubCareer("07/1982 - 06/1983",new Club( "Arsenal FC [U18]"), "England", "Defender", null)));
	    player2ExpectedValueInfo.clubMatches = new ArrayList<>(Arrays.asList(
	    		new PlayerCompetitionInformation(  "UEFA","Champions League","21", "1", "21", "0", "1", "3", "0", "0"),
	    		new PlayerCompetitionInformation(  "UEFA","Europa League","9", "0", "9", "0", "2", "2", "0", "0"),
	    		new PlayerCompetitionInformation( "UEFA","UEFA Super Cup", "2", "0", "2", "0", "0", "0", "0", "0"),
	    		new PlayerCompetitionInformation( "UEFA","Cup Winners Cup", "16", "2", "16", "0", "0", "2", "0", "0"),
	    		new PlayerCompetitionInformation( "England","Premier League", "504", "32", "500", "4", "19", "37", "1", "4"),
	    		new PlayerCompetitionInformation(  "England","FA Cup","33", "7", "32", "1", "0", "2", "0", "0"),
	    		new PlayerCompetitionInformation( "England", "League Cup","17", "3", "17", "0", "0", "1", "0", "0"),
	    		new PlayerCompetitionInformation( "England","FA Community Shield", "4", "0", "4", "0", "1", "0", "0", "0"),
	    		new PlayerCompetitionInformation (null, "∑","606", "45", "601", "5", "23", "47", "1", "4")));
	    player2ExpectedValueInfo.internationalCopmetitionsInfo = new ArrayList<>(Arrays.asList(
	    		new PlayerCompetitionInformation( "FIFA","World Cup", "4", "0", "4", "0", "0", "0", "0", "0"),
	    		new PlayerCompetitionInformation( "FIFA","WC Qualifiers Europe", "14", "0", "14", "0", "2", "2", "0", "0"),
	    		new PlayerCompetitionInformation( "FIFA","Friendlies", "29", "3", "29", "0", "4", "0", "0", "0"),
	    		new PlayerCompetitionInformation( "UEFA","EURO", "9", "1", "9", "0", "1", "1", "0", "0"),
	    		new PlayerCompetitionInformation("UEFA","EURO Qualifiers",  "10", "1", "10", "0", "2", "1", "0", "0"),
	    		new PlayerCompetitionInformation(null, "∑", "66", "5", "66", "0", "9", "4", "0", "0"),
	    		new PlayerCompetitionInformation("UEFA","EURO [U21]",  "1", "0", "1", "0", "0", "0", "0", "0"),
	    		new PlayerCompetitionInformation( null,"∑ U21", "1", "0", "1", "0", "0", "0", "0", "0")));
	    player2ExpectedValueInfo.clubsMatchesOverall = new ArrayList<>(Arrays.asList(
	    		new PlayerCompetitionInformationOverall( "2001/2002", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "FA Cup", "3", "1", "3", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "2001/2002",new Club( "Arsenal FC"),new PlayerCompetitionInformation("England", "Pr. League", "10", "0", "10", "0", "1", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "2000/2001", new Club("Arsenal FC"), new PlayerCompetitionInformation("England", "Pr. League","26", "1", "26", "0", "0", "7", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "2000/2001", new Club("Arsenal FC"),new PlayerCompetitionInformation( "England", "FA Cup","4", "1", "4", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "2000/2001",new Club( "Arsenal FC"), new PlayerCompetitionInformation("UEFA", "Ch. League","8", "0", "8", "0", "0", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1999/2000", new Club("Arsenal FC"), new PlayerCompetitionInformation("UEFA", "EL","6", "0", "6", "0", "1", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1999/2000", new Club("Arsenal FC"), new PlayerCompetitionInformation("England", "Pr. League","21", "0", "21", "0", "0", "2", "0", "0")),
	    		new PlayerCompetitionInformationOverall("1999/2000",new Club( "Arsenal FC"), new PlayerCompetitionInformation("England", "FA Cup", "1", "1", "1", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1999/2000", new Club("Arsenal FC"),new PlayerCompetitionInformation( "UEFA", "Ch. League","5", "0", "5", "0", "0", "2", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1998/1999", new Club("Arsenal FC"),new PlayerCompetitionInformation( "England", "Pr. League","26", "1", "26", "0", "0", "4", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1998/1999",new Club( "Arsenal FC"),new PlayerCompetitionInformation( "England", "FA Cup","5", "0", "5", "0", "0", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1998/1999", new Club("Arsenal FC"),new PlayerCompetitionInformation( "UEFA", "Ch. League","4", "1", "4", "0", "1", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1998",new Club( "Arsenal FC"), new PlayerCompetitionInformation("England", "Com. Shield","1", "0", "1", "0", "1", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1997/1998", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "FA Cup", "6", "0", "6", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1997/1998", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "Pr. League", "26", "3", "26", "0", "0", "6", "0", "0")),
	    		new PlayerCompetitionInformationOverall("1997/1998",new Club( "Arsenal FC"), new PlayerCompetitionInformation("England", "League Cup", "2", "0", "2", "0", "0", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1997/1998", new Club("Arsenal FC"),new PlayerCompetitionInformation("UEFA", "EL", "2", "0", "2", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1996/1997", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "Pr. League", "28", "3", "27", "1", "2", "5", "1", "1")),
	    		new PlayerCompetitionInformationOverall( "1996/1997", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "FA Cup", "3", "0", "3", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1996/1997", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "League Cup", "3", "0", "3", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1996/1997",new Club( "Arsenal FC"),new PlayerCompetitionInformation( "UEFA", "EL","1", "0", "1", "0", "1", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1995/1996", new Club("Arsenal FC"),new PlayerCompetitionInformation( "England", "FA Cup","2", "0", "2", "0", "0", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1995/1996",new Club( "Arsenal FC"),new PlayerCompetitionInformation( "England", "Pr. League","21", "1", "21", "0", "0", "2", "0", "1")),
	    		new PlayerCompetitionInformationOverall( "1995/1996",new Club( "Arsenal FC"),new PlayerCompetitionInformation("England", "League Cup", "5", "2", "5", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall("1994/1995",new Club( "Arsenal FC"), new PlayerCompetitionInformation("England", "Pr. League", "27", "3", "27", "0", "3", "4", "0", "1")),
	    		new PlayerCompetitionInformationOverall( "1994/1995", new Club("Arsenal FC"),new PlayerCompetitionInformation( "UEFA", "CWC","8", "0", "8", "0", "0", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1994/1995", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "FA Cup", "1", "0", "0", "1", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1994/1995", new Club("Arsenal FC"),new PlayerCompetitionInformation( "England", "League Cup","4", "1", "4", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1994",new Club( "Arsenal FC"),new PlayerCompetitionInformation("UEFA", "UEFA Sup.Cup", "2", "0", "2", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1993/1994", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "Pr. League", "35", "0", "35", "0", "3", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall("1993/1994", new Club("Arsenal FC"),new PlayerCompetitionInformation("UEFA", "CWC",  "8", "2", "8", "0", "0", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1993/1994",new Club( "Arsenal FC"),new PlayerCompetitionInformation("England", "FA Cup", "3", "2", "3", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1993/1994",new Club( "Arsenal FC"), new PlayerCompetitionInformation("England", "League Cup","1", "0", "1", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1993", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "Com. Shield", "1", "0", "1", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall("1992/1993", new Club("Arsenal FC"), new PlayerCompetitionInformation("England", "FA Cup", "4", "2", "4", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1992/1993",new Club( "Arsenal FC"),new PlayerCompetitionInformation("England", "Pr. League", "35", "0", "33", "2", "2", "4", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1992/1993",new Club( "Arsenal FC"),new PlayerCompetitionInformation("England", "League Cup", "1", "0", "1", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1991/1992",new Club( "Arsenal FC"), new PlayerCompetitionInformation("England", "Pr. League","35", "2", "35", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1991/1992", new Club("Arsenal FC"), new PlayerCompetitionInformation("UEFA", "Ch. League","4", "0", "4", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall("1991", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "Com. Shield",  "1", "0", "1", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1990/1991",new Club( "Arsenal FC"),new PlayerCompetitionInformation("England", "Pr. League", "30", "1", "30", "0", "2", "1", "0", "1")),
	    		new PlayerCompetitionInformationOverall("1990/1991",new Club( "Arsenal FC"), new PlayerCompetitionInformation("England", "FA Cup", "1", "0", "1", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1989/1990", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "Pr. League", "38", "5", "38", "0", "1", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1989", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "Com. Shield", "1", "0", "1", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1988/1989", new Club("Arsenal FC"),new PlayerCompetitionInformation("England", "Pr. League", "36", "4", "36", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall("1987/1988", new Club("Arsenal FC"), new PlayerCompetitionInformation("England", "Pr. League", "39", "2", "39", "0", "3", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1986/1987", new Club("Arsenal FC"),new PlayerCompetitionInformation( "England", "Pr. League","42", "6", "42", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1986/1987", new Club("Arsenal FC"),new PlayerCompetitionInformation( "England", "League Cup","1", "0", "1", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1985/1986", new Club("Arsenal FC"),new PlayerCompetitionInformation( "England", "Pr. League","10", "0", "10", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1984/1985",new Club( "Arsenal FC"),new PlayerCompetitionInformation("England", "Pr. League", "16", "0", "15", "1", "1", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1983/1984",new Club( "Arsenal FC"),new PlayerCompetitionInformation("England", "Pr. League", "3", "0", "3", "0", "1", "0", "0", "0"))));
	    player2ExpectedValueInfo.internationalCopmetitionsOverall = new ArrayList<>(Arrays.asList(
	    		new PlayerCompetitionInformationOverall( "2000/2001", new Club("England"),new PlayerCompetitionInformation("FIFA", "WCQ Europe", "1", "0", "1", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "2000 Holland/Belgium",new Club( "England"),new PlayerCompetitionInformation( "UEFA", "EURO","1", "0", "1", "0", "1", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "2000", new Club("England"), new PlayerCompetitionInformation("FIFA", "Friendlies","2", "1", "2", "0", "1", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1999", new Club("England"), new PlayerCompetitionInformation("FIFA", "Friendlies","2", "0", "2", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1998/1999",new Club( "England"),new PlayerCompetitionInformation("UEFA", "EURO Qualif.", "5", "0", "5", "0", "1", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall("1998 France", new Club("England"),new PlayerCompetitionInformation("FIFA", "World Cup",  "4", "0", "4", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1998", new Club("England"),new PlayerCompetitionInformation("FIFA", "Friendlies", "3", "0", "3", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1996/1997", new Club("England"),new PlayerCompetitionInformation("FIFA", "WCQ Europe", "3", "0", "3", "0", "1", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1996 England", new Club("England"),new PlayerCompetitionInformation( "UEFA", "EURO","5", "0", "5", "0", "0", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1996",new Club( "England"),new PlayerCompetitionInformation("FIFA", "Friendlies", "1", "0", "1", "0", "1", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall("1995",new Club( "England"),new PlayerCompetitionInformation("FIFA", "Friendlies",  "6", "0", "6", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1994", new Club("England"), new PlayerCompetitionInformation("FIFA", "Friendlies","5", "0", "5", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall("1992/1993", new Club("England"),new PlayerCompetitionInformation("FIFA", "WCQ Europe",  "9", "0", "9", "0", "0", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1990/1991",new Club( "England"),new PlayerCompetitionInformation("UEFA", "EURO Qualif.", "2", "0", "2", "0", "1", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1988/1989",new Club( "England"), new PlayerCompetitionInformation("FIFA", "WCQ Europe","1", "0", "1", "0", "1", "1", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1988 Germany",new Club( "England"),new PlayerCompetitionInformation("UEFA", "EURO", "3", "1", "3", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1988",new Club( "England"),new PlayerCompetitionInformation( "FIFA", "Friendlies","7", "2", "7", "0", "2", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1987", new Club("England"),new PlayerCompetitionInformation("FIFA", "Friendlies", "3", "0", "3", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1986/1987",new Club( "England"), new PlayerCompetitionInformation("UEFA", "EURO Qualif.","3", "1", "3", "0", "0", "0", "0", "0")),
	    		new PlayerCompetitionInformationOverall( "1986", new Club("England"),new PlayerCompetitionInformation( "UEFA", "EURO [U21]","1", "0", "1", "0", "0", "0", "0", "0"))));
	    player2ExpectedValueInfo.recordOpponent = new ArrayList<>(Arrays.asList(
	    		new PlayerOpponentRecordInformation(new Club("Manchester United"),"31","11","9","11","2","4","0","0"),
	    		new PlayerOpponentRecordInformation(new Club("Luton Town"),"13","7","4","2","1","0","0","1"),
	    		new PlayerOpponentRecordInformation(new Club("Germany"),"3","0","0","3","0","0","0","0"),
	    		new PlayerOpponentRecordInformation(new Club("France"), "2","0","1","1","0","0","0","0"),
	    		new PlayerOpponentRecordInformation(new Club("Ukraine"),"1","1","0","0","1","0","0","0"),
	    		new PlayerOpponentRecordInformation(new Club("Parma Calcio 1913"),"1","1","0","0","0","0","0","0"),
	    		new PlayerOpponentRecordInformation(new Club("USA"),"1","1","0","0","0","0","0","0")));
	    
	    player2ExpectedValueInfo.recordReferee = new ArrayList<>(Arrays.asList(
	    		new PlayerRefereeRecordInformation(new Referee("Paul Durkin","England"),"20","14","3","3","0","2","0","1"),
	    		new PlayerRefereeRecordInformation(new Referee("Albert Thomas","Netherlands"),"1","1","0","0","0","0","0","0"),
	    		new PlayerRefereeRecordInformation(new Referee("Vadim Zhuk","Belarus"),"1","1","0","0","0","0","0","0")));
		
	    return player2ExpectedValueInfo;
		}
		
		public PlayerAllInformation getWwalterAitkenhead() {
			
			PlayerAllInformation player3ExpectedValueInfo = new PlayerAllInformation();
	        player3ExpectedValueInfo.personalInfo = new PlayerPersonalInformation(new Player("Walter Aitkenhead"), "Walter Campbell Allison Aitkenhead",
	                "21.05.1887 † 19.07.1966", "Glasgow, Scotland", new  ArrayList<String>(Arrays.asList("Scotland")), null, null, null, null);
	        player3ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
	        		new PlayerClubCareer("01/1906 - 12/1918",new Club( "Blackburn Rovers"), "England", "Forward", null),
	        		new PlayerClubCareer("01/1905 - 12/1905", new Club("Partick Thistle"), "Scotland", "Forward", null)));
	        player3ExpectedValueInfo.internationalCopmetitionsInfo = new ArrayList<>(Arrays.asList(
	        		new PlayerCompetitionInformation("FIFA","Friendlies",  "1", "2", "1", "0", "0", "0", "0", "0"),
	        		new PlayerCompetitionInformation(null,"∑",  "1", "2", "1", "0", "0", "0", "0", "0")));
	        player3ExpectedValueInfo.internationalCopmetitionsOverall = new ArrayList<>(Arrays.asList(
	        		new PlayerCompetitionInformationOverall( "1912", new Club("Scotland"),new PlayerCompetitionInformation("FIFA", "Friendlies", "1", "2", "1", "0", "0", "0", "0", "0"))));
	        player3ExpectedValueInfo.recordOpponent = new ArrayList<>(Arrays.asList(
	        		new PlayerOpponentRecordInformation(new Club("All Ireland"),"1","1","0","0","2","0","0","0")));
	        player3ExpectedValueInfo.recordReferee = new ArrayList<>(Arrays.asList(
	        		new PlayerRefereeRecordInformation(new Referee("Herbert Bamlett","England"),"1","1","0","0","2","0","0","0")));
	        player3ExpectedValueInfo.teamsManaged = null;
	        player3ExpectedValueInfo.clubMatches = null;
	        player3ExpectedValueInfo.clubsMatchesOverall = null;
	        
	        return  player3ExpectedValueInfo;
		}

		public PlayerAllInformation getSamJohnstone() {
		
			PlayerAllInformation player4ExpectedValueInfo = new PlayerAllInformation();
			
	        player4ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
	        		new PlayerClubCareer("07/2018 - 07/2018", new Club("Manchester United U23"), "England", "Goalkeeper", null),
	         		new PlayerClubCareer("01/2016 - 01/2016", new Club("Preston North End"), "England", "Goalkeeper", null)));

	        player4ExpectedValueInfo.clubMatches = new ArrayList<>(Arrays.asList(
	        		new PlayerCompetitionInformation("England","Premier League","19","0","19","0","0","0","0","0"),
	        		new PlayerCompetitionInformation("England","League One","51","0","51","0","0","4","0","0"),
	        		new PlayerCompetitionInformation(null, "∑","275","0","275","0","0","14","0","0")));
	        
	        return player4ExpectedValueInfo;
		}
		
		public PlayerAllInformation getGeorgeTimmins() {
		
			PlayerAllInformation player5ExpectedValueInfo = new PlayerAllInformation();
	        player5ExpectedValueInfo.personalInfo = new PlayerPersonalInformation(new Player("George Timmins"),null,"1858 †","West Bromwich, England",new  ArrayList<String>(Arrays.asList("England")),null,null,null,null);
	        player5ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
	        		new PlayerClubCareer("07/1880 - 06/1891",new Club("West Bromwich Albion"),"England","Midfielder", null)));
	        
	        player5ExpectedValueInfo.clubMatches = null;
	        player5ExpectedValueInfo.clubsMatchesOverall=null;
	        player5ExpectedValueInfo.internationalCopmetitionsInfo =null;
	        
	        return player5ExpectedValueInfo;
		}
		
		public PlayerAllInformation getCheAdams() {
			PlayerAllInformation player6ExpectedValueInfo = new PlayerAllInformation();
	        player6ExpectedValueInfo.personalInfo = new PlayerPersonalInformation(new Player("Che Adams"),"Che Zach Everton Fred Adams","13.07.1996",
	        		"Leicester, England",new  ArrayList<String>(Arrays.asList("England","Antigua & Barbuda")),"179 cm","70 kg",new  ArrayList<String>(Arrays.asList("Centre Forward","Left Winger")),"right");
	        player6ExpectedValueInfo.teamsManaged = null;
	        return player6ExpectedValueInfo;
		
		}
		public PlayerAllInformation getAdamCarson() {
		
			PlayerAllInformation player7ExpectedValueInfo = new PlayerAllInformation();
	        player7ExpectedValueInfo.personalInfo = new PlayerPersonalInformation(new Player("Adam Carson"),null,"†",
	        		"Scotland",new  ArrayList<String>(Arrays.asList("Scotland")),null,null,null,null);
	       
	        player7ExpectedValueInfo.teamsManaged = null;
	        return player7ExpectedValueInfo;
		}

	}


