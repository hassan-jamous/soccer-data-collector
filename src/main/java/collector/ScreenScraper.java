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
    public static final String WORLD_FOOTBALL_SCHEDULE_URL = "https://www.worldfootball.net/schedule/";
    private HttpUtil httpUtil = new HttpUtil();

    public GamesTableOfLeague getAllRounds(String leagueName, String competitionYears) {
        String url = WORLD_FOOTBALL_MATCHES_URL + leagueName + "-" + competitionYears + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements League = doc.getElementsByClass("standard_tabelle");
        Elements trs = League.select("tr");

        GamesTableOfLeague gamesTable = new GamesTableOfLeague(competitionYears);
        for (int i = 0; i < trs.size(); i++) {
            Element tr = trs.get(i);
            if (isRound(tr)) {
                Round round = new Round();
                round.setRoundNumber(tr.child(0).child(0).text());
                round.games.addAll(ParseGamesInRound(trs, i));
                gamesTable.addRound(round);
            }
        }
        return gamesTable;
    }

    private List<Game> ParseGamesInRound(Elements trs, int startFromIndex) {
        int j = startFromIndex + 1;
        List<Game> output = new ArrayList<>();

        //In some cases, game's date is shared among multiple game (i.e multiple games have the same date).
        //in this case the date is mentioned once
        //that is why we need to keep the date in a variable and use it for every game.
        String date = "";
        while ((j < trs.size()) && (!isRound(trs.get(j))) && (isGame((trs.get(j))))) {
            if (isGame(trs.get(j))) {
                String currentDate = getGameValues(trs.get(j), GameIformationInTDs.Date);
                date = currentDate == null ? date : currentDate;
                Game game = new Game(date,
                        getGameValues(trs.get(j), GameIformationInTDs.Time),
                        getGameValues(trs.get(j), GameIformationInTDs.FirstTeam),
                        getGameValues(trs.get(j), GameIformationInTDs.SecondTeam),
                        getGameValues(trs.get(j), GameIformationInTDs.Result));
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

    private String getGameValues(Element tr, GameIformationInTDs type) {
        Elements tds = tr.children();
        //games might not have date because it shares the same date with other games
        if (type == GameIformationInTDs.Date && tds.get(0).childrenSize() > 0) {
            return tds.get(0).child(0).text();
        } else if (type == GameIformationInTDs.Time) {
            return tds.get(1).text();
        } else if (type == GameIformationInTDs.FirstTeam) {
            return tds.get(2).child(0).text();
        } else if (type == GameIformationInTDs.SecondTeam) {
            return tds.get(4).child(0).text();
        } else if (type == GameIformationInTDs.Result && tds.get(5).childrenSize() > 0) {
            return tds.get(5).child(0).text();
        } else if (type == GameIformationInTDs.Result && tds.get(5).childrenSize() == 0) {
            //this is for old leagues, there is no children
            return tds.get(5).text();
        }
        return null;
    }

    public RankingTable getLastTable(String leagueName, String years) {
        String url = WORLD_FOOTBALL_SCHEDULE_URL + leagueName + "-" + years + "/";
        return getRankingTable(url);
    }

    public RankingTable getTableByRound(String leagueName, String years, String round) {
        String url = WORLD_FOOTBALL_SCHEDULE_URL + leagueName + "-" + years + "-spieltag/" + round + "/";
        return getRankingTable(url);
    }

    private RankingTable getRankingTable(String url) {
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        RankingTable rankingTable = new RankingTable();
        for (Element table : tables) {
            if (table.childrenSize() > 0) {
                //there are many tables with (class is standard_tabelle)
                //only ranking table has this mark (#)
                if (table.children().text().contains("#")) {
                    Elements trs = table.select("tr");
                    //the first row is the header, this is why i = 1;
                    for (int i = 1; i < trs.size(); i++) {
                        Element tr = trs.get(i);
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
        return rankingTable;
    }


    public ArrayList<Goal> getGoalsOfGame(String gameURL) {
    	
        String htmlPage = httpUtil.sendGetHttpRequest(gameURL);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        Element tableOfGoals = getGoalsTable(tables);
        Elements rowsOfGoals = tableOfGoals.select("tr");
        ArrayList<Goal> goals = new ArrayList<>();
      //the first row is the header, this is why i = 1;
        for(int i = 1 ; i < rowsOfGoals.size() ; i++) {//
        	if (rowsOfGoals.get(i).text().contains(":")) {//it is goal
                Goal goal = new Goal(); ;
                if (rowsOfGoals.get(i).child(1).ownText().equals("0.")) {//old league does not have any informations only has 0.
                   	goal = getGoal(rowsOfGoals.get(i) ,KindOfGoal.OldGoal );
                    goals.add(goal);
                } else {//new league
                    if (kindOfGoal(rowsOfGoals.get(i)) == KindOfGoal.HasAssister) {
                    	goal = getGoal(rowsOfGoals.get(i) ,KindOfGoal.HasAssister );
                        goals.add(goal);
                    } 
                    else if (kindOfGoal(rowsOfGoals.get(i)) == KindOfGoal.Individually) {
                    	goal = getGoal(rowsOfGoals.get(i) ,KindOfGoal.Individually );
                        goals.add(goal);
                    } 
                    else if (kindOfGoal(rowsOfGoals.get(i)) == KindOfGoal.Reverse) {
                    	goal = getGoal(rowsOfGoals.get(i) ,KindOfGoal.Reverse );
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
      //goal has two children the first is the result and the second  who has the informations
        if (goal.childrenSize() == 2) {
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
            } else {
                return KindOfGoal.Individually;
            }
        }
        throw new RuntimeException("Uknown Kind of Goal");
    }

    public Goal getGoal(Element rowOfGoal , KindOfGoal kind) {
    	Goal result = new Goal();
    	if(kind == KindOfGoal.OldGoal) {
    		result.kind = kind;
    		result.result = rowOfGoal.child(0).text();
    		result.player = rowOfGoal.child(1).child(0).attr("title");
    		result.information = "0.";
        }
    	else if(kind == KindOfGoal.HasAssister){
    		result.kind = kind;
            result.result = rowOfGoal.child(0).text();
            result.player = rowOfGoal.child(1).child(0).attr("title");
            result.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
            result.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2, rowOfGoal.child(1).ownText().indexOf("(") - 1);
            result.assester = rowOfGoal.child(1).child(1).attr("title");
    	}
    	else if(kind == KindOfGoal.Individually){
    		result.kind = kind;
            result.result = rowOfGoal.child(0).text();
            result.player = rowOfGoal.child(1).child(0).attr("title");
            result.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
            result.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2);
            
    	}
    	else if(kind == KindOfGoal.Reverse){ 
    		result.kind = kind;
    		result.result = rowOfGoal.child(0).text();
    		result.player = rowOfGoal.child(1).child(0).attr("title");
    		result.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
    		result.information = "own goal";
    		}
    		return result;
    }
   
    public ArrayList<Team> getTeamsAtSeason(String competitionYears) {

        String url = "https://www.worldfootball.net/players/eng-premier-league-" + competitionYears + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.getElementsByClass("standard_tabelle");
        Elements teams = tables.select("tr:has(td:has(a[href*=/teams/]))");
        ArrayList<Team> teamsInLeague = new ArrayList<>();
        Team teamInLeague;
        for (Element team : teams) {
            teamInLeague = new Team();
            teamInLeague.setName(team.child(1).child(0).ownText());
            teamsInLeague.add(teamInLeague);
        }
        return teamsInLeague;
    }

    public ArrayList<Player> getPlayersSummuryOfTeam(String teamName, String year) {
        String url = "https://www.worldfootball.net/teams/" + teamName + "/" + year + "/2/";
        return getPlayersSummuryOfTeam(url);
    }

    
    public ArrayList<Player> getPlayersSummuryOfTeam(String url) {

        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        Elements rows = tables.select("tr");
        ArrayList<Player> players = new ArrayList<>();
        //They organize players in groups (Goal keeper, Defender , Midfielder , ......)
        //so player´s information is mentioned only once for multiple players
        //that is why we need to keep the information in a variable and use it for each player
        String information = "";
        for (Element row : rows) {
            if (kindHeaderOfPlayer(row) == KindOfPlayer.Goalkeeper) {
                information = "Goalkeeper";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.Defender) {
                information = "Defender";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.Midfielder) {
                information = "Midfielder";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.Forward) {
                information = "Forward";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.Manager) {
                information = "Manager";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.AssistantManager) {
                information = "Ass. Manager";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.GoalkeeperCoach) {
                information = "Goalkeeper-Coach";
            } else if (!(row.select("a[href*=/player_summary/]").isEmpty())) {//link to player summary
                Player player = new Player(row.child(1).text(), row.child(2).text(), row.child(4).text(), row.child(5).text(), information);
                players.add(player);
            }
        }
        return players;

    }

    
    public KindOfPlayer kindHeaderOfPlayer(Element row) {
        KindOfPlayer result = KindOfPlayer.Error;
        if (row.getElementsByTag("b").text().equals("Goalkeeper")) {
            return KindOfPlayer.Goalkeeper;
        }
        else if (row.getElementsByTag("b").text().equals("Defender")) {
            return KindOfPlayer.Defender;
        }
        else if (row.getElementsByTag("b").text().equals("Midfielder")) {
            return KindOfPlayer.Midfielder;
        }
        else if (row.getElementsByTag("b").text().equals("Forward")) {
            return KindOfPlayer.Forward;
        }
        else if (row.getElementsByTag("b").text().equals("Manager")) {
            return KindOfPlayer.Manager;
        }
        else if (row.getElementsByTag("b").text().equals("Ass. Manager")) {
            return KindOfPlayer.AssistantManager;
        }
        else if (row.getElementsByTag("b").text().equals("Goalkeeper-Coach")) {
            return KindOfPlayer.GoalkeeperCoach;
        }
        return result;
    }

    public PlayerInformation getAllInformationAboutPlayer(String nameAsInURL) {//look to bruno-fernandes at manchester  united 2020 (url is bruno-fernandes_2) not just name
		
		String url = "https://www.worldfootball.net/player_summary/" + nameAsInURL +"/";
		
    	String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements divs = doc.getElementsByClass("box");
        
        Elements divTeamsManaged  = divs.select("div:has(div:has(h2:contains(Teams managed)))");
        Elements divClubCareer = divs.select("div:has(div:has(h2:contains(Club career)))");
        Elements divClubMatches = divs.select("div:has(div:has(h2:contains(Club matches)))");
        Elements divInternationals = divs.select("div:has(div:has(h2:contains(Internationals)))");
        Elements divPersonalInformation = divs.select("div:has(div:has(h2[itemprop=name]))");
        
        PlayerInformation playerTotalInfo = new PlayerInformation();
        playerTotalInfo.teamsManaged = getPlayerTeamManaged(divTeamsManaged);
        playerTotalInfo.clubsCareer = getClubCarrer(divClubCareer);
        playerTotalInfo.clubMatches = getPlayerClubsMatch(divClubMatches);
        playerTotalInfo.internationalCopmetitionsInfo = getPlayerInternatiols(divInternationals);
        playerTotalInfo.personalInfo = getPlayerPersonalInformation(divPersonalInformation);
        
        return playerTotalInfo;
        

    }
	
    
    public ArrayList <PlayerCompetitionsInformation> getPlayerClubsMatch(Elements div) {
		Elements trs = div.select("tr");
		PlayerCompetitionsInformation palyerInfoCompetition;
		ArrayList <PlayerCompetitionsInformation> result = new ArrayList<>();
		//if(!(getOverallIndexes(div).isEmpty())) {//has more information i.e {Overall international matches}
			//go to new url
		//}
		//else {
			for(int i = 1 ; i <trs.size() ; i++) {//we do not need the header ,because it does not have any information 
				palyerInfoCompetition = new PlayerCompetitionsInformation();
				if(trs.get(i).child(0).text().contains("∑")) {
					palyerInfoCompetition.competitionName = trs.get(i).child(0).text().replace("∑", "Total");
					palyerInfoCompetition.competitionNation = null;
					palyerInfoCompetition.matchesNumber = trs.get(i).child(1).text();
					
					palyerInfoCompetition.goalsNumber = trs.get(i).child(2).text();
					palyerInfoCompetition.startingLineUp = trs.get(i).child(3).text();
					palyerInfoCompetition.substitueIn = trs.get(i).child(4).text();
					palyerInfoCompetition.substitueOut = trs.get(i).child(5).text();
					palyerInfoCompetition.yellowCards = trs.get(i).child(6).text();
					palyerInfoCompetition.secondYellowCards = trs.get(i).child(7).text();
					palyerInfoCompetition.redCards = trs.get(i).child(8).text();
					result.add(palyerInfoCompetition);
				}
				else {
					palyerInfoCompetition.competitionName = trs.get(i).child(0).text();
					palyerInfoCompetition.competitionNation = trs.get(i).child(1).child(0).attr("title");				
					palyerInfoCompetition.matchesNumber = trs.get(i).child(2).text();
					palyerInfoCompetition.goalsNumber = trs.get(i).child(3).text();
					palyerInfoCompetition.startingLineUp = trs.get(i).child(4).text();
					palyerInfoCompetition.substitueIn = trs.get(i).child(5).text();
					palyerInfoCompetition.substitueOut = trs.get(i).child(6).text();
					palyerInfoCompetition.yellowCards = trs.get(i).child(7).text();
					palyerInfoCompetition.secondYellowCards = trs.get(i).child(8).text();
					palyerInfoCompetition.redCards = trs.get(i).child(9).text();
					result.add(palyerInfoCompetition);
				}
			}
		//}end else
		return result;
			
		
		
		
	} 
	
    
    public ArrayList <PlayerTeamManaged> getPlayerTeamManaged(Elements div) {
		Elements trs = div.select("tr");
		PlayerTeamManaged palyerTeamManaged;
		ArrayList <PlayerTeamManaged> result = new ArrayList<>();
		for(int i = 0 ; i <trs.size() ; i++) {
			palyerTeamManaged = new PlayerTeamManaged();
			
			palyerTeamManaged.date = trs.get(i).child(0).text();
			palyerTeamManaged.clubName = trs.get(i).child(2).text();
			palyerTeamManaged.clubNation = trs.get(i).child(3).child(0).attr("title");
			palyerTeamManaged.position = trs.get(i).child(4).text();
			
			result.add(palyerTeamManaged);
		}
		
		return result;
			
		
		
		
	} 
	
	
	
	
	
	
	
	
	
	
	public ArrayList<PlayerClubCareer> getClubCarrer(Elements div) {
		Elements trClubs = div.select("tr");
		ArrayList <PlayerClubCareer>result = new ArrayList<>();
		PlayerClubCareer club ; 
		for(int i =0 ; i < trClubs.size() ;i++) {
			
			
			if((i == 0) && (trClubs.get(0).child(1).attr("width").equals("60%"))) {//new version
					
				club = new PlayerClubCareer();
					                                 
				club.clubName = trClubs.get(0).child(1).child(0).child(0).text();
			
				club.clubNation = trClubs.get(0).child(1).child(1).child(0).attr("title");
				String playerPositionAndContract = trClubs.get(0).child(1).child(1).text(); 			
				club.playerPosition = playerPositionAndContract.substring(club.clubNation.length()+1, playerPositionAndContract.indexOf('/')-3);
					
				club.years = playerPositionAndContract.substring(playerPositionAndContract.indexOf('/')-2);
				club.playerNumber = trClubs.get(0).child(2).child(0).text();
				result.add(club);
				}
					
				
				
			
			
			else if( (trClubs.get(i).childrenSize() > 4)){
				club = new PlayerClubCareer();
				club.years = trClubs.get(i).child(0).text();
				club.clubName = trClubs.get(i).child(2).text();
				club.clubNation = trClubs.get(i).child(3).child(0).attr("title");
				club.playerPosition = trClubs.get(i).child(4).text();
				result.add(club);
			}
		}

		return result;
	}
	
	
	public ArrayList <PlayerCompetitionsInformation> getPlayerInternatiols(Elements div) {
		Elements trs = div.select("tr");
		PlayerCompetitionsInformation palyerInfoInternational;
		ArrayList <PlayerCompetitionsInformation> result = new ArrayList<>();
		for(int i = 1 ; i <trs.size() ; i++) {//header 
			palyerInfoInternational = new PlayerCompetitionsInformation();
			if(trs.get(i).child(0).text().contains("∑")) {
				palyerInfoInternational.competitionName = trs.get(i).child(0).text().replace("∑", "Total");
				palyerInfoInternational.competitionNation = null;
				palyerInfoInternational.matchesNumber = trs.get(i).child(1).text();
				palyerInfoInternational.goalsNumber = trs.get(i).child(2).text();
				palyerInfoInternational.startingLineUp = trs.get(i).child(3).text();
				palyerInfoInternational.substitueIn = trs.get(i).child(4).text();
				palyerInfoInternational.substitueOut = trs.get(i).child(5).text();
				palyerInfoInternational.yellowCards = trs.get(i).child(6).text();
				palyerInfoInternational.secondYellowCards = trs.get(i).child(7).text();
				palyerInfoInternational.redCards = trs.get(i).child(8).text();
				result.add(palyerInfoInternational);
			}
			else {
				palyerInfoInternational.competitionName = trs.get(i).child(0).text();
			
				palyerInfoInternational.competitionNation = trs.get(i).child(1).child(0).attr("title");
				palyerInfoInternational.matchesNumber = trs.get(i).child(2).text();
				palyerInfoInternational.goalsNumber = trs.get(i).child(3).text();
				palyerInfoInternational.startingLineUp = trs.get(i).child(4).text();
				palyerInfoInternational.substitueIn = trs.get(i).child(5).text();
				palyerInfoInternational.substitueOut = trs.get(i).child(6).text();
				palyerInfoInternational.yellowCards = trs.get(i).child(7).text();
				palyerInfoInternational.secondYellowCards = trs.get(i).child(8).text();
				palyerInfoInternational.redCards = trs.get(i).child(9).text();
				result.add(palyerInfoInternational);
			}
		}
		
		return result;
		
		
	}
	
	public PlayerPersonalInformation  getPlayerPersonalInformation(Elements divinfo) {
		Elements divs = divinfo.select("div");
		Element div = divs.get(0);
		PlayerPersonalInformation info = new PlayerPersonalInformation();
		
		
		info.name = div.child(1).text();
		//image child 2
		Elements tds = div.child(3).select("td");
		if(tds.size() >=15) {//new 
			info.fullName = tds.get(0).text();
			info.born = tds.get(3).text();
			info.birthPlace = tds.get(5).text();
			info.nationality = tds.get(7).text();
			info.height = tds.get(9).text();
			info.weight = tds.get(11).text();
			info.positions = tds.get(13).text();
			info.foot = tds.get(15).text();
		}
		else {
			info.fullName = tds.get(0).text();
			info.born = tds.get(3).text();
			info.birthPlace = tds.get(5).text();
			info.nationality = tds.get(7).text();
		}
		return info;
		
		}
		
	public  ArrayList<Integer> getOverallIndexes(Elements div) {
			ArrayList<Integer> result = new ArrayList<>();
			Elements trs = div.select("tr");
			for(int i = 0 ; i < trs.size() ; i++) {
				if(trs.get(i).child(trs.get(i).childrenSize() -1).text().contains("Overall")) {
					result.add(i);
				}
			}
			return result;
		}
	
		
		
		
	public ArrayList <PlayerCompetitionInformationOverall > getOverallCompetitionInformation(String url) {
			String htmlPage = httpUtil.sendGetHttpRequest(url);
	        Document doc = Jsoup.parse(htmlPage);	        
	        Elements trs = doc.select("tr");
	        ArrayList <PlayerCompetitionInformationOverall >result = new ArrayList <>();
	        PlayerCompetitionInformationOverall info ;
	        for(int i =1 ; i < trs.size() ; i++) {
	        	info = new PlayerCompetitionInformationOverall();
	        	                                  //---------td--------
	        	info.competitionNation             = trs.get(i).child(0).child(0).attr("title");
	        	info.competitionName               = trs.get(i).child(1).text();
	        	info.season                        = trs.get(i).child(2).text();
	        	info.team                          = trs.get(i).child(3).text();
	        	info.matches                       = trs.get(i).child(4).text();
	        	info.goals                         = trs.get(i).child(5).text();
	        	info.startingLineUp                = trs.get(i).child(6).text();
	        	info.substitueIn                   = trs.get(i).child(7).text();
	        	info.substituOut                   = trs.get(i).child(8).text();
	        	info.yellowCards                   = trs.get(i).child(9).text();
	        	info.secondYellowCards             = trs.get(i).child(10).text();
	        	info.redCards                      = trs.get(i).child(11).text();
	        	
	        	result.add(info);
	        	
	        }
			return result;
			
		}
	public MatchDetails matchesDetails(String matchAsURL) {
		
		MatchDetails result = new MatchDetails();
		String htmlPage = httpUtil.sendGetHttpRequest(matchAsURL);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        
        Elements elementBasicInfo = tables.select("table:has(th:has(a[href*=/teams/]))");
        Elements elementGoalsInfo = tables.select("table:has(td:contains(goals))");
        Elements elementClubsInfo  = tables.select("table:has(td[width=10%],[width=72%],[width=18%])");
        Elements elementManagersInfo = tables.select("table:has(th:contains(Manager:))");
        Elements elementMatchLocationRefeersAndOtherInfo = tables.select("table:has(img[title=stadium])");
        
        MatchDetails resultSummary = new MatchDetails();
        resultSummary  =getMatchSummry(elementBasicInfo);
        
        MatchDetails resultLocationAndRefereesAndOther = new MatchDetails();        
        resultLocationAndRefereesAndOther = getMatchLocationRefereesAndOtherInfo(elementMatchLocationRefeersAndOtherInfo);
        
        ArrayList <MatchDetailsClub> resultTeams = new ArrayList<>();
        resultTeams = getClubAtMatch(elementGoalsInfo,elementClubsInfo,elementManagersInfo);
        
        result.firstClub = resultTeams.get(0);
       
        result.firstClub.clubName = resultSummary.firstClub.clubName;
        result.secondClub = resultTeams.get(1);
        result.secondClub.clubName = resultSummary.secondClub.clubName;
        
        result.date = resultSummary.date;
        result.time = resultSummary.time;
        result.resultSummary = resultSummary.resultSummary;
        
        result.referees = resultLocationAndRefereesAndOther.referees;
        result.staduim  = resultLocationAndRefereesAndOther.staduim;
        result.attendance =resultLocationAndRefereesAndOther.attendance;
        
        System.out.println(result);
		return result;
	}
	 
	public ArrayList <MatchDetailsClub> getClubAtMatch(Elements tableGoals , Elements tableClubs , Elements tablesManager ) {
		ArrayList <MatchDetailsClub> result = new ArrayList<>();
		
		//player#############################################
		for(int clubIndex = 0 ; clubIndex < tableClubs.size() ; clubIndex++) {
			MatchDetailsClub club = new MatchDetailsClub();
			Elements trsTeam = tableClubs.get(clubIndex).select("tr");
			
			int indexOfSub = indexOfSubstiute(trsTeam);
			
			for(int i =0 ; i < trsTeam.size() ; i++) {
				
				if(i != indexOfSub) {
					if((i < indexOfSub) || (indexOfSub == -1)) { //indexOfSub ==-1 (i.e old league)
						PlayerAtMatch player = new PlayerAtMatch();
						                                         //----------td----------
						player.playerNumberAsString              = trsTeam.get(i).child(0).text();
						player.playerName                        = trsTeam.get(i).child(1).text();
						
						player.playerType = PlayerTypeAtMatch.Essential;
						//to get events     -------------td--------
						Elements elementPlayerEvents = trsTeam.get(i).select(" img , span[title*=at]");
						if(!(elementPlayerEvents.isEmpty())) {
							for(int eventIndex = 0 ; eventIndex <  elementPlayerEvents.size() ; eventIndex= eventIndex+2) {
								PlayerEventAtMatch event1 = new PlayerEventAtMatch();
								event1.event = elementPlayerEvents.get(eventIndex).attr("title");
								event1.minute  = elementPlayerEvents.get(eventIndex+1).attr("title").replace("at ", "");
								player.events.add(event1);
							}
						}
						
						if(trsTeam.get(i).child(2).hasText()) {
							PlayerEventAtMatch event1 = new PlayerEventAtMatch();
							event1.event = "out";
							event1.minute = trsTeam.get(i).child(2).text();
							player.events.add(event1);
						}
						club.players.add(player);
					}
					else {
						PlayerAtMatch player = new PlayerAtMatch();
		                                                         //----------td----------
						player.playerNumberAsString              = trsTeam.get(i).child(0).text();
						
						player.playerName                        = trsTeam.get(i).child(1).child(0).attr("title");
						player.playerType = PlayerTypeAtMatch.Substitute;
						//to get events     -------------td--------
						for(int j = 1 ; j < trsTeam.get(i).child(1).childrenSize() ; j=j+2) {//first child is his name
							PlayerEventAtMatch event1 = new PlayerEventAtMatch();
							event1.event = trsTeam.get(i).child(1).child(j).attr("title");
							event1.minute  = trsTeam.get(i).child(1).child(j+1).attr("title");
							player.events.add(event1);
						}
						if(trsTeam.get(i).child(2).hasText()) {
							PlayerEventAtMatch event1 = new PlayerEventAtMatch();
							event1.event = "in";
							event1.minute = trsTeam.get(i).child(2).text();
							player.events.add(event1);
						}
						club.players.add(player);
					}
				}
				
			}
			result.add(club);
		}
		//end player#############################################
		
		Elements thsManager = tablesManager.select("th");
		if(result.size()  == 2) {
			result.get(0).manager = thsManager.get(0).child(0).attr("title");
			result.get(1).manager = thsManager.get(1).child(0).attr("title");
		}
		
		//goals
		Elements trsGoals = tableGoals.select("tr");
		
		if(trsGoals.get(1).text().equals("none")) {
			
		}
		else {
			for(int ii =1 ; ii < trsGoals.size() ; ii++) {//we do not need the header
				Goal goal = new Goal();
				if(trsGoals.get(ii).child(1).attr("style").contains("padding-left: 50px")) {//second team
					
					if (trsGoals.get(ii).child(1).ownText().equals("0.")) {//old league does not have any informations only has 0.
	                   	goal = getGoal(trsGoals.get(ii) ,KindOfGoal.OldGoal );
	                   	result.get(1).goals.add(goal);
	                } else {//new league
	                    if (kindOfGoal(trsGoals.get(ii)) == KindOfGoal.HasAssister) {
	                    	goal = getGoal(trsGoals.get(ii) ,KindOfGoal.HasAssister );
	                    	result.get(1).goals.add(goal);
	                    } 
	                    else if (kindOfGoal(trsGoals.get(ii)) == KindOfGoal.Individually) {
	                    	goal = getGoal(trsGoals.get(ii) ,KindOfGoal.Individually );
	                    	result.get(1).goals.add(goal);
	                    } 
	                    else if (kindOfGoal(trsGoals.get(ii)) == KindOfGoal.Reverse) {
	                    	goal = getGoal(trsGoals.get(ii) ,KindOfGoal.Reverse );
	                    	result.get(1).goals.add(goal);
	                    }
	                }
					
			            
					
				}//end second team
				else {//first team
					if (trsGoals.get(ii).child(1).ownText().equals("0.")) {//old league does not have any informations only has 0.
	                   	goal = getGoal(trsGoals.get(ii) ,KindOfGoal.OldGoal );
	                   	result.get(0).goals.add(goal);
	                } else {//new league
	                    if (kindOfGoal(trsGoals.get(ii)) == KindOfGoal.HasAssister) {
	                    	goal = getGoal(trsGoals.get(ii) ,KindOfGoal.HasAssister );
	                    	result.get(0).goals.add(goal);
	                    } 
	                    else if (kindOfGoal(trsGoals.get(ii)) == KindOfGoal.Individually) {
	                    	goal = getGoal(trsGoals.get(ii) ,KindOfGoal.Individually );
	                    	result.get(0).goals.add(goal);
	                    } 
	                    else if (kindOfGoal(trsGoals.get(ii)) == KindOfGoal.Reverse) {
	                    	goal = getGoal(trsGoals.get(ii) ,KindOfGoal.Reverse );
	                    	result.get(0).goals.add(goal);
	                    }
	                }
				}//end first team
			}
		}
		return result;
		
	}
	public int indexOfSubstiute(Elements trs) {
		for(int i =0; i <trs.size() ; i++) {
			if(trs.get(i).html().contains("Substitutes")) {
				return i;
			}
		}
		
			return -1;// no sub
		
	}
	//get hour date result and clubs
	public MatchDetails  getMatchSummry(Elements tableBasicInfo) {
		MatchDetails result = new MatchDetails();
		if(tableBasicInfo.size() > 0) {//not null
			Elements trs = tableBasicInfo.get(0).select("tr");
			if(trs.size() == 2) {
				result.firstClub.clubName  = trs.get(0).child(0).text();
				if(trs.get(0).child(1).html().contains("<")) {
					result.date                = trs.get(0).child(1).html().substring(0, trs.get(0).child(1).html().indexOf('<'));
					result.time                = trs.get(0).child(1).html().substring(trs.get(0).child(1).html().indexOf('>')+1);
					result.resultSummary =     trs.get(0).child(1).text();
				}
				else {
					result.date                = trs.get(0).child(1).text();
					result.resultSummary =     trs.get(1).child(1).text();
				}
				result.secondClub.clubName = trs.get(0).child(2).text();
				
			}
		}
		return result;
	}
	public MatchDetails  getMatchLocationRefereesAndOtherInfo(Elements table) {
		MatchDetails result = new MatchDetails();
		if(table.size() == 1) {
			Elements elementStadium = table.get(0).select("tr:has(td:has(img[title=stadium]))");
			if(elementStadium != null) {result.staduim = elementStadium.text();}			
			
			Elements elementAttendance = table.get(0).select("tr:has(td:has(img[title=Attendance]))");
			if(elementAttendance != null) {result.attendance = elementAttendance.text();}
			
			Elements elementReferees = table.get(0).select("tr:has(td:has(img[title=Referee]))");
			if(elementReferees.size() > 0) {
				Referee referee = new Referee();
				referee.kind =  KindOfReferee.Referee;				
				referee.name =  elementReferees.text().substring(0, elementReferees.text().indexOf("(")-1);
				referee.nation =  elementReferees.text().substring(elementReferees.text().indexOf("(")+1 ,elementReferees.text().indexOf(")"));
				
				result.referees.add(referee);
			}
			Elements elementAssistantRefereeses = table.get(0).select("tr:has(td:has(img[title=Assistant Referee]))");
			if(elementAssistantRefereeses.size() > 0) {
				for(Element assistantRefere : elementAssistantRefereeses ) {
					Referee referee = new Referee();
					referee.kind =  KindOfReferee.AssistantReferee;				
					referee.name =  assistantRefere.text().substring(0, assistantRefere.text().indexOf("(")-1);
					referee.nation =  assistantRefere.text().substring(assistantRefere.text().indexOf("(")+1 ,assistantRefere.text().indexOf(")"));
					
					result.referees.add(referee);
				}
			}
			
			/*System.out.println(result.staduim);
			System.out.println(result.attendance);			
			for(int i =0; i<result.referees.size() ; i++) {
				System.out.println(result.referees.get(i));
			}*/
		}

		return result;
	}
	public ArrayList <ClubTansferTable> getTransferTableForAllClubs(String competitionYears) {
		
		String url = "https://www.worldfootball.net/transfers/eng-premier-league-" + competitionYears + "/";
		String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        //,width=30%,width=5%,width=10%,width=7%,width=38%]
        Elements divs1 = doc.select("div:has(div:has(h2))");
        ArrayList <ClubTansferTable> result = new ArrayList<>(); 
        ArrayList <Element> divs = getTransferDivs(divs1);
        for(Element div : divs) {
        	ClubTansferTable clubTransferTable = new ClubTansferTable();
        	clubTransferTable.clubName = div.child(0).child(0).ownText().substring(0, div.child(0).child(0).ownText().indexOf("»")-1);
        	clubTransferTable.season = competitionYears;        	
        	Elements trs = div.getElementsByTag("tr");
        	
        	TransferPlayerInformation playerTransfer;
        	for(int i=0; i<trs.size();i++ ) {//i=1 the header
        		Element tr = trs.get(i);
        		
        		
        		if(tr.text().equals("In")) {
        			int j=i+1;
        			
        			while(!(trs.get(j).text().equals("Out"))) {
        				playerTransfer = new TransferPlayerInformation();
        				playerTransfer.toClub = clubTransferTable.clubName ;
                                                       //-------td---------        				
        				playerTransfer.date            = trs.get(j).child(0).text();
        				playerTransfer.playerName      = trs.get(j).child(1).text();
        				
        				playerTransfer.playerNation    = trs.get(j).child(2).child(0).attr("title");
        				playerTransfer.playerPosition        = trs.get(j).child(3).text();
        				playerTransfer.fromClub        = trs.get(j).child(5).text();
        				j++;
        				clubTransferTable.transferPlayers.add(playerTransfer);
        				
        			}
        		}
        		else if(tr.text().equals("Out")) {
        			int j=i+1;
        			while(j < trs.size()) {
        			playerTransfer = new TransferPlayerInformation();
        			playerTransfer.toClub =  trs.get(j).child(5).text();
                                                   //-------td---------        				
					playerTransfer.date            = trs.get(j).child(0).text();
					playerTransfer.playerName      = trs.get(j).child(1).text();
					playerTransfer.playerNation    = trs.get(j).child(2).child(0).attr("title");
					playerTransfer.playerPosition        = trs.get(j).child(3).text();
					playerTransfer.fromClub        = clubTransferTable.clubName;
					j++;
					clubTransferTable.transferPlayers.add(playerTransfer);
        			}
        		}
        	}
       result.add(clubTransferTable);
        }
        
	return result;
	}
	public ArrayList<Element> getTransferDivs(Elements divs) {
		ArrayList <Element> result = new ArrayList<>();
		for(Element div : divs) {
			if(div.childrenSize() >= 2) {				
				if(div.child(0).tagName().equals("div") && (div.child(1).tagName().equals("div"))) {
					if(div.child(0).childrenSize() > 0) {
						if((div.child(0).child(0).tagName().equals("h2")) && (div.child(0).child(0).ownText().contains("Transfers"))) {
					
						result.add(div);
						}
						
					}
					
				}
				
			}
			}
		
		return result;
	}
	public ArrayList <PlayerTopSoccer> getTopSoccer(String competitionYears ) {
		
		String url = "https://www.worldfootball.net/goalgetter/eng-premier-league-" + competitionYears + "/";
		String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.select("table[class=standard_tabelle]");
        Elements table =getTopSoccerTable(tables); 
        Elements trs =table.select("tr");
        ArrayList <PlayerTopSoccer>  result = new ArrayList<>();
        String ranking="";
        for(int i = 1 ; i<trs.size() ; i++) {
        	PlayerTopSoccer player = new PlayerTopSoccer();
        	if((trs.get(i).child(0).hasText())) {
        		ranking = trs.get(i).child(0).text();
        	}
        	                    //-------td----------
        	player.playerRanking =  ranking;
        	player.playerName    = trs.get(i).child(1).text();
        	player.playerNation  = trs.get(i).child(3).text();
        	player.playerClubName= trs.get(i).child(4).text();
        	player.goals         = trs.get(i).child(5).text().substring(0, trs.get(i).child(5).text().indexOf('(')-1);
        	player.penalty = trs.get(i).child(5).text().substring(trs.get(i).child(5).text().indexOf('(')+1,trs.get(i).child(5).text().indexOf(')'));
       
        	result.add(player);
        
                }
       
           return result;
	}
	public Elements getTopSoccerTable(Elements tables) {
		Elements result = new Elements();
		for(Element table : tables) {
			if(table.childrenSize() > 0) {
				
				if(table.child(0).childrenSize()>0) {
					if((table.child(0).child(0).child(0).tagName().equals("th")) &&(table.child(0).child(0).child(0).ownText().equals("#"))) {
						result.add(table);
					}
				}
			}
		}
		return result;
	}
}//end ScreenScraper

