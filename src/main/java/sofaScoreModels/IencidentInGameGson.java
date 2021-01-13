package sofaScoreModels;

public  class IencidentInGameGson {
	public String confirmed; 
	public String text;
	public String homeScore;
	public String awayScore;
	public String isLive;//or boolean
	public String time;//or int
	public String addedTime;
	public String incidentType;//or enum
	public String length;//or int
	public IencidentInGame_Player playerIn;
	public IencidentInGame_Player playerOut;
	public String injury;//or boolean
	public String isHome;//or boolean
	public String incidentClass;//or enum
	public IencidentInGame_Player player;
	public IencidentInGame_Player assist1;
	public String id;
	public String reason;
	public String playerName;
	public String firstName;
	public String lastName;
	
   public IencidentInGameGson() {
	  playerIn =new IencidentInGame_Player();
	  playerOut =new IencidentInGame_Player();
	  player =new IencidentInGame_Player();
	  assist1 =new IencidentInGame_Player();

   }
   public String toString() {
	   String result = "";
	   result = "gson    "+incidentType + "      "+((player.name != null)?player.name : "    ")+ "     time" + time;
	   return result;
   }

	
}
