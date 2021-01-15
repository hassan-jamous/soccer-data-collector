package worldfootball.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlayerCompetitionInformationOverall {
    public String competitionYears;
    public Club clubInfo;
    public PlayerCompetitionInformation competitionInfo;

}
