package worldfootball.testData;

import java.util.ArrayList;
import java.util.Arrays;
import worldfootball.models.ClubTransferTable;
import worldfootball.models.TransferPlayerInformation;

public class WorldFootballTransferTableValues {

		public ClubTransferTable getTransferTableForAstonVilla2015_2016() {
			
			ClubTransferTable AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue = new ClubTransferTable();
	        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.clubBasicInfo.name = "Aston Villa";
	        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.season = "2015-2016";
	        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable = new ArrayList<>(Arrays.asList(
	        		new TransferPlayerInformation("05/16", "Lewis Kinsella", "England", "DF", "Kidderminster Harriers", "Aston Villa"),
	        		new TransferPlayerInformation("01/16", "Joe Cole", "England", "MF", "Coventry City", "Aston Villa"),
	        		new TransferPlayerInformation("01/16", "Aly Cissokho", "France", "DF", "FC Porto", "Aston Villa"),
	        		new TransferPlayerInformation("01/16", "Callum Robinson", "Ireland", "MF", "Bristol City", "Aston Villa"),
	        		new TransferPlayerInformation("11/15", "Bradley Watkins", "England", "GK", "Wolverhampton Wanderers U21", "Aston Villa")));
	        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable = new ArrayList<>(Arrays.asList(
	        		new TransferPlayerInformation("03/16", "Jerell Sellars", "England", "MF", "Aston Villa", "Wycombe Wanderers"),
	        		new TransferPlayerInformation("02/16", "Lewis Kinsella", "England", "DF", "Aston Villa", "Kidderminster Harriers"),
	        		new TransferPlayerInformation("01/16", "Philippe Senderos", "Switzerland", "DF", "Aston Villa", "Grasshopper Club Zürich"),
	        		new TransferPlayerInformation("01/16", "Ángel Crespo", "Spain", "DF", "Aston Villa", "Rayo Vallecano"),
	        		new TransferPlayerInformation("01/16", "Gary Gardner", "England", "MF", "Aston Villa", "Nottingham Forest")));
	        
	        return AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue;
		}
		
		public ClubTransferTable getTransferTableForAstonVilla1889_1890() {
			ClubTransferTable astonVillatransferTable1889_1890ExpectedValue = new ClubTransferTable();
	        astonVillatransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Aston Villa";
	        astonVillatransferTable1889_1890ExpectedValue.season = "1889-1890";
	        astonVillatransferTable1889_1890ExpectedValue.intable = new ArrayList<>(Arrays.asList(
	        		new TransferPlayerInformation("07/89", "Albert Aldridge", "England", "DF", "Swifts FC", "Aston Villa"),
	            	new TransferPlayerInformation("07/89", "William Dickson", "Scotland", "FW", "Sunderland AFC", "Aston Villa")));
	        astonVillatransferTable1889_1890ExpectedValue.outtable = new ArrayList<>(Arrays.asList(
	        		new TransferPlayerInformation("06/89", "Archie Goodall", "Northern Ireland", "MF", "Aston Villa", "Derby County")));
	        
	        return astonVillatransferTable1889_1890ExpectedValue;
		}
		public ClubTransferTable getTransferTableForAccringtonFC1889_1890() {
			ClubTransferTable accringtonFCtransferTable1889_1890ExpectedValue = new ClubTransferTable();
	        accringtonFCtransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Accrington FC";
	        accringtonFCtransferTable1889_1890ExpectedValue.season = "1889-1890";
	        accringtonFCtransferTable1889_1890ExpectedValue.outtable = new ArrayList<>(Arrays.asList(
	        		new TransferPlayerInformation("06/89", "Joe Lofthouse", "England", "FW", "Accrington FC", "Blackburn Rovers")));
	        accringtonFCtransferTable1889_1890ExpectedValue.intable = null;
	        return accringtonFCtransferTable1889_1890ExpectedValue;
		}
		public ClubTransferTable getTransferTableForDerbyCounty1889_1890() {
			 ClubTransferTable derbyCountytransferTable1889_1890ExpectedValue = new ClubTransferTable();
		        derbyCountytransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Derby County";
		        derbyCountytransferTable1889_1890ExpectedValue.season = "1889-1890";
		        derbyCountytransferTable1889_1890ExpectedValue.intable= new ArrayList<>(Arrays.asList(
		        		new TransferPlayerInformation("07/89", "Charlie Bunyan", "England", "GK", "Hyde FC", "Derby County"),
		        		new TransferPlayerInformation("07/89", "Archie Goodall", "Northern Ireland", "MF", "Aston Villa", "Derby County"),
		        		new TransferPlayerInformation("07/89", "John Goodall", "England", "FW", "Preston North End", "Derby County")));
		        derbyCountytransferTable1889_1890ExpectedValue.outtable = null;
		        return derbyCountytransferTable1889_1890ExpectedValue;
		}

		public ClubTransferTable getTransferTableForburnleyFCTransferTable1889_1890() {
	        ClubTransferTable burnleyFCtransferTable1889_1890ExpectedValue = new ClubTransferTable();
	        burnleyFCtransferTable1889_1890ExpectedValue.clubBasicInfo.name = "Burnley FC";
	        burnleyFCtransferTable1889_1890ExpectedValue.season = "1889-1890";
	        burnleyFCtransferTable1889_1890ExpectedValue.intable = null;
	        burnleyFCtransferTable1889_1890ExpectedValue.outtable = null;
	        return burnleyFCtransferTable1889_1890ExpectedValue;
			
		}


	}


