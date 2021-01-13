package worldfootball.models;

import java.util.ArrayList;
import java.util.List;

public class GamesTableOfLeague {
    public String years;
    public List<Round> rounds;

    public GamesTableOfLeague() {        
        rounds = new ArrayList<>();
    }
    public GamesTableOfLeague(String years) {
    	this();
    	this.years = years;
        
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
