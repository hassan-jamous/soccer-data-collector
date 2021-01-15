package sofaScore.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
//to ask why lombok can not build an object (some times)
public class IencidentInGameChangePlayers implements Iencident{
	public IencidentInGamePlayer playerIn;
	public IencidentInGamePlayer playerOut;
	public String injury;//or boolean
	public String id;//or int 
	public String time;//or int
	public String addedTime;//or int
	public String isHome;//or boolean
	public String incidentClass;//or enum
	public String incidentType;//or enum
	
}
