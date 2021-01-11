package collector;

import java.util.ArrayList;

import org.junit.Test;

import sofaScore.SofaScoreCollector;
import sofaScoreModels.GameIencidents;

public class SofaScoreGameIencidentsTest {

	@Test
    public void itShouldGetGameIencidentsSofaScore() {
        SofaScoreCollector sofaScoreCollectorTest = new SofaScoreCollector();
        ArrayList<GameIencidents> game1Atround3At19_20IencidentsActualValue = sofaScoreCollectorTest.getGameIencidents("Premier League", "19/20", "3", 0);

        System.out.println("##########################################################");
        System.out.println("##########################################################");
        System.out.println("\n  \n \n");
        for (int j = 0; j < game1Atround3At19_20IencidentsActualValue.size(); j++) {
            System.out.println(j + "    " + game1Atround3At19_20IencidentsActualValue.get(j));
        }
        System.out.println("size   " + game1Atround3At19_20IencidentsActualValue.size());
    }

}
