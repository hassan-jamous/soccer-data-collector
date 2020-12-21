package collector;

import models.Club;
import models.RankingTable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TableCollector {
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLD_FOOTBALL_SCHEDULE_URL = "https://www.worldfootball.net/schedule/";

    public RankingTable getLastTable(String leagueName, String years) {
        String url = WORLD_FOOTBALL_SCHEDULE_URL + leagueName + "-" + years + "/";
        return getRankingTable(url);
    }

    public RankingTable getTableByRound(String leagueName, String years, String round) {
        String url = WORLD_FOOTBALL_SCHEDULE_URL + leagueName + "-" + years + "-spieltag/" + round + "/";
        return getRankingTable(url);
    }

    RankingTable getRankingTable(String url) {
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
}