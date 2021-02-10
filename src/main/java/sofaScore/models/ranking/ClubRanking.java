package sofaScore.models.ranking;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ClubRanking implements Comparable <ClubRanking> {

	public Integer position;
	public String clubName;
	public Integer playedGames;
	public Integer winGames;
	public Integer drawGames;
	public Integer lostGames;
	public Integer hisGoals;
	public Integer againstGoals;
	public Integer points;
	
	public ClubRanking(String clubName) {
		this.clubName =clubName;
		this.playedGames=0;
		this.points=0;
		this.winGames=0;
		this.drawGames=0;
		this.lostGames=0;
		this.hisGoals=0;
		this.againstGoals=0;
	}
	
	//in other league there are other rules!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!like laliga
	@Override
	public int compareTo(ClubRanking objecToCompare) {
		if(this.points == objecToCompare.points){
			if((this.hisGoals-this.againstGoals) == (objecToCompare.hisGoals-objecToCompare.againstGoals)) {
				return  objecToCompare.hisGoals-this.hisGoals;
			}
			else {
				return   (objecToCompare.hisGoals-objecToCompare.againstGoals)-(this.hisGoals-this.againstGoals);
			}
		}
		else{
			return  objecToCompare.points - this.points ;
		}		
	}
}
