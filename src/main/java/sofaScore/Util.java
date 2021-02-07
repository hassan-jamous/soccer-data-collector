package sofaScore;

import sofaScore.models.basicModels.GamePoints;
import sofaScore.models.gameBasicInformation.GameBasicInformation;
import sofaScore.models.ranking.ClubRanking;
import sofaScore.models.ranking.RankingTable;

public class Util {
	
	public void parseGame(GameBasicInformation game , String club , ClubRanking clubRanking) {
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

	public boolean isHomeClub(GameBasicInformation game , String club) {
		if(game.event.homeTeam.name.equals(club)) {
			return true;
		}
		return false;
	}
	public GamePoints getGamePoints(GameBasicInformation game) {
	
		if(game.event.status.type.equals("finished")) {
			if(game.event.awayScore.current == game.event.awayScore.current) {
				return new GamePoints(1,1);
			}
			else if(game.event.awayScore.current > game.event.awayScore.current) {
				return new GamePoints(0,3);
			}
			else {
				return new GamePoints(3,0);	
			}
		}
		else {return null;}
	}
	
	
}
