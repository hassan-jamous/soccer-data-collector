package sofaScore.models.gameBasicInformation;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class SeasonInGame {
	public String name ;
	public String year;
	public int id;
	
	public String  headerToCSV() {
		return  "Season ,";
	}
	public String  valuesToCSV() {
		return  year + ",";
	}
}
