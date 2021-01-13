package worldfootball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import worldfootball.testData.SofaScoreGamesIdInRoundValues;
import sofaScore.SofaScoreCollector;
import sofaScore.models.GameID;
import sofaScore.models.RoundGamesID;

public class ZSofaScoreGamesInRoundTest {

	SofaScoreGamesIdInRoundValues gameIDInRoundSofaScoreValues = new worldfootball.testData.SofaScoreGamesIdInRoundValues();
	
	void assertSofaScoreGamesIdInRound(RoundGamesID actualValue, List<Integer> indexes, ArrayList<GameID> expectedValue, int expectedGamesNumberInRound) {

        int limit = (indexes == null || indexes.size() == 0) ? expectedGamesNumberInRound : indexes.size();
        int i = 0;
        while (i < limit) {
            int index = (indexes == null || indexes.size() == 0) ? i : indexes.get(i);
            assertThat(actualValue.events.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.get(i));
            i++;
        }
    }

    @Test
    public void itShouldgetGamesIDInRound() {
        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();

        RoundGamesID gamesIdActualValueEnglishPreimerLeague19_20Round3 = sofaScoreCollectorTest.getGamesIdInRound("Premier League", "19/20", "3");
        ArrayList<GameID> gamesIdExpectedValueEnglishPreimerLeague19_20Round3 = gameIDInRoundSofaScoreValues.getEnglishPreimerLeague19_20Round3();
        assertSofaScoreGamesIdInRound(gamesIdActualValueEnglishPreimerLeague19_20Round3, null, gamesIdExpectedValueEnglishPreimerLeague19_20Round3, 10);
        RoundGamesID gamesIdActualValueEnglishPreimerLeague18_19Round5 = sofaScoreCollectorTest.getGamesIdInRound("Premier League", "18/19", "5");
        ArrayList<GameID> gamesIdExpectedValueEnglishPreimerLeague18_19Round5 = gameIDInRoundSofaScoreValues.getEnglishPreimerLeague18_19Round5();
        assertSofaScoreGamesIdInRound(gamesIdActualValueEnglishPreimerLeague18_19Round5, null, gamesIdExpectedValueEnglishPreimerLeague18_19Round5, 10);

    }
}
