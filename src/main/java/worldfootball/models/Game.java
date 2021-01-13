package worldfootball.models;

public class Game {
    public Club firstTeamBasicInfo;
    public Club secondTeamBasicInfo;
    public String finalResult;
    public String resultOfFirstHalf;
    public String date;
    public String time;


    public Game() {
        firstTeamBasicInfo = new Club();
        secondTeamBasicInfo = new Club();
    }


    public Game(String date, String time, String firstTeam, String secondTeam, String result) {
        this();
        this.date = date;
        this.time = time;
        this.firstTeamBasicInfo.name = firstTeam;
        this.secondTeamBasicInfo.name = secondTeam;
        if (result.contains("(")) {
            finalResult = result.substring(0, result.indexOf("(") - 1);
            resultOfFirstHalf = result.substring(result.indexOf("(") + 1, result.indexOf(")"));
        } else {
            finalResult = result;
            resultOfFirstHalf = null;
        }
    }

    public String toString() {
        String game = "";

        game = date + "   " + ((time != null) ? time : "") + "  " + firstTeamBasicInfo.name + "  vs  " + secondTeamBasicInfo.name + "  " + finalResult +

                ((resultOfFirstHalf != null) ? "(" + resultOfFirstHalf + ")" : "");
        return game;
    }
}
