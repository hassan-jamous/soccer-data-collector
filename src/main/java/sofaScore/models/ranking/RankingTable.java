package sofaScore.models.ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public class RankingTable {

	public String competitionName;
	public String competitionYears;
	public List<ClubRanking> table;
	
	public RankingTable(String competitionName, String competitionYears) {
		this.competitionName = competitionName;
		this.competitionYears= competitionYears;
		this.table = new ArrayList<>(Arrays.asList());
	}
	
	public void getClubsRanking() {
		Collections.sort(this.table);
		for(int i =0; i < this.table.size(); i++) {
			this.table.get(i).position=i+1;
		}
	}
}
