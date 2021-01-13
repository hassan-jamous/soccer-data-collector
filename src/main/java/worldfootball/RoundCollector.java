package worldfootball;

import worldfootball.models.Game;
import worldfootball.models.GameIformationInTDs;
import worldfootball.models.GamesTableOfLeague;
import worldfootball.models.Round;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class RoundCollector {
    private static final String WORLD_FOOTBALL_MATCHES_URL = "https://www.worldfootball.net/all_matches/";
    private static final String WORLD_FOOTBALL_SITE_URL = "https://www.worldfootball.net/";
    private HttpUtil httpUtil = new HttpUtil();

    public GamesTableOfLeague getAllRounds(String competitoinName, String competitionYears) {
        String url = WORLD_FOOTBALL_MATCHES_URL + competitoinName + "-" + competitionYears + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements League = doc.getElementsByClass("standard_tabelle");
        Elements trs = League.select("tr");

        GamesTableOfLeague gamesTable = new GamesTableOfLeague(competitionYears);
        for (int i = 0; i < trs.size(); i++) {
            Element tr = trs.get(i);
            if (isRound(tr)) {
                Round round = new Round();
                round.roundNumberAsString = tr.child(0).child(0).text();
                Elements link = tr.select("a[href*=/schedule/]");
                if((link != null) && !(link.isEmpty()) ) {
                	
                }
                round.games.addAll(ParseGamesInRound(trs, i , link ));
                gamesTable.rounds.add(round);
            }
        }
        return gamesTable;
    }

    private List<Game> ParseGamesInRound(Elements trs, int startFromIndex , Elements link) {
        int j = startFromIndex + 1;
        List<Game> output = new ArrayList<>();

        //In some cases, game's date is shared among multiple game (i.e multiple games have the same date).
        //in this case the date is mentioned once
        //that is why we need to keep the date in a variable and use it for every game.
        String date = "";
        while ((j < trs.size()) && (!isRound(trs.get(j))) && (isGame((trs.get(j))))) {
            if (isGame(trs.get(j))) {
                String currentDate = getGameValues(trs.get(j), GameIformationInTDs.Date);
               
                date = currentDate == null ? date : currentDate;
                if(date.equals("")) {//in the first game the date =="" like 3.Round in 1925-1926
                	date = getRoundDate(WORLD_FOOTBALL_SITE_URL+ link.get(0).attr("href"));
                }
                Game game = new Game(date,
                        getGameValues(trs.get(j), GameIformationInTDs.Time),
                        getGameValues(trs.get(j), GameIformationInTDs.FirstTeam),
                        getGameValues(trs.get(j), GameIformationInTDs.SecondTeam),
                        getGameValues(trs.get(j), GameIformationInTDs.Result));
                output.add(game);
            }
            j++;
        }
        return output;
    }

    private boolean isGame(Element tr) {
        if (tr != null) {
            int numberOfTeams = 0;
            for (Element td : tr.select("td")) {
                for (Element child : td.children()) {
                    if (child.attr("href").contains("teams")) {
                        numberOfTeams++;
                    }
                }
            }
            return numberOfTeams == 2;
        }
        return false;
    }

    private boolean isRound(Element tr) {
        if (tr != null) {
            for (Element td : tr.children()) {
                if (td.text().contains("Round")) {
                    return true;
                }
            }
        }
        return false;
    }

    private String getGameValues(Element tr, GameIformationInTDs type) {
        Elements tds = tr.children();
        //games might not have date because it shares the same date with other games
        if (type == GameIformationInTDs.Date && tds.get(0).childrenSize() > 0) {
            return tds.get(0).child(0).text();
        } else if (type == GameIformationInTDs.Time) {
            if(tds.get(1).text().equals("")) {
            	return null;
            }
        	return tds.get(1).text();
        } else if (type == GameIformationInTDs.FirstTeam) {
            return tds.get(2).child(0).text();
        } else if (type == GameIformationInTDs.SecondTeam) {
            return tds.get(4).child(0).text();
        } else if (type == GameIformationInTDs.Result && tds.get(5).childrenSize() > 0) {
            return tds.get(5).child(0).text();
        } else if (type == GameIformationInTDs.Result && tds.get(5).childrenSize() == 0) {
            //this is for old leagues, there is no children
            return tds.get(5).text();
        }
        return null;
    }
    
    private String getRoundDate(String roundURL) {
        String htmlPage = httpUtil.sendGetHttpRequest(roundURL);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.select("table.standard_tabelle");
        Elements roundTable = tables.select("table:has(tbody:has(tr:has(td[nowrap=nowrap]):contains(/)))");

        Elements trs =roundTable.select("tr");

        if (isGame(trs.get(0))) {
        	return trs.get(0).child(0).text();
        }
        
        throw new RuntimeException();
    }
}
