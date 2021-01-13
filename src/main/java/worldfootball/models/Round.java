package worldfootball.models;

import java.util.ArrayList;

public class Round {
    public String roundNumberAsString;
    public ArrayList<Game> games;

    public Round() {
        games = new ArrayList<>();
    }

    public String toString() {
        String round = "";
        round = round + roundNumberAsString + "\n";
        for (int i = 0; i < games.size(); i++) {
            round = round + games.get(i).toString() + "\n";
        }
        return round;
    }
}


