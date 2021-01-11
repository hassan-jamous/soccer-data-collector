package collector.testData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Goal;

public class WorldFootballGoalsValues {
    public List<Goal> goals1946_1947LeedsUnitedSunderlandAfcExpected() {
        return Arrays.asList(
                new Goal("1 : 0", "90", "Davy Cochrane"),
                new Goal("1 : 1", "90", "Jackie Robinson"));
    }

    public List<Goal> goals1956_1957TottenhamHotspurLeedsUnitedExpectedVlaue() {
        return Arrays.asList(
                new Goal("1 : 0", "0", "Bobby Smith"),
                new Goal("2 : 0", "0", "George Robb"),
                new Goal("3 : 0", "0", "Terry Medwin"),
                new Goal("4 : 0", "0", "John Brooks"),
                new Goal("5 : 0", "0", "Danny Blanchflower"),
                new Goal("5 : 1", "0", "Keith Ripley"));
    }

    public List<Goal> goals1956_1957SheffieldWednesdayChelseaFcExpectedValue() {
        return Arrays.asList(
                new Goal("1 : 0", "0", "Roy Shiner"),
                new Goal("2 : 0", "0", "Roy Shiner"),
                new Goal("3 : 0", "0", "Albert Quixall"),
                new Goal("4 : 0", "0", "Albert Quixall"));
    }

    public List<Goal> goals1963_1964SheffieldUnitedBurnleyFcExpected() {
        return Arrays.asList(
                new Goal("1 : 0", "90", "Tony Wagstaff"),
                new Goal("2 : 0", "90", "Mick Jones"));
    }

    public List<Goal> goals1976_1977LeedsUnitedCoventryCityExpected() {
        return Arrays.asList(
                new Goal("0 : 1", "45", "Alan Green"),
                new Goal("1 : 1", "45", "Joe Jordan"),
                new Goal("1 : 2", "90", "Donal Murphy"));
    }

    public List<Goal> goals1983_1984TottenhamHotspurManchesterUnitedExpected() {
        return Arrays.asList(
                new Goal("1 : 0", "90", "Steve Archibald"),
                new Goal("1 : 1", "90", "Norman Whiteside"));
    }

    public List<Goal> goals1992_1993ChelseaFcSheffieldUnitedExpected() {
        return Arrays.asList(
                new Goal("0 : 1", "40", "Adrian Littlejohn"),
                new Goal("1 : 1", "41", "Andy Townsend"),
                new Goal("1 : 2", "57", "Brian Deane"));
    }

    public List<Goal> goals1996_1997ManchesterUnitedWestHamUnitedExpected() {
        return Arrays.asList(
                new Goal("1 : 0", "11", "Ole Gunnar Solskjær"),
                new Goal("2 : 0", "84", "Jordi Cruyff"));
    }

    public ArrayList<Goal> goals2000_2001LeedsUnitedEvertonFcExpectedValue() {
        return new ArrayList<>(Arrays.asList(
                new Goal("1 : 0", "16", "Alan Smith"),
                new Goal("2 : 0", "37", "Alan Smith")
        ));
    }

    public List<Goal> getgoals1998_1999ArsenalFcAstonVillaExpected() {
        return Arrays.asList(
                new Goal("1 : 0", "66", "Nwankwo Kanu"));
    }

    public List<Goal> getGamesGoalsValue(String gameInfo) {
        if (gameInfo.equals("goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue")) {
            return Arrays.asList(
                    new Goal("1 : 0", "26", "Mohamed Salah", "left-footed shot"),
                    new Goal("2 : 0", "40", "Dejan Lovren", "header", "Andrew Robertson"),
                    new Goal("3 : 0", "53", "Dominic Solanke", "right-footed shot", "Mohamed Salah"),
                    new Goal("4 : 0", "85", "Andrew Robertson", "left-footed shot"));
        }
        if (gameInfo.equals("goals2015_2016ArsenalFcAstonVillaExpectedValue")) {
            return Arrays.asList(
                    new Goal("1 : 0", "5", "Olivier Giroud", "header", "Nacho Monreal"),
                    new Goal("2 : 0", "78", "Olivier Giroud", "left-footed shot", "Mesut Özil"),
                    new Goal("3 : 0", "80", "Olivier Giroud", "left-footed shot", "Héctor Bellerín"),
                    new Goal("4 : 0", "90", "Mark Bunn", "own goal"));

        }
        if (gameInfo.equals("goals2015_2016SunderlandAfcChelseaFcExpectedValue")) {
            return Arrays.asList(
                    new Goal("0 : 1", "14", "Diego Costa", "right-footed shot"),
                    new Goal("1 : 1", "41", "Wahbi Khazri", "right-footed shot"),
                    new Goal("1 : 2", "45", "Nemanja Matić", "left-footed shot", "Azpilicueta"),
                    new Goal("2 : 2", "67", "Fabio Borini", "right-footed shot", "Patrick van Aanholt"),
                    new Goal("3 : 2", "70", "Jermain Defoe", "right-footed shot"));

        }
        throw new RuntimeException("Method getGamesGoalsValue  In Class WorldFootballGoalsValues    " + gameInfo);
    }


}
