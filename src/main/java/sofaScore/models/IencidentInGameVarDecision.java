package sofaScore.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IencidentInGameVarDecision implements Iencident {

    public String confirmed;
    public IencidentInGamePlayer player;
    public String isHome;
    public String id;
    public String time;
    public String incidentClass;
    public String incidentType;
}
