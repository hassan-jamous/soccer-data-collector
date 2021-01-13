package worldfootball.models;

public class PlayerTeamManaged {
	public String date;
	public Club clubBasicInfo ;
	public String clubNation;
	public String position;//manager or assestant manager
	
	public PlayerTeamManaged() {
		clubBasicInfo = new Club();
	}
	public PlayerTeamManaged(String date , String clubName , String clubNation , String position) {
		this();
		this.date = date;
		this.clubBasicInfo.name = clubName;
		this.clubNation = clubNation;
		this.position = position;
	}
	public String toString() {
		String result ="";
		result = date + "    " + clubBasicInfo.name + "   "+ clubNation    + "  AS  " + position; 
		return result;
	}
}
