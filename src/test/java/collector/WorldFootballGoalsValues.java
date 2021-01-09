package collector;

import java.util.Arrays;
import java.util.List;

import models.Goal;

public class WorldFootballGoalsValues {
	
	public List<Goal> getGamesGoalsValue(String competitionName , String gameInfo){
		if(competitionName.equals("premier-league") && gameInfo.equals("goals2017_2018LiverpoolFcBrightonHoveAlbionExpectedValue")) {
			return Arrays.asList(
	        		new Goal("1 : 0", "26", "Mohamed Salah", "left-footed shot"),
	        		new Goal("2 : 0", "40", "Dejan Lovren", "header", "Andrew Robertson"),
	        		new Goal("3 : 0", "53", "Dominic Solanke", "right-footed shot", "Mohamed Salah"),
	        		new Goal("4 : 0", "85", "Andrew Robertson", "left-footed shot")); 
		}
		
		
		throw new RuntimeException("Method getGamesGoalsValue  In Class WorldFootballGoalsValues    " + gameInfo);
	}

}
