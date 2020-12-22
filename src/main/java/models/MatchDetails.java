package models;

import java.util.ArrayList;

public class MatchDetails {

	public ClubInMatch firstClub;
	public ClubInMatch secondClub;
	public String resultSummary;
	public String date;
	public String time;
	public String staduim;
	public String attendance;
	public ArrayList <Referee> referees;
	
	public MatchDetails() {
		firstClub = new ClubInMatch();
		secondClub = new ClubInMatch();
		referees = new ArrayList<>();
	}
	
	public MatchDetails(ClubInMatch firstClub ,ClubInMatch secondClub , String resultSummary ,
			String date , String time,  String staduim , String attendance, ArrayList <Referee> referees) {
		
		this.firstClub = firstClub;		
		this.secondClub = secondClub;
		this.resultSummary = resultSummary;
		this.date = date;
		this.time = time;
		this.staduim = staduim;
		this.attendance =  attendance;
		this.referees = referees;
	}
	
	public String toString() {
		String result ="";
		result = firstClub.clubName + "  vs  " + secondClub.clubName +"\n" +
		(date == null ? "NO DATE" : date) + "  " + (time == null ? "NO TIME" : time) + "\n" +
		"IN  " + staduim + "\n" 
		+"Result Summary is " + resultSummary + "\n" 
		+(firstClub.goals==null ? "" : "First Team Goal " + "\n" +firstClub.goals + "\n") 
		+(secondClub.goals== null ? "" : "Second Team Goal " + "\n" +secondClub.goals +"\n");
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
