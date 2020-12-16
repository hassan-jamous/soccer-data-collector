package models;

import java.util.ArrayList;
import java.util.List;

public class Round {
    public String roundNumberAsString;
    public int roundNumberAsInt;
    public List<Game> games;

    public Round() {
        roundNumberAsString = "";
        games = new ArrayList<>();
    }
    
    public void setRoundNumber(String numberAsString) {
    	roundNumberAsString = numberAsString;
		String actualNumber = numberAsString.substring(0 ,numberAsString.indexOf('.') );
    	roundNumberAsInt = Integer.parseInt(actualNumber);
    }
    public int getRoundNumber(String round) {
		String numberAsString = round.substring(0 , round.indexOf(".")-1);
		int number = Integer.valueOf(numberAsString);
    	return number;
    }
    public String getRoundNumber() {
    	return roundNumberAsString;
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


