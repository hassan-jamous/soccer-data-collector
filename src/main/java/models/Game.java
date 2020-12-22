package models;

public class Game {
    public String firstTeam;
    public String secondTeam;
    public String finalResult;
    public String resultOfFirstHalf;
    public String date;
    public String time;// new leagues use it so do we want it???
    
    public Game() {}

    public Game(String date, String time, String firstTeam, String secondTeam, String result) {
        this.date = date;
        this.time = time;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        if (result.contains("(")) {
            finalResult = result.substring(0, result.indexOf("(") - 1);
            resultOfFirstHalf = result.substring(result.indexOf("(") + 1, result.indexOf(")"));
        } else {
            finalResult = result;
            resultOfFirstHalf = "#";
        }
    }

    public String toString() {
        String game = "";
        game = date + "   " + ((time != null) ?  time : "") + "  " + firstTeam + "  vs  " + secondTeam + "  " + finalResult + 
        ((resultOfFirstHalf != null) ? "(" + resultOfFirstHalf +")": "");
        return game;
    }
}
