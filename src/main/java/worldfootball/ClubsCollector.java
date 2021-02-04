package worldfootball;

import java.util.ArrayList;
import java.util.TreeSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import worldfootball.models.Club;
import worldfootball.models.KindOfPlayer;
import worldfootball.models.Player;
import worldfootball.models.PlayerSummary;
import util.HttpUtil;

/**
 *Collects 2 kind of information 
 *club squad from  https://www.worldfootball.net/players/eng-premier-league-2020-2021/
 *clubs in competition at the season
 */
public class ClubsCollector {
	
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLD_FOOTBALL_URL = "https://www.worldfootball.net";
    private static final String WORLD_FOOTBALL_PLAYERS_URL = "https://www.worldfootball.net/players/";
    private static final String WORLD_FOOTBALL_CLUBS_URL = "https://www.worldfootball.net/teams/";
    private static final String WORLD_FOOTBALL_ROUND_URL ="https://www.worldfootball.net/schedule/";
    public ArrayList<PlayerSummary> getClubSquad(String clubName, String year) {
        String url = WORLD_FOOTBALL_CLUBS_URL + clubName + "/" + year + "/2/";
        return getAllPlayersFromPage(url);
    }

    public int getNumberOfRoundInCompetition(String competitionRoundsURL ) {
    	
    	String url = WORLD_FOOTBALL_URL+"/players/"+competitionRoundsURL;
    	String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements table = doc.select("table.standard_tabelle").select("table:has(tbody:has(tr:has(td:contains(Appearances))))").select("table:has(tbody:has(tr:has(td:contains(Squad [))))");
        Elements trs = table.select("tr");
        return (trs.size()-1)*2;
    }
    
    public String getCompetitionLeagueForClubInYear(String club , String year) {
    	String leagueYear = (year.length()>6)?year:Integer.valueOf(year)-1+"/"+Integer.valueOf(year);
    	String url = WORLD_FOOTBALL_CLUBS_URL+club+"/"+leagueYear.substring(5,9)+"/3/";
    	String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.select("table.standard_tabelle").select("table:has(tbody:has(tr:has(td:has(a[href*=/all_matches]))))");
        for(Element table : tables) {
        	Elements trs = table.select("tr");
        	String leagueURL="";
            boolean isLeague; 
        	for(int tr=0; tr<trs.size();tr++ ) {        		
        		if(isCompetitionHeader(trs.get(tr))) {//competition
        			leagueURL = trs.get(tr).child(0).child(0).attr("href").replace("/all_matches", "");
        			isLeague = true;
        			int game= tr+2;
        			while(game <trs.size() && (! isCompetitionHeader(trs.get(game)))) {//not header
            			if(isGame(trs.get(game))) {
            				if(trs.get(game).child(0).text().contains("Week") || trs.get(game).child(0).text().contains("Group") 
            						|| trs.get(game).child(0).text().contains("inal")//finals or Final
            						|| trs.get(game).child(0).text().contains("of")) {
            					isLeague=false;
            					break;
            				}
            			}
            			game++;
            		}
        			//after all trs in this competition
                	if(isLeague == true) {
                		isLeague = isRoundInLeague(trs.get(tr+2));
                		if(isLeague) {return leagueURL;}
                	}
        		}       		
        	}        	
        }//or return no league!!!!!!!!!!!!!
        throw new RuntimeException(club +" did not play in any league at "+year);       
    }

    private boolean isRoundInLeague(Element tr) {

    	String roundURL = WORLD_FOOTBALL_ROUND_URL+tr.child(0).child(0).attr("href");
    	String htmlPage = httpUtil.sendGetHttpRequest(roundURL);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.select("table.standard_tabelle").select("table:has(tbody:has(tr:has(th:contains(#))))")
        		.select("table:has(tbody:has(tr:has(th:contains(Dif.))))");
        if(tables.size()==1) {return true;}
        return false;
    }
	private boolean isCompetitionHeader(Element tr) {
		if( tr.select("a[href*=/all_matches]")!= null && tr.select("a[href*=/all_matches]").size()==1) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isGame(Element tr) {
		if( tr.childrenSize()==8 && tr.child(4).child(0).attr("href").contains("/teams/") && tr.child(5).child(0).attr("href").contains("/teams/")) {
			return true;
		}
		return false;
	}

    public ArrayList<Club> getAllClubsInSeason(String competitionName, String competitionYears) {
        String url = WORLD_FOOTBALL_PLAYERS_URL + competitionName + "-" + competitionYears + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        Elements clubs = tables.select("tr:has(td:has(a[href*=/teams/]))");
        ArrayList<Club> result = new ArrayList<>();
        Club clubInLeague;
        for (Element tr : clubs) {
            clubInLeague = new Club();
            clubInLeague.name = tr.child(1).child(0).ownText();
            result.add(clubInLeague);
        }
        return result;
    }
    
    public TreeSet <String> getAllClubsInCompetition(String competitionName, String startSeason , String endSeason) {

    	TreeSet <String> result = new TreeSet <>();
        int firstyear = Integer.valueOf(startSeason.substring(0,4));
        int firstYearOfLastSeason=Integer.valueOf(endSeason.substring(0,4));
        for(int year = firstyear; year <=firstYearOfLastSeason; year++ ) {
        	String competitionFirstYear = String.valueOf(year);
        	String competitionsecondYear = String.valueOf(year+1);
        	String competitionYears = competitionFirstYear+"-"+competitionsecondYear;
        	ArrayList<Club> clubsInSeason = getAllClubsInSeason(competitionName,competitionYears);
        	for(int club =0 ; club < clubsInSeason.size(); club++) {
        		result.add(clubsInSeason.get(club).name);
        	}
        }
        return result;
    }

    
    private ArrayList<PlayerSummary> getAllPlayersFromPage(String url) {
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        Elements rows = tables.select("tr");
        if (rows.isEmpty()) {
            return null;
        }
        ArrayList<PlayerSummary> players = new ArrayList<>();
        //They organize players in groups (Goal keeper, Defender, Midfielder, ......)
        //so player's information is mentioned only once for multiple players
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
                String playerNumber = (row.child(1).text().equals("")) ? null : row.child(1).text();
                PlayerSummary player = new PlayerSummary(playerNumber, new Player(row.child(2).text()), row.child(4).text(), row.child(5).text(), information);
                players.add(player);
            }
        }
        return players;
    }

    private KindOfPlayer kindHeaderOfPlayer(Element row) {
        KindOfPlayer result = KindOfPlayer.Error;
        if (row.getElementsByTag("b").text().equals("Goalkeeper")) {
            return KindOfPlayer.Goalkeeper;
        } else if (row.getElementsByTag("b").text().equals("Defender")) {
            return KindOfPlayer.Defender;
        } else if (row.getElementsByTag("b").text().equals("Midfielder")) {
            return KindOfPlayer.Midfielder;
        } else if (row.getElementsByTag("b").text().equals("Forward")) {
            return KindOfPlayer.Forward;
        } else if (row.getElementsByTag("b").text().equals("Manager")) {
            return KindOfPlayer.Manager;
        } else if (row.getElementsByTag("b").text().equals("Ass. Manager")) {
            return KindOfPlayer.AssistantManager;
        } else if (row.getElementsByTag("b").text().equals("Goalkeeper-Coach")) {
            return KindOfPlayer.GoalkeeperCoach;
        }
        return result;
    }
}
