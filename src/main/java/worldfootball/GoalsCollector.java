package worldfootball;

import worldfootball.models.Goal;
import worldfootball.models.KindOfGoal;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.HttpUtil;

import java.util.ArrayList;

public class GoalsCollector {
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLD_FOOTBALL_GAMES_URL = "https://www.worldfootball.net/report/";

    public ArrayList<Goal> getGoalsOfGame(String competitionName, String competitionYears, String firstClub, String secondClub) {
        String gameURL = WORLD_FOOTBALL_GAMES_URL + competitionName + "-" + competitionYears + "-" + firstClub + "-" + secondClub + "/";

        String htmlPage = httpUtil.sendGetHttpRequest(gameURL);
        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.getElementsByClass("standard_tabelle");
        Element tableOfGoals = getGoalsTable(tables);

        Elements rowsOfGoals = tableOfGoals.select("tr");
        if ((rowsOfGoals != null) && (rowsOfGoals.size() == 2) && (rowsOfGoals.get(1).text().contains("none"))) {
            return null;
        }
        ArrayList<Goal> goals = new ArrayList<>();
        //the first row is the header, this is why i = 1;
        for (int i = 1; i < rowsOfGoals.size(); i++) {//
            if (rowsOfGoals.get(i).text().contains(":")) {//it is goal
                if (!(rowsOfGoals.get(i).child(1).ownText().contains("/"))) {//old league does not have any information
                    Goal goal = getGoal(rowsOfGoals.get(i), KindOfGoal.OldGoal);
                    goals.add(goal);
                } else {//new league
                    if (kindOfGoal(rowsOfGoals.get(i)) == KindOfGoal.HasAssister) {
                        Goal goal = getGoal(rowsOfGoals.get(i), KindOfGoal.HasAssister);
                        goals.add(goal);
                    } else if (kindOfGoal(rowsOfGoals.get(i)) == KindOfGoal.Reverse) {
                        Goal goal = getGoal(rowsOfGoals.get(i), KindOfGoal.Reverse);
                        goals.add(goal);
                    } else if (kindOfGoal(rowsOfGoals.get(i)) == KindOfGoal.Individually) {
                        Goal goal = getGoal(rowsOfGoals.get(i), KindOfGoal.Individually);
                        goals.add(goal);
                    }
                }
            }
        }
        return goals;
    }

    public KindOfGoal kindOfGoal(Element goal) {
        int numberOfPlayer = 0;
        //goal has two children, the first is the result and the second is the goal information
        if (goal.childrenSize() == 2) {
            for (Element grandson : goal.child(1).children()) {
                if (grandson.hasAttr("href")) {
                    numberOfPlayer++;
                }
            }
            if (numberOfPlayer == 2) {
                return KindOfGoal.HasAssister;
            } else if (goal.text().contains("own goal")) {
                return KindOfGoal.Reverse;
            } else {
                return KindOfGoal.Individually;
            }
        }
        throw new RuntimeException("Unknown Kind of Goal");
    }

    public Goal getGoal(Element rowOfGoal, KindOfGoal kind) {

        if (kind == KindOfGoal.OldGoal) {
            Goal result = new Goal(rowOfGoal.child(0).text(),
                    rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf(".")),
                    rowOfGoal.child(1).child(0).attr("title"));
            result.kind = kind;
            return result;
        } else if (kind == KindOfGoal.HasAssister) {
            Goal result = new Goal(rowOfGoal.child(0).text(),
                    rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf(".")),
                    rowOfGoal.child(1).child(0).attr("title"),
                    rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2, rowOfGoal.child(1).ownText().indexOf("(") - 1),
                    rowOfGoal.child(1).child(1).attr("title"));
            result.kind = kind;
            return result;
        } else if (kind == KindOfGoal.Individually) {
            Goal result = new Goal(rowOfGoal.child(0).text(),
                    rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf(".")),
                    rowOfGoal.child(1).child(0).attr("title"),
                    rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2));
            result.kind = kind;
            return result;
        } else if (kind == KindOfGoal.Reverse) {
            Goal result = new Goal(rowOfGoal.child(0).text(),
                    rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf(".")),
                    rowOfGoal.child(1).child(0).attr("title"),
                    "own goal");
            result.kind = kind;
            return result;
        }
        throw new RuntimeException();
    }

    private Element getGoalsTable(Elements tables) {
        for (Element table : tables) {
            if (table.text().contains("goals")) {
                return table;
            }
        }
        throw new RuntimeException("Unexpected input, there is no table");
    }
}
