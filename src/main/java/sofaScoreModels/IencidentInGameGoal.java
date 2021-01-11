package sofaScoreModels;

public class IencidentInGameGoal implements GameIencidents{
	public IencidentInGamePlayer assist1;
	public String awayScore;
	public String homeScore;
	public String id;
	public String incidentClass;
	public String incidentType;
	public String isHome;//boolean is better????????
	public IencidentInGamePlayer player;//any other place we will use class player
	public String time;
	
	public IencidentInGameGoal() {
		player = new IencidentInGamePlayer();
	}
	
	public String toString() {
		String result ="";
		result= "(" + homeScore + "  :  " + awayScore +") by   " + player.name + "   asissted by  " + assist1.name;
		return result;
	}
	
	

}
