package collector;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello From Hassan");
        ScreenScraper testObject = new ScreenScraper();
        
        //test
       //testObject.getAllGamesOfLeague("","2015-2016"); test again with other years
        String ownGoal = "https://www.worldfootball.net/report/premier-league-2015-2016-arsenal-fc-aston-villa/";
        String individuallyGoal ="https://www.worldfootball.net/report/premier-league-2015-2016-sunderland-afc-chelsea-fc/";
        testObject.getEventsOfGame(individuallyGoal);
        System.out.println("End Main1");
        System.out.println("End Main2");
    }
}
