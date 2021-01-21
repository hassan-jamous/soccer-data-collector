package testUtilities;

import java.util.Comparator;

import worldfootball.models.StatisticsGoalsPerRound;

public class CompareStatisticsGoalsPerRound implements Comparator<StatisticsGoalsPerRound> {

    @Override
    public int compare(StatisticsGoalsPerRound round1, StatisticsGoalsPerRound round2) {

        double goal1 = Double.parseDouble((round1.goalsPerMatch.contains("Ø")) ? round1.goalsPerMatch.replace("Ø", "") : round1.goalsPerMatch);
        double goal2 = Double.parseDouble((round2.goalsPerMatch.contains("Ø")) ? round2.goalsPerMatch.replace("Ø", "") : round2.goalsPerMatch);
        if(goal1 == goal2) {
            int year1 = Integer.parseInt(round1.seasonYears.substring(0, round1.seasonYears.indexOf("/")));
            int year2 = Integer.parseInt(round2.seasonYears.substring(0, round2.seasonYears.indexOf("/")));
            if(year1 == year2) {            	 
                int numRound1 = Integer.parseInt(round1.round.roundNumberAsString.replace(". Round", ""));
                int numRound2 = Integer.parseInt(round2.round.roundNumberAsString.replace(". Round", ""));
                return numRound2-numRound1;
            }
            else {
            	return year2-year1;
            }
        }
        else {
        	return (int) Math.round(10000*(goal2-goal1));
        }        
    }
}
