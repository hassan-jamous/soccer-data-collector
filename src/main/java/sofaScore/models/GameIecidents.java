package sofaScore.models;

import java.util.ArrayList;

public class GameIecidents {

	public ArrayList<Iencident> iecidents;
	
	public GameIecidents() {
		iecidents = new ArrayList<>();
	}
	public String toString() {
		String result = "";
		if(iecidents == null) {return null;}
		if(iecidents.isEmpty()) {return "Emtpy";}
		for(int i = 0 ; i < iecidents.size() ; i++) {
			result += iecidents.get(i) + "\n";
		}
		return result;
		
	}
}
