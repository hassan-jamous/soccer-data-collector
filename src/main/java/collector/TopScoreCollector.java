package collector;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import models.PlayerTopSoccer;

public class TopScoreCollector {

	private HttpUtil httpUtil = new HttpUtil();
	private static final String WORLD_FOOTBALL_SCORE_URL ="https://www.worldfootball.net/goalgetter/eng-premier-league-";

	public ArrayList <PlayerTopSoccer> getTopSoccerAtSeason(String competitionYears ) {
		
		String url = WORLD_FOOTBALL_SCORE_URL + competitionYears + "/";
		String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.select("table[class=standard_tabelle]");
        Elements table =getTopSoccerTable(tables); 
        Elements trs =table.select("tr");
        ArrayList <PlayerTopSoccer>  result = new ArrayList<>();
        //some players have the same ranking , but their ranking is not written
        //so we use variable ranking to store the value
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
	

	

	private Elements getTopSoccerTable(Elements tables) {
		Elements result = new Elements();
		for(Element table : tables) {
			if(table.childrenSize() > 0) {				
				if(table.child(0).childrenSize()>0) {
					if((table.child(0).child(0).child(0).tagName().equals("th")) 
							&&(table.child(0).child(0).child(0).ownText().equals("#"))) {
						result.add(table);
					}
				}
			}
		}
		return result;
	}
	
}
