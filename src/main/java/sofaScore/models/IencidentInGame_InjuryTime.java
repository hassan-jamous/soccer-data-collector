package sofaScore.models;

public class IencidentInGame_InjuryTime implements Iencident {
	public String addedTime;
	public String incidentType;
	public String length;//or int
	public String time;//or int
	
	public IencidentInGame_InjuryTime() {}
	
	public IencidentInGame_InjuryTime(String length ,String time ,String addedTime ,String icidentType) {
		this.addedTime = addedTime;
		this.incidentType = icidentType;
		this.length = length;
		this.time = time;
	}
	
	public String toString() {
		String result ="";
		result = incidentType + "     " + time + " additional    " + length + "    "+ addedTime ;
		return result;
	}
}
