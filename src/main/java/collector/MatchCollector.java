package collector;

import java.util.ArrayList;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import models.Goal;
import models.KindOfGoal;
import models.KindOfReferee;
import models.MatchDetails;
import models.ClubInMatch;
import models.PlayerAtMatch;
import models.PlayerEventAtMatch;
import models.PlayerTypeAtMatch;
import models.Referee;

public class MatchCollector {
	
	private HttpUtil httpUtil = new HttpUtil();
	private static final String WORLD_FOOTBALL_MATCH_URL ="https://www.worldfootball.net/report/";
	private GoalsCollector goalsCollector = new GoalsCollector();

	public MatchDetails getMatchDetails(String competitionName , String competitionYears , String firstClub , String secondClub) {
		
		MatchDetails result = new MatchDetails();
		
		String matchAsURL = WORLD_FOOTBALL_MATCH_URL + competitionName + "-" + competitionYears + "-" + firstClub +"-" +secondClub+"/" ;
		String htmlPage = httpUtil.sendGetHttpRequest(matchAsURL);
       
		Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        
        Elements elementBasicInfo = tables.select("table:has(th:has(a[href*=/teams/]))");
        Elements elementGoalsInfo = tables.select("table:has(td:contains(goals))");
        Elements elementClubsInfo  = tables.select("table:has(td[width=10%],[width=72%],[width=18%])");
        Elements elementManagersInfo = tables.select("table:has(th:contains(Manager:))");
        Elements elementMatchLocationRefeersAndOtherInfo = tables.select("table:has(img[title=stadium])");
        
     
        MatchSummary matchSummary = new MatchSummary();
        matchSummary = getMatchSummry(elementBasicInfo);
       result.firstClub.players = getClubPlayersInMatch(elementClubsInfo.get(0));
       result.firstClub.manager =  elementManagersInfo.get(0).select("a").get(0).attr("title"); 
       if(result.firstClub.manager.startsWith(" ")) {
    	   result.firstClub.manager = result.firstClub.manager.substring(1);
       }
       result.firstClub.goals = getGoalsInMatch(elementGoalsInfo ,0 );
       result.firstClub.clubName = matchSummary.firstClub;
       
       result.secondClub.players = getClubPlayersInMatch(elementClubsInfo.get(1));
       result.secondClub.manager =  elementManagersInfo.get(0).select("a").get(1).attr("title");
       if(result.secondClub.manager.startsWith(" ")) {// some times the name starts with space
    	   result.secondClub.manager = result.secondClub.manager.substring(1);
       }
       result.secondClub.goals = getGoalsInMatch(elementGoalsInfo ,1);
       result.secondClub.clubName = matchSummary.secondClub;
       
       result.date = matchSummary.date;
       result.time = matchSummary.time;
       result.resultSummary = matchSummary.resultSummary;
       result.referees = getRefereesInMatch(elementMatchLocationRefeersAndOtherInfo);
       Elements elementStadium = elementMatchLocationRefeersAndOtherInfo.get(0).select("tr:has(td:has(img[title=stadium]))");
		if(elementStadium != null) {result.staduim = elementStadium.text();}			
		
		Elements elementAttendance = elementMatchLocationRefeersAndOtherInfo.get(0).select("tr:has(td:has(img[title=Attendance]))");
		if(elementAttendance != null) {result.attendance = elementAttendance.text();}
		return result;
	}
	 
	
 	
	
	
	private MatchSummary  getMatchSummry(Elements tableBasicInfo) {
		MatchSummary result = new MatchSummary();
		if(tableBasicInfo.size() > 0) {//not null
			Elements trs = tableBasicInfo.get(0).select("tr");
			if(trs.size() == 2) {//insure we will not have run time exception (out of index)
				result.firstClub  = trs.get(0).child(0).text();
				if(trs.get(0).child(1).html().contains("<")) {//new league contains hour not only the day
					result.date                = trs.get(0).child(1).html().substring(0, trs.get(0).child(1).html().indexOf('<'));
					result.time                = trs.get(0).child(1).html().substring(trs.get(0).child(1).html().indexOf('>')+1);
					result.resultSummary =     trs.get(1).child(1).text();
					
				}
				else {
					result.date                = trs.get(0).child(1).text();
					result.resultSummary =     trs.get(1).child(1).text();
				}
				result.secondClub = trs.get(0).child(2).text();
				
			}
		}
		return result;
	}
	private ArrayList <Referee> getRefereesInMatch (Elements table){
		ArrayList <Referee> result = new ArrayList<>();
		Elements elementReferees = table.get(0).select("tr:has(td:has(img[title=Referee]))");
		if(elementReferees.size() > 0) {
			Referee referee = new Referee();
			referee.kind =  KindOfReferee.Referee;				
			referee.name =  elementReferees.text().substring(0, elementReferees.text().indexOf("(")-1);
			referee.nation =  elementReferees.text().substring(elementReferees.text().indexOf("(")+1 ,elementReferees.text().indexOf(")"));
			
			result.add(referee);
		}
		Elements elementAssistantRefereeses = table.get(0).select("tr:has(td:has(img[title=Assistant Referee]))");
		if(elementAssistantRefereeses.size() > 0) {
			for(Element assistantRefere : elementAssistantRefereeses ) {
				Referee referee = new Referee();
				referee.kind =  KindOfReferee.AssistantReferee;				
				referee.name =  assistantRefere.text().substring(0, assistantRefere.text().indexOf("(")-1);
				referee.nation =  assistantRefere.text().substring(assistantRefere.text().indexOf("(")+1 ,assistantRefere.text().indexOf(")"));
				result.add(referee);
			}
		
	}
		return result;
	}
	
	 

	private ArrayList<PlayerAtMatch> getClubPlayersInMatch(Element tableClubPlayer) {
		ArrayList<PlayerAtMatch> result = new ArrayList();
		Elements trsTeam = tableClubPlayer.select("tr");
		//less than indexOfSub that means the player is Essential  
		//bigger than indexOfSub that  means the player is sub
		//indexOfSub ==-1 that means old league
		int indexOfSub = indexOfSubstiute(trsTeam);
		
		for(int i =0 ; i < trsTeam.size() ; i++) {
			
			if(i != indexOfSub) {
				if((i < indexOfSub) || (indexOfSub == -1)) { //indexOfSub ==-1 (i.e old league)
					PlayerAtMatch player = new PlayerAtMatch();
					                                         //----------td----------
					player.playerNumberAsString              = trsTeam.get(i).child(0).text();
				
					player.playerName                        = trsTeam.get(i).child(1).child(0).text();
					if(player.playerName.startsWith(" ")) {//some names begin with space
						player.playerName = player.playerName.substring(1);
					}
					
					player.playerType = PlayerTypeAtMatch.Essential;
					player.events = getPlayerEventsInMtach(trsTeam.get(i).child(1));
					
					if(trsTeam.get(i).child(2).hasText()) {
						PlayerEventAtMatch event1 = new PlayerEventAtMatch();
						event1.event = "out";
						event1.minute = trsTeam.get(i).child(2).text().substring(0,trsTeam.get(i).child(2).text().length()-1);
						
						player.events.add(event1);
					}
					result.add(player);
				}
				else {
					
					PlayerAtMatch player = new PlayerAtMatch();
	                                                         //----------td----------
					player.playerNumberAsString              = trsTeam.get(i).child(0).text();						
					player.playerName                        = trsTeam.get(i).child(1).child(0).attr("title");
					player.playerType = PlayerTypeAtMatch.Substitute;
					
					player.events = getPlayerEventsInMtach(trsTeam.get(i).child(1));
					
										

					if(trsTeam.get(i).child(2).hasText()) {
						PlayerEventAtMatch event1 = new PlayerEventAtMatch();
						event1.event = "in";
						event1.minute = trsTeam.get(i).child(2).text().substring(0,trsTeam.get(i).child(2).text().length()-1);
						player.events.add(event1);
					}
					result.add(player);
				}
			}
			
		}
		
	
		return result;
	}
	///to get events     
	//image contains  the name of event (red card  , yellow card ,....) and the next span contains the time
	//eventIndex+2 (i.e) event's name and it's time
	private ArrayList<PlayerEventAtMatch> getPlayerEventsInMtach(Element TdPlayer) {
		ArrayList<PlayerEventAtMatch> result = new  ArrayList<>();
		Elements elementPlayerEvents = TdPlayer.select(" img , span[title*=at]");
		if(!(elementPlayerEvents.isEmpty())) {
			for(int eventIndex = 0 ; eventIndex <  elementPlayerEvents.size() ; eventIndex= eventIndex+2) {
				PlayerEventAtMatch event1 = new PlayerEventAtMatch();
				event1.event = elementPlayerEvents.get(eventIndex).attr("title");
				event1.minute= elementPlayerEvents.get(eventIndex+1).attr("title").substring(3,5);
				
				result.add(event1);
			}
		}
		
		return result;
	}
	private int indexOfSubstiute(Elements trs) {
		for(int i =0; i <trs.size() ; i++) {
			if(trs.get(i).html().contains("Substitutes")) {
				return i;
			}
		}
		
			return -1;// no sub (i.e old league)
		
	}
	//{club ==0 first team} or {club == 1 second team}
	private ArrayList<Goal> getGoalsInMatch(Elements goalsTable ,int club ){
		ArrayList <Goal> result = new ArrayList<>();
		Elements trs = goalsTable.select("tr");
	
		if(trs.get(1).text().equals("none")) {
			return result;
		}
		
		for(int i =1 ; i<trs.size() ;i++) {//the header contains (goals) 
			if(club == 0) {
				if(!(trs.get(i).child(1).attr("style").contains("padding-left: 50px"))) {				
					if ((trs.get(i).child(1).ownText().equals("0."))) {//old league does not have any information, it only has 0.
						Goal goal = new Goal(); 
						goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.OldGoal);
	                     result.add(goal);
	                } 
					else {//new league             	
	                
	                    if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.HasAssister) {
	                    	Goal goal = new Goal();
	                    	goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.HasAssister);
	                        result.add(goal);
	                    } else if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.Individually) {
	                    	Goal goal = new Goal();
	                    	 goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.Individually);
	                         result.add(goal);
	                    } else if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.Reverse) {	                    	
	                    	Goal goal = new Goal();
	                         goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.Reverse);
	                        result.add(goal);
	                    }
	                }			
				}
			}
		
			else {
				if((trs.get(i).child(1).attr("style").contains("padding-left: 50px"))) {			
					if ((trs.get(i).child(1).ownText().equals("0."))) {//old league does not have any information, it only has 0.
						Goal goal = new Goal(); 
						goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.OldGoal);
		                 result.add(goal);
		            } 
					else {//new league	            
		                if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.HasAssister) {
		                	Goal goal = new Goal();
		                	goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.HasAssister);
		                    result.add(goal);
		                } 
		                else if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.Individually) {
		                	Goal goal = new Goal();
		                	goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.Individually);
		                    result.add(goal);
		                } 
		                else if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.Reverse) {
		                	Goal goal = new Goal();
		                    goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.Reverse);
		                    result.add(goal);
		                }
				}
	
			}
		}
			
		
		
		
		}
		
		return result;
	}
}	

