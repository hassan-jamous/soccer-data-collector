package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransferPlayerInformation {

    public String date;
    public Player playerBasicInfo;
    public String playerNation;
    public String playerPosition;
    public Club fromClub;
    public Club toClub;

}
