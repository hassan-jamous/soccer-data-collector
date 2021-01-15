package worldfootball.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor

public class ClubTransferTable {

    public Club clubBasicInfo;
    public String season;
    public ArrayList<TransferPlayerInformation> intable;
    public ArrayList<TransferPlayerInformation> outtable;
 
}
