package sofaScore;

import com.google.gson.Gson;
import csvFile.CSVFilesDealer;
import csvFile.FileTypes;
import csvFile.CSVDealerForGetInforamtion;
import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.gameStatistics.GameStatistics;
import sofaScore.models.utilities.HashMapLeaguesID;
import sofaScore.models.utilities.HashMapSeasonsID;
import util.HttpUtil;
import util.Sites;

public class RoundCollector {

	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID();
	private final HttpUtil httpUtil = new HttpUtil();
	GameCollector gameCollector = new GameCollector();
	CSVDealerForGetInforamtion csvGetterString = new CSVDealerForGetInforamtion();
	CSVFilesDealer csvDealer = new CSVFilesDealer();
	private final String API_SOFA_SCORE_ROUND_URL = "https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/events/round/%s%s";

	/***
	 * @param competitionName  for example ( Premier League , LaLiga , Bundesliga ,
	 *                         .....)
	 * @param competitionYears for example (2020/2021 , 2009/2021 , ....)
	 * @param round            for example 1 , 4 , 10 , 20 , .......
	 * @param stringToAddToURL if normal round this will be empty string or equals
	 *                         to /slug/final or /slug/qualification-round-2
	 *                         according to round's kind French league 2017/2018
	 *                         
	 *                         from this url
	 *                         https://api.sofascore.com/api/v1/unique-tournament/Competition's
	 *                         ID/season/Season's ID/events/round/ Round Number we
	 *                         extract games' ids for the round competition's id =
	 *                         17 English Premier League season's id = 23776 for
	 *                         season 2019/2020 round's number =3 the third round in
	 *                         league
	 * 
	 * @return arraylist of game' id
	 */

	public RoundGamesID getGamesIdInRound(String competitionName, String competitionYears, String round,
			String stringToAddToURL) {

		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_ROUND_URL, leagueId.getLeagueID(competitionName),
						seasonId.getSeasonID(competitionName, competitionYears), round, stringToAddToURL));
		if (gsonString.contains("Not Found")) {
			return null;
		}
		Gson gson = new Gson();
		RoundGamesID gamesId = gson.fromJson(gsonString, RoundGamesID.class);
		return gamesId;
	}

	/**
	 * @param competitionName  for example ( Premier League , LaLiga , Bundesliga ,
	 *                         .....)
	 * @param competitionYears for example (2020/2021 , 2009/2021 , ....)
	 * @param round            for example 1 , 4 , 10 , 20 , .......
	 * @param stringToAddToURL if normal round this will be empty string or equals
	 *                         to /slug/final or /slug/qualification-round-2
	 *                         according to round's kind
	 * 
	 *                         write round's games (game basic information and game
	 *                         statistics) into file
	 */
	public void writeRound(String competitionName, String competitionYears, String round, String stringToAddToURL) {

		RoundGamesID gamesIdInRound = getGamesIdInRound(competitionName, competitionYears, round, stringToAddToURL);
		if ((gamesIdInRound == null) || (gamesIdInRound.events == null) || (gamesIdInRound.events.isEmpty())) {
			csvDealer.writeInFileWithHeader(Sites.SofaScore_Com, competitionName,"no information about this season " + competitionYears + " at round " + round, true,
					FileTypes.NoInformation);
		} else {
			for (int i = 0; i < gamesIdInRound.events.size(); i++) {
				GameStatistics gameStatistic = gameCollector.getGameStatistics(gamesIdInRound.events.get(i).id);
				GameBasicInformation gameBasicInfromation = gameCollector
						.getGameBasicInformation(gamesIdInRound.events.get(i).id);
				// we must know all values gameBasicInfromation.event.status.type and gameBasicInfromation.event.status.description
				if ((gameBasicInfromation.event.status.description.equals("Ended")
						|| gameBasicInfromation.event.status.description.equals("Removed")
						|| (gameBasicInfromation.event.status.description.equals("AP")))
						&& gameBasicInfromation.event.status.type.equals("finished")) {
					if ((i == 0) && (Integer.valueOf(round) == 1)) {
						csvDealer.writeInFileWithHeader(Sites.SofaScore_Com, competitionName,csvGetterString.getHeaderStringForCSV(gameBasicInfromation)+","+csvGetterString.getHeaderStringForCSV(gameStatistic),true, FileTypes.Statistics);
					}
					csvDealer.writeInFileWithHeader(Sites.SofaScore_Com, competitionName,csvGetterString.getValuesStringForCSV(gameBasicInfromation)+","+csvGetterString.getValuesStringForCSV(gameStatistic),false, FileTypes.Statistics);
					//to ask hassan now all types except (finished) are equal i asked about canceled what about other
				} else if (gameBasicInfromation.event.status.type.equals("inprogress")) {
				} else if (gameBasicInfromation.event.status.description.equals("Not started")
						&& gameBasicInfromation.event.status.type.equals("notstarted")) {
					if ((i == 0) && (Integer.valueOf(round) == 1)) {
						csvDealer.writeInFileWithHeader(Sites.SofaScore_Com, competitionName,csvGetterString.getHeaderStringForCSV(gameBasicInfromation)+","+ csvGetterString.getHeaderStringForCSV(gameStatistic),true, FileTypes.Statistics);
					}
				} else {// if the match has been canceled
					if ((i == 0) && (Integer.valueOf(round) == 1)) {
						csvDealer.writeInFileWithHeader(Sites.SofaScore_Com, competitionName,csvGetterString.getHeaderStringForCSV(gameBasicInfromation)+","+ csvGetterString.getHeaderStringForCSV(gameStatistic),true, FileTypes.Statistics);
					}
				}
			}
		}
	}
}
