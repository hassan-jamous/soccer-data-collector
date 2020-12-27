package collector;

import convertByGson.GamesConvertor;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello From Hassan###");
        //ScreenScraper test = new ScreenScraper();
        GamesConvertor x = new GamesConvertor();
        x.convertAllRoundsFromObjectToGson("eng-premier-league", "1888-1889");
        x.convertAllRoundsFromGsonToObejct();
        System.out.println("End Main###");
    }
}
