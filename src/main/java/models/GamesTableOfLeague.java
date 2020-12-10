package models;

import java.util.ArrayList;
import java.util.List;

public class GamesTableOfLeague {
    String years;
    List<Round> rounds;

    public GamesTableOfLeague(String years) {
        this.years = years;
        rounds = new ArrayList<>();
    }

    public int getRoundIndex(String roundName) {
        for (Round round : rounds) {
            if (round.getRoundNumber().equals(roundName)) {
                return rounds.indexOf(round);
            }
        }
        throw new RuntimeException("Round Not Found");
    }

    public void addRound(Round round) {
        rounds.add(rounds.size(), round);
    }
    
    public String toString() {
    	String table = "";
    	table = this.years;
    	table  = table + "\n";
    	for(int i = 0 ; i<rounds.size() ;i++) {
    		table = table + rounds.get(i).toString() + "\n" ; 
    	}
    	return table;
    }

}
