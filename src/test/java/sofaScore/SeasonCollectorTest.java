package sofaScore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SeasonCollectorTest {
    SeasonCollector seasonCollectorTest = new SeasonCollector();
		
	@Test
	public void itShouldGetCurrentRound() {
       int currentRound20_21  = seasonCollectorTest.getCurrentRound("Premier League", "20/21");
        assertThat(currentRound20_21).isEqualTo(18);
	}
	
}
