package worldfootball.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString

//is it better to convert (class)String to (class)Player some (old) players are managers now (tony adams arsenal2002)
//remember in club squad when u want to build class manager
public class ClubInMatchDetails {
    public Club clubBasicInfo;
    public String manager;
    public ArrayList<PlayerAtMatch> players;
}
