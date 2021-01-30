package sofaScore;



import java.util.List;

import com.google.gson.Gson;
import csvFile.CSVDealer;
import sofaScore.models.season.CurrentRound;
import sofaScore.models.season.PageRoundsSeasonInfo;
import sofaScore.models.utilities.HashMapLeaguesID;
import sofaScore.models.utilities.HashMapSeasonsID;
import sofaScore.models.utilities.SeasonIDObject;
import util.HttpUtil;

public class SeasonCollector {
	
	private final HttpUtil httpUtil = new HttpUtil();
	private final String API_SOFA_SCORE_CURRENT_ROUND_URL = "https://api.sofascore.com/api/v1/unique-tournament/%s/season/%s/rounds";
	private final HashMapSeasonsID seasonId = new HashMapSeasonsID();
	private final HashMapLeaguesID leagueId = new HashMapLeaguesID(); 
	RoundCollector roundCollerctor = new RoundCollector();
	GameCollector gameCollector = new GameCollector();
	CSVDealer csvDealer = new CSVDealer();

	/**
	 * 
	 * @param competitionName for example ( Premier League , La Liga  , Bundesliga , Seria A .....)
	 * @param competitionYears  for example (2020/2021 , 2009/2021 , 1999/1998 , ....)
	 * @return
	 */
	public int getCurrentRound(String competitionName , String competitionYears) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_CURRENT_ROUND_URL,leagueId.getLeagueID(competitionName), seasonId.getSeasonID(competitionName , competitionYears)));
		if(gsonString.contains("Not Found")) {return getCurrentRoundIfNotFoundInSite(competitionName,competitionYears);}
		Gson gson = new Gson();
		PageRoundsSeasonInfo currentRoundInfo = gson.fromJson(gsonString, PageRoundsSeasonInfo.class);
		return currentRoundInfo.currentRound.round;
	}
	
	/**
	 * 
	 * @param competitionName for example ( Premier League , La Liga  , Bundesliga , Seria A .....)
	 * @param competitionYears  for example (2020/2021 , 2009/2021 , 1999/1998 , ....)
	 * @return
	 */
	public PageRoundsSeasonInfo getCurrentRound222(String competitionName , String competitionYears) {
		
		String gsonString = httpUtil.sendGetHttpRequest(String.format(API_SOFA_SCORE_CURRENT_ROUND_URL,leagueId.getLeagueID(competitionName), seasonId.getSeasonID(competitionName , competitionYears)));
		if(gsonString.contains("Not Found")) {return getCurrentRoundIfNotFoundInSite222(competitionName,competitionYears);}
		Gson gson = new Gson();
		PageRoundsSeasonInfo currentRoundInfo = gson.fromJson(gsonString, PageRoundsSeasonInfo.class);
		return currentRoundInfo;
	}
	
	public PageRoundsSeasonInfo getCurrentRoundIfNotFoundInSite222(String competitionName , String competitionYears) {
		PageRoundsSeasonInfo result = new PageRoundsSeasonInfo();
		if(result.currentRound == null) {result.currentRound = new CurrentRound() ;}
		result.currentRound.name ="Not Found";
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("1997/1998") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("1998/1999") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("1999/2000") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("2000/2001") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("2001/2002") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("2002/2003") ) {result.currentRound.round = 38;	return result;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("2003/2004") ) {result.currentRound.round = 38;	return result;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("1997/1998") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("1998/1999") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("1999/2000") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("2000/2001") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("2001/2002") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("2002/2003") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("1997/1998") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("1998/1999") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("1999/2000") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("2000/2001") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("2001/2002") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("2002/2003") ) {result.currentRound.round = 34;	return result;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1993/1994") ) {result.currentRound.round = 38;	return result;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1994/1995") ) {result.currentRound.round = 38;	return result;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1995/1996") ) {result.currentRound.round = 42;	return result;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1996/1997") ) {result.currentRound.round = 42;	return result;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1997/1998") ) {result.currentRound.round = 38;	return result;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1999/1999") ) {result.currentRound.round = 38;	return result;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1999/2000") ) {result.currentRound.round = 38;	return result;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("2000/2001") ) {result.currentRound.round = 38;	return result;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("2001/2002") ) {result.currentRound.round = 38;	return result;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("2002/2003") ) {result.currentRound.round = 38;	return result;}

		else {throw new RuntimeException("we do not know how many rounds are in "+competitionName+"  at  "+competitionYears);}
	}

	
	public int getCurrentRoundIfNotFoundInSite(String competitionName , String competitionYears) {
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("1997/1998") ) {return 34;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("1998/1999") ) {return 34;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("1999/2000") ) {return 34;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("2000/2001") ) {return 34;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("2001/2002") ) {return 34;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("2002/2003") ) {return 38;}
		if(competitionName.equals("Ligue 1") &&  competitionYears.equals("2003/2004") ) {return 38;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("1997/1998") ) {return 34;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("1998/1999") ) {return 34;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("1999/2000") ) {return 34;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("2000/2001") ) {return 34;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("2001/2002") ) {return 34;}
		if(competitionName.equals("Serie A") &&  competitionYears.equals("2002/2003") ) {return 34;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("1997/1998") ) {return 34;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("1998/1999") ) {return 34;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("1999/2000") ) {return 34;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("2000/2001") ) {return 34;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("2001/2002") ) {return 34;}
		if(competitionName.equals("Bundesliga") &&  competitionYears.equals("2002/2003") ) {return 34;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1993/1994") ) {return 38;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1994/1995") ) {return 38;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1995/1996") ) {return 42;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1996/1997") ) {return 42;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1997/1998") ) {return 38;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1999/1999") ) {return 38;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("1999/2000") ) {return 38;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("2000/2001") ) {return 38;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("2001/2002") ) {return 38;}
		if(competitionName.equals("LaLiga") &&  competitionYears.equals("2002/2003") ) {return 38;}

		else {throw new RuntimeException("we do not know how many rounds are in "+competitionName+"  at  "+competitionYears);}
	}

	/**
	 * 
	 * @param competitionName for example ( Premier League , LaLiga  , Bundesliga , Seria A .....)
	 * @param competitionYears  for example (2020/2021 , 2009/2021 , 1999/1998 , ....)
	 * 
	 */
	public void writeSeason(String competitionName, String competitionYears) {

		int limit = getCurrentRound(competitionName, competitionYears);
		for(int i =1 ; i <= limit ; i++) {
			roundCollerctor.writeRound(competitionName, competitionYears , String.valueOf(i));
		}
	}
	
	/**
	 * 
	 * @param competitionName for example ( Premier League , LaLiga  , Bundesliga , Seria A .....)
	 * @param competitionYears  for example (2020/2021 , 2009/2021 , 1999/1998 , ....)
	 * 
	 */
	public void writeSeason222(String competitionName, String competitionYears) {

		PageRoundsSeasonInfo seasonRounds = getCurrentRound222(competitionName, competitionYears);
		if((seasonRounds.currentRound.name == null) || (seasonRounds.currentRound.name=="Not Found")) {
			int limit = seasonRounds.currentRound.round;
			for(int i =1 ; i <= limit ; i++) {
				roundCollerctor.writeRound(competitionName, competitionYears , String.valueOf(i));
			}
		}
		else {
			for(int i=0; i <seasonRounds.rounds.size(); i++) {
				roundCollerctor.writeRound222(competitionName, competitionYears , String.valueOf( seasonRounds.rounds.get(i).round),(seasonRounds.rounds.get(i).slug==null)?"":"/slug/"+seasonRounds.rounds.get(i).slug);
			}
			
		}
	}
	
	/**
	 * 
	 * @param competitionName for example ( Premier League , LaLiga  , Bundesliga , Seria A .....)
	 * @param startYear for example ( 2009 , 2013 , 2007 , 2015 , ......)
	 */
	public void writeCompetition(String competitionName , String startYear) {

		List<SeasonIDObject> competitions = seasonId.getAllSeasonInfo(competitionName, startYear);
		for(int i =0 ; i <competitions.size(); i++) {
			writeSeason222(competitions.get(i).competitionName , competitions.get(i).years);
		}
		
	}
	/**
	 * 
	 * @param competitionName for example ( Premier League , LaLiga  , Bundesliga , Seria A .....)
	 * @param startYear for example ( 2009 , 2013 , 2007 , 2015 , ......)
	 */
	public void writeCompetition(String competitionName , String startYear , String endYear) {

		List<SeasonIDObject> competitions = seasonId.getAllSeasonInfo(competitionName, startYear , endYear);
		for(int i =0 ; i <competitions.size(); i++) {
			writeSeason222(competitions.get(i).competitionName , competitions.get(i).years);
		}
		
	}
	
}
