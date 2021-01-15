package worldfootball.testData;

import java.util.ArrayList;
import java.util.Arrays;

import worldfootball.models.Club;
import worldfootball.models.ClubTransferTable;
import worldfootball.models.Player;
import worldfootball.models.TransferPlayerInformation;

public class TransferTableValues {

		public ClubTransferTable getTransferTableForAstonVilla2015_2016() {
			
			ClubTransferTable AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue = new ClubTransferTable();
	        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.clubBasicInfo = new Club("Aston Villa");
	        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.season = "2015-2016";
	        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.intable = new ArrayList<>(Arrays.asList(
	        		new TransferPlayerInformation("05/16", new Player("Lewis Kinsella"), "England", "DF", new Club("Kidderminster Harriers"), new Club( "Aston Villa")),
	        		new TransferPlayerInformation("01/16", new Player("Joe Cole"), "England", "MF", new Club("Coventry City"), new Club("Aston Villa")),
	        		new TransferPlayerInformation("01/16", new Player("Aly Cissokho"), "France", "DF", new Club("FC Porto"), new Club("Aston Villa")),
	        		new TransferPlayerInformation("01/16", new Player("Callum Robinson"), "Ireland", "MF", new Club("Bristol City"),new Club( "Aston Villa")),
	        		new TransferPlayerInformation("11/15", new Player("Bradley Watkins"), "England", "GK",new Club( "Wolverhampton Wanderers U21"), new Club("Aston Villa"))));
	        AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue.outtable = new ArrayList<>(Arrays.asList(
	        		new TransferPlayerInformation("03/16", new Player("Jerell Sellars"), "England", "MF", new Club("Aston Villa"), new Club("Wycombe Wanderers")),
	        		new TransferPlayerInformation("02/16", new Player("Lewis Kinsella"), "England", "DF", new Club("Aston Villa"), new Club("Kidderminster Harriers")),
	        		new TransferPlayerInformation("01/16", new Player("Philippe Senderos"), "Switzerland", "DF", new Club("Aston Villa"),new Club( "Grasshopper Club Zürich")),
	        		new TransferPlayerInformation("01/16", new Player("Ángel Crespo"), "Spain", "DF",new Club( "Aston Villa"), new Club("Rayo Vallecano")),
	        		new TransferPlayerInformation("01/16", new Player("Gary Gardner"), "England", "MF",new Club( "Aston Villa"), new Club("Nottingham Forest"))));
	        
	        return AstonVillatransferTable2015_2016_5IN5Out_ExpectedValue;
		}
		
		public ClubTransferTable getTransferTableForAstonVilla1889_1890() {
			ClubTransferTable astonVillatransferTable1889_1890ExpectedValue = new ClubTransferTable();
	        astonVillatransferTable1889_1890ExpectedValue.clubBasicInfo = new Club("Aston Villa");
	        astonVillatransferTable1889_1890ExpectedValue.season = "1889-1890";
	        astonVillatransferTable1889_1890ExpectedValue.intable = new ArrayList<>(Arrays.asList(
	        		new TransferPlayerInformation("07/89",new Player( "Albert Aldridge"), "England", "DF", new Club("Swifts FC"), new Club("Aston Villa")),
	            	new TransferPlayerInformation("07/89",new Player( "William Dickson"), "Scotland", "FW",new Club( "Sunderland AFC"), new Club("Aston Villa"))));
	        astonVillatransferTable1889_1890ExpectedValue.outtable = new ArrayList<>(Arrays.asList(
	        		new TransferPlayerInformation("06/89", new Player("Archie Goodall"), "Northern Ireland", "MF", new Club("Aston Villa"),new Club( "Derby County"))));
	        
	        return astonVillatransferTable1889_1890ExpectedValue;
		}
		public ClubTransferTable getTransferTableForAccringtonFC1889_1890() {
			ClubTransferTable accringtonFCtransferTable1889_1890ExpectedValue = new ClubTransferTable();
	        accringtonFCtransferTable1889_1890ExpectedValue.clubBasicInfo = new Club("Accrington FC");
	        accringtonFCtransferTable1889_1890ExpectedValue.season = "1889-1890";
	        accringtonFCtransferTable1889_1890ExpectedValue.outtable = new ArrayList<>(Arrays.asList(
	        		new TransferPlayerInformation("06/89", new Player("Joe Lofthouse"), "England", "FW", new Club("Accrington FC"), new Club("Blackburn Rovers"))));
	        accringtonFCtransferTable1889_1890ExpectedValue.intable = null;
	        return accringtonFCtransferTable1889_1890ExpectedValue;
		}
		public ClubTransferTable getTransferTableForDerbyCounty1889_1890() {
			 ClubTransferTable derbyCountytransferTable1889_1890ExpectedValue = new ClubTransferTable();
		        derbyCountytransferTable1889_1890ExpectedValue.clubBasicInfo = new Club("Derby County");
		        derbyCountytransferTable1889_1890ExpectedValue.season = "1889-1890";
		        derbyCountytransferTable1889_1890ExpectedValue.intable= new ArrayList<>(Arrays.asList(
		        		new TransferPlayerInformation("07/89", new Player("Charlie Bunyan"), "England", "GK", new Club("Hyde FC"),new Club( "Derby County")),
		        		new TransferPlayerInformation("07/89", new Player("Archie Goodall"), "Northern Ireland", "MF", new Club("Aston Villa"), new Club("Derby County")),
		        		new TransferPlayerInformation("07/89", new Player("John Goodall"), "England", "FW", new Club("Preston North End"), new Club("Derby County"))));
		        derbyCountytransferTable1889_1890ExpectedValue.outtable = null;
		        return derbyCountytransferTable1889_1890ExpectedValue;
		}

		public ClubTransferTable getTransferTableForburnleyFCTransferTable1889_1890() {
	        ClubTransferTable burnleyFCtransferTable1889_1890ExpectedValue = new ClubTransferTable();
	        burnleyFCtransferTable1889_1890ExpectedValue.clubBasicInfo = new Club("Burnley FC");
	        burnleyFCtransferTable1889_1890ExpectedValue.season = "1889-1890";
	        burnleyFCtransferTable1889_1890ExpectedValue.intable = null;
	        burnleyFCtransferTable1889_1890ExpectedValue.outtable = null;
	        return burnleyFCtransferTable1889_1890ExpectedValue;
			
		}


	}


