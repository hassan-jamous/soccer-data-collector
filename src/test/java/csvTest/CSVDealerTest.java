package csvTest;

import csvFile.CSVDealer;
import sofaScore.RoundCollector;

import org.junit.Test;

public class CSVDealerTest {

	RoundCollector roundCollector = new RoundCollector();
	CSVDealer csvDealer = new CSVDealer();
	
	@Test
	public void itShouldWrite() {
	
		roundCollector.writeRound("Premier League", "19/20", "1");
	}
}
