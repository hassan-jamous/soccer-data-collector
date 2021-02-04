package csvFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import util.Sites;

public class CSVFilesDealer {
	public static final String dataBasePath = "./\\sources\\DataBase\\%s\\%s";

	public void writeInFileWithOutHeader(Sites site , String competitionName , String data,FileTypes fileType) {
	
		competitionName = competitionName.replaceAll("\\s+", "");
		Path directoryPath = Path.of(String.format(dataBasePath,site.value(), competitionName ));
		try {
			Files.createDirectories(directoryPath);
		} catch (Exception e) {
			throw new RuntimeException("can not create the folder  " + competitionName );// is it good to add e.getStackTrace()  to the msg
		}
		Path filePath = Path.of(String.format(dataBasePath ,site.value(), competitionName)+"\\"  + competitionName+fileType.value()+".csv");
	    if( ! Files.exists(filePath)) {
			try {
				Files.createFile(filePath);
			} catch (Exception e) {
				throw new RuntimeException("can not create the file  " + competitionName+fileType.value());// is it good to add e.getStackTrace()  to the msg
			}
	    }
		try {
			Files.writeString(filePath, data + "\n", StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("can not write the file  " +  competitionName+fileType);// is it good to add e.getStackTrace()  to the msg
		}
	}

		/**
		 * 
		 * @param site SofaScore or WorldFootball write them according CamelCase
		 * @param competitionName
		 * @param competitionYears
		 * @param data the string which we want to write
		 * @param dataType statistics or incidentInGames
		 * @param isHeader to know if the data is header or no :: it depends on how we send the data object which contains data or string if object i think we do not want this parameter
		 */
		public void writeInFileWithHeader(Sites site , String competitionName , String data , boolean isHeader , FileTypes fileType) {
			
			competitionName = competitionName.replaceAll("\\s+", "");
			Path directoryPath = Path.of(String.format(dataBasePath,site.value(), competitionName ));
		    try {
				Files.createDirectories(directoryPath);
			} catch (Exception e) {
				throw new RuntimeException("can not create the folder  " + competitionName );// is it good to add e.getStackTrace()  to the msg
			}
			Path filePath = Path.of(String.format(dataBasePath ,site.value(), competitionName)+"\\"  + competitionName+fileType.value()+".csv");
		    if( ! Files.exists(filePath)) {
				try {
					Files.createFile(filePath);
					if(fileType == FileTypes.Statistics) {//this file contains data which need header
						if(isHeader) {Files.writeString(filePath, data +"\n" );}
						else {throw new RuntimeException ("the file is empty and the data is not header");}
					}
					else {//this file contains data which do not need header
						Files.writeString(filePath, data +"\n" );
					}
				} catch (Exception e) {
					throw new RuntimeException("can not create the file  " + competitionName+fileType.value());// is it good to add e.getStackTrace()  to the msg
				}
		    }
			try {
				if(fileType == FileTypes.Statistics) {
					if(! isHeader) { //in this type we distinguish between header or data 
						Files.writeString(filePath, data + "\n", StandardOpenOption.APPEND);
					}
				}
				else{ //data are equal to information 
					Files.writeString(filePath, data + "\n", StandardOpenOption.APPEND);
				}
			} catch (IOException e) {
				throw new RuntimeException("can not write the file  " +  competitionName+fileType);// is it good to add e.getStackTrace()  to the msg
			}
		}
		
		
		
}


