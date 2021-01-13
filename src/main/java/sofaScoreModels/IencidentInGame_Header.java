package sofaScoreModels;

public class IencidentInGame_Header implements Iencident{
	
	public String addedTime;
	public String awayScore;
	public String homeScore;
	public String incidentType;
	public String isLive;//or boolean
	public String text;
	public String time;
	public IencidentInGame_Header() {}
	public IencidentInGame_Header(String text , String homeScore , String awayScore , String isLive ,
			String time , String addedTime , String incidentType) {
		this.addedTime = addedTime;
		this.awayScore = awayScore;
		this.homeScore = homeScore;
		this.incidentType = incidentType;
		this.isLive = isLive;
		this.text = text;
		this.time = time;
	}
	public String toString() {
		String result ="";
		result = text + "( " + homeScore + " : " + awayScore + ")  " + time;
		return result;
	}

}
