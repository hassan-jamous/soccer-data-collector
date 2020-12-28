package collector;

import java.util.ArrayList;

import models.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import models.Goal;
import models.KindOfGoal;
import models.KindOfReferee;
import models.MatchDetails;
import models.PlayerAtMatch;
import models.PlayerEventAtMatch;
import models.PlayerTypeAtMatch;
import models.Referee;

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
        result.firstClub = getClubInformation(allTablesInPage, 0, result.matchSummary.firstClubInfo.name);
        result.secondClub = getClubInformation(allTablesInPage, 1, result.matchSummary.secondClubInfo.name);
        result.referees = getRefereesInMatch(allTablesInPage);
        result.attendance = getMatchAttendance(allTablesInPage);
        result.staduim = getMatchStadium(allTablesInPage);
        return result;
    }

    private String getMatchStadium(Elements allTablesInPage) {
        Elements elementStadium = allTablesInPage.select("tr:has(td:has(img[title=stadium]))");
        if (elementStadium != null) {
            return elementStadium.text();
        }
        return null;
    }

    private String getMatchAttendance(Elements allTablesInPage) {
        Elements elementAttendance = allTablesInPage.select("tr:has(td:has(img[title=Attendance]))");
        if (elementAttendance != null) {
            return elementAttendance.text();
        }
        return null;
    }

    private ClubInMatch getClubInformation(Elements allTablesInPage, int teamNumber, String clubName) {
        Elements elementClubsInfo = allTablesInPage.select("table:has(td[width=10%],[width=72%],[width=18%])");
        Elements elementManagersInfo = allTablesInPage.select("table:has(th:contains(Manager:))");
        Elements elementGoalsInfo = allTablesInPage.select("table:has(td:contains(goals))");

        ClubInMatch result = new ClubInMatch();
        result.players = getClubPlayersInMatch(elementClubsInfo.get(teamNumber));
        result.manager = elementManagersInfo.get(0).select("a").get(teamNumber).attr("title").trim();
        // result.goals = getGoalsInMatch(elementGoalsInfo, teamNumber);

        result.goals = getMatchGoals(elementGoalsInfo, teamNumber)[teamNumber].getGoals();
        result.clubBasicInfo.name = clubName;
        return result;
    }

    private MatchSummary getMatchSummary(Elements allTablesInPage) {
        Elements elementBasicInfo = allTablesInPage.select("table:has(th:has(a[href*=/teams/]))");
        MatchSummary result = new MatchSummary();
        if (elementBasicInfo.size() > 0) {

            Elements trs = elementBasicInfo.get(0).select("tr");
            if (trs.size() == 2) {
                result.firstClubInfo.name = trs.get(0).child(0).text();
                result.secondClubInfo.name = trs.get(0).child(2).text();
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

        Elements refereesElement = allTablesInPage.select("tr:has(td:has(img[title=Referee]))");
        ArrayList<Referee> result = new ArrayList<>();

        if (refereesElement.size() > 0) {
            Referee referee = new Referee();
            referee.kind = KindOfReferee.Referee;
            referee.name = refereesElement.text().substring(0, refereesElement.text().indexOf("(") - 1);
            referee.nation = refereesElement.text().substring(refereesElement.text().indexOf("(") + 1, refereesElement.text().indexOf(")"));
            result.add(referee);
        }
        Elements assistantRefereesElement = allTablesInPage.select("tr:has(td:has(img[title=Assistant Referee]))");
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
    private ArrayList<PlayerAtMatch> getClubPlayersInMatch(Element table) {
        ArrayList<PlayerAtMatch> result = new ArrayList<>();
        Elements trsTeam = table.select("tr");
        int indexOfRowWithSubstitutesTitle = getIndexOfRowWithSubstitutesTitle(trsTeam);
        for (int i = 0; i < trsTeam.size() && i != indexOfRowWithSubstitutesTitle; i++) {
            PlayerAtMatch player = new PlayerAtMatch();
            player.playerNumberAsString = trsTeam.get(i).child(0).text();
            player.playerBasicInfo.name = trsTeam.get(i).child(1).child(0).text().trim();
            player.events = getPlayerEventsInMatch(trsTeam.get(i).child(1));
            if ((indexOfRowWithSubstitutesTitle != -1 && i < indexOfRowWithSubstitutesTitle) || indexOfRowWithSubstitutesTitle == -1) {// not Substitute
                player.playerType = PlayerTypeAtMatch.Essential;
                if (trsTeam.get(i).child(2).hasText()) {
                    PlayerEventAtMatch event = new PlayerEventAtMatch();
                    event.event = "out";
                    event.minute = trsTeam.get(i).child(2).text().substring(0, trsTeam.get(i).child(2).text().length() - 1);
                    player.events.add(event);
                }
            } else if (indexOfRowWithSubstitutesTitle != -1 && i > indexOfRowWithSubstitutesTitle) {//substitute
                player.playerType = PlayerTypeAtMatch.Substitute;
                if (trsTeam.get(i).child(2).hasText()) {
                    PlayerEventAtMatch event1 = new PlayerEventAtMatch();
                    event1.event = "in";
                    event1.minute = trsTeam.get(i).child(2).text().substring(0, trsTeam.get(i).child(2).text().length() - 1);
                    player.events.add(event1);
                }
            }
            result.add(player);
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

    private Goals[] getMatchGoals(Elements goalsTable, int teamNumber) {
        Goals[] result = new Goals[2];

        Elements trs = goalsTable.select("tr");
   /*      if (trs.get(1).text().equals("none")) {
    * want to test for result (1:0) not only (0:0) or (3:2)
        	 System.out.println("XXXXXXXXXXXXXXXXXXXXXx");
        	 result[0] = new Goals();
        	 result[1] = new Goals();

        	 result[0] =null exception
        	 result[1] =null exception
        	 return result;//null exception!!!!!!!!!!!!!!!!!!!!!!!11
         }*/
        ArrayList<Elements> goalstrs = new ArrayList<>();
        goalstrs.add(0, getFirstTeamGoals(trs));


        goalstrs.add(1, trs.select("tr:has(td[style*=padding-left])"));

        Goals teamGoals = new Goals();
        if ((goalstrs.get(teamNumber) != null)) {

            for (int i = 0; i < goalstrs.get(teamNumber).size(); i++) {

                Goal goal = new Goal();
                if ((goalstrs.get(teamNumber).get(i).child(1).ownText().equals("0."))) {//old league does not have any information, it only has 0.

                    goal = goalsCollector.getGoal(trs.get(i), KindOfGoal.OldGoal);
                } else {//new league

                    if (goalsCollector.kindOfGoal(goalstrs.get(teamNumber).get(i)) == KindOfGoal.HasAssister) {
                        goal = goalsCollector.getGoal(goalstrs.get(teamNumber).get(i), KindOfGoal.HasAssister);
                    } else if (goalsCollector.kindOfGoal(goalstrs.get(teamNumber).get(i)) == KindOfGoal.Individually) {
                        goal = goalsCollector.getGoal(goalstrs.get(teamNumber).get(i), KindOfGoal.Individually);
                    } else if (goalsCollector.kindOfGoal(goalstrs.get(teamNumber).get(i)) == KindOfGoal.Reverse) {
                        goal = goalsCollector.getGoal(goalstrs.get(teamNumber).get(i), KindOfGoal.Reverse);
                    }
                }

                teamGoals.addGoal(goal);

            }
        }
        result[teamNumber] = teamGoals;

        return result;

    }

    private Elements getFirstTeamGoals(Elements trs) {
        Elements result = new Elements();

        for (int i = 0; i < trs.size(); i++) {
            if (!(trs.get(i).text().equals("none"))) {
                if (!(trs.get(i).text().equals("goals"))) {
                    if (!(trs.get(i).children().hasAttr("style"))) {
                        result.add(trs.get(i));
                    }
                }
            }

        }
        return result;
    }

    //{club ==0 first team} or {club == 1 second team}
    private ArrayList<Goal> getGoalsInMatch(Elements goalsTable, int club) {
        ArrayList<Goal> result = new ArrayList<>();
        Elements trs = goalsTable.select("tr");

        if (trs.get(1).text().equals("none")) {
            return result;//or null
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
            } else if (club == 1) {
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
