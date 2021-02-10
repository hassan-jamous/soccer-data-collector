package sofaScore;

import org.junit.Test;

public class SeasonCollectorTest {
    
	SeasonCollector seasonCollectorTest = new SeasonCollector();
		
	@Test
	public void itShouldWriteCompetition() {
		
		//seasonCollectorTest.writeCompetition("Premier League", "2005/2006", "2008/2009");
		//seasonCollectorTest.writeCompetition("Premier League", "2009/2010", "2012/2013");
		//seasonCollectorTest.writeCompetition("Premier League", "2013/2014", "2015/2016");
		seasonCollectorTest.writeCompetition("Premier League", "2016/2017", "2018/2019");
		//seasonCollectorTest.writeCompetition("Premier League", "2019/2020", "2020/2021");

		//seasonCollectorTest.writeCompetition("LaLiga", "2009/2010", "2012/2013");
		//seasonCollectorTest.writeCompetition("LaLiga", "2013/2014", "2015/2016");
		//seasonCollectorTest.writeCompetition("LaLiga", "2016/2017", "2018/2019");
		//seasonCollectorTest.writeCompetition("LaLiga", "2019/2020", "2020/2021");
		
		//seasonCollectorTest.writeCompetition("Bundesliga", "2009/2010", "2012/2013");
		//seasonCollectorTest.writeCompetition("Bundesliga", "2013/2014", "2015/2016");
		//seasonCollectorTest.writeCompetition("Bundesliga", "2016/2017", "2018/2019");
		//seasonCollectorTest.writeCompetition("Bundesliga", "2019/2020", "2020/2021");

		//seasonCollectorTest.writeCompetition("Serie A", "2009/2010", "2012/2013");
		//seasonCollectorTest.writeCompetition("Serie A", "2013/2014", "2015/2016");
		//seasonCollectorTest.writeCompetition("Serie A", "2016/2017", "2018/2019");
		//seasonCollectorTest.writeCompetition("Serie A", "2019/2020", "2020/2021");
		
		//seasonCollectorTest.writeCompetition("Ligue 1", "2009/2010", "2012/2013");
		//seasonCollectorTest.writeCompetition("Ligue 1", "2013/2014", "2015/2016");
		//seasonCollectorTest.writeCompetition("Ligue 1", "2016/2017", "2018/2019");
		//seasonCollectorTest.writeCompetition("Ligue 1", "2019/2020", "2020/2021");
	}
	
	@Test
	public void itShouldWriteSeason() {
		
		//seasonCollectorTest.roundCollerctor.writeRound("Premier League", "2019/2020", "1", "");
		//seasonCollectorTest.writeSeason("Premier League", "2019/2020");
	}	
}
