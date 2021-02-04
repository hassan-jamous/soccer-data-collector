package worldfootball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import csvFile.CSVDealerForGetInforamtion;
import csvFile.CSVFilesDealer;
import csvFile.FileTypes;
import util.HttpUtil;
import util.Sites;
import worldfootball.models.Club;
import worldfootball.models.Game;
import worldfootball.models.HistoyGame;

public class HistoryCollector {

	ClubsCollector clubCollector = new ClubsCollector();
    private HttpUtil httpUtil = new HttpUtil();
	private static final String WORLD_FOOTBALL_ROUND_BASIS_URL ="https://www.worldfootball.net//schedule/";
	private static final String WORLD_FOOTBALL_HISTORY_MATCH_URL = "https://www.worldfootball.net/teams/%s/%s/11/";
	CSVFilesDealer csvFilesDealer = new CSVFilesDealer();
	CSVDealerForGetInforamtion csvInformationDealer = new CSVDealerForGetInforamtion(); 
	
	public void writeHeadToHeadInCSV(String competitionName ,String firstClub, String secondClub , String year) {
	
		String data ="";
		ArrayList<HistoyGame> gamesToWrite = getHeadToHeadUntil(firstClub,secondClub,year);
		if(gamesToWrite == null || gamesToWrite.isEmpty()) {
			csvFilesDealer.writeInFileWithOutHeader(Sites.WorldFootBall_Net, competitionName,"there is no head to head between "+ firstClub+" and "+secondClub, FileTypes.HeadToHead);
		}
		else {
			for(int i =0 ; i < gamesToWrite.size();i++) {
				data += csvInformationDealer.getValueStringForCSV( gamesToWrite.get(i));
			}
			csvFilesDealer.writeInFileWithOutHeader(Sites.WorldFootBall_Net, competitionName,firstClub+" vs "+ secondClub+" : " +data, FileTypes.HeadToHead);

		}
	}
	
	
	public ArrayList<HistoyGame> getHeadToHeadUntil(String firstClub, String secondClub , String year){
	
		String url = String.format(WORLD_FOOTBALL_HISTORY_MATCH_URL, firstClub, secondClub);
		String htmlPage = httpUtil.sendGetHttpRequest(url);
		Document doc = Jsoup.parse(htmlPage);
		Elements tables = doc.select("table.standard_tabelle")
				.select("table:has(tbody:has(tr:has(a[href*=/competition/])))");
		ArrayList<HistoyGame> result = new ArrayList<>(Arrays.asList());
		for (int i = 1; i < tables.size(); i++) {// first table contains overall information about every competition and overall of all competitions
			Elements trs = tables.get(i).select("tr");
			String competitionName = trs.get(0).child(0).child(0).attr("title");
			int gameIndexInTheSameRound =0;
			int limit = getIndexOfYear(trs, year, firstClub, secondClub);
			for (int j = limit; j > 0; j--) {
				int gameYear =Integer.valueOf( trs.get(j).child(0).child(0).text().substring(0, 4));
				int limitYear =Integer.valueOf( year.substring(0, 4));

				if(gameYear >= limitYear) {
					HistoyGame game = new HistoyGame();
					game.competitionName = competitionName;
					game.year = trs.get(j).child(0).child(0).text();
					game.roundInfo = trs.get(j).child(1).child(0).text();
					if(j != trs.size()-1 && trs.get(j+1).childrenSize()>3 &&
							trs.get(j).child(1).child(0).text().equals(trs.get(j+1).child(1).child(0).text()) 
							&&  trs.get(j).child(0).child(0).text().equals(trs.get(j+1).child(0).child(0).text())) {
						gameIndexInTheSameRound++;
					}
					else {gameIndexInTheSameRound=0;}
					String roundURL = trs.get(j).child(1).child(0).attr("href");
					String firstClubToCompare = trs.get(j).child(2).child(0).text();
					String secondClubToCompare = trs.get(j).child(4).child(0).text();
					String gameResult = trs.get(j).child(5).text();
					game.gameInfo = new Game(null , null , new Club(firstClubToCompare), new Club(secondClubToCompare), gameResult );
					getIformationForGame(roundURL,game.gameInfo,gameIndexInTheSameRound);
					result.add(game);
				}
			}
		}
		if(result==null ||  result.isEmpty()) {return null;}
		Collections.sort(result);
		return result;
	}
	
	
	public ArrayList<HistoyGame> getAllHeadToHeadBetween(String firstClub, String secondClub) {

		String url = String.format(WORLD_FOOTBALL_HISTORY_MATCH_URL, firstClub, secondClub);
		String htmlPage = httpUtil.sendGetHttpRequest(url);
		Document doc = Jsoup.parse(htmlPage);
		Elements tables = doc.select("table.standard_tabelle")
				.select("table:has(tbody:has(tr:has(a[href*=/competition/])))");
		ArrayList<HistoyGame> result = new ArrayList<>(Arrays.asList());
		for (int i = 1; i < tables.size(); i++) {// first table contains overall information about every competition and overall of all competitions
			Elements trs = tables.get(i).select("tr");
			String competitionName = trs.get(0).child(0).child(0).attr("title");
			int gameIndexInTheSameRound =0;
			for (int j = trs.size()-1; j > 0; j--) {
				HistoyGame game = new HistoyGame();
				game.competitionName = competitionName;
				game.year = trs.get(j).child(0).child(0).text();
				game.roundInfo = trs.get(j).child(1).child(0).text();
				if(j != trs.size()-1 && trs.get(j+1).childrenSize()>3 &&
						trs.get(j).child(1).child(0).text().equals(trs.get(j+1).child(1).child(0).text()) 
						&&  trs.get(j).child(0).child(0).text().equals(trs.get(j+1).child(0).child(0).text())) {
					gameIndexInTheSameRound++;
				}
				else {gameIndexInTheSameRound=0;}
				String roundURL = trs.get(j).child(1).child(0).attr("href");
				String firstClubToCompare = trs.get(j).child(2).child(0).text();
				String secondClubToCompare = trs.get(j).child(4).child(0).text();
				String gameResult = trs.get(j).child(5).text();
				game.gameInfo = new Game(null , null , new Club(firstClubToCompare), new Club(secondClubToCompare), gameResult );
				getIformationForGame(roundURL,game.gameInfo,gameIndexInTheSameRound);
				result.add(game);				
			}
		}		
		Collections.sort(result);
		return result;
	}

	private void getIformationForGame( String roundURL , Game game , int gameIndexInRoundH2H ) {
		
		String htmlPage = httpUtil.sendGetHttpRequest(WORLD_FOOTBALL_ROUND_BASIS_URL+roundURL);
		Document doc = Jsoup.parse(htmlPage);
		Elements trs = doc.select("table.standard_tabelle").select("tr");
		int counterTheSameGame= 0;
		for(int i =0 ; i < trs.size(); i++) {
			if(isGame(trs.get(i))) {
				if(trs.get(i).text().contains(game.firstTeamBasicInfo.name) && trs.get(i).text().contains(game.secondTeamBasicInfo.name)) {
					if(counterTheSameGame == gameIndexInRoundH2H) {
						game.time = trs.get(i).child(1).text().trim();
						if(trs.get(i).child(0).text()!= null && ! trs.get(i).child(0).text().isEmpty() ) {
							if(trs.get(i).child(0).text().contains("leg")) {
								int offsetTR;
								int indexTD;
								if(trs.get(i).child(0).text().contains("1")) {offsetTR=2;indexTD=1;}
								else {offsetTR=1;indexTD=3;}
								game.date = trs.get(i+offsetTR).child(indexTD).text().substring(trs.get(i+offsetTR).child(indexTD).text().indexOf(':')+1,trs.get(i+offsetTR).child(indexTD).text().indexOf(':')+12).trim();
								game.time = trs.get(i+offsetTR).child(indexTD).text().substring(trs.get(i+offsetTR).child(indexTD).text().lastIndexOf(':')-2,trs.get(i+offsetTR).child(indexTD).text().length()).trim();
							}
							else{
								game.date = trs.get(i).child(0).text().trim();
							}
						}
						else {
							int j =i-1;
							String date="";
							while((j >=0) && (date.equals(""))) {
								if(isGame(trs.get(j))) {
									date = trs.get(j).child(0).text();
								}
								j--;
							}						
							if((j<0)&& date.equals("")){throw new RuntimeException("this game does not have date");}
							game.date = date.trim();
						}
						counterTheSameGame++;
					}
					counterTheSameGame++;
				}
			}
		}	
	}
	private boolean isGame(Element tr) {
        if (tr != null) {
            int numberOfTeams = 0;
            for (Element td : tr.select("td")) {
                for (Element child : td.children()) {
                    if (child.attr("href").contains("teams")) {
                        numberOfTeams++;
                    }
                }
            }
            return numberOfTeams == 2;
        }
        return false;
    }
	
	private int getIndexOfYear(Elements trs , String year, String firstClub , String secondClub) {
		
		if(year == null) {return trs.size()-1;}
		for(int index = trs.size()-1 ; index >=0 ; index-- ) {
			if(trs.get(index)!= null && trs.get(index).childrenSize()>0 && trs.get(index).child(0).child(0).text().equals(year)) {
				return trs.size()-1-index;
			}
		}
		return  trs.size()-1;
	}
}
