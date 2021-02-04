package worldfootball.util;

public class ConvertWorldToWorldFootball {

	public String convertWorldToUseInURL(String world) {
		
		if(world.equals("Premier League")) {return "eng-premier-league";}
		if(world.equals("Championship")) {return "eng-championship";}
		else {
			return world.replaceAll("&", "").replaceAll("/", "-").replaceAll("\\s", "-").toLowerCase();
		}
	}
	
	
}
