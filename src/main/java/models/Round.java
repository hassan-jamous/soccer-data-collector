package models;

import java.util.ArrayList;
import java.util.List;

public class Round {
    public String roundNumberAsString;
    public List<Game> games;

    public Round() {        
        games = new ArrayList<>();
    }

    public String toString() {
    	String round = "";
    	round = round + roundNumberAsString +"\n";
    	for(int i =0 ; i<games.size() ;i++) {
    		round = round + games.get(i).toString() +"\n";
    	}
    	return round;
    }
}


