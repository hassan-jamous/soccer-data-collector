package collector;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import models.ClubTransferTable;
import models.TransferPlayerInformation;

public class TransferCollector {
	 private HttpUtil httpUtil = new HttpUtil();
	   
	    private static final String WORLD_FOOTBALL_TRANSFER_URL = "https://www.worldfootball.net/transfers/";

	public ArrayList<ClubTransferTable> getClubsTransferTableAtSeason( String competitionName,String competiotionYears) {
		String url = WORLD_FOOTBALL_TRANSFER_URL + competitionName + "-league-"+competiotionYears + "/";
		
		String htmlPage = httpUtil.sendGetHttpRequest(url);
	
        Document doc = Jsoup.parse(htmlPage);
        Elements divs1 = doc.select("div:has(div:has(h2))");
        ArrayList <Element> divs = getTransferDivs(divs1);
        ArrayList<ClubTransferTable> result = new ArrayList<>();
        for(Element div :divs) {
        	
        	ClubTransferTable clubTransferTable = new ClubTransferTable();
        	clubTransferTable.clubName = div.child(0).child(0).text().substring(0, div.child(0).child(0).text().indexOf("�")-1);
        	clubTransferTable.season = competiotionYears;
        	             //    div        table  tbody
        	Elements trs = div.child(1).getElementsByTag("tr");
        	
        	for(int i =0; i < trs.size() ;i++) {
        		if(trs.get(i).text().equals("In")) {
        			int j= i+1;
	        		while((j<trs.size()) && (!( trs.get(j).text().equals("Out"))) ){
	        			TransferPlayerInformation player = new TransferPlayerInformation();
	        			player.date = trs.get(j).child(0).text();
	        			
	        			player.playerName = trs.get(j).child(1).text();
	        			player.playerNation = trs.get(j).child(2).child(0).attr("title");
	        			player.playerPosition = trs.get(j).child(3).text();
	        			player.fromClub = trs.get(j).child(5).text();
	        			player.toClub = clubTransferTable.clubName;
	        			clubTransferTable.intable.add(player);
	        			
	        			j++;
	        		}
        		}
        		else if(trs.get(i).text().equals("Out")) {
        			int j= i+1;
	        		while ((j<trs.size())){
	        			TransferPlayerInformation player = new TransferPlayerInformation();
	        			player.date = trs.get(j).child(0).text();
	        			player.playerName = trs.get(j).child(1).text();
	        			player.playerNation = trs.get(j).child(2).child(0).attr("title");
	        			player.playerPosition = trs.get(j).child(3).text();
	        			player.toClub = trs.get(j).child(5).text();
	        			
	        			player.fromClub = clubTransferTable.clubName;
	        			clubTransferTable.outtable.add(player);
	        			j++;
	        		}
        		}
        	}
        result.add(clubTransferTable);
        }
        return result;
	} 
	private ArrayList<Element> getTransferDivs(Elements divs) {
		ArrayList <Element> result = new ArrayList<>();
		for(Element div : divs) {
			if(div.childrenSize() >= 2) {				
				if(div.child(0).tagName().equals("div") && (div.child(1).tagName().equals("div"))) {
					if(div.child(0).childrenSize() > 0) {
						if((div.child(0).child(0).tagName().equals("h2")) && 
								(div.child(0).child(0).ownText().contains("Transfers"))) {					
							result.add(div);
						}						
					}					
				}
			}
		}
		return result;
	}
	
//public??????
	public ClubTransferTable getTransferTableByClubName(ArrayList <ClubTransferTable> table ,String ClubName ) {
		
		for(int i =0; i <table.size() ; i++) {
			if(table.get(i).clubName.contains(ClubName)) {				
					return table.get(i);
				} 
				
			}
		
		throw new RuntimeException("Club Transfer Not Found");
	}
}