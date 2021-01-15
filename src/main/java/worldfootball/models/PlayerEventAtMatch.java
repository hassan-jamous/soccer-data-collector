package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerEventAtMatch {
    public String minute;
    public String event;//enum or stirng want to know all event or handle that by throw RuntimeException??????

}
