package sofaScore.models.season;

import java.util.ArrayList;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
//in this url https://api.sofascore.com/api/v1/unique-tournament/34/season/11648/rounds
public class PageOfSeasonRounds {
	
	public CurrentRound currentRound;
	public ArrayList<RoundInPageCurrentRound> rounds;
}
