package csvFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class DealerCSV {

	public static final String dataBasePath = "D:\\Mohammad\\MyWork\\HassanJamous\\DataBase\\%s\\%s";

	public void writeRound(String competitionName , String competitionYears , int round , String data) {
		writeToFile(competitionName, competitionYears, round, data);			    		
	}
	
	//to ask hassan do we need go to line gameId 
	public void writeGame(String competitionName , String competitionYears , int round  , int gameId , String data) {
		writeToFile(competitionName, competitionYears, round, data);			    		
	}

	private void writeToFile(String competitionName, String competitionYears, int round, String data) {
		competitionYears = competitionYears.replace('/', '-');
		Path directoryPath = Path.of(String.format(dataBasePath, competitionName ,competitionYears));
	    try {
			Files.createDirectories(directoryPath);
		} catch (Exception e) {
			throw new RuntimeException("can not create the folder  " + competitionName + "\\" + competitionYears);// is it good to add e.getStackTrace()  to the msg
		}
		Path filePath = Path.of(String.format(dataBasePath, competitionName ,competitionYears) + "\\" + round+".csv");
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
