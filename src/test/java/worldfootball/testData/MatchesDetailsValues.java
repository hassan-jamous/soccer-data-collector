package worldfootball.testData;

import java.util.ArrayList;
import java.util.Arrays;

import worldfootball.models.Club;
import worldfootball.models.ClubInMatchDetails;
import worldfootball.models.Goal;
import worldfootball.models.GoalInMatchDetails;
import worldfootball.models.KindOfReferee;
import worldfootball.models.MatchDetails;
import worldfootball.models.MatchSummary;
import worldfootball.models.Player;
import worldfootball.models.PlayerAtMatch;
import worldfootball.models.PlayerEventAtMatch;
import worldfootball.models.PlayerTypeAtMatch;
import worldfootball.models.Referee;

public class MatchesDetailsValues {

	    //https://www.worldfootball.net/report/premier-league-2019-2020-brighton-hove-albion-everton-fc/
		public MatchDetails getGame2019_2020BrightonHoveAlbionEvertonFc() {
			
			MatchDetails expectedValue = new MatchDetails();

	        expectedValue.staduim ="Amex Stadium (Brighton / England)";
	        expectedValue.attendance ="30.529";
	        expectedValue.goals = new ArrayList<>(Arrays.asList(
	        		new GoalInMatchDetails(new Club ("Brighton & Hove Albion"), new Goal("1 : 0", "15",new Player( "Pascal Groß"), "free kick")),
	        		new GoalInMatchDetails(new Club ("Everton FC"), new Goal("1 : 1", "20", new Player("Adam Webster"), "own goal")),
	        		new GoalInMatchDetails(new Club ("Everton FC"), new Goal("1 : 2", "74", new Player("Dominic Calvert-Lewin"), "left-footed shot", new Player("Mason Holgate"))),
	        		new GoalInMatchDetails(new Club ("Brighton & Hove Albion"), new Goal("2 : 2", "80",new Player( "Neal Maupay"), "penalty")),
	        		new GoalInMatchDetails(new Club ("Brighton & Hove Albion"), new Goal("3 : 2", "90", new Player("Lucas Digne"), "own goal"))));

	        expectedValue.referees = new ArrayList<>(Arrays.asList(
	        		new Referee("Andy Madley", "England", KindOfReferee.Referee),
	        		new Referee("Edward Smart", "England", KindOfReferee.AssistantReferee),
	        		new Referee("Derek Eaton", "England", KindOfReferee.AssistantReferee)));
	        
	        expectedValue.matchSummary = new MatchSummary(new Club("Brighton & Hove Albion"),new Club( "Everton FC"), "3:2", "Saturday, 26. October 2019", "15:00 Clock");
	        
	        expectedValue.firstClub = new ClubInMatchDetails(
	        		new Club("Brighton & Hove Albion"), 
	        		"Graham Potter",
	        		new ArrayList<PlayerAtMatch>(Arrays.asList(
	        				new PlayerAtMatch("1", new Player("Mathew Ryan"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch("5", new Player("Lewis Dunk"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch("15", new Player("Adam Webster"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch("22",new Player( "Martín Montoya"), PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("66", "out")))),
	        				new PlayerAtMatch("33", new Player("Dan Burn"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch("6", new Player("Dale Stephens"), PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("33", "Yellow card")))),
	        				new PlayerAtMatch("13",new Player( "Pascal Groß"), PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("65", "out")))),
	        				new PlayerAtMatch("24",new Player( "Davy Pröpper"), PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("90", "Yellow card")))),
	        				new PlayerAtMatch("46",new Player( "Steven Alzate"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch("7", new Player("Neal Maupay"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch("44",new Player( "Aaron Connolly"), PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("80", "out")))),
	        				new PlayerAtMatch("21", new Player("Ezequiel Schelotto"), PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("66", "in")))),
	           				new PlayerAtMatch("11",new Player( "Leandro Trossard"), PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("65", "in")))),
	        				new PlayerAtMatch("17",new Player( "Glenn Murray"), PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("80", "in")))),
	        				new PlayerAtMatch("27", new Player("David Button"), PlayerTypeAtMatch.Substitute, null),
	        				new PlayerAtMatch("14", new Player("Leon Balogun"), PlayerTypeAtMatch.Substitute, null),
	        				new PlayerAtMatch("8", new Player("Yves Bissouma"), PlayerTypeAtMatch.Substitute, null),
	        				new PlayerAtMatch("20",new Player( "Solly March"), PlayerTypeAtMatch.Substitute, null))));

	        expectedValue.secondClub = new ClubInMatchDetails(
	        									new Club("Everton FC"),
	        									"Marco Silva",
	        									new ArrayList<PlayerAtMatch>(Arrays.asList(
	        											new PlayerAtMatch("1", new Player("Jordan Pickford"), PlayerTypeAtMatch.Essential, null),
	        											new PlayerAtMatch("2", new Player("Mason Holgate"), PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("86", "Yellow card")))),
	        											new PlayerAtMatch("5", new Player("Michael Keane"), PlayerTypeAtMatch.Essential, null),
	        											new PlayerAtMatch("12",new Player( "Lucas Digne"), PlayerTypeAtMatch.Essential, null),
	        											new PlayerAtMatch("19", new Player("Djibril Sidibé"), PlayerTypeAtMatch.Essential, null),
	        											new PlayerAtMatch("21", new Player("André Gomes"), PlayerTypeAtMatch.Essential, null),
	        											new PlayerAtMatch("26",new Player( "Tom Davies"), PlayerTypeAtMatch.Essential, null),
	        											new PlayerAtMatch("7", new Player("Richarlison"), PlayerTypeAtMatch.Essential, null),
	        											new PlayerAtMatch("11",new Player( "Theo Walcott"), PlayerTypeAtMatch.Essential,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "out")))),
	        											new PlayerAtMatch("17",new Player( "Alex Iwobi"), PlayerTypeAtMatch.Essential,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "out")))),
	        											new PlayerAtMatch("20", new Player("Bernard"), PlayerTypeAtMatch.Essential,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("30", "out")))),
	        											new PlayerAtMatch("8", new Player("Fabian Delph"), PlayerTypeAtMatch.Substitute,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "in")))),
	        											new PlayerAtMatch("10",new Player( "Gylfi Sigurðsson"), PlayerTypeAtMatch.Substitute,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("30", "in")))),
	        											new PlayerAtMatch("9", new Player("Dominic Calvert-Lewin"), PlayerTypeAtMatch.Substitute,  new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "in")))),
	        											new PlayerAtMatch("49",new Player( "Jonas Lössl"), PlayerTypeAtMatch.Substitute, null),
	        											new PlayerAtMatch("23",new Player( "Séamus Coleman"), PlayerTypeAtMatch.Substitute, null),
	        											new PlayerAtMatch("18",new Player( "Morgan Schneiderlin"), PlayerTypeAtMatch.Substitute, null),
	        											new PlayerAtMatch("27", new Player("Moise Kean"), PlayerTypeAtMatch.Substitute, null))));
			
		return expectedValue;
		}
		
	    //https://www.worldfootball.net/report/premier-league-1946-1947-brentford-fc-middlesbrough-fc/
		public MatchDetails getGame1946_1947BrentfordFcMiddlesbroughFc() {
			MatchDetails expectedValue = new MatchDetails();
	        expectedValue.staduim ="Griffin Park (London / England)";
	        expectedValue.attendance = "19.020";
	        expectedValue.referees = null;
	        expectedValue.goals = null;
	        expectedValue.matchSummary = new MatchSummary(new Club ("Brentford FC"),new Club ("Middlesbrough FC"), "0:0", "Saturday, 26. April 1947", null);

	        expectedValue.firstClub = new ClubInMatchDetails(
	        		new Club("Brentford FC"), 
	        		"Jimmy Hogan",
					new ArrayList<PlayerAtMatch>(Arrays.asList(
							new PlayerAtMatch(null,new Player( "Joe Crozier"), PlayerTypeAtMatch.Essential, null),
							new PlayerAtMatch(null, new Player("Harry Oliver"), PlayerTypeAtMatch.Essential, null),
							new PlayerAtMatch(null, new Player("Roddie Munro"), PlayerTypeAtMatch.Essential, null),
							new PlayerAtMatch(null, new Player("George Smith"), PlayerTypeAtMatch.Essential, null),
							new PlayerAtMatch(null, new Player("Cyril Toulouse"), PlayerTypeAtMatch.Essential, null),
							new PlayerAtMatch(null, new Player("Dai Hopkins"), PlayerTypeAtMatch.Essential, null),
							new PlayerAtMatch(null, new Player("George Paterson"), PlayerTypeAtMatch.Essential, null),
							new PlayerAtMatch(null, new Player("Len Townsend"), PlayerTypeAtMatch.Essential, null),
							new PlayerAtMatch(null, new Player("George Stewart"), PlayerTypeAtMatch.Essential, null),
							new PlayerAtMatch(null, new Player("Dickie Girling"), PlayerTypeAtMatch.Essential, null),
							new PlayerAtMatch(null, new Player("Malky MacDonald"), PlayerTypeAtMatch.Essential, null))));

	        expectedValue.secondClub = new ClubInMatchDetails(
	        		new Club("Middlesbrough FC"), 
	        		"David Jack",
	        		new ArrayList<PlayerAtMatch>(Arrays.asList(
	        				new PlayerAtMatch(null,new Player( "Paddy Nash"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch(null,new Player( "Bobby Stuart"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch(null, new Player("Dicky Robinson"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch(null,new Player( "George Hardwick"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch(null,new Player( "Harry Bell"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch(null, new Player("Geoff Walker"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch(null,new Player( "Johnny Spuhler"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch(null,new Player( "Jimmy Gordon"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch(null, new Player("Alec Linwood"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch(null, new Player("Micky Fenton"), PlayerTypeAtMatch.Essential, null),
	        				new PlayerAtMatch(null,new Player( "Wilf Mannion"), PlayerTypeAtMatch.Essential, null))));
	        
	        return expectedValue;
			
		}
	    //https://www.worldfootball.net/report/premier-league-2020-2021-leeds-united-burnley-fc/
		public MatchDetails getGame2020_2021LeedsUnitdBurnleyFc() {

			MatchDetails expectedValue =new  MatchDetails();
	        expectedValue.goals= new ArrayList<>(Arrays.asList(
	        		new GoalInMatchDetails(new Club ("Leeds United"), new Goal("1 : 0", "5",new Player( "Patrick Bamford"), "penalty"))));
	        return expectedValue;

		}
	    //https://www.worldfootball.net/report/premier-league-2020-2021-sheffield-united-everton-fc/
		public MatchDetails getGame2020_2021SheffieldUnitdEvertonFc() {
			 MatchDetails expectedValue =new  MatchDetails();
		     expectedValue.goals= new ArrayList<>(Arrays.asList(
		      		new GoalInMatchDetails(new Club ("Everton FC"), new Goal("0 : 1", "80",new Player( "Gylfi Sigurðsson"), "right-footed shot",new Player( "Abdoulaye Doucouré")))));
	        return expectedValue;

		}
		
		//https://www.worldfootball.net/report/premier-league-2020-2021-sheffield-united-newcastle-united/
		public MatchDetails getGame2020_2021SheffieldUnitedNewcastleUnited() {
			 MatchDetails expectedValue =new  MatchDetails();
			 expectedValue.firstClub = new ClubInMatchDetails(
					 new Club("Sheffield United"),
					 "Chris Wilder",
						new ArrayList<PlayerAtMatch>(Arrays.asList(
		        				new PlayerAtMatch("17", new Player("David McGoldrick"), PlayerTypeAtMatch.Essential, 
		        									new ArrayList<>(Arrays.asList(
		        											new PlayerEventAtMatch("90", "Yellow card"),
		        											new PlayerEventAtMatch("90", "out")))),
		        				new PlayerAtMatch("10", new Player("Billy Sharp"), PlayerTypeAtMatch.Substitute, 
		        									new ArrayList<>(Arrays.asList(
		        											new PlayerEventAtMatch("80", "Yellow card"),
		        					        				new PlayerEventAtMatch("59", "in")))))));
			 expectedValue.secondClub = new ClubInMatchDetails(
					 new Club("Newcastle United"),
					 "Steve Bruce",
						new ArrayList<PlayerAtMatch>(Arrays.asList(
		        				new PlayerAtMatch("21", new Player("Ryan Fraser"), PlayerTypeAtMatch.Essential, 
		        									new ArrayList<>(Arrays.asList(
		        											new PlayerEventAtMatch("42", "Yellow card"),
		        											new PlayerEventAtMatch("45", "Second yellow card")))))));
			 
			 
		     return expectedValue;		
			
		}
		//https://www.worldfootball.net/report/premier-league-2020-2021-wolverhampton-wanderers-manchester-united/
		public MatchDetails getGame2020_2021WolverhamptonWanderersManchesterUnited() {
			 MatchDetails expectedValue =new  MatchDetails();
			 expectedValue.firstClub = new ClubInMatchDetails( new Club("Wolverhampton Wanderers"),"Nuno",null);
			 expectedValue.secondClub = new ClubInMatchDetails( new Club("Manchester United"),"Ole Gunnar Solskjær",null);
			 expectedValue.staduim ="Molineux Stadium (Wolverhampton / England)";
			 expectedValue.referees = null;
			 expectedValue.attendance = null;
			 expectedValue.goals= null;
			 expectedValue.matchSummary = new MatchSummary(new Club("Wolverhampton Wanderers"),
					 									   new Club("Manchester United"),
					 									   "-:-",
					 									   "Sunday, 23. May 2021",
					 									   "16:00 Clock");
			 
			 
			 
		     return expectedValue;		
			
		}
}
