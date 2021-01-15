package worldfootball.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerPersonalInformation {

    public Player playerBasicInfo;
    public String fullName;
    public String born;
    public String birthPlace;
    public ArrayList<String> nationality;//there are many players have more than one nationality https://www.worldfootball.net/player_summary/che-adams/
    public String height;
    public String weight;
    public ArrayList<String> positions;//there are many players have more than one position https://www.worldfootball.net/player_summary/che-adams/
    public String foot;
}
