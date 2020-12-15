package collector;

import java.util.ArrayList;


import models.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//TODO
//fix round

public class ScreenScraper {
    private static final String WORLD_FOOTBALL_MATCHES_URL = "https://www.worldfootball.net/all_matches/";
    private HttpUtil httpUtil = new HttpUtil();

    public GamesTableOfLeague getGamesTableOfCompetition(String competitionYears) {//name of method!! i want to bring table of all (round) games
    	GamesTableOfLeague gamesTable = new GamesTableOfLeague(competitionYears);

        Round round;
       
        String htmlPage = httpUtil.sendGetHttpRequest(buildGetEnglishPremierLeagueSeasonUrl(competitionYears));
		Document doc = Jsoup.parse(htmlPage);

        Elements League = doc.getElementsByClass("standard_tabelle");
        Elements rows = League.select("tr");
        
        int i=0;
       
        for(Element row : rows) {
        	if(kindOfElement(row).kind == KindRow.Round) {
        		
        		round = new Round();
        		round.setRoundNumber(kindOfElement(row).refrenceOfElement.text());
        		int j = i +1;
        		String date ="";
    			
        		while((j<rows.size()) && (kindOfElement(rows.get(j)).kind !=KindRow.Round)){
        			Elements tds = rows.get(j).children();
        			Game game ;
        			
        			if(tds.size() >=6) {
        				if(kindOfElement(tds.get(0)).kind == KindRow.Date) {
        					date = kindOfElement(tds.get(0)).refrenceOfElement.text();
        					
        				}
        				if((tds.size() >= 6) && (kindOfElement(tds.get(2)).kind == KindRow.Team) && (kindOfElement(tds.get(4)).kind == KindRow.Team)){
        					game = new Game(date,
        							tds.get(1).text(),
        									kindOfElement(tds.get(2)).refrenceOfElement.text(),//first team
        									kindOfElement(tds.get(4)).refrenceOfElement.text(),//second team
        									kindOfElement(tds.get(5)).refrenceOfElement.text());//result
        					round.addGame(game);        					
        				}
        			}
        			j++;
        		}
        		gamesTable.addRound(round);
        	}
        	
        i++;}
       
        
       
        return gamesTable;
    }



    public KindOfRow kindOfElement(Element element) {
    	KindOfRow result = new KindOfRow();
        result.kind = KindRow.Error;
        
        if ((element != null) && (element.childrenSize() > 0)) {
            Elements children = element.children();
            
            for (Element child : children) {//for all children
                //round
                if (child.text().contains("Round")) {
                    result.refrenceOfElement = child;
                    result.kind = KindRow.Round;
                    return result;
                }//end round

                //date
                if (child.attr("href").contains("matches_today")) {
                	
                    result.refrenceOfElement = child;
                    result.kind = KindRow.Date;
                    return result;
                }//end date

                //team
                if (child.attr("href").contains("teams")) {
                    result.refrenceOfElement = child;
                    result.kind = KindRow.Team;
                    return result;
                }//end team

                //result of match
                if (child.text().contains(":") && (child.hasAttr("href"))) {//game´s time has : in new leagues
                    result.refrenceOfElement = child;
                    result.kind = KindRow.Result;
                    return result;
                }//end result of match

            }//for all children
        }//end if element.childrenSize() > 0

        //result for old league
        	//to distinguish  between time (hour) in new league
        	//next element is team? then return error
        if (element.text().contains(":") && (element.childrenSize() == 0)) {
            if ((element.nextElementSibling() != null) && (element.nextElementSibling().childrenSize() > 0)
                    && (element.nextElementSibling().children().hasAttr("href"))) { 
                return result;//return error
            } else {
                result.refrenceOfElement = element;
                result.kind = KindRow.Result;
                return result;
            }
        }////result for old league
        return result;
    }

    RankingTable getLastTable(String years) {
    	RankingTable  rankingTable = new RankingTable();
        //build url
        String competitionName = "eng-premier-league-";
        String url = "https://www.worldfootball.net/schedule/" + competitionName + years + "/";

        String htmlPage = httpUtil.sendGetHttpRequest(url);

        Document doc  = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        for (Element table : tables) {
            if (table.childrenSize() > 0) {
                if (table.children().text().contains("#")) {//ranking table
                	
                    Elements rows = table.select("tr");
                    int i =0;
                    
                    for (Element row : rows) {
                    if(i == 0) {i = 1;}//first element is the table´s header  
                    else {
                    
                            Club club = new Club();
                           
                            	club.setPosition(row.child(0).text());
                            	club.setName(row.child(2).text());
                            	club.setPlayedGames(row.child(3).text());
                            	club.setWinGames(row.child(4).text());
                            	club.setDrawGames(row.child(5).text());
                            	club.setLostGames(row.child(6).text());
                            	club.setGoals(row.child(7).text());
                            	club.setDifGoals(row.child(8).text());
                            	club.setPoints(row.child(9).text());
                            	
                            	rankingTable.addClub(club);
                    }
     
                        }
                    	}
       
                    }
                }
            
   
        
        return rankingTable;
        }
   
    RankingTable getTableByRound(String years, String round) {
        
    	RankingTable rankingTable = new RankingTable();
        String competition = "eng-premier-league-";
        String url = "https://www.worldfootball.net/schedule/" + competition + years + "-spieltag/" + round + "/";

        String htmlPage  = httpUtil.sendGetHttpRequest(url);

        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.getElementsByClass("standard_tabelle");
        for (Element table : tables) {
            if (table.childrenSize() > 0) {
                if (table.children().text().contains("#")) {//ranking table
                	
                    Elements rows = table.select("tr");
                    int i =0;
                    
                    for (Element row : rows) {
                    if(i == 0) {i = 1;}//the header
                    else {
                    
                            Club club = new Club();
                           
                            	club.setPosition(row.child(0).text());
                            	club.setName(row.child(2).text());
                            	club.setPlayedGames(row.child(3).text());
                            	club.setWinGames(row.child(4).text());
                            	club.setDrawGames(row.child(5).text());
                            	club.setLostGames(row.child(6).text());
                            	club.setGoals(row.child(7).text());
                            	club.setDifGoals(row.child(8).text());
                            	club.setPoints(row.child(9).text());
                            	
                            	rankingTable.addClub(club);
                    }
     
                        }
                    	
                }
            }
        }
                    return rankingTable;
                }

    //###############################################################################################
//###############################################################################################
    boolean hasResultForFirstHalf(String game) {
        if (game.contains("(")) {
            return true;
        }
        return false;
    }

    //###############################################################################################
//##############################################################################################
  
    ArrayList <Goal> getEventsOfGame(Element game) {

        String gameURL;
        gameURL = "https://www.worldfootball.net" + game.attr("href");
        
        return getEventsOfGame( gameURL);
       

    }
/***
 * 
 * @param game
 * @return goals and if it empty that means the result is (0:0)
 */
    public ArrayList <Goal> getEventsOfGame(String game) {

        String gameURL;
        Goal goal ;
        ArrayList <Goal> goals = new ArrayList<>();
        gameURL = game;
        String htmlPage;
        htmlPage = httpUtil.sendGetHttpRequest(gameURL);

        Document doc;//select("td[text()*=goals]");
        doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        Element tableOfGoals = getGoalsTable(tables);
        Elements rowOfGoals = tableOfGoals.select("tr");
        for (Element rowOfGoal : rowOfGoals) {
            if (rowOfGoal.text().contains("goals")) {//if the header
             
            }//if end the header
            else if (rowOfGoal.text().contains(":")) {//it is goal
            	goal = new Goal();
                if (kindOfGoal(rowOfGoal).equals(KindOfGoal.HasAssister)) {
                    goal.kind = KindOfGoal.HasAssister;
                    goal.result = rowOfGoal.child(0).text();
                    goal.player = rowOfGoal.child(1).child(0).attr("title");
                    goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
                    goal.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2, rowOfGoal.child(1).ownText().indexOf("(")-1);
                    goal.assester = rowOfGoal.child(1).child(1).attr("title");
                    goals.add(goal);
                } else if (kindOfGoal(rowOfGoal).equals(KindOfGoal.Individually)) {
                    goal.kind = KindOfGoal.Individually;
                    goal.result = rowOfGoal.child(0).text();
                    goal.player = rowOfGoal.child(1).child(0).attr("title");
                    goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
                    goal.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2);
                    goals.add(goal);
                } else if (kindOfGoal(rowOfGoal).equals(KindOfGoal.Reverse)) {
                    goal.kind = KindOfGoal.Reverse;
                    goal.result = rowOfGoal.child(0).text();
                    goal.player = rowOfGoal.child(1).child(0).attr("title");
                    goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
                    goal.information = "own goal";
                    goals.add(goal);
                    //goal.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/")+1);
                }
            }//end it is goal
        }
return goals;
    }

    //###############################################################################################
//##############################################################################################
    Element getGoalsTable(Elements tables) {
        Element tableOfGoals = null;
        for (Element table : tables) {
            if (table.text().contains("goals")) {
                return table;
            }
        }
        return tableOfGoals;
    }

    //###############################################################################################
//##############################################################################################
    KindOfGoal kindOfGoal(Element goal) {
        int numberOfPlayer = 0;

        if (goal.childrenSize() == 2) {

            for (Element grandson : goal.child(1).children()) {
                if (grandson.hasAttr("href")) {
                    numberOfPlayer++;
                }
            }
            if (numberOfPlayer == 2) {//to do
                return KindOfGoal.HasAssister;
            }

            if (goal.text().contains("own")) {
                return KindOfGoal.Reverse;
            } else {
                return KindOfGoal.Individually;

            }

        }
        //to ask hassan is better to throw error or !!!!!!!!!!!!!!!!!!!!!!
        return KindOfGoal.Error;

    }

	/***
	 *
	 * @param years
	 * years are the playing season, example 1990-1991
	 * @return
	 * the url to fetch the season
	 */
	private String buildGetEnglishPremierLeagueSeasonUrl(String years) {
		String url = WORLD_FOOTBALL_MATCHES_URL + "eng-premier-league-" + years + "/";
		return url;
	}
}//end ScreenScraper

