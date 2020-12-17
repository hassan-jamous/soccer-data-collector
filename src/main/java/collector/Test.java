package collector;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello From Hassan###");
        ScreenScraper testObject = new ScreenScraper();
        
        //new player cedric-soares
        //old player tony-adams
        //new player eric-bailly
        testObject.getAllInformationAboutPlayer("eric-bailly");
        System.out.println("End Main###");
    }
}
