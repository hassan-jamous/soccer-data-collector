package worldfootball.models;


public class GoalInMatchDetails {

    public Club clubInfo;
    public Goal goalsInfo;

    public GoalInMatchDetails() {
        clubInfo = new Club();
        goalsInfo = new Goal();
    }

    public GoalInMatchDetails(String clubName, Goal goalsInfo) {
        this();
        this.clubInfo.name = clubName;
        this.goalsInfo = goalsInfo;
    }

    public String toString() {
        String result = "";

        result += "[" + clubInfo.name + "]  " + goalsInfo + "   ";

        return result;
    }

}
