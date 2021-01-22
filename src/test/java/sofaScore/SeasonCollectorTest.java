package sofaScore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import sofaScore.models.season.RoundInfo;
import sofaScore.models.season.Season;

public class SeasonCollectorTest {
    
	SeasonCollector seasonCollectorTest = new SeasonCollector();
	
	@Test
	public void itShouldGetCurrentRound() {
       int currentRound20_21  = seasonCollectorTest.getCurrentRound("Premier League", "20/21");
       assertThat(currentRound20_21).isEqualTo(18);
	}
	
	@Test 
	public void itShouldWriteSeason() {
			
		//seasonCollectorTest.writeSeason("Premier League", "20/21");
		seasonCollectorTest.writeSeason("Premier League", "19/20");
		//seasonCollectorTest.writeSeason("Premier League", "18/19");
		//seasonCollectorTest.writeSeason("Premier League", "17/18");
		//seasonCollectorTest.writeSeason("Premier League", "16/17");
		//seasonCollectorTest.writeSeason("Premier League", "15/16");
		//seasonCollectorTest.writeSeason("Premier League", "14/15");
		//seasonCollectorTest.writeSeason("Premier League", "13/14");
		//seasonCollectorTest.writeSeason("Premier League", "12/13");
		//seasonCollectorTest.writeSeason("Premier League", "11/12");
		//seasonCollectorTest.writeSeason("Premier League", "10/11");
		seasonCollectorTest.writeSeason("Premier League", "09/10");
		
	}
	
	@Test
    public void itShouldGetInformationAboutSeason() {
        
        Season  season20_21 = seasonCollectorTest.getAllRoundsInformationInSeason("Premier League", "20/21");
        RoundInfo round1At20_21 = new RoundInfo("1","1:1",4264,1600159517);
        assertThat(season20_21.rounds.get(0)).usingRecursiveComparison().isEqualTo(round1At20_21);
        assertThat(season20_21.rounds.size()).isEqualTo(19);//at 16/01/2021
        
        Season  season19_20 = seasonCollectorTest.getAllRoundsInformationInSeason("Premier League", "19/20");
        assertThat(season19_20.rounds.size()).isEqualTo(38);
        
	}

	@Test 
	public void itShouldGetSeasonStatistic() {

	}
	
}
