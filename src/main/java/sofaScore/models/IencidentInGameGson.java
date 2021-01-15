package sofaScore.models;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public  class IencidentInGameGson {
	public String confirmed; //or boolean
	public String text;
	public String homeScore;// or int
	public String awayScore;//or int
	public String isLive;//or boolean
	public String time;//or int
	public String addedTime;//or int
	public String incidentType;//or enum
	public String length;//or int
	public IencidentInGamePlayer playerIn;
	public IencidentInGamePlayer playerOut;
	public String injury;//or boolean
	public String isHome;//or boolean
	public String incidentClass;//or enum
	public IencidentInGamePlayer player;
	public IencidentInGamePlayer assist1;
	public String id;//or int 
	public String reason;
	public String playerName;
	public String firstName;
	public String lastName;
	
}
