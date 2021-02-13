package sofaScore.models.basicModels;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
//now i do not use it but i can be a part IncidentInGamePlayer
public class Player {

	public String name;
	public String slug;
	public String shortName;
	public String position;
	
}
