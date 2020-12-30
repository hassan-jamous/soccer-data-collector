package collector;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import models.PlayerAllInformation;
import models.PlayerClubCareer;
import models.PlayerCompetitionInformationOverall;
import models.PlayerCompetitionsInformation;

import models.PlayerPersonalInformation;
import models.PlayerTeamManaged;

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
        Elements divs = doc.getElementsByClass("box");

        Elements divTeamsManaged = divs.select("div:has(div:has(h2:contains(Teams managed)))");
        Elements divClubCareer = divs.select("div:has(div:has(h2:contains(Club career)))");
        Elements divClubMatches = divs.select("div:has(div:has(h2:contains(Club matches)))");
        Elements divInternationals = divs.select("div:has(div:has(h2:contains(Internationals)))");
        Elements divPersonalInformation = divs.select("div:has(div:has(h2[itemprop=name]))");

        PlayerAllInformation playerTotalInfo = new PlayerAllInformation();
        playerTotalInfo.teamsManaged = getPlayerTeamManaged(divTeamsManaged);
        playerTotalInfo.clubsCareer = getClubCareer(divClubCareer);
        playerTotalInfo.personalInfo = getPlayerPersonalInformation(divPersonalInformation);
        playerTotalInfo.clubMatches = getPlayerClubsAndInternatiolsCompetitions(divClubMatches);
        playerTotalInfo.internationalCopmetitionsInfo = getPlayerClubsAndInternatiolsCompetitions(divInternationals);
        if (getOverallURL(divClubMatches) != null) {
            playerTotalInfo.clubsMatchesOverall = getOverallCompetitionWithClubsInformation(WORLD_FOOTBALL_SITE_URL + getOverallURL(divClubMatches));
        }
        if (getOverallURL(divInternationals) != null) {
            playerTotalInfo.internationalCopmetitionsOverall = getOverallCompetitionWithClubsInformation(WORLD_FOOTBALL_SITE_URL + getOverallURL(divInternationals));
        }
        return playerTotalInfo;
    }

    private ArrayList<PlayerTeamManaged> getPlayerTeamManaged(Elements div) {
        Elements trs = div.select("tr");
        PlayerTeamManaged palyerTeamManaged;
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

    private ArrayList<PlayerClubCareer> getClubCareer(Elements div) {
        Elements trClubs = div.select("tr");
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

    private PlayerPersonalInformation getPlayerPersonalInformation(Elements divInfo) {
        Element div = divInfo.get(0);
        PlayerPersonalInformation info = new PlayerPersonalInformation();
        info.playerBasicInfo.name = div.child(1).text();
        Elements tds = div.child(3).select("td");
        info.fullName = tds.get(0).text();
        info.born = tds.get(3).text();
        info.birthPlace = tds.get(5).text();
        info.nationality = tds.get(7).text();

        if (tds.size() >= 15) {//new style for modern player
            info.height = tds.get(9).text();
            info.weight = tds.get(11).text();
            info.positions = tds.get(13).text();
            info.foot = tds.get(15).text();
        }
        return info;
    }

    private ArrayList<PlayerCompetitionsInformation> getPlayerClubsAndInternatiolsCompetitions(Elements div) {
        Elements trs = div.select("tr");
        PlayerCompetitionsInformation palyerInfoInternational;
        ArrayList<PlayerCompetitionsInformation> result = new ArrayList<>();
        for (int i = 1; i < trs.size(); i++) {
            palyerInfoInternational = new PlayerCompetitionsInformation();
            int rowNumber = 1;
            if (trs.get(i).child(0).text().contains("∑")) {
                palyerInfoInternational.competitionName = trs.get(i).child(0).text().replace("∑", "Total");
                palyerInfoInternational.competitionNation = null;
            } else {
                palyerInfoInternational.competitionName = trs.get(i).child(0).text();
                palyerInfoInternational.competitionNation = trs.get(i).child(1).child(0).attr("title");
                rowNumber = 2;
            }
			palyerInfoInternational.matchesNumber = trs.get(i).child(rowNumber++).text();
			palyerInfoInternational.goalsNumber = trs.get(i).child(rowNumber++).text();
			palyerInfoInternational.startingLineUp = trs.get(i).child(rowNumber++).text();
			palyerInfoInternational.substitueIn = trs.get(i).child(rowNumber++).text();
			palyerInfoInternational.substitueOut = trs.get(i).child(rowNumber++).text();
			palyerInfoInternational.yellowCards = trs.get(i).child(rowNumber++).text();
			palyerInfoInternational.secondYellowCards = trs.get(i).child(rowNumber++).text();
			palyerInfoInternational.redCards = trs.get(i).child(rowNumber++).text();
			result.add(palyerInfoInternational);
        }
        return result;
    }

    private String getOverallURL(Elements div) {
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
}
