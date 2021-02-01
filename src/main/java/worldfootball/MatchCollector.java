package worldfootball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import worldfootball.models.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.HttpUtil;

/**
 * 
 * collect match's information
 *
 */
public class MatchCollector {
	private HttpUtil httpUtil = new HttpUtil();
	private static final String WORLD_FOOTBALL_MATCH_URL = "https://www.worldfootball.net/report/";
	private static final String WORLD_FOOTBALL_HISTORY_MATCH_URL = "https://www.worldfootball.net/teams/%s/%s/11/";

	private GoalsCollector goalsCollector = new GoalsCollector();

	/**
	 * 
	 * @param competitionName
	 * @param competitionYears
	 * @param firstClub
	 * @param secondClub
	 * @return
	 */
	public MatchDetails getMatchDetails(String competitionName, String competitionYears, String firstClub,
			String secondClub) {

		String matchURL = WORLD_FOOTBALL_MATCH_URL + competitionName + "-" + competitionYears + "-" + firstClub + "-"
				+ secondClub + "/";
		String htmlPage = httpUtil.sendGetHttpRequest(matchURL);
		Document doc = Jsoup.parse(htmlPage);
		Elements allTablesInPage = doc.getElementsByClass("standard_tabelle");
		MatchDetails result = new MatchDetails();
		result.matchSummary = getMatchSummary(allTablesInPage);
		result.firstClub = getClubInformation(allTablesInPage, 0, result.matchSummary.firstClubInfo.name);
		result.secondClub = getClubInformation(allTablesInPage, 1, result.matchSummary.secondClubInfo.name);
		result.goals = getMatchGoals(allTablesInPage, result.matchSummary.firstClubInfo.name,
				result.matchSummary.secondClubInfo.name);
		result.referees = getRefereesInMatch(allTablesInPage);
		result.attendance = getMatchAttendance(allTablesInPage);
		result.staduim = getMatchStadium(allTablesInPage);
		// result.attendance = getMatchAttendanceOrStaduim(allTablesInPage ,
		// "Attendance");
		// result.staduim = getMatchAttendanceOrStaduim(allTablesInPage , "stadium");
		return result;
	}

	private String getMatchStadium(Elements allTablesInPage) {
		Elements elementStadium = allTablesInPage.select("tr:has(td:has(img[title=stadium]))");
		if (elementStadium != null) {
			return elementStadium.text();
		}
		return null;
	}

	private String getMatchAttendance(Elements allTablesInPage) {
		Elements elementAttendance = allTablesInPage.select("tr:has(td:has(img[title=Attendance]))");
		if (elementAttendance != null) {
			return elementAttendance.text();
		}
		return null;
	}

	/*
	 * to ask hassan why does not work private String
	 * getMatchAttendanceOrStaduim(Elements allTablesInPage , String request) {
	 * String selectParameter = "tr:has(td:has(img[title=%s]))";
	 * String.format(selectParameter, "Attendance");
	 * System.out.println(selectParameter); Elements element =
	 * allTablesInPage.select(selectParameter); if (element != null) { return
	 * element.text(); } return null; }
	 */
//the site is changed there are many manger , manager and assistant manager do we want them????
	private ClubInMatchDetails getClubInformation(Elements allTablesInPage, int teamNumber, String clubName) {
		Elements elementClubsInfo = allTablesInPage.select("table:has(td[width=10%],[width=72%],[width=18%])");
		Elements elementManagersInfo = allTablesInPage.select("table:has(td:contains(Manager:))");
		ClubInMatchDetails result = new ClubInMatchDetails();
		result.players = getClubPlayersInMatch(elementClubsInfo.get(teamNumber));
		result.manager = elementManagersInfo.get(0).select("td").get(teamNumber).child(0).select("a").attr("title")
				.trim();
		result.clubBasicInfo = new Club(clubName);

		return result;
	}

	private MatchSummary getMatchSummary(Elements allTablesInPage) {
		Elements elementBasicInfo = allTablesInPage.select("table:has(th:has(a[href*=/teams/]))");
		MatchSummary result = new MatchSummary();
		if (elementBasicInfo.size() > 0) {
			Elements trs = elementBasicInfo.get(0).select("tr");
			if (trs.size() == 2) {
				result.firstClubInfo = new Club(trs.get(0).child(0).text());
				result.secondClubInfo = new Club(trs.get(0).child(2).text());
				result.resultSummary = trs.get(1).child(1).text();
				if (trs.get(0).child(1).html().contains("<")) {// new league contains time not only the date
					result.date = trs.get(0).child(1).html().substring(0, trs.get(0).child(1).html().indexOf('<'));
					result.time = trs.get(0).child(1).html().substring(trs.get(0).child(1).html().indexOf('>') + 1);
				} else { // old league information
					result.date = trs.get(0).child(1).text();
				}
			} else {
				throw new RuntimeException("Unexpected match summary details");
			}
		}
		return result;
	}

	private ArrayList<Referee> getRefereesInMatch(Elements allTablesInPage) {
		Elements refereesElement = allTablesInPage.select("tr:has(td:has(img[title=Referee]))");
		if (refereesElement.isEmpty()) {
			return null;
		}
		ArrayList<Referee> result = new ArrayList<>();

		if (refereesElement.size() > 0) {
			Referee referee = new Referee();
			referee.kind = KindOfReferee.Referee;
			referee.name = refereesElement.text().substring(0, refereesElement.text().indexOf("(") - 1);
			referee.nation = refereesElement.text().substring(refereesElement.text().indexOf("(") + 1,
					refereesElement.text().indexOf(")"));
			result.add(referee);
		}
		Elements assistantRefereesElement = allTablesInPage.select("tr:has(td:has(img[title=Assistant Referee]))");
		if (assistantRefereesElement.size() > 0) {
			for (Element assistantReferee : assistantRefereesElement) {
				Referee referee = new Referee();
				referee.kind = KindOfReferee.AssistantReferee;
				referee.name = assistantReferee.text().substring(0, assistantReferee.text().indexOf("(") - 1);
				referee.nation = assistantReferee.text().substring(assistantReferee.text().indexOf("(") + 1,
						assistantReferee.text().indexOf(")"));
				result.add(referee);
			}
		}
		return result;
	}

	private ArrayList<PlayerAtMatch> getClubPlayersInMatch(Element table) {
		ArrayList<PlayerAtMatch> result = new ArrayList<>();
		Elements trsTeam = table.select("tr");
		if (trsTeam.isEmpty()) {
			return null;
		}
		int indexOfRowWithSubstitutesTitle = getIndexOfRowWithSubstitutesTitle(trsTeam);
		for (int i = 0; i < trsTeam.size(); i++) {
			if (i != indexOfRowWithSubstitutesTitle) {
				PlayerAtMatch player = new PlayerAtMatch();
				player.playerNumberAsString = (trsTeam.get(i).child(0).text().isEmpty()) ? null
						: trsTeam.get(i).child(0).text();
				player.playerBasicInfo = new Player(trsTeam.get(i).child(1).child(0).text().trim());
				player.events = getPlayerEventsInMatch(trsTeam.get(i).child(1));
				if ((indexOfRowWithSubstitutesTitle != -1 && i < indexOfRowWithSubstitutesTitle)
						|| indexOfRowWithSubstitutesTitle == -1) {
					player.playerType = PlayerTypeAtMatch.Essential;

				} else if (indexOfRowWithSubstitutesTitle != -1 && i > indexOfRowWithSubstitutesTitle) {
					player.playerType = PlayerTypeAtMatch.Substitute;
				}
				if (trsTeam.get(i).child(2).hasText()) {
					PlayerEventAtMatch event = new PlayerEventAtMatch();
					event.event = (player.playerType == PlayerTypeAtMatch.Essential) ? "out" : "in";
					event.minute = trsTeam.get(i).child(2).text().substring(0,
							trsTeam.get(i).child(2).text().length() - 1);
					player.events.add(event);
				}
				if (player.events.isEmpty()) {
					player.events = null;
				}
				result.add(player);
			}
		}
		return result;
	}

	/// to get events
	// image contains the name of event (red card , yellow card,....) and the next
	/// span contains the time
	// eventIndex+2 (i.e) event's name and it's time
	private ArrayList<PlayerEventAtMatch> getPlayerEventsInMatch(Element TdPlayer) {
		ArrayList<PlayerEventAtMatch> result = new ArrayList<>();
		Elements elementPlayerEvents = TdPlayer.select(" img , span[title*=at]");
		if (!(elementPlayerEvents.isEmpty())) {
			for (int eventIndex = 0; eventIndex < elementPlayerEvents.size(); eventIndex = eventIndex + 2) {
				PlayerEventAtMatch event1 = new PlayerEventAtMatch();
				event1.event = elementPlayerEvents.get(eventIndex).attr("title");
				event1.minute = elementPlayerEvents.get(eventIndex + 1).attr("title").substring(3, 5);
				result.add(event1);
			}
		}
		return result;
	}

	private int getIndexOfRowWithSubstitutesTitle(Elements trs) {
		for (int i = 0; i < trs.size(); i++) {
			if (trs.get(i).html().contains("Substitutes")) {
				return i;
			}
		}
		return -1;// no sub (i.e old league)
	}

	private ArrayList<GoalInMatchDetails> getMatchGoals(Elements allTablesInPage, String firstClub, String secondClub) {
		Elements goalsTable = allTablesInPage.select("table:has(tbody:has(tr:has(td:contains(goals))))");
		Elements trs = goalsTable.select("tr");
		if (trs.get(1).text().equals("none")) {// the result is 0:0
			return null;
		}
		ArrayList<GoalInMatchDetails> result = new ArrayList<>();
		for (int i = 1; i < trs.size(); i++) {
			GoalInMatchDetails goal = new GoalInMatchDetails();

			if (trs.get(i).child(1).hasAttr("style")) {// second club
				goal.clubInfo = new Club(secondClub);
			} else {
				goal.clubInfo = new Club(firstClub);
			}

			if (!(trs.get(i).child(1).ownText().contains("/"))) {// old league does not have any information, it only
																	// has 0.
				goal.goalsInfo = goalsCollector.getGoal(trs.get(i), KindOfGoal.OldGoal);

			} else {// new league
				if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.HasAssister) {
					goal.goalsInfo = goalsCollector.getGoal(trs.get(i), KindOfGoal.HasAssister);

				} else if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.Reverse) {
					goal.goalsInfo = goalsCollector.getGoal(trs.get(i), KindOfGoal.Reverse);

				} else if (goalsCollector.kindOfGoal(trs.get(i)) == KindOfGoal.Individually) {
					goal.goalsInfo = goalsCollector.getGoal(trs.get(i), KindOfGoal.Individually);
				}
			}
			result.add(goal);
		}

		return result;
	}

	public ArrayList<HistoyGame> getHistoryOfGame(String firstClub, String secondClub) {

		String url = String.format(WORLD_FOOTBALL_HISTORY_MATCH_URL, firstClub, secondClub);
		String htmlPage = httpUtil.sendGetHttpRequest(url);
		Document doc = Jsoup.parse(htmlPage);
		Elements tables = doc.select("table.standard_tabelle")
				.select("table:has(tbody:has(tr:has(a[href*=/competition/])))");
		ArrayList<HistoyGame> result = new ArrayList<>(Arrays.asList());
		for (int i = 1; i < tables.size(); i++) {// first table contains overall information about every competition and overall of all competitions
			Elements trs = tables.get(i).select("tr");
			String competitionName = trs.get(0).child(0).child(0).attr("title");
			for (int j = 1; j < trs.size(); j++) {
				HistoyGame game = new HistoyGame();
				game.competitionName = competitionName;
				game.year = trs.get(j).child(0).child(0).text();
				game.roundInfo = trs.get(j).child(1).child(0).text();
				
				Club firstClubInfo = new Club(trs.get(j).child(2).child(0).attr("title"));
				Club secondClubInfo = new Club(trs.get(j).child(4).child(0).attr("title"));
				String gameResult = (trs.get(j).child(5).childrenSize() > 0)?trs.get(j).child(5).child(0).text():trs.get(j).child(5).text();
				game.gameInfo = new Game(null , null , firstClubInfo, secondClubInfo, gameResult );
				result.add(game);
			}
		}
		Collections.sort(result);
		return result;
	}
	
	public int getRankingClub(String competitionName , String competitionYear, int round , String club ){
		
		TableCollector tableCollector = new TableCollector();
		if(round == 1) {return 1;}
		RankingTable table = tableCollector.getTableByRound(competitionName, competitionYear,String.valueOf(round-1), RankingTableRequest.Normal);
		int result = -1;
		for(int i =0 ; i < table.table.size(); i++) {
			if(table.table.get(i).clubBasicInfo.name.equals(club)) {
				return(Integer.valueOf(table.table.get(i).position));
			}
		}
		if(result == -1) {
			throw new RuntimeException("can not find "+club +" in "+ competitionName +" "+competitionYear+" round "+round);
		}
		return result;
	}
}
