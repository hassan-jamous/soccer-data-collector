package sofaScore.models.gameBasicInformation;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeamInGame  {
	public String name;
	public String slug;
	public String shortName;
	public String gender;// want to see all type to convert to enum
	public int userCount;
	public String nameCode;
	public boolean national;
	public int type;
	public int id;
	public Country country;
	public ArrayList<PlayerInGame> subTeams;
	public TeamColorInGame teamColor;

}
