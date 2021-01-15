
package worldfootball.models;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class Goal {
    public KindOfGoal kind;
    public String result;
    public String minute;
    public Player playerBasicInfo;
    public String information;
    public Player assesterBasicInfo;

    //old goal just takes three parameters , and the minutes take one of three value 0,45,90
    public Goal(String result, String minutes, Player player) {
        this();
        this.result = result;
        this.playerBasicInfo = player;
        this.minute = minutes;
        this.information = null;
        this.assesterBasicInfo = null;
        this.kind = KindOfGoal.OldGoal;

    }
    //new goal but does not have an assister
    public Goal(String result, String minute, Player player, String information) {
        this();
        this.result = result;
        this.minute = minute;
        this.playerBasicInfo = player;
        this.information = information;
        if (information.contains("own goal")) {
            kind = KindOfGoal.Reverse;
        } else {
            kind = KindOfGoal.Individually;
        }
        this.assesterBasicInfo = null;

    }

    public Goal(String result, String minute, Player player, String information, Player assester) {
        this();
        this.result = result;
        this.minute = minute;
        this.playerBasicInfo = player;
        this.information = information;
        this.assesterBasicInfo = assester;
        this.kind = KindOfGoal.HasAssister;
    }
}
