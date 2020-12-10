package models;

import java.util.ArrayList;
import java.util.List;

public class Round {
    public String RoundNumber;
    public List<Game> games;

    public Round() {
        RoundNumber = "";
        games = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }
}


