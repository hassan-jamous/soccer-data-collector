package sofaScore;

import java.util.List;

import com.google.gson.Gson;
import csvFile.CSVFilesDealer;
import sofaScore.models.season.CurrentRound;
import sofaScore.models.season.PageOfSeasonRounds;
import sofaScore.models.utilities.HashMapLeaguesID;
import sofaScore.models.utilities.HashMapSeasonsID;
import sofaScore.models.utilities.SeasonIDObject;
import util.HttpUtil;

public class SeasonCollector {

	private final HttpUtil httpUtil = new HttpUtil();
	private final String API_SOFA_SCORE_SEASON_ROUNDS_URL = "https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/rounds";
	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID();
	RoundCollector roundCollerctor = new RoundCollector();
	GameCollector gameCollector = new GameCollector();
	CSVFilesDealer csvDealer = new CSVFilesDealer();

	/**
	 * 
	 * @param competitionName  for example ( Premier League , LaLiga , Bundesliga ,
	 *                         Seria A .....)
	 * @param competitionYears for example (2020/2021 , 2009/2021 , 1999/1998 ,
	 *                         ....)
	 * @return object contains all round in the season until now
	 */
	public PageOfSeasonRounds getSeasonRounds(String competitionName, String competitionYears) {

		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_SEASON_ROUNDS_URL,leagueId.getLeagueID(competitionName), seasonId.getSeasonID(competitionName, competitionYears)));
		if (gsonString.contains("Not Found")) {
			return getSeasonRoundsIfNotFoundInSite(competitionName, competitionYears);
		}
		Gson gson = new Gson();
		PageOfSeasonRounds seasonRounds = gson.fromJson(gsonString, PageOfSeasonRounds.class);
		return seasonRounds;
	}

	/**
	 * 
	 * @param competitionName  for example ( Premier League , LaLiga , Bundesliga ,
	 *                         Seria A .....)
	 * @param competitionYears for example (2020/2021 , 2009/2021 , 1999/1998 ,
	 *                         ....)
	 * 
	 */
	public void writeSeasonBasicInfoAndStatistics(String competitionName, String competitionYears) {

		PageOfSeasonRounds seasonRounds = getSeasonRounds(competitionName, competitionYears);
		if ((seasonRounds.currentRound.name == null) || (seasonRounds.currentRound.name == "Not Found")) {
			for (int i = 1; i <= seasonRounds.currentRound.round; i++) {
				roundCollerctor.writeRoundBasicInfoAndStatistics(competitionName, competitionYears, String.valueOf(i), "");
			}
		} else {
			for (int i = 0; i < seasonRounds.rounds.size(); i++) {
				roundCollerctor.writeRoundBasicInfoAndStatistics(competitionName, competitionYears,
						String.valueOf(seasonRounds.rounds.get(i).round),
						(seasonRounds.rounds.get(i).slug == null) ? "" : "/slug/" + seasonRounds.rounds.get(i).slug);
			}
		}
	}
	
	/**
	 * 
	 * @param competitionName  for example ( Premier League , LaLiga , Bundesliga ,
	 *                         Seria A .....)
	 * @param competitionYears for example (2020/2021 , 2009/2021 , 1999/1998 ,
	 *                         ....)
	 * 
	 */
	public void writeSeasonIncidents(String competitionName, String competitionYears) {
		PageOfSeasonRounds seasonRounds = getSeasonRounds(competitionName, competitionYears);
		if ((seasonRounds.currentRound.name == null) || (seasonRounds.currentRound.name == "Not Found")) {
			for (int i = 1; i <= seasonRounds.currentRound.round; i++) {
				roundCollerctor.writeRoundIncidents(competitionName, competitionYears, String.valueOf(i), "");
			}
		} else {
			for (int i = 0; i < seasonRounds.rounds.size(); i++) {
				roundCollerctor.writeRoundIncidents(competitionName, competitionYears,
						String.valueOf(seasonRounds.rounds.get(i).round),
						(seasonRounds.rounds.get(i).slug == null) ? "" : "/slug/" + seasonRounds.rounds.get(i).slug);
			}
		}
	}

	/**
	 * 
	 * @param competitionName for example ( Premier League , LaLiga , Bundesliga ,
	 *                        Seria A .....)
	 * @param startYear       for example ( 2009/2010 , 2013/2014 , 2007/2008 ,
	 *                        2015/2016 , ......)
	 */
	public void writeCompetitionBasicInfoAndStatistics(String competitionName, String startYear) {

		List<SeasonIDObject> competitions = seasonId.getAllSeasonInfo(competitionName, startYear);
		for (int i = 0; i < competitions.size(); i++) {
			writeSeasonBasicInfoAndStatistics(competitions.get(i).competitionName, competitions.get(i).years);
		}

	}

	/**
	 * 
	 * @param competitionName for example ( Premier League , LaLiga , Bundesliga ,
	 *                        Seria A .....)
	 * @param startYears      for example ( 2009/2010 , 2013/2014 , 2007/2008 ,
	 *                        2015/2016 , ......)
	 * @param endYears
	 */
	public void writeCompetitionBasicInfoAndStatistics(String competitionName, String startYear, String endYear) {

		List<SeasonIDObject> competitions = seasonId.getAllSeasonInfo(competitionName, startYear, endYear);
		for (int i = 0; i < competitions.size(); i++) {
			writeSeasonBasicInfoAndStatistics(competitions.get(i).competitionName, competitions.get(i).years);
		}

	}

	/**
	 * 
	 * these seasons do not contain any information about rounds , just the last
	 * ranking table and the last round's games(just result) like this game
	 * https://www.sofascore.com/as-monaco-paris-saint-germain/UHsdI
	 */
	private PageOfSeasonRounds getSeasonRoundsIfNotFoundInSite(String competitionName, String competitionYears) {
		PageOfSeasonRounds result = new PageOfSeasonRounds();
		if (result.currentRound == null) {
			result.currentRound = new CurrentRound();
		}
		result.currentRound.name = "Not Found";
		if (competitionName.equals("Ligue 1") && competitionYears.equals("1997/1998")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Ligue 1") && competitionYears.equals("1998/1999")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Ligue 1") && competitionYears.equals("1999/2000")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Ligue 1") && competitionYears.equals("2000/2001")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Ligue 1") && competitionYears.equals("2001/2002")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Ligue 1") && competitionYears.equals("2002/2003")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("Ligue 1") && competitionYears.equals("2003/2004")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("Serie A") && competitionYears.equals("1997/1998")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Serie A") && competitionYears.equals("1998/1999")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Serie A") && competitionYears.equals("1999/2000")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Serie A") && competitionYears.equals("2000/2001")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Serie A") && competitionYears.equals("2001/2002")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Serie A") && competitionYears.equals("2002/2003")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Bundesliga") && competitionYears.equals("1997/1998")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Bundesliga") && competitionYears.equals("1998/1999")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Bundesliga") && competitionYears.equals("1999/2000")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Bundesliga") && competitionYears.equals("2000/2001")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Bundesliga") && competitionYears.equals("2001/2002")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("Bundesliga") && competitionYears.equals("2002/2003")) {
			result.currentRound.round = 34;
			return result;
		}
		if (competitionName.equals("LaLiga") && competitionYears.equals("1993/1994")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("LaLiga") && competitionYears.equals("1994/1995")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("LaLiga") && competitionYears.equals("1995/1996")) {
			result.currentRound.round = 42;
			return result;
		}
		if (competitionName.equals("LaLiga") && competitionYears.equals("1996/1997")) {
			result.currentRound.round = 42;
			return result;
		}
		if (competitionName.equals("LaLiga") && competitionYears.equals("1997/1998")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("LaLiga") && competitionYears.equals("1998/1999")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("LaLiga") && competitionYears.equals("1999/2000")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("LaLiga") && competitionYears.equals("2000/2001")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("LaLiga") && competitionYears.equals("2001/2002")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("LaLiga") && competitionYears.equals("2002/2003")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("Premier League") && competitionYears.equals("1993/1994")) {
			result.currentRound.round = 42;
			return result;
		}
		if (competitionName.equals("Premier League") && competitionYears.equals("1994/1995")) {
			result.currentRound.round = 42;
			return result;
		}
		if (competitionName.equals("Premier League") && competitionYears.equals("1995/1996")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("Premier League") && competitionYears.equals("1996/1997")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("Premier League") && competitionYears.equals("1997/1998")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("Premier League") && competitionYears.equals("1998/1999")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("Premier League") && competitionYears.equals("1999/2000")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("Premier League") && competitionYears.equals("2000/2001")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("Premier League") && competitionYears.equals("2001/2002")) {
			result.currentRound.round = 38;
			return result;
		}
		if (competitionName.equals("Premier League") && competitionYears.equals("2002/2003")) {
			result.currentRound.round = 38;
			return result;
		}

		else {
			throw new RuntimeException(
					"we do not know how many rounds are in " + competitionName + "  at  " + competitionYears);
		}
	}

}
