package sofaScoreModels;

public  class IencidentInGameGson {
	public String text;
	public String homeScore;
	public String awayScore;
	public String isLive;//or boolean
	public String time;//or int
	public String addedTime;
	public String incidentType;//or enum
	public String length;//or int
	public IencidentInGamePlayer playerIn;
	public IencidentInGamePlayer playerOut;
	public String injury;//or boolean
	public String isHome;//or boolean
	public String incidentClass;//or enum
	public IencidentInGamePlayer player;
	public IencidentInGamePlayer assist1;
	public String id;
	public String reason;
	
   public IencidentInGameGson() {}

	
}
