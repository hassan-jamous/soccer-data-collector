package collector;

import java.util.ArrayList;


import models.*;


public class ScreenScraper {
	RoundCollector roundCollector = new RoundCollector();
	TableCollector tableCollector = new TableCollector();
	GoalsCollector goalsCollector = new GoalsCollector();
	TeamsCollector teamsCollector = new TeamsCollector();
	PlayerCollector playerCollector = new PlayerCollector();
	MatchCollector matchCollector = new MatchCollector();
	TransferCollector transferCollector = new TransferCollector();
	TopScoreCollector topScoreCollector = new TopScoreCollector();
    

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

	public ArrayList<Player> getAllPlayersSummuryInCompetition(String competitionName , String competitionYears) {
		return teamsCollector.getAllPlayersSummuryInCompetition(competitionName, competitionYears);
	}
 
	public ArrayList<Player> getAllPlayersSummuryInTeam(String teamName, String year) {
		return teamsCollector.getAllPlayersSummuryInTeam(teamName, year);

	}

	public ArrayList<Team> getAllTeamsInSeason(String competitionYears) {
		return teamsCollector.getAllTeamsInSeason(competitionYears);

	}

	 public PlayerInformation getAllInformationAboutPlayer(String nameAsInURL) {
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

		
		
		
	
	
	
	
	
	
	
	
	
	
}//end ScreenScraper

