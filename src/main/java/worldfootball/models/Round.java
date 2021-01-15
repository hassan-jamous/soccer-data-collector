package worldfootball.models;

import java.util.ArrayList;

import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
//StatisticsCollector use roundNumberAsString as string with value all seasons
public class Round {
    public String roundNumberAsString;
    public ArrayList<Game> games;

    public Round(String roundNumber ) {
    	this();
    	this.roundNumberAsString = roundNumber;
    }
}


