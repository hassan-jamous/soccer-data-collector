package sofaScore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class SeasonCollectorTest {
    
	SeasonCollector seasonCollectorTest = new SeasonCollector();
	
	@Test
	public void itShouldGetCurrentRound() {
	   // https://api.sofascore.com/api/v1/unique-tournament/17/season/29415/rounds
       //int currentRound20_21  = seasonCollectorTest.getCurrentRound("Premier League", "2020/2021");
       //assertThat(currentRound20_21).isEqualTo(20);
       
	}
	
	@Test
	public void itShouldWriteCompetition() {		

		//seasonCollectorTest.writeCompetition("Ligue 1", "1997/1998", "2004/2005");
		//seasonCollectorTest.writeCompetition("Ligue 1", "2005/2006", "2009/2010");
		//seasonCollectorTest.writeCompetition("Ligue 1", "2010/2011", "2015/2016");
		//seasonCollectorTest.writeCompetition("Ligue 1", "2016/2017", "2020/2021");

	}
	
	@Test 
	public void itShouldWriteSeason() {
		
		//seasonCollectorTest.writeSeason222("Ligue 1", "2017/2018");
	}

}
