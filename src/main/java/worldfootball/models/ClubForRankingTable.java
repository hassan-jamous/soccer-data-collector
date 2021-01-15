package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ClubForRankingTable {
    public String position;
    public Club clubBasicInfo;
    public String playedGames;
    public String winGames;
    public String drawGames;
    public String lostGames;
    public String goals;
    public String diffirentGoals;
    public String points;
}
	
