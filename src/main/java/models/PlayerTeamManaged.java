package models;

public class PlayerTeamManaged {
	public String date;
	public String clubName ;
	public String clubNation;
	public String position;//manager or assestant manager
	
	public PlayerTeamManaged() {}
	public PlayerTeamManaged(String date , String clubName , String clubNation , String position) {
		this.date = date;
		this.clubName = clubName;
		this.clubNation = clubNation;
		this.position = position;
	}
	public String toString() {
		String result ="";
		result = date + "    " + clubName + "   "+ clubNation    + "  AS  " + position; 
		return result;
	}
}
