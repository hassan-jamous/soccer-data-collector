package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerOpponentRecordInformation {

    public Club opponentName;
    public String matchesNumber;
    public String goalsNumber;
    public String startingLineUp;
    public String substitueIn;
    public String substitueOut;
    public String yellowCards;
    public String secondYellowCards;
    public String redCards;

}
