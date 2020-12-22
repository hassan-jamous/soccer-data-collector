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

    public ArrayList<Goal> getGoalsOfGame(String competitionName, String competitionYears ,String fisrtTeam , String secondTeam) {
    	String gameURL = WORLD_FOOTBALL_GAMES_URL + competitionName +"-" +competitionYears +"-"+ fisrtTeam +"-"+ secondTeam +"/";
    	
        String htmlPage = httpUtil.sendGetHttpRequest(gameURL);
        Document doc = Jsoup.parse(htmlPage);

        Elements tables = doc.getElementsByClass("standard_tabelle");
        Element tableOfGoals = getGoalsTable(tables);
        
        Elements rowsOfGoals = tableOfGoals.select("tr");
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
                    } else if (kindOfGoal(rowsOfGoals.get(i)) == KindOfGoal.Individually) {
                        Goal goal = getGoal(rowsOfGoals.get(i), KindOfGoal.Individually);
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
            if (goal.text().contains("own")) {
                return KindOfGoal.Reverse;
            } else {
                return KindOfGoal.Individually;
            }
        }
        throw new RuntimeException("Unknown Kind of Goal");
    }

    //todo
    //information should be null for old league goals
    public Goal getGoal(Element rowOfGoal, KindOfGoal kind) {

        Goal result = new Goal();
        if (kind == KindOfGoal.OldGoal) {
            result.kind = kind;
            result.result = rowOfGoal.child(0).text();
            result.player = rowOfGoal.child(1).child(0).attr("title");
            result.information = null;
        } else if (kind == KindOfGoal.HasAssister) {
            result.kind = kind;
            result.result = rowOfGoal.child(0).text();
            result.player = rowOfGoal.child(1).child(0).attr("title");
            result.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
            result.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2, rowOfGoal.child(1).ownText().indexOf("(") - 1);
            result.assester = rowOfGoal.child(1).child(1).attr("title");
        } else if (kind == KindOfGoal.Individually) {
            result.kind = kind;
            result.result = rowOfGoal.child(0).text();
            result.player = rowOfGoal.child(1).child(0).attr("title");
            result.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
            result.information = rowOfGoal.child(1).ownText().substring(rowOfGoal.child(1).ownText().indexOf("/") + 2);
        } else if (kind == KindOfGoal.Reverse) {
            result.kind = kind;
            result.result = rowOfGoal.child(0).text();
            result.player = rowOfGoal.child(1).child(0).attr("title");
            result.minute = rowOfGoal.child(1).ownText().substring(0, rowOfGoal.child(1).ownText().indexOf("."));
            result.information = "own goal";
        }
        return result;
    }

    private Element getGoalsTable(Elements tables) {
        Element tableOfGoals = null;
        for (Element table : tables) {
            if (table.text().contains("goals")) {
                return table;
            }
        }
        return tableOfGoals;
    }
}
