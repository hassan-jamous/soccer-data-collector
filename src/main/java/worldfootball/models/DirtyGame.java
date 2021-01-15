package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DirtyGame {
    public Game gameNormalInfo;//i.e first team , second team , result , date , .......
    public String redCards;
    public String secondYellowCards;
    public String yellowCards;
    public String dirtyPoints;

}
