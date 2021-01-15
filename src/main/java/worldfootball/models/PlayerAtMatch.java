package worldfootball.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PlayerAtMatch {

    public String playerNumberAsString;
    public Player playerBasicInfo;
    public PlayerTypeAtMatch playerType;
    public ArrayList<PlayerEventAtMatch> events;

}
