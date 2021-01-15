package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerTopScoreForSeason {
    public String competitionYears;
    public String playerNation;
    public Player playerInfo;
    public Club clubInfo;
    public String goals;

}
