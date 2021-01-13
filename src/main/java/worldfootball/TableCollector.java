package worldfootball;

import worldfootball.models.ClubForRankingTable;
import worldfootball.models.RankingTable;
import worldfootball.models.RankingTableRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.HttpUtil;

public class TableCollector {
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLD_FOOTBALL_SCHEDULE_URL = "https://www.worldfootball.net/schedule/";

    public RankingTable getLastTable(String competitionName, String competitionYears) {
        String url = WORLD_FOOTBALL_SCHEDULE_URL + competitionName + "-" + competitionYears + "/";
        return getRankingTable(url);
    }

    public RankingTable getTableByRound(String competitionName, String competitionYears, String round , RankingTableRequest requestKind) {
        String url = WORLD_FOOTBALL_SCHEDULE_URL + competitionName + "-" + competitionYears + "-spieltag/" + round + requestKind.value() + "/";
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
                        ClubForRankingTable club = new ClubForRankingTable();
                        club.position = tr.child(0).text();
                        club.clubBasicInfo.name = tr.child(2).text();
                        club.playedGames = tr.child(3).text();
                        club.winGames = tr.child(4).text();
                        club.drawGames = tr.child(5).text();
                        club.lostGames = tr.child(6).text();
                        club.goals = tr.child(7).text();
                        club.diffirentGoals =tr.child(8).text();
                        club.points = tr.child(9).text();
                        rankingTable.table.add(club);
                    }
                }
            }
        }
        return rankingTable;
    }
}