package collector;

import models.Goal;
import models.KindOfGoal;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
        if((rowsOfGoals != null)&&(rowsOfGoals.size() ==2 )&&(rowsOfGoals.get(1).text().contains("none"))) {
        	return null;
        }
        ArrayList<Goal> goals = new ArrayList<>();
        //the first row is the header, this is why i = 1;
        for (int i = 1; i < rowsOfGoals.size(); i++) {//
            if (rowsOfGoals.get(i).text().contains(":")) {//it is goal
                if (rowsOfGoals.get(i).child(1).ownText().equals("0.")) {//old league does not have any information, it only has 0.
                    Goal goal = getGoal(rowsOfGoals.get(i), KindOfGoal.OldGoal);
                    goals.add(goal);
                } else {//new league
                    if (kindOfGoal(rowsOfGoals.get(i)) == KindOfGoal.HasAssister) {
                        Goal goal = getGoal(rowsOfGoals.get(i), KindOfGoal.HasAssister);
                        goals.add(goal);
                    } else if (kindOfGoal(rowsOfGoals.get(i)) == KindOfGoal.NoInformationOrIndividually) {
                        Goal goal = getGoal(rowsOfGoals.get(i), KindOfGoal.NoInformationOrIndividually);
                        goals.add(goal);
                    } else if (kindOfGoal(rowsOfGoals.get(i)) == KindOfGoal.Reverse) {
                        Goal goal = getGoal(rowsOfGoals.get(i), KindOfGoal.Reverse);
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
            }
            if (goal.text().contains("own goal")) {
                return KindOfGoal.Reverse;
            } else {
                return KindOfGoal.NoInformationOrIndividually;
            }
        }
        throw new RuntimeException("Unknown Kind of Goal");
    }

    public Goal getGoal(Element rowOfGoal, KindOfGoal kind) {
        Goal result = new Goal();
        result.kind = kind;
        result.result = rowOfGoal.child(0).text();
        result.playerBasicInfo.name = rowOfGoal.child(1).child(0).attr("title");
        if (kind == KindOfGoal.OldGoal) {
            result.information = null;
        } else if (kind == KindOfGoal.HasAssister) {
            result.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
            result.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2, rowOfGoal.child(1).ownText().indexOf("(") - 1);
            result.assesterBasicInfo.name = rowOfGoal.child(1).child(1).attr("title");
        } else if (kind == KindOfGoal.NoInformationOrIndividually) {
            result.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
            if(rowOfGoal.child(1).ownText().equals(result.minute+".")) {
            	result.information = null;
            	result.kind = KindOfGoal.NoInformation;
            }
            else{
            	result.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2);
            	result.kind = KindOfGoal.Individually;
            }
        } else if (kind == KindOfGoal.Reverse) {
            result.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
            result.information = "own goal";
        }
        return result;
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
