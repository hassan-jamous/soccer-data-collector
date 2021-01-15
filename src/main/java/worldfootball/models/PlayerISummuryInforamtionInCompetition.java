package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerISummuryInforamtionInCompetition {

    public Player playerInfo;
    public Club clubInfo;
    public String born;
    public String height;
    public String position;//or enum

}
