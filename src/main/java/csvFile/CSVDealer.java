package csvFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CSVDealer {
	public static final String dataBasePath = "./\\sources\\DataBase\\%s\\%s";

		/**
		 * 
		 * @param site SofaScore or WorldFootball write them according CamelCase
		 * @param competitionName
		 * @param competitionYears
		 * @param data the string which we want to write
		 * @param dataType statistics or incidentInGames
		 * @param isHeader to know if the data is header or no :: it depends on how we send the data object which contains data or string if object i think we do not want this parameter
		 */

		public void write(String site , String competitionName , String data , boolean isHeader , String fileType) {
			
			competitionName = competitionName.replaceAll("\\s+", "");
			Path directoryPath = Path.of(String.format(dataBasePath,site, competitionName ));
		    try {
				Files.createDirectories(directoryPath);
			} catch (Exception e) {
				throw new RuntimeException("can not create the folder  " + competitionName );// is it good to add e.getStackTrace()  to the msg
			}
			Path filePath = Path.of(String.format(dataBasePath ,site, competitionName)+"\\"  + competitionName+fileType+".csv");
		    if( ! Files.exists(filePath)) {
				try {
					Files.createFile(filePath);
					if(fileType.equals("Statistic")) {
						if(isHeader) {Files.writeString(filePath, data +"\n" );}
						else {throw new RuntimeException ("the file is empty and the data is not header");}
					}
					else {
						Files.writeString(filePath, data +"\n" );
					}
				} catch (Exception e) {
					throw new RuntimeException("can not create the file  " + competitionName+fileType);// is it good to add e.getStackTrace()  to the msg
				}
		    }
			try {
				if(fileType.equals("Statistic")) {
					if(! isHeader) { 
						Files.writeString(filePath, data + "\n", StandardOpenOption.APPEND);
					}
				}
				else{
					Files.writeString(filePath, data + "\n", StandardOpenOption.APPEND);
				}
			} catch (IOException e) {
				throw new RuntimeException("can not write the file  " +  competitionName+fileType);// is it good to add e.getStackTrace()  to the msg
			}
		}
		
		
		
}


