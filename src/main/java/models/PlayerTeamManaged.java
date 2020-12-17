package models;

public class PlayerTeamManaged {
	public String date;
	public String clubName ;
	public String clubNation;
	public String position;//manager or assestant manager
	
	public String toString() {
		String result ="";
		result = date + "    " + clubName + "   clubNation  " + "  AS  " + position; 
		return result;
	}
}
