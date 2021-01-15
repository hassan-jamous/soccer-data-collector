package worldfootball.models;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class Game {
    public String date;
    public String time;
    public Club firstTeamBasicInfo;
    public Club secondTeamBasicInfo;
    public String finalResult;
    public String resultOfFirstHalf;

    public Game(String date, String time, Club firstTeam, Club secondTeam, String result) {
        this();
        this.date = date;
        this.time = time;
        this.firstTeamBasicInfo = firstTeam;
        this.secondTeamBasicInfo = secondTeam;
        if (result.contains("(")) {
            finalResult = result.substring(0, result.indexOf("(") - 1);
            resultOfFirstHalf = result.substring(result.indexOf("(") + 1, result.indexOf(")"));
        } else {
            finalResult = result;
            resultOfFirstHalf = null;
        }
    }
}
