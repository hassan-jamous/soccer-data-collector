package worldfootball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import worldfootball.testData.TransferTableValues;
import worldfootball.models.ClubTransferTable;
import testUtilities.ArrayAttributeWithIndexes;
import testUtilities.AssertUtilities;

public class TransferCollectorTest {
	
	TransferTableValues tansferTableWorldFootballTransferTableValues = new TransferTableValues();
    AssertUtilities assertObjectArrayToArray = new AssertUtilities();

	public void assertClubTransfer(ClubTransferTable actualValue, List<ArrayAttributeWithIndexes> tables, ClubTransferTable expectedValue) {
        assertThat(actualValue.clubBasicInfo).usingRecursiveComparison().isEqualTo(expectedValue.clubBasicInfo);
        assertThat(actualValue.season).isEqualTo(expectedValue.season);
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).attributeName.equals("in")) {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.intable, tables.get(i).indexes, expectedValue.intable);
            } 
            else {
            	assertObjectArrayToArray.assertArrayToArraySpecificIndexes(actualValue.outtable, tables.get(i).indexes, expectedValue.outtable);
            }
        }
    }

    @Test
    public void itShouldGetTransferTable() {

        ScreenScraper screenScraperUnderTest = new ScreenScraper();

        ArrayList<ClubTransferTable> transferTableActualValue2015_2016 = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier-league", "2015-2016");
        ClubTransferTable astonVillaTransferTable2015_2016ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTableActualValue2015_2016, "Aston Villa");
        ClubTransferTable AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForAstonVilla2015_2016();
        List<ArrayAttributeWithIndexes> astonVilla2015_2016AtrribuTests = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("in", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4))),
                new ArrayAttributeWithIndexes("out", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4)))));
        assertClubTransfer(astonVillaTransferTable2015_2016ActualValue, astonVilla2015_2016AtrribuTests, AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue);

        ArrayList<ClubTransferTable> transferTable1889_1890ActualValue = screenScraperUnderTest.getClubsTransferTableAtSeason("eng-premier-league", "1889-1890");
        ClubTransferTable astonVillaTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Aston Villa");
        ClubTransferTable astonVillatransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForAstonVilla1889_1890();
        List<ArrayAttributeWithIndexes> astonVilla1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("in", new ArrayList<Integer>(Arrays.asList())),
                new ArrayAttributeWithIndexes("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(astonVillaTransferTable1889_1890ActualValue, astonVilla1889_1890AtrribuTests, astonVillatransferTable1889_1890ExpectedValue);

        ClubTransferTable accringtonFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Accrington FC");
        ClubTransferTable accringtonFCtransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForAccringtonFC1889_1890();
        List<ArrayAttributeWithIndexes> accrington1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("in", new ArrayList<Integer>(Arrays.asList())),
                new ArrayAttributeWithIndexes("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(accringtonFCTransferTable1889_1890ActualValue, accrington1889_1890AtrribuTests, accringtonFCtransferTable1889_1890ExpectedValue);

        ClubTransferTable derbyCountyTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Derby County");
        ClubTransferTable derbyCountytransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForDerbyCounty1889_1890();
        List<ArrayAttributeWithIndexes> derbyCounty1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("in", new ArrayList<Integer>(Arrays.asList())),
                new ArrayAttributeWithIndexes("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(derbyCountyTransferTable1889_1890ActualValue, derbyCounty1889_1890AtrribuTests, derbyCountytransferTable1889_1890ExpectedValue);

        ClubTransferTable burnleyFCTransferTable1889_1890ActualValue = new ClubTransferTable();
        burnleyFCTransferTable1889_1890ActualValue = screenScraperUnderTest.transferCollector.getTransferTableByClubName(transferTable1889_1890ActualValue, "Burnley FC");
        ClubTransferTable burnleyFCtransferTable1889_1890ExpectedValue = tansferTableWorldFootballTransferTableValues.getTransferTableForburnleyFCTransferTable1889_1890();
        List<ArrayAttributeWithIndexes> burnleyFC1889_1890AtrribuTests = new ArrayList<>(Arrays.asList(
                new ArrayAttributeWithIndexes("in", new ArrayList<Integer>(Arrays.asList())),
                new ArrayAttributeWithIndexes("out", new ArrayList<Integer>(Arrays.asList()))));
        assertClubTransfer(burnleyFCTransferTable1889_1890ActualValue, burnleyFC1889_1890AtrribuTests, burnleyFCtransferTable1889_1890ExpectedValue);

    }
}