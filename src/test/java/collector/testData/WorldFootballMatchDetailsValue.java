package collector.testData;

import java.util.ArrayList;
import java.util.Arrays;

import models.ClubInMatchDetails;
import models.Goal;
import models.GoalInMatchDetails;
import models.KindOfReferee;
import models.MatchDetails;
import models.MatchSummary;
import models.PlayerAtMatch;
import models.PlayerEventAtMatch;
import models.PlayerTypeAtMatch;
import models.Referee;

public class WorldFootballMatchDetailsValue {

    /**
     * https://www.worldfootball.net/report/premier-league-2019-2020-brighton-hove-albion-everton-fc/
     */
    public MatchDetails getGame2019_2020BrightonHoveAlbionEvertonFc() {
        MatchDetails match1ExpectedValue = new MatchDetails();

        match1ExpectedValue.staduim = "Amex Stadium (Brighton / England)";
        match1ExpectedValue.attendance = "30.529";
        match1ExpectedValue.goals = new ArrayList<>(Arrays.asList(
                new GoalInMatchDetails("Brighton & Hove Albion", new Goal("1 : 0", "15", "Pascal Groß", "free kick")),
                new GoalInMatchDetails("Everton FC", new Goal("1 : 1", "20", "Adam Webster", "own goal")),
                new GoalInMatchDetails("Everton FC", new Goal("1 : 2", "74", "Dominic Calvert-Lewin", "left-footed shot", "Mason Holgate")),
                new GoalInMatchDetails("Brighton & Hove Albion", new Goal("2 : 2", "80", "Neal Maupay", "penalty")),
                new GoalInMatchDetails("Brighton & Hove Albion", new Goal("3 : 2", "90", "Lucas Digne", "own goal"))));

        match1ExpectedValue.referees = new ArrayList<>(Arrays.asList(
                new Referee("Andy Madley", "England", KindOfReferee.Referee),
                new Referee("Edward Smart", "England", KindOfReferee.AssistantReferee),
                new Referee("Derek Eaton", "England", KindOfReferee.AssistantReferee)));

        match1ExpectedValue.matchSummary = new MatchSummary("Brighton & Hove Albion", "Everton FC", "3:2", "Saturday, 26. October 2019", "15:00 Clock");

        match1ExpectedValue.firstClub = new ClubInMatchDetails(
                "Brighton & Hove Albion",
                "Graham Potter",
                new ArrayList<PlayerAtMatch>(Arrays.asList(
                        new PlayerAtMatch("1", "Mathew Ryan", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("5", "Lewis Dunk", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("15", "Adam Webster", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("22", "Martín Montoya", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("66", "out")))),
                        new PlayerAtMatch("33", "Dan Burn", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("6", "Dale Stephens", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("33", "Yellow card")))),
                        new PlayerAtMatch("13", "Pascal Groß", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("65", "out")))),
                        new PlayerAtMatch("24", "Davy Pröpper", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("90", "Yellow card")))),
                        new PlayerAtMatch("46", "Steven Alzate", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("7", "Neal Maupay", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("44", "Aaron Connolly", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("80", "out")))),
                        new PlayerAtMatch("21", "Ezequiel Schelotto", PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("66", "in")))),
                        new PlayerAtMatch("11", "Leandro Trossard", PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("65", "in")))),
                        new PlayerAtMatch("17", "Glenn Murray", PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("80", "in")))),
                        new PlayerAtMatch("27", "David Button", PlayerTypeAtMatch.Substitute, null),
                        new PlayerAtMatch("14", "Leon Balogun", PlayerTypeAtMatch.Substitute, null),
                        new PlayerAtMatch("8", "Yves Bissouma", PlayerTypeAtMatch.Substitute, null),
                        new PlayerAtMatch("20", "Solly March", PlayerTypeAtMatch.Substitute, null))));

        match1ExpectedValue.secondClub = new ClubInMatchDetails(
                "Everton FC",
                "Marco Silva",
                new ArrayList<PlayerAtMatch>(Arrays.asList(
                        new PlayerAtMatch("1", "Jordan Pickford", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("2", "Mason Holgate", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("86", "Yellow card")))),
                        new PlayerAtMatch("5", "Michael Keane", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("12", "Lucas Digne", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("19", "Djibril Sidibé", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("21", "André Gomes", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("26", "Tom Davies", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("7", "Richarlison", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch("11", "Theo Walcott", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "out")))),
                        new PlayerAtMatch("17", "Alex Iwobi", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "out")))),
                        new PlayerAtMatch("20", "Bernard", PlayerTypeAtMatch.Essential, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("30", "out")))),
                        new PlayerAtMatch("8", "Fabian Delph", PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "in")))),
                        new PlayerAtMatch("10", "Gylfi Sigurðsson ", PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("30", "in")))),
                        new PlayerAtMatch("9", "Dominic Calvert-Lewin", PlayerTypeAtMatch.Substitute, new ArrayList<PlayerEventAtMatch>(Arrays.asList(new PlayerEventAtMatch("72", "in")))),
                        new PlayerAtMatch("49", "Jonas Lössl", PlayerTypeAtMatch.Substitute, null),
                        new PlayerAtMatch("23", "Séamus Coleman", PlayerTypeAtMatch.Substitute, null),
                        new PlayerAtMatch("18", "Morgan Schneiderlin", PlayerTypeAtMatch.Substitute, null),
                        new PlayerAtMatch("27", "Moise Kean", PlayerTypeAtMatch.Substitute, null))));

        return match1ExpectedValue;
    }

    /**
     * https://www.worldfootball.net/report/premier-league-1946-1947-brentford-fc-middlesbrough-fc/
     */
    public MatchDetails getGame1946_1947BrentfordFcMiddlesbroughFc() {
        MatchDetails match2ExpectedValue = new MatchDetails();
        match2ExpectedValue.staduim = "Griffin Park (London / England)";
        match2ExpectedValue.attendance = "19.020";
        match2ExpectedValue.referees = null;
        match2ExpectedValue.goals = null;
        match2ExpectedValue.matchSummary = new MatchSummary("Brentford FC", "Middlesbrough FC", "0:0", "Saturday, 26. April 1947", null);

        match2ExpectedValue.firstClub = new ClubInMatchDetails(
                "Brentford FC",
                "Jimmy Hogan",
                new ArrayList<PlayerAtMatch>(Arrays.asList(
                        new PlayerAtMatch(null, "Joe Crozier", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Harry Oliver", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Roddie Munro", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "George Smith", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Cyril Toulouse", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Dai Hopkins", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "George Paterson", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Len Townsend", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "George Stewart", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Dickie Girling", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Malky MacDonald", PlayerTypeAtMatch.Essential, null))));

        match2ExpectedValue.secondClub = new ClubInMatchDetails(
                "Middlesbrough FC",
                "David Jack",
                new ArrayList<PlayerAtMatch>(Arrays.asList(
                        new PlayerAtMatch(null, "Paddy Nash", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Bobby Stuart", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Dicky Robinson", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "George Hardwick", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Harry Bell", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Geoff Walker", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Johnny Spuhler", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Jimmy Gordon", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Alec Linwood", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Micky Fenton", PlayerTypeAtMatch.Essential, null),
                        new PlayerAtMatch(null, "Wilf Mannion", PlayerTypeAtMatch.Essential, null))));

        return match2ExpectedValue;

    }

    /**
     * https://www.worldfootball.net/report/premier-league-2020-2021-leeds-united-burnley-fc/
     */
    public MatchDetails getGame2020_2021LeedsUnitdBurnleyFc() {

        MatchDetails match3ExpectedValue = new MatchDetails();
        match3ExpectedValue.goals = new ArrayList<>(Arrays.asList(
                new GoalInMatchDetails("Leeds United", new Goal("1 : 0", "5", "Patrick Bamford", "penalty"))));
        return match3ExpectedValue;

    }

    /**
     * https://www.worldfootball.net/report/premier-league-2020-2021-sheffield-united-everton-fc/
     */

    public MatchDetails getGame2020_2021SheffieldUnitdEvertonFc() {
        MatchDetails match4ExpectedValue = new MatchDetails();
        match4ExpectedValue.goals = new ArrayList<>(Arrays.asList(
                new GoalInMatchDetails("Everton FC", new Goal("0 : 1", "80", "Gylfi Sigurðsson", "right-footed shot", "Abdoulaye Doucouré"))));
        return match4ExpectedValue;

    }
}