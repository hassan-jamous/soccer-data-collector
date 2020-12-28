package models;

public class MatchSummary {
	public Club firstClubInfo;
	public Club secondClubInfo;
	public String date;
	public String time;
	public String resultSummary;
	
	public MatchSummary() {
		firstClubInfo = new Club();
		secondClubInfo = new Club();
	}
	
	public MatchSummary(String firstClub , String  secondClub ,String resultSummary,String date , String time ) {
		this.firstClubInfo = new Club();
		this.secondClubInfo = new Club();
		this.firstClubInfo.name = firstClub;
		this.secondClubInfo.name = secondClub;
		this.date = date;
		this.time = time;
		this.resultSummary = resultSummary;
	}
	public String toString() {
		String result ="";
		result =firstClubInfo.name + "  vs  " + secondClubInfo.name +  "  (" + resultSummary  + ")" + " AT " + date + "  ON " + time;
		return result;
	} 
	
	
}
