package collector;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello From Hassan");
        ScreenScraper testObject = new ScreenScraper();
        
        //test
       //testObject.getAllGamesOfLeague("","2015-2016"); test again with other years
        
        String ownGoal = "https://www.worldfootball.net/report/premier-league-2015-2016-arsenal-fc-aston-villa/";
        //String individuallyGoal ="https://www.worldfootball.net/report/premier-league-2015-2016-sunderland-afc-chelsea-fc/";
    //    System.out.println( testObject.getLastTable("", "1888-1889"));
   //  System.out.println(testObject.getGamesTableOfCompetition("1888-1889"));
    // System.out.println(testObject.getTableByRound("", "1999-2000", "5"));   
        ArrayList goals = testObject.getEventsOfGame(ownGoal);
for(int i =0 ; i<goals.size() ; i++) {
	System.out.println(goals.get(i));
}
        System.out.println("End Main");
    }
}
