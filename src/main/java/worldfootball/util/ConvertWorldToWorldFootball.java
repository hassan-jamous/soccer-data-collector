package worldfootball.util;

public class ConvertWorldToWorldFootball {

	public String convertWorldToUseInURL(String world) {
		
		if(world.equals("Premier League")) {return "eng-premier-league";}
		if(world.equals("Championship")) {return "eng-championship";}
		else {
			return world.replaceAll("&", "").replaceAll("/", "-").replaceAll("\\s", "-").toLowerCase();
		}
	}

	public String convertWorldToPrint(String world) {
		
		if(world.equals("eng-premier-league")) {return "Premier League";}
		if(world.equals("eng-championship")) {return "Championship";}
		if(world.equals("brighton-hove-albion")) {return "Brighton & Hove Albion";}
		else {
			return world.replaceAll("-", "\\s").toLowerCase();
		}
	}
	
}
