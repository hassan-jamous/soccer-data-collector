package worldfootball.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MatchDetails {

    public String staduim;
    public String attendance;
    public ArrayList<GoalInMatchDetails> goals;
    public ArrayList<Referee> referees;
    public MatchSummary matchSummary;
    public ClubInMatchDetails firstClub;
    public ClubInMatchDetails secondClub;

}
