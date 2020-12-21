package collector;

import java.util.ArrayList;


import models.ClubTransferTable;
import models.PlayerTopSoccer;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello From Hassan###");
        ScreenScraper testObject = new ScreenScraper();
        
        
        //new player cedric-soares
        //old player tony-adams
        //new player eric-bailly
        String matchOld = "https://www.worldfootball.net/report/premier-league-1946-1947-brentford-fc-middlesbrough-fc/";
        String matchNew = "https://www.worldfootball.net/report/premier-league-2020-2021-wolverhampton-wanderers-chelsea-fc/";
        //first competition has match details 1946
      //  testObject.matchesDetails(matchOld);
       
        
        ArrayList <ClubTransferTable>  result = testObject.getClubsTransferTable("2015-2016");
        for (int i =0 ; i< result.size()  ; i++) {
        	//System.out.println(result.get(i));
        	}
        ArrayList <PlayerTopSoccer>  topSoccer = new ArrayList<>();
        
        topSoccer = testObject.getTopSoccer("2019-2020");
        for(int i =0 ; i< topSoccer.size() ; i++) {
       // 	System.out.println(topSoccer.get(i));
        }
        System.out.println("End Main###");
    }
}
