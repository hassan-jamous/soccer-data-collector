package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerTopSoccerAtSeason {

    public String playerRanking;
    public Player playerBasicInfo;
    public String playerNation;
    public Club playerClub;
    public String goals;
    public String penalty;

}
