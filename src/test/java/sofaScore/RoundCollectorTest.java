package sofaScore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

import sofaScore.models.RoundInformation.GameID;
import sofaScore.models.RoundInformation.RoundGamesID;
import sofaScore.models.season.RoundInfo;
import sofaScore.models.season.Season;
import sofaScore.testData.GamesIdInRoundValues;
import testUtilities.AssertUtilities;

public class RoundCollectorTest {

    AssertUtilities assertObjectArrayToArray = new AssertUtilities();
	GamesIdInRoundValues gameIDInRoundSofaScoreValues = new sofaScore.testData.GamesIdInRoundValues();

	
	@Test
    public void itShouldgetGamesIDInRound() {
        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();

        RoundGamesID gamesIdActualValueEnglishPreimerLeague19_20Round3 = sofaScoreCollectorTest.getGamesIdInRound("Premier League", "19/20", "3");
        List<GameID> gamesIdExpectedValueEnglishPreimerLeague19_20Round3 = gameIDInRoundSofaScoreValues.getEnglishPreimerLeague19_20Round3();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(gamesIdActualValueEnglishPreimerLeague19_20Round3.events, null, gamesIdExpectedValueEnglishPreimerLeague19_20Round3);
       
        RoundGamesID gamesIdActualValueEnglishPreimerLeague18_19Round5 = sofaScoreCollectorTest.getGamesIdInRound("Premier League", "18/19", "5");
        List<GameID> gamesIdExpectedValueEnglishPreimerLeague18_19Round5 = gameIDInRoundSofaScoreValues.getEnglishPreimerLeague18_19Round5();
        assertObjectArrayToArray.assertArrayToArraySpecificIndexes(gamesIdActualValueEnglishPreimerLeague18_19Round5.events, null, gamesIdExpectedValueEnglishPreimerLeague18_19Round5);

    }
	
	@Test
    public void itShouldgetAllRoundsInformationInSeason() {
        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
        
        Season  season20_21 = sofaScoreCollectorTest.getAllRoundsInformationInSeason("Premier League", "20/21");
        RoundInfo round1At20_21 = new RoundInfo("1","1:1",4264,1600159517);
        assertThat(season20_21.rounds.get(0)).usingRecursiveComparison().isEqualTo(round1At20_21);
        assertThat(season20_21.rounds.size()).isEqualTo(18);//at 16/01/2021
        
        Season  season19_20 = sofaScoreCollectorTest.getAllRoundsInformationInSeason("Premier League", "19/20");
        assertThat(season19_20.rounds.size()).isEqualTo(38);

        
	}
	
}
