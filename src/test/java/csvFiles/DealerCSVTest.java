package csvFiles;

import org.junit.Test;

import sofaScore.SofaScoreCollector;

public class DealerCSVTest {
	SofaScoreCollector sofaScoreColletor = new SofaScoreCollector();
	DealerCSV csvDealer = new DealerCSV();
	@Test
	public void itShouldWriteCSVFiles() {
		sofaScoreColletor.writePlayedGamesInRoundInCSVFiles("Premier League", "20/21", 17);	
	}
	
	@Test 
	public void itShouldReadCSVFilles() {}

}
