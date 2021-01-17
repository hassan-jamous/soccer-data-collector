package csvFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class DealerCSV {

	//we can use enum for sites
	//competitionName , competitionYears and round to reach to the file

	public static final String dataBasePath = "D:\\Mohammad\\MyWork\\HassanJamous\\DataBase\\%s\\%s\\%s";

	public void writeRound(String competitionName , String competitionYears ,String site , int round , String data) {
		writeToFile(competitionName, competitionYears,site, round, data);			    		
	}
	
	//to ask hassan do we need go to the certain line to write game (gameId) 
	//do we need this method , what about the games which canceled or postponed
	public void writeGame(String site , String competitionName , String competitionYears , int round  , int gameId , String data) {
		writeToFile(site , competitionName, competitionYears, round, data);			    		
	}

	private void writeToFile(String site, String competitionName, String competitionYears, int round, String data) {
		if(site.equals("SofaScore")) {competitionYears = competitionYears.replace('/', '-');}
		Path directoryPath = Path.of(String.format(dataBasePath, site ,competitionName ,competitionYears));
	    try {
			Files.createDirectories(directoryPath);
		} catch (Exception e) {
			throw new RuntimeException("can not create the folder  " + competitionName + "\\" + competitionYears);// is it good to add e.getStackTrace()  to the msg
		}
		Path filePath = Path.of(String.format(dataBasePath,site , competitionName ,competitionYears) + "\\" + round+".csv");
	    if( ! Files.exists(filePath)) {
			try {
				Files.createFile(filePath);
				Files.writeString(filePath, "the header" +"\n" );
			} catch (Exception e) {
				throw new RuntimeException("can not create the file  " + round);// is it good to add e.getStackTrace()  to the msg
	
			}
	    }
		try {
			
			Files.writeString(filePath, data + "\n", StandardOpenOption.APPEND);//
		} catch (IOException e) {
			throw new RuntimeException("can not write the file  " + round);// is it good to add e.getStackTrace()  to the msg

		}
	}
	public void read() {}
}
