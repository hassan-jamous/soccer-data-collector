package sofaScoreModels;

public class InncidentInGame_Card implements Iencident {
	public String addedTime ;
	public String id;
	public String incidentClass;//or enum
	public String incidentType;//or enum
	public String isHome ;
	public IencidentInGame_Player player;
	public String playerName;
	public String reason;//or enum
	public String time;

	
	public InncidentInGame_Card() {
		new IencidentInGame_Player ();
	}
	public InncidentInGame_Card(IencidentInGame_Player player , String playerName , String reason ,String id ,String time , 
			String addedTime ,String isHome ,String incidentClass , String incidentType ) {
		this();
		this.addedTime = addedTime;
		this.player = player;
		this.playerName = playerName;
		this.reason = reason;
		this.id = id;
		this.time = time;
		this.isHome = isHome;
		this.incidentClass = incidentClass;
		this.incidentType = incidentType;
		
	}
	
	public String toString() {
		String result = "";
		result=((reason == null || reason.equals(""))? ""  :"(" +reason + ")  " )+player.name + "  at " + time  + "    "+incidentClass +"  " + incidentType;
		return result;
	}

}
