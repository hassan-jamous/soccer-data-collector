package sofaScore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;


public class SeasonCollectorTest {
    
	SeasonCollector seasonCollectorTest = new SeasonCollector();
	
	@Test
	public void itShouldGetCurrentRound() {
	   //https://api.sofascore.com/api/v1/unique-tournament/17/season/29415/rounds
       int currentRound20_21  = seasonCollectorTest.getCurrentRound("Premier League", "20/21");
       assertThat(currentRound20_21).isEqualTo(20);
	}
	
	@Test 
	public void itShouldWriteSeason() {
		//seasonCollectorTest.writeSeasonNew("Premier League", "20/21");
		seasonCollectorTest.writeSeason("Premier League", "19/20");
		seasonCollectorTest.writeSeason("Premier League", "18/19");
		//seasonCollectorTest.writeSeason("Premier League", "17/18");
		//seasonCollectorTest.writeSeason("Premier League", "16/17");
		//seasonCollectorTest.writeSeason("Premier League", "15/16");
		//seasonCollectorTest.writeSeason("Premier League", "14/15");
		//seasonCollectorTest.writeSeason("Premier League", "13/14");
		//seasonCollectorTest.writeSeason("Premier League", "12/13");
		//seasonCollectorTest.writeSeason("Premier League", "11/12");
		//seasonCollectorTest.writeSeason("Premier League", "10/11");
		//seasonCollectorTest.writeSeason("Premier League", "09/10");
		//seasonCollectorTest.writeSeason("La Liga", "20/21");
		//seasonCollectorTest.writeSeason("La Liga", "19/20");
		//seasonCollectorTest.writeSeason("La Liga", "18/19");
		//seasonCollectorTest.writeSeason("La Liga", "17/18");
		//seasonCollectorTest.writeSeason("La Liga", "16/17");
		//seasonCollectorTest.writeSeason("La Liga", "15/16");
		//seasonCollectorTest.writeSeason("La Liga", "14/15");
		//seasonCollectorTest.writeSeason("La Liga", "13/14");
		//seasonCollectorTest.writeSeason("La Liga", "12/13");
		//seasonCollectorTest.writeSeason("La Liga", "11/12");
		//seasonCollectorTest.writeSeason("La Liga", "10/11");
		//seasonCollectorTest.writeSeason("La Liga", "09/10");

	}

}
