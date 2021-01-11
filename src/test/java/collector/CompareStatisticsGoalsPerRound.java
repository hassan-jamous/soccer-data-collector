package collector;

import java.util.Comparator;

import models.StatisticsGoalsPerRound;

public class CompareStatisticsGoalsPerRound implements Comparator<StatisticsGoalsPerRound> {

    @Override
    public int compare(StatisticsGoalsPerRound round1, StatisticsGoalsPerRound round2) {

        double goal1 = Double.parseDouble((round1.goalsPerMatch.contains("Ø")) ? round1.goalsPerMatch.replace("Ø", "") : round1.goalsPerMatch);
        double goal2 = Double.parseDouble((round2.goalsPerMatch.contains("Ø")) ? round2.goalsPerMatch.replace("Ø", "") : round2.goalsPerMatch);
        if (goal1 > goal2) {
            return -1;
        } else if (goal1 < goal2) {
            return +1;
        } else {
            double year1 = Double.parseDouble(round1.seasonYears.substring(0, round1.seasonYears.indexOf("/")));
            double year2 = Double.parseDouble(round2.seasonYears.substring(0, round2.seasonYears.indexOf("/")));
            if (year1 > year2) {
                return -1;
            } else if (year1 < year2) {
                return +1;
            } else {
                double numRound1 = Double.parseDouble(round1.round.roundNumberAsString.replace(". Round", ""));
                double numRound2 = Double.parseDouble(round2.round.roundNumberAsString.replace(". Round", ""));
                if (numRound1 >= numRound2) {
                    return -1;
                } else {
                    return +1;
                }
            }
        }
    }

}
