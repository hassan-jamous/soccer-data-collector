package  worldfootball.testData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import worldfootball.models.Goal;
import worldfootball.models.Player;

public class GamesGoalsValues {
	
		public List<Goal> goals1946_1947LeedsUnitedSunderlandAfcExpected() {
			return Arrays.asList(
		    		new Goal("1 : 0", "90", new Player( "Davy Cochrane")),
		    		new Goal("1 : 1", "90", new Player("Jackie Robinson")));
		}

		public List<Goal> goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue() {
			return Arrays.asList(
		    		new Goal("1 : 0", "0",new Player("Bobby Smith")),
		    		new Goal("2 : 0", "0",new Player("George Robb")),
		    		new Goal("3 : 0", "0",new Player("Terry Medwin")),
		    		new Goal("4 : 0", "0",new Player("John Brooks")),
		    		new Goal("5 : 0", "0",new Player("Danny Blanchflower")),
		    		new Goal("5 : 1", "0",new Player("Keith Ripley")));
		}

		public List<Goal> goals1956_1957SheffieldWednesdayChelseaFcExpectedValue() {
			return Arrays.asList(
		    		new Goal("1 : 0", "0",new Player("Roy Shiner") ),
		    		new Goal("2 : 0", "0",new Player("Roy Shiner")),
		    		new Goal("3 : 0", "0",new Player("Albert Quixall")),
		    		new Goal("4 : 0", "0",new Player("Albert Quixall")));
		}

		public List<Goal> goals1963_1964SheffieldUnitedBurnleyFcExpected() {
			return Arrays.asList(
		    		new Goal("1 : 0", "90",new Player( "Tony Wagstaff")),
		    		new Goal("2 : 0", "90",new Player( "Mick Jones")));
		}

		public List<Goal> goals1976_1977LeedsUnitedCoventryCityExpected() {
			return Arrays.asList(
		    		new Goal("0 : 1", "45", new Player("Alan Green")),
		    		new Goal("1 : 1", "45", new Player("Joe Jordan")),
		    		new Goal("1 : 2", "90", new Player("Donal Murphy")));
		}

		public List<Goal> goals1983_1984TottenhamHotspurManchesterUnitedExpected() {
			return Arrays.asList(
		    		new Goal("1 : 0", "90",new Player( "Steve Archibald")),
		    		new Goal("1 : 1", "90",new Player( "Norman Whiteside")));
		}

		public List<Goal> goals1992_1993ChelseaFcSheffieldUnitedExpected() {
			return Arrays.asList(
		    		new Goal("0 : 1", "40", new Player( "Adrian Littlejohn")),
		    		new Goal("1 : 1", "41",new Player( "Andy Townsend")),
		    		new Goal("1 : 2", "57",new Player( "Brian Deane")));
		}

		public List<Goal> goals1996_1997ManchesterUnitedWestHamUnitedExpected() {
			return Arrays.asList(
		    		new Goal("1 : 0", "11", new Player("Ole Gunnar Solskjær")),
		    		new Goal("2 : 0", "84", new Player("Jordi Cruyff")));
		}

		public ArrayList<Goal> goals2000_2001LeedsUnitedEvertonFcExpectedValue() {
			return new ArrayList<>(Arrays.asList(
		    		new Goal("1 : 0", "16", new Player("Alan Smith")),
		    		new Goal("2 : 0", "37", new Player("Alan Smith"))
		    		));
		}

		public List<Goal> getgoals1998_1999ArsenalFcAstonVillaExpected() {
			return Arrays.asList(
		    		new Goal("1 : 0", "66", new Player("Nwankwo Kanu")));
		}		

		public List<Goal> goals2015_2016ArsenalFcAstonVillaExpectedValue() {
			return Arrays.asList(
					new Goal("1 : 0", "5",new Player( "Olivier Giroud"), "header",new Player( "Nacho Monreal")),
					new Goal("2 : 0", "78",new Player( "Olivier Giroud"), "left-footed shot",new Player( "Mesut Özil")),
					new Goal("3 : 0", "80",new Player( "Olivier Giroud"), "left-footed shot", new Player("Héctor Bellerín")),
					new Goal("4 : 0", "90", new Player("Mark Bunn"), "own goal"));
		}

		public List<Goal> goals2015_2016SunderlandAfcChelseaFcExpectedValue() {
			return  Arrays.asList(
					new Goal("0 : 1", "14", new Player("Diego Costa"), "right-footed shot"),
					new Goal("1 : 1", "41",new Player( "Wahbi Khazri"), "right-footed shot"),
					new Goal("1 : 2", "45", new Player("Nemanja Matić"), "left-footed shot", new Player("Azpilicueta")),
					new Goal("2 : 2", "67", new Player("Fabio Borini"), "right-footed shot", new Player("Patrick van Aanholt")),
					new Goal("3 : 2", "70", new Player("Jermain Defoe"), "right-footed shot"));
		}


		public List<Goal> getgoals2017_2018LiverpoolFcBrightonHoveAlbionExpected() {
				return Arrays.asList(
		        		new Goal("1 : 0", "26", new Player("Mohamed Salah"), "left-footed shot"),
		        		new Goal("2 : 0", "40",new Player( "Dejan Lovren"), "header",new Player( "Andrew Robertson")),
		        		new Goal("3 : 0", "53",new Player( "Dominic Solanke"), "right-footed shot", new Player("Mohamed Salah")),
		        		new Goal("4 : 0", "85",new Player( "Andrew Robertson"), "left-footed shot")); 
			
		}

}



