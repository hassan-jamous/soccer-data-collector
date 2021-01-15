package worldfootball.testData;

import java.util.ArrayList;
import java.util.Arrays;

import worldfootball.models.Club;
import worldfootball.models.Player;
import worldfootball.models.PlayerTopScoreForSeason;

public class TopScoreAndTopScoreForCompetition {

		public ArrayList<PlayerTopScoreForSeason> getTopScoerForEnglishPreimerLeagueAllYears() {
			return new ArrayList<>(Arrays.asList(
	    			new PlayerTopScoreForSeason("2019/2020" , "England",new Player("Jamie Vardy"),               new Club( "Leicester City"),"23"),
	    			new PlayerTopScoreForSeason("2018/2019" , "Senegal",new Player("Sadio Mané") ,                new Club("Liverpool FC"),  "22"),
	    			new PlayerTopScoreForSeason("2018/2019" , "Gabon",  new Player("Pierre-Emerick Aubameyang"),  new Club("Arsenal FC"),    "22"),
	    			new PlayerTopScoreForSeason("2018/2019" , "Egypt",  new Player("Mohamed Salah"), 	          new Club("Liverpool FC"),  "22"),
	    			new PlayerTopScoreForSeason("2017/2018" , "Egypt", 	new Player("Mohamed Salah"), 	 	      new Club("Liverpool FC"),  "32"),
	    			new PlayerTopScoreForSeason("2016/2017" , "England",new Player("Harry Kane"), 	              new Club("Tottenham Hotspur"),"29"),
	    			new PlayerTopScoreForSeason("2012/2013" , "Netherlands",new Player("Robin van Persie"), 	new Club("Manchester United"),"26")));
		}

}


