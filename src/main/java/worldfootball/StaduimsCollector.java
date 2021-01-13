package worldfootball;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import worldfootball.models.Staduim;
import util.HttpUtil;

public class StaduimsCollector {
	
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLDFOOTBALL_VENUES_URL = "https://www.worldfootball.net/venues/";

	public ArrayList<Staduim> getCompetitionSatuims(String competitionName, String competitionYears) {
        ArrayList<Staduim> result = new ArrayList<>();
        String url = WORLDFOOTBALL_VENUES_URL + competitionName + "-" + competitionYears + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.select("table:has(tbody:has(tr:has(th:contains(stadium)))) , table:has(tbody:has(tr:has(th:contains(Country))))");
        Elements trs = tables.select("tr");
        if(trs.isEmpty()) {return null;}

        for (int i = 1; i < trs.size(); i++) {//i=0 the the header contains names of columns
            Staduim staduimInfo = new Staduim();
            staduimInfo.name = trs.get(i).child(1).text();
            staduimInfo.city = trs.get(i).child(2).text();
            staduimInfo.country = trs.get(i).child(4).text();
            staduimInfo.capacity = trs.get(i).child(5).text();
            result.add(staduimInfo);
        }
        return result;
    }
}
