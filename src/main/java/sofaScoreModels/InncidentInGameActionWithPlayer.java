package sofaScoreModels;

public class InncidentInGameActionWithPlayer implements GameIencidents {
	public String addedTime ;
	public String id;
	public String incidentClass;//or enum
	public String incidentType;//or enum
	public String isHome ;
	public IencidentInGamePlayer player;
	public String playerName;
	public String reason;//or enum
	public String time;

	
	public InncidentInGameActionWithPlayer() {
		new IencidentInGamePlayer ();
	}
	public String toString() {
		String result = "";
		result=(reason == null || reason.equals(""))? ""  :"(" +reason + ")  " +player.name + "  at " + time  + "    "+incidentClass +"  " + incidentType;
		return result;
	}

}
