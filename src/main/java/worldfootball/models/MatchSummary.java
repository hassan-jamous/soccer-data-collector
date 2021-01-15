package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MatchSummary {
    public Club firstClubInfo;
    public Club secondClubInfo;
    public String resultSummary;
    public String date;
    public String time;

}
