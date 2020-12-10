package models;

import java.util.ArrayList;
import java.util.List;

public class TableOfLeague {
    String years;
    List<Round> rounds;

    public TableOfLeague(String years) {
        this.years = years;
        rounds = new ArrayList<>();
    }

    public int getRound(String roundName) {
        for (Round round : rounds) {
            if (round.RoundNumber.equals(roundName)) {
                return rounds.indexOf(round);
            }
        }
        throw new RuntimeException("Round Not Found");
    }

    public void addRound(Round round) {
        rounds.add(rounds.size(), round);
    }

}
