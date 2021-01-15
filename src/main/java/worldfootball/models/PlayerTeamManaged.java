package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerTeamManaged {
    public String date;
    public Club clubBasicInfo;
    public String clubNation;
    public String position;//manager or assestant manager

}
