package collector;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import models.Club;
import models.KindOfPlayer;
import models.PlayerSummary;

public class ClubsCollector {
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLD_FOOTBALL_PLAYERS_URL = "https://www.worldfootball.net/players/";
    private static final String WORLD_FOOTBALL_CLUBS_URL = "https://www.worldfootball.net/teams/";
    
    public ArrayList<PlayerSummary> getAllPlayersSummaryInCompetition(String competitionName, String competitionYears) {
        String url = WORLD_FOOTBALL_PLAYERS_URL + competitionName + "-" + competitionYears;
        return getAllPlayersFromPage(url);
    }

    public ArrayList<PlayerSummary> getAllPlayersSummaryInClub(String clubName, String year) {
        String url = WORLD_FOOTBALL_CLUBS_URL + clubName + "/" + year + "/2/";
        return getAllPlayersFromPage(url);
    }


    public ArrayList<Club> getAllClubsInSeason(String competitionName ,String competitionYears) {
        String url = WORLD_FOOTBALL_PLAYERS_URL + competitionName +"-" + competitionYears + "/";
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

    private ArrayList<PlayerSummary> getAllPlayersFromPage(String url) {
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        Elements rows = tables.select("tr");
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
            	String playerNumber = (row.child(1).text().equals(""))? null : row.child(1).text() ;
                PlayerSummary player = new PlayerSummary(playerNumber, row.child(2).text(), row.child(4).text(), row.child(5).text(), information);
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
