package collector;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import models.DirtyGame;
import models.Staduim;
import models.StatisticsBestPlayerInYear;
import models.StatisticsGoalsPerRound;
import models.StatisticsGoalsPerSeason;
import models.StatisticsMostGoalsInGame;
import models.StatisticsRecordWinsAndMostGoalInGame;

public class StatisticsCollector {
	
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLDFOOTBALL_STATS_URL ="https://www.worldfootball.net/stats/";
    private static final String WORLDFOOTBALL_BEST_PLAYER_URL = "https://www.worldfootball.net/footballer_of_the_year/";
    private static final String WORLDFOOTBALL_VENUES_URL ="https://www.worldfootball.net/venues/";
    
	public ArrayList <StatisticsGoalsPerSeason> getStatisticsGoalsPerSeason(String competitionName) {
		String url = WORLDFOOTBALL_STATS_URL +competitionName +"/1/";
		String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        
        Elements tables = doc.select("table:eq(0):has(th:contains(Ø goals))");
        Elements trs = tables.select("tr");
		ArrayList <StatisticsGoalsPerSeason> result = new ArrayList <>();

        for (int i = 1 ; i < trs.size() ; i++) {//i=1 the header contains names of columns
        	StatisticsGoalsPerSeason clubInfo = new StatisticsGoalsPerSeason();

        	clubInfo.seasonRankingNumber  = (trs.get(i).child(0).text().equals("∑")) ? "TOTAL" : trs.get(i).child(0).text();
        	clubInfo.seasonYears   = trs.get(i).child(1).text();
        	clubInfo.goals         = trs.get(i).child(2).text();
        	clubInfo.matchesNumber = trs.get(i).child(3).text();
        	clubInfo.goalsPerMatch = trs.get(i).child(4).text();

        	result.add(clubInfo);
        }
		return result;
	}

	public ArrayList <StatisticsGoalsPerRound> getStatisticsGoalsPerRound(String competitionName) {
		ArrayList <StatisticsGoalsPerRound> result = new ArrayList <>();
		String url = WORLDFOOTBALL_STATS_URL +competitionName +"/2/";
		String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        
        Elements tables = doc.select("table:eq(0):has(th:contains(Ø goals))");
        Elements trs = tables.select("tr");
        for (int i = 1 ; i < trs.size() ; i++) {//i=1 the the header contains names of columns
        	StatisticsGoalsPerRound roundInfo = new StatisticsGoalsPerRound();
        	                             
        	roundInfo.roundRankingNumber  = (trs.get(i).child(0).text().equals("∑")) ? "TOTAL" : trs.get(i).child(0).text();
        	if(!(trs.get(i).child(0).text().equals("∑"))) {
	        	roundInfo.seasonYears                = trs.get(i).child(1).child(0).text().substring(0,trs.get(i).child(1).text().indexOf("| ")-1);
	        	roundInfo.round.roundNumberAsString  = trs.get(i).child(1).text().substring(trs.get(i).child(1).text().indexOf("| ")+2);
        	}
        	else {
	        	roundInfo.seasonYears                 = trs.get(i).child(1).child(0).text();
	        	roundInfo.round.roundNumberAsString   ="all season";

        	}
        	roundInfo.goals               = trs.get(i).child(2).text();
        	roundInfo.matchesNumber       = trs.get(i).child(3).text();
        	roundInfo.goalsPerMatch       = trs.get(i).child(4).text();
            
        	result.add(roundInfo);
        }
		return result;
	}
	
	//3 is the request for record wins or 4 is the request for most goals in game 
	public ArrayList <StatisticsRecordWinsAndMostGoalInGame> getStatisticsRecordWinsOrMostGoalInGame(String competitionName , int kindOfRequest) {
		ArrayList <StatisticsRecordWinsAndMostGoalInGame> result = new ArrayList <>();
		String requestAsString= String.valueOf(kindOfRequest) ;
		//3 is the request for record wins or 4 is the request for most goals in game 
		String url = WORLDFOOTBALL_STATS_URL +competitionName +"/"+ requestAsString +"/";
		String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.select("table:eq(0):has(th:contains(guest)) , table:eq(0):has(th:contains(Season))");
        Elements trs = tables.select("tr");
        for (int i = 1 ; i < trs.size() ; i++) {//i=1 the the header contains names of columns
        	StatisticsRecordWinsAndMostGoalInGame winInfo = new StatisticsRecordWinsAndMostGoalInGame();
        	                              
        	winInfo.seasonYears               = trs.get(i).child(0).text();
        	winInfo.round.roundNumberAsString = trs.get(i).child(1).text();
        	winInfo.matchDate                 = trs.get(i).child(2).text();
        	winInfo.homeClubBasicInfo.name    = trs.get(i).child(3).text();
        	winInfo.matchResult               = trs.get(i).child(5).text();
        	winInfo.guestClubBasicInfo.name   = trs.get(i).child(7).text();

        	result.add(winInfo);
        }
		return result;
	       
	}
	
	public ArrayList <StatisticsMostGoalsInGame> getStatisticsMostGoalsInGameInCompetetion(String competitionName){
		
		ArrayList <StatisticsMostGoalsInGame> result = new ArrayList<>();
		String url =WORLDFOOTBALL_STATS_URL +competitionName +"/5/";
		String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements divs = doc.select("div:has(div:has(table:eq(0):has(th:contains(Player)))) , div:has(div:has(table:eq(0):has(th:contains(date))))");
        
        //we have one table for each number of goals    
        //table for number of goals 4 contain every player who scored 4 goals in one match
        //table for number of goals 3 contain every player who scored 3 goals in one match
        for(int divIndex=0 ; divIndex < divs.size();  divIndex++ ) {
        	String maxNumberOfGoals = divs.get(divIndex).getElementsByTag("h2").text().substring(divs.get(divIndex).getElementsByTag("h2").text().indexOf("» ")+2, divs.get(divIndex).getElementsByTag("h2").text().indexOf("Goals")-1) ;
        	Elements trs = divs.get(divIndex).select("tr");
	        for (int i = 0 ; i < trs.size() ; i++) {
	        	
	        	if(trs.get(i).childrenSize() ==7) {//we do not need the header  the header contains 6 children
		        	StatisticsMostGoalsInGame gameInfo = new StatisticsMostGoalsInGame();
		        	                    
		        	gameInfo.playerBasicInfo.name   = trs.get(i).child(0).text();
		        	gameInfo.matchDate              = trs.get(i).child(1).text();
		        	gameInfo.homeClubBasicInfo.name = trs.get(i).child(2).text();
		        	gameInfo.matchResult            = trs.get(i).child(4).text();
		        	gameInfo.guestClubBasicInfo.name= trs.get(i).child(6).text();
		        	gameInfo.playerGoalsNumber      = maxNumberOfGoals;
		        	
		        	result.add(gameInfo);
	        	}
	        }
        }
        
		return result;
	}
	
	public ArrayList<DirtyGame> getStatisticsDirtiesGamesForCompetition(String competitionName){
		ArrayList<DirtyGame> result = new ArrayList<>();
		
		String url =WORLDFOOTBALL_STATS_URL +competitionName +"/6/";
		String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        
        Elements tables = doc.select("table.standard_tabelle:has(tbody:has(tr:has(th:has(img[alt*=Red cards]))))");
        Elements trs = tables.select("tr");
        
        for (int i = 1 ; i < trs.size() ; i++) {//i=1 the the header contains names of columns
        	DirtyGame dirtyGameInfo = new DirtyGame();
        	                                                       
        	dirtyGameInfo.gameNormalInfo.date                      = trs.get(i).child(0).text();
        	dirtyGameInfo.gameNormalInfo.firstTeamBasicInfo.name   = trs.get(i).child(1).text();
        	dirtyGameInfo.gameNormalInfo.finalResult               = trs.get(i).child(3).text();
        	dirtyGameInfo.gameNormalInfo.secondTeamBasicInfo.name  = trs.get(i).child(5).text();
        	dirtyGameInfo.redCards                                 = trs.get(i).child(6).text();
        	dirtyGameInfo.secondYellowCards                        = trs.get(i).child(7).text();
        	dirtyGameInfo.yellowCards                              = trs.get(i).child(8).text();
        	dirtyGameInfo.dirtyPoints                              = trs.get(i).child(9).text();
        	
        	result.add(dirtyGameInfo);
        }
		return result;
	       
	}
	
	public ArrayList<StatisticsBestPlayerInYear> getStatisticsBestPlayerInYear(String country){
		ArrayList<StatisticsBestPlayerInYear> result = new ArrayList<>();
		
		String url = WORLDFOOTBALL_BEST_PLAYER_URL +country +"/";
		String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
       
        Elements tables = doc.select("table.standard_tabelle:has(tbody:has(tr:contains(Year))),table.standard_tabelle:has(tbody:has(tr:contains(Player)))");
        Elements trs = tables.select("tr");
       
        for (int i = 1 ; i < trs.size() ; i++) {//i=1 the the header contains names of columns
            StatisticsBestPlayerInYear bestPlayerInfo = new StatisticsBestPlayerInYear();
        	
        	bestPlayerInfo.year        = trs.get(i).child(0).text();
        	bestPlayerInfo.playerBasicInfo.name  = trs.get(i).child(1).text(); 
        	
        	result.add(bestPlayerInfo);
        }
        return result;
	}
	
	public ArrayList<Staduim> getCompetitionSatuims (String competitionName , String competitionYears){
		ArrayList<Staduim> result = new ArrayList<>();
		String url = WORLDFOOTBALL_VENUES_URL +competitionName +"-" + competitionYears +"/" ;
		String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        
        Elements tables = doc.select("table:has(tbody:has(tr:has(th:contains(stadium)))) , table:has(tbody:has(tr:has(th:contains(Country))))");
        Elements trs = tables.select("tr");
        for(int i =1 ; i < trs.size() ; i++) {//i=1 the the header contains names of columns
        	Staduim staduimInfo = new Staduim();
        	staduimInfo.name       = trs.get(i).child(1).text();
        	staduimInfo.city       = trs.get(i).child(2).text();
        	staduimInfo.country    = trs.get(i).child(4).text();
        	staduimInfo.capacity   = trs.get(i).child(5).text();
        	
        	result.add(staduimInfo);
        }
		return result;
	}
	
}