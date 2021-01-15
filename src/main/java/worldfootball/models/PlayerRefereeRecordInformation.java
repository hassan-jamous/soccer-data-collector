package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerRefereeRecordInformation {

    public Referee refereeInfo;
    public String matchesNumber;
    public String goalsNumber;
    public String startingLineUp;
    public String substitueIn;
    public String substitueOut;
    public String yellowCards;
    public String secondYellowCards;
    public String redCards;
 
}


