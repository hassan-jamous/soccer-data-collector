package sofaScore.models;

public class IencidentInGame_ChangePlayers implements Iencident{
	public String id;
	public String incidentClass;//or enum
	public String incidentType;//or enum
	public String injury;//or boolean
	public String isHome;//or boolean
	public IencidentInGame_Player playerIn;
	public IencidentInGame_Player playerOut;
	public String addedTime;
	public String time;
	
	public IencidentInGame_ChangePlayers() {
		playerIn = new IencidentInGame_Player();
		playerOut = new IencidentInGame_Player();
	}
	
	public IencidentInGame_ChangePlayers( IencidentInGame_Player playerIn, IencidentInGame_Player playerOut ,
			String injury, String id , String time ,String addedTime , String isHome ,String incidentClass, String incidentType  ) {
		this();
		this.playerIn = playerIn;
		this.playerOut = playerOut;
		this.id = id;
		this.incidentClass = incidentClass;
		this.injury = injury;
		this.time = time;
		this.addedTime = addedTime;
		this.isHome = isHome;
		this.incidentType = incidentType;
		
	}
	public String toString() {
		String result ="";
		result= incidentType + "   player in (" + playerIn.name +")  player out ("+ playerOut.name + ")  at " + time; 
		return result;
	} 


}
