package testUtilities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
//ShouldContainAtIndex.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

public class AssertUtilities {

	public void assertArrayToArraySpecificIndexes(ArrayList<?> actualValue, List<Integer> indexes, List<?> expectedValue) {
		if (expectedValue == null) {
            Assert.assertEquals(null, actualValue);
        } else {
            int limit = (indexes == null || indexes.isEmpty()) ? Math.max(actualValue.size(), expectedValue.size()) : indexes.size();
            int j = 0;
            while (j < limit) {
                int index = (indexes == null || indexes.isEmpty()) ? j : indexes.get(j);
                assertThat(actualValue.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.get(j));
                j++;
            }
        }
    }
}
