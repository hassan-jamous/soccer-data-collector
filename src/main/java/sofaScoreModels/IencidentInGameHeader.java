package sofaScoreModels;

public class IencidentInGameHeader implements GameIencidents{
	
	public String addedTime;
	public String awayScore;
	public String homeScore;
	public String incidentType;
	public String isLive;//or boolean
	public String text;
	public String time;
	public IencidentInGameHeader() {}
	public String toString() {
		String result ="";
		result = text + "( " + homeScore + " : " + awayScore + ")  " + time;
		return result;
	}

}
