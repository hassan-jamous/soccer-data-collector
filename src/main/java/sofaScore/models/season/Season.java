package sofaScore.models.season;

import java.util.ArrayList;

import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor

//use to know number of round in season and the current round
public class Season {

	public ArrayList<RoundInfo> rounds;
}
