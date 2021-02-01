package sofaScore;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import sofaScore.models.statisticsPlayer.PlayerInLineups;
import sofaScore.models.statisticsPlayer.TeamKindInGame;

public class PlayerCollectorTest {

	PlayerCollector playerCollector = new PlayerCollector();

	@Test
	public void itShouldGetPlayersRating() {

		// https://www.sofascore.com/manchester-city-sheffield-united/psr
		// https://api.sofascore.com/api/v1/event/8897021/lineups
		List<PlayerInLineups> game1HomeTeam = playerCollector.getPlayerStatisticsInTeam("8897021", TeamKindInGame.Home);
		assertEquals(game1HomeTeam.get(0).statistics.rating, Double.valueOf(7.1));
		assertEquals(game1HomeTeam.get(1).statistics.rating, Double.valueOf(7.2));
		assertEquals(game1HomeTeam.get(2).statistics.rating, Double.valueOf(7.4));
		assertEquals(game1HomeTeam.get(9).statistics.rating, Double.valueOf(7));
		assertEquals(game1HomeTeam.get(10).statistics.rating, Double.valueOf(7.4));
		assertEquals(game1HomeTeam.get(11).statistics.rating, null);
		List<PlayerInLineups> game1AwayTeam = playerCollector.getPlayerStatisticsInTeam("8897021", TeamKindInGame.Away);
		assertEquals(game1AwayTeam.get(3).statistics.rating, Double.valueOf(7.2));
		assertEquals(game1AwayTeam.get(6).statistics.rating, Double.valueOf(6.7));
		assertEquals(game1AwayTeam.get(8).statistics.rating, Double.valueOf(6.3));
		assertEquals(game1AwayTeam.get(9).statistics.rating, Double.valueOf(6.8));
		assertEquals(game1AwayTeam.get(11).statistics.rating, null);
		assertEquals(game1AwayTeam.get(18).statistics.rating, Double.valueOf(6.6));
		assertEquals(game1AwayTeam.get(19).statistics.rating, Double.valueOf(6.4));

		// https://www.sofascore.com/manchester-united-leicester-city/GK
		String game2ID = playerCollector.getPlayerStatisticsInTeamJUST_TEST("Premier League", "2019/2020", "38", 5);
		List<PlayerInLineups> game2HomeTeam = playerCollector.getPlayerStatisticsInTeam(game2ID, TeamKindInGame.Home);
		assertEquals(game2HomeTeam.get(0).statistics.rating, Double.valueOf(5.6));
		assertEquals(game2HomeTeam.get(1).statistics.rating, Double.valueOf(7.3));
		assertEquals(game2HomeTeam.get(5).statistics.rating, Double.valueOf(6.4));
		assertEquals(game2HomeTeam.get(10).statistics.rating, Double.valueOf(7));
		assertEquals(game2HomeTeam.get(11).statistics.rating, null);
		assertEquals(game2HomeTeam.get(14).statistics.rating, null);
		assertEquals(game2HomeTeam.get(15).statistics.rating, Double.valueOf(6.8));
		assertEquals(game2HomeTeam.get(19).statistics.rating, Double.valueOf(6.7));
		List<PlayerInLineups> game2AwayTeam = playerCollector.getPlayerStatisticsInTeam(game2ID, TeamKindInGame.Away);
		assertEquals(game2AwayTeam.get(3).statistics.rating, Double.valueOf(7.1));
		assertEquals(game2AwayTeam.get(4).statistics.rating, Double.valueOf(7.4));
		assertEquals(game2AwayTeam.get(7).statistics.rating, Double.valueOf(6.4));
		assertEquals(game2AwayTeam.get(9).statistics.rating, Double.valueOf(6.8));
		assertEquals(game2AwayTeam.get(11).statistics.rating, null);
		assertEquals(game2AwayTeam.get(15).statistics.rating, Double.valueOf(6.7));
		assertEquals(game2AwayTeam.get(17).statistics.rating, null);
		assertEquals(game2AwayTeam.get(18).statistics.rating, null);
		assertEquals(game2AwayTeam.get(19).statistics.rating, null);

		// https://www.sofascore.com/manchester-united-leicester-city/GK
		String game3ID = playerCollector.getPlayerStatisticsInTeamJUST_TEST("Premier League", "2016/2017", "6", 0);
		List<PlayerInLineups> game3HomeTeam = playerCollector.getPlayerStatisticsInTeam(game3ID, TeamKindInGame.Home);
		assertEquals(game3HomeTeam.get(0).statistics.rating, Double.valueOf(6.7));
		assertEquals(game3HomeTeam.get(1).statistics.rating, Double.valueOf(7.2));
		assertEquals(game3HomeTeam.get(2).statistics.rating, Double.valueOf(7.6));
		assertEquals(game3HomeTeam.get(6).statistics.rating, Double.valueOf(8.4));
		assertEquals(game3HomeTeam.get(10).statistics.rating, Double.valueOf(7.3));
		assertEquals(game3HomeTeam.get(11).statistics.rating, null);
		assertEquals(game3HomeTeam.get(14).statistics.rating, Double.valueOf(6.5));
		assertEquals(game3HomeTeam.get(15).statistics.rating, null);
		assertEquals(game3HomeTeam.get(16).statistics.rating, null);
		assertEquals(game3HomeTeam.get(17).statistics.rating, Double.valueOf(6.7));
		List<PlayerInLineups> game3AwayTeam = playerCollector.getPlayerStatisticsInTeam(game3ID, TeamKindInGame.Away);
		assertEquals(game3AwayTeam.get(2).statistics.rating, Double.valueOf(6.3));
		assertEquals(game3AwayTeam.get(4).statistics.rating, Double.valueOf(6));
		assertEquals(game3AwayTeam.get(7).statistics.rating, Double.valueOf(7.3));
		assertEquals(game3AwayTeam.get(8).statistics.rating, Double.valueOf(6.3));
		assertEquals(game3AwayTeam.get(11).statistics.rating, null);
		assertEquals(game3AwayTeam.get(15).statistics.rating, Double.valueOf(6.5));
		assertEquals(game3AwayTeam.get(17).statistics.rating, null);

		// https://www.sofascore.com/west-ham-united-manchester-united/KM
		String game4ID = playerCollector.getPlayerStatisticsInTeamJUST_TEST("Premier League", "2015/2016", "15", 2);
		List<PlayerInLineups> game4HomeTeam = playerCollector.getPlayerStatisticsInTeam(game4ID, TeamKindInGame.Home);
		assertEquals(game4HomeTeam.get(0).statistics.rating, Double.valueOf(7.2));
		assertEquals(game4HomeTeam.get(1).statistics.rating, Double.valueOf(6));
		assertEquals(game4HomeTeam.get(2).statistics.rating, Double.valueOf(7.9));
		assertEquals(game4HomeTeam.get(6).statistics.rating, Double.valueOf(7.2));
		assertEquals(game4HomeTeam.get(10).statistics.rating, Double.valueOf(6.9));
		assertEquals(game4HomeTeam.get(11).statistics.rating, null);
		assertEquals(game4HomeTeam.get(14).statistics.rating, null);
		assertEquals(game4HomeTeam.get(15).statistics.rating, null);
		assertEquals(game4HomeTeam.get(16).statistics.rating, Double.valueOf(6.7));
		assertEquals(game4HomeTeam.get(17).statistics.rating, Double.valueOf(7.1));
		List<PlayerInLineups> game4AwayTeam = playerCollector.getPlayerStatisticsInTeam(game4ID, TeamKindInGame.Away);
		assertEquals(game4AwayTeam.get(2).statistics.rating, Double.valueOf(7.6));
		assertEquals(game4AwayTeam.get(4).statistics.rating, Double.valueOf(7.1));
		assertEquals(game4AwayTeam.get(7).statistics.rating, Double.valueOf(7.5));
		assertEquals(game4AwayTeam.get(8).statistics.rating, Double.valueOf(7.2));
		assertEquals(game4AwayTeam.get(11).statistics.rating, null);
		assertEquals(game4AwayTeam.get(13).statistics.rating, null);
		assertEquals(game4AwayTeam.get(14).statistics.rating, null);
		assertEquals(game4AwayTeam.get(15).statistics.rating, Double.valueOf(6.5));
		assertEquals(game4AwayTeam.get(17).statistics.rating, null);

		// https://www.sofascore.com/arsenal-manchester-united/KR
		String game5ID = playerCollector.getPlayerStatisticsInTeamJUST_TEST("Premier League", "2012/2013", "10", 0);
		List<PlayerInLineups> game5HomeTeam = playerCollector.getPlayerStatisticsInTeam(game5ID, TeamKindInGame.Home);
		assertEquals(game5HomeTeam.get(0).statistics, null);
		assertEquals(game5HomeTeam.get(1).statistics, null);
		assertEquals(game5HomeTeam.get(2).statistics, null);
		assertEquals(game5HomeTeam.get(6).statistics, null);
		assertEquals(game5HomeTeam.get(10).statistics, null);
		assertEquals(game5HomeTeam.get(11).statistics, null);
		assertEquals(game5HomeTeam.get(14).statistics, null);
		assertEquals(game5HomeTeam.get(15).statistics, null);
		assertEquals(game5HomeTeam.get(16).statistics, null);
		assertEquals(game5HomeTeam.get(17).statistics, null);

	}
}
