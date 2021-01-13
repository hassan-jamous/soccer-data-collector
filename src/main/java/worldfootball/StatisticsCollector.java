package worldfootball;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import worldfootball.models.DirtyGame;
import worldfootball.models.StatisticsBestPlayerInYear;
import worldfootball.models.StatisticsGoalsPerRound;
import worldfootball.models.StatisticsGoalsPerSeason;
import worldfootball.models.StatisticsMostGoalsByPlayerPerGame;
import worldfootball.models.StatisticsRecordWinsAndMostGoalInGame;
import worldfootball.models.StatisticsRequestKind;
import util.HttpUtil;

public class StatisticsCollector {
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLDFOOTBALL_STATS_URL = "https://www.worldfootball.net/stats/";
    private static final String WORLDFOOTBALL_BEST_PLAYER_URL = "https://www.worldfootball.net/footballer_of_the_year/";

    public ArrayList<StatisticsGoalsPerSeason> getStatisticsGoalsPerSeason(String competitionName) {
        String url = WORLDFOOTBALL_STATS_URL + competitionName + "/1/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.select("table:eq(0):has(th:contains(Ø goals))");
        Elements trs = tables.select("tr");
        if(trs.isEmpty()) {return null;}
        ArrayList<StatisticsGoalsPerSeason> result = new ArrayList<>();

        for (int i = 1; i < trs.size(); i++) {//i=0 the header contains names of columns, so we start from 1
            StatisticsGoalsPerSeason clubInfo = new StatisticsGoalsPerSeason();
            clubInfo.seasonRankingNumber = (trs.get(i).child(0).text().equals("∑")) ? "TOTAL" : trs.get(i).child(0).text();
            clubInfo.seasonYears = trs.get(i).child(1).text();
            clubInfo.goals = trs.get(i).child(2).text();
            clubInfo.matchesNumber = trs.get(i).child(3).text();
            clubInfo.goalsPerMatch = trs.get(i).child(4).text();
            result.add(clubInfo);
        }
        return result;
    }

    public ArrayList<StatisticsGoalsPerRound> getStatisticsGoalsPerRound(String competitionName) {
        ArrayList<StatisticsGoalsPerRound> result = new ArrayList<>();
        String url = WORLDFOOTBALL_STATS_URL + competitionName + "/2/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.select("table:eq(0):has(th:contains(Ø goals))");
        Elements trs = tables.select("tr");
        if(trs.isEmpty()) {return null;}
        for (int i = 1; i < trs.size(); i++) {//i=0 the the header contains names of columns, so we start from 1
            StatisticsGoalsPerRound roundInfo = new StatisticsGoalsPerRound();
            roundInfo.roundRankingNumber = (trs.get(i).child(0).text().equals("∑")) ? "TOTAL" : trs.get(i).child(0).text();
            if (!(trs.get(i).child(0).text().equals("∑"))) {
                roundInfo.seasonYears = trs.get(i).child(1).child(0).text().substring(0, trs.get(i).child(1).text().indexOf("| ") - 1);
                roundInfo.round.roundNumberAsString = trs.get(i).child(1).text().substring(trs.get(i).child(1).text().indexOf("| ") + 2);
            } else {
                roundInfo.seasonYears = trs.get(i).child(1).child(0).text();
                roundInfo.round.roundNumberAsString = "all season";
            }
            roundInfo.goals = trs.get(i).child(2).text();
            roundInfo.matchesNumber = trs.get(i).child(3).text();
            roundInfo.goalsPerMatch = trs.get(i).child(4).text();
            result.add(roundInfo);
        }
        return result;
    }

    public ArrayList<StatisticsRecordWinsAndMostGoalInGame> getStatisticsRecordWinsOrMostGoalInGame(String competitionName, StatisticsRequestKind  kindOfRequest) {
        ArrayList<StatisticsRecordWinsAndMostGoalInGame> result = new ArrayList<>();
        String url = WORLDFOOTBALL_STATS_URL + competitionName + "/" + kindOfRequest.value() + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.select("table:eq(0):has(th:contains(guest)) , table:eq(0):has(th:contains(Season))");
        Elements trs = tables.select("tr");
        if(trs.isEmpty()) {return null;}
        for (int i = 1; i < trs.size(); i++) {//i=0 the the header contains names of columns, so we start from 1
            StatisticsRecordWinsAndMostGoalInGame winInfo = new StatisticsRecordWinsAndMostGoalInGame();
            winInfo.seasonYears = trs.get(i).child(0).text();
            winInfo.round.roundNumberAsString = trs.get(i).child(1).text();
            winInfo.matchDate = trs.get(i).child(2).text();
            winInfo.homeClubBasicInfo.name = trs.get(i).child(3).text();
            winInfo.matchResult = trs.get(i).child(5).text();
            winInfo.guestClubBasicInfo.name = trs.get(i).child(7).text();
            result.add(winInfo);
        }
        return result;
    }


    public ArrayList<StatisticsMostGoalsByPlayerPerGame> getStatisticsMostGoalsByPlayerInGameInCompetition(String competitionName) {
        ArrayList<StatisticsMostGoalsByPlayerPerGame> result = new ArrayList<>();
        String url = WORLDFOOTBALL_STATS_URL + competitionName + "/5/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        
        Elements divsA = doc.select("div.box");
        Elements divs = divsA.select("div:has(div:has(table:has(tbody:has(tr:has(th:contains(Player)))))) , div:has(div:has(table:has(tbody:has(tr:has(th:contains(Guest))))))");
        //we have one table for each number of goals
        if(divs.isEmpty()) {return null;}

        for (int divIndex = 0; divIndex < divs.size(); divIndex++) {
        	
            String maxNumberOfGoals = divs.get(divIndex).child(0).child(0).text().substring(divs.get(divIndex).child(0).child(0).text().indexOf("»") +2 , divs.get(divIndex).child(0).child(0).text().indexOf("Goals")-1);
            Elements trs = divs.get(divIndex).select("tr");
            for (int i = 0; i < trs.size(); i++) {
                if (trs.get(i).childrenSize() == 7) {
                	StatisticsMostGoalsByPlayerPerGame gameAndPlayer = new StatisticsMostGoalsByPlayerPerGame();
                	gameAndPlayer.playerInfo.name = trs.get(i).child(0).text();
                    gameAndPlayer.gameInfo.date = trs.get(i).child(1).text();
                    gameAndPlayer.gameInfo.firstTeamBasicInfo.name = trs.get(i).child(2).text();
                    gameAndPlayer.gameInfo.finalResult = trs.get(i).child(4).text();
                    gameAndPlayer.gameInfo.secondTeamBasicInfo.name = trs.get(i).child(6).text();
                    gameAndPlayer.numberOfGoal = maxNumberOfGoals;
                    
                    result.add(gameAndPlayer);
                }
            }
        }
        return result;
    }

    public ArrayList<DirtyGame> getStatisticsDirtiesGamesForCompetition(String competitionName) {
        ArrayList<DirtyGame> result = new ArrayList<>();
        String url = WORLDFOOTBALL_STATS_URL + competitionName + "/6/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.select("table.standard_tabelle:has(tbody:has(tr:has(th:has(img[alt*=Red cards]))))");
        Elements trs = tables.select("tr");
        if(trs.isEmpty()) {return null;}

        for (int i = 1; i < trs.size(); i++) {//i=0 the the header contains names of columns
            DirtyGame dirtyGameInfo = new DirtyGame();
            dirtyGameInfo.gameNormalInfo.date = trs.get(i).child(0).text();
            dirtyGameInfo.gameNormalInfo.firstTeamBasicInfo.name = trs.get(i).child(1).text();
            dirtyGameInfo.gameNormalInfo.finalResult = trs.get(i).child(3).text();
            dirtyGameInfo.gameNormalInfo.secondTeamBasicInfo.name = trs.get(i).child(5).text();
            dirtyGameInfo.redCards = trs.get(i).child(6).text();
            dirtyGameInfo.secondYellowCards = trs.get(i).child(7).text();
            dirtyGameInfo.yellowCards = trs.get(i).child(8).text();
            dirtyGameInfo.dirtyPoints = trs.get(i).child(9).text();
            result.add(dirtyGameInfo);
        }
        return result;
    }

    public ArrayList<StatisticsBestPlayerInYear> getStatisticsBestPlayerInYear(String country) {
        ArrayList<StatisticsBestPlayerInYear> result = new ArrayList<>();
        String url = WORLDFOOTBALL_BEST_PLAYER_URL + country + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.select("table.standard_tabelle:has(tbody:has(tr:contains(Year))),table.standard_tabelle:has(tbody:has(tr:contains(Player)))");
        Elements trs = tables.select("tr");
        if(trs.isEmpty()) {return null;}

        for (int i = 1; i < trs.size(); i++) {//i=0 the the header contains names of columns
            StatisticsBestPlayerInYear bestPlayerInfo = new StatisticsBestPlayerInYear();
            bestPlayerInfo.year = trs.get(i).child(0).text();
            bestPlayerInfo.playerBasicInfo.name = trs.get(i).child(1).text();
            result.add(bestPlayerInfo);
        }
        return result;
    }

    
}
