package collector.testData;

import java.util.Arrays;
import java.util.List;


import models.Game;

public class WorldFootballGamesInTableOfLeagueValues {

    public List<Game> getGamesInRoundInSeason(String competitionYears, int round) {
        if (competitionYears.equals("2015-2016") && (round == 4)) {
            return Arrays.asList(
                    new Game("29/08/2015", "12:45", "Newcastle United", "Arsenal FC", "0:1 (0:0)"),
                    new Game("29/08/2015", "15:00", "AFC Bournemouth", "Leicester City", "1:1 (1:0)"),
                    new Game("30/08/2015", "13:30", "Southampton FC", "Norwich City", "3:0 (1:0)"));
        } else if (competitionYears.equals("2015-2016") && (round == 9)) {
            return Arrays.asList(new Game("17/10/2015", "12:45", "Tottenham Hotspur", "Liverpool FC", "0:0 (0:0)"),
                    new Game("17/10/2015", "15:00", "Everton FC", "Manchester United", "0:3 (0:2)"),
                    new Game("18/10/2015", "16:00", "Newcastle United", "Norwich City", "6:2 (3:2)"),
                    new Game("19/10/2015", "20:00", "Swansea City", "Stoke City", "0:1 (0:1)"));
        } else if (competitionYears.equals("2015-2016") && (round == 14)) {
            return Arrays.asList(new Game("28/11/2015", "15:00", "Aston Villa", "Watford FC", "2:3 (1:1)"),
                    new Game("28/11/2015", "17:30", "Leicester City", "Manchester United", "1:1 (1:1)"),
                    new Game("29/11/2015", "14:05", "West Ham United", "West Bromwich Albion", "1:1 (1:0)"),
                    new Game("29/11/2015", "16:15", "Liverpool FC", "Swansea City", "1:0 (0:0)"));
        } else if (competitionYears.equals("2015-2016") && (round == 21)) {
            return Arrays.asList(new Game("12/01/2016", "19:45", "AFC Bournemouth", "West Ham United", "1:3 (1:0)"),
                    new Game("12/01/2016", "19:45", "Newcastle United", "Manchester United", "3:3 (1:2)"),
                    new Game("13/01/2016", "20:00", "Tottenham Hotspur", "Leicester City", "0:1 (0:0)"));
        } else if (competitionYears.equals("2015-2016") && (round == 27)) {
            return Arrays.asList(
                    new Game("28/02/2016", "14:05", "Manchester United", "Arsenal FC", "3:2 (2:1)"),
                    new Game("28/02/2016", "14:05", "Tottenham Hotspur", "Swansea City", "2:1 (0:1)"),
                    new Game("20/04/2016", "20:00", "Liverpool FC", "Everton FC", "4:0 (2:0)"));
        } else if (competitionYears.equals("2015-2016") && (round == 35)) {
            return Arrays.asList(
                    new Game("13/04/2016", "20:00", "Crystal Palace", "Everton FC", "0:0 (0:0)"),
                    new Game("23/04/2016", "15:00", "Liverpool FC", "Newcastle United", "2:2 (2:0)"),
                    new Game("10/05/2016", "20:30", "West Ham United", "Manchester United", "3:2 (1:0)"));
        } else if (competitionYears.equals("2005-2006") && (round == 2)) {
            return Arrays.asList(
                    new Game("20/08/2005", "12:45", "Manchester United", "Aston Villa", "1:0 (0:0)"),
                    new Game("20/08/2005", "15:00", "Blackburn Rovers", "Fulham FC", "2:1 (1:0)"),
                    new Game("20/08/2005", "15:15", "Liverpool FC", "Sunderland AFC", "1:0 (1:0)"),
                    new Game("21/08/2005", "13:30", "Bolton Wanderers", "Everton FC", "0:1 (0:0)"));
        } else if (competitionYears.equals("2005-2006") && (round == 12)) {
            return Arrays.asList(
                    new Game("05/11/2005", "15:00", "Blackburn Rovers", "Charlton Athletic", "4:1 (2:1)"),
                    new Game("05/11/2005", "17:15", "Portsmouth FC", "Wigan Athletic", "0:2 (0:0)"),
                    new Game("06/11/2005", "16:00", "Manchester United", "Chelsea FC", "1:0 (1:0)"));
        } else if (competitionYears.equals("2005-2006") && (round == 20)) {
            return Arrays.asList(
                    new Game("31/12/2005", "12:45", "Aston Villa", "Arsenal FC", "0:0 (0:0)"),
                    new Game("31/12/2005", "13:00", "Tottenham Hotspur", "Newcastle United", "2:0 (1:0)"),
                    new Game("31/12/2005", "15:00", "Wigan Athletic", "Blackburn Rovers", "0:3 (0:1)"));
        } else if (competitionYears.equals("2005-2006") && (round == 32)) {
            return Arrays.asList(
                    new Game("01/04/2006", "12:45", "Birmingham City", "Chelsea FC", "0:0 (0:0)"),
                    new Game("01/04/2006", "15:00", "Arsenal FC", "Aston Villa", "5:0 (2:0)"),
                    new Game("02/04/2006", "15:00", "Manchester City", "Middlesbrough FC", "0:1 (0:1)"),
                    new Game("03/04/2006", "20:00", "Blackburn Rovers", "Wigan Athletic", "1:1 (0:0)"));
        } else if (competitionYears.equals("1960-1961") && (round == 1)) {
            return Arrays.asList(
                    new Game("20/08/1960", null, "Aston Villa", "Chelsea FC", "3:2 (0:0)"),
                    new Game("20/08/1960", null, "Manchester United", "Blackburn Rovers", "1:3 (0:1)"),
                    new Game("20/08/1960", null, "Burnley FC", "Arsenal FC", "3:2 (1:1)"),
                    new Game("20/08/1960", null, "Wolverhampton Wanderers", "West Ham United", "4:2 (0:0)"));
        } else if (competitionYears.equals("1960-1961") && (round == 4)) {
            return Arrays.asList(
                    new Game("30/08/1960", null, "Burnley FC", "Manchester City", "1:3 (0:0)"),
                    new Game("30/08/1960", null, "Preston North End", "Arsenal FC", "2:0 (0:0)"),
                    new Game("31/08/1960", null, "Manchester United", "Everton FC", "4:0 (2:0)"),
                    new Game("31/08/1960", null, "Fulham FC", "Newcastle United", "4:3 (0:0)"));
        } else if (competitionYears.equals("1960-1961") && (round == 16)) {
            return Arrays.asList(
                    new Game("04/11/1960", null, "Leicester City", "Preston North End", "5:2 (0:0)"),
                    new Game("05/11/1960", null, "Chelsea FC", "Newcastle United", "4:2 (0:0)"),
                    new Game("05/11/1960", null, "Blackburn Rovers", "Birmingham City", "2:0 (0:0)"),
                    new Game("05/11/1960", null, "Aston Villa", "Burnley FC", "2:0 (0:0)"));
        } else if (competitionYears.equals("1960-1961") && (round == 27)) {
            return Arrays.asList(
                    new Game("21/01/1961", null, "West Ham United", "Chelsea FC", "3:1 (0:0)"),
                    new Game("21/01/1961", null, "Bolton Wanderers", "Blackpool FC", "3:1 (0:0)"),
                    new Game("21/01/1961", null, "Leicester City", "Manchester United", "6:0 (2:0)"),
                    new Game("21/01/1961", null, "Tottenham Hotspur", "Arsenal FC", "4:2 (3:1)"));
        } else if (competitionYears.equals("1960-1961") && (round == 36)) {
            return Arrays.asList(
                    new Game("28/01/1961", null, "Wolverhampton Wanderers", "West Bromwich Albion", "4:2 (0:0)"),
                    new Game("31/03/1961", null, "Burnley FC", "Nottingham Forest", "4:1 (0:0)"),
                    new Game("31/03/1961", null, "Blackpool FC", "Manchester United", "2:0 (1:0)"),
                    new Game("31/03/1961", null, "Fulham FC", "Arsenal FC", "2:2 (0:1)"));
        } else if (competitionYears.equals("1925-1926") && (round == 3)) {
            return Arrays.asList(
                    new Game("05/09/1925", null, "West Bromwich Albion", "Sunderland AFC", "2:5"),
                    new Game("05/09/1925", null, "Newcastle United", "Notts County", "6:3"),
                    new Game("08/09/1925", null, "Huddersfield Town", "Bury FC", "2:1"));
        } else if (competitionYears.equals("1925-1926") && (round == 35)) {
            return Arrays.asList(
                    new Game("13/03/1926", null, "Birmingham FC", "Newcastle United", "1:1"),
                    new Game("13/03/1926", null, "Tottenham Hotspur", "Leicester City", "1:3"),
                    new Game("02/04/1926", null, "Aston Villa", "Arsenal FC", "3:0"));
        } else if (competitionYears.equals("1925-1926") && (round == 36)) {
            return Arrays.asList(
                    new Game("20/03/1926", null, "Leeds United", "Blackburn Rovers", "2:1"),
                    new Game("20/03/1926", null, "Manchester United", "Everton FC", "0:0"),
                    new Game("03/04/1926", null, "Arsenal FC", "Blackburn Rovers", "4:2"),
                    new Game("03/04/1926", null, "Newcastle United", "Cardiff City", "0:1"));
        } else if (competitionYears.equals("1891-1892") && (round == 1)) {
            return Arrays.asList(
                    new Game("05/09/1891", null, "Aston Villa", "Blackburn Rovers", "5:1"),
                    new Game("05/09/1891", null, "Stoke City", "Derby County", "2:1"),
                    new Game("05/09/1891", null, "West Bromwich Albion", "Everton FC", "4:0"));
        } else if (competitionYears.equals("1891-1892") && (round == 6)) {
            return Arrays.asList(
                    new Game("03/10/1891", null, "Darwen", "Stoke City", "9:3"),
                    new Game("10/10/1891", null, "Aston Villa", "Bolton Wanderers", "1:2"),
                    new Game("10/10/1891", null, "Notts County", "West Bromwich Albion", "4:0"),
                    new Game("17/10/1891", null, "West Bromwich Albion", "Sunderland AFC", "2:5"));
        } else if (competitionYears.equals("1891-1892") && (round == 14)) {
            return Arrays.asList(
                    new Game("28/11/1891", null, "Wolverhampton Wanderers", "Blackburn Rovers", "6:1"),
                    new Game("05/12/1891", null, "Aston Villa", "Burnley FC", "6:1"),
                    new Game("05/12/1891", null, "Sunderland AFC", "Notts County", "4:0"),
                    new Game("12/12/1891", null, "Burnley FC", "Blackburn Rovers", "3:0"));
        } else if (competitionYears.equals("1891-1892") && (round == 23)) {
            return Arrays.asList(
                    new Game("26/03/1892", null, "Sunderland AFC", "Aston Villa", "2:1"),
                    new Game("02/04/1892", null, "Wolverhampton Wanderers", "Preston North End", "3:0"),
                    new Game("04/04/1892", null, "West Bromwich Albion", "Darwen", "12:0"));
        } else if (competitionYears.equals("1888-1889") && (round == 2)) {
            return Arrays.asList(
                    new Game("15/09/1888", null, "Aston Villa", "Stoke City", "5:1"),
                    new Game("15/09/1888", null, "Bolton Wanderers", "Burnley FC", "3:4"),
                    new Game("15/09/1888", null, "Derby County", "West Bromwich Albion", "1:2"),
                    new Game("15/09/1888", null, "Everton FC", "Notts County", "2:1"),
                    new Game("15/09/1888", null, "Wolverhampton Wanderers", "Preston North End", "0:4"),
                    new Game("15/09/1888", null, "Blackburn Rovers", "Accrington FC", "5:5"));
        }
        throw new RuntimeException("Method getGamesInRound in Class WorldFootballGamesInTableOfLeague " + round);
    }

}
