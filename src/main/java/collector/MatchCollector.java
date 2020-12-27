package collector;

import java.util.ArrayList;


import models.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MatchCollector {
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLD_FOOTBALL_MATCH_URL = "https://www.worldfootball.net/report/";
    private GoalsCollector goalsCollector = new GoalsCollector();

    public MatchDetails getMatchDetails(String competitionName, String competitionYears, String firstClub, String secondClub) {
        String matchURL = WORLD_FOOTBALL_MATCH_URL + competitionName + "-" + competitionYears + "-" + firstClub + "-" + secondClub + "/";
        String htmlPage = httpUtil.sendGetHttpRequest(matchURL);

        Document doc = Jsoup.parse(htmlPage);
        Elements allTablesInPage = doc.getElementsByClass("standard_tabelle");

        MatchDetails result = new MatchDetails();

        result.matchSummary = getMatchSummary(allTablesInPage);
        result.firstClub = getClubInformation(allTablesInPage, 0, result.matchSummary.firstClub);
        result.secondClub = getClubInformation(allTablesInPage, 1, result.matchSummary.secondClub);

        //todo
        //make this a function to get extra info
        Elements elementMatchLocationRefeersAndOtherInfo = allTablesInPage.select("table:has(img[title=stadium])");
        result.referees = getRefereesInMatch(elementMatchLocationRefeersAndOtherInfo);
        Elements elementStadium = elementMatchLocationRefeersAndOtherInfo.get(0).select("tr:has(td:has(img[title=stadium]))");
        if (elementStadium != null) {
            result.staduim = elementStadium.text();
        }

        Elements elementAttendance = elementMatchLocationRefeersAndOtherInfo.get(0).select("tr:has(td:has(img[title=Attendance]))");
        if (elementAttendance != null) {
            result.attendance = elementAttendance.text();
        }
        return result;
    }

    private ClubInMatch getClubInformation(Elements allTablesInPage, int teamNumber, String clubName) {
        Elements elementClubsInfo = allTablesInPage.select("table:has(td[width=10%],[width=72%],[width=18%])");
        Elements elementManagersInfo = allTablesInPage.select("table:has(th:contains(Manager:))");
        Elements elementGoalsInfo = allTablesInPage.select("table:has(td:contains(goals))");

        ClubInMatch result = new ClubInMatch();
        result.players = getClubPlayersInMatch(elementClubsInfo.get(teamNumber));
        result.manager = elementManagersInfo.get(0).select("a").get(teamNumber).attr("title");
        if (result.manager.startsWith(" ")) {
            result.manager = result.manager.substring(1);
        }
        result.goals = getGoalsInMatch(elementGoalsInfo, teamNumber);
        result.clubName = clubName;
        return result;
    }

    private MatchSummary getMatchSummary(Elements allTablesInPage) {
        Elements elementBasicInfo = allTablesInPage.select("table:has(th:has(a[href*=/teams/]))");
        MatchSummary result = new MatchSummary();
        if (elementBasicInfo.size() > 0) {
            Elements trs = elementBasicInfo.get(0).select("tr");
            if (trs.size() == 2) {
                result.firstClub = trs.get(0).child(0).text();
                result.secondClub = trs.get(0).child(2).text();
                result.resultSummary = trs.get(1).child(1).text();
                if (trs.get(0).child(1).html().contains("<")) {//new league contains time not only the date
                    result.date = trs.get(0).child(1).html().substring(0, trs.get(0).child(1).html().indexOf('<'));
                    result.time = trs.get(0).child(1).html().substring(trs.get(0).child(1).html().indexOf('>') + 1);
                } else { // old league information
                    result.date = trs.get(0).child(1).text();
                }
            } else {
                throw new RuntimeException("Unexpected match summary details");
            }
        }
        return result;
    }

    private ArrayList<Referee> getRefereesInMatch(Elements allTablesInPage) {
        ArrayList<Referee> result = new ArrayList<>();
        Elements refereesElement = allTablesInPage.get(0).select("tr:has(td:has(img[title=Referee]))");

        if (refereesElement.size() > 0) {
            Referee referee = new Referee();
            referee.kind = KindOfReferee.Referee;
            referee.name = refereesElement.text().substring(0, refereesElement.text().indexOf("(") - 1);
            referee.nation = refereesElement.text().substring(refereesElement.text().indexOf("(") + 1, refereesElement.text().indexOf(")"));
            result.add(referee);
        }
        Elements assistantRefereesElement = allTablesInPage.get(0).select("tr:has(td:has(img[title=Assistant Referee]))");
        if (assistantRefereesElement.size() > 0) {
            for (Element assistantReferee : assistantRefereesElement) {
                Referee referee = new Referee();
                referee.kind = KindOfReferee.AssistantReferee;
                referee.name = assistantReferee.text().substring(0, assistantReferee.text().indexOf("(") - 1);
                referee.nation = assistantReferee.text().substring(assistantReferee.text().indexOf("(") + 1, assistantReferee.text().indexOf(")"));
                result.add(referee);
            }
        }
        return result;
    }


    //todo
    //no copy paste
    private ArrayList<PlayerAtMatch> getClubPlayersInMatch(Element tableClubPlayer) {
        ArrayList<PlayerAtMatch> result = new ArrayList();
        Elements trsTeam = tableClubPlayer.select("tr");

        int indexOfRowWithSubstitutesTitle = getIndexOfRowWithSubstitutesTitle(trsTeam);

        for (int i = 0; i < trsTeam.size(); i++) {
            if ((indexOfRowWithSubstitutesTitle != -1 && i < indexOfRowWithSubstitutesTitle) || indexOfRowWithSubstitutesTitle == -1) {// not Substitute
                PlayerAtMatch player = new PlayerAtMatch();
                player.playerNumberAsString = trsTeam.get(i).child(0).text();
                player.playerName = trsTeam.get(i).child(1).child(0).text();
                if (player.playerName.startsWith(" ")) {//some names begin with space
                    player.playerName = player.playerName.substring(1);
                }

                player.playerType = PlayerTypeAtMatch.Essential;
                player.events = getPlayerEventsInMatch(trsTeam.get(i).child(1));

                if (trsTeam.get(i).child(2).hasText()) {
                    PlayerEventAtMatch event1 = new PlayerEventAtMatch();
                    event1.event = "out";
                    event1.minute = trsTeam.get(i).child(2).text().substring(0, trsTeam.get(i).child(2).text().length() - 1);
                    player.events.add(event1);
                }
                result.add(player);
            } else if (indexOfRowWithSubstitutesTitle != -1 && i > indexOfRowWithSubstitutesTitle) {//substitute
                PlayerAtMatch player = new PlayerAtMatch();
                player.playerNumberAsString = trsTeam.get(i).child(0).text();
                player.playerName = trsTeam.get(i).child(1).child(0).attr("title");
                player.playerType = PlayerTypeAtMatch.Substitute;
                player.events = getPlayerEventsInMatch(trsTeam.get(i).child(1));

                if (trsTeam.get(i).child(2).hasText()) {
                    PlayerEventAtMatch event1 = new PlayerEventAtMatch();
                    event1.event = "in";
                    event1.minute = trsTeam.get(i).child(2).text().substring(0, trsTeam.get(i).child(2).text().length() - 1);
                    player.events.add(event1);
                }
                result.add(player);
            }
        }
        return result;
    }

    ///to get events
    //image contains  the name of event (red card  , yellow card ,....) and the next span contains the time
    //eventIndex+2 (i.e) event's name and it's time
    private ArrayList<PlayerEventAtMatch> getPlayerEventsInMatch(Element TdPlayer) {
        ArrayList<PlayerEventAtMatch> result = new ArrayList<>();
        Elements elementPlayerEvents = TdPlayer.select(" img , span[title*=at]");
        if (!(elementPlayerEvents.isEmpty())) {
            for (int eventIndex = 0; eventIndex < elementPlayerEvents.size(); eventIndex = eventIndex + 2) {
                PlayerEventAtMatch event1 = new PlayerEventAtMatch();
                event1.event = elementPlayerEvents.get(eventIndex).attr("title");
                event1.minute = elementPlayerEvents.get(eventIndex + 1).attr("title").substring(3, 5);
                result.add(event1);
            }
        }
        return result;
    }

    private int getIndexOfRowWithSubstitutesTitle(Elements trs) {
        for (int i = 0; i < trs.size(); i++) {
            if (trs.get(i).html().contains("Substitutes")) {
                return i;
            }
        }
        return -1;// no sub (i.e old league)
    }

    //{club ==0 first team} or {club == 1 second team}
    private ArrayList<Goal> getGoalsInMatch(Elements goalsTable, int club) {
        ArrayList<Goal> result = new ArrayList<>();
        Elements trs = goalsTable.select("tr");

        if (trs.get(1).text().equals("none")) {
            return result;
        }

        for (int i = 1; i < trs.size(); i++) {//the header contains (goals)
            if (club == 0) {
                if (!(trs.get(i).child(1).attr("style").contains("padding-left: 50px"))) {
                    if ((trs.get(i).child(1).ownText().equals("0."))) {//old league does not have any information, it only has 0.
                        Goal goal = new Goal();
                        goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.OldGoal);
                        result.add(goal);
                    } else {//new league

                        if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.HasAssister) {
                            Goal goal = new Goal();
                            goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.HasAssister);
                            result.add(goal);
                        } else if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.Individually) {
                            Goal goal = new Goal();
                            goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.Individually);
                            result.add(goal);
                        } else if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.Reverse) {
                            Goal goal = new Goal();
                            goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.Reverse);
                            result.add(goal);
                        }
                    }
                }
            } else {
                if ((trs.get(i).child(1).attr("style").contains("padding-left: 50px"))) {
                    if ((trs.get(i).child(1).ownText().equals("0."))) {//old league does not have any information, it only has 0.
                        Goal goal = new Goal();
                        goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.OldGoal);
                        result.add(goal);
                    } else {//new league
                        if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.HasAssister) {
                            Goal goal = new Goal();
                            goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.HasAssister);
                            result.add(goal);
                        } else if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.Individually) {
                            Goal goal = new Goal();
                            goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.Individually);
                            result.add(goal);
                        } else if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.Reverse) {
                            Goal goal = new Goal();
                            goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.Reverse);
                            result.add(goal);
                        }
                    }

                }
            }
        }

        return result;
    }
}	

