package sofaScore.models.basicModels;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Player {

	public String name;
	public String slug;
	public String shortName;
	public String position;
}
