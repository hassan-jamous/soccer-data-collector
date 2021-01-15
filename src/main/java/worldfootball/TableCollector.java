package worldfootball;

import worldfootball.models.Club;
import worldfootball.models.ClubForRankingTable;
import worldfootball.models.RankingTable;
import worldfootball.models.RankingTableRequest;

import java.util.ArrayList;

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

    public RankingTable getTableByRound(String competitionName, String competitionYears, String round, RankingTableRequest requestKind) {
        String url = WORLD_FOOTBALL_SCHEDULE_URL + competitionName + "-" + competitionYears + "-spieltag/" + round + requestKind.value() + "/";
        return getRankingTable(url);
    }

    private RankingTable getRankingTable(String url) {
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements elementRankingTable = doc.select("table.standard_tabelle").select("table:has(tbody:has(tr:has(th:contains(#))))");
        RankingTable rankingTable = new RankingTable();
        Elements trs = elementRankingTable.select("tr");
        //the first row is the header, this is why i = 1;
        for (int i = 1; i < trs.size(); i++) {
        	if(rankingTable.table == null) {rankingTable.table = new ArrayList<>();}
	        rankingTable.table.add(getClub(trs.get(i)));
        }
        return rankingTable;
    }

	private ClubForRankingTable getClub(Element tr) {
		ClubForRankingTable club = new ClubForRankingTable();
		club.position = tr.child(0).text();
		club.clubBasicInfo = new Club(tr.child(2).text());
		club.playedGames = tr.child(3).text();
		club.winGames = tr.child(4).text();
		club.drawGames = tr.child(5).text();
		club.lostGames = tr.child(6).text();
		club.goals = tr.child(7).text();
		club.diffirentGoals = tr.child(8).text();
		club.points = tr.child(9).text();
		return club;
	}
}