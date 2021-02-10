package sofaScore;

import java.util.List;
import connectionWithDataBase.DataBaseDealer;
import sofaScore.models.basicModels.GamePoints;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.ranking.ClubRanking;
import sofaScore.models.ranking.RankingTable;

public class Util {
	
	DataBaseDealer dataBaseDealer = new DataBaseDealer();
	
	RankingTable getRankingTableForComptitionUntil(String competitionName,String competitionYears,String until) {
			List<String> clubs = getClubsNames(competitionName,competitionYears);
			RankingTable leagueRankingTable =new RankingTable(competitionName, competitionYears);
			for(String clubName : clubs) {
				leagueRankingTable.table.add(parseGamesInSeasonUntil(competitionName , competitionYears , clubName ,until));
			}
			leagueRankingTable.getClubsRanking();
			return leagueRankingTable;
		}	
	
	//where can i bring clubs' names from this function or from worldfootball? ClubsCollector.getAllClubsInSeason 
	public List<String> getClubsNames(String competitionName , String competitionYears){
		return dataBaseDealer.getClubsNamesInCompetition(competitionName, competitionYears);
	}

	public ClubRanking parseGamesInSeasonUntil(String competitionName , String competitionYears , String clubName ,String until) {
		ClubRanking clubRanking = new ClubRanking(clubName);
		List<GameBasicInformation> games = dataBaseDealer.getClubGamesBasicInfoFromDataBaseInSeasonUntil(competitionName,competitionYears,clubName,until);
		for(int i =0; i < games.size(); i++) {
			parseGame(games.get(i),clubName,clubRanking);
		}
		return clubRanking; 
	}
	
	public ClubRanking getClubRankingAt(String competitionName,String competitionYears,String until ,String clubName) {
		RankingTable leagueTable =  getRankingTableForComptitionUntil(competitionName,competitionYears,until);
		for(int i = 0 ; i < leagueTable.table.size(); i++) {
			if(leagueTable.table.get(i).clubName.equals(clubName)) {
				return leagueTable.table.get(i);
			}
		}
		throw new RuntimeException("this club "+clubName+" does not found in "+competitionName+" at season "+competitionYears);
	}
	
	public List<GameBasicInformation> getHeadToHeadFromDataBaseSinceUntil(String competitionName,String firstClub, String secondClub ,String since ,String until){
		return dataBaseDealer.getHeadToHeadFromDataBaseSinceUntil(competitionName,firstClub, secondClub, since, until);
	} 

	private void parseGame(GameBasicInformation game , String club , ClubRanking clubRanking) {
		if(game.event.status.type.equals("finished")) {
			clubRanking.playedGames++;
			if(isHomeClub(game, club)) {
				int homePoint = getGamePoints(game).home;
				clubRanking.points+=homePoint;
				switch(homePoint) {
					case 0:{clubRanking.lostGames++;break;}
					case 1:{clubRanking.drawGames++;break;}
					case 3:{clubRanking.winGames++;break;}
				}
				clubRanking.hisGoals+=game.event.homeScore.current;
				clubRanking.againstGoals+=game.event.awayScore.current;
			}
			else {
				int awayPoint = getGamePoints(game).away;
				clubRanking.points+=awayPoint;
				switch(awayPoint) {
					case 0:{clubRanking.lostGames++;break;}
					case 1:{clubRanking.drawGames++;break;}
					case 3:{clubRanking.winGames++;break;}
				}
				clubRanking.hisGoals+=game.event.awayScore.current;
				clubRanking.againstGoals+=game.event.homeScore.current;
			}
		}
	}
	
	private boolean isHomeClub(GameBasicInformation game , String club) {
		if(game.event.homeTeam.name.equals(club)) {
			return true;
		}
		return false;
	}
	
	private GamePoints getGamePoints(GameBasicInformation game) {
		if(game.event.status.type.equals("finished")) {
			if(game.event.homeScore.current == game.event.awayScore.current) {
				return new GamePoints(1,1);
			}
			else if(game.event.homeScore.current > game.event.awayScore.current) {
				return new GamePoints(3,0);
			}
			else {
				return new GamePoints(0,3);	
			}
		}
		else {return null;}
	}

}
