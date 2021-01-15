package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString

//use this class in club squad 
//ask hassan
	//name of attribute information
	//do we need other class for manager for managers
public class PlayerSummary {

    public String number;
    public Player playerBasicInfo;
    public String nation;
    public String birthDate;
    public String information;
}
