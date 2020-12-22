package collector;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import models.KindOfPlayer;
import models.Player;
import models.Team;

public class TeamsCollector {

	private HttpUtil httpUtil = new HttpUtil();
	private static final String WORLD_FOOTBALL_PLAYERS_URL ="https://www.worldfootball.net/players/";
	
	public ArrayList<Player> getAllPlayersSummuryInCompetition(String competitionName , String competitionYears) {
		String url =WORLD_FOOTBALL_PLAYERS_URL + competitionName +"-" + competitionYears;
		return getAllPlayersFromPage(url);
        
    }

	public ArrayList<Player> getAllPlayersSummuryInTeam(String teamName, String year) {
        String url = "https://www.worldfootball.net/teams/" + teamName + "/" + year + "/2/";
        return getAllPlayersFromPage(url);
    }

	public ArrayList<Team> getAllTeamsInSeason(String competitionYears) {

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
	
	
    private ArrayList<Player> getAllPlayersFromPage(String url) {
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
    
    
    private KindOfPlayer kindHeaderOfPlayer(Element row) {
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

}
