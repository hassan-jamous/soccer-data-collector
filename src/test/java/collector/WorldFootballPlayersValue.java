package collector;

import java.util.ArrayList;
import java.util.Arrays;
import models.PlayerAllInformation;
import models.PlayerClubCareer;
import models.PlayerCompetitionInformation;
import models.PlayerCompetitionInformationOverall;
import models.PlayerOpponentRecordInformation;
import models.PlayerPersonalInformation;
import models.PlayerRefereeRecordInformation;
import models.PlayerTeamManaged;

public class WorldFootballPlayersValue {
	
	public PlayerAllInformation getEricBaillyInformation() {
		PlayerAllInformation player1ExpectedValueInfo = new PlayerAllInformation();
	    player1ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Eric Bailly","Eric Bertrand Bailly",
	            "12.04.1994", "Bingerville, Ivory Coast", new  ArrayList<String>(Arrays.asList("Ivory Coast")), "187 cm",
	            "77 kg",new  ArrayList<String>(Arrays.asList( "Centre Back")), "right");
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
	    		new PlayerCompetitionInformation("FA Cup", "England", "7", "0", "6", "1", "3", "1", "0", "0"),
	    		new PlayerCompetitionInformation("League Cup", "England", "5", "0", "5", "0", "0", "0", "0", "0"),
	    		new PlayerCompetitionInformation("FA Community Shield", "England", "1", "0", "1", "0", "0", "1", "0", "0"),
	    		new PlayerCompetitionInformation("U23 Premier League Div. 1", "England", "1", "0", "1", "0", "1", "0", "0", "0"),
	    		new PlayerCompetitionInformation("U23 Premier League Div. 2", "England", "1", "0", "1", "0", "1", "0", "0", "0"),
	    		new PlayerCompetitionInformation("Primera División", "Spanien", "40", "0", "39", "1", "10", "15", "1", "0"),
	    		new PlayerCompetitionInformation("Copa del Rey", "Spanien", "3", "0", "3", "0", "0", "2", "0", "0"),
	    		new PlayerCompetitionInformation("Segunda B Grupo 3", "Spanien", "22", "0", "19", "3", "2", "6", "1", "0"),
	    		new PlayerCompetitionInformation("∑", null, "170", "2", "154", "16", "25", "39", "4", "2")));
	    player1ExpectedValueInfo.clubsMatchesOverall = new ArrayList<>(Arrays.asList(
	    		new PlayerCompetitionInformationOverall("England", "FA Cup", "2020/2021", "Manchester United", "1", "0", "1", "0", "1", "0", "0", "0"),
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
	    
	    player1ExpectedValueInfo.recordOpponent = new ArrayList<>(Arrays.asList(
	    		new PlayerOpponentRecordInformation("Chelsea FC","7","3","1","3","0","1","0","0"),
	    		new PlayerOpponentRecordInformation("Liverpool FC","4","2","1","1","0","1","0","0"),
	    		new PlayerOpponentRecordInformation("Real Madrid","3","1","1","1","0","2","0","0"),
	    		new PlayerOpponentRecordInformation("SD Eibar","3","2","1","0","0","0","0","0"),
	    		new PlayerOpponentRecordInformation("Middlesbrough FC","2","2","0","0","0","0","0","0"),
	    		new PlayerOpponentRecordInformation("Belgium","1","0","1","0","0","0","0","0"),
	    		new PlayerOpponentRecordInformation("Japan","1","0","0","1","0","0","0","0"),
	    		new PlayerOpponentRecordInformation("Sporting Gijón","1","0","0","1","0","0","0","0"),
	    		new PlayerOpponentRecordInformation("Wolverhampton Wanderers","1","1","0","0","0","0","0","0")));
	    
	    player1ExpectedValueInfo.recordReferee = new ArrayList<>(Arrays.asList(
	    		new PlayerRefereeRecordInformation("Jonathan Moss","England","10","7","2","1","1","1","0","0"),
	    		new PlayerRefereeRecordInformation("Carlos Velasco Carballo","Spain","3","1","0","2","0","2","0","0"),
	    		new PlayerRefereeRecordInformation("Alex Muhabi",           "Uganda","1","1","0","0","1","0","0","0"),
	    		new PlayerRefereeRecordInformation("Jorge Díaz Escudero","Spain","1","1","0","0","0","0","0","0"),
	    		new PlayerRefereeRecordInformation("Pavel Královec","Czech Republic","1","1","0","0","0","0","0","0"),
	    		new PlayerRefereeRecordInformation("José Teixeira Vitienes","Spain","1","0","1","0","0","1","0","0"),
	    		new PlayerRefereeRecordInformation("Slavko Vinčić","Slovenia","1","0","1","0","0","0","0","0")));
	    player1ExpectedValueInfo.teamsManaged = null;
	    
	    player1ExpectedValueInfo.forEachCompetitionInformationOverallsClubs  = new ArrayList<PlayerCompetitionInformationOverall>(Arrays.asList(
				new PlayerCompetitionInformationOverall("UEFA","EL","2019/2020","Manchester United","4","0","4","0","1","1","0","0"),
				new PlayerCompetitionInformationOverall("UEFA","EL","2016/2017","Manchester United","11","0","11","0","0","2","1","1")));

	    return player1ExpectedValueInfo;
	}

    
	public PlayerAllInformation getTonyAdamsInformation() {

    //https://www.worldfootball.net/player_summary/tony-adams/
    PlayerAllInformation player2ExpectedValueInfo = new PlayerAllInformation();

    player2ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Tony Adams", "Anthony Alexander Adams",
            "10.10.1966", "Romford, England",new  ArrayList<String>(Arrays.asList( "England")), "191 cm", "87 kg", 
            new  ArrayList<String>(Arrays.asList("Centre Back")), "right");
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
    player2ExpectedValueInfo.recordOpponent = new ArrayList<>(Arrays.asList(
    		new PlayerOpponentRecordInformation("Manchester United","31","11","9","11","2","4","0","0"),
    		new PlayerOpponentRecordInformation("Luton Town","13","7","4","2","1","0","0","1"),
    		new PlayerOpponentRecordInformation("Germany","3","0","0","3","0","0","0","0"),
    		new PlayerOpponentRecordInformation("France", "2","0","1","1","0","0","0","0"),
    		new PlayerOpponentRecordInformation("Ukraine","1","1","0","0","1","0","0","0"),
    		new PlayerOpponentRecordInformation("Parma Calcio 1913","1","1","0","0","0","0","0","0"),
    		new PlayerOpponentRecordInformation("USA","1","1","0","0","0","0","0","0")));
    
    player2ExpectedValueInfo.recordReferee = new ArrayList<>(Arrays.asList(
    		new PlayerRefereeRecordInformation("Paul Durkin","England","20","14","3","3","0","2","0","1"),
    		new PlayerRefereeRecordInformation("Albert Thomas","Netherlands","1","1","0","0","0","0","0","0"),
    		new PlayerRefereeRecordInformation("Vadim Zhuk","Belarus","1","1","0","0","0","0","0","0")));
	
    return player2ExpectedValueInfo;
	}
	
	public PlayerAllInformation getWwalterAitkenhead() {
		
		PlayerAllInformation player3ExpectedValueInfo = new PlayerAllInformation();
        player3ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Walter Aitkenhead", "Walter Campbell Allison Aitkenhead",
                "21.05.1887 † 19.07.1966", "Glasgow, Scotland", new  ArrayList<String>(Arrays.asList("Scotland")), null, null, null, null);
        player3ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("01/1906 - 12/1918", "Blackburn Rovers", "England", "Forward", null),
        		new PlayerClubCareer("01/1905 - 12/1905", "Partick Thistle", "Scotland", "Forward", null)));
        player3ExpectedValueInfo.internationalCopmetitionsInfo = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("Friendlies", "FIFA", "1", "2", "1", "0", "0", "0", "0", "0"),
        		new PlayerCompetitionInformation("∑", null, "1", "2", "1", "0", "0", "0", "0", "0")));
        player3ExpectedValueInfo.internationalCopmetitionsOverall = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformationOverall("FIFA", "Friendlies", "1912", "Scotland", "1", "2", "1", "0", "0", "0", "0", "0")));
        player3ExpectedValueInfo.recordOpponent = new ArrayList<>(Arrays.asList(
        		new PlayerOpponentRecordInformation("All Ireland","1","1","0","0","2","0","0","0")));
        player3ExpectedValueInfo.recordReferee = new ArrayList<>(Arrays.asList(
        		new PlayerRefereeRecordInformation("Herbert Bamlett","England","1","1","0","0","2","0","0","0")));
        player3ExpectedValueInfo.teamsManaged = null;
        player3ExpectedValueInfo.clubMatches = null;
        player3ExpectedValueInfo.clubsMatchesOverall = null;
        
        return  player3ExpectedValueInfo;
	}

	public PlayerAllInformation getSamJohnstone() {
	
		PlayerAllInformation player4ExpectedValueInfo = new PlayerAllInformation();
        player4ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("07/2018 - 07/2018", "Manchester United U23", "England", "Goalkeeper", null),
         		new PlayerClubCareer("01/2016 - 01/2016", "Preston North End", "England", "Goalkeeper", null)));

        player4ExpectedValueInfo.clubMatches = new ArrayList<>(Arrays.asList(
        		new PlayerCompetitionInformation("Premier League","England","17","0","17","0","0","0","0","0"),
        		new PlayerCompetitionInformation("League One","England","51","0","51","0","0","4","0","0"),
        		new PlayerCompetitionInformation("∑",null,"273","0","273","0","0","14","0","0")));
        
        return player4ExpectedValueInfo;
	}
	
	public PlayerAllInformation getGeorgeTimmins() {
	
		PlayerAllInformation player5ExpectedValueInfo = new PlayerAllInformation();
        player5ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("George Timmins",null,"1858 †","West Bromwich, England",new  ArrayList<String>(Arrays.asList("England")),null,null,null,null);
        player5ExpectedValueInfo.clubsCareer = new ArrayList<>(Arrays.asList(
        		new PlayerClubCareer("07/1880 - 06/1891","West Bromwich Albion","England","Midfielder", null)));
        
        player5ExpectedValueInfo.clubMatches = null;
        player5ExpectedValueInfo.clubsMatchesOverall=null;
        player5ExpectedValueInfo.internationalCopmetitionsInfo =null;
        
        return player5ExpectedValueInfo;
	}
	
	public PlayerAllInformation getCheAdams() {
		PlayerAllInformation player6ExpectedValueInfo = new PlayerAllInformation();
        player6ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Che Adams","Che Zach Everton Fred Adams","13.07.1996",
        		"Leicester, England",new  ArrayList<String>(Arrays.asList("England","Antigua & Barbuda")),"179 cm","70 kg",new  ArrayList<String>(Arrays.asList("Centre Forward","Left Winger")),"right");
        player6ExpectedValueInfo.teamsManaged = null;
        return player6ExpectedValueInfo;
	
	}
	public PlayerAllInformation getAdamCarson() {
	
		PlayerAllInformation player7ExpectedValueInfo = new PlayerAllInformation();
        player7ExpectedValueInfo.personalInfo = new PlayerPersonalInformation("Adam Carson",null,"†",
        		"Scotland",new  ArrayList<String>(Arrays.asList("Scotland")),null,null,null,null);
       
        player7ExpectedValueInfo.teamsManaged = null;
        return player7ExpectedValueInfo;
	}

}
