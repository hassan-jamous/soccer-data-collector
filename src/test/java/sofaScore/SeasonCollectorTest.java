package sofaScore;

import org.junit.Test;

import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.models.season.PageOfSeasonRounds;


public class SeasonCollectorTest {

	SeasonCollector seasonCollectorTest = new SeasonCollector();
		
	@Test
	public void itShouldWriteCompetition() {
		
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Premier League", "2005/2006", "2006/2007");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Premier League", "2007/2008", "2008/2009");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Premier League", "2009/2010", "2010/2011");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Premier League", "2011/2012", "2012/2013");
		//remember season 13/14 round 11 there are 9 games not 10 the site missed game aston villa vs cardiff
		//but this league has statistic ??????
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Premier League", "2013/2014", "2014/2015");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Premier League", "2015/2016", "2016/2017");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Premier League", "2017/2018", "2018/2019");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Premier League", "2019/2020", "2020/2021");

		
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("LaLiga", "2005/2006", "2006/2007");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("LaLiga", "2007/2008", "2008/2009");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("LaLiga", "2009/2010", "2010/2011");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("LaLiga", "2011/2012", "2012/2013");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("LaLiga", "2013/2014", "2014/2015");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("LaLiga", "2015/2016", "2016/2017");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("LaLiga", "2017/2018", "2018/2019");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("LaLiga", "2019/2020", "2020/2021");
	
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Bundesliga", "2005/2006", "2006/2007");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Bundesliga", "2007/2008", "2008/2009");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Bundesliga", "2009/2010", "2010/2011");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Bundesliga", "2011/2012", "2012/2013");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Bundesliga", "2013/2014", "2014/2015");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Bundesliga", "2015/2016", "2016/2017");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Bundesliga", "2017/2018", "2018/2019");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Bundesliga", "2019/2020", "2020/2021");

		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Serie A", "2005/2006", "2006/2007");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Serie A", "2007/2008", "2008/2009");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Serie A", "2009/2010", "2010/2011");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Serie A", "2011/2012", "2012/2013");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Serie A", "2013/2014", "2014/2015");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Serie A", "2015/2016", "2016/2017");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Serie A", "2017/2018", "2018/2019");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Serie A", "2019/2020", "2020/2021");
		
		//seasonCollectorTest.writeSeasonBasicInfoAndStatistics("Premier League", "2020/2021");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Ligue 1", "2005/2006", "2006/2007");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Ligue 1", "2007/2008", "2008/2009");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Ligue 1", "2009/2010", "2010/2011");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Ligue 1", "2011/2012", "2012/2013");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Ligue 1", "2013/2014", "2014/2015");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Ligue 1", "2015/2016", "2016/2017");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Ligue 1", "2017/2018", "2018/2019");
		//seasonCollectorTest.writeCompetitionBasicInfoAndStatistics("Ligue 1", "2019/2020", "2020/2021");
		
	}
/*	
	@Test
	public void itShouldGetSeasonRounds() {
		
		PageOfSeasonRounds seasonRounds =seasonCollectorTest.getSeasonRounds("Bundesliga", "2014/2015");
		for(int i =0 ; i < seasonRounds.rounds.size(); i++) {
			
			if(seasonRounds.rounds.get(i).slug != null) {
				RoundGamesID gamesIDS = seasonCollectorTest.roundCollerctor.getGamesIdInRound("Bundesliga", "2014/2015", String.valueOf(seasonRounds.rounds.get(i).round), (seasonRounds.rounds.get(i).slug == null) ? "" : "/slug/" + seasonRounds.rounds.get(i).slug);
				System.out.println(gamesIDS);
			}
		}
		seasonCollectorTest.writeSeasonBasicInfoAndStatistics("Bundesliga", "2014/2015");
	}	
	
	*/
	@Test
	public void itShouldWriteSeasonPlayerRating() {
		
		// start rating at season Premier League "2014/2015"
		seasonCollectorTest.writeSeasonPlayers("Premier League", "2020/2021");
	}	
	@Test
	public void itShouldWriteSeasonIncidents() {
		// start rating at season Premier League "2012/2013"
		//seasonCollectorTest.writeSeasonIncidents("Premier League", "2020/2021");
	}	
}
