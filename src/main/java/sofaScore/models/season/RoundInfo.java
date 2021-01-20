package sofaScore.models.season;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoundInfo {

	public String roundName;
	public String roundSlug;
	public int id;
	public long createdAtTimestamp;
}
