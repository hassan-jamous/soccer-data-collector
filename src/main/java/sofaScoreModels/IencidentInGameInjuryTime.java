package sofaScoreModels;

public class IencidentInGameInjuryTime implements GameIencidents {
	public String addedTime;
	public String incidentType;
	public String length;//or int
	public String time;//or int
	public IencidentInGameInjuryTime() {}
	public String toString() {
		String result ="";
		result = incidentType + "     " + time + " additional    " + length + "    "+ addedTime ;
		return result;
	}
}
