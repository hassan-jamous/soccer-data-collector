package sofaScore.models.gameBasicInformation;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class Stauts {

	public int code;
	public String description;
	public String type;
	
	public String write(String dataType) {
		return (dataType.equals("header"))? "Description , " : description +",";
	}
}
