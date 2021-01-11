package collector;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import models.ClubTransferTable;
import testUtilities.WorldFootBallAttributeFor_TEST;
import testValues.WorldFootballTransferTableValues;

public class WorldFootballTransferTableTest {

	WorldFootballTransferTableValues tansferTableWorldFootballTransferTableValues = new WorldFootballTransferTableValues();
	
	public void assertClubTransfer(ClubTransferTable actualValue, List<WorldFootBallAttributeFor_TEST> tables, ClubTransferTable expectedValue) {
        assertThat(actualValue.clubBasicInfo).usingRecursiveComparison().isEqualTo(expectedValue.clubBasicInfo);
        assertThat(actualValue.season).isEqualTo(expectedValue.season);
        for (int i = 0; i < tables.size(); i++) {
            int limit;
            if (tables.get(i).attributeName.equals("in")) {
                if (expectedValue.intable == null) {
                    Assert.assertEquals(null, actualValue.intable);
                } else {
                    limit = (tables.get(i).indexes.isEmpty()) ? Math.max(actualValue.intable.size(), expectedValue.intable.size()) : tables.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (tables.get(i).indexes.isEmpty()) ? index = j : tables.get(i).indexes.get(j);
                        assertThat(actualValue.intable.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.intable.get(j));
                        j++;
                    }
                }
            } else {
                if (expectedValue.outtable == null) {
                    Assert.assertEquals(null, actualValue.outtable);
                } else {
                    limit = (tables.get(i).indexes.isEmpty()) ? Math.max(actualValue.outtable.size(), expectedValue.outtable.size()) : tables.get(i).indexes.size();
                    int j = 0;
                    while (j < limit) {
                        int index = (tables.get(i).indexes.isEmpty()) ? index = j : tables.get(i).indexes.get(j);
                        assertThat(actualValue.outtable.get(index)).usingRecursiveComparison().isEqualTo(expectedValue.outtable.get(j));
                        j++;
                    }
                }
            }
        }
    }

    @Test
    public void itShouldGetTransferTable() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<ClubTransferTable> transferTableActualValue2015_2016 = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier-league", "2015-2016");
        ClubTransferTable astonVillaTransferTable2015_2016ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTableActualValue2015_2016, "Aston Villa");
        ClubTransferTable AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForAstonVilla2015_2016();
        List<WorldFootBallAttributeFor_TEST> astonVilla2015_2016AtrribuTests = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("in", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4))),
                new WorldFootBallAttributeFor_TEST("out", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4)))));
        assertClubTransfer(astonVillaTransferTable2015_2016ActualValue, astonVilla2015_2016AtrribuTests, AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue);

        ArrayList<ClubTransferTable> transferTable1889_1890ActualValue = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier-league", "1889-1890");
        ClubTransferTable astonVillaTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Aston Villa");
        ClubTransferTable astonVillatransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForAstonVilla1889_1890();
        List<WorldFootBallAttributeFor_TEST> astonVilla1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("in", new ArrayList<Integer>(Arrays.asList())),
                new WorldFootBallAttributeFor_TEST("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(astonVillaTransferTable1889_1890ActualValue, astonVilla1889_1890AtrribuTests, astonVillatransferTable1889_1890ExpectedValue);

        ClubTransferTable accringtonFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Accrington FC");
        ClubTransferTable accringtonFCtransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForAccringtonFC1889_1890();
        List<WorldFootBallAttributeFor_TEST> accrington1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("in", new ArrayList<Integer>(Arrays.asList())),
                new WorldFootBallAttributeFor_TEST("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(accringtonFCTransferTable1889_1890ActualValue, accrington1889_1890AtrribuTests, accringtonFCtransferTable1889_1890ExpectedValue);

        ClubTransferTable derbyCountyTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Derby County");
        ClubTransferTable derbyCountytransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForDerbyCounty1889_1890();
        List<WorldFootBallAttributeFor_TEST> derbyCounty1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("in", new ArrayList<Integer>(Arrays.asList())),
                new WorldFootBallAttributeFor_TEST("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(derbyCountyTransferTable1889_1890ActualValue, derbyCounty1889_1890AtrribuTests, derbyCountytransferTable1889_1890ExpectedValue);

        ClubTransferTable burnleyFCTransferTable1889_1890ActualValue = new ClubTransferTable();
        burnleyFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Burnley FC");
        ClubTransferTable burnleyFCtransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForburnleyFCTransferTable1889_1890();
        List<WorldFootBallAttributeFor_TEST> burnleyFC1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new WorldFootBallAttributeFor_TEST("in", new ArrayList<Integer>(Arrays.asList())),
                new WorldFootBallAttributeFor_TEST("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(burnleyFCTransferTable1889_1890ActualValue, burnleyFC1889_1890AtrribuTests, burnleyFCtransferTable1889_1890ExpectedValue);

    }

}
