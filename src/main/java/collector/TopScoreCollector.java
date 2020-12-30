package collector;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import models.PlayerTopSoccer;

public class TopScoreCollector {
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLD_FOOTBALL_SCORE_URL = "https://www.worldfootball.net/goalgetter/";

    public ArrayList<PlayerTopSoccer> getTopSoccerAtSeason(String competitionName, String competitionYears) {
        String url = WORLD_FOOTBALL_SCORE_URL + competitionName + "-" + competitionYears + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.select("table[class=standard_tabelle]");
        Elements table = tables.select("table:has(tbody:has(tr:has(th:contains(#)))) , table:has(tbody:has(tr:has(th:contains(Goals (Penalty)))))");
        Elements trs = table.select("tr");
        ArrayList<PlayerTopSoccer> result = new ArrayList<>();
        //some players have the same ranking , but their ranking is not written
        //so we use variable ranking to store the value
        String ranking = "";
        for (int i = 1; i < trs.size(); i++) {
            PlayerTopSoccer player = new PlayerTopSoccer();
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
}
