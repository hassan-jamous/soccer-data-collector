package models;

import java.util.ArrayList;

public class PlayerAllInformation {
	public PlayerPersonalInformation personalInfo ;
	public ArrayList <PlayerTeamManaged> teamsManaged;
	public ArrayList <PlayerClubCareer> clubsCareer;
	public ArrayList <PlayerCompetitionInformation> clubMatches;
	public ArrayList <PlayerCompetitionInformation> internationalCopmetitionsInfo;
	public ArrayList <PlayerCompetitionInformationOverall> clubsMatchesOverall;
	public ArrayList <PlayerCompetitionInformationOverall> internationalCopmetitionsOverall;
	public ArrayList<PlayerRefereeRecordInformation> recordReferee;
	public ArrayList<PlayerOpponentRecordInformation> recordOpponent;

	 
	public PlayerAllInformation() {
		clubsCareer = new ArrayList<>();
		clubMatches = new ArrayList <>();
		personalInfo = new PlayerPersonalInformation();
		teamsManaged = new ArrayList <>();
		internationalCopmetitionsInfo = new ArrayList <>(); 
		clubsMatchesOverall = new ArrayList <>();
		internationalCopmetitionsOverall = new ArrayList <>();
		recordReferee = new ArrayList<>();
		recordOpponent = new ArrayList<>();

	}
	public String toString() {
		String result="";
		result = personalInfo.toString();
		result = result + "TEAMS MANAGED" + "\n";
		for(int i =0; i<teamsManaged.size() ;i++) {
				result = result + teamsManaged.get(i).toString() + "\n";
		}
		result = result + "CLUBS CAREER" + "\n";
		for(int i =0; i<clubsCareer.size() ;i++) {
				result = result + clubsCareer.get(i).toString() + "\n";
		}
		result = result + "CLUB MATCHES" + "\n";
		for(int i =0; i<clubMatches.size() ;i++) {
				result = result + clubMatches.get(i).toString() + "\n";
		}
		result = result + "INTERNATIONAL" + "\n";
		for(int i =0; i<internationalCopmetitionsInfo.size() ;i++) {
				result = result + internationalCopmetitionsInfo.get(i).toString() + "\n";
		}
		result = result + "OVERALL CLUBS INFO" + "\n";
		for(int i =0; i<clubsMatchesOverall.size() ;i++) {
			result = result + clubsMatchesOverall.get(i).toString() + "\n";
		}
		result = result + "OVERALL International " + "\n";
		for(int i =0; i<internationalCopmetitionsOverall.size() ;i++) {
			result = result + internationalCopmetitionsOverall.get(i).toString() + "\n";
		}
		result = result + "record Referee" + "\n";
		for(int i =0; i<recordReferee.size() ;i++) {
			result = result + recordReferee.get(i).toString() + "\n";
		}
		result = result + "OVERALL CLUBS INFO" + "\n";
		for(int i =0; i<recordOpponent.size() ;i++) {
			result = result + recordOpponent.get(i).toString() + "\n";
		}
		return result;
	}
}
