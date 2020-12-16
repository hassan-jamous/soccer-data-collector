package collector;

import java.util.ArrayList;
import java.util.List;

import models.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScreenScraper {
    private static final String WORLD_FOOTBALL_MATCHES_URL = "https://www.worldfootball.net/all_matches/";
    private HttpUtil httpUtil = new HttpUtil();

    public GamesTableOfLeague getAllRounds(String competitionYears) {
        String htmlPage = httpUtil.sendGetHttpRequest(buildGetEnglishPremierLeagueSeasonUrl(competitionYears));
        Document doc = Jsoup.parse(htmlPage);
        Elements League = doc.getElementsByClass("standard_tabelle");
        Elements trs = League.select("tr");

        GamesTableOfLeague gamesTable = new GamesTableOfLeague(competitionYears);
        for (int i = 0; i < trs.size(); i++) {
            Element tr = trs.get(i);
            if (isRound(tr)) {
                Round round = new Round();
                round.setRoundNumber(getRoundValues(tr));
                round.games.addAll(ParseGamesInRound(trs, i));
                gamesTable.addRound(round);
            }
        }
        return gamesTable;
    }

    private List<Game> ParseGamesInRound(Elements trs, int startFromIndex) {
        int j = startFromIndex + 1;
        List<Game> output = new ArrayList<>();

        //In some cases game's date is mentioned only once for multiple games
        //that is why we need to keep the date in a variable and use it for each game.
        String date = "";
        while ((j < trs.size()) && (!isRound(trs.get(j))) && (isGame((trs.get(j))))) {
            Elements tds = trs.get(j).children();
            if (isGame(trs.get(j))) {
                String currentDate = getGameValues(tds.get(0) , GameIformationInTDs.Date);
                date = currentDate == null ? date : currentDate;
                Game game = new Game(date,
                		getGameValues(tds.get(1) , GameIformationInTDs.Time       ),
                		getGameValues(tds.get(2) , GameIformationInTDs.FirstTeam ),
                        getGameValues(tds.get(4) , GameIformationInTDs.SecondTeam),
                        getGameValues(tds.get(5) , GameIformationInTDs.Result    ));
                output.add(game);
            }
            j++;
        }
        return output;
    }

    private boolean isRound(Element tr) {
        if (tr != null) {
            for (Element td : tr.children()) {
                if (td.text().contains("Round")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isGame(Element tr) {
        if (tr != null) {
            int numberOfTeams = 0;
            for (Element td : tr.select("td")) {
                for (Element child : td.children()) {
                    if (child.attr("href").contains("teams")) {
                        numberOfTeams++;
                    }
                }
            }
            return numberOfTeams == 2;
        }
        return false;
    }
    public String getRoundValues(Element tr) {
    	
    	return tr.child(0).child(0).text();//tr.child(0) is <th> , tr.child(0).child(0) is <a> i do it {if we want to get the round큦 url , and to follow table큦tructural}
    }

    public String getGameValues(Element td , GameIformationInTDs type) {
    	if(type == GameIformationInTDs.Date) {
    		if(td.childrenSize() > 0) {//the game has date, maybe it does not have because it큦 date is the same to previous game큦 date     	
    			return td.child(0).text();
    		}
    		return null;
    	}
    	if(type == GameIformationInTDs.Time) {
    		return td.text();
    	}
    	if(type == GameIformationInTDs.FirstTeam) {
    		return td.child(0).text();//td.child(0) is <a> , i do it {if we want to get the first team큦 url , and to follow table큦tructural}
    	}
    	if(type == GameIformationInTDs.SecondTeam) {
    		return td.child(0).text();//td.child(0) is <a> , i do it {if we want to get the second team큦 url , and to follow table큦tructural}
    	}
    	if(type == GameIformationInTDs.Result) {
    		if(td.childrenSize() > 0) {
    			return td.child(0).text();//td.child(0) is <a> , i do it {if we want to get the result큦 url , and to follow table큦tructural}
    		}
    		return td.text();//old leagues
    	}
        return null;
    }

    RankingTable getLastTable(String years) {        
       
        String url = "https://www.worldfootball.net/schedule/eng-premier-league-" + years + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        RankingTable rankingTable = new RankingTable();
        for (Element table : tables) {
            if (table.childrenSize() > 0) {
            	//there are many tables have (class is standard_tabelle)
            	//only ranking table has this mark (#)
                if (table.children().text().contains("#")) {
                    Elements trs = table.select("tr");
                    int i = 0;
                    for (Element tr : trs) {
                        if (i == 0) {//first element is the table큦 header
                            i = 1;
                        }
                        else {
                            Club club = new Club();
                            club.setPosition(tr.child(0).text());
                            club.setName(tr.child(2).text());
                            club.setPlayedGames(tr.child(3).text());
                            club.setWinGames(tr.child(4).text());
                            club.setDrawGames(tr.child(5).text());
                            club.setLostGames(tr.child(6).text());
                            club.setGoals(tr.child(7).text());
                            club.setDifGoals(tr.child(8).text());
                            club.setPoints(tr.child(9).text());
                            rankingTable.addClub(club);
                        }
                    }
                }
            }
        }
        return rankingTable;
    }

    RankingTable getTableByRound(String years, String round) {

        
        String url = "https://www.worldfootball.net/schedule/eng-premier-league-" + years + "-spieltag/" + round + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        RankingTable rankingTable = new RankingTable();
        for (Element table : tables) {
            if (table.childrenSize() > 0) {
            	//there are many tables have (class is standard_tabelle)
            	//only ranking table has this mark (#)
                if (table.children().text().contains("#")) {
                    Elements trs = table.select("tr");
                    int i = 0;
                    for (Element tr : trs) {//the header
                        if (i == 0) {
                            i = 1;
                        }
                        else {
                            Club club = new Club();
                            club.setPosition(tr.child(0).text());
                            club.setName(tr.child(2).text());
                            club.setPlayedGames(tr.child(3).text());
                            club.setWinGames(tr.child(4).text());
                            club.setDrawGames(tr.child(5).text());
                            club.setLostGames(tr.child(6).text());
                            club.setGoals(tr.child(7).text());
                            club.setDifGoals(tr.child(8).text());
                            club.setPoints(tr.child(9).text());

                            rankingTable.addClub(club);
                        }
                    }
                }
            }
        }
        return rankingTable;
    }


    boolean hasResultForFirstHalf(String game) {
        if (game.contains("(")) {
            return true;
        }
        return false;
    }


    ArrayList<Goal> getEventsOfGame(Element game) {

        String gameURL;
        gameURL = "https://www.worldfootball.net" + game.attr("href");

        return getEventsOfGame(gameURL);


    }

    /***
     *
     * @param game
     * @return goals and if it empty that means the result is (0:0)
     */
    public ArrayList<Goal> getEventsOfGame(String gameURL) {

        
        String htmlPage = httpUtil.sendGetHttpRequest(gameURL);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        Element tableOfGoals = getGoalsTable(tables);
        Elements rowOfGoals = tableOfGoals.select("tr");
        Goal goal;
        ArrayList<Goal> goals = new ArrayList<>();
        for (Element rowOfGoal : rowOfGoals) {
            if (rowOfGoal.text().contains("goals")) {}//if the header           
            else if (rowOfGoal.text().contains(":")) {//it is goal
                goal = new Goal();
                if (rowOfGoal.child(1).ownText().equals("0.")) {//old league does not have any informations
                    goal.kind = KindOfGoal.OldGoal;
                    goal.result = rowOfGoal.child(0).text();
                    goal.player = rowOfGoal.child(1).child(0).attr("title");
                    goal.information = "0.";
                    goals.add(goal);
                } else {//new league
                    if (kindOfGoal(rowOfGoal).equals(KindOfGoal.HasAssister)) {
                        goal.kind = KindOfGoal.HasAssister;
                        goal.result = rowOfGoal.child(0).text();
                        goal.player = rowOfGoal.child(1).child(0).attr("title");
                        goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
                        goal.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2, rowOfGoal.child(1).ownText().indexOf("(") - 1);
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
                    }
                }
            }
        }
        return goals;
    }


    Element getGoalsTable(Elements tables) {
        Element tableOfGoals = null;
        for (Element table : tables) {
            if (table.text().contains("goals")) {
                return table;
            }
        }
        return tableOfGoals;
    }

    KindOfGoal kindOfGoal(Element goal) {
        int numberOfPlayer = 0;
        if (goal.childrenSize() == 2) {//goal has two children the first is the result and the second  who has the informations
            for (Element grandson : goal.child(1).children()) {
                if (grandson.hasAttr("href")) {
                    numberOfPlayer++;
                }
            }
            if (numberOfPlayer == 2) {
                return KindOfGoal.HasAssister;
            }
            if (goal.text().contains("own")) {
                return KindOfGoal.Reverse;
            } 
            else {
                return KindOfGoal.Individually;
            }
        }
        //to ask hassan is better to throw error or !!!!!!!!!!!!!!!!!!!!!! if some thing is wrong
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
	
	public ArrayList<Team> getTeamsAtSeason(String competitionYears) {		
		
		String url = "https://www.worldfootball.net/players/eng-premier-league-"+competitionYears+"/";
		String htmlPage = httpUtil.sendGetHttpRequest(url);
		Document doc = Jsoup.parse(htmlPage);
		
		Elements  tables = doc.getElementsByClass("standard_tabelle");
		Elements teams = tables.select("tr:has(td:has(a[href*=/teams/]))");
		ArrayList <Team> teamsInLeague = new ArrayList<>();
		Team teamInLeague ;
		for (Element team : teams) {
			teamInLeague = new Team();
			teamInLeague.setName(team.child(1).child(0).ownText());			
			teamsInLeague.add(teamInLeague);
		}
		return teamsInLeague;		
	}
	public ArrayList<Player> getTeamPlayers(String teamName , String year) {
		String url = "https://www.worldfootball.net/teams/"+teamName + "/" + year +"/2/";
		return getTeamPlayers(url);
	}
	//if i want to call it from squad
	public ArrayList<Player> getTeamPlayers(String url) {		
		
		String htmlPage = httpUtil.sendGetHttpRequest(url);
		Document doc = Jsoup.parse(htmlPage);		
		Elements  tables = doc.getElementsByClass("standard_tabelle");
		Elements rows = tables.select("tr");
		ArrayList <Player> players = new ArrayList <>();
		//They organize players in groups (Goal keeper, Defender , Midfielder , ......)
		//so player큦 information is mentioned only once for multiple players
        //that is why we need to keep the information in a variable and use it for each player
		String information ="";
		for(Element row : rows) {	
			if(kindHeaderOfPlayer(row) == KindOfPlayer.Goalkeeper) {
				information = "Goalkeeper" ;
			}
			else if(kindHeaderOfPlayer(row) == KindOfPlayer.Defender) {
				information = "Defender" ;
			}
			else if(kindHeaderOfPlayer(row) == KindOfPlayer.Midfielder) {
				information = "Midfielder" ;
			}
			else if(kindHeaderOfPlayer(row) == KindOfPlayer.Forward) {
				information = "Forward" ;				
			}
			else if(kindHeaderOfPlayer(row) == KindOfPlayer.Manager) {
				information = "Manager" ;				
			}
			else if(kindHeaderOfPlayer(row) == KindOfPlayer.AssistantManager) {
				information = "Ass. Manager" ;				
			}
			else if(kindHeaderOfPlayer(row) == KindOfPlayer.GoalkeeperCoach) {
				information = "Goalkeeper-Coach" ;				
			}
			else if(!(row.select("a[href*=/player_summary/]").isEmpty())) {//link to player summary
				Player player = new Player(row.child(1).text() , row.child(2).text(),row.child(4).text() , row.child(5).text(),information);
				players.add(player);
			} 
		}
		return players;
		
	}
	

	public KindOfPlayer kindHeaderOfPlayer(Element row) {
		KindOfPlayer result = KindOfPlayer.Error;
		if(row.getElementsByTag("b").text().equals("Goalkeeper")) {
			return KindOfPlayer.Goalkeeper;
		}
		if(row.getElementsByTag("b").text().equals("Defender")) {
			return KindOfPlayer.Defender;
		}
		if(row.getElementsByTag("b").text().equals("Midfielder")) {
			return KindOfPlayer.Midfielder;
		}
		if(row.getElementsByTag("b").text().equals("Forward")) {
			return KindOfPlayer.Forward;
		}
		if(row.getElementsByTag("b").text().equals("Manager")) {
			return KindOfPlayer.Manager;
		}
		if(row.getElementsByTag("b").text().equals("Ass. Manager")) {
			return KindOfPlayer.AssistantManager;
		}
		if(row.getElementsByTag("b").text().equals("Goalkeeper-Coach")) {
			return KindOfPlayer.GoalkeeperCoach;
		}
		return  result;
	}
	
}//end ScreenScraper

