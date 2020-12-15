package collector;

import java.util.ArrayList;
import java.util.List;

import models.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScreenScraper {
    private static final String WORLD_FOOTBALL_MATCHES_URL = "https://www.worldfootball.net/all_matches/";
    private HttpUtil httpUtil = new HttpUtil();

    public GamesTableOfLeague getAllRounds(String competitionYears) {
        String htmlPage = httpUtil.sendGetHttpRequest(buildGetEnglishPremierLeagueSeasonUrl(competitionYears));
        Document doc = Jsoup.parse(htmlPage);
        Elements League = doc.getElementsByClass("standard_tabelle");
        Elements rows = League.select("tr");

        GamesTableOfLeague gamesTable = new GamesTableOfLeague(competitionYears);
        for (int i = 0; i < rows.size(); i++) {
            Element row = rows.get(i);
            if (isRound(row)) {
                Round round = new Round();
                round.setRoundNumber(getRoundAndGameElementValues(row));
                round.games.addAll(ParseGamesInRound(rows, i));
                gamesTable.addRound(round);
            }
        }
        return gamesTable;
    }

    private List<Game> ParseGamesInRound(Elements rows, int startFromIndex) {
        int j = startFromIndex + 1;
        List<Game> output = new ArrayList<>();

        //In some cases game's date is mentioned only once for multiple games
        //that is why we need to keep the date in a variable and use it for each game.
        String date = "";
        while ((j < rows.size()) && (!isRound(rows.get(j)))) {
            Elements tds = rows.get(j).children();
            if (isGame(rows.get(j))) {
                String currentDate = getRoundAndGameElementValues(tds.get(0));
                date = currentDate == null ? date : currentDate;
                Game game = new Game(date,
                        tds.get(1).text(),
                        getRoundAndGameElementValues(tds.get(2)),
                        getRoundAndGameElementValues(tds.get(4)),
                        getRoundAndGameElementValues(tds.get(5)));
                output.add(game);
            }
            j++;
        }
        return output;
    }

    private boolean isRound(Element row) {
        if (row != null) {
            for (Element child : row.children()) {
                if (child.text().contains("Round")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isGame(Element row) {
        if (row != null) {
            int numberOfTeams = 0;
            for (Element td : row.select("td")) {
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


    public String getRoundAndGameElementValues(Element element) {
        if ((element != null) && (element.childrenSize() > 0)) {
            Elements children = element.children();
            for (Element child : children) {
                if (child.text().contains("Round")) {
                    return child.text();
                } else if (child.attr("href").contains("matches_today")) {
                    return child.text();
                } else if (child.attr("href").contains("teams")) {
                    return child.text();
                } else if (child.text().contains(":") && (child.hasAttr("href"))) {//this is game result
                    return child.text();
                }
            }
        }

        //result for old league
        //to distinguish  between time (hour) in new league
        //next element is team? then return error
        if (element.text().contains(":") && (element.childrenSize() == 0)) {
            if ((element.nextElementSibling() != null) && (element.nextElementSibling().childrenSize() > 0)
                    && (element.nextElementSibling().children().hasAttr("href"))) {
                return null;//return error
            } else {
                return element.text();
            }
        }////result for old league
        return null;
    }

    RankingTable getLastTable(String years) {
        RankingTable rankingTable = new RankingTable();
        //build url
        String competitionName = "eng-premier-league-";
        String url = "https://www.worldfootball.net/schedule/" + competitionName + years + "/";

        String htmlPage = httpUtil.sendGetHttpRequest(url);

        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        for (Element table : tables) {
            if (table.childrenSize() > 0) {
                if (table.children().text().contains("#")) {//ranking table

                    Elements rows = table.select("tr");
                    int i = 0;

                    for (Element row : rows) {
                        if (i == 0) {
                            i = 1;
                        }//first element is the table�s header
                        else {

                            Club club = new Club();

                            club.setPosition(row.child(0).text());
                            club.setName(row.child(2).text());
                            club.setPlayedGames(row.child(3).text());
                            club.setWinGames(row.child(4).text());
                            club.setDrawGames(row.child(5).text());
                            club.setLostGames(row.child(6).text());
                            club.setGoals(row.child(7).text());
                            club.setDifGoals(row.child(8).text());
                            club.setPoints(row.child(9).text());

                            rankingTable.addClub(club);
                        }

                    }
                }

            }
        }


        return rankingTable;
    }

    RankingTable getTableByRound(String years, String round) {

        RankingTable rankingTable = new RankingTable();
        String competition = "eng-premier-league-";
        String url = "https://www.worldfootball.net/schedule/" + competition + years + "-spieltag/" + round + "/";

        String htmlPage = httpUtil.sendGetHttpRequest(url);

        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.getElementsByClass("standard_tabelle");
        for (Element table : tables) {
            if (table.childrenSize() > 0) {
                if (table.children().text().contains("#")) {//ranking table

                    Elements rows = table.select("tr");
                    int i = 0;

                    for (Element row : rows) {
                        if (i == 0) {
                            i = 1;
                        }//the header
                        else {

                            Club club = new Club();

                            club.setPosition(row.child(0).text());
                            club.setName(row.child(2).text());
                            club.setPlayedGames(row.child(3).text());
                            club.setWinGames(row.child(4).text());
                            club.setDrawGames(row.child(5).text());
                            club.setLostGames(row.child(6).text());
                            club.setGoals(row.child(7).text());
                            club.setDifGoals(row.child(8).text());
                            club.setPoints(row.child(9).text());

                            rankingTable.addClub(club);
                        }

                    }

                }
            }
        }
        return rankingTable;
    }


    boolean hasResultForFirstHalf(String game) {
        if (game.contains("(")) {
            return true;
        }
        return false;
    }


    ArrayList<Goal> getEventsOfGame(Element game) {

        String gameURL;
        gameURL = "https://www.worldfootball.net" + game.attr("href");

        return getEventsOfGame(gameURL);


    }

    /***
     *
     * @param game
     * @return goals and if it empty that means the result is (0:0)
     */
    public ArrayList<Goal> getEventsOfGame(String game) {

        String gameURL;
        Goal goal;
        ArrayList<Goal> goals = new ArrayList<>();
        gameURL = game;
        String htmlPage;
        htmlPage = httpUtil.sendGetHttpRequest(gameURL);

        Document doc;//select("td[text()*=goals]");
        doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        Element tableOfGoals = getGoalsTable(tables);
        Elements rowOfGoals = tableOfGoals.select("tr");
        for (Element rowOfGoal : rowOfGoals) {
            if (rowOfGoal.text().contains("goals")) {//if the header

            }//if end the header
            else if (rowOfGoal.text().contains(":")) {//it is goal
                goal = new Goal();
                if (rowOfGoal.child(1).ownText().equals("0.")) {//old league has not informations
                    goal.kind = KindOfGoal.OldGoal;
                    goal.result = rowOfGoal.child(0).text();
                    goal.player = rowOfGoal.child(1).child(0).attr("title");
                    goal.information = "0.";
                    goals.add(goal);
                } else {//new league
                    if (kindOfGoal(rowOfGoal).equals(KindOfGoal.HasAssister)) {
                        goal.kind = KindOfGoal.HasAssister;
                        goal.result = rowOfGoal.child(0).text();
                        goal.player = rowOfGoal.child(1).child(0).attr("title");
                        goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
                        goal.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2, rowOfGoal.child(1).ownText().indexOf("(") - 1);
                        goal.assester = rowOfGoal.child(1).child(1).attr("title");
                        goals.add(goal);
                    } else if (kindOfGoal(rowOfGoal).equals(KindOfGoal.Individually)) {
                        goal.kind = KindOfGoal.Individually;
                        goal.result = rowOfGoal.child(0).text();
                        goal.player = rowOfGoal.child(1).child(0).attr("title");
                        goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
                        goal.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2);
                        goals.add(goal);
                    } else if (kindOfGoal(rowOfGoal).equals(KindOfGoal.Reverse)) {
                        goal.kind = KindOfGoal.Reverse;
                        goal.result = rowOfGoal.child(0).text();
                        goal.player = rowOfGoal.child(1).child(0).attr("title");
                        goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
                        goal.information = "own goal";
                        goals.add(goal);
                    }
                }//end new league
            }//end it is goal
        }
        return goals;
    }


    Element getGoalsTable(Elements tables) {
        Element tableOfGoals = null;
        for (Element table : tables) {
            if (table.text().contains("goals")) {
                return table;
            }
        }
        return tableOfGoals;
    }

    KindOfGoal kindOfGoal(Element goal) {
        int numberOfPlayer = 0;

        if (goal.childrenSize() == 2) {

            for (Element grandson : goal.child(1).children()) {
                if (grandson.hasAttr("href")) {
                    numberOfPlayer++;
                }
            }
            if (numberOfPlayer == 2) {//to do
                return KindOfGoal.HasAssister;
            }

            if (goal.text().contains("own")) {
                return KindOfGoal.Reverse;
            } else {
                return KindOfGoal.Individually;

            }

        }
        //to ask hassan is better to throw error or !!!!!!!!!!!!!!!!!!!!!!
        return KindOfGoal.Error;

    }

    /***
     *
     * @param years
     * years are the playing season, example 1990-1991
     * @return
     * the url to fetch the season
     */
    private String buildGetEnglishPremierLeagueSeasonUrl(String years) {
        String url = WORLD_FOOTBALL_MATCHES_URL + "eng-premier-league-" + years + "/";
        return url;
    }
}//end ScreenScraper

