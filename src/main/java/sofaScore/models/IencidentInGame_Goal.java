package sofaScore.models;

public class IencidentInGame_Goal implements Iencident{
	public String addedTime;
	public IencidentInGame_Player assist1;
	public String awayScore;
	public String homeScore;
	public String id;
	public String incidentClass;
	public String incidentType;
	public String isHome;//boolean is better????????
	public IencidentInGame_Player player;//any other place we will use class player
	public String time;
	
	public IencidentInGame_Goal() {
		player = new IencidentInGame_Player();
	}
	public IencidentInGame_Goal(String homeScore , String awayScore , IencidentInGame_Player player, IencidentInGame_Player assist1 ,
			String id , String time , String addedTime , String isHome , String incidentClass , String incidentType) {
		this();
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.player = player;
		this.assist1 = assist1;
		this.id = id;
		this.time = time;
		this.addedTime = addedTime;
		this.isHome = isHome;
		this.incidentClass = incidentClass;
		this.incidentType = incidentType;
	}

	public String toString() {
		String result ="";
		result= "(" + homeScore + "  :  " + awayScore +") by   " + player.name + "   asissted by  " + assist1.name;
		return result;
	}
	
	

}
