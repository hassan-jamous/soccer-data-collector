package csvTest;

import csvFile.CSVDealer;
import sofaScore.RoundCollector;
import sofaScore.SeasonCollector;

import org.junit.Test;

public class CSVDealerTest {
	SeasonCollector seasonCollector = new SeasonCollector();
	RoundCollector roundCollector = new RoundCollector();
	CSVDealer csvDealer = new CSVDealer();
	
	@Test
	public void itShouldWrite() {
	
		seasonCollector.writeSeason("Premier League", "19/20");
	}
}
