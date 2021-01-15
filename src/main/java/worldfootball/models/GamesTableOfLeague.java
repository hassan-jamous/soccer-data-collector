package worldfootball.models;

import java.util.List;

import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@ToString
public class GamesTableOfLeague {
    public String years;
    public List<Round> rounds;

    public GamesTableOfLeague(String years) {
        this();
        this.years = years;
    }
 }
