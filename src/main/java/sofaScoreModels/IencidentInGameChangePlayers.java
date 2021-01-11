package sofaScoreModels;

public class IencidentInGameChangePlayers implements GameIencidents{
	public String id;
	public String incidentClass;//or enum
	public String incidentType;//or enum
	public String injury;//or boolean
	public String isHome;//or boolean
	public IencidentInGamePlayer playerIn;
	public IencidentInGamePlayer playerOut;
	public String time;
	
	public IencidentInGameChangePlayers() {
		playerIn = new IencidentInGamePlayer();
		playerOut = new IencidentInGamePlayer();
	}
	public String toString() {
		String result ="";
		result= incidentType + "   player in (" + playerIn.name +")  player out ("+ playerOut.name + ")  at " + time; 
		return result;
	} 


}
