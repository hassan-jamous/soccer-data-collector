package models;

import java.util.ArrayList;

public class MatchDetails {

	public ClubInMatchDetails firstClub;
	public ClubInMatchDetails secondClub;
	public String staduim;
	public String attendance;
	public ArrayList <GoalInMatchDetails> goals;
	public ArrayList <Referee> referees;
	public MatchSummary matchSummary;

	public MatchDetails() {
		
		matchSummary = new MatchSummary();
		firstClub = new ClubInMatchDetails();
		secondClub = new ClubInMatchDetails();
		goals = new ArrayList<>();
		referees = new ArrayList<>();
	}
	
	public MatchDetails(ClubInMatchDetails firstClub ,ClubInMatchDetails secondClub ,  MatchSummary matchSummary , 
			String staduim , String attendance, ArrayList <Referee> referees , ArrayList <GoalInMatchDetails> goals) {
		this();
		this.matchSummary= matchSummary;
		this.firstClub = firstClub;		
		this.secondClub = secondClub;
		this.goals = goals;
		this.staduim = staduim;
		this.attendance =  attendance;
		this.referees = referees;
	}
	
	public String toString() {
		String result ="";
		result = firstClub.clubBasicInfo.name + "  vs  " + secondClub.clubBasicInfo.name +"\n" +
		(this.matchSummary.date == null ? "NO DATE" : this.matchSummary.date) + "  " + (this.matchSummary.time == null ? "NO TIME" : this.matchSummary.time) + "\n" +
		"IN  " + staduim + "\n" 
		+"Result Summary is " + this.matchSummary.resultSummary + "\n";
		result = result + goals;
		result = result +  "First Team" + "\n";
		for(int ifirst = 0 ; ifirst < firstClub.players.size() ; ifirst++) {
			result = result + firstClub.players.get(ifirst).toString()+"\n";
		}
		result = result +  "Second Team" + "\n";
		for(int isecond = 0 ; isecond < secondClub.players.size() ; isecond++) {
			result = result  + secondClub.players.get(isecond).toString()+"\n";
		} 
		result = result + "Attendance is " + attendance + "\n" ;
		result = result + (referees.isEmpty() ? "" : "Referees are" + "\n");
		for(int i =0; i<referees.size() ; i++) {
			result = result + referees.get(i) +"\n";
		}
		return result;
	}
}
