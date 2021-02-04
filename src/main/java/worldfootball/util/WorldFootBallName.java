package worldfootball.util;

public class WorldFootBallName {

	public String normalName;//use to print
	public String worldFootballName;//use in site
	
	public WorldFootBallName() {}
	
	public WorldFootBallName(String normalName) {
		this.normalName= normalName;
		if(normalName.equals("Premier League")) {worldFootballName= "eng-premier-league";}
		else {
			worldFootballName= normalName.replaceAll("&", "").replaceAll("/", "-").replaceAll("\\s", "-").toLowerCase();
		}
	}
}
