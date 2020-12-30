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

    public GamesTableOfLeague getAllRounds(String competitionName, String competitionYears) {
        return roundCollector.getAllRounds(competitionName, competitionYears);
    }

    public RankingTable getLastTable(String competitionName, String competitionYears) {
        return tableCollector.getLastTable(competitionName, competitionYears);
    }

    public RankingTable getTableByRound(String competitionName, String competitionYears, String round) {
        return tableCollector.getTableByRound(competitionName, competitionYears, round);
    }

    public ArrayList<Goal> getGoalsOfGame(String competitionName, String competitionYears, String fisrtTeam, String secondTeam) {
        return goalsCollector.getGoalsOfGame(competitionName, competitionYears, fisrtTeam, secondTeam);
    }

    public ArrayList<PlayerSummary> getAllPlayersSummaryInCompetition(String competitionName, String competitionYears) {
        return clubsCollector.getAllPlayersSummaryInCompetition(competitionName, competitionYears);
    }

    public ArrayList<PlayerSummary> getAllPlayersSummaryInClub(String clubName, String year) {
        return clubsCollector.getAllPlayersSummaryInClub(clubName, year);
    }

    public ArrayList<Club> getAllClubsInSeason(String competitionName, String competitionYears) {
        return clubsCollector.getAllClubsInSeason(competitionName ,competitionYears);
    }

    public PlayerAllInformation getAllInformationAboutPlayer(String nameAsInURL) {
        return playerCollector.getAllInformationAboutPlayer(nameAsInURL);
    }

    public MatchDetails getMatchDetails(String competitionName, String competitionYears, String firstClub, String secondClub) {
        return matchCollector.getMatchDetails(competitionName, competitionYears, firstClub, secondClub);
    }

    public ArrayList<ClubTransferTable> getClubsTransferTableAtSeason(String competitionName, String competiotionYears) {
        return transferCollector.getClubsTransferTableAtSeason(competitionName, competiotionYears);
    }

    public ArrayList<PlayerTopSoccer> getTopSoccerAtSeason(String competitionName, String competitionYears) {
        return topScoreCollector.getTopSoccerAtSeason(competitionName, competitionYears);
    }

    public ArrayList<StatisticsGoalsPerSeason> getStatisticsGoalsPerSeason(String competitionName) {
        return statisticsCollector.getStatisticsGoalsPerSeason(competitionName);
    }

    public ArrayList<StatisticsGoalsPerRound> getStatisticsGoalsPerRound(String competitionName) {
        return statisticsCollector.getStatisticsGoalsPerRound(competitionName);
    }

    
    public ArrayList<StatisticsRecordWinsAndMostGoalInGame> getStatisticsRecordWinsOrMostGoalInGame(String competitionName, StatisticsRequestKind kindOfRequest) {
        return statisticsCollector.getStatisticsRecordWinsOrMostGoalInGame(competitionName, kindOfRequest);
    }

    public ArrayList<StatisticsMostGoalsByPlayerPerGame> getStatisticsMostGoalsByPlayerInGameInCompetition(String competitionName) {
        return statisticsCollector.getStatisticsMostGoalsByPlayerInGameInCompetition(competitionName);
    }

    public ArrayList<DirtyGame> getStatisticsDirtiesGamesForCompetition(String competitionName) {
        return statisticsCollector.getStatisticsDirtiesGamesForCompetition(competitionName);
    }

    public ArrayList<StatisticsBestPlayerInYear> getStatisticsBestPlayerInYear(String country) {
        return statisticsCollector.getStatisticsBestPlayerInYear(country);
    }

    public ArrayList<Staduim> getCompetitionStadiums(String competitionName, String competitionYears) {
        return statisticsCollector.getCompetitionSatuims(competitionName, competitionYears);
    }

}

