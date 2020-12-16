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
    public static final String WORLD_FOOTBALL_SCHEDULE_URL = "https://www.worldfootball.net/schedule/";
    private HttpUtil httpUtil = new HttpUtil();

    public GamesTableOfLeague getAllRounds(String leagueName, String competitionYears) {
        String url = WORLD_FOOTBALL_MATCHES_URL + leagueName + "-" + competitionYears + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements League = doc.getElementsByClass("standard_tabelle");
        Elements trs = League.select("tr");

        GamesTableOfLeague gamesTable = new GamesTableOfLeague(competitionYears);
        for (int i = 0; i < trs.size(); i++) {
            Element tr = trs.get(i);
            if (isRound(tr)) {
                Round round = new Round();
                round.setRoundNumber(tr.child(0).child(0).text());
                round.games.addAll(ParseGamesInRound(trs, i));
                gamesTable.addRound(round);
            }
        }
        return gamesTable;
    }

    private List<Game> ParseGamesInRound(Elements trs, int startFromIndex) {
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

    private String getGameValues(Element tr, GameIformationInTDs type) {
        Elements tds = tr.children();
        //games might not have date because it shares the same date with other games
        if (type == GameIformationInTDs.Date && tds.get(0).childrenSize() > 0) {
            return tds.get(0).child(0).text();
        } else if (type == GameIformationInTDs.Time) {
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

    public RankingTable getLastTable(String leagueName, String years) {
        String url = WORLD_FOOTBALL_SCHEDULE_URL + leagueName + "-" + years + "/";
        return getRankingTable(url);
    }

    public RankingTable getTableByRound(String leagueName, String years, String round) {
        String url = WORLD_FOOTBALL_SCHEDULE_URL + leagueName + "-" + years + "-spieltag/" + round + "/";
        return getRankingTable(url);
    }

    private RankingTable getRankingTable(String url) {
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


    public ArrayList<Goal> getEventsOfGame(String gameURL) {
        String htmlPage = httpUtil.sendGetHttpRequest(gameURL);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        Element tableOfGoals = getGoalsTable(tables);
        Elements rowOfGoals = tableOfGoals.select("tr");
        ArrayList<Goal> goals = new ArrayList<>();
        for (Element rowOfGoal : rowOfGoals) {
            if (rowOfGoal.text().contains("goals")) {
            }//if the header
            else if (rowOfGoal.text().contains(":")) {//it is goal
                Goal goal = new Goal();
                if (rowOfGoal.child(1).ownText().equals("0.")) {//old league does not have any informations
                    goal.kind = KindOfGoal.OldGoal;
                    goal.result = rowOfGoal.child(0).text();
                    goal.player = rowOfGoal.child(1).child(0).attr("title");
                    goal.information = "0.";
                    goals.add(goal);
                } else {//new league
                    if (kindOfGoal(rowOfGoal) == KindOfGoal.HasAssister) {
                        goal.kind = KindOfGoal.HasAssister;
                        goal.result = rowOfGoal.child(0).text();
                        goal.player = rowOfGoal.child(1).child(0).attr("title");
                        goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
                        goal.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2, rowOfGoal.child(1).ownText().indexOf("(") - 1);
                        goal.assester = rowOfGoal.child(1).child(1).attr("title");
                        goals.add(goal);
                    } else if (kindOfGoal(rowOfGoal) == KindOfGoal.Individually) {
                        goal.kind = KindOfGoal.Individually;
                        goal.result = rowOfGoal.child(0).text();
                        goal.player = rowOfGoal.child(1).child(0).attr("title");
                        goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
                        goal.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2);
                        goals.add(goal);
                    } else if (kindOfGoal(rowOfGoal) == KindOfGoal.Reverse) {
                        goal.kind = KindOfGoal.Reverse;
                        goal.result = rowOfGoal.child(0).text();
                        goal.player = rowOfGoal.child(1).child(0).attr("title");
                        goal.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
                        goal.information = "own goal";
                        goals.add(goal);
                    }
                }
            }
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
        if (goal.childrenSize() == 2) {//goal has two children the first is the result and the second  who has the informations
            for (Element grandson : goal.child(1).children()) {
                if (grandson.hasAttr("href")) {
                    numberOfPlayer++;
                }
            }
            if (numberOfPlayer == 2) {
                return KindOfGoal.HasAssister;
            }
            if (goal.text().contains("own")) {
                return KindOfGoal.Reverse;
            } else {
                return KindOfGoal.Individually;
            }
        }
        throw new RuntimeException("Uknown Kind of Goal");
    }

    public ArrayList<Team> getTeamsAtSeason(String competitionYears) {

        String url = "https://www.worldfootball.net/players/eng-premier-league-" + competitionYears + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.getElementsByClass("standard_tabelle");
        Elements teams = tables.select("tr:has(td:has(a[href*=/teams/]))");
        ArrayList<Team> teamsInLeague = new ArrayList<>();
        Team teamInLeague;
        for (Element team : teams) {
            teamInLeague = new Team();
            teamInLeague.setName(team.child(1).child(0).ownText());
            teamsInLeague.add(teamInLeague);
        }
        return teamsInLeague;
    }

    public ArrayList<Player> getTeamPlayers(String teamName, String year) {
        String url = "https://www.worldfootball.net/teams/" + teamName + "/" + year + "/2/";
        return getTeamPlayers(url);
    }

    //if i want to call it from squad
    public ArrayList<Player> getTeamPlayers(String url) {

        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements tables = doc.getElementsByClass("standard_tabelle");
        Elements rows = tables.select("tr");
        ArrayList<Player> players = new ArrayList<>();
        //They organize players in groups (Goal keeper, Defender , Midfielder , ......)
        //so player�s information is mentioned only once for multiple players
        //that is why we need to keep the information in a variable and use it for each player
        String information = "";
        for (Element row : rows) {
            if (kindHeaderOfPlayer(row) == KindOfPlayer.Goalkeeper) {
                information = "Goalkeeper";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.Defender) {
                information = "Defender";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.Midfielder) {
                information = "Midfielder";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.Forward) {
                information = "Forward";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.Manager) {
                information = "Manager";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.AssistantManager) {
                information = "Ass. Manager";
            } else if (kindHeaderOfPlayer(row) == KindOfPlayer.GoalkeeperCoach) {
                information = "Goalkeeper-Coach";
            } else if (!(row.select("a[href*=/player_summary/]").isEmpty())) {//link to player summary
                Player player = new Player(row.child(1).text(), row.child(2).text(), row.child(4).text(), row.child(5).text(), information);
                players.add(player);
            }
        }
        return players;

    }


    public KindOfPlayer kindHeaderOfPlayer(Element row) {
        KindOfPlayer result = KindOfPlayer.Error;
        if (row.getElementsByTag("b").text().equals("Goalkeeper")) {
            return KindOfPlayer.Goalkeeper;
        }
        if (row.getElementsByTag("b").text().equals("Defender")) {
            return KindOfPlayer.Defender;
        }
        if (row.getElementsByTag("b").text().equals("Midfielder")) {
            return KindOfPlayer.Midfielder;
        }
        if (row.getElementsByTag("b").text().equals("Forward")) {
            return KindOfPlayer.Forward;
        }
        if (row.getElementsByTag("b").text().equals("Manager")) {
            return KindOfPlayer.Manager;
        }
        if (row.getElementsByTag("b").text().equals("Ass. Manager")) {
            return KindOfPlayer.AssistantManager;
        }
        if (row.getElementsByTag("b").text().equals("Goalkeeper-Coach")) {
            return KindOfPlayer.GoalkeeperCoach;
        }
        return result;
    }

}//end ScreenScraper

