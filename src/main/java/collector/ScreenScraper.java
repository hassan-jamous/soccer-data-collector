package collector;

import java.util.ArrayList;


import models.*;


public class ScreenScraper {
	RoundCollector roundCollector = new RoundCollector();
	TableCollector tableCollector = new TableCollector();
	GoalsCollector goalsCollector = new GoalsCollector();
	ClubsCollector clubsCollector = new ClubsCollector();
	PlayerCollector playerCollector = new PlayerCollector();
	MatchCollector matchCollector = new MatchCollector();
	TransferCollector transferCollector = new TransferCollector();
	TopScoreCollector topScoreCollector = new TopScoreCollector();
	StatisticsCollector statisticsCollector = new StatisticsCollector();

    public GamesTableOfLeague getAllRounds(String leagueName, String competitionYears) {
       return roundCollector.getAllRounds(leagueName, competitionYears);
    }

    public RankingTable getLastTable(String leagueName, String years) {
		return tableCollector.getLastTable(leagueName, years);
	}

    public RankingTable getTableByRound(String leagueName, String years, String round) {
		return tableCollector.getTableByRound(leagueName, years, round);
	}

	public ArrayList<Goal> getGoalsOfGame(String competitionName, String competitionYears ,String fisrtTeam , String secondTeam) {
    	return goalsCollector.getGoalsOfGame(competitionName, competitionYears , fisrtTeam ,  secondTeam);
	}

	public ArrayList<PlayerSummary> getAllPlayersSummuryInCompetition(String competitionName , String competitionYears) {
		return clubsCollector.getAllPlayersSummaryInCompetition(competitionName, competitionYears);
	}
 
	public ArrayList<PlayerSummary> getAllPlayersSummuryInClub(String clubName, String year) {
		return clubsCollector.getAllPlayersSummaryInClub(clubName, year);

	}

	public ArrayList<Club> getAllClubsInSeason(String competitionYears) {
		return clubsCollector.getAllClubsInSeason(competitionYears);

	}

	 public PlayerAllInformation getAllInformationAboutPlayer(String nameAsInURL) {
		 return playerCollector.getAllInformationAboutPlayer(nameAsInURL);
	 }
    
 
	public MatchDetails getMatchDetails(String competitionName , String competitionYears , String firstClub , String secondClub) {
		 return matchCollector.getMatchDetails(competitionName, competitionYears, firstClub, secondClub);
	 }

	public ArrayList<ClubTransferTable> getClubsTransferTableAtSeason(String competitionName , String competiotionYears) {
		return transferCollector.getClubsTransferTableAtSeason(competitionName , competiotionYears);
	}

	public ArrayList <PlayerTopSoccer> getTopSoccerAtSeason(String competitionYears ) {
		return topScoreCollector.getTopSoccerAtSeason(competitionYears);
	}

	public ArrayList <StatisticsGoalsPerSeason> getStatisticsGoalsPerSeason(String competitionName) {
		return statisticsCollector.getStatisticsGoalsPerSeason(competitionName);
	}
	public ArrayList <StatisticsGoalsPerRound> getStatisticsGoalsPerRound(String competitionName) {
		return statisticsCollector.getStatisticsGoalsPerRound(competitionName);

	}
	
	//3 is the request for record wins or 4 is the request for most goals in game 
	public ArrayList <StatisticsRecordWinsAndMostGoalInGame> getStatisticsRecordWinsOrMostGoalInGame(String competitionName , int kindOfRequest) {
		return statisticsCollector.getStatisticsRecordWinsOrMostGoalInGame(competitionName , kindOfRequest);
	}
		
	public ArrayList <StatisticsMostGoalsInGame> getStatisticsMostGoalsInGameInCompetetion(String competitionName){
		return 	statisticsCollector.getStatisticsMostGoalsInGameInCompetetion(competitionName);
	}
 	public ArrayList<DirtyGame> getStatisticsDirtiesGamesForCompetition(String competitionName){
 		return statisticsCollector.getStatisticsDirtiesGamesForCompetition(competitionName);
 	}

 	public ArrayList<StatisticsBestPlayerInYear> getStatisticsBestPlayerInYear(String country){
 		return statisticsCollector.getStatisticsBestPlayerInYear(country);
 	}
	public ArrayList<Staduim> getCompetitionSatuims (String competitionName , String competitionYears){

		return 	statisticsCollector.getCompetitionSatuims (competitionName , competitionYears);

	}	
	
	
	
	
	
	
	
	
	
	
}//end ScreenScraper

