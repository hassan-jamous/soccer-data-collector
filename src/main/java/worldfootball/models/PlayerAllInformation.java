package worldfootball.models;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;

@ToString
@AllArgsConstructor
@NoArgsConstructor
//to ask hassan data structure
public class PlayerAllInformation {
    public PlayerPersonalInformation personalInfo;
    public ArrayList<PlayerTeamManaged> teamsManaged;
    public ArrayList<PlayerClubCareer> clubsCareer;
    public ArrayList<PlayerCompetitionInformation> clubMatches;
    public ArrayList<PlayerCompetitionInformation> internationalCopmetitionsInfo;
    public ArrayList<PlayerCompetitionInformationOverall> clubsMatchesOverall;
    public ArrayList<PlayerCompetitionInformationOverall> internationalCopmetitionsOverall;
    public ArrayList<PlayerRefereeRecordInformation> recordReferee;
    public ArrayList<PlayerOpponentRecordInformation> recordOpponent;
    //public ArrayList <ArrayList<PlayerCompetitionInformationOverall>> forEachCompetitionInformationOverallsClubs; 
    //public ArrayList <ArrayList<PlayerCompetitionInformationOverall>> forEachCompetitionInformationOverallsInternational;
    public ArrayList<PlayerCompetitionInformationOverall> forEachCompetitionInformationOverallsClubs;
    public ArrayList<PlayerCompetitionInformationOverall> forEachCompetitionInformationOverallsInternational;

}
