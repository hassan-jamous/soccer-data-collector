package worldfootball;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import worldfootball.models.HashMapPlayerAttributeIsIntilized;
import worldfootball.models.PlayerAllInformation;
import worldfootball.models.PlayerClubCareer;
import worldfootball.models.PlayerCompetitionInformationOverall;
import worldfootball.models.PlayerCompetitionInformation;
import worldfootball.models.PlayerInformationRequest;
import worldfootball.models.PlayerOpponentRecordInformation;
import worldfootball.models.PlayerPersonalInformation;
import worldfootball.models.PlayerPersonalInformationKindOf_TD;
import worldfootball.models.PlayerRefereeRecordInformation;
import worldfootball.models.PlayerTeamManaged;
import util.HttpUtil;

public class PlayerCollector {
    private HttpUtil httpUtil = new HttpUtil();
    private static final String WORLD_FOOTBALL_PLAYERS_SUMMARY_URL = "https://www.worldfootball.net/player_summary/";
    private static final String WORLD_FOOTBALL_SITE_URL = "https://www.worldfootball.net/";

    //look to bruno-fernandes at manchester  united 2020 (url is bruno-fernandes_2)
    //not just name
    public PlayerAllInformation getAllInformationAboutPlayer(String nameAsInURL) {
        String url = WORLD_FOOTBALL_PLAYERS_SUMMARY_URL + nameAsInURL + "/";

        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements divs = doc.select("div.box,div.data");
        PlayerAllInformation playerTotalInfo = new PlayerAllInformation();
        playerTotalInfo.teamsManaged = getPlayerTeamManaged(divs , nameAsInURL);
        playerTotalInfo.clubsCareer = getClubCareer(divs);
        playerTotalInfo.personalInfo = getPlayerPersonalInformation(divs);
        playerTotalInfo.clubMatches = getPlayerClubsAndInternatiolsCompetitions(divs , PlayerInformationRequest.Clubs);
        playerTotalInfo.internationalCopmetitionsInfo = getPlayerClubsAndInternatiolsCompetitions(divs , PlayerInformationRequest.International);
        if (getOverallURL(divs , PlayerInformationRequest.Clubs) != null) {
            playerTotalInfo.clubsMatchesOverall = getOverallCompetitionWithClubsInformation(WORLD_FOOTBALL_SITE_URL + getOverallURL(divs , PlayerInformationRequest.Clubs));
        }
        else {playerTotalInfo.clubsMatchesOverall = null;}
        if (getOverallURL(divs , PlayerInformationRequest.International) != null) {
            playerTotalInfo.internationalCopmetitionsOverall = getOverallCompetitionWithClubsInformation(WORLD_FOOTBALL_SITE_URL + getOverallURL(divs ,PlayerInformationRequest.International));
        }
        else {playerTotalInfo.internationalCopmetitionsOverall = null;}
        playerTotalInfo.forEachCompetitionInformationOverallsClubs = getAllInformationOverAllForEachCompetitionWithClubsORInternational1(divs , PlayerInformationRequest.Clubs );
        playerTotalInfo.forEachCompetitionInformationOverallsInternational = getAllInformationOverAllForEachCompetitionWithClubsORInternational1(divs , PlayerInformationRequest.International  );

        playerTotalInfo.recordOpponent = getPlayerOpponentRecord(divs);
        playerTotalInfo.recordReferee = getPlayerRefereeRecord(divs);
        return playerTotalInfo;
    }

    private ArrayList<PlayerTeamManaged> getPlayerTeamManaged(Elements divs, String nameAsURL) {
    	Elements divTeamsManaged = divs.select("div:has(div:has(h2:contains(Teams managed)))");
        Elements trs = divTeamsManaged.select("tr");
        PlayerTeamManaged palyerTeamManaged;
        if(trs.size() ==0) {
        	return null;
        }
        ArrayList<PlayerTeamManaged> result = new ArrayList<>();
        for (int i = 0; i < trs.size(); i++) {
            palyerTeamManaged = new PlayerTeamManaged();
            palyerTeamManaged.date = trs.get(i).child(0).text();
            palyerTeamManaged.clubBasicInfo.name = trs.get(i).child(2).text();
            palyerTeamManaged.clubNation = trs.get(i).child(3).child(0).attr("title");
            palyerTeamManaged.position = trs.get(i).child(4).text();
            result.add(palyerTeamManaged);
        }
        return result;
    }

    private ArrayList<PlayerClubCareer> getClubCareer(Elements divs) {
    	Elements divClubCareer = divs.select("div:has(div:has(h2:contains(Club career)))");
        Elements trClubs = divClubCareer.select("tr");
        if(trClubs.size() ==0) {
        	return null;
        }
        ArrayList<PlayerClubCareer> result = new ArrayList<>();
        PlayerClubCareer club;
        for (int i = 0; i < trClubs.size(); i++) {
            club = new PlayerClubCareer();
            if ((i == 0) && (trClubs.get(0).child(1).attr("width").equals("60%"))) {//new league has a different style
                club.clubBasicInfo.name = trClubs.get(0).child(1).child(0).child(0).text();
                club.clubNation = trClubs.get(0).child(1).child(1).child(0).attr("title");
                String playerPositionAndContract = trClubs.get(0).child(1).child(1).text();
                club.playerPosition = playerPositionAndContract.substring(club.clubNation.length() + 1, playerPositionAndContract.indexOf('/') - 3);
                club.years = playerPositionAndContract.substring(playerPositionAndContract.indexOf('/') - 2);
                club.playerNumber = trClubs.get(0).child(2).child(0).text();
                result.add(club);
            } else if ((trClubs.get(i).childrenSize() > 4)) {
                club.years = trClubs.get(i).child(0).text();
                club.clubBasicInfo.name = trClubs.get(i).child(2).text();
                club.clubNation = trClubs.get(i).child(3).child(0).attr("title");
                club.playerPosition = trClubs.get(i).child(4).text();
                result.add(club);
            }
        }
        return result;
    }

    private PlayerPersonalInformation getPlayerPersonalInformation(Elements divs) {
        Elements divPersonalInformation = divs.select("div:has(div:has(h2[itemprop=name]))");
        if(divPersonalInformation.size() ==0) {
        	return null;
        }
        Element div = divPersonalInformation.get(0);
        PlayerPersonalInformation info = new PlayerPersonalInformation();
        info.playerBasicInfo.name = div.child(1).text();
        Elements trs = div.child(3).select("tr");
        HashMapPlayerAttributeIsIntilized isIntilized = new HashMapPlayerAttributeIsIntilized() ; 
        for(int i =0 ; i <trs.size(); i++) {
        	switch (getKindOfTD( trs , i)) {
				case fullName:
					isIntilized.changeToTrue(PlayerPersonalInformationKindOf_TD.fullName);
					info.fullName = trs.get(i).child(0).text();
				break;
				case Born:
					isIntilized.changeToTrue(PlayerPersonalInformationKindOf_TD.Born);
					info.born = trs.get(i).child(1).text();
				break;
				case PlaceOfBirth:
					isIntilized.changeToTrue(PlayerPersonalInformationKindOf_TD.PlaceOfBirth);
					info.birthPlace = trs.get(i).child(1).text();
				break;
				case Nationality:{
					isIntilized.changeToTrue(PlayerPersonalInformationKindOf_TD.Nationality);
					Elements imgs = trs.get(i).select("img[src*=flaggen_neu]");
						for(Element img :imgs) {
							info.nationality.add(img.attr("alt"));
					}
				break;}
				case Weight:
					isIntilized.changeToTrue(PlayerPersonalInformationKindOf_TD.Weight);
					info.weight = trs.get(i).child(1).text();
				break;
				case Height:
					isIntilized.changeToTrue(PlayerPersonalInformationKindOf_TD.Height);
					info.height = trs.get(i).child(1).text();
				break;
				case Position:{	
					isIntilized.changeToTrue(PlayerPersonalInformationKindOf_TD.Position);
					String[]positions = trs.get(i).child(1).html().split("<br>");
					for(int j =0 ; j<positions.length ; j++) {
						info.positions.add(positions[j]);
					}
				break;}
				case Foot:
					isIntilized.changeToTrue(PlayerPersonalInformationKindOf_TD.Foot);
					info.foot = trs.get(i).child(1).text();
				break;
			default:
				break;
			}
        }
        setToNullIfNotInsilized( isIntilized,info);
        return info;
    }
 
    private void setToNullIfNotInsilized(HashMapPlayerAttributeIsIntilized flags,PlayerPersonalInformation playerInfo) {
    	for(PlayerPersonalInformationKindOf_TD  key: flags.attributesFlag.keySet()) {
    		switch (key){
			case fullName:
				if(flags.attributesFlag.get(key) == false) {playerInfo.fullName = null;}
			break;
			case Born:
				if(flags.attributesFlag.get(key) == false) {playerInfo.born = null;}
			break;
			case PlaceOfBirth:
				if(flags.attributesFlag.get(key) == false) {playerInfo.birthPlace = null;}
			break;
			case Nationality:
				if(flags.attributesFlag.get(key) == false) {playerInfo.nationality = null;}
			break;
			case Weight:
				if(flags.attributesFlag.get(key) == false) {playerInfo.weight = null;}
			break;
			case Height:
				if(flags.attributesFlag.get(key) == false) {playerInfo.height = null;}
			break;
			case Position:
				if(flags.attributesFlag.get(key) == false) {playerInfo.positions = null;}
			break;
			case Foot:
				if(flags.attributesFlag.get(key) == false) {playerInfo.foot = null;}
			break;
		default:
			break;
			}
    	}
    }
    
    private PlayerPersonalInformationKindOf_TD getKindOfTD(Elements trs ,int i) {
    	if(! trs.get(i).select("td:has(b:contains(Born:))").isEmpty()) {
    		return PlayerPersonalInformationKindOf_TD.Born;
    	}
    	else if(! trs.get(i).select("td:has(b:contains(Place of birth:))").isEmpty()) {
    		return PlayerPersonalInformationKindOf_TD.PlaceOfBirth;
    	}
    	else if(! trs.get(i).select("td:has(b:contains(Place of birth:))").isEmpty()) {
    		return PlayerPersonalInformationKindOf_TD.PlaceOfBirth;
    	}
   		else if(! trs.get(i).select("td:has(b:contains(Nationality:))").isEmpty()) {
        		return PlayerPersonalInformationKindOf_TD.Nationality;
        }
   		else if(! trs.get(i).select("td:has(b:contains(Height:))").isEmpty()) {
    		return PlayerPersonalInformationKindOf_TD.Height;
   		}
   		else if(! trs.get(i).select("td:has(b:contains(Weight:))").isEmpty()) {
    		return PlayerPersonalInformationKindOf_TD.Weight;
   		}
   		else if(! trs.get(i).select("td:has(b:contains(Position))").isEmpty()) {
    		return PlayerPersonalInformationKindOf_TD.Position;
   		}
   		else if(! trs.get(i).select("td:has(b:contains(Foot:))").isEmpty()) {
    		return PlayerPersonalInformationKindOf_TD.Foot;
   		}
   		else if((i==0) && (i+1 < trs.size()) && (trs.get(i+1).childrenSize() ==1) 
   				&& (trs.get(i+1).child(0).text().equals(""))
   				&& trs.get(i).childrenSize()==1){
   			return PlayerPersonalInformationKindOf_TD.fullName;
   		}
    	return PlayerPersonalInformationKindOf_TD.Error;
    	
    }
    
    private ArrayList<PlayerCompetitionInformation> getPlayerClubsAndInternatiolsCompetitions(Elements divs , PlayerInformationRequest requerstInfo ) {
    	Elements div;
    	if(requerstInfo == PlayerInformationRequest.Clubs) {
        	div = divs.select("div:has(div:has(h2:contains(Club matches)))");
    	}
    	else {
    		div = divs.select("div:has(div:has(h2:contains(Internationals)))");
    	}
        
        Elements trs = div.select("tr");
        if(trs.size() ==0 ) {return null;}
        PlayerCompetitionInformation palyerInfo;
        ArrayList<PlayerCompetitionInformation> result = new ArrayList<>();
        for (int i = 1; i < trs.size(); i++) {
            palyerInfo = new PlayerCompetitionInformation();
            int rowNumber = 1;
            if (trs.get(i).child(0).text().contains("∑")) {
                palyerInfo.competitionName = trs.get(i).child(0).text();
                palyerInfo.competitionNation = null;
            } else {
                palyerInfo.competitionName = trs.get(i).child(0).text();
                palyerInfo.competitionNation = trs.get(i).child(1).child(0).attr("title");
                rowNumber = 2;
            }
			palyerInfo.matchesNumber = trs.get(i).child(rowNumber++).text();
			palyerInfo.goalsNumber = trs.get(i).child(rowNumber++).text();
			palyerInfo.startingLineUp = trs.get(i).child(rowNumber++).text();
			palyerInfo.substitueIn = trs.get(i).child(rowNumber++).text();
			palyerInfo.substitueOut = trs.get(i).child(rowNumber++).text();
			palyerInfo.yellowCards = trs.get(i).child(rowNumber++).text();
			palyerInfo.secondYellowCards = trs.get(i).child(rowNumber++).text();
			palyerInfo.redCards = trs.get(i).child(rowNumber++).text();
			result.add(palyerInfo);
        }
        return result;
    }

    private String getOverallURL(Elements divs ,PlayerInformationRequest requestInfo) {
    	Elements div;
    	if(requestInfo == PlayerInformationRequest.Clubs) {
        	div = divs.select("div:has(div:has(h2:contains(Club matches)))");
    	}
    	else {
    		div = divs.select("div:has(div:has(h2:contains(Internationals)))");
    	}
        Elements trs = div.select("tr:contains(∑)");
        Elements link = trs.select("a:contains(Overall)");
        if (!(link.isEmpty())) {
            return link.attr("href");
        }
        return null;
    }

    private ArrayList<PlayerCompetitionInformationOverall> getOverallCompetitionWithClubsInformation(String url) {
        String htmlPage = httpUtil.sendGetHttpRequest(url);
        Document doc = Jsoup.parse(htmlPage);
        Elements table = doc.select("table:has(tbody:has(tr:has(th:contains(Team)))),table:has(tbody:has(tr:has(th:contains(Season))))");
        Elements trs = table.select("tr");

        ArrayList<PlayerCompetitionInformationOverall> result = new ArrayList<>();
        PlayerCompetitionInformationOverall info;
        for (int i = 1; i < trs.size(); i++) {
            info = new PlayerCompetitionInformationOverall();
            info.competitionInfo.competitionNation = trs.get(i).child(0).child(0).attr("title");
            info.competitionInfo.competitionName = trs.get(i).child(1).text();
            info.competitionYears = trs.get(i).child(2).text();
            info.clubInfo.name = trs.get(i).child(3).text();
            info.competitionInfo.matchesNumber = trs.get(i).child(4).text();
            info.competitionInfo.goalsNumber = trs.get(i).child(5).text();
            info.competitionInfo.startingLineUp = trs.get(i).child(6).text();
            info.competitionInfo.substitueIn = trs.get(i).child(7).text();
            info.competitionInfo.substitueOut = trs.get(i).child(8).text();
            info.competitionInfo.yellowCards = trs.get(i).child(9).text();
            info.competitionInfo.secondYellowCards = trs.get(i).child(10).text();
            info.competitionInfo.redCards = trs.get(i).child(11).text();
            result.add(info);
        }
        return result;
    }
    private ArrayList<PlayerOpponentRecordInformation> getPlayerOpponentRecord(Elements divs ) {
    	
    	Elements link = divs.select("a[href*=gegner]");
    	if(link.isEmpty()) {
    		return null;
    	}
    	String htmlPage = httpUtil.sendGetHttpRequest(WORLD_FOOTBALL_SITE_URL+link.attr("href"));
        Document doc = Jsoup.parse(htmlPage);
        Elements table = doc.select("table:has(tbody:has(tr:has(th:contains(Opponent)))),table:has(tbody:has(tr:has(th:has(img[title=Matches]))))");
        Elements trs = table.select("tr");
        PlayerOpponentRecordInformation palyerInfoInternational;
        ArrayList<PlayerOpponentRecordInformation> result = new ArrayList<>();
        for (int i = 0; i < trs.size(); i++) {
        	if(!(trs.get(i).child(0).tagName().equals("th"))) {
	            palyerInfoInternational = new PlayerOpponentRecordInformation();
	            
	            palyerInfoInternational.opponentName.name  = trs.get(i).child(1).child(0).ownText();
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
        private ArrayList<PlayerRefereeRecordInformation> getPlayerRefereeRecord(Elements divs ) {
        	
        	Elements link = divs.select("a[href*=schiedsrichter]");
        	if(link.isEmpty()) {
        		return null;
        	}
        	String htmlPage = httpUtil.sendGetHttpRequest(WORLD_FOOTBALL_SITE_URL+link.attr("href"));
            Document doc = Jsoup.parse(htmlPage);
            Elements table = doc.select("table:has(tbody:has(tr:has(th:contains(Opponent)))),table:has(tbody:has(tr:has(th:has(img[title=Matches]))))");
            Elements trs = table.select("tr");
            PlayerRefereeRecordInformation palyerInfoInternational;
            ArrayList<PlayerRefereeRecordInformation> result = new ArrayList<>();
            for (int i = 0; i < trs.size(); i++) {
            	if(!(trs.get(i).child(0).tagName().equals("th"))) {
    	            palyerInfoInternational = new PlayerRefereeRecordInformation();
    	            
    	            palyerInfoInternational.refereeInfo.name  = trs.get(i).child(0).text();
    	            palyerInfoInternational.refereeInfo.nation = trs.get(i).child(1).child(0).attr("title");
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
        private ArrayList< ArrayList<PlayerCompetitionInformationOverall>> getAllInformationOverAllForEachCompetitionWithClubsORInternational(Elements divs ,PlayerInformationRequest requerstInfo ) {
        	Elements div;
        	if(requerstInfo == PlayerInformationRequest.Clubs) {
            	div = divs.select("div:has(div:has(h2:contains(Club matches)))");
        	}
        	else {
        		div = divs.select("div:has(div:has(h2:contains(Internationals)))");
        	}            
            Elements trs = div.select("tr");
            if(trs.size() ==0 ) {return null;}
            ArrayList <ArrayList<PlayerCompetitionInformationOverall>> result =new ArrayList<>();
            for (int i = 1; i < trs.size(); i++) {
            	Elements link = trs.get(i).select("a[href*=/player_summary/]");
            	if (!(link.isEmpty())) {
            		result.add(getCompetitionInformation(WORLD_FOOTBALL_SITE_URL + link.attr("href")));
            		
            	}
            }
            return result;
        }
        private ArrayList<PlayerCompetitionInformationOverall> getCompetitionInformation(String url) {
        	String htmlPage = httpUtil.sendGetHttpRequest(url);
            Document doc = Jsoup.parse(htmlPage);
            Elements table = doc.select("table:has(tbody:has(tr:has(th:contains(league))))").select(
            		"table:has(tbody:has(tr:has(th:contains(Team))))").select("table:has(tbody:has(tr:has(th:contains(Season))))");
            ArrayList<PlayerCompetitionInformationOverall> result =new ArrayList<>(); 
            Elements trs = table.select("tr");
            if(trs.isEmpty()) {throw new RuntimeException("Error in getCompetitionInformation" + url);}
            for(int i =1 ; i<trs.size() ; i++) {
            	PlayerCompetitionInformationOverall playerCompetitionInfo = new PlayerCompetitionInformationOverall(); 
            	playerCompetitionInfo.competitionInfo.competitionNation = trs.get(i).child(0).child(0).attr("title");
            	playerCompetitionInfo.competitionInfo.competitionName   = trs.get(i).child(1).child(0).text();
            	playerCompetitionInfo.competitionYears                  = trs.get(i).child(2).child(0).text();
            	playerCompetitionInfo.clubInfo.name                     = trs.get(i).child(3).child(0).text();
            	playerCompetitionInfo.competitionInfo.matchesNumber     = trs.get(i).child(4).child(0).text();
            	playerCompetitionInfo.competitionInfo.goalsNumber       = trs.get(i).child(5).text();
            	playerCompetitionInfo.competitionInfo.startingLineUp    = trs.get(i).child(6).text();
            	playerCompetitionInfo.competitionInfo.substitueOut      = trs.get(i).child(7).text();
            	playerCompetitionInfo.competitionInfo.yellowCards       = trs.get(i).child(8).text();
            	playerCompetitionInfo.competitionInfo.secondYellowCards = trs.get(i).child(9).text();
            	playerCompetitionInfo.competitionInfo.redCards          = trs.get(i).child(10).text();
            
            	result.add(playerCompetitionInfo);
            }
            
        	return result;
        }
        private void getCompetitionInformation1(String url  ,ArrayList<PlayerCompetitionInformationOverall> result) {
        	String htmlPage = httpUtil.sendGetHttpRequest(url);
            Document doc = Jsoup.parse(htmlPage);
            Elements table = doc.select("table:has(tbody:has(tr:has(th:contains(league))))").select(
            		"table:has(tbody:has(tr:has(th:contains(Team))))").select("table:has(tbody:has(tr:has(th:contains(Season))))");
            Elements trs = table.select("tr");
            if(trs.isEmpty()) {throw new RuntimeException("Error in getCompetitionInformation" + url);}
            for(int i =1 ; i<trs.size() ; i++) {
            	PlayerCompetitionInformationOverall playerCompetitionInfo = new PlayerCompetitionInformationOverall(); 
            	playerCompetitionInfo.competitionInfo.competitionNation = trs.get(i).child(0).child(0).attr("title");
            	playerCompetitionInfo.competitionInfo.competitionName   = trs.get(i).child(1).child(0).text();//ask hassan we want full name of competition or just this name (in record (where we get the link_url the name is champion leagues here Ch.league)) 
            	playerCompetitionInfo.competitionYears                  = trs.get(i).child(2).child(0).text();
            	playerCompetitionInfo.clubInfo.name                     = trs.get(i).child(3).child(0).text();
            	playerCompetitionInfo.competitionInfo.matchesNumber     = trs.get(i).child(4).child(0).text();
            	playerCompetitionInfo.competitionInfo.goalsNumber       = trs.get(i).child(5).text();
            	playerCompetitionInfo.competitionInfo.startingLineUp    = trs.get(i).child(6).text();
            	playerCompetitionInfo.competitionInfo.substitueIn       = trs.get(i).child(7).text();
            	playerCompetitionInfo.competitionInfo.substitueOut      = trs.get(i).child(8).text();
            	playerCompetitionInfo.competitionInfo.yellowCards       = trs.get(i).child(9).text();
            	playerCompetitionInfo.competitionInfo.secondYellowCards = trs.get(i).child(10).text();
            	playerCompetitionInfo.competitionInfo.redCards          = trs.get(i).child(11).text();
            
            	result.add(playerCompetitionInfo);
            }
            
        }
        private ArrayList<PlayerCompetitionInformationOverall> getAllInformationOverAllForEachCompetitionWithClubsORInternational1(Elements divs ,PlayerInformationRequest requerstInfo)  {
        	Elements div;
        	if(requerstInfo == PlayerInformationRequest.Clubs) {
            	div = divs.select("div:has(div:has(h2:contains(Club matches)))");
        	}
        	else {
        		div = divs.select("div:has(div:has(h2:contains(Internationals)))");
        	}            
            Elements trs = div.select("tr");
            if(trs.size() ==0 ) {return null;}
            ArrayList <PlayerCompetitionInformationOverall> result =new ArrayList<>();
            for (int i = 1; i < trs.size(); i++) {
            	Elements link = trs.get(i).select("a[href*=/player_summary/]");
            	if (!(link.isEmpty())) {
            		getCompetitionInformation1(WORLD_FOOTBALL_SITE_URL + link.attr("href"), result);
            		
            	}
            }
            return result;
        }
    
    
}
