package worldfootball.models;

public class PlayerEventAtMatch {
    public String minute;
    public String event;//enum or stirng??????

    public PlayerEventAtMatch() {
    }

    public PlayerEventAtMatch(String minute, String event) {
        this.event = event;
        this.minute = minute;
    }

    public String toString() {
        String result = "";
        result = event + " at " + minute;
        return result;
    }
}
