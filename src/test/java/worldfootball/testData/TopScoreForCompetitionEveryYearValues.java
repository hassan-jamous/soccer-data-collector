package worldfootball.testData;

import java.util.ArrayList;
import java.util.Arrays;

import worldfootball.models.Club;
import worldfootball.models.Player;
import worldfootball.models.PlayerTopSoccerAtSeason;

public class TopScoreForCompetitionEveryYearValues {

	public ArrayList<PlayerTopSoccerAtSeason> getTableTopScoreEnglishPriemerLeague2019_2020() {
		return new ArrayList<>(Arrays.asList(
        		new PlayerTopSoccerAtSeason("1.", new Player("Jamie Vardy"), "England", new Club("Leicester City"), "23", "4"),
        		new PlayerTopSoccerAtSeason("2.", new Player("Pierre-Emerick Aubameyang"), "Gabon", new Club("Arsenal FC"), "22", "2"),
        		new PlayerTopSoccerAtSeason("2.", new Player("Danny Ings"), "England", new Club("Southampton FC"), "22", "1"),
        		new PlayerTopSoccerAtSeason("4.", new Player("Raheem Sterling"), "England",new Club( "Manchester City"), "20", "0"),
        		new PlayerTopSoccerAtSeason("5.", new Player("Mohamed Salah"), "Egypt", new Club("Liverpool FC"), "19", "3")));
	}
	public ArrayList<PlayerTopSoccerAtSeason> getTopScoreEngishPriemerLeague1946_1947() {
		return new ArrayList<>(Arrays.asList(
        		new PlayerTopSoccerAtSeason("1.", new Player("Dennis Westcott"), "England", new Club("Wolverhampton Wanderers"), "38", "0"),
        		new PlayerTopSoccerAtSeason("2.", new Player("Reg Lewis"), "England", new Club("Arsenal FC"), "29", "3"),
        		new PlayerTopSoccerAtSeason("2.", new Player("Stan Mortensen"), "England", new Club("Blackpool FC"), "29", "1"),
        		new PlayerTopSoccerAtSeason("2.", new Player("Duggie Reid"), "Scotland", new Club("Portsmouth FC"), "29", "1"),
        		new PlayerTopSoccerAtSeason("2.", new Player("Freddie Steele"), "England",new Club( "Stoke City"), "29", "0")));
	}

	public ArrayList<PlayerTopSoccerAtSeason> getTopScoreEnglishPreimerLeague2009_2010() {
		return new ArrayList<>(Arrays.asList(
        		new PlayerTopSoccerAtSeason("5.",new Player( "Frank Lampard"), "England", new Club("Chelsea FC"), "22", "10"),
        		new PlayerTopSoccerAtSeason("6.", new Player("Jermain Defoe"), "England",new Club( "Tottenham Hotspur"), "18", "1"),
        		new PlayerTopSoccerAtSeason("6.", new Player("Fernando Torres"), "Spain", new Club("Liverpool FC"), "18", "0"),
        		new PlayerTopSoccerAtSeason("8.", new Player("Cesc Fàbregas"), "Spain", new Club("Arsenal FC"), "15", "3"),
        		new PlayerTopSoccerAtSeason("9.",new Player( "Emmanuel Adebayor"), "Togo",new Club( "Manchester City"), "14", "0")));
	}
}
