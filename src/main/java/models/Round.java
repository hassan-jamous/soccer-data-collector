package models;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private String roundNumber;
    int roundNumberAsInt;
    public List<Game> games;

    public Round() {
        roundNumber = "";
        games = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }
    
    public void setRoundNumber(String numberAsString) {
    	roundNumber = numberAsString;
    	
    	
    }
    public int getRoundNumber(String round) {
    	int number = 0;
    	String numberAsString ="";
    	numberAsString = round.substring(0 , round.indexOf("."));
    	number = Integer.valueOf(numberAsString);
    	return number;
    }
    public String getRoundNumber() {
    	return roundNumber;
    }
    public String toString() {
    	String round = "";
    	round = round + roundNumber +"\n";
    	for(int i =0 ; i<games.size() ;i++) {
    		round = round + games.get(i).toString() +"\n";
    	}
    	return round;
    }
}


