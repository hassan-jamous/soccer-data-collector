package testUtilities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class AssertUtilities {

	public void assertArrayToArraySpecificIndexes(ArrayList<?> actualValue, List<Integer> indexes, List<?> expectedValue) {
		String s1="playerIn.id";
		String s2="playerIn.userCount";
		String s3="playerOut.id";
		String s4="playerOut.userCount";
		String s5="player.id";
		String s6="player.userCount";
		String s7="assist1.id";
		String s8="assist1.userCount";
		if (expectedValue == null) {
            Assert.assertEquals(null, actualValue);
        } else {
            int limit = (indexes == null || indexes.isEmpty()) ? Math.max(actualValue.size(), expectedValue.size()) : indexes.size();
            int j = 0;
            while (j < limit) {
                int index = (indexes == null || indexes.isEmpty()) ? j : indexes.get(j);
                //assertThat(actualValue.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.get(j));
                assertThat(actualValue.get(index)).usingRecursiveComparison().ignoringFields(s1,s2,s3,s4,s5,s6,s7,s8).isEqualTo(expectedValue.get(j));
                j++;
            }
        }
    }
}
