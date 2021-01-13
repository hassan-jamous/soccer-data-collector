package worldfootball;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import worldfootball.models.PlayerTopScoreForSeason;
import worldfootball.models.PlayerTopSoccerAtSeason;
import util.HttpUtil;

public class TopScoreCollector {
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLD_FOOTBALL_SCORE_URL_AT_SEASON = "https://www.worldfootball.net/goalgetter/";
    private static final String WORRL_FOOTBALL_SCORE_FOR_ALL_YEAR = "https://www.worldfootball.net/top_scorer/";
   
    public ArrayList<PlayerTopSoccerAtSeason> getTopSoccerAtSeason(String competitionName, String competitionYears) {
        String url = WORLD_FOOTBALL_SCORE_URL_AT_SEASON + competitionName + "-" + competitionYears + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.select("table[class=standard_tabelle]");
        Elements table = tables.select("table:has(tbody:has(tr:has(th:contains(#)))) , table:has(tbody:has(tr:has(th:contains(Goals (Penalty)))))");
        Elements trs = table.select("tr");
        ArrayList<PlayerTopSoccerAtSeason> result = new ArrayList<>();
        //some players have the same ranking , but their ranking is not written
        //so we use variable ranking to store the value
        String ranking = "";
        for (int i = 1; i < trs.size(); i++) {
            PlayerTopSoccerAtSeason player = new PlayerTopSoccerAtSeason();
            if ((trs.get(i).child(0).hasText())) {
                ranking = trs.get(i).child(0).text();
            }
            player.playerRanking = ranking;
            player.playerBasicInfo.name = trs.get(i).child(1).text();
            player.playerNation = trs.get(i).child(3).text();
            player.playerClubName = trs.get(i).child(4).text();
            player.goals = trs.get(i).child(5).text().substring(0, trs.get(i).child(5).text().indexOf('(') - 1);
            player.penalty = trs.get(i).child(5).text().substring(trs.get(i).child(5).text().indexOf('(') + 1, trs.get(i).child(5).text().indexOf(')'));
            result.add(player);
        }

        return result;
    }
    public ArrayList<PlayerTopScoreForSeason> getTopSoccerForCompetitionAllYears(String competitionName) {
    	String url = WORRL_FOOTBALL_SCORE_FOR_ALL_YEAR + competitionName + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.select("table[class=standard_tabelle]");
        Elements table = tables.select("table:has(tbody:has(tr:has(td:contains(Season))))").select("table:has(tbody:has(tr:has(td:contains(Top scorer))))");
        Elements trs = table.select("tr");
        //some players have the same years , but their years is not written
        //so we use variable years to store the value
        String years = "";
        ArrayList<PlayerTopScoreForSeason> result = new ArrayList<>();
        for (int i = 1; i < trs.size(); i++) {
        	PlayerTopScoreForSeason player = new PlayerTopScoreForSeason();
            if ((trs.get(i).child(0).hasText())) {
            	years = trs.get(i).child(0).child(0).text();
            }
            player.competitionYears =  years;
            player.playerNation = trs.get(i).child(1).child(0).attr("title");
            player.playerInfo.name = trs.get(i).child(2).child(0).text();
            player.clubInfo.name = trs.get(i).child(4).child(0).attr("title");
            player.goals = trs.get(i).child(5).text();
            
            result.add(player);
        }

        return result;
    }

}
