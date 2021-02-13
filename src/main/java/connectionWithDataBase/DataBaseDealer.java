package connectionWithDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import sofaScore.models.gameBasicInformation.GameBasicInformation;

public class DataBaseDealer {
	Connection dataBaseConnection;
	Statement dataBaseStatement;
	HashMapTableName tableNames = new HashMapTableName();

	public List<String> getClubsNamesInCompetition(String competitionName , String competitionYears){
		String query =String.format("SELECT DISTINCT HomeTeam FROM %s WHERE League='%s'  AND Years='%s'",tableNames.getTableName(competitionName),competitionName,competitionYears);
		return getClubsNamesFromDataBase(query);
	}
	public List<GameBasicInformation> getClubGamesBasicInfoFromDataBaseInSeasonUntil(String competitionName,String competitionYears,String clubName ,String until) {
		String query =String.format("SELECT * FROM %s  WHERE League='%s' AND Years='%s' AND Date<'%s' AND  ( HomeTeam='%s' OR AwayTeam='%s')",tableNames.getTableName(competitionName),competitionName,competitionYears,until,clubName,clubName);
		return getGamesBaiscInfoFromDataBase(query);
	}
	
	public List<GameBasicInformation> getHeadToHeadFromDataBaseSinceUntil(String competitionName,String firstClub, String secondClub ,String since ,String until) {
		String query =String.format("SELECT * FROM %1$s  WHERE Date BETWEEN '%2$s' AND '%3$s' AND(  ( HomeTeam='%4$s' AND AwayTeam='%5$s') OR ( HomeTeam='%5$s' AND AwayTeam='%4$s'))",tableNames.getTableName(competitionName),since,until ,firstClub,secondClub);
		return getGamesBaiscInfoFromDataBase(query);
	}

	private List<String> getClubsNamesFromDataBase(String query){
		List<String> result = new ArrayList<>( Arrays.asList());		
		ResultSet resultFromDataBase= getDataFromDataBase(query);
		try {
			while(resultFromDataBase.next())  {
				String club = resultFromDataBase.getString("HomeTeam");				
				result.add(club);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		closeDataBase();			
		Collections.sort(result);
		return result;
	}
	
	private List<GameBasicInformation> getGamesBaiscInfoFromDataBase(String query){
		List<GameBasicInformation> result = new ArrayList<>( Arrays.asList());
		ResultSet resultFromDataBase= getDataFromDataBase(query);			
		try {
			while(resultFromDataBase.next())  {
				GameBasicInformation game = getGameValuesFromDataBase(resultFromDataBase);;
				result.add(game);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		closeDataBase();			
		return result;
	}

	private GameBasicInformation getGameValuesFromDataBase(ResultSet resultFromDataBase) {
		GameBasicInformation game = new GameBasicInformation();
		game.initialize();
		try {
		game.event.tournament.name= resultFromDataBase.getString("League");		
		game.event.season.year = resultFromDataBase.getString("Years");
		game.event.tournament.uniqueTournament.name=resultFromDataBase.getString("TypeOfLeague");
		game.event.roundInfo.round= resultFromDataBase.getInt("Round");
		game.event.startTimestamp= resultFromDataBase.getTimestamp("Date");
		game.event.homeTeam.name = resultFromDataBase.getString("HomeTeam");
		game.event.awayTeam.name= resultFromDataBase.getString("AwayTeam");
		game.event.homeScore.current = resultFromDataBase.getInt("HomeScore");
		game.event.awayScore.current= resultFromDataBase.getInt("AwayScore");
		game.event.status.type ="finished";
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return game;
	}
	
	private ResultSet getDataFromDataBase(String query){
		ResultSet resultFromDataBase;
		try{  
			Class.forName("com.mysql.jdbc.Driver");
			dataBaseConnection=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test?useSSL=false","root","HassanJamous");  
			dataBaseStatement=dataBaseConnection.createStatement();			
			resultFromDataBase=dataBaseStatement.executeQuery(query); 			
			}catch(Exception e){ 
				throw new RuntimeException(e.getMessage());
			} 
		return resultFromDataBase;
	}
	
	private void closeDataBase() {
		try {
			dataBaseConnection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
