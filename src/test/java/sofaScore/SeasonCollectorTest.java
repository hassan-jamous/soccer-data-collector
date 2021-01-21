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
	public void itShouldWriteSeasonStatistic() {
		seasonCollectorTest.writeSeason("Premier League", "19/20");

	}
	@Test
    public void itShouldgetAllRoundsInformationInSeason() {
        
        Season  season20_21 = seasonCollectorTest.getAllRoundsInformationInSeason("Premier League", "20/21");
        RoundInfo round1At20_21 = new RoundInfo("1","1:1",4264,1600159517);
        assertThat(season20_21.rounds.get(0)).usingRecursiveComparison().isEqualTo(round1At20_21);
        assertThat(season20_21.rounds.size()).isEqualTo(18);//at 16/01/2021
        
        Season  season19_20 = seasonCollectorTest.getAllRoundsInformationInSeason("Premier League", "19/20");
        assertThat(season19_20.rounds.size()).isEqualTo(38);

        
	}
	
	
	
}
