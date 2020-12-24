package collector;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import models.PlayerAllInformation;
import models.PlayerClubCareer;

import models.PlayerCompetitionsInformation;

import models.PlayerPersonalInformation;
import models.PlayerTeamManaged;

public class PlayerCollector {

	private HttpUtil httpUtil = new HttpUtil();
	private static final String WORLD_FOOTBALL_PLAYERS_SUMMARY_URL ="https://www.worldfootball.net/player_summary/";
	
	//look to bruno-fernandes at manchester  united 2020 (url is bruno-fernandes_2) 
	//not just name
	 public PlayerAllInformation getAllInformationAboutPlayer(String nameAsInURL) {
			
			String url = WORLD_FOOTBALL_PLAYERS_SUMMARY_URL + nameAsInURL +"/";
			
	    	String htmlPage = httpUtil.sendGetHttpRequest(url);
	        Document doc = Jsoup.parse(htmlPage);
	        Elements divs = doc.getElementsByClass("box");
	        
	        Elements divTeamsManaged  = divs.select("div:has(div:has(h2:contains(Teams managed)))");
	        Elements divClubCareer = divs.select("div:has(div:has(h2:contains(Club career)))");
	        Elements divClubMatches = divs.select("div:has(div:has(h2:contains(Club matches)))");
	        Elements divInternationals = divs.select("div:has(div:has(h2:contains(Internationals)))");
	        Elements divPersonalInformation = divs.select("div:has(div:has(h2[itemprop=name]))");
	        
	        PlayerAllInformation playerTotalInfo = new PlayerAllInformation();
	        playerTotalInfo.teamsManaged = getPlayerTeamManaged(divTeamsManaged);
	        playerTotalInfo.clubsCareer = getClubCarrer(divClubCareer);
	        playerTotalInfo.clubMatches = getPlayerClubsMatch(divClubMatches);
	        playerTotalInfo.internationalCopmetitionsInfo = getPlayerInternatiols(divInternationals);
	        playerTotalInfo.personalInfo = getPlayerPersonalInformation(divPersonalInformation);
	        
	        return playerTotalInfo;
	    }
	 
	 private ArrayList <PlayerTeamManaged> getPlayerTeamManaged(Elements div) {
			Elements trs = div.select("tr");
			PlayerTeamManaged palyerTeamManaged;
			ArrayList <PlayerTeamManaged> result = new ArrayList<>();
			for(int i = 0 ; i <trs.size() ; i++) {
				palyerTeamManaged = new PlayerTeamManaged();
				
				palyerTeamManaged.date = trs.get(i).child(0).text();
				palyerTeamManaged.clubBasicInfo.name = trs.get(i).child(2).text();
				palyerTeamManaged.clubNation = trs.get(i).child(3).child(0).attr("title");
				palyerTeamManaged.position = trs.get(i).child(4).text();
				
				result.add(palyerTeamManaged);
			}
			
			return result;
			
		} 
	 
	 private ArrayList<PlayerClubCareer> getClubCarrer(Elements div) {
			Elements trClubs = div.select("tr");
			ArrayList <PlayerClubCareer>result = new ArrayList<>();
			PlayerClubCareer club ; 
			for(int i =0 ; i < trClubs.size() ;i++) {
				if((i == 0) && (trClubs.get(0).child(1).attr("width").equals("60%"))) {//new version
					club = new PlayerClubCareer();
						                                 
					club.clubBasicInfo.name= trClubs.get(0).child(1).child(0).child(0).text();
				
					club.clubNation = trClubs.get(0).child(1).child(1).child(0).attr("title");
					String playerPositionAndContract = trClubs.get(0).child(1).child(1).text(); 			
					club.playerPosition = playerPositionAndContract.substring(club.clubNation.length()+1, playerPositionAndContract.indexOf('/')-3);
						
					club.years = playerPositionAndContract.substring(playerPositionAndContract.indexOf('/')-2);
					club.playerNumber = trClubs.get(0).child(2).child(0).text();
					result.add(club);
					}

				else if( (trClubs.get(i).childrenSize() > 4)){
					club = new PlayerClubCareer();
					club.years = trClubs.get(i).child(0).text();
					club.clubBasicInfo.name = trClubs.get(i).child(2).text();
					club.clubNation = trClubs.get(i).child(3).child(0).attr("title");
					club.playerPosition = trClubs.get(i).child(4).text();
					result.add(club);
				}
			}

			return result;
		}
		
		private PlayerPersonalInformation  getPlayerPersonalInformation(Elements divinfo) {
			Elements divs = divinfo.select("div");
			Element div = divs.get(0);
			PlayerPersonalInformation info = new PlayerPersonalInformation();
			
			
			info.playerBasicInfo.name = div.child(1).text();
			//image child 2
			Elements tds = div.child(3).select("td");
			if(tds.size() >=15) {//new 
				info.fullName = tds.get(0).text();
				info.born = tds.get(3).text();
				info.birthPlace = tds.get(5).text();
				info.nationality = tds.get(7).text();
				info.height = tds.get(9).text();
				info.weight = tds.get(11).text();
				info.positions = tds.get(13).text();
				info.foot = tds.get(15).text();
			}
			else {
				info.fullName = tds.get(0).text();
				info.born = tds.get(3).text();
				info.birthPlace = tds.get(5).text();
				info.nationality = tds.get(7).text();
			}
			return info;
			
			}
		
		private ArrayList <PlayerCompetitionsInformation> getPlayerInternatiols(Elements div) {
			Elements trs = div.select("tr");
			PlayerCompetitionsInformation palyerInfoInternational;
			ArrayList <PlayerCompetitionsInformation> result = new ArrayList<>();
			for(int i = 1 ; i <trs.size() ; i++) {//header 
				palyerInfoInternational = new PlayerCompetitionsInformation();
				if(trs.get(i).child(0).text().contains("∑")) {
					palyerInfoInternational.competitionName = trs.get(i).child(0).text().replace("∑", "Total");
					palyerInfoInternational.competitionNation = null;
					palyerInfoInternational.matchesNumber = trs.get(i).child(1).text();
					palyerInfoInternational.goalsNumber = trs.get(i).child(2).text();
					palyerInfoInternational.startingLineUp = trs.get(i).child(3).text();
					palyerInfoInternational.substitueIn = trs.get(i).child(4).text();
					palyerInfoInternational.substitueOut = trs.get(i).child(5).text();
					palyerInfoInternational.yellowCards = trs.get(i).child(6).text();
					palyerInfoInternational.secondYellowCards = trs.get(i).child(7).text();
					palyerInfoInternational.redCards = trs.get(i).child(8).text();
					result.add(palyerInfoInternational);
				}
				else {
					palyerInfoInternational.competitionName = trs.get(i).child(0).text();
				
					palyerInfoInternational.competitionNation = trs.get(i).child(1).child(0).attr("title");
					palyerInfoInternational.matchesNumber = trs.get(i).child(2).text();
					palyerInfoInternational.goalsNumber = trs.get(i).child(3).text();
					palyerInfoInternational.startingLineUp = trs.get(i).child(4).text();
					palyerInfoInternational.substitueIn = trs.get(i).child(5).text();
					palyerInfoInternational.substitueOut = trs.get(i).child(6).text();
					palyerInfoInternational.yellowCards = trs.get(i).child(7).text();
					palyerInfoInternational.secondYellowCards = trs.get(i).child(8).text();
					palyerInfoInternational.redCards = trs.get(i).child(9).text();
					result.add(palyerInfoInternational);
				}
			}
			
			return result;
			
			
		}
		
		private ArrayList <PlayerCompetitionsInformation> getPlayerClubsMatch(Elements div) {
			Elements trs = div.select("tr");
			PlayerCompetitionsInformation palyerInfoCompetition;
			ArrayList <PlayerCompetitionsInformation> result = new ArrayList<>();
			//if(!(getOverallIndexes(div).isEmpty())) {//has more information i.e {Overall international matches}
				//go to new url
			//}
			//else {
				for(int i = 1 ; i <trs.size() ; i++) {//we do not need the header ,because it does not have any information 
					palyerInfoCompetition = new PlayerCompetitionsInformation();
					if(trs.get(i).child(0).text().contains("∑")) {
						palyerInfoCompetition.competitionName = trs.get(i).child(0).text().replace("∑", "Total");
						palyerInfoCompetition.competitionNation = null;
						palyerInfoCompetition.matchesNumber = trs.get(i).child(1).text();
						
						palyerInfoCompetition.goalsNumber = trs.get(i).child(2).text();
						palyerInfoCompetition.startingLineUp = trs.get(i).child(3).text();
						palyerInfoCompetition.substitueIn = trs.get(i).child(4).text();
						palyerInfoCompetition.substitueOut = trs.get(i).child(5).text();
						palyerInfoCompetition.yellowCards = trs.get(i).child(6).text();
						palyerInfoCompetition.secondYellowCards = trs.get(i).child(7).text();
						palyerInfoCompetition.redCards = trs.get(i).child(8).text();
						result.add(palyerInfoCompetition);
					}
					else {
						palyerInfoCompetition.competitionName = trs.get(i).child(0).text();
						palyerInfoCompetition.competitionNation = trs.get(i).child(1).child(0).attr("title");				
						palyerInfoCompetition.matchesNumber = trs.get(i).child(2).text();
						palyerInfoCompetition.goalsNumber = trs.get(i).child(3).text();
						palyerInfoCompetition.startingLineUp = trs.get(i).child(4).text();
						palyerInfoCompetition.substitueIn = trs.get(i).child(5).text();
						palyerInfoCompetition.substitueOut = trs.get(i).child(6).text();
						palyerInfoCompetition.yellowCards = trs.get(i).child(7).text();
						palyerInfoCompetition.secondYellowCards = trs.get(i).child(8).text();
						palyerInfoCompetition.redCards = trs.get(i).child(9).text();
						result.add(palyerInfoCompetition);
					}
				}
			//}end else
			return result;		
			
		} 
		/*
		private  ArrayList<Integer> getOverallIndexes(Elements div) {
			ArrayList<Integer> result = new ArrayList<>();
			Elements trs = div.select("tr");
			for(int i = 0 ; i < trs.size() ; i++) {
				if(trs.get(i).child(trs.get(i).childrenSize() -1).text().contains("Overall")) {
					result.add(i);
				}
			}
			return result;
		}
		*/
		/*
		 * public ArrayList <PlayerCompetitionInformationOverall > getOverallCompetitionInformation(String url) {
			String htmlPage = httpUtil.sendGetHttpRequest(url);
	        Document doc = Jsoup.parse(htmlPage);	        
	        Elements trs = doc.select("tr");
	        ArrayList <PlayerCompetitionInformationOverall >result = new ArrayList <>();
	        PlayerCompetitionInformationOverall info ;
	        for(int i =1 ; i < trs.size() ; i++) {
	        	info = new PlayerCompetitionInformationOverall();
	        	                                  //---------td--------
	        	info.competitionNation             = trs.get(i).child(0).child(0).attr("title");
	        	info.competitionName               = trs.get(i).child(1).text();
	        	info.season                        = trs.get(i).child(2).text();
	        	info.team                          = trs.get(i).child(3).text();
	        	info.matches                       = trs.get(i).child(4).text();
	        	info.goals                         = trs.get(i).child(5).text();
	        	info.startingLineUp                = trs.get(i).child(6).text();
	        	info.substitueIn                   = trs.get(i).child(7).text();
	        	info.substituOut                   = trs.get(i).child(8).text();
	        	info.yellowCards                   = trs.get(i).child(9).text();
	        	info.secondYellowCards             = trs.get(i).child(10).text();
	        	info.redCards                      = trs.get(i).child(11).text();
	        	
	        	result.add(info);
	        	
	        }
			return result;
			
		}
		*/
		 
		
}
