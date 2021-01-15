package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Referee {

    public String name;
    public String nation;
    public KindOfReferee kind;
   
    // use this constructor in record referee for player
    public Referee(String name , String nation) {
    	this.name = name;
    	this.nation = nation;
    	this.kind = KindOfReferee.unknown;
    	
    }

}
